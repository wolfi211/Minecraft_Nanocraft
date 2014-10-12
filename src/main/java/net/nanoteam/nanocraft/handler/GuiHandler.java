package net.nanoteam.nanocraft.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.nanoteam.nanocraft.Nanocraft;
import net.nanoteam.nanocraft.container.ContainerMelter;
import net.nanoteam.nanocraft.gui.GuiMelter;
import net.nanoteam.nanocraft.tileentity.TileEntityMelter;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null){
			switch (ID){
			case Nanocraft.guiIDMelter:
				if (entity instanceof TileEntityMelter) return new ContainerMelter(player.inventory, (TileEntityMelter) entity);
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null){
			switch (ID){
			case Nanocraft.guiIDMelter:
				if (entity instanceof TileEntityMelter) return new GuiMelter(player.inventory, (TileEntityMelter) entity);
				return null;
			
			}
		}
		return null;
	}

}
