package de.gewaltigerzorn.listener;

import org.bukkit.entity.Player;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.gewaltigerzorn.main.Main;
import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.FileManager;
import de.gewaltigerzorn.methods.Messages;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

public class PDeathEvent implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {

			Player killer = e.getEntity().getKiller();
			Player death = e.getEntity();

			if (Arena.isInArena(e.getEntity().getPlayer().getLocation())) {

				e.getDrops().clear();
				e.getEntity().getPlayer().getInventory().clear();
				e.setDeathMessage(null);

				respawn(death);

				if (killer == null) {

					int d_coins = FileManager.stats_cfg.getInt(death.getUniqueId() + ".coins");
					int d_kills = FileManager.stats_cfg.getInt(death.getUniqueId() + ".kills");
					int d_deaths = FileManager.stats_cfg.getInt(death.getUniqueId() + ".deaths");
					FileManager.setPlayerDefaults(death, d_coins + Main.plugin.getConfig().getInt("coins.death"), d_kills, d_deaths + 1);

					death.sendMessage(Messages.playerDeath_fall);
					
					if(FileManager.stats_cfg.getInt(death.getUniqueId() + ".coins") < 0) {
						FileManager.stats_cfg.set(death.getUniqueId() + ".coins", 0);
						
						try {
							FileManager.stats_cfg.save(FileManager.stats_file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

				}

				if (killer instanceof Player && death instanceof Player) {

					int k_coins = FileManager.stats_cfg.getInt(killer.getUniqueId() + ".coins");
					int k_kills = FileManager.stats_cfg.getInt(killer.getUniqueId() + ".kills");
					int k_deaths = FileManager.stats_cfg.getInt(killer.getUniqueId() + ".deaths");

					FileManager.setPlayerDefaults(death, k_coins + Main.plugin.getConfig().getInt("coins.kill"), k_kills + 1, k_deaths);
					killer.sendMessage(Messages.playerKill.replace("%player%", death.getName()));

					int d_coins = FileManager.stats_cfg.getInt(death.getUniqueId() + ".coins");
					int d_kills = FileManager.stats_cfg.getInt(death.getUniqueId() + ".kills");
					int d_deaths = FileManager.stats_cfg.getInt(death.getUniqueId() + ".deaths");

					FileManager.setPlayerDefaults(killer, d_coins + Main.plugin.getConfig().getInt("coins.death"), d_kills, d_deaths + 1);
					death.sendMessage(Messages.playerDeath_player.replace("%player%", killer.getName()));

					if(FileManager.stats_cfg.getInt(death.getUniqueId() + ".coins") < 0) {
						FileManager.stats_cfg.set(death.getUniqueId() + ".coins", 0);
						
						try {
							FileManager.stats_cfg.save(FileManager.stats_file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
				}
			}
		}
	}

	public void respawn(Player p) {
		Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {

			@Override
			public void run() {
				((CraftPlayer) p).getHandle().playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));

			}
		}, 1);
	}

}
