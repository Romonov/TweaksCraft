package com.romonov.mcmod.tweakscraft.event;

import com.romonov.mcmod.tweakscraft.item.ItemLoader;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventEntityItemPickUp {
    @SubscribeEvent
    public void onEntityItemPickUp(EntityItemPickupEvent event) {
        if (event.getEntityPlayer().inventory.hasItemStack(new ItemStack(ItemLoader.EXCLUDER))) {
            
        }
    }
}
