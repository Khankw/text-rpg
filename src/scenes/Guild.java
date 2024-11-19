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
		int sel = in.input("[1]용병모집 [2]용병해고 [0]로비", -1);

		if (sel == RECRUIT)
			recruit();
		else if (sel == REMOVE)
			remove();
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}

	private void recruit() {
		Player player = user.getPlayer();
		if (player.getMoney() < 1000) {
			out.printErrln("모집할 금액이 부족합니다.");
			return;
		}

		StringBuilder className = new StringBuilder();
		String[] unitClass = { "Warrior", "Cleric", "Mage" };

		RandomGen ran = RandomGen.getInstance();
		className.append("units.").append(unitClass[ran.get(unitClass.length)]);

		try {
			Class<?> classScene = Class.forName(className.toString());

			Class<?>[] argTypes = { String.class };
			Playable unit = (Playable) classScene.getConstructor(argTypes).newInstance(className.toString());
			// player.subtractMoney(1000);
			out.addReset("#### 모집성공 ####\n", color.BLUE, color.BRIGHTGREEN);
			out.add(unit).addLine().add(unit.getName()).println("이 고용되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void remove() {
		out.println("해고");
	}
}
