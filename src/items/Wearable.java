package items;

public class Wearable extends Item {
	private String part;
	private boolean isEquiped;
	private int attack;
	private int defense;

	public Wearable(int type, String name, int price, String part, int attack, int defense) {
		super(type, name, price);
		this.part = part;
		this.attack = attack;
		this.defense = defense;
	}

	public String getPart() {
		return part;
	}

	public boolean isEquiped() {
		return isEquiped;
	}

	public void setEquiped(boolean isEquiped) {
		this.isEquiped = isEquiped;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}
}
