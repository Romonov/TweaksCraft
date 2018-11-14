package com.Romonov.mcmod.TweaksCraft.Item;

import com.Romonov.mcmod.TweaksCraft.Block.BlockLoader;
import com.Romonov.mcmod.TweaksCraft.TweaksCraft;

import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemLoader
{
    public static Item ruby = new ItemRuby().setUnlocalizedName("ruby");
    public static Item sapphire = new ItemSapphire().setUnlocalizedName("sapphire");
    public static Item jade = new ItemJade().setUnlocalizedName("jade");
    public static Item iceCharge = new ItemIceCharge().setUnlocalizedName("ice_charge");
    public static Item freezeRod = new ItemFreezeRod().setUnlocalizedName("freeze_rod");
    public static Item freezePowder = new ItemFreezePowder().setUnlocalizedName("freeze_powder");
    public static Item ironHook = new ItemIronHook().setUnlocalizedName("iron_hook");

    public ItemLoader(FMLPreInitializationEvent event)
    {
        register(ruby, "ruby");
        register(sapphire, "sapphire");
        register(jade, "jade");
        register(iceCharge, "ice_charge");
        register(freezeRod, "freeze_rod");
        register(freezePowder, "freeze_powder");
        register(ironHook, "iron_hook");
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }

    private static void register(Item item, String name)
    {
        ForgeRegistries.ITEMS.register(item.setRegistryName(name));
        TweaksCraft.instance.getLogger().info("[TweaksCraft]Item " + name + " registered!");
        registerModel(item);
    }
}