
public class Item implements Rules{
	private String name;
	private int weight;
	private String color;
	private int dura;
	private String type;
	/**
	 * Constructs an item with a <Strong>String</Strong> Name, an <Strong>Int</Strong> Weight, a <Strong>String</Strong> Color, and an <Strong>Int</Strong> Durability.
	 * @param Name : Name of item
	 * @param Weight : determines ability to pick up
	 * @param Color : drop option + quest turn-ins
	 * @param Durability : number of uses
	 */
	// Constructor for Items
	public Item (String Name, int Weight, String Color, int Durability, String type){
		name = Name;
		weight = Weight;
		color = Color;
		dura = Durability;
		this.type = type;
	}
	/**
	 * @return Returns the items name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return Returns the weight of the item.
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @return Returns the color of an item.
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @return Returns the amount of durability an item has.
	 */
	public int getDura() {
		return dura;
	}
	/**
	 * @param Takes an <Strong>Int</Strong> Value to set durability to.
	 */
	public void setDura(int x) {
		dura = x;
	}
	public String getType(){
		return type;
	}
}