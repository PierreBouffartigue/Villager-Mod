package fr.ynov.villager;

import fr.ynov.villager.gui.GuiDebug;
import fr.ynov.villager.init.BlocksMod;
import fr.ynov.villager.init.ItemsMod;
import fr.ynov.villager.init.RecipesMod;
import fr.ynov.villager.proxy.ServerProxy;
import fr.ynov.villager.tabs.VillagerTab;
import fr.ynov.villager.util.handler.RegistryHandler;
import fr.ynov.villager.world.OreGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptedMinecraftVersions = References.MINECRAFT_VERSION)
public class Main {
    public static final CreativeTabs creativeTab = new VillagerTab("villager");
    @Mod.Instance
    public static Main instance;
    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY, modId = References.MODID)
    public static ServerProxy proxy;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        BlocksMod.init();
        ItemsMod.init();
        RecipesMod.init();
        RegistryHandler.preInitRegistries();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.register();
        RegistryHandler.initRegistries();
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        MinecraftForge.EVENT_BUS.register(new GuiDebug());
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}