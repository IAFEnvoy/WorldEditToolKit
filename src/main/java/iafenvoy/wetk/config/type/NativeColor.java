package iafenvoy.wetk.config.type;

import fi.dy.masa.malilib.config.options.ConfigColor;
import iafenvoy.wetk.ModIdProvider;
import net.minecraft.client.resource.language.I18n;

public class NativeColor extends ConfigColor implements ModIdProvider {

    public NativeColor(String keyname, String defaultValue) {
        super(I18n.translate("config." + MOD_ID + "." + keyname), defaultValue, I18n.translate("config." + MOD_ID + "." + keyname + ".help"));
    }

}
