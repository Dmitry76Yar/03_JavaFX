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
		
			/* Установить событие можно через
		 - методы setOn, например, setOnAction()
		 - метод addEventHandler()
		 - метод addEventFilter() - определяет обработчик до основого обработчика addEventHandler()
		     	ПРИОРИТЕТ ВЫЗОВА HANDLER ДЛЯ УЗЛА
		 	 Приоритет вызова = addEventFilter() -> addEventHandler() -> setOnAction()
		     C помошью addEventHandler() и addEventFilter() можно задать несколько обработчиков, последовательность в этом случае будет
		  Filter1 -> Filter2 -> Handler1 -> Handler2 -> setOnAction()		 */
		
			// УСТАНОВКА HANDLER С ПОМОЩЬЮ МЕТОДОВ SetOn  Например, setOnAction()
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
		
			// УСТАНОВКА HANDLER С ПОМОЩЬЮ МЕТОДA AddEventHandler()
		btnDivision.addEventHandler(ActionEvent.ACTION, event -> {
			iCounter = iCounter/2;
			lbl.setText(Double.toString(iCounter));
		});
		
			/* НАЗНАЧЕНИЕ ОБРАБОТКИ ПРЕДШЕСТВУЮЩЕЙ ОСНОВНОЙ ОБРАБОТКЕ С ПОМОЩЬЮ МЕТОДA AddEventFilter()
			Обработчик AddEventFilter() вызыается перед обработчиком AddEventHandler()	
			Если внутри обработчика AddEventFilter() вызвать consume, то AddEventHandler() вызван не будет */
		btnDivision.addEventFilter(ActionEvent.ACTION, eventFilter -> {
			System.out.println("Был вызван AddEventFilter() ");
//			eventFilter.consume();
		});
		
			/* УСТАНОВКА HANDLER ДЛЯ ОДНОГО УЗЛА, ТАКОГО ЖЕ КАК ДЛЯ ДРУГОГО УЗЛА
		Удобно использовать, например, при нажатии Enter для завершения ввода в поле  */
		btn.setOnAction(event -> {
			Event.fireEvent(btnAdd, event);			// Назначает для кнопки btn тот же обработчик, что и для btnAdd
		});
		
			// ВРЕМЕННАЯ БЛОКИРОВКА ОБРАБОТЧИКА ЧЕРЕЗ УСТАНОВКУ НЕАКТИВНОСТИ УЗЛА С ПОМОЩЬЮ SETDISABLE()
//		btnDivision.setDisable(true);
		
			// УДАЛЕНИЕ ОБРАБОТЧИКА EventHandler, вызванного методом setOnAction()
//		btnAdd.setOnAction(null);
		
			// УДАЛЕНИЕ ОБРАБОТЧИКА EventHandler, вызванного методом addEventHandler()
		// Сначала нужно сохранить ссылку на обработчик
		EventHandler<ActionEvent> handler = event -> {
			iCounter = iCounter*2;
			lbl.setText(Double.toString(iCounter));
		};
		btnMultiply.addEventHandler(ActionEvent.ACTION, handler);
//		btnMultiply.removeEventHandler(ActionEvent.ACTION, handler);
		
			// УДАЛЕНИЕ ОБРАБОТЧИКА EventFilter, вызванного методом addEventFilter()
		// Сначала нужно сохранить ссылку на обработчик
		EventHandler<ActionEvent> filter = event -> {
			System.out.println("Вызван EventFilter для кнопки Multiply");
		};
		btnMultiply.addEventFilter(ActionEvent.ACTION, filter);
		btnMultiply.removeEventFilter(ActionEvent.ACTION, filter);
		
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btnAdd, btnSubtract, btnDivision, btnMultiply, btn, lbl);
		
			// НАЗНАЧЕНИЕ HANDLER ДЛЯ PANE  - АКТИВАЦИЯ HANDLER ДЛЯ ВСЕХ УЗЛОВ В ЭТОМ PANE 
		pane.addEventHandler(ActionEvent.ACTION, event -> {
			System.out.println("Вызван handler для HBOX PANE");
		});
		
		Scene scene = new Scene(pane, 400, 400);
		
			// НАЗНАЧЕНИЕ HANDLER ДЛЯ SCENE  - АКТИВАЦИЯ HANDLER ДЛЯ ВСЕХ УЗЛОВ В ЭТОМ SCENE 
		scene.addEventHandler(ActionEvent.ACTION, event -> {
			System.out.println("Вызван handler для SCENE");
		});
			/* 	ПРИОРИТЕТ ВЫЗОВА HANDLER ДЛЯ ЭЛЕМЕНТОВ APP
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
