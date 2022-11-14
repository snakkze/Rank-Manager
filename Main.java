package net.snakkze.rankmanager;

import net.snakkze.rankmanager.commands.GetRankCommand;
import net.snakkze.rankmanager.commands.SetRankCommand;
import net.snakkze.rankmanager.listeners.JoinEvent;
import net.snakkze.rankmanager.listeners.OnChatEvent;
import net.snakkze.rankmanager.mysql.GetSQL;
import net.snakkze.rankmanager.mysql.MySQL;
import net.snakkze.rankmanager.mysql.listener.SQLJoinEvent;
import net.snakkze.rankmanager.utils.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public MySQL mySQL;
    public GetSQL getSQL;
    public TablistManager tablistManager;
    private static Main instance;

    @Override
    public void onEnable() {
        // instance
        instance = this;

        // database
        getSQL = new GetSQL(this);
        mySQL = new MySQL(this);
        mySQL.init();

        // TablistManager
        tablistManager = new TablistManager();

        // listeners
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new SQLJoinEvent(), this);
        pm.registerEvents(new OnChatEvent(), this);
        pm.registerEvents(new JoinEvent(), this);

        // commands
        getCommand("setrank").setExecutor(new SetRankCommand());
        getCommand("getrank").setExecutor(new GetRankCommand());

    }

    @Override
    public void onDisable() {
        mySQL.disconnect();
    }

    public static Main getInstance() {
        return instance;
    }


}
