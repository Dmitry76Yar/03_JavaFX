package t29_3_HTMLEditor;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.*;
	
public class Main extends Application {
		
		@Override 
	public void start(Stage primaryStage) {
		
/* -------------------------------------------------HTML EDITOR----------------------------------------------------------
 	��������� ��������� ��������, � ������� �������� ������������ ����� ��������� ������������� �����. �������� �������� ������ ��� ������ 
 	� ������� ������, ��� ������������� ������ �� �����������, ��� �������� ������������� ��� �������������� ������, ��� ��������������
 	������ (�������������, ������������, ������, ����� � ����������). � ������ ��������� ����� ����� � ������� HTML, ����� ����
 	����� ������ ��������� ��� �����������, � �� �������� HTML ���.
 	������������ Object - Node - Parent - Region - Control - HTMLEditor
 		 	������������:
 	- HTMLEditor()						 - ������� ������ text field. 
 	- TextArea(String text)				 - ������� text area � ��������� ������� */
	
	HTMLEditor editor  = new HTMLEditor();
	editor.setHtmlText(
			"<html><head><title>��������</title></head><body>" + 
			"<h1>���������</h1>" + 
			"<p>����� 1 <b>���������� �����</b></p>" +
			"<p>����� 2 <u>������������ �����</u></p>" +
			"</body></html>");
	
	Button btn = new Button("�������� HTML �����");
	btn.setOnAction(event -> {
		Alert a = new Alert(Alert.AlertType.INFORMATION, editor.getHtmlText());
		a.showAndWait();
		System.out.println(editor.getHtmlText().toString());	// ������ ����� ��������� ������ ����� ��������� � editor.setHtmlText()
																// ��� ���������� ���������
	});
	
	HBox hbox1 = new HBox(20, editor, btn);

	Scene scene = new Scene(hbox1, 800, 600);
	primaryStage.setScene(scene);
	primaryStage.setTitle("HTML");
	primaryStage.show();
}
		
	public static void main(String[] args) {
		launch(args);
	}
}