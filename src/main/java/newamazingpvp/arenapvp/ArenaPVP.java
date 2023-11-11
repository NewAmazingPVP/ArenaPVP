package newamazingpvp.arenapvp;

import newamazingpvp.arenapvp.Custom_Item_Listeners.InstaBoom_TNT;
import newamazingpvp.arenapvp.General_Listeners.Damage_Indicator;
import newamazingpvp.arenapvp.General_Listeners.Death_Event;
import newamazingpvp.arenapvp.Mystic_Well.MysticWell_Listener;
import newamazingpvp.arenapvp.General_Listeners.PlayerCount;
import newamazingpvp.arenapvp.Give_Item_Commands_ADMIN_ONLY.Give_InstaboomTNT;
import newamazingpvp.arenapvp.Kill_Streak_Info.Kill_Listener;
import newamazingpvp.arenapvp.User_Commands.OnlinePlayers;
import newamazingpvp.arenapvp.utility.DataBaseHelper;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.ResultSet;

import static newamazingpvp.arenapvp.utility.AutoUpload.startReleaseChecker;

public final class ArenaPVP extends JavaPlugin {

    public static ArenaPVP arenaPVP;
    public static FileConfiguration config;
    public static DataBaseHelper dataBaseHelper;

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        saveDefaultConfig();
        config = getConfig();
        arenaPVP = this;
        startReleaseChecker();


        //Initialize things ig
        getServer().getPluginManager().registerEvents(new Kill_Listener(), this);
        getServer().getPluginManager().registerEvents(new Death_Event(), this);
        getServer().getPluginManager().registerEvents(new PlayerCount(), this);
        getServer().getPluginManager().registerEvents(new InstaBoom_TNT(), this);
        getServer().getPluginManager().registerEvents(new MysticWell_Listener(), this);
        getServer().getPluginManager().registerEvents(new Damage_Indicator(), this);


        //commands
        getCommand("howmanyplayersareonline").setExecutor(new OnlinePlayers());
        getCommand("give_InstaBoomTNT").setExecutor(new Give_InstaboomTNT());

        //database
        dataBaseHelper = new DataBaseHelper(getDataFolder().getAbsolutePath() + File.separator + "example.db");

        // Example: Create a table
        dataBaseHelper.createTable("player_data", "id INTEGER PRIMARY KEY, player_name TEXT, score INTEGER");

        // Example: Insert data
        dataBaseHelper.insertData("player_data", "player_name, score", "'Player1', 100");

        // Example: Retrieve data
        ResultSet resultSet = dataBaseHelper.getData("player_data", "score > 50");

        // Example: Delete data
        dataBaseHelper.deleteData("player_data", "player_name = 'Player2'");
    }

    @Override
    public void onDisable() {
        dataBaseHelper.disconnect();
    }
}
