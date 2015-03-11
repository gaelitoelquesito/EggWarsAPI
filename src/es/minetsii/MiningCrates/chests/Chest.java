package es.minetsii.MiningCrates.chests;

public class Chest {
	private String name;
	private int probability;
	private Boolean isConsole;
	private String command;

	public Chest(String name, int probability, Boolean isConsole, String command) {
		// Nombre;Probabilidad;esConsola;comando
		// Cofre1;15;true;eco give %p% 5000
		// Cofre2;5;false;fly
		this.name = name;
		this.probability = probability;
		this.isConsole = isConsole;
		this.command = command;
	}

	public String getName() {
		return name;
	}

	public int getProbability() {
		return probability;
	}

	public Boolean getIsConsole() {
		return isConsole;
	}

	public String getCommand() {
		return command;
	}
}
