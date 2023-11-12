package newamazingpvp.arenapvp.General_Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.arenapvp.Pre_Made_Items.PreMade_Armor.*;

public class Player_Join implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chest = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();



        if (chest == null || chest.getType() == Material.AIR) {

            player.getInventory().setChestplate(startCP());

        }

        if (leggings == null || leggings.getType() == Material.AIR) {

            player.getInventory().setLeggings(startLeg());

        }

        if (boots == null || boots.getType() == Material.AIR) {

            player.getInventory().setBoots(startBoot());

        }
    }
}
