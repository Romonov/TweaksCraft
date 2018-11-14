package com.Romonov.mcmod.TweaksCraft.Block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader
{
    public static Block blockRuby = new BlockRuby().setUnlocalizedName("block_ruby");
    public static Block blockOreRuby = new BlockOreRuby().setUnlocalizedName("ore_ruby");
    public static Block blockSapphire = new BlockSapphire().setUnlocalizedName("block_sapphire");
    public static Block blockOreSapphire = new BlockOreSapphire().setUnlocalizedName("ore_sapphire");
    public static Block blockJade = new BlockJade().setUnlocalizedName("block_jade");
    public static Block blockOreJade = new BlockOreJade().setUnlocalizedName("ore_jade");
    public static Block blockGlowingObsidian = new BlockGlowingObsidian().setUnlocalizedName("glowing_obsidian");
    public static Block blockCryingObsidian = new BlockCryingObsidian().setUnlocalizedName("crying_obsidian");
    public static Block blockRose = new BlockRose().setUnlocalizedName("rose");

    public BlockLoader(FMLPreInitializationEvent event)
    {
        register(blockRuby, "block_ruby");
        register(blockOreRuby, "ore_ruby");
        register(blockSapphire, "block_sapphire");
        register(blockOreSapphire, "ore_sapphire");
        register(blockJade, "block_jade");
        register(blockOreJade, "ore_jade");
        register(blockGlowingObsidian, "glowing_obsidian");
        register(blockCryingObsidian, "crying_obsidian");
        register(blockRose, "rose");
    }

    private static void register(Block block, String name)
    {
        ForgeRegistries.BLOCKS.register(block.setRegistryName(name));
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        registerModel(block);
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Block block)
    {
        ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
    }
}