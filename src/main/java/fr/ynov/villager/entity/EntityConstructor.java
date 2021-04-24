package fr.ynov.villager.entity;

import fr.ynov.villager.ia.IAConstructor;
import fr.ynov.villager.ia.IARest;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class EntityConstructor extends EntityCreature {
    public EntityConstructor(World worldIn) {
        super(worldIn);
        setCustomNameTag(getName());
    }

    @ParametersAreNonnullByDefault
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(">>> Occupé"));
        return false;
    }

    protected void applyEntityAI() {
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new IAConstructor(this,0.25D));
        this.applyEntityAI();
    }
}