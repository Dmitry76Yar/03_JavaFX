package t31_Radio_Button;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

/* RadioButton - ��������� ������� �� Check box, �� ����� ����� ������� ������ ���� �� ������������ ���������
  ��� ������ � RadioButton ������������ 2 ������:
  1. ����� RadioButton ��� �������� ����� ������
  2. ����� ToggleGroup ����� ��� ����������� ��������� ������ � ������. ��� ������ �� ����� ������ ����� ������� ������ ���� �������. 
  			������������:
 	- RadioButton() 						 - ������� ����� RadioButton, ������� ���������� ��� ��������� �����
 	- RadioButton(String text)				 - ������� ����� RadioButton � �������
			������:
	- String getText() 				  					- ���������� �����, ������� ��� ������ � ��� ����
	- boolean isSelected()								- ���������� true, ���� ���� RadioButton ������ 
	- void setOnAction(EventHandler<Action Event> value)- ������������� ActionEvent listener ��� ��������� � action events
	- void setSelected(boolean value) 					- �������� ���� RadioButton ����� ��� true
	- void setText(String text) 						- ��������� ����� � ���� 	
	
	������������: Object - Node- Parent - Region - Control - Labeled - ButtonBase - ToggleButton - RadioButton */
	
public class Main extends Application {
	RadioButton rbMushrooms, rbAnchovies, rbPepperoni;
	Stage stage;
	ToggleGroup toggleGroup;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
			
		Label lbl = new Label("������ ���������� �����");
		HBox paneLbl = new HBox(20, lbl);
		paneLbl.setAlignment(Pos.CENTER);
		paneLbl.setPadding(new Insets(10));		// ��������� �� ���� = 10 ���
		
		rbMushrooms = new RadioButton("Mushrooms");
		rbAnchovies = new RadioButton("Anchovies");
		rbAnchovies.setSelected(true);							// ���� RadioButton �������� ����� � ��������
		rbPepperoni = new RadioButton("Pepperoni");
		rbPepperoni.setOnAction(e -> chkPepperoni_Click() );	// ����� - ��� ������ ����� RadioButton �������� ���������, ��� ����������	
		
			/* ����� ToggleGroup ��� ����������� ������ � ������
		������ ����� ������ ����� ���� ������� ������ ���� �������������. ��� ��������� ������� ������������� ������ �����������.
		��� ������������� ToggleButton ����� ��������� ��� ����������� ������ ������ � �������� null
		��� ������������� RadioButton ������ ������ ������ ���� ���� ���������� �������������				 */
		
		toggleGroup = new ToggleGroup();
			// ���������� ������ � ������
		toggleGroup.getToggles().addAll(rbAnchovies, rbMushrooms, rbPepperoni);
			// ����� �������� ���
//		rbPepperoni.setToggleGroup(toggleGroup);
		
		HBox panePicca = new HBox(20, rbMushrooms, rbAnchovies, rbPepperoni);
		panePicca.setAlignment(Pos.CENTER);
		panePicca.setPadding(new Insets(10));	
		
		Button btnOK = new Button("OK");
		btnOK.setMinWidth(75);
		Button btnCancel = new Button("Cancel");
		btnCancel.setMinWidth(75);
		btnOK.setOnAction(e -> btnOK_Click() );
		btnCancel.setOnAction(e -> btnCancel_Click() );
		HBox buttonBox = new HBox(20, btnOK, btnCancel);
		buttonBox.setAlignment(Pos.CENTER_RIGHT);
		buttonBox.setPadding(new Insets(10));		// ��������� �� ���� = 10 ���
		
		VBox pane = new VBox(10, paneLbl, panePicca, buttonBox);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("����� �����");
		primaryStage.show();
	}
	
	public void btnOK_Click() {
		System.out.println(toggleGroup.getSelectedToggle());
		
		String msg = "";
		if (rbPepperoni.isSelected()) 	msg = "Pepperoni";
		if (rbMushrooms.isSelected()) 	msg = "Mushrooms";
		if (rbAnchovies.isSelected()) 	msg = "Anchovies";
		if (msg.equals("")) 	msg = "You didn't order any toppings.";
		else msg = "You ordered the topping:\n" + msg;
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("Your Order");
		a.showAndWait();
		rbAnchovies.setSelected(false);
		rbMushrooms.setSelected(false);
		rbPepperoni.setSelected(false);
		}
	
	public void chkPepperoni_Click() {
		Alert a = new Alert(Alert.AlertType.WARNING, "We don't do Pepperoni here.");
		a.setTitle("Yuck!");
		a.showAndWait();
		rbPepperoni.setSelected(false);
	}
	
	public void btnCancel_Click() {
		stage.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}