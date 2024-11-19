package scenes;

public class Party extends Scene {
	private final int PARTY = 1;
	private final int EQUIP = 2;

	@Override
	public void update() {
		setPlayer();
		printTitle("파티");
		player.showParty();
		int sel = in.input("[1]파티설정 [2]장비교체 [0]로비", -1);

		if (sel == PARTY)
			party();
		else if (sel == EQUIP)
			equip();
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}

	private void party() {
		printTitle("파티설정");
		player.showUnits();
		out.println("0) 파티원 해제\n------------------------------");
		int index = in.input("용병 번호 입력", 0) - 1;
		if (index < -1 || index >= player.getUnitsSize())
			return;

		player.showParty();
		int sel = in.input("파티원슬롯 선택", 0) - 1;
		if (sel < 0 || sel >= 5)
			return;

		player.setParty(index, sel);
		out.println("파티설정을 완료했습니다.");
	}

	private void equip() {

	}
}
