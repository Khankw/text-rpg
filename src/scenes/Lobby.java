package scenes;

import textrpg.UserManager;

public class Lobby extends Scene {
	private final int DUNGEON = 1;
	private final int PARTY = 2;
	private final int GUILD = 3;
	private final int STORE = 4;
	private final int LOGOUT = 5;
	private final int LEAVE = 6;

	@Override
	public void update() {
		printTitle("Lobby");
		int sel = in.input("[1]던전 [2]파티 [3]길드 [4]상점\n[5]로그아웃 [6]계정탈퇴 [0]게임종료", -1);

		if (sel == DUNGEON)
			out.println("Dungeon");
		else if (sel == PARTY)
			out.println("Party");
		else if (sel == GUILD)
			out.println("Guild");
		else if (sel == STORE)
			out.println("Store");
		else if (sel == LEAVE)
			leave();
		else if (sel == LOGOUT)
			logout();
		else if (sel == EXIT)
			exit();
	}

	private void leave() {
		String pw = in.input("PW");
		if (!UserManager.getInstance().leave(pw)) {
			out.printErrln("비밀번호가 틀렸습니다.");
			return;
		}
		out.println("탈퇴가 완료되었습니다.");

		manager.changeScene("Title");
	}

	private void logout() {
		UserManager.getInstance().logout();
		manager.changeScene("Title");
	}
}
