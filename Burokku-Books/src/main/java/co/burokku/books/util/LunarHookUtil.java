package co.burokku.books.util;

import co.burokku.books.BooksPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LunarHookUtil {

    public static void sendLunarData(byte[] data) {
        for (Player o : Bukkit.getServer().getOnlinePlayers()) {
            o.sendPluginMessage(BooksPlugin.getInstance(), "Lunar-Client", data);
        }
    }

}
