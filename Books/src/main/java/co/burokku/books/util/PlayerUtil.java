package co.burokku.books.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PlayerUtil {

    public static Set<Player> getPlayersFromUUIDs(Collection<UUID> uuids) {
        Set<Player> players = new HashSet<>();

        for (UUID uuid : uuids) {
            if (Bukkit.getPlayer(uuid) != null) {
                players.add(Bukkit.getPlayer(uuid));
            }
        }

        return players;
    }

    public static byte[] getBytesFromUUID(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return bb.array();
    }

}
