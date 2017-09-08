package de.gewaltigerzorn.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import de.gewaltigerzorn.main.Main;
import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.FileManager;
import de.gewaltigerzorn.methods.Messages;
import de.gewaltigerzorn.methods.ScoreboardEvent;

public class SignEvent implements Listener {

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("[KnockbackFFA]")) {
			if (e.getLine(1).equalsIgnoreCase("join")) {

				Player p = e.getPlayer();

				String arena = e.getLine(2);

				if (FileManager.arena_cfg.get(arena.toLowerCase()) != null) {

					String lastline = ChatColor.translateAlternateColorCodes('&', FileManager.msg_cfg.getString("sign.players"));
					lastline = lastline.replace("%players_online%", Integer.toString(FileManager.arena_cfg.getInt(arena.toLowerCase() + ".playersonline")));
					lastline = lastline.replace("%max_players%", Integer.toString(FileManager.arena_cfg.getInt(arena.toLowerCase() + ".maxplayers")));

					e.setLine(0, ChatColor.translateAlternateColorCodes('&', FileManager.msg_cfg.getString("sign.title")));
					e.setLine(1, ChatColor.translateAlternateColorCodes('&', FileManager.msg_cfg.getString("sign.others")));
					e.setLine(2, ChatColor.translateAlternateColorCodes('&', FileManager.msg_cfg.getString("sign.arena").replace("%arena%", FileManager.arena_cfg.getString(arena.toLowerCase() + ".name"))));
					e.setLine(3, lastline);

					Arena.setSignLocation(p, arena, e.getBlock().getLocation());
				} else {
					p.sendMessage(Messages.arenaNotAvailable.replace("%arena%", arena));
				}

			}
		}
	}

	@EventHandler
	public void onInteractWithSign(PlayerInteractEvent e) {

		Player p = e.getPlayer();

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getState() instanceof Sign) {
				Sign sign = (Sign) e.getClickedBlock().getState();

				if (sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', FileManager.msg_cfg.getString("sign.title")))) {
					if (sign.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', FileManager.msg_cfg.getString("sign.others")))) {

						for (String arena : FileManager.arena_cfg.getConfigurationSection("").getKeys(false)) {
							if (FileManager.arena_cfg.getInt(arena.toLowerCase() + ".playersonline") < FileManager.arena_cfg.getInt(arena.toLowerCase() + ".maxplayers")) {
								
								if(FileManager.stats_cfg.get(p.getUniqueId().toString()) == null) {
									FileManager.setPlayerDefaults(p, 0, 0, 0);
									return;
								}
								
								
								ScoreboardEvent.updateScoreboard(p);
								
								Arena.updateSign(p, arena, +1);

								double x = FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".x");
								double y = FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".y");
								double z = FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".z");
								float yaw = (float) FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".yaw");
								float pitch = (float) FileManager.arena_cfg.getDouble(arena.toLowerCase() + "." + "spawn" + ".pitch");
								String world = FileManager.arena_cfg.getString(arena.toLowerCase() + "." + "spawn" + ".world");

								p.teleport(new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch));

								p.getInventory().setItem(0, Main.KnockbackStick);
								p.getInventory().setItem(4, Main.ShopChest);
							}else {
								p.sendMessage(Messages.arenaFull);
							}
						}
					}
				}
			}
		}
	}

}
