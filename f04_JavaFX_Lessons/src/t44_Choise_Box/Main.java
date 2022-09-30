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
/*	� JavaFX ������� ������� ����� �����������, ����������� ���������� ���������� ������ ����� � ��������� � ����������� 
����������. ������ ������������ ��������� "������/�������������", ����������� �������� ������ �� �� �����������. � ����
������� ��������� ������, ����������� ��������� Obversablelist<E>, � � ���� �������������- ChoiseBox, ComboBox, ListView.
��������� Obversablelist<E> ��������� ���������� Iterable<E>, Collection<E>, List<E>, Obversable.
	�������� Obversable ����� ������ addListener() � removeListener(), ������� ��������� ��������� � ������� ���������� �������
��������� ������  
  
  ChoiceBox<T> ������������ ���������� ������, �� �������� ����� ������� ������ ���� �������.
  � ������� �� ComboBox � ChoiceBox ����� � ��������� ��������� ��������������� �������.
  ������������ Object - Node - Parent- Region - Control - ChoiseBox<T>			*/

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
		
			/* ������������
		ChoiceBox<T>() 							- ������� ������ �hoice list ���������� ����
		ChoiceBox<T>(ObservableList<T> items)	- ������� choice list � ��������� ��� ���������� � list ���������� ���� */
		apollo13 = new ChoiceBox<Astronaut>();
		
		ObservableList<String> obvList =  
				FXCollections.<String>observableArrayList("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		choice = new ChoiceBox(obvList);
		
			/* ChoiceBox �� ��������� ��������� � ���� ������, ������� ����� ��������� ��� ������ ����� ChoiceBox 
		������� ����� �������� ����� getItems(), ������� ���������� ������ ���� ObservableList, � ������� ��� ����� 
		��������� ��������  */
		apollo13.getItems().add(new Astronaut("Jim", "Lovell"));		// ��������� ��������� �������
		apollo13.getItems().add(0, new Astronaut("John", "Swigert"));	// ��������� ��������� ������� � ��������� ������� ������
		Astronaut haise = new Astronaut("Fred", "Haise");
		apollo13.getItems().add(haise);
		
			// ����� ����� �������� ����� ����� addAll()
		choice.getItems().addAll();   

		// ��������� ������� � ��������� ������		����� ObservableList<T> getItems()	
		System.out.println("������ ������ =  " + apollo13.getItems().size());
		System.out.println("������ apollo13 - " + apollo13.getItems());			 // ������ ����� ������
		System.out.println("������� ������� ������ apollo13 - " + apollo13.getItems().get(0));	 // ������ �������� ������
		
			/* �� ��������� � choice box ��� �������� ������ � ��������� ����
		� ������� ������ setValue() ����� ���������� �������, ������� ����� ���������� ����� �� ������ ChoiceBox  */
		apollo13.setValue(haise);
		
			/* ������������� ��������� ���������� �������� � ������ � ������� .setOnAction() */ 
		apollo13.setOnAction(e -> apollo_Click());
		
			// ������� ������ ������ hide() � ����������� ����� ������ show()
//		apollo13.hide();
		
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
		
			// ����� �������� �� ���������
//		choice.getSelectionModel().select(0);    	  // �� �������
//		choice.getSelectionModel().selectFirst();     // ������ �������
//		choice.getSelectionModel().selectLast();     // ��������� �������
//		choice.getSelectionModel().selectNext();     // ��������� �������
		
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
			// C ������� ������ getValue() ����� �������� ������ �� ObservableList, ������� ��� ������ �������������
		msg = msg + apollo13.getValue();
		Alert alert = new Alert(AlertType.INFORMATION, msg);
		alert.showAndWait();
		lbl.setText(""+apollo13.getValue());
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}