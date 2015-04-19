package es.minetsii.MiningCrates.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;

import es.minetsii.MiningCrates.MiningCrates;
import es.minetsii.MiningCrates.chests.CrateEffect;
import es.minetsii.MiningCrates.clickEffects.Explode;
import es.minetsii.MiningCrates.clickEffects.Teleport;
import es.minetsii.MiningCrates.clickEffects.Up;

public class RemoveCrate {

	private MiningCrates plugin;
	private Up up;
	
	public RemoveCrate(MiningCrates plugin){
		this.plugin = plugin;
		this.up = new Up(plugin);
	}
	
	public void removeCrate(CrateEffect effect, Chest ch){
		Location l = ch.getLocation();
		ch.getInventory().clear();
		ch.getLocation().getBlock().setType(Material.AIR);
		switch(effect){
		default:
		case UP:
			up.up(l);
			break;
		case EXPLODE:
			Explode.explode(l);
			break;
		case TELEPORT:
			Teleport.teleport(l);
			break;
		}
	}
}
