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

// Наследование Object -EventObject - Event - InputEvent - MouseEvent 

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
		
				// УСТАНОВКА ОБРАБОТЧИКА НА ЛЮБОЕ ДВИЖЕНИЯ МЫШИ
		primaryStage.addEventHandler(MouseEvent.ANY, event -> {
//		  System.out.println("Реакция на любое движение мыши " + event.getEventType());	
		});
		
				/* УСТАНОВКА ОБРАБОТЧИКА НАЖАТИЯ КНОПКИ МЫШИ		 При постоянном нажатии на клавишу событие генерируется постоянно			 */
			// Из Stage addEventHandler(EventType<MouseEvent> MOUSE_PRESSED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			  System.out.println("Реакция на нажатие любой кнопки мыши из Stage  " + event.getEventType());	
			});
			// Из Scene setOnMousePressed(EventHandler event)
		scene.setOnMousePressed(event -> {
			  System.out.println("Реакция на нажатие любой кнопки мыши из Scene " + event.getEventType());
			});
			// Из Node setOnMousePressed(EventHandler event)
		txf.setOnMousePressed(event -> {
		  System.out.println("Реакция на нажатие любой кнопки мыши из Node (TextField) " + event.getEventType());
		});
		
				// УСТАНОВКА ОБРАБОТЧИКА ОТПУСКАНИЯ РАНЕЕ НАЖАТОЙ КНОПКИ МЫШИ    
			// Из Stage addEventHandler(EventType<MouseEvent> MOUSE_RELEASED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			  System.out.println("Реакция на отпускание клавиши мыши из Stage  " + event.getEventType());	
			});
			// Из Scene setOnMouseReleased(EventHandler event)
		scene.setOnMouseReleased(event -> {
			  System.out.println("Реакция на отпускание клавиши мыши из Scene " + event.getEventType());
			});
			// Из Node setOnMouseReleased(EventHandler event)
		txf.setOnMouseReleased(event -> {
		  System.out.println("Реакция на отпускание клавиши мыши из Node (TextField) " + event.getEventType());
		});
		
				// УСТАНОВКА ЩЕЛЧКА МЫШИ    
			// Из Stage addEventHandler(EventType<MouseEvent> MOUSE_CLICKED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			  System.out.println("Реакция на щелчок мыши из Stage  " + event.getEventType());	
			});
			// Из Scene setOnMouseClicked(EventHandler event)
		scene.setOnMouseClicked(event -> {
			  System.out.println("Реакция на щелчок мыши из Scene " + event.getEventType());
			});
			// Из Node setOnMouseReleased(EventHandler event)
		txf.setOnMouseClicked(event -> {
		  System.out.println("Реакция на щелчок мыши из Node (TextField) " + event.getEventType());
		});
		
				// УСТАНОВКА ПЕРЕМЕЩЕНИЯ УКАЗАТЕЛЯ МЫШИ БЕЗ НАЖАТИЯ    
			// Из Stage addEventHandler(EventType<MouseEvent> MOUSE_MOVED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
//			  System.out.println("Реакция на перемещение указателя мыши без нажатия из Stage  " + event.getEventType());	
		});
			// Из Scene setOnMouseMoved(EventHandler event)
		scene.setOnMouseMoved(event -> {
//			System.out.println("Реакция на перемещение указателя мыши без нажатия из Scene " + event.getEventType());
		});
			// Из Node setOnMouseMoved(EventHandler event)
		txf.setOnMouseMoved(event -> {
//			  System.out.println("Реакция на перемещение указателя мыши без нажатия из Node (TextField) " + event.getEventType());
		});
		
				// УСТАНОВКА ПЕРЕМЕЩЕНИЯ УКАЗАТЕЛЯ МЫШИ С ЗАЖАТИЕМ КЛАВИШИ    
			// Из Stage addEventHandler(EventType<MouseEvent> MOUSE_DRAGGED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
			System.out.println("Реакция на перемещение указателя мыши с зажатой кнопкой мыши из Stage  " + event.getEventType());	
		});
			// Из Scene setOnMouseDragged(EventHandler event)
		scene.setOnMouseDragged(event -> {
			System.out.println("Реакция на перемещение указателя мыши с зажатой кнопкой мыши из Scene " + event.getEventType());
		});
			// Из Node setOnMouseDragged(EventHandler event)
		txf.setOnMouseDragged(event -> {
			System.out.println("Реакция на перемещение указателя мыши с зажатой кнопкой мыши из Node (TextField) " + event.getEventType());
		});
		
				// УСТАНОВКА НАЧАЛА ПРОЦЕССА ПЕРЕТАСКИВАНИЯ     
			// Из Stage addEventHandler(EventType<MouseEvent> DRAG_DETECTED)
		primaryStage.addEventHandler(MouseEvent.DRAG_DETECTED, event -> {
			System.out.println("Начало процесса перетаскивания  из Stage  " + event.getEventType());	
		});
			// Из Scene setOnDragDetected(EventHandler event)
		scene.setOnDragDetected(event -> {
			System.out.println("Начало процесса перетаскивания из Scene " + event.getEventType());
		});
			// Из Node setOnDragDetected(EventHandler event)
		txf.setOnDragDetected(event -> {
			System.out.println("Начало процесса перетаскивания из Node (TextField) " + event.getEventType());
		});
			
				// УСТАНОВКА MOUSE_ENTERED НАВЕДЕНИЕ УКАЗАТЕЛЯ МЫШИ НА УЗЕЛ         Событие доставляется только узлу
			// Из Stage addEventHandler(EventType<MouseEvent> MOUSE_ENTERED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
//			System.out.println("Наведение указателя мыши на узел из Stage  " + event.getEventType());	
		});
			// Из Scene setOnMouseEntered(EventHandler event)
		scene.setOnMouseEntered(event -> {
//			System.out.println("Наведение указателя мыши на узел из Scene " + event.getEventType());
		});
			// Из Node setOnMouseEntered(EventHandler event)
		txf.setOnMouseEntered(event -> {
//			txf.setText("Курсор мыши наведен на TextField");
//			System.out.println("Наведение указателя мыши на узел из Node (TextField) " + event.getEventType());
		});
		
				// УСТАНОВКА MOUSE_EXITED ВЫВЕДЕНИЕ УКАЗАТЕЛЯ МЫШИ ИЗ УЗЛА       Событие доставляется только узлу
			// Из Stage addEventHandler(EventType<MouseEvent> MOUSE_EXITED)
		primaryStage.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
//			System.out.println("Выведение указателя мыши из узла из Stage  " + event.getEventType());	
		});
			// Из Scene setOnMouseExited(EventHandler event)
		scene.setOnMouseExited(event -> {
//			System.out.println("Выведение указателя мыши из узла из Scene " + event.getEventType());
		});
			// Из Node setOnMouseExited(EventHandler event)
		txf.setOnMouseExited(event -> {
//			txf.setText("Курсор мыши выведен из TextField");
//			System.out.println("Выведение указателя мыши из узла из Node (TextField) " + event.getEventType());
		});

			/* УСТАНОВКА MOUSE_ENTERED_TARGET НАВЕДЕНИЕ УКАЗАТЕЛЯ МЫШИ НА УЗЕЛ
			   УСТАНОВКА MOUSE_EXITED_TARGET ВЫВЕДЕНИЕ УКАЗАТЕЛЯ МЫШИ ИЗ УЗЛА       
		Аналогично MOUSE_ENTERED, но с тем отличием, что, например, при установке на Scene
		 - MOUSE_ENTERED - при вхождении мыши в узел, сгенериться событие вхождение мыши только внутрь сцены
		 - MOUSE_ENTERED_TARGET - при вхождении мыши в узел, сгенериться событие вхождение мыши последовательно: внутрь сцены,
		 внутрь контейнера, внутрь узла.  Чтобы определить какой объект яв-ся целью вызывает метод getTarget() через объект события	 */
		
			// ОБРАБОТЧИК НАВЕДЕНИЯ УКАЗАТЕЛЯ НА УЗЕЛ ЧЕРЕЗ МЕТОД  ISHOVER()
		if (txf.isHover()) {
			System.out.println("vdfmnvfndn");
			txf.setText("Курсор вошел в TextField");
		}
		
				/* ПОЛУЧЕНИЕ ИНФОРМАЦИИ О НАЖАТОЙ КЛАВИШЕ
		Метод getButton() возвращает какая кнопка мыши была нажата- NONE, PRIMARY(левая), SECONDARY(правая) и MIDDLE(средняя)
		Методы isPrimaryButtonDown(), isMiddleButtonDown() и isSecondaryButtonDown() - определяют была ли нажата определенная кнопка
		Метод getClickCount() считает кол-во нажатий на клавишу "в ряд" (без паузы между нажатиями)		 	 */
		primaryStage.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			  System.out.println("Была нажата клавиша мыши  " + event.getButton());	
			  System.out.println("Была нажата левая клавиша мыши?  " + event.isPrimaryButtonDown());
			  System.out.println("Была нажата средняя клавиша мыши?  " + event.isMiddleButtonDown());
			  System.out.println("Была нажата правая клавиша мыши?  " + event.isSecondaryButtonDown());
			  System.out.println("Клавиша мыши была нажата количество раз =  " + event.getClickCount());
		});
		
				/* ПОЛУЧЕНИЕ КООРДИНАТ УКАЗАТЕЛЯ МЫШИ
		Методы getX, getY, getZ - Возвращает координаты мыши относительно левого верхнего угла узла, для которого вызывается 
		Методы getSceneX, getSceneY - Возвращает координаты мыши относительно левого верхнего угла Scene
		Методы getScreenX, getScreenY  - Возвращает координаты мыши относительно левого верхнего угла экрана 		 */
		primaryStage.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
			System.out.println("Координаты мыши относительно левого верхнего угла Stage - " + 
						event.getX() + "  " + event.getY() + "  " + event.getZ());
			System.out.println("Координаты мыши относительно левого верхнего угла Scene - " + 
					event.getSceneX() + "  " + event.getSceneY());
			System.out.println("Координаты мыши относительно левого верхнего угла экрана - " + 
					event.getScreenX() + "  " + event.getScreenY());
		});
			// Из Node setOnMouseMoved(EventHandler event)
		txf.setOnMouseMoved(event -> {
			System.out.println("Координаты мыши относительно левого верхнего угла TextField - " + 
						event.getX() + "  " + event.getY() + "  " + event.getZ());
		});
		
			// ПРОВЕРКА ЗАЖАТИЯ SHIFT, ALT, CTRL
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			System.out.println("Был зажат Shift " + event.isShiftDown());
			System.out.println("Был зажат Alt " + event.isAltDown());
			System.out.println("Был зажат Ctrl " + event.isControlDown());
			});
				
			/* ПРОВЕРКА НАЧАЛА ПЕРЕТАСКИВАНИЯ
		Метод isDragDetected() - возвращает true, если возникло событие DRAG_DETECTED (начало перетаскивания)  */
		
			/* ПРОВЕРКА ДВИГАЛАСЬ ЛИ МЫШЬ
		Метод isStillSincePress() - возвращает true, если мышь не двигалась между событиями */
		primaryStage.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
			  System.out.println("Мышь двигалась между событиями? " + event.isStillSincePress());	
		});
			
			/* ПРОВЕРКА ПРИВЕЛО ЛИ СОБЫТИЕ К ОТРЫТИЮ ВСПЛЫВАЮЩЕГО ОКНА
		Метод isPopupTrigger()*/
		
/*---------------------------- ----------------------------------------------------------------------------------------------------
			 * ПРОКРУТКА МЫШИ ИЛИ ПРОКРУТКА СЕНСОРНОГО ЭКРАНА       КЛАСС ScrollEvent
		Наследование: Object - EventObject - Event - InputEvent - GestureEvent -ScrollEvent  */
		
				// УСТАНОВКА ОБРАБОТЧИКА НА ЛЮБОЕ СОБЫТИЕ ПРОКРУТКИ
		primaryStage.addEventHandler(ScrollEvent.ANY, event -> {
		  System.out.println("Реакция на любое событие прокрутки " + event.getEventType());	
		});
		
				// ОБРАБОТКА СОБЫТИЯ ПРОКРУТКИ
			// Из Stage addEventHandler(EventType<ScrollEvent> SCROLL)
		primaryStage.addEventHandler(ScrollEvent.SCROLL, event -> {
			System.out.println("Реакция событие прокрутки из Stage  " + event.getEventType());	
		});
			// Из Scene setOnScroll(EventHandler event)
		scene.setOnScroll(event -> {
			  System.out.println("Реакция на событие прокрутки из Scene " + event.getEventType());
		});
			// Из Node setOnScroll(EventHandler event)
		txf.setOnScroll(event -> {
			  System.out.println("Реакция на событие прокрутки из Node (TextField) " + event.getEventType());
		});
		
				/* ОБРАБОТКА НАЧАЛА И КОНЦА ЖЕСТА ПРОКРУТКИ (для колесика мыши событие не генерируется)
			 Из Stage addEventHandler(EventType<ScrollEvent> SCROLL_STARTED) и SCROLL_FINISHED */
		primaryStage.addEventHandler(ScrollEvent.SCROLL_STARTED, event -> {
			System.out.println("Реакция на начало жеста прокрутки из Stage  " + event.getEventType());	
		});
			// Из Scene setOnScrollStarted(EventHandler event) и setOnScrollFinished(EventHandler event)
		scene.setOnScrollStarted(event -> {
			  System.out.println("Реакция на начало жеста прокрутки из Scene " + event.getEventType());
		});
			// Из Node setOnScrollStarted(EventHandler event) и setOnScrollFinished(EventHandler event)
		txf.setOnScrollFinished(event -> {
			  System.out.println("Реакция на конец жеста прокрутки из Node (TextField) " + event.getEventType());
		});
		
			/* МЕТОДЫ ниже наследуются также для класса SCROLL
		Методы getX, getY, getZ - Возвращает координаты мыши относительно левого верхнего угла узла, для которого вызывается 
		Методы getSceneX, getSceneY - Возвращает координаты мыши относительно левого верхнего угла Scene
		Методы getScreenX, getScreenY  - Возвращает координаты мыши относительно левого верхнего угла экрана 		
		Методы isShiftDown, isAltDown и isControlDown - 
		 */

			/* ПОЛУЧЕНИЕ ИНФОРМАЦИИ О ПРОКРУТКЕ МЫШИ
		Метод getDeltaX - возвращает кол-во пикселов для прокрутки по горизонтали  (для мыши нужно зажать Shift и вращать колесо)
		Метод getDeltaY - возвращает кол-во пикселов для прокрутки по вертикали
		Пример ниже для перемещения квадрата на сцене 
		scene.addEventHandler(ScrollEvent.SCROLL, event -> {
			 rectangle.setTranslateX(rectangle.getTranslateX() + event.getDeltaX());
			 rectangle.setTranslateY(rectangle.getTranslateY() + event.getDeltaY());
		});			 */
		scene.setOnScroll(event -> {
			  System.out.println("Реакция на начало жеста прокрутки из Scene " + event.getDeltaX() + "  " + event.getDeltaY());
		});
		
			// МЕТОД ПОЛУЧЕНИЯ МНОЖИТЕЛЯ ДЛЯ ПРЕОБРАЗОВАНИЯ ЕДИНИЦ ВРАЩЕНИЯ В ПИКСЕЛЫ
		scene.addEventHandler(ScrollEvent.SCROLL, event -> {
			 event.getMultiplierX();
			 event.getMultiplierY();
		});

/*---------------------------- ----------------------------------------------------------------------------------------------------
 			  ИЗМЕНЕНИЕ ВНЕШНЕГО ВИДА КУРСОРА МЫШИ 
		Наследование: Object - EventObject - Event - InputEvent - GestureEvent -ScrollEvent  
		В параметр метода setCursor() передается объект класса Cursor: 
		 - или объект Cursor,
		 - или объект ImageCursor,
		 - статические константы : NONE(курсор не отображается), DEFAULT, HAND(рука с указывающим пальцем), CLOSED_HAND (сжатая рука),
		 OPEN_HAND(разжатая рука), WAIT(курсор ожидания), TEXT(текстовый I-образный указатель), CROSSHAIR(крестообразный указатель)...
		*/
		txf.setOnMouseEntered(event -> {
			txf.setText("Курсор мыши наведен на TextField"); 
			System.out.println("Текущий курсор " + txf.getCursor());
			txf.setCursor(Cursor.N_RESIZE);
		});
		txf.setOnMouseExited(event -> { 
			txf.setText("Курсор мыши вышел из TextField");
			txf.setCursor(null);
			});
		
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
