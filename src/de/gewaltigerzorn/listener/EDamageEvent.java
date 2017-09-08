package de.gewaltigerzorn.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import de.gewaltigerzorn.methods.Arena;

public class EDamageEvent implements Listener{
	
	@EventHandler
	public void onDmage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			
			if(Arena.isInArena(e.getEntity().getLocation())) {
				if(e.getCause().equals(DamageCause.FALL)) {
					e.setCancelled(true);
				}
			}
			
		}
	}

}
