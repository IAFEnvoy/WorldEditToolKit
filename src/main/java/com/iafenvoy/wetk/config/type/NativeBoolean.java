package com.iafenvoy.wetk.config.type;

import com.iafenvoy.wetk.WorldEditToolKit;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import net.minecraft.client.resource.language.I18n;

public class NativeBoolean extends ConfigBoolean {
    public NativeBoolean(String keyname, boolean defaultValue) {
        super(I18n.translate("config." + WorldEditToolKit.MOD_ID + "." + keyname), defaultValue, I18n.translate("config." + WorldEditToolKit.MOD_ID + "." + keyname + ".help"));
    }
}
