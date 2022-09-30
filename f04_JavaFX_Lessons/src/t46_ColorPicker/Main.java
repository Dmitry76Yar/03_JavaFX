package t46_ColorPicker;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
  
  ColorPicker реализует раскрывающийся список, из которого можно выбрать цвет 
  Наследование Object - Node - Parent - Region - Control - ComboBoxBase<Color> - ColorPicker    */

public class Main extends Application {
	ColorPicker colorPicker1  = new ColorPicker();;
	
		@Override 
	public void start(Stage primaryStage) 		{
		Stage stage = primaryStage;
		
			/* КОНСТРУКТОР
		- ColorPicker() 				- создает  ColorPicker с белым цветом по умолчанию
		- ColorPicker(Color color)		- создает ColorPicker с указанным цветом */
		
		ColorPicker colorPicker1 = new ColorPicker();
		ObservableList<Color> obvList = FXCollections.<Color>observableArrayList(Color.RED, Color.BLUE, Color.YELLOW);
		ColorPicker colorPicker2 = new ColorPicker();
		
			// Добавление пользовательских цветов
		colorPicker1.getCustomColors().add(Color.GREEN);					// добавляет указанный элеметн
		colorPicker1.getCustomColors().add(0, Color.ANTIQUEWHITE);		    // добавляет указанный элеметн в указанную позицию списка
		
			// Можно также добавить через метод addAll()
		colorPicker1 = new ColorPicker();
		colorPicker1.getCustomColors().addAll(Color.RED, Color.BLUE, Color.YELLOW);
		
		colorPicker2.getStyleClass().add(ColorPicker.STYLE_CLASS_BUTTON);
		
		/* Метод void setEditable(boolean value) - При true пользователь может внести свои данные в поле text field
		По умолчанию стоит false и пользователь не может добавлять собственный выбор */
		colorPicker1.setEditable(true);
		colorPicker2.setEditable(false);
			
			// void setVisibleRowCount(int value) 	- устанавлиает число элементов для показа
		colorPicker1.setVisible(true);
		
			// void setPromptText(String text) 		- устанавливает фоновый текст-подсказку, которая изначально показывается
		colorPicker1.setPromptText("COLOR PICKER");
			
			// Получение размера и элементов списка		Метод ObservableList<T> getItems()	
		System.out.println("Размер списка =  " + colorPicker1.getCustomColors().size());
		System.out.println("Список apollo13 - " + colorPicker1.getCustomColors());			 // Печать всего списка
		System.out.println("Нулевой элемент списка apollo13 - " + colorPicker1.getCustomColors().get(0));	 // Печать элемента списка
				
			/* По умолчанию в ComboBox все элементы скрыты в выпадащем окне
			С помощью метода setValue() можно установить элемент, который будет отражаться сразу на кнопке ComboBox  */
		colorPicker2.setValue(Color.BLUE);
		
			/* Отслеживаение изменения выбранного значения в списке с помощью .setOnAction() 
		Работает, как при выборе элемента из списка, так и при вводе собственного и нажатия Enter 		 */ 
		colorPicker2.setOnAction(e -> apollo_Click());
		
				/* Отслеживаение изменения выбранного значения в списке с помощью .valueProperty().addListener() 
			 Отслеживаение изменения выбранного значения в списке в случае, если список содержит все уникальные элементы
			 Можно сразу после выбора изменить текст Label с выбранным значенеим 		 */
		colorPicker2.valueProperty().addListener(new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				System.out.println("Изменение списка colorPicker2 с отслеживанием по colorPicker2.valueProperty().addListener()  с " + 
						oldValue + " на " + newValue);
			}
		});
		
		
			// Отслеживание события разворачивания списка
		colorPicker2.showingProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue == true) System.out.println("Список развернут");
			}
		});
		
			// Обработчик события перед отображением списка выбора
		TextField txtfield = new TextField();
		colorPicker2.setOnShowing(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("Список готов к выбору");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
			}
		});
		
			// Обработчик события при отображении списка выбора
		colorPicker2.setOnShown(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("Идет выбор");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
			}
		});
		
			// Обработчик события при скрытии списка выбора
		colorPicker2.setOnHidden(new EventHandler<Event>() {
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
		
		
		HBox hbox = new HBox(10, txtfield, colorPicker1, colorPicker2);
		hbox.setPadding(new Insets(20, 10, 20, 10));
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CHOISE BOX");  // LbvfRbv1984@#!
		primaryStage.show();
	}
			
		public void apollo_Click() {
			String msg = "Your Favorite color -    ";
			msg = msg + colorPicker1.getValue();
			Alert alert = new Alert(AlertType.INFORMATION, msg);
			alert.showAndWait();
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}