package newamazingpvp.arenapvp.Give_Item_Commands_ADMIN_ONLY;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static newamazingpvp.arenapvp.Pre_Made_Items.PreMadeItems_Custom.InstaBoomTNT;

public class Open_God_Menu_Listener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "God Menu")) {


            if (event.getCurrentItem() == null) {
                return;
            }

            if (event.getCurrentItem().getDisplayName().equalsIgnoreCase(ChatColor.RED + "" + ChatColor.BOLD + "InstaBoom TNT") && event.getCurrentItem().getType() == Material.TNT) {

                player.getInventory().addItem(InstaBoomTNT());
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                event.setCancelled(true);

            }


            event.setCancelled(true);
        }
    }
}
