package com.iafenvoy.wetk.config.type;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import com.iafenvoy.wetk.ModIdProvider;
import net.minecraft.client.resource.language.I18n;

public class NativeBoolean extends ConfigBoolean implements ModIdProvider {

    public NativeBoolean(String keyname, boolean defaultValue) {
        super(I18n.translate("config." + MOD_ID + "." + keyname), defaultValue, I18n.translate("config." + MOD_ID + "." + keyname + ".help"));
    }

}
