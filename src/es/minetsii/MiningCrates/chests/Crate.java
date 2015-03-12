package es.minetsii.MiningCrates.chests;

import es.minetsii.MiningCrates.MiningCrates;

public class Crate {
	private String name;
	private Double probability;
	private Boolean isConsole;
	private String command;

	public Crate(String name, Double probability, Boolean isConsole, String command) {
		this.name = name;
		this.probability = probability;
		this.isConsole = isConsole;
		this.command = command;
	}

	public String getName() {
		return name;
	}

	public Double getProbability() {
		return probability;
	}

	public Boolean getIsConsole() {
		return isConsole;
	}

	public String getCommand() {
		return command;
	}
	
	public void setProbability(Double probability){
		this.probability = probability;
	}
	
	public Double getProbChest(){
		Double ret = 0.0;
		for(Crate chest : MiningCrates.chestList.keySet()){
			ret += chest.getProbability();
		}
		ret = this.getProbability() * 100 / ret;
		return ret;
	}
}
