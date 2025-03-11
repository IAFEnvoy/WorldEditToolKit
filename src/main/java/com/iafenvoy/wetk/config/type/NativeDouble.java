package com.iafenvoy.wetk.config.type;

import fi.dy.masa.malilib.config.options.ConfigDouble;
import com.iafenvoy.wetk.ModIdProvider;
import net.minecraft.client.resource.language.I18n;

public class NativeDouble extends ConfigDouble implements ModIdProvider {

    public NativeDouble(String keyname, double defaultValue, double minValue, double maxValue) {
        super(I18n.translate("config." + MOD_ID + "." + keyname), defaultValue, minValue, maxValue, I18n.translate("config." + MOD_ID + "." + keyname + ".help"));
    }

}
