package es.minetsii.MiningCrates.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import es.minetsii.MiningCrates.MiningCrates;
import es.minetsii.MiningCrates.chests.Crate;

public class Mine implements Listener {
	MiningCrates plugin;

	public Mine(MiningCrates plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void mineEvent(BlockBreakEvent e) {
		final Player p = e.getPlayer();
		Double i = new Random().nextDouble() * 100;
		if (!MiningCrates.blocksAffected.containsKey(e.getBlock().getType())) {
			return;
		} else {
		}
		for (String group : MiningCrates.groups.keySet()) {
			try{
			if (!p.hasPermission(MiningCrates.group_Permission + group)) {
				continue;
			}
			double block = MiningCrates.blocksAffected.get(e.getBlock()
					.getType());
			double gr = MiningCrates.groups.get(group);
			double probability = gr * block;
			if (i > probability || detectchest(e.getBlock().getLocation()) == false)
				break;
			Crate chest = getRandomChest();
			if (chest == null)
				break;
			final Block b = e.getBlock();
			e.setCancelled(true);
			for(ItemStack item : e.getBlock().getDrops()){
				p.getInventory().addItem(item);
			}
			b.setType(Material.TRAPPED_CHEST);
			String s = chest.getName();
			Chest ch = (Chest) b.getState();
			ItemStack item = new ItemStack(Material.ENDER_PORTAL_FRAME);
			ItemStack item2 = new ItemStack(Material.DRAGON_EGG);
			ItemMeta im = item.getItemMeta();
			ItemMeta im2 = item2.getItemMeta();
			im.setDisplayName(s);
			im2.setDisplayName(p.getUniqueId().toString());
			item.setItemMeta(im);
			item2.setItemMeta(im2);
			final Inventory ci = ch.getInventory();
			ci.setItem(0, item);
			ci.setItem(1, item2);
			new BukkitRunnable(){
				public void run(){
					for(Player pl : Bukkit.getOnlinePlayers()){
						if(p != pl)
						pl.sendBlockChange(b.getLocation(), Material.AIR, (byte)0);
					}
				}
			}.runTaskLater(plugin, 5);
			new BukkitRunnable(){
				public void run(){
					ci.clear();
					b.setType(Material.AIR);
				}
			}.runTaskLater(plugin, MiningCrates.countdown);
			}catch(Exception ex){
				
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void chestOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Material m = e.getClickedBlock().getType();
			if (m.equals(Material.TRAPPED_CHEST)) {
				Chest ch = (Chest) e.getClickedBlock().getState();
				Inventory ci = ch.getInventory();
				if(ci.getItem(0) == null || ci.getItem(1) == null) return;
				if (!ci.getItem(0).getType().equals(Material.ENDER_PORTAL_FRAME)
						|| !ci.getItem(1).getType().equals(Material.DRAGON_EGG))
					return;	
				ItemStack i = ci.getItem(0);
				ItemStack i2 = ci.getItem(1);
				String s = i.getItemMeta().getDisplayName();
				String s2 = i2.getItemMeta().getDisplayName();
				List<String> chestNames = new ArrayList<String>();
				if (!s2.equals(p.getUniqueId().toString())) {
					e.setCancelled(true);
					return;
				}

				for (Crate c : MiningCrates.chestList.keySet()) {
					chestNames.add(c.getName());
				}
				if (chestNames.contains(s)) {
					ci.clear();
					e.getClickedBlock().setType(Material.AIR);
					Crate c = MiningCrates.getCrateByName(s);
					String cmd = c.getCommand();
					for(Player pl : Bukkit.getServer().getOnlinePlayers()){
						pl.playSound(e.getClickedBlock()
								.getLocation(), Sound.FIREWORK_BLAST, 30, 1);
					}
					ParticleEffect.FIREWORKS_SPARK.display(0.3F, 0.3F, 0.3F, 1, 50, 
							e.getClickedBlock().getLocation(), 20);
					if (c.getIsConsole()) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								cmd.replace("%p%", p.getName()));
					} else {
						Bukkit.dispatchCommand(p, cmd.replace("%p%", p.getName()));
					}

				}
			}
		}
	}
	
	@EventHandler
	public void destroy(BlockBreakEvent e) {
		Material m = e.getBlock().getType();
		if (m.equals(Material.CHEST)) {
			Chest ch = (Chest) e.getBlock().getState();
			Inventory ci = ch.getInventory();
			if(ci.getItem(0) == null || ci.getItem(1) == null) return;
			if (!ci.getItem(0).getType().equals(Material.ENDER_PORTAL_FRAME)
					|| !ci.getItem(1).getType().equals(Material.DRAGON_EGG))
				return;	
			if(!e.getPlayer().hasPermission("MiningCrates.destroy")) e.setCancelled(true);
			else ci.clear();
		}
	}	

	private Crate getRandomChest() {
		Double i = new Random().nextDouble() * 100;
		Crate chest = null;
		for (Double chestProb : MiningCrates.chestList.values()) {
			if (i <= chestProb)
				chest = MiningCrates.getKeyByValue(MiningCrates.chestList,
						chestProb);
		}
		if(chest == null){
			int r = new Random().nextInt(MiningCrates.random.size());
			int r2 = r--;
			MiningCrates.random.get(r2);
		}
		return chest;
	}
	private boolean detectchest(Location l){
		if(l.add(1,0,0).getBlock().getType().equals(Material.CHEST) ||
				l.add(-1,0,0).getBlock().getType().equals(Material.CHEST) ||
						l.add(0,0,1).getBlock().getType().equals(Material.CHEST) ||
								l.add(0,0,-1).getBlock().getType().equals(Material.CHEST))
		{
			return false;
		}
		else return true;
	}
}
