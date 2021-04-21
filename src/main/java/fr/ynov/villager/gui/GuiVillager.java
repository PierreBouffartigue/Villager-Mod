package fr.ynov.villager.gui;

import fr.ynov.villager.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
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
        buttonList.add(new GuiCustomButton(1, guiLeft + 77, guiTop + 116, 100, 20, "Précédent", 0, 0));
        buttonList.add(new GuiCustomButton(2, guiLeft + 77, guiTop + 151, 100, 20, "Button 3", 0, 0));
        buttonList.get(2).enabled = false;
        buttonList.add(new GuiCustomButton(3, guiLeft + 240, guiTop, 16, 16, "X", 128, 0));
    }

    public void addButtons(){
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                this.mc.player.sendMessage(new TextComponentString("Suivant"));
                tab++;
                break;
            case 1:
                this.mc.player.sendMessage(new TextComponentString("Précédent"));
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
        addButtons();
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
        switch (tab) {
            case 0:
                drawString(fontRenderer, "Bonjour " + this.mc.player.getName(), guiLeft + 128, guiTop + 20, Color.BLACK.getRGB(), true, false);
                drawString(fontRenderer, "Je suis " + this.villager.getName() + ", que puis-je faire pour vous ?", guiLeft + 128, guiTop + 40, Color.BLACK.getRGB(), true, false);
                drawString(fontRenderer, "Nom de la ville : test", guiLeft + 78, guiTop + 60, Color.BLACK.getRGB(), false, false);
                drawString(fontRenderer, "Réputation : 0", guiLeft + 78, guiTop + 70, Color.BLACK.getRGB(), false, false);
                break;
            case 1:
                drawString(fontRenderer, "Echanger avec le village : ", guiLeft + 128, guiTop + 20, Color.BLACK.getRGB(), true, false);
                break;
            case 2:
                drawString(fontRenderer, "Développer le village : ", guiLeft + 128, guiTop + 20, Color.BLACK.getRGB(), true, false);
                break;
            default:
                drawString(fontRenderer, "Page " + this.tab, guiLeft + 128, guiTop + 20, Color.BLACK.getRGB(), true, false);
                break;
        }

    }

    public void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
        if (tab == 0) {
            GuiInventory.drawEntityOnScreen(posX, posY, scale, mouseX, mouseY, ent);
        }
    }

    public void drawString(FontRenderer fontRendererIn, String text, int x, int y, int color, boolean centered, boolean shadow) {
        if (shadow) {
            fontRendererIn.drawStringWithShadow(text, centered ? x - fontRendererIn.getStringWidth(text) / 2 : x, y, color);
        } else {
            fontRendererIn.drawString(text, centered ? x - fontRendererIn.getStringWidth(text) / 2 : x, y, color);
        }

    }
}
