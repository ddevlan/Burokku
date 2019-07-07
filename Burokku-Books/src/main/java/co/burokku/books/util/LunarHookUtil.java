package co.burokku.books.util;

import co.burokku.books.BooksPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LunarHookUtil {

    public static void sendDataAll(byte[] data) {
        for (Player o : Bukkit.getServer().getOnlinePlayers()) {
            o.sendPluginMessage(BooksPlugin.getInstance(), "Lunar-Client", data);
        }
    }

    public static void sendDataOnly(byte[] data, Player player) {
        player.sendPluginMessage(BooksPlugin.getInstance(), "Lunar-Client", data);
    }

    /*public static byte[] compilePacket(byte packetId, byte[] source) {
        byte[] data = new byte[256];
        data[0] = packetId;
        data[]
    }*/

}
