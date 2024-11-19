package scenes;

public class Signin extends Scene {
	@Override
	public void update() {
		printTitle("가입");
		String id = in.input("ID");
		String pw = in.input("PW");

		if (user.signin(id, pw))
			out.add(id, color.BRIGHTBLUE).resetColor().println("님의 회원가입이 완료되었습니다.");

		manager.changeScene("Title");
	}
}
