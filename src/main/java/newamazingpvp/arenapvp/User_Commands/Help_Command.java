package newamazingpvp.arenapvp.User_Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help_Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;

        player.sendMessage(ChatColor.YELLOW + "" +ChatColor.BOLD + "============== Commands ================");
        player.sendMessage(" ");
        player.sendMessage(ChatColor.DARK_PURPLE + "/howmanyplayersareonline" + ChatColor.RED);

        return true;
    }
}
