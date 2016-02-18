package es.minetsii.eggwars.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import es.minetsii.eggwars.objects.EwPlayer;
import es.minetsii.eggwars.objects.Team;

public class EwPlayerRemoveEggEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;
	private EwPlayer player;
	private Team eggTeam;

	public EwPlayerRemoveEggEvent(EwPlayer player, Team eggTeam) {
		cancelled = false;
		this.player = player;
		this.eggTeam = eggTeam;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public EwPlayer getPlayer() {
		return player;
	}

	public Team getEggTeam() {
		return eggTeam;
	}
}
