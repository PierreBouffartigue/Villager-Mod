package fr.ynov.villager.book;

import fr.ynov.villager.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class BookMod extends ItemWritableBook {
    public BookMod(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("WIP");
    }

    @Override
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        Minecraft.getMinecraft().player.sendChatMessage("Livre ouvert");
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
