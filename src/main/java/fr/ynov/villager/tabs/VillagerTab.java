package fr.ynov.villager.tabs;

import fr.ynov.villager.References;
import fr.ynov.villager.init.ItemsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VillagerTab extends CreativeTabs {

    public VillagerTab() {
        super(References.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemsMod.viande);
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }
}
