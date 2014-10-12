package net.nanoteam.nanocraft.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.nanoteam.nanocraft.tileentity.TileEntityMelter;

public class ContainerMelter extends Container {

	private TileEntityMelter melter;
	
	public ContainerMelter (InventoryPlayer inventory, TileEntityMelter tileentity){
		this.melter = tileentity;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return false;
	}

}
