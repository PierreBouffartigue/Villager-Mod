package fr.ynov.villager.ia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.ynov.villager.bdd.JedisConnexion;
import fr.ynov.villager.bdd.MongoConnexion;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import org.bson.Document;
import redis.clients.jedis.Jedis;

public class IAFarmer extends EntityAIBase {
    protected final EntityCreature creature;
    protected double speed;
    protected int randPosX;
    protected int randPosY;
    protected int randPosZ;
    protected int count = 0;
    protected int timer = 180;
    MongoDatabase villagerDB = MongoConnexion.initMongo().getDatabase("villager");
    MongoCollection<Document> villager = villagerDB.getCollection("villager");
    Document vivi = villager.find().first();

    public IAFarmer(EntityCreature creature, double speedIn) {
        this.creature = creature;
        this.speed = speedIn;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        return this.findPath();
    }


    protected boolean findPath() {

        String ViviX = vivi.get("x").toString();
        String ViviY = vivi.get("y").toString();
        String ViviZ = vivi.get("z").toString();
        int ViviX2 = Integer.parseInt(ViviX);
        int ViviY2 = Integer.parseInt(ViviY);
        int ViviZ2 = Integer.parseInt(ViviZ);

        this.randPosX = ViviX2;
        this.randPosY = ViviY2;
        this.randPosZ = ViviZ2;

        return true;
    }

    public void startExecuting() {
        Jedis j = JedisConnexion.initJedis().getResource();
        j.select(1);
        String stn = j.get("stone");
        int stone = Integer.parseInt(stn);
        timer--;
        if (timer > 120) {

            this.creature.getNavigator().tryMoveToXYZ(this.randPosX - 16, this.randPosY, this.randPosZ - 7, this.speed);
        }
        else if (timer > 60) {
            this.creature.getNavigator().tryMoveToXYZ(this.randPosX - 16, this.randPosY, this.randPosZ - 14, this.speed);
        }
        else if (timer > 0) {
            this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
        }
        else {
            timer = 180;
            int stoneBuyInt = stone + 2;
            j.set("stone", Integer.toString(stoneBuyInt));
        }
    }


    public boolean shouldContinueExecuting() {
        return !this.creature.getNavigator().noPath();
    }

}