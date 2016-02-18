package es.minetsii.eggwars.enums;

import java.util.List;

import org.bukkit.Material;

public enum EnumGeneratorType {

	iron(Material.IRON_INGOT), gold(Material.GOLD_INGOT), diamond(Material.DIAMOND);
	
	private EnumGeneratorType(Material material){
	}
	
	public Material getMat(){
		return null;
	}
	
	public static List<Material> getMatList(){
		return null;
	}
}
