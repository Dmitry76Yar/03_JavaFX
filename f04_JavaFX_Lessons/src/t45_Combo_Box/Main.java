package t45_Combo_Box;
	
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
  В отличие от ChoiceBox
   - в ComboBox есть возможность ограничить число выпадающих элементов 
   - ComboBox имеет поле TextField, которое позволяет пользователю ввести свои данне вместо того, чтобы выбирать
   - ComboBox иницирует action event, когда пользователь выбирает из выпадающего окна
  Наследование Object - Node - Parent- Region - Control - ComboBoxBase<T>- ComboBox<T>
  Абстрактный класс ComboBoxBase<T> является базовым для ComboBox<T>, ColorPicker, DatePicker */

class Astronaut {
	private String firstName;
	private String lastName;
	public Astronaut(String FirstName, String LastName) {
		firstName = FirstName;
		lastName = LastName;
	}
	public String toString()  {
		return firstName + " " + lastName;}
}

public class Main extends Application {
	Stage stage;
	ComboBox<Astronaut> apollo13;
	ComboBox<String> choice;
	Label lbl;
	TextField txtfield;
	Astronaut haise;
	
		@Override 
	public void start(Stage primaryStage) 		{
		stage = primaryStage;
		lbl = new Label("Initial LABEL");	lbl.setMinWidth(100);
		txtfield = new TextField();			txtfield.setPromptText("Initial TEXTFIELD");
		
			/* КОНСТРУКТОР
		- ComboBox<T>() 						- создает пустой ComboBox указанного типа
		- ComboBox<T>(ObservableList<T> items)	- создает ComboBox и заполняет его значениями в list указанного типа */
		apollo13 = new ComboBox<Astronaut>();
		ObservableList<String> obvList =  
				FXCollections.<String>observableArrayList("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		choice = new ComboBox(obvList);
		
			/* ComboBox не позволяет добавлять в него список, который будет выплывать при выборе этого ComboBox 
		Сначала нужно вызывать метод getItems(), который возвращает список типа ObservableList, в который уже можно 
		добавлять варианты  */
		apollo13.getItems().add(new Astronaut("Jim", "Lovell"));		// добавляет указанный элеметн
		apollo13.getItems().add(0, new Astronaut("John", "Swigert"));	// добавляет указанный элеметн в указанную позицию списка
		Astronaut haise = new Astronaut("Fred", "Haise");
		apollo13.getItems().add(haise);
		
			// Можно также добавить через метод addAll()
		choice = new ComboBox<String>();
		choice.getItems().addAll("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		
		/* Метод void setEditable(boolean value) - При true пользователь может внести свои данные в поле text field
		По умолчанию стоит false и пользователь не может добавлять собственный выбор */
		choice.setEditable(true);
		apollo13.setEditable(false);
			
			// void setVisibleRowCount(int value) 	- устанавлиает число элементов для показа
		choice.setVisibleRowCount(4);
		
			// void setPromptText(String text) 		- устанавливает фоновый текст-подсказку, которая изначально показывается
		choice.setPromptText("Введите сюда");
			
			// Получение размера и элементов списка		Метод ObservableList<T> getItems()	
		System.out.println("Размер списка =  " + apollo13.getItems().size());
		System.out.println("Список apollo13 - " + apollo13.getItems());			 // Печать всего списка
		System.out.println("Нулевой элемент списка apollo13 - " + apollo13.getItems().get(0));	 // Печать элемента списка
				
			/* По умолчанию в ComboBox все элементы скрыты в выпадащем окне
			С помощью метода setValue() можно установить элемент, который будет отражаться сразу на кнопке ComboBox  */
		apollo13.setValue(haise);
		
			// Устанавливает узел, который будет отображаться в открыващемся списке, если он пустой
		choice.setPlaceholder(new Label("Список пустой"));
		
			/* Задает стиль каждой ячейки выпадающего списка
		Например, слева от надписи можно отобразить небольшое изображение или любой узел (из класса Labeled)	 */
		
		Callback<ListView<Color>,ListCell<Color>> cellFactory = new Callback<ListView<Color>, ListCell<Color>>() {
			@Override
			public ListCell<Color> call(ListView<Color> listView) {
				return new ListCell<Color>() {
					private final Rectangle rect = new Rectangle(50.0, 10.0);
					@Override
					protected void updateItem (Color color, boolean empty) {
						super.updateItem(color, empty);
						if (color == null || empty) {
							setGraphic(null);
							setText("");
						}
						else {
							rect.setFill(color);
							setGraphic(rect);
							setText(color.toString());
						}
					}
				};
			}
		};
		ComboBox<Color> comboColor = new ComboBox<Color>();
		comboColor.setPromptText("Color ComboBox");
		comboColor.getItems().addAll(Color.RED, Color.GREEN, Color.BLUE);
		comboColor.setButtonCell(cellFactory.call(null));
		comboColor.setCellFactory(cellFactory);
		
				
			/* Отслеживаение изменения выбранного значения в списке с помощью .setOnAction() 
		Работает, как при выборе элемента из списка, так и при вводе собственного и нажатия Enter 		 */ 
		apollo13.setOnAction(e -> apollo_Click());
		
				/* Отслеживаение изменения выбранного значения в списке с помощью .valueProperty().addListener() 
			 Отслеживаение изменения выбранного значения в списке в случае, если список содержит все уникальные элементы
			 Можно сразу после выбора изменить текст Label с выбранным значенеим 		 */
		choice.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("Изменение списка choice с отслеживанием по choice.valueProperty().addListener()  с " + 
						oldValue + " на " + newValue);
			}
		});
		
		/*  Отслеживание изменения выбранного значения через SingleSelectionModel класс
		 SingleSelectionModel класс - описывает модель выбора одного элемента из списка
		 Наследование Object - SelectionModel<T> - SingleSelectionModel<T>
		 Через SelectionModel класс также можно сразу после выбора изменить текст Label с выбранным значенеим 		 
		 Метод getSelectionModel() возвращает selection model - объект, который управляет тем, как юзер может выбрать варианты из списка.
	Selection model - объект, который implements один из нескольких классов, расширяющих абстрактный класс SelectionModel class. 
	Для Сhoice box таким selection model всегда является SingleSelectionMode, который позволяет выбрать из списка только 1 элемент.
		Далее для возвращенного selection model вызывается метод selectedItemProperty(), который возвращает property для выбранного элемента
	списка. В Java property - специальный тип объекта, чье значение может отслеживаться listener (отслеживает изменение property).
		Далее для возвращенного property вызывается метод addListener(). 
	Метод Listener вызывается при каждом изменении  property. Так как listener имплементирует функциональный интерфейс ChangeListener (такой 
	инфтерфейс имеет только один метод), то можно вывывать лямбда-выражение для написания кода реакции на изменение.
		Будуча функциональным интерфейсом, ChangeListerner определяет единственный метод changed(), который вызывакт при любом изменении 
	Сhoice box и возвращает 3 параметра:
	- observable: property, который был изменен  	 - oldValue: прежнее значение рroperty		 - newValue: новое значение property
	Именно эти 3 параметра указываются в лямбда-выражении 	 */
		
		SingleSelectionModel<String> sel = choice.getSelectionModel();
		
			/* Отслеживания  индекса выбранного элемента
			Возвращает индекс элемента или -1, если ничего не выбрано 	 */
		sel.selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if ((newValue == null) || ((int)newValue <0)) return;
				System.out.println("Изменение списка choice с отслеживанием с SingleSelectionModel по индексу с " + 
						oldValue + " на " + newValue);
			}
		});
		
			/* Отслеживания  значения выбранного элемента
			Возвращает индекс элемента или null, если ничего не выбрано 	 */
		sel.selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue == null) return;
				System.out.println("Изменение списка choice с отслеживанием с SingleSelectionModel по значению с " + 
						oldValue + " на " + newValue);
				lbl.setText(newValue);
				txtfield.setText(newValue);
				}
			});
		
			// Отслеживание события разворачивания списка
		choice.showingProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue == true) System.out.println("Список развернут");
			}
		});
		
			// Обработчик события перед отображением списка выбора
		choice.setOnShowing(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("Список готов к выбору");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
			}
		});
		
			// Обработчик события при отображении списка выбора
		choice.setOnShown(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("Идет выбор");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
			}
		});
		
			// Обработчик события при скрытии списка выбора
		choice.setOnHidden(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("Выбор сделан");
				txtfield.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
			}
		});
		
			/* Обработчик TextField внутри ComboBox
		Метод getEditor() возвращает TextField, который далее можно обрабатывать 	 */
		choice.getEditor().textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("В текстовое поле введено новое значение" + newValue);
			}
		});
		
				// Выбор элемента из программы
		//	choice.getSelectionModel().select(0);    	  // По индексу
		//	choice.getSelectionModel().selectFirst();     // Первый элемент
		//	choice.getSelectionModel().selectLast();     // Последний элемент
		//	choice.getSelectionModel().selectNext();     // Следующий элемент
		
		
		HBox hbox = new HBox(10, lbl, txtfield, choice, apollo13, comboColor);
		hbox.setPadding(new Insets(20, 10, 20, 10));
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CHOISE BOX");  // LbvfRbv1984@#!
		primaryStage.show();
	}
	public void choice_Click() {
		String msg = "Твой выбор";
			/* C помощью метода getValue() можно получить объект из ObservableList, который был выбран пользователем, или его собственный объект
			Так как пользователь может выбрать не из списка, а ввести собственное значение, то сначала нужно проверить 
			содержится ли такой элемент в списке.  Метод getItems() возвращает список и метод contains() проверяет возращенное при совершении
			выбора значение  */
		if (choice.getItems().contains(choice.getValue())) 
			msg = msg + " из списка" + choice.getValue();
		else 
			msg = msg + " за рамками списка " + choice.getValue();
		Alert alert = new Alert(AlertType.INFORMATION, msg);
		alert.showAndWait();
		lbl.setText(choice.getValue());
	}	
			
		public void apollo_Click() {
			if (apollo13.getValue().equals(haise)) {
				Alert b = new Alert(Alert.AlertType.INFORMATION, "He's my favorite too!");
				b.setTitle("Good Choice");
				b.showAndWait();
			}
			
			String msg = "Your Favorite Astronaut";
			msg = msg + apollo13.getValue();
			Alert alert = new Alert(AlertType.INFORMATION, msg);
			alert.showAndWait();
			txtfield.setText(apollo13.getValue().toString());
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}