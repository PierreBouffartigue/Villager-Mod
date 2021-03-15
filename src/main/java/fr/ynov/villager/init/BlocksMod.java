package fr.ynov.villager.init;

import fr.ynov.villager.Main;
import fr.ynov.villager.References;
import fr.ynov.villager.blocks.BlockMod;
import fr.ynov.villager.blocks.BlockOreMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = References.MODID)
public class BlocksMod {
    public static Block epicka_block, copper_ore;

    public static void init() {
        epicka_block = new BlockMod("epicka_block", Material.ROCK).setLightLevel(20).setCreativeTab(Main.creativeTab).setHardness(5.0F);
        copper_ore = new BlockOreMod("copper_ore", 2, 1, 8).setCreativeTab(Main.creativeTab).setHardness(5.0F);

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(epicka_block, copper_ore);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(epicka_block).setRegistryName(Objects.requireNonNull(epicka_block.getRegistryName())),
                new ItemBlock(copper_ore).setRegistryName(Objects.requireNonNull(copper_ore.getRegistryName()))
        );
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(epicka_block));
        registerRender(Item.getItemFromBlock(copper_ore));
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}