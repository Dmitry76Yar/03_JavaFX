package t56_Alert_Class;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	/* �����������
		- Alert(Alert.AlertType) Creates a new alert of the specified type 
		- Alert(Alert.AlertType,String text) Creates a new alert of the specified type and sets the message text
		- Alert(Alert.AlertType, String text, ButtonType type...) Creates a new alert and sets the buttons to be displayed
	 ������
	    - void setTitle(String text) Sets the title Optional<ButtonType> 
	    - showAndWait() Shows the alert and waits for the user�s response, which is returned as a ButtonType object */
	    
	/* AlertType parameter ��������� ������� ��� ����������� ����
		- AlertType.CONFIRMATION  - ���������� ����������� ����������� ��������
		- AlertType.ERROR - ���������� ���� ������
		- AlertType.INFORMATION - ���������� �������������� ����
		- AlertType.WARNING - ���������� ���� ��������������
		- AlertType.NONE - ���������� ������������� ���������� ����		 */
	
	/* ����� ������� ����� ������ �������� ��� ��������� Alert ���� ����� ����� ButtonType parameter:
		-ButtonType.APPLY		-ButtonType.CANCEL	 	-ButtonType.CLOSE 		-ButtonType.FINISH 		-ButtonType.NEXT
		-ButtonType.NO			-ButtonType.OK			-ButtonType.PREVIOUS	-ButtonType.YES */

	Button btn;
	Label lbl;
	int iClickCount = 0;
	
		@Override 
	public void start(Stage primaryStage) {	
			btn = new Button();
			btn.setText("Click me please!");
			btn.setOnAction(e -> buttonClick());
			BorderPane pane = new BorderPane();
			pane.setCenter(btn);
			Scene scene = new Scene(pane, 250, 150);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Click Counter");
			primaryStage.show();
	}
	public void buttonClick() 	{
		iClickCount++;
		if (iClickCount == 1) 	{
			Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked once.");
			a.showAndWait(); }
		else {
				// ���������� � ���� ���� ���� ������
			Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked " + iClickCount + " times.", ButtonType.YES, ButtonType.NO);
				/* ����� showAndWait ���������� ����� �� ������ ���� ���� ������ �������������
			����� ���������� ������ ���� Optional. �����, ��� ���� ����� �� ������ �� ���� �� ������, � ������ ������� ���� ����� �������,
			������� ������� ����� ������� ����� isPresent(), ����� ������ ���� ������ ������ � �������� */
			Optional<ButtonType> r = a.showAndWait();
			if (r.isPresent() && r.get() == ButtonType.YES)	{
				Alert b = new Alert(Alert.AlertType.WARNING, "The user clicked YES!");
				b.showAndWait();
			}
			else if (r.isPresent() && r.get() == ButtonType.NO)	{
				Alert b = new Alert(Alert.AlertType.ERROR, "The user clicked NO!");
				b.showAndWait();
			}
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
