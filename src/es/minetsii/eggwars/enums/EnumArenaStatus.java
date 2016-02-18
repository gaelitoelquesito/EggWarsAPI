package es.minetsii.eggwars.enums;

public enum EnumArenaStatus {

	lobby, starting, startingGame, setting, ingame, finish;
	
	
	@Override
	public String toString(){
		switch (name()) {
		case "lobby":
		case "ingame":
		case "finish":
		case "starting":
		case "setting":
			return name();
		case "startingGame":
			return "ingame";
		default:
			return "";
		}
		
		
	}
}
