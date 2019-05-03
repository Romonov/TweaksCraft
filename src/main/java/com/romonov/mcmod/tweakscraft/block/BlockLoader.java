package com.romonov.mcmod.tweakscraft.block;

import com.romonov.mcmod.tweakscraft.creativeTab.CreativeTabLoader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader {
    public static Block ACCELERATE_TORCH = new BlockAccelerateTorch().setUnlocalizedName("accelerateTorch");

    public BlockLoader()
    {
        register(ACCELERATE_TORCH, "accelerate_torch");
    }

    private static void register(Block block, String name)
    {
        ForgeRegistries.BLOCKS.register(block.setRegistryName(name).setUnlocalizedName(name).setCreativeTab(CreativeTabLoader.TAB_TWEAKS_CRAFT));
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
