package com.bun133.reversecraft.block.reversecrafter;

import com.bun133.reversecraft.util.HookSlotItemHandler;
import com.bun133.reversecraft.util.Hookable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class ReverseCrafterTileEntity extends TileEntity implements ITickable, Hookable {
    public ItemStackHandler crafter_inventory = new ItemStackHandler(10); //3*3+1

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability== CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.crafter_inventory;
        return super.getCapability(capability, facing);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.crafter_inventory.deserializeNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("Inventory",this.crafter_inventory.serializeNBT());
        return super.writeToNBT(compound);
    }

    @SuppressWarnings("NoTranslation")
    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentTranslation("container.reversecrafter");
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX(), (double) this.pos.getY(), (double) this.pos.getZ()) <= 64;
    }

    public ItemStack currentItemStack;
    public boolean isSetted;
    @Override
    public void update() {
        if(!this.crafter_inventory.getStackInSlot(0).isEmpty()) {
            if (allEmpty()) {
                setToHandler(ReverseCrafterRecipe.INSTANCE.getRecipeResult(this.crafter_inventory, 0));
                this.crafter_inventory.setStackInSlot(0, ItemStack.EMPTY);
            }
        }
    }

    private boolean allEmpty() {
        return allEmpty(this.crafter_inventory,1,9);
    }

    private boolean allEmpty(ItemStackHandler crafter_inventory, int start, int end) {
        for(int i=start;i<end;i++){
            if(!crafter_inventory.getStackInSlot(i).isEmpty()){
                return false;
            }
        }
        return true;
    }

    private void setToHandler(ItemStack[] recipeResult,int shift_int) {
        for (int i = shift_int; i < recipeResult.length+shift_int; i++) {
            this.crafter_inventory.setStackInSlot(i,recipeResult[i-shift_int]);
        }
    }

    private void setToHandler(ItemStack[] stack){
        this.setToHandler(stack,1);
    }

    @Override
    public void onHook(HookSlotItemHandler handler, ItemStack before, ItemStack after) {
//        if(before.getItem().equals(after.getItem())){
//            if(after.getCount()<before.getCount()){
//                if(handler.slotNumber!=0 && handler.slotNumber<9){
//
//                }
//            }
//        }
    }
}
