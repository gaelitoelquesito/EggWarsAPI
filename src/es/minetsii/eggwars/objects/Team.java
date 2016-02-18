package es.minetsii.eggwars.objects;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.entity.Villager;

public class Team {
	
	public Team(Location egg, Location villager, Location spawn, Location respawn, int id) {
	}

	public Set<EwPlayer> getPlayers() {
		return null;
	}
	
	public Set<EwPlayer> getPlayersAlive(){
		return null;
	}
	
	public Location getEgg() {
		return null;
	}
	
	public void setEgg(Location egg) {
	}
	
	public Villager getVillager() {
		return null;
	}
	
	public void setVillager(Villager villager) {
	}
	
	public Arena getArena() {
		return null;
	}
	
	public Location getSpawn() {
		return null;
	}

	public void setSpawn(Location spawn) {
	}

	public boolean canRespawn(){
		return false;
	}
	
	public void addPlayer(EwPlayer pl){
	}
	
	public Location getRespawn() {
		return null;
	}

	public void setRespawn(Location respawn) {
	}
	
	public Location getVillagerLoc() {
		return null;
	}

	public void setVillagerLoc(Location villagerLoc) {
	}

	public org.bukkit.scoreboard.Team getMcTeam() {
		return null;
	}

	public void setMcTeam(org.bukkit.scoreboard.Team mcTeam) {
	}

	public int getId() {
		return 0;
	}

	public void spawnVillager(){
	}
	
	public boolean isEliminated(){
		return false;
	}

	public void setGlass(){
	}
	
	public void removeGlass(){
	}
	
	public void spawnPlayers(){
	}
	
	public void setEgg(){
	}
	
	public void removeVillager(){
	}
	
	public void sendBroadcast(String s, boolean languageNode, Object... obj){
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
