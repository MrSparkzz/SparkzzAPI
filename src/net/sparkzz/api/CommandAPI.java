package net.sparkzz.api;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

/*
 * Created by: MrSparkzz
 */
public class CommandAPI {

	private static HashMap<String, CommandExecutor> commands;
	{
		commands = new HashMap<String, CommandExecutor>();
	}
	
	public void addCommand(String command, CommandExecutor executor) {
		commands.put(command, executor);
	}
	
	public void initCommand(String command, CommandExecutor executor) {
		Bukkit.getPluginCommand(command).setExecutor(executor);
	}
	
	public void initCommands() {
		for (String command : commands.keySet()) {
			Bukkit.getPluginCommand(command).setExecutor(commands.get(command));
		}
	}
}