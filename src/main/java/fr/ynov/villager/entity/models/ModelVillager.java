package fr.ynov.villager.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelVillager extends ModelBase {
    public ModelRenderer field_178736_x;
    public ModelRenderer field_178734_a;
    public ModelRenderer field_178731_d;
    public ModelRenderer field_178720_f;
    public ModelRenderer field_178733_c;
    public ModelRenderer field_178723_h;
    public ModelRenderer field_178721_j;
    public ModelRenderer field_78116_c;
    public ModelRenderer field_78115_e;
    public ModelRenderer field_178724_i;
    public ModelRenderer field_178722_k;

    public ModelVillager() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.field_178722_k = new ModelRenderer(this, 16, 48);
        this.field_178722_k.setRotationPoint(1.899999976158142F, 12.0F, 0.0F);
        this.field_178722_k.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_178734_a = new ModelRenderer(this, 48, 48);
        this.field_178734_a.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.field_178734_a.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
        this.field_178736_x = new ModelRenderer(this, 24, 0);
        this.field_178736_x.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178736_x.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0.0F);
        this.field_178724_i = new ModelRenderer(this, 32, 48);
        this.field_178724_i.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.field_178724_i.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_178733_c = new ModelRenderer(this, 0, 48);
        this.field_178733_c.setRotationPoint(1.899999976158142F, 12.0F, 0.0F);
        this.field_178733_c.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.field_178723_h = new ModelRenderer(this, 40, 16);
        this.field_178723_h.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.field_178723_h.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_78116_c = new ModelRenderer(this, 0, 0);
        this.field_78116_c.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78116_c.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.field_78115_e = new ModelRenderer(this, 16, 16);
        this.field_78115_e.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78115_e.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.field_178731_d = new ModelRenderer(this, 0, 32);
        this.field_178731_d.setRotationPoint(-1.899999976158142F, 12.0F, 0.0F);
        this.field_178731_d.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.field_178720_f = new ModelRenderer(this, 32, 0);
        this.field_178720_f.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178720_f.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.field_178721_j = new ModelRenderer(this, 0, 16);
        this.field_178721_j.setRotationPoint(-1.899999976158142F, 12.0F, 0.0F);
        this.field_178721_j.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.field_178722_k.render(f5);
        this.field_178734_a.render(f5);
        this.field_178736_x.render(f5);
        this.field_178724_i.render(f5);
        this.field_178733_c.render(f5);
        this.field_178723_h.render(f5);
        this.field_78116_c.render(f5);
        this.field_78115_e.render(f5);
        this.field_178731_d.render(f5);
        this.field_178720_f.render(f5);
        this.field_178721_j.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}