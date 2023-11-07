package newamazingpvp.arenapvp.GeberalListeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class KillTest1 implements Listener {

    @EventHandler
    public void onPlayerInteract(EntityDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        killer.sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "KILL!" + ChatColor.AQUA + " +12XP");
        killer.playSound(killer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 2.0f);
        killer.playSound(killer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 2.0f);
    }
}
