package newamazingpvp.arenapvp.GeberalListeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class KillTest1 implements Listener {

    int streak;

    @EventHandler
    public void onPlayerInteract(EntityDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        streak +=1;
        killer.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.AQUA + " +12XP" + ChatColor.GOLD + " " + streak);
        killer.playSound(killer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 2.0f);
        killer.playSound(killer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 2.0f);
        Location loc = e.getEntity().getLocation();
        e.getEntity().getWorld().spawnParticle(Particle.SMOKE_NORMAL, loc, 10);
    }
}
