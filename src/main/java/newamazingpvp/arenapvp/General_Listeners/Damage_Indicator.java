package newamazingpvp.arenapvp.General_Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import static newamazingpvp.arenapvp.ArenaPVP.arenaPVP;

public class Damage_Indicator implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity damageTaker = event.getEntity();


        if (damager instanceof Player) {
            Player player = (Player) damager;
            double health = ((Damageable) damageTaker).getHealth();
            if (health > 0) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 1.0f, 1.0f);
                Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.sendActionBar(ChatColor.RED + "" + ChatColor.BOLD + health + ChatColor.RED + " ❤"), 20);
                //player.sendActionBar(ChatColor.RED + "" + ChatColor.BOLD + health + ChatColor.RED + " ❤");
                player.stopSound(Sound.valueOf("PLAYER_ATTACK_SWEEP"));
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDeathEvent event) {

        Player killer = event.getEntity().getKiller();
        killer.sendActionBar(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.AQUA + " ⚔");

    }
}