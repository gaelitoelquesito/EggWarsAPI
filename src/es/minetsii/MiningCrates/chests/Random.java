package es.minetsii.MiningCrates.chests;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import es.minetsii.MiningCrates.MiningCrates;

public class Random implements Listener {
	MiningCrates plugin;
	public Random(MiningCrates plugin){
		this.plugin = plugin;
	}
	
	
	Chest ch;
	
	public void random(){
		Random r = new Random();
		List<ItemStack> i = ch.getItems();
		int size = i.size();
	}

}
