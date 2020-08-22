package com.bun133.reversecraft;

import com.bun133.reversecraft.block.Blocks;
import com.bun133.reversecraft.block.reversecrafter.ReverseCrafter;
import com.bun133.reversecraft.item.Items;
import com.bun133.reversecraft.tileEntity.TileEntityHandler;
import com.bun133.reversecraft.util.GUIHandler;
import com.bun133.reversecraft.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ReverseCraftModMain.MOD_ID,version = ReverseCraftModMain.MOD_VER,name = ReverseCraftModMain.MOD_NAME)
@Mod.EventBusSubscriber
public class ReverseCraftModMain {
    public static final String MOD_ID="rsc";
    public static final String MOD_NAME="ReverseCraft";
    public static final String MOD_VER="1.0";

    public static final int ReverseCrafter_GUIID=11;

    public static final CreativeTabs MOD_TAB=new ModTab("ReverseCraft");

    @Mod.Instance(MOD_ID)
    public static ReverseCraftModMain INSTANCE;

    public static org.apache.logging.log4j.Logger Logger;

    @GameRegistry.ObjectHolder(MOD_ID)
    public static ReverseCrafter crafter = new ReverseCrafter(Material.ROCK);


    @SubscribeEvent
    public static void onItemInit(RegistryEvent.Register<Item> item) {
        Logger.info("Item init");
        for(Item i: Items.items){
            item.getRegistry().register(i);
        }

        for(Item i: Blocks.items){
            item.getRegistry().register(i);
        }
    }

    @SubscribeEvent
    public static void onBlockInit(RegistryEvent.Register<Block> block){
        Logger.info("Block init");
        for(Block b: Blocks.blocks){
            block.getRegistry().register(b);
        }

        TileEntityHandler.TileEntityRegister();
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent e){
        Logger.info("Model init");
        for(Item i: Items.items){
            if(i instanceof IHasModel){
                ((IHasModel) i).onModel();
            }
        }

        for(Block b: Blocks.blocks){
            if(b instanceof IHasModel){
                ((IHasModel) b).onModel();
            }
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e){
        Logger=e.getModLog();
        Logger.info("Preinit");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        Logger.info("init");
        NetworkRegistry.INSTANCE.registerGuiHandler(ReverseCraftModMain.INSTANCE,new GUIHandler());
    }
}
