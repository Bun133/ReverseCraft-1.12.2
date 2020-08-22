package com.bun133.reversecraft;

import com.bun133.reversecraft.block.Blocks;
import com.bun133.reversecraft.item.Items;
import com.bun133.reversecraft.tileEntity.TileEntityHandler;
import com.bun133.reversecraft.util.GUIHandler;
import com.bun133.reversecraft.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import static com.bun133.reversecraft.ReverseCraftModMain.Logger;

@Mod.EventBusSubscriber
public class ReverseCraftModBus {
    @SubscribeEvent
    public void onItemInit(RegistryEvent.Register<Item> item) {
        Logger.info("Item init");
        for(Item i:Items.items){
            item.getRegistry().register(i);
        }

        for(Item i: Blocks.items){
            item.getRegistry().register(i);
        }
    }

    @SubscribeEvent
    public void onBlockInit(RegistryEvent.Register<Block> block){
        Logger.info("Block init");
        for(Block b:Blocks.blocks){
            block.getRegistry().register(b);
        }

        TileEntityHandler.TileEntityRegister();
    }

    @SubscribeEvent
    public void onModelRegister(ModelRegistryEvent e){
        Logger.info("Model init");
        for(Item i:Items.items){
            if(i instanceof IHasModel){
                ((IHasModel) i).onModel();
            }
        }

        for(Block b:Blocks.blocks){
            if(b instanceof IHasModel){
                ((IHasModel) b).onModel();
            }
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        Logger=e.getModLog();
        Logger.info("Preinit");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        Logger.info("init");
        NetworkRegistry.INSTANCE.registerGuiHandler(ReverseCraftModMain.INSTANCE,new GUIHandler());
    }
}
