package com.iafenvoy.wetk;

import com.iafenvoy.wetk.config.Configs;
import com.iafenvoy.wetk.config.hotkey.KeybindProvider;
import com.iafenvoy.wetk.tip.TipManager;
import com.iafenvoy.wetk.util.FileUtil;
import com.mojang.logging.LogUtils;
import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.event.InputEventHandler;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;

public class WorldEditToolKit implements ClientModInitializer {
    public static final String MOD_ID = "wetk";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitializeClient() {
        ConfigManager.getInstance().registerConfigHandler(MOD_ID, new Configs());
        Configs.loadFile();
        Configs.Init();
        InputEventHandler.getKeybindManager().registerKeybindProvider(new KeybindProvider());
        TipManager.INSTANCE.addTips(FileUtil.readResourceAsJson("/tips/worldedit.json"));
    }
}
