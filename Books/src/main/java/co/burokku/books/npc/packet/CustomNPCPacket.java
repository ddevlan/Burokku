package co.burokku.books.npc.packet;

import co.burokku.books.npc.ICustomNPC;
import lombok.Getter;
import net.minecraft.server.v1_7_R4.PacketPlayOutEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class CustomNPCPacket {

    private Class packetClass;
    private List<ICustomNPC> listening;

    public CustomNPCPacket(Class<? extends PacketPlayOutEntity> clazz) {
        this.packetClass = clazz;
        this.listening = new ArrayList<>();
    }

    public void registerPacket(ICustomNPC customNPC) {
        this.listening.add(customNPC);
    }

    public void unregisterPacket(ICustomNPC customNPC) {
        this.listening.remove(customNPC);
    }

}
