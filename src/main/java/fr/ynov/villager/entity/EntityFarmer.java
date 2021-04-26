package fr.ynov.villager.entity;

import fr.ynov.villager.bdd.JedisConnexion;
import fr.ynov.villager.ia.IAFarmer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import redis.clients.jedis.Jedis;

import javax.annotation.ParametersAreNonnullByDefault;

public class EntityFarmer extends EntityCreature {
    public EntityFarmer(World worldIn) {
        super(worldIn);
        setCustomNameTag(getName());
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        Jedis j = JedisConnexion.initJedis().getResource();
        j.select(1);
        String rep = j.get("reputation");
        int repu = Integer.parseInt(rep);
        int newRepu = repu - 5;
        j.set("reputation", Integer.toString(newRepu));
        Minecraft.getMinecraft().player.sendChatMessage("5 Points de réputation perdus");
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
        this.tasks.addTask(1, new IAFarmer(this, 0.30D));
        this.applyEntityAI();
    }
}