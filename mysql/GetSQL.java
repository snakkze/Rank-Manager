package net.snakkze.rankmanager.mysql;

import net.snakkze.rankmanager.Main;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class GetSQL {

    private Main plugin;

    public GetSQL(Main plugin) {
        this.plugin = plugin;
    }

    public void createTable() {
        PreparedStatement ps;
        try {
            ps = plugin.mySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS playerdata "
                + "(NAME VARCHAR(100),UUID VARCHAR(100),RANK VARCHAR(25),PRIMARY KEY (NAME))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPlayer(Player p) {
        try {
            UUID uuid = p.getUniqueId();
            if(!exist(uuid)) {
                PreparedStatement ps2 = plugin.mySQL.getConnection().prepareStatement("INSERT IGNORE INTO playerdata " +
                        "(NAME,UUID) VALUES (?,?)");
                ps2.setString(1, p.getName());
                ps2.setString(2, uuid.toString());
                ps2.executeUpdate();

                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exist(UUID uuid) {
        try {
            PreparedStatement ps = plugin.mySQL.getConnection().prepareStatement("SELECT * FROM playerdata WHERE UUID=?");
            ps.setString(1, uuid.toString());

            ResultSet results = ps.executeQuery();
            if(results.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setRank(UUID uuid, String rank) {
            try {
                PreparedStatement ps = plugin.mySQL.getConnection().prepareStatement("UPDATE playerdata SET RANK=? WHERE UUID=?");
                ps.setString(1, rank);
                ps.setString(2, uuid.toString());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    public String getRank(UUID uuid) {
        try {
            PreparedStatement ps = plugin.mySQL.getConnection().prepareStatement("SELECT RANK FROM playerdata WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            String rank;
            if(rs.next()) {
                rank = rs.getString("RANK");
                return rank;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
