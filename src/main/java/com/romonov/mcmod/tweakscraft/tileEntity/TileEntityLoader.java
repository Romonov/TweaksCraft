package com.romonov.mcmod.tweakscraft.tileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityLoader {
    public TileEntityLoader() {
        register(TileEntityAccelerateTorch.class);
    }

    private void register(Class<? extends TileEntity> tileEntity) {
        GameRegistry.registerTileEntity(tileEntity, new ResourceLocation("tweakscraft"));
    }
}
