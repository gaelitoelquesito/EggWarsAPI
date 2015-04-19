package es.minetsii.MiningCrates.clickEffects;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Teleport {

	@SuppressWarnings("deprecation")
	public static void teleport(Location l){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.playEffect(l, Effect.ENDER_SIGNAL, 100000);
			p.playSound(l, Sound.ENDERMAN_TELEPORT, 30, 1);
		}
	}
}
