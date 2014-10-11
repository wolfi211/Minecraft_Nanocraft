package net.nanoteam.nanocraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;
import net.nanoteam.nanocraft.Nanocraft;

public class NanoAxe extends ItemAxe {

	public NanoAxe(ToolMaterial mat) {
		super(mat);
		this.setCreativeTab(Nanocraft.nanoTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Nanocraft.MODID + ":" + this.getUnlocalizedName().substring(5));
	}


}
