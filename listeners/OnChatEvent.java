package net.snakkze.rankmanager.listeners;

import net.snakkze.rankmanager.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if(Main.getInstance().getSQL.getRank(p.getUniqueId()).equalsIgnoreCase("owner")) {
            e.setFormat("[§c§lOwner§f] " + p.getDisplayName() + ": " + e.getMessage());
        }
        if(Main.getInstance().getSQL.getRank(p.getUniqueId()).equalsIgnoreCase("admin")) {
            e.setFormat("[§cAdmin§f] " + p.getDisplayName() + ": " + e.getMessage());
        }
        if(Main.getInstance().getSQL.getRank(p.getUniqueId()).equalsIgnoreCase("moderator")) {
            e.setFormat("§7[§2Moderator§7]§f " + p.getDisplayName() + ": " + e.getMessage());
        }
        if(Main.getInstance().getSQL.getRank(p.getUniqueId()).equalsIgnoreCase("developer")) {
            e.setFormat("§7[§9Developer§7]§f " + p.getDisplayName() + ": " + e.getMessage());
        }
        if(Main.getInstance().getSQL.getRank(p.getUniqueId()).equalsIgnoreCase("supporter")) {
            e.setFormat("§7[§aSupporter§7] §f" + p.getDisplayName() + ": " + e.getMessage());
        }
        if(Main.getInstance().getSQL.getRank(p.getUniqueId()).equalsIgnoreCase("contentcreator")) {
            e.setFormat("§7[§fContent §cCreator§7]§f " + p.getDisplayName() + ": " + e.getMessage());
        }
        if(Main.getInstance().getSQL.getRank(p.getUniqueId()).equalsIgnoreCase("supreme")) {
            e.setFormat("§7[§bSupreme§7]§f " + p.getDisplayName() + ": " + e.getMessage());
        }
        if(Main.getInstance().getSQL.getRank(p.getUniqueId()).equalsIgnoreCase("premium")) {
            e.setFormat("§7[§6Premium§7]§f " + p.getDisplayName() + ": " + e.getMessage());
        }
        if(Main.getInstance().getSQL.getRank(p.getUniqueId()).equalsIgnoreCase("default")) {
            e.setFormat("§7[Default]§f " + p.getDisplayName() + ": " + e.getMessage());
        }
    }

}
