package co.burokku.books.pmf.packets.bungee;

import co.burokku.books.pmf.PacketWriter;
import co.burokku.books.pmf.StandardPacket;
import co.burokku.books.pmf.RawPacket;

import java.io.IOException;

/**
 * Created by iKeirNez on 22/02/14.
 */
public class PacketForward extends RawPacket {

    public String server;
    public String channel;
    public StandardPacket packet;

    public PacketForward(String server, StandardPacket packet){
        super("BungeeCord");
        this.server = server;
        this.packet = packet;
    }

    @Override
    public PacketWriter write() throws IOException {
        PacketWriter packetWriter = new PacketWriter(this);
        packetWriter.writeUTF("Forward");
        packetWriter.writeUTF(server);
        packetWriter.writeUTF(channel);
        byte[] msgBytes = packet.write().toByteArray();
        packetWriter.writeShort(msgBytes.length);
        packetWriter.write(msgBytes);
        return packetWriter;
    }
}
