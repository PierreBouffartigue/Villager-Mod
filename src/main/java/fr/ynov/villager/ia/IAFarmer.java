package fr.ynov.villager.ia;

import net.minecraft.entity.ai.EntityAIBase;

public class IAFarmer extends EntityAIBase {
    @Override
    public boolean shouldExecute() {
        return false;
        //IA Pour que le gars aille "farm" dans sa zone et ramène les ressources à l'HDV
    }
}
