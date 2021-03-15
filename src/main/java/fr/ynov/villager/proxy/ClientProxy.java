package fr.ynov.villager.proxy;

import fr.ynov.villager.References;
import net.minecraftforge.client.model.obj.OBJLoader;

public class ClientProxy extends ServerProxy {
    @Override
    public void register() {
        OBJLoader.INSTANCE.addDomain(References.MODID);
    }
}
