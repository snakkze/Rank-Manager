package net.snakkze.rankmanager.mysql.listener;

import net.snakkze.rankmanager.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SQLJoinEvent implements Listener  {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Main.getInstance().mySQL.getData().createPlayer(p);
        if(!p.hasPlayedBefore()) {
            Main.getInstance().mySQL.getData().setRank(p.getUniqueId(), "default");
        }
        Bukkit.getLogger().info("Created Player Data");
    }

}
