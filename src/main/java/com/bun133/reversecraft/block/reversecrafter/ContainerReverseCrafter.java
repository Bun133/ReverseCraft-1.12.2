package com.bun133.reversecraft.block.reversecrafter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerReverseCrafter extends Container {
    private InventoryPlayer player;
    private IItemHandler item_handler;
    private ReverseCrafterTileEntity tileEntity;
    public ContainerReverseCrafter(InventoryPlayer player, ReverseCrafterTileEntity tileentity) {
        this.player = player;
        this.item_handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,null);
        this.tileEntity =tileentity;

        /*
         * Player Inventory
         */

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(player, x + y * 9, 6 + x * 18,143 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(player, x, 6 + x * 18, 201));
        }

        /*
         *  Crafter Inventory
         */
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                //TODO
                this.addSlotToContainer(new SlotItemHandler(item_handler,x+y*3+1,100,17));
            }
        }

        this.addSlotToContainer(new SlotItemHandler(item_handler,0,34,30));
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileEntity.isUsableByPlayer(playerIn);
    }

    //Ah...I,I don't know what this method mean and work
    //but,this time just return empty.
    //It will work!...maybe
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        return ItemStack.EMPTY;
    }
}
