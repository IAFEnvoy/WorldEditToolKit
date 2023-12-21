package iafenvoy.wetk;

import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.event.InputEventHandler;
import iafenvoy.wetk.config.Configs;
import iafenvoy.wetk.config.hotkey.KeybindProvider;
import iafenvoy.wetk.tip.TipManager;
import iafenvoy.wetk.util.FileUtil;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class WorldEditToolKit implements ClientModInitializer, ModIdProvider {
    @Override
    public void onInitializeClient() {
        if (!FabricLoader.getInstance().isModLoaded("malilib")) {
            System.err.println("Malilib is not loaded, WorldEditToolKit will not work.");
            return;
        }

        ConfigManager.getInstance().registerConfigHandler(MOD_ID, new Configs());
        Configs.loadFile();
        Configs.Init();
        InputEventHandler.getKeybindManager().registerKeybindProvider(new KeybindProvider());
        TipManager.INSTANCE.addTips(FileUtil.readResourceAsJson("/tips/worldedit.json"));
    }
}
