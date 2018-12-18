package com.Romonov.mcmod.TweaksCraft.Block;

import com.Romonov.mcmod.TweaksCraft.CreativeTab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
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
    public static Block blockRuby = new BlockRuby();
    public static Block blockOreRuby = new BlockOreRuby();
    public static Block blockSapphire = new BlockSapphire();
    public static Block blockOreSapphire = new BlockOreSapphire();
    public static Block blockJade = new BlockJade();
    public static Block blockOreJade = new BlockOreJade();
    public static Block blockGlowingObsidian = new BlockGlowingObsidian();
    public static Block blockCryingObsidian = new BlockCryingObsidian();
    public static BlockBush blockRose = (BlockBush) new BlockRose();

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
        ForgeRegistries.BLOCKS.register(block.setUnlocalizedName(name));
        ForgeRegistries.BLOCKS.register(block.setCreativeTab(CreativeTabsLoader.tabTweaksCraft));

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