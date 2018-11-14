package com.Romonov.mcmod.TweaksCraft.Proxy;

import com.Romonov.mcmod.TweaksCraft.Block.BlockLoader;
import com.Romonov.mcmod.TweaksCraft.Common.ConfigLoader;
import com.Romonov.mcmod.TweaksCraft.Common.OreDictionaryLoader;
import com.Romonov.mcmod.TweaksCraft.Crafting.RecipesLoader;
import com.Romonov.mcmod.TweaksCraft.Crafting.SmeltingLoader;
import com.Romonov.mcmod.TweaksCraft.Item.ItemLoader;
import com.Romonov.mcmod.TweaksCraft.Crafting.RecipesRemover;
import com.Romonov.mcmod.TweaksCraft.WorldGen.WorldGenLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyCommon {
    public void preInit(FMLPreInitializationEvent event)
    {
        new ItemLoader(event);
        new BlockLoader(event);
        new OreDictionaryLoader();
        new ConfigLoader(event);
    }

    public void init(FMLInitializationEvent event)
    {
        WorldGenLoader.init();
        RecipesRemover.RemoveRecipe();
        RecipesLoader.RecipesLoader();
        SmeltingLoader.SmeltingLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
