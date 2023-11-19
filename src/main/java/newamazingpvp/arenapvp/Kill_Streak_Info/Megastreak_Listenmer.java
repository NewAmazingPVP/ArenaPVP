package newamazingpvp.arenapvp.Kill_Streak_Info;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import static newamazingpvp.arenapvp.Kill_Streak_Info.Kill_Listener.streaks;

public class Megastreak_Listenmer implements Listener {

    @EventHandler
    public void onPlayerInteract(EntityDeathEvent e) {

        Player killer = e.getEntity().getKiller();
        
        killer.sendMessage(ChatColor.GOLD + "test" + streaks);


    }
}
