package fr.ynov.villager.util.handler;

import fr.ynov.villager.References;
import fr.ynov.villager.blocks.ContainerCoinCreator;
import fr.ynov.villager.blocks.TileCoinCreator;
import fr.ynov.villager.container.ContainerChestMod;
import fr.ynov.villager.container.TileEntityChestMod;
import fr.ynov.villager.gui.GuiChest;
import fr.ynov.villager.gui.GuiCoinCreator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import java.util.Objects;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te instanceof TileCoinCreator) {
            return new ContainerCoinCreator((TileCoinCreator) te, player.inventory);
        }
        if (ID == References.GUI_SILVER_CHEST)
            return new ContainerChestMod(player.inventory, (TileEntityChestMod) Objects.requireNonNull(world.getTileEntity(new BlockPos(x, y, z))), player);

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te instanceof TileCoinCreator) {
            return new GuiCoinCreator((TileCoinCreator) te, player.inventory);
        }

        if (ID == References.GUI_SILVER_CHEST)
            return new GuiChest(player.inventory, (TileEntityChestMod) world.getTileEntity(new BlockPos(x, y, z)), player);
        return null;
    }
}
