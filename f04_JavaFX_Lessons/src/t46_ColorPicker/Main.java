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

/*	� JavaFX ������� ������� ����� �����������, ����������� ���������� ���������� ������ ����� � ��������� � ����������� 
����������. ������ ������������ ��������� "������/�������������", ����������� �������� ������ �� �� �����������. � ����
������� ��������� ������, ����������� ��������� Obversablelist<E>, � � ���� �������������- ChoiseBox, ComboBox, ListView.
��������� Obversablelist<E> ��������� ���������� Iterable<E>, Collection<E>, List<E>, Obversable.
	�������� Obversable ����� ������ addListener() � removeListener(), ������� ��������� ��������� � ������� ���������� �������
��������� ������  
  
  ComboBox<T> ������������ ���������� ������ � ������������ ����� ������������� �������� � ��������� ���� 
  ����������� ����� ComboBoxBase<T> �������� ������� ��� ComboBox<T>, ColorPicker, DatePicker 
  
  ColorPicker ��������� �������������� ������, �� �������� ����� ������� ���� 
  ������������ Object - Node - Parent - Region - Control - ComboBoxBase<Color> - ColorPicker    */

public class Main extends Application {
	ColorPicker colorPicker1  = new ColorPicker();;
	
		@Override 
	public void start(Stage primaryStage) 		{
		Stage stage = primaryStage;
		
			/* �����������
		- ColorPicker() 				- �������  ColorPicker � ����� ������ �� ���������
		- ColorPicker(Color color)		- ������� ColorPicker � ��������� ������ */
		
		ColorPicker colorPicker1 = new ColorPicker();
		ObservableList<Color> obvList = FXCollections.<Color>observableArrayList(Color.RED, Color.BLUE, Color.YELLOW);
		ColorPicker colorPicker2 = new ColorPicker();
		
			// ���������� ���������������� ������
		colorPicker1.getCustomColors().add(Color.GREEN);					// ��������� ��������� �������
		colorPicker1.getCustomColors().add(0, Color.ANTIQUEWHITE);		    // ��������� ��������� ������� � ��������� ������� ������
		
			// ����� ����� �������� ����� ����� addAll()
		colorPicker1 = new ColorPicker();
		colorPicker1.getCustomColors().addAll(Color.RED, Color.BLUE, Color.YELLOW);
		
		colorPicker2.getStyleClass().add(ColorPicker.STYLE_CLASS_BUTTON);
		
		/* ����� void setEditable(boolean value) - ��� true ������������ ����� ������ ���� ������ � ���� text field
		�� ��������� ����� false � ������������ �� ����� ��������� ����������� ����� */
		colorPicker1.setEditable(true);
		colorPicker2.setEditable(false);
			
			// void setVisibleRowCount(int value) 	- ������������ ����� ��������� ��� ������
		colorPicker1.setVisible(true);
		
			// void setPromptText(String text) 		- ������������� ������� �����-���������, ������� ���������� ������������
		colorPicker1.setPromptText("COLOR PICKER");
			
			// ��������� ������� � ��������� ������		����� ObservableList<T> getItems()	
		System.out.println("������ ������ =  " + colorPicker1.getCustomColors().size());
		System.out.println("������ apollo13 - " + colorPicker1.getCustomColors());			 // ������ ����� ������
		System.out.println("������� ������� ������ apollo13 - " + colorPicker1.getCustomColors().get(0));	 // ������ �������� ������
				
			/* �� ��������� � ComboBox ��� �������� ������ � ��������� ����
			� ������� ������ setValue() ����� ���������� �������, ������� ����� ���������� ����� �� ������ ComboBox  */
		colorPicker2.setValue(Color.BLUE);
		
			/* ������������� ��������� ���������� �������� � ������ � ������� .setOnAction() 
		��������, ��� ��� ������ �������� �� ������, ��� � ��� ����� ������������ � ������� Enter 		 */ 
		colorPicker2.setOnAction(e -> apollo_Click());
		
				/* ������������� ��������� ���������� �������� � ������ � ������� .valueProperty().addListener() 
			 ������������� ��������� ���������� �������� � ������ � ������, ���� ������ �������� ��� ���������� ��������
			 ����� ����� ����� ������ �������� ����� Label � ��������� ��������� 		 */
		colorPicker2.valueProperty().addListener(new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				System.out.println("��������� ������ colorPicker2 � ������������� �� colorPicker2.valueProperty().addListener()  � " + 
						oldValue + " �� " + newValue);
			}
		});
		
		
			// ������������ ������� �������������� ������
		colorPicker2.showingProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue == true) System.out.println("������ ���������");
			}
		});
		
			// ���������� ������� ����� ������������ ������ ������
		TextField txtfield = new TextField();
		colorPicker2.setOnShowing(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("������ ����� � ������");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
			}
		});
		
			// ���������� ������� ��� ����������� ������ ������
		colorPicker2.setOnShown(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("���� �����");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
			}
		});
		
			// ���������� ������� ��� ������� ������ ������
		colorPicker2.setOnHidden(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("����� ������");
				txtfield.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
			}
		});
		
				// ����� �������� �� ���������
		//	choice.getSelectionModel().select(0);    	  // �� �������
		//	choice.getSelectionModel().selectFirst();     // ������ �������
		//	choice.getSelectionModel().selectLast();     // ��������� �������
		//	choice.getSelectionModel().selectNext();     // ��������� �������
		
		
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