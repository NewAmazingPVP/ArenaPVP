package newamazingpvp.arenapvp.General_Listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

import static newamazingpvp.arenapvp.ArenaPVP.arenaPVP;

public class Mystic_Box implements Listener {

    @EventHandler
    public void onPlayerPlace(BlockPlaceEvent e) {

        e.getBlockPlaced();

        ItemStack item = e.getItemInHand();
        Location location = e.getBlock().getLocation();
        Player player = e.getPlayer();
        ItemMeta meta = item.getItemMeta();

        player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Opening...");

        if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "L" + ChatColor.GOLD + "" + ChatColor.BOLD + " Mystic Box " + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "L")) {
            location.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, location, 20);
            e.setCancelled(true);



            for (Player onlineplayer : Bukkit.getOnlinePlayers()) {


                List<Player> nearbyPlayers = (List<Player>) location.getWorld().getNearbyPlayers(location, 10);
                for (Player playernear : nearbyPlayers) {

                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 0.0f), 1);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 0.0f), 2);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 0.1f), 3);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 0.0f), 4);


                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 1.0f), 5);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 1.0f), 6);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 2.0f), 7);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 1.0f), 8);


                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 2.0f), 9);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 2.0f), 10);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 2.0f), 11);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10.0f, 2.0f), 3);

                }
            }
            if (item.getAmount() > 1) {
                item.setAmount(item.getAmount() - 1);
                player.getInventory().setItemInMainHand(item);
            } else {
                player.getInventory().setItemInMainHand(null);
            }
        }
    }
}

