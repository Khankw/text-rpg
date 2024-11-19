package textrpg;

import java.util.ArrayList;
import java.util.HashMap;

import units.Playable;

public class Player {
	private final int MAXUNITS = 20;
	private final int MAXPARTY = 5;

	private int money;

	private ArrayList<Playable> units = new ArrayList<>();
	private HashMap<Integer, Playable> party = new HashMap<>();

	public Player() {
		this.money = 1500;
		for (int i = 1; i <= MAXPARTY; i++) {
			party.put(i, null);
		}
	}

	public void putParty(int index, Playable unit) {
		if (index < 1 || index > MAXPARTY)
			return;

		party.put(index, unit);
	}

	public void removeParty(int index) {
		if (index < 1 || index > MAXPARTY)
			return;

		party.put(index, null);
	}

	public int getMoney() {
		return money;
	}

	public void subtractMoney(int money) {
		this.money -= money;
	}

	public void addMoney(int money) {
		this.money += money;
	}
}
