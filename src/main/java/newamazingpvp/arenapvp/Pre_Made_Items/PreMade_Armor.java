package newamazingpvp.arenapvp.Pre_Made_Items;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class PreMade_Armor {

    public static ItemStack startCP() {

        ItemStack startCP = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta startcpm = (LeatherArmorMeta) startCP.getItemMeta();
        startcpm.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Starter Chestplate");
        startcpm.setUnbreakable(true);
        startcpm.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        startcpm.addItemFlags(ItemFlag.HIDE_DYE);
        startCP.setItemMeta(startcpm);


        return startCP;
    }

    public static ItemStack startLeg() {

        ItemStack startLeg = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta startlegm = (LeatherArmorMeta) startLeg.getItemMeta();
        startlegm.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Starter Leggings");
        startlegm.setUnbreakable(true);
        startlegm.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        startlegm.addItemFlags(ItemFlag.HIDE_DYE);
        startLeg.setItemMeta(startlegm);


        return startLeg;
    }

    public static ItemStack startBoot() {

        ItemStack startBoots = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta startbootm = (LeatherArmorMeta) startBoots.getItemMeta();
        startbootm.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Starter Boots");
        startbootm.setUnbreakable(true);
        startbootm.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        startbootm.addItemFlags(ItemFlag.HIDE_DYE);
        startBoots.setItemMeta(startbootm);

        return startBoots;
    }

}
