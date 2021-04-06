package fr.ynov.villager.gui;

import fr.ynov.villager.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = References.MODID)
public class GuiCustomButton extends GuiButton {
    private ResourceLocation buttonTex = new ResourceLocation(References.MODID, "textures/gui/gui_button.png");
    private int textureX;
    private int textureY;

    public GuiCustomButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, int textureX, int textureY) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
        this.textureX = textureX;
        this.textureY = textureY;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(buttonTex);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int i = this.getHoverState(this.hovered);
            this.drawTexturedModalRect(this.x, this.y, this.textureX, this.textureY + i * this.height, this.width, this.height);
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;

            if (packedFGColour != 0) {
                j = packedFGColour;
            } else if (!this.enabled) {
                j = 10526880;
            } else if (this.hovered) {
                j = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
        }
    }
}
