package com.Romonov.mcmod.TweaksCraft.Crafting;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class RecipesRemover {
    public static void RemoveRecipe(){
        RecipesRemover(Items.FISHING_ROD);
    }

    static void RecipesRemover(Item item){
        ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry) ForgeRegistries.RECIPES;
        for (IRecipe recipe : recipeRegistry) {
            if (recipe.getRecipeOutput().getItem() == item) {
                recipeRegistry.remove(recipe.getRegistryName());
            }
        }
    }
}
