package t20_Event_Listener;
	
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.event.*;

public class Main extends Application  {
	Button button;
	Label lbl;
	TextField txtField;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {			
		button = new Button();			button.setText("BUTTON");				
		lbl = new Label("LABEL");		
		txtField = new TextField();		txtField.setMinWidth(70);			txtField.setMaxWidth(70);
		txtField.setPromptText("Enter ");		// ���������� "������" ��������� � ����
		Slider slider = new Slider(0, 100, 0); 
		
/*-----------------------����������� �� ������ JAVAFX PROPERTIES-------------------------------------------------------
 		JavaFX-�������� ����� ��������� ����������, ������� ����� ���������� ��� ��������� �������� ��������.
 		����� ����������� ������ ����������� ���� ��������� InvalidationListener ��� ChangeListener<T>
 		
 					INVALIDATION LISTENER
 		��������� InvalidationListener ��������� ������� ��������������� �������� �������� � ����� ���� ����� invalidated() 
 		������ ��� ���������� � �������� ����������� ������� ��������������� ����������� � ���������� Obversable, ������� ��������
 		  - ����� addListener() ��� ���������� �����������
 		  - ����� removeListener() ��� �������� �����������. 
 			 	���������� ����� ������ ������ ��� ������ ��������� ��������, � ����� �� ���������� �� �����, ���� �� �� ������� �������� 
 		 ����������� �������� ��������. ��� ������� � "�������" �����������, ����� �������� �������� ��������������� �� ����� �����
 		 ���������, � ������ ��� ������� �������� �������� ��������		 		 
 		 	 ����� ��������� ���������� ����� ��� ���� � ��������� ������� InvalidationListener � ��������������� ������ invalidated() ��� 
 		 ����� ��� � ������-����������, �.�. ��������� InvalidationListener �������� ��������������.		 		 	 */
		InvalidationListener invListener = new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
//				System.out.println(" ������  Scene ���a �������a");
			}
		};
		primaryStage.widthProperty().addListener(invListener);
			// ��� �������� ����������� �����
//		primaryStage.widthProperty().removeListener(invListener);
		
			/* ����������� ��������� ����� ������-���������
		����� ����� �������, ���, �.�. ������ �� ���������� �� ����������� �� ��������� ������-���������, �� ������� ���������� �� ��������� 			 */
		primaryStage.widthProperty().addListener(observable -> {
//			System.out.println(" ������  Scene ���a �������a   ������-���������");
//			System.out.println(primaryStage.getWidth());
		});

/*							CHANGE LISTENER																
  		�������������� ��������� ChangeListener<T> ��������� ������� ��������� �������� ��������. 
  		�� �������� ����� void changed(ObversableValue<? extends T> obversable, T oldValue, T newValue)
  		������ ����������� ������� ����������� � ���������� ObversableValue, ������� ��������
 		  - ����� addListener() ��� ���������� �����������
 		  - ����� removeListener() ��� �������� �����������.
 		  - ����� getValue() ��� �������� ������ �������� 
  		����� �������� ObversableValue �������� ������, ��� �� ���������� ObversableValue, ��� � �� ���������� Obversable, �.�.
  		ObversableValue �������� ����������� Obversable.
  		�������� oldValue - �������� ������ �������� ��������, newValue - �����
  			�����, ��� ����� ���������� ��� ����� ��������� �������� �������� � �� ������� �� "�������" ����������		
  		����� ��������� ���������� ����� ��� ���� � ��������� ������� ChangeListener � ��������������� ������ chaged() ��� 
 		 ����� ��� � ������-����������, �.�. ��������� ChangeListener �������� ��������������.		 	*/
		ChangeListener<? super Number> changeList = new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("������ stage ���������� � " + oldValue + "  �� " + newValue);
			}
		};
		primaryStage.widthProperty().addListener(changeList);
			// ��� �������� ����������� �����
//		primaryStage.widthProperty().removeListener(changeList);
		
			/* ����������� ��������� ����� ������-���������
		����� ����� �������, ���, �.�. ������ �� ���������� �� ����������� �� ��������� ������-���������, �� ������� ���������� �� ��������� 			 */
		primaryStage.widthProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("����� ������-��������� ������ stage ���������� � " + oldValue + "  �� " + newValue);
		});

/*------------------------------------������ ������� ������������ �������-----------------------------------------------------*/
			// ������ ��� ������������ �������� ��������
		slider.valueProperty().addListener((obj, oldValue, newValue) -> {
				System.out.println("�������� �������� ���������� � " + oldValue + " �� " + newValue);
		});
			// ������ ��� ������������ ��������� ������� � TextField
		txtField.textProperty().addListener((listener, oldValue, newValue) -> {
			System.out.println("���������� ������� �� txtField c " + oldValue + "  �� " + newValue);
		});
			// ��������� ��������� � ������� ����     xProperty  � yProperty   
		primaryStage.xProperty().addListener((listener, oldValue, newValue) -> {
//			System.out.println("���������� � ������ �������� ���� ���� ���������� � " + oldValue + "  �� " + newValue);
		});
		
		
		HBox pane = new HBox(10);
		Group group = new Group(); 	group.getChildren().addAll(txtField); 
		pane.getChildren().addAll(button, lbl, slider, group);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
