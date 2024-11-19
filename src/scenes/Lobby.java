package scenes;

public class Lobby extends Scene {
	private final int DUNGEON = 1;
	private final int PARTY = 2;
	private final int GUILD = 3;
	private final int STORE = 4;
	private final int LOGOUT = 5;
	private final int LEAVE = 6;

	@Override
	public void update() {
		printTitle("대기실");
		out.println(user.getPlayer());
		int sel = in.input("[1]던전 [2]파티 [3]길드 [4]상점\n[5]로그아웃 [6]계정탈퇴 [0]게임종료", -1);

		if (sel == DUNGEON)
			manager.changeScene("Dungeon");
		else if (sel == PARTY)
			manager.changeScene("Party");
		else if (sel == GUILD)
			manager.changeScene("Guild");
		else if (sel == STORE)
			manager.changeScene("Store");
		else if (sel == LEAVE)
			leave();
		else if (sel == LOGOUT)
			logout();
		else if (sel == EXIT)
			exit();
	}

	private void leave() {
		String pw = in.input("PW");
		if (!user.leave(pw))
			return;

		out.println("탈퇴가 완료되었습니다.");

		manager.changeScene("Title");
	}

	private void logout() {
		user.logout();
		manager.changeScene("Title");
	}
}
