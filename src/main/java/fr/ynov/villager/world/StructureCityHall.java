package fr.ynov.villager.world;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import fr.ynov.villager.Main;
import fr.ynov.villager.bdd.MongoConnexion;
import fr.ynov.villager.entity.EntityConstructor;
import fr.ynov.villager.entity.EntityMayor;
import fr.ynov.villager.init.BlocksMod;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class StructureCityHall extends Item {
    JSONObject jo;
    ArrayList<String> listdata = new ArrayList<String>();

    public StructureCityHall(String name) {
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
        if (!world.isRemote) {
            try {
                Object obj = new JSONParser().parse(new FileReader("../src/main/resources/assets/villager/json/cityhall.json"));
                jo = (JSONObject) obj;
                JSONArray ja = (JSONArray) jo.get("town hall");


                for (Object o : ja) {
                    listdata.add(o.toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            ItemStack itemstack = player.getHeldItem(handIn);

            if (!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            int x = (int) Minecraft.getMinecraft().player.posX;
            int y = (int) Minecraft.getMinecraft().player.posY;
            int z = (int) Minecraft.getMinecraft().player.posZ;
            BlockPos initialPos = new BlockPos(x, y, z);

            for (String listdatum : listdata) {
                String[] parts = listdatum.split(",");

                Block blk = Block.getBlockById(Integer.parseInt(parts[3]));
                IBlockState blkState = blk.getDefaultState();

                initialPos = new BlockPos(x + Integer.parseInt(parts[0]) - 1, y + Integer.parseInt(parts[1]), z + Integer.parseInt(parts[2]) + 1);
                world.setBlockState(initialPos, blkState);
            }

            initialPos = new BlockPos(x - 1 , y , z + 6);
            Block blk = BlocksMod.silver_chest;
            IBlockState blkState = blk.getDefaultState();
            world.setBlockState(initialPos, blkState);

            player.getCooldownTracker().setCooldown(this, 50);



            EntityMayor mayor = new EntityMayor(world);
            mayor.setLocationAndAngles(Minecraft.getMinecraft().player.posX + 1.5, Minecraft.getMinecraft().player.posY + 1.0 + mayor.getYOffset(), Minecraft.getMinecraft().player.posZ + 6.0, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
            world.spawnEntity(mayor);

            EntityConstructor constructor = new EntityConstructor(world);
            constructor.setLocationAndAngles(Minecraft.getMinecraft().player.posX - 1.0, Minecraft.getMinecraft().player.posY + 1.0 + constructor.getYOffset(), Minecraft.getMinecraft().player.posZ + 6.0, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
            world.spawnEntity(constructor);

            //Redis / Jedis

            /**
            //MongoDB
            MongoDatabase villagerDB = MongoConnexion.initMongo().getDatabase("villager");
            MongoCollection<Document> villager = villagerDB.getCollection("villager");
            villager.drop();
            Document village = new Document("name", "MyVillage")
                    .append("x", x + 1)
                    .append("y", y)
                    .append("z", z + 4)
                    .append("farm", "none")
                    .append("house", "none");
            villager.insertOne(village);

            Document vivi = villager.find(new Document(village)).first();
            assert vivi != null;
            Minecraft.getMinecraft().player.sendChatMessage(vivi.toJson());
             **/
        }
        return super.onItemRightClick(world, player, handIn);
    }
}
