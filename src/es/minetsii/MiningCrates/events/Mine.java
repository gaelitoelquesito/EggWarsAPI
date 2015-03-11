package es.minetsii.MiningCrates.events;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import es.minetsii.MiningCrates.MiningCrates;
import es.minetsii.MiningCrates.chests.Chest;

public class Mine implements Listener {
	MiningCrates plugin;

	public Mine(MiningCrates plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void mineEvent(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Double i = new Random().nextDouble() * 100;
		if(!MiningCrates.blocksAffected.containsKey(e.getBlock().getType()))
				return;
		for(String group : MiningCrates.groups.keySet()){
			if(p.hasPermission(MiningCrates.group_Permission + group)){
				//TODO Comprobación del random respecto al porcentaje del grupo, en caso positivo lanzar el getRandomChest(), sacar los datos, colocarlo, etc...
				//Probabilidad de Acierto = probabilidadBloque * probabilidadGrupo
				Double probability = MiningCrates.blocksAffected.get(e.getBlock().getType()) * MiningCrates.groups.get(group);
				if(i <= probability){
					getRandomChest();
					// y mucho blablabla
				}
			}
		}
	}
	
	private Chest getRandomChest(){
		//TODO Seleccionar un cofre random y devolverlo
		Double i = new Random().nextDouble() * 100;
		for(Double chestProb : MiningCrates.chestList.values()){
			if(i <= chestProb)
				return MiningCrates.getKeyByValue(MiningCrates.chestList, chestProb);
		}
		return null;
	}
}
