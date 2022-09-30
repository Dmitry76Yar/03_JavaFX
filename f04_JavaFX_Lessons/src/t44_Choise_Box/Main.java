package t44_Choise_Box;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.*;
/*	В JavaFX имеется широкий выбор компонентов, позволяющих отображать одномерный список строк в свернутом и развернутом 
состояниях. Списки поддерживают концепцию "модель/представление", позволяющую отделить данные от их отображения. В роли
мождели выступают объект, реализующий интерфейс Obversablelist<E>, а в роли представления- ChoiseBox, ComboBox, ListView.
Интерфейс Obversablelist<E> наследует интерфейсы Iterable<E>, Collection<E>, List<E>, Obversable.
	Интефейс Obversable имеют методы addListener() и removeListener(), которые позволяют назначить и удалить обработчик события
изменения списка  
  
  ChoiceBox<T> представляет выпадающий список, из которого можно выбрать только один элемент.
  В отличие от ComboBox в ChoiceBox рядом с выбранным элементом устанавливается отметка.
  Наследование Object - Node - Parent- Region - Control - ChoiseBox<T>			*/

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
	ChoiceBox<Astronaut> apollo13;
	ChoiceBox<String> choice;
	Label lbl;
	TextField txtfield;
	
		@Override 
	public void start(Stage primaryStage) 		{
		stage = primaryStage;
		lbl = new Label("Initial LABEL");
		txtfield = new TextField();
		txtfield.setPromptText("Initial TEXTFIELD");
		
			/* КОНСТРУКТОРЫ
		ChoiceBox<T>() 							- создает пустой сhoice list указанного типа
		ChoiceBox<T>(ObservableList<T> items)	- создает choice list и заполняет его значениями в list указанного типа */
		apollo13 = new ChoiceBox<Astronaut>();
		
		ObservableList<String> obvList =  
				FXCollections.<String>observableArrayList("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		choice = new ChoiceBox(obvList);
		
			/* ChoiceBox не позволяет добавлять в него список, который будет выплывать при выборе этого ChoiceBox 
		Сначала нужно вызывать метод getItems(), который возвращает список типа ObservableList, в который уже можно 
		добавлять варианты  */
		apollo13.getItems().add(new Astronaut("Jim", "Lovell"));		// добавляет указанный элеметн
		apollo13.getItems().add(0, new Astronaut("John", "Swigert"));	// добавляет указанный элеметн в указанную позицию списка
		Astronaut haise = new Astronaut("Fred", "Haise");
		apollo13.getItems().add(haise);
		
			// Можно также добавить через метод addAll()
		choice.getItems().addAll();   

		// Получение размера и элементов списка		Метод ObservableList<T> getItems()	
		System.out.println("Размер списка =  " + apollo13.getItems().size());
		System.out.println("Список apollo13 - " + apollo13.getItems());			 // Печать всего списка
		System.out.println("Нулевой элемент списка apollo13 - " + apollo13.getItems().get(0));	 // Печать элемента списка
		
			/* По умолчанию в choice box все элементы скрыты в выпадащем окне
		С помощью метода setValue() можно установить элемент, который будет отражаться сразу на кнопке ChoiceBox  */
		apollo13.setValue(haise);
		
			/* Отслеживаение изменения выбранного значения в списке с помощью .setOnAction() */ 
		apollo13.setOnAction(e -> apollo_Click());
		
			// Скрытие списка выбора hide() и отображение сразу списка show()
//		apollo13.hide();
		
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
		
			// Выбор элемента из программы
//		choice.getSelectionModel().select(0);    	  // По индексу
//		choice.getSelectionModel().selectFirst();     // Первый элемент
//		choice.getSelectionModel().selectLast();     // Последний элемент
//		choice.getSelectionModel().selectNext();     // Следующий элемент
		
		HBox hbox = new HBox(10, lbl, txtfield, choice, apollo13);
		hbox.setPadding(new Insets(20, 10, 20, 10));
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CHOISE BOX");  // LbvfRbv1984@#!
		primaryStage.show();
	}
	public void apollo_Click() {
		String msg = "Your Favorite Astronaut";
			// C помощью метода getValue() можно получить объект из ObservableList, который был выбран пользователем
		msg = msg + apollo13.getValue();
		Alert alert = new Alert(AlertType.INFORMATION, msg);
		alert.showAndWait();
		lbl.setText(""+apollo13.getValue());
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}