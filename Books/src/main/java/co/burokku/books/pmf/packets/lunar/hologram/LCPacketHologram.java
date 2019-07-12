package co.burokku.books.pmf.packets.lunar.hologram;

import co.burokku.books.pmf.PacketWriter;
import co.burokku.books.pmf.packets.lunar.LCPacket;

import java.io.IOException;

public class LCPacketHologram extends LCPacket {

    public LCPacketHologram() {
        super(4);
    }

    @Override
    public PacketWriter write() throws IOException {
        return null;
    }
}
