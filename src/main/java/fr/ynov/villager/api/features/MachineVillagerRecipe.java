package fr.ynov.villager.api.features;

import fr.villager.ynov.features.IMachineVillagerRecipe;
import net.minecraft.item.ItemStack;

public class MachineVillagerRecipe implements IMachineVillagerRecipe {


    private ItemStack[] inputs;

    private ItemStack[] outputs;

    public MachineVillagerRecipe(ItemStack[] in, ItemStack[] out) {
        inputs = in;
        outputs = out;
    }

    @Override
    public ItemStack[] getInput() {
        return inputs;
    }

    @Override
    public void setInput(ItemStack[] input) {
        inputs = input;
    }

    @Override
    public ItemStack[] getOutput() {
        return outputs;
    }

    @Override
    public void setOutput(ItemStack[] output) {
        outputs = output;
    }

}
