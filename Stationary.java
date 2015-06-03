
public class Stationary extends Item {
	private String reaction;
	public Stationary(String Name, String Reaction) {
		super(Name, 999, "Black", 9999, "Stationary");
		setReaction(Reaction);		
	}
	public String getReaction() {
		return reaction;
	}
	public void setReaction(String reaction) {
		this.reaction = reaction;
	}

}
