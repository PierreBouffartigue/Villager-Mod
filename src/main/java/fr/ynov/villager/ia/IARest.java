package fr.ynov.villager.ia;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.Vec3d;

public class IARest extends EntityAIBase {
    protected final EntityCreature creature;
    protected double speed;
    protected double randPosX;
    protected double randPosY;
    protected double randPosZ;
    protected int timer = 0;

    public IARest(EntityCreature creature, double speedIn) {
        this.creature = creature;
        this.speed = speedIn;
        this.setMutexBits(1);
    }


    public boolean shouldExecute() {
        return this.findPath();
    }

    protected boolean findPath() {
        Vec3d vec3d = RandomPositionGenerator.findRandomTarget(this.creature, 1, 4);

        if (vec3d == null) {
            return false;
        } else {
            this.randPosX = vec3d.x;
            this.randPosY = vec3d.y;
            this.randPosZ = vec3d.z;
            return true;
        }
    }


    public void startExecuting() {
        if (timer == 0) {
            this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
            timer = 100;
        } else {
            timer--;
        }
    }


    public boolean shouldContinueExecuting() {
        return !this.creature.getNavigator().noPath();
    }

}