public class Weapon extends Item {
	private int damage;
	private int rarity;
	public Weapon(String Name, int Weight, String Color, int Durability, int Damage, int Rarity) {
		super(Name, Weight, Color, Durability, "Weapon");
		setDamage(Damage);
		setRarity(Rarity);
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	@Override
//	public String toString(){
//		return "A " + super.getColor() + " " + super.getName() + " with damage of " + damage + " and a durability of " + super.getDura() + ".";
//	}
	public String toString(){
		return super.getName() + " - " + damage + " - " + super.getDura();
	}
}