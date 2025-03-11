package com.iafenvoy.wetk.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iafenvoy.wetk.config.type.NativeBoolean;
import com.iafenvoy.wetk.config.type.NativeHotkey;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.*;
import fi.dy.masa.malilib.util.JsonUtils;
import iafenvoy.wetk.config.type.*;

import java.io.File;

public class Configs implements IConfigHandler {
    private static final String FILE_PATH = "./config/wetk.json";
    private static final File CONFIG_DIR = new File("./config");

    public static void Init() {
        General.init();
        ShortCut.init();
    }

    public static void loadFile() {
        File settingFile = new File(FILE_PATH);
        if (settingFile.isFile() && settingFile.exists()) {
            JsonElement jsonElement = JsonUtils.parseJsonFile(settingFile);
            if (jsonElement instanceof JsonObject) {

                for (Category category : Category.values())
                    ConfigUtils.readConfigBase((JsonObject) jsonElement, category.name(), category.getConfigs());
            }
        }
    }

    @Override
    public void load() {
        loadFile();
    }

    @Override
    public void save() {
        if ((CONFIG_DIR.exists() && CONFIG_DIR.isDirectory()) || CONFIG_DIR.mkdirs()) {
            JsonObject configRoot = new JsonObject();
            for (Category category : Category.values())
                ConfigUtils.writeConfigBase(configRoot, category.name(), category.getConfigs());
            JsonUtils.writeJsonToFile(configRoot, new File(FILE_PATH));
        }
    }

    public static class General {
        public static final ConfigHotkey OPEN_MENU_KEY = new NativeHotkey("open_menu_key", "Z,C");
        public static final ConfigBoolean ENABLE_TIP = new NativeBoolean("enable_tip", true);
        public static final ConfigBoolean ENABLE_HOTKEY = new NativeBoolean("enable_hotkey", true);
        public static final ConfigBoolean SET_HAND = new NativeBoolean("set_hand", true);

        public static void init() {
            Category.GENERAL.add(OPEN_MENU_KEY);
            Category.GENERAL.add(ENABLE_TIP);
            Category.GENERAL.add(ENABLE_HOTKEY);
            Category.GENERAL.add(SET_HAND);
        }
    }

    public static class ShortCut {
        public static final ConfigHotkey WE_CUT = new NativeHotkey("we_cut", "LEFT_CONTROL,X");
        public static final ConfigHotkey WE_COPY = new NativeHotkey("we_copy", "LEFT_CONTROL,C");
        public static final ConfigHotkey WE_PASTE = new NativeHotkey("we_paste", "LEFT_CONTROL,V");
        public static final ConfigHotkey WE_UNDO = new NativeHotkey("we_undo", "LEFT_CONTROL,Z");
        public static final ConfigHotkey WE_REDO = new NativeHotkey("we_redo", "LEFT_CONTROL,Y");
        public static final ConfigHotkey WE_SET = new NativeHotkey("we_set", "LEFT_CONTROL,H");

        public static void init() {
            Category.SHORTCUT.add(WE_CUT);
            Category.SHORTCUT.add(WE_COPY);
            Category.SHORTCUT.add(WE_PASTE);
            Category.SHORTCUT.add(WE_UNDO);
            Category.SHORTCUT.add(WE_REDO);
            Category.SHORTCUT.add(WE_SET);
        }
    }
}
