package es.minetsii.MiningCrates.clicEffects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import es.minetsii.MiningCrates.MiningCrates;

public class Up {

private MiningCrates plugin;
	
	public Up(MiningCrates plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public void up(Location l){
		for(Player pl : Bukkit.getServer().getOnlinePlayers()){
			pl.playSound(l, Sound.FIREWORK_LAUNCH, 30, 1);
		}
		final FallingBlock fs = l.getWorld().spawnFallingBlock(l.clone().add(0,0.5,0), Material.WOOD, (byte)0);
		fs.setDropItem(false);
		new BukkitRunnable(){
			public void run(){
				fs.setVelocity(new Vector(0,0.3,0));
			}
		}.runTaskTimer(plugin, 0, 2);
		new BukkitRunnable(){
			public void run(){
				fs.remove();
				return;
			}
		}.runTaskLater(plugin, 30);
	}
}
