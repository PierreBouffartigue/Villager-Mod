package fr.ynov.villager.entity;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.ynov.villager.bdd.JedisConnexion;
import fr.ynov.villager.bdd.MongoConnexion;
import fr.ynov.villager.gui.GuiVillagerMain;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.bson.Document;
import redis.clients.jedis.Jedis;

import javax.annotation.ParametersAreNonnullByDefault;

public class EntityMayor extends EntityCreature {
    public EntityMayor(World worldIn) {
        super(worldIn);
        setCustomNameTag(getName());
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        MongoDatabase villagerDB = MongoConnexion.initMongo().getDatabase("villager");
        MongoCollection<Document> villager = villagerDB.getCollection("villager");
        villager.drop();
        Jedis j = JedisConnexion.initJedis().getResource();
        j.select(1);
        j.set("bronzeCoin", "0");
        j.set("silverCoin", "0");
        j.set("stone", "0");
        Minecraft.getMinecraft().player.sendChatMessage("Maire tué, village supprimé des bases de données");
    }

    @ParametersAreNonnullByDefault
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiVillagerMain(Minecraft.getMinecraft(), this));
        return false;
    }

    protected void applyEntityAI() {
    }

    @Override
    protected void initEntityAI() {
        this.applyEntityAI();
    }
}
