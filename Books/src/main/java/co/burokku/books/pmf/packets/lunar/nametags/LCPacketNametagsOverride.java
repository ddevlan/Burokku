package co.burokku.books.pmf.packets.lunar.nametags;

import co.burokku.books.pmf.PacketWriter;
import co.burokku.books.pmf.packets.lunar.LCPacket;
import co.burokku.books.util.PlayerUtil;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.UUID;

public class LCPacketNametagsOverride extends LCPacket {

    private UUID overridePlayer;
    private String[] tags;

    public LCPacketNametagsOverride(Player overridePlayer, String... tags) {
        super(7);

        this.overridePlayer = overridePlayer.getUniqueId();
        this.tags = tags;
    }

    @Override
    public PacketWriter write() throws IOException {
        PacketWriter writer = new PacketWriter(this);

        writer.write(packetId);
        writer.write(PlayerUtil.getBytesFromUUID(overridePlayer));

        writer.writeBoolean(true);
        writer.write(writer.getVarInt(tags.length));

        for (String tag : tags) {
            writer.write(writer.getStringBytes(tag));
        }

        return writer;
    }
}
