package scenes;

import java.util.ArrayList;

import items.*;

public class Purchase extends Scene {
	private final int WEAPON = 1;
	private final int ARMOR = 2;
	private final int POTION = 3;

	private ArrayList<Item> weapons = new ArrayList<>();
	private ArrayList<Item> armors = new ArrayList<>();
	private ArrayList<Item> potions = new ArrayList<>();

	public Purchase() {
		weapons.add(new Wearable(WEAPON, "Dagger", 100, 10, 0));
		weapons.add(new Wearable(WEAPON, "Sword", 300, 20, 0));
		weapons.add(new Wearable(WEAPON, "Great Sword", 900, 30, 0));
		weapons.add(new Wearable(WEAPON, "Staff", 200, 15, 0));
		weapons.add(new Wearable(WEAPON, "Mace", 600, 25, 0));
		armors.add(new Wearable(ARMOR, "Cloth Armour", 200, 0, 10));
		armors.add(new Wearable(ARMOR, "Leather Armour", 400, 0, 15));
		armors.add(new Wearable(ARMOR, "Chain Mail", 800, 0, 20));
		armors.add(new Wearable(ARMOR, "Plate Armour", 1600, 0, 25));
		armors.add(new Wearable(ARMOR, "Full Plate Armour", 3200, 0, 30));
		potions.add(new Potion(POTION, "Light Potion", 100, 30, false));
		potions.add(new Potion(POTION, "Potion", 250, 60, false));
		potions.add(new Potion(POTION, "Strong Potion", 600, 90, false));
		potions.add(new Potion(POTION, "Full Potion", 1500, 120, false));
		potions.add(new Potion(POTION, "Resurrection Potion", 2000, 100, true));
	}

	@Override
	public void update() {
		setPlayer();
		printTitle("상품구매");
		player.showInfo();
		int sel = in.input("[1]무기 [2]갑옷 [3]물약 [0]뒤로", -1);

		if (sel == WEAPON) {
			printTitle("무기구매");
			purchaseItem(weapons);
		} else if (sel == ARMOR) {
			printTitle("갑옷구매");
			purchaseItem(armors);

		} else if (sel == POTION) {
			printTitle("포션구매");
			purchaseItem(potions);
		} else if (sel == EXIT)
			manager.changeScene("Store");

	}

	private void purchaseItem(ArrayList<Item> list) {
		if (player.isMaxItem()) {
			out.printErrln("아이템을 더 이상 구매할 수 없습니다.");
			return;
		}

		player.showInfo();

		int num = 1;
		for (Item item : list) {
			out.add(num, color.BLACK, color.WHITE).add(") ").add(item);
			out.reset().add("\n------------------------------\n");
			num++;
		}
		out.print();

		int sel = in.input("아이템 번호 입력", 0) - 1;

		if (sel < 0 || sel >= list.size())
			return;

		Item item = list.get(sel);
		if (item.getPrice() > player.getMoney()) {
			out.printErrln("금액이 부족합니다.");
			return;
		}

		player.addItem(item.clone());
		player.subtractMoney(item.getPrice());
		out.addReset("#### 구매완료 ####\n", color.CYAN, color.BRIGHTCYAN);
		out.add(item.getName(), color.CYAN).reset().println("를 구매하였습니다.");
	}
}
