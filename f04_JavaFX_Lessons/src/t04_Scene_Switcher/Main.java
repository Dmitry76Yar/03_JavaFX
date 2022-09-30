package t04_Scene_Switcher;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
		// Поля для Click-Counter scene
	int iClickCount = 0;
	Label lblClicks;
	Button btnClickMe;
	Button btnSwitchToScene2;
	Scene scene1;
		// Поля для Add-Subtract scene
	int iCounter = 0;
	Label lblCounter;
	Button btnAdd;
	Button btnSubtract;
	Button btnSwitchToScene1;
	Scene scene2;
		// Поле для Stage
	Stage stage;			// Это поле нужно для сохранения ссылки на primary stage, чтобы у нас был доступ к ней во всей программе
	
		@Override 
	public void start(Stage primaryStage) {	
		stage = primaryStage;
			// Построение Click-Counter scene
		lblClicks = new Label();
		lblClicks.setText("You have not clicked the button.");
		btnClickMe = new Button();
		btnClickMe.setText("Click me please!");
		btnClickMe.setOnAction(e -> btnClickMe_Click());
		btnSwitchToScene2 = new Button();
		btnSwitchToScene2.setText("Switch!");
		btnSwitchToScene2.setOnAction(e -> btnSwitchToScene2_Click());
		VBox pane1 = new VBox(10);
		pane1.getChildren().addAll(lblClicks, btnClickMe, btnSwitchToScene2);
		scene1 = new Scene(pane1, 250, 150);
		
		// Построение Add-Subtract scene
		lblCounter = new Label();
		lblCounter.setText(Integer.toString(iCounter));
		btnAdd = new Button();
		btnAdd.setText("Add");
		btnAdd.setOnAction(e -> btnAdd_Click());
		btnSubtract = new Button();
		btnSubtract.setText("Subtract");
		btnSubtract.setOnAction(e -> btnSubtract_Click());
		btnSwitchToScene1 = new Button();
		btnSwitchToScene1.setText("Switch!");
		btnSwitchToScene1.setOnAction(e -> btnSwitchToScene1_Click());
		HBox pane2 = new HBox(10);
		pane2.getChildren().addAll(lblCounter, btnAdd, btnSubtract, btnSwitchToScene1);
		scene2 = new Scene(pane2, 300, 75);
		
			// Установка scene 1 на stage и show stage
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Scene Switcher");
		primaryStage.show();
	}
		
			// Event handlers for scene 1
		public void btnClickMe_Click() 	{
			iClickCount++;
			if (iClickCount == 1) lblClicks.setText("You have clicked once.");
			else 	lblClicks.setText("You have clicked " + iClickCount + " times." );
		}
		private void btnSwitchToScene2_Click() 	{
			stage.setScene(scene2); 
		}
		
			// Event handlers for scene 2
		private void btnAdd_Click() {
			iCounter++;
			lblCounter.setText(Integer.toString(iCounter));
		}
		private void btnSubtract_Click() {
			iCounter--;
			lblCounter.setText(Integer.toString(iCounter));
		}
		private void btnSwitchToScene1_Click() 	{
			stage.setScene(scene1);
		}

		public static void main(String[] args) {
		launch(args);
	}
}
