package es.minetsii.eggwars.objects;

import org.bukkit.entity.Player;

public class EwPlayer {
	
	public EwPlayer(Player player, DataPlayer data){
	}
	
	public void setArena(Arena arena){
	}
	
	public Arena getArena(){
		return null;
	}
	
	public Player getPlayer(){
		return null;
	}
	
	public boolean isInArena(){
		return false;
	}

	public DataPlayer getData() {
		return null;
	}

	public Team getTeam() {
		return null;
	}

	public boolean isDead() {
		return false;
	}

	public InvPlayer getInv() {
		return null;
	}

	public void setInv(InvPlayer inv) {
	}

	public EwKit getKit() {
		return null;
	}

	public void setKit(EwKit kit) {
	}
	
	public int getTargetTeam() {
		return 0;
	}

	public void setTargetTeam(int targetTeam) {
	}

	public boolean isInvincible(){
		return false;
	}
	
	public int getInvincibleTicks() {
		return 0;
	}

	public void setInvincibleTicks(int invincibleTicks) {
	}

	public boolean hasKit(EwKit kit){
		return false;
	}
    
	public int getSpecialItemDelayTicks() {
		return 0;
    }
    
    public void setSpecialItemDelayTicks(int siDelayTicks) {
    }
    
    public boolean canUseSpecialItem() {
    	return false;
    }
    
    public void setLastDamager(EwPlayer player) {
    }
    
    public EwPlayer getLastDamager() {
    	return null;
    }
	
	
}
