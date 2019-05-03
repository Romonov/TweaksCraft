package com.romonov.mcmod.tweakscraft.creativeTab;

import com.romonov.mcmod.tweakscraft.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabTweaksCraft extends CreativeTabs {
    public CreativeTabTweaksCraft() {
        super("tweakscraft");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemLoader.IRON_HOOK);
    }
}
