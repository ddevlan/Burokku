package co.burokku.books.lunar.packet.staff;

import co.burokku.books.lunar.packet.LCPacket;
import net.minecraft.util.com.google.common.io.ByteArrayDataOutput;
import net.minecraft.util.com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class LCPacketStaffModState extends LCPacket {

    private String mod;

    public LCPacketStaffModState(String mod) {
        super(12);

        this.mod = mod;
    }

    @Override
    public byte[] getData(Player player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput(256);

        try {
            out.write(packetId);
            out.write(mod.getBytes());
            out.writeBoolean(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

}
