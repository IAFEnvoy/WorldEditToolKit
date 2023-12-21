package iafenvoy.wetk.mixin;

import iafenvoy.wetk.config.Configs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.BlockItem;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientPlayNetworkHandler.class)
public class MixinClientPlayNetworkHandler {
    @ModifyVariable(method = "sendChatCommand", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private String modifyCommand(String original) {
        if (original.equals("/set")&& Configs.General.set_hand.getBooleanValue()&&MinecraftClient.getInstance().player != null) {
            if (MinecraftClient.getInstance().player.getInventory().getMainHandStack().getItem() instanceof BlockItem)
                original += " " + MinecraftClient.getInstance().player.getInventory().getMainHandStack().getItem().toString();
            else
                MinecraftClient.getInstance().player.sendMessage(Text.translatable("chat.error.not_a_block"));
        }
        return original;
    }
}
