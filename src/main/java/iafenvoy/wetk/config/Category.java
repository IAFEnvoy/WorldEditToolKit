package iafenvoy.wetk.config;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.IConfigBase;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    GENERAL("config.wetk.general"),
    SHORTCUT("config.wetk.shortcut");

    private final String key;
    private final List<IConfigBase> configs;

    Category(String key) {
        this.key = key;
        configs = new ArrayList<>();
    }

    <T extends IConfigBase> void add(T config) {
        this.configs.add(config);
    }

    public List<IConfigBase> getConfigs() {
        return ImmutableList.copyOf(this.configs);
    }

    public String getKey() {
        return this.key;
    }
}
