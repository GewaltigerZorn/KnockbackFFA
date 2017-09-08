package de.gewaltigerzorn.methods;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages extends FileManager {

	public static String playerOffline;
	public static String noPlayer;
	public static String noPermissions;
	public static String itemDrop;
	public static String arenaFull;
	public static String arenaCreate;
	public static String arenaDelete;
	public static String arenaAlreadyExists;
	public static String arenaNotAvailable;
	public static String spawnSet;
	public static String couldntsave;
	public static String notANumber;
	public static String highSet;
	public static String deathzoneSet;
	public static String maxplayersSet;
	public static String coinsAdd;
	public static String coinsSet;
	public static String coinsRemove;
	public static String pos1Set;
	public static String pos2Set;
	public static String posNotSet;
	public static String itemBuy;
	public static String playerDeath_player;
	public static String playerDeath_fall;
	public static String playerKill;
	public static String notEnoughCoins;
	public static String differentWorlds;
	public static String buildModeOn;
	public static String buildModeOff;

	public static void createFile() {
		if (msg_file.exists()) {
			msg_cfg.addDefault("playerOffline", "&cKnockbackFFA &8» &7Der Spieler %player% ist nicht online!");
			msg_cfg.addDefault("noPlayer", "&cKnockbackFFA &8» &7Dieser Befehl kann nur ein Spieler ausführen!");
			msg_cfg.addDefault("noPermissions", "&6Hycraft &8| &7Unbekannter Befehl!");
			msg_cfg.addDefault("itemDrop", "&cKnockbackFFA &8» &7Du darfst keine Items droppen!");
			msg_cfg.addDefault("arenaFull", "&cKnockbackFFA &8» &7Die Arena ist voll!");
			msg_cfg.addDefault("arenaCreate", "&cKnockbackFFA &8» &7Die Arena %arena% wurde erfolgreich erstellt!");
			msg_cfg.addDefault("arenaDelete", "&cKnockbackFFA &8» &7Die Arena %arena% wurde erfolgreich entfernt!");
			msg_cfg.addDefault("arenaAlreadyExists", "&cKnockbackFFA &8» &7Die Arena %arena% ist bereits vorhanden!");
			msg_cfg.addDefault("arenaNotAvailable", "&cKnockbackFFA &8» &7Die Arena %arena% ist nicht vorhanden!");
			msg_cfg.addDefault("couldntsave", "&cKnockbackFFA &8» &7Die Datei konnte nicht gespeichert werden!");
			msg_cfg.addDefault("spawnSet", "&cKnockbackFFA &8» &7Der Spawn wurde gesetzt!");
			msg_cfg.addDefault("notANumber", "&cKnockbackFFA &8» &7Du musst eine Zahl eingeben!");
			msg_cfg.addDefault("highSet", "&cKnockbackFFA &8» &7Du hast die Höhe erfolgreich auf %amount% gesetzt!");
			msg_cfg.addDefault("deathzoneSet", "&cKnockbackFFA &8» &7Du hast die Todes-Höhe erfolgreich auf %amount% gesetzt!");
			msg_cfg.addDefault("maxplayersSet", "&cKnockbackFFA &8» &7Du hast die maximalen Spieler auf %amount% gesetzt!");
			msg_cfg.addDefault("coinsAdd", "&cKnockbackFFA &8» &7Du hast %player% %amount% Coins gegeben!");
			msg_cfg.addDefault("coinsSet", "&cKnockbackFFA &8» &7Du hast %player% sein Konto auf %amount% Coins gesetzt!");
			msg_cfg.addDefault("coinsRemove", "&cKnockbackFFA &8» &7Du hast %player%, %amount% Coins weg genommen!");
			msg_cfg.addDefault("pos1Set", "&cKnockbackFFA &8» &7Du hast die erste Position gesetzt!");
			msg_cfg.addDefault("pos2Set", "&cKnockbackFFA &8» &7Du hast die zweite Position gesetzt!");
			msg_cfg.addDefault("posNotSet", "&cKnockbackFFA &8» &7Du musst erst die Arena markieren!");
			msg_cfg.addDefault("itemBuy", "&cKnockbackFFA &8» &7Du hast dir das Item: %item% erfolgreich gekauft!");
			msg_cfg.addDefault("playerDeath.player", "&cKnockbackFFA &8» &7Du wurdest von %player% getötet!");
			msg_cfg.addDefault("playerDeath.fall", "&cKnockbackFFA &8» &7Du wurdest getötet!");
			msg_cfg.addDefault("playerKill", "&cKnockbackFFA &8» &7Du hast %player% getötet!");
			msg_cfg.addDefault("notEnoughCoins", "&cKnockbackFFA &8» &7Du hast nicht genug Coins!");
			msg_cfg.addDefault("differentWorlds", "&cKnockbackFFA &8» &7Du hast zwei unterschiedliche Welten ausgewählt!");
			msg_cfg.addDefault("buildModeOn", "&cKnockbackFFA &8» &7%player% kann nun bauen!");
			msg_cfg.addDefault("buildModeOff", "&cKnockbackFFA &8» &7%player% kann nicht mehr bauen!");

			msg_cfg.addDefault("sign.title", "&7[&cKnockbackFFA&7]");
			msg_cfg.addDefault("sign.others", "&7---------------");
			msg_cfg.addDefault("sign.arena", "&6%arena%");
			msg_cfg.addDefault("sign.players", "&7%players_online% &8/ &7%max_players%");

			msg_cfg.addDefault("help", new String[] { "&8[]&7=========&8(&cKnockbackFFA Help&8)&7=========&8[]", "&6/kb create <arena> &7| &eErstellt eine neue Arena!", "&6/kb delete <arena> &7| &eErstellt eine neue Arena!", "&6/kb setspawn <arena> &7| &eSetzt den Spawn einer Arena!", "&6/kb sethigh <arena> <amount>&7| &eSetzt die höhe, ab wann man kämpfen kann!", "&6/kb setdeathzone <arena> <amount>&7| &eSetzt die höhe, wann der Spieler stirbt!",
					"&6/kb setmaxplayers <arena> <amount> &7| &eSetzt die Anzahl der Maximalen Spieler, von dieser Arena!", "&6/kb coins <set/add/remove> <player> <amount> &7| &eSetzt/gibt/entfernt einen Spieler eine Anzahl an Coins!", "&6/kb build <player> &7| &eGibt einem Spieler Bau-Rechte!", "&6/kb tool &7| &eGibt dir ein Tool, womit du die Arena markieren kannst!", "&6/kb coins <set/add/remove> <player> <amount> &7| &eSetzt/gibt/entfernt einen Spieler eine Anzahl an Coins!", "&6/kb build <player> &7| &eGibt einem Spieler Bau-Rechte!", "&6/kb reset <arena> &7| &eSetzt den Spielerstand einer Arena auf 0", "[]=====================================[]" });

			msg_cfg.addDefault("scoreboard-title", "&7[&cKnockbackFFA&7]");
			msg_cfg.addDefault("scoreboard", new String[] {"", "&eKills ", "&8» &7%kills% ", " ", "&eTode", "&8» &7%deaths%", "  ", "&eCoins  ", "&8» &6%coins%  " });

			msg_cfg.options().copyDefaults(true);

			try {
				msg_cfg.save(msg_file);

				playerOffline = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("playerOffline"));
				noPlayer = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("noPlayer"));
				noPermissions = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("noPermissions"));
				itemDrop = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("itemDrop"));
				arenaFull = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("arenaFull"));
				arenaCreate = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("arenaCreate"));
				arenaDelete = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("arenaDelete"));
				arenaAlreadyExists = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("arenaAlreadyExists"));
				arenaNotAvailable = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("arenaNotAvailable"));
				spawnSet = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("spawnSet"));
				couldntsave = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("couldntsave"));
				notANumber = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("notANumber"));
				highSet = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("highSet"));
				deathzoneSet = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("deathzoneSet"));
				maxplayersSet = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("maxplayersSet"));
				coinsAdd = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("coinsAdd"));
				coinsSet = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("coinsSet"));
				coinsRemove = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("coinsRemove"));
				pos1Set = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("pos1Set"));
				pos2Set = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("pos2Set"));
				posNotSet = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("posNotSet"));
				itemBuy = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("itemBuy"));
				playerDeath_player = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("playerDeath.player"));
				playerDeath_fall = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("playerDeath.fall"));
				playerKill = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("playerKill"));
				notEnoughCoins = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("notEnoughCoins"));
				differentWorlds = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("differentWorlds"));
				buildModeOn = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("buildModeOn"));
				buildModeOff = ChatColor.translateAlternateColorCodes('&', msg_cfg.getString("buildModeOff"));

			} catch (IOException e) {
				Bukkit.getConsoleSender().sendMessage(couldntsave);
			}
		} else {
			try {
				msg_file.createNewFile();
				createFile();
			} catch (IOException e) {
				Bukkit.getConsoleSender().sendMessage(couldntsave);
			}
		}
	}

	public static void help(Player p) {
		if (p.hasPermission("kb.help")) {
			for (String help : msg_cfg.getStringList("help")) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', help));
			}
		} else {
			p.sendMessage(noPermissions);
		}
	}
}
