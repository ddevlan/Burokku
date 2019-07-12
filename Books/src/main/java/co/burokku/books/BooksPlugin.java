package co.burokku.books;

import co.burokku.books.command.CommandHandler;
import co.burokku.books.pmf.PacketManager;
import co.burokku.books.pmf.PacketPlayer;
import co.burokku.books.pmf.impl.BukkitPacketManager;
import co.burokku.books.pmf.packets.lunar.LCPacket;
import co.burokku.books.pmf.packets.lunar.nametags.LCPacketNametagsOverride;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class BooksPlugin extends JavaPlugin implements Listener {

    @Getter
    private static BooksPlugin instance;
    private PacketManager packetManager;

    @Override
    public void onEnable() {
        instance = this;

        init_lunar_hook();

        CommandHandler.init();
        CommandHandler.loadCommandsFromPackage(instance, "co.burokku.books.command.commands");

        Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.PEACEFUL);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void init_lunar_hook() {
        packetManager = new BukkitPacketManager(this, "Lunar-Client");

        instance.getServer().getPluginManager().registerEvents(this, instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        LCPacket packet = new LCPacketNametagsOverride(event.getPlayer(),  "§4" + event.getPlayer().getName(), "§7[Staff]");

        for (Player player : Bukkit.getOnlinePlayers()) {
            packetManager.sendPacket(new PacketPlayer(player), packet);
        }
    }

}
