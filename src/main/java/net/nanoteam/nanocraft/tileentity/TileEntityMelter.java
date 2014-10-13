package net.nanoteam.nanocraft.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.nanoteam.nanocraft.blocks.Melter;

public class TileEntityMelter extends TileEntity implements ISidedInventory{
	
	//variable declaration
	private String localizedName;
	
	private ItemStack[] slots = new ItemStack[3];
	
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_side = new int[]{1};
	
	public int speed = 60;			//the number of ticks that the furnace will keep burning for
	public int burnTime;			//number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
	public int currentItemBurnTime;	//number of ticks that the current item has been cooking for
	public int cookTime;
	
	//start of the methods
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}
	public boolean hasCustomInventoryName() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	public String getInventoryName() {
		return (this.hasCustomInventoryName() ? this.localizedName : "container.melter");
	}
	public int getSizeInventory(){
		return this.slots.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isItemValidForSlot(int var1, ItemStack itemstack) {
		return var1 == 2 ? false : (var1 == 1 ? isItemFuel(itemstack) : true);
	}
	private boolean isItemFuel(ItemStack itemstack) {
		return getItemBurnTime(itemstack) > 0;
	}

	private int getItemBurnTime(ItemStack itemstack) {
		if (itemstack == null) return 0;
		else {
			Item item = itemstack.getItem();
			
			if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
				Block block = Block.getBlockFromItem(item);
				
				//if (item == Nanocraft.fuel) return 800;
				if (item == Items.coal) return 1600;
				if (block == Blocks.coal_block) return 14400;
				
				return GameRegistry.getFuelValue(itemstack);
			} else return 0;
		}
	}
	public  void updateEnity(){
		boolean flag = this.burnTime >0;
		boolean flag1 = false;
		
		if(this.burnTime > 0){
			this.burnTime--;
		}
		if(!this.worldObj.isRemote){
			if(this.burnTime == 0 && this.canSmelt()){
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
				
				if(this.isBurning()){
					flag1 = true;
					
					if(this.slots[1] != null){
						this.slots[1].stackSize--;
						
						if(this.slots[1].stackSize == 0){
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
						}
					}
				}
			}
			if(this.isBurning() && this.canSmelt()){
				this.cookTime++;
			
				if(this.cookTime == this.speed){
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
				} else {
					this.cookTime = 0;
				}
			if (flag != this.isBurning()){
				flag1 = true;
				Melter.updateMelterBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		
		if(flag1){
			this.markDirty();
		}
	}
	
	private void smeltItem() {
		// TODO Auto-generated method stub
		
	}

	private boolean canSmelt() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isBurning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
	}
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}

}
