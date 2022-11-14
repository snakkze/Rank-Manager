package net.snakkze.rankmanager.commands;

import net.snakkze.rankmanager.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetRankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("rankmanager.getrank")) {
                if(args.length == 0) {
                    sender.sendMessage(Main.getInstance().getSQL.getRank(p.getUniqueId()));
                } else if(args.length == 1) {
                    Player t = Bukkit.getPlayer(args[0]);
                        if(t != null) {
                            sender.sendMessage(Main.getInstance().getSQL.getRank(t.getUniqueId()));
                    }
                }
            }
        }
        return true;
    }
}
