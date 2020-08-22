package com.bun133.reversecraft.block.reversecrafter;

import com.bun133.reversecraft.ReverseCraftModMain;
import com.bun133.reversecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class ReverseCrafter extends BlockBase {
    public ReverseCrafter( Material materialIn) {
        super("reversecrafter", materialIn, 1.0f, 1.0f);
    }

    @Override
    public boolean hasTileEntity() {
        return super.hasTileEntity();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new ReverseCrafterTileEntity();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            playerIn.openGui(ReverseCraftModMain.INSTANCE,ReverseCraftModMain.ReverseCrafter_GUIID,worldIn,pos.getX(),pos.getY(),pos.getZ());
        }
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        ReverseCrafterTileEntity tile = (ReverseCrafterTileEntity) worldIn.getTileEntity(pos);
        IItemHandler handler=tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,null);
        for(int i=0;i<handler.getSlots();i++){
            worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(),handler.getStackInSlot(i)));
        }
        super.breakBlock(worldIn,pos,state);
    }
}
