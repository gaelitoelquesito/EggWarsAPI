package es.minetsii.MiningCrates.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import es.minetsii.MiningCrates.MiningCrates;
import es.minetsii.MiningCrates.chests.Crate;

public class Mine implements Listener {
	private MiningCrates plugin;
	private RemoveCrate rc;

	public Mine(MiningCrates plugin) {
		this.plugin = plugin;
		this.rc = new RemoveCrate(plugin);
	}

	@EventHandler
	public void placeBlock(BlockPlaceEvent e){
		MiningCrates.placedBlocks.add(e.getBlock().getLocation());
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void mineEvent(BlockBreakEvent e) {
		final Player p = e.getPlayer();
		Double i = new Random().nextDouble() * 100;
		if (!MiningCrates.blocksAffected.containsKey(e.getBlock().getType())) return;
		if (!MiningCrates.placedBlocks.contains(e.getBlock().getLocation())) return;
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
			final Crate chest = getRandomChest();
			if (chest == null)
				break;
			final Block b = e.getBlock();
			new BukkitRunnable(){
				public void run(){
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
				}
			}.runTaskLater(plugin, 1);
			}catch(Exception ex){
			}
		}
	}

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
					Crate c = MiningCrates.getCrateByName(s);
					rc.removeCrate(c.getEffect(), ch);
					String cmd = c.getCommand();
					if (c.getIsConsole()) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								cmd.replace("%p%", p.getName()).replace("%cl%", 
										ch.getLocation().getX()+" "+ch.getLocation().getY()+
										" "+ch.getLocation().getZ()).replace("%pl%", 
												p.getLocation().getX()+" "+p.getLocation().getY()+
												" "+p.getLocation().getZ()));
					} else {
						Bukkit.dispatchCommand(p, cmd.replace("%p%", p.getName()).replace("%cl%", 
								ch.getLocation().getX()+" "+ch.getLocation().getY()+
								" "+ch.getLocation().getZ()).replace("%pl%", 
										p.getLocation().getX()+" "+p.getLocation().getY()+
										" "+p.getLocation().getZ()));
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void spawn(ItemSpawnEvent e){
		Item it = e.getEntity();
		if(it.getItemStack().getType().equals(Material.DRAGON_EGG)){
			for(Player p : Bukkit.getOnlinePlayers()){
				if(it.getItemStack().getItemMeta().getDisplayName() == null) return;
				if(it.getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase
						(p.getUniqueId().toString())){
					it.remove();
				}
			}
		}
		if(it.getItemStack().getType().equals(Material.ENDER_PORTAL_FRAME)){
			for(Crate c : MiningCrates.chestList.keySet()){
				if(it.getItemStack().getItemMeta().getDisplayName() == null) return;
				if(c.getName().equalsIgnoreCase(it.getItemStack().getItemMeta().getDisplayName())){
					it.remove();
				}
			}
		}
	}
	
	

	private Crate getRandomChest() {
		Double i = new Random().nextDouble() * 100;
		Crate chest = null;
		List<Crate> random = new ArrayList<Crate>();
		for (Crate chestProb : MiningCrates.chestList.keySet()) {
			random.add(chestProb);
		}
		Crate c = random.get(new Random().nextInt(random.size()));
		if(c.getProbability() < i) chest = c;
		if(chest == null){
			chest = getRandomChest();
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
