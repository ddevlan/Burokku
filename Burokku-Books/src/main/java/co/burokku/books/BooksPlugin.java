package co.burokku.books;

import co.burokku.books.command.CommandHandler;
import co.burokku.books.lunar.LunarHookListener;
import co.burokku.books.lunar.packet.LCPacketEmote;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BooksPlugin extends JavaPlugin {

    @Getter
    private static BooksPlugin instance;

    private Map<LCPacketEmote.Emote, LCPacketEmote> emotes;

    @Override
    public void onEnable() {
        instance = this;

        init_emotes();

        getServer().getMessenger().registerIncomingPluginChannel(instance, "Lunar-Client", new LunarHookListener(instance));
        getServer().getMessenger().registerOutgoingPluginChannel(instance, "Lunar-Client");

        CommandHandler.init();
        CommandHandler.loadCommandsFromPackage(instance, "co.burokku.books.command.commands");
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void init_emotes() {
        this.emotes = new HashMap<>();

        for (LCPacketEmote.Emote value : LCPacketEmote.Emote.values()) {
            emotes.put(value, new LCPacketEmote(value));
        }
    }

}
