package fr.ynov.villager.commands;

import fr.ynov.villager.bdd.JedisConnexion;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        Jedis j = JedisConnexion.initJedis().getResource();
        j.select(0);
        j.set("abc", "def");
        String value = j.get("abc");
        Minecraft.getMinecraft().player.sendChatMessage("tttt");
    }
}

