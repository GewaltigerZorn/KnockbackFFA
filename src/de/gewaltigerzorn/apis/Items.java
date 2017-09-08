package de.gewaltigerzorn.apis;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Items {

	public static ItemStack item(Material material, int amount, short subid, String displayname) {
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setDisplayName(displayname);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}

	public static ItemStack item(Material material, int amount, short subid, String displayname, short durability) {
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setDisplayName(displayname);
		itemstack.setDurability(durability);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ItemStack item_lore(Material material, int amount, short subid, String displayname, String lore) {
		List<String> l = new ArrayList<String>();
		l.add(lore);
		
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setDisplayName(displayname);
		itemmeta.setLore(l);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}

	public static ItemStack item_lore(Material material, int amount, short subid, String lore) {
		List<String> l = new ArrayList<String>();
		l.add(lore);
		
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setLore(l);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}

	public static ItemStack item_lore(Material material, int amount, short subid, String lore, short durability) {
		List<String> l = new ArrayList<String>();
		l.add(lore);
		
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setLore(l);
		itemstack.setDurability(durability);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}

	public static ItemStack item_lore(Material material, int amount, short subid, String displayname, String lore, short durability) {
		List<String> l = new ArrayList<String>();
		l.add(lore);
		
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setDisplayName(displayname);
		itemmeta.setLore(l);
		itemstack.setDurability(durability);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ItemStack item_enchant(Material material, int amount, short subid, Enchantment enchantment, int level) {
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.addEnchant(enchantment, level, true);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}

	public static ItemStack item_enchant(Material material, int amount, short subid, String displayname, Enchantment enchantment, int level) {
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setDisplayName(displayname);
		itemmeta.addEnchant(enchantment, level, true);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}

	public static ItemStack item_enchant(Material material, int amount, short subid, Enchantment enchantment, int level, short durability) {
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.addEnchant(enchantment, level, true);
		itemstack.setDurability(durability);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}

	public static ItemStack item_enchant(Material material, int amount, short subid, String displayname, Enchantment enchantment, int level, short durability) {
		ItemStack itemstack = new ItemStack(material, amount, subid);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setDisplayName(displayname);
		itemmeta.addEnchant(enchantment, level, true);
		itemstack.setDurability(durability);
		itemstack.setItemMeta(itemmeta);

		return itemstack;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ItemStack item_skull(String owner, int amount) {
		ItemStack itemstack = new ItemStack(Material.SKULL_ITEM);
		SkullMeta skullmeta = (SkullMeta) itemstack.getItemMeta();
		skullmeta.setOwner(owner);
		itemstack.setItemMeta(skullmeta);

		return itemstack;
	}

	public static ItemStack item_skull(String owner, int amount, String displayname) {
		ItemStack itemstack = new ItemStack(Material.SKULL_ITEM);
		SkullMeta skullmeta = (SkullMeta) itemstack.getItemMeta();
		skullmeta.setOwner(owner);
		skullmeta.setDisplayName(displayname);
		itemstack.setItemMeta(skullmeta);

		return itemstack;
	}

	public static ItemStack item_skull(String owner, int amount, String displayname, String lore) {
		List<String> l = new ArrayList<String>();
		l.add(lore);
		
		ItemStack itemstack = new ItemStack(Material.SKULL_ITEM, amount);
		SkullMeta skullmeta = (SkullMeta) itemstack.getItemMeta();
		skullmeta.setOwner(owner);
		skullmeta.setDisplayName(displayname);
		skullmeta.setLore(l);
		itemstack.setItemMeta(skullmeta);

		return itemstack;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ItemStack item_skull_enchant(String owner, int amount, String displayname, Enchantment enchantment, int level) {
		ItemStack itemstack = new ItemStack(Material.SKULL_ITEM, amount);
		SkullMeta skullmeta = (SkullMeta) itemstack.getItemMeta();
		skullmeta.setOwner(owner);
		skullmeta.setDisplayName(displayname);
		skullmeta.addEnchant(enchantment, level, true);
		itemstack.setItemMeta(skullmeta);

		return itemstack;
	}

	public static ItemStack item_skull_enchant(String owner, int amount, String displayname, String lore, Enchantment enchantment, int level) {
		List<String> l = new ArrayList<String>();
		l.add(lore);
		
		ItemStack itemstack = new ItemStack(Material.SKULL_ITEM, amount);
		SkullMeta skullmeta = (SkullMeta) itemstack.getItemMeta();
		skullmeta.setOwner(owner);
		skullmeta.setDisplayName(displayname);
		skullmeta.setLore(l);
		skullmeta.addEnchant(enchantment, level, true);
		itemstack.setItemMeta(skullmeta);

		return itemstack;
	}

}
