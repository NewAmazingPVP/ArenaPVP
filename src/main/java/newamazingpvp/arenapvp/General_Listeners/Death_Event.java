package newamazingpvp.arenapvp.General_Listeners;

import org.bukkit.Bukkit;
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
        for (Player playeronline : Bukkit.getOnlinePlayers()) {
            playeronline.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + player + ChatColor.RED + " Has Died!");
        }
        //cansel the death (in a way that will not break the game and your client)
        e.setDeathMessage(null);
        e.setDroppedExp(0);
        e.getDrops().clear();

        //death visuals
        player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 2.0f, 2.0f);
        player.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "You Died", "", 0, 70, 20);


        //possible respawn locations
        Location loc1 = new Location(e.getEntity().getWorld(), 25, 111, 62);

        e.getEntity().teleport(loc1);
    }
}

