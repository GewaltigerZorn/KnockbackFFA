package de.gewaltigerzorn.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import de.gewaltigerzorn.apis.Items;
import de.gewaltigerzorn.commands.Knockback;
import de.gewaltigerzorn.listener.BreakEvent;
import de.gewaltigerzorn.listener.EDamageByEEvent;
import de.gewaltigerzorn.listener.EDamageEvent;
import de.gewaltigerzorn.listener.PCmdPreprocessEvent;
import de.gewaltigerzorn.listener.PDeathEvent;
import de.gewaltigerzorn.listener.PDropItemEvent;
import de.gewaltigerzorn.listener.PInteractEvent;
import de.gewaltigerzorn.listener.PMoveEvent;
import de.gewaltigerzorn.listener.PQuitEvent;
import de.gewaltigerzorn.listener.PRespawnEvent;
import de.gewaltigerzorn.listener.PlaceEvent;
import de.gewaltigerzorn.listener.ShopEvent;
import de.gewaltigerzorn.listener.SignEvent;
import de.gewaltigerzorn.methods.Messages;

public class Main extends JavaPlugin {

	public static Main plugin;

	public static ItemStack ArenaToolItem = Items.item(Material.BONE, 1, (short) 0, "§f§LArena-Tool");
	public static ItemStack ShopChest = Items.item(Material.CHEST, 1, (short) 0, "§eShop");
	public static ItemStack KnockbackStick = Items.item_enchant(Material.STICK, 1, (short) 0, "§6Knocker", Enchantment.KNOCKBACK, 2);
	
	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {

		plugin = this;

		if (!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}

		config();
		Messages.createFile();

		Bukkit.getPluginManager().registerEvents(new BreakEvent(), this);
		Bukkit.getPluginManager().registerEvents(new EDamageByEEvent(), this);
		Bukkit.getPluginManager().registerEvents(new EDamageEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PDeathEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PDropItemEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PInteractEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PlaceEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PMoveEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PRespawnEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PCmdPreprocessEvent(), this);
		Bukkit.getPluginManager().registerEvents(new SignEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PQuitEvent(), this);
		Bukkit.getPluginManager().registerEvents(new ShopEvent(), this);
		
		this.getCommand("knockback").setExecutor(new Knockback());

	}

	public void config() {
		this.getConfig().addDefault("leaveCommands", new String[] { "/l", "/lobby", "/hub", "/spawn" });

		this.getConfig().addDefault("coins.kill", 7);
		this.getConfig().addDefault("coins.death", -3);

		this.getConfig().addDefault("shop.gui.title", "&7Shop");

		this.getConfig().addDefault("shop.items.1.name", "&7Blöcke (SANDSTONE)");
		this.getConfig().addDefault("shop.items.1.amount", 8);
		this.getConfig().addDefault("shop.items.1.costs", 10);

		this.getConfig().addDefault("shop.items.2.name", "&7Angel");
		this.getConfig().addDefault("shop.items.2.amount", 1);
		this.getConfig().addDefault("shop.items.2.costs", 10);

		this.getConfig().addDefault("shop.items.3.name", "&7Holzschwert");
		this.getConfig().addDefault("shop.items.3.amount", 1);
		this.getConfig().addDefault("shop.items.3.costs", 10);

		this.getConfig().addDefault("shop.items.4.name", "&7Steinschwert");
		this.getConfig().addDefault("shop.items.4.amount", 1);
		this.getConfig().addDefault("shop.items.4.costs", 10);

		this.getConfig().addDefault("shop.items.5.name", "&7Spinnennetz");
		this.getConfig().addDefault("shop.items.5.amount", 8);
		this.getConfig().addDefault("shop.items.5.costs", 10);

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();

	}

}
