package fr.ynov.villager.entity.render;

import fr.ynov.villager.References;
import fr.ynov.villager.entity.EntityMayor;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.ParametersAreNonnullByDefault;

@SideOnly(Side.CLIENT)
public
class RenderMayor<T extends EntityMayor> extends RenderLiving<T> {
    private static final ResourceLocation MAYOR_TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/mayor.png");

    public RenderMayor(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelPlayer(0.0F, false), 0.5F);
    }

    @ParametersAreNonnullByDefault
    protected float getDeathMaxRotation(T entityLivingBaseIn) {
        return 100.0F;
    }

    @ParametersAreNonnullByDefault
    protected ResourceLocation getEntityTexture(T entity) {
        return MAYOR_TEXTURES;
    }
}