package net.nanoteam.nanocraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.nanoteam.nanocraft.tileentity.TileEntityMelter;

public class GuiMelter extends GuiContainer{
	
	public TileEntityMelter melter;

	public GuiMelter(InventoryPlayer invetoryPlayer, TileEntityMelter entity) {
		super(ContainerMelter(invetoryPlayer, entity));
		
		this.melter = entity;
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}
	

}
