package com.bun133.reversecraft.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class HookSlotItemHandler extends SlotItemHandler {
    private Hookable hook;
    public HookSlotItemHandler(Hookable hook, IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public void onSlotChange(@Nonnull ItemStack p_75220_1_, @Nonnull ItemStack p_75220_2_) {
        hook.onHook(this,p_75220_1_,p_75220_2_);
    }
}
