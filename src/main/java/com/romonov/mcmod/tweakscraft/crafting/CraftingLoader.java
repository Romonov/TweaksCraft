package com.romonov.mcmod.tweakscraft.crafting;

import com.google.common.base.Predicate;
import com.romonov.mcmod.tweakscraft.block.BlockLoader;
import com.romonov.mcmod.tweakscraft.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;

public class CraftingLoader {
    public CraftingLoader() {
        RemoveRecipe(Items.FISHING_ROD);

        GameRegistry.addShapedRecipe(new ResourceLocation("iron_hook"),
                new ResourceLocation("tweakscraft"), new ItemStack(ItemLoader.IRON_HOOK),
                new Object[] {
                        "I  ",
                        "I I",
                        " I ",
                        'I', Items.IRON_NUGGET
                });
        GameRegistry.addShapedRecipe(new ResourceLocation("fishing_rod"),
                new ResourceLocation("tweakscraft"), new ItemStack(Items.FISHING_ROD),
                new Object[] {
                        "  W",
                        " WS",
                        "W I",
                        'W', Items.STICK,
                        'S', Items.STRING,
                        'I', ItemLoader.IRON_HOOK
                });
        GameRegistry.addShapedRecipe(new ResourceLocation("saddle"),
                new ResourceLocation("tweakscraft"), new ItemStack(Items.SADDLE),
                new Object[] {
                        "LLL",
                        "LIL",
                        "I I",
                        'L', Items.LEATHER,
                        'I', Items.IRON_INGOT
                });
        GameRegistry.addShapedRecipe(new ResourceLocation("accelerate_torch"),
                new ResourceLocation("tweakscraft"), new ItemStack(BlockLoader.ACCELERATE_TORCH),
                new Object[] {
                        " C ",
                        "CTC",
                        " C ",
                        'C', Items.CLOCK,
                        'T', Blocks.TORCH
                });
        GameRegistry.addShapelessRecipe(new ResourceLocation("red_dye"),
                new ResourceLocation("tweakscraft"), new ItemStack(Items.DYE, 1, 1),
                Ingredient.fromStacks(new ItemStack(BlockLoader.ROSE)));

        RegisterSmelting(Items.ROTTEN_FLESH, Items.LEATHER, 0.0F);
    }

    private void RemoveRecipe(Item item) {
        ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry) ForgeRegistries.RECIPES;
        for (IRecipe recipe : recipeRegistry) {
            if (recipe.getRecipeOutput().getItem() == item) {
                recipeRegistry.remove(recipe.getRegistryName());
            }
        }
    }

    private void RegisterSmelting(ItemStack input, ItemStack output, float xp) {
        GameRegistry.addSmelting(input, output, xp);
    }

    private void RegisterSmelting(Item input, Item output, float xp) {
        GameRegistry.addSmelting(input, new ItemStack(output), xp);
    }
}
