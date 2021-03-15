package fr.ynov.villager.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandler {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderPre(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.DEBUG) {
            Minecraft mc = Minecraft.getMinecraft();
            event.setCanceled(true);
            this.drawString(Minecraft.getMinecraft().fontRenderer, mc.debug.split(",", 2)[0], 10, 50, 0xFF0000);
        }
    }

    @SideOnly(Side.CLIENT)
    public void drawString(FontRenderer fontRenderer, String str, int x, int y, int color) {
        fontRenderer.drawStringWithShadow(str, x, y, color);
    }
}
