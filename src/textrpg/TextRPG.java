package textrpg;

import scenes.SceneManager;

public class TextRPG {
	private TextRPG() {
	}

	private static TextRPG instance = new TextRPG();

	public static TextRPG getInstance() {
		return instance;
	}

	private SceneManager scene = SceneManager.getInstance();

	private boolean isRun = true;

	public void run() {
		scene.init();
		while (isRun) {
			scene.update();
		}
	}

	public void exit() {
		isRun = false;
	}
}
