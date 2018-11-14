package com.Romonov.mcmod.TweaksCraft.Block;

import com.Romonov.mcmod.TweaksCraft.CreativeTab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCryingObsidian extends Block {
    public BlockCryingObsidian() {
        super(Material.ROCK);
        this.setHarvestLevel("pickaxe", 3);
        this.setCreativeTab(CreativeTabsLoader.tabTweaksCraft);
    }
}
