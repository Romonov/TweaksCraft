package com.Romonov.mcmod.TweaksCraft.Block;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockRose extends BlockBush {
    public BlockRose() {
        super(Material.PLANTS);
        this.setSoundType(SoundType.GROUND);;
    }
}
