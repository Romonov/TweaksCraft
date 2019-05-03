package com.romonov.mcmod.tweakscraft.event;

import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventEntityMount {
    @SubscribeEvent
    public void onEntityMount(EntityMountEvent event) {
        if (event.getEntityMounting() instanceof EntityPlayer
                && event.getEntityBeingMounted() instanceof EntityPig
                && ((EntityPig) event.getEntityBeingMounted()).getSaddled()
                && event.getEntityMounting().isSneaking()
                && !event.getEntityBeingMounted().isBeingRidden()) {
            event.setCanceled(true);
            ((EntityPlayer) event.getEntityMounting()).addItemStackToInventory(new ItemStack(Items.SADDLE));
            ((EntityPig) event.getEntityBeingMounted()).setSaddled(false);
        }
    }
}
