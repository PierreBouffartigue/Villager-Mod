package fr.ynov.villager.ia;

import net.minecraft.entity.ai.EntityAIBase;

public class IAConstructor extends EntityAIBase {
    @Override
    public boolean shouldExecute() {
        return false;
        //IA Pour la construction de la mairie, d'une maison et de la zone de farm
    }
}
