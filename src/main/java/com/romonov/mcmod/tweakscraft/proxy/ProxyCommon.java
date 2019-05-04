package com.romonov.mcmod.tweakscraft.proxy;

import com.romonov.mcmod.tweakscraft.block.BlockLoader;
import com.romonov.mcmod.tweakscraft.crafting.CraftingLoader;
import com.romonov.mcmod.tweakscraft.event.EventLoader;
import com.romonov.mcmod.tweakscraft.item.ItemLoader;
import com.romonov.mcmod.tweakscraft.tileEntity.TileEntityLoader;
import com.romonov.mcmod.tweakscraft.world.gen.WorldGenLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyCommon {
    public void preInit(FMLPreInitializationEvent event)
    {
        new ItemLoader();
        new BlockLoader();
        new TileEntityLoader();
    }

    public void init(FMLInitializationEvent event)
    {
        new CraftingLoader();
        new EventLoader();
        new WorldGenLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}