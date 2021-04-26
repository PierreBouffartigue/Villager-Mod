package fr.ynov.villager.entity;

import fr.ynov.villager.bdd.JedisConnexion;
import fr.ynov.villager.ia.IACweep;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import redis.clients.jedis.Jedis;

public class EntityCweep extends EntitySpider {

    public EntityCweep(World worldIn) {
        super(worldIn);
        this.setSize(1.4F, 0.9F);
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        Jedis j = JedisConnexion.initJedis().getResource();
        j.select(1);
        String rep = j.get("reputation");
        int repu = Integer.parseInt(rep);
        int newRepu = repu + 20;
        j.set("reputation", Integer.toString(newRepu));
        Minecraft.getMinecraft().player.sendChatMessage("20 Points de réputation gagnés");
    }


    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192192896D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    protected void applyEntityAI() {
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityMayor.class, false));
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new IACweep(this, 2, false));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.applyEntityAI();
    }
}