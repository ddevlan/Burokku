package co.burokku.books.command.param.defaults;

import co.burokku.books.BooksPlugin;
import co.burokku.books.command.param.ParameterType;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class UUIDParameterType implements ParameterType<UUID> {

    public UUID transform(CommandSender sender, String source) {
        if (sender instanceof Player && (source.equalsIgnoreCase("self") || source.equals(""))) {
            return (((Player) sender).getUniqueId());
        }

        UUID uuid = UUID.fromString(source);

        if (uuid == null) {
            sender.sendMessage(ChatColor.RED + source + " has never joined the server.");
            return (null);
        }

        return (uuid);
    }

    public List<String> tabComplete(Player sender, Set<String> flags, String source) {
        List<String> completions = new ArrayList<>();

        for (Player player : BooksPlugin.getInstance().getServer().getOnlinePlayers()) {
            if (StringUtils.startsWithIgnoreCase(player.getName(), source)) {
                completions.add(player.getName());
            }
        }

        return (completions);
    }

}