package scenes;

import framework.*;
import textrpg.TextRPG;

abstract public class Scene {
	protected final int EXIT = 0;

	protected IndexColor color;
	protected Output out = Output.getInstance();
	protected Input in = Input.getInstance();

	protected TextRPG game = TextRPG.getInstance();

	protected SceneManager manager = SceneManager.getInstance();

	protected Scene prevScene;

	public void setPrevScene(Scene prevScene) {
		if (prevScene != null)
			this.prevScene = prevScene;
	}

	public Scene getPrevScene() {
		return this.prevScene;
	}

	
	protected void printTitle(String title) {
		out.add("======== ", color.GREEN, color.BRIGHTYELLOW);
		out.add(title);
		out.println(" ========");
		out.resetColor();
	}

	protected void exit() {
		game.exit();
	}

	abstract public void update();
}
