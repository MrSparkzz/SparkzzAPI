package net.sparkzz.api;

import java.util.logging.Level;

import org.bukkit.plugin.Plugin;

/*
 * Created by: MrSparkzz
 */
public class LoggerAPI {

	public void log(Plugin plugin, Level level, String message) {
		plugin.getLogger().log(level, message);
	}
	
	public void info(Plugin plugin, String message) {
		log(plugin, Level.INFO, message);
	}
	
	public void severe(Plugin plugin, String message) {
		log(plugin, Level.SEVERE, message);
	}
	
	public void warn(Plugin plugin, String message) {
		log(plugin, Level.WARNING, message);
	}
	
	private static LoggerAPI logger = new LoggerAPI();
	
	public static LoggerAPI getLogger() {
		return logger;
	}
}
