package newamazingpvp.arenapvp.User_Commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.arenapvp.General_Listeners.PlayerCount.onlineplayers;

public class OnlinePlayers implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;

        if(onlineplayers == 0){
            player.sendMessage(ChatColor.RED + "How the fuck did you run this command!?!?!??!?!?!!!!??!?!??????");
        }
        if (onlineplayers == 1) {
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "There is only " + onlineplayers + " player online");
        } else {
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "There are " + onlineplayers + " players online");
        }
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 0.0f);
        return true;
    }
}

