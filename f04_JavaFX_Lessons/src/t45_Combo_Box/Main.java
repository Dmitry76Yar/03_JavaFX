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

/*	� JavaFX ������� ������� ����� �����������, ����������� ���������� ���������� ������ ����� � ��������� � ����������� 
����������. ������ ������������ ��������� "������/�������������", ����������� �������� ������ �� �� �����������. � ����
������� ��������� ������, ����������� ��������� Obversablelist<E>, � � ���� �������������- ChoiseBox, ComboBox, ListView.
��������� Obversablelist<E> ��������� ���������� Iterable<E>, Collection<E>, List<E>, Obversable.
	�������� Obversable ����� ������ addListener() � removeListener(), ������� ��������� ��������� � ������� ���������� �������
��������� ������  
  
  ComboBox<T> ������������ ���������� ������ � ������������ ����� ������������� �������� � ��������� ���� 
  � ������� �� ChoiceBox
   - � ComboBox ���� ����������� ���������� ����� ���������� ��������� 
   - ComboBox ����� ���� TextField, ������� ��������� ������������ ������ ���� ����� ������ ����, ����� ��������
   - ComboBox ��������� action event, ����� ������������ �������� �� ����������� ����
  ������������ Object - Node - Parent- Region - Control - ComboBoxBase<T>- ComboBox<T>
  ����������� ����� ComboBoxBase<T> �������� ������� ��� ComboBox<T>, ColorPicker, DatePicker */

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
		
			/* �����������
		- ComboBox<T>() 						- ������� ������ ComboBox ���������� ����
		- ComboBox<T>(ObservableList<T> items)	- ������� ComboBox � ��������� ��� ���������� � list ���������� ���� */
		apollo13 = new ComboBox<Astronaut>();
		ObservableList<String> obvList =  
				FXCollections.<String>observableArrayList("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		choice = new ComboBox(obvList);
		
			/* ComboBox �� ��������� ��������� � ���� ������, ������� ����� ��������� ��� ������ ����� ComboBox 
		������� ����� �������� ����� getItems(), ������� ���������� ������ ���� ObservableList, � ������� ��� ����� 
		��������� ��������  */
		apollo13.getItems().add(new Astronaut("Jim", "Lovell"));		// ��������� ��������� �������
		apollo13.getItems().add(0, new Astronaut("John", "Swigert"));	// ��������� ��������� ������� � ��������� ������� ������
		Astronaut haise = new Astronaut("Fred", "Haise");
		apollo13.getItems().add(haise);
		
			// ����� ����� �������� ����� ����� addAll()
		choice = new ComboBox<String>();
		choice.getItems().addAll("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		
		/* ����� void setEditable(boolean value) - ��� true ������������ ����� ������ ���� ������ � ���� text field
		�� ��������� ����� false � ������������ �� ����� ��������� ����������� ����� */
		choice.setEditable(true);
		apollo13.setEditable(false);
			
			// void setVisibleRowCount(int value) 	- ������������ ����� ��������� ��� ������
		choice.setVisibleRowCount(4);
		
			// void setPromptText(String text) 		- ������������� ������� �����-���������, ������� ���������� ������������
		choice.setPromptText("������� ����");
			
			// ��������� ������� � ��������� ������		����� ObservableList<T> getItems()	
		System.out.println("������ ������ =  " + apollo13.getItems().size());
		System.out.println("������ apollo13 - " + apollo13.getItems());			 // ������ ����� ������
		System.out.println("������� ������� ������ apollo13 - " + apollo13.getItems().get(0));	 // ������ �������� ������
				
			/* �� ��������� � ComboBox ��� �������� ������ � ��������� ����
			� ������� ������ setValue() ����� ���������� �������, ������� ����� ���������� ����� �� ������ ComboBox  */
		apollo13.setValue(haise);
		
			// ������������� ����, ������� ����� ������������ � ������������ ������, ���� �� ������
		choice.setPlaceholder(new Label("������ ������"));
		
			/* ������ ����� ������ ������ ����������� ������
		��������, ����� �� ������� ����� ���������� ��������� ����������� ��� ����� ���� (�� ������ Labeled)	 */
		
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
		
				
			/* ������������� ��������� ���������� �������� � ������ � ������� .setOnAction() 
		��������, ��� ��� ������ �������� �� ������, ��� � ��� ����� ������������ � ������� Enter 		 */ 
		apollo13.setOnAction(e -> apollo_Click());
		
				/* ������������� ��������� ���������� �������� � ������ � ������� .valueProperty().addListener() 
			 ������������� ��������� ���������� �������� � ������ � ������, ���� ������ �������� ��� ���������� ��������
			 ����� ����� ����� ������ �������� ����� Label � ��������� ��������� 		 */
		choice.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("��������� ������ choice � ������������� �� choice.valueProperty().addListener()  � " + 
						oldValue + " �� " + newValue);
			}
		});
		
		/*  ������������ ��������� ���������� �������� ����� SingleSelectionModel �����
		 SingleSelectionModel ����� - ��������� ������ ������ ������ �������� �� ������
		 ������������ Object - SelectionModel<T> - SingleSelectionModel<T>
		 ����� SelectionModel ����� ����� ����� ����� ����� ������ �������� ����� Label � ��������� ��������� 		 
		 ����� getSelectionModel() ���������� selection model - ������, ������� ��������� ���, ��� ���� ����� ������� �������� �� ������.
	Selection model - ������, ������� implements ���� �� ���������� �������, ����������� ����������� ����� SelectionModel class. 
	��� �hoice box ����� selection model ������ �������� SingleSelectionMode, ������� ��������� ������� �� ������ ������ 1 �������.
		����� ��� ������������� selection model ���������� ����� selectedItemProperty(), ������� ���������� property ��� ���������� ��������
	������. � Java property - ����������� ��� �������, ��� �������� ����� ������������� listener (����������� ��������� property).
		����� ��� ������������� property ���������� ����� addListener(). 
	����� Listener ���������� ��� ������ ���������  property. ��� ��� listener �������������� �������������� ��������� ChangeListener (����� 
	���������� ����� ������ ���� �����), �� ����� �������� ������-��������� ��� ��������� ���� ������� �� ���������.
		������ �������������� �����������, ChangeListerner ���������� ������������ ����� changed(), ������� �������� ��� ����� ��������� 
	�hoice box � ���������� 3 ���������:
	- observable: property, ������� ��� �������  	 - oldValue: ������� �������� �roperty		 - newValue: ����� �������� property
	������ ��� 3 ��������� ����������� � ������-��������� 	 */
		
		SingleSelectionModel<String> sel = choice.getSelectionModel();
		
			/* ������������  ������� ���������� ��������
			���������� ������ �������� ��� -1, ���� ������ �� ������� 	 */
		sel.selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if ((newValue == null) || ((int)newValue <0)) return;
				System.out.println("��������� ������ choice � ������������� � SingleSelectionModel �� ������� � " + 
						oldValue + " �� " + newValue);
			}
		});
		
			/* ������������  �������� ���������� ��������
			���������� ������ �������� ��� null, ���� ������ �� ������� 	 */
		sel.selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue == null) return;
				System.out.println("��������� ������ choice � ������������� � SingleSelectionModel �� �������� � " + 
						oldValue + " �� " + newValue);
				lbl.setText(newValue);
				txtfield.setText(newValue);
				}
			});
		
			// ������������ ������� �������������� ������
		choice.showingProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue == true) System.out.println("������ ���������");
			}
		});
		
			// ���������� ������� ����� ������������ ������ ������
		choice.setOnShowing(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("������ ����� � ������");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
			}
		});
		
			// ���������� ������� ��� ����������� ������ ������
		choice.setOnShown(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("���� �����");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
			}
		});
		
			// ���������� ������� ��� ������� ������ ������
		choice.setOnHidden(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("����� ������");
				txtfield.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
			}
		});
		
			/* ���������� TextField ������ ComboBox
		����� getEditor() ���������� TextField, ������� ����� ����� ������������ 	 */
		choice.getEditor().textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("� ��������� ���� ������� ����� ��������" + newValue);
			}
		});
		
				// ����� �������� �� ���������
		//	choice.getSelectionModel().select(0);    	  // �� �������
		//	choice.getSelectionModel().selectFirst();     // ������ �������
		//	choice.getSelectionModel().selectLast();     // ��������� �������
		//	choice.getSelectionModel().selectNext();     // ��������� �������
		
		
		HBox hbox = new HBox(10, lbl, txtfield, choice, apollo13, comboColor);
		hbox.setPadding(new Insets(20, 10, 20, 10));
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CHOISE BOX");  // LbvfRbv1984@#!
		primaryStage.show();
	}
	public void choice_Click() {
		String msg = "���� �����";
			/* C ������� ������ getValue() ����� �������� ������ �� ObservableList, ������� ��� ������ �������������, ��� ��� ����������� ������
			��� ��� ������������ ����� ������� �� �� ������, � ������ ����������� ��������, �� ������� ����� ��������� 
			���������� �� ����� ������� � ������.  ����� getItems() ���������� ������ � ����� contains() ��������� ����������� ��� ����������
			������ ��������  */
		if (choice.getItems().contains(choice.getValue())) 
			msg = msg + " �� ������" + choice.getValue();
		else 
			msg = msg + " �� ������� ������ " + choice.getValue();
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