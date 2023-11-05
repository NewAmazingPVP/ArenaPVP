package newamazingpvp.arenapvp;

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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
