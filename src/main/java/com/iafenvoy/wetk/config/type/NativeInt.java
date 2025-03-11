package com.iafenvoy.wetk.config.type;

import fi.dy.masa.malilib.config.options.ConfigInteger;
import com.iafenvoy.wetk.ModIdProvider;
import net.minecraft.client.resource.language.I18n;

public class NativeInt extends ConfigInteger  implements ModIdProvider {

    public NativeInt(String keyname, int defaultValue, int minValue, int maxValue, boolean useSlider) {
        super(I18n.translate("config." + MOD_ID + "." + keyname), defaultValue, minValue, maxValue, useSlider, I18n.translate("config." + MOD_ID + "." + keyname + ".help"));
    }

}
