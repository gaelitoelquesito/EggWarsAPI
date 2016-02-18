package es.minetsii.eggwars.enums;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public enum EnumPlayerFaceDirection {

    north(0, -1), northeast(1, -1), east(1, 0), southeast(1, 1), south(0, 1), southwest(-1, 1), west(-1, 0), northwest(-1, -1);

    private EnumPlayerFaceDirection(int x, int z) {
    }

    public int getX() {
        return 0;
    }

    public int getZ() {
        return 0;
    }

    public static EnumPlayerFaceDirection getCardinalDirection(Player player) {
    	return null;
    }

    public static EnumPlayerFaceDirection getDirection(double rot) {
    	return null;
    }

    public void addXZ(Location loc) {
    }
}
