package fr.ynov.villager.ia;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class IAConstructor extends EntityAIBase {
    protected final EntityCreature creature;
    protected double speed;
    protected int randPosX;
    protected int randPosY;
    protected int randPosZ;
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
        return false;
    }


    public void startExecuting() {
        this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ - 6, this.speed);
        this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ - 12, this.speed);
        Structure.HouseStructure(this.creature, this.creature.world);
    }


    public boolean shouldContinueExecuting() {
        return !this.creature.getNavigator().noPath();
    }

}
