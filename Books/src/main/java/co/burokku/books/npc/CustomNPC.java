package co.burokku.books.npc;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CustomNPC implements ICustomNPC {

    private String name, displayName;
    private String skin;

    private Set<UUID> visableIds;

    private Location location;
    private Vector velocity;

    private int motX, motY, motZ;

    public CustomNPC(String name, String skin) {
        this.name = name;
        this.displayName = name;

        this.skin = skin;
        this.visableIds = new HashSet<>();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void show(Player player) {
        visableIds.add(player.getUniqueId());

        //TODO update packets
    }

    @Override
    public void hide(Player player) {
        visableIds.remove(player.getUniqueId());

        //TODO update packets
    }

    @Override
    public Set<UUID> visibleTo() {
        return visableIds;
    }

    @Override
    public void setDisplayName(String name) {
        this.displayName = ChatColor.translateAlternateColorCodes('&', name);

        //TODO update packets
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setSkin(String url) {
        this.skin = url;

        //TODO skin packets
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void teleport(Location location) {
        this.location = location;

        //TODO teleport packets
    }

    @Override
    public Vector getVelocity() {
        return null;
    }

    @Override
    public void setVelocity() {

    }

    @Override
    public void setItemInHand(ItemStack itemStack) {

    }

    @Override
    public ItemStack getItemInHand() {
        return null;
    }

    @Override
    public void setArmorContents(ItemStack[] itemStacks) {

    }

    @Override
    public ItemStack[] getArmorContents() {
        return new ItemStack[0];
    }

    @Override
    public void setOnFire(boolean b) {

    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    public void setSprinting(boolean b) {

    }

    @Override
    public boolean isSprinting() {
        return false;
    }

    @Override
    public void setSneaking(boolean b) {

    }

    @Override
    public boolean isSneaking() {
        return false;
    }

    @Override
    public void setEating(boolean b) {

    }

    @Override
    public boolean isEating() {
        return false;
    }

    @Override
    public void setDrinking(boolean b) {

    }

    @Override
    public boolean isDrinking() {
        return false;
    }

    @Override
    public void setBlocking(boolean b) {

    }

    @Override
    public boolean isBlocking() {
        return false;
    }

    @Override
    public void swing() {

    }

    @Override
    public void jump() {

    }

    @Override
    public void damage() {

    }

    private void motionX(int x) {
        this.motX = x;
    }

    private void motionY(int y) {
        this.motY = y;
    }

    private void motionZ(int z) {
        this.motZ = z;
    }

    @Override
    public void move(Location location) {

    }

}
