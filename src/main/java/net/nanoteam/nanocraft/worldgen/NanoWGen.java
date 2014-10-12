package net.nanoteam.nanocraft.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.nanoteam.nanocraft.Nanocraft;
import cpw.mods.fml.common.IWorldGenerator;

public class NanoWGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
			case 0:
				//generate surface world
				generateSurface(world, random, chunkX*16, chunkZ*16);
			case -1:
				//generate nether world
				generateNether(world, random, chunkX*16, chunkZ*16);
			case 1:
				//generate end world
				generateEnd(world, random, chunkX*16, chunkZ*16);
		
		}
		
	}

	private void generateEnd(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateNether(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int x, int z) {
		this.addOreSpawn(Nanocraft.ore_Titanium, world, random, x, z, 16, 16, 2+random.nextInt(3), 15, 5, 100);
		
	}

	private void addOreSpawn(Block block, World world, Random random, int x, int z, int maxX, int maxZ, int veinSize, int chance, int minY, int maxY) {
		for (int i = 0; i < chance; i++){
			int posX = x + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY-minY);
			int posZ = z + random.nextInt(maxZ);
			(new WorldGenMinable(block, veinSize)).generate(world, random, posX, posY, posZ);
		}
		
	}
	
	
}
