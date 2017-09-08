package de.gewaltigerzorn.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.FileManager;

public class EDamageByEEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {

			Player killer = (Player) e.getDamager();
			Player death = (Player) e.getEntity();

			int y = 0;

			for (String arena : FileManager.arena_cfg.getConfigurationSection("").getKeys(false)) {
				y = FileManager.arena_cfg.getInt(arena.toLowerCase() + "." + "high");
			}

			if (Arena.isInArena(killer.getLocation()) && Arena.isInArena(death.getLocation())) {
				if (killer.getLocation().getBlockY() < y && killer.getLocation().getBlockY() < y) {
					
				}else {
					e.setCancelled(true);
				}
			}
		}
	}

}
