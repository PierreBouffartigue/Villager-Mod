package fr.ynov.villager.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class GuiVillagerSell extends GuiVillager {
    public GuiVillagerSell(Minecraft mc, EntityLivingBase villager) {
        super(mc, villager);
    }

    public void initGui() {
        setGuiLeft((this.width - getxSize()) / 2);
        setGuiTop((this.height - getySize()) / 2);

        buttonList.add(new GuiCustomButton(0, getGuiLeft() + 240, getGuiTop(), 16, 16, "X", 128, 0));
        buttonList.add(new GuiCustomButton(1, getGuiLeft() + 6, getGuiTop() + 6, 100, 20, "Retour", 0, 0));
    }

    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                getMc().displayGuiScreen(null);
                getMc().setIngameFocus();
                break;
            case 1:
                getMc().player.sendMessage(new TextComponentString("Retour"));
                getMc().displayGuiScreen(new GuiVillagerMain(getMc(), getVillager()));
                break;
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackgroundImage(getBackgroundTrade());

        drawString(fontRenderer, "Vendre : ", getGuiLeft() + 128, getGuiTop() + 30, Color.BLACK.getRGB(), true, false);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
