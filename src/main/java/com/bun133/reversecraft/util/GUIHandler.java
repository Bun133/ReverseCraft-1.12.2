package com.bun133.reversecraft.util;

import com.bun133.reversecraft.ReverseCraftModMain;
import com.bun133.reversecraft.block.reversecrafter.ContainerReverseCrafter;
import com.bun133.reversecraft.block.reversecrafter.GuiReverseCrafter;
import com.bun133.reversecraft.block.reversecrafter.ReverseCrafterTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GUIHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID== ReverseCraftModMain.ReverseCrafter_GUIID) return new ContainerReverseCrafter(player.inventory,(ReverseCrafterTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID==ReverseCraftModMain.ReverseCrafter_GUIID) return new GuiReverseCrafter(player,(ReverseCrafterTileEntity) world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }
}
