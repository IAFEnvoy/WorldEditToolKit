package iafenvoy.wetk.config.hotkey;

import fi.dy.masa.malilib.hotkeys.IKeybindManager;
import fi.dy.masa.malilib.hotkeys.IKeybindProvider;
import iafenvoy.wetk.config.Configs;

public class KeybindProvider implements IKeybindProvider {
    @Override
    public void addKeysToMap(IKeybindManager manager) {
        manager.addKeybindToMap(Configs.General.open_menu_key.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.we_cut.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.we_copy.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.we_paste.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.we_undo.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.we_redo.getKeybind());
    }

    @Override
    public void addHotkeys(IKeybindManager manager) {
        // Not necessary
    }
}