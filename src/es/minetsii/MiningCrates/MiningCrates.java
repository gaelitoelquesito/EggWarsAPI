package es.minetsii.MiningCrates;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import es.minetsii.MiningCrates.chests.Chest;
import es.minetsii.MiningCrates.eventos.Mine;

public class MiningCrates extends JavaPlugin {

	public static String prefix = "§f[§eMCratesP§f] ";
	
	public static String use_Permission = "tempperm.use";
	public static List<Chest> chestList;
	
	public Mine Mine = new Mine(this);
	
	
	@Override
	public void onEnable() {
		
		getConfig().options().header(
				"#############################################" + "\n" +
				"#             - Mining Crates -             #" + "\n" +
				"#############################################" + "\n"
		);

		getConfig().addDefault("chests", new String[] {});
		getConfig().addDefault("blocksAffected",
				new String[] { "STONE", "IRON_ORE","DIAMOND_ORE","COAL_ORE","REDSTONE_ORE","LAPIS_ORE","EMERALD_ORE"});
		getConfig().options().copyHeader(true);
		getConfig().options().copyDefaults(true);
		
		loadChests();
		saveConfig();
		reloadConfig();	
		Bukkit.getServer().getPluginManager().registerEvents(Mine, this);
	}
	
	private void loadChests() {
		chestList = new ArrayList<Chest>();
		for(String chest : this.getConfig().getStringList("chests")){
			String[] chestArray = chest.split("#");
			if(chestArray.length != 4)
				this.getLogger().log(Level.SEVERE, "Error in the chests at the config.");
			chestList.add(new Chest(chestArray[0], new Integer(chestArray[1]),new Boolean(chestArray[2]), chestArray[3]));
		}
	}

	@Override
	public void onDisable() {
		
		
	}
	
}
