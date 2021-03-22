package fr.ynov.villager.util.handler;

import fr.ynov.villager.init.EntitysMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {

    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {

    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
    }


    public static void preInitRegistries() {
        EntitysMod.registerEntities();
        RenderHandler.registerEntityRenders();

    }

    public static void initRegistries() {

    }

}
