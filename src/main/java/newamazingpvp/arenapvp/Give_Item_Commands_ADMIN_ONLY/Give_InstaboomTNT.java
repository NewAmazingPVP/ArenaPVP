package newamazingpvp.arenapvp.Give_Item_Commands_ADMIN_ONLY;

import newamazingpvp.arenapvp.Custom_Item_Listeners.InstaBoom_TNT;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.arenapvp.Pre_Made_Items.PreMadeItems_Custom.InstaBoomTNT;

public class Give_InstaboomTNT implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;

        player.getInventory().addItem(InstaBoomTNT());

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 0.0f);
        return true;
    }
}
