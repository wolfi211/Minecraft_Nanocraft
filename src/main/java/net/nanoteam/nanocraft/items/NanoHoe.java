package net.nanoteam.nanocraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;
import net.nanoteam.nanocraft.Nanocraft;

public class NanoHoe extends ItemHoe {

	public NanoHoe(ToolMaterial mat) {
		super(mat);
		this.setCreativeTab(Nanocraft.nanoTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Nanocraft.MODID + ":" + this.getUnlocalizedName().substring(5));
	}


}
