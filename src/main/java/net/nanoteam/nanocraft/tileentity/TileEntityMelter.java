package net.nanoteam.nanocraft.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityMelter extends TileEntity {
	
	private String localizedName;
	
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
		
	}

}
