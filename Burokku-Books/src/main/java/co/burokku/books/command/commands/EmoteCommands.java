package co.burokku.books.command.commands;

import co.burokku.books.BooksPlugin;
import co.burokku.books.command.Command;
import co.burokku.books.command.param.Parameter;
import co.burokku.books.lunar.packet.LCPacketEmote;
import org.bukkit.entity.Player;

public class EmoteCommands {

    @Command(names = "wave", permissionNode = "burokku.emote.wave")
    public static void wave(Player sender, @Parameter(name = "player", defaultValue = "self") Player player) {
        BooksPlugin.getInstance().getEmotes().get(LCPacketEmote.Emote.WAVE).emote(player);
        sender.sendMessage("\uD83D\uDC4B");
        player.sendMessage("\uD83D\uDC4B");
    }

    @Command(names = "handsup", permissionNode = "burokku.emote.handsup")
    public static void hands_up(Player sender, @Parameter(name = "player", defaultValue = "self") Player player) {
        BooksPlugin.getInstance().getEmotes().get(LCPacketEmote.Emote.HANDS_UP).emote(player);
        sender.sendMessage("gachiiHYPER");
        player.sendMessage("gachiiHYPER");
    }

    @Command(names = "floss", permissionNode = "burokku.emote.floss")
    public static void floss(Player sender, @Parameter(name = "player", defaultValue = "self") Player player) {
        BooksPlugin.getInstance().getEmotes().get(LCPacketEmote.Emote.FLOSS).emote(player);
        sender.sendMessage("squadW");
        player.sendMessage("squadW");
    }

    @Command(names = "dab", permissionNode = "burokku.emote.dab")
    public static void dab(Player sender, @Parameter(name = "player", defaultValue = "self") Player player) {
        BooksPlugin.getInstance().getEmotes().get(LCPacketEmote.Emote.DAB).emote(player);
        sender.sendMessage("<o/");
        player.sendMessage("\\o>");
    }

    @Command(names = "tpose", permissionNode = "burokku.emote.tpose")
    public static void tpose(Player sender, @Parameter(name = "player", defaultValue = "self") Player player) {
        BooksPlugin.getInstance().getEmotes().get(LCPacketEmote.Emote.T_POSE).emote(player);
        sender.sendMessage("T");
        player.sendMessage("T");
    }

    @Command(names = "shrug", permissionNode = "burokku.emote.shrug")
    public static void shrug(Player sender, @Parameter(name = "player", defaultValue = "self") Player player) {
        BooksPlugin.getInstance().getEmotes().get(LCPacketEmote.Emote.SHRUG).emote(player);
        sender.sendMessage("¯\\_(ツ)_/¯");
        player.sendMessage("¯\\_(ツ)_/¯");
    }

    @Command(names = "facepalm", permissionNode = "burokku.emote.facepalm")
    public static void facepalm(Player sender, @Parameter(name = "player", defaultValue = "self") Player player) {
        BooksPlugin.getInstance().getEmotes().get(LCPacketEmote.Emote.FACEPALM).emote(player);
        sender.sendMessage("FailFish");
        player.sendMessage("FailFish");
    }

}