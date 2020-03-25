package attacks;

public interface Vault {
	Attack FLAMETHROWER = new Attack("Flamethrower", "The Monster kills the enemy with his Flamethrower!", "fire",
			"Burn 30", 15, 120, 100, 1);
	Attack BUBBLE = new Attack("Bubble", "The Monster bubbles the enemy", "Water", "", 20, 40, 100, 1);
	Attack EMBER = new Attack("Ember", "The Monster fires at the enemy an ember", "Fire", "Burn 10", 20, 40, 100, 1);
	Attack GRAPES = new Attack("Grapes", "The Monster is throwing grapes at the enemy", "Grass", "", 20, 40, 100, 1);
	Attack POISON_RAY = new Attack("Poison Ray", "The Monster unlish poison ray, which can poison the enemy", "Poison",
			"Poison 75", 15, 60, 75, 1);
	Attack SCRATCH = new Attack("Scratch", "The Monster Scratches the enemy.", "Normal", "", 20, 40, 100, 1);
	Attack GUST = new Attack("Gust", "The Monster attack from the air", "FLYING", "", 20, 35, 95, 1);
	Attack SPARK = new Attack("Spark", "The Monster attack with electricity", "ELECTRIC", "Paralyze 20", 20, 40, 100,
			1);
	Attack IRON_CLAW = new Attack("Iron Claw", "The Monster Scratches the enemy with an Iron Claw!", "STEEL", "", 20,
			60, 100, 1);
	Attack PUNCH = new Attack("Punch", "The Monster Punches the enemy", "FIGHTING", "", 20, 55, 100, 1);
	Attack DRAGON_RAGE = new Attack("Dragon Rage", "The Monster Rages at the enemy", "DRAGON", "", 15, 85, 95, 1);
	Attack PSYCHO = new Attack("Psycho", "The Monster Psych the enemy", "PSYCHIC", "", 15, 100, 85, 1);
	Attack POISON_STING = new Attack("Poison Sting", "The Monster Sting the enemy and Poison him", "POISON",
			"Poison 15", 20, 15, 85, 5);
	// example:
	// Attack atkName = new Attack("Attack Name", "Attack
	// Description", "Type", "Effect", pp, power, acc, missiles);
	// empty:
	// Attack = new Attack("", "", "", "", , , , );

}