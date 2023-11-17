package newamazingpvp.arenapvp.Give_Item_Commands_ADMIN_ONLY;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.arenapvp.ArenaPVP.arenaPVP;

public class Quick_Pit_Server_Restart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        Player playerSender = (Player) sender;
        playerSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Quick Restarting Server!");


        for (Player player : Bukkit.getOnlinePlayers()) {

            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 5sec!");

            player.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "Server Restart!", "", 0, 70, 20);

            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 2);
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f), 4);
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 6);
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f), 8);
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 10);

        }

        Bukkit.getScheduler().runTaskLater(arenaPVP, () -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart"), 100);

        return true;

    }

}
