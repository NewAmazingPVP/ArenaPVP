package newamazingpvp.arenapvp.Custom_Item_Listeners;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

import static newamazingpvp.arenapvp.ArenaPVP.arenaPVP;

public class Ice_Cube implements Listener {

    //not the fucking rapper

    @EventHandler
    public void onPlayerInteract(BlockPlaceEvent e) {

        Player player = e.getPlayer();
        ItemStack item = e.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        Player closestPlayer = null;
        double minDistance = Double.MAX_VALUE;

        Location location = e.getBlock().getLocation();
        if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Ice Cube" + ChatColor.DARK_AQUA + " [Item]")) {
            location.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, location, 10);
            e.setCancelled(true);
            player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
            for (Player onlineplayer : Bukkit.getOnlinePlayers()) {

                double distance = player.getLocation().distance(location);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPlayer = player;
                }
                if (closestPlayer != null) {

                    closestPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 5));
                    closestPlayer.addScoreboardTag("frozen");
                    Player finalClosestPlayer = closestPlayer;
                    Bukkit.getScheduler().runTaskLater(arenaPVP, () -> finalClosestPlayer.removeScoreboardTag("frozen"), 40);
                    closestPlayer.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT_FREEZE, 1.0f, 0.0f);

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
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboardTags().contains("frozen")) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerMove(PlayerJumpEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboardTags().contains("frozen")) {
            event.setCancelled(true);
        }
    }
}

