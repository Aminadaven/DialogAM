package main;

//import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

import Monsters.CoreVaults;
import Monsters.Monster;
import Monsters.Player;
import attacks.Attack;
import attacks.Vault;
//import dialogGUI.DialogIO;
import saveAndLoad.KeyGroup;
import saveAndLoad.LogFile;
import saveAndLoad.SaveFile;

public class startGUI {
	static class Data {
		public int actualHp;
		public String status;

		public Data(int actualHp, String status) {
			this.actualHp = actualHp;
			this.status = status;
		}
	}
	//public static GUI gui = new GUI();
	static SaveFile saf;
	static LogFile log;
	//public static Scanner in = new Scanner(System.in);
	// player vars
	public static Player player;
	static String title = "";
	public static GUI gui = new GUI();

	synchronized public static void out(String text) {
		gui.log(text);
		//gui.out(text);
		//MsgDialog.msg(text, "title");
		MsgDialog.msgp(gui.io, text, title+" - Story");
		//JOptionPane.showInternalMessageDialog(gui.ioPanel, text, title+" - Story", JOptionPane.PLAIN_MESSAGE);
		//gui.pack();
	}

	public static int ynChoice(String question, String title, String... options) {
		return JOptionPane.showOptionDialog(null, question, title, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
	}

	synchronized public static String mchoice(String question/* , String title */, String... options) {
		return MsgDialog.inputp(gui.io, question, title+" - A Choice", options);
		/*
		return (String) JOptionPane.showInternalInputDialog(gui.io, question, title+" - A Choice", JOptionPane.PLAIN_MESSAGE, null,
				options, options[0]);
				*/
	}

	synchronized public static String getStr(String question/* , String title */) {
		return MsgDialog.inputp(gui.io, question, title+" - Input");
		/*
		out(question);
		return gui.in();
		
		return (String) JOptionPane.showInternalInputDialog(gui.ioPanel, question, title+" - Input", JOptionPane.PLAIN_MESSAGE, null, null,
				null);
		*/
		
	}

	public static int getInt(String question/* , String title */) {
		/*
		out(question);
		return Integer.parseInt(gui.in());
		*/
		return Integer.parseInt((String) JOptionPane.showInternalInputDialog(gui.ioPanel, question, title+" - Input", JOptionPane.PLAIN_MESSAGE,
				null, null, null));
	}

	/*
	 * public static void out(String str) { //System.out.println(str);
	 * DialogIO.out(str); }
	 * 
	 * 
	 * public static int getInt() { return Integer.parseInt(in.nextLine()); }
	 * 
	 * 
	 * public static String getStr() { return in.nextLine(); }
	 * 
	 */
	private static void cls() {
		// out("\n\n");
	}

	private static void pause() {
		// out("Enter any key to continue...");
		// getStr();
	}

	/*
	
	public static int choice(String title, String... options) {
		return gui.choice(title, options);
	}
	*/
	
	public static int choice(String title, String... options) {
		gui.log(title);
		String choice = mchoice(title, options);
		for (int num = 0; num < options.length; num++) {
			if (choice.equals(options[num])) {
				gui.log(options[num]);
				return num;
			}
		}
		return -1;
	}
	
	/*
	 * do { do { out(title); for (int i = 0; i < options.length; i++) { out(i +
	 * ")" + options[i]); } try { choice = getInt(); } catch
	 * (java.lang.NumberFormatException e) { System.err.print(
	 * "Error: you didnt typed a number!"); choice = -1; cls(); } } while
	 * (choice > 9 || choice < 0); } while (choice >= options.length); return
	 * choice;
	 */
	// }

	static void playerBar() {
		String s = "";
		s += (player.name + " \n" + player.core.spec + " level: " + player.lvl);
		s += "\n";
		s += (" XP: " + player.xp + "/" + player.lvl * 10); // shoild be 100,
															// but...
		s += "\n";
		s += (" hp: " + player.hp);
		s += "\n";
		s += (" speed: " + player.spd);
		s += "\n";
		s += (" attack: " + player.atk);
		s += "\n";
		s += (" defense: " + player.def);
		s += "\n";
		s += (" sp. attack: " + player.spAtk);
		s += "\n";
		s += (" sp. defense: " + player.spDef);
		s += "\n";
		for (int i = 0; i < player.attacks.getSize(); i++) {
			s += ("Attack " + i + ": " + player.attacks.get(i).name);
			s += "\n";
		}
		out(s);
	}

	private static void drawMonsters(Monster mon1, Monster mon2) {
		cls();
		// assuming only the player has name
		String out1 = mon1.getClass().getSimpleName().equals("Player") ? player.name + " \n" : "";
		out1 += mon1.core.spec + "\n\t" + "HP: " + mon1.actualHp + "/" + mon1.hp + " Speed: " + mon1.spd;
		String out2 = mon2.getClass().getSimpleName().equals("Player") ? player.name + " \n" : "";
		out2 += mon2.core.spec + "\n\t" + "HP: " + mon2.actualHp + "/" + mon2.hp + " Speed: " + mon2.spd;
		out(out1 + "\n---------------------------------------\n" + out2);
	}

	public static int round(double dmg) {
		int round = (int) dmg;
		return (round + 1 - dmg < 0.5) ? round + 1 : round;
	}

	private static void turn(Monster attacker, Monster defender) {
		String out = "";
		if (attacker.hp <= 0)
			return;
		pause();
		cls();
		// 1 status reduction
		switch (attacker.status) {
		case "Poisoned":
			attacker.actualHp -= attacker.hp / 8.0;
			break;
		case "Burned":
			attacker.actualHp -= attacker.hp / 16.0;
			attacker.atk -= attacker.atk / 10.0;
			break;
		case "Paralized":
			attacker.spd -= attacker.spd / 4.0;
			if (Math.random() < 0.25) {
				out(attacker.core.spec + " is Paralized!");
				return;
			}
			break;
		// add the rest here
		}
		out += ("Its " + attacker.core.spec + " Turn now!");
		if (!attacker.status.equals(""))
			out += ("\n" + attacker.core.spec + " Is " + attacker.status + "!");
		out(out);
		out = "";
		drawMonsters(attacker, defender);
		int choice;
		// int num = 4;
		/*
		 * for (int i = 0; i < attacker.attacks.length; i++) { if
		 * (attacker.attacks[i] == null) num--; }
		 */
		do {
			String[] options;
			if (attacker.equals(player)) {
				// drawMonsters(attacker, defender);
				// AttacksVector
				Vector<String> attacks = new Vector<String>();
				for (int i = 0; i < attacker.attacks.getSize(); i++) {
					attacks.add(attacker.attacks.get(i).name + " type: " + attacker.attacks.get(i).type + " pp: "
							+ attacker.attacks.get(i).actualPp + "/" + attacker.attacks.get(i).pp + " Power: "
							+ attacker.attacks.get(i).power + " Accuracy: " + attacker.attacks.get(i).acc + "\n\t "
							+ attacker.attacks.get(i).desc);
				}
				if (player.berry) {
					options = new String[attacks.size() + 1];
					for (int i = 0; i < options.length - 1; i++) {
						options[i] = attacks.elementAt(i);
					}
					options[options.length - 1] = "Use Your Berry!";
				} else {
					options = new String[attacks.size()];
					for (int i = 0; i < options.length; i++) {
						options[i] = attacks.elementAt(i);
					}
				}
				choice = choice("Choose Attack", options);
				if (player.berry && choice == options.length - 1) {
					attacker.actualHp = attacker.hp;
					out(player.name + " Has used his Berry!!");
					player.berry = false;
					return;
				}
			} else {
				// Randomly choose an attack
				choice = (int) (Math.random() * attacker.attacks.getSize());
			}
			/*
			 * while (attacker.attacks[choice] == null) { choice++; if (choice
			 * == 4) choice = 0; } //
			 */
		} while (attacker.attacks.get(choice).actualPp <= 0);
		Attack chosenAttack = attacker.attacks.get(choice);
		out += (attacker.core.spec + " Has Chosen the attack: " + attacker.attacks.get(choice).name);
		// pp reduction
		chosenAttack.actualPp--;
		// there should be an ability check here
		for (int i = 0; i < chosenAttack.missiles; i++) {
			boolean cont;
			cont= true;
			// accuracy check
			if (chosenAttack.acc < Math.random() * 100) { // Unsuccessful hit
				out += ("\n" + attacker.core.spec + " has missed " + chosenAttack.name);
				out(out);
				out = "";
				if (i == chosenAttack.missiles - 1) {
					return;
				}
				cont = false;
			}
			while (cont) {
				// damage stage
				boolean special = false;
				switch (chosenAttack.type.toLowerCase()) {
				case "fire":
					special = true;
					break;
				case "water":
					special = true;
					break;
				case "grass":
					special = true;
					break;
				case "electric":
					special = true;
					break;
				case "psychic":
					special = true;
					break;
				case "ice":
					special = true;
					break;
				case "dark":
					special = true;
					break;
				}
				// STAB and type bonus
				// out+=("\nattack power: " + chosenAttack.power);
				double dmg;
				if (Matrix.isType(attacker.core.type, chosenAttack.type)) {
					dmg = chosenAttack.power * 1.5;
					out += "\nSame Type Attack Bonus!";
				} else {
					dmg = chosenAttack.power;
				}
				double factor = Matrix.getMult(chosenAttack.type, defender.core.type);
				if (factor >= 2) {
					out += "\nThe Attack is super effective!";
				} else if (factor < 1) {
					out += "\nThe Attack is not very effective.";
				}
				dmg = dmg * factor;
				// * Matrix.getMult(chosenAttack.type, defender.core.type);
				// out("after bonuses raw dmg is: " + dmg);
				if (special) {
					// out("dmg: " + dmg + " spAtk: " + attacker.spAtk + "
					// spDef: " + defender.spDef);
					dmg = (dmg * attacker.spAtk / defender.spDef);
				} else {
					// out("dmg: " + dmg + " atk: " + attacker.atk + " def: " +
					// defender.def);
					dmg = (dmg * attacker.atk / defender.def);
				}

				if (Math.random() * 100 > 90) {
					out += "\nCritical Hit!";
					dmg = dmg * 2;
				}
				// dmg = (Math.random() * 100 > 90) ? dmg * 2 : dmg;
				// out("final dmg is: " + dmg);
				// there should be an ability check here

				// applying damage
				out += ("\n" + attacker.core.spec + " Is Doing " + round(dmg) + " Damage!");
				defender.actualHp -= round(dmg);
				// status effects
				switch (chosenAttack.effect) {
				case "Poison 75":
					if (Math.random() * 100 < 75) {
						defender.status = "Poisoned";
						out += ("\n" + attacker.core.spec + " Has Poisoned " + defender.core.spec);
					}
					break;
				case "Poison 15":
					if (Math.random() * 100 < 15) {
						defender.status = "Poisoned";
						out += ("\n" + attacker.core.spec + " Has Poisoned " + defender.core.spec);
					}
					break;
				case "Burn 10":
					if (Math.random() * 100 < 10) {
						defender.status = "Burned";
						out += ("\n" + attacker.core.spec + " Has Burned " + defender.core.spec);
					}
					break;
				case "Burn 30":
					if (Math.random() * 100 < 30) {
						defender.status = "Burned";
						out += ("\n" + attacker.core.spec + " Has Burned " + defender.core.spec);
					}
					break;
				case "Paralyze 20":
					if (Math.random() * 100 < 20) {
						defender.status = "Burned";
						out += ("\n" + attacker.core.spec + " Has Paralyzed " + defender.core.spec);
					}
					break;
				}
				cont = false;
			}
		}
		out(out);
		// there should be an ability check here
	}

	static void battle(Monster mon1, Monster mon2) {
		Data[] data = new Data[2];
		while (mon1.actualHp > 0 && mon2.actualHp > 0) {
			if (mon1.spd >= mon2.spd) {
				if (mon1.actualHp > 0)
					turn(mon1, mon2);
				if (mon2.actualHp > 0)
					turn(mon2, mon1);
			} else {
				if (mon2.actualHp > 0)
					turn(mon2, mon1);
				if (mon1.actualHp > 0)
					turn(mon1, mon2);
			}
		}
		if (player.actualHp <= 0)
			gameOver();
		if (mon1.actualHp <= 0) {
			data[0] = new Data(0, "Fainted");
			out(mon1.core.spec + " Has Fainted!");
		} else {
			data[0] = new Data(mon1.actualHp, mon1.status);
		}
		if (mon2.actualHp <= 0) {
			data[1] = new Data(0, "Fainted");
			out(mon2.core.spec + " Has Fainted!");
		} else {
			data[1] = new Data(mon2.actualHp, mon2.status);
		}
		pause();
		cls();
		mon1.calcStats();
		mon1.actualHp = data[0].actualHp;
		mon1.status = data[0].status;
		mon2.calcStats();
		mon2.actualHp = data[1].actualHp;
		mon2.status = data[1].status;
		int old;
		if (mon1.actualHp > 0) {
			old = mon1.xp;
			mon1.addXP(mon2);
			mon1.addEV(mon2);
			old = mon1.xp - old;
			out(mon1.core.spec + " Has gained " + old + " XP!");
		} else {
			old = mon2.xp;
			mon2.addXP(mon1);
			mon2.addEV(mon1);
			old = mon2.xp - old;
			out(mon2.core.spec + " Has gained " + old + " XP!");
		}
	}

	private static void Introduction() {
		title = "Introduction";
		out("Welcome to AdventureMonster!" + System.lineSeparator()
				+ "You are playing as a Monster in a world that Humans, called: Trainers " + System.lineSeparator()
				+ "are widly capturing Monsters and turning them into their pets, battle tools or \'friends\'."
				+ System.lineSeparator()
				+ "the Trainers calling the Monsters \"Pocket Monsters\" or in short - Pokemons."
				+ System.lineSeparator()
				+ "As a Monster you will have to decide across the game if you want to fight the Trainers, "
				+ System.lineSeparator() + "or Join them." + System.lineSeparator() + "Ready? Let\'s Begin!");
		pause();
		switch (choice("Choose your color:", "Green", "Red", "Blue")) {
		case 0:
			player = new Player(CoreVaults.BULBASAUR);
			break;
		case 1:
			player = new Player(CoreVaults.CHARMANDER);
			break;
		case 2:
			player = new Player(CoreVaults.SQUIRTLE);
			break;
		}
		cls();
		if (choice("So, " + player.core.spec + " Do you want to choose your name?",
				"Yes, a name will make me feel unique.",
				"No! names are for humans and their puppets!\n" + player.core.spec + " is just fine!") == 0) {
			// out("Then please enter your name here:");
			player.name = getStr("Then please enter your name here:");
			player.side--;
		} else {
			out("Fine. You won\'t have unique name.\nYour Name is set to " + player.core.spec);
			player.name = player.core.spec;
			player.side++;
		}
		// player.calcStats();
		// player.attacksUpdate();
		cls();
		out("So you are now...");
		playerBar();
		pause();
		saf = new SaveFile(player.name + ".dam");
		log = new LogFile(player.name + ".log");
		// saf2 = new SaveFile("Attacks" + player.name + ".cam");
		save("c1");
		chapter1();
	}

	private static void chapter1() {
		title = "Chapter 1";
		Monster enemy = null;
		switch (player.core.spec) {
		case "Bulbasaur":
			enemy = new Monster(CoreVaults.CHARMANDER, 5);
			break;
		case "Charmander":
			enemy = new Monster(CoreVaults.SQUIRTLE, 5);
			break;
		case "Squirtle":
			enemy = new Monster(CoreVaults.BULBASAUR, 5);
			break;
		}
		Monster mon = new Monster((Math.random() * 2 > 1) ? CoreVaults.NIDORAN_M : CoreVaults.PIDGEY, 4);
		//out("Chapter 1\n------------");
		player.addBerry();
		int choice = 0;
		switch (choice(
				"You are instinctivly awake when you hear all that noise.\nA Trainer want to catch a Monster, but there is another Monster that tries to defend that Monster.\nWhat do you think? ",
				new String[] { "I must help the Monsters! I will fight the trainer!",
						"No one should ruin the bond within a Trainer and his Pokemon! I will clear that wild Pokemon!",
						"I just want to see what happen" })) {
		case 0:
			player.side += 2;
			battle(player, enemy);
			out("For your help to the Monsters, I, " + mon.core.spec + " will teach you a rare attack!");
			choice = choice("What attack do you prefer to learn?", "Psycho", "Dragon Rage");
			if (choice == 0)
				player.addAttack(Vault.PSYCHO);
			if (choice == 1)
				player.addAttack(Vault.DRAGON_RAGE);
			// player.addXP(20000);
			break;
		case 1:
			player.side -= 2;
			battle(player, mon);
			out("For your help to the Trainers, I, want to teach you a nice attack, and add to you some EV");
			choice = choice("What attack do you prefer to learn?", "Iron Claw", "Punch");
			if (choice == 0)
				player.addAttack(Vault.IRON_CLAW);
			if (choice == 1)
				player.addAttack(Vault.PUNCH);
			choice = choice("Choose type to get 8 EV Points:", "HP", "Attack", "Defence", "Special Attack",
					"Special Defence", "Speed");
			player.addEV(choice, 8);
			break;
		default:
			player.side--;
			battle(mon, enemy);
			break;
		}
		/*
		 * player.heal(); out(
		 * "You must help! There is a dangerous Monster on the hill! " +
		 * "\nBut, do you ready? it should be lvl 20+ Monster! (exit train to proceed...)"
		 * ); pause(); playerBar(); String str = ""; do { str = ""; cls();
		 * train(); playerBar(); // str += (player.name + " \n" +
		 * player.core.spec + " level: " + // player.lvl + "\n"); // str += (
		 * " XP: " + player.xp + "/" + player.lvl * 10 + "\n"); // // Should //
		 * be // 100, // but... } while (choice(str +
		 * "So, do you want to train? ", "Yes", "No") == 0);
		 */
		save("c2");
		chapter2();
	}

	private static void chapter2() {
		title = "Chapter 2";
		cls();
		//out("Chapter2\n" + "-----------");
		player.heal();
		out("You must help! There is a dangerous Monster on the hill! "
				+ "\nBut, do you ready? it should be lvl 20+ Monster! (exit train to proceed...)");
		pause();
		playerBar();
		String str = "";
		do {
			str = "";
			cls();
			train();
			save("c2");
			playerBar();
			// str += (player.name + " \n" + player.core.spec + " level: " +
			// player.lvl + "\n");
			// str += (" XP: " + player.xp + "/" + player.lvl * 10 + "\n"); //
			// Should
			// be
			// 100,
			// but...
		} while (choice(str + "So, do you want to train? ", "Yes", "No") == 0);

	}

	private static void train() {
		title = "Train";
		int choice = choice("Choose a monster to fight against: ", "Pidgey (spd EV) lvl " + (player.lvl + 4),
				"Nidoran M (atk EV) lvl " + player.lvl, "Random Starter lvl " + (player.lvl - 1),
				"Random Monster at random lvl");
		player.addBerry();
		player.status = "";
		for (int i = 0; i < player.attacks.getSize(); i++) {
			if (player.attacks.get(i) != null) {
				player.attacks.get(i).actualPp = player.attacks.get(i).pp;
			}
		}
		int rand;
		switch (choice) {
		case 0:
			battle(player, new Monster(CoreVaults.PIDGEY, player.lvl + 4));
			break;
		case 1:
			battle(player, new Monster(CoreVaults.NIDORAN_M, player.lvl));
			break;
		case 2:
			rand = (int) (Math.random() * 3);
			if (rand == 0)
				battle(player, new Monster(CoreVaults.BULBASAUR, player.lvl - 1));
			if (rand == 1)
				battle(player, new Monster(CoreVaults.SQUIRTLE, player.lvl - 1));
			if (rand == 2)
				battle(player, new Monster(CoreVaults.CHARMANDER, player.lvl - 1));
			break;
		case 3:
			rand = (int) (Math.random() * 6);
			int lvl = player.lvl - 5 + (int) (Math.random() * 10) + 1;
			if (rand == 0)
				battle(player, new Monster(CoreVaults.BULBASAUR, lvl));
			if (rand == 1)
				battle(player, new Monster(CoreVaults.SQUIRTLE, lvl));
			if (rand == 2)
				battle(player, new Monster(CoreVaults.CHARMANDER, lvl));
			if (rand == 3)
				battle(player, new Monster(CoreVaults.PIDGEY, lvl));
			if (rand == 4)
				battle(player, new Monster(CoreVaults.NIDORAN_M, lvl));
			if (rand == 5)
				battle(player, new Monster(CoreVaults.VOLTORB, lvl));
			break;
		}
		player.heal();
	}

	private static void gameOver() {
		String mission = player.side < -1
				? "help the Pokemon understand they're place in the world,\nFriends with the Trainers!"
				: "Fight the trainers and free the monsters from Human Tyranny!!";
		cls();
		cls();
		out("You have been fainted!\nYou Lost, and failed your mission to " + mission);
		if (choice("Do you want to start again?", "Yes!", "No...") == 0)
			Introduction();
		// pause();
		System.exit(1);
	}

	public static void main(String[] args) {
		if (args != null)
			if (args.length > 0) {
				saf = new SaveFile(args[0]);
				log = new LogFile(args[0].replace(".dam", ".log"));
				// saf2 = new SaveFile("Attacks" + args[0]);
				switch (load()) {
				case "intro":
					Introduction();
					break;
				case "c1":
					chapter1();
					break;
				case "c2":
					chapter2();
					break;
				}

			} else {
				Introduction();
				// chapter1();
			}

	}

	static void save(String method) {
		log.save(gui.getLog());
		KeyGroup playerSettings = new KeyGroup("PLAYER");
		playerSettings.addKey("method", method);
		playerSettings.addKey("core", player.core.spec);
		playerSettings.addKey("name", player.name);
		playerSettings.addKey("status", player.status);
		playerSettings.addKey("nature", player.nature);
		playerSettings.addKey("ability", player.ability);
		playerSettings.addKey("level", "" + player.lvl);
		playerSettings.addKey("actual_hp", "" + player.actualHp);
		playerSettings.addKey("xp", "" + player.xp);
		playerSettings.addKey("side", "" + player.side);
		playerSettings.addKey("berry", "" + player.berry);
		saf.addGroup(playerSettings);
		KeyGroup ev = new KeyGroup("EV");
		ev.addKey("ev0", "" + player.ev[0]);
		ev.addKey("ev1", "" + player.ev[1]);
		ev.addKey("ev2", "" + player.ev[2]);
		ev.addKey("ev3", "" + player.ev[3]);
		ev.addKey("ev4", "" + player.ev[4]);
		ev.addKey("ev5", "" + player.ev[5]);
		saf.addGroup(ev);
		KeyGroup iv = new KeyGroup("IV");
		iv.addKey("iv0", "" + player.iv[0]);
		iv.addKey("iv1", "" + player.iv[1]);
		iv.addKey("iv2", "" + player.iv[2]);
		iv.addKey("iv3", "" + player.iv[3]);
		iv.addKey("iv4", "" + player.iv[4]);
		iv.addKey("iv5", "" + player.iv[5]);
		saf.addGroup(iv);
		// saf.save();
		for (int i = 0; i < player.attacks.getSize(); i++) {
			Attack current = player.attacks.get(i);
			KeyGroup attack = new KeyGroup(i + "");
			attack.addKey("name", current.name);
			attack.addKey("desc", current.desc);
			attack.addKey("type", current.type);
			attack.addKey("effect", current.effect);
			attack.addKey("pp", current.pp + "");
			attack.addKey("power", current.power + "");
			attack.addKey("acc", current.acc + "");
			attack.addKey("missiles", current.missiles + "");
			attack.addKey("actualPp", current.actualPp + "");
			saf.addGroup(attack);
		}
		saf.save();
		out("The game has been saved");
	}

	static String load() {
		gui.setLog(log.load());
		saf.load();
		KeyGroup playerSettings = saf.getGroup("PLAYER");
		String method = playerSettings.getKey("method");
		switch (playerSettings.getKey("core")) {
		case "Bulbasaur":
			player = new Player(CoreVaults.BULBASAUR);
			break;
		case "Ivysaur":
			player = new Player(CoreVaults.IVYSAUR);
			break;
		case "Venusaur":
			player = new Player(CoreVaults.VENUSAUR);
			break;
		case "Charmander":
			player = new Player(CoreVaults.CHARMANDER);
			break;
		case "Charmeleon":
			player = new Player(CoreVaults.CHARMELEON);
			break;
		case "Charizard":
			player = new Player(CoreVaults.CHARIZARD);
			break;
		case "Squirtle":
			player = new Player(CoreVaults.SQUIRTLE);
			break;
		case "Wartortle":
			player = new Player(CoreVaults.WARTORTLE);
			break;
		case "Blastoise":
			player = new Player(CoreVaults.BLASTOISE);
			break;
		}
		player.name = playerSettings.getKey("name");
		player.status = playerSettings.getKey("status");
		player.nature = playerSettings.getKey("nature");
		player.ability = playerSettings.getKey("ability");
		player.lvl = Integer.parseInt(playerSettings.getKey("level"));
		player.actualHp = Integer.parseInt(playerSettings.getKey("actual_hp"));
		player.xp = Integer.parseInt(playerSettings.getKey("xp"));
		player.side = Integer.parseInt(playerSettings.getKey("side"));
		player.berry = Boolean.parseBoolean(playerSettings.getKey("berry"));
		KeyGroup ev = saf.getGroup("EV");
		player.ev[0] = Integer.parseInt(ev.getKey("ev0"));
		player.ev[1] = Integer.parseInt(ev.getKey("ev1"));
		player.ev[2] = Integer.parseInt(ev.getKey("ev2"));
		player.ev[3] = Integer.parseInt(ev.getKey("ev3"));
		player.ev[4] = Integer.parseInt(ev.getKey("ev4"));
		player.ev[5] = Integer.parseInt(ev.getKey("ev5"));
		KeyGroup iv = saf.getGroup("IV");
		player.iv[0] = Integer.parseInt(iv.getKey("iv0"));
		player.iv[1] = Integer.parseInt(iv.getKey("iv1"));
		player.iv[2] = Integer.parseInt(iv.getKey("iv2"));
		player.iv[3] = Integer.parseInt(iv.getKey("iv3"));
		player.iv[4] = Integer.parseInt(iv.getKey("iv4"));
		player.iv[5] = Integer.parseInt(iv.getKey("iv5"));
		player.attacksUpdate();
		player.calcStats();
		// saf2.load();
		for (int i = 0; i < saf.getSize() - 3; i++) {
			KeyGroup attack = saf.getGroup(i + "");
			Attack current = new Attack(attack.getKey("name"), attack.getKey("desc"), attack.getKey("type"),
					attack.getKey("effect"), Integer.parseInt(attack.getKey("pp")),
					Integer.parseInt(attack.getKey("power")), Integer.parseInt(attack.getKey("acc")),
					Integer.parseInt(attack.getKey("missiles")));
			current.actualPp = Integer.parseInt(attack.getKey("actualPp"));
			player.addAttack(current);
		}
		out("The game has been loaded");
		return method;
	}
}