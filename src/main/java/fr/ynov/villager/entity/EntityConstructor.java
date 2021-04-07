package fr.ynov.villager.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class EntityConstructor extends EntityCreature {
    public EntityConstructor(World worldIn) {
        super(worldIn);
        setCustomNameTag(getName());
    }
}