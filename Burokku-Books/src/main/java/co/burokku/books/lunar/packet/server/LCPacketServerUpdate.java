package co.burokku.books.lunar.packet.server;

import co.burokku.books.lunar.packet.LCPacket;
import net.minecraft.util.com.google.common.io.ByteArrayDataOutput;
import net.minecraft.util.com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

public class LCPacketServerUpdate extends LCPacket {

    private String server;

    public LCPacketServerUpdate(String server) {
        super(11);

        this.server = server;
    }

    @Override
    public byte[] getData(Player player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput(256);

        try {
            out.writeByte(packetId);
            out.write(server.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

}
