package fr.ynov.villager.blocks;

import fr.ynov.villager.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMod extends Block {

    public BlockMod(String name, Material materialIn, int harvestLevel) {
        super(materialIn);
        setHarvestLevel("pickaxe", harvestLevel);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}