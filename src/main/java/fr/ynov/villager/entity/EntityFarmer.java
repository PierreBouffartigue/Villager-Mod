package fr.ynov.villager.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class EntityFarmer extends EntityCreature {
    public EntityFarmer(World worldIn) {
        super(worldIn);
        setCustomNameTag(getName());
    }
}