package t29_4_Web_View;
	
import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.*;
import javafx.util.Callback;
	
public class Main extends Application {
		
		@Override 
	public void start(Stage primaryStage) {
	HBox hbox = new HBox();
		
/* -------------------------------------------------WebView----------------------------------------------------------
 	��������� ����������� Web-������� � ���������� HTML5 � JavaScript. ������ � WebView ������������ HTML-��� ��� �������������
 	���������� HTMLEditor. 
 	������������ Object - Node - Parent - WebView
 		 	�����������:- WebView() 							*/
			
	WebView webView = new WebView();
	WebEngine webEngine = webView.getEngine();
	webEngine.load("file://C:/Program Files/Java/eclipse/eclipse/readme/readme_eclipse.html");
	
/* -------------------------------------------------WebEngine----------------------------------------------------------
 	��������� Web-��������, ������������ ����������� WebView. �������� ������ �� ������ ������ ��������� ����� getEngine()
 	������������ Object - Node - Parent - WebView
 		 	�����������:
 		- WebEngine() 							
 		- WebEngine (String url)    */
	
		// �������� WEB-�������� �� �� ������
	WebView webView1 = new WebView();
	WebEngine webEngine1 = webView1.getEngine();
	System.out.println("Web-������� �� ���������  - " + webEngine1.getUserAgent());
		// ��������� ������� ��������
	webEngine1.setUserAgent("MyBot/1.0");
		// �������� �������� �� ���������� ������ � ������ ������ WebEngine. �������� �����-�� � ������� ������ 
	webEngine1.load("https://javarush.ru/");
//	hbox.getChildren().addAll(webView);
	
		// �������� WEB-�������� �� ������ �� ����
	WebView webView2 = new WebView();
	WebEngine webEngine2 = webView2.getEngine();
	webEngine2.loadContent(
		"<html><head><title>��������</title></head?"
		+ "<body>"
		+ "<h1>���������</h1>\n"
		+ "<p>����� <b>���������� �����</b></p>"
		+ "</body></html>");
//	hbox.getChildren().addAll(webView2);
	
		/* ��������� ������� ��� �������� WEB-�������� �� �� ������
	�������� Web-�������� �������������� � ������� ������. ����� ����� ����������� ���������� ������� ��������, �������
	������� ����� getLoadWorker() � �������� ������ �� ������ ������, ������������ ��������� Worker<V>	 */
	WebView webView3 = new WebView();
	WebEngine webEngine3 = webView3.getEngine();
	webEngine3.getLoadWorker().stateProperty().addListener((obj, oldVlaue, newValue) -> {
		if (newValue == Worker.State.SUCCEEDED) System.out.println("�������� ��������� �������");
		else if (newValue == Worker.State.FAILED) {
			System.out.println("������ ��������");
			webEngine3.loadContent("<h1>������ ��������/h1>");
		}
		else if (newValue == Worker.State.CANCELLED) {
			System.out.println("�������� ��������");
			webEngine3.loadContent("<h1>�������� ��������</h1>");
		}
		else if (newValue == Worker.State.READY) System.out.println("�������� �� ���������");
	});
		// ������� ��� ������ ��������
	Button btn = new Button("������ ��������");
	btn.setOnAction(event -> {
		webEngine3.getLoadWorker().cancel();
	});
		// ����������� �����, ����� ����� �������� �������� ������ ������ ����������� ����������
	btn.disableProperty().bind(webEngine3.getLoadWorker().runningProperty().not());
	webView3.setMaxWidth(400); webView3.setMaxHeight(400);
	webEngine3.load("https://javarush.ru/");
	
		// ��������� ���������� � WEB-�������� 
	System.out.println("URL web �������� - " + webEngine3.getLocation());
	System.out.println("��������� web �������� - " + webEngine3.getTitle());
	hbox.getChildren().addAll(webView3, btn);
	
/*-----------------------------------------------�������������� � JAVASCRIPT-----------------------------------------------
 	����� WebEngine ��������� ��������� �������, ���������� �� ����� JavaScript.  */
	
			/* ��������� ������� JavaScript �� �����������. ��������, ����� ���������� ���������� ���� alert(), ����� ��������� 
		���������� ������� ������� ���� �� JavaScript-���� � ������ ����������� ������� ���� � ���������� ���. ��������� ����������
		��������� �������� onAlert �� ������ WebEngine	 */
	
			/*  �������� ����������� ALERT ��� ������  
		���������� ������� �����, ������� ��� �������� � ������ ��� ���������� ����������� 
		���� �������� ������ ALERT(), ������������ � ����, � ���������� ��� ��� ����������a alert 
		������ ����� �������� ALERT - ��� "<a> ALERT()</a>"
		������������� � ��������� ����� 	 - ��� "<a href=\"#\"> ALERT()</a>"
		���������� ����������� alert ��� ������ � ������� ���� onclick=\"window.alert('DATA for REFERNCE'); return false;\  */
	WebView webView4 = new WebView();
	WebEngine webEngine4 = webView4.getEngine();
	webEngine4.loadContent("<a href=\"#\" onclick=\"window.alert('DATA for REFERNCE'); return false;\"> ALERT()</a>");
		
		/* ���������� ���� ��� ����������� ������� ������ alert ����� ����� ������ setOnAlert()
		� ������ void setOnAlert(EventHandler<Web.Event<String>> hadler  � �������� ���������� ������ ������ Web.Event<String>, ���
		�������� � ������� ������ getData() ����� �������� ������ ������ 	 */
	webEngine4.setOnAlert(new EventHandler<WebEvent<String>>() {
		@Override
		public void handle(WebEvent<String> event) {
			System.out.println("������ ������ � ������� - " + event.getData());
			Alert alert = new Alert(AlertType.INFORMATION, "������ ������ � ������� - " + event.getData());
			alert.showAndWait(); 
		}
	});
		/* ���� ����� � ������� ������-���������
	webEngine4.setOnAlert(event -> {
		System.out.println("������ ������ - " + event.getData());
	});
	//	hbox.getChildren().addAll(webView4, btn); 																*/
	
			/*  �������� ����������� CONFIRM ��� ������
		���� �������� ������ � ��������� window.confirm(), ������������ � ����, ��� �������� �� ������� ���������� 
		��������� ���� ������� openConfirm() 
		������ ����� �������� window.confirm()  - ��� "<a> window.confirm()</a>")
		������������� � ��������� �����  - - ��� "<a a href=\"#\" > window.confirm()</a>") 
		���������� ����������� confirm ��� ������ � ������� ���� onclick=\"openConfirm(); return false;\   */
	WebView webView5 = new WebView();
	WebEngine webEngine5 = webView5.getEngine();
	webEngine5.loadContent("<a href=\"#\" onclick=\"openConfirm(); return false;\"> window.confirm()</a>");

	/* ���������� ���� ��� ����������� ������� ������ CONFIRM ����� ����� ������ setOnAlert()
	� ������ void setConfirmHandler(CallBack<String, Boolean> handler � �������� ���������� �������������� �������� Callback
	����� ��������� ����� ����� call(), ������� ���������� ��� ����������� ������� � ������ ���� ��������� � ����*/
	webEngine5.setConfirmHandler(new Callback<String, Boolean>() {
		@Override
		public Boolean call(String param) {
			System.out.println("cdmvndfnv");
			System.out.println(param);
			return false;
		}
	});
	
//	function openConfirm() {
//	var result = document.getElementById("result");
//	if (window.confirm('�����')) {
//		result.innerHTML = "�� ������ ��";
//	}
//	else {
//		result.innerHTML = "�� ������ Cancel";
//	}
//}

//	hbox.getChildren().addAll(webView5);
	
		/*  �������� ����������� PROMPT ��� ������  */ 
	
	Scene scene = new Scene(hbox, 600, 600); 
	primaryStage.setScene(scene);
	primaryStage.setTitle("WebView and WebEngine");
	primaryStage.show();
}
		
	public static void main(String[] args) {
		launch(args);
	}
}