package scenes;

public class Title extends Scene {
	private final int LOGIN = 1;
	private final int SIGNIN = 2;

	@Override
	public void update() {
		printTitle("Text RPG");
		int sel = in.input("[1]로그인 [2]가입 [0]종료", -1);

		if (sel == LOGIN)
			login();
		else if (sel == SIGNIN)
			signin();
		else if (sel == EXIT)
			exit();
	}

	private void login() {
		printTitle("로그인");
		String id = in.input("ID");
		String pw = in.input("PW");

		if (user.login(id, pw)) {
			out.add(user.getUserId(), color.BRIGHTBLUE).reset().println("님, 로그인 완료되었습니다.");
			player = user.getPlayer();
			manager.changeScene("Lobby");
		} else
			out.printErrln("사용자 정보를 확인해 주세요.");
	}

	private void signin() {
		printTitle("가입");
		String id = in.input("ID");
		String pw = in.input("PW");

		if (user.signin(id, pw))
			out.add(id, color.BRIGHTBLUE).reset().println("님의 회원가입이 완료되었습니다.");
	}
}
