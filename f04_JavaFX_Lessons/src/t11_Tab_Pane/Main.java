package t11_Tab_Pane;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Main extends Application {
	
		@Override 
	public void start(Stage primaryStage) {	
		
			// TabPane - ��������� ��� �������� ������ � ��������� (��� ��������� � ����������)
		Button btn1 = new Button("Button One");		Button btn2 = new Button("Button Two");		Button btn3 = new Button("Button Three");
		
			/* �������� TabPane
		������������:
		- TabPane () - ������� ������ pane
		- TabPane (Tab...tabs)  				*/
		TabPane pane = new TabPane();
		
			// ��������� �������� ������ �������
		pane.setTabMinWidth(100);
		pane.setTabMinHeight(30);
		pane.setMaxWidth(100);
		pane.setMaxHeight(30);
			
			// ��������� ������� �� ������� ����� ������������ �������
		pane.setSide(Side.TOP);
//		pane.setSide(Side.LEFT);
		
			// ���� true, �� ����, ������������ ����� �� �������, ����� �������������� ������ � ������� �������
		pane.setRotateGraphic(true);
				
			/* ��������� ������� � �������� �������
		UNAVAILABLE - ������������ �� ����� ������� ���
		SELECTED TAB - ����� ������� �������� �������, ���� ������� closable ��� ���� ������� ����� true (�������� �� ���������)
		ALL_TABS -  ����� ������� ����� �������, ���� ������� closable ��� ���� ������� ����� true (�������� �� ���������) 	 */
		pane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
//		pane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		
			/*  ��������� �������������� ������� �������
		FIXED - ������ ������������� ������ (�������� �� ���������)
		REORDER - ������������ ����� �������� ������� ������� ������� 	 */
		pane.setTabDragPolicy(TabPane.TabDragPolicy.REORDER);
		
			/* �������� ������� � ��������� ��������� � ����������� �������
		������������ ������ Tab: 
		 - Tab()
		 - Tab(String text);
		 - Tab(String text, Node content);			*/
		Tab tab1 = new Tab();			
		Tab tab2 = new Tab("TAB2", new Label("���������� ������� 2"));	   
		Tab tab3 = new Tab("TAB3", btn2);
		Tab tab4 = new Tab("TAB4", new Label("���������� ������� 4"));
		
			// ����� ������� �� ������ �������
		tab1.setText("TAB1");
		
			// ��������� ����, �������������� ����� �� ������ ������� �� ������ �������
		tab2.setGraphic(btn1);
		
			// ��������� ����, ������������� �� �������
		tab1.setContent(new Label("���������� ������� 1"));
		
			/* ���������� �������� �������
		�� ��������� ������� ����� ������� ����� ������� �������� �� ���.  ��� ��������� false ������� ������� ������  */
		tab1.setClosable(false);
		
			/*  ���������� ������� ��� �������� �������			 */
		tab2.setOnClosed(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				System.out.println("�� ������� ������� TAB2");
			}
		});
		
			/*  ���������� ������� ��� �������� �������	��� �� ��������	 
		���� ��������� consume, �� ������� ����� ����������, �� ������� �� ���������*/
		tab3.setOnCloseRequest(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				System.out.println("�� �������� ������� ������� TAB3");
				event.consume();
			}
		});
			
			// ������� ������� ����������
		tab4.setDisable(true);
		System.out.println("������� TAB4 ������� ? -  " + tab4.isDisable());
		
		pane.getTabs().add(tab1);
		pane.getTabs().add(tab2);
		pane.getTabs().add(tab3);
		pane.getTabs().add(tab4);
		
				// ��������� �� ������ PANE �� �����
		pane.setPadding(new Insets(20, 20, 20, 20));	// ����������� ��������� �� ����
		
		Scene scene = new Scene(pane, 600.0, 600.0); 
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("BorderPane");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
