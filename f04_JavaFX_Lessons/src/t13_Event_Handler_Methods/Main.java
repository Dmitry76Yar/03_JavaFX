package t13_Event_Handler_Methods;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.event.*;

public class Main extends Application  {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply, btn;
	Label lbl;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {			
		btnAdd = new Button();			btnAdd.setText("Add");				
		btnSubtract = new Button();		btnSubtract.setText("Substract");	
		btnDivision = new Button();		btnDivision.setText("Division");	
		btnMultiply = new Button();		btnMultiply.setText("Multiply");	
		btn = new Button();				btn.setText("fireEvent()");
		lbl = new Label();				lbl.setText(Double.toString(iCounter));
		
			/* ���������� ������� ����� �����
		 - ������ setOn, ��������, setOnAction()
		 - ����� addEventHandler()
		 - ����� addEventFilter() - ���������� ���������� �� �������� ����������� addEventHandler()
		     	��������� ������ HANDLER ��� ����
		 	 ��������� ������ = addEventFilter() -> addEventHandler() -> setOnAction()
		     C ������� addEventHandler() � addEventFilter() ����� ������ ��������� ������������, ������������������ � ���� ������ �����
		  Filter1 -> Filter2 -> Handler1 -> Handler2 -> setOnAction()		 */
		
			// ��������� HANDLER � ������� ������� SetOn  ��������, setOnAction()
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) { 
				iCounter++;
				lbl.setText(Double.toString(iCounter));
			}
		});
		
		btnSubtract.setOnAction( e -> {
			iCounter--;
			lbl.setText(Double.toString(iCounter));
		} );
		
			// ��������� HANDLER � ������� �����A AddEventHandler()
		btnDivision.addEventHandler(ActionEvent.ACTION, event -> {
			iCounter = iCounter/2;
			lbl.setText(Double.toString(iCounter));
		});
		
			/* ���������� ��������� �������������� �������� ��������� � ������� �����A AddEventFilter()
			���������� AddEventFilter() ��������� ����� ������������ AddEventHandler()	
			���� ������ ����������� AddEventFilter() ������� consume, �� AddEventHandler() ������ �� ����� */
		btnDivision.addEventFilter(ActionEvent.ACTION, eventFilter -> {
			System.out.println("��� ������ AddEventFilter() ");
//			eventFilter.consume();
		});
		
			/* ��������� HANDLER ��� ������ ����, ������ �� ��� ��� ������� ����
		������ ������������, ��������, ��� ������� Enter ��� ���������� ����� � ����  */
		btn.setOnAction(event -> {
			Event.fireEvent(btnAdd, event);			// ��������� ��� ������ btn ��� �� ����������, ��� � ��� btnAdd
		});
		
			// ��������� ���������� ����������� ����� ��������� ������������ ���� � ������� SETDISABLE()
//		btnDivision.setDisable(true);
		
			// �������� ����������� EventHandler, ���������� ������� setOnAction()
//		btnAdd.setOnAction(null);
		
			// �������� ����������� EventHandler, ���������� ������� addEventHandler()
		// ������� ����� ��������� ������ �� ����������
		EventHandler<ActionEvent> handler = event -> {
			iCounter = iCounter*2;
			lbl.setText(Double.toString(iCounter));
		};
		btnMultiply.addEventHandler(ActionEvent.ACTION, handler);
//		btnMultiply.removeEventHandler(ActionEvent.ACTION, handler);
		
			// �������� ����������� EventFilter, ���������� ������� addEventFilter()
		// ������� ����� ��������� ������ �� ����������
		EventHandler<ActionEvent> filter = event -> {
			System.out.println("������ EventFilter ��� ������ Multiply");
		};
		btnMultiply.addEventFilter(ActionEvent.ACTION, filter);
		btnMultiply.removeEventFilter(ActionEvent.ACTION, filter);
		
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btnAdd, btnSubtract, btnDivision, btnMultiply, btn, lbl);
		
			// ���������� HANDLER ��� PANE  - ��������� HANDLER ��� ���� ����� � ���� PANE 
		pane.addEventHandler(ActionEvent.ACTION, event -> {
			System.out.println("������ handler ��� HBOX PANE");
		});
		
		Scene scene = new Scene(pane, 400, 400);
		
			// ���������� HANDLER ��� SCENE  - ��������� HANDLER ��� ���� ����� � ���� SCENE 
		scene.addEventHandler(ActionEvent.ACTION, event -> {
			System.out.println("������ handler ��� SCENE");
		});
			/* 	��������� ������ HANDLER ��� ��������� APP
			  - Stage - Filter
			  - Scene - Filter
			  - Pane - Filter
			  - Button - Filter
			  - Button - Handler
			  - Button - setonAction()
			  - Pane - Handler
			  - Scene - Handler
			  - Stage - Handler		 */
		
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
