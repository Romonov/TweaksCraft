package com.romonov.mcmod.tweakscraft.gui.container;

import com.romonov.mcmod.tweakscraft.core.ItemStackHandlerExcluder;
import com.romonov.mcmod.tweakscraft.item.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraftforge.items.SlotItemHandler;

public class ExcluderContainer extends Container {
    private ItemStackHandlerExcluder items = new ItemStackHandlerExcluder();

    public ExcluderContainer(EntityPlayer playerIn) {
        super();

        if (playerIn.isServerWorld()) {
            ItemStack item = getExcluder(playerIn);
            if (item == null) {
                return;
            }
            NBTTagCompound nbt = null;

            if (item.hasTagCompound()) {
                nbt = item.getTagCompound();
                if (nbt != null) {
                    items.deserializeNBT(nbt.getCompoundTag("Excludes"));
                }
            }
        }

        drawPlayerInventory(playerIn);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        ItemStack itemStack = new ItemStack(ItemLoader.EXCLUDER);
        return (itemStack.isItemEqual(playerIn.getHeldItem(EnumHand.MAIN_HAND)))
                || (itemStack.isItemEqual(playerIn.getHeldItem(EnumHand.OFF_HAND)));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);

        if (playerIn.isServerWorld()) {
            ItemStack item = getExcluder(playerIn);
            if (item == null) {
                return;
            }

            NBTTagCompound nbt = null;

            if (item.hasTagCompound()) {
                nbt = item.getTagCompound();
            } else {
                nbt = new NBTTagCompound();
            }

            if (nbt != null) {
                nbt.setTag("Excludes", items.serializeNBT());
                item.setTagCompound(nbt);
            }
        }
    }

    private ItemStack getExcluder(EntityPlayer playerIn) {
        ItemStack itemStack = new ItemStack(ItemLoader.EXCLUDER);
        ItemStack itemMainHand = playerIn.getHeldItem(EnumHand.MAIN_HAND);
        ItemStack itemOffHand = playerIn.getHeldItem(EnumHand.OFF_HAND);
        if (itemStack.isItemEqual(itemMainHand)) {
            return itemMainHand;
        } else if (itemStack.isItemEqual(itemOffHand)) {
            return itemOffHand;
        }
        return null;
    }

    private void drawPlayerInventory(EntityPlayer playerIn) {
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
                this.addSlotToContainer(new Slot(playerIn.inventory, j + i * 9 + 9, 9 + j * 18, 86 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerIn.inventory, i, 9 + i * 18, 144));
        }
    }
}
