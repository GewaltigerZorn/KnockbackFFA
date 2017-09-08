package de.gewaltigerzorn.methods;

import org.bukkit.entity.Player;

public class Coins extends FileManager {

	public static void setCoins(Player p, Player t, int amount, boolean msgOutput) {

		try {
			if (stats_cfg.get(t.getUniqueId().toString()) != null) {
				stats_cfg.set(t.getUniqueId() + ".coins", amount);
				if (msgOutput) {
					String msg = Messages.coinsSet.replace("%player%", t.getName()).replace("%amount%", Integer.toString(amount));

					p.sendMessage(msg);
				}
				ScoreboardEvent.updateScoreboard(t);
				stats_cfg.save(stats_file);

			} else {
				setPlayerDefaults(t, 0, 0, 0);

			}
		} catch (Exception e) {
			p.sendMessage(Messages.notANumber);
		}

	}

	public static void addCoins(Player p, Player t, int amount, boolean msgOutput) {

		try {
			if (stats_cfg.get(t.getUniqueId().toString()) != null) {
				int coins = stats_cfg.getInt(t.getUniqueId() + ".coins");
				stats_cfg.set(t.getUniqueId() + ".coins", coins + amount);
				if (msgOutput) {
					String msg = Messages.coinsAdd.replace("%player%", t.getName()).replace("%amount%", Integer.toString(amount));

					p.sendMessage(msg);
				}
				ScoreboardEvent.updateScoreboard(t);
				stats_cfg.save(stats_file);

			} else {
				setPlayerDefaults(t, 0, 0, 0);

			}
		} catch (Exception e) {
			p.sendMessage(Messages.notANumber);
		}

	}

	public static void removeCoins(Player p, Player t, int amount, boolean msgOutput) {

		try {
			if (stats_cfg.get(t.getUniqueId().toString()) != null) {
				int coins = stats_cfg.getInt(t.getUniqueId() + ".coins");
				stats_cfg.set(t.getUniqueId() + ".coins", coins - amount);
				if (msgOutput) {
					String msg = Messages.coinsRemove.replace("%player%", t.getName()).replace("%amount%", Integer.toString(amount));

					p.sendMessage(msg);

				}
				ScoreboardEvent.updateScoreboard(t);
				stats_cfg.save(stats_file);

			} else {
				setPlayerDefaults(t, 0, 0, 0);

			}
		} catch (Exception e) {
			p.sendMessage(Messages.notANumber);
		}

	}

	public static int getCoins(Player p) {
		try {
			if (stats_cfg.get(p.getUniqueId().toString()) != null) {
				return stats_cfg.getInt(p.getUniqueId() + ".coins");
			} else {
				return -1;
			}
		} catch (Exception e) {

		}
		return -1;
	}

}
