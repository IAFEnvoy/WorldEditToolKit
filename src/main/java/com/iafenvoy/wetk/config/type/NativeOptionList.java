package com.iafenvoy.wetk.config.type;

import fi.dy.masa.malilib.config.IConfigOptionListEntry;
import fi.dy.masa.malilib.config.options.ConfigOptionList;
import com.iafenvoy.wetk.ModIdProvider;
import net.minecraft.client.resource.language.I18n;

public class NativeOptionList extends ConfigOptionList implements ModIdProvider {

    public NativeOptionList(String keyname, IConfigOptionListEntry defaultValue) {
        super(I18n.translate("config." + MOD_ID + "." + keyname), defaultValue, I18n.translate("config." + MOD_ID + "." + keyname + ".help"));
    }

}
