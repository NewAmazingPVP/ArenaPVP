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
        BL.add(ChatColor.GREEN + "When placed, it will instantly");
        BL.add(ChatColor.GREEN + "explode dealing damage to");
        BL.add(ChatColor.GREEN + "ALL PLAYERS in range.");
        BL.add(" ");
        BL.add(ChatColor.DARK_AQUA + "If a player has the InstaBoom");
        BL.add(ChatColor.DARK_AQUA + "Enchant they are immune to it.");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        InstaBoomTNT.setItemMeta(SI);

        return InstaBoomTNT;
    }

    public static ItemStack startIronSword() {

        ItemStack startIronSword = new ItemStack(Material.IRON_SWORD);
        ItemMeta SI = startIronSword.getItemMeta();
        SI.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Iron Sword");
        SI.setUnbreakable(true);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        startIronSword.setItemMeta(SI);

        return startIronSword;

    }

    public static ItemStack startBow() {

        ItemStack startBow = new ItemStack(Material.BOW);
        ItemMeta SIB = startBow.getItemMeta();
        SIB.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Bow");
        SIB.setUnbreakable(true);
        SIB.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        startBow.setItemMeta(SIB);

        return startBow;

    }

    public static ItemStack MysticBox() {

        ItemStack MysticBox = new ItemStack(Material.ENDER_CHEST);
        ItemMeta SI = MysticBox.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "L" + ChatColor.GOLD + "" + ChatColor.BOLD + " Mystic Box " + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "L");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Place to open!");
        SI.setLore(BL);
        MysticBox.setItemMeta(SI);

        return MysticBox;
    }

    public static ItemStack SpeedFeather() {

        ItemStack SpeedFeather = new ItemStack(Material.FEATHER);
        ItemMeta SI = SpeedFeather.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Speed Feather" + ChatColor.DARK_AQUA + " [Item]");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click:" + ChatColor.DARK_PURPLE + " Get speed for a few sec!");
        BL.add(ChatColor.RED + "One time use.");
        SI.setLore(BL);
        SpeedFeather.setItemMeta(SI);

        return SpeedFeather;
    }
}

