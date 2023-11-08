package newamazingpvp.arenapvp.General_Listeners;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class PlayerCount implements Listener {

    public static int onlineplayers;

    @EventHandler
    public void onplayerjoin(PlayerJoinEvent e) {

        e.setJoinMessage(null);
        onlineplayers += 1;


    }

    @EventHandler
    public void onplayerleave(PlayerQuitEvent e) {

        onlineplayers -=1;

    }
}


