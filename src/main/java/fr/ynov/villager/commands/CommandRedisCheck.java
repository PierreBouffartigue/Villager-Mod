package fr.ynov.villager.commands;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.ynov.villager.bdd.MongoConnexion;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import org.bson.Document;
import org.bson.types.ObjectId;

public class CommandRedisCheck extends CommandBase {
    @Override
    public String getName() {
        return "check";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "check";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        /**
        Jedis j = JedisConnexion.initJedis().getResource();
        j.select(0);
        j.set("abc", "def");
        String value = j.get("abc");
        Minecraft.getMinecraft().player.sendChatMessage("tttt");
        **/

        MongoDatabase villagerDB = MongoConnexion.initMongo().getDatabase("villager");
        MongoCollection<Document> villager = villagerDB.getCollection("villager");

        for (String name : villagerDB.listCollectionNames()) {
            Minecraft.getMinecraft().player.sendChatMessage("Collections : " + name);
        }
    }
}

