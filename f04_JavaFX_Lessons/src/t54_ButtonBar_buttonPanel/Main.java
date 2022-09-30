package t54_ButtonBar_buttonPanel;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.HBox;

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) {			
			
			/* ����� ButtonBar
		������������: Object - Node- Parent - Region - Control - ButtonBar		 
		������� ����������� ����������� ������ � ������ ������������ �������� ����� ���������.
		����� �������� ������ � �������, �������� ����������� � ������������ ������� ������������, ������ ����� ButtonBar.
		�� ��������� �������������� ���������, � ������� �� ����� �������� ������, ������ �� ��������������.
		�������� ��������������, ������ ����� ��������� ������������� 	*/
			
			// ������������ 		
		ButtonBar buttonBar1 = new ButtonBar();		// ������� ������� ���������� �� ��������� (������� �� ������.�������)
		
		ButtonBar buttonBar2 = new ButtonBar("BUTTON_ORDER_WINDOWS");		
		ButtonBar buttonBar3 = new ButtonBar("BUTTON_ORDER_MAC_OS");
		/* ����������� ���� ������� ������� ���������� � ��������� ������� � ������� ����.��������
		  	- BUTTON_ORDER_WINDOWS 	- 	������� L_E+U+FBXI_YNOCAH_R
		  	- BUTTON_ORDER_LINUX - 		������� L_HE+UNYACBXIO_R
		  	- BUTTON_ORDER_MAC_OS - 	������� L_HE+U+FBIX_NCYOA_R
		  	- BUTTON_ORDER_NONE	 - 		������� ����� ��������������� ������� ������ ������, ������� ���������� getButtons()
		 								� ������ ����� ��������� �� ������� ����
		 	���������� ������������� �������������� �� �������� ������ ButtonData.XXX								*/
		System.out.println(ButtonBar.BUTTON_ORDER_WINDOWS);
		System.out.println(ButtonBar.BUTTON_ORDER_LINUX);
		System.out.println(ButtonBar.BUTTON_ORDER_MAC_OS);
			
			// ������ ������� � ����� ������ (�� ������� �� ������ �������������)
		buttonBar2.setButtonOrder("BUTTON_ORDER_NONE");
			
			// �������� ���������� ��� ��������������
		System.out.println(ButtonData.APPLY.getTypeCode());
			
			// ��������� �������������� ��� ������ � ������� ������ setButtonData(Node btn, Button)
		Button btn1 = new Button("RIGHT");			Button btn2 = new Button("LEFT");		Button btn3 = new Button("APPLY");
		Button btn4 = new Button("CANCEL_CLOSE");	Button btn5 = new Button("OK_DONE");	Button btn6 = new Button("NO");
		ButtonBar.setButtonData(btn1, ButtonData.RIGHT);		ButtonBar.setButtonData(btn2, ButtonData.LEFT);
		ButtonBar.setButtonData(btn3, ButtonData.APPLY);		ButtonBar.setButtonData(btn4, ButtonData.CANCEL_CLOSE);
		ButtonBar.setButtonData(btn5, ButtonData.OK_DONE);		ButtonBar.setButtonData(btn6, ButtonData.NO);
		
			// ���������� ������ � ButtonBar
		buttonBar1.getButtons().addAll(btn1, btn2, btn3, btn4, btn5, btn6);		
		buttonBar2.getButtons().addAll(btn1, btn2, btn3, btn4, btn5, btn6);
		buttonBar3.getButtons().addAll(btn1, btn2, btn3, btn4, btn5, btn6);
		
			// ������ ����������� ������ ������ � ButtonBar
		buttonBar1.setMinWidth(30);		buttonBar2.setMinWidth(30);		buttonBar3.setMinWidth(30);
		
			// ������� ������ ������, �������� �� ������ ������
		buttonBar1.setButtonUniformSize(btn1, true);
		
		HBox hbox = new HBox();	
		hbox.getChildren().addAll(buttonBar1);
		Scene scene = new Scene(hbox, 500, 500);	
		primaryStage.setScene(scene);				
		primaryStage.show();						
	}
	public static void main(String[] args) {
		launch(args);
	}
}
