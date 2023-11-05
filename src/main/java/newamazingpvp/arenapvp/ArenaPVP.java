package newamazingpvp.arenapvp;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArenaPVP extends JavaPlugin {

    public static ArenaPVP arenaPVP;
    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        arenaPVP = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
