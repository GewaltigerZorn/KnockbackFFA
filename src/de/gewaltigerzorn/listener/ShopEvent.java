package de.gewaltigerzorn.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import de.gewaltigerzorn.apis.Items;
import de.gewaltigerzorn.main.Main;
import de.gewaltigerzorn.methods.Arena;
import de.gewaltigerzorn.methods.Coins;
import de.gewaltigerzorn.methods.Messages;

public class ShopEvent implements Listener {

	Inventory inv;

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {

		Player p = e.getPlayer();

		if (Arena.isInArena(p.getLocation())) {
			if (e.getItem().equals(Main.ShopChest)) {

				inv = p.getServer().createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("shop.gui.title")));

				inv.setItem(0, Items.item_lore(Material.SANDSTONE, getAmount(1), (short) 0, getName(1), "§6" + getCosts(1) + " Coins"));
				inv.setItem(1, Items.item_lore(Material.FISHING_ROD, getAmount(2), (short) 0, getName(2), "§6" + getCosts(2) + " Coins"));
				inv.setItem(2, Items.item_lore(Material.WOOD_SWORD, getAmount(3), (short) 0, getName(3), "§6" + getCosts(3) + " Coins"));
				inv.setItem(3, Items.item_lore(Material.STONE_SWORD, getAmount(4), (short) 0, getName(4), "§6" + getCosts(4) + " Coins"));
				inv.setItem(4, Items.item_lore(Material.WEB, getAmount(5), (short) 0, getName(5), "§6" + getCosts(5) + " Coins"));
			

				p.openInventory(inv);

			}
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("shop.gui.title")))) {
			e.setCancelled(true);

			if (e.getCurrentItem().equals(Items.item_lore(Material.SANDSTONE, getAmount(1), (short) 0, getName(1), "§6" + getCosts(1) + " Coins"))) {
				if (Coins.getCoins(p) >= getCosts(2)) {
					Coins.removeCoins(p, p, getCosts(1), false);
					p.getInventory().addItem(Items.item(Material.SANDSTONE, getAmount(1), (short) 0, getName(1)));
				} else {
					p.sendMessage(Messages.notEnoughCoins);
				}

			} else if (e.getCurrentItem().equals(Items.item_lore(Material.FISHING_ROD, getAmount(2), (short) 0, getName(2), "§6" + getCosts(2) + " Coins"))) {

				if (Coins.getCoins(p) >= getCosts(2)) {
					Coins.removeCoins(p, p, getCosts(2), false);
					p.getInventory().addItem(Items.item(Material.FISHING_ROD, getAmount(2), (short) 0, getName(2)));
				} else {
					p.sendMessage(Messages.notEnoughCoins);
				}

			} else if (e.getCurrentItem().equals(Items.item_lore(Material.WOOD_SWORD, getAmount(3), (short) 0, getName(3), "§6" + getCosts(3) + " Coins"))) {
				if (Coins.getCoins(p) >= getCosts(3)) {
					Coins.removeCoins(p, p, getCosts(3), false);
					p.getInventory().addItem(Items.item(Material.WOOD_SWORD, getAmount(3), (short) 0, getName(3)));
				} else {
					p.sendMessage(Messages.notEnoughCoins);
				}

			} else if (e.getCurrentItem().equals(Items.item_lore(Material.STONE_SWORD, getAmount(4), (short) 0, getName(4), "§6" + getCosts(4) + " Coins"))) {
				if (Coins.getCoins(p) >= getCosts(4)) {
					Coins.removeCoins(null, p, getCosts(4), false);
					p.getInventory().addItem(Items.item(Material.STONE_SWORD, getAmount(4), (short) 0, getName(4)));
				} else {
					p.sendMessage(Messages.notEnoughCoins);
				}
			} else if (e.getCurrentItem().equals(Items.item_lore(Material.WEB, getAmount(5), (short) 0, getName(5), "§6" + getCosts(5) + " Coins"))) {
				if (Coins.getCoins(p) >= getCosts(5)) {
					Coins.removeCoins(null, p, getCosts(5), false);
					p.getInventory().addItem(Items.item(Material.WEB, getAmount(5), (short) 0, getName(5)));
				} else {
					p.sendMessage(Messages.notEnoughCoins);
				}
			}
		}
	}

	public String getName(int i) {
		return ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("shop.items." + i + ".name"));
	}

	public int getAmount(int i) {
		return Main.plugin.getConfig().getInt("shop.items." + i + ".amount");
	}

	public int getCosts(int i) {
		return Main.plugin.getConfig().getInt("shop.items." + i + ".costs");
	}

}
