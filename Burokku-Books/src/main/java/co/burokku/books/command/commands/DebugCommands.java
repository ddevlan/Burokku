package co.burokku.books.command.commands;

import co.burokku.books.BooksPlugin;
import co.burokku.books.command.Command;
import co.burokku.books.lunar.packet.LCPacket;
import co.burokku.books.lunar.packet.cooldown.LCPacketCooldown;
import co.burokku.books.lunar.packet.emote.LCPacketEmoteBroadcast;
import co.burokku.books.lunar.packet.staff.LCPacketStaffModState;
import co.burokku.books.lunar.packet.type.Emote;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DebugCommands {

    @Command(names = "dbug")
    public static void debug(Player player) {
        List<LCPacket> packets = new ArrayList<>();

        packets.add(new LCPacketStaffModState("xray"));
//        packets.add(new LCPacketStaffModState("nametags"));
//        packets.add(new LCPacketStaffModState("noclip"));
        packets.add(new LCPacketCooldown("debug", Material.DIAMOND_HOE, 15));
        packets.add(new LCPacketStaffModState("bunnyhop"));
        packets.add(new LCPacketEmoteBroadcast(Emote.DAB, player));
        packets.add(BooksPlugin.getInstance().getLunarHookListener().getServerUpdate());

        packets.forEach(lcPacket -> lcPacket.send(player));
    }

}
