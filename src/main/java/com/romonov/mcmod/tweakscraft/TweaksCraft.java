package com.romonov.mcmod.tweakscraft;

import com.romonov.mcmod.tweakscraft.proxy.ProxyCommon;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TweaksCraft.MODID,
        name = TweaksCraft.NAME,
        version = TweaksCraft.VERSION,
        acceptedMinecraftVersions = "1.12.2")
public class TweaksCraft {
    public static final String MODID = "tweakscraft";
    public static final String NAME = "Old Batter Backpacks";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(TweaksCraft.MODID)
    public static TweaksCraft instance;

    @SidedProxy(clientSide = "com.romonov.mcmod.tweakscraft.proxy.ProxyClient",
            serverSide = "com.romonov.mcmod.tweakscraft.proxy.ProxyServer")
    public static ProxyCommon proxy;

    private Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
        instance.getLogger().info("[Tweaks Craft] Pre-Init finished!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        instance.getLogger().info("[Tweaks Craft] Init finished!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
        instance.getLogger().info("[Tweaks Craft] Post-Init finished!");
    }

    public Logger getLogger()
    {
        return logger;
    }
}