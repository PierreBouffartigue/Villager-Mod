package fr.ynov.villager.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.Display;

public class GuiDebug {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderPre(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.DEBUG) {
            Minecraft mc = Minecraft.getMinecraft();
            event.setCanceled(true);

            //Position
            int x = (int) mc.player.posX;
            int y = (int) mc.player.posY;
            int z = (int) mc.player.posZ;
            String coords = TextFormatting.RED + "X : " + x + "  Y : " + y + "  Z : " + z;

            //Screen
            int wd = Display.getWidth();
            int hd = Display.getHeight();
            String screen = TextFormatting.WHITE + "Display : " + wd + " x " + hd;

            //Memory
            long i = Runtime.getRuntime().maxMemory();
            long j = Runtime.getRuntime().totalMemory();
            long k = Runtime.getRuntime().freeMemory();
            long l = j - k;
            long megabyte = 1024L * 1024L;
            String memory = "Mem: " + l / megabyte + " / " + i / megabyte + " MB";

            //CPU
            String cpu = "CPU : " + OpenGlHelper.getCpu();

            //GPU
            String gpu = "GPU : " + GlStateManager.glGetString(7937);

            //Facing - Direction
            EnumFacing enumfacing = mc.player.getHorizontalFacing();
            String s = "Invalid";

            switch (enumfacing) {
                case NORTH:
                    s = "Towards negative Z";
                    break;
                case SOUTH:
                    s = "Towards positive Z";
                    break;
                case WEST:
                    s = "Towards negative X";
                    break;
                case EAST:
                    s = "Towards positive X";
            }
            String facing = "Facing : " + enumfacing;

            //Biome
            String playerbiome = mc.world.getBiome(mc.player.getPosition()).getBiomeName();
            String biome = TextFormatting.WHITE + "Biome : " + playerbiome;

            //Draw text
            this.drawString(Minecraft.getMinecraft().fontRenderer, ">>> Villager", 30, 10, 0xcc0000);
            this.drawString(Minecraft.getMinecraft().fontRenderer, mc.player.getName(), 30, 30, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, mc.debug.split(",", 2)[0], 30, 40, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, biome, 30, 60, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, coords, 30, 70, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, facing, 30, 80, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, memory, 30, 100, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, screen, 30, 110, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, cpu, 30, 130, -1);
            this.drawString(Minecraft.getMinecraft().fontRenderer, gpu, 30, 140, -1);

        }
    }

    @SideOnly(Side.CLIENT)
    public void drawString(FontRenderer fontRenderer, String str, int x, int y, int color) {
        fontRenderer.drawStringWithShadow(str, x, y, color);
    }
}