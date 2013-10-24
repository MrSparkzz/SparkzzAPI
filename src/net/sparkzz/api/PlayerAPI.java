package net.sparkzz.api;

import org.bukkit.Achievement;
import org.bukkit.entity.Player;

/*
 * Created by: MrSparkzz
 */
public class PlayerAPI {
	
	public boolean addHealth(Player player, int amount) {
		double health = player.getHealth();
		
		if (health == 20) {
			player.setHealth(20);
			return true;
		}
		
		if (health > (20 - amount)) {
			player.setHealth(20);
			return true;
		}
		
		if (health < (20 - amount)) {
			player.setHealth(health + amount);
			return true;
		}
		return false;
	}

	public boolean removeHealth(Player player, int amount) {
		double health = player.getHealth();
		
		if (health > (health - amount)) {
			player.setHealth(health - amount);
			return true;
		}
		
		if (health < (health - amount)) {
			player.setHealth(0);
			return true;
		}
		return false;
	}
	
	public void award(Player player, Achievement achievement) {
		player.awardAchievement(achievement);
	}

	public void burn(Player player) {
		player.setFireTicks(20);
	}

	public void burn(Player player, int ticks) {
		player.setFireTicks(ticks);
	}
	
	public void extinguish(Player player) {
		player.setFireTicks(0);
	}
	
	public void kill(Player player) {
		player.setHealth(0);
	}
}