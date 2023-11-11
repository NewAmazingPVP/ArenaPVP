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

        ItemStack startCP = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leg = (LeatherArmorMeta) startCP.getItemMeta();
        leg.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Starter Chestplate");
        leg.setUnbreakable(true);
        leg.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        leg.addItemFlags(ItemFlag.HIDE_DYE);
        startCP.setItemMeta(leg);


        return startCP;
    }
}
