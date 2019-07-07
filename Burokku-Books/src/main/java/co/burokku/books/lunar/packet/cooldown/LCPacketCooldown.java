package co.burokku.books.lunar.packet.cooldown;

import co.burokku.books.lunar.packet.LCPacket;
import net.minecraft.util.com.google.common.io.ByteArrayDataOutput;
import net.minecraft.util.com.google.common.io.ByteStreams;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LCPacketCooldown extends LCPacket {

    private String name;
    private int id;
    private long time;

    public LCPacketCooldown(String name, Material mat, int seconds) {
        super(3);

        this.name = name;
        this.id = mat.getId();
        this.time = seconds * 1000;
    }

    @Override
    public byte[] getData(Player player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput(256);
        byte[] nameData = name.getBytes();

        try {
            out.writeByte(packetId);
            out.write(nameData);
            out.write(id);
            out.writeLong(time);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }
}
