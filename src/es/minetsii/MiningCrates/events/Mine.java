package es.minetsii.MiningCrates.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

import es.minetsii.MiningCrates.MiningCrates;
import es.minetsii.MiningCrates.chests.Crate;

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
				Double probability = MiningCrates.blocksAffected.get(e.getBlock().getType()) * MiningCrates.groups.get(group);
				if(i <= probability){
					Crate chest = getRandomChest();
					if(chest == null) continue;
					Block b = e.getBlock();
					b.setType(Material.CHEST);
					String s = chest.getName();
					Chest ch = (Chest) b;
					ItemStack item = new ItemStack(Material.ENDER_PORTAL_FRAME);
					ItemStack item2 = new ItemStack(Material.DRAGON_EGG);
					ItemMeta im = item.getItemMeta();
					im.setDisplayName(s);
					item.setItemMeta(im);
					Inventory ci = ch.getBlockInventory();
					ci.setItem(0, item);
					ci.setItem(1, item2);
					for(Player all : Bukkit.getServer().getOnlinePlayers()){
						if(all != p)
						all.sendBlockChange(b.getLocation(), Material.BARRIER, (byte) 0);
					}
					
				}
			}
		}
	}
	
	@EventHandler
	public void chestOpen(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
		    Material m = e.getClickedBlock().getType();
		    if(m.equals(Material.CHEST)){
		    	Chest ch = (Chest) e.getClickedBlock();
		    	Inventory ci = ch.getBlockInventory();
		    	if(!ci.getItem(0).equals(new ItemStack(Material.ENDER_PORTAL_FRAME)) || !ci.getItem(1).equals(new ItemStack(Material.DRAGON_EGG)))
		    		return;
		    	
	    		ItemStack i = ci.getItem(0);
	    		String s = i.getItemMeta().getDisplayName();
	    		List<String> chestNames = new ArrayList<String>();
	    		
	    		for(Crate c : MiningCrates.chestList.keySet()){
	    		     chestNames.add(c.getName());
	    		}
	    		
	    		if(chestNames.contains(s)){
	    			Crate c = MiningCrates.getCrateByName(s);
	    			String cmd = c.getCommand();
	    			if(c.getIsConsole()){
	    				 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("%p%", p.getName()));
	    				}else{
	    				  Bukkit.dispatchCommand(p, cmd);
	    				}

	    		}
		    }
		}
	}
	
	
	private Crate getRandomChest(){
		//TODO Seleccionar un cofre random y devolverlo
		Double i = new Random().nextDouble() * 100;
		Crate chest = null;
		for(Double chestProb : MiningCrates.chestList.values()){
			if(i <= chestProb)
				chest = MiningCrates.getKeyByValue(MiningCrates.chestList, chestProb);
		}
		return chest;
	}
}
