package de.gewaltigerzorn.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.FileManager;

public class PMoveEvent implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();

		if (Arena.isInArena(p.getLocation())) {
			for (String arena : FileManager.arena_cfg.getConfigurationSection("").getKeys(false)) {
				int y = FileManager.arena_cfg.getInt(arena.toLowerCase() + ".deathzone");
				
					if (p.getLocation().getY() < y) {
						p.setHealth(0);
					}
				 
			}
			

		}
	}

}
