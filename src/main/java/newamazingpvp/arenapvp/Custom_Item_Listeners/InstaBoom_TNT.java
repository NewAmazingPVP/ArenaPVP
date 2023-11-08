package newamazingpvp.arenapvp.Custom_Item_Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InstaBoom_TNT implements Listener {

    @EventHandler
    public void onPlayerPlaceInstaboomTNT(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (e.getMaterial() == Material.getMaterial("111111111")) {
                e.setCancelled(true);




            }
        }
    }
}
