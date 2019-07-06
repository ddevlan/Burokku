package co.burokku.books.lunar.packet;

import co.burokku.books.util.LunarHookUtil;
import co.burokku.books.util.UUIDUtil;
import org.bukkit.entity.Player;

public class LCPacketEmote {

    public enum Emote {
        WAVE,
        HANDS_UP,
        FLOSS,
        DAB,
        T_POSE,
        SHRUG,
        FACEPALM;

        public static boolean exists(String name) {
            for (Emote value : values()) {
                if (value.toString().equalsIgnoreCase(name.replace(" ", "_"))) {
                    return true;
                }
            }
            return false;
        }

        public static Emote getByName(String name) {
            for (Emote value : values()) {
                if (value.toString().equalsIgnoreCase(name.replace(" ", "_"))) {
                    return value;
                }
            }
            return null;
        }

        public byte[] getData(Player player) {
            byte[] data = new byte[256];
            data[0] = (byte) 26;
            data[20] = (byte) ordinal();
            byte[] uuid = UUIDUtil.asBytes(player.getUniqueId());
            for (int i = 1; i <= uuid.length; i++) {
                data[i] = uuid[i - 1];
            }
            return data;
        }

    }

    private Emote emote;

    public LCPacketEmote(Emote emote) {
        this.emote = emote;
    }

    public LCPacketEmote(int emote) {
        this.emote = Emote.values()[emote];
    }

    public void emote(Player player) {
        LunarHookUtil.sendLunarData(emote.getData(player));
    }

}
