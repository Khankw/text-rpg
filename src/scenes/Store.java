package scenes;

import items.Item;

public class Store extends Scene {
	private final int BUY = 1;
	private final int SELL = 2;

	@Override
	public void update() {
		setPlayer();
		printTitle("상점");
		player.showInfo();
		int sel = in.input("[1]구매 [2]판매 [0]로비", -1);

		if (sel == BUY)
			manager.changeScene("Purchase");
		else if (sel == SELL)
			sellItem();
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}

	private void sellItem() {
		printTitle("상품판매");
		if (player.getItemsSize() == 0) {
			out.printErrln("판매할 상품이 없습니다.");
			return;
		}

		player.showItems();
		int sel = in.input("판매할 상품 번호 입력", 0) - 1;

		if (sel < 0 || sel >= player.getItemsSize())
			return;

		Item item= player.sellItem(sel);
		player.addMoney(item.getPrice());
		out.addReset("#### 판매완료 ####\n", color.BLACK, color.BRIGHTMAGENTA);
		out.add(item.getName(), color.MAGENTA).reset().println("를 판매하였습니다.");
		
	}
}
