package fr.ynov.villager.init;

import fr.ynov.villager.References;
import fr.ynov.villager.armor.ArmorMod;
import fr.ynov.villager.book.BookMod;
import fr.ynov.villager.items.ItemFoodMod;
import fr.ynov.villager.items.ItemMod;
import fr.ynov.villager.tools.ItemAxeMod;
import fr.ynov.villager.tools.ItemPickaxeMod;
import fr.ynov.villager.tools.ItemShovelMod;
import fr.ynov.villager.tools.ItemSwordMod;
import fr.ynov.villager.world.StructureCityHall;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = References.MODID)
public class ItemsMod {
    public static Item saphire, viande, copper_coin, copper_ingot, silver_coin, silver_ingot, gold_coin, copper_pickaxe,
            copper_sword, copper_axe, copper_shovel, copper_helmet, copper_chestplate,
            copper_leggings, copper_boots, steam_sword, explication_book,structure_generator;
    public static ItemArmor.ArmorMaterial copper_material;
    public static Item.ToolMaterial copper_tool_material;

    public static void init() {

        saphire = new ItemMod("saphire");
        //Copper items
        copper_coin = new ItemMod("copper_coin");
        copper_ingot = new ItemMod("copper_ingot");


        //Silver items
        silver_coin = new ItemMod("silver_coin");
        silver_ingot = new ItemMod("silver_ingot");

        //Gold items
        gold_coin = new ItemMod("gold_coin");
        viande = (new ItemFoodMod("viande", 10, 0.3F, false));

        //Tools
        copper_tool_material = EnumHelper.addToolMaterial("copper_tool", 3,100,1, 20F,1);
        copper_pickaxe = new ItemPickaxeMod("copper_pickaxe", copper_tool_material);
        copper_sword = new ItemSwordMod("copper_sword", copper_tool_material);
        copper_axe = new ItemAxeMod("copper_axe", copper_tool_material);
        copper_shovel = new ItemShovelMod("copper_shovel", copper_tool_material);
        steam_sword = new ItemSwordMod("steam_sword", copper_tool_material);
        structure_generator = new StructureCityHall("structure_generator");

        //Armor
        copper_material = EnumHelper.addArmorMaterial("copper", References.MODID + ":copper", 100, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0f);
        copper_helmet = new ArmorMod("copper_helmet", copper_material, 1, EntityEquipmentSlot.HEAD);
        copper_chestplate = new ArmorMod("copper_chestplate", copper_material, 1, EntityEquipmentSlot.CHEST);
        copper_leggings = new ArmorMod("copper_leggings", copper_material, 2, EntityEquipmentSlot.LEGS);
        copper_boots = new ArmorMod("copper_boots", copper_material, 1, EntityEquipmentSlot.FEET);

        //Book
        explication_book = new BookMod("explication_book");

        //Craft


    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(saphire, viande, copper_coin, copper_ingot, silver_coin, silver_ingot, gold_coin,
                copper_pickaxe, copper_sword, copper_shovel, copper_axe, copper_helmet, copper_chestplate,
                copper_leggings, copper_boots, steam_sword, explication_book, structure_generator);
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
        registerRender(structure_generator);

        //armor
        registerRender(copper_helmet);
        registerRender(copper_chestplate);
        registerRender(copper_leggings);
        registerRender(copper_boots);

        //book
        registerRender(explication_book);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}