package fr.ynov.villager.util.handler;

import fr.ynov.villager.Main;
import fr.ynov.villager.container.RenderingChestMod;
import fr.ynov.villager.container.TileEntityChestMod;
import fr.ynov.villager.init.EntitysMod;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        TileEntityHandler.registerTileEntities();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChestMod.class, new RenderingChestMod());
    }

    public static void preInitRegistries() {
        EntitysMod.registerEntities();
        RenderHandler.registerEntityRenders();

    }

    public static void initRegistries() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }

}
