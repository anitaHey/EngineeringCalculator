import javafx.scene.Scene;

public class ControlledStage {
	Scene scene;
	public void addtrans(Scene newScene){
		scene=newScene;
	}
	public Scene pressTrans(){
		return scene;
	}
}