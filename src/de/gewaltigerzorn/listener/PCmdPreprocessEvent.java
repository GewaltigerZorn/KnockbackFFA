package de.gewaltigerzorn.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.gewaltigerzorn.main.Main;
import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.FileManager;

public class PCmdPreprocessEvent implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String cmd = e.getMessage();
		if (Arena.isInArena(p.getLocation())) {
			for (int i = 0; i < Main.plugin.getConfig().getStringList("leaveCommands").size(); i++) {
				String eingabe = Main.plugin.getConfig().getStringList("leaveCommands").get(i);
				if (eingabe.toUpperCase().equals(cmd.toUpperCase())) {
					for (String arena : FileManager.arena_cfg.getConfigurationSection("").getKeys(false)) {

						p.getInventory().clear();

						Arena.updateSign(p, arena, -1);
						
						p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
					}
				}
			}
		}

	}
}
