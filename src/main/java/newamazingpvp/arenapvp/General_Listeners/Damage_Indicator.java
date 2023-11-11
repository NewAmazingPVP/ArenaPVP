package newamazingpvp.arenapvp.General_Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Damage_Indicator implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity damageTaker = event.getEntity();

        Player player = null;
        double health = 0;
        if (damager instanceof Player) {
            player = (Player) damager;
            health = ((Damageable) damageTaker).getHealth();
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 1.0f, 1.0f);
            if (health <= 0) {
                player.sendActionBar(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.AQUA + " ⚔");


            }
        } else {
            player.sendActionBar(ChatColor.RED + "" + ChatColor.BOLD + health + ChatColor.RED + " ❤");
        }
    }
}