package de.gewaltigerzorn.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.Messages;

public class PDropItemEvent implements Listener {

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		
		Player p = e.getPlayer();
		if (Arena.isInArena(p.getLocation())) {
			if (!p.hasPermission("kb.drop")) {
				e.setCancelled(true);
				p.sendMessage(Messages.itemDrop);
			}
		}
	}

}
