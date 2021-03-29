package fr.ynov.villager.container;

import fr.ynov.villager.Main;
import net.minecraft.block.BlockChest;

public class ChestMod extends BlockChest {
    public ChestMod(String name, Type chestTypeIn) {
        super(chestTypeIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
}
