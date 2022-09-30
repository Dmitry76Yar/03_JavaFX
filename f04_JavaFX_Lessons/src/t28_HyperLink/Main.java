package t28_HyperLink;
	
import java.awt.Desktop;
import java.net.URI;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) {
			
			/* Абстрактный класс ButtonBase являетс базовым для кнопок, переключателей, флажков и гиперссылок
			Наследование: Object - Node- Parent - Region - Control - Labeled - ButtonBase		 */
			
			/* HyperLink позволяет отобразить гиперссылку в окне 
			По сути HyperLink это и текстовая надпись (наследует Labeled) и кнопка (наследует ButtonBase)
			Наследование: Object - Node- Parent - Region - Control - Labeled - ButtonBase - Hyperlink		 */
			
			// Конструкторы 		
		Hyperlink hyperlink1 = new Hyperlink();
		Hyperlink hyperlink2 = new Hyperlink("ССЫЛКА2");			// В тексте указывается текст   
			// Конструктор ниже помимо текста также отображает изображение слева от текста (по умолчанию)
		ImageView imf = new ImageView("/img/icons.png");
		Hyperlink hyperlink3 = new Hyperlink("-----ССЫЛКА3-------", imf);
		
			// Внесение ссылки в объект
		hyperlink1.setText("ССЫЛКА1");	
		
			// Растояние между строками
		hyperlink1.setLineSpacing(2);
		
			// Выравнивание текста 
		hyperlink1.setTextAlignment(TextAlignment.LEFT);		// По левому краю
		hyperlink1.setTextAlignment(TextAlignment.JUSTIFY);		// По ширине
		
			// Растояние от внутренних границ области до текста и/или изображения 
		hyperlink1.setStyle("-fx-label-padding: 5.0px;");
		
			// Задает изображение около надписи и его расположение относительно надписи внутри кнопки
		hyperlink1.setGraphic(new ImageView("/img/icons.png"));
		hyperlink1.setContentDisplay(ContentDisplay.TOP);				// Позиционирует изображение относительно текста
		hyperlink1.setGraphicTextGap(2);								// Задает растояние между изображением и текстом
		hyperlink1.setAlignment(Pos.CENTER);							// Задает выравнивание текста и изображения внутри области
		Hyperlink hyperlink4 = new Hyperlink("https://yandex.ru/", imf);
		hyperlink4.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);				// Только изображение
		
			// Установка фона и цвета текста кнопуи
		hyperlink2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		hyperlink2.setTextFill(Color.WHITE);
		
			// Установка и настройка текста
		hyperlink2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// Шрифт 
		hyperlink2.setUnderline(true);														// Подчеркивание
				
			/* Задает перенос на другую строку
		Если true, то строка будет переноситься на другую
		Если false (по умолчанию), то строка будет обрезаться		 */
		Hyperlink hyperlink5 = new Hyperlink("https://yandex.ru/images/?from=tabbar");
		hyperlink5.setFont(new Font(17));
		hyperlink5.setWrapText(false);
				
			// Задает строку, которая будет показываться при обрезке текста (если он не помещается на одной строке или внутри области)
		hyperlink5.setEllipsisString("/..../");
			
			/* Задает режим обрезки (если текст не помещается на одной строке или внутри области)
		 - ELLIPSIS 				- текст обрезается в конце и добавляется значение свойства ellipsisString
		 - WORD_ELLIPSIS 			- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CENTER_ELLIPSIS 			- текст обрезается посередине и добавляется значение свойства ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - LEADING_ELLIPSIS 		- текст обрезается вначале и добавляется значение свойства ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CLIP 					- текст просто обрезается в конце					 */
		hyperlink5.setTextOverrun(OverrunStyle.ELLIPSIS);
		
					// ОБРАБОТЧИК 
			// С помощью анониманого класса
		hyperlink1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Переход по гиперссылке кнопка");
					// Чтобы запустить Web-браузер, используемый в системе по умолчанию, и передать ему адрес ссылки
				if (Desktop.isDesktopSupported()) {
					try {	Desktop.getDesktop().browse(URI.create("https://yandex.ru/"));}
					catch (Exception e) {System.out.println("Не удалось запустить браузер");}
				}
			}
		});
			// С помощью лямбда-выражения
		hyperlink2.setOnAction(event -> {
			System.out.println("Переход по гиперссылке кнопка");
				// Чтобы запустить Web-браузер, используемый в системе по умолчанию, и передать ему адрес ссылки
			if (Desktop.isDesktopSupported()) {
				try {	Desktop.getDesktop().browse(URI.create("https://yandex.ru/"));}
				catch (Exception e) {System.out.println("Не удалось запустить браузер");}
			}
		});
			// С помощью метода addEventHandler()
		hyperlink3.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
				@Override
			public void handle(ActionEvent event) {
				System.out.println("Переход по гиперссылке кнопка");
					// Чтобы запустить Web-браузер, используемый в системе по умолчанию, и передать ему адрес ссылки
				if (Desktop.isDesktopSupported()) {
					try {	Desktop.getDesktop().browse(URI.create("https://yandex.ru/"));}
					catch (Exception e) {System.out.println("Не удалось запустить браузер");}
				}
			}
		});
		
//				// ИМИТАЦИЯ НАЖАТИЯ НА КПОНКУ МЫШЬЮ из кода программы
//		btn3.arm();
//		btn3.requestFocus();
//		PauseTransition tr = new PauseTransition(Duration.seconds(1.0));
//		tr.setOnFinished(event -> {
//			btn3.fire();
//			btn3.disarm();
//		});
//		tr.play();
//		
			
		HBox hbox = new HBox();	
		hbox.getChildren().addAll(hyperlink1, hyperlink2, hyperlink3, hyperlink4, hyperlink5);
		Scene scene = new Scene(hbox, 700, 500);	// Добавление the layout pane to a scene
		primaryStage.setScene(scene);				// Добавление в Stage объекта scene
		primaryStage.show();						// Показ Stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}
