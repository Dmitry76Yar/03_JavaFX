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
/* ListView ��������� ��������� �������������� ����������� (�� ���������) ��� �������������� ������ � ������������ ������ ������
   ��� ���������� ���������, � ����� � ������������ �������������� ���������� �������� �������������.
      � ListView ������ �� �������� ����������, � ������������ �� ������ � ����, ������� �������� ����� ������
   ListView ��������� ������������ �������� �����, ��� ���� �������. �� ��������� - ����� ������ ������ ��������
        ��� ����� ��-�� ��������� ����� ������� ��������, ����� Ctrl. ��� ������ ��������� ��������� ����� ������ Shift
   - ListView �� ����� ���� TextField, ������� ��������� ������������ ������ ���� ������ ������ ����, ����� ��������
   - �������� � ListView ����� ������������ ������������ ������� (�� ���������) ��� �������������� ������� 
        ������������ Object - Node - Parent - Region - Control - ListView<T>			
				������
	- ObservableList<T> getItems() 			- ���������� list of items
	- void setItems(ObservableList<T> items)- ������������ list of items
	- void setOrientation(Orientation o) 	- ������������� ���������� ������ (Orientation.HORIZONTAL ��� Orientation.VERTICAL)
	- MultipleSelectionModel<T> getSelectionModel()	- ��� ������ ����� 1 ��������. ���������� selection model, ������� ����� ����� 
									getSelectedItems() ����� ������������ ��� ��������� ObservableList, ���������� ��������� ��������, */
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
		
		/* ������������
		- ListView<T>() 						- ������� ������ ListView 
		- ListView<T>(ObservableList<T> items)	- ������� ListView � ��������� ��� ���������� � list ���������� ���� */
		
		ListView<Astronaut> apollo13 = new ListView<Astronaut>();
		ObservableList<String> obvList =  
				FXCollections.<String>observableArrayList("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		ListView<String> choice = new ListView<String>(obvList);
		
			/* ����������  */
		apollo13.getItems().add(new Astronaut("Jim", "Lovell"));
		apollo13.getItems().add(new Astronaut("John", "Swigert"));
		haise = new Astronaut("Fred", "Haise");
		apollo13.getItems().add(haise);
			// ���������� ����� setItems
//		choice.setItems(FXCollections.<String>observableArrayList("Bashful2", "Doc2"));
			// ����� ����� �������� ����� ����� addAll()
//		choice.getItems().addAll("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		
			// ������������� ���� (��������, label), ������� ������������ ����� ������ ������
		choice.setPlaceholder(new Label("Empty list"));
		
			// ������ ������������� ������ (��� ������.����������) � ������ (��� �����.����������) ����� ������
		choice.setFixedCellSize(20);
		apollo13.setFixedCellSize(40);
		
			//  void setOrientation(Orientation o) 	- ������������� ���������� ������ (Orientation.HORIZONTAL ��� Orientation.VERTICAL)
		apollo13.setOrientation(Orientation.VERTICAL);
			
			// ��������� �������� �� ������ �� ��������� (����� ����� ������ ����)
		choice.getSelectionModel().selectLast();
		
			// ������� ������ �� �������� �� ������ �� ��������� (����� ����� ������ ����)
		choice.getFocusModel().focus(3);
		
			// �������������� ������ ������������� (�������� ����������� �������) 
		/* 1-�� ��� - ��������� true � ������ void setEditable(boolean value) 
		   2-�� ��� - ������ �������� �������� cellFactory. ����� ����������� ���� ����������� ������ ��������������
		   ��� ��������������� �������� �������� �� ������ Control.cell - ��������, TextFieldListCell<T>, ������� � ������
		   �������������� ���������� ������ ������ ��������� ����	 
		   �������������� ������������ ��� ������� ������ ����� ������� ���� �� ������ ������ ��� ��������� + Enter */
		choice.setEditable(true);		
		choice.setCellFactory(TextFieldListCell.forListView());
				// ���������� ������� ��������������
			// ���������� ������ ��������������
		choice.addEventHandler(ListView.<String>editAnyEvent(), event -> {
//			System.out.println("������� �� ����� �������������� ������");
		});
			// ���������� ������ �������������� ( ��� ������� ������ ����� ������� ���� �� ������ ������ ��� ��������� + Enter)
		choice.addEventHandler(ListView.<String>editStartEvent(), event -> {
			System.out.println("���� � �������������� ������ ������");
		});
			// ���������� ������ �������������� (������������ ������ ���������� ���� ����� Esc ��� ������� � ������ ����)
		choice.addEventHandler(ListView.<String>editCancelEvent(), event -> {
			System.out.println("������ �������������� ������ ������");
		});
			// ���������� ��������� �������������� (������������ ���� �������� � ��������� ���� � ����� Enter)
		choice.addEventHandler(ListView.<String>editCommitEvent(), event -> {
			System.out.println("�������� �������������� ������ ������");
			System.out.println("��� ������� ����� ������ � �������� " + event.getIndex());
			System.out.println("��� ������� ����� ������  " + event.getSource());
			System.out.println("����� �������� ��� ����������� ������  " + event.getNewValue());
				// ���������� �������� � �������
			choice.getItems().set(event.getIndex(), event.getNewValue());
			System.out.println(choice.getItems().toString());
		});
		System.out.println(choice.getItems().toString());
		
			
			/* ����� setSelectionMode(SelectionMode.CONSTANT)
			��� ������� ����������� ������ ������ ������ �������� - ���������
			��� ������� ����������� ������������� ������ - ��������� SelectionMode.MULTIPLE 		 */
		apollo13.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		choice.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
			// ��������� ��������� ��������� ��� ListView � SelectionMode.SINGLE � SelectionMode.MULTIPLE
		choice.setId("CHOISE_ID");
		apollo13.setId("APOLLO_ID");
		Button btn = new Button("GET");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
					// ��������� ��������� ��������� ��� ListView � SelectionMode.SINGLE 
				int index = choice.getSelectionModel().getSelectedIndex();
				String chOb = choice.getSelectionModel().getSelectedItem();
					// ��������� ��������� ��������� ��� ListView � SelectionMode.MULTIPLE
				ObservableList<Integer> obsIndex = apollo13.getSelectionModel().getSelectedIndices();
				ObservableList<Astronaut> obsValue = apollo13.getSelectionModel().getSelectedItems();
				Alert alert = new Alert(AlertType.INFORMATION, "������� �������� apollo ����� � ��������� " + 
						obsIndex.toString() + " � �� ��������� " + obsValue.toString() + "\n ������ ������� choice ����� � �������� " + 
						index + " � �� ��������� "  + chOb);
						alert.showAndWait();
					}
		});
		
		choice.setOnScrollTo(new EventHandler<ScrollToEvent<Integer>>() {
			@Override
			public void handle(ScrollToEvent<Integer> event) {
				System.out.println("��������� � �������� � �������� " + event.getScrollTarget());
			}
		});
		
			// ���������� ������� ���������� ������ ��������� ��� ������������ ������
		FocusModel<String> focusm= choice.getFocusModel();		// ���������� ������ �� ������, ������� ������ � ������
		focusm.focusedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				System.out.println("����� ��������� � " + oldValue + " ������� �� " + newValue);
			}
		});
		
		focusm.focusedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				System.out.println("����� ��������� � " + oldValue + " ������� �� " + newValue);
			}
		});
		
		/* cellFactory ��������� ��������� ���������������� ����� ������ ������ ������. 
		��������, ����� �� ������� ����� ���������� ��������� ����������� ��� ����� ������ ���� (����� Labeled)	 */
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

			// ��������� ������� � ��������� ������		����� ObservableList<T> getItems()	
		System.out.println("������ ������ =  " + apollo13.getItems().size());
		System.out.println("������ apollo13 - " + apollo13.getItems());			 // ������ ����� ������
		System.out.println("������� ������� ������ apollo13 - " + apollo13.getItems().get(0));	 // ������ �������� ������
		
		// ����� �������� �� ���������
//		choice.getSelectionModel().select(0);    	  // �� �������
//		choice.getSelectionModel().selectFirst();     // ������ �������
//		choice.getSelectionModel().selectLast();     // ��������� �������
//		choice.getSelectionModel().selectNext();     // ��������� �������
		
			// ������� ������� �� �����  
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