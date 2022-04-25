package dev.necauqua.mods.cm.mixin.access;

import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(net.minecraft.client.gui.GuiNewChat.class)
public interface GuiNewChatAccessor {
	@Accessor("drawnChatLines")
	List<ChatLine> $cm$getDrawnChatLines();
}
