package net.nanoteam.nanocraft.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.nanoteam.nanocraft.Nanocraft;
import net.nanoteam.nanocraft.container.ContainerMelter;
import net.nanoteam.nanocraft.tileentity.TileEntityMelter;

public class GuiMelter extends GuiContainer{
	
	public static final ResourceLocation bground = new ResourceLocation(Nanocraft.MODID + ":" + "textures/gui/Melter.png");
	
	public TileEntityMelter melter;

	public GuiMelter(InventoryPlayer invetoryPlayer, TileEntityMelter entity) {
		super(new ContainerMelter(invetoryPlayer, entity));
		
		this.melter = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.melter.hasCustomInventoryName() ? this.melter.getInventoryName() : I18n.format(this.melter.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString("Melter", this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), this.xSize / 2 + 30, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}
	

}
