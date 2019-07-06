package co.burokku.books.lunar;

import co.burokku.books.BooksPlugin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class LunarHookListener implements PluginMessageListener {

    private BooksPlugin plugin;

    public LunarHookListener(BooksPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {

    }
}
