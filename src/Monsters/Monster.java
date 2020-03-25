package Monsters;

import attacks.Attack;
import attacks.AttacksVector;
import main.start;

public class Monster {
	// public Attack[] attacks = new Attack[4];
	public AttacksVector attacks = new AttacksVector();
	public Core core;
	public int hp, spd, atk, spAtk, def, spDef, lvl, xp, actualHp; // Monster
																	// Stats
	public int[] iv, ev;
	public String nature, ability, status;

	public Monster(Core core) {
		this.core = core;
		status = "";
		lvl = 5;
		iv = new int[6];
		randIV();
		ev = new int[6];
		zeroEV();
		randNTR();
		randABL();
		calcStats();
		attacksUpdate();
	}

	public Monster(Core core, int lvl) {
		this.core = core;
		status = "";
		this.lvl = lvl;
		iv = new int[6];
		randIV();
		ev = new int[6];
		zeroEV();
		randNTR();
		randABL();
		calcStats();
		attacksUpdate();
	}

	public void addEV(Monster los) {
		int max = 0;
		for (int i = 0; i < los.core.Stats.length; i++) {
			max = los.core.Stats[max] > los.core.Stats[i] ? max : i;
		}
		ev[max]++;
	}
	
	public void addEV(int type, int amount){
		ev[type] += amount;
	}

	public void addXP(int i) {
		xp += i;
		if (checkLvlUp())
			lvlUp();
	}

	public void addXP(Monster los) {
		xp += (los.lvl * (los.hp + los.spd + los.atk + los.def + los.spAtk + los.spDef) / 50);
		if (checkLvlUp())
			lvlUp();
	}
	
	public void addAttack(Attack attack){
		if(!attacks.hasAttack(attack)) attacks.add(attack);
	}

	public void attacksUpdate() {
		if (core.route == null)
			return;
		for (int i = 0; (i < core.route.length) && (lvl + 1 > core.route[i].lvl); i++) {
			if (!attacks.hasAttack(core.route[i].attack)) {
				attacks.add(core.route[i].attack);
			}
		}
	}

	public void calcStats() {
		int fStats[] = new int[6];
		for (int i = 0; i < 6; i++) {
			fStats[i] = Math.max(start.round(core.Stats[i] * lvl / 50), 1);// basic
																			// stats
																			// *
																			// lvl
			fStats[i] += start.round(iv[i] * lvl / 400);// bonus iv
			fStats[i] += start.round(ev[i] * lvl / 400);// bonus ev
		}
		// nature ad and dis
		String[] ads = nature.split("@");
		int[] adi = new int[2];
		adi[0] = Integer.parseInt(ads[0]);
		adi[1] = Integer.parseInt(ads[1]);
		if (adi[0] != adi[1]) {
			fStats[adi[0]] = (int) Math.max(fStats[adi[0]] * 1.1, 1);
			fStats[adi[1]] = (int) Math.max(fStats[adi[1]] * 0.9, 1);
		}
		// Ability
		/*
		 * switch(ability) { case "Angry": fStats[2] *= 1.25; case "Crazy":
		 * fStats[2] *= 1.5; fStats[4] *= 0.5; case "Friendly": fStats[2] *=
		 * 0.8; }
		 */

		// convert to monster stats
		// order: hp, attack, def, sp_atk, spDef, spd
		hp = fStats[0] * (40) + 100; // survive...
		atk = fStats[1];
		def = fStats[2];
		spAtk = fStats[3];
		spDef = fStats[4];
		spd = fStats[5];
		actualHp = hp;
	}

	boolean checkEvolve() {
		if (core.evoCond.startsWith("lvl"))
			return lvl >= Integer.parseInt(core.evoCond.substring(4));
		return false;
	}

	boolean checkLvlUp() {
		return xp >= lvl * 10;// should be 100
	}

	public void evolve() {
		core = core.evolveTo;
		calcStats();
	}

	public void lvlUp() {
		xp -= (lvl * 10);// Normally is * 100
		lvl++;
		calcStats();
		actualHp = hp;

		// attacksUpdate();
		if (checkEvolve()) {
			evolve();
		}
	}

	void randABL() {
		ability = core.Abls[(int) Math.random() * core.Abls.length];
	}

	void randIV() {
		for (int i = 0; i < iv.length; i++)
			iv[i] = (int) (Math.random() * 129);
	}

	void randNTR() {
		int ad, dis;
		ad = (int) (Math.random() * 6);
		dis = (int) (Math.random() * 6);
		nature = ad + "@" + dis;
	}

	void zeroEV() {
		for (int i = 0; i < ev.length; i++)
			ev[i] = 0;
	}
}