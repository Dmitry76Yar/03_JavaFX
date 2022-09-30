package t08_Border_Pane;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
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
	
		@Override 
	public void start(Stage primaryStage) {	
		
			/* Border Pane: ��������� pane �� 5 ��������: Top, Left, Center, Right, and Bottom. 
			 ��� ���������� node ����� ������� �������
			 Border pane - ��������� ������� ��� app, ������� ����� ������������ ��� ����, ��� ���� � ������ ������������ ���������
			 ������ ����, status bar ��� ��/Cancel ������ - ����� ����, �������������� ������ - �����, ��������� ���� -�����,
			 � ������� ���������� - � ������
					������:
			- void setCenter(Node node) 		- ������������� ����������� node
			- void setTop(Node node) 			- ������������� ������� node
			- void setRight(Node node) 			- ������������� ������ node
			- void setBottom(Node node) 		- ������������� ������ node
			- void setLeft(Node node) 			- ������������� ����� node
			- void setAlignment(Pos alignment) 	- ������������� alignment ��� nodes
			- static void setMargin(Node child,Insets value) - ���������� margin (������ ���� �� ���� �����) ��� ��������� node.
		 */
		Button btn1 = new Button("Button One");
		Button btn2 = new Button("Button Two");
		Button btn3 = new Button("Button Three");
		Button btn4 = new Button("Button 4");
		Button btn5 = new Button("Button 5");
		Button btn6 = new Button("Button 6");
		Button btn7 = new Button("Button 7");
		Button btn8 = new Button("Button 8");
		Button btn9 = new Button("Button 9");
		Button btn10 = new Button("Central information");
			VBox vboxRight = new VBox(btn1, btn2, btn3);
			vboxRight.setPadding(new Insets(10));
			vboxRight.setAlignment(Pos.CENTER_RIGHT); 
		HBox hbox = new HBox(btn4, btn5, btn6);
		hbox.setPadding(new Insets(10));
		hbox.setAlignment(Pos.CENTER_LEFT);
			VBox vboxLeft = new VBox(btn7, btn8, btn9);
			vboxLeft.setPadding(new Insets(10));
			vboxLeft.setAlignment(Pos.CENTER_LEFT); 
		HBox hboxCenter = new HBox(btn10);
		hboxCenter.setPadding(new Insets(10));
		hboxCenter.setAlignment(Pos.CENTER);
		
			/* �������� BorderPane
		������������:
		- BorderPane () - ������� ������ pane
		- BorderPane (Node center) - ������� pane c ��������� ����������� node.
		- BorderPane (Node center, Node top, Node right, Node bottom, Node left) - ������� pane c ��������� �����������..... nodes	 */
		BorderPane pane = new BorderPane(hboxCenter, null, vboxRight, hbox, vboxLeft);
		
				/* ���������� Nodes � pane.
		 - ����� setLeft(Node node)  					- ��������� ���� �����
		 - ����� setTop(Node node)  					- ��������� ���� ������
		 - ����� setRight(Node node)  
		 - ����� setBottom(Node node)  
		 - ����� setCenter(Node node)   
		 - ����� getchildren.addAll(Node...Children)					*/
		
				// ��������� �� ������ PANE �� �����
		pane.setPadding(new Insets(20, 20, 20, 20));	// ����������� ��������� �� ����
		
				// ���������������� ����� ������ ������
		pane.setAlignment(hboxCenter, Pos.CENTER);					
		
		Scene scene = new Scene(pane, 400.0, 400.0); 
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("BorderPane");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
