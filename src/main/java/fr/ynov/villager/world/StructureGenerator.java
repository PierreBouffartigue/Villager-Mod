package fr.ynov.villager.world;

import fr.ynov.villager.Main;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class StructureGenerator extends Item {

    public StructureGenerator(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }

    public int getItemEnchantability() {
        return 0;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 0;
    }

    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
        return 1.0F;
    }


    public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c) {

        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(">>> Item used"));
        if(true){
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(">>> Item used"));
            boolean place = true;
            if(place){
                Block blk = Block.getBlockById(42);
                IBlockState blkState = blk.getDefaultState();

                BlockPos initialPos = new BlockPos(i,j,k);
                world.setBlockState(initialPos, blkState);
                initialPos = new BlockPos(i+1,j,k);
                world.setBlockState(initialPos, blkState);
                initialPos = new BlockPos(i+2,j,k);
                world.setBlockState(initialPos, blkState);
                initialPos = new BlockPos(i+3,j,k);
                world.setBlockState(initialPos, blkState);
                initialPos = new BlockPos(i+4,j,k);
                world.setBlockState(initialPos, blkState);
                initialPos = new BlockPos(i+5,j,k);
                world.setBlockState(initialPos, blkState);

            }

        }
        return true;
    }
}
