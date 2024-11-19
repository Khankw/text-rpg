package scenes;

import framework.RandomGen;
import textrpg.Player;
import units.*;

public class Guild extends Scene {
	private final int RECRUIT = 1;
	private final int REMOVE = 2;

	@Override
	public void update() {
		printTitle("길드");
		out.println(user.getPlayer());
		int sel = in.input("[1]용병모집 [2]용병해고 [0]로비", -1);

		if (sel == RECRUIT)
			recruit();
		else if (sel == REMOVE)
			remove();
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}

	private void recruit() {
		int price = 10;

		printTitle("용병모집");
		Player player = user.getPlayer();
		if (player.getMoney() < price) {
			out.printErrln("모집할 금액이 부족합니다.");
			return;
		}
		if(player.getUnitsSize()==20) {
			out.printErrln("용병을 더 이상 늘릴수 없습니다.");
			return;
		}
			

		StringBuilder str = new StringBuilder();
		String[] unitClass = { "Warrior", "Cleric", "Mage" };

		RandomGen ran = RandomGen.getInstance();

		str.append("units.").append(unitClass[ran.get(unitClass.length)]);
		String classStr = str.toString();

		str.setLength(0);
		String[] firstNames = { "Sophia", "Liam", "Ava", "Benjamin", "Olivia", "Mason", "Mia", "Ethan", "Lucas",
				"Charlotte", "Isaac", "Evelyn", "Wyatt", "Zoe", "David", "Amelia", "James", "Aiden", "Emma",
				"Sebastian" };
		String[] lastNames = { "Taylor", "Jordan", "Morgan", "Ryan", "Hunter", "Carter", "Avery", "Parker", "Austin",
				"Madison", "Dylan", "Ellie", "Samantha", "Kennedy", "Sophie", "Adrian", "Riley", "Savannah", "Blake",
				"Cameron" };

		str.append(firstNames[ran.get(firstNames.length)]).append(" ").append(lastNames[ran.get(lastNames.length)]);
		String name = str.toString();

		try {
			Class<?> classScene = Class.forName(classStr);
			Class<?>[] argTypes = { String.class };
			Playable unit = (Playable) classScene.getConstructor(argTypes).newInstance(name);
			player.subtractMoney(price);
			player.addUnit(unit);
			out.addReset("#### 모집성공 ####\n", color.BLUE, color.BRIGHTGREEN);
			out.add(unit).addLine().add(unit.getName()).println("이 고용되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void remove() {
		printTitle("용병해고");
		Player player = user.getPlayer();

		if (player.getUnitsSize() < 2) {
			out.printErrln("용병이 2명 이상일때 해고가 가능합니다.");
			return;
		}

		out.println(player.unitsToString());
		int sel = in.input("해고할 용병 번호 입력", 0) - 1;

		if (sel < 0 || sel >= player.getUnitsSize()) {
			out.printErrln("입력 범위를 벗어났습니다.");
			return;
		}

		String name = player.getUnitName(sel);
		player.removeUnit(sel);
		out.addReset("#### 해고완료 ####\n", color.RED, color.BRIGHTRED);
		out.add(name).println("이 해고되었습니다.");

	}
}
