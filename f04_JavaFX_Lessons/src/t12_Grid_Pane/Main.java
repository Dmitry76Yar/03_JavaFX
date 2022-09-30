package t12_Grid_Pane;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.*;

/* Panes - ��� ����������� ������, ����� ������� �������� ����������� Nodes �� �����. 
 * ������ ��� Panes ����� ���� �������� ������������.    �������� ������:
    - HBox: ����������� Nodes ������������� ����� ���� � ������ - �� ���� � ������ 
    - VBox: ����������� Nodes ����������� ����� ���� � ������ - �� ���� � �������
    - FlowPane: ����������� Nodes ����� ���� � ������ �� ��� ��� ���� �� ���������� �����, ����� it wraps to continue layout nodes. 
                ����� ������������������ FlowPane ��� ��������������� � ������������� ������������ Nodes 
    - Border: ��������� pane �� 5 ��������: Top, Left, Center, Right, and Bottom.  ��� ���������� node ����� ������� �������
    - GridPane: ��������� pane �� �����, ������������ �������������� ������������ ��������� �� ������� � �������� 
    
    ����� ������������� panes ��� �������� ����� ������� pane. ��������, ����� ������� pane c �������������� ������� ����� � ������������ 
    �������� ������ ������, ����� ������� Border Pane  � ������� HBox � ������ ������� � VBox � ������ �������. 
    ��� ��������, �.�. ��� Pane ��������� javafx.scene.layout.Pane, ������� � ���� ������� ��������� ����� javafx.scene.Node. 
    �� ���� ��� Pane ����� �������� Nodes.   */

		/* GridPane: ��������� pane �� �����, ����������� �������������� ������������ ��������� �� ������� � ��������
		    GridPane ������������� ����������� ������ �������� � ������ ����� �� ������ ������� ����������� ���������
	��� ���������� node ����� ������� �������
	Border pane - ��������� ������� ��� app, ������� ����� ������������ ��� ����, ��� ���� � ������ ������������ ���������
	������ ����, status bar ��� ��/Cancel ������ - ����� ����, �������������� ������ - �����, ��������� ���� -�����,
	� ������� ���������� - � ������
	 		�����������:
	- GridPane grid = new GridPane() - ������� ������ pane
			������:
	- void add(Node node, int col, int row)		- ��������� node � ��������� ������ (column and row index).
	- void add(Node node, int col, int row,int colspan, int rowspan) - ��������� node � ��������� ������ (column and row index) � 
	     � ��������� column and row spans - ������� �������� � ����� �������� ���� node
	- void addColumn(int col, Node... nodes)	-  ��������� � ��������� ������� nodes.
	- void addRow(int row, Node... nodes)		-  ��������� � ��������� ������ nodes.
	- <ObservableList> getColumnConstraints()	- ���������� column constraints.   �� ����
	- <ObservableList> getRowConstraints() 		- ���������� row constraints.      �� ����
	- void setColumnSpan(Node node, int colspan)- ������������� ������� �������� ������ ������ ��������� node.
	- void setRowSpan(Node node, int colspan) 	- ������������� ������� ����� ������ ������ ��������� node.
	- void setHalignment(Node node, HPos value) - ������������� horizontal alignment ��� node.
	 			��������� ��������: HPos.LEFT, HPos.CENTER, HPos.RIGHT.
	- void setValignment(Node node, VPos value) - ������������� vertical alignment ��� node. 
				��������� ��������: HPos.BOTTOM, HPos.CENTER, HPos.TOP.
	- void setHgap(double value) 				- ������������� ������ ������ ����� ���������
	- void setVgap(double value) 				- ������������� ������ ������ ����� ��������
	- static void setMargin(Node node,Insets value)  - ������������� margin (���� ������ ��������) ��� ��������� node.
	- void setPadding(Insets value) 			- ������������� ����� �� �����
	- void setMinHeight(double value)			- ������������� ����������� ������ grid pane.
	- void setMaxHeight(double value) 			- ������������� ������������ ������ grid pane.
	- void setPrefHeight(double value)			- ������������� ����� �� ������ the grid pane.
	- void setMinWidth(double value)			- ������������� ����������� ������ grid pane.
	- void setMaxWidth(double value) 			- ������������� ������������ ������ grid pane.
	- void setPrefWidth(double value)			- ������������� ����� �� ������ grid pane.		*/
			
public class Main extends Application {
	Stage stage;
	TextField txtName, txtPhone, txtAddress;
	RadioButton rdoSmall, rdoMedium, rdoLarge, rdoThin, rdoThick;
	CheckBox chkPepperoni, chkMushrooms, chkAnchovies;
		
		@Override 
	public void start(Stage primaryStage) {
		/* 	 ��� ������������� Scene Builder GridPane ��������� �� ������� Containers. ����� ��� ���������� �������� ������� �� 3-� ����� � 
		 2-� ��������. �� �������� ������� ����������� ������. ���� �������� ����� �������� ���� �� ������, �� ����������� ������� 
		 Layout ��� ������� ������ ��� �������. ���� �� ������ �������� ������ ��������, �� ����� �������, ����������� ��� �������� ������/�������
		 ����� �������� ��������� � ������� ���������� ���������� ��� � ������� ���� � ������ ������.
		 ��� ��������� ������� ��������� ������ ���� �������� ���������, ������������� ������ ������, � ��������������� �������� �������
		 �� ������� Layout � ������� Grid Pane Constraints.	����� �������� �������� ���� �������, ����� �������� ����� �������� ���� �� ���������
		 ����� ������� � �������� �������� ������� �� �������� Properties � Layout			 */

		stage = primaryStage;
			// ��������� � ��������� ���� ��������� ��� customer�s name.
		Label lblName = new Label("Name:");
		txtName = new TextField();	txtName.setMinWidth(100);	txtName.setPrefWidth(200);		txtName.setMaxWidth(300);
		txtName.setPromptText("Enter the name here");	// ������� ������� � ���������� � ������ ��� ����������
		
			// ���������� ��������� ������
	    Separator separator2 = new Separator(Orientation.VERTICAL);
		
			// ��������� � ��������� ���� ��������� ��� customer�s phone number
		Label lblPhone = new Label("Phone Number:");
		txtPhone = new TextField();	txtPhone.setMinWidth(60);	txtPhone.setPrefWidth(120);	txtPhone.setMaxWidth(180);	
		txtPhone.setPromptText("Enter the phone number here");
		
			// ��������� � ��������� ���� ��������� ��� customer�s address
		Label lblAddress = new Label("Address:");
		txtAddress = new TextField();	txtAddress.setMinWidth(100);	txtAddress.setPrefWidth(200);	txtAddress.setMaxWidth(300);
		txtAddress.setPromptText("Enter the address here");
		
			// ��������� � 3 radio buttons (��������� ��������) ��������� � ����������� � VBox � ��������� paneSize.
		Label lblSize = new Label("Size");
		rdoSmall = new RadioButton("Small");
		rdoMedium = new RadioButton("Medium");
		rdoLarge = new RadioButton("Large");
		rdoMedium.setSelected(true);
		ToggleGroup groupSize = new ToggleGroup();		// ��� ToggleGroup ����� ������� ��� 3 radio buttons, �� �� ���� �� ����
		rdoSmall.setToggleGroup(groupSize);
		rdoMedium.setToggleGroup(groupSize);
		rdoLarge.setToggleGroup(groupSize);
		VBox paneSize = new VBox(lblSize, rdoSmall, rdoMedium, rdoLarge);
		paneSize.setSpacing(10);

			// ��������� � 2 radio buttons ��������� ��� ������ ������� ����� � �������� � VBox � ��������� paneStyle
		Label lblCrust = new Label("Crust");
		rdoThin = new RadioButton("Thin");	rdoThick = new RadioButton("Thick");	rdoThin.setSelected(true);
		ToggleGroup groupCrust = new ToggleGroup();		// ��� ToggleGroup ����� ������� ��� 2 radio buttons, �� �� ���� �� ����
		rdoThin.setToggleGroup(groupCrust);		rdoThick.setToggleGroup(groupCrust);	
		VBox paneCrust = new VBox(lblCrust, rdoThin, rdoThick);
		paneCrust.setSpacing(10);

			// ��������� � 3 check boxes ��������� ��� ������ ���������� ����� � �������� � VBox � ��������� paneStyle paneToppings
		Label lblToppings = new Label("Toppings");
		chkPepperoni = new CheckBox("Pepperoni");	chkMushrooms = new CheckBox("Mushrooms");	chkAnchovies = new CheckBox("Anchovies");
		VBox paneToppings = new VBox(lblToppings, chkPepperoni,	chkMushrooms, chkAnchovies);
		paneToppings.setSpacing(10);
			
			// ������ OK � Cancel ��������� � ����������� �  HBox � ��������� paneButton
		Button btnOK = new Button("OK");
		btnOK.setPrefWidth(80);						// ������� ������ ������
		btnOK.setOnAction(e -> btnOK_Click() );		// ������� EventHandler ��� �������
		Button btnCancel = new Button("Cancel");
		btnCancel.setPrefWidth(80);
		btnCancel.setOnAction(e -> btnCancel_Click() );
		HBox paneButtons = new HBox(10, btnOK, btnCancel);

			// �������� GridPane
		GridPane grid = new GridPane();
		
			// ��������� �� ������ PANE �� �����
		grid.setPadding(new Insets(10));
		
			// ��������� ����� �������� � ���������
		grid.setHgap(10);						
		grid.setVgap(10);
		
			// ������� PANE
		grid.setMinWidth(500);
		grid.setPrefWidth(500);
		grid.setMaxWidth(800);
		
			/* ���������� Nodes � pane.
		���������� Nodes �������� ��������������� � pane ��� ������� � Constrains, � ����� �� � Pane 
		���� ���������������� ���������� � Pane
		 - ����� addRow(int rowIndex, Node...Children)  - ��������� ������ � ����� Nodes � ���
		 - ����� addColumn(int columnIndex, Node...Children)  - ��������� ������� � ����� Nodes � ����
		 - ����� add(Node node, int columnIndex, int rowIndex)  - ��������� Nodes � �������� ������� � ������ 
		 - ����� getchildren.addAll(Node...Childre)					*/
			
//		grid.addRow(0, lblName, txtName);		// ��������� � ��������� ���� ��� ���, ����� �������� � ����� �������� � ������ 0,1 � 2 
//												// �.�. ��������� ������ � 1-�� �������, � ���� ��� �������� ���� �� 2-�� �������
//		grid.addRow(1, lblPhone, txtPhone);	
//		grid.addRow(2, lblAddress, txtAddress);
//		grid.addRow(3, paneSize, paneCrust, paneToppings);	// ���������� VBox paneSize, paneCrust, paneToppings � ������ = 3
//		grid.add(paneButtons,2,4);  						// ���������� HBox, ���������� ������ �� � CANCEL � ������� = 2 � ������ = 4
		
				// ����������� �����
		grid.setGridLinesVisible(true);
		
				// ���������������� ����� ������ ������
		GridPane.setHalignment(lblName, HPos.RIGHT);		// ���������������� ������� �� ������� ���� �������
		GridPane.setHalignment(lblPhone, HPos.RIGHT);
		GridPane.setHalignment(lblAddress, HPos.RIGHT);
		
				/* ����������� �����
		setColumnSpan(Node child, int value)		- ������ ���-�� ������������ ����� �� �����������
		setRawSpan(Node child, int value)			- ������ ���-�� ������������ ����� �� ���������  
		� �������� value ����� ������� GridPane.REMAINING - ���� ����� �������� ��� ���������� �������	*/
		
		GridPane.setColumnSpan(txtName,2);					// ����������� ���� ��� �������� ���� �� 2 �������- ������ ��� �������� 2 � 3 ������� 
		GridPane.setColumnSpan(txtPhone,2);
		GridPane.setColumnSpan(txtAddress,2);
		
				/* ��������� ������� ������ ������/������� � Nodes ������ ��� (���� �����)			����� CONSTRAINS
		� �������� ���� ����� �������������� ������ ������� ���� pane, �� �� ������ ��������� ����� � ��������.
		���� ������� ��� ColumnConstraints, ��� RowConstraints ����������� ������ � ������������
		    ����������� CONSTRAINS:
		- ColumnConstraints()										- ������� ������ column constraints ������
		- ColumnConstraints(double width) 							- ������� column constraint ������������� ������, ��� ���� �������� ���
		 										������������ � ����������� ������� ����� ����� �������� Region.Pref_size
		- ColumnConstraints(double min, double pref, double max)	- ������� column constraint ��������� �����., ����������. � ���� ������ */
		
				// ������� ColumnConstraints ��� ������������ ������������� �� �� ������ pane
		ColumnConstraints col1 = new ColumnConstraints();	
		ColumnConstraints col2 = new ColumnConstraints();
		ColumnConstraints col3 = new ColumnConstraints();
				
				/* ��������� ������ (������) ����� (��������) � ������� CONSTRAINS: 
		- void setMinWidth(double value)	- ������������� ����������� ������ ������ 
		- void setMaxWidth(double value)	- ������������� ������������ ������ ������
		- void setPrefWidth(double value) 	- ������������ ���������������� ������ �������
		- void setPercentWidth(double value)- ������������� ������ �������, ��� % �� ����� ������ pane. */
		col1.setPercentWidth(33);
		col2.setPercentWidth(33);
		col3.setPercentWidth(33);
		
				/* ��������� ������������   ����� setHgrow(Node child, Priority priority)
		���� �����, ����� ��� ������������ ����, �����-���� ���� ������� ��� �������, �� ����� ��������� ��� ���� ��������� � �������
		������ setHgrow() � ������������� ������������� ��������� ��� ����� ���� ������� node.setMaxWidth(Double.MAX_VAlUE)	
			 	������ Priority enumeration:
		- Priority.NEVER - ����������, ��� ������ node ������� �� ������ ���������������� ��� ���������� ����� ���������� ������������
		pane. ��� ��������� �� ���������, ������� nodes �� ���������� ��� ��������� ������� pane, ���������� ��.
		- Priority.ALWAYS  -  ������  ������ ��������. ���� 2 � ����� ���� ����� ����� ���������, �� ��� ����� ������� �������
		- Priority.SOMETIMES  - ������ ���� ��������, ������ ���� ��� ������ ����� � ����������� ALWAYS. */ 
		col1.setHgrow(Priority.NEVER);   col2.setHgrow(Priority.SOMETIMES);    col3.setHgrow(Priority.ALWAYS);
			
			// ���������������� ���� ����� ������ ������
		col1.setHalignment(HPos.RIGHT);		
		
				// ���������� CONSTRAINS � PANE
		grid.getColumnConstraints().addAll(col1, col2, col3);
		
				/* ���������� NODES � PANE ����� CONSTRAINS 
		���������� Nodes �������� ��������������� � pane ��� ������� � Constrains, � ����� �� � Pane 
		���� ���������� ����� Constrains ����� ������
		 - add(Node child, int columnIndex, int rowIndex)
		 - add(Node child, int columnIndex, int rowIndex, int columnspan, int rowspan)
		      ��� intcolumn � rowspan - ���-�� ������������ ����� �� ��������� � ����������� ��������������		 		*/
		grid.add(lblName, 0, 0);		grid.add(txtName, 1, 0);
		grid.add(lblPhone, 0, 1);		grid.add(txtPhone, 1, 1);
		grid.add(lblAddress, 0, 2);		grid.add(txtAddress, 1, 2);
		grid.add(paneSize, 0, 3);       grid.add(paneCrust, 1, 3);      grid.add(paneToppings, 2, 3);
	    grid.add(paneButtons, 1, 4);
	    
	    /* ���������� NODES � PANE ����� setCONSTRAINS      ��� ������ ������ ���������� 
	     - setConstrains(Node child, int columnIndex, int rowIndex)
	     - setConstrains(Node child, int columnIndex, int rowIndex, int colspan, int rowspan)
	     - setConstrains(Node child, int columnIndex, int rowIndex, int colspan, int rowspan, Hpos haligment, Vpos valigment)
	     - setConstrains(Node child, int columnIndex, int rowIndex, int colspan, int rowspan, Hpos haligment, Vpos valigment, 
	     				Priority hgrow, Priority vgrow)
	     - setConstrains(Node child, int columnIndex, int rowIndex, int colspan, int rowspan, Hpos haligment, Vpos valigment, 
	     				Priority hgrow, Priority vgrow, Inserts margin)
	     	��� intcolumn � rowspan - ���-�� ������������ ����� �� ��������� � ����������� ��������������		 	
	     	    haligment � valigment - ������������ ���� �� ����������� � ��������� ��������������
	     	    hgrow � vgrow - ���������� ������������ Node  ��� ��������� ������� ����
	     	    margin -��������� ������� ������� ������ */
	    Label first = new Label("First");
        Label second = new Label("Second");
        Label third = new Label("Third");
         
        GridPane root = new GridPane();
        root.getColumnConstraints().add(new ColumnConstraints(80));
        root.getColumnConstraints().add(new ColumnConstraints(150, 150, 150));
        root.getColumnConstraints().add(new ColumnConstraints(70, 70, 70, null, HPos.CENTER, false));
         
        root.setGridLinesVisible(true); // ������ ������� ����� ����� � ��������
        root.setConstraints(first, 0, 0);
        root.setConstraints(second, 1, 0);
        root.setConstraints(third, 2, 0, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5));
        root.getChildren().addAll(first, second, third);
		
				// ������ GET()
	    System.out.println("���-�� ����� = " + grid.getColumnCount());
	    System.out.println("���-�� �������� = " + grid.getRowCount());
	    
	    		// ������� �������
	    GridPane.setMargin(lblName, new Insets(10));
	    
	    		// ������� ������
	    grid.setHgap(2);	// ������� �������������� ������
	    grid.setVgap(3);	// ������� ������������ ������
	    
	    
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pizza Order");
		primaryStage.setMinWidth(500);
		primaryStage.setMaxWidth(900);
		primaryStage.show();
	}
	
	public void btnOK_Click()	{
			// Create a message string with the customer information
		String msg = "Customer:\n";
		msg += "\t Name: \t\t" + txtName.getText() + "\n";
		msg += "\t Phone: \t\t" + txtPhone.getText() + "\n";
		msg += "\t Address: \t\t" + txtAddress.getText() + "\n";
		msg += "You have ordered a ";
			// Add the pizza size
		if (rdoSmall.isSelected())  msg += "small ";
		if (rdoMedium.isSelected()) msg += "medium ";
		if (rdoLarge.isSelected()) 	msg += "large ";
			// Add the crust style
		if (rdoThin.isSelected()) 	msg += "thin crust pizza with ";
		if (rdoThick.isSelected()) 	msg += "thick crust pizza with ";
			// Add the toppings
		String toppings = "";
		toppings = buildToppings(chkPepperoni, toppings);
		toppings = buildToppings(chkMushrooms, toppings);
		toppings = buildToppings(chkAnchovies, toppings);
		if (toppings.equals("")) msg += "no toppings.";
		else msg += "the following toppings:\n" + toppings;
			// Display the message
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("Order Details");
		a.showAndWait();
	}
	
	public String buildToppings(CheckBox chk, String msg)	{
			// Helper method for displaying the list of toppings
		if (chk.isSelected()) 	{
			if (!msg.equals("")) msg += ", ";		// ������ ������� ������, ���� ��� ���� ����������� �����������
			msg += chk.getText();
		}
		return msg;
	}
	
	public void btnCancel_Click() {
	stage.close();
	}
	public static void main(String[] args) {
		launch(args);
	}
}