package newamazingpvp.arenapvp.Mystic_Well;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class MysticWell_Listener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block.getType() == Material.ENCHANTING_TABLE) {
                event.setCancelled(true);
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2.0f, 0.0f);
                Inventory well = Bukkit.createInventory(player, 45,  ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "L" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + " Mystic Well " + ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "L");

                ItemStack G1 = new ItemStack(Material.BLACK_STAINED_GLASS);
                ItemMeta M1 = G1.getItemMeta();
                M1.setDisplayName(" ");
                G1.setItemMeta(M1);

                ItemStack G2 = new ItemStack(Material.PINK_STAINED_GLASS);
                ItemMeta M2 = G2.getItemMeta();
                M2.setDisplayName(" ");
                G2.setItemMeta(M2);




                player.openInventory(well);

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

            /*Location location2 = event.getBlock().getLocation().add(0.5, 1.1, 0.5);
            ArmorStand armorStand2 = event.getBlock().getWorld().spawn(location2, ArmorStand.class);
            armorStand2.setCustomName(ChatColor.GRAY + "Item Enchants");
            armorStand2.setCustomNameVisible(true);
            armorStand2.setVisible(false);
            armorStand2.setGravity(false);
            armorStand2.setInvulnerable(true);
            armorStand2.setMarker(true);
            armorStandMap.put(event.getBlock().getLocation().hashCode(), armorStand2);*/
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.ENCHANTING_TABLE) {
            ArmorStand armorStand = armorStandMap.get(event.getBlock().getLocation().hashCode());
            //ArmorStand armorStand2 = armorStandMap.get(event.getBlock().getLocation().hashCode());
            if (armorStand != null) {
                armorStand.remove();
                //armorStand2.remove();
                armorStandMap.remove(event.getBlock().getLocation().hashCode());
            }
        }
    }
}


