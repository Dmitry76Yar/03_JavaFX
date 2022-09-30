package t22_KeyEvent_handler;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.event.*;
import javafx.geometry.Pos;

// ������������ Object -EventObject - Event - InputEvent - KeyEvent 

public class Main extends Application  {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {			
		btnAdd = new Button();			btnAdd.setText("Add");				
		btnSubtract = new Button();		btnSubtract.setText("Substract");	
		btnDivision = new Button();		btnDivision.setText("Division");	
		btnMultiply = new Button();		btnMultiply.setText("Multiply");	
		lbl = new Label();				lbl.setText(Double.toString(iCounter)); 
		TextField txf = new TextField("TextField");
		
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btnAdd, btnSubtract, btnDivision, btnMultiply, lbl, txf);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		
			// ��������� ����������� �� ������� ����� ������� ����������
		primaryStage.addEventHandler(KeyEvent.ANY, event -> {
//		  System.out.println("������� �� ������� ����� �������  " + event.getEventType());	
		});
		
			/* ��������� ����������� ������� �� �������    ��� ���������� ������� �� ������� ������� ������������ ���������			 */
				// �� Stage addEventHandler(EventType<KeyEvent> KEY_PRESSED)
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			  System.out.println("������� �� ������� ����� ������� �� Stage  " + event.getEventType());	
			});
				// �� Scene setOnKeyPressed(EventHandler event)
		scene.setOnKeyPressed(event -> {
			  System.out.println("������� �� ������� ����� �������  �� Scene " + event.getEventType());
			});
				// �� Node setOnKeyPressed(EventHandler event)
		txf.setOnKeyPressed(event -> {
		  System.out.println("������� �� ������� ����� �������  �� Node (TextField) " + event.getEventType());
		});
		
				// ��������� ����������� ���������� ����� ������� �������    
				// �� Stage addEventHandler(EventType<KeyEvent> KEY_RELEASED)
		primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
			  System.out.println("������� �� ���������� ����� ������� �� Stage  " + event.getEventType());	
			});
				// �� Scene setOnKeyReleased(EventHandler event)
		scene.setOnKeyReleased(event -> {
			  System.out.println("������� �� ���������� ����� �������  �� Scene " + event.getEventType());
			});
				// �� Node setOnKeyReleased(EventHandler event)
		txf.setOnKeyReleased(event -> {
		  System.out.println("������� �� ���������� ����� �������  �� Node (TextField) " + event.getEventType());
		});
		
			// ��������� ����������� ��� ����� ������� UNICODE    ��� ������� �����. ������ �� ��������� (Ctrl, Alr, Shift)    
				// �� Stage addEventHandler(EventType<KeyEvent> KEY_TYPED)
		primaryStage.addEventHandler(KeyEvent.KEY_TYPED, event -> {
			  System.out.println("������� �� ���� ������� Unicode �� Stage  " + event.getEventType());	
			});
				// �� Scene setOnKeyTyped(EventHandler event)
		scene.setOnKeyTyped(event -> {
			  System.out.println("������� �� ���� ������� Unicode �� Scene " + event.getEventType());
			});
				// �� Node setOnKeyTyped(EventHandler event)
		txf.setOnKeyTyped(event -> {
		  System.out.println("������� �� ���� ������� Unicode �� Node (TextField) " + event.getEventType());
		});
		
				/* ��������� ���������� � ������� �������
			 	����� getCode() ��� ����������� KeyEvent.KEY_PRESSED � KeyEvent.KEY_TYPED - ���������� ��������� �� KeyCode, 
			 ������� ������������� ������� �������.   ��� ��������������� ������ ��� ����������� KeyEvent.KEY_TYPED ����������
			 ��������� KeyCode.UNDEFINED 			 
			 	����� getText() ���������� ��������� ������������� ������� �������. ��� ��������������� ������ -������.
			 	����� getCharacter() ���������� ���������� ������������� ������� ������� ��� ��� ����������� KeyEvent.KEY_TYPED.
			  ��� KeyEvent.KEY_PRESSED � KeyEvent.KEY_RELEASED ���������� �������� KeyEvent.CHAR_UNDEFINeD
			    ������ ��������� 
			  - getCode() �� ��������� �� ����� ���������, �� ��������
			  - getText() ��������� ���� ���������, �� �� ��������� �������� (������������ Shift, ��� ��������� �������)
			  - getCharacter() ��������� ���� ��������� � ������� (��������� ������� Shift)
			  ������� getCharacter() ����������������, �.�. �� ����� ������ ���.��������
			 */
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			  System.out.println("������ ������� c ����� " + event.getCode() + " � � ������� " + event.getText());	
			  if (event.getText().equals("�")) System.out.println("���� ������ ������� �");
			});
		
		primaryStage.addEventHandler(KeyEvent.KEY_TYPED, event -> {
			  System.out.println("������ ������� c ����� " + event.getCode() + " � � ������� " + event.getText() + 
					  "  � � �������� "+ event.getCharacter());	
			  if (event.getText().equals("�")) System.out.println("���� ������ ������� �");    // ���������� ��������� �������������
			});
		
		
			// ������ �������������� ��������
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			System.out.println("��� ����� Shift " + event.isShiftDown());
			System.out.println("��� ����� Alt " + event.isAltDown());
			System.out.println("��� ����� Ctrl " + event.isControlDown());
			});
				
		scene.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				System.out.println("dvndfmv");
				txf.requestFocus();
			}
		});
		
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
