package com.romonov.mcmod.tweakscraft.core;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class ItemStackHandlerExcluder extends ItemStackHandler {
    public ItemStackHandlerExcluder() {
        super(27);
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        validateSlotIndex(slot);
        super.setStackInSlot(slot, ItemHandlerHelper.copyStackWithSize(stack, 1));
        return false;
    }

    @Override
    @Nonnull
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        validateSlotIndex(slot);

        this.setStackInSlot(slot, ItemStack.EMPTY);
        onContentsChanged(slot);

        return ItemStack.EMPTY;
    }
}
