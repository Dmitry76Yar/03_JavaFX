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

/*	� JavaFX ������� ������� ����� �����������, ����������� ���������� ���������� ������ ����� � ��������� � ����������� 
����������. ������ ������������ ��������� "������/�������������", ����������� �������� ������ �� �� �����������. � ����
������� ��������� ������, ����������� ��������� Obversablelist<E>, � � ���� �������������- ChoiseBox, ComboBox, ListView.
��������� Obversablelist<E> ��������� ���������� Iterable<E>, Collection<E>, List<E>, Obversable.
	�������� Obversable ����� ������ addListener() � removeListener(), ������� ��������� ��������� � ������� ���������� �������
��������� ������  
  
  ComboBox<T> ������������ ���������� ������ � ������������ ����� ������������� �������� � ��������� ���� 
  ����������� ����� ComboBoxBase<T> �������� ������� ��� ComboBox<T>, ColorPicker, DatePicker 
  
  DatePicker ��������� �������������� ������, �� �������� ����� ������� ����  
  ������������ Object - Node - Parent - Region - Control - ComboBoxBase<Color> - DatePicker    */

public class Main extends Application {
	DatePicker datePicker1  = new DatePicker();;
	
		@Override 
	public void start(Stage primaryStage) 		{
		Stage stage = primaryStage;
		
			/* �����������
		- DatePicker() 							- �������  DatePicker ��� ��������� ����
		- DatePicker(LocalDate localDate)		- ������� DatePicker � ��������� ����� */
		
		DatePicker datePicker1 = new DatePicker();
		DatePicker datePicker2 = new DatePicker(LocalDate.now());
		
		/* ����� void setEditable(boolean value) - ��� true ������������ ����� ������ ���� ������ � ���� text field
		�� ��������� ����� false � ������������ �� ����� ��������� ����������� ����� */
		datePicker1.setEditable(true);
		datePicker2.setEditable(false);
			
			// void setVisibleRowCount(int value) 	- ������������ ����� ��������� ��� ������
		datePicker1.setVisible(true);
		
			// ����������� ������ ������ ������ ����
		datePicker1.setShowWeekNumbers(true);
		
			// void setPromptText(String text) 		- ������������� ������� �����-���������, ������� ���������� ������������
		datePicker1.setPromptText("DATE PICKER");
				
			/* �� ��������� ��� �������� ������ � ��������� ����
			� ������� ������ setValue() ����� ���������� �������, ������� ����� ���������� ����� �� ������ ComboBox  */
		datePicker2.setValue(LocalDate.now());
		
			/* dayCellFactory ��������� �������� ��������� ������ ���������. �������� ����� �������� ����������� ���
		��� ���� ��������, ������� �����-���� ���� ����������� ��� ������, ������� ����������� ���������.			 */
		Callback<DatePicker, DateCell> cellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(DatePicker param) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item == null || empty) return;
							// ������ ���������� ���� ����������� ��� ������
						if (item.equals(LocalDate.now().plusDays(1))) setDisable(true);
							// �������� ��������� ���� ������� ������ � ��������� ����������� ���������
						else if (item.equals(LocalDate.now().minusDays(2))) {
							setTooltip(new Tooltip("�����"));
							setStyle("fx-background-color: #008000;");
						}
							// ���� ������ ��� �������� ������ �������
						if ((item.getDayOfWeek() == DayOfWeek.SATURDAY) || (item.getDayOfWeek() == DayOfWeek.SUNDAY))
							setTextFill(Color.RED);
					}
				};
			}
		};
		datePicker2.setDayCellFactory(cellFactory);
		
		
			/* ������������� ��������� ���������� �������� � ������ � ������� .setOnAction() 
		��������, ��� ��� ������ �������� �� ������, ��� � ��� ����� ������������ � ������� Enter 		 */ 
		datePicker1.setOnAction(e -> 	{
			LocalDate date = datePicker1.getValue();
			Alert alert;
			if (date == null) alert = new Alert(AlertType.INFORMATION, "����� �� �������");
			else alert = new Alert(AlertType.INFORMATION, "Time is  -    " + 
									date.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
			alert.showAndWait();
		});
		
				/* ������������� ��������� ���������� �������� � ������ � ������� .valueProperty().addListener() 
			 ������������� ��������� ���������� �������� � ������ � ������, ���� ������ �������� ��� ���������� ��������
			 ����� ����� ����� ������ �������� ����� Label � ��������� ��������� 		 */
		datePicker2.valueProperty().addListener(new ChangeListener<LocalDate>() {
			@Override
			public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
				System.out.println("��������� ������ datePicker2 � ������������� �� datePicker2.valueProperty().addListener()  � " + 
						oldValue + " �� " + newValue);
			}
		});
		
			// ������������ ������� �������������� ������
		datePicker2.showingProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue == true) System.out.println("������ ���������");
			}
		});
		
			// ���������� ������� ����� ������������ ������ ������
		TextField txtfield = new TextField();
		datePicker2.setOnShowing(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("������ ����� � ������");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
			}
		});
		
			// ���������� ������� ��� ����������� ������ ������
		datePicker2.setOnShown(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				txtfield.setText("���� �����");
				txtfield.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
			}
		});
		
			// ���������� ������� ��� ������� ������ ������
		datePicker2.setOnHidden(new EventHandler<Event>() {
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