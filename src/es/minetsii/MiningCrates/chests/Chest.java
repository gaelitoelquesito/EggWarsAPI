package es.minetsii.MiningCrates.chests;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

public class Chest {
	private String name;
	private String type;
	private int amount;
	private List<ItemStack> items;
	
	public Chest(String name, String type){
		// Nombre;tipo:argumentos
		// Cofre1;cash:1500
		// Cofre2;items:Item1#amount#enchant,lvl-Item2#amount#enchant,lvl
		this.name = name;
		this.type = type;
		this.amount = 0;
		this.items = new ArrayList<ItemStack>();
	}
	
	public String getName(){
		return name;
	}
	public String getType(){
		return type;
	}
	public int getAmount(){
		return amount;
	}
	public List<ItemStack> getItems(){
		return new ArrayList<ItemStack>(items);
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	public void setItems(List<ItemStack> items){
		this.items = items;
	}
}
