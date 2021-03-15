package fr.ynov.villager.init;

import fr.ynov.villager.Main;
import fr.ynov.villager.References;
import fr.ynov.villager.items.ItemCustomFood;
import fr.ynov.villager.items.ItemMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = References.MODID)
public class ItemsMod {
    public static Item saphire;
    public static Item viande;

    public static void init() {

        saphire = new ItemMod("saphire").setCreativeTab(Main.creativeTab);
        viande = (new ItemCustomFood("viande", 10, 0.3F, false)).setCreativeTab(Main.creativeTab);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(saphire, viande);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {

        registerRender(saphire);
        registerRender(viande);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}