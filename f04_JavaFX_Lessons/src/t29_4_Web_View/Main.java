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
 	реализует полноценный Web-браузер с поддержкой HTML5 и JavaScript. Именно в WebView отображается HTML-код при использовании
 	компонента HTMLEditor. 
 	Наследование Object - Node - Parent - WebView
 		 	КОНСТРУКТОР:- WebView() 							*/
			
	WebView webView = new WebView();
	WebEngine webEngine = webView.getEngine();
	webEngine.load("file://C:/Program Files/Java/eclipse/eclipse/readme/readme_eclipse.html");
	
/* -------------------------------------------------WebEngine----------------------------------------------------------
 	описывает Web-страницу, отображаемую компонентом WebView. Получить ссылку на объект класса позволяет метод getEngine()
 	Наследование Object - Node - Parent - WebView
 		 	КОНСТРУКТОР:
 		- WebEngine() 							
 		- WebEngine (String url)    */
	
		// ЗАГРУЗКА WEB-СТРАНИЦЫ ПО ЕЕ АДРЕСУ
	WebView webView1 = new WebView();
	WebEngine webEngine1 = webView1.getEngine();
	System.out.println("Web-браузер по умолчанию  - " + webEngine1.getUserAgent());
		// Установка другого браузера
	webEngine1.setUserAgent("MyBot/1.0");
		// Загрузка страницы по указанному адресу в объект класса WebEngine. Загрузка выпол-ся в фоновом режиме 
	webEngine1.load("https://javarush.ru/");
//	hbox.getChildren().addAll(webView);
	
		// ЗАГРУЗКА WEB-СТРАНИЦЫ ИЗ СТРОКИ ЕЕ КОДА
	WebView webView2 = new WebView();
	WebEngine webEngine2 = webView2.getEngine();
	webEngine2.loadContent(
		"<html><head><title>Название</title></head?"
		+ "<body>"
		+ "<h1>Заголовок</h1>\n"
		+ "<p>Абзац <b>выделенный текст</b></p>"
		+ "</body></html>");
//	hbox.getChildren().addAll(webView2);
	
		/* ОБРАБОТКА СОБЫТИЙ ПРИ ЗАГРУЗКЕ WEB-СТРАНИЦЫ ПО ЕЕ АДРЕСУ
	Загрузка Web-страницы осуществляется в фоновом режиме. Чтобы иметь возможность обработать события загрузки, следует
	вызвать метод getLoadWorker() и получить ссылку на объект класса, реализующего интерфейс Worker<V>	 */
	WebView webView3 = new WebView();
	WebEngine webEngine3 = webView3.getEngine();
	webEngine3.getLoadWorker().stateProperty().addListener((obj, oldVlaue, newValue) -> {
		if (newValue == Worker.State.SUCCEEDED) System.out.println("Загрузка выполнено успешно");
		else if (newValue == Worker.State.FAILED) {
			System.out.println("Ошибка загрузки");
			webEngine3.loadContent("<h1>Ошибка загрузки/h1>");
		}
		else if (newValue == Worker.State.CANCELLED) {
			System.out.println("Загрузка отменена");
			webEngine3.loadContent("<h1>Загрузка отменена</h1>");
		}
		else if (newValue == Worker.State.READY) System.out.println("Загрузка на выполнена");
	});
		// Клавиша для отмены загрузки
	Button btn = new Button("ОТМЕНА ЗАГРУЗКИ");
	btn.setOnAction(event -> {
		webEngine3.getLoadWorker().cancel();
	});
		// Прописываем связь, чтобы после загрузки страницы кнопка отмены становилась неактивной
	btn.disableProperty().bind(webEngine3.getLoadWorker().runningProperty().not());
	webView3.setMaxWidth(400); webView3.setMaxHeight(400);
	webEngine3.load("https://javarush.ru/");
	
		// ПОЛУЧЕНИЕ ИНФОРМАЦИИ О WEB-СТРАНИЦЫ 
	System.out.println("URL web страницы - " + webEngine3.getLocation());
	System.out.println("Заголовок web страницы - " + webEngine3.getTitle());
	hbox.getChildren().addAll(webView3, btn);
	
/*-----------------------------------------------ВЗАИМОДЕЙСТВИЕ С JAVASCRIPT-----------------------------------------------
 	Класс WebEngine позволяет выполнять скрипты, написанные на языке JavaScript.  */
	
			/* Некоторые функции JavaScript не реализованы. Например, чтобы отобразить диалоговое окно alert(), нужно назначить 
		обработчик события запроса окна из JavaScript-кода и внутри обработчика создать окно и отобразить его. Назначить обработчик
		позволяет свойство onAlert из класса WebEngine	 */
	
			/*  СОЗДАНИЕ ОБРАБОТЧИКА ALERT ДЛЯ ССЫЛКИ  
		Обработчик выводит текст, который был сохранен в ссылке при назначении обработчика 
		Ниже создание ссылки ALERT(), отображаемой в окне, и назначение для нее обработчикa alert 
		Ссылка имеет название ALERT - код "<a> ALERT()</a>"
		Подчеркивание и выделение синим 	 - код "<a href=\"#\"> ALERT()</a>"
		Назначение обработчика alert для ссылки с помощью кода onclick=\"window.alert('DATA for REFERNCE'); return false;\  */
	WebView webView4 = new WebView();
	WebEngine webEngine4 = webView4.getEngine();
	webEngine4.loadContent("<a href=\"#\" onclick=\"window.alert('DATA for REFERNCE'); return false;\"> ALERT()</a>");
		
		/* Назначение кода для обработчика нажатия ссылки alert через вызов метода setOnAlert()
		В методе void setOnAlert(EventHandler<Web.Event<String>> hadler  в параметр передается объект класса Web.Event<String>, для
		которого с помощью метода getData() можно получить данные ссылки 	 */
	webEngine4.setOnAlert(new EventHandler<WebEvent<String>>() {
		@Override
		public void handle(WebEvent<String> event) {
			System.out.println("Нажата кнопка с данными - " + event.getData());
			Alert alert = new Alert(AlertType.INFORMATION, "Нажата кнопка с данными - " + event.getData());
			alert.showAndWait(); 
		}
	});
		/* Тоже самое с помощью лямбда-выражения
	webEngine4.setOnAlert(event -> {
		System.out.println("Нажата кнопка - " + event.getData());
	});
	//	hbox.getChildren().addAll(webView4, btn); 																*/
	
			/*  СОЗДАНИЕ ОБРАБОТЧИКА CONFIRM ДЛЯ ССЫЛКИ
		Ниже создание ссылки с названием window.confirm(), отображаемой в окне, при переходе по которой вызывается 
		созданная нами функция openConfirm() 
		Ссылка имеет название window.confirm()  - код "<a> window.confirm()</a>")
		Подчеркивание и выделение синим  - - код "<a a href=\"#\" > window.confirm()</a>") 
		Назначение обработчика confirm для ссылки с помощью кода onclick=\"openConfirm(); return false;\   */
	WebView webView5 = new WebView();
	WebEngine webEngine5 = webView5.getEngine();
	webEngine5.loadContent("<a href=\"#\" onclick=\"openConfirm(); return false;\"> window.confirm()</a>");

	/* Назначение кода для обработчика нажатия ссылки CONFIRM через вызов метода setOnAlert()
	В методе void setConfirmHandler(CallBack<String, Boolean> handler в параметр передается функциональный интефейс Callback
	Даный интерфейс имеет метод call(), который вызывается при наступлении события и должен быть определен в коде*/
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
//	if (window.confirm('Текст')) {
//		result.innerHTML = "Вы нажали ОК";
//	}
//	else {
//		result.innerHTML = "Вы нажали Cancel";
//	}
//}

//	hbox.getChildren().addAll(webView5);
	
		/*  СОЗДАНИЕ ОБРАБОТЧИКА PROMPT ДЛЯ ССЫЛКИ  */ 
	
	Scene scene = new Scene(hbox, 600, 600); 
	primaryStage.setScene(scene);
	primaryStage.setTitle("WebView and WebEngine");
	primaryStage.show();
}
		
	public static void main(String[] args) {
		launch(args);
	}
}