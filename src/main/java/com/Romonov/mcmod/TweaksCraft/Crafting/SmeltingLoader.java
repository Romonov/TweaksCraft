package com.Romonov.mcmod.TweaksCraft.Crafting;

import com.Romonov.mcmod.TweaksCraft.Block.BlockLoader;
import com.Romonov.mcmod.TweaksCraft.Item.ItemLoader;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingLoader {
    public static void SmeltingLoader(){
        GameRegistry.addSmelting(BlockLoader.blockOreRuby, new ItemStack(ItemLoader.ruby), 0.5F);
        GameRegistry.addSmelting(BlockLoader.blockOreSapphire, new ItemStack(ItemLoader.sapphire), 0.5F);
    }
}
