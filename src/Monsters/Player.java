package Monsters;

import main.start;

public class Player extends Monster {
	// siding with humans is -, with monsters is +
	public boolean berry = false;
	public String name;
	public int side = 0;

	public Player(Core core) {
		super(core);
	}

	public Player(Core core, int lvl) {
		super(core, lvl);
	}
	/*
	public void calcStats() {
		super.calcStats();
		String data = "";
		start.gui.setData(data);
	}
	*/
/*
	public Player(Core core, String name, String status, String nature, String ability, int[] iv, int[] ev, int lvl,
			int side, int actualHp, int xp, boolean berry, AttacksVector attacks) {
		super(core, lvl);
		this.name = name;
		this.status = status;
		this.iv = iv;
		this.ev = ev;
		this.nature = nature;
		this.ability = ability;
		calcStats();
		this.actualHp = actualHp;
		this.attacks = attacks;
		this.xp = xp;
		this.side = side;
		this.berry = berry;
	}
*/
	@Override
	public void lvlUp() {
		xp -= (lvl * 10);//should be 100
		lvl++;
		start.out(name + " Has Leveled Up to level: " + lvl + "!");
		calcStats();
		actualHp = hp;
		attacksUpdate();
		/*
		if(checkMoves()) {
			
		}
		*/
		if (checkEvolve()) {
			if (wantEvolve())
				evolve();
		}
	}

	@SuppressWarnings("unused")
	private boolean checkMoves() {
		/*
		int old = lvl - 1;
		for(int i = 0; i < core.route.length; i++) {
			
		}
		*/
		return false;
	}

	boolean wantEvolve() {
		return start.choice(core.spec + " can evolve! \nWhat do you decide?", "Evolve!", "Not yet.") == 0;
	}

	public void addBerry() {
		start.out(name + " has collected a Berry!");
		berry = true;
	}

	public void heal() {
		start.out("You have been healed to max health!");
		actualHp = hp;
	}
	
	public void addEV(int type, int amount) {
		super.addEV(type, amount);
		start.out("You have gotten " + amount + " EV of type:" + type);
	}
}