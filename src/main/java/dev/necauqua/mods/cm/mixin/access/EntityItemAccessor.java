package dev.necauqua.mods.cm.mixin.access;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EntityItem.class)
public class EntityItemAccessor {
	@Accessor("ITEM")
	public static DataParameter<ItemStack> $cm$getITEM() {
		return null;
	}
}
