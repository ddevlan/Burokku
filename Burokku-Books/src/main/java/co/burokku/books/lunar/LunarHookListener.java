package co.burokku.books.lunar;

import co.burokku.books.BooksPlugin;
import co.burokku.books.lunar.packet.LCPacket;
import co.burokku.books.lunar.packet.server.LCPacketServerUpdate;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitRunnable;

public class LunarHookListener implements PluginMessageListener, Listener {

    private BooksPlugin plugin;
    @Getter
    private LCPacket serverUpdate;

    public LunarHookListener(BooksPlugin plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);

        this.serverUpdate = new LCPacketServerUpdate("ElusiveMC Network");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        new BukkitRunnable() {
            @Override
            public void run() {
                serverUpdate.send(event.getPlayer(), event.getPlayer());
            }
        }.runTaskLater(plugin, 20 * 5);
    }

    @Override
    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {

    }
}
