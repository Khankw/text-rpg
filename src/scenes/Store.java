package scenes;

public class Store extends Scene {

	@Override
	public void update() {
		printTitle("상점");
		int sel = in.input("[1]구매 [2]판매 [0]로비", -1);
		
		if (sel == 1)
			out.println("구매");
		else if (sel == 2)
			out.println("판매");
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}
}
