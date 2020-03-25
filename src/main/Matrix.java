package main;

public abstract class Matrix {
	static double[][] mults = { { 1, 1, 1, 1, 1, 0.5, 1, 0, 0.5, 1, 1, 1, 1, 1, 1, 1, 1 }, // Normal
																							// attack
																							// against:
																							// ...
			{ 2, 1, 0.5, 0.5, 1, 2, 0.5, 0, 2, 1, 1, 1, 1, 0.5, 2, 1, 2 }, // fight
			{ 1, 2, 1, 1, 1, 0.5, 2, 1, 0.5, 1, 1, 2, 0.5, 1, 1, 1, 1 }, // flying
			{ 1, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 0, 1, 1, 2, 1, 1, 1, 1, 1 }, // poison
			{ 1, 1, 0, 2, 1, 2, 0.5, 1, 2, 2, 1, 0.5, 2, 1, 1, 1, 1 },
			{ 1, 0.5, 2, 1, 0.5, 1, 2, 1, 0.5, 2, 1, 1, 1, 1, 2, 1, 1 },
			{ 1, 0.5, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 0.5, 1, 2, 1, 2, 1, 1, 2 },
			{ 0, 1, 1, 1, 1, 1, 1, 2, 0.5, 1, 1, 1, 1, 2, 1, 1, 0.5 },
			{ 1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 1, 2, 1, 1 },
			{ 1, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5, 0.5, 2, 1, 1, 2, 0.5, 1 },
			{ 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 1, 0.5, 1 },
			{ 1, 1, 0.5, 0.5, 2, 2, 0.5, 1, 0.5, 0.5, 2, 0.5, 1, 1, 1, 0.5, 1 },
			{ 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 0.5, 1 },
			{ 1, 2, 1, 2, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 0.5, 1, 1, 0 },
			{ 1, 1, 2, 1, 2, 1, 1, 1, 0.5, 0.5, 0.5, 2, 1, 1, 0.5, 2, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 1, 1, 2, 1 },
			{ 1, 0.5, 1, 1, 1, 1, 1, 2, 0.5, 1, 1, 1, 1, 2, 1, 1, 0.5 } };
	// types: normal, fire, grass, fighting, flying, water,
	// ice, dark, ghost, psyche, bug, dragon, poison, electric, ground, rock,
	// iron
	// String[] rowTitles, lineTitles;
	static String[] types = { "Normal", "Fighting", "Flying", "Poison", "Ground", "Rock", "Bug", "Ghost", "Steel", "Fire",
			"Water", "Grass", "Electric", "Psychic", "Ice", "Dragon", "Dark" };

	public static double getMult(String attackType, String monsterType) {
		if (monsterType.startsWith("#")) {
			double mult1, mult2;
			String[] types = monsterType.substring(1).split("&");
			mult1 = getSingleMult(attackType, types[0]);
			mult2 = getSingleMult(attackType, types[1]);
			return mult1 * mult2;
		}
		return getSingleMult(attackType, monsterType);
	}

	public static double getSingleMult(String attackType, String monsterType) {
		int attack, monster;
		for (attack = 0; !types[attack].toUpperCase().equals(attackType.toUpperCase()); attack++)
			;
		for (monster = 0; !types[monster].toUpperCase().equals(monsterType.toUpperCase()); monster++)
			;
		return mults[attack][monster];
	}

	public static boolean isType(String attackerType, String attack) {
		if (attackerType.startsWith("#")) {
			String[] types = attackerType.substring(1).split("&");
			return attack.toUpperCase().matches(types[0].toUpperCase()) || attack.toUpperCase().matches(types[1].toUpperCase());
		}
		return attack.toUpperCase().matches(attackerType.toUpperCase());
	}
}