package es.minetsii.eggwars.objects;

import java.util.Collection;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class InvPlayer {

	public InvPlayer(Player player){
	}
	
	public void sendToPlayer(){;
	}

	public Player getPlayer() {
		return null;
	}

	public ItemStack[] getItems() {
		return null;
	}

	public ItemStack[] getArmor() {
		return null;
	}

	public double getHealth() {
		return 0;
	}

	public int getFoodLevel() {
		return 0;
	}

	public GameMode getGamemode() {
		return null;
	}

	public Collection<PotionEffect> getEffects() {
		return null;
	}

	public float getXp() {
		return 0;
	}

	public int getXpLevel() {
		return 0;
	}

	public boolean isFlying() {
		return false;
	}

	public boolean isAllowFlight() {
		return false;
	}

	public String getCustomName() {
		return null;
	}
}
