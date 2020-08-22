package com.bun133.reversecraft.util;

import net.minecraft.item.ItemStack;

public interface Hookable {
    void onHook(HookSlotItemHandler handler,ItemStack before, ItemStack after);
}
