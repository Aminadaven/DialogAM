package Monsters;

import attacks.LvlAttack;
import attacks.Vault;

public interface CoreVaults {
	Core MEW = new Core("Mew", "PSYCHIC", null, "lvl 16", new int[] { 100, 100, 100, 100, 100, 100 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core MEWTWO = new Core("Mewtwo", "PSYCHIC", CoreVaults.MEW, "lvl 16", new int[] { 106, 110, 90, 154, 90, 130 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core DRAGONITE = new Core("Dragonite", "#DRAGON&FLYING", CoreVaults.MEWTWO, "lvl 16",
			new int[] { 91, 134, 95, 100, 100, 80 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core DRAGONAIR = new Core("Dragonair", "DRAGON", CoreVaults.DRAGONITE, "lvl 16",
			new int[] { 61, 84, 65, 70, 70, 70 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core DRATINI = new Core("Dratini", "DRAGON", CoreVaults.DRAGONAIR, "lvl 16", new int[] { 41, 64, 45, 50, 50, 50 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core MOLTRES = new Core("Moltres", "#FIRE&FLYING", CoreVaults.DRATINI, "lvl 16",
			new int[] { 90, 100, 90, 125, 85, 90 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core ZAPDOS = new Core("Zapdos", "#ELECTRIC&FLYING", CoreVaults.MOLTRES, "lvl 16",
			new int[] { 90, 90, 85, 125, 90, 100 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core ARTICUNO = new Core("Articuno", "#ICE&FLYING", CoreVaults.ZAPDOS, "lvl 16",
			new int[] { 90, 85, 100, 95, 125, 85 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core SNORLAX = new Core("Snorlax", "NORMAL", CoreVaults.ARTICUNO, "lvl 16", new int[] { 160, 110, 65, 65, 110, 30 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core AERODACTYL = new Core("Aerodactyl", "#ROCK&FLYING", CoreVaults.SNORLAX, "lvl 16",
			new int[] { 80, 105, 65, 60, 75, 130 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core KABUTOPS = new Core("Kabutops", "#ROCK&WATER", CoreVaults.AERODACTYL, "lvl 16",
			new int[] { 60, 115, 105, 65, 70, 80 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core KABUTO = new Core("Kabuto", "#ROCK&WATER", CoreVaults.KABUTOPS, "lvl 16", new int[] { 30, 80, 90, 55, 45, 55 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core OMASTAR = new Core("Omastar", "#ROCK&WATER", CoreVaults.KABUTO, "lvl 16",
			new int[] { 70, 60, 125, 115, 70, 55 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core OMANYTE = new Core("Omanyte", "#ROCK&WATER", CoreVaults.OMASTAR, "lvl 16",
			new int[] { 35, 40, 100, 90, 55, 35 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core PORYGON = new Core("Porygon", "NORMAL", CoreVaults.OMANYTE, "lvl 16", new int[] { 65, 60, 70, 85, 75, 40 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core FLAREON = new Core("Flareon", "FIRE", CoreVaults.PORYGON, "lvl 16", new int[] { 65, 130, 60, 95, 110, 65 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core JOLTEON = new Core("Jolteon", "ELECTRIC", CoreVaults.FLAREON, "lvl 16", new int[] { 65, 65, 60, 110, 95, 130 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core VAPOREON = new Core("Vaporeon", "WATER", CoreVaults.JOLTEON, "lvl 16", new int[] { 130, 65, 60, 110, 95, 65 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core EEVEE = new Core("Eevee", "NORMAL", CoreVaults.VAPOREON, "lvl 16", new int[] { 55, 55, 50, 45, 65, 55 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core DITTO = new Core("Ditto", "NORMAL", CoreVaults.EEVEE, "lvl 16", new int[] { 48, 48, 48, 48, 48, 48 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core LAPRAS = new Core("Lapras", "#WATER&ICE", CoreVaults.DITTO, "lvl 16", new int[] { 130, 85, 80, 85, 95, 60 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core GYARADOS = new Core("Gyarados", "#WATER&FLYING", CoreVaults.LAPRAS, "lvl 16",
			new int[] { 95, 125, 79, 60, 100, 81 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core MAGIKARP = new Core("Magikarp", "WATER", CoreVaults.GYARADOS, "lvl 16", new int[] { 20, 10, 55, 15, 20, 80 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core TAUROS = new Core("Tauros", "NORMAL", CoreVaults.MAGIKARP, "lvl 16", new int[] { 75, 100, 95, 40, 70, 110 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core PINSIR = new Core("Pinsir", "BUG", CoreVaults.TAUROS, "lvl 16", new int[] { 65, 125, 100, 55, 70, 85 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core MAGMAR = new Core("Magmar", "FIRE", CoreVaults.PINSIR, "lvl 16", new int[] { 65, 95, 57, 100, 85, 93 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core ELECTABUZZ = new Core("Electabuzz", "ELECTRIC", CoreVaults.MAGMAR, "lvl 16",
			new int[] { 65, 83, 57, 95, 85, 105 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core JYNX = new Core("Jynx", "#ICE&PSYCHIC", CoreVaults.ELECTABUZZ, "lvl 16", new int[] { 65, 50, 35, 115, 95, 95 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core SCYTHER = new Core("Scyther", "#BUG&FLYING", CoreVaults.JYNX, "lvl 16", new int[] { 70, 110, 80, 55, 80, 105 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core MR_MIME = new Core("Mr. Mime", "#PSYCHIC&FAIRY", null, "lvl 16", new int[] { 40, 45, 65, 100, 120, 90 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core STARMIE = new Core("Starmie", "#WATER&PSYCHIC", null, "lvl 16", new int[] { 60, 75, 85, 100, 85, 115 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core STARYU = new Core("Staryu", "WATER", CoreVaults.STARMIE, "lvl 16", new int[] { 30, 45, 55, 70, 55, 85 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core SEAKING = new Core("Seaking", "WATER", CoreVaults.STARYU, "lvl 16", new int[] { 80, 92, 65, 65, 80, 68 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core GOLDEEN = new Core("Goldeen", "WATER", CoreVaults.SEAKING, "lvl 16", new int[] { 45, 67, 60, 35, 50, 63 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core SEADRA = new Core("Seadra", "WATER", CoreVaults.GOLDEEN, "lvl 16", new int[] { 55, 65, 95, 95, 45, 85 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core HORSEA = new Core("Horsea", "WATER", CoreVaults.SEADRA, "lvl 16", new int[] { 30, 40, 70, 70, 25, 60 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core KANGASKHAN = new Core("Kangaskhan", "NORMAL", CoreVaults.HORSEA, "lvl 16",
			new int[] { 105, 95, 80, 40, 80, 90 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core TANGELA = new Core("Tangela", "GRASS", CoreVaults.KANGASKHAN, "lvl 16", new int[] { 65, 55, 115, 100, 40, 60 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core CHANSEY = new Core("Chansey", "NORMAL", CoreVaults.TANGELA, "lvl 16", new int[] { 250, 5, 5, 35, 105, 50 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core RHYDON = new Core("Rhydon", "#GROUND&ROCK", CoreVaults.CHANSEY, "lvl 16",
			new int[] { 105, 130, 120, 45, 45, 40 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core RHYHORN = new Core("Rhyhorn", "#GROUND&ROCK", CoreVaults.RHYDON, "lvl 16",
			new int[] { 80, 85, 95, 30, 30, 25 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core WEEZING = new Core("Weezing", "POISON", CoreVaults.RHYHORN, "lvl 16", new int[] { 65, 90, 120, 85, 70, 60 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core KOFFING = new Core("Koffing", "POISON", CoreVaults.WEEZING, "lvl 16", new int[] { 40, 65, 95, 60, 45, 35 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core LICKITUNG = new Core("Lickitung", "NORMAL", CoreVaults.KOFFING, "lvl 16", new int[] { 90, 55, 75, 60, 75, 30 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core HITMONCHAN = new Core("Hitmonchan", "FIGHTING", CoreVaults.LICKITUNG, "lvl 16",
			new int[] { 50, 105, 79, 35, 110, 76 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core HITMONLEE = new Core("Hitmonlee", "FIGHTING", CoreVaults.HITMONCHAN, "lvl 16",
			new int[] { 50, 120, 53, 35, 110, 87 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core MAROWAK = new Core("Marowak", "GROUND", CoreVaults.HITMONLEE, "lvl 16", new int[] { 60, 80, 110, 50, 80, 45 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core CUBONE = new Core("Cubone", "GROUND", CoreVaults.MAROWAK, "lvl 16", new int[] { 50, 50, 95, 40, 50, 35 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core EXEGGUTOR = new Core("Exeggutor", "#GRASS&PSYCHIC", CoreVaults.CUBONE, "lvl 16",
			new int[] { 95, 95, 85, 125, 75, 55 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core EXEGGCUTE = new Core("Exeggcute", "#GRASS&PSYCHIC", CoreVaults.EXEGGUTOR, "lvl 16",
			new int[] { 60, 40, 80, 60, 45, 40 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core ELECTRODE = new Core("Electrode", "ELECTRIC", null, "",
			new int[] { 60, 50, 70, 80, 80, 150 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core VOLTORB = new Core("Voltorb", "ELECTRIC", CoreVaults.ELECTRODE, "lvl 16",
			new int[] { 40, 30, 50, 55, 55, 100 }, new String[] { "Angry" }, new LvlAttack[] { new LvlAttack(1, Vault.SPARK) });
	Core KINGLER = new Core("Kingler", "WATER", CoreVaults.VOLTORB, "lvl 16", new int[] { 55, 130, 115, 50, 50, 75 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core KRABBY = new Core("Krabby", "WATER", CoreVaults.KINGLER, "lvl 16", new int[] { 30, 105, 90, 25, 25, 50 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core HYPNO = new Core("Hypno", "PSYCHIC", CoreVaults.KRABBY, "lvl 16", new int[] { 85, 73, 70, 73, 115, 67 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core DROWZEE = new Core("Drowzee", "PSYCHIC", CoreVaults.HYPNO, "lvl 16", new int[] { 60, 48, 45, 43, 90, 42 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core ONIX = new Core("Onix", "#ROCK&GROUND", CoreVaults.DROWZEE, "lvl 16", new int[] { 35, 45, 160, 30, 45, 70 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core GENGAR = new Core("Gengar", "#GHOST&POISON", CoreVaults.ONIX, "lvl 16", new int[] { 60, 65, 60, 130, 75, 110 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core HAUNTER = new Core("Haunter", "#GHOST&POISON", CoreVaults.GENGAR, "lvl 16",
			new int[] { 45, 50, 45, 115, 55, 95 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core GASTLY = new Core("Gastly", "#GHOST&POISON", CoreVaults.HAUNTER, "lvl 16",
			new int[] { 30, 35, 30, 100, 35, 80 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core CLOYSTER = new Core("Cloyster", "#WATER&ICE", CoreVaults.GASTLY, "lvl 16",
			new int[] { 50, 95, 180, 85, 45, 70 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core SHELLDER = new Core("Shellder", "WATER", CoreVaults.CLOYSTER, "lvl 16", new int[] { 30, 65, 100, 45, 25, 40 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core MUK = new Core("Muk", "POISON", CoreVaults.SHELLDER, "lvl 16", new int[] { 105, 105, 75, 65, 100, 50 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core GRIMER = new Core("Grimer", "POISON", CoreVaults.MUK, "lvl 16", new int[] { 80, 80, 50, 40, 50, 25 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core DEWGONG = new Core("Dewgong", "#WATER&ICE", CoreVaults.GRIMER, "lvl 16", new int[] { 90, 70, 80, 70, 95, 70 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core SEEL = new Core("Seel", "WATER", CoreVaults.DEWGONG, "lvl 16", new int[] { 65, 45, 55, 45, 70, 45 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core DODRIO = new Core("Dodrio", "#NORMAL&FLYING", CoreVaults.SEEL, "lvl 16",
			new int[] { 60, 110, 70, 60, 60, 110 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core DODUO = new Core("Doduo", "#NORMAL&FLYING", CoreVaults.DODRIO, "lvl 16", new int[] { 35, 85, 45, 35, 35, 75 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core FARFETCH_D = new Core("Farfetch\'d", "#NORMAL&FLYING", CoreVaults.DODUO, "lvl 16",
			new int[] { 52, 90, 55, 58, 62, 60 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core MAGNETON = new Core("Magneton", "#ELECTRIC&STEEL", null, "lvl 16", new int[] { 50, 60, 95, 120, 70, 70 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core MAGNEMITE = new Core("Magnemite", "#ELECTRIC&STEEL", CoreVaults.MAGNETON, "lvl 16",
			new int[] { 25, 35, 70, 95, 55, 45 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core SLOWBRO = new Core("Slowbro", "#WATER&PSYCHIC", CoreVaults.MAGNEMITE, "lvl 16",
			new int[] { 95, 75, 110, 100, 80, 30 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core SLOWPOKE = new Core("Slowpoke", "#WATER&PSYCHIC", CoreVaults.SLOWBRO, "lvl 16",
			new int[] { 90, 65, 65, 40, 40, 15 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core RAPIDASH = new Core("Rapidash", "FIRE", CoreVaults.SLOWPOKE, "lvl 16", new int[] { 65, 100, 70, 80, 80, 105 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core PONYTA = new Core("Ponyta", "FIRE", CoreVaults.RAPIDASH, "lvl 16", new int[] { 50, 85, 55, 65, 65, 90 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core GOLEM = new Core("Golem", "#ROCK&GROUND", CoreVaults.PONYTA, "lvl 16", new int[] { 80, 120, 130, 55, 65, 45 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core GRAVELER = new Core("Graveler", "#ROCK&GROUND", CoreVaults.GOLEM, "lvl 16",
			new int[] { 55, 95, 115, 45, 45, 35 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core GEODUDE = new Core("Geodude", "#ROCK&GROUND", CoreVaults.GRAVELER, "lvl 16",
			new int[] { 40, 80, 100, 30, 30, 20 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core TENTACRUEL = new Core("Tentacruel", "#WATER&POISON", CoreVaults.GEODUDE, "lvl 16",
			new int[] { 80, 70, 65, 80, 120, 100 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core TENTACOOL = new Core("Tentacool", "#WATER&POISON", CoreVaults.TENTACRUEL, "lvl 16",
			new int[] { 40, 40, 35, 50, 100, 70 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core VICTREEBEL = new Core("Victreebel", "#GRASS&POISON", CoreVaults.TENTACOOL, "lvl 16",
			new int[] { 80, 105, 65, 100, 70, 70 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core WEEPINBELL = new Core("Weepinbell", "#GRASS&POISON", CoreVaults.VICTREEBEL, "lvl 16",
			new int[] { 65, 90, 50, 85, 45, 55 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core BELLSPROUT = new Core("Bellsprout", "#GRASS&POISON", CoreVaults.WEEPINBELL, "lvl 16",
			new int[] { 50, 75, 35, 70, 30, 40 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core MACHAMP = new Core("Machamp", "FIGHTING", CoreVaults.BELLSPROUT, "lvl 16",
			new int[] { 90, 130, 80, 65, 85, 55 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core MACHOKE = new Core("Machoke", "FIGHTING", CoreVaults.MACHAMP, "lvl 16", new int[] { 80, 100, 70, 50, 60, 45 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core MACHOP = new Core("Machop", "FIGHTING", CoreVaults.MACHOKE, "lvl 16", new int[] { 70, 80, 50, 35, 35, 35 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core ALAKAZAM = new Core("Alakazam", "PSYCHIC", CoreVaults.MACHOP, "lvl 16", new int[] { 55, 50, 45, 135, 95, 120 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core KADABRA = new Core("Kadabra", "PSYCHIC", CoreVaults.ALAKAZAM, "lvl 16", new int[] { 40, 35, 30, 120, 70, 105 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core ABRA = new Core("Abra", "PSYCHIC", CoreVaults.KADABRA, "lvl 16", new int[] { 25, 20, 15, 105, 55, 90 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core POLIWRATH = new Core("Poliwrath", "#WATER&FIGHTING", CoreVaults.ABRA, "lvl 16",
			new int[] { 90, 95, 95, 70, 90, 70 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core POLIWHIRL = new Core("Poliwhirl", "WATER", CoreVaults.POLIWRATH, "lvl 16",
			new int[] { 65, 65, 65, 50, 50, 90 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core POLIWAG = new Core("Poliwag", "WATER", CoreVaults.POLIWHIRL, "lvl 16", new int[] { 40, 50, 40, 40, 40, 90 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core ARCANINE = new Core("Arcanine", "FIRE", CoreVaults.POLIWAG, "lvl 16", new int[] { 90, 110, 80, 100, 80, 95 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core GROWLITHE = new Core("Growlithe", "FIRE", CoreVaults.ARCANINE, "lvl 16", new int[] { 55, 70, 45, 70, 50, 60 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core PRIMEAPE = new Core("Primeape", "FIGHTING", CoreVaults.GROWLITHE, "lvl 16",
			new int[] { 65, 105, 60, 60, 70, 95 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core MANKEY = new Core("Mankey", "FIGHTING", CoreVaults.PRIMEAPE, "lvl 16", new int[] { 40, 80, 35, 35, 45, 70 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core GOLDUCK = new Core("Golduck", "WATER", CoreVaults.MANKEY, "lvl 16", new int[] { 80, 82, 78, 95, 80, 85 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core PSYDUCK = new Core("Psyduck", "WATER", CoreVaults.GOLDUCK, "lvl 16", new int[] { 50, 52, 48, 65, 50, 55 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core PERSIAN = new Core("Persian", "NORMAL", CoreVaults.PSYDUCK, "lvl 16", new int[] { 65, 70, 60, 65, 65, 115 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core MEOWTH = new Core("Meowth", "NORMAL", CoreVaults.PERSIAN, "lvl 16", new int[] { 40, 45, 35, 40, 40, 90 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core DUGTRIO = new Core("Dugtrio", "GROUND", CoreVaults.MEOWTH, "lvl 16", new int[] { 35, 100, 50, 50, 70, 120 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core DIGLETT = new Core("Diglett", "GROUND", CoreVaults.DUGTRIO, "lvl 16", new int[] { 10, 55, 25, 35, 45, 95 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core VENOMOTH = new Core("Venomoth", "#BUG&POISON", CoreVaults.DIGLETT, "lvl 16",
			new int[] { 70, 65, 60, 90, 75, 90 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core VENONAT = new Core("Venonat", "#BUG&POISON", CoreVaults.VENOMOTH, "lvl 16",
			new int[] { 60, 55, 50, 40, 55, 45 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core PARASECT = new Core("Parasect", "#BUG&GRASS", CoreVaults.VENONAT, "lvl 16",
			new int[] { 60, 95, 80, 60, 80, 30 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core PARAS = new Core("Paras", "#BUG&GRASS", CoreVaults.PARASECT, "lvl 16", new int[] { 35, 70, 55, 45, 55, 25 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core VILEPLUME = new Core("Vileplume", "#GRASS&POISON", CoreVaults.PARAS, "lvl 16",
			new int[] { 75, 80, 85, 110, 90, 50 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core GLOOM = new Core("Gloom", "#GRASS&POISON", CoreVaults.VILEPLUME, "lvl 16",
			new int[] { 60, 65, 70, 85, 75, 40 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core ODDISH = new Core("Oddish", "#GRASS&POISON", CoreVaults.GLOOM, "lvl 16", new int[] { 45, 50, 55, 75, 65, 30 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core GOLBAT = new Core("Golbat", "#POISON&FLYING", CoreVaults.ODDISH, "lvl 16",
			new int[] { 75, 80, 70, 65, 75, 90 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core ZUBAT = new Core("Zubat", "#POISON&FLYING", CoreVaults.GOLBAT, "lvl 16", new int[] { 40, 45, 35, 30, 40, 55 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core WIGGLYTUFF = new Core("Wigglytuff", "#NORMAL&FAIRY", CoreVaults.ZUBAT, "lvl 16",
			new int[] { 140, 70, 45, 85, 50, 45 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core JIGGLYPUFF = new Core("Jigglypuff", "#NORMAL&FAIRY", CoreVaults.WIGGLYTUFF, "lvl 16",
			new int[] { 115, 45, 20, 45, 25, 20 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core NINETALES = new Core("Ninetales", "FIRE", CoreVaults.JIGGLYPUFF, "lvl 16",
			new int[] { 73, 76, 75, 81, 100, 100 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core VULPIX = new Core("Vulpix", "FIRE", CoreVaults.NINETALES, "lvl 16", new int[] { 38, 41, 40, 50, 65, 65 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core CLEFABLE = new Core("Clefable", "FAIRY", CoreVaults.VULPIX, "lvl 16", new int[] { 95, 70, 73, 95, 90, 60 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core CLEFAIRY = new Core("Clefairy", "FAIRY", CoreVaults.CLEFABLE, "lvl 16", new int[] { 70, 45, 48, 60, 65, 35 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core NIDOKING = new Core("Nidoking", "#POISON&GROUND", CoreVaults.CLEFAIRY, "lvl 16",
			new int[] { 81, 102, 77, 85, 75, 85 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core NIDORINO = new Core("Nidorino", "POISON", CoreVaults.NIDOKING, "lvl 16", new int[] { 61, 72, 57, 55, 55, 65 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core NIDORAN_M = new Core("Nidoran M", "POISON", CoreVaults.NIDORINO, "lvl 16",
			new int[] { 46, 57, 40, 40, 40, 50 }, new String[] { "Angry" },
			new LvlAttack[] { new LvlAttack(0, Vault.POISON_STING), new LvlAttack(15, Vault.POISON_RAY) });
	Core NIDOQUEEN = new Core("Nidoqueen", "#POISON&GROUND", CoreVaults.NIDORAN_M, "lvl 16",
			new int[] { 90, 92, 87, 75, 85, 76 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core NIDORINA = new Core("Nidorina", "POISON", CoreVaults.NIDOQUEEN, "lvl 16", new int[] { 70, 62, 67, 55, 55, 56 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core NIDORAN_F = new Core("Nidoran F", "POISON", CoreVaults.NIDORINA, "lvl 16",
			new int[] { 55, 47, 52, 40, 40, 41 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core SANDSLASH = new Core("Sandslash", "GROUND", CoreVaults.NIDORAN_F, "lvl 16",
			new int[] { 75, 100, 110, 45, 55, 65 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core SANDSHREW = new Core("Sandshrew", "GROUND", CoreVaults.SANDSLASH, "lvl 16",
			new int[] { 50, 75, 85, 20, 30, 40 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core RAICHU = new Core("Raichu", "ELECTRIC", CoreVaults.SANDSHREW, "lvl 16", new int[] { 60, 90, 55, 90, 80, 110 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core PIKACHU = new Core("Pikachu", "ELECTRIC", CoreVaults.RAICHU, "lvl 16", new int[] { 35, 55, 40, 50, 50, 90 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core ARBOK = new Core("Arbok", "POISON", CoreVaults.PIKACHU, "lvl 16", new int[] { 60, 95, 69, 65, 79, 80 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core EKANS = new Core("Ekans", "POISON", CoreVaults.ARBOK, "lvl 16", new int[] { 35, 60, 44, 40, 54, 55 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core FEAROW = new Core("Fearow", "#NORMAL&FLYING", CoreVaults.EKANS, "lvl 16",
			new int[] { 65, 90, 65, 61, 61, 100 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core SPEAROW = new Core("Spearow", "#NORMAL&FLYING", CoreVaults.FEAROW, "lvl 16",
			new int[] { 40, 60, 30, 31, 31, 70 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core RATICATE = new Core("Raticate", "NORMAL", CoreVaults.SPEAROW, "lvl 16", new int[] { 55, 81, 60, 50, 70, 97 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core RATTATA = new Core("Rattata", "NORMAL", CoreVaults.RATICATE, "lvl 16", new int[] { 30, 56, 35, 25, 35, 72 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core PIDGEOT = new Core("Pidgeot", "#NORMAL&FLYING", CoreVaults.RATTATA, "lvl 16",
			new int[] { 83, 80, 75, 70, 70, 101 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core PIDGEOTTO = new Core("Pidgeotto", "#NORMAL&FLYING", CoreVaults.PIDGEOT, "lvl 16",
			new int[] { 63, 60, 55, 50, 50, 71 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core PIDGEY = new Core("Pidgey", "#NORMAL&FLYING", CoreVaults.PIDGEOTTO, "lvl 16",
			new int[] { 40, 45, 40, 35, 35, 56 }, new String[] { "Angry" },
			new LvlAttack[] { new LvlAttack(1, Vault.SCRATCH), new LvlAttack(8, Vault.GUST) });
	Core BEEDRILL = new Core("Beedrill", "#BUG&POISON", CoreVaults.PIDGEY, "lvl 16",
			new int[] { 65, 90, 40, 45, 80, 75 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core KAKUNA = new Core("Kakuna", "#BUG&POISON", CoreVaults.BEEDRILL, "lvl 16", new int[] { 45, 25, 50, 25, 25, 35 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core WEEDLE = new Core("Weedle", "#BUG&POISON", CoreVaults.KAKUNA, "lvl 16", new int[] { 40, 35, 30, 20, 20, 50 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core BUTTERFREE = new Core("Butterfree", "#BUG&FLYING", CoreVaults.WEEDLE, "lvl 16",
			new int[] { 60, 45, 50, 90, 80, 70 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core METAPOD = new Core("Metapod", "BUG", CoreVaults.BUTTERFREE, "lvl 16", new int[] { 50, 20, 55, 25, 25, 30 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core CATERPIE = new Core("Caterpie", "BUG", CoreVaults.METAPOD, "lvl 16", new int[] { 45, 30, 35, 20, 20, 45 },
			new String[] { "Angry" }, new LvlAttack[] { null });
	Core BLASTOISE = new Core("Blastoise", "WATER", CoreVaults.CATERPIE, "lvl 16",
			new int[] { 79, 83, 100, 85, 105, 78 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core WARTORTLE = new Core("Wartortle", "WATER", CoreVaults.BLASTOISE, "lvl 16",
			new int[] { 59, 63, 80, 65, 80, 58 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core SQUIRTLE = new Core("Squirtle", "WATER", CoreVaults.WARTORTLE, "lvl 16", new int[] { 44, 48, 65, 50, 64, 43 },
			new String[] { "Angry" }, new LvlAttack[] { new LvlAttack(1, Vault.SCRATCH), new LvlAttack(6, Vault.BUBBLE) });
	Core CHARIZARD = new Core("Charizard", "#FIRE&FLYING", CoreVaults.SQUIRTLE, "lvl 16",
			new int[] { 78, 84, 78, 109, 85, 100 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core CHARMELEON = new Core("Charmeleon", "FIRE", CoreVaults.CHARIZARD, "lvl 16",
			new int[] { 58, 64, 58, 80, 65, 80 }, new String[] { "Angry" }, new LvlAttack[] { new LvlAttack(16, Vault.FLAMETHROWER) });
	Core CHARMANDER = new Core("Charmander", "FIRE", CoreVaults.CHARMELEON, "lvl 16",
			new int[] { 39, 52, 43, 60, 50, 65 }, new String[] { "Angry" },
			new LvlAttack[] { new LvlAttack(1, Vault.SCRATCH), new LvlAttack(6, Vault.EMBER) });
	Core VENUSAUR = new Core("Venusaur", "#GRASS&POISON", CoreVaults.CHARMANDER, "lvl 16",
			new int[] { 80, 82, 83, 100, 100, 80 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core IVYSAUR = new Core("Ivysaur", "#GRASS&POISON", CoreVaults.VENUSAUR, "lvl 16",
			new int[] { 60, 62, 63, 80, 80, 60 }, new String[] { "Angry" }, new LvlAttack[] { null });
	Core BULBASAUR = new Core("Bulbasaur", "#GRASS&POISON", CoreVaults.IVYSAUR, "lvl 16",
			new int[] { 45, 49, 49, 65, 65, 45 }, new String[] { "Angry" },
			new LvlAttack[] { new LvlAttack(1, Vault.SCRATCH), new LvlAttack(6, Vault.GRAPES) });
}