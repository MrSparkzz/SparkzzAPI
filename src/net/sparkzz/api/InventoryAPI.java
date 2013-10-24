package net.sparkzz.api;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/*
 * Created by: MrSparkzz
 */
public class InventoryAPI {
	
	public boolean isFull(Inventory inventory) {
		if (inventory.firstEmpty() != -1) return false;
		return true;
	}
	
	public boolean contains(Inventory inventory, ItemStack itemstack) {
		if (inventory.contains(itemstack)) return true;
		return false;
	}
	
	public boolean contains(Inventory inventory, Material material) {
		if (inventory.contains(material)) return true;
		return false;
	}
	
	public boolean contains(Inventory inventory, Material material, int amount) {
		if (inventory.contains(material, amount)) return true;
		return false;
	}
	
	public boolean hasEmptySlot(Inventory inventory) {
		for (ItemStack items : inventory.getContents()) {
			if (items == null) {
				return false;
			}
		}
		return true;
	}
	
	public String getName(Inventory inventory) {
		return inventory.getName();
	}
	
	public String getTitle(Inventory inventory) {
		return inventory.getTitle();
	}
	
	public void add(Inventory inventory, Material material) {
		if (!isFull(inventory))
			inventory.addItem(new ItemStack(material, 1));
	}
	
	public void add(Inventory inventory, Material material, int amount) {
		int count = 0;
		
		ItemStack items = new ItemStack(material, 1);
		
		do {
			inventory.addItem(items);
			
			count++;
			
			if (isFull(inventory)) break;
		} while (count < amount);
	}
	
	public void add(Player player, Inventory inventory, Material material, int amount) {
		int count = 0;
		
		ItemStack item = new ItemStack(material, 1);
		
		do {
			if (!isFull(inventory)) {
				inventory.addItem(item);
			
				count++;
			} else {
				player.getWorld().dropItemNaturally(player.getLocation(), item);
			
				count++;
			}
		} while (count < amount);
	}
	
	public void addStack(Inventory inventory, Material material) {
		if (hasEmptySlot(inventory)) {
			ItemStack item = new ItemStack(material);
			int max = item.getMaxStackSize();
			
			item = new ItemStack(material, max);
			
			if (max != -1)
				inventory.addItem(item);
		}
	}
	
	public void remove(Inventory inventory, Material material, int amount) {
		if (contains(inventory, material, amount)) {
			do {
				inventory.remove(new ItemStack(material, 1));
				
				amount--;
			} while (amount > 0);
		}
	}
	
	public void removeAll(Inventory inventory, Material material) {
		if (contains(inventory, material)) {
			inventory.remove(material);
		}
	}
	
	public void copy(Player player, Player target) {
		Inventory sourceInv = player.getInventory();
		Inventory targetInv = target.getInventory();
		
		copy(sourceInv, targetInv);
	}

	public void copy(Inventory source, Player target) {
		Inventory targetInv = target.getInventory();
		
		copy(source, targetInv);
	}
	
	public void copy(Inventory source, Inventory target) {
		ItemStack[] items = source.getContents();
		
		target.setContents(items);
	}
	
	public void clear(Inventory inventory) {
		inventory.clear();
	}
}