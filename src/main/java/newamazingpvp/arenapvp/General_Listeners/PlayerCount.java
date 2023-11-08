package newamazingpvp.arenapvp.General_Listeners;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerCount implements Listener {

    int onlineplayers;

    @EventHandler
    public void onplayerjoin(PlayerJumpEvent e) {

        e.setCancelled(true);


    }
}


