package net.nanoteam.nanocraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.nanoteam.nanocraft.Nanocraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Melter extends BlockContainer {
	
	private final boolean isActive;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;

	public Melter(boolean isActive) {
		super(Material.iron);
		
		this.isActive = isActive;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Nanocraft.MODID + ":" + "MelterSide");
		this.iconFront = iconRegister.registerIcon(Nanocraft.MODID + ":" + (this.isActive ? "MelterFrontOn" : "MelterFrontOff"));
		this.iconTop = iconRegister.registerIcon(Nanocraft.MODID + ":" + "MelterTop");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata){
		return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != metadata ? this.blockIcon : this.iconFront));
	}
	
	public Item getItemDropped(World world, int x, int y, int z){
		return Item.getItemFromBlock(Nanocraft.fact_Melter_Inactive);
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z){
		if (world.isRemote){
			Block b1 = world.getBlock(x, y, z-1);
			Block b2 = world.getBlock(x, y, z+1);
			Block b3 = world.getBlock(x-1, y, z);
			Block b4 = world.getBlock(x+1, y, z);
			
			byte b0 = 3;
			
			if(b1.func_149730_j() && !b2.func_149730_j()){
				b0 = 3;
			}
			
			if(b2.func_149730_j() && !b1.func_149730_j()){
				b0 = 2;
			}
			
			if(b3.func_149730_j() && !b4.func_149730_j()){
				b0 = 5;
			}
			
			if(b4.func_149730_j() && !b3.func_149730_j()){
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		
		}
		
		
	}
	
	//TODO onBlockActivated
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2){
		return null;		
	}
	
	//TODO randomDisplayTick
	
	public void inBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityPlayer, ItemStack itemstack) {
		int l = MathHelper.floor_double((double)(entityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if (l == 0) world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		if (l == 1) world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		if (l == 2) world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		if (l == 3) world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		
		if (itemstack.hasDisplayName()){
			//TODO ((TileEntityMelter)world.getTileEntity(x,y,z)).setGuiDisplayName(itemstack.getDisplayName());
		}
	}
	

}