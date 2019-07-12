package co.burokku.books.command.commands;

import co.burokku.books.BooksPlugin;
import co.burokku.books.command.Command;
import co.burokku.books.pmf.PacketPlayer;
import co.burokku.books.pmf.packets.lunar.LCPacket;
import co.burokku.books.pmf.packets.lunar.emote.LCPacketEmoteBroadcast;
import co.burokku.books.pmf.packets.lunar.nametags.LCPacketNametagsOverride;
import co.burokku.books.pmf.packets.lunar.staff.LCPacketStaffModState;
import co.burokku.books.pmf.packets.lunar.type.Emote;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class DebugCommands {

    private static List<String> mods = Arrays.asList("bunnyhop", "xray", "nametags", "noclip");

    @Command(names = "dbug")
    public static void debug(Player player) {
        mods.forEach(s -> BooksPlugin.getInstance().getPacketManager().sendPacket(new PacketPlayer(player), new LCPacketStaffModState(s, true)));
        BooksPlugin.getInstance().getPacketManager().sendPacket(new PacketPlayer(player), new LCPacketEmoteBroadcast(player, Emote.DAB));

        LCPacket packet = new LCPacketNametagsOverride(player,  "§4" + player.getName(), "§7[Staff]");

        BooksPlugin.getInstance().getPacketManager().sendPacketToAll(packet);
    }

}
