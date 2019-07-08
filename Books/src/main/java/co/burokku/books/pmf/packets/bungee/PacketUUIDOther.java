package co.burokku.books.pmf.packets.bungee;

import co.burokku.books.pmf.PacketWriter;
import co.burokku.books.pmf.RawPacket;

import java.io.IOException;

/**
 * Created by iKeirNez on 01/01/14.
 */
public class PacketUUIDOther extends RawPacket {

    public String name;

    public PacketUUIDOther(String name){
        super("BungeeCord");
        this.name = name;
    }

    @Override
    public PacketWriter write() throws IOException {
        PacketWriter packetWriter = new PacketWriter(this);
        packetWriter.writeUTF("UUIDOther");
        packetWriter.writeUTF(name);
        return packetWriter;
    }
}
