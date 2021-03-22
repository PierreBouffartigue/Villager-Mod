package fr.ynov.villager.gui.jt;

import fr.ynov.villager.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = References.MODID)
public class GuiMain extends GuiScreen {
    private final ResourceLocation background = new ResourceLocation("textures/gui/gui_base.png"); // 256x202

    private final int xSize = 256;
    private final int ySize = 202;

    private int guiLeft;
    private int guiTop;

    private Minecraft minecraft;

    public GuiMain(Minecraft mc) {
        this.minecraft = mc;
    }

    public void initGui() {
        guiLeft = (this.width - this.xSize) / 2;
        guiTop = (this.height - this.ySize) / 2;
    }

    public void actionPerforme(GuiButton button) {

    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackgroundImage();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawBackgroundImage() {
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);

        minecraft.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);


        GlStateManager.popMatrix();
    }
}
