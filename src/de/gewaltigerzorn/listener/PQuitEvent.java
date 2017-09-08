package de.gewaltigerzorn.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.FileManager;

public class PQuitEvent implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {

		Player p = e.getPlayer();

		if (Arena.isInArena(p.getLocation())) {
			for (String arena : FileManager.arena_cfg.getConfigurationSection("").getKeys(false)) {

				p.getInventory().clear();

				Arena.updateSign(p, arena, -1);
				
				p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
			}
		}
	}

}
