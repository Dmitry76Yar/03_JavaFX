package t03_Stage_class;
	
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.RadialGradient;

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
		btn.setText("Click me please!");			
		BorderPane pane = new BorderPane();			
		pane.setCenter(btn);						
		Scene scene = new Scene(pane, 300, 250);
		/* ��� ����������� (���� �� ����) ���������� ������ 3 ������ ������������
		 - setScene()    - ������ stage ������ ����� scene
		 - setTtitle     - �������� ����
		 - show() 
		 	������ ������ ��������� ������ ������� ��� � ��������� ����, ���� ��������� �� ��������� �� ����������		 
		 ��������, ���� ��������������� ����������� ������� ���� ��� ��� ������������ */
		
		 primaryStage.setScene(scene);
		 primaryStage.setTitle("TITLE OF STAGE");
		 primaryStage.setHeight(300);
		 primaryStage.setWidth(300);
		 
		 	/* ����������� ������� ����
		 primaryStage.setWidth(100)			- ������������� ������ ����
		 primaryStage.setHeight(100)  		- ������������� ������ ����
		 primaryStage.setMinWidth(200);		- ������������� ����������� ������ ���� (�� ������� ����� ������ ��� ������������) Default - 0
		 primaryStage.setMinHeight(200);	- ������������� ����������� ������ ���� (�� ������� ����� ������ ��� ������������) Default - 0
		 primaryStage.setMaxWidth(600);		- ������������� ������������ ������ ���� (�� ������� ����� ���������) Default - Double.MAX_VALUE
		 primaryStage.setMaxHeight(600);	- ������������� ������������ ������ ���� (�� ������� ����� ���������) Default - Double.MAX_VALUE
		 primaryStage.sizeToScene() 		- ������������� ������� ���� � ������������ � ��������� ����������� ������� Scene
         primaryStage.setFullScreen(false)   - ��� �������� �������� true ���� ������������ �� ���� �����. ��� ������ ESC
		 primaryStage.setMaximized(false);	 - ���������� setFullScreen(), �� ������������ ��������� (�������, ��������...)
		 primaryStage.setIconified(true)	 - ��� �������� �������� true ���� �������������
		 primaryStage.setResizable(true);     - ��� false ���� ������ ���������
		   ����������� ������ get..() ������������ ��� ��������� ��������������� ���������� */
		 
		 	/* ���������������� ���� �� ������ �� ������ �������� ����
		primaryStage.setX(111)			- ������������� �������������� ������ �������� ���� �� ��� �
		primaryStage.setY(111)			- ������������� �������������� ������ �������� ���� �� ��� Y
		primaryStage.getX()				- ���������� �������������� ������ �������� ���� �� ��� �
		primaryStage.getY()				- ���������� �������������� ������ �������� ���� �� ��� Y
		 ������ ��������� ��������� � ����� ������� ���� ������.  ������������� ��� � ���������� ������, ������������� ��� � - ����
		primaryStage.centerOnScreen();	- ����������� ���� � ������ ������   */
		 
		 	/* ���������������� ���� �� ������ �� ��������� �����
		������� ����� ������ ����������� ��� ������������ ���������� � � Y ������, ����� ���������� ����������� ���� ������
		��� ����� ������������ ����� SCREEN � ��� ����������� ������      import javafx.stage.Screen;
		Screen.getPrimary() 					- ���������� ������ �� �������� �����
		Screen.getScreens()						- ���������� ������ �� �������� ����� � ������� ������ ObvervableList<Screen>
		Screen.getPrimary().getDpi() 			- ���������� ���������� ��������� ������
		Screen.getPrimary().getBounds() 		- ���������� ������ Rectangle2D � �������������� ����� ������
		Screen.getPrimary().getVisualBounds()  - ���������� ������ Rectangle2D � �������������� ����� ������ ��� ������ ����� 	 */
		Rectangle2D bounds = Screen.getPrimary().getBounds();
		System.out.println("����������� ���������� X -" + bounds.getMinX());
		
			// ������������ ����������� � ������������ ����
		 primaryStage.xProperty().addListener((obj, oldValue, newValue) -> {
			 System.out.println("���������� � ���������� � " + oldValue + " �� " + newValue);
			 });
		 primaryStage.widthProperty().addListener((obj, oldValue, newValue) -> {
			 System.out.println("������ ���������� � " + oldValue + " �� " + newValue);
			 });
		
			/* ���������� ������� ����
		������ ������ ������ ����� ���������� ������-���� �������� �������� ����� ������� ����, ����� ��� ��������� ������ ���� ����
		primaryStage.setAlwaysOnTop(true)	- ��� �������� �������� true ���� ����� ������ ������������� ������ ������ ����
		primaryStage.toBack();				- ���������� ���� �� ������ ����
		primaryStage.toFront();				- ���������� ���� �� �������� ���� */
		 
		 	/* ������������
		primaryStage.setOpacity(double value)	: ������������� ������������
		primaryStage.getOpacity()				: ���������� �������� ������������
		 	
		 	/* ��������� ����
		 ���� ��������� ���� �� ����� �������, ������� �������� ������ ���� ������.
		 primaryStage.initModality(Modality modality) - ������������� ����������� ����    ������ ���������� �� ������ ������ show()
         ����������� ����� ����:  
          - Modality.NONE  				- ���� �� �������� ���������
          - Modality.APPLICATION_MODAL	- ��������� ���� ��������� ��� ����
          - Modality.WINDOW_MODAL  	 	- ���� ��������� ������ ������������ ���� � �������� ��������
          	  ��� ��� ������������� ���������� ������� ������ �� ������������ ���� � ������� ������ initOwner(Window owner)
          primaryStage.getModality() 	- ���������� ����������� ���� 
          ����� getOwner(): ���������� ������������ ���� � ���� ������� Window, ������� ������� ������� �����
	      Window wind = primaryStage.getOwner();
          */

			/* ����� initStyle(StageStyle.UTILITY) - �������� ����� ���� �� ��������� ���� 
		- DECORATED - �� ���������. ���� ������ ����� � ������, ���������� � ������ ��������, ���������� � ������� � ������ � ����� ������� ����,
		��� �������	�� ������� ������������ ���� ���� ��������, ���������� � �������. ������� ���� �������� 
		- UNDECORATED -  DECORATED, �� ��� ����� � ���������. ������� ���� �� ��������
		- TRANSPARENT - ���������� ���� ��� ����� � ���������. ������� ���� �� ��������
		- UTILITY -  DECORATED, �� � ������������ ������� ������� (��� ������ ��������, ���������� � ������ � ����� ������� ����)
		- UNIFIED - DECORATED, �� ���������� ������� ����� �� ����������
		primaryStage.initStyle(): ���������� ����� ����	 */
		primaryStage.initStyle(StageStyle.DECORATED);
		
				/* ����� ������ ����
		  ���������� ������� ������ ������� 16�16 ��� 32�32 ��� � ��������� ��� � ������� PNG, BMP, JPEG, GIF � ��������� ���
		  � ����� �������� src/img.   �������� ���� � ������ � ������� getResource() � �������� ���� � ����������� ������ IMAGE
		  ������� ����� getIcons() ��� ������� ���� � �������� ������ Image � ������ � ������� add()	 */
		try {
			primaryStage.getIcons().add(new Image(getClass().getResource("/img/icons.png").toExternalForm()));
		} catch (Exception e) {
			System.out.println("�� ������� ��������� ������");
		}
		
			// ����� show(): ���������� ����		
		primaryStage.show();
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
