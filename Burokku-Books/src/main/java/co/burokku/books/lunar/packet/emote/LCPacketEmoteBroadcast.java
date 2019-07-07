package co.burokku.books.lunar.packet.emote;

import co.burokku.books.lunar.packet.LCPacket;
import co.burokku.books.lunar.packet.type.Emote;
import co.burokku.books.util.UUIDUtil;
import net.minecraft.util.com.google.common.io.ByteArrayDataOutput;
import net.minecraft.util.com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.UUID;

public class LCPacketEmoteBroadcast extends LCPacket {

    private int id;
    private UUID uuid;

    public LCPacketEmoteBroadcast(Emote emote, Player player) {
        super(26);
        this.id = emote.getId();
        this.uuid = player.getUniqueId();
    }

    public LCPacketEmoteBroadcast(int id, Player player) {
        super(26);
        this.id = id;
        this.uuid = player.getUniqueId();
    }

    /*
        0 = packet id
        1-17 = uuid
        20 = emote id
     */
    @Override
    public byte[] getData(Player player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput(256);

        try {
            out.writeByte(packetId);
            out.writeShort(UUIDUtil.asBytes(uuid).length);
            out.write(UUIDUtil.asBytes(uuid));
            out.write(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

}
