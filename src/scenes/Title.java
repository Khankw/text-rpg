package scenes;

public class Title extends Scene {
	private final int LOGIN = 1;
	private final int SIGNIN = 2;

	@Override
	public void update() {
		printTitle("Text RPG");
		int sel = in.input("[1]로그인 [2]가입", -1);

		if (sel == LOGIN)
			manager.changeScene("Login");
		else if (sel == SIGNIN)
			manager.changeScene("Signin");
		else if (sel == EXIT)
			exit();
		

	}
}
