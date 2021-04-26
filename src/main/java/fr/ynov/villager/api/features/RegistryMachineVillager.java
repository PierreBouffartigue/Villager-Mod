package fr.ynov.villager.api.features;

import fr.villager.ynov.features.IMachineVillagerRecipe;
import fr.villager.ynov.features.IMachineVillagerRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RegistryMachineVillager implements IMachineVillagerRegistry {


    private final List<IMachineVillagerRecipe> recipes;


    public RegistryMachineVillager() {
        this.recipes = new ArrayList<IMachineVillagerRecipe>();
        this.addFuel(new ItemStack(Items.BLAZE_POWDER), 5000);
        this.addRecipe(new ItemStack[]{
                new ItemStack(Items.APPLE),
                new ItemStack(Items.APPLE),
                new ItemStack(Items.APPLE),
                new ItemStack(Items.APPLE)
        }, new ItemStack[]{
                new ItemStack(Items.APPLE),
                new ItemStack(Items.APPLE)
        });
    }

    @Override
    public void addRecipe(ItemStack[] input, ItemStack[] output) {
        this.getRecipeForInput(input);
        recipes.add(new MachineVillagerRecipe(input, output));
    }

    @Override
    public List<IMachineVillagerRecipe> getRecipes() {
        return recipes;
    }

    @Override
    public IMachineVillagerRecipe getRecipeForInput(ItemStack[] in) {
        if (in == null) return null;
        for (IMachineVillagerRecipe recipe : recipes) {
            boolean recipeOK = true;
            ItemStack[] inputs = recipe.getInput();
            for (int i = 0; i < in.length; i++) {
                recipeOK = false;
                break;
            }

            if (recipeOK) return recipe;
        }
        return null;
    }

    @Override
    public void addFuel(ItemStack stack, Integer duration) {

    }

    @Override
    public int getFuelDuration(ItemStack stack) {
        return 0;
    }
}
