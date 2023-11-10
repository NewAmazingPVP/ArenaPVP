package newamazingpvp.arenapvp.General_Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class Mystic_Well implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block.getType() == Material.ENCHANTING_TABLE) {
                event.setCancelled(true);
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2.0f, 0.0f);
            }
        }
    }

    private final Map<Integer, ArmorStand> armorStandMap = new HashMap<>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.ENCHANTING_TABLE) {
            Location location = event.getBlock().getLocation().add(0.5, 1, 0.5);
            ArmorStand armorStand = event.getBlock().getWorld().spawn(location, ArmorStand.class);
            armorStand.setCustomName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mystic Well");
            armorStand.setCustomNameVisible(true);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setInvulnerable(true);
            armorStand.setMarker(true);

            armorStandMap.put(event.getBlock().getLocation().hashCode(), armorStand);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.ENCHANTING_TABLE) {
            ArmorStand armorStand = armorStandMap.get(event.getBlock().getLocation().hashCode());
            if (armorStand != null) {
                armorStand.remove();
                armorStandMap.remove(event.getBlock().getLocation().hashCode());
            }
        }
    }
}
