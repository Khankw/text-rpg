package scenes;

public class Login extends Scene {

	@Override
	public void update() {
		printTitle("로그인");
		String id = in.input("ID");
		String pw = in.input("PW");

		if (user.login(id, pw)) {
			out.add(user.getUserId(), color.BRIGHTBLUE).resetColor().println("님, 로그인 완료되었습니다.");
			manager.changeScene("Lobby");
			return;
		} else
			out.printErrln("사용자 정보를 확인해 주세요.");

		manager.changeScene("Title");
	}
}
