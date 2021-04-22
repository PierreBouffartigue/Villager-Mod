package fr.ynov.villager.world;


import com.fasterxml.jackson.databind.ObjectMapper;
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
import net.minecraft.world.World;

import java.nio.file.Paths;
import java.util.Map;

public class StructureGenerator extends Item {

    public StructureGenerator(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);

        try {

            System.out.println("user.dir");
            String test = System.getProperty("user.dir");
            System.out.println(test);
            ObjectMapper mapper = new ObjectMapper();

            //Code pour créer un JSON, le path par défaut est dans le run à la racine du projet
            //FileWriter file = new FileWriter("../src/main/resources/assets/villager/json/tt.json");
            //file.write("tt");
            //file.close();

            Map map = mapper.readValue(Paths.get("../src/main/resources/assets/villager/json/tt.json").toFile(), Map.class);
            //Minecraft.getMinecraft().player.sendMessage(new TextComponentString(map.toString()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getItemEnchantability() {
        return 0;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 0;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {

        ItemStack itemstack = player.getHeldItem(handIn);

        if (!player.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        //Minecraft.getMinecraft().player.sendMessage(new TextComponentString(">>> Item used"));
        Block blk = Block.getBlockById(98);
        IBlockState blkState = blk.getDefaultState();
        int x = (int) Minecraft.getMinecraft().player.posX;
        int y = (int) Minecraft.getMinecraft().player.posY;
        int z = (int) Minecraft.getMinecraft().player.posZ;

        BlockPos initialPos = new BlockPos(x, y, z);


        /**
         for (int i = 0; i < 6; i++){

         initialPos = new BlockPos(x +i, y -1, z);
         world.setBlockState(initialPos, blkState);

         // 3 * z
         for(int a = 1; a<3 ; a++){
         initialPos = new BlockPos(x +i, y -1, z + a);
         world.setBlockState(initialPos, blkState);
         }

         // 4 * y
         for(int a = 0; a<3 ; a++){
         initialPos = new BlockPos(x +i, y + a, z + 3);
         world.setBlockState(initialPos, blkState);
         }

         // 3 * -z
         for(int a = 1; a<3 ; a++){
         initialPos = new BlockPos(x +i, y -1, z - a);
         world.setBlockState(initialPos, blkState);
         }


         initialPos = new BlockPos(x +i, y -1, z -3);
         world.setBlockState(initialPos, blkState);

         // 4 * -y
         for(int a = 0; a<3 ; a++){
         initialPos = new BlockPos(x +i, y + a, z - 3);
         world.setBlockState(initialPos, blkState);
         }

         // 3 * z
         initialPos = new BlockPos(x +i, y -1, z);
         world.setBlockState(initialPos, blkState);
         for(int a = 1; a<3 ; a++){
         initialPos = new BlockPos(x +i, y -1, z + a);
         world.setBlockState(initialPos, blkState);
         }

         // 4 * -z
         for(int a = 0; a<3 ; a++){
         initialPos = new BlockPos(x +i, y + a, z + 3);
         world.setBlockState(initialPos, blkState);
         }

         // 3 * -z
         for(int a = 1; a<3 ; a++){
         initialPos = new BlockPos(x +i, y -1, z - a);
         world.setBlockState(initialPos, blkState);
         }

         initialPos = new BlockPos(x +i, y -1, z -3);
         world.setBlockState(initialPos, blkState);

         // 4 * y
         for(int a = 0; a<3 ; a++){
         initialPos = new BlockPos(x +i, y +a, z - 3);
         world.setBlockState(initialPos, blkState);
         }

         }*/

        world.setBlockState(initialPos, blkState);

        return super.onItemRightClick(world, player, handIn);
    }
}