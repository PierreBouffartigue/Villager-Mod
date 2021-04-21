package fr.ynov.villager.ia;

import net.minecraft.entity.ai.EntityAIBase;

public class IARest extends EntityAIBase {
    @Override
    public boolean shouldExecute() {
        return false;
        //IA surtout pour le constructeur au repos
    }
}
