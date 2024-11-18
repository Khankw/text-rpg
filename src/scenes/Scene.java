package scenes;

import framework.*;
import textrpg.TextRPG;

abstract public class Scene {
	protected final int TITLELENGTH = 30;
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
		int length = title.length();
		int size = TITLELENGTH - length - 2;
		out.addColor(color.GREEN, color.BRIGHTYELLOW);
		for (int i = 0; i < size / 2; i++)
			out.add("=");
		if (size % 2 == 1)
			out.add("=");
		out.add(" ");
		out.add(title);
		out.add(" ");
		for (int i = 0; i < size / 2; i++)
			out.add("=");
		out.println();
		out.resetColor();
	}

	protected void exit() {
		game.exit();
	}

	abstract public void update();
}
