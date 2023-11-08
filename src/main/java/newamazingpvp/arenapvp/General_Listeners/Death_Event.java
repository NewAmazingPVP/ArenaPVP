package newamazingpvp.arenapvp.General_Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death_Event implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getPlayer();

        //cansel the death (in a way that will not break the game and your client)
        e.setDeathMessage(null);
        e.setDroppedExp(0);
        e.getDrops().clear();

        //death visuals
        player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 2.0f, 2.0f);
        player.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "You Died", "", 10, 70, 20);


        //possible respawn locations
        Location loc1 = new Location(e.getEntity().getWorld(), 19, 110, 59);
        Location loc2 = new Location(e.getEntity().getWorld(), 22, 110, 61);
        Location loc3 = new Location(e.getEntity().getWorld(), 27, 110, 61);

        e.getEntity().teleport(loc1);
    }
}

