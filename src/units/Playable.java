package units;

import java.util.HashMap;

import framework.RandomGen;
import items.Wearable;

public abstract class Playable extends Unit {
	private HashMap<String, Wearable> equipments = new HashMap<>();

	public Playable(String name, int hp, int sp, int power, int speed) {
		super(name, hp, sp, power, speed);
		RandomGen ran = RandomGen.getInstance();
		this.hp += ran.get(0, 100);
		this.maxHp = this.hp;
		this.sp += ran.get(0, 50);
		this.maxSp = this.sp;
		this.power += ran.get(0, 20);
		this.speed += ran.get(0, 20);
		calcEquipStatus();
	}

	public void equip(Wearable equipment) {
		String part = equipment.getPart();
		Wearable oldEquip = equipments.get(part);
		if (oldEquip != null)
			oldEquip.setEquiped(false);

		equipments.put(part, equipment);
		calcEquipStatus();
	}

	private void calcEquipStatus() {
		attack = power;
		defense = 0;
		for (String part : equipments.keySet()) {
			Wearable equip = equipments.get(part);
			attack += equip.getAttack();
			defense += equip.getDefense();
		}

	}
	
	
}
