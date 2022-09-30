package t21_JavaFX_Properties_Bound_events;
	
import java.text.NumberFormat;
import java.util.Locale;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.event.*;
import javafx.geometry.Insets;

public class Main extends Application  {
	Button button, button2;
	Label lbl;
	TextField txtField, txtField1, txtField2 ;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {			
		button = new Button();			button.setText("BUTTON");				
		button2 = new Button();			button2.setText("BUTTON2");
		lbl = new Label("LABEL");		
		txtField = new TextField();		txtField.setMinWidth(70);	txtField.setMaxWidth(70);	txtField.setPromptText("Enter ");		
		txtField1 = new TextField();	txtField1.setMinWidth(70);	txtField1.setMaxWidth(70);	txtField1.setPromptText("Enter2 ");
		txtField2 = new TextField();	txtField2.setMinWidth(70);	txtField2.setMaxWidth(70);	txtField2.setPromptText("Enter2 ");
		Slider slider = new Slider(0, 100, 0); 				Slider slider1 = new Slider(0, 100, 0);
		Slider slider2 = new Slider(0, 100, 0); 			Slider slider3 = new Slider(0, 100, 0);
		Slider slider4 = new Slider(0, 100, 0); 			Slider slider5 = new Slider(0, 100, 0);
		Rectangle rectan = new Rectangle(50,50,Color.BEIGE);		
		rectan.setStroke(Color.BLACK);				// Цвет обводки
		rectan.setStrokeWidth(3.0);				// Толщина обводки
		
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

/*------------------------------------ДВУХНАПРАВЛЕННОЕ ИЗМЕНЕНИЕ------------------------------------------------------------------
 		Мы можем связать значение одного свойства со значением другого свойства. Если изменится значение первого свойства, то
 		изменится и значение второго свойства */
			// Изменение ползунка приводит к изменению ширины прямоугольника
		slider.valueProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Значение ползунка изменилось с " + oldValue + " на " + newValue);
			rectan.setWidth((Double)newValue);
		});
			// Изменение значения ширины прямоугольника при вводе значения в TextField меняет ползунок
		txtField.textProperty().addListener((listener, oldValue, newValue) -> {
			System.out.println("Изменилось надпись на txtField c " + oldValue + "  на " + newValue);
			rectan.setWidth(Double.parseDouble(newValue));
		});
			/* Метод bindBidirectional(Property other) устанавливает двухнаправленную связь положения ползунка и ширины прямоугольника
		Этот метод объявлен в интерфейсе Property<T>, который реализует все свойства в JAVAFX	*/
		rectan.widthProperty().bindBidirectional(slider.valueProperty());	
		
			/* КОНВЕРТИРОВАНИЕ из разных форматов Properties
		В примере выше конвертирование текста из TextField в числа происходит черех parse(), но у Properties есть свои конверторы
		В примере ниже для 3 строки узлов используется другие формата метода bindBidirectional()
			- void bindBidirectional(Property<T> other, StringConverter<T> converter)
			- void bindBidirectional(Property<?> other, Format format)  
		 	Абстрактный класс  StringConverter наследуют классы очень много конвертеров: BooleanStringConverter, NumberStringConverter,
		 IntegerStringConverter, DoubleStringConverter, DateTimeStringConverter, LocalDateTimeStringConverter....
		 	Абстракный класс Format наследуют много классов: NumberFormat, DateFormat, MessageFormat...		*/
		txtField1.textProperty().bindBidirectional(slider1.valueProperty(), new NumberStringConverter());
//		txtField1.textProperty().bindBidirectional(slider1.valueProperty(), NumberFormat.getInstance());

			// ОТМЕНА ДВУХНАПРАВЛЕННОЙ СВЯЗИ
//		txtField1.textProperty().unbindBidirectional(slider1.valueProperty());
		
/*------------------------------------ОДНОНАПРАВЛЕННОЕ ИЗМЕНЕНИЕ------------------------------------------------------------------
 		Пример ниже показывает однонаправленное связывание двух ползунков	 - при изменении ползунка slider3 
 		будет проиходить изменение ползунка slider2
 		При этом изменение ползунка slider2 явным образом будет нельзя и перетянуть нельзя  */
		System.out.println("Ползунок slider2 связан " + slider2.valueProperty().isBound());
		slider2.valueProperty().bind(slider3.valueProperty());		// Связывание
		System.out.println("Ползунок slider2 связан " + slider2.valueProperty().isBound());
		
//		button.disabledProperty().bind(txtField.textProperty());
			
			// ОТМЕНА ОДНОАПРАВЛЕННОЙ СВЯЗИ
//		slider2.valueProperty().unbind();
		
/*------------------------------------ВЫРАЖЕНИЯ В СВЯЗАННЫХ ИЗМЕНЕНИЯХ СВОЙСТВ------------------------------------------------------------------
   Работает для того случая, когда нужно, чтобы значение одного свойства отличалась от значения другого на какое-либо число.
   Например, чтобы значение второго ползунка было всегда больше на 30, чем значение первого ползунка
   В этом случае полезны выражения: BooleanExpresion, IntegerExpression, LongExpression, DoubleExpression, StringExpression, ObjectExpression */
		slider4.valueProperty().bind(slider5.valueProperty().subtract(30));		// Связывание и вычитание 30
		slider4.valueProperty().bind(slider5.valueProperty().multiply(1.2));	// Связывание и умножение
		slider4.valueProperty().bind(slider5.valueProperty().divide(1.2));		// Связывание и деление
//		slider4.valueProperty().bind(slider5.valueProperty().negate());			// Изменяет знак на противоположный
		slider4.valueProperty().bind(slider5.valueProperty().add(30));			// Связывание и добваление 30

/* -------------------------------------ПРЕОБРАЗОВАНИЯ ФОРМАТОВ В СВОЙСТВАХ------------------------------------------------------
 		int property.intValue()
 		long property.longVaue()
 		float property.floatValue()
 		double property.doubleValue()		 */
		
/* -------------------------------------ОПЕРАЦИИ СРАВНЕНИЯ СВОЙСТВ------------------------------------------------------
 	В классе NumberExpression, наследниками которого являются IntegerExpression, LongExpression, DoubleExpression...., определены
 	методы сравнения: greatherThan(),  greatherThanOrEqual(), isEqualTo(), isNotEqualTo(), lessThan(), lessThanOrEqualTo()  */
		DoubleProperty property = new SimpleDoubleProperty(20);
		System.out.println("Property greather than 30 --" + property.greaterThan(30).get());
		System.out.println("Property less than 30 --" + property.lessThan(30).get());
		System.out.println("Property equal to 30 --" + property.isEqualTo(30).get());
		
		StringProperty strProperty = new SimpleStringProperty("STRING");
		System.out.println("Is this string null " + strProperty.isEmpty().get());
		System.out.println("Isn't this string null " + strProperty.isNotEmpty().get());
		System.out.println("Is strProperty null = " + strProperty.isNull());
		System.out.println("Isn't strProperty null = " + strProperty.isNotNull());
		System.out.println("strProperty greather than STRING! --" + strProperty.greaterThan("STRING!").get());
		System.out.println("strProperty equal to STRING! --" + strProperty.isEqualTo("STRING!").get());
		
			// Кнопка не будет активной, пока нет текста в txtField
		button2.disableProperty().bind(txtField2.textProperty().isEmpty());

/*--------------------------------------ПЕЧАТЬ ЗНАЧЕНИЯ СВОЙСТВА---------------------------------------------------------*/
		DoubleProperty property1 = new SimpleDoubleProperty(20.01233);
		System.out.println("Value of property = " + property1.doubleValue());			// 20.01233
		System.out.println("Value of property = " + property1.toString());				// 20.01233
		System.out.println("Value of property = " + property1.asString().get());		// 20.01233
		System.out.println("Value of property = " + property1.asString("%.2f").get());	// 20,01
		System.out.println("Value of property = " + property1.asString(new Locale("en","US"), "%.2f").get());	// 20.01
		
		StringProperty strProperty1 = new SimpleStringProperty("STRING");
		System.out.println("Value of strProperty = " + strProperty1.get());
		System.out.println("Value of strProperty = " + strProperty1.getValueSafe());		// В отличии от get(), если строка пустая,то
				// вернется именно пустая строка, но не null
		
		
/*--------------------------------------ПЕЧАТЬ ЗНАЧЕНИЯ СВОЙСТВА---------------------------------------------------------*/		
		System.out.println("Is this string null " + strProperty.isEmpty().get());
		System.out.println("Isn't this string null " + strProperty.isNotEmpty().get());
		
		
			// Изменение положения и размера окна     xProperty  и yProperty   
		primaryStage.xProperty().addListener((listener, oldValue, newValue) -> {
//			System.out.println("Координата Х левого верхнего угла окна изменилась с " + oldValue + "  на " + newValue);
		});
		
		HBox hbox = new HBox(10);	hbox.setPadding(new Insets(10));
		HBox hbox1 = new HBox(10);	hbox1.setPadding(new Insets(10));
		HBox hbox2 = new HBox(10);	hbox2.setPadding(new Insets(10));
		HBox hbox3 = new HBox(10);	hbox3.setPadding(new Insets(10));
		HBox hbox4 = new HBox(10);	hbox4.setPadding(new Insets(10));
		HBox hbox5 = new HBox(10);	hbox5.setPadding(new Insets(10));
		Group group = new Group(); 		group.getChildren().addAll(txtField);
		hbox.getChildren().addAll(button, lbl, slider, group);
		hbox1.getChildren().addAll(rectan);
		hbox2.getChildren().addAll(slider1, txtField1);
		hbox3.getChildren().addAll(slider2, slider3);
		hbox4.getChildren().addAll(slider4, slider5);
		hbox5.getChildren().addAll(button2, txtField2);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(hbox, hbox1, hbox2, hbox3, hbox4, hbox5);
		
		Scene scene = new Scene(vbox, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
