package fr.ynov.villager.util.handler;

import fr.ynov.villager.References;
import fr.ynov.villager.container.ContainerChestMod;
import fr.ynov.villager.container.TileEntityChestMod;
import fr.ynov.villager.gui.GuiChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import java.util.Objects;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == References.GUI_SILVER_CHEST) return new ContainerChestMod(player.inventory, (TileEntityChestMod) Objects.requireNonNull(world.getTileEntity(new BlockPos(x, y, z))), player);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == References.GUI_SILVER_CHEST) return new GuiChest(player.inventory, (TileEntityChestMod)world.getTileEntity(new BlockPos(x,y,z)), player);
        return null;
    }
}
