package com.romonov.mcmod.tweakscraft.gui.container;

import com.romonov.mcmod.tweakscraft.item.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ExcluderContainer extends Container {
    private ItemStackHandler items = new ItemStackHandler();

    public ExcluderContainer(EntityPlayer player) {
        super();
        drawPlayerInventory(player);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        ItemStack itemStack = new ItemStack(ItemLoader.EXCLUDER);
        return (itemStack.isItemEqual(playerIn.getHeldItem(EnumHand.MAIN_HAND)))
                || (itemStack.isItemEqual(playerIn.getHeldItem(EnumHand.OFF_HAND)));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        return null;
    }

    private void drawPlayerInventory(EntityPlayer player) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                int index = i * 9 + j;
                if (items.getSlots() > index) {
                    this.addSlotToContainer(new SlotItemHandler(items, index, 9 + j * 18, 18 + i * 18));
                }
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 9 + j * 18, 86 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player.inventory, i, 9 + i * 18, 144));
        }
    }
}
