
public class keyItem extends Item{
	private String usedOn;
	public keyItem(String Name, int Weight, String Color, int Durability, String usedOn) {
		super(Name, Weight, Color, Durability, "Key Item");
		setUsedOn(usedOn);
	}
	public String getUsedOn() {
		return usedOn;
	}
	public void setUsedOn(String usedOn) {
		this.usedOn = usedOn;
	}
	
}