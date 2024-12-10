package iafenvoy.wetk.config.hotkey;

import fi.dy.masa.malilib.hotkeys.IKeybindManager;
import fi.dy.masa.malilib.hotkeys.IKeybindProvider;
import iafenvoy.wetk.config.Configs;

public class KeybindProvider implements IKeybindProvider {
    @Override
    public void addKeysToMap(IKeybindManager manager) {
        manager.addKeybindToMap(Configs.General.OPEN_MENU_KEY.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.WE_CUT.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.WE_COPY.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.WE_PASTE.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.WE_UNDO.getKeybind());
        manager.addKeybindToMap(Configs.ShortCut.WE_REDO.getKeybind());
    }

    @Override
    public void addHotkeys(IKeybindManager manager) {
        // Not necessary
    }
}