package newamazingpvp.arenapvp.Pre_Made_Items;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class PreMade_Mystics {

    public static ItemStack Fresh_Red() {

        ItemStack Fresh_Red = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta legs = (LeatherArmorMeta) Fresh_Red.getItemMeta();
        legs.setColor(Color.RED);
        legs.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Star Dust Mines Leggings");
        legs.setUnbreakable(true);
        legs.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        legs.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> SLL = new ArrayList<>();
        SLL.add(" ");
        SLL.add(ChatColor.DARK_GREEN + "Low level armor used in the mines.");
        SLL.add(" ");
        legs.setLore(SLL);
        legs.addItemFlags(ItemFlag.HIDE_DYE);
        Fresh_Red.setItemMeta(legs);


        return Fresh_Red;
    }

}
