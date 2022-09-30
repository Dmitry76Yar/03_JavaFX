package t04_Scene_class;
	
import java.awt.MultipleGradientPaint.CycleMethod;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
	/* ��� ���������� ��������, ������� �� ����� ���������� � Stage, ���������� � ������ Scene ��� �� �����. 
	Scene ������������ ��������� ��� ���� ����������� ��������� ������ ������� Stage � ���� �����, ������� ���������� 
	Scene Graph. ��� ���� ����� �����, �� ���� �� ���� ��� ��������� �������� ������ ������������ ����� javafx.scene.Node.
	�� �������� ���� ����� ����� ������ ������������ ������ ������, ������� ����������� �� javafx.scene.Parent. 
	�� ���� Parent - ��� ���������, ������� ����� ��������� ������ ��������.   
			��� ��������� ��������� ���� � Scene ����������� ���� �� ������������� ������� Scene. �������� �� ���:
		Scene(Parent root): ������� Scene � �������� ����� root
		Scene(Parent root, double width, double height): ������� Scene � �������� ����� root, � ������� width � ������� height
		Scene(Parent root, Paint fill): ������� Scene � �������� ����� root � ������������� ������� ����
		Scene(Parent root, double width, double height, Paint fill): ������� Scene � �������� ����� root, � ������� width � ������� height � ������������� ������� ����
		��� ���� ��� ������������ ��������� � �������� ������� ��������� �������� ����. �� ���� ��� �������� ������� Scene 
		��� �� ��� ����� �������� ���������� � �������� ����.
		
			��� ����������� ��������, ������� ������������ � ������� Scene � ����������� � Scene Graph, ������ ������������
		����� javafx.scene.Node ��� ����� ����. ��� ���������� ������ ���������� ����������� ��������� ��� ����, ��������, 
		������, ��������� ���� � ������, ����������� �� ������ Node.
			��� ���� ���� ���� Node ����� ��������� ��������� ������ ����� Node. ��������, ����� Parent ����������� �� Node,
		�� ��� ���� ��� ����� ��������� ������ ���� Node.
			������� �������� ������� ����� ����������� ��������� �������:
			
			jafafx.scene.shape.Shape     \       /  jafafx.scene.media.MediaView
			jafafx.scene.shape.Shape3D    - Node -   jafafx.scene.image.ImageView
			jafafx.scene.canvas.Canvas   /   |     
			                                 jafafx.scene.Parent. - jafafx.scene.Group
			                                           |          \ jafafx.scene.web.WebView
	  jafafx.scene.chart.Chart -   jafafx.scene.layout.Region
	  javafx.scene.layout.Pane /                              \ jafafx.scene.control.Control
	  
	  ������� ���������� ��� ��������. �������� ������, ������� ����������� �� ������ Node:
	javafx.scene.shape.Shape: �������� ������� ������� ��� �������� �������������� ���������� ��������� (��������, �����, 
	�������������, ������)
	javafx.scene.shape.Shape3D: �������� ������� ������� ��� �������� ���������� ��������
	javafx.scene.canvas.Canvas: ������������ ������� ��� ��������� ���������� �����������
	javafx.scene.Camera: ������� ����� ������, ������ ����������� ��� ���������� �����
	javafx.scene.LightBase: ������������� ������� ���������� ��� �������, ������� ����� ������������ ��������� �����
	javafx.scene.image.ImageView: ������� ��� ����������� �����������
	javafx.scene.media.MediaView: ������� ��� ������ � �����������
	javafx.embed.swing.SwingNode: ������� ��� ����������� ����������� Swing � JavaFX
	javafx.scene.SubScene: ������� ��� ����� ����� � JavaFX, �������� ������� ����� �� ��������
	javafx.scene.Parent: ������� ����� ��� ���� ���������, ������� ����� ��������� ������ ��������
	����� Parent
	������������ ���������������� ��� ���������� ���������� ������, �� ���������� � �������� � ������ �������� � ����. 
	- javafx.scene.web.WebView: �������, ������� ��������� ���������� ���-����������.
	- javafx.scene.Group: ������������ ��������� ��� ������ ��������
	- javafx.scene.layout.Region: ������� ����� ��� ���� ��������� ����������, ������� ���������� � ��������. 
	��� ������������� ����������� ������� � ���, ��� �� ��������� ���������������� ���������� ��������� � ��������� ���������.
	����� Region
	�������� ������� ������� ��� ����������� ���������� �����������, ������� ����� ����� ���������������.
	- javafx.scene.chart.Chart: ������� ����� ��� ���� ��������.
	- javafx.scene.layout.Pane: ������� ����� ��� ���� ������� ����������, ������� ��������� ��������� ������������� ��������� 
	���������, ������������ ������� ������������� ��.
	- javafx.scene.control.Control: ������� ����� ��� ���� ��������� ���������� (������, ��������� ����� �����, ������� � �.�.).  */

public class Main extends Application {
	Button btn;
		@Override 
	public void start(Stage primaryStage) {			
        Label label = new Label("Hello");        
        label.setMinWidth(50);      label.setMinHeight(50);
        Button button = new Button("Button");    
        Button button2 = new Button("������ ���� �����");
        button2.setId("Button2");
        button.setMinWidth(50);     button.setMinHeight(50);
        Group group = new Group(button, button2);                // ��������� ���� Group. K���� Group ����������� �� ������ Parent.
        HBox hbox = new HBox(label,button,group);
        hbox.setSpacing(20);	hbox.setPadding(new Insets(20));
        hbox.setMinWidth(200);
        hbox.setMinHeight(200);
        
        	/* ������������
       	Scene(Parent root)												��� root - ��������� (HBox ��� VBOX ���...) ������ �������� ������
       	Scene(Parent root, double width, double height)					��� �������� ��������
       	Scene(Parent root, double width, double height, Paint fill)
       	Scene(Parent root, Paint fill)											fill ������ ��������� ���� ����� 
       	Scene(Parent root, double width, double height, boolean depthBuffer)
       		��� depthBuffer = true ������ ����� ����� ������ �������, ��� ������������ ��� ����������� ������������
        Scene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing)
        	 �������� antiAliasing ������ ������� �����������*/
        Scene scene = new Scene(hbox, 300, 300, Color.AQUA);
        
        	// ��������� ������� ���������� �������� ������
        System.out.println("��������� �������� ������ ������ - " + scene.getRoot().toString());
        scene.setRoot(hbox);
        System.out.println("��������� �������� ������ ������ - " + scene.getRoot().toString());
       
       		/* ����������� ������� ����
       	 � ������� ������������� � ���������.  ��� ���������� � ������������ ���� ����� �������, ����� ��� ������� �����������
       	 ������� ��������� ������� � Scene ���
		 scene.getWidth()			- ���������� ������ ����
		 scene.getHeight()  		- ���������� ������ ����
		 scene.widthProperty()  	- ���������� ������ �� ��������, ������ ������� � ������� �����
		 scene.heightProperty()  	- ���������� ������ �� ��������, ������ ������� � ������� �����  */
       
       		/* ���������������� ����� ������������ ������ �������� ���� ����
		scene.getX()		- ���������� �������������� ������ �������� ���� �� ��� � ����� ������������ ������ �������� ���� ���� STAGE
		scene.getY()		- ���������� �������������� ������ �������� ���� �� ��� Y ����� ������������ ������ �������� ���� ���� STAGE
		�� ���� ��� �������� ���������� ������ ������� ������� ���� Scene.
		scene.xProperty()  	- ���������� ������ �� ��������, ������ ������� � ����������� X
		scene.yProperty()  	- ���������� ������ �� ��������, ������ ������� � ����������� Y
		���������� ����� �������� ������ ����� �����������   */
       
        	/* ��������� ����� SCENE � ��������� �������� �������
        C ������� ������������ - Scene(Parent root, Paint fill) � Scene(Parent root, double width, double height, Paint fill)
        C ������� ������ setFill(Paint fill)
        �������� ����� ����� ����
          - COLOR 			- �������� ����		
          - ImagePattern 	- ������� �����������
          - LinearGradient 	- �������� ��������
          - RadialGradient 	- ���������� ��������
        ����� - ����� ���� ����� ��� �����, ���������� ������� ��������� �������� ������ ���������� */
        hbox.setBackground(Background.EMPTY);
        scene.setFill(Color.BISQUE);
        
        	// ��������� �������� �������
        ImagePattern im = null; ;
        	// ���������  �������� �������, ������� ������������� �� ��� ����
        try {
			im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg")));
			scene.setFill(im);
		} catch (Exception e) {
			System.out.println("�� ������� ��������� �����������");
		}
        	// ��������� �������� ������� ������������� ������� 
        	// ���� ������ ��� �� ������������� �����������, �� ��� ������������ ���� ����������� ����� ����� ������������ ����������������� 
        try {
			im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg")),
					100, 100, 0.3, 0.3, true);
			/* ����� ����������� ImagePattern(Image img, double x, double y, double width, double height, boolean proportional)
			   ��� x, y- ��������� ����������, � ������� ���� ����������� �����������,
			       width, height - ������ � ������� ����� ���������� ��������� �����������,
			       proportional - ��� true ������� ����������� � ����� �� 0 �� 1 	 */
			scene.setFill(im);
		} catch (Exception e) {
			System.out.println("�� ������� ��������� �����������");
		}
        	// ���������  �������� ������� ������������� �������
        	// ���� ������ ��� �� ������������� �����������, �� ��� ������������ ���� ����������� �� ����� ������ ������, 
        	// � ����� ����������� ����� ��� ���������� ����� ����
        try {
			im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg")),
						100, 100, 50, 50, false);
				/* ����� ��� ������������� ImagePattern(Image img, double x, double y, double width, double height, boolean proportional), 
				   �� ������� ������� � ��������, � �� � ����� */
			scene.setFill(im);
		} catch (Exception e) {
			System.out.println("�� ������� ��������� �����������");
		}
        
        	/* ��������� ��������� ���������
        Stop stop1 = new Stop(0, Color.BLACK);
        Stop stop2 = new Stop(1, Color.WHITE);
        LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stop1, stop2);      �� �������� */
        
    		// ��������� ����������� ���������
        RadialGradient rg = RadialGradient.valueOf("center 100px 100 px, radius 300px, red 0%, blue 50%, black 100%");
        scene.setFill(im);

        	// ���������� ��� ����������� ���������� ���� �����
        scene.addEventHandler(ActionEvent.ACTION, event -> {
        	if (event.getTarget() instanceof Button) {
        		Button a = (Button)event.getTarget();
        		if (a.getId().equals("Button2")) {
        			System.out.println("Button was pressed");
        			Scene s = a.getScene();
        			System.out.println("Height of scene - " + s.getHeight());
        		}
        	}
        });
        
        	/* ����� � �������� ��������� ���� ��������� ����� FlowPane
			   FlowPane �������� ������ Label (��������� �����) � ������ Group.
			   � ������ Group, � ���� �������, �������� ������ Button (������).
			   					FlowPane
			   					/	\
			   			   Label    group
			   			             /\
			   			               button
        	 */
        primaryStage.setTitle("Hello JavaFX");
        
        primaryStage.setScene(scene);                    // ��������� Scene ��� Stage
        primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
