package newamazingpvp.arenapvp.General_Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class Prevrnt_Invintory_Slots implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (event.getHand() == EquipmentSlot.OFF_HAND) {
            event.setCancelled(true);
            player.sendMessage("test1111111");

        }
    }
}
