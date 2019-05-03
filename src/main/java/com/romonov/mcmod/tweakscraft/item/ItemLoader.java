package com.romonov.mcmod.tweakscraft.item;

import com.romonov.mcmod.tweakscraft.TweaksCraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
    public static Item IRON_HOOK = new ItemIronHook().setUnlocalizedName("ironHook");

    public ItemLoader() {
        register(IRON_HOOK, "iron_hook");
    }

    private static void register(Item item, String name)
    {
        ForgeRegistries.ITEMS.register(item.setRegistryName(name));
        TweaksCraft.instance.getLogger().info("[Tweaks Craft] sItem " + name + " registered!");
        registerModel(item);
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }
}
