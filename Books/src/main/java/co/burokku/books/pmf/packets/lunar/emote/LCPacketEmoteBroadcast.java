package co.burokku.books.pmf.packets.lunar.emote;

import co.burokku.books.pmf.PacketWriter;
import co.burokku.books.pmf.packets.lunar.LCPacket;
import co.burokku.books.pmf.packets.lunar.type.Emote;
import co.burokku.books.util.PlayerUtil;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.UUID;

public class LCPacketEmoteBroadcast extends LCPacket {

    private UUID emotingPlayer;
    private Emote emote;

    public LCPacketEmoteBroadcast(Player emotingPlayer, Emote emote) {
        super(26);

        this.emotingPlayer = emotingPlayer.getUniqueId();
        this.emote = emote;
    }

    @Override
    public PacketWriter write() throws IOException {
        PacketWriter writer = new PacketWriter(this);

        writer.write(26);
        writer.write(PlayerUtil.getBytesFromUUID(emotingPlayer));
        writer.writeInt(emote.ordinal());

        return writer;
    }
}
