package de.gewaltigerzorn.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import de.gewaltigerzorn.commands.Knockback;
import de.gewaltigerzorn.methods.Arena;

public class BreakEvent implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (Arena.isInArena(e.getBlock().getLocation())) {
			if (!Knockback.build.contains(e.getPlayer())) {
				e.setCancelled(true);
			}
		}
	}

}
