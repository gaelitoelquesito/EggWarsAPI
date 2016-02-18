package es.minetsii.eggwars.objects;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import es.minetsii.eggwars.enums.EnumArenaStatus;
import es.minetsii.eggwars.specialitems.SpecialExecutor;

public class Arena {

	public Arena(Location lobby, Set<Generator> generators, String name,
			int maxTeamPlayers, Map<Integer, Team> teams, int minPlayers,
			int defCountdown, Location center, int time, int gameCountdown,
			int fullCountdown, Map<Integer, String> teamNames) {
	}

	public Map<Integer, Team> getTeams() {
		return null;
	}

	public void removeTeam(int i) {
	}
	
	public void addTeam(Team team, int id) {
	}

	public Location getLobby() {
		return null;
	}

	public Set<Location> getBlocksPlaced() {
		return null;
	}

	public void setBlocksPlaced(Set<Location> blocksPlaced) {
	}

	public Set<Generator> getGenerators() {
		return null;
	}

	public void removeGenerator(Generator gen) {
	}
	
	public void addGenerator(Generator gen) {
	}

	public String getName() {
		return null;
	}

	public EnumArenaStatus getStatus() {
		return null;
	}
	
	public World getWorld() {
		return null;
	}

	public int getMaxTeamPlayers() {
		return 0;
	}

	public int getMaxPlayers() {
		return 0;
	}

	public Set<EwPlayer> getPlayers() {
		return null;
	}

	public int getFullCountdown() {
		return 0;
	}

	public void joinArena(final EwPlayer pl, boolean silenced, final boolean spec) {
	}

	public void leaveArena(EwPlayer pl, boolean tpBungee, boolean silenced) {
	}

	public int getMinPlayers() {
		return 0;
	}

	public Set<EwPlayer> getAlivePlayers() {
		return null;
	}
	
	public Set<Team> getAliveTeams() {
		return null;
	}

	public void setMinPlayers(int minPlayers) {
	}

	public boolean hasEnoughtPlayers() {
		return false;
	}

	public int getDefCountdown() {
		return 0;
	}

	public int getCountdown() {
		return 0;
	}

	public void setCountdown(int countdown) {
	}

	public Location getCenter() {
		return null;
	}

	public int getTime() {
		return 0;
	}

	public void setTime(int time) {
	}

	public int getGameCountdown() {
		return 0;
	}

	public Scoreboard getScore() {
		return null;
	}

	public void setScore(Scoreboard score) {
	}	

	public Map<Integer, String> getTeamNames() {
		return null;
	}
	
    public List<SpecialExecutor> getActiveSpecialItems() {
    	return null;
    }
    
    public void addActiveSpecialItem(Object obj) {
    }
    
    public void stopAllActiveSpecialItems() {
    }
    
    public void recalculateSpecialItems() {
    }

    public Team getWinner() {
    	return null;
	}

	public void reset() {
	}

	public void sendBroadcast(String s, boolean languageNode, Object... obj) {
	}

	public boolean isSetup() {
		return false;
	}

	public boolean isFull() {
		return false;
	}

	public void sendToDo(Player p) {
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	public boolean saveArena() {
		return false;
	}

	public boolean isInGame() {
		return false;
	}

	public void openTeamInv(Player pl) {
	}
}
