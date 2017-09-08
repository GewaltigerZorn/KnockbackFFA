package de.gewaltigerzorn.listener;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import de.gewaltigerzorn.commands.Knockback;
import de.gewaltigerzorn.main.Main;
import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.FileManager;

public class PlaceEvent implements Listener {

	Map<Block, Long> blocks = new HashMap<Block, Long>();

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		int y = 0;

		for (String arena : FileManager.arena_cfg.getConfigurationSection("").getKeys(false)) {
			y = FileManager.arena_cfg.getInt(arena.toLowerCase() + "." + "high");
		}

		if (Arena.isInArena(e.getBlock().getLocation())) {
			if (e.getBlock().getLocation().getBlockY() > y) {
				if (!Knockback.build.contains(e.getPlayer())) {
					e.setCancelled(true);
				}
			} else {

				if (!Knockback.build.contains(e.getPlayer())) {

					Block block = e.getBlockPlaced();
					if (block.getType().equals(Material.SANDSTONE) || block.getType().equals(Material.WEB)) {
						Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {

							@Override
							public void run() {

								block.setType(Material.AIR);
							}
						}, 10 * 20);
					} else {
						e.setCancelled(true);
					}
				}
			}
		}
	}

}
