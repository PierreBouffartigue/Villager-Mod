package fr.ynov.villager.tools;

import fr.ynov.villager.Main;
import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeMod extends ItemPickaxe {

    public ItemPickaxeMod(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
}
