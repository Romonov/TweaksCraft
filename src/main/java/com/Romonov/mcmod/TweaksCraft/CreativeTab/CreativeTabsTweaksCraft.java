package com.Romonov.mcmod.TweaksCraft.CreativeTab;

import com.Romonov.mcmod.TweaksCraft.Item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsTweaksCraft extends CreativeTabs {

    public CreativeTabsTweaksCraft(){
        super("tweakscraft");
    }

    @Override
    public ItemStack getTabIconItem(){
        return new ItemStack(ItemLoader.ruby);
    }
}
