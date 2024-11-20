package units;

import java.util.HashMap;

import items.Wearable;

public abstract class Playable extends Unit {
	private HashMap<Integer, Wearable> equipments = new HashMap<>();

	public Playable(String name, int hp, int sp, int power, int speed) {
		super(name, hp, sp, power, speed);
	}

	public String equipmentsToSting() {
		String[] parts = { "무기", "갑옷" };
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= 2; i++) {
			str.append(i).append(") ").append("[").append(parts[i - 1]).append("]----------------------\n");
			Wearable item = equipments.get(i);
			if (item == null)
				str.append("미착용\n");
			else
				str.append(item.toString()).append("\n");
		}
		str.append("------------------------------");

		return str.toString();
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
