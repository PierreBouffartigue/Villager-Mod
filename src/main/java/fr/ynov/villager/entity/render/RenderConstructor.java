package fr.ynov.villager.entity.render;

import fr.ynov.villager.References;
import fr.ynov.villager.entity.EntityConstructor;
import fr.ynov.villager.entity.models.ModelVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.ParametersAreNonnullByDefault;

@SideOnly(Side.CLIENT)
public
class RenderConstructor<T extends EntityConstructor> extends RenderLiving<T> {
    private static final ResourceLocation MAYOR_TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/constructor.png");

    public RenderConstructor(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelVillager(), 1.0F);
    }

    @ParametersAreNonnullByDefault
    protected float getDeathMaxRotation(T entityLivingBaseIn) {
        return 180.0F;
    }

    @ParametersAreNonnullByDefault
    protected ResourceLocation getEntityTexture(T entity) {
        return MAYOR_TEXTURES;
    }
}