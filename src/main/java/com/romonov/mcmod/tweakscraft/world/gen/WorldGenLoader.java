package com.romonov.mcmod.tweakscraft.world.gen;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenLoader {
    public WorldGenLoader() {
        GameRegistry.registerWorldGenerator(new WorldGenRose(), 1);
    }
}
