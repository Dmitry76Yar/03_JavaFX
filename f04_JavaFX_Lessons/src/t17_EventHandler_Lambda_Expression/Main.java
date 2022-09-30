package t17_EventHandler_Lambda_Expression;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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

	/* ���������� EventHandler ����� ������ ���������
   Lambda expression lets you create an anonymous class that implements a specific type of interface � a functional interface � which has one and
only one abstract method.
   The EventHandler interface used to handle JavaFX events meets that definition: It has just one abstract method, handle. Thus, EventHandler is
a functional interface and can be used with lambda expressions. */
public class Main extends Application {
	Button btnAdd, btnSubtract, btnDivision;
	Label lbl;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {		
		/* ��� ������������� ������-��������� �� ��������� ����� ������, ������� ����������, �.�. �������������� ���������, ����������� � 
		 ������-���������� ����� ����� ������������ �����. � ����� ������ � EventHandler interface - ��� ����� handle.
		 ����� �� ��������� ����� �������� ���������������� ����������, �.�. �� ������������ �� ���������. ����� setOnAction ����������
		 ������������ ��������� ���� EventHandler, ������� ��� �������������� ������-��������� � setOnAction, Java ��������, ��� 
		 ������-��������� �������������� EventHandler interface �, ��������������, ��� ������������ ����� - handle(). 
	 ��������, ��� ������������� ���������� ������ ��� ������-��������� ����� ����������� �������� ���������� EventHandler � ������ handle().  */
		btnAdd = new Button();					 
		btnAdd.setText("Add");
		btnAdd.setOnAction( e -> {
				iCounter++;
				lbl.setText(Double.toString(iCounter));
				} );
		
		/* ���� � ���������� ������������ ����� ��������������� ������, �� ������������� ������-���������, ��� ����, ����������
		   � ���� ������ ����� ����������� ������� ��� ������ � ��������� �����, ��� ������� ����  		 */
		btnSubtract = new Button();					 
		btnSubtract.setText("Substract");
		btnSubtract.setOnAction( e -> btnSubtract_Click());
		
		btnDivision = new Button();					 
		btnDivision.setText("Division");
		btnDivision.setOnAction ( e -> btnDivision_Click());
		
		lbl = new Label();
		lbl.setText(Double.toString(iCounter));
		
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btnAdd, btnSubtract, btnDivision, lbl);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
 	}
	private void btnSubtract_Click(){
		iCounter++;
		lbl.setText(Double.toString(iCounter));
	}
	private void btnDivision_Click(){
		iCounter = iCounter/2;
		lbl.setText(Double.toString(iCounter));
	}
		
public static void main(String[] args) {
	launch(args);
	}
}
