package net.snakkze.rankmanager.listeners;

import net.snakkze.rankmanager.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Main.getInstance().tablistManager.setAllPlayerTeams();
    }
}
