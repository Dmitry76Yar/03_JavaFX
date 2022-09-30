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
 	реализует текстовой редактор, с помощью которого пользователь может создавать форматируемый текст. Редактор сожержит кнопки для работы 
 	с буфером обмена, для выраванивания текста по горизонтали, для создания нумерованного или маркированного списка, для форматирования
 	текста (подчеркивание, зачеркивание, курсив, абзац и заголовков). В основе редактора лежит текст в формате HTML, одако юзер
 	видит только результат его отображения, а не исходный HTML код.
 	Наследование Object - Node - Parent - Region - Control - HTMLEditor
 		 	КОНСТРУКТОРЫ:
 	- HTMLEditor()						 - создает пустой text field. 
 	- TextArea(String text)				 - создает text area с внесенным текстом */
	
	HTMLEditor editor  = new HTMLEditor();
	editor.setHtmlText(
			"<html><head><title>Название</title></head><body>" + 
			"<h1>Заголовок</h1>" + 
			"<p>Абзац 1 <b>выделенный текст</b></p>" +
			"<p>Абзац 2 <u>подчеркнутый текст</u></p>" +
			"</body></html>");
	
	Button btn = new Button("Получить HTML текст");
	btn.setOnAction(event -> {
		Alert a = new Alert(Alert.AlertType.INFORMATION, editor.getHtmlText());
		a.showAndWait();
		System.out.println(editor.getHtmlText().toString());	// Строку можно сохранить вместо ранее введенной в editor.setHtmlText()
																// для сохранения изменения
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