package t30_ToggleButton;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) {
			
			/* Класс ToggleButton и интерфейс Toogle
		Класс ToggleButton реализует переключатель в виде обычной кнопки, имеющей дополнительно нажатое состояние
		Наследование: Object - Node- Parent - Region - Control - Labeled - ButtonBase - ToogleButton		 */
			
			// Конструкторы 		
		ToggleButton toggleButton1 = new ToggleButton();
		ToggleButton toggleButton2 = new ToggleButton("toggleButton2");		   
			// Конструктор ниже помимо текста также отображает изображение слева от текста (по умолчанию)
		ImageView imf = new ImageView("/img/icons.png");
		ToggleButton toggleButton3 = new ToggleButton("toggleButton3", imf);
				
			// Внесение текста на кнопку
		toggleButton1.setText("toggleButton1");
		toggleButton1.setMinWidth(120);
		
			// Включение и выключение кнопки
		toggleButton1.selectedProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("button selected = " + newValue);
		});
		toggleButton1.setOnAction(event -> {
			if (toggleButton1.isSelected())  {					// isSelected() при true включен, false - выключено
				System.out.println("Переключатель включен");			
				toggleButton1.setText("ВКЛЮЧЕНО");
			}
			else {
				System.out.println("Переключатель выключен");
				toggleButton1.setText("ВЫКЛЮЧЕНО");
			}
		});
		
		toggleButton2.setOnAction(event -> {
			if (toggleButton2.isSelected())  {					// isSelected() при true включен, false - выключено
				System.out.println("Переключатель включен");			
				toggleButton2.setText("ВКЛЮЧЕНО");
			}
			else {
				System.out.println("Переключатель выключен");
				toggleButton2.setText("ВЫКЛЮЧЕНО");
			}
		});
		
			/* Класс ToggleGroup для объединения кнопок в группы
		Внутри такой группы может быть включен только один переключатель. При включении другого переключателя первый отключается.
		При использовании ToggleButton можно выключить все выключатели внутри группы и получить null
		При использовании RadioButton внутри группы должен быть один включенный переключатель				 */
		ToggleGroup toggleGroup = new ToggleGroup();
			// Добавление кнопок в группу
		toggleGroup.getToggles().addAll(toggleButton1, toggleButton2);
		
			// Растояние между строками
		toggleButton1.setLineSpacing(2);
		
			// Выравнивание текста 
		toggleButton1.setTextAlignment(TextAlignment.LEFT);		// По левому краю
		toggleButton1.setTextAlignment(TextAlignment.JUSTIFY);		// По ширине
		
			// Растояние от внутренних границ области до текста и/или изображения 
		toggleButton1.setStyle("-fx-label-padding: 5.0px;");
		
			// Задает изображение около надписи и его расположение относительно надписи внутри кнопки
		toggleButton1.setGraphic(new ImageView("/img/icons.png"));
		toggleButton1.setContentDisplay(ContentDisplay.TOP);				// Позиционирует изображение относительно текста
		toggleButton1.setGraphicTextGap(2);								// Задает растояние между изображением и текстом
		toggleButton1.setAlignment(Pos.CENTER);							// Задает выравнивание текста и изображения внутри области
		ToggleButton toggleButton4 = new ToggleButton("toggleButton4", imf);
		toggleButton4.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);				// Только изображение
		
			// Установка фона и цвета текста кнопуи
		toggleButton2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		toggleButton2.setTextFill(Color.WHITE);
		
			// Установка и настройка текста
		toggleButton2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// Шрифт 
		toggleButton2.setUnderline(true);														// Подчеркивание
				
			/* Задает перенос на другую строку
		Если true, то строка будет переноситься на другую
		Если false (по умолчанию), то строка будет обрезаться		 */
		ToggleButton toggleButton5 = new ToggleButton("ТЕКСТ НА КНОПКЕ5");
		toggleButton5.setFont(new Font(17));
		toggleButton5.setWrapText(false);
				
			// Задает строку, которая будет показываться при обрезке текста (если он не помещается на одной строке или внутри области)
		toggleButton5.setEllipsisString("/..../");
			
			/* Задает режим обрезки (если текст не помещается на одной строке или внутри области)
		 - ELLIPSIS 				- текст обрезается в конце и добавляется значение свойства ellipsisString
		 - WORD_ELLIPSIS 			- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CENTER_ELLIPSIS 			- текст обрезается посередине и добавляется значение свойства ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - LEADING_ELLIPSIS 		- текст обрезается вначале и добавляется значение свойства ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CLIP 					- текст просто обрезается в конце					 */
		toggleButton5.setTextOverrun(OverrunStyle.ELLIPSIS);
		
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
		hbox.getChildren().addAll(toggleButton1, toggleButton2, toggleButton3, toggleButton4, toggleButton5);
		Scene scene = new Scene(hbox, 700, 500);	// Добавление the layout pane to a scene
		primaryStage.setScene(scene);				// Добавление в Stage объекта scene
		primaryStage.show();						// Показ Stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}
