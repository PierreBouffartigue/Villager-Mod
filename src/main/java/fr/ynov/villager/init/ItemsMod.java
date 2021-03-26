package fr.ynov.villager.init;

import fr.ynov.villager.References;
import fr.ynov.villager.armor.ArmorMod;
import fr.ynov.villager.items.ItemCustomFood;
import fr.ynov.villager.items.ItemMod;
import fr.ynov.villager.tools.ItemAxeMod;
import fr.ynov.villager.tools.ItemPickaxeMod;
import fr.ynov.villager.tools.ItemShovelMod;
import fr.ynov.villager.tools.ItemSwordMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = References.MODID)
public class ItemsMod {
    public static Item saphire, viande, copper_coin, copper_ingot, silver_coin, silver_ingot, gold_coin, copper_pickaxe, copper_sword, copper_axe, copper_shovel, copper_helmet, copper_chestplate, copper_leggings, copper_boots, steam_sword;

    public static void init() {

        saphire = new ItemMod("saphire");
        //copper items
        copper_coin = new ItemMod("copper_coin");
        copper_ingot = new ItemMod("copper_ingot");


        //silver items
        silver_coin = new ItemMod("silver_coin");
        silver_ingot = new ItemMod("silver_ingot");

        //gold items
        gold_coin = new ItemMod("gold_coin");
        viande = (new ItemCustomFood("viande", 10, 0.3F, false));

        //tools
        copper_pickaxe = new ItemPickaxeMod("copper_pickaxe", Item.ToolMaterial.DIAMOND);
        copper_sword = new ItemSwordMod("copper_sword", Item.ToolMaterial.DIAMOND);
        copper_axe = new ItemAxeMod("copper_axe", Item.ToolMaterial.DIAMOND);
        copper_shovel = new ItemShovelMod("copper_shovel", Item.ToolMaterial.DIAMOND);
        steam_sword = new ItemSwordMod("steam_sword", Item.ToolMaterial.DIAMOND);

        //armor
        copper_helmet = new ArmorMod("copper_helmet", ItemArmor.ArmorMaterial.DIAMOND, 1, EntityEquipmentSlot.HEAD);
        copper_chestplate = new ArmorMod("copper_chestplate", ItemArmor.ArmorMaterial.DIAMOND, 1, EntityEquipmentSlot.CHEST);
        copper_leggings = new ArmorMod("copper_leggings", ItemArmor.ArmorMaterial.DIAMOND, 2, EntityEquipmentSlot.LEGS);
        copper_boots = new ArmorMod("copper_boots", ItemArmor.ArmorMaterial.DIAMOND, 1, EntityEquipmentSlot.FEET);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(saphire, viande, copper_coin, copper_ingot, silver_coin, silver_ingot, gold_coin, copper_pickaxe, copper_sword, copper_shovel, copper_axe, copper_helmet, copper_chestplate, copper_leggings, copper_boots, steam_sword);
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

        //tools
        registerRender(copper_pickaxe);
        registerRender(copper_sword);
        registerRender(copper_axe);
        registerRender(copper_shovel);
        registerRender(steam_sword);

        //armor
        registerRender(copper_helmet);
        registerRender(copper_chestplate);
        registerRender(copper_leggings);
        registerRender(copper_boots);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}