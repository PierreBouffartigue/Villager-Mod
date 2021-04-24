package fr.ynov.villager.entity;

import fr.ynov.villager.ia.IAFarmer;
import fr.ynov.villager.ia.IARest;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class EntityFarmer extends EntityCreature {
    public EntityFarmer(World worldIn) {
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
        this.tasks.addTask(1, new IAFarmer(this, 0.25D));
        this.tasks.addTask(2, new IARest(this, 0.23D));
        this.applyEntityAI();
    }
}