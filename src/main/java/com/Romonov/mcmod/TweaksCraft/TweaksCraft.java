package com.Romonov.mcmod.TweaksCraft;

import com.Romonov.mcmod.TweaksCraft.Item.ItemLoader;
import com.Romonov.mcmod.TweaksCraft.Proxy.ProxyCommon;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = TweaksCraft.MODID,
        name = TweaksCraft.NAME,
        version = TweaksCraft.VERSION,
        acceptedMinecraftVersions = "1.12.2")
public class TweaksCraft
{
    public static final String MODID = "tweakscraft";
    public static final String NAME = "TweaksCraft";
    public static final String VERSION = "0.3.1";

    @Instance(TweaksCraft.MODID)
    public static TweaksCraft instance;

    @SidedProxy(clientSide = "com.Romonov.mcmod.TweaksCraft.Proxy.ProxyClient",
            serverSide = "com.Romonov.mcmod.TweaksCraft.Proxy.ProxyCommon")
    public static ProxyCommon proxy;

    private Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
        instance.getLogger().info("[TweaksCraft]Pre-Init finished!");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        instance.getLogger().info("[TweaksCraft]Init finished!");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
        instance.getLogger().info("[TweaksCraft]Post-Init finished!");

    }

    public Logger getLogger()
    {
        return logger;
    }
}
