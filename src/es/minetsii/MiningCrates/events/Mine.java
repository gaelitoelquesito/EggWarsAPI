package es.minetsii.MiningCrates.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import es.minetsii.MiningCrates.MiningCrates;

public class Mine implements Listener {
	MiningCrates plugin;

	public Mine(MiningCrates plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void mineEvent(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Random r = new Random();
		Double i = r.nextDouble();
		for(String group : MiningCrates.groups.keySet()){
			if(p.hasPermission(MiningCrates.group_Permission + group)){
				//TODO Comprobación del random respecto al porcentaje del grupo, en caso positivo lanzar el getRandomChest(), sacar los datos, colocarlo, etc...
			}
		}
	}
	
	private Chest getRandomChest(){
		//TODO Seleccionar un cofre random y devolverlo
		
		return null;
	}

}
