package newamazingpvp.arenapvp;

import newamazingpvp.arenapvp.General_Listeners.Death_Event;
import newamazingpvp.arenapvp.Kill_Streak_Info.Kill_Listener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import static newamazingpvp.arenapvp.utility.AutoUpload.startReleaseChecker;

public final class ArenaPVP extends JavaPlugin {

    public static ArenaPVP arenaPVP;
    public static FileConfiguration config;

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


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
