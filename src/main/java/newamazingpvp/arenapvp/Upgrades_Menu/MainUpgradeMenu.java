package newamazingpvp.arenapvp.Upgrades_Menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

public class MainUpgradeMenu implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getClickedBlock().getType() == Material.NETHERITE_BLOCK) {

            Inventory upgrades = Bukkit.createInventory(player, 45,  ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Upgrades Menu");


            player.openInventory(upgrades);
        }
    }
}
