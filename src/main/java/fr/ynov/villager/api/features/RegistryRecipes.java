package fr.ynov.villager.api.features;

import fr.villager.ynov.features.IMachineVillagerRegistry;
import fr.villager.ynov.features.IRegistryRecipes;

public class RegistryRecipes implements IRegistryRecipes {


    private final IMachineVillagerRegistry machineVillager;


    public RegistryRecipes() {
        machineVillager = new RegistryMachineVillager();
    }

    @Override
    public IMachineVillagerRegistry machineVillager() {
        return machineVillager;
    }

}
