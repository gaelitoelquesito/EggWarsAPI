package es.minetsii.MiningCrates;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import es.minetsii.MiningCrates.eventos.Picar;

public class MiningCrates extends JavaPlugin {

	public static String prefix = "§f[§eMCratesP§f] ";
	
	public static String use_Permission = "tempperm.use";
	
	public Picar Picar = new Picar(this);
	
	
	@Override
	public void onEnable() {
		
		getConfig().options().header(
				"#############################################" + "\n" +
				"#             - Mining Crates -             #" + "\n" +
				"#############################################" + "\n"
		);

		getConfig().addDefault("chests", new String[] {});
		getConfig().addDefault("percent", 3);
		getConfig().addDefault("blocksAffected",
				new String[] {"STONE","IRON_ORE","DIAMOND_ORE","COAL_ORE","REDSTONE_ORE","LAPIS_ORE","EMERALD_ORE"});
		getConfig().options().copyHeader(true);
		getConfig().options().copyDefaults(true);
		
		saveConfig();
		reloadConfig();	
		Bukkit.getServer().getPluginManager().registerEvents(Picar, this);
	}
	
	@Override
	public void onDisable() {
		
		
	}
	
}
