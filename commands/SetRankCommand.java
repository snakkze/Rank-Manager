package net.snakkze.rankmanager.commands;

import net.snakkze.rankmanager.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRankCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Commands can only be executed by Players!");
            return true;
        }

        Player p = (Player) sender;
        if(p.hasPermission("serverutils.setrank")) {
            if (cmd.getName().equalsIgnoreCase("setrank")) {
                if(args.length >= 2) {
                    try {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(args[1].equalsIgnoreCase("owner")) {
                            target.setOp(true);
                            Main.getInstance().mySQL.getData().setRank(target.getUniqueId(), "owner");
                            p.sendMessage("§a" + target.getDisplayName() + " is now an Owner!");
                            target.sendMessage("§aYou're now an Owner! To recive the rank you must rejoin!");
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                        if(args[1].equalsIgnoreCase("admin")) {
                            target.setOp(true);
                            Main.getInstance().mySQL.getData().setRank(target.getUniqueId(), "admin");
                            p.sendMessage("§a" + target.getDisplayName() + " is now an Admin!");
                            target.sendMessage("§aYou're now an Admin! To recive the rank you must rejoin!");
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                        if(args[1].equalsIgnoreCase("moderator")) {
                            target.setOp(false);
                            Main.getInstance().mySQL.getData().setRank(target.getUniqueId(), "moderator");
                            p.sendMessage("§a" + target.getDisplayName() + " is now an Moderator!");
                            target.sendMessage("§aYou're now an Moderator! To recive the rank you must rejoin!");
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                        if(args[1].equalsIgnoreCase("developer")) {
                            target.setOp(false);
                            Main.getInstance().mySQL.getData().setRank(target.getUniqueId(), "developer");
                            p.sendMessage("§a" + target.getDisplayName() + " is now an Developer!");
                            target.sendMessage("§aYou're now an Developer! To recive the rank you must rejoin!");
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                        if(args[1].equalsIgnoreCase("supporter")) {
                            target.setOp(false);
                            Main.getInstance().mySQL.getData().setRank(target.getUniqueId(), "supporter");
                            p.sendMessage("§a" + target.getDisplayName() + " is now an Supporter!");
                            target.sendMessage("§aYou're now an Supporter! To recive the rank you must rejoin!");
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                        if(args[1].equalsIgnoreCase("contentcreator")) {
                            target.setOp(false);
                            Main.getInstance().mySQL.getData().setRank(target.getUniqueId(), "contentcreator");
                            p.sendMessage("§a" + target.getDisplayName() + " is now an ContentCreator!");
                            target.sendMessage("§aYou're now an ContentCreator! To recive the rank you must rejoin!");
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                        if(args[1].equalsIgnoreCase("supreme")) {
                            target.setOp(false);
                            Main.getInstance().mySQL.getData().setRank(target.getUniqueId(), "supreme");
                            p.sendMessage("§a" + target.getDisplayName() + " is now an Supreme!");
                            target.sendMessage("§aYou're now an Supreme! To recive the rank you must rejoin!");
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                        if(args[1].equalsIgnoreCase("premium")) {
                            target.setOp(false);
                            Main.getInstance().mySQL.getData().setRank(target.getUniqueId(), "premium");
                            p.sendMessage("§a" + target.getDisplayName() + " is now an Premium!");
                            target.sendMessage("§aYou're now an Premium! To recive the rank you must rejoin!");
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                        if(args[1].equalsIgnoreCase("default")) {
                            target.setOp(false);
                            Main.getInstance().mySQL.getData().setRank(target.getUniqueId(), "default");
                            p.sendMessage("§a" + target.getDisplayName() + " is now an Spieler!");
                            target.sendMessage("§aYou're now an Spieler! To recive the rank you must rejoin!");
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }

                    } catch (IllegalArgumentException e) {
                        p.sendMessage("§c/setrank <Player> <Rank>");
                    }
                } else {
                    p.sendMessage("§c/setrank <Player> <Rank>");
                }
            }
        } else {
            p.sendMessage("§cYou must be an OP!");
        }
        return true;
    }
}