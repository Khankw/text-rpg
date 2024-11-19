package scenes;

public class Party extends Scene {

	@Override
	public void update() {
		printTitle("파티");
		int sel = in.input("[1]파티교체 [2]파티장비 [0]로비", -1);
		
		if (sel == 1)
			out.println("파티교체");
		else if (sel == 2)
			out.println("파티장비");
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}
}
