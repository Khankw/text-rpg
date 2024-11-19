package items;

import units.Unit;

public class Potion extends Item {
	private int healPoint;
	private boolean isResurrection;

	public Potion(int type, String name, int price, int healPoint, boolean isResurrection) {
		super(type, name, price);
		this.healPoint = healPoint;
		this.isResurrection = isResurrection;
	}

	public boolean use(Unit unit) {
		if (unit.isDie() && !isResurrection)
			return false;

		unit.healing(healPoint);
		return true;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(getName()).append("\n[회복량:").append(healPoint).append("][기능:");
		if (isResurrection)
			str.append("사망자소생");
		else
			str.append("회복(사망자제외)");
		str.append("][가격:").append(getPrice()).append("]");
		return str.toString();
	}

	@Override
	public Potion clone() {
		return new Potion(getType(), getName(), getPrice() / 2, healPoint, isResurrection);
	}
}
