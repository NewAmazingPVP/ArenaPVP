package newamazingpvp.arenapvp.Kill_Streak_Info;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.HashMap;
import java.util.UUID;

import static newamazingpvp.arenapvp.ArenaPVP.arenaPVP;
import static newamazingpvp.arenapvp.Pre_Made_Items.PreMadeItems_Custom.MysticBox;

public class Kill_Listener implements Listener {

    static final HashMap<UUID, Integer> streaks = new HashMap<>();

    @EventHandler
    public void onPlayerInteract(EntityDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        Location loc = e.getEntity().getLocation();

        UUID uuid = killer.getUniqueId();

        if (streaks.containsKey(uuid)) {
            streaks.put(uuid, streaks.get(uuid) + 1);
        } else {
            streaks.put(uuid, 1);
        }

        if (Math.random() < 0.5) {

            killer.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.AQUA + " +12XP ⚔" + " " + streaks.get(uuid));
            killer.playSound(killer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 2.0f);


        } else if (Math.random() > 0.5) {

            killer.playSound(killer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 2.0f);
            killer.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.AQUA + " +12XP ⚔" + " " + streaks.get(uuid));
            killer.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "RARE DROP!" + ChatColor.DARK_PURPLE + " +1 Mystic Box");
            e.getEntity().getWorld().spawnParticle(Particle.WATER_WAKE, loc, 5);
            killer.getInventory().addItem(MysticBox());
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0f, 0.0f), 1);
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0f, 1.0f), 11);
            Bukkit.getScheduler().runTaskLater(arenaPVP, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0f, 3.0f), 21);
        }
        if (streaks.containsValue(50)) {
            killer.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You Activated Overdrive!");

            for (Player onlineplayer : Bukkit.getOnlinePlayers()) {

                onlineplayer.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Test");
                killer.playSound(killer.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1.0f, 2.0f);

            }
        }
    }
}









