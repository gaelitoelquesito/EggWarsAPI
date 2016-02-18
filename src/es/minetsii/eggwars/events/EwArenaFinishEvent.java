package es.minetsii.eggwars.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import es.minetsii.eggwars.objects.Arena;
import es.minetsii.eggwars.objects.Team;

public class EwArenaFinishEvent extends Event {

	private static final HandlerList	handlers	= new HandlerList();
	private Arena arena;
	private Team winner;

	public EwArenaFinishEvent(Team winner, Arena arena) {
		this.winner = winner;
		this.arena = arena;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public Arena getArena() {
		return arena;
	}

	public Team getWinner() {
		return winner;
	}
	
}
