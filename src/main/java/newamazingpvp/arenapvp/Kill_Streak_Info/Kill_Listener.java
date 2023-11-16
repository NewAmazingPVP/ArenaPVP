package newamazingpvp.arenapvp.Kill_Streak_Info;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.UUID;

import static newamazingpvp.arenapvp.ArenaPVP.arenaPVP;
import static newamazingpvp.arenapvp.Pre_Made_Items.PreMadeItems_Custom.MysticBox;

public class Kill_Listener implements Listener {


    @EventHandler
    public void onPlayerInteract(EntityDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        Location loc = e.getEntity().getLocation();


        if (Math.random() < 0.5) {

            killer.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.AQUA + " +12XP ⚔");
            killer.playSound(killer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 2.0f);


        }

        else if (Math.random() < 0.5) {

            killer.playSound(killer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 2.0f);
            killer.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.AQUA + " +12XP ⚔");
            killer.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "RARE DROP!" + ChatColor.DARK_PURPLE + " +1 Mystic Box");
            e.getEntity().getWorld().spawnParticle(Particle.WATER_WAKE, loc, 5);
            killer.getInventory().addItem(MysticBox());
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0f, 0.0f), 1);
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0f, 1.0f), 3);
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0f, 3.0f), 5);
        }
    }










    }
}
