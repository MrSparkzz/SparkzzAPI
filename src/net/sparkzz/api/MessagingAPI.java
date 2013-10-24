package net.sparkzz.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 * Created by: MrSparkzz
 */
public class MessagingAPI {

	public void broadcast(String message) {
		Bukkit.broadcastMessage(message);
	}
	
	public void broadcast(String[] args) {
		broadcast(0, args);
	}
	
	public void broadcast(int start, String[] args) {
		String message = buildString(start, args);
		
		Bukkit.broadcastMessage(message);
	}
	
	public void deny(CommandSender sender) {
		sender.sendMessage(ChatColor.RED + "You are not allowed to do this!");
	}
	
	public void deny(CommandSender sender, String message) {
		sender.sendMessage(ChatColor.RED + message);
	}
	
	public void deny(Player player) {
		player.sendMessage(ChatColor.RED + "You are not allowed to do this!");
	}
	
	public void deny(Player player, String message) {
		player.sendMessage(ChatColor.RED + message);
	}
	
	public void massSend(String message) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage(message);
		}
	}
	
	public void massSend(Player[] players, String message) {
		for (Player player : players) {
			if (player.isOnline()) {
				player.sendMessage(message);
			}
		}
	}
	
	public void massSend(String[] players, String message) {
		for (String target : players) {
			Player player = Bukkit.getPlayer(target);
			
			if (player.isOnline()) {
				player.sendMessage(message);
			}
		}
	}
	
	public void noTarget(CommandSender sender, String name) {
		sender.sendMessage(ChatColor.GOLD + name + ChatColor.RED + " was not found!");
	}
	
	public void noTarget(Player player, String name) {
		player.sendMessage(ChatColor.GOLD + name + ChatColor.RED + " was not found!");
	}
	
	public void send(CommandSender sender, String message) {
		sender.sendMessage(message);
	}
	
	public void send(Player player, String message) {
		player.sendMessage(message);
	}
	
	public void send(String name, String message) {
		Player player = Bukkit.getPlayer(name);
		
		if (player != null) {
			player.sendMessage(message);
		}
	}
	
	public String buildString(String[] args) {
		return buildString(0, args);
	}
	
	public String buildString(int start, String[] args) {
		StringBuilder str = new StringBuilder();
		
		for (int i = start; i < args.length; i++) {
			str.append(args[i] + " ");
		}
	
		String message = str.toString();
		
		return message;
	}

	public String info(String message) {
		return ChatColor.GRAY + "" + ChatColor.ITALIC + message;
	}
	
	public String severe(String message) {
		return ChatColor.RED + message;
	}
	
	public String warn(String message) {
		return ChatColor.YELLOW + message;
	}
	
	private static MessagingAPI messageAPI = new MessagingAPI();
	
	public static MessagingAPI getMessenger() {
		return messageAPI;
	}
}