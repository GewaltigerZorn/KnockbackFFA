package de.gewaltigerzorn.methods;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import de.gewaltigerzorn.main.Main;

public class ScoreboardEvent extends FileManager {

	public static void updateScoreboard(Player p) {
		int taskID = 0;
		if (!Bukkit.getScheduler().isCurrentlyRunning(taskID)) {
			taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

				@Override
				public void run() {
					addScoreboard(p);

				}
			}, 0, 20);
		}
	}

	public static void addScoreboard(Player p) {

		Scoreboard board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();

		Objective o = board.registerNewObjective("Scoreboard", "dummy");

		o.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileManager.msg_cfg.getString("scoreboard-title")));
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		List<String> Lines = FileManager.msg_cfg.getStringList("scoreboard");
		int Line = Lines.size();
		for (String s : Lines) {
			String Replaced = s.replace("%kills%", Integer.toString(stats_cfg.getInt(p.getUniqueId() + ".kills"))).replace("%deaths%", Integer.toString(stats_cfg.getInt(p.getUniqueId() + ".deaths"))).replace("%coins%", Integer.toString(stats_cfg.getInt(p.getUniqueId() + ".coins")));

			o.getScore(ChatColor.translateAlternateColorCodes('&', Replaced)).setScore(--Line);
		}
		p.setScoreboard(board);
	}

}
