package fr.ynov.villager.ia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.ynov.villager.bdd.JedisConnexion;
import fr.ynov.villager.bdd.MongoConnexion;
import fr.ynov.villager.world.Structure;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import org.bson.Document;
import redis.clients.jedis.Jedis;

public class IAConstructor extends EntityAIBase {
    protected final EntityCreature creature;
    protected double speed;
    protected int randPosX;
    protected int randPosY;
    protected int randPosZ;
    protected int timer = 20;
    MongoDatabase villagerDB = MongoConnexion.initMongo().getDatabase("villager");
    MongoCollection<Document> villager = villagerDB.getCollection("villager");
    Document vivi = villager.find().first();

    public IAConstructor(EntityCreature creature, double speedIn) {
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
        String bzc = j.get("constructor");
        if(bzc.equals("house")) {
            this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ - 6, this.speed);
            this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ - 12, this.speed);
            this.creature.getNavigator().noPath();
            if (timer == 0) {
                Structure.HouseStructure(this.creature, this.creature.world);
                timer = 30;
            } else {
                timer--;
            }
        }
        if(bzc.equals("farm")) {
            this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ - 6, this.speed);
            this.creature.getNavigator().tryMoveToXYZ(this.randPosX - 10, this.randPosY, this.randPosZ -6, this.speed);
            this.creature.getNavigator().noPath();
            if (timer == 0) {
                Structure.FarmStructure(this.creature, this.creature.world);
                timer = 30;
            } else {
                timer--;
            }
        }
    }


    public boolean shouldContinueExecuting() {
        return !this.creature.getNavigator().noPath();

    }

}
