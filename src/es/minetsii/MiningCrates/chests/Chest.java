package es.minetsii.MiningCrates.chests;

public class Chest {
	private String name;
	private Double probability;
	private Boolean isConsole;
	private String command;

	public Chest(String name, Double probability, Boolean isConsole, String command) {
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

	public Double getProbability() {
		return probability;
	}

	public Boolean getIsConsole() {
		return isConsole;
	}

	public String getCommand() {
		return command;
	}
}
