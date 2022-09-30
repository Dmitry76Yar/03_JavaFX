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
		txtField.setPromptText("Enter ");		// Добавление "тенево" подсказки в поле
		Slider slider = new Slider(0, 100, 0); 
		
/*-----------------------ОБРАБОТЧИКИ НА ОСНОВЕ JAVAFX PROPERTIES-------------------------------------------------------
 		JavaFX-свойству можно назначить обработчик, который будет вызываться при изменении значения свойства.
 		Такие обработчики должны реализовать либо интерфейс InvalidationListener или ChangeListener<T>
 		
 					INVALIDATION LISTENER
 		Интерфейс InvalidationListener описывает события недостоверности значений свойства и имеет один метод invalidated() 
 		Методы для назначения и удаления обработчика события недостоверности описываются в интерфейсе Obversable, который содержит
 		  - метод addListener() для назначения обработчика
 		  - метод removeListener() для удаления обработчика. 
 			 	Обработчик будет вызван только при первом изменении свойства, а потом он вызываться не будет, пока мы не захотим получить 
 		 фактическое значение свойства. Это свяазно с "ленивым" вычислением, когда значения свойства пересчитываются не сразу после
 		 изменения, а только при попытке получить значение свойства		 		 
 		 	 Можно назначить обработчик через код ниже с созданием объекта InvalidationListener и переопределения метода invalidated() или 
 		 через код с лямбда-выражением, т.к. интерфейс InvalidationListener является функциональным.		 		 	 */
		InvalidationListener invListener = new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
//				System.out.println(" Ширина  Scene былa измененa");
			}
		};
		primaryStage.widthProperty().addListener(invListener);
			// Для удаления обработчика нужно
//		primaryStage.widthProperty().removeListener(invListener);
		
			/* Аналогичный результат через лямбда-выражение
		Минус этого способа, что, т.к. ссылка на обработчик не сохраняется за пределами лямбда-выражения, то удалить обработчик не получится 			 */
		primaryStage.widthProperty().addListener(observable -> {
//			System.out.println(" Ширина  Scene былa измененa   ЛЯМБДА-ВЫРАЖЕНИЕ");
//			System.out.println(primaryStage.getWidth());
		});

/*							CHANGE LISTENER																
  		Функциональный интерфейс ChangeListener<T> описывает события изменения значения свойства. 
  		Он содержит метод void changed(ObversableValue<? extends T> obversable, T oldValue, T newValue)
  		Методы обработчика события описываются в интерфейсе ObversableValue, который содержит
 		  - метод addListener() для назначения обработчика
 		  - метод removeListener() для удаления обработчика.
 		  - метод getValue() для возврата нового значения 
  		Через параметр ObversableValue доступны методы, как из интерфейса ObversableValue, так и из интерфейса Obversable, т.к.
  		ObversableValue является наследником Obversable.
  		Параметр oldValue - содержит старое значения свойства, newValue - новое
  			ВАЖНО, что метод вызывается при любом изменении значения свойства и не зависит от "ленивых" вычислений		
  		Можно назначить обработчик через код ниже с созданием объекта ChangeListener и переопределения метода chaged() или 
 		 через код с лямбда-выражением, т.к. интерфейс ChangeListener является функциональным.		 	*/
		ChangeListener<? super Number> changeList = new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("Ширина stage изменилась с " + oldValue + "  на " + newValue);
			}
		};
		primaryStage.widthProperty().addListener(changeList);
			// Для удаления обработчика нужно
//		primaryStage.widthProperty().removeListener(changeList);
		
			/* Аналогичный результат через лямбда-выражение
		Минус этого способа, что, т.к. ссылка на обработчик не сохраняется за пределами лямбда-выражения, то удалить обработчик не получится 			 */
		primaryStage.widthProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Через ЛЯМБДА-ВЫРАЖЕНИЕ Ширина stage изменилась с " + oldValue + "  на " + newValue);
		});

/*------------------------------------ДРУГИЕ ПРИМЕРЫ ОТСЛЕЖИВАНИЯ СВОЙСТВ-----------------------------------------------------*/
			// Пример для отслеживания значения ползунка
		slider.valueProperty().addListener((obj, oldValue, newValue) -> {
				System.out.println("Значение ползунка изменилось с " + oldValue + " на " + newValue);
		});
			// Пример для отслеживания изменения надписи в TextField
		txtField.textProperty().addListener((listener, oldValue, newValue) -> {
			System.out.println("Изменилось надпись на txtField c " + oldValue + "  на " + newValue);
		});
			// Изменение положения и размера окна     xProperty  и yProperty   
		primaryStage.xProperty().addListener((listener, oldValue, newValue) -> {
//			System.out.println("Координата Х левого верхнего угла окна изменилась с " + oldValue + "  на " + newValue);
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
