package co.burokku.books.pmf.packets.lunar;

import co.burokku.books.pmf.PacketWriter;
import co.burokku.books.pmf.RawPacket;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class LCPacket extends RawPacket {

    public int packetId;

    public LCPacket(int packetId) {
        super("Lunar-Client");
        this.packetId = packetId;
    }

    @Override
    public void handle(DataInputStream dataInputStream) throws IOException {
        System.out.println(dataInputStream.readUTF());
    }

    @Override
    public abstract PacketWriter write() throws IOException;

}
