package iafenvoy.wetk.config.type;

import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import iafenvoy.wetk.ModIdProvider;
import iafenvoy.wetk.config.hotkey.KeyBindHandler;
import net.minecraft.client.resource.language.I18n;

public class NativeHotkey extends ConfigHotkey implements ModIdProvider {

    public NativeHotkey(String keyname, String defaultStorageString) {
        super(I18n.translate("config." + MOD_ID + "." + keyname), defaultStorageString, KeybindSettings.MODIFIER_INGAME, I18n.translate("config." + MOD_ID + "." + keyname + ".help"));
        this.getKeybind().setCallback(KeyBindHandler.INSTANCE);
    }

}
