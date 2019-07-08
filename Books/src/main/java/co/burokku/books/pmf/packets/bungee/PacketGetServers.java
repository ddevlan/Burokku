package co.burokku.books.pmf.packets.bungee;

import co.burokku.books.pmf.PacketWriter;
import co.burokku.books.pmf.RawPacket;

import java.io.IOException;

/**
 * Created by iKeirNez on 01/01/14.
 */
public class PacketGetServers extends RawPacket {

    public PacketGetServers(){
        super("BungeeCord");
    }

    @Override
    public PacketWriter write() throws IOException {
        PacketWriter packetWriter = new PacketWriter(this);
        packetWriter.writeUTF("GetServers");
        return packetWriter;
    }
}
