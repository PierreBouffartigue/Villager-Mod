package fr.ynov.villager.items;

import fr.ynov.villager.Main;
import net.minecraft.item.Item;

public class ItemMod extends Item {
    public ItemMod(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
}