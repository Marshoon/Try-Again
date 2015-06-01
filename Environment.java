
public class Environment {
	private String Type, Size;
	private Entity[] Entities;
	private Item[] Items;
	public Environment(String type, Entity[] entities, Item[] items, String size){
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

	public String toString() {
		String Ent = "";
		for (int i = 1; i < Entities.length; i++) {
			Ent += Entities[i].getName() + " ";
		}
		return "A " + Size + " " + Type + " lies before you. Within are " + Ent + ".";
	}
}