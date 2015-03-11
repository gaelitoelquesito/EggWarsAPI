package es.minetsii.MiningCrates;

import org.bukkit.plugin.java.JavaPlugin;

public class MiningCrates extends JavaPlugin {

	public static String prefix = "§f[§eMCratesP§f] ";
	
	public static String use_Permission = "tempperm.use";
	@Override
	public void onEnable() {
		
		getConfig().options().header(
				"#############################################" + "\n" +
				"#             - Mining Crates -             #" + "\n" +
				"#############################################" + "\n"
		);

		getConfig().addDefault("chests", new String[] {});
		getConfig().addDefault("blocksAffected",
				new String[] {"STONE", "LOG"}); // Añade aquí los que tu creas convenientes que sean los que vienen default.
		
		getConfig().options().copyHeader(true);
		getConfig().options().copyDefaults(true);
		
		saveConfig();
		reloadConfig();	
	}
	
	@Override
	public void onDisable() {
		
		
	}
	
}
