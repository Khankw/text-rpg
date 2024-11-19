package units;

import java.util.HashMap;

import items.Wearable;

public abstract class Playable extends Unit {
	private HashMap<Integer, Wearable> equipments = new HashMap<>();

	public Playable(String name, int hp, int sp, int power, int speed) {
		super(name, hp, sp, power, speed);
	}

	public void equip(Wearable equipment) {
		int type = equipment.getType();
		unequip(type);

		equipments.put(type, equipment);
		attack += equipment.getAttack();
		defense += equipment.getDefense();
		equipment.setEquipped(this);
	}

	public void unequip(int type) {
		Wearable equip = equipments.get(type);
		if (equip == null)
			return;

		equipments.put(type, null);
		attack -= equip.getAttack();
		defense -= equip.getDefense();
		equip.setEquipped(null);
	}
}
