package fr.ynov.villager.init;

import fr.ynov.villager.Main;
import fr.ynov.villager.References;
import fr.ynov.villager.entity.EntityConstructor;
import fr.ynov.villager.entity.EntityCweep;
import fr.ynov.villager.entity.EntityFarmer;
import fr.ynov.villager.entity.EntityMayor;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntitysMod {
    public static void registerEntities() {
        registerEntity("mayor", EntityMayor.class, 112, 40, 12345678, 56984235);
        registerEntity("cweep", EntityCweep.class, 111, 50, 16765255, 1672485);
        registerEntity("farmer", EntityFarmer.class, 113, 50, 66765255, 1672455);
        registerEntity("constructor", EntityConstructor.class, 114, 50, 16799255, 1699485);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(References.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
    }
}
