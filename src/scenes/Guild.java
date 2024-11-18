package scenes;

import textrpg.UserManager;

public class Guild extends Scene {
	private final int RECRUIT = 1;
	private final int REMOVE = 2;
	
	@Override
	public void update() {
		printTitle("Guild");
		int sel = in.input("[1]용병모집 [2]용병해고 [0]로비", -1);

		if (sel == RECRUIT)
			recruit();
		else if (sel == REMOVE)
			remove();
		else if (sel == EXIT)
			manager.changeScene("Lobby");
	}
	
	private void recruit(){
		out.println("모집");
	}
	private void remove(){
		out.println("해고");
	}
}
