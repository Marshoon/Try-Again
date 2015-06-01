import Paul.*;

public class Engine extends Etc {
	public static Player Hero;
	private static Enemy Boss;
	/**
	 * @param at
	 *            index 0/2 is the Hero
	 * @param at
	 *            index 1/2 is an Enemy
	 * @param at
	 *            index 2/2 is an NPC or an Enemy
	 */
	private static Entity[] entities;
	private static Entity[] boss;
	private static Entity[] quest;
	private static Item[] items;
	private static Item[] Empty;
	private static Item[] Treasure;
	private static Environment[][] map;
	private static Environment Boss_Room;
	private static Environment Treasure_Room;
	private static Environment Quest_Room;
	private static int locR, locC;

	public static void main(String[] args) {
		entities = new Entity[3];
		quest = new Entity[3];
		items = new Item[3];
		items[0] = Generator.nextMeleeWeapon(7);
		items[1] = Generator.nextMeleeWeapon(1);
		items[2] = Generator.nextMeleeWeapon(4);
		start();
		entities[1] = new Enemy("Goblin", 1, 1, 1, 1, "Goblin");
		entities[2] = new Enemy("Troll", 1, 1, 1, 1, "Troll");
		map[0][0] = new Environment("Forest", entities, items, "Small");
		System.out.println("Command Please");
		String x = scan.nextLine();
		recog(x);

		// for (int i = 0; i < map.length; i++) {
		// for (int j = 0; j < map[0].length; j++) {
		// map[i][j] = nextRegion();
		// }
		// }
		// for (int i = 0; i < map.length; i++) {
		// for (int j = 0; j < map[0].length; j++) {
		// println("Area: " + i + j + " " + map[i][j].toString());
		// }
		// }

	}

	public static void start() {
		println("Welcome to Zoraka!");
		println("What is your hero's name?");
		String x = scan.nextLine();
		println("What Class would you like to be");
		println("Knight, Rogue, Mage");
		String y = scan.nextLine();
		Hero = new Player(x, 250, 100, 10, 2, y);
		entities[0] = Hero;
		quest[0] = Hero;
		Boss = new Boss(999, 300, 20, 15);
		Boss_Room = new Environment("Tower", entities, items, "small");
		Treasure_Room = new Environment("Treasure Room", quest, Treasure,
				"small");
		Quest_Room = new Environment("Bar", quest, Empty, "small");
		map = new Environment[2][2];
	}

	public static void drop(String x) {
		// Hero.drop(x);
		System.out.print("drop");
	}

	public static void recog(String x) {
		int end = 0, end1 = 0, l = 0, count = 0, start = 0, s = 0;
		x += " ";
		for (int i = 0; i < x.length(); i++) {
			if ((int) x.charAt(i) == 32) {
				s++;
			}
		}
		String[] words = new String[s];
		for (int i = start; i < x.length(); i++) {
			for (int j = start + 1; j < x.length(); j++) {
				if (l < x.length() - 1) {
					if ((int) x.charAt(j) == 32) {
						if (count % 2 == 0) {
							end = j;
							words[count] = x.substring(end1, end);
							System.out.println(words[count]);
							count++;
						} else {
							end1 = j;
							words[count] = x.substring(end + 1, end1);
							System.out.println(words[count]);
							count++;
						}
						l += words[count - 1].length();
					}
				}
			}
			if (end > end1) {
				start = end;
			} else {
				start = end1;
			}
		}
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
		// tells engine what commands to execute based on entered text
		switch (words[0]) {
		// Error out of bounds if no second word
		case "go":
			if (words[1] != null) {
				switch (words[1]) {
				case "n":
					// moveN(map[locR][locC + 1], items, entities);
					System.out.println("north");
					break;
				case "e":
					// moveE(map[locR + 1][locC], items, entities);
					System.out.println("east");
					break;
				case "s":
					// moveS(map[locR][locC - 1], items, entities);
					System.out.println("south");
					break;
				case "w":
					// moveW(map[locR - 1][locC], items, entities);
					System.out.println("west");
					break;
				}
			} else {
				another(0);
			}
			break;
		case "take":
			for (int i = 0; i < items.length; i++) {
				if (items[i].getName().equalsIgnoreCase(words[1])) {
					if (items[i] != null) {
						Hero.addToInven(items[i]);
						items[i] = null;
					}
				}
			}
			another(1);
			break;
		case "stats":
			// players health
			break;
		case "drop":
			// drop(word2);
			System.out.print("drop");
			break;
		case "look":
			System.out.println(map[0][0].toString());
			for (int i = 0; i < items.length; i++) {
				if (items[i] != null) {
					System.out.println("There is " + items[i].toString()
							+ "on the ground");
				}
			}
			another(1);
			break;
		case "quit":
			System.exit(0);
			System.out.print("quit");
			break;
		case "open":
			// open(word2);
			System.out.print("open");
			break;
		case "i":
			openI();
			another(1);
			break;
		case "attack":
			int a = 0;
			for (int i = 1; i < entities.length; i++) {
				for (int j = 0; j < words.length; j++) {
					if (entities[i] != null) {
						if (entities[i].getName().equalsIgnoreCase(words[j])) {
							a = i;
							break;
						}
					}
				}
			}
			fight(Hero, (Enemy) entities[a]);
			another(1);
			break;
		case "fight":
			int q = 0;
			for (int i = 1; i < entities.length; i++) {
				for (int j = 0; j < words.length; j++) {
					if (entities[i] != null) {
						if (entities[i].getName().equalsIgnoreCase(words[j])) {
							q = i;
							break;
						}
					}
				}
			}
			fight(Hero, (Enemy) entities[q]);
			another(1);
			break;
		case "use":
			// use();
			System.out.print("use");
			break;
		case "heal":
			heal(Hero);
			System.out.print("heal");
			another(1);
			break;
		default:
			System.out.println("That would not be wise");
			words = new String[s];
			another(1);
			break;
		}
	}

	public static void another(int x) {
		if (x == 0) {
			System.out
					.println("Error:/|{^<]_[>^}|\\:Cannot compute:/|{^<]_[>^}|\\:Please Re-Enter Command");
		}
		String w = scan.nextLine();
		recog(w);
	}

	public static void openI() {
		for (int i = 0; i < Hero.getInventory().length; i++) {
			System.out.println(Hero.inventory[i]);
		}
	}

	public static void fight(Player x, Enemy y) {
		if (x.getRace().equalsIgnoreCase("knight")
				|| x.getRace().equalsIgnoreCase("admin")) {
			x.setHealth(x.getHealth()
					- (y.getDamage() - (int) (y.getDamage() * .15)));
		} else {
			x.setHealth(x.getHealth() - y.getDamage());
		}
		if (x.getRace().equalsIgnoreCase("rogue")
				|| x.getRace().equalsIgnoreCase("admin")) {
			int a = (int) (Math.random() * 100);
			if (a <= 15) {
				y.setHealth(y.getHealth() - (x.getDamage() * 2));
			} else {
				y.setHealth(y.getHealth() - x.getDamage());
			}
		}
		y.setHealth(y.getHealth() - x.getDamage());
	}

	public static void heal(Player x) {
		if (x.getRace().equalsIgnoreCase("mage")
				|| x.getRace().equalsIgnoreCase("admin")) {
			x.setHealth(x.getHealth() + 10);
		} else {
			System.out.println("That would not be wise");
		}
	}

	public static void heal(Player y, Food x) {
		y.setHealth(y.getHealth() + x.getBoostTotal());
	}

	public static void moveN(Environment x, Item[] items, Entity[] entities) {
		System.out.print("move N");
	}

	public static void moveS(Environment x, Item[] items, Entity[] entities) {
		System.out.print("move S");
	}

	public static void moveE(Environment x, Item[] items, Entity[] entities) {
		System.out.print("move E");
	}

	public static void moveW(Environment x, Item[] items, Entity[] entities) {
		System.out.print("move W");
	}

	public static void print(String x) {
		System.out.print(x);
	}

	public static void println(String x) {
		System.out.println(x);
	}
}