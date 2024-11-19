package scenes;

import textrpg.Player;

public class Party extends Scene {
	private final int PARTY = 1;
	private final int EQUIP = 2;

	@Override
	public void update() {
		printTitle("파티");
		out.println(user.getPlayer());
		int sel = in.input("[1]파티원교체 [2]장비교체 [0]로비", -1);

		if (sel == 1)
			party();
		else if (sel == EQUIP)
			equip();
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}

	private void party() {
		Player player = user.getPlayer();

		printTitle("파티원교체");
		out.add(player.unitsToString()).add("\n");
		out.println("0) 파티원 해제");
		int index = in.input("용병 번호 입력", 0) - 1;
		if (index < -1 || index >= player.getUnitsSize()) {
			out.printErrln("입력 범위를 벗어났습니다.");
			return;
		}

		int sel = in.input("파티 슬롯 선택", 0) - 1;
		if (sel < 0 || sel >= 5) {
			out.printErrln("입력 범위를 벗어났습니다.");
			return;
		}

		player.setParty(index, sel);
		out.println("파티원교체를 완료했습니다.");
	}

	private void equip() {

	}
}
