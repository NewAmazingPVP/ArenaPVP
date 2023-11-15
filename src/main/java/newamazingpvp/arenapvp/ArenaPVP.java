package newamazingpvp.arenapvp;

import newamazingpvp.arenapvp.Custom_Item_Listeners.InstaBoom_TNT;
import newamazingpvp.arenapvp.General_Listeners.*;
import newamazingpvp.arenapvp.Give_Item_Commands_ADMIN_ONLY.Open_God_Menu;
import newamazingpvp.arenapvp.Give_Item_Commands_ADMIN_ONLY.Open_God_Menu_Listener;
import newamazingpvp.arenapvp.Give_Item_Commands_ADMIN_ONLY.Pit_Server_Restart;
import newamazingpvp.arenapvp.Mystic_Well.MysticWell_Listener;
import newamazingpvp.arenapvp.Kill_Streak_Info.Kill_Listener;
import newamazingpvp.arenapvp.Upgrades_Menu.MainUpgradeMenu;
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


        //Initialize Listeners
        getServer().getPluginManager().registerEvents(new Kill_Listener(), this);
        getServer().getPluginManager().registerEvents(new Death_Event(), this);
        getServer().getPluginManager().registerEvents(new PlayerCount(), this);
        getServer().getPluginManager().registerEvents(new InstaBoom_TNT(), this);
        getServer().getPluginManager().registerEvents(new MysticWell_Listener(), this);
        getServer().getPluginManager().registerEvents(new Damage_Indicator(), this);
        getServer().getPluginManager().registerEvents(new Player_Join(), this);
        getServer().getPluginManager().registerEvents(new MainUpgradeMenu(), this);
        getServer().getPluginManager().registerEvents(new Open_God_Menu_Listener(), this);
        //getServer().getPluginManager().registerEvents(new Prevrnt_Invintory_Slots(), this);
        getServer().getPluginManager().registerEvents(new Mystic_Box(), this);




        //commands
        getCommand("howmanyplayersareonline").setExecutor(new OnlinePlayers());
        getCommand("open_god_menu").setExecutor(new Open_God_Menu());
        getCommand("pit_restart_server").setExecutor(new Pit_Server_Restart());

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
