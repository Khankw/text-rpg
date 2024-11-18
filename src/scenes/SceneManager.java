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

	public void putScene(Scene scene) {
		scenes.put(scene.getClass().getSimpleName(), scene);
		if (curScene == null)
			curScene = scene;
	}

	public void changeScene(String key) {
		Scene newScene = scenes.get(key);
		
		if(newScene ==null) {
			Output.getInstance().printErrln("해당 씬이 없음");
			return;
		}
		newScene.setPrevScene(curScene);
		curScene = newScene;
	}

	public void prevScene() {
		curScene = curScene.getPrevScene();
	}

	public void update() {
		curScene.update();
	}
}
