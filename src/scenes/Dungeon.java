package scenes;

public class Dungeon extends Scene {

	@Override
	public void update() {
		setPlayer();
		printTitle("던전");
		out.println(player);
		int sel = in.input("[1]입장 [0]복귀", -1);
		
		if (sel == 1)
			out.println("입장");
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}

}
