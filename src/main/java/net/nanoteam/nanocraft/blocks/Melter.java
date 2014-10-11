package net.nanoteam.nanocraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
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
		return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : this.blockIcon);
	}
	
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2){
		return null;		
	}
	

}
