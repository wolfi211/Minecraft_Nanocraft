package net.nanoteam.nanocraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.nanoteam.nanocraft.blocks.Melter;
import net.nanoteam.nanocraft.blocks.NanoOres;
import net.nanoteam.nanocraft.blocks.TitaniumBlock;
import net.nanoteam.nanocraft.items.NanoAxe;
import net.nanoteam.nanocraft.items.NanoHoe;
import net.nanoteam.nanocraft.items.NanoItems;
import net.nanoteam.nanocraft.items.NanoPickaxe;
import net.nanoteam.nanocraft.items.NanoShovel;
import net.nanoteam.nanocraft.items.NanoSword;
import net.nanoteam.nanocraft.worldgen.NanoWGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Nanocraft.MODID, version = Nanocraft.VERSION)
public class Nanocraft {

	public static final String MODID = "NanoCraft";
	public static final String VERSION = "Alpha v0.1";
	
	NanoWGen eventWorldGen = new NanoWGen();
	
	//tab(s)
	public static CreativeTabs nanoTab;
	
	//material items
	public static Item item_TitaniumIngot;
	public static Item item_rawTitaniumDust;
	public static Item item_pureTitaniumPile;
	public static Item item_GrapheneSheet;
	public static Item item_GrapheneDust;
	
	//tools and armors
	public static Item tool_TitaniumPickaxe;
	public static Item tool_TitaniumShovel;
	public static Item tool_TitaniumAxe;
	public static Item tool_TitaniumSword;
	public static Item tool_TitaniumHoe;
	public static Item armor_TitaniumHelmet;
	public static Item armor_TitaniumChestplate;
	public static Item armor_TitaniumLeggings;
	public static Item armor_TitaniumBoots;
	
	//Materials
	public static ToolMaterial material_Titanium = EnumHelper.addToolMaterial("material_Titanium", 3, 780, 8.0F, 3.0F, 22);
	//public static ArmorMaterial armorMaterial_Titanium = EnumHelper.addArmorMaterial("material_Titanium", 24, new int[]{3, 8, 6, 3}, 22);
	
	//material blocks
	public static Block ore_Titanium;
	
	//decorative blocks
	public static Block block_Titanium;
	
	//Factory Blocks
	public static Block fact_Melter_Inactive;
	public static Block fact_Melter_Active;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		
		//tab(s)
		nanoTab = new CreativeTabs("nanocraft"){
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return Nanocraft.item_TitaniumIngot;
			}
		};
		
		//material items
		item_TitaniumIngot = new NanoItems().setUnlocalizedName("TitaniumIngot");
		item_rawTitaniumDust = new NanoItems().setUnlocalizedName("rawTitaniumDust");
		item_pureTitaniumPile = new NanoItems().setUnlocalizedName("pureTitaniumPile");
		item_GrapheneSheet = new NanoItems().setUnlocalizedName("GrapheneSheet");
		item_GrapheneDust = new NanoItems().setUnlocalizedName("GrapheneDust");
		GameRegistry.registerItem(item_TitaniumIngot, "TitaniumIngot");
		GameRegistry.registerItem(item_rawTitaniumDust, "TitaniumDust");
		GameRegistry.registerItem(item_pureTitaniumPile, "unprocessedTitanium");
		GameRegistry.registerItem(item_GrapheneSheet, "GrapheneSheet");
		GameRegistry.registerItem(item_GrapheneDust, "GrapheneDust");
		
		//tools and armors
		tool_TitaniumPickaxe = new NanoPickaxe(material_Titanium).setUnlocalizedName("TitaniumPickaxe");
		tool_TitaniumShovel = new NanoShovel(material_Titanium).setUnlocalizedName("TitaniumShovel");
		tool_TitaniumAxe = new NanoAxe(material_Titanium).setUnlocalizedName("TitaniumAxe");
		tool_TitaniumSword = new NanoSword(material_Titanium).setUnlocalizedName("TitaniumSword");
		tool_TitaniumHoe = new NanoHoe(material_Titanium).setUnlocalizedName("TitaniumHoe");
		/*armor_TitaniumHelmet = new TitaniumHelmet(material_Titanium).setUnlocalizedName("TitaniumHelmet");
		armor_TitaniumChestplate = new TitaniumChestplate(material_Titanium).setUnlocalizedName("TitaniumChestplate");
		armor_TitaniumLeggings = new TitaniumLeggings(material_Titanium).setUnlocalizedName("TitaniumLeggings");
		armor_TitaniumBoots = new TitaniumBoots(material_Titanium).setUnlocalizedName("TitaniumBoots");*/
		GameRegistry.registerItem(tool_TitaniumPickaxe, "TitaniumPickaxe");
		GameRegistry.registerItem(tool_TitaniumShovel, "TitaniumShovel");
		GameRegistry.registerItem(tool_TitaniumAxe, "TitaniumAxe");
		GameRegistry.registerItem(tool_TitaniumSword, "TitaniumSword");
		GameRegistry.registerItem(tool_TitaniumHoe, "TitaniumHoe");
		/*GameRegistry.registerItem(armor_TitaniumHelmet, "TitaniumHelmet");
		GameRegistry.registerItem(armor_TitaniumChestplate, "TitaniumChestplate");
		GameRegistry.registerItem(armor_TitaniumLeggings, "TitaniumLeggings");
		GameRegistry.registerItem(armor_TitaniumBoots, "TitaniumBoots");*/
		
		//material blocks
		ore_Titanium = new NanoOres(Material.rock).setBlockName("TitaniumOre");
		GameRegistry.registerBlock(ore_Titanium, "TitaniumOre");
		
		//decorative blocks
		block_Titanium = new TitaniumBlock(Material.iron).setBlockName("TitaniumBlock");
		GameRegistry.registerBlock(block_Titanium, "TitaniumBlock");
		
		//Factory blocks
		fact_Melter_Inactive = new Melter(false).setBlockName("MelterInactive").setCreativeTab(nanoTab);
		fact_Melter_Active = new Melter(true).setBlockName("MelterActive").setLightLevel(0.625F);
		GameRegistry.registerBlock(fact_Melter_Inactive, "MelterInactive");
		GameRegistry.registerBlock(fact_Melter_Active, "MelterActive");
		
		//spawn
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		//recipes
		GameRegistry.addRecipe(new ItemStack(block_Titanium), new Object[]{"TTT", "TTT", "TTT", 'T', item_TitaniumIngot});
		GameRegistry.addRecipe(new ItemStack(tool_TitaniumPickaxe), new Object[]{"TTT", " S ", " S ", 'T', item_TitaniumIngot, 'S',  net.minecraft.item.Item.getItemById(280)});
		GameRegistry.addRecipe(new ItemStack(tool_TitaniumSword), new Object[]{" T ", " T ", " S ", 'T', item_TitaniumIngot, 'S',  net.minecraft.item.Item.getItemById(280)});
		GameRegistry.addRecipe(new ItemStack(tool_TitaniumAxe), new Object[]{" TT", " ST", " S ", 'T', item_TitaniumIngot, 'S',  net.minecraft.item.Item.getItemById(280)});
		GameRegistry.addRecipe(new ItemStack(tool_TitaniumShovel), new Object[]{" T ", " S ", " S ", 'T', item_TitaniumIngot, 'S',  net.minecraft.item.Item.getItemById(280)});
		GameRegistry.addRecipe(new ItemStack(tool_TitaniumHoe), new Object[]{" TT", " S ", " S ", 'T', item_TitaniumIngot, 'S',  net.minecraft.item.Item.getItemById(280)});
		GameRegistry.addRecipe(new ItemStack(tool_TitaniumHoe), new Object[]{"TT ", " S ", " S ", 'T', item_TitaniumIngot, 'S',  net.minecraft.item.Item.getItemById(280)});
		GameRegistry.addRecipe(new ItemStack(tool_TitaniumHoe), new Object[]{"TT ", "TS ", " S ", 'T', item_TitaniumIngot, 'S',  net.minecraft.item.Item.getItemById(280)}); 
		
		//Smelting recipes
		GameRegistry.addSmelting(item_pureTitaniumPile, new ItemStack(item_TitaniumIngot), 10);
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		
	}
}
