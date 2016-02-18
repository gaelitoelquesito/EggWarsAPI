package es.minetsii.eggwars.objects;

import java.util.Comparator;

import org.bukkit.Location;

public class DistanceComparator implements Comparator<EwPlayer> {
	
	private Location center;
	
	public DistanceComparator(Location center) {
		this.center = center;
	}
	
	@Override
	public int compare(EwPlayer o1, EwPlayer o2) {
		return (int)o2.getPlayer().getLocation().distance(center)
				- (int)o1.getPlayer().getLocation().distance(center);
	}
	

}
