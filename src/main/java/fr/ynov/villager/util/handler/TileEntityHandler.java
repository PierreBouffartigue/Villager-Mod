package fr.ynov.villager.util.handler;

import fr.ynov.villager.References;
import fr.ynov.villager.container.TileEntityChestMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityChestMod.class, new ResourceLocation(References.MODID + ":silver_chest"));
    }
}