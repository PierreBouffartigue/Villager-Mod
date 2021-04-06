package fr.ynov.villager.entity;

import fr.ynov.villager.gui.GuiVillager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityMayor extends EntityCreature {
    public EntityMayor(World worldIn) {
        super(worldIn);
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiVillager(Minecraft.getMinecraft(), this));
        return false;
    }
}
