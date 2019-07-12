package co.burokku.books.pmf.packets.lunar.staff;

import co.burokku.books.pmf.PacketWriter;
import co.burokku.books.pmf.packets.lunar.LCPacket;

import java.io.DataInputStream;
import java.io.IOException;

public class LCPacketStaffModState extends LCPacket {

    private String mod;
    private boolean state;

    public LCPacketStaffModState(String mod, boolean state) {
        super(12);

        this.mod = mod;
        this.state = state;
    }

    @Override
    public void handle(DataInputStream dataInputStream) throws IOException {
        super.handle(dataInputStream);
    }

    @Override
    public PacketWriter write() throws IOException {
        PacketWriter packetWriter = new PacketWriter(this);

        packetWriter.write(packetId);
        packetWriter.writeString(mod);
        packetWriter.writeBoolean(state);

        return packetWriter;
    }
}
