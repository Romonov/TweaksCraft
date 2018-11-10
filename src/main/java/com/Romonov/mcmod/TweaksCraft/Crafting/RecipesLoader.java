package com.Romonov.mcmod.TweaksCraft.Crafting;

import com.Romonov.mcmod.TweaksCraft.Item.ItemLoader;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesLoader {
    public static void RecipesLoader() {
        GameRegistry.addShapedRecipe(
            new ResourceLocation("fishing_rod"), new ResourceLocation("tweakscraft"),
            new ItemStack(Items.FISHING_ROD),
            new Object[]{
                "  X",
                " XY",
                "X Z",
                Character.valueOf('X'), Items.STICK,
                Character.valueOf('Y'), Items.STRING,
                Character.valueOf('Z'), ItemLoader.ironHook
            }
        );
    }
}
