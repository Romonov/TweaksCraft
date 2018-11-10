package com.Romonov.mcmod.TweaksCraft.Block;

import com.Romonov.mcmod.TweaksCraft.CreativeTab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSapphire extends Block {
    public BlockSapphire() {
        super(Material.ROCK);
        this.setSoundType(SoundType.STONE);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(CreativeTabsLoader.tabTweaksCraft);
    }
}

