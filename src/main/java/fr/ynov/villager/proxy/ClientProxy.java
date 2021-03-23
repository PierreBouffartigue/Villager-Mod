package fr.ynov.villager.proxy;

import fr.ynov.villager.References;
import fr.ynov.villager.gui.GuiMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends ServerProxy {
    private static KeyBinding keyBindTest;

    public ClientProxy() {
        MinecraftForge.EVENT_BUS.register(this);
        keyBindTest = new KeyBinding("modtest.key", Keyboard.KEY_O, "key.categories.gameplay");
        ClientRegistry.registerKeyBinding(keyBindTest);
    }

    @Override
    public void register() {
        OBJLoader.INSTANCE.addDomain(References.MODID);
    }

    @SubscribeEvent
    public void onEvent(InputEvent.KeyInputEvent event) {
        if (keyBindTest.isPressed()) {
            keyTestTyped();
        }
    }

    private void keyTestTyped() {
        Minecraft.getMinecraft().displayGuiScreen(new GuiMain(Minecraft.getMinecraft()));
    }
}
