package com.bun133.reversecraft.block.reversecrafter;

import com.bun133.reversecraft.ReverseCraftModMain;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandler;

public class GuiReverseCrafter extends GuiContainer {
    public final ResourceLocation TEXTURE=new ResourceLocation(ReverseCraftModMain.MOD_ID,"textures/gui/texture.png");
    private IItemHandler item_handler;
    public GuiReverseCrafter(EntityPlayer player, ReverseCrafterTileEntity tileentity) {
        super(new ContainerReverseCrafter(player.inventory, tileentity));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f,1.0f,1.0f);
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(TEXTURE);

        //Draw GUI
        int center_x=(width/2) - this.xSize /2;
        int center_y=(height/2) - this.ySize /2;
        drawTexturedModalRect(center_x,center_y,0,0,this.xSize,this.ySize);
    }
}
