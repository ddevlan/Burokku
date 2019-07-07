package co.burokku.books.lunar.packet;

import org.bukkit.entity.Player;

public class LCPacketDebug extends LCPacket {

    public LCPacketDebug(int id) {
        super(id);
    }

    @Override
    public byte[] getData(Player player) {
        return new byte[256];
    }
}
