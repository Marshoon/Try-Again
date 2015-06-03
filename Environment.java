import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Environment {
	private String Type, Size;
	private Entity[] Entities;
	private Item[] Items;

	public Environment(String type, Entity[] entities, Item[] items, String size) {
		setEntities(entities);
		setItems(items);
		setType(type, size);
	}

	public String getType() {
		return Type;
	}

	public void setType(String type, String size) {
		Type = type;
		Size = size;
	}

	public Entity[] getEntities() {
		return Entities;
	}

	public void setEntities(Entity[] entities) {
		Entities = entities;
	}

	public Item[] getItems() {
		return Items;
	}

	public void setItems(Item[] items) {
		Items = items;
	}

	public String onGround() {
		String r = "";
		for (int i = 0; i < Items.length; i++) {
			if (Items[i] != null) {
				r += Items[i].toString() + " ";
				if (i < Items.length - 1) {
					r += ", \n";
				}
			}
		}
		return r;
	}

	public String toString() {
		return "A " + Size + " " + Type + " lies before you.";
	}

	public String toStringX() {

		String Ent = "";
		for (int i = 0; i < Entities.length; i++) {
			if (Entities[i] != null) {
				Ent += Entities[i].getName() + " ";
			}
		}
		if (Ent.length() == 0 && getItems().length == 0) {
			return "A "
					+ Size
					+ " "
					+ Type
					+ " lies before you. There are no Enemies or Items in the area.";
		} else if (Ent.length() != 0 && getItems().length == 0) {
			return "A " + Size + " " + Type + " lies before you. Within are "
					+ Ent;
		} else if (Ent.length() == 0 && getItems().length != 0) {
			return "A " + Size + " " + Type
					+ " lies before you. \n On the ground are " + onGround();
		} else {
			return "A " + Size + " " + Type + " lies before you. Within are "
					+ Ent + "\n On the ground are " + onGround();
		}
	}
}