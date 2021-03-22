package fr.ynov.villager.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMod extends Block {

    public BlockMod(String name, Material materialIn, int harvestLevel) {
        super(materialIn);
        setHarvestLevel("pickaxe", harvestLevel);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}