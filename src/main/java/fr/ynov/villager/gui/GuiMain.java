package fr.ynov.villager.gui;

import fr.ynov.villager.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = References.MODID)
public class GuiMain extends GuiScreen {
    private final ResourceLocation background = new ResourceLocation(References.MODID, "textures/gui/gui_base.png"); // 256x202

    private final int xSize = 256;
    private final int ySize = 202;

    private int guiLeft;
    private int guiTop;

    private Minecraft mc;

    public GuiMain(Minecraft mc) {
        this.mc = mc;
    }

    public void initGui() {
        guiLeft = (this.width - this.xSize) / 2;
        guiTop = (this.height - this.ySize) / 2;

        buttonList.add(new GuiCustomButton(0, guiLeft + 77, guiTop + 91, 100, 20, "Button 1", 0, 0));
        buttonList.add(new GuiCustomButton(1, guiLeft + 77, guiTop + 116, 100, 20, "Button 2", 0, 0));
        buttonList.get(1).enabled = false;
        buttonList.add(new GuiCustomButton(2, guiLeft + 240, guiTop, 16, 16, "X", 128, 0));
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                this.mc.player.sendChatMessage("Button 1");
                break;
            case 1:
                this.mc.player.sendChatMessage("Button 2");
                break;
            case 2:
                this.mc.displayGuiScreen((GuiScreen) null);
                this.mc.setIngameFocus();
                break;
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackgroundImage();
        drawEntityOnScreen(guiLeft + 40, guiTop + 150, 40, (guiLeft + 40) - mouseX, (guiTop + 80) - mouseY, this.mc.player);
        drawText();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawBackgroundImage() {
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);

        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);


        GlStateManager.popMatrix();
    }

    public void drawText() {
        // drawString
        // drawCenterdString
        drawCenteredString(fontRenderer, "Bonjour " + this.mc.player.getName() + " | Lvl : " + this.mc.player.experienceLevel, guiLeft + 128, guiTop + 20, Color.ORANGE.getRGB());
    }

    public void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) posX, (float) posY, 50.0F);
        GlStateManager.scale((float) (-scale), (float) scale, (float) scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float) Math.atan((double) (mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        ent.renderYawOffset = (float) Math.atan((double) (mouseX / 40.0F)) * 20.0F;
        ent.rotationYaw = (float) Math.atan((double) (mouseX / 40.0F)) * 40.0F;
        ent.rotationPitch = -((float) Math.atan((double) (mouseY / 40.0F))) * 20.0F;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}
