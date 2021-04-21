package fr.ynov.villager.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EntityFarmer extends EntityCreature {
    public EntityFarmer(World worldIn) {
        super(worldIn);
        setCustomNameTag(getName());
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(">>> Occupé"));
        return false;
    }
}