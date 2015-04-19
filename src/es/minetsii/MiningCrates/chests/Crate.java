package es.minetsii.MiningCrates.chests;

import es.minetsii.MiningCrates.MiningCrates;

public class Crate {
	private String name;
	private Double probability;
	private Boolean isConsole;
	private String command;
	private CrateEffect effect;

	public Crate(String name, Double probability, Boolean isConsole,
			String command, CrateEffect effect) {
		this.name = name;
		this.probability = probability;
		this.isConsole = isConsole;
		this.command = command;
		this.effect = effect;
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

	public CrateEffect getEffect() {
		return effect;
	}

	public void setProbability(Double probability) {
		this.probability = probability;
	}

	public void setEffect(CrateEffect effect) {
		this.effect = effect;
	}

	public Double getProbChest() {
		Double ret = 0.0;
		for (Crate chest : MiningCrates.chestList.keySet()) {
			ret += chest.getProbability();
		}
		ret = this.getProbability() * 100 / ret;
		return ret;
	}
}
