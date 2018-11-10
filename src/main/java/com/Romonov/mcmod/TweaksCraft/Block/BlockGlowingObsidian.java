package com.Romonov.mcmod.TweaksCraft.Block;

import com.Romonov.mcmod.TweaksCraft.CreativeTab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockGlowingObsidian extends Block {
    public BlockGlowingObsidian() {
        super(Material.ROCK);
        this.setSoundType(SoundType.STONE);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 3);
        this.setCreativeTab(CreativeTabsLoader.tabTweaksCraft);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(Blocks.OBSIDIAN);
    }

}
