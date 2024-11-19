package textrpg;

import java.util.ArrayList;

import items.Item;
import units.Playable;

public class Player {
	private final int MAXUNITS = 20;
	private final int MAXPARTY = 5;

	private int money;

	private ArrayList<Playable> units = new ArrayList<>();
	private ArrayList<Playable> party = new ArrayList<>();
	private ArrayList<Item> items = new ArrayList<>();

	public Player() {
		this.money = 1500;
		for (int i = 0; i < MAXPARTY; i++)
			party.add(null);

	}

	public void addUnit(Playable unit) {
		units.add(unit);
	}

	public void removeUnit(int index) {
		Playable unit = units.get(index);
		int idx = party.indexOf(unit);
		if (idx != -1)
			party.set(idx, null);
		units.remove(index);
	}

	public void setParty(int unitNum, int partyNum) {
		Playable unit = null;
		if (unitNum > -1)
			unit = units.get(unitNum);

		int idx = party.indexOf(unit);
		if (idx != -1)
			party.set(idx, null);

		party.set(partyNum, unit);
	}

	public int getMoney() {
		return money;
	}

	public String getUnitName(int index) {
		return units.get(index).getName();
	}

	public int getUnitsSize() {
		return units.size();
	}

	public void subtractMoney(int money) {
		this.money -= money;
	}

	public void addMoney(int money) {
		this.money += money;
	}

	public String unitsToString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < units.size(); i++) {
			Playable unit = units.get(i);
			str.append(i + 1).append(") ").append(unit);
			if(party.contains(unit))
				str.append(" <<<파티중");
			str.append("\n------------------------------");
			if (i < units.size() - 1)
				str.append("\n");
		}

		return str.toString();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[현금:").append(money).append("][보유용병:");
		str.append(units.size()).append("/").append(MAXUNITS).append("]\n");
		for (int i = 0; i < MAXPARTY; i++) {
			Playable unit = party.get(i);
			str.append(i + 1).append("번째 용병----------------------\n");
			if (unit == null)
				str.append("빈슬롯");
			else
				str.append(unit);
			str.append("\n");
		}
		str.append("------------------------------");

		return str.toString();
	}
}
