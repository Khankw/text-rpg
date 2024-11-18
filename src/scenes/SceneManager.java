package scenes;

import java.util.HashMap;

public class SceneManager {
	private SceneManager() {
	}

	private static SceneManager instance = new SceneManager();

	public static SceneManager getInstance() {
		return instance;
	}

	private HashMap<String, Scene> scenes = new HashMap<>();

	private Scene curScene;

	public void putScene(Scene scene) {
		scenes.put(scene.getClass().getSimpleName(), scene);
		if (curScene == null)
			curScene = scene;
	}

	public void changeScene(String key) {
		Scene prevScene = curScene;
		curScene = scenes.get(key);
		curScene.setPrevScene(prevScene);
	}

	public void prevScene() {
		curScene = curScene.getPrevScene();
	}

	public void update() {
		curScene.update();
	}
}
