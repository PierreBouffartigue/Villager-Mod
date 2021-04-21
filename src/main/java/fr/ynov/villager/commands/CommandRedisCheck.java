package fr.ynov.villager.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandRedisCheck extends CommandBase {
    @Override
    public String getName() {
        return "jedis";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "jedis";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(">>> Jedis check"));
    }
}

