public class Enemy extends Entity {
	private int Damage;
	private String Race;

	public Enemy(String name, int weight, int health, int inventory,
			int damage, String race) {
		super(name, weight, health, inventory);
		setDamage(damage);

	}

	public void sethealth(int x) {
		health -= x;
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
	public boolean isEnemy(){
		return true;
	}
	@Override
	public String toString(){
		return super.getName() + " - " + getDamage() + " - " + getHealth();
	}
}