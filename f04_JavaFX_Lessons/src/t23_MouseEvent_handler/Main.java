package t23_MouseEvent_handler;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;

// ������������ Object -EventObject - Event - InputEvent - MouseEvent 

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
		
				// ��������� ����������� �� ����� �������� ����
		primaryStage.addEventHandler(MouseEvent.ANY, event -> {
//		  System.out.println("������� �� ����� �������� ���� " + event.getEventType());	
		});
		
				/* ��������� ����������� ������� ������ ����		 ��� ���������� ������� �� ������� ������� ������������ ���������			 */
			// �� Stage addEventHandler(EventType<MouseEvent> MOUSE_PRESSED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			  System.out.println("������� �� ������� ����� ������ ���� �� Stage  " + event.getEventType());	
			});
			// �� Scene setOnMousePressed(EventHandler event)
		scene.setOnMousePressed(event -> {
			  System.out.println("������� �� ������� ����� ������ ���� �� Scene " + event.getEventType());
			});
			// �� Node setOnMousePressed(EventHandler event)
		txf.setOnMousePressed(event -> {
		  System.out.println("������� �� ������� ����� ������ ���� �� Node (TextField) " + event.getEventType());
		});
		
				// ��������� ����������� ���������� ����� ������� ������ ����    
			// �� Stage addEventHandler(EventType<MouseEvent> MOUSE_RELEASED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			  System.out.println("������� �� ���������� ������� ���� �� Stage  " + event.getEventType());	
			});
			// �� Scene setOnMouseReleased(EventHandler event)
		scene.setOnMouseReleased(event -> {
			  System.out.println("������� �� ���������� ������� ���� �� Scene " + event.getEventType());
			});
			// �� Node setOnMouseReleased(EventHandler event)
		txf.setOnMouseReleased(event -> {
		  System.out.println("������� �� ���������� ������� ���� �� Node (TextField) " + event.getEventType());
		});
		
				// ��������� ������ ����    
			// �� Stage addEventHandler(EventType<MouseEvent> MOUSE_CLICKED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			  System.out.println("������� �� ������ ���� �� Stage  " + event.getEventType());	
			});
			// �� Scene setOnMouseClicked(EventHandler event)
		scene.setOnMouseClicked(event -> {
			  System.out.println("������� �� ������ ���� �� Scene " + event.getEventType());
			});
			// �� Node setOnMouseReleased(EventHandler event)
		txf.setOnMouseClicked(event -> {
		  System.out.println("������� �� ������ ���� �� Node (TextField) " + event.getEventType());
		});
		
				// ��������� ����������� ��������� ���� ��� �������    
			// �� Stage addEventHandler(EventType<MouseEvent> MOUSE_MOVED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
//			  System.out.println("������� �� ����������� ��������� ���� ��� ������� �� Stage  " + event.getEventType());	
		});
			// �� Scene setOnMouseMoved(EventHandler event)
		scene.setOnMouseMoved(event -> {
//			System.out.println("������� �� ����������� ��������� ���� ��� ������� �� Scene " + event.getEventType());
		});
			// �� Node setOnMouseMoved(EventHandler event)
		txf.setOnMouseMoved(event -> {
//			  System.out.println("������� �� ����������� ��������� ���� ��� ������� �� Node (TextField) " + event.getEventType());
		});
		
				// ��������� ����������� ��������� ���� � �������� �������    
			// �� Stage addEventHandler(EventType<MouseEvent> MOUSE_DRAGGED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
			System.out.println("������� �� ����������� ��������� ���� � ������� ������� ���� �� Stage  " + event.getEventType());	
		});
			// �� Scene setOnMouseDragged(EventHandler event)
		scene.setOnMouseDragged(event -> {
			System.out.println("������� �� ����������� ��������� ���� � ������� ������� ���� �� Scene " + event.getEventType());
		});
			// �� Node setOnMouseDragged(EventHandler event)
		txf.setOnMouseDragged(event -> {
			System.out.println("������� �� ����������� ��������� ���� � ������� ������� ���� �� Node (TextField) " + event.getEventType());
		});
		
				// ��������� ������ �������� ��������������     
			// �� Stage addEventHandler(EventType<MouseEvent> DRAG_DETECTED)
		primaryStage.addEventHandler(MouseEvent.DRAG_DETECTED, event -> {
			System.out.println("������ �������� ��������������  �� Stage  " + event.getEventType());	
		});
			// �� Scene setOnDragDetected(EventHandler event)
		scene.setOnDragDetected(event -> {
			System.out.println("������ �������� �������������� �� Scene " + event.getEventType());
		});
			// �� Node setOnDragDetected(EventHandler event)
		txf.setOnDragDetected(event -> {
			System.out.println("������ �������� �������������� �� Node (TextField) " + event.getEventType());
		});
			
				// ��������� MOUSE_ENTERED ��������� ��������� ���� �� ����         ������� ������������ ������ ����
			// �� Stage addEventHandler(EventType<MouseEvent> MOUSE_ENTERED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
//			System.out.println("��������� ��������� ���� �� ���� �� Stage  " + event.getEventType());	
		});
			// �� Scene setOnMouseEntered(EventHandler event)
		scene.setOnMouseEntered(event -> {
//			System.out.println("��������� ��������� ���� �� ���� �� Scene " + event.getEventType());
		});
			// �� Node setOnMouseEntered(EventHandler event)
		txf.setOnMouseEntered(event -> {
//			txf.setText("������ ���� ������� �� TextField");
//			System.out.println("��������� ��������� ���� �� ���� �� Node (TextField) " + event.getEventType());
		});
		
				// ��������� MOUSE_EXITED ��������� ��������� ���� �� ����       ������� ������������ ������ ����
			// �� Stage addEventHandler(EventType<MouseEvent> MOUSE_EXITED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
//			System.out.println("��������� ��������� ���� �� ���� �� Stage  " + event.getEventType());	
		});
			// �� Scene setOnMouseExited(EventHandler event)
		scene.setOnMouseExited(event -> {
//			System.out.println("��������� ��������� ���� �� ���� �� Scene " + event.getEventType());
		});
			// �� Node setOnMouseExited(EventHandler event)
		txf.setOnMouseExited(event -> {
//			txf.setText("������ ���� ������� �� TextField");
//			System.out.println("��������� ��������� ���� �� ���� �� Node (TextField) " + event.getEventType());
		});

			/* ��������� MOUSE_ENTERED_TARGET ��������� ��������� ���� �� ����
			   ��������� MOUSE_EXITED_TARGET ��������� ��������� ���� �� ����       
		���������� MOUSE_ENTERED, �� � ��� ��������, ���, ��������, ��� ��������� �� Scene
		 - MOUSE_ENTERED - ��� ��������� ���� � ����, ����������� ������� ��������� ���� ������ ������ �����
		 - MOUSE_ENTERED_TARGET - ��� ��������� ���� � ����, ����������� ������� ��������� ���� ���������������: ������ �����,
		 ������ ����������, ������ ����.  ����� ���������� ����� ������ ��-�� ����� �������� ����� getTarget() ����� ������ �������	 */
		
			// ���������� ��������� ��������� �� ���� ����� �����  ISHOVER()
		if (txf.isHover()) {
			System.out.println("vdfmnvfndn");
			txf.setText("������ ����� � TextField");
		}
		
				/* ��������� ���������� � ������� �������
		����� getButton() ���������� ����� ������ ���� ���� ������- NONE, PRIMARY(�����), SECONDARY(������) � MIDDLE(�������)
		������ isPrimaryButtonDown(), isMiddleButtonDown() � isSecondaryButtonDown() - ���������� ���� �� ������ ������������ ������
		����� getClickCount() ������� ���-�� ������� �� ������� "� ���" (��� ����� ����� ���������)		 	 */
		primaryStage.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			  System.out.println("���� ������ ������� ����  " + event.getButton());	
			  System.out.println("���� ������ ����� ������� ����?  " + event.isPrimaryButtonDown());
			  System.out.println("���� ������ ������� ������� ����?  " + event.isMiddleButtonDown());
			  System.out.println("���� ������ ������ ������� ����?  " + event.isSecondaryButtonDown());
			  System.out.println("������� ���� ���� ������ ���������� ��� =  " + event.getClickCount());
		});
		
				/* ��������� ��������� ��������� ����
		������ getX, getY, getZ - ���������� ���������� ���� ������������ ������ �������� ���� ����, ��� �������� ���������� 
		������ getSceneX, getSceneY - ���������� ���������� ���� ������������ ������ �������� ���� Scene
		������ getScreenX, getScreenY  - ���������� ���������� ���� ������������ ������ �������� ���� ������ 		 */
		primaryStage.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
			System.out.println("���������� ���� ������������ ������ �������� ���� Stage - " + 
						event.getX() + "  " + event.getY() + "  " + event.getZ());
			System.out.println("���������� ���� ������������ ������ �������� ���� Scene - " + 
					event.getSceneX() + "  " + event.getSceneY());
			System.out.println("���������� ���� ������������ ������ �������� ���� ������ - " + 
					event.getScreenX() + "  " + event.getScreenY());
		});
			// �� Node setOnMouseMoved(EventHandler event)
		txf.setOnMouseMoved(event -> {
			System.out.println("���������� ���� ������������ ������ �������� ���� TextField - " + 
						event.getX() + "  " + event.getY() + "  " + event.getZ());
		});
		
			// �������� ������� SHIFT, ALT, CTRL
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			System.out.println("��� ����� Shift " + event.isShiftDown());
			System.out.println("��� ����� Alt " + event.isAltDown());
			System.out.println("��� ����� Ctrl " + event.isControlDown());
			});
				
			/* �������� ������ ��������������
		����� isDragDetected() - ���������� true, ���� �������� ������� DRAG_DETECTED (������ ��������������)  */
		
			/* �������� ��������� �� ����
		����� isStillSincePress() - ���������� true, ���� ���� �� ��������� ����� ��������� */
		primaryStage.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
			  System.out.println("���� ��������� ����� ���������? " + event.isStillSincePress());	
		});
			
			/* �������� ������� �� ������� � ������� ������������ ����
		����� isPopupTrigger()*/
		
/*---------------------------- ----------------------------------------------------------------------------------------------------
			 * ��������� ���� ��� ��������� ���������� ������       ����� ScrollEvent
		������������: Object - EventObject - Event - InputEvent - GestureEvent -ScrollEvent  */
		
				// ��������� ����������� �� ����� ������� ���������
		primaryStage.addEventHandler(ScrollEvent.ANY, event -> {
		  System.out.println("������� �� ����� ������� ��������� " + event.getEventType());	
		});
		
				// ��������� ������� ���������
			// �� Stage addEventHandler(EventType<ScrollEvent> SCROLL)
		primaryStage.addEventHandler(ScrollEvent.SCROLL, event -> {
			System.out.println("������� ������� ��������� �� Stage  " + event.getEventType());	
		});
			// �� Scene setOnScroll(EventHandler event)
		scene.setOnScroll(event -> {
			  System.out.println("������� �� ������� ��������� �� Scene " + event.getEventType());
		});
			// �� Node setOnScroll(EventHandler event)
		txf.setOnScroll(event -> {
			  System.out.println("������� �� ������� ��������� �� Node (TextField) " + event.getEventType());
		});
		
				/* ��������� ������ � ����� ����� ��������� (��� �������� ���� ������� �� ������������)
			 �� Stage addEventHandler(EventType<ScrollEvent> SCROLL_STARTED) � SCROLL_FINISHED */
		primaryStage.addEventHandler(ScrollEvent.SCROLL_STARTED, event -> {
			System.out.println("������� �� ������ ����� ��������� �� Stage  " + event.getEventType());	
		});
			// �� Scene setOnScrollStarted(EventHandler event) � setOnScrollFinished(EventHandler event)
		scene.setOnScrollStarted(event -> {
			  System.out.println("������� �� ������ ����� ��������� �� Scene " + event.getEventType());
		});
			// �� Node setOnScrollStarted(EventHandler event) � setOnScrollFinished(EventHandler event)
		txf.setOnScrollFinished(event -> {
			  System.out.println("������� �� ����� ����� ��������� �� Node (TextField) " + event.getEventType());
		});
		
			/* ������ ���� ����������� ����� ��� ������ SCROLL
		������ getX, getY, getZ - ���������� ���������� ���� ������������ ������ �������� ���� ����, ��� �������� ���������� 
		������ getSceneX, getSceneY - ���������� ���������� ���� ������������ ������ �������� ���� Scene
		������ getScreenX, getScreenY  - ���������� ���������� ���� ������������ ������ �������� ���� ������ 		
		������ isShiftDown, isAltDown � isControlDown - 
		 */

			/* ��������� ���������� � ��������� ����
		����� getDeltaX - ���������� ���-�� �������� ��� ��������� �� �����������  (��� ���� ����� ������ Shift � ������� ������)
		����� getDeltaY - ���������� ���-�� �������� ��� ��������� �� ���������
		������ ���� ��� ����������� �������� �� ����� 
		scene.addEventHandler(ScrollEvent.SCROLL, event -> {
			 rectangle.setTranslateX(rectangle.getTranslateX() + event.getDeltaX());
			 rectangle.setTranslateY(rectangle.getTranslateY() + event.getDeltaY());
		});			 */
		scene.setOnScroll(event -> {
			  System.out.println("������� �� ������ ����� ��������� �� Scene " + event.getDeltaX() + "  " + event.getDeltaY());
		});
		
			// ����� ��������� ��������� ��� �������������� ������ �������� � �������
		scene.addEventHandler(ScrollEvent.SCROLL, event -> {
			 event.getMultiplierX();
			 event.getMultiplierY();
		});

/*---------------------------- ----------------------------------------------------------------------------------------------------
 			  ��������� �������� ���� ������� ���� 
		������������: Object - EventObject - Event - InputEvent - GestureEvent -ScrollEvent  
		� �������� ������ setCursor() ���������� ������ ������ Cursor: 
		 - ��� ������ Cursor,
		 - ��� ������ ImageCursor,
		 - ����������� ��������� : NONE(������ �� ������������), DEFAULT, HAND(���� � ����������� �������), CLOSED_HAND (������ ����),
		 OPEN_HAND(�������� ����), WAIT(������ ��������), TEXT(��������� I-�������� ���������), CROSSHAIR(�������������� ���������)...
		*/
		txf.setOnMouseEntered(event -> {
			txf.setText("������ ���� ������� �� TextField"); 
			System.out.println("������� ������ " + txf.getCursor());
			txf.setCursor(Cursor.N_RESIZE);
		});
		txf.setOnMouseExited(event -> { 
			txf.setText("������ ���� ����� �� TextField");
			txf.setCursor(null);
			});
		
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
