package fr.ynov.villager.util.handler;

import fr.ynov.villager.init.EntitysMod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class RegistryHandler {

    public static void preInitRegistries() {
        EntitysMod.registerEntities();
        RenderHandler.registerEntityRenders();

    }

    public static void initRegistries() {

    }

}
