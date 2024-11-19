package scenes;

public class Store extends Scene {
	private final int BUY = 1;
	private final int SELL = 2;

	@Override
	public void update() {
		printTitle("상점");
		out.println(user.getPlayer());
		int sel = in.input("[1]구매 [2]판매 [0]로비", -1);

		if (sel == BUY)
			buyItem();
		else if (sel == SELL)
			sellItem();
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}

	private void buyItem() {

	}

	private void sellItem() {

	}
}
