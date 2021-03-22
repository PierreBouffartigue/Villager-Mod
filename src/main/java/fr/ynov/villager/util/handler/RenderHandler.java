package fr.ynov.villager.util.handler;


import fr.ynov.villager.entity.EntityCweep;
import fr.ynov.villager.entity.render.RenderCweep;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCweep.class, new IRenderFactory<EntityCweep>() {

            @Override
            public Render<? super EntityCweep> createRenderFor(RenderManager manager) {
                return new RenderCweep<EntityCweep>(manager);
            }
        });
    }
}
