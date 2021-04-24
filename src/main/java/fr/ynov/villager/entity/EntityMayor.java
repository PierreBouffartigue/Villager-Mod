package fr.ynov.villager.entity;

import fr.ynov.villager.gui.GuiVillagerMain;
import fr.ynov.villager.ia.IAConstructor;
import fr.ynov.villager.ia.IARest;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class EntityMayor extends EntityCreature {
    public EntityMayor(World worldIn) {
        super(worldIn);
        setCustomNameTag(getName());
    }

    @ParametersAreNonnullByDefault
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiVillagerMain(Minecraft.getMinecraft(), this));
        return false;
    }

    protected void applyEntityAI() {
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(2, new IARest(this, 0.23D));
        this.applyEntityAI();
    }
}
