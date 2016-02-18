package es.minetsii.eggwars.API;

import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import es.minetsii.eggwars.objects.Arena;
import es.minetsii.eggwars.objects.EwKit;
import es.minetsii.eggwars.objects.EwPlayer;
import es.minetsii.eggwars.specialitems.SpecialExecutor;
import es.minetsii.eggwars.utils.villagerGui.Merchant;

/**
 * This is the EggWarsAPI class.
 */
public class EggWarsAPI {

	
	/**
	 * Returns a EggWars's player.
	 *
	 * @param player The bukkit's player.
	 * @return The EggWars's player.
	 */
	public static EwPlayer getEggWarsPlayer(Player player) {
		return null;
	}
	
	/**
	 * Returns a EggWars's arena.
	 *
	 * @param name The arena's name.
	 * @return The EggWars's arena.
	 */
	public static Arena getEggWarsPlayer(String name){
		return null;
	}
	
	/**
	 * Forces an arena to start.
	 *
	 * @param arena The arena.
	 * @return If the arena has started.
	 */
	public static boolean forceStart(Arena arena) {
		return false;
	}
	
	/**
	 * Forces a player to join an arena.
	 *
	 * @param arena The arena.
	 * @param player The player.
	 */
	public static void joinArena(Arena arena, EwPlayer player) {
	}
	
	/**
	 * Forces a player to leave an arena.
	 *
	 * @param arena The arena.
	 * @param silenced Silenced exit.
	 * @return If the player was in an arena.
	 */
	public static boolean leaveArena(EwPlayer player, boolean silenced) {
		return false;
	}
	
	/**
	 * Adds a kit to the game.
	 *
	 * @param kit The kit.
	 */
	public static void addKit(EwKit kit){
	}
	
	/**
	 * Removes a kit from the game.
	 *
	 * @param kit The kit.
	 */
	public static void removeKit(EwKit kit){
	}
	
	/**
	 * Adds a special item to the game.
	 * 
	 * ALERT! All special items must has a constructor like this!
	 * public ExampleSpecialItem(EwPlayer player, Map<String, String> extra) {}
	 *
	 * @param clazz The special item's class.
	 * @param name The special item's name.
	 * @param execItem The special item's executor item.
	 * @param extra Extra configuration for the special item.
	 * @return If the special item was add.
	 */
	public static boolean addSpecialItem(Class<SpecialExecutor> clazz, String name,
			ItemStack execItem, Map<String, String> extra) {
		return false;
	}
	
	/**
	 *Removes a special item.
	 * 
	 * @param name The special item's name.
	 */
	public static void removeSpecialItem(String name) {
	}
	
	/**
	 * Checks if a special item is in the game.
	 * 
	 * @param name The special item's name.
	 */
	public static boolean isSpecialItemLoaded(String name) {
		return false;
	}
	
	/**
	 * Opens a villager shop to a player.
	 * 
	 * @param player The player.
	 * @param shopId The villager shop id.
	 * @param needsPerm If this boolean is in true, 
	 * EggWars will check before if the player has enough permissions.
	 */
	public static void openVillagerShop(EwPlayer player, int shopId, boolean needsPerm) {
	}
	
	
	/**
	 * Returns a villager shop.
	 * It can be null if the shopId is invalid.
	 * 
	 * @param shopId The shop id.
	 * @return A villager shop.
	 */
	public static Merchant getMerchant(int shopId) {
		return null;
	}
	
	/**
	 * Adds a villager shop to the game.
	 * 
	 * @param merchant The villager shop.
	 * @param shopId The shop id.
	 * @param mainItem The item that will be shown in the villager's main menu.
	 * @return A villager shop.
	 */
	public static boolean setMerchant(Merchant merchant, int shopId, ItemStack mainItem) {
		return false;
	}
}
