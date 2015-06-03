public class Engine extends Etc {
	private static Enemy Boss;
	private static Entity[] boss;
	private static Entity[] quest;
	private static Item[] Empty;
	private static Item[] Treasure;
	private static Item[] boss_items;
	public static Environment[][] map;
	private static Environment Boss_Room;
	private static Environment Treasure_Room;
	private static Environment Quest_Room;
	public static GUI gameWindow;

	public static void main(String[] args) {
		GUI gameWindow = new GUI();
		gameWindow.frmWelcome.setVisible(true);
		quest = new Entity[3];
		start();
		map[0][0] = Generator.nextRegion();
		System.out.println("Welcome to Zoraka!");
		System.out.println(map[0][0].toString());
		Item[] temp = new Item[map[Player.getCurrentR()][Player.getCurrentC()]
				.getItems().length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Generator.nextRegion();
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				println("Area: " + i + "-" + j + " " + map[i][j].toString());
			}
		}

	}

	public static void start() {
		Boss = new Boss(999, 300, 20, 15);
		Boss_Room = new Environment("Tower", boss, boss_items, "small");
		Treasure_Room = new Environment("Treasure Room", quest, Treasure,
				"small");
		Quest_Room = new Environment("Bar", quest, Empty, "small");
		map = new Environment[5][5];
	}

	public static void drop(String x) {
		gameWindow.Hero.drop(x);
	}

	public static String recog(String x) {
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
							count++;
						} else {
							end1 = j;
							words[count] = x.substring(end + 1, end1);
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

		Item[] temp = map[Player.getCurrentR()][Player.getCurrentC()]
				.getItems();
		// tells engine what commands to execute based on entered text
		switch (words[0]) {
		// Error out of bounds if no second word
		case "":
			return "";
		case "go":
			if (words[1] != null) {
				switch (words[1]) {
				case "n":
					// moveN(map[locR][locC + 1]);
					return ("north");
				case "e":
					// moveE(map[locR + 1][locC]);
					return ("east");
				case "s":
					// moveS(map[locR][locC - 1]);
					return ("south");
				case "w":
					// moveW(map[locR - 1][locC]);
					return ("west");
				}
			} else {
				// another(0);
			}
			break;
		case "take":
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].getName().equalsIgnoreCase(words[1])) {
					if (temp[i] != null) {
						gameWindow.Hero.addToInven(temp[i]);
						String thing = ("you pick up the" + temp[i].getName());
						temp[i] = null;
						return thing;
					}
				}
			}
			// another(1);
			break;
		case "stats":
			return (gameWindow.Hero.toString());
		case "drop":
			// drop(word[1]);
			return ("drop");
		case "look":
			return (map[gameWindow.Hero.getCurrentC()][gameWindow.Hero
					.getCurrentR()].toStringX());
		case "quit":
			System.exit(0);
			break;
		case "open":
			// open(word[1]);
			return ("open");
		case "attack":
			return "";
		case "fight":
			return "";			
		case "use":
			// use();
			System.out.print("use");
			break;
		case "heal":
			heal(gameWindow.Hero);
			System.out.print("heal");
			// another(1);
			break;
		case "talk":
			// talk(words[2]);
			System.out.print("talk");
			break;
		default:
			words = new String[s];
			return ("That would not be wise");
		}
		return x;
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

	public static void moveN(Environment x) {
		System.out.print("move N");
	}

	public static void moveS() {
		System.out.print("move S");
	}

	public static void moveE() {
		System.out.print("move E");
	}

	public static void moveW() {
		System.out.print("move W");
	}

	public static void print(String x) {
		System.out.print(x);
	}

	public static void println(String x) {
		System.out.println(x);
	}
}