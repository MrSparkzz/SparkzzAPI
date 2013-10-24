package net.sparkzz.api;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

/*
 * Created by: MrSparkzz
 */
public class EventAPI {
	
	private static HashMap<Listener, Plugin> events;
	{
		events = new HashMap<Listener, Plugin>();
	}
	
	public void addEvent(Listener listener, Plugin plugin) {
		events.put(listener, plugin);
	}
	
	public void registerEvent(Listener listener, Plugin plugin) {
		Bukkit.getPluginManager().registerEvents(listener, plugin);
	}
	
	public void registerEvents() {
		for (Listener listener : events.keySet()) {
			Bukkit.getPluginManager().registerEvents(listener, events.get(listener));
		}
	}
}
