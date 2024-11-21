package textrpg;

import java.util.ArrayList;

import framework.*;
import items.*;
import units.Playable;

public class Player {
	private final int MAXUNITS = 20;
	private final int MAXPARTY = 5;
	private final int MAXITEMS = 50;

	private Output out = Output.getInstance();

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

		if (unit != null)
			unit.setBonus((MAXPARTY - partyNum) * 5, (partyNum + 1) * 5);
		party.set(partyNum, unit);
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public Item sellItem(int index) {
		Item item = items.get(index);
		if (item instanceof Wearable) {
			Wearable wearable = (Wearable) item;
			Playable unit = wearable.getEquippedUnit();
			if (unit != null)
				unit.unequip(item.getType());
		}

		items.remove(index);
		return item;
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

	public boolean hasPartyUnit() {
		for (int i = 0; i < MAXPARTY; i++)
			if (party.get(i) != null)
				return true;
		return false;
	}

	public boolean hasPartyUnit(int index) {
		return party.get(index) != null;
	}

	public boolean isMaxUnit() {
		return units.size() == MAXUNITS;
	}

	public int getItemsSize() {
		return items.size();
	}

	public boolean isMaxItem() {
		return items.size() == MAXITEMS;
	}

	public int getWearableItemSize() {
		int cnt = 0;
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if (item instanceof Wearable)
				cnt++;

		}
		return cnt;
	}

	public void subtractMoney(int money) {
		this.money -= money;
	}

	public void addMoney(int money) {
		this.money += money;
	}

	public void showInfo() {
		out.clear();
		out.add("[현금:").add(money).add("][보유용병:");
		out.add(units.size()).add("/").add(MAXUNITS).add("][보유아이템:");
		out.add(items.size()).add("/").add(MAXITEMS).println("]");
	}

	public void showUnits() {
		out.clear();
		for (int i = 0; i < units.size(); i++) {
			Playable unit = units.get(i);
			boolean isParty = party.contains(unit);
			if (isParty)
				out.add(i + 1, IndexColor.BLACK, IndexColor.BRIGHTCYAN);
			else
				out.add(i + 1, IndexColor.BLACK, IndexColor.WHITE);
			out.add(") ").add(unit);
			if (isParty)
				out.add(" <<<파티중");
			out.reset().add("\n------------------------------\n");
		}
		out.print();
	}

	public void showParty() {
		out.clear();
		for (int i = 0; i < MAXPARTY; i++) {
			out.add(i + 1).add("번째 용병----------------------\n");
			Playable unit = party.get(i);
			if (unit == null)
				out.add("빈슬롯", IndexColor.BLACK, IndexColor.WHITE);
			else
				out.add(unit, IndexColor.BLACK, IndexColor.BRIGHTCYAN);
			out.reset().add("\n");
		}
		out.println("------------------------------");
	}

	public void showItems() {
		out.clear();
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			boolean isEquipped = false;
			if (item instanceof Wearable) {
				Wearable wearable = (Wearable) item;
				isEquipped = wearable.isEquiped();

			}
			if (isEquipped)
				out.add(i + 1, IndexColor.BLACK, IndexColor.BRIGHTGREEN).add(")[착용중]").add(item);
			else
				out.add(i + 1, IndexColor.BLACK, IndexColor.WHITE).add(") ").add(item);
			out.reset().add("\n------------------------------\n");
		}
		out.print();
	}

	public void showWearableItems() {
		out.clear();
		int num = 1;
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if (item instanceof Wearable) {
				Wearable wearable = (Wearable) item;
				if (wearable.isEquiped())
					out.add(num++, IndexColor.BLACK, IndexColor.BRIGHTGREEN).add(")[착용중]").add(item);
				else
					out.add(num++, IndexColor.BLACK, IndexColor.WHITE).add(") ").add(item);
				out.reset().add("\n------------------------------\n");
			}
		}
		out.print();
	}

	public void showUnitEquip(int index) {
		Playable unit = party.get(index);
		if (unit == null)
			return;
		out.clear();
		out.add(unit).add("\n").println(unit.equipmentsToSting());
	}

	public boolean unitEquip(int slot, int itemIdx) {
		Item item = null;
		int num = 1;
		for (int i = 0; i < items.size(); i++) {
			item = items.get(i);
			if (item instanceof Wearable && itemIdx == num++)
				break;
		}

		Wearable wearable = (Wearable) item;
		if (wearable.isEquiped())
			wearable.getEquippedUnit().unequip(wearable.getType());

		Playable unit = party.get(slot);
		unit.equip(wearable);
		return true;
	}
}
