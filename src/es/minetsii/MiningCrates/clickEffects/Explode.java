package es.minetsii.MiningCrates.clickEffects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import es.minetsii.MiningCrates.events.ParticleEffect;


public class Explode {

	public static void explode(Location l){
		for(Player pl : Bukkit.getServer().getOnlinePlayers()){
			pl.playSound(l, Sound.FIREWORK_BLAST, 30, 1);
		}
		ParticleEffect.FIREWORKS_SPARK.display(0.3F, 0.3F, 0.3F, 1, 50, 
				l, 20);
	}
}
