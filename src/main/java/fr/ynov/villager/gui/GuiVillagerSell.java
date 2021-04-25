package fr.ynov.villager.gui;

import fr.ynov.villager.bdd.JedisConnexion;
import fr.ynov.villager.init.ItemsMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import redis.clients.jedis.Jedis;

import java.awt.*;
import java.util.Objects;

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
        buttonList.add(new GuiCustomButton(2, getGuiLeft() + 77, getGuiTop() + 50, 100, 20, "Vendre 5 Pierres", 0, 0));
        buttonList.add(new GuiCustomButton(3, getGuiLeft() + 77, getGuiTop() + 80, 100, 20, "Vendre 1 PA", 0, 0));
    }

    public void actionPerformed(GuiButton button) {
        Jedis j = JedisConnexion.initJedis().getResource();
        j.select(1);
        switch (button.id) {
            case 0:
                getMc().displayGuiScreen(null);
                getMc().setIngameFocus();
                break;
            case 1:
                getMc().player.sendMessage(new TextComponentString("Retour"));
                getMc().displayGuiScreen(new GuiVillagerMain(getMc(), getVillager()));
                break;
            case 2:
                getMc().player.addItemStackToInventory(new ItemStack(Objects.requireNonNull(ItemsMod.copper_coin), 1));
                int itemId = getMc().player.inventory.getSlotFor(new ItemStack(Objects.requireNonNull(Block.getBlockFromName("stone"))));
                getMc().player.inventory.decrStackSize(itemId, 5);
                break;
            case 3:
                getMc().player.addItemStackToInventory(new ItemStack(Objects.requireNonNull(ItemsMod.copper_coin), 1));
                int itemId2 = getMc().player.inventory.getSlotFor(new ItemStack(Objects.requireNonNull(ItemsMod.silver_coin)));
                getMc().player.inventory.decrStackSize(itemId2, 1);
                break;
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackgroundImage(getBackground());

        drawString(fontRenderer, "Vendre : ", getGuiLeft() + 128, getGuiTop() + 30, Color.BLACK.getRGB(), true, false);

        super.drawScreen(mouseX, mouseY, partialTicks);

        buttonHoveringText(buttonList.get(2), mouseX, mouseY, new String[]{"5 Pierres", "", "Gain : 1 Pièce de cuivre"}, mouseX, mouseY);
        buttonHoveringText(buttonList.get(3), mouseX, mouseY, new String[]{"1 Pièce de silver", "", "Gain : 1 Pièce de cuivre"}, mouseX, mouseY);
    }
}
