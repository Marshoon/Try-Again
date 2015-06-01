
public class Food extends Item {
	private int boostTotal;
	public Food(String Name, int Weight, String Color, int Durability, int hpBoost) {
		super(Name, Weight, Color, Durability);
		setBoostTotal(hpBoost);
	}
	public int getBoostTotal() {
		return boostTotal;
	}
	public void setBoostTotal(int boostTotal) {
		this.boostTotal = boostTotal;
	}
	
}
