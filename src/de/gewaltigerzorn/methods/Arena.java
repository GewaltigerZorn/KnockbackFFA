package de.gewaltigerzorn.methods;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class Arena extends FileManager {

	public static void setPlayer(Player p, String arena, int amount) {
		if (arena_cfg.get(arena.toLowerCase()) != null) {
			try {
				arena_cfg.set(arena.toLowerCase() + ".playersonline", amount);
			} catch (NumberFormatException nfe) {
				p.sendMessage(Messages.notANumber);
			}
			try {
				arena_cfg.save(arena_file);
			} catch (IOException e) {
				p.sendMessage(Messages.couldntsave);
			}
		} else {
			p.sendMessage(Messages.arenaNotAvailable.replace("%arena%", arena));
		}
	}

	public static void setMaxPlayers(Player p, String arena, int amount) {
		if (arena_cfg.get(arena.toLowerCase()) != null) {
			try {
				arena_cfg.set(arena.toLowerCase() + ".maxplayers", amount);
				p.sendMessage(Messages.maxplayersSet.replace("%amount%", Integer.toString(amount)));
			} catch (NumberFormatException nfe) {
				p.sendMessage(Messages.notANumber);
			}
			try {
				arena_cfg.save(arena_file);
			} catch (IOException e) {
				p.sendMessage(Messages.couldntsave);
			}
		}

	}

	public static void setDeathZone(Player p, String arena, int amount) {
		if (arena_cfg.get(arena.toLowerCase()) != null) {
			try {
				arena_cfg.set(arena.toLowerCase() + ".deathzone", amount);
				p.sendMessage(Messages.deathzoneSet.replace("%amount%", Integer.toString(amount)));
			} catch (NumberFormatException nfe) {
				p.sendMessage(Messages.notANumber);
			}
			try {
				arena_cfg.save(arena_file);
			} catch (IOException e) {
				p.sendMessage(Messages.couldntsave);
			}
		} else {
			p.sendMessage(Messages.arenaNotAvailable.replace("%arena%", arena));
		}

	}

	public static void setHigh(Player p, String arena, int amount) {
		if (arena_cfg.get(arena.toLowerCase()) != null) {
			try {
				arena_cfg.set(arena.toLowerCase() + ".high", amount);
				p.sendMessage(Messages.highSet.replace("%amount%", Integer.toString(amount)));
			} catch (NumberFormatException nfe) {
				p.sendMessage(Messages.notANumber);
			}
			try {
				arena_cfg.save(arena_file);
			} catch (IOException e) {
				p.sendMessage(Messages.couldntsave);
			}
		} else {
			p.sendMessage(Messages.arenaNotAvailable.replace("%arena%", arena));
		}

	}

	public static void setSignLocation(Player p, String arena, Location sign) {
		if (arena_cfg.get(arena.toLowerCase()) != null) {
			arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".x", sign.getBlockX());
			arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".y", sign.getBlockY());
			arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".z", sign.getBlockZ());
			arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".world", sign.getWorld().getName());

			try {
				arena_cfg.save(arena_file);
			} catch (IOException e) {
				p.sendMessage(Messages.couldntsave);
			}
		} else {
			p.sendMessage(Messages.arenaNotAvailable.replace("%arena%", arena));
		}
	}

	public static void setSpawn(Player p, String arena) {
		if (arena_cfg.get(arena.toLowerCase()) != null) {
			try {
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".x", p.getLocation().getX());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".y", p.getLocation().getY());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".z", p.getLocation().getZ());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".yaw", p.getLocation().getYaw());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".pitch", p.getLocation().getPitch());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".world", p.getLocation().getWorld().getName());
				p.sendMessage(Messages.spawnSet);
			} catch (NumberFormatException nfe) {
				p.sendMessage(Messages.notANumber);
			}
			try {
				arena_cfg.save(arena_file);
			} catch (IOException e) {
				p.sendMessage(Messages.couldntsave);
			}
		} else {
			p.sendMessage(Messages.arenaNotAvailable.replace("%arena%", arena));
		}

	}

	public static void createArena(Player p, String arena, Location spawn, Location pos1, Location pos2) {

		if (arena_cfg.get(arena.toLowerCase()) == null) {
			if (pos1.getWorld() == pos2.getWorld()) {
				arena_cfg.set(arena.toLowerCase() + ".name", arena);
				arena_cfg.set(arena.toLowerCase() + ".high", 50);
				arena_cfg.set(arena.toLowerCase() + ".deathzone", 0);
				arena_cfg.set(arena.toLowerCase() + ".playersonline", 0);
				arena_cfg.set(arena.toLowerCase() + ".maxplayers", 100);

				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".x", spawn.getX());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".y", spawn.getY());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".z", spawn.getZ());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".yaw", spawn.getYaw());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".pitch", spawn.getPitch());
				arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".world", spawn.getWorld().getName());

				arena_cfg.set(arena.toLowerCase() + "." + "pos1" + ".x", pos1.getBlockX());
				arena_cfg.set(arena.toLowerCase() + "." + "pos1" + ".z", pos1.getBlockZ());
				arena_cfg.set(arena.toLowerCase() + "." + "pos1" + ".world", pos1.getWorld().getName());

				arena_cfg.set(arena.toLowerCase() + "." + "pos2" + ".x", pos2.getBlockX());
				arena_cfg.set(arena.toLowerCase() + "." + "pos2" + ".z", pos2.getBlockZ());
				arena_cfg.set(arena.toLowerCase() + "." + "pos2" + ".world", pos2.getWorld().getName());

				arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".x", 0);
				arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".y", 0);
				arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".z", 0);
				arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".world", 0);
				p.sendMessage(Messages.arenaCreate.replace("%arena%", arena));
				try {
					arena_cfg.save(arena_file);
				} catch (IOException e) {
					p.sendMessage(Messages.couldntsave);
				}
			} else {
				p.sendMessage(Messages.posNotSet);
			}
		} else {
			p.sendMessage(Messages.arenaAlreadyExists.replace("%arena%", arena));
		}
	}

	public static void deleteArena(Player p, String arena) {

		if (arena_cfg.get(arena.toLowerCase()) != null) {
			arena_cfg.set(arena.toLowerCase() + "." + "name", null);
			arena_cfg.set(arena.toLowerCase() + "." + "high", null);
			arena_cfg.set(arena.toLowerCase() + "." + "deathzone", null);
			arena_cfg.set(arena.toLowerCase() + "." + "playersonline", null);
			arena_cfg.set(arena.toLowerCase() + "." + "maxplayers", null);

			arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".x", null);
			arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".y", null);
			arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".z", null);
			arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".yaw", null);
			arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".pitch", null);
			arena_cfg.set(arena.toLowerCase() + "." + "spawn" + ".world", null);
			arena_cfg.set(arena.toLowerCase() + "." + "spawn", null);

			arena_cfg.set(arena.toLowerCase() + "." + "pos1" + ".x", null);
			arena_cfg.set(arena.toLowerCase() + "." + "pos1" + ".z", null);
			arena_cfg.set(arena.toLowerCase() + "." + "pos1" + ".world", null);
			arena_cfg.set(arena.toLowerCase() + "." + "pos1", null);

			arena_cfg.set(arena.toLowerCase() + "." + "pos2" + ".x", null);
			arena_cfg.set(arena.toLowerCase() + "." + "pos2" + ".z", null);
			arena_cfg.set(arena.toLowerCase() + "." + "pos2" + ".world", null);
			arena_cfg.set(arena.toLowerCase() + "." + "pos2", null);

			arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".x", null);
			arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".y", null);
			arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".z", null);
			arena_cfg.set(arena.toLowerCase() + "." + "sign" + ".world", null);
			arena_cfg.set(arena.toLowerCase() + "." + "sign", null);
			p.sendMessage(Messages.arenaDelete.replace("%arena%", arena));
			try {
				arena_cfg.save(arena_file);
			} catch (IOException e) {
				p.sendMessage(Messages.couldntsave);
			}
		} else {
			p.sendMessage(Messages.arenaNotAvailable.replace("%arena%", arena));
		}
	}

	public static boolean isInArena(Location loc) {

		for (String arena : arena_cfg.getConfigurationSection("").getKeys(false)) {
			int x1 = arena_cfg.getInt(arena.toLowerCase() + "." + "pos1" + ".x");
			int z1 = arena_cfg.getInt(arena.toLowerCase() + "." + "pos1" + ".z");

			int x2 = arena_cfg.getInt(arena.toLowerCase() + "." + "pos2" + ".x");
			int z2 = arena_cfg.getInt(arena.toLowerCase() + "." + "pos2" + ".z");

			if (((x1 <= loc.getX() && x2 >= loc.getX()) || (x1 >= loc.getX() && x2 <= loc.getX())) && ((z1 <= loc.getZ() && z2 >= loc.getZ()) || (z1 >= loc.getZ() && z2 <= loc.getZ()))) {
				return true;
			}
		}

		return false;

	}

	public static void setSignP(Player p, String arena, int amount) {

		arena_cfg.set(arena.toLowerCase() + ".playersonline", amount);

		try {
			arena_cfg.save(arena_file);
			Location loc = new Location(Bukkit.getWorld(arena_cfg.getString(arena.toLowerCase() + "." + "sign" + ".world")), arena_cfg.getInt(arena.toLowerCase() + "." + "sign" + ".x"), arena_cfg.getInt(arena.toLowerCase() + "." + "sign" + ".y"), arena_cfg.getInt(arena.toLowerCase() + "." + "sign" + ".z"));

			Sign sign = (Sign) loc.getBlock().getState();

			String lastline = ChatColor.translateAlternateColorCodes('&', FileManager.msg_cfg.getString("sign.players"));
			lastline = lastline.replace("%players_online%", Integer.toString(FileManager.arena_cfg.getInt(arena.toLowerCase() + ".playersonline")));
			lastline = lastline.replace("%max_players%", Integer.toString(FileManager.arena_cfg.getInt(arena.toLowerCase() + ".maxplayers")));

			sign.setLine(3, lastline);

			sign.update();
		} catch (IOException e) {
			p.sendMessage(Messages.couldntsave);
		}

	}
	
	public static void updateSign(Player p, String arena, int amount) {

		int playersonline = arena_cfg.getInt(arena.toLowerCase() + ".playersonline");

		arena_cfg.set(arena.toLowerCase() + ".playersonline", playersonline + amount);

		try {
			arena_cfg.save(arena_file);
			Location loc = new Location(Bukkit.getWorld(arena_cfg.getString(arena.toLowerCase() + "." + "sign" + ".world")), arena_cfg.getInt(arena.toLowerCase() + "." + "sign" + ".x"), arena_cfg.getInt(arena.toLowerCase() + "." + "sign" + ".y"), arena_cfg.getInt(arena.toLowerCase() + "." + "sign" + ".z"));

			Sign sign = (Sign) loc.getBlock().getState();

			String lastline = ChatColor.translateAlternateColorCodes('&', FileManager.msg_cfg.getString("sign.players"));
			lastline = lastline.replace("%players_online%", Integer.toString(FileManager.arena_cfg.getInt(arena.toLowerCase() + ".playersonline")));
			lastline = lastline.replace("%max_players%", Integer.toString(FileManager.arena_cfg.getInt(arena.toLowerCase() + ".maxplayers")));

			sign.setLine(3, lastline);

			sign.update();
		} catch (IOException e) {
			p.sendMessage(Messages.couldntsave);
		}

	}

}
