package com.romonov.mcmod.tweakscraft.gui;

import com.romonov.mcmod.tweakscraft.TweaksCraft;
import com.romonov.mcmod.tweakscraft.gui.client.ExcluderGuiContainer;
import com.romonov.mcmod.tweakscraft.gui.container.ExcluderContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;

public class GuiLoader implements IGuiHandler {
    public static final int GUI_EXCLUDER = 0;

    public GuiLoader() {
        NetworkRegistry.INSTANCE.registerGuiHandler(TweaksCraft.instance, this);
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_EXCLUDER:
                return new ExcluderContainer(player);
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_EXCLUDER:
                return new ExcluderGuiContainer(new ExcluderContainer(player));
            default:
                return null;
        }
    }
}
