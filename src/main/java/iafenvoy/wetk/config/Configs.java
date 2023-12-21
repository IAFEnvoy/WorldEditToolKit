package iafenvoy.wetk.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
        public static final ConfigHotkey open_menu_key = new NativeHotkey("open_menu_key", "Z,C");
        public static final ConfigBoolean enable_tip = new NativeBoolean("enable_tip", true);
        public static final ConfigBoolean set_hand = new NativeBoolean("set_hand", true);

        public static void init() {
            Category.GENERAL.add(open_menu_key);
            Category.GENERAL.add(enable_tip);
            Category.GENERAL.add(set_hand);
        }
    }

    public static class ShortCut {
        public static final ConfigHotkey we_cut = new NativeHotkey("we_cut", "LEFT_CONTROL,X");
        public static final ConfigHotkey we_copy = new NativeHotkey("we_copy", "LEFT_CONTROL,C");
        public static final ConfigHotkey we_paste = new NativeHotkey("we_paste", "LEFT_CONTROL,V");
        public static final ConfigHotkey we_undo = new NativeHotkey("we_undo", "LEFT_CONTROL,Z");
        public static final ConfigHotkey we_redo = new NativeHotkey("we_redo", "LEFT_CONTROL,Y");
        public static final ConfigHotkey we_set = new NativeHotkey("we_set", "LEFT_CONTROL,H");

        public static void init() {
            Category.SHORTCUT.add(we_cut);
            Category.SHORTCUT.add(we_copy);
            Category.SHORTCUT.add(we_paste);
            Category.SHORTCUT.add(we_undo);
            Category.SHORTCUT.add(we_redo);
            Category.SHORTCUT.add(we_set);
        }
    }
}
