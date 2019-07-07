package co.burokku.books;

import co.burokku.books.command.CommandHandler;
import co.burokku.books.lunar.LunarHookListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class BooksPlugin extends JavaPlugin {

    @Getter
    private static BooksPlugin instance;

    private LunarHookListener lunarHookListener;

    @Override
    public void onEnable() {
        instance = this;

        this.lunarHookListener = new LunarHookListener(instance);

        getServer().getMessenger().registerIncomingPluginChannel(instance, "Lunar-Client", lunarHookListener);
        getServer().getMessenger().registerOutgoingPluginChannel(instance, "Lunar-Client");

        CommandHandler.init();
        CommandHandler.loadCommandsFromPackage(instance, "co.burokku.books.command.commands");

        Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.PEACEFUL);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

}
