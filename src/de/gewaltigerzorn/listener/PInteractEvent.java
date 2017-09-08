package de.gewaltigerzorn.listener;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.gewaltigerzorn.main.Main;
import de.gewaltigerzorn.methods.Messages;

public class PInteractEvent implements Listener {

	public static Map<Player, Location> pos1 = new HashMap<Player, Location>();
	public static Map<Player, Location> pos2 = new HashMap<Player, Location>();

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (p.getItemInHand().equals(Main.ArenaToolItem)) {
			if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
				e.setCancelled(true);
				pos1.put(p, e.getClickedBlock().getLocation());
				p.sendMessage(Messages.pos1Set);

			} else if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				pos2.put(p, e.getClickedBlock().getLocation());
				p.sendMessage(Messages.pos2Set);
			}
		}
	}



}
