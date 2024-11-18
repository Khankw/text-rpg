package scenes;

abstract public class Scene {
	private Scene prevScene;

	public void setPrevScene(Scene prevScene) {
		this.prevScene = prevScene;
	}

	abstract public void update();
}
