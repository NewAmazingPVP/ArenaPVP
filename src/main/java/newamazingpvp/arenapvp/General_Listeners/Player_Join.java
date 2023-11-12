package newamazingpvp.arenapvp.General_Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static newamazingpvp.arenapvp.Pre_Made_Items.PreMadeItems_Custom.startIronSword;
import static newamazingpvp.arenapvp.Pre_Made_Items.PreMade_Armor.*;

public class Player_Join implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerJoinEvent e) {

        //inventory check (also add to run on death and event end)
        Player player = e.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chest = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        ItemStack startIronSword = new ItemStack(Material.IRON_SWORD);
        ItemMeta SI = startIronSword.getItemMeta();
        SI.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Iron Sword");
        SI.setUnbreakable(true);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        startIronSword.setItemMeta(SI);


        if (chest == null || chest.getType() == Material.AIR) {

            player.getInventory().setChestplate(startCP());

        }

        if (leggings == null || leggings.getType() == Material.AIR) {

            player.getInventory().setLeggings(startLeg());

        }

        if (boots == null || boots.getType() == Material.AIR) {

            player.getInventory().setBoots(startBoot());

        }

        if (player.getInventory().contains(startIronSword)) {


        } else {

            player.getInventory().addItem(startIronSword());

        }



        //other things
        player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Welcome!" + ChatColor.GREEN + " This game is in early development and will have a lot of bugs!");
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
        player.sendTitle(ChatColor.DARK_GREEN + "Welcome!", "", 0, 70, 20);

    }
}
