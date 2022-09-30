package t10_Anchor_Pane;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Main extends Application {
	
		@Override 
	public void start(Stage primaryStage) {	
		
			/* AnchorPane позволяет указать привязку узла к сторонам pane. Если задана привязка к двум противоположным сторонам, то
			 узел растянется на всю ширину панели 		 */
		Button btn1 = new Button("Button One");		Button btn2 = new Button("Button Two");		Button btn3 = new Button("Button Three");
		Button btn4 = new Button("Button 4");		Button btn5 = new Button("Button 5");		Button btn6 = new Button("Button 6");
		
			// Разделение элементов линией
		Separator separator2 = new Separator(Orientation.VERTICAL);
		
			/* СОЗДАНИЕ StackPane
		Конструкторы:
		- AnchorPane () - создает пустой pane
		- AnchorPane (Node...children) - создает pane c указанными узлами	
		- Метод getchildren.addAll(Node...Children) 
		После добавления все узлы будут находится в точке с координатами 0,0 */
		AnchorPane pane = new AnchorPane(btn1, btn2, separator2, btn3, btn4, btn5, btn6);
		
				// РАСПРЕДЕЛЕНИЕ УЗЛОВ ПО СТОРОНАМ 
		AnchorPane.setTopAnchor(btn1, 10.0);	AnchorPane.setTopAnchor(btn5, 20.0);
		AnchorPane.setRightAnchor(btn2, 5.0);	
		AnchorPane.setBottomAnchor(btn3, 10.0);
		AnchorPane.setLeftAnchor(btn4, 10.0);
		
				// РАСТОЯНИЕ ОТ ГРАНИЦ PANE ДО УЗЛОВ
		pane.setPadding(new Insets(20, 20, 20, 20));	// Установлено растояния от края
		
		Scene scene = new Scene(pane, 400.0, 400.0); 
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("BorderPane");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
