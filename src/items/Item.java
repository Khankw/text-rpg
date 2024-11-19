package items;

import framework.Output;

abstract public class Item {
	protected Output out = Output.getInstance();

	private int type;
	private String name;
	private int price;

	public Item(int type, String name, int price) {
		this.type = type;
		this.name = name;
		this.price = price;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	abstract public Item clone();
}
