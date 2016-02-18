package es.minetsii.eggwars.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import es.minetsii.eggwars.enums.EnumReloadType;

public class EwPluginReloadEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private EnumReloadType reloadType;
	
	public EwPluginReloadEvent(EnumReloadType reloadType) {
		this.reloadType = reloadType;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public EnumReloadType getReloadType() {
		return reloadType;
	}
	
}
