package fr.villager.ynov.features;

import net.minecraft.item.ItemStack;

import java.util.List;

public interface IMachineVillagerRegistry {


    List<IMachineVillagerRecipe> getRecipes();

    void addRecipe(ItemStack[] in, ItemStack[] out);


    IMachineVillagerRecipe getRecipeForInput(ItemStack[] in);

    void addFuel(ItemStack stack, Integer duration);


    int getFuelDuration(ItemStack stack);

}
