package fr.ynov.villager.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiDebug {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderPre(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.DEBUG) {
            Minecraft mc = Minecraft.getMinecraft();
            event.setCanceled(true);

            int x = (int) mc.player.posX;
            int y = (int) mc.player.posY;
            int z = (int) mc.player.posZ;
            String coords = TextFormatting.WHITE + "X : " + x + "  Y : " + y + "  Z : " + z;

            String playerbiome = mc.world.getBiome(mc.player.getPosition()).getBiomeName();
            String biome = TextFormatting.WHITE + "Biome : " + playerbiome;

            this.drawString(Minecraft.getMinecraft().fontRenderer, "Villager Mod", 30, 20, 0xFF0000);
            this.drawString(Minecraft.getMinecraft().fontRenderer, mc.debug.split(",", 2)[0], 30, 40, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, biome, 30, 50, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, coords, 30, 60, -1);
        }
    }

    @SideOnly(Side.CLIENT)
    public void drawString(FontRenderer fontRenderer, String str, int x, int y, int color) {
        fontRenderer.drawStringWithShadow(str, x, y, color);
    }
}