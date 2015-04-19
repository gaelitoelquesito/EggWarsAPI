package es.minetsii.MiningCrates.chests;

public enum CrateEffect {

	EXPLODE("explode"), UP("up"), TELEPORT("teleport");

	@SuppressWarnings("deprecation")
	private String type;

	private CrateEffect(String type) {
		this.type = type;
	}
}
