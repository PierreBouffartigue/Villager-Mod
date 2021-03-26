package fr.ynov.villager.tools;


import fr.ynov.villager.Main;
import net.minecraft.item.ItemSpade;

public class ItemShovelMod extends ItemSpade {

    public ItemShovelMod(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);

    }
}
