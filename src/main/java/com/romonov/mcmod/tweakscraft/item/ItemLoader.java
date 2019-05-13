package com.romonov.mcmod.tweakscraft.item;

import com.romonov.mcmod.tweakscraft.TweaksCraft;
import com.romonov.mcmod.tweakscraft.creativeTab.CreativeTabLoader;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemLoader
{
    public static Item IRON_HOOK = new ItemIronHook();
    public static Item EXCLUDER = new ItemExcluder();


    public ItemLoader()
    {
        register(IRON_HOOK, "iron_hook");
        register(EXCLUDER, "excluder");
    }

    public static void registerModel() {
        registerModel(IRON_HOOK);
        registerModel(EXCLUDER);
    }

    private static void register(Item item, String name)
    {
        ForgeRegistries.ITEMS.register(item.setRegistryName(name).setUnlocalizedName(name).setCreativeTab(CreativeTabLoader.TAB_TWEAKS_CRAFT));
    }

    private static void registerModel(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }
}
