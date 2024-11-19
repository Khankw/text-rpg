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
		StringBuilder className = new StringBuilder();
		String[] scenes = {"Title","Login","Signin","Lobby",
				"Dungeon","Party","Guild","Store"};

		for(int i= 0;i<scenes.length;i++) {
			className.setLength(0);
			className.append("scenes.").append(scenes[i]);
			try {
				Class<?> classScene = Class.forName(className.toString());
				Scene newScene = (Scene) classScene.getConstructor().newInstance();
				scene.putScene(newScene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void exit() {
		isRun= false;
	}
}
