package com.iafenvoy.wetk.tip;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class CommandTipLabel {
    private final int x, y, width, height;
    private final TextRenderer textRenderer;
    private String lastCmd = "", lastTip = "";

    public CommandTipLabel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.textRenderer = MinecraftClient.getInstance().textRenderer;
    }

    public void render(DrawContext context, String commandText) {
        if (!commandText.equals(this.lastCmd)) {
            this.lastTip = TipManager.INSTANCE.getTip(commandText);
            this.lastCmd = commandText;
        }
        if (this.lastTip.isEmpty()) return;
        context.fill(this.x, this.y, this.x + Math.min(this.width, this.textRenderer.getWidth(this.lastTip) + 4), this.y + this.height, -805306368);
        context.drawTextWithShadow(this.textRenderer, this.lastTip, this.x + 2, this.y + 2, -1);
    }
}
