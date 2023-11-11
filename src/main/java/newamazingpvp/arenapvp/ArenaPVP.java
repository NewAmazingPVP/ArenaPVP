package newamazingpvp.arenapvp;

import newamazingpvp.arenapvp.Custom_Item_Listeners.InstaBoom_TNT;
import newamazingpvp.arenapvp.General_Listeners.Damage_Indicator;
import newamazingpvp.arenapvp.General_Listeners.Death_Event;
import newamazingpvp.arenapvp.Mystic_Well.MysticWell_Listener;
import newamazingpvp.arenapvp.General_Listeners.PlayerCount;
import newamazingpvp.arenapvp.Give_Item_Commands_ADMIN_ONLY.Give_InstaboomTNT;
import newamazingpvp.arenapvp.Kill_Streak_Info.Kill_Listener;
import newamazingpvp.arenapvp.User_Commands.OnlinePlayers;
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
        getServer().getPluginManager().registerEvents(new PlayerCount(), this);
        getServer().getPluginManager().registerEvents(new InstaBoom_TNT(), this);
        getServer().getPluginManager().registerEvents(new MysticWell_Listener(), this);
        getServer().getPluginManager().registerEvents(new Damage_Indicator(), this);


        //commands
        getCommand("howmanyplayersareonline").setExecutor(new OnlinePlayers());
        getCommand("give_InstaBoomTNT").setExecutor(new Give_InstaboomTNT());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
