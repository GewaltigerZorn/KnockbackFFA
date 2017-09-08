package de.gewaltigerzorn.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.gewaltigerzorn.main.Main;
import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.FileManager;

public class PRespawnEvent implements Listener {

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {

		Player p = e.getPlayer();

		for (String arena : FileManager.arena_cfg.getConfigurationSection("").getKeys(false)) {
			double x = FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".x");
			double y = FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".y");
			double z = FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".z");
			float yaw = (float) FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".yaw");
			float pitch = (float) FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".pitch");
			String world = FileManager.arena_cfg.getString(arena.toLowerCase() + "." + "spawn" + ".world");

			if (Arena.isInArena(p.getLocation())) {
				e.setRespawnLocation(new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch));
				p.getInventory().setItem(0, Main.KnockbackStick);
				p.getInventory().setItem(4, Main.ShopChest);
			}

		}
	}
}
