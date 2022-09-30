package t03_Stage_Several_Windows;
	
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/* ������������: Object - Window - Stage
   ���������� ������ start() ��-c� ������ Stage - ��� o����a ��� �������� ������������ ���������� 
			   �� ���� �� �������� �����������, � ������� ���������� ��� ��������� ���������� ����������. 
			   �� ��������� ��� ����� ��������� ����������� ����, � �� ��������� ����������� ��������� - ���� ����� ����������
			   � ��������� �� JavaFX ����� ������������ ��������� �������� Stage, �� ���� �� ��� �������� ��������.
			   ��� �������� JavaFX, �������� primary stage ��������� �������������. ������ �� ���� ������ ���������� � ����� �����. 
							@Override 
							public void start(Stage primaryStage) 	{		}
			   Stage primaryStage ���������� ������� ���� ��� ����� ���������. ������ ������ ���������� �� ����� ����� ���������
			   ������ ������� Stage - ������ ����������� ����
		   Stage ��������� ��������� �����������������, ��������� � ���������� ������� ����������� ���� ����������. ���������� 
		   ��������� �������� ������ ������ Stage
 */

public class Main extends Application {
	Button btn;
		@Override 
	public void start(Stage primaryStage) {			
		btn = new Button();							
		btn.setText("������� ������ ����!");
		btn.setOnAction(event -> {
			newWindow(primaryStage, Modality.APPLICATION_MODAL);
		});
		BorderPane pane = new BorderPane();			
		pane.setCenter(btn);						
		Scene scene = new Scene(pane, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TITLE OF STAGE");
		primaryStage.show();
	}
		
	public void newWindow (Stage parent, Modality modality) {
		Stage window = new  Stage(StageStyle.UTILITY);	// �������� ����
			/* ��������� ����
		 ���� ��������� ���� �� ����� �������, ������� �������� ������ ���� ������.
		 primaryStage.initModality(Modality modality) - ������������� ����������� ����    ������ ���������� �� ������ ������ show()
        ����������� ����� ����:  
         - Modality.NONE  				- ���� �� �������� ���������
         - Modality.APPLICATION_MODAL	- ��������� ���� ��������� ��� ����
         - Modality.WINDOW_MODAL  	 	- ���� ��������� ������ ������������ ���� � �������� ��������
         	  ��� ��� ������������� ���������� ������� ������ �� ������������ ���� � ������� ������ initOwner(Window owner)
         primaryStage.getModality() 	- ���������� ����������� ���� 	 */
		window.setTitle("NEW WINDOW");
		window.initModality(modality);
		window.initOwner(parent);
		
		BorderPane pane = new BorderPane();
		Button btn = new Button("������� ����");
		pane.setCenter(btn);
		btn.setOnAction(event -> {
			window.close();
		});
		window.setScene(new Scene(pane, 200,200));
		window.show();
				/* ����������� Stage(StageStyle) - ����� ������� ������� ����� ����
		- DECORATED - �� ���������. ���� ������ ����� � ������, ���������� � ������ ��������, ���������� � ������� � ������ � ����� ������� ����,
		��� �������	�� ������� ������������ ���� ���� ��������, ���������� � �������. ������� ���� �������� 
		- UNDECORATED -  DECORATED, �� ��� ����� � ���������. ������� ���� �� ��������
		- TRANSPARENT - ���������� ���� ��� ����� � ���������. ������� ���� �� ��������
		- UTILITY -  DECORATED, �� � ������������ ������� ������� (��� ������ ��������, ���������� � ������ � ����� ������� ����)
		- UNIFIED - DECORATED, �� ���������� ������� ����� �� ����������	 */
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
