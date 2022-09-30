package t02_Loader_to_and_from_FXML;
	
import java.util.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.Callback;

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) {
			primaryStage = new Stage();
			try {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("FXML.fxml"));
				BorderPane root = loader.load();
				
					// Чтобы получить ссылку на Label из файла FXML
				 Map<String, Object> fxmlNamespace = loader.getNamespace(); 
				 Label lb = (Label)fxmlNamespace.get("LabelFxId");
				 lb.setTextFill(Color.RED);
				 System.out.println(" Надпись на Label, полученной из FXML файла, - " + lb.getText());
				 
				 	// Чтобы передать контроллеру ссылку из Main без указания его статической переменной
				 String toTransfer = " transfer was done ";
				 final Stage primaryStage2 = primaryStage;
				 loader.setControllerFactory(new Callback<Class<?>, Object>() {
					@Override
					public Object call(Class<?> param) {
						System.out.println(" UPLOAD ");
						return new Controll (primaryStage2, toTransfer);
					}
				});
				 Scene scene = new Scene(root);
				 primaryStage.setScene(scene);
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