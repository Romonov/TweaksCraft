package com.Romonov.mcmod.TweaksCraft.Block;

import com.Romonov.mcmod.TweaksCraft.CreativeTab.CreativeTabsLoader;
import com.Romonov.mcmod.TweaksCraft.Item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockOreJade extends Block {
    public BlockOreJade() {
        super(Material.ROCK);
        this.setSoundType(SoundType.STONE);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(CreativeTabsLoader.tabTweaksCraft);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ItemLoader.jade;
    }

    public ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(BlockLoader.blockOreJade);
    }

    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);

        if (this.getItemDropped(state, worldIn.rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 1 + worldIn.rand.nextInt(5);
            this.dropXpOnBlockBreak(worldIn, pos, i);
        }
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
}
