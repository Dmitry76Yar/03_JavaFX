package t29_1_TextArea;
	
import java.util.function.UnaryOperator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.*;
import javafx.util.converter.IntegerStringConverter;

/* Класс TextInputControl является базовым для текстовых полей
Наследование Object - Node - Parent - Region - Control - TextInputControl
Text_Field - поля, в который user может вносить текст. */
	
public class Main extends Application {
		
		@Override 
	public void start(Stage primaryStage) {
		
/* -------------------------------------------------TEXT AREA----------------------------------------------------------
 	реализует многострочное текстовое поле. Перенос на следующую строку осуществляется нажатием Enter, а из программы /n.
 	Если текст не помещается в поле, то автоматически отображаются полосы прокрутки.
 	Наследование Object - Node - Parent - Region - Control - TextInputControl - TextArea
 		 	КОНСТРУКТОРЫ:
 	- TextArea()						 - создает пустой text field. 
 	- TextArea(String text)				 - создает text area с внесенным текстом */
	
	TextArea textArea0 = new TextArea();
	TextArea textArea1 = new TextArea();
	TextArea textArea2 = new TextArea("Строка1 \nСтрока2 ");
	
		// Задает автоматический перенос, если не влезает в строку 
	textArea2.setWrapText(true);
		// Внесение надписи
	textArea0.setText("TEXT");
		// Добавление "теневой" подсказки в поле
	textArea1.setPromptText("Enter a text");
		// Размеры
	textArea0.setMinWidth(300);		textArea0.setMaxWidth(300);
	textArea1.setMinWidth(200);		textArea1.setMaxWidth(200);
	textArea2.setMinWidth(200);		textArea2.setMaxWidth(200);
		// Зазоры
	textArea0.setPadding(new Insets(10));
		// Предпочтительная высота поля prefRowCount.  По умолчанию - TextArea.DEFAULT_PREF_ROW_COUNT 
	textArea0.setPrefHeight(300);	
		// Предпочтительная длина поля prefColumnCount.  По умолчанию - TextArea.DEFAULT_PREF_COLUMN_COUNT 
	textArea0.setPrefRowCount(300);	
		// Цвет фона 
	textArea0.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(1), new Insets(10))));
		// Шрифт
	textArea0.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
		// При false поле не может редактироваться
	textArea0.setEditable(true);
		// Добавление текста в конец существующей надписи из программы
	textArea0.appendText("1");
		// Добавление текста в конец в выбранный индекс из программы
	textArea0.insertText(2, "2");
		// Замена части текста
	textArea0.replaceText(0, 2, "New");
	textArea0.replaceSelection("New");  	// Заменяет выделение
	 	// Удаление части текста
	textArea0.deleteText(0, 1);
		// Очищает поле
//	textArea0.clear();
		// Удаляет символ, расположенный слева от текстового курсора    Курсор взялся из textArea0.insertText(2, "2");
	textArea0.deletePreviousChar();
		// Удаляет символ, расположенный справа от текстового курсора   Курсор взялся из textArea0.insertText(2, "2");
	textArea0.deleteNextChar(); 
		// Получение текста из TextField  методы getText() и getCharacters()
	Button btnGetText = new Button("getText()");
	Button btnGetParagraph = new Button("getParagraph()");
	btnGetText.setOnAction(event -> {
		String msg = textArea0.getText() + "  " + textArea1.getText() + "  " + textArea2.getText();
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("GET TEXT");
		a.showAndWait();
	});
	btnGetParagraph.setOnAction(event -> {
		String msg = textArea0.getParagraphs() + "  " + textArea1.getParagraphs() + "  " + textArea2.getParagraphs();
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("GET PARAGRAPH");
		a.showAndWait();
	});
	
		// УПРАВЛЕНИЕ ПОЗИЦИЕЙ КУРСОРА 
	System.out.println("Текущая позиция курсора в TextField - " + textArea0.getCaretPosition());		
	textArea0.home(); 				// Перемещает курсор в начало поля
	textArea0.positionCaret(2);		// Перемещает курсор в указанную позицию
	textArea0.end(); 				// Перемещает курсор в конец поля
	textArea0.backward(); 			// Сдвигает курсор на один символ ближе к началу поля
	textArea0.forward(); 			// Сдвигает курсор на один символ ближе к концу поля
	textArea0.previousWord(); 		// Сдвигает курсор к началу предыдущего слова
	textArea0.nextWord(); 			// Сдвигает курсор к началу следующего слова 
	textArea0.endOfNextWord(); 		// Сдвигает курсор к концу следующего слова

		/* ВЫДЕЛЕНИЕ ТЕКСТА
		 Для работы с выделением внутри поля предназначены следующие свойства класса TextInpurControl	
		 По умолчанию реализуются стандартные сочетания клавиш: Ctrl + A - выделить все, Shift + клавиши со стрелками - 
		 выделение сдвигом посимвольным, Shift + End - выделение до конца 				  */
			// Выделение текста из программы:
	textArea0.selectAll();       			// Выделение всего текста в поле
	textArea0.deselect();        			// Снимает выделение 
	textArea0.selectRange(0, 2);			// Выделяет указанный диапазон символов
	textArea0.selectPositionCaret(10);	/* задает новое значение курсора (caretPosition). Если выделения не было, то оно
		образуется от предыдущей позиции текстового курсора (caretPosition) до новой позиции.  Если выделение было, то будетв
		выделен диапазон от anchor до caretPostion.  */
	textArea0.extendSelection(10);		/* изменяет выделение таким образом, чтобы указанная позиция стала границей выделения.
		Если выделения не было, то оно образуется от предыдущей позиции текстового курсора до новой позиции */
	textArea0.selectBackward();          // перемещает позицию caretPosition на одим символ назад, изменяя при этом выделение
	textArea0.selectForward();          // перемещает позицию caretPosition на одим символ вперед, изменяя при этом выделение
	textArea0.selectPreviousWord();     // перемещает позицию caretPosition к началу предыд. слова, изменяя при этом выделение
	textArea0.selectNextWord();    	   // перемещает позицию caretPosition к началу следующего слова, изменяя при этом выделение
	textArea0.selectEndOfNextWord();    // перемещает позицию caretPosition к концу следующего слова, изменяя при этом выделение
	textArea0.selectHome();  	       // перемещает позицию caretPosition в начало поля, изменяя при этом выделение
	textArea0.selectEnd();  			   // перемещает позицию caretPosition в конец поля, изменяя при этом выделение
	System.out.println("Начальная позиция выделения - " + textArea0.getAnchor()  );
	System.out.println("Конечная позиция выделения - позиция курсора " + textArea0.getCaretPosition());
	System.out.println("Выделенный текст - " + textArea0.getSelectedText());
	
	/* Копирование и вставка текста
	По умолчанию реализуются стандартные сочетания клавиш: Ctrl + C - копировать, Ctrl + X - вырезать, Ctrl + V - вставить 	 */
	textArea0.copy();		// копирует выделенный текст в буфер
	textArea0.cut();			// вырезает выделенный текст и копирует в буфер
	textArea0.paste();		// вставка текста из буфера в текущую позицию курсора
	
		/* Отмена и повтор ввода
	По умолчанию реализуются стандартные сочетания клавиш: Ctrl + Z - отменить, Ctrl + Y - повторить */
	textArea0.isUndoable();		// если true, то доступна операция отмены последнего ввода
	textArea0.isRedoable();		// если true, то доступна операция повтора ранее введенного текста
	textArea0.undo();			// отменяет последнюю операцию ввода
	textArea0.redo();			// повторяет ранее отмененную операцию ввода
	
		/*  ПРЕОБРАЗОВАНИЕ ТИПОВ И ПРАВИЛА НА ВВОД ТЕКСТА 
		Класс  TextFormatter<V> помогает контрлировать ввод данных и реализовывать преобразование типов 	 
		Конструкторы:
	TextFormatter (StringConverter<V> valueConverter)
	TextFormatter (StringConverter<V> valueConverter, V defaultValue)
	TextFormatter (StringConverter<V> valueConverter, V defaultValue, UnaryOperator<TextFormatter.Change> filter)
	TextFormatter (UnaryOperator<TextFormatter.Change> filter)
		где - StringConverter<V> valueConverter - задает объект, который будет выполнять преобразование типов
			- defaultValue - позволяет указать значение по умолчанию. Введенное значение передается в объекту valueConverter после 
			нажатия Enter, а не во время ввода 
			- UnaryOperator<TextFormatter.Change> filter - задает объект, который реализует функциональный интерфейс UnaryOperator
			Вводимое в поле значение передается этому объекту постоянно при вводе, а также во время выделения фрагмента. Внутри
			этого объекта мы можем проверить данные. Если данные соответствуют нашим ожиданиям, то возвращаем данные как есть или
			модифицируем их. Если не соотвествуют, то возврщаем null. Если возвращаем null, то новые данные вставлены не будут.  
		 		В параметре StringConverter<V> valueConverter  можно указать константу TextFormatter.IDENTITY_STRING_CONVERTER, 
		 	в этом случае задается объект, преобразующий строку в ту же самую строку. Это может пригодиться, что указать в 
		 	конструкторе TextFormatter (StringConverter<V> valueConverter, V defaultValue) только defaultValue	*/
	
		/* Для этого поля задается ограничение на ввод только чисел
		 Если будет написан текст, то после нажатия Enter в этом поле отобразится ноль (defaultValue - указан в параметре конструктора) 			 */
//	TextFormatter<Integer> textForm = new TextFormatter<Integer>(new IntegerStringConverter(), 0); 
//	textArea0.setTextFormatter(textForm);   
	
//		// Для этого поля задается ограничение на ввод только английскими буквами в нижнем регистре
//	UnaryOperator<TextFormatter.Change> filter = change -> {
//		String str = change.getControlNewText();
//		if (str.matches("^([a-z]+)?$")) {
//			return change;
//		}
//		return null;
//	};
//	TextFormatter<String> textForm2 = new TextFormatter<String>(TextFormatter.IDENTITY_STRING_CONVERTER, "ABC", filter); 
//	textArea0.setTextFormatter(textForm2);

	// Получение значений полей, для которых назначен TextFormatter на ввод
//	btnOK.setOnAction(event -> {
//		String msg = "Выбран Character's Name - ";
//		msg = msg + txtCharacter.getText() + " , Actor's Name - ";
//		msg = msg + txtActor.getText() + " , Number - ";
//		Integer value = (Integer)txtNumber.getTextFormatter().getValue();
//		msg = msg + value.toString();
//		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
//		a.setTitle("Твой Выбор");
//		a.showAndWait();
//	});

	HBox hbox1 = new HBox(20, textArea0, textArea1, textArea2);
	HBox hbox2 = new HBox(20, btnGetText, btnGetParagraph);
	hbox1.setPadding(new Insets(10));
	hbox2.setPadding(new Insets(10));

	VBox pane = new VBox(10, hbox1, hbox2);
	Scene scene = new Scene(pane, 1200, 600);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Role Player");
	primaryStage.show();
}
		
	public static void main(String[] args) {
		launch(args);
	}
}