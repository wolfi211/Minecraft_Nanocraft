package net.nanoteam.nanocraft.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.nanoteam.nanocraft.tileentity.TileEntityMelter;

public class ContainerMelter extends Container {

	private TileEntityMelter melter;
	
	public int lastBurnTime;			//number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
	public int lastCurrentItemBurnTime;	//number of ticks that the current item has been cooking for
	public int lastCookTime;
	
	public ContainerMelter (InventoryPlayer inventory, TileEntityMelter tileentity){
		this.melter = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 56, 35));
		this.addSlotToContainer(new Slot(tileentity, 1, 8, 61));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 116, 35));
		
		for (int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j*18, 84 + i*18));
				
			}
		}
		
		for (int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}
	
	public void addCraftingToCrafters (ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.melter.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.melter.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.melter.currentItemBurnTime);
		
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++){
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.melter.cookTime){
				icrafting.sendProgressBarUpdate(this, 0, this.melter.cookTime);
			}
			if(this.lastBurnTime != this.melter.burnTime){
				icrafting.sendProgressBarUpdate(this, 0, this.melter.burnTime);
			}
			if(this.lastCurrentItemBurnTime != this.melter.currentItemBurnTime){
				icrafting.sendProgressBarUpdate(this, 0, this.melter.currentItemBurnTime);
			}
		}
		this.lastCookTime = this.melter.cookTime;
		this.lastBurnTime = this.melter.burnTime;
		this.lastCurrentItemBurnTime = this.melter.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue){
		
	}

}
