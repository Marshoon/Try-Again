
public class Player extends Entity{
	public static int Damage;
	private String Race;
	private static int rowLoc = 0, colLoc = 0;
	public final int h, bs;
	public Player(String name, int weight, int health, int inventory, int damage, String race) {
		super(name, weight, health, inventory);
		h = health;
		bs = damage;
		setDamage(damage);
		setRace(race);
	}
	public int getDamage() {
		return Damage;
	}
	public void setDamage(int damage) {
		Damage = damage;
	}
	public String getRace() {
		return Race;
	}
	public void setRace(String race) {
		Race = race;
	}
	public static int getCurrentR(){
		return rowLoc;
	}
	public static int getCurrentC(){
		return colLoc;
	}
	public static void setCurrentR(int x){
		rowLoc = x;
	}
	public static void setCurrentC(int x){
		colLoc = x;
	}
//	public String toString(){
//		return getName() + " is a " + getRace() + " with a base damage of " + getDamage() + " and a total health of " + getHealth() + " and " + getInventory() + " inventory spaces";
//	}
	@Override
	public String toString(){
		return getName() + " - " +  getDamage() + " has " + getHealth() + " health " + getInventory().length + " inventory spaces";
	}
}
