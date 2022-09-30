package t14_EventHandler_Anonimus_Class;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.event.*;

/* Handling an Action Event  - ��������� c�������, ����� ������ - ��� ����� ����� btn.setOnAction():
   ����� ��������� ��� ������ ������� �� ������� � ��������� �� ��������, ������� ������� � ��� ����. 	
   Event  - ������, ������� ���������, ����� ������������  ��������������� � ���������-���������.
   ����� Event ������ ���������� � ����������� ������ Event Handler, � ������� ���������� ����������� �� ������� �����
   �������� ���� ���������� � ����������� ��������������� ��������
   Event Handler �������������� ��������� EventHandler, ������� ���������� ������������ ����� handle()
   
   	    ������ ������������ ������
   - ActionEvent - ���������, ����� ���� ��������� �������� � ������� ��� ������ �����������. ������ ��� �������� ������ �� ������
   � ����������, �� ����� ��� ����� ���� ������� ������� Enter � ������������ �� ������� � �������  ��� �������� ������������������ �����
   - InputEvent - ���������, ����� ��������� event, ��������� � ��������� ���� ��� �������� ������� �� ����������
   - KeyEvent  - ��������� ��� ������� ������� �� ����������. ������������ ��� ��������� ������������ ������ ����������
                 (KeyEvent �������� ���������� InputEvent.)
   - MouseEvent - ���������, ����� ���� ������ ���-�� ���������� � �����: �������� �� ������, �������������� �����, ���
   				  ������ �������� ������� ���� �� ������.      
   				  (MouseEvent �������� ���������� InputEvent)
    - TouchEvent - ���������, ����� ������������ ���������� ��������� ������� �� ���������� � ��������� ������
    - WindowEvent - ��������� ��� ������� ��������� ������� ���� (stage)    
    
    4 ������� �������� EventHandler ������
    - �������� "implements EventHandler" � ������ ����� ��������� � �������� ������������� ������ handle()
    - ������� ���������� �����, ������� "implements EventHandler" ���������
    - ������� ��������� �����, ������� "implements EventHandler" ���������
    - ������������  ������ ���������, ����� �������� ������������� ������ handle()    */

	// ���������� EventHandler ����� ��������� �����
public class Main extends Application {
	Button btnAdd, btnSubtract;
	Label lbl;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {		
			// �������� ������� ClickHandler
		btnAdd = new Button();					 
		btnAdd.setText("Add");
		btnAdd.setOnAction(
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						iCounter++;
						lbl.setText(Double.toString(iCounter));
				}
				} );
		
		btnSubtract = new Button();					 
		btnSubtract.setText("Substract");
		btnSubtract.setOnAction(
				new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					iCounter--;
					lbl.setText(Double.toString(iCounter));
				}
				} );
		
		lbl = new Label();
		lbl.setText(Double.toString(iCounter));
		
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btnAdd, btnSubtract, lbl);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
 	}
public static void main(String[] args) {
	launch(args);
	}
}
