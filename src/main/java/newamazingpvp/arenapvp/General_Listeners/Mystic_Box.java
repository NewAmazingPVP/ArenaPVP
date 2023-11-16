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
        player.playEffect(EntityEffect.TOTEM_RESURRECT);



        if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "L" + ChatColor.GOLD + "" + ChatColor.BOLD + " Mystic Box " + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "L")) {
            location.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, location, 1);
            e.setCancelled(true);
            for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
                List<Player> nearbyPlayers = (List<Player>) location.getWorld().getNearbyPlayers(location, 15);
                for (Player playernear : nearbyPlayers) {

                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> playernear.playSound(playernear.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10.0f, 0.0f), 0);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> playernear.playSound(playernear.getLocation(), Sound.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, 10.0f, 1.0f), 0);
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> playernear.playSound(playernear.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 10.0f, 1.0f), 0);




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

