package com.bun133.reversecraft.tileEntity;

import com.bun133.reversecraft.ReverseCraftModMain;
import com.bun133.reversecraft.block.reversecrafter.ReverseCrafterTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    // It must be called after Blocks register.
    public static void TileEntityRegister(){
        GameRegistry.registerTileEntity(ReverseCrafterTileEntity.class,new ResourceLocation(ReverseCraftModMain.MOD_ID,"reversecrafter"));
    }
}
