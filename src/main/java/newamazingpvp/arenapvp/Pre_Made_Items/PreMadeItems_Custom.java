package newamazingpvp.arenapvp.Pre_Made_Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PreMadeItems_Custom {
    public static ItemStack InstaBoomTNT() {

        ItemStack InstaBoomTNT = new ItemStack(Material.TNT);
        ItemMeta SI = InstaBoomTNT.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "InstaBoom TNT");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(" ");
        BL.add(ChatColor.GREEN + "When placed, it will instantly explode dealing damage to ALL PLAYERS in range.");
        BL.add(ChatColor.GREEN + "If a player has the InstaBoom Enchant they are immune to it.");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        InstaBoomTNT.setItemMeta(SI);

        return InstaBoomTNT;
    }
}
