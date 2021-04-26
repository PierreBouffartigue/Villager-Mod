package fr.ynov.villager.gui;

import fr.ynov.villager.bdd.JedisConnexion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import redis.clients.jedis.Jedis;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class GuiVillagerBuild extends GuiVillager {
    public GuiVillagerBuild(Minecraft mc, EntityLivingBase villager) {
        super(mc, villager);
    }

    public void initGui() {
        Jedis j = JedisConnexion.initJedis().getResource();
        j.select(1);
        String bzc = j.get("bronzeCoin");
        String stn = j.get("stone");
        int bronze = Integer.parseInt(bzc);
        int stone = Integer.parseInt(stn);

        setGuiLeft((this.width - getxSize()) / 2);
        setGuiTop((this.height - getySize()) / 2);

        buttonList.add(new GuiCustomButton(0, getGuiLeft() + 240, getGuiTop(), 16, 16, "X", 128, 0));
        buttonList.add(new GuiCustomButton(1, getGuiLeft() + 6, getGuiTop() + 6, 100, 20, "Retour", 0, 0));
        buttonList.add(new GuiCustomButton(2, getGuiLeft() + 77, getGuiTop() + 50, 100, 20, "Construire ferme", 0, 0));
        buttonList.add(new GuiCustomButton(3, getGuiLeft() + 77, getGuiTop() + 80, 100, 20, "Construire maison", 0, 0));
        buttonList.get(2).enabled = stone >= 50;
        buttonList.get(3).enabled = stone >= 50;
    }

    public void actionPerformed(GuiButton button) {

        switch (button.id) {
            case 0:
                getMc().displayGuiScreen(null);
                break;
            case 1:
                getMc().displayGuiScreen(new GuiVillagerMain(getMc(), getVillager()));
                break;
            case 2:
                Jedis j = JedisConnexion.initJedis().getResource();
                j.select(1);
                j.set("constructor","farm");
                String stn = j.get("stone");
                int stone = Integer.parseInt(stn);
                int stoneBuyInt = stone - 50;
                j.set("stone", Integer.toString(stoneBuyInt));
                getMc().player.sendMessage(new TextComponentString("Construction d'une ferme"));
                break;
            case 3:
                Jedis j2 = JedisConnexion.initJedis().getResource();
                j2.select(1);
                j2.set("constructor","house");
                String stn2 = j2.get("stone");
                int stone2 = Integer.parseInt(stn2);
                int stoneBuyInt2 = stone2 - 50;
                j2.set("stone", Integer.toString(stoneBuyInt2));
                getMc().player.sendMessage(new TextComponentString("Construction d'une maison"));
                break;
        }

    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackgroundImage(getBackground());
        drawString(fontRenderer, "Développer le village : ", getGuiLeft() + 128, getGuiTop() + 30, Color.BLACK.getRGB(), true, false);
        super.drawScreen(mouseX, mouseY, partialTicks);

        buttonHoveringText(buttonList.get(2), mouseX, mouseY, new String[]{"Nécessite 50 pièces de bronze"}, mouseX, mouseY);
        buttonHoveringText(buttonList.get(3), mouseX, mouseY, new String[]{"Nécessite 50 pierres"}, mouseX, mouseY);
    }
}
