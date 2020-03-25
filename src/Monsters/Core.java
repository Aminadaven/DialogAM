package Monsters;

import attacks.LvlAttack;

public class Core {
	// order: hp, attack, def, sp_atk, spDef, spd
	String[] Abls;
	String evoCond;
	Core evolveTo;
	LvlAttack[] route;
	public String spec, type;
	int[] Stats;

	public Core(String spec, String type, Core evolveTo, String evoCond, int[] Stats, String[] Abls,
			LvlAttack[] route) {
		this.spec = spec;
		this.type = type;
		this.evolveTo = evolveTo;
		this.evoCond = evoCond;
		this.Stats = Stats;
		this.Abls = Abls;
		this.route = route;
	}
}