package com.iafenvoy.wetk.tip;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iafenvoy.wetk.WorldEditToolKit;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TipManager {
    public static final TipManager INSTANCE = new TipManager();
    private final List<JsonObject> tips = new ArrayList<>();
    private final HashMap<String, TipProvider> providers = new HashMap<>();

    public void registerProvider(String name, TipProvider provider) {
        providers.put(name, provider);
    }

    public String getTip(String command) {
        if (command.isEmpty()) return "";
        String[] commands = command.split(" ");
        if (providers.containsKey(commands[0])) {
            String ret = providers.get(commands[0]).parse(commands);
            if (ret != null) return ret;
        }
        for (JsonObject tip : tips) {
            try {
                String shortName = MinecraftClient.getInstance().options.language;
                if (!tip.has(shortName)) continue;
                String res = getTipDfs(commands, 0, tip.get(shortName), tip.get(shortName).getAsJsonObject());
                if (res != null) return res;
            } catch (Exception e) {
                WorldEditToolKit.LOGGER.error("Failed to get tips.", e);
            }
        }
        return "";
    }

    private String getTipDfs(String[] commands, int index, JsonElement ele, JsonObject base) {
        // *->any ?->default |->link ~->local link
        if (!ele.isJsonObject()) return ele.getAsString();
        JsonObject obj = ele.getAsJsonObject();
        if (obj.has("|")) {
            String ret = getTipDfs(commands, 1, base.get(obj.get("|").getAsString()), base);
            if (ret != null) return ret;
        }
        if (index == commands.length) return obj.has("?") ? obj.get("?").getAsString() : null;
        String now = commands[index];
        if (obj.has(now)) {
            while (obj.get(now).isJsonObject() && obj.get(now).getAsJsonObject().has("~")) {
                now = obj.get(now).getAsJsonObject().get("~").getAsString();
                if (!obj.has(now)) return null;
            }
            String ret = getTipDfs(commands, index + 1, obj.get(now), base);
            if (ret != null) return ret;
        }
        if (obj.has("*")) {
            String ret = getTipDfs(commands, index + 1, obj.get("*"), base);
            if (ret != null) return ret;
        }
        if (obj.has("?")) return obj.get("?").getAsString();
        return null;
    }

    public void addTips(JsonObject object) {
        if (object != null)
            this.tips.add(object);
    }
}
