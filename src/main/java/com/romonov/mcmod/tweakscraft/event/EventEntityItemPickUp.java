package com.romonov.mcmod.tweakscraft.event;

import com.romonov.mcmod.tweakscraft.TweaksCraft;
import com.romonov.mcmod.tweakscraft.item.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

public class EventEntityItemPickUp {
    @SubscribeEvent
    public void onEntityItemPickUp(EntityItemPickupEvent event) {
        if (event.getEntityPlayer() == null) {
            return;
        }

        ItemStack itemExcluder = new ItemStack(ItemLoader.EXCLUDER);
        if (event.getEntityPlayer().inventory.hasItemStack(itemExcluder)) {
            EntityPlayer player = event.getEntityPlayer();
            ArrayList<ItemStack> items = new ArrayList<ItemStack>() {};
            items.addAll(player.inventory.mainInventory);
            items.addAll(player.inventory.armorInventory);
            items.addAll(player.inventory.offHandInventory);

            for (ItemStack item : items) {
                if (item.isItemEqual(itemExcluder) && item.hasTagCompound()) {
                    NBTTagCompound nbt = item.getTagCompound();
                    if (nbt != null && nbt.hasKey("Excludes")) {
                        NBTTagList list = nbt.getCompoundTag("Excludes").getTagList("Items", Constants.NBT.TAG_COMPOUND);
                        for (int i = 0; i < list.tagCount(); i++) {
                            if (event.getItem().getItem().isItemEqual(new ItemStack(list.getCompoundTagAt(i)))) {
                                event.setCanceled(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
