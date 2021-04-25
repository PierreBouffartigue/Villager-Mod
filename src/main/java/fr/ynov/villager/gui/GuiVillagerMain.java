package fr.ynov.villager.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class GuiVillagerMain extends GuiVillager {
    public GuiVillagerMain(Minecraft mc, EntityLivingBase villager) {
        super(mc, villager);
    }

    public void initGui() {
        setGuiLeft((this.width - getxSize()) / 2);
        setGuiTop((this.height - getySize()) / 2);

        buttonList.add(new GuiCustomButton(0, getGuiLeft() + 240, getGuiTop(), 16, 16, "X", 128, 0));
        buttonList.add(new GuiCustomButton(1, getGuiLeft() + 77, getGuiTop() + 91, 100, 20, "Acheter", 0, 0));
        buttonList.add(new GuiCustomButton(2, getGuiLeft() + 77, getGuiTop() + 116, 100, 20, "Vendre", 0, 0));
        buttonList.add(new GuiCustomButton(3, getGuiLeft() + 77, getGuiTop() + 141, 100, 20, "Construire", 0, 0));
    }

    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                getMc().displayGuiScreen(null);
                getMc().setIngameFocus();
                break;
            case 1:
                getMc().player.sendMessage(new TextComponentString("Acheter"));
                getMc().displayGuiScreen(new GuiVillagerBuy(getMc(), getVillager()));
                break;
            case 2:
                getMc().player.sendMessage(new TextComponentString("Vendre"));
                getMc().displayGuiScreen(new GuiVillagerSell(getMc(), getVillager()));
                break;
            case 3:
                getMc().player.sendMessage(new TextComponentString("Construire"));
                getMc().displayGuiScreen(new GuiVillagerBuild(getMc(), getVillager()));
                break;
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackgroundImage(getBackground());
        drawEntityOnScreen(getGuiLeft() + 40, getGuiTop() + 150, 40, (getGuiLeft() + 40) - mouseX, (getGuiTop() + 80) - mouseY, getVillager());

        drawString(fontRenderer, "Bonjour " + getMc().player.getName(), getGuiLeft() + 128, getGuiTop() + 20, Color.BLACK.getRGB(), true, false);
        drawString(fontRenderer, "Je suis " + getVillager().getName() + ", que puis-je faire pour vous ?", getGuiLeft() + 128, getGuiTop() + 40, Color.BLACK.getRGB(), true, false);
        drawString(fontRenderer, "Nom de la ville : MyVillage", getGuiLeft() + 78, getGuiTop() + 60, Color.BLACK.getRGB(), false, false);
        drawString(fontRenderer, "Réputation : 0", getGuiLeft() + 78, getGuiTop() + 70, Color.BLACK.getRGB(), false, false);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
