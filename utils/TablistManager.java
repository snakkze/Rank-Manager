package net.snakkze.rankmanager.utils;

import net.snakkze.rankmanager.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistManager {

    public void setAllPlayerTeams() {
        Bukkit.getOnlinePlayers().forEach(this::setTablist);
    }

    public void setTablist(Player p) {
        Scoreboard board = p.getScoreboard();

        Team Owner = board.getTeam("001owner");
        Team Admin = board.getTeam("002Admin");
        Team Moderator = board.getTeam("003100Moderator");
        Team Developer = board.getTeam("004Developer");
        Team Supporter = board.getTeam("005Supporter");
        Team ContentCreator = board.getTeam("006ContentCreator");
        Team Supreme = board.getTeam("007Supreme");
        Team Premium = board.getTeam("008Premium");
        Team Default = board.getTeam("009Default");

        if(Owner == null) {
            Owner = board.registerNewTeam("001Owner");
        }
        if(Admin == null) {
            Admin =board.registerNewTeam("002Admin");
        }
        if(Moderator == null) {
            Moderator = board.registerNewTeam("003Moderator");
        }
        if(Developer == null) {
            Developer = board.registerNewTeam("004Developer");
        }
        if(Supporter == null) {
            Supporter = board.registerNewTeam("005Supporter");
        }
        if(ContentCreator == null) {
            ContentCreator = board.registerNewTeam("006ContentCreator");
        }
        if(Supreme == null) {
            Supreme = board.registerNewTeam("007Supreme");
        }
        if(Premium == null) {
            Premium = board.registerNewTeam("008Premium");
        }
        if(Default == null) {
            Default = board.registerNewTeam("009Default");
        }

        Owner.setPrefix(" [§c§lOwner§f] ");
        Admin.setPrefix(" [§cAdmin§f] ");
        Moderator.setPrefix(" §7[§2Moderator§7]§f ");
        Developer.setPrefix(" §7[§9Developer§7]§f ");
        Supporter.setPrefix(" §7[§aSupporter§7] §f ");
        ContentCreator.setPrefix(" §7[§fContent §cCreator§7]§f ");
        Supreme.setPrefix("§7[§bSupreme§7]§f ");
        Premium.setPrefix("§7[§6Premium§7]§f ");
        Default.setPrefix("§7[Default]§f ");

        for(Player target : Bukkit.getOnlinePlayers()) {
            if(Main.getInstance().getSQL.getRank(target.getUniqueId()).equals("owner")) {
                Owner.addEntry(target.getName());
                continue;
            } else if(Main.getInstance().getSQL.getRank(target.getUniqueId()).equals("admin")) {
                Admin.addEntry(target.getName());
                continue;
            } else if(Main.getInstance().getSQL.getRank(target.getUniqueId()).equals("moderator")) {
                Moderator.addEntry(target.getName());
                continue;
            } else if(Main.getInstance().getSQL.getRank(target.getUniqueId()).equals("developer")) {
                Developer.addEntry(target.getName());
                continue;
            } else if(Main.getInstance().getSQL.getRank(target.getUniqueId()).equals("supporter")) {
                Supporter.addEntry(target.getName());
                continue;
            } else if(Main.getInstance().getSQL.getRank(target.getUniqueId()).equals("contentcreator")) {
                ContentCreator.addEntry(target.getName());
                continue;
            } else if(Main.getInstance().getSQL.getRank(target.getUniqueId()).equals("supreme")) {
                Supreme.addEntry(target.getName());
                continue;
            } else if(Main.getInstance().getSQL.getRank(target.getUniqueId()).equals("premium")) {
                Premium.addEntry(target.getName());
                continue;
            } else if(Main.getInstance().getSQL.getRank(target.getUniqueId()).equals("default")) {
                Default.addEntry(target.getName());
                continue;
            }
        }
    }

}
