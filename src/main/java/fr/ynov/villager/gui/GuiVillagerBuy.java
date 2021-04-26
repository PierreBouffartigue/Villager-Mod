package fr.ynov.villager.gui;

import fr.ynov.villager.bdd.JedisConnexion;
import fr.ynov.villager.init.ItemsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import redis.clients.jedis.Jedis;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class GuiVillagerBuy extends GuiVillager {
    public GuiVillagerBuy(Minecraft mc, EntityLivingBase villager) {
        super(mc, villager);
    }

    public void initGui() {
        setGuiLeft((this.width - getxSize()) / 2);
        setGuiTop((this.height - getySize()) / 2);

        buttonList.add(new GuiCustomButton(0, getGuiLeft() + 240, getGuiTop(), 16, 16, "X", 128, 0));
        buttonList.add(new GuiCustomButton(1, getGuiLeft() + 6, getGuiTop() + 6, 100, 20, "Retour", 0, 0));

        buttonList.add(new GuiCustomButton(2, getGuiLeft() + 77, getGuiTop() + 50, 100, 20, "Acheter 5 Pierres", 0, 0));
        buttonList.add(new GuiCustomButton(3, getGuiLeft() + 77, getGuiTop() + 80, 100, 20, "Acheter 1 PA", 0, 0));
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
                getMc().displayGuiScreen(new GuiVillagerMain(getMc(), getVillager()));
                break;
            case 2:
                String bzc = j.get("bronzeCoin");
                String stn = j.get("stone");
                int bronze = Integer.parseInt(bzc);
                int stone = Integer.parseInt(stn);

                    if(stone >= 5 && getInventoryItemCount(getInventoryItemId(new ItemStack(ItemsMod.copper_coin))) >= 2){
                    int bronzeBuyInt = bronze + 2;
                    int stoneBuyInt = stone - 5;
                    j.set("stone", Integer.toString(stoneBuyInt));
                    j.set("bronzeCoin", Integer.toString(bronzeBuyInt));
                    getMc().player.addItemStackToInventory(new ItemStack(Blocks.STONE, 5));
                    decreaseInventoryItem(new ItemStack(ItemsMod.copper_coin), 2);
                    break;
                    }else{
                        getMc().player.sendMessage(new TextComponentString("Action impossible manque de ressources ou d'argent"));
                        break;
                    }



            case 3:
                String bzc2 = j.get("bronzeCoin");
                String svc = j.get("silverCoin");
                int bronze2 = Integer.parseInt(bzc2);
                int silver = Integer.parseInt(svc);

                if (silver >= 5 && getInventoryItemCount(getInventoryItemId(new ItemStack(ItemsMod.copper_coin))) >= 2) {
                    int bronzeBuyInt2 = bronze2 + 2;
                    int silverBuyInt = silver - 1;
                    j.set("silverCoin", Integer.toString(silverBuyInt));
                    j.set("bronzeCoin", Integer.toString(bronzeBuyInt2));
                    getMc().player.addItemStackToInventory(new ItemStack(ItemsMod.silver_coin, 1));
                    decreaseInventoryItem(new ItemStack(ItemsMod.copper_coin), 2);
                    break;
                }else{
                    getMc().player.sendMessage(new TextComponentString("Action impossible manque de ressources ou d'argent"));
                    break;
                }


        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackgroundImage(getBackground());
        drawString(fontRenderer, "Acheter : ", getGuiLeft() + 128, getGuiTop() + 30, Color.BLACK.getRGB(), true, false);
        super.drawScreen(mouseX, mouseY, partialTicks);

        buttonHoveringText(buttonList.get(2), mouseX, mouseY, new String[]{"5 Pierres", "", "Prix : 2 Pièce de cuivre"}, mouseX, mouseY);
        buttonHoveringText(buttonList.get(3), mouseX, mouseY, new String[]{"1 Pièce de silver", "", "Prix : 2 Pièce de cuivre"}, mouseX, mouseY);
    }
}
