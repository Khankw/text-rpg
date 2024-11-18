package textrpg;

import scenes.*;

public class TextRPG {
	private TextRPG() {}
	private static TextRPG instance = new TextRPG();
	public static TextRPG getInstance() {
		return instance;
	}
	
	private SceneManager scene = SceneManager.getInstance();
	
	private boolean isRun = true;
	
	public void run() {
		initGame();
		while(isRun) {
			scene.update();
		}
	}

	private void initGame() {
		scene.putScene(new Title());
		scene.putScene(new Login());
		scene.putScene(new Signin());
	}
	
	public void exit() {
		isRun= false;
	}
}
