package net.nanoteam.nanocraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.nanoteam.nanocraft.Nanocraft;
import net.nanoteam.nanocraft.tileentity.TileEntityMelter;
import net.nanoteam.nanocraft.container.ContainerMelter;

public class GuiMelter extends GuiContainer{
	
	public static final ResourceLocation bground = new ResourceLocation(Nanocraft.MODID, "textures/gui/Melter.png");
	
	public TileEntityMelter melter;

	public GuiMelter(InventoryPlayer invetoryPlayer, TileEntityMelter entity) {
		super(ContainerMelter(invetoryPlayer, entity));
		
		this.melter = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForgroundLayer(int par1, int par2){
		String name = this.melter.hasCustomInventoryName() ? this.melter.getInventoryName() : I18n.format(this.melter.getInventoryName, new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), this.xSize / 2 + 50, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}
	

}
