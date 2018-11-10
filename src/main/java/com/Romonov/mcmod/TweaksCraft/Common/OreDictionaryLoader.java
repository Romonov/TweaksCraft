package com.Romonov.mcmod.TweaksCraft.Common;

import com.Romonov.mcmod.TweaksCraft.Block.BlockLoader;
import com.Romonov.mcmod.TweaksCraft.Item.ItemLoader;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryLoader {
    public OreDictionaryLoader(){
        OreDictionary.registerOre("ingotRuby", ItemLoader.ruby);
        OreDictionary.registerOre("blockRuby", BlockLoader.blockRuby);
        OreDictionary.registerOre("oreRuby", BlockLoader.blockOreRuby);
    }
}
