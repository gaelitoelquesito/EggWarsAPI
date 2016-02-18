package es.minetsii.eggwars.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import es.minetsii.eggwars.objects.Arena;
import es.minetsii.eggwars.objects.EwPlayer;

public class EwPlayerJoinArenaEvent extends Event implements Cancellable {

	private static final HandlerList	handlers	= new HandlerList();
	private EwPlayer player;
	private Arena arena;
	private boolean cancelled;

	public EwPlayerJoinArenaEvent(EwPlayer player, Arena arena) {
		this.player = player;
		this.arena = arena;
		this.cancelled = false;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public EwPlayer getPlayer() {
		return player;
	}

	public void setPlayer(EwPlayer player) {
		this.player = player;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	
}
