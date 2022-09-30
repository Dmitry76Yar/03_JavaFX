package t15_EventHandler_Impem_Interface;
	
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

	// ���������� EventHandler ����� ��������� "implements EventHandler" � ������ ����� ���������
public class Main extends Application implements EventHandler <ActionEvent> {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {			
		btnAdd = new Button();					 
		btnAdd.setText("Add");
		btnAdd.setOnAction(this);
		
		btnSubtract = new Button();					 
		btnSubtract.setText("Substract");
		btnSubtract.setOnAction(this);
		
		btnDivision = new Button();					 
		btnDivision.setText("Division");
		btnDivision.setOnAction(this);
		
		btnMultiply = new Button();					 
		btnMultiply.setText("Multiply");
		btnMultiply.setOnAction(this);
		
		lbl = new Label();
		lbl.setText(Double.toString(iCounter));
		
			// ����� javafx.scene.layout.HBox ���������� ��� ��������� �������� � ���� �������������� ����.
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btnAdd, btnSubtract, btnDivision, btnMultiply, lbl);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
	}
		
		@Override
		public void handle(ActionEvent e) {
			if (e.getSource()==btnAdd) 	iCounter++;
			else if (e.getSource()==btnSubtract) iCounter--;
			else if (e.getSource()==btnDivision) iCounter = iCounter/2;
			else if (e.getSource()==btnMultiply) iCounter = iCounter*2;
			lbl.setText(Double.toString(iCounter));
		}
		
	public static void main(String[] args) {
		launch(args);
	}
}
