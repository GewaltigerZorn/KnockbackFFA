package de.gewaltigerzorn.methods;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.gewaltigerzorn.main.Main;

public class FileManager {

	public static File arena_file = new File(Main.plugin.getDataFolder(), "arenas.yml");
	public static FileConfiguration arena_cfg = YamlConfiguration.loadConfiguration(arena_file);

	public static File msg_file = new File(Main.plugin.getDataFolder(), "messages.yml");
	public static FileConfiguration msg_cfg = YamlConfiguration.loadConfiguration(msg_file);

	public static File stats_file = new File(Main.plugin.getDataFolder(), "stats.yml");
	public static FileConfiguration stats_cfg = YamlConfiguration.loadConfiguration(stats_file);

	public static void setPlayerDefaults(Player p, int coins, int kills, int deaths) {
		stats_cfg.set(p.getUniqueId() + ".coins", coins);
		stats_cfg.set(p.getUniqueId() + ".kills", kills);
		stats_cfg.set(p.getUniqueId() + ".deaths", deaths);

		try {
			stats_cfg.save(stats_file);
		} catch (IOException e) {
		}
	}

}
