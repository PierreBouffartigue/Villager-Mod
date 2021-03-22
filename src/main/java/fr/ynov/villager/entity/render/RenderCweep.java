package fr.ynov.villager.entity.render;


import fr.ynov.villager.References;
import fr.ynov.villager.entity.EntityCweep;
import fr.ynov.villager.entity.models.ModelCweep;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.ParametersAreNonnullByDefault;

@SideOnly(Side.CLIENT)
public
class RenderCweep<T extends EntityCweep> extends RenderLiving<T> {
    private static final ResourceLocation SPIDER_TEXTURES = new ResourceLocation(References.MODID + ":textures/models/entity/cweep.png");

    public RenderCweep(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelCweep(), 1.0F);
    }

    @ParametersAreNonnullByDefault
    protected float getDeathMaxRotation(T entityLivingBaseIn) {
        return 180.0F;
    }

    @ParametersAreNonnullByDefault
    protected ResourceLocation getEntityTexture(T entity) {
        return SPIDER_TEXTURES;
    }
}
