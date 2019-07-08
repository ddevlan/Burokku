package co.burokku.books.pmf.packets.bungee;

import co.burokku.books.pmf.PacketWriter;
import co.burokku.books.pmf.RawPacket;

import java.io.IOException;

/**
 * Created by iKeirNez on 01/01/14.
 */
public class PacketMessage extends RawPacket {

    public String name;
    public String message;

    public PacketMessage(String name, String message){
        super("BungeeCord");
        this.name = name;
        this.message = message;
    }

    @Override
    public PacketWriter write() throws IOException {
        PacketWriter packetWriter = new PacketWriter(this);
        packetWriter.writeUTF("Message");
        packetWriter.writeUTF(name);
        packetWriter.writeUTF(message);
        return packetWriter;
    }
}
