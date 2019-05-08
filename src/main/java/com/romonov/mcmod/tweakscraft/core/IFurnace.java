package com.romonov.mcmod.tweakscraft.core;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.IHopper;

public abstract interface IFurnace extends ISidedInventory, IHopper
{
    public abstract byte getFacing();
    public abstract ItemStack[] getSmeltingResult(ItemStack paramItemStack);
    public abstract boolean hasExtraStorage();
    public abstract boolean hasUpgrade(Item paramItem);
    public abstract boolean hasElectricUpgrade();
    public abstract ItemStack getUpgrade(Item paramItem);
}
