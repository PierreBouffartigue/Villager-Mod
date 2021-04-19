package fr.ynov.villager.world;

import fr.ynov.villager.Main;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
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

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {

        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(">>> Item used"));
        Block blk = Block.getBlockById(98);
        IBlockState blkState = blk.getDefaultState();
        int x = (int) Minecraft.getMinecraft().player.posX;
        int y = (int) Minecraft.getMinecraft().player.posY;
        int z = (int) Minecraft.getMinecraft().player.posZ;


        BlockPos initialPos = new BlockPos(x, y, z);
        world.setBlockState(initialPos, blkState);
        initialPos = new BlockPos(x + 1, y, z);
        world.setBlockState(initialPos, blkState);
        initialPos = new BlockPos(x + 2, y, z);
        world.setBlockState(initialPos, blkState);
        initialPos = new BlockPos(x + 3, y, z);
        world.setBlockState(initialPos, blkState);
        initialPos = new BlockPos(x + 4, y, z);
        world.setBlockState(initialPos, blkState);
        initialPos = new BlockPos(x + 5, y, z);
        world.setBlockState(initialPos, blkState);

        return super.onItemRightClick(world, player, handIn);
    }
}
