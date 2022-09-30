package t07_Flow__Pane;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
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

public class Main extends Application {
	int iClickCount = 0;
	
		@Override 
	public void start(Stage primaryStage) {	
		
					/* ������� ���������� NODES � FLOW PANE
		� ������� �� HBox � VBox, ���� ���� �� ���������� � ����� ������/�������, �� ��� ���������� � ���������
		 			������ ����� FLOWPANE
		 -  ObservableList<Node> getChildren()	 	- ���������� ��������� child nodes � ������, ������� ��������� �������� ������ ����� addAll
		 - void setAlignment(Pos alignment) 		- ������������� ������������ ������ ����� � ��������
		 - void setColumnAlignment (Pos alignment) 	- ������������� ������������ ������ ��������
		 - void setHgap(double value) 				- ������������� �������������� �����. 
		 		��� horizontal flow layout - ��� ��������� ����� nodes. ��� vertical flow layout - ��� ��������� ����� ���������
		 - static void setMargin(Node child, Insets value) 	- ������������� margins ��� �������� node.
		 - void setOrientation(Orientation orientation) 	- ������������� ���������� �� Orientation.HORIZONTAL ��� Orientation.VERTICAL
		 - void setPadding(Insets value)					- ������������� ��������� �� ����
		 - void setPrefWrapLength(double value) 			- ������������� ���������������� ����� ��� pane.
		  	��� horizontal flow layout	- ��� ����� ������ pane.  ��� vertical flow layout	- ��� ����� ������ pane.
		 - void setRowAlignment(Pos alignment) 				- ������������� ������������ ������ �����
		 - void setSpacing(double value) 					- ������������� spacing ����� nodes, ������������ � ���� flow layout. 
		 - void setVgap(double value) 						- ������������� ������������ �����.
		 	��� vertical flow layout - ��� ��������� ����� nodes. ��� horizontal flow layout - ��� ��������� ����� ��������
		 */
			
			// ������ �������� horizontal flow pane c 10��� ��� �����. � ������. ������� ����� nodes �
			// ����� ��������� � ���������������� ������ 300 ���
			// �����, ��� ��� ������������ ����, ������ ���������������
		Button btn1 = new Button("Button One");		Button btn2 = new Button("Button Two");		Button btn3 = new Button("Button Three");
		Button btn4 = new Button("Button Four");	Button btn5 = new Button("Button Five");
		
			// ���������� ��������� ������
		Separator separator2 = new Separator(Orientation.VERTICAL);
		
				/* �������� FlowPane
		������������:
		- FlowPane() - ������� ������ �������������� FlowPane � ��������. � ������������� �������� = 0
		- FlowPane(double hgap, double vgap) - ������� ������ �������������� FlowPane � ��������� ��������. � ������������� ��������
		- FlowPane(double hgap, double vgap, Node... children) - ������� �������������� FlowPane � ��������� ��������. � 
			 ������������� �������� � ����������� ��������� child nodes.
		- FlowPane(Node... children) - ������� �������������� FlowPane � ��������. � ������������� �������� = 0
			 � ����������� ��������� child nodes.
		- FlowPane(Orientation orientation) - ������� ������ FlowPane � ��������. � ������������� �������� = 0 � 
		 	�������� ����������� (Orientation.HORIZONTAL ��� Orientation.VERTICAL) 
		- FlowPane(Orientation orientation, double hgap, double vgap) -  - ������� ������ FlowPane � ��������� 
			 ��������. � ������������� �������� � �������� ����������� (Orientation.HORIZONTAL ��� Orientation.VERTICAL)
		- FlowPane(Orientation orientation, double hgap, double vgap, Node... children) - ������� FlowPane � ��������� ��������. � 
			 ������������� ��������, ����������� ��������� child nodes � �������� ����������� (Orientation.HORIZONTAL ��� Orientation.VERTICAL)
		- FlowPane(Orientation orientation, Node... children) - ������� FlowPane � ��������. � ������������� �������� = 0
			 � ����������� ��������� child nodes � �������� ����������� (Orientation.HORIZONTAL ��� Orientation.VERTICAL)  */
		FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 10, 10, btn1, separator2, btn2, btn3, btn4, btn5);
		
				/* ���������� Nodes � pane.
		 - ����� getchildren.addAll(Node...Children)					*/
		
				// ��������� �� ������ PANE �� �����
		pane.setPadding(new Insets(20, 20, 20, 20));	// ����������� ��������� �� ����
		
				// ��������� ����� �������� � ���������
		pane.setHgap(10);						
		pane.setVgap(10);
				
				// ������� PANE
		pane.setPrefWrapLength(300);					// ���������� ����� ��� ������ ���� = 300 ���
		
				// ���������� ����� ������ ���������
		pane.setOrientation(Orientation.HORIZONTAL);
		
				// ���������������� ����� ������ ������
		pane.setAlignment(Pos.CENTER);					// ���������� ��� ������� � �� ���������, � �� �����������
		pane.setColumnHalignment(HPos.CENTER);			// ���������� �� ����������� 
		pane.setRowValignment(VPos.CENTER);				// ���������� �� ���������
		
		Scene scene = new Scene(pane);     	
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("FlowPane");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
