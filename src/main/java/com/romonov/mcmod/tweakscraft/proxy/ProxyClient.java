package com.romonov.mcmod.tweakscraft.proxy;

import com.romonov.mcmod.tweakscraft.block.BlockLoader;
import com.romonov.mcmod.tweakscraft.item.ItemLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyCommon {
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        ItemLoader.registerModel();
        BlockLoader.registerModel();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}