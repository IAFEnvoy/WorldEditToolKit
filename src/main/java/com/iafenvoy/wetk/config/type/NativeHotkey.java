package com.iafenvoy.wetk.config.type;

import com.iafenvoy.wetk.WorldEditToolKit;
import com.iafenvoy.wetk.config.hotkey.KeyBindHandler;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import net.minecraft.client.resource.language.I18n;

public class NativeHotkey extends ConfigHotkey {
    public NativeHotkey(String keyname, String defaultStorageString) {
        super(I18n.translate("config." + WorldEditToolKit.MOD_ID + "." + keyname), defaultStorageString, KeybindSettings.MODIFIER_INGAME, I18n.translate("config." + WorldEditToolKit.MOD_ID + "." + keyname + ".help"));
        this.getKeybind().setCallback(KeyBindHandler.INSTANCE);
    }
}
