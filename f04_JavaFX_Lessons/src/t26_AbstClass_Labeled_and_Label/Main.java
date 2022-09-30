package t26_AbstClass_Labeled_and_Label;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
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
	Button btn, btn2;
		@Override 
	public void start(Stage primaryStage) {		
			/* Абстрактный класс Labeled - базовый класс для всех классов, содержащих НЕРЕДАКТИРУЕМУЮ надпись
	Например, надпись на кнопке соеджится в узле LabeledText внутри кнопки, т.к. кнопка наследует класс Labeled и все его методы
	Наследование Object - Node - Parent - Region - Control - Labeled
		Реализацией абстрактного класса Labeled является класс Label
	Наследование Object - Node - Parent - Region - Control - Labeled - Label 
		Для выводы текста в окне также можно использовать объект класса Text. Разница между Text и Label в том, что класс Text описывает
	фигуру, а клас Label компонент 	
		Конструкторы 			*/
		Label lbl1 = new Label();
		Label lbl2 = new Label("String TEXT");
			// Конструктор ниже помимо текста также отображает изображение слева от текста (по умолчанию)
		ImageView imf = new ImageView("/img/icons.png");
		Label lbl3 = new Label("String TEXT", imf);
		
			// Растояние между строками
		lbl1.setLineSpacing(2);
		
			// Выравнивание текста в строке
		lbl1.setTextAlignment(TextAlignment.LEFT);			// По левому краю
		lbl1.setTextAlignment(TextAlignment.JUSTIFY);		// По ширине
		
			// Растояние от внутренних границ области до текста и/или изображения
		lbl1.setStyle("-fx-label-padding: 20.0px;");
		
			// Задает изображение около надписи и его расположение относительно надписи
		lbl1.setGraphic(new ImageView("/img/icons.png"));
		lbl1.setContentDisplay(ContentDisplay.TOP);				// Позиционирует изображение относительно текста
		lbl1.setGraphicTextGap(2);								// Задает растояние между изображением и текстом
		lbl1.setAlignment(Pos.CENTER);							// Задает выравнивание текста и изображения внутри области
		
			// Установка фона и цвета текста
		lbl2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		lbl2.setTextFill(Color.WHITE);
		
			// Установка и настройка текста
		lbl1.setText("LABEL1");																
		lbl1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// Шрифт 
		lbl1.setUnderline(true);														// Подчеркивание
		
			/* Задает перенос на другую строку
		Если true, то строка будет переноситься на другую
		Если false (по умолчанию), то строка будет обрезаться		 */
		Label lbl4 = new Label("LABELLLLLLLLLLLLLLLLLLLLLLLLLLLL");
		lbl4.setFont(new Font(17));
		lbl4.setWrapText(false);
		
			// Задает строку, которая будет показываться при обрезке текста (если он не помещается на одной строке или внутри области)
		lbl4.setEllipsisString("/..../");
		
			/* Задает режим обрезки (если текст не помещается на одной строке или внутри области)
		 - ELLIPSIS 				- текст обрезается в конце и добавляется значение свойства ellipsisString
		 - WORD_ELLIPSIS 			- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CENTER_ELLIPSIS 			- текст обрезается посередине и добавляется значение свойства ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - LEADING_ELLIPSIS 		- текст обрезается вначале и добавляется значение свойства ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CLIP 					- текст просто обрезается в конце					 */
		lbl4.setTextOverrun(OverrunStyle.ELLIPSIS);
		
			
			
			
		HBox hbox = new HBox();		hbox.setPadding(new Insets(10));	hbox.setSpacing(20);	
		hbox.getChildren().addAll(lbl1, lbl2, lbl3, lbl4);
		Scene scene = new Scene(hbox, 500, 500);	// Добавление the layout pane to a scene
		primaryStage.setScene(scene);				// Добавление в Stage объекта scene
		primaryStage.show();						// Показ Stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}
