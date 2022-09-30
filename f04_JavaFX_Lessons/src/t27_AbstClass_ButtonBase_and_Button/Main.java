package t27_AbstClass_ButtonBase_and_Button;
	
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
			
			/* Класс Button
		Наследование: Object - Node- Parent - Region - Control - Labeled - ButtonBase - Button		 */
			
			// Конструкторы 		
		Button btn = new Button();
		Button btn2 = new Button("BUTTON2");
			// Конструктор ниже помимо текста также отображает изображение слева от текста (по умолчанию)
		ImageView imf = new ImageView("/img/icons.png");
		Button btn3 = new Button("BUTTON3", imf);
		
			// Внесение надписи на кнопке
		btn.setText("Click me please!");		
		
			// Кнопка по умолчанию - нажимается при нажатии Enter
		btn2.setDefaultButton(true);
		
			// Кнопка отмены - нажимается при нажатии ESC
		btn3.setCancelButton(true);		
		
			/* Часто при нажатии кнопки происходит длительный процесс и нужно заблокировать кнопку, чтобы пользователь
		ее снова не нажимал, думая, что компьютер завис. Такая заблокированная кнопка не будет вызывать обработик			 */
		btn3.setOnAction(event -> {
			System.out.println("Нажата кнопка3");
			btn3.setDisable(true);												// Делает кнопку недоступной
			PauseTransition tr = new PauseTransition(Duration.seconds(5));		// Для имитации выполнения долгого процесса
			tr.setOnFinished(event2 -> {
				System.out.println("Операция завершена");
				btn3.setDisable(false);											// Делает кнопку снова доступной
			});
			tr.play();
		});
		
			// Растояние между строками текста в кнопке
		btn3.setLineSpacing(2);
		
			// Выравнивание текста в кнопке
		btn3.setTextAlignment(TextAlignment.LEFT);			// По левому краю
		btn3.setTextAlignment(TextAlignment.JUSTIFY);		// По ширине
		
			// Растояние от внутренних границ области до текста и/или изображения внутри кнопки
		btn3.setStyle("-fx-label-padding: 5.0px;");
		
			// Задает изображение около надписи и его расположение относительно надписи внутри кнопки
		btn.setGraphic(new ImageView("/img/icons.png"));
		btn.setContentDisplay(ContentDisplay.TOP);				// Позиционирует изображение относительно текста
		btn.setGraphicTextGap(2);								// Задает растояние между изображением и текстом
		btn.setAlignment(Pos.CENTER);							// Задает выравнивание текста и изображения внутри области
		Button btn4 = new Button("BUTTON4", imf);
		btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);		// Только изображение
		
			// Установка фона и цвета текста кнопуи
		btn2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		btn2.setTextFill(Color.WHITE);
		
			// Установка и настройка текста
		btn2.setText("LABEL1");																
		btn2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// Шрифт 
		btn2.setUnderline(true);														// Подчеркивание
				
			/* Задает перенос на другую строку
		Если true, то строка будет переноситься на другую
		Если false (по умолчанию), то строка будет обрезаться		 */
		Button btn5 = new Button("TEXTTTTTTTTTT");
		btn5.setFont(new Font(17));
		btn5.setWrapText(false);
				
			// Задает строку, которая будет показываться при обрезке текста (если он не помещается на одной строке или внутри области)
		btn5.setEllipsisString("/..../");
			
			/* Задает режим обрезки (если текст не помещается на одной строке или внутри области)
		 - ELLIPSIS 				- текст обрезается в конце и добавляется значение свойства ellipsisString
		 - WORD_ELLIPSIS 			- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CENTER_ELLIPSIS 			- текст обрезается посередине и добавляется значение свойства ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - LEADING_ELLIPSIS 		- текст обрезается вначале и добавляется значение свойства ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CLIP 					- текст просто обрезается в конце					 */
		btn5.setTextOverrun(OverrunStyle.ELLIPSIS);
		
					// ОБРАБОТЧИК 
			// С помощью анониманого класса
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Нажата кнопка1");
			}
		});
			// С помощью лямбда-выражения
		btn2.setOnAction(event -> {
			System.out.println("Нажата кнопка2");
		});
			// С помощью метода addEventHandler()
		btn4.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
				@Override
			public void handle(ActionEvent event) {
				System.out.println("Нажата кнопка3");
			}
		});
		
				// ИМИТАЦИЯ НАЖАТИЯ НА КПОНКУ МЫШЬЮ из кода программы
		btn2.arm();
		btn2.requestFocus();
		PauseTransition tr = new PauseTransition(Duration.seconds(1.0));
		tr.setOnFinished(event -> {
			btn2.fire();
			btn2.disarm();
		});
		tr.play();
		
			
		HBox hbox = new HBox();	
		hbox.getChildren().addAll(btn, btn2, btn3, btn4, btn5);
		Scene scene = new Scene(hbox, 500, 500);	// Добавление the layout pane to a scene
		primaryStage.setScene(scene);				// Добавление в Stage объекта scene
		primaryStage.show();						// Показ Stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}
