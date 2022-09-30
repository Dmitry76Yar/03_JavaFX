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

// Наследование Object -EventObject - Event - InputEvent - KeyEvent 

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
		
			// УСТАНОВКА ОБРАБОТЧИКА НА НАЖАТИЕ ЛЮБОЙ КЛАВИШИ КЛАВИАТУРЫ
		primaryStage.addEventHandler(KeyEvent.ANY, event -> {
//		  System.out.println("Реакция на нажатие любой клавиши  " + event.getEventType());	
		});
		
			/* УСТАНОВКА ОБРАБОТЧИКА НАЖАТИЯ НА КЛАВИШУ    При постоянном нажатии на клавишу событие генерируется постоянно			 */
				// Из Stage addEventHandler(EventType<KeyEvent> KEY_PRESSED)
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			  System.out.println("Реакция на нажатие любой клавиши из Stage  " + event.getEventType());	
			});
				// Из Scene setOnKeyPressed(EventHandler event)
		scene.setOnKeyPressed(event -> {
			  System.out.println("Реакция на нажатие любой клавиши  из Scene " + event.getEventType());
			});
				// Из Node setOnKeyPressed(EventHandler event)
		txf.setOnKeyPressed(event -> {
		  System.out.println("Реакция на нажатие любой клавиши  из Node (TextField) " + event.getEventType());
		});
		
				// УСТАНОВКА ОБРАБОТЧИКА ОТПУСКАНИЯ РАНЕЕ НАЖАТОЙ КЛАВИШИ    
				// Из Stage addEventHandler(EventType<KeyEvent> KEY_RELEASED)
		primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
			  System.out.println("Реакция на отпускание любой клавиши из Stage  " + event.getEventType());	
			});
				// Из Scene setOnKeyReleased(EventHandler event)
		scene.setOnKeyReleased(event -> {
			  System.out.println("Реакция на отпускание любой клавиши  из Scene " + event.getEventType());
			});
				// Из Node setOnKeyReleased(EventHandler event)
		txf.setOnKeyReleased(event -> {
		  System.out.println("Реакция на отпускание любой клавиши  из Node (TextField) " + event.getEventType());
		});
		
			// УСТАНОВКА ОБРАБОТЧИКА ПРИ ВВОДЕ СИМВОЛА UNICODE    При нажатии функц. клавиш не генерится (Ctrl, Alr, Shift)    
				// Из Stage addEventHandler(EventType<KeyEvent> KEY_TYPED)
		primaryStage.addEventHandler(KeyEvent.KEY_TYPED, event -> {
			  System.out.println("Реакция на ввод символа Unicode из Stage  " + event.getEventType());	
			});
				// Из Scene setOnKeyTyped(EventHandler event)
		scene.setOnKeyTyped(event -> {
			  System.out.println("Реакция на ввод символа Unicode из Scene " + event.getEventType());
			});
				// Из Node setOnKeyTyped(EventHandler event)
		txf.setOnKeyTyped(event -> {
		  System.out.println("Реакция на ввод символа Unicode из Node (TextField) " + event.getEventType());
		});
		
				/* ПОЛУЧЕНИЕ ИНФОРМАЦИИ О НАЖАТОЙ КЛАВИШЕ
			 	Метод getCode() для обработчика KeyEvent.KEY_PRESSED и KeyEvent.KEY_TYPED - возвращает константу из KeyCode, 
			 которая соответствует нажатой клавише.   Для функциональеных клавиш для обработчика KeyEvent.KEY_TYPED возвращает
			 константу KeyCode.UNDEFINED 			 
			 	Метод getText() возвращает текстовое представление нажатой клавиши. Для функциональеных клавиш -пробел.
			 	Метод getCharacter() возвращает символьное представление нажатой клавиши для для обработчика KeyEvent.KEY_TYPED.
			  Для KeyEvent.KEY_PRESSED и KeyEvent.KEY_RELEASED возвращает значение KeyEvent.CHAR_UNDEFINeD
			    Методы учитывают 
			  - getCode() не учитывает ни языка раскладки, ни регистра
			  - getText() учитывает язык раскладки, но не учитывает регистра (воспринимает Shift, как отдельное нажатие)
			  - getCharacter() учитывает язык раскладки и регистр (учитывает нажатие Shift)
			  Поэтоме getCharacter() предпочтительный, т.к. не нужно делать доп.проверок
			 */
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			  System.out.println("Нажата клавиша c кодом " + event.getCode() + " и с текстом " + event.getText());	
			  if (event.getText().equals("ы")) System.out.println("Была нажата клавиша ы");
			});
		
		primaryStage.addEventHandler(KeyEvent.KEY_TYPED, event -> {
			  System.out.println("Нажата клавиша c кодом " + event.getCode() + " и с текстом " + event.getText() + 
					  "  и с символом "+ event.getCharacter());	
			  if (event.getText().equals("Я")) System.out.println("Была нажата клавиша Я");    // Возвращает строковое представление
			});
		
		
			// МЕТОДЫ ДОПОЛНИТЕЛЬНЫХ ПРОВЕРОК
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			System.out.println("Был зажат Shift " + event.isShiftDown());
			System.out.println("Был зажат Alt " + event.isAltDown());
			System.out.println("Был зажат Ctrl " + event.isControlDown());
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
