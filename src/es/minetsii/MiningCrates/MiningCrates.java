package es.minetsii.MiningCrates;

import org.bukkit.plugin.java.JavaPlugin;

public class MiningCrates extends JavaPlugin {

	public static String prefix = "§f[§eMCratesP§f] ";
	
	public static String use_Permission = "tempperm.use";
	//main
	@Override
	public void onEnable() {
		
		getConfig().options().header(
				"#############################################" + "\n" +
				"#             - Mining Crates -             #" + "\n" +
				"#############################################" + "\n"
		);

		getConfig().addDefault("chests", new String[] {});
		
		getConfig().options().copyHeader(true);
		getConfig().options().copyDefaults(true);
		
		saveConfig();
		reloadConfig();	
	}
	
	@Override
	public void onDisable() {
		
		
	}
	
}
