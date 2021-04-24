package fr.villager.ynov.features;

import net.minecraft.item.ItemStack;

public interface IMachineVillagerRecipe {


    ItemStack[] getInput();

    void setInput(ItemStack[] input);


    ItemStack[] getOutput();


    void setOutput(ItemStack[] output);

}
