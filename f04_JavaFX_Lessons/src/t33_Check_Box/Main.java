package t33_Check_Box;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

/* Check box - ���������, ����� "���������� ������� � ��������������� ������"
  ��������, ����� ������������ ��� ����� �� 3-� ��������� (����� ������� �� 1 �� 3)
  � ������� �� Check box ��� ������ � RadioButton ��� ����� ������� ������ ���� �� ������������ ���������
  
  			������������:
 	- CheckBox() 						 - ������� ����� check box, ������� ���������� ��� ��������� �����
 	- CheckBox(String text)				 - ������� ����� check box � �������
			������:
	- String getText() 				  					- ���������� �����, ������� ��� ������ � ��� ����
	- boolean isSelected()								- ���������� true, ���� ���� check box ������/�������� 
	- void setOnAction(EventHandler<Action Event> value)- ������������� ActionEvent listener ��� ��������� � action events
	- void setSelected(boolean value) 					- �������� ���� �heck box ����� ��� true
	- void setText(String text) 						- ��������� ����� � ����
	
������������: Object - Node - Parent- Region - Control - Labelled - ButtonBase - CheckBox		*/

	
public class Main extends Application {
	CheckBox chkPepperoni, chkMushrooms, chkAnchovies;
	Stage stage;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
			
		Label lbl = new Label("������ ���������� �����");
		HBox paneLbl = new HBox(20, lbl);
		paneLbl.setAlignment(Pos.CENTER);
		paneLbl.setPadding(new Insets(10));		// ��������� �� ���� = 10 ���
		
			// ������������ 		
		chkMushrooms = new CheckBox();
		chkAnchovies = new CheckBox("Anchovies");
		chkPepperoni = new CheckBox("Pepperoni");
		
			// ���� CheckBox �������� ����� � ��������
		chkAnchovies.setSelected(true);							
		
			// �������� ������� �� ������
		chkMushrooms.setText("Mushrooms");	
		
			// ��������� ����� �������� ������ � ������
		chkMushrooms.setLineSpacing(2);
				
			// ������������ ������ � ������
		chkMushrooms.setTextAlignment(TextAlignment.LEFT);			// �� ������ ����
		chkMushrooms.setTextAlignment(TextAlignment.JUSTIFY);		// �� ������
				
			// ��������� �� ���������� ������ ������� �� ������ �/��� ����������� ������ ������
		chkMushrooms.setStyle("-fx-label-padding: 5.0px;");
				
			// ������ ����������� ����� ������� � ��� ������������ ������������ ������� ������ ������
		chkPepperoni.setGraphic(new ImageView("/img/icons.png"));
		chkPepperoni.setContentDisplay(ContentDisplay.TOP);				// ������������� ����������� ������������ ������
		chkPepperoni.setGraphicTextGap(2);								// ������ ��������� ����� ������������ � �������
		chkPepperoni.setAlignment(Pos.CENTER);							// ������ ������������ ������ � ����������� ������ �������
//		Button btn4 = new Button("BUTTON4", imf);
		chkPepperoni.setContentDisplay(ContentDisplay.TOP);				// ������ �����������
		
			// ��������� ���� � ����� ������ ������
		chkAnchovies.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		chkAnchovies.setTextFill(Color.WHITE);
				
			// ��������� � ��������� ������
		chkAnchovies.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// ����� 
		chkAnchovies.setUnderline(true);														// �������������
						
			/* ������ ������� �� ������ ������
		���� true, �� ������ ����� ������������ �� ������
		���� false (�� ���������), �� ������ ����� ����������		 */
		chkAnchovies.setWrapText(false);
						
			// ������ ������, ������� ����� ������������ ��� ������� ������ (���� �� �� ���������� �� ����� ������ ��� ������ �������)
		chkAnchovies.setEllipsisString("/..../");
				
			/* ������ ����� ������� (���� ����� �� ���������� �� ����� ������ ��� ������ �������)
		 - ELLIPSIS 				- ����� ���������� � ����� � ����������� �������� �������� ellipsisString
		 - WORD_ELLIPSIS 			- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CENTER_ELLIPSIS 			- ����� ���������� ���������� � ����������� �������� �������� ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - LEADING_ELLIPSIS 		- ����� ���������� ������� � ����������� �������� �������� ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CLIP 					- ����� ������ ���������� � �����					 */
		chkAnchovies.setTextOverrun(OverrunStyle.ELLIPSIS);
				
		
		chkPepperoni.setOnAction(e -> chkPepperoni_Click() );	// ����� - ��� ������ ����� CheckBox �������� ���������, ��� ����������	
		HBox panePicca = new HBox(20, chkMushrooms, chkAnchovies, chkPepperoni);
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
		String msg = "";
		if (chkPepperoni.isSelected()) 	msg += "Pepperoni\n";
		if (chkMushrooms.isSelected()) 	msg += "Mushrooms\n";
		if (chkAnchovies.isSelected()) 	msg += "Anchovies\n";
		if (msg.equals("")) 	msg = "You didn't order any toppings.";
		else msg = "You ordered these toppings:\n" + msg;
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("Your Order");
		a.showAndWait();
		chkPepperoni.setSelected(false);
		chkMushrooms.setSelected(false);
		chkAnchovies.setSelected(false);
		}
	
	public void chkPepperoni_Click() {
		Alert a = new Alert(Alert.AlertType.WARNING, "We don't do anchovies here.");
		a.setTitle("Yuck!");
		a.showAndWait();
		chkPepperoni.setSelected(false);
	}
	
	public void btnCancel_Click() {
		stage.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}