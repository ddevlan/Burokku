package co.burokku.books.npc;

import co.burokku.books.npc.packet.CustomNPCPacket;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Set;
import java.util.UUID;

public interface ICustomNPC {

    void setName(String name);
    String getName();

    void show(Player player);
    void hide(Player player);
    Set<UUID> visibleTo();

    void setDisplayName(String name);
    String getDisplayName();

    void setSkin(String url);   //todo make custom skin object
    //getSkin

    Location getLocation();
    void teleport(Location location);
    Vector getVelocity();
    void setVelocity();

    void setItemInHand(ItemStack itemStack);
    ItemStack getItemInHand();

    void setArmorContents(ItemStack[] itemStacks);
    ItemStack[] getArmorContents();

    void setOnFire(boolean b);
    boolean isOnFire();

    void setSprinting(boolean b);
    boolean isSprinting();

    void setSneaking(boolean b);
    boolean isSneaking();

    void setEating(boolean b);
    boolean isEating();

    void setDrinking(boolean b);
    boolean isDrinking();

    void setBlocking(boolean b);
    boolean isBlocking();

    void swing();
    void jump();
    void damage();
    void move(Location location);

    void sendPacket(CustomNPCPacket packet);

}
