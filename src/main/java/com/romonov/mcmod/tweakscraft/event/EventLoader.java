package com.romonov.mcmod.tweakscraft.event;

import net.minecraftforge.common.MinecraftForge;

public class EventLoader {
    public EventLoader() {
        MinecraftForge.EVENT_BUS.register(new EventEntityMount());
    }
}
