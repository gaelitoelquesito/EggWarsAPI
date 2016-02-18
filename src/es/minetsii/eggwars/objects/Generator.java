package es.minetsii.eggwars.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import es.minetsii.eggwars.enums.EnumGeneratorType;

public class Generator {

	public Generator(Location block, int defLevel, EnumGeneratorType type, Arena arena) {
	}

	public Location getBlock() {
		return null;
	}

	public int getDefLevel() {
		return 0;
	}

	public void setDefLevel(int defLevel) {
	}

	public int getLevel() {
		return 0;
	}

	public void setLevel(int level) {
	}

	public EnumGeneratorType getType() {
		return null;
	}

	public void setType(EnumGeneratorType type) {
	}

	public Arena getArena() {
		return null;
	}

	public void start() {
	}

	public void stop() {
	}

	public void reset() {
	}

	public void generate() {
	}

	public void updateSign() {
	}

	public void openInventory(Player pl) {
	}

	public void upgrade(Player pl) {
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

}
