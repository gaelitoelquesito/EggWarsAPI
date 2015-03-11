package es.minetsii.MiningCrates.chests;

import java.util.Random;

import org.bukkit.event.Listener;

import es.minetsii.MiningCrates.MiningCrates;

public class RandomChest implements Listener {
	MiningCrates plugin;
	public RandomChest(MiningCrates plugin){
		this.plugin = plugin;
	}
	
	
	Chest ch;
	
	public void Random(){
		Random r = new Random();
	}

}
