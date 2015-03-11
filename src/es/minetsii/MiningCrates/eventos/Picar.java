package es.minetsii.MiningCrates.eventos;

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

public class Picar implements Listener {
	MiningCrates plugin;

	public Picar(MiningCrates plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void picar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Random r = new Random();
		int i = r.nextInt(100);
		if (i <= plugin.getConfig().getInt("percent")) {
			Inventory inv = Bukkit.createInventory(p, 27, p.getUniqueId() + "");
			Block b = e.getBlock();
			Location l = b.getLocation();
			b.setType(Material.CHEST);
			Chest c = (Chest) b;
			Inventory ci = c.getInventory();
			ItemStack item = new ItemStack(Material.STONE);
			ItemMeta im = item.getItemMeta();
			im.setDisplayName(p.getUniqueId() + "");
			item.setItemMeta(im);
			c.getInventory().setItem(0, item);
		}
	}

}
