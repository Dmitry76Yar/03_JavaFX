package t09_Stack_Pane;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		
			/* StackPane - ���������, � ������� ���� ��������� ���� ��� ������
			 ������ ����������� ���� ����� ���������� � ����� ���� ������, ��������� - �� ����� �����  */
		Button btn1 = new Button("Button One");
		Button btn2 = new Button("Button Two");
		Button btn3 = new Button("Button Three");
		Button btn4 = new Button("Button 4");
		Button btn5 = new Button("Button 5");
		Button btn6 = new Button("Button 6");
		
			/* �������� StackPane
		������������:
		- StackPane () - ������� ������ pane
		- StackPane (Node...children) - ������� pane c ���������� ������	
		 - ����� getchildren.addAll(Node...Children)  */
		StackPane pane = new StackPane(btn1, btn2, btn3, btn4, btn5, btn6);
		
				// ��������� �� ������ PANE �� �����
		pane.setPadding(new Insets(20, 20, 20, 20));	// ����������� ��������� �� ����
		
				/* ���������������� ����� ������ ������ 
		�� ��������� ���� ����������� � ����. �������� ������������ ����� � �������  */
		pane.setAlignment(Pos.CENTER);					
		
		Scene scene = new Scene(pane, 400.0, 400.0); 
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("BorderPane");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
