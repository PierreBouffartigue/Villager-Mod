package fr.ynov.villager.ia;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class IAFarmer extends EntityAIBase {
    protected final EntityCreature creature;
    protected double speed;
    protected double randPosX;
    protected double randPosY;
    protected double randPosZ;

    public IAFarmer(EntityCreature creature, double speedIn) {
        this.creature = creature;
        this.speed = speedIn;
        this.setMutexBits(1);
    }

    /**
        Faire l'IA avec des coordonnées fixes, j'ajouterais la partie coordonnées de Mongo après. Et le faire farm
        et ramener les blocs (print quand il doit ramener) j'ajouterais redis
     */

    public boolean shouldExecute() {
        return this.findPath();
    }

    protected boolean findPath() {
        return false;
    }


    public void startExecuting() {
    }


    public boolean shouldContinueExecuting() {
        return false;
    }

}
