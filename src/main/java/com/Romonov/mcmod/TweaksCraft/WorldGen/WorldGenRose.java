package com.Romonov.mcmod.TweaksCraft.WorldGen;

import com.Romonov.mcmod.TweaksCraft.Block.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;


public class WorldGenRose extends WorldGenerator {
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {

        BlockBush flower = BlockLoader.blockRose;

        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && flower.canBlockStay(worldIn, blockpos, flower.getDefaultState()))
            {
                worldIn.setBlockState(blockpos, flower.getDefaultState(), 2);
            }
        }

        return true;
    }
}
