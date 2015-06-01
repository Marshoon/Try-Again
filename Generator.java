import java.util.Random;

public class Generator {
	public static Weapon nextMeleeWeapon(int rarity) {
		Random gen = new Random();
		String[] itemNames = {"Sword of the Covenant", "Mystical Axe", "Mystical Sword", "Axe",
				"Sword", "Sharp Axe", "Sharp Sword", "Heavy Axe", "Heavy Sword",
				"Woodcutters Axe", "Cleaver", "Shovel", " Wooden Sword", "Telescope",
				"Cane", "Umbrella", "Swatter", "Pan", "Ladle", "Plank", "Stick",
				"Bread Loaf", "Shoe", "Whig"};

		int[] itemRarity = {7, 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0};

		String[] phase2 = new String[8];
	

		int j = 0;

		for (int i = 0; i < itemRarity.length; i++) {
			if (itemRarity[i] == rarity) {
				phase2[j] = (itemNames[i]);
				j++;
			}
		}

		
		String name = phase2[gen.nextInt(j)];

		String[] itemColors = {"Red", "Green", "Blue", "Yellow", "Molten Red", "Crystalline Green", "Dripping Blue", "Glowing Yellow"};

		String color = itemColors[gen.nextInt(itemColors.length)];
		
		int damage = gen.nextInt((rarity + 3) - rarity) + rarity;
		
		int durability = gen.nextInt((rarity * 3) - rarity) + rarity;
		
		Weapon newWeapon = new Weapon(name, rarity + 1, color, durability, damage, rarity);
		
		return newWeapon;
	}
	
	public static Weapon nextRangedWeapon(int rarity) {
		Random gen = new Random();
		String[] itemNames = {"Leaf","Clod","Fruit","Pastry",
							"Stone","Rock","Shortbow","Slingshot",
							"Throwing Knife","Longbow","Sling","Throwing Axe",
							"Heavy Bow","Light Crossbow","Mastercraft Bow","Scorpio",
							"Mystical Bow","Mystical Crossbow","Etrayu"};

		int[] itemRarity = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7};

		String[] phase2 = new String[8];
		

		int j = 0;

		for (int i = 0; i < itemRarity.length; i++) {
			if (itemRarity[i] == rarity) {
				phase2[j] = (itemNames[i]);
				j++;
			}
		}

		
		String name = phase2[gen.nextInt(j)];

		String[] itemColors = {"Red", "Green", "Blue", "Yellow", "Molten Red", "Crystalline Green", "Dripping Blue", "Glowing Yellow"};

		String color = itemColors[gen.nextInt(itemColors.length)];
		
		int damage = gen.nextInt((rarity + 3) - rarity) + rarity;
		
		int durability = gen.nextInt((rarity * 3) - rarity) + rarity;
		
		Weapon newWeapon = new Weapon(name, rarity + 1, color, durability, damage, rarity);
		
		return newWeapon;
	}
	
	public static Environment nextRegion(String locale, Entity[] ent, Item[] items) {
		Random gen = new Random();
		String[] Types = {"Forest", "Lake", "Marsh", "Swamp", "Wheatfield", "Cave",};
    
		int[] itemRarity = {7,6,5,4,};

		String[] phase2 = new String[8];
	

		int j = 0;

		for (int i = 0; i < itemRarity.length; i++) {
			if (Types[i] == locale) {
				phase2[j] = (Types[i]);
				j++;
			}
		}
		String size = "";
		int l =(int) Math.random() * 100;
		if (l <= 50) {
			size = "Small";
		} else if (l > 50 && l <= 75) {
			size = "Average";
		} else if (l > 75 && l <= 80) {
			size = "Large";
		} else if (l > 80 && l <= 92) {
			size = "Huge";
		} else {
			size = "Massive";
		}
		String name = phase2[gen.nextInt(j)];

		String[] itemColors = {"Red", "Green", "Blue", "Yellow", "Molten Red", "Crystalline Green", "Dripping Blue", "Glowing Yellow"};

		String color = itemColors[gen.nextInt(itemColors.length)];
		
		Environment newRegion = new Environment(phase2[j],ent,items,size);
		
		return newRegion;
		
	}
	
	public static Enemy nextEnemy(int rank) {
		Random gen = new Random();
		String[] enemyNames = {"A Cave Troll", "A Dark Mage", "A Possessed Villager", "An Undead Villager", "An Oruk Cultist", "A Queen Spider", "A Large Spider", "A Grisled Thief"};

		int[] enemyRank = {7, 6, 5, 4, 3, 2, 1, 0};

		String[] phase2 = new String[1];
	

		int j = 0;

		for (int i = 0; i < enemyRank.length ; i++) {
			if (enemyRank[i] == rank) {
				phase2[j] = (enemyNames[i]);
				j++;
			}
		}


		

		
		String name = phase2[gen.nextInt(j)];

		String[] enemyDesc = {"Breathing heavily", "Staring into your eyes", "Hungry", "Angry"};
		
		String description = enemyDesc[gen.nextInt(enemyDesc.length)];
		
		int damage = gen.nextInt((rank + 3) - rank) + rank;
		
		int weight = gen.nextInt(((rank * 3) + 3) - rank) + rank;
		
		int health = gen.nextInt((rank * 3) - rank) + rank;
		
		int inventory = gen.nextInt(3) + 1;
		
		Enemy newEnemy = new Enemy(name, weight, health, inventory, damage, description);
		
		return newEnemy;
	}
}

