package com.iafenvoy.wetk.mixin;

import com.iafenvoy.wetk.config.Configs;
import com.iafenvoy.wetk.tip.CommandTipLabel;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatScreen.class)
public class MixinChatScreen extends Screen {
    @Shadow
    protected TextFieldWidget chatField;
    @Unique
    private CommandTipLabel commandTipLabel;

    protected MixinChatScreen(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    private void init(CallbackInfo ci) {
        this.commandTipLabel = new CommandTipLabel(2, this.height - 40, this.width - 4, 12);
    }

    @Inject(method = "render", at = @At("HEAD"))
    private void renderTips(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (Configs.General.ENABLE_TIP.getBooleanValue() && this.chatField.getText().startsWith("/"))
            this.commandTipLabel.render(context, this.chatField.getText().substring(1));
    }
}
