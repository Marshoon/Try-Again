// The main class for any "THING" in the game
public class Entity implements Rules_E {
	private String name;
	private int weight;
	public int health;
	public Item[] inventory;
	private int sizeI;
	private int count = 0;
	/**
	 * Constructs an Entity with <Strong>String</Strong> of Name <Strong>Int</Strong> of Weight <Strong>Int</Strong> of Health <Strong>Int</Strong> of total inventory slots.
	 * @param Name : The name of the entity
	 * @param Weight : Determines 
	 * @param Health : Hits until death
	 * @param Inventory : Number of items in inventory
	 */
	// Constructs Entities
	public Entity(String name, int weight, int health, int inventory) {
		this.name = name;
		this.weight = weight;
		this.health = health;
		sizeI = inventory;
		this.inventory = new Item [inventory];
	}
	/**
	 * @param takes a <Strong>String</Strong> x to Remove to inventory
	 */
	public String drop(String x){
		int start = 0;
		for (int i = 0; i < inventory.length; i++) {
			if (x.equalsIgnoreCase(inventory[i].getName())) {
				inventory[count] = null;
				start = i;
				break;
			}
		}
		for (int i = start; i < inventory.length; i++) {
			inventory[start - 1] = inventory[start];
		}
		count--;
		return (x + " was dropped");
	}
	/**
	 * @param takes a <Strong>String</Strong> x to add to inventory
	 */
	public void addToInven(Item x){
		inventory[count] = x;
		count++;
	}
	/**
	 * @return Returns the name of the Entity.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return Returns the current weight of the entity.
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @return Returns the Total health of the Entity.
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * @return Returns the total inventory slots for the Entity.
	 */
	public Item[] getInventory() {
		Item[] t = new Item[sizeI];
		for (int i = 0; i < inventory.length; i++) {
			t[i] = inventory[i];
		}
		return t;
	}
	/**
	 * @param Sets the Health to an int x.
	 */
	public void setHealth(int x) {
		health = x;
	}
	/**
	 * @param Sets the Weight to an int x.
	 */
	public void setWeight(int x) {
		weight = x;
	}
}