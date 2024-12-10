package iafenvoy.wetk.config.hotkey;

import fi.dy.masa.malilib.hotkeys.IHotkeyCallback;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import iafenvoy.wetk.config.Configs;
import iafenvoy.wetk.config.GuiConfig;
import net.minecraft.client.MinecraftClient;

public class KeyBindHandler implements IHotkeyCallback {
    public static final KeyBindHandler INSTANCE = new KeyBindHandler();

    @Override
    public boolean onKeyAction(KeyAction action, IKeybind key) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || !Configs.General.ENABLE_HOTKEY.getBooleanValue()) return true;
        if (key == Configs.General.OPEN_MENU_KEY.getKeybind()) {
            if (client.currentScreen instanceof GuiConfig)
                client.currentScreen.close(); // actually has no effect
            else
                client.setScreen(new GuiConfig());
        } else if (key == Configs.ShortCut.WE_CUT.getKeybind())
            client.player.networkHandler.sendChatCommand("/cut");
        else if (key == Configs.ShortCut.WE_COPY.getKeybind())
            client.player.networkHandler.sendChatCommand("/copy");
        else if (key == Configs.ShortCut.WE_PASTE.getKeybind())
            client.player.networkHandler.sendChatCommand("/paste");
        else if (key == Configs.ShortCut.WE_UNDO.getKeybind())
            client.player.networkHandler.sendChatCommand("/undo");
        else if (key == Configs.ShortCut.WE_REDO.getKeybind())
            client.player.networkHandler.sendChatCommand("/redo");
        return true;
    }
}
