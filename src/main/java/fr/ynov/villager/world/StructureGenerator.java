package fr.ynov.villager.world;


import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ynov.villager.Main;
//import jdk.nashorn.internal.parser.JSONParser;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.lwjgl.Sys;
import scala.actors.threadpool.TimeUnit;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StructureGenerator extends Item {
    Map map;
    JSONObject jo;
    ArrayList<String> listdata = new ArrayList<String>();
    JSONArray ja;
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

        try{

            //System.out.println("user.dir");
            //String test = System.getProperty("user.dir");
            //System.out.println(test);
            //ObjectMapper mapper = new ObjectMapper();

            //Code pour créer un JSON, le path par défaut est dans le run à la racine du projet
            //FileWriter file = new FileWriter("../src/main/resources/assets/villager/json/structure.json");
            //file.write("tt");
            //file.close();

            //map = mapper.readValue(Paths.get("../src/main/resources/assets/villager/json/structure.json").toFile(), Map.class);

            Object obj = new JSONParser().parse(new FileReader("../src/main/resources/assets/villager/json/structure.json"));
            jo = (JSONObject) obj;
            JSONArray ja = (JSONArray) jo.get("town hall");

            //get
            for (int i = 0; i < ja.size(); i++){
                listdata.add(ja.get(i).toString());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        ItemStack itemstack = player.getHeldItem(handIn);

        if (!player.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        //Minecraft.getMinecraft().player.sendMessage(new TextComponentString(">>> Item used"));


        int x = (int) Minecraft.getMinecraft().player.posX;
        int y = (int) Minecraft.getMinecraft().player.posY;
        int z = (int) Minecraft.getMinecraft().player.posZ;
        BlockPos initialPos = new BlockPos(x, y, z);







        for (int i=0 ;i < listdata.size(); i++){
            String[] parts = listdata.get(i).split(",");

            Block blk = Block.getBlockById(Integer.parseInt(parts[3]));
            IBlockState blkState = blk.getDefaultState();

            //initialPos = new BlockPos(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            initialPos = new BlockPos(x + Integer.parseInt(parts[0]) -1, y + Integer.parseInt(parts[1]), z + Integer.parseInt(parts[2]) +1);
            world.setBlockState(initialPos, blkState);
        }

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
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.onItemRightClick(world, player, handIn);
    }
}
