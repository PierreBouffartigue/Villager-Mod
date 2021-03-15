package fr.ynov.villager.blocks;

import fr.ynov.villager.init.BlocksMod;
import fr.ynov.villager.init.ItemsMod;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class BlockOreMod extends BlockOre {
    private static boolean multipleQuantity = false;
    private static int minDrop;
    private static int maxDrop;

    public BlockOreMod(String name, int harvestLevel) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setHarvestLevel("pickaxe", harvestLevel);
    }

    public BlockOreMod(String name, int harvestLevel, int minDrop, int maxDrop) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setHarvestLevel("pickaxe", harvestLevel);
        multipleQuantity = true;
        BlockOreMod.minDrop = minDrop;
        BlockOreMod.maxDrop = maxDrop;
    }

    @ParametersAreNonnullByDefault
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (this == BlocksMod.copper_ore) {
            return ItemsMod.saphire;
        } else {
            return Item.getItemFromBlock(this);
        }
    }

    public int quantityDropped(Random rand) {
        return multipleQuantity ? minDrop + rand.nextInt(maxDrop - minDrop) : 1;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World) world).rand : new Random();

        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            if (this == BlocksMod.copper_ore) {
                return MathHelper.getInt(rand, 1, 5);
            }
        }

        return 0;
    }
}