package application;
	
import Controllers.MainSceneController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	public static Stage primaryStage;
	public static int numberMines, sizeCell, xNumberOfCells, yNumberOfCells;
	public static Param currentParameters;
	
	@Override
	public void start(Stage useless) {
		primaryStage = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/UI_FXML_files/MainScene.fxml"));
			BorderPane root = loader.load();
			Records.createAndRecordRecords();
			currentParameters = Param.read();			// Чтение настроек из предыдущих игр (или создание с нуля при отсутсвии)
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setOnCloseRequest( e -> {
				e.consume();
				if (MainSceneController.btnClose_Click()) primaryStage.close();
			} );
			primaryStage.setY(10);
			primaryStage.setX(100);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
