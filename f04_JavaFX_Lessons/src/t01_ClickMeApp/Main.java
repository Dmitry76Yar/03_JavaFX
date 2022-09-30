package t01_ClickMeApp;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
	/* Stage ����� - ���������� top-level ��������� ��� ���� �������� ���������� (����� �������� ����, ��� ���������� ��� ��������)
	Scene ����� - ���������, � ������� ���������� ��� ��������, ������������ � ���������
	Layout ����� - ��� �����, ������� ���������� �������� �����; ���������� ��� - ���������������� ������� �������
	�ontrol ����� - ���� ����� �������� �������������� ������, ����� ��� buttons, text boxes, and labels.
	   ������������:
	Button ����� - ���� �� ������ �������, ������� ����������� �� ������ javafx.scene.control.Control. 
	Control ����� - ���� �� ���������� �������, ������ ����������� �� ������ �������� ������ javafx.scene.Node. 
    ����� Node  - ������� ����� ��� ���� ��������� ����������, ������� ����� ���� �������� in a scene. 
	 
	JavaFX application - ��� Java �����, ������� extends javafx.application, ������� ����� ����������� extends Application 
		������ JavaFX application 
	- ��������� ����������� ����� JavaFX (���� ��� �� ��������)
	- ��� �������� ����������� ������, ������� ��������� ����� Application, ��� ����� �������� ��������� ������� ������
	- ����� ����� JavaFX �������� ����� init()
	- ���������� ����� start(javafx.stage.Stage), � ������� ����� JavaFX �������� ��������� ������ Stage. ����� �������, 
	���������� �������� ��������
	 - ����� ����� �������, ���� ���� � ���������� �� ����� ������ ����������� �������� ����� Platform.exit(), 
	 ���� ���� �� ����� ������� ��������� ���� ���������
	 - ����� ���������� ������ ���������� ����� JavaFX �������� ����� stop()
	*/
public class Main extends Application {
	Button btn;
	Label lbl;
	int iClickCount = 0;
	 @Override
	    public void init() throws Exception {
	         
	        System.out.println("Application inits");
	        super.init();
	    }
	 	/* ����� start - ����������� ����� ������ Application, ������� �� ����� default ����������. ����� override ���. 
		   ����� start �������� �� ���������� � ����������� user interface.  */
	@Override 
	public void start(Stage primaryStage) {		
			/* ���������� ������ start() ��-c� ������ Stage - ��� o����a ��� �������� ������������ ���������� 
			   �� ���� �� �������� �����������, � ������� ���������� ��� ��������� ���������� ����������. 
			   �� ��������� ��� ����� ��������� ����������� ����, � �� ��������� ����������� ��������� - ���� ����� ����������
			   � ��������� �� JavaFX ����� ������������ ��������� �������� Stage, �� ���� �� ��� �������� ��������.
			   ��� ������� ���������� �������� ������ Stage ��������� ������ JavaFX � ���������� � ����� start(Stage primaryStage)
			   ���� ������ Stage ���������� ������� ���� ��� ����� ���������. ������ ������ ���������� �� ����� ����� ���������
			   ������ ������� Stage - ������ ����������� ����  		 */
													// ���������. ��������, �� ��������� Stage ����� ������������ ����������� ����.
		btn = new Button();							// �������� ������
		btn.setText("Click me please!");			

		Text text = new Text("Hello!!!");			// C������� �������
		text.setLayoutY(80); 
		text.setLayoutX(80);
		
		lbl = new Label();								// �������� �������, ����������� ���-�� ������� �� �������			
		lbl.setText("You have not clicked the button.");
		
		btn.setOnAction(e -> buttonClick());	/* ����� buttonClick() ����������, ����� ������������ ������ ������  
									Handling an Action Event  - ��������� c�������, ����� ������ - ��� ����� ����� btn.setOnAction():
									����� ��������� ��� ������ ������� �� ������� � ���������
									�� ��������, ������� ������� � ��� ����.  ������ ��������� e -> buttonClick()	
									Event  - ������, ������� ���������, ����� ������������  ��������������� � ���������-���������.
									����� Event ������ ���������� � ����������� ����� Event Handler, � ������� ����������
									����������� �� ������� ����� �������� ���� ���������� � ����������� �������. ��������	*/
		
		BorderPane pane = new BorderPane();			/* ���������� ������ �� layout ������ (pane)
									Pane - ������, ��� ������������� ��� �������� � ��������������� ���� ������������ �����
									Border pane - ������, ��� ������� ����� ������������� � 5 ��������: ����, �����, ������,
									��� � �����. ��� ��������� ������� ��� menu and toolbar at the top, a status bar at the bottom,
									optional task panes or toolbars on the left or right, and a main working area in the center of the screen. 	*/
		pane.setCenter(btn);						// ���������������� ������ �� ������
		pane.setTop(lbl);
		pane.setBottom(text);
		
		/* ��� ���������� ��������, ������� �� ����� ���������� � Stage, ���������� � ������ Scene ��� �� �����. 
		   Scene ������������ ��������� ��� ���� ����������� ��������� ������ ������� Stage � ���� �����, ������� ���������� 
		   Scene Graph. ��� ���� ����� �����, �� ���� �� ���� ��� ��������� �������� ������ ������������ ����� javafx.scene.Node.
		   �� �������� ���� ����� ����� ������ ������������ ������ ������, ������� ����������� �� javafx.scene.Parent. 
		   �� ���� Parent - ��� ���������, ������� ����� ��������� ������ ��������.
		 */
		
		Scene scene = new Scene(pane, 300, 250);	/* ���������� the layout pane to a scene
								    Scene - ��� ���������, � ������� �������� Pane. ����������� - pane, ������ � ������ � ��������
								    Scene ����� ��������� ������ 1 Pane								*/
		primaryStage.setScene(scene);				/* ���������� � Stage ������� scene
						            				Stage ������ ����, � ������� ������������ Scene */
		primaryStage.setTitle("The Click Me App");	
		primaryStage.show();						// ����� Stage
	}
		// stop(): ���������� ����� �������� ����������, ��������, ����� ����, ��� ������������ ����� �� ������� � ������ ������� ����
	 @Override
	 public void stop() throws Exception {
        System.out.println("Application stops");
        super.stop();
	}
	 
	public void buttonClick(){
		iClickCount++;
		if (iClickCount == 1) {
			lbl.setText("You have clicked once");
			btn.setText("You have clicked once");}
		else {
			lbl.setText("You have clicked " + iClickCount + "times!");
			btn.setText("You have clicked " + iClickCount + "times!");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Launching JavaFX");
		launch(args);
		/* ����� launch() �������� JavaFX app. ���� ����� �������� ���������. 
		   ��� ������ ������ launch() ��������� ������ ������ Application � ���������� ���� ����� JavaFX, ������� �������
		   ������� ����� init, ����� ����� start � ����� ���������� ���������� ���������, ����� ���� ��������� ����� stop().
		   ����� init() �� ���� ������ �� ������, �� ��� ����� ��������������, ����� ��������� �������� ����� ������� ������ app.
		   ����� stop() ����� ������ �� ������, �� ��� ����� ��������������, ����� ��������� �������� ����� ������ ��������� app    
		*/
		System.out.println("Finished");
	}
}

/*   ������ �� ��������� ������
 *  ������� � ������� ������� cd �������� � ��������� ������/��������� � ��������, ��� ���������� ���� � �������� �����. 
C:\Users\dkuli\Documents\My_works\JavaFX_Lessons\src\t01_ClickMeApp
	����� ������������ ���������� � ������� �������
	javac --module-path C:\Program Files\JavaFX\javafx-sdk-14.0.2.1\lib --add-modules=javafx.controls Main.java - �� ��������
	��� ������������ JavaFX � Program Files �� ��������� ������ �� �������������
	��� �������� JavaFX �� Program Files �� ���� � - ��� �������� �� ��������� ������
	javac --module-path C:\javafx-sdk-14.0.2.1\lib --add-modules=javafx.controls Main.java
��� ���������� ������������ ����������� ���������� Java - javac. ��� ���������� �������� --module-path, ������� ��������� ��
������������ �������. � ������ ���������� ������ � ����������� �� ����, ��� ���������� SDK, ���� ���� ����� ����������.
����� ����, ����������� �������� add-modules, ������� ��������� �� ������������ ������. � ������ ������ ����������� ������
javafx.controls, ������� �������� ������ �� ������ ������.
	����� �������� ���������������� ���������� � ������� �������
	java --module-path C:\javafx-sdk-14.0.2.1\lib --add-modules=javafx.controls Main    �� �������� ??*/
