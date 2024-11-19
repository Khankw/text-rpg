package scenes;

import java.util.HashMap;

import framework.Output;

public class SceneManager {
	private SceneManager() {
	}

	private static SceneManager instance = new SceneManager();

	public static SceneManager getInstance() {
		return instance;
	}

	private HashMap<String, Scene> scenes = new HashMap<>();

	private Scene curScene;

	public void init() {
		StringBuilder className = new StringBuilder();
		String[] sceneNames = { "Title", "Lobby", "Dungeon", "Party", "Guild", "Store", "Purchase" };

		for (int i = 0; i < sceneNames.length; i++) {
			className.setLength(0);
			className.append("scenes.").append(sceneNames[i]);
			try {
				Class<?> classScene = Class.forName(className.toString());
				Scene newScene = (Scene) classScene.getConstructor().newInstance();
				scenes.put(sceneNames[i], newScene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		curScene = scenes.get("Title");
	}

	public void changeScene(String key) {
		Scene newScene = scenes.get(key);

		if (newScene == null) {
			Output.getInstance().printErrln("해당 씬이 없음");
			return;
		}
		curScene = newScene;
	}

	public void update() {
		curScene.update();
	}
}
