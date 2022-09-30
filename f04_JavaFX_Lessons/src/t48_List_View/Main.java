package t48_List_View;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.FocusModel;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
/* ListView реализует постоянно отображающийся ветикальный (по умолчанию) или горизонтальный список с возможностью выбора одного
   или нескольких элементов, а также с возможностью редактирования отдельного элемента пользователем.
      В ListView список не является выпадающим, а показывается на экране в окне, размеры которого можно задать
   ListView позволяет пользователю выбирать более, чем один элемент. По умолчанию - выбор только одного элемента
        Для выбор мн-ва элементов нужно выбрать элементы, зажав Ctrl. Для выбора диапазона элементов нужно зажать Shift
   - ListView не имеет поле TextField, которое позволяет пользователю ввести свои данные вместо того, чтобы выбирать
   - Элементы в ListView могут показываться вертикальным списком (по умолчанию) или горизонтальным списком 
        Наследование Object - Node - Parent - Region - Control - ListView<T>			
				МЕТОДЫ
	- ObservableList<T> getItems() 			- возвращает list of items
	- void setItems(ObservableList<T> items)- устанавлиает list of items
	- void setOrientation(Orientation o) 	- устанавливает ориентацию списка (Orientation.HORIZONTAL или Orientation.VERTICAL)
	- MultipleSelectionModel<T> getSelectionModel()	- для выбора более 1 элемента. Возвращает selection model, который через метод 
									getSelectedItems() можно использовать для получения ObservableList, содержащий выбранные элементы, */
import javafx.util.Callback;

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
	ListView<Astronaut> apollo13;			ListView<String> choice;
	Label lbl;			Astronaut haise;
	
		@Override 
	public void start(Stage primaryStage) 		{
		stage = primaryStage;
		lbl = new Label("Initial LABEL");	lbl.setMinWidth(50);
		
		/* КОНСТРУКТОРЫ
		- ListView<T>() 						- создает пустой ListView 
		- ListView<T>(ObservableList<T> items)	- создает ListView и заполняет его значениями в list указанного типа */
		
		ListView<Astronaut> apollo13 = new ListView<Astronaut>();
		ObservableList<String> obvList =  
				FXCollections.<String>observableArrayList("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		ListView<String> choice = new ListView<String>(obvList);
		
			/* Добавление  */
		apollo13.getItems().add(new Astronaut("Jim", "Lovell"));
		apollo13.getItems().add(new Astronaut("John", "Swigert"));
		haise = new Astronaut("Fred", "Haise");
		apollo13.getItems().add(haise);
			// Добавление через setItems
//		choice.setItems(FXCollections.<String>observableArrayList("Bashful2", "Doc2"));
			// Можно также добавить через метод addAll()
//		choice.getItems().addAll("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		
			// Устанавливает узел (например, label), который показывается когда список пустой
		choice.setPlaceholder(new Label("Empty list"));
		
			// Задает фиксированную высоту (для вертик.ориентации) и ширину (для гориз.ориентации) ячеек списка
		choice.setFixedCellSize(20);
		apollo13.setFixedCellSize(40);
		
			//  void setOrientation(Orientation o) 	- устанавливает ориентацию списка (Orientation.HORIZONTAL или Orientation.VERTICAL)
		apollo13.setOrientation(Orientation.VERTICAL);
			
			// Выделение элемента из списка по умолчанию (сразу после показа окна)
		choice.getSelectionModel().selectLast();
		
			// Задание фокуса на элементе из списка по умолчанию (сразу после показа окна)
		choice.getFocusModel().focus(3);
		
			// РЕДАКТИРОВАНИЕ СПИСКА ПОЛЬЗОВАТЕЛЕМ (добавить собственный элемент) 
		/* 1-ый шаг - поставить true в методе void setEditable(boolean value) 
		   2-ой шаг - задать значение свойства cellFactory. Можно реализовать свой собственный способ редактирования
		   или воспользоваться готовыми классами из пакета Control.cell - например, TextFieldListCell<T>, который в режиме
		   редактирования отображает внутри ячейки текстовое поле	 
		   Редактирование производится при двойном щелчке левой кнопкой мыши на пункте списка или выделение + Enter */
		choice.setEditable(true);		
		choice.setCellFactory(TextFieldListCell.forListView());
				// Обработчик событий редактирования
			// Обработчик любого редактирования
		choice.addEventHandler(ListView.<String>editAnyEvent(), event -> {
//			System.out.println("Реакция на любое редактирование списка");
		});
			// Обработчик начала редактирования ( при двойном щелчке левой кнопкой мыши на пункте списка или выделение + Enter)
		choice.addEventHandler(ListView.<String>editStartEvent(), event -> {
			System.out.println("Вход в редактирование пунтка списка");
		});
			// Обработчик отмены редактирования (пользователь внутри текстового поля нажал Esc или перешел в другое поле)
		choice.addEventHandler(ListView.<String>editCancelEvent(), event -> {
			System.out.println("Отмена редактирования пунтка списка");
		});
			// Обработчик успешного редактирования (пользователь ввел значение в текстовое поле и нажал Enter)
		choice.addEventHandler(ListView.<String>editCommitEvent(), event -> {
			System.out.println("Успешное редактирования пунтка списка");
			System.out.println("Был изменен пункт списка с индексом " + event.getIndex());
			System.out.println("Был изменен пункт списка  " + event.getSource());
			System.out.println("Новое значение для измененного списка  " + event.getNewValue());
				// Сохранение значения в таблице
			choice.getItems().set(event.getIndex(), event.getNewValue());
			System.out.println(choice.getItems().toString());
		});
		System.out.println(choice.getItems().toString());
		
			
			/* Метод setSelectionMode(SelectionMode.CONSTANT)
			для задания возможности выбора только одного вараинта - константа
			для задания возможности многократного выбора - константа SelectionMode.MULTIPLE 		 */
		apollo13.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		choice.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
			// Получение выбранных элементов для ListView с SelectionMode.SINGLE и SelectionMode.MULTIPLE
		choice.setId("CHOISE_ID");
		apollo13.setId("APOLLO_ID");
		Button btn = new Button("GET");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
					// Получение выбранных элементов для ListView с SelectionMode.SINGLE 
				int index = choice.getSelectionModel().getSelectedIndex();
				String chOb = choice.getSelectionModel().getSelectedItem();
					// Получение выбранных элементов для ListView с SelectionMode.MULTIPLE
				ObservableList<Integer> obsIndex = apollo13.getSelectionModel().getSelectedIndices();
				ObservableList<Astronaut> obsValue = apollo13.getSelectionModel().getSelectedItems();
				Alert alert = new Alert(AlertType.INFORMATION, "Выбраны элементы apollo листа с индексами " + 
						obsIndex.toString() + " и со значением " + obsValue.toString() + "\n Выбран элемент choice листа с индексом " + 
						index + " и со значением "  + chOb);
						alert.showAndWait();
					}
		});
		
		choice.setOnScrollTo(new EventHandler<ScrollToEvent<Integer>>() {
			@Override
			public void handle(ScrollToEvent<Integer> event) {
				System.out.println("Прокрутка к элементу с индексом " + event.getScrollTarget());
			}
		});
		
			// Управление фокусом Обработчик выбора элементов при расположении фокуса
		FocusModel<String> focusm= choice.getFocusModel();		// Возвращает ссылку на объект, который сейчас в фокусе
		focusm.focusedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				System.out.println("Фокус изменился с " + oldValue + " индекса на " + newValue);
			}
		});
		
		focusm.focusedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				System.out.println("Фокус изменился с " + oldValue + " объекта на " + newValue);
			}
		});
		
		/* cellFactory позволяет создавать пользовательский стиль каждой ячейки списка. 
		Например, слева от надписи можем отобразить небольшое изображение или любой другой узел (класс Labeled)	 */
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
		ListView<Color> liView3 = new ListView<Color>();
		liView3.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		liView3.getItems().addAll(Color.RED, Color.GREEN, Color.BLUE);
		liView3.setCellFactory(cellFactory);

			// Получение размера и элементов списка		Метод ObservableList<T> getItems()	
		System.out.println("Размер списка =  " + apollo13.getItems().size());
		System.out.println("Список apollo13 - " + apollo13.getItems());			 // Печать всего списка
		System.out.println("Нулевой элемент списка apollo13 - " + apollo13.getItems().get(0));	 // Печать элемента списка
		
		// Выбор элемента из программы
//		choice.getSelectionModel().select(0);    	  // По индексу
//		choice.getSelectionModel().selectFirst();     // Первый элемент
//		choice.getSelectionModel().selectLast();     // Последний элемент
//		choice.getSelectionModel().selectNext();     // Следующий элемент
		
			// Задание отклика на выбор  
//		choice.setOnAction(e -> choice_Click());
//		apollo13.setOnAction(e -> apollo_Click());
		
		HBox hbox = new HBox(10, lbl, choice, apollo13, btn, liView3);
		hbox.setPadding(new Insets(20, 10, 20, 10));
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox, 1000, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CHOISE BOX");  // LbvfRbv1984@#!
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}