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
    public static Item copper_coin;
    public static Item copper_ingot;
    public static Item silver_coin;
    public static Item silver_ingot;
    public static Item gold_coin;


    public static void init() {

        saphire = new ItemMod("saphire").setCreativeTab(Main.creativeTab);
        //copper items
        copper_coin = new ItemMod("copper_coin").setCreativeTab(Main.creativeTab);
        copper_ingot = new ItemMod("copper_ingot").setCreativeTab(Main.creativeTab);

        //silver items
        silver_coin = new ItemMod("silver_coin").setCreativeTab(Main.creativeTab);
        silver_ingot = new ItemMod("silver_ingot").setCreativeTab(Main.creativeTab);

        //gold items
        gold_coin = new ItemMod("gold_coin").setCreativeTab(Main.creativeTab);
        viande = (new ItemCustomFood("viande", 10, 0.3F, false)).setCreativeTab(Main.creativeTab);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(saphire, viande, copper_coin,copper_ingot, silver_coin,silver_ingot, gold_coin);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {

        registerRender(saphire);
        registerRender(viande);

        //copper items
        registerRender(copper_coin);
        registerRender(copper_ingot);

        //silver items
        registerRender(silver_coin);
        registerRender(silver_ingot);

        //gold items
        registerRender(gold_coin);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}