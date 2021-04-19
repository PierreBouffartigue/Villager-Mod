package fr.ynov.villager.blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.oredict.OreDictionary;

public class TileCoinCreator extends TileEntityLockable implements ITickable
{

    private NonNullList<ItemStack> stacks = NonNullList.withSize(5, ItemStack.EMPTY);
    private String customName;
    private int	timePassed = 0;
    private int	burningTimeLeft	= 0;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.stacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.stacks);

        if (compound.hasKey("CustomName", 8)) {
            this.customName = compound.getString("CustomName");
        }
        this.burningTimeLeft = compound.getInteger("burningTimeLeft");
        this.timePassed = compound.getInteger("timePassed");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        ItemStackHelper.saveAllItems(compound, this.stacks);

        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }

        compound.setInteger("burningTimeLeft", this.burningTimeLeft);
        compound.setInteger("timePassed", this.timePassed);

        return compound;
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    //Getters and Setters
    @Override
    public String getName() {
        return hasCustomName() ? this.customName : "Coin creator";
    }

    public void setCustomName(String name) {
        this.customName = name;
    }

    @Override
    public int getField(int id) {
        switch (id) {
            case 0:
                return this.burningTimeLeft;
            case 1:
                return this.timePassed;
        }
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.burningTimeLeft = value;
                break;
            case 1:
                this.timePassed = value;
        }
    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    //Manipulation ItemStack
    @Override
    public int getSizeInventory() {
        return this.stacks.size();
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.stacks.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.stacks, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(stacks, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.stacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack stack : this.stacks) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for(int i = 0; i < this.stacks.size(); i++) {
            this.stacks.set(i, ItemStack.EMPTY);
        }
    }

    //called when open or closed
    @Override
    public void openInventory(EntityPlayer player) {}

    @Override
    public void closeInventory(EntityPlayer player) {}

    //For minecraft
    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return null;
    }

    @Override
    public String getGuiID() {
        return null;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {

        // Slot 1 Iron ingot
        if (index == 1)
            return stack.getItem() == Items.IRON_INGOT;
        // slot 2 Coal
        if (index == 2)
            return stack.getItem() == Items.COAL;
        // slot 3 is output
        if (index == 3)
            return false;
        //slot 0 for ingot
        return true;
    }

    //check if block is usable
    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) == this && player
                .getDistanceSq((double) this.pos.getX() + 0.5D,
                        (double) this.pos.getY() + 0.5D,
                        (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public boolean hasFuelEmpty() {

        return this.getStackInSlot(2).isEmpty()
                || this.getStackInSlot(1).isEmpty();
    }

    public ItemStack getRecipeResult() {
        return CoinCreatorRecipies.getRecipeResult(new ItemStack[] {
                this.getStackInSlot(0)});
    }

    public boolean canSmelt() {

        ItemStack result = this.getRecipeResult();

        if (result != null) {

            ItemStack slot3 = this.getStackInSlot(3);


            if (slot3.isEmpty())
                return true;


            if (slot3.getItem() == result.getItem() && slot3.getItemDamage() == result.getItemDamage()) {
                int newStackSize = slot3.getCount() + result.getCount();
                if (newStackSize <= this.getInventoryStackLimit() && newStackSize <= slot3.getMaxStackSize()) {
                    return true;
                }
            }
        }
        return false;
    }

    //If can smelt --> TRUE
    public void smelt() {

        ItemStack result = this.getRecipeResult();
        this.decrStackSize(0, 1);
        ItemStack stack3 = this.getStackInSlot(2);

        if (stack3.isEmpty()) {

            this.setInventorySlotContents(3, result.copy());
        } else {

            stack3.setCount(stack3.getCount() + result.getCount());
        }
    }


    public int getFullRecipeTime() {
        return 50;
    }


    public int getFullBurnTime() {
        return 100;
    }


    public boolean isBurning() {
        return burningTimeLeft > 0;
    }

    @Override
    public void update() {

        if (!this.world.isRemote) {

            if (this.isBurning()) {
                this.burningTimeLeft--;
            }

            if (!this.isBurning() && this.canSmelt() && !this.hasFuelEmpty()) {
                Minecraft.getMinecraft().player.sendMessage(new TextComponentString(">>> Livre ouvert"));
                this.burningTimeLeft = this.getFullBurnTime();
                this.decrStackSize(1, 1);
                this.decrStackSize(2, 1);
            }


            if (this.isBurning() && this.canSmelt()) {
                this.timePassed++;
                if (timePassed >= this.getFullRecipeTime()) {
                    timePassed = 0;
                    this.smelt();
                }
            } else {
                timePassed = 0;
            }
            this.markDirty();
        }

    }
}
