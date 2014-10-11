package net.nanoteam.nanocraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.nanoteam.nanocraft.Nanocraft;

public class TitaniumBlock extends Block{

	public TitaniumBlock(Material mat) {
		super(mat);
		
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(Nanocraft.nanoTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Nanocraft.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
