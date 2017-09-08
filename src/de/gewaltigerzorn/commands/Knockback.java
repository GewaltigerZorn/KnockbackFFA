package de.gewaltigerzorn.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.gewaltigerzorn.listener.PInteractEvent;
import de.gewaltigerzorn.main.Main;
import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.Coins;
import de.gewaltigerzorn.methods.FileManager;
import de.gewaltigerzorn.methods.Messages;

public class Knockback implements CommandExecutor {

	public static List<Player> build = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {

			Player p = (Player) sender;

			if (args.length == 0) {
				Messages.help(p);
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("help")) {
					Messages.help(p);
				} else if (args[0].equalsIgnoreCase("tool")) {
					if (p.hasPermission("kb.tool")) {
						p.getInventory().addItem(Main.ArenaToolItem);
					} else {
						p.sendMessage(Messages.noPermissions);
					}
				} else {
					Messages.help(p);
				}
			} else if (args.length == 2) {

				if (args[0].equalsIgnoreCase("reset")) {
					if (p.hasPermission("kb.reset")) {
						for (String arena : FileManager.arena_cfg.getConfigurationSection("").getKeys(false)) {
							if (FileManager.arena_cfg.get(arena.toLowerCase()) != null) {
								Arena.setSignP(p, arena, 0);
							}
							try {
								FileManager.arena_cfg.save(FileManager.arena_file);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				} else if (args[0].equalsIgnoreCase("create")) {
					if (p.hasPermission("kb.create")) {
						Arena.createArena(p, args[1], p.getLocation(), PInteractEvent.pos1.get(p), PInteractEvent.pos2.get(p));
					} else {
						p.sendMessage(Messages.noPermissions);
					}

				} else if (args[0].equalsIgnoreCase("delete")) {

					if (p.hasPermission("kb.delete")) {

						Arena.deleteArena(p, args[1]);
					} else {
						p.sendMessage(Messages.noPermissions);
					}

				} else if (args[0].equalsIgnoreCase("setspawn")) {

					if (p.hasPermission("kb.setspawn")) {
						Arena.setSpawn(p, args[1]);
					} else {
						p.sendMessage(Messages.noPermissions);
					}

				} else if (args[0].equalsIgnoreCase("build")) {
					if (p.hasPermission("kb.build")) {

						if (Bukkit.getPlayer(args[1]) != null) {

							Player t = Bukkit.getPlayer(args[1]);

							if (build.contains(t)) {
								build.remove(t);
								p.sendMessage(Messages.buildModeOff.replace("%player%", t.getName()));
							} else {
								build.add(t);
								p.sendMessage(Messages.buildModeOn.replace("%player%", t.getName()));
							}
						} else {
							p.sendMessage(Messages.playerOffline.replace("%player%", args[1]));
						}
					} else {
						Messages.help(p);
					}

				} else {
					Messages.help(p);
				}

			} else if (args.length == 3) {

				if (args[0].equalsIgnoreCase("sethigh")) {
					if (p.hasPermission("kb.sethigh")) {

						Arena.setHigh(p, args[1], Integer.parseInt(args[2]));

					} else {
						p.sendMessage(Messages.noPermissions);
					}

				} else if (args[0].equalsIgnoreCase("setdeathzone")) {

					if (p.hasPermission("kb.setdeathzone")) {
						Arena.setDeathZone(p, args[1], Integer.parseInt(args[2]));

					} else {
						p.sendMessage(Messages.noPermissions);
					}

				} else if (args[0].equalsIgnoreCase("setmaxplayers")) {

					if (p.hasPermission("kb.setmaxplayers")) {

						Arena.setMaxPlayers(p, args[1], Integer.parseInt(args[2]));

					} else {
						p.sendMessage(Messages.noPermissions);
					}

				} else {
					Messages.help(p);
				}

			} else if (args.length == 4) {

				if (args[0].equalsIgnoreCase("coins")) {
					if (args[1].equalsIgnoreCase("add")) {
						if (p.hasPermission("kb.coins.add")) {
							Coins.addCoins(p, Bukkit.getPlayer(args[2]), Integer.parseInt(args[3]), true);
						} else {
							p.sendMessage(Messages.noPermissions);
						}

					} else if (args[1].equalsIgnoreCase("set")) {

						if (p.hasPermission("kb.coins.set")) {
							Coins.setCoins(p, Bukkit.getPlayer(args[2]), Integer.parseInt(args[3]), true);
						} else {
							p.sendMessage(Messages.noPermissions);
						}

					} else if (args[1].equalsIgnoreCase("remove")) {

						if (p.hasPermission("kb.coins.remove")) {
							Coins.removeCoins(p, Bukkit.getPlayer(args[2]), Integer.parseInt(args[3]), true);

						} else {
							p.sendMessage(Messages.noPermissions);
						}

					} else {
						Messages.help(p);
					}
				} else {
					Messages.help(p);
				}

			} else

			{
				Messages.help(p);
			}

		} else

		{
			Bukkit.getConsoleSender().sendMessage(Messages.noPlayer);
		}

		return true;
	}

}
