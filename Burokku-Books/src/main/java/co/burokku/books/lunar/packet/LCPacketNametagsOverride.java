package co.burokku.books.lunar.packet;

import co.burokku.books.util.LunarHookUtil;
import co.burokku.books.util.UUIDUtil;
import org.bukkit.entity.Player;

import java.util.List;

public class LCPacketNametagsOverride {

    private String[] tags;

    public LCPacketNametagsOverride(String tag) {
        this.tags = new String[] {tag};
    }

    public LCPacketNametagsOverride(String[] tags) {
        this.tags = tags;
    }

    public LCPacketNametagsOverride(List<String> tags) {
        this.tags = tags.toArray(new String[]{});
    }

    public void update(Player player) {
        LunarHookUtil.sendLunarData(getData(player));
    }

    private byte[] getData(Player player) {
        byte[] data = new byte[0];
        data[0] = (byte) 0; // <--- packet data
        data[20] = (byte) 0; // <--- tags -> bytes

        byte[] uuid = UUIDUtil.asBytes(player.getUniqueId());
        for (int i = 1; i <= uuid.length; i++) {
            data[i] = uuid[i - 1];
        }
        /*
            byte amount --

            byte - packet id at index 0
            tags -> byte[]
            uuid -> byte[]
         */
        return null;
    }

}
