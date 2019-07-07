package co.burokku.books.lunar.packet;

import co.burokku.books.util.LunarHookUtil;
import org.bukkit.entity.Player;

public abstract class LCPacket {

    protected byte packetId;

    public LCPacket(int id) {
        this.packetId = (byte) id;
    }

    public abstract byte[] getData(Player player);

    public void send(Player source) {
        LunarHookUtil.sendDataAll(getData(source));
    }

    public void send(Player source, Player player) {
        LunarHookUtil.sendDataOnly(getData(source), player);
    }

}
