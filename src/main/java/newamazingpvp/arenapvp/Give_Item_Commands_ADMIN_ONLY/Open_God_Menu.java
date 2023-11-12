package newamazingpvp.arenapvp.Give_Item_Commands_ADMIN_ONLY;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static newamazingpvp.arenapvp.ArenaPVP.arenaPVP;


public class Open_God_Menu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;

        Inventory godMenu = Bukkit.createInventory(player, 54,  ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "God Menu");

        ItemStack G1 = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE);
        ItemMeta M1 = G1.getItemMeta();
        M1.setDisplayName(" ");
        G1.setItemMeta(M1);


        godMenu.setItem(0, G1);
        godMenu.setItem(1, G1);
        godMenu.setItem(2, G1);
        godMenu.setItem(3, G1);
        godMenu.setItem(4, G1);
        godMenu.setItem(5, G1);
        godMenu.setItem(6, G1);
        godMenu.setItem(7, G1);
        godMenu.setItem(8, G1);
        godMenu.setItem(9, G1);




        godMenu.setItem(18, G1);
        godMenu.setItem(27, G1);
        godMenu.setItem(36, G1);
        godMenu.setItem(17, G1);
        godMenu.setItem(26, G1);
        godMenu.setItem(0, G1);
        godMenu.setItem(35, G1);
        godMenu.setItem(44, G1);
        godMenu.setItem(45, G1);
        godMenu.setItem(46, G1);
        godMenu.setItem(47, G1);
        godMenu.setItem(48, G1);
        godMenu.setItem(49, G1);
        godMenu.setItem(50, G1);
        godMenu.setItem(51, G1);
        godMenu.setItem(52, G1);
        godMenu.setItem(53, G1);




        player.openInventory(godMenu);

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 7);
        Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f), 17);
        Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 24);
        Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f), 34);
        Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 41);
        return true;
    }
}
