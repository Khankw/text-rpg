package items;

abstract public class Item {
	private int type;
	private String name;
	private int price;

	public Item(int type, String name, int price) {
		this.type = type;
		this.name = name;
		this.price = price;
	}
}
