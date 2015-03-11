package es.minetsii.MiningCrates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import es.minetsii.MiningCrates.chests.Crate;
import es.minetsii.MiningCrates.events.Mine;

public class MiningCrates extends JavaPlugin {

	public static String prefix = "§f[§eMCratesP§f] ";

	public static String group_Permission = "miningcrates.group.";
	public static Map<Crate, Double> chestList;
	public static Map<Material, Double> blocksAffected;
	public static Map<String, Double> groups;

	public Mine Mine = new Mine(this);

	@Override
	public void onEnable() {

		getConfig().options().header(
				"#############################################" + "\n"
						+ "#             - Mining Crates -             #"
						+ "\n"
						+ "#############################################"
						+ "\n");

		getConfig().addDefault("groupPercent",
				new String[] { "default:5.0", "vip:15" });
		getConfig().addDefault("chests", new String[] {});
		getConfig().addDefault(
				"blocksAffected",
				new String[] { "STONE:0.1", "IRON_ORE:0.5", "DIAMOND_ORE:1.0",
						"COAL_ORE:0.2", "REDSTONE_ORE:0.5", "LAPIS_ORE:0.8",
						"EMERALD_ORE:0.8" });
		getConfig().options().copyHeader(true);
		getConfig().options().copyDefaults(true);

		saveConfig();
		reloadConfig();

		Bukkit.getServer().getPluginManager().registerEvents(Mine, this);

		loadChests();
		loadBlocks();
		loadGroups();
	}

	@Override
	public void onDisable() {

	}

	private void loadChests() {
		chestList = new HashMap<Crate, Double>();
		for (String chest : this.getConfig().getStringList("chests")) {
			String[] chestArray = chest.split("#");
			if (chestArray.length != 4)
				this.getLogger().log(Level.SEVERE,
						"Error in the chests at the config.");
			Crate newChest = new Crate(chestArray[0], new Double(chestArray[1]),
					new Boolean(chestArray[2]), chestArray[3]);
			chestList.put(newChest, newChest.getProbability());
		}
		updateChestsProb();
	}
	
	private void updateChestsProb(){
		Double prob = 0.0;
		for(Crate chest : chestList.keySet()){
			prob += chest.getProbability();
			chestList.put(chest, prob);
		}
	}

	@SuppressWarnings("deprecation")
	private void loadBlocks() {
		blocksAffected = new HashMap<Material, Double>();
		for (String block : this.getConfig().getStringList("blocksAffected")) {
			String[] blockArray = block.split(":");
			if (blockArray.length != 2)
				this.getLogger()
						.log(Level.SEVERE,
								"Error in the chests at the config. Must be MATERIAL:PERCENT");
			Material mat = (StringUtils.isNumeric(blockArray[0])) ? Material
					.getMaterial(new Integer(blockArray[0])) : Material
					.getMaterial(blockArray[0]);
			blocksAffected.put(mat, new Double(blockArray[1]));
		}
	}

	private void loadGroups() {
		groups = new HashMap<String, Double>();
		for (String group : this.getConfig().getStringList("blocksAffected")) {
			String[] groupArray = group.split(":");
			if (groupArray.length != 2)
				this.getLogger()
						.log(Level.SEVERE,
								"Error in the chests at the config. Must be MATERIAL:PERCENT");
			groups.put(groupArray[0], new Double(groupArray[1]));
		}
	}
	
	public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (value.equals(entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	public static Crate getCrateByName(String name){
		  Crate ret = null;
		  for(Crate c : MiningCrates.chestList.keySet()){
		   if(c.getName().equals(name)){
		    ret = c;
		    continue;
		   }
		  }
		  return ret;
		 }
}
