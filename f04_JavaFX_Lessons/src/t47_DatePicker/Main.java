package t47_DatePicker;
	
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.Callback;

/*	В JavaFX имеется широкий выбор компонентов, позволяющих отображать одномерный список строк в свернутом и развернутом 
состояниях. Списки поддерживают концепцию "модель/представление", позволяющую отделить данные от их отображения. В роли
мождели выступают объект, реализующий интерфейс Obversablelist<E>, а в роли представления- ChoiseBox, ComboBox, ListView.
Интерфейс Obversablelist<E> наследует интерфейсы Iterable<E>, Collection<E>, List<E>, Obversable.
	Интефейс Obversable имеют методы addListener() и removeListener(), которые позволяют назначить и удалить обработчик события
изменения списка  
  
  ComboBox<T> представляет выпадающий список с возможностью ввода произвольного значения в текстовое поле 
  Абстрактный класс ComboBoxBase<T> является базовым для ComboBox<T>, ColorPicker, DatePicker 
  
  DatePicker реализует раскрывающийся список, из которого можно выбрать дату  
  Наследование Object - Node - Parent - Region - Control - ComboBoxBase<Color> - DatePicker    */

public class Main extends Application {
	DatePicker datePicker1  = new DatePicker();;
	
		@Override 
	public void start(Stage primaryStage) 		{
		Stage stage = primaryStage;
		
			/* КОНСТРУКТОР
		- DatePicker() 							- создает  DatePicker без выбранной даты
		- DatePicker(LocalDate localDate)		- создает DatePicker с выбранной датой */
		
		DatePicker datePicker1 = new DatePicker();
		DatePicker datePicker2 = new DatePicker(LocalDate.now());
		
		/* Метод void setEditable(boolean value) - При true пользователь может внести свои данные в поле text field
		По умолчанию стоит false и пользователь не может добавлять собственный выбор */
		datePicker1.setEditable(true);
		datePicker2.setEditable(false);
			
			// void setVisibleRowCount(int value) 	- устанавлиает число элементов для показа
		datePicker1.setVisible(true);
		
			// Отображение номера недель вместо даты
		datePicker1.setShowWeekNumbers(true);
		
			// void setPromptText(String text) 		- устанавливает фоновый текст-подсказку, которая изначально показывается
		datePicker1.setPromptText("DATE PICKER");
				
			/* По умолчанию все элементы скрыты в выпадащем окне
			С помощью метода setValue() можно установить элемент, который будет отражаться сразу на кнопке ComboBox  */
		datePicker2.setValue(LocalDate.now());
		
			/* dayCellFactory позволяет изменить отдельные ячейки календаря. Например можно выделить прездничные дни
		или день Рождения, сделать какую-либо дату недоступной для выбора, вывести всплывающую подсказку.			 */
		Callback<DatePicker, DateCell> cellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(DatePicker param) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item == null || empty) return;
							// Делает завтрашний день недоступным для выбора
						if (item.equals(LocalDate.now().plusDays(1))) setDisable(true);
							// Выделяет вчерашний день зеленым цветом и добавляет всплывающую подсказку
						else if (item.equals(LocalDate.now().minusDays(2))) {
							setTooltip(new Tooltip("Вчера"));
							setStyle("fx-background-color: #008000;");
						}
							// Цвет текста для выходных делает красный
						if ((item.getDayOfWeek() == DayOfWeek.SATURDAY) || (item.getDayOfWeek() == DayOfWeek.SUNDAY))
							setTextFill(Color.RED);
					}
				};
			}
		};
		datePicker2.setDayCellFactory(cellFactory);
		
		
			/* Отслеживаение изменения выбранного значения в списке с помощью .setOnAction() 
		Работает, как при выборе элемента из списка, так и при вводе собственного и нажатия Enter 		 */ 
		datePicker1.setOnAction(e -> 	{
			LocalDate date = datePicker1.getValue();
			Alert alert;
			if (date == null) alert = new Alert(AlertType.INFORMATION, "Время не выбрано");
			else alert = new Alert(AlertType.INFORMATION, "Time is  -    " + 
									date.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
			alert.showAndWait();
		});
		
				/* Отслеживаение изменения выбранного значения в списке с помощью .valueProperty().addListener() 
			 Отслеживаение изменения выбранного значения в списке в случае, если список содержит все уникальные элементы
			 Можно сразу после выбора изменить текст Label с выбранным значенеим 		 */
		datePicker2.valueProperty().addListener(new ChangeListener<LocalDate>() {
			@Override
			public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
				System.out.println("Изменение списка datePicker2 с отслеживанием по datePicker2.valueProperty().addListener()  с " + 
						oldValue + " на " + newValue);
			}
		});
		
			// Отслеживание события разворачивания списка
		datePicker2.showingProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue == true) System.out.println("Список развернут");
			}
		});
		
			// Обработчик события перед отображением списка выбора
		TextField txtfield = new TextField();
		datePicker2.setOnShowing(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("Список готов к выбору");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
			}
		});
		
			// Обработчик события при отображении списка выбора
		datePicker2.setOnShown(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("Идет выбор");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
			}
		});
		
			// Обработчик события при скрытии списка выбора
		datePicker2.setOnHidden(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("Выбор сделан");
				txtfield.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
			}
		});
		
				// Выбор элемента из программы
		//	choice.getSelectionModel().select(0);    	  // По индексу
		//	choice.getSelectionModel().selectFirst();     // Первый элемент
		//	choice.getSelectionModel().selectLast();     // Последний элемент
		//	choice.getSelectionModel().selectNext();     // Следующий элемент
		
		
		HBox hbox = new HBox(10, txtfield, datePicker1, datePicker2);
		hbox.setPadding(new Insets(20, 10, 20, 10));
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
			
	public static void main(String[] args) {
		launch(args);
	}
}