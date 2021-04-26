package fr.ynov.villager.gui;

import fr.ynov.villager.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SideOnly(Side.CLIENT)
public class GuiVillager extends GuiScreen {
    private final ResourceLocation background = new ResourceLocation(References.MODID, "textures/gui/gui_base.png"); // 256x202
    private final ResourceLocation backgroundTrade = new ResourceLocation(References.MODID, "textures/gui/gui_trade.png"); // 256x202
    private final int xSize = 256;
    private final int ySize = 202;
    private final Minecraft mc;
    private final EntityLivingBase villager;
    private int guiLeft;
    private int guiTop;

    public GuiVillager(Minecraft mc, EntityLivingBase villager) {
        this.mc = mc;
        this.villager = villager;
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public void drawBackgroundImage(ResourceLocation background) {
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        GlStateManager.popMatrix();
    }

    public void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
        GuiInventory.drawEntityOnScreen(posX, posY, scale, mouseX, mouseY, ent);
    }

    public void drawString(FontRenderer fontRendererIn, String text, int x, int y, int color, boolean centered, boolean shadow) {
        if (shadow) {
            fontRendererIn.drawStringWithShadow(text, centered ? x - fontRendererIn.getStringWidth(text) / 2F : x, y, color);
        } else {
            fontRendererIn.drawString(text, centered ? x - fontRendererIn.getStringWidth(text) / 2 : x, y, color);
        }
    }

    public void buttonHoveringText(GuiButton button, int mouseX, int mouseY, String[] text, int posX, int posY) {
        if (button.visible && mouseX >= button.x && mouseY >= button.y && mouseX < button.x + button.width && mouseY < button.y + button.height) {
            List<String> temp = Arrays.asList(text);
            drawHoveringText(temp, posX, posY);
        }
    }

    public List<Integer> getInventoryItemId(ItemStack itemStack) {
        List<Integer> coinId = new ArrayList<>();
        for (int i = 0; i < getMc().player.inventory.getSizeInventory(); i++) {
            if (getMc().player.inventory.getStackInSlot(i).getItem() == itemStack.getItem()) {
                coinId.add(i);
            }
        }
        return coinId;
    }

    public int getInventoryItemCount(List<Integer> itemId) {
        int count = 0;
        for (int i = 0; i < itemId.size(); i++) {
            count += getMc().player.inventory.getStackInSlot(itemId.get(i)).getCount();
        }
        return count;
    }

    public boolean decreaseInventoryItem(ItemStack itemStack, int nb) {
        List<Integer> itemId = getInventoryItemId(itemStack);
        for (int i = 0; i < itemId.size(); i++) {
            if (nb < getMc().player.inventory.getStackInSlot(itemId.get(i)).getCount()) {
                getMc().player.inventory.decrStackSize(itemId.get(i), nb);
                return true;
            }
            else {
                nb -= getMc().player.inventory.getStackInSlot(itemId.get(i)).getCount();
                getMc().player.inventory.removeStackFromSlot(itemId.get(i));
            }
        }
        return false;
    }

    public ResourceLocation getBackground() {
        return background;
    }

    public ResourceLocation getBackgroundTrade() {
        return backgroundTrade;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public Minecraft getMc() {
        return mc;
    }

    public EntityLivingBase getVillager() {
        return villager;
    }

    public int getGuiLeft() {
        return guiLeft;
    }

    public void setGuiLeft(int guiLeft) {
        this.guiLeft = guiLeft;
    }

    public int getGuiTop() {
        return guiTop;
    }

    public void setGuiTop(int guiTop) {
        this.guiTop = guiTop;
    }
}
