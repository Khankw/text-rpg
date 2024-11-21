package scenes;

public class Party extends Scene {
	private final int PARTY = 1;
	private final int EQUIP = 2;

	@Override
	public void update() {
		setPlayer();
		printTitle("파티");
		if (player.getUnitsSize() == 0) {
			out.printErrln("유닛을 보유하지 않았습니다.");
			manager.changeScene("Lobby");
			return;
		}
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
		int min = 0;
		if (player.hasPartyUnit()) {
			out.println("0) 파티원 해제\n------------------------------");
			min = -1;
		}

		int index = in.input("용병 번호 입력", -1) - 1;
		if (index < min || index >= player.getUnitsSize())
			return;

		player.showParty();
		int sel = in.input("파티원슬롯 선택", 0) - 1;
		if (sel < 0 || sel >= 5)
			return;

		player.setParty(index, sel);
		out.println("파티설정을 완료했습니다.");
	}

	private void equip() {
		printTitle("장비교체");
		if(!player.hasPartyUnit()) {
			out.printErrln("파티설정 먼저 해야합니다.");
			return;
		}
		int size=player.getWearableItemSize();
		if(size==0) {
			out.printErrln("착용 가능한 장비가 없습니다.");
			return;
		}
			
		player.showParty();
		int sel = in.input("파티원슬롯 선택", 0) - 1;
		if (!player.hasPartyUnit(sel))
			return;
		
		player.showUnitEquip(sel);

		player.showWearableItems();
		
		int index = in.input("아이템 번호 입력", 0);

		if (index < 0 || index >= size)
			return;
		
		player.unitEquip(sel, index);
		out.println("장비교체를 완료했습니다.");
			
	}
}
