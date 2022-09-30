package t34_Slider;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.converter.NumberStringConverter;

/* Slider - шкала с ползунком, которая может иметь горизонтальную и вертикальную ориентацию
Наследование: Object - Node - Parent- Region - Control - Slider		*/

public class Main extends Application {
	Slider slider1, slider2, slider3, slider4, slider5, slider6;
	Stage stage;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
			// Конструкторы
		slider1 = new Slider();
		slider2 = new Slider(0, 100, 0);		//(min, max, current)
			
			// Указание размеров
		slider1.setMinHeight(60);   slider1.setMinWidth(100);
		slider2.setMinHeight(60);   slider2.setMinWidth(100);
		
			// Задание ориентации
		slider1.setOrientation(Orientation.HORIZONTAL);
		
			// Установка минимального и максимального диапазона ползунка
		slider1.setMin(0.0);    slider1.setMax(100.0);
		
			// Растояние от внутренних границ области до текста и/или изображения внутри кнопки
		slider1.setStyle("-fx-label-padding: 5.0px;");
				
			// Установка фона и цвета текста кнопуи
		slider1.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
				
			// Установка  шкалы под ползунком
		slider2.setShowTickLabels(true);	// при true, отображаются числовые значения около рисок
		slider2.setShowTickMarks(true);		// при true, отображаются риски шкалы
		slider2.setMajorTickUnit(10);		// Задает интервал между главными рисками
		slider2.setMinorTickCount(5);		// Задает интервал между вспомогательными рисками
//		slider2.setLabelFormatter(new StringConverter<Double>());	// Задает способ преобразовния числа в строку для шкалы
		
			// Выравнивание ползунка по рискам
		slider2.setSnapToTicks(true);
		
			// Задание насколько изменится значение ползунка при нажатии на клавиши влево и вправо
		slider2.setBlockIncrement(5.0);
		
			// Увеличение и уменьшение на величину, указанную в setBlockIncrement()
		slider2.increment();
		slider2.decrement();
		
			// Получить значение ползунка
		System.out.println(slider1.getValue());
		
			// Отслеживание значения ползунка
		slider1.valueProperty().addListener((obj, oldValue, newValue) -> {
				/* setValueChanging(true) содержит true, если пользователь в данный момент перемещает ползунок
				 и false, если перемещение ползунка закончено				 */
			if (slider1.isValueChanging() == false) {
				System.out.println("Значение ползунка изменилось с " + oldValue + " на " + newValue); 
			}
		});
		
		/*------------------------------------ДВУХНАПРАВЛЕННОЕ ИЗМЕНЕНИЕ------------------------------------------------------------------
 		Мы можем связать значение одного свойства со значением другого свойства. Если изменится значение первого свойства, то
 		изменится и значение второго свойства */
			/* Метод bindBidirectional(Property other) устанавливает двухнаправленную связь положения ползунка1 и ползунка2
		Этот метод объявлен в интерфейсе Property<T>, который реализует все свойства в JAVAFX	*/
		slider1.valueProperty().bindBidirectional(slider2.valueProperty());	
			
			// ОТМЕНА ДВУХНАПРАВЛЕННОЙ СВЯЗИ
//		slider1.textProperty().unbindBidirectional(slider2.valueProperty());
		
			/* КОНВЕРТИРОВАНИЕ из разных форматов Properties
		В примере выше конвертирование текста из TextField в числа происходит черех parse(), но у Properties есть свои конверторы
		В примере ниже для 3 строки узлов используется другие формата метода bindBidirectional()
			- void bindBidirectional(Property<T> other, StringConverter<T> converter)
			- void bindBidirectional(Property<?> other, Format format)  
		 	Абстрактный класс  StringConverter наследуют классы очень много конвертеров: BooleanStringConverter, NumberStringConverter,
		 IntegerStringConverter, DoubleStringConverter, DateTimeStringConverter, LocalDateTimeStringConverter....
		 	Абстракный класс Format наследуют много классов: NumberFormat, DateFormat, MessageFormat...		*/
		TextField txtField1 = new TextField();  
		txtField1.textProperty().bindBidirectional(slider1.valueProperty(), new NumberStringConverter());
			
/*------------------------------------ОДНОНАПРАВЛЕННОЕ ИЗМЕНЕНИЕ------------------------------------------------------------------
 		Пример ниже показывает однонаправленное связывание двух ползунков	 - при изменении ползунка slider3 
 		будет проиходить изменение ползунка slider2
 		При этом изменение ползунка slider2 явным образом будет нельзя и перетянуть нельзя  */
		slider3 = new Slider();			slider4 = new Slider();
		slider3.setMinHeight(60);   slider3.setMinWidth(100);	slider4.setMinHeight(60);   slider4.setMinWidth(100);
		System.out.println("Ползунок slider3 связан " + slider3.valueProperty().isBound());
		slider3.valueProperty().bind(slider4.valueProperty());		// Связывание
		System.out.println("Ползунок slider4 связан " + slider4.valueProperty().isBound());
		
//		button.disabledProperty().bind(txtField.textProperty());
			
			// ОТМЕНА ОДНОАПРАВЛЕННОЙ СВЯЗИ
//		slider2.valueProperty().unbind();
		
/*------------------------------------ВЫРАЖЕНИЯ В СВЯЗАННЫХ ИЗМЕНЕНИЯХ СВОЙСТВ------------------------------------------------------------------
   Работает для того случая, когда нужно, чтобы значение одного свойства отличалась от значения другого на какое-либо число.
   Например, чтобы значение второго ползунка было всегда больше на 30, чем значение первого ползунка
   В этом случае полезны выражения: BooleanExpresion, IntegerExpression, LongExpression, DoubleExpression, StringExpression, ObjectExpression */
		slider5 = new Slider();			slider6 = new Slider();
		slider5.setMinHeight(60);   slider5.setMinWidth(100);	slider6.setMinHeight(60);   slider6.setMinWidth(100);
		slider5.valueProperty().bind(slider6.valueProperty().subtract(30));		// Связывание и вычитание 30
		slider5.valueProperty().bind(slider6.valueProperty().multiply(1.2));	// Связывание и умножение
		slider5.valueProperty().bind(slider6.valueProperty().divide(1.2));		// Связывание и деление
//		slider5.valueProperty().bind(slider6.valueProperty().negate());			// Изменяет знак на противоположный
		slider5.valueProperty().bind(slider6.valueProperty().add(30));			// Связывание и добваление 30
				
		
		HBox hbox = new HBox(20, slider1, slider2, txtField1, slider3, slider4, slider5, slider6);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));		
		
		Scene scene = new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ВЫБОР ПИЦЦЫ");
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}