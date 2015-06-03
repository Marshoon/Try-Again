import java.util.Random;

public class Generator {
	public static Weapon nextMeleeWeapon(int rarity) {
		Random gen = new Random();
		String[] itemNames = { "Sword of the Covenant", "Mystical Axe",
				"Mystical Sword", "Axe", "Sword", "Sharp Axe", "Sharp Sword",
				"Heavy Axe", "Heavy Sword", "Woodcutters Axe", "Cleaver",
				"Shovel", " Wooden Sword", "Telescope", "Cane", "Umbrella",
				"Swatter", "Pan", "Ladle", "Plank", "Stick", "Bread Loaf",
				"Shoe", "Whig" };

		int[] itemRarity = { 7, 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1,
				1, 1, 1, 1, 0, 0, 0 };

		String[] phase2 = new String[8];

		int j = 0;

		for (int i = 0; i < itemRarity.length; i++) {
			if (itemRarity[i] == rarity) {
				phase2[j] = (itemNames[i]);
				j++;
			}
		}

		String name = phase2[gen.nextInt(j)];

		String[] itemColors = { "Red", "Green", "Blue", "Yellow", "Molten Red",
				"Crystalline Green", "Dripping Blue", "Glowing Yellow" };

		String color = itemColors[gen.nextInt(itemColors.length)];

		int damage = gen.nextInt((rarity + 3) - rarity) + rarity;

		int durability = gen.nextInt(10) + 1;
//		int durability = gen.nextInt((rarity * 3) - rarity) + rarity;

		Weapon newWeapon = new Weapon(name, rarity + 1, color, durability,
				damage, rarity);

		return newWeapon;
	}
	public static Food nextFood() {
		Random gen = new Random();
		String[] FoodNames = {"Bread", "Steak", "Potato", "Carrot", "Cake"};

		String name = FoodNames[gen.nextInt(4)];

		String[] itemColors = { "Red", "Green", "Blue", "Yellow", "Molten Red",
				"Crystalline Green", "Dripping Blue", "Glowing Yellow" };

		String color = itemColors[gen.nextInt(itemColors.length)];
		int hpBoost = gen.nextInt(5) + 1;
		int durability = gen.nextInt(3) + 1;
//		int durability = gen.nextInt((rarity * 3) - rarity) + rarity;

		Food newFood = new Food(name, 1, "White", durability, hpBoost);

		return newFood;
	}

	public static Weapon nextRangedWeapon(int rarity) {
		Random gen = new Random();
		String[] itemNames = { "Leaf", "Clod", "Fruit", "Pastry", "Stone",
				"Rock", "Shortbow", "Slingshot", "Throwing Knife", "Longbow",
				"Sling", "Throwing Axe", "Heavy Bow", "Light Crossbow",
				"Mastercraft Bow", "Scorpio", "Mystical Bow",
				"Mystical Crossbow", "Etrayu" };

		int[] itemRarity = { 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6,
				6, 7 };

		String[] phase2 = new String[8];

		int j = 0;

		for (int i = 0; i < itemRarity.length; i++) {
			if (itemRarity[i] == rarity) {
				phase2[j] = (itemNames[i]);
				j++;
			}
		}

		String name = phase2[gen.nextInt(j)];

		String[] itemColors = { "Red", "Green", "Blue", "Yellow", "Molten Red",
				"Crystalline Green", "Dripping Blue", "Glowing Yellow" };

		String color = itemColors[gen.nextInt(itemColors.length)];

		int damage = gen.nextInt((rarity + 3) - rarity) + rarity;

		int durability = gen.nextInt(100);
		// int durability = gen.nextInt((rarity * 3) - rarity) + rarity;

		Weapon newWeapon = new Weapon(name, rarity + 1, color, durability,
				damage, rarity);

		return newWeapon;
	}

	public static Environment nextRegion() {
		String[] Types = { "Forest", "Lake", "Marsh", "Swamp", "Wheatfield",
				"Cave", "Plain", "Mountain" };

		String name = Types[(int)(Math.random() * 7)];
		String size = "";
		int l = ((int) (Math.random() * 100)) + 1;
		int q = 0;
		if (l <= 50) {
			size = "Small";
			q = 1;
		} else if (l > 50 && l <= 75) {
			size = "Average";
			q = 2;
		} else if (l > 75 && l <= 80) {
			size = "Large";
			q = 3;
		} else if (l > 80 && l <= 92) {
			size = "Huge";
			q = 4;
		} else {
			size = "Massive";
			q = 5;
		}
		Item[] items = new Item[q];
		int c = 0;
		for (int i = 0; i < q; i++) {
		int u = ((int)(Math.random() * 100)) + 1;
		if (u <= 10) {
			c = 0;
		} else if (u > 10 && u <= 40) {
			c = 1;
		} else if (u > 40 && u <= 60) {
			c = 2;
		} else if (u > 60 && u <= 75) {
			c = 3;
		} else if (u > 75 && u <= 85) {
			c = 4;
		} else if (u > 85 && u <= 93) {
			c = 5;
		} else if (u > 93 && u <= 99) {
			c = 6;
		} else {
			c = 7;
		}
		int g = (int)(Math.random() * 2);
			if (g == 0) {
				items[i] = null;
			} else if (g == 1) {
				items[i] = nextMeleeWeapon(c);
			} else {
				items[i] = nextRangedWeapon(c);
			}
		}
		Entity[] ent = new Entity[2];
		int v = 0;
		for (int i = 0; i < ent.length; i++) {
			int u = ((int)(Math.random() * 100)) + 1;
			if (u <= 12) {
				v = 0;
			} else if (u > 12 && u <= 24) {
				v = 1;
			} else if (u > 24 && u <= 52) {
				v = 2;
			} else if (u > 52 && u <= 71) {
				v = 3;
			} else if (u > 71 && u <= 86) {
				v = 4;
			} else if (u > 86 && u <= 94) {
				v = 5;
			} else if (u > 94 && u <= 99) {
				v = 6;
			} else {
				v = 7;
			}
			int g = (int)(Math.random() * 2);
			if (g == 0) {
				ent[i] = null;
			} else if (g == 1) {
				ent[i] = nextEnemy(v);
			} else {
				ent[i] = nextNPC(v, (int) (Math.random() * 1));
			}
		}

		Environment newRegion = new Environment(name, ent, items, size);

		return newRegion;

	}

	public static Enemy nextEnemy(int rank) {
		Random gen = new Random();
		String[] enemyNames1 = { "A Cave Troll", "A Dark Mage",
				"A Possessed Villager", "An Undead Villager",
				"An Oruk Cultist", "A Queen Spider", "A Large Spider",
				"A Grisled Thief" };

		int[] enemyRank = { 7, 6, 5, 4, 3, 2, 1, 0 };

		String[] phase2 = new String[1];

		int j = 0;

		for (int i = 0; i < enemyRank.length; i++) {
			if (enemyRank[i] == rank) {
				phase2[j] = (enemyNames1[i]);
				j++;
			}
		}

		String name = phase2[gen.nextInt(j)];

		String[] enemyDesc = { "Breathing heavily", "Staring into your eyes",
				"Hungry", "Angry", "Haggard" };

		String description = enemyDesc[gen.nextInt(enemyDesc.length)];

		int damage = gen.nextInt((rank + 3) - rank) + rank;

		int weight = gen.nextInt(((rank * 3) + 3) - rank) + rank;

//		int health = gen.nextInt((rank * 3) - rank) + rank;
		int health = gen.nextInt(10) + 1;

		int inventory = gen.nextInt(3) + 1;

		Enemy newEnemy = new Enemy(name, weight, health, inventory, damage,
				description);

		return newEnemy;
	}

	/**
	 * @param Rank
	 *            = rank of NPC 7 = King/Queen,
	 * @param Gender
	 *            = Gender 0 = male 1 = female
	 */
	public static Entity nextNPC(int rank, int gender) {
		Random gen = new Random();
		String[] NPCNamesM = { "King", "Lord", "Duke", "Knight", "Shopkeeper",
				"Villager", "Mr.", "Beggar" };
		String[] NPCNamesF = { "Queen", "Lady", "Duchess", "Valkyrie",
				"Shopkeeper", "Villager", "Mrs.", "Beggar" };

		int[] NPCRank = { 7, 6, 5, 4, 3, 2, 1, 0 };

		String[] phase2 = new String[1];

		int j = 0;

		for (int i = 0; i < NPCRank.length; i++) {
			if (NPCRank[i] == rank) {
				if (gender == 0) {
					phase2[j] = (NPCNamesM[i]);
					j++;
				} else {
					phase2[j] = (NPCNamesF[i]);
					j++;
				}
			}
		}

		String[] NPCMale = { "Marth", "Cormag", "Hector", "Ike", "Erk", "Roy",
				"Ephraim" };
		String[] NPCFemale = { "Eirika", "Lucina", "Lyn", "Emmeryn",
				"Guinivere", "L'Arachel", "Lucia" };
		String description = "";
		if (gender == 0) {
			description = NPCMale[gen.nextInt(NPCMale.length)];
		} else {
			description = NPCFemale[gen.nextInt(NPCFemale.length)];
		}
		String name = phase2[gen.nextInt(j)] + " " + description;

		Entity newNPC = new Entity(name, 999, 999, 1);

		return newNPC;
	}
}
