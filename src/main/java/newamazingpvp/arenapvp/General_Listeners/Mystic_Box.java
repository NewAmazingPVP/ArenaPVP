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

public class Mystic_Box implements Listener {

    @EventHandler
    public void onPlayerPlace(BlockPlaceEvent e) {

        e.getBlockPlaced();

        ItemStack item = e.getItemInHand();
        Location location = e.getBlock().getLocation();
        Player player = e.getPlayer();
        ItemMeta meta = item.getItemMeta();



        if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "InstaBoom TNT")) {
            location.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, location, 10);
            e.setCancelled(true);
            for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
                onlineplayer.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
                List<Player> nearbyPlayers = (List<Player>) location.getWorld().getNearbyPlayers(location, 2);
                for (Player playernear : nearbyPlayers) {
                    playernear.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 1, 4));

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

