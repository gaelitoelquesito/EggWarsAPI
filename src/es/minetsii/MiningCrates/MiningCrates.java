package es.minetsii.MiningCrates;

import org.bukkit.Bukkit;

import com.deathlyflags.TempPerm.TempPermCommand;

public class MiningCrates {
	
	@Override
	public void onEnable() {
		
		getConfig().options().header(
				"#############################################" + "\n" +
				"#       - TempPerm for GroupManager -       #" + "\n" +
				"#############################################" + "\n"
		);

		getConfig().addDefault("playerList", new String[] {});
		
		getConfig().options().copyHeader(true);
		getConfig().options().copyDefaults(true);
		
		saveConfig();
		reloadConfig();	
	}
}
