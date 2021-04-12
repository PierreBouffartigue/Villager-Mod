package fr.ynov.villager.init;

import fr.ynov.villager.References;
import fr.ynov.villager.blocks.BlockCoinCreator;
import fr.ynov.villager.blocks.BlockMod;
import fr.ynov.villager.container.ChestMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = References.MODID)
public class BlocksMod {
    public static Block ardoise_block, copper_ore, silver_ore, sign_block, silver_lantern;
    public static ChestMod silver_chest;
    public static BlockCoinCreator coin_creator;

    public static void init() {
        //ore
        ardoise_block = new BlockMod("ardoise_block", Material.ROCK, 0).setHardness(5.0F);
        copper_ore = new BlockMod("copper_ore", Material.IRON, 1).setHardness(3.5F);
        silver_ore = new BlockMod("silver_ore", Material.IRON, 2).setHardness(4.5F);

        //blocks
        sign_block = new BlockMod("sign_block", Material.GLASS, 1).setHardness(1.0F);
        silver_lantern = new BlockMod("silver_lantern", Material.CLAY, 0).setHardness(1.0F).setLightLevel(1.0F);

        //chest
        silver_chest = new ChestMod("silver_chest");

        //coin creator
        coin_creator = new BlockCoinCreator("coin_creator",Material.ROCK);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ardoise_block, copper_ore, silver_ore, sign_block, silver_chest, silver_lantern, coin_creator);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(ardoise_block).setRegistryName(Objects.requireNonNull(ardoise_block.getRegistryName())),
                new ItemBlock(copper_ore).setRegistryName(Objects.requireNonNull(copper_ore.getRegistryName())),
                new ItemBlock(silver_ore).setRegistryName(Objects.requireNonNull(silver_ore.getRegistryName())),
                new ItemBlock(sign_block).setRegistryName(Objects.requireNonNull(sign_block.getRegistryName())),
                new ItemBlock(silver_chest).setRegistryName(Objects.requireNonNull(silver_chest.getRegistryName())),
                new ItemBlock(silver_lantern).setRegistryName(Objects.requireNonNull(silver_lantern.getRegistryName())),
                new ItemBlock(coin_creator).setRegistryName(Objects.requireNonNull(coin_creator.getRegistryName()))
        );
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(ardoise_block));
        registerRender(Item.getItemFromBlock(copper_ore));
        registerRender(Item.getItemFromBlock(silver_ore));
        registerRender(Item.getItemFromBlock(sign_block));
        registerRender(Item.getItemFromBlock(silver_chest));
        registerRender(Item.getItemFromBlock(silver_lantern));
        registerRender(Item.getItemFromBlock(coin_creator));

        //Adding smelting
        GameRegistry.addSmelting(new ItemStack(copper_ore), new ItemStack(ItemsMod.copper_ingot), 1.0F);
        GameRegistry.addSmelting(new ItemStack(silver_ore), new ItemStack(ItemsMod.silver_ingot), 2.0F);

    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }

}