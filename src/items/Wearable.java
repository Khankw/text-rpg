package items;

import units.Playable;

public class Wearable extends Item {
	private int attack;
	private int defense;
	private Playable equippedUnit;

	public Wearable(int type, String name, int price, int attack, int defense) {
		super(type, name, price);
		this.attack = attack;
		this.defense = defense;
	}

	public boolean isEquiped() {
		return equippedUnit != null;
	}

	public Playable getEquippedUnit() {
		return equippedUnit;
	}

	public void setEquipped(Playable unit) {
		this.equippedUnit = unit;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(getName()).append("\n[공격력:").append(attack);
		str.append("][방어력:").append(defense).append("][가격:").append(getPrice()).append("]");
		return str.toString();
	}

	@Override
	public Wearable clone() {
		return new Wearable(getType(), getName(), getPrice() / 2, attack, defense);
	}
}
