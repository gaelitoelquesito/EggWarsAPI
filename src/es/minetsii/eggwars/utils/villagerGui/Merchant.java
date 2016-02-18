
package es.minetsii.eggwars.utils.villagerGui;

import java.util.List;

import org.bukkit.entity.Player;

public class Merchant {
	
	public Merchant() {
	}
	
	public String getTitle() {
		return null;
	}
	
	public void setTitle(String title) {
	}
	
	public List<MerchantOffer> getOffers() {
		return null;
	}
	
	public Merchant addOffer(MerchantOffer offer) {
		return this;
	}
	
	public Merchant addOffers(MerchantOffer[] offers) {
		return this;
	}
	
	public Merchant setOffers(List<MerchantOffer> offers) {
		return this;
	}
	
	public boolean hasCustomer() {
		return false;
	}
	
	public Player getCustomer() {
		return null;
	}
	
	public Merchant setCustomer(Player player) {
		return this;
	}
	
	public void openTrading(Player player) {
	}
	
	@Override
	public Merchant clone() {
		return null;
	}
	
}