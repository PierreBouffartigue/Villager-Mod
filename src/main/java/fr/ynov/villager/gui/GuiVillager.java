package fr.ynov.villager.gui;

import fr.ynov.villager.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class GuiVillager extends GuiScreen {
    private final ResourceLocation background = new ResourceLocation(References.MODID, "textures/gui/gui_base.png"); // 256x202
    private final int xSize = 256;
    private final int ySize = 202;
    private final Minecraft mc;
    private final EntityLivingBase villager;
    private int tab = 0;
    private int guiLeft;
    private int guiTop;

    public GuiVillager(Minecraft mc, EntityLivingBase villager) {
        this.mc = mc;
        this.villager = villager;
    }

    public void initGui() {
        guiLeft = (this.width - this.xSize) / 2;
        guiTop = (this.height - this.ySize) / 2;

        buttonList.add(new GuiCustomButton(0, guiLeft + 77, guiTop + 91, 100, 20, "Suivant", 0, 0));
        buttonList.add(new GuiCustomButton(1, guiLeft + 77, guiTop + 116, 100, 20, "Precedent", 0, 0));
        buttonList.add(new GuiCustomButton(2, guiLeft + 77, guiTop + 151, 100, 20, "Button 3", 0, 0));
        buttonList.get(2).enabled = false;
        buttonList.add(new GuiCustomButton(3, guiLeft + 240, guiTop, 16, 16, "X", 128, 0));
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                this.mc.player.sendChatMessage("Suivant");
                tab++;
                break;
            case 1:
                this.mc.player.sendChatMessage("Precedent");
                tab--;
                break;
            case 3:
                this.mc.displayGuiScreen(null);
                this.mc.setIngameFocus();
                break;
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackgroundImage();
        drawEntityOnScreen(guiLeft + 40, guiTop + 150, 40, (guiLeft + 40) - mouseX, (guiTop + 80) - mouseY, this.villager);
        drawText();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawBackgroundImage() {
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);

        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 1, xSize, ySize);


        GlStateManager.popMatrix();
    }

    public void drawText() {
        // drawString
        // drawCenterdString
        switch (tab) {
            case 0:
                drawCenteredString(fontRenderer, "Bonjour " + this.mc.player.getName() + " | Lvl : " + this.mc.player.experienceLevel, guiLeft + 128, guiTop + 20, Color.ORANGE.getRGB());
                drawCenteredString(fontRenderer, "Je suis " + this.villager.getName() + ", que puis-je faire pour vous ?", guiLeft + 128, guiTop + 50, Color.WHITE.getRGB());
                break;
            case 1:
                drawCenteredString(fontRenderer, "Page 2, hello", guiLeft + 128, guiTop + 20, Color.WHITE.getRGB());
                drawString(fontRenderer, "Page 2, hello", guiLeft + 128, guiTop + 40, Color.WHITE.getRGB());
                break;
            default:
                drawCenteredString(fontRenderer, "Page " + this.tab, guiLeft + 128, guiTop + 20, Color.WHITE.getRGB());
                break;
        }

    }

    public void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
        if (tab == 0) {
            GuiInventory.drawEntityOnScreen(posX, posY, scale, mouseX, mouseY, ent);
        }
    }
}
