package newamazingpvp.arenapvp.Custom_Item_Listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class Ice_Cube implements Listener {

    @EventHandler
    public void onPlayerInteract(BlockPlaceEvent e) {

        Player player = e.getPlayer();
        ItemStack item = e.getItemInHand();
        ItemMeta meta = item.getItemMeta();

        Location location = e.getBlock().getLocation();
        if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Ice Cube" + ChatColor.DARK_AQUA + " [Item]")) {
            location.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, location, 10);
            e.setCancelled(true);
            for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
                onlineplayer.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
                List<Player> nearbyPlayers = (List<Player>) location.getWorld().getNearbyPlayers(location, 5);
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
