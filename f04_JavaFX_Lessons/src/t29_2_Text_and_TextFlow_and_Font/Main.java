package t29_2_Text_and_TextFlow_and_Font;
	
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.*;

public class Main extends Application {
		
		@Override 
	public void start(Stage primaryStage) {
		
/* -------------------------------------------------TEXT---------------------------------------------------------- 
	- Text()									 
	- Text(String text)						 - создает Text с внесенным текстом
	- Text(double x, double y, String text)	 - создает Text с внесенным текстом и с указанными координатами*/
		
	Text text1 = new Text();
	Text text2 = new Text("ТЕКСТ");
	Text text3 = new Text(0.0, 0.0, "ТЕКСТ QWERTY");		
		// Метод корректировки надписи и координат
	text1.setX(1.0);
	text1.setY(1.0);
		// Внесение надписи
	text1.setText("Text");
		// Цвет
	text2.setFill(Color.BLACK);
		// Расположение текста в ячейке
	text2.setTextOrigin(VPos.BOTTOM);		text3.setTextOrigin(VPos.CENTER);
		// Шрифт
	text2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
		
		// Получение текста методы getText()
	Button btnGetText = new Button("getText()");
	Button btnGetParagraph = new Button("getParagraph()");
	btnGetText.setOnAction(event -> {
		String msg = text2.getText();
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("GET TEXT");
		a.showAndWait();
	});

		// Подчеркивание и зачеркивание
	text3.setStrikethrough(true);
	text2.setUnderline(true);
	Path path = new Path(text2.underlineShape(0, 20));			// Чтобы сделать подчеркивание красным
	path.setStroke(Color.RED);
	path.setStrokeWidth(1);
		// Растояние между строками
	text3.setLineSpacing(5);
		// Шрифт
	text1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
			
		// ВЫДЕЛЕНИЕ ТЕКСТА
	// Начальная и конечная позиция выделения
	text2.setSelectionStart(-1);		// Чтобы сбросить выделение
	text2.setSelectionStart(2); 		// Выделяет, начиная с 2-го и заканчивая 4-м символами
	text2.setSelectionEnd(4);
		// Цвет выделения
	text2.setSelectionFill(Color.BLUE);
		// Траектория, описывающий уже выделеный фрагмент текста
	Path path2 = new Path(text2.getSelectionShape());
	path2.setFill(Color.RED);
	path2.setStroke(Color.BLACK);
		// Траектория нового выделения фрагмента текста
	Path path3 = new Path(text3.rangeShape(0, 10));
	path3.setFill(Color.BLUE);
	path3.setStroke(Color.BLACK);
	text3.setSelectionFill(Color.BEIGE);
		
			// УПРАВЛЕНИЕ КУРСОРОМ В ТЕКСТЕ
	text3.setCaretPosition(2);		// Позиция курсора в тексе (значение -1 - позиция не установлена)
	text3.setCaretBias(true);       // true (по умолчанию) - курсор перед символом, false -курсор после символа
	Path path4 = new Path(text3.getCaretShape());		// Траектория, описывающая курсор
	path4.setStroke(Color.RED);
			
			// ВЫРАВНИВАНИЕ ТЕКСТА
		// Ограничение ширины текстового поля
		// Если текст не помещается в выделенное поле, то идет перенос на следующую строку
	text2.setWrappingWidth(100);		// Для поля выделена область шириной 100 пкс
	text3.setWrappingWidth(100);	
				// Выравнивание текста внутри области ограниченной ширины
	text2.setTextAlignment(TextAlignment.CENTER);
	text3.setTextAlignment(TextAlignment.RIGHT);			// По правому краю
	text1.setTextAlignment(TextAlignment.JUSTIFY);			// По ширине выделенной области
	
	/*--------------------------------------КЛАСС TEXTFLOW---ВЫРАВНИВАНИЕ ТЕКСТА -------------------------------------------------------------------------*/
	/* 	Позволяет выравнять текст - если текст не помещается в выделенную область, то он будет перетекать на след.строку
	При этом значение свойств выравнивания из класса Text будут игнорироваться
	Наследование Object - Node - Parent - Region - Pane - TextFlow
	Создает PANE
		Конструкторы:
	 - TextFlow()					- создает пустой Pane							
	 - TextFlow(Node...children) 	- создает Pane с помещенными в него узлами 
	 Метод setTextAlignment(TextAlignment value) - выравнивание по горизонтали внутри контейнера
		 - CENTER - по центру
		 - RIGHT - по правому краю
		 - LEFT  - по левому краю
		 - JUSTIFY - по ширине
	 Метод setLineSpacing() - растояние между строками
	 Метод setBackground()	- установка заливки
	 Метод getChildren().addAll() - добавление узлов 	 	 */
	Text text5 = new Text("КЛАСС TEXTFLOW------КЛАСС TEXTFLOW");
	text5.setFill(Color.BLACK);
	text5.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 24));
	
	TextFlow textFlowPane1 = new TextFlow();
	textFlowPane1.setPrefWidth(400);
	textFlowPane1.setPadding(new Insets(10));
	textFlowPane1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
	textFlowPane1.setTextAlignment(TextAlignment.CENTER);
	textFlowPane1.setLineSpacing(1.0);
	textFlowPane1.getChildren().addAll(text5);
	
/*--------------------------------------ШРИФТ-------------------------------------------------------------------------*/
		// Конструктор
	Font font1 = new Font(24);								// Указывает только размер шрифта
	Font font2 = new Font("Calibri Bold Italic", 24);		// Указывает размер и тип шрифта через String
		// Создание шрифта
	Font font3 = Font.font(24);									// (double size)
	Font font4 = Font.font("Calibri");							// (String family)
	Font font5 = Font.font("Calibri", 24);						// (String family, double size)
	Font font6 = Font.font("Calibri", FontWeight.BOLD, 24);		// (String family, FontWeight weight, double size)
	Font font7 = Font.font("Calibri", FontPosture.ITALIC, 24);	// (String family, FontPosture posture, double size)
	Font font8 = Font.font("Calibri", FontWeight.THIN, FontPosture.ITALIC, 24);	// (String family, FontWeight weight, FontPosture posture, double size)
		// Узнать шрифт по умолчанию системы
	System.out.println("Шрифт по умолчанию " + Font.getDefault());
		// Чтобы получить список всех семейств доступных шрифтов
	List<String> list1 = Font.getFamilies();	
	System.out.println(list1);
		// Чтобы получить список всех названий доступных шрифтов
	List<String> list2 = Font.getFontNames();	
	System.out.println(list2);
		// Чтобы получить список всех названий для указанного семейства шрифтов
	List<String> list3 = Font.getFontNames("Calibri");	
	System.out.println(list3);
		/* Загрузка шрифтов из файлов
	 - static Font loadFont (string urlStr, double size)
	 - static Font loadFont (Inputstream in, double size)
	 - static Font[] loadFonts (string urlStr, double size)
	 - static Font[] loadFonts (Inputstream in, double size)			 */
		// Методы GET
	System.out.println("Название семейства шрифта  " + font8.getFamily());
	System.out.println("Название шрифта  " + font8.getName());
	System.out.println("Название размер  " + font8.getSize());
	System.out.println("Название стиль шрифта  " + font8.getStyle());
		// Установка шрифта
	text3.setFont(font1);
	text2.setFont(font2);
	
	HBox hbox1 = new HBox(20, text1,text2, text3,textFlowPane1);
	hbox1.setPadding(new Insets(10));

	Scene scene = new Scene(hbox1);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Role Player");
	primaryStage.show();
}
		
	public static void main(String[] args) {
		launch(args);
	}
}