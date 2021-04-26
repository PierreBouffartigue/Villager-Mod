package fr.ynov.villager.tools;


import fr.ynov.villager.Main;
import net.minecraft.item.ItemSword;

public class ItemSwordMod extends ItemSword {

    public ItemSwordMod(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
}
