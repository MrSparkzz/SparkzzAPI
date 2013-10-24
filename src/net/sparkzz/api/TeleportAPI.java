package net.sparkzz.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/*
 * Created by: MrSparkzz
 */
public class TeleportAPI {

	public Location newLocation(Player target) {
		Location location = target.getLocation();
		
		return location;
	}
	
	public Location newLocation(World world, double x, double y, double z) {
		Location location = new Location(world, x, y, z);
		
		return location;
	}
	
	public Location newLocation(World world, double x, double y, double z, float pitch, float yaw) {
		Location location = new Location(world, x, y, z, pitch, yaw);
		
		return location;
	}
	
	public void teleport(Player player, Player target) {
		player.teleport(target);
	}
	
	public void teleport(Player player, Location location) {
		player.teleport(location);
	}
	
	public void teleport(Player player, double x, double y, double z) {
		Location location = new Location(player.getWorld(), x, y, z);
		
		player.teleport(location);
	}
	
	public void teleport(Player player, World world, double x, double y, double z) {
		Location location = new Location(world, x, y, z);
		
		player.teleport(location);
	}
	
	public void teleport(Player player, World world, double x, double y, double z, float pitch, float yaw) {
		Location location = new Location(world, x, y, z, pitch, yaw);
		
		player.teleport(location);
	}

	public void teleportAll(Location location) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.teleport(location);
		}
	}
	
	public void teleportAll(Player[] players, Location location) {
		for (Player player : players) {
			if (player.isOnline()) {
				player.teleport(location);
			}
		}
	}
	
	public void teleportAll(String[] players, Location location) {
		for (String target : players) {
			Player player = Bukkit.getPlayer(target);
			
			if (player.isOnline()) {
				player.teleport(location);
			}
		}
	}
}