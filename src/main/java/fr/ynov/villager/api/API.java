package fr.ynov.villager.api;

import fr.villager.ynov.IVillagerAPI;
import fr.villager.ynov.features.IRegistryRecipes;
import fr.ynov.villager.api.features.RegistryRecipes;

public class API implements IVillagerAPI {

    public static final API INSTANCE = new API();

    private final IRegistryRecipes registryRecipes;

    private API() {
        registryRecipes = new RegistryRecipes();
    }

    @Override
    public IRegistryRecipes recipes() {
        return registryRecipes;
    }

}
