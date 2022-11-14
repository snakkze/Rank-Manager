package net.snakkze.rankmanager.mysql;

import net.snakkze.rankmanager.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL implements Listener {

    private GetSQL data;
    private Main plugin;

    private String host = "localhost";
    private String port = "8111";
    private String database = "ranks";
    private String username = "root";
    private String password = "";

    private Connection connection;

    public MySQL(Main plugin) {
        this.plugin = plugin;
        this.data = new GetSQL(plugin);
    }

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if(!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" +
                host + ":" + port + "/" + database + "?useSSL=false",
                username, password);
        }
    }

    public void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void init() {
        data = new GetSQL(plugin);
        try {
            connect();
        } catch (ClassNotFoundException | SQLException e) {
            Bukkit.getLogger().info("Database could not connect!");
        }

        if(isConnected()) {
            Bukkit.getLogger().info("Database is connected");
            data.createTable();
        }
    }

    public GetSQL getData() {
        return this.data;
    }
}
