package t29_TextField_PasswordField;
	
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
		Label lblCharacter = new Label("Character's Name:"); 
		lblCharacter.setMinWidth(100);		lblCharacter.setAlignment(Pos.BOTTOM_RIGHT);
		Label lblActor = new Label("Actor's Name:");	lblActor.setMinWidth(100);		lblActor.setAlignment(Pos.BOTTOM_RIGHT);
		Label lblNumber = new Label("Number:");			lblNumber.setMinWidth(100);		lblNumber.setAlignment(Pos.BOTTOM_RIGHT);
		Button btnOK = new Button("OK"); 
		Button btnGetText = new Button("getText");
		
/* -------------------------------------------------TEXT FIELD----------------------------------------------------------
 	реализует однострочное текстовое поле, предназначенно для ввода и редактирования текста небольшого объема. 
 	Поле по умолчанию поддерживает стандартные клавиши быстрого доступа, работу с буфером обмена и другое.
 	Наследование Object - Node - Parent - Region - Control - TextInputControl - TextField
 	
 		 	КОНСТРУКТОРЫ:
 	- TextField()						 - создает пустой text field. 
 	- TextField(String text, int cols)	 - создает text field с внесенным текстом 
			МЕТОДЫ:
	- String getText() 				  	- возвращает текст, который был введен в это поле
	- void requestFocus() 			  	- запрашивает перемещение фокуса в это text field. 
	- void setEditable(boolean value) 	- если false, то делает  field со статусом read-only.
	- void setMaxWidth(double width)  	- устанавливает максимальную ширину text field. 
	- void setMinWidth(double width)  	- устанавливает минимальную ширину text field.
	- void setPrefColumnCount(int cols) - устанавливает предпочтительный размер text field в столбце (т.е. число символов в столбце)
	- void setPrefWidth(double width) 	- устанавливает предпочтительную ширину field.
	- void setPromptText(String prompt) - устанавливает "теневую" подпись-подсказку для юзера в поле для заполнения
										Надпись исчезнет после ввода юзером текста или если поле имеет фокус
	- void setText(String text) 		- добавляет текст в поле								 */
		
			// Конструкторы
		TextField txtCharacter = new TextField();		
		TextField txtActor = new TextField();	
		TextField txtNumber = new TextField();
			// Добавление "теневой" подсказки в поле
		txtCharacter.setPromptText("Enter the name of the character here.");
		txtActor.setPromptText("Enter the name of the actor here.");
		txtNumber.setPromptText("Enter the number");
			// Размеры
		txtCharacter.setMinWidth(200);	txtCharacter.setMaxWidth(200);
		txtActor.setMinWidth(200);		txtActor.setMaxWidth(200);
		txtNumber.setMinWidth(200);		txtNumber.setMaxWidth(200);
			// Зазоры
		txtCharacter.setPadding(new Insets(10));
			// Внесение надписи
		txtActor.setText("TEXT");
			// Выравнивание теста внутри свободной области поля
		txtActor.setAlignment(Pos.CENTER);
			// Цвет
		txtCharacter.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(1), new Insets(10))));
			// Шрифт
		txtCharacter.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
			// При false поле не может редактироваться
		txtCharacter.setEditable(true);
			// Добавление текста в конец существующей надписи из программы
		txtActor.appendText("1");	
			// Добавление текста в конец в выбранный индекс из программы
		txtActor.insertText(2, "2");
			// Замена части текста
		txtActor.replaceText(0, 2, "New");
		txtActor.replaceSelection("New");  	// Заменяет выделение
		 	// Удаление части текста
		txtActor.deleteText(0, 1);
			// Очищает поле
		txtCharacter.clear();
			// Удаляет символ, расположенный слева от текстового курсора    Курсор взялся из txtActor.insertText(2, "2");
		txtActor.deletePreviousChar();
			// Удаляет символ, расположенный справа от текстового курсора   Курсор взялся из txtActor.insertText(2, "2");
		txtActor.deleteNextChar(); 
			// Получение текста из TextField  методы getText() и getCharacters()
		btnGetText.setOnAction(event -> {
			String msg = txtActor.getText() + "  " + txtCharacter.getCharacters() + "  " + txtActor.getText();
			Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
			a.setTitle("GET TEXT");
			a.showAndWait();
		});
		
			// УПРАВЛЕНИЕ ПОЗИЦИЕЙ КУРСОРА В TextField
		System.out.println("Текущая позиция курсора в TextField - " + txtActor.getCaretPosition());		
		txtActor.home(); 				// Перемещает курсор в начало поля
		txtActor.positionCaret(2);		// Перемещает курсор в указанную позицию
		txtActor.end(); 				// Перемещает курсор в конец поля
		txtActor.backward(); 			// Сдвигает курсор на один символ ближе к началу поля
		txtActor.forward(); 			// Сдвигает курсор на один символ ближе к концу поля
		txtActor.previousWord(); 		// Сдвигает курсор к началу предыдущего слова
		txtActor.nextWord(); 			// Сдвигает курсор к началу следующего слова 
		txtActor.endOfNextWord(); 		// Сдвигает курсор к концу следующего слова
			// Возвращает текст введенный в поле
		System.out.println("Текст в поле " + txtActor.getText());
		System.out.println("Текст в поле между 1 и 2 индексом" + txtActor.getText(1,2));
		
			/* ВЫДЕЛЕНИЕ ТЕКСТА В TextField
			 Для работы с выделением внутри TextField предназначены следующие свойства класса TextInpurControl	
			 По умолчанию реализуются стандартные сочетания клавиш: Ctrl + A - выделить все, Shift + клавиши со стрелками - 
			 выделение сдвигом посимвольным, Shift + End - выделение до конца 				  */
				// Выделение текста из программы:
		txtCharacter.setText("TEXT_CHARACTER");
		txtCharacter.selectAll();       		// Выделение всего текста в поле
		txtCharacter.deselect();        		// Снимает выделение 
		txtCharacter.selectRange(0, 2);			// Выделяет указанный диапазон символов
		txtCharacter.selectPositionCaret(10);	/* задает новое значение курсора (caretPosition). Если выделения не было, то оно
			образуется от предыдущей позиции текстового курсора (caretPosition) до новой позиции.  Если выделение было, то будетв
			выделен диапазон от anchor до caretPostion.  */
		txtCharacter.extendSelection(10);		/* изменяет выделение таким образом, чтобы указанная позиция стала границей выделения.
			Если выделения не было, то оно образуется от предыдущей позиции текстового курсора до новой позиции */
		txtCharacter.selectBackward();          // перемещает позицию caretPosition на одим символ назад, изменяя при этом выделение
		txtCharacter.selectForward();          // перемещает позицию caretPosition на одим символ вперед, изменяя при этом выделение
		txtCharacter.selectPreviousWord();     // перемещает позицию caretPosition к началу предыд. слова, изменяя при этом выделение
		txtCharacter.selectNextWord();    	   // перемещает позицию caretPosition к началу следующего слова, изменяя при этом выделение
		txtCharacter.selectEndOfNextWord();    // перемещает позицию caretPosition к концу следующего слова, изменяя при этом выделение
		txtCharacter.selectHome();  	       // перемещает позицию caretPosition в начало поля, изменяя при этом выделение
		txtCharacter.selectEnd();  			   // перемещает позицию caretPosition в конец поля, изменяя при этом выделение
		System.out.println("Начальная позиция выделения - " + txtCharacter.getAnchor()  );
		System.out.println("Конечная позиция выделения - позиция курсора " + txtCharacter.getCaretPosition());
		System.out.println("Выделенный текст - " + txtCharacter.getSelectedText());
		
			/* Копирование и вставка текста
		По умолчанию реализуются стандартные сочетания клавиш: Ctrl + C - копировать, Ctrl + X - вырезать, Ctrl + V - вставить 	 */
		txtCharacter.copy();		// копирует выделенный текст в буфер
		txtCharacter.cut();			// вырезает выделенный текст и копирует в буфер
		txtCharacter.paste();		// вставка текста из буфера в текущую позицию курсора
		
			/* Отмена и повтор ввода
		По умолчанию реализуются стандартные сочетания клавиш: Ctrl + Z - отменить, Ctrl + Y - повторить */
		txtCharacter.isUndoable();		// если true, то доступна операция отмены последнего ввода
		txtCharacter.isRedoable();		// если true, то доступна операция повтора ранее введенного текста
		txtCharacter.undo();			// отменяет последнюю операцию ввода
		txtCharacter.redo();			// повторяет ранее отмененную операцию ввода
		
		txtCharacter.clear();
	
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
		TextFormatter<Integer> textForm = new TextFormatter<Integer>(new IntegerStringConverter(), 0); 
		txtNumber.setTextFormatter(textForm);   
		
			// Для этого поля задается ограничение на ввод только английскими буквами в нижнем регистре
		UnaryOperator<TextFormatter.Change> filter = change -> {
			String str = change.getControlNewText();
			if (str.matches("^([a-z]+)?$")) {
				return change;
			}
			return null;
		};
		TextFormatter<String> textForm2 = new TextFormatter<String>(TextFormatter.IDENTITY_STRING_CONVERTER, "ABC", filter); 
		txtCharacter.setTextFormatter(textForm2);
		
			// Получение значений полей, для которых назначен TextFormatter на ввод
		btnOK.setOnAction(event -> {
			String msg = "Выбран Character's Name - ";
			msg = msg + txtCharacter.getText() + " , Actor's Name - ";
			msg = msg + txtActor.getText() + " , Number - ";
			Integer value = (Integer)txtNumber.getTextFormatter().getValue();
			msg = msg + value.toString();
			Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
			a.setTitle("Твой Выбор");
			a.showAndWait();
		});
		
		
/*---------------------------------------PASSWORD FIELD--------------------------------------------------------------------------
  скрывает вводимый текст. Расширяет класс TextField и поэтому наследует все его методы  
  Наследование Object - Node - Parent - Region - Control - TextInputControl - TextField - PasswordField
 		 	КОНСТРУКТОР:
 	- PasswordField()						 - создает пустой text field. 	*/
		
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Введите пароль");
		Label label = new Label("_Password");
		label.setMnemonicParsing(true);
		label.setLabelFor(passwordField);
		
		passwordField.setMaxSize(200,100);
		
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
		TextField txt2 = new TextField();
		txt2.setText("fvndfvfdfnb");
		TextFlow textFlowPane1 = new TextFlow();
		textFlowPane1.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
		textFlowPane1.setMaxWidth(300);
		textFlowPane1.setTextAlignment(TextAlignment.CENTER);
		textFlowPane1.setLineSpacing(1.0);
		textFlowPane1.getChildren().addAll(txt2);
		
		HBox paneCharacter = new HBox(20, lblCharacter, txtCharacter, btnGetText, btnOK);
		paneCharacter.setPadding(new Insets(10));		// Растояние от края = 10 пкс
		HBox paneActor = new HBox(20, lblActor, txtActor);
		paneActor.setPadding(new Insets(10));
		HBox paneNumber = new HBox(20, lblNumber, txtNumber);
		paneNumber.setPadding(new Insets(10));
		HBox pasw = new HBox(20, label, passwordField);
		paneNumber.setPadding(new Insets(10));
		
		VBox pane = new VBox(10, paneCharacter, paneActor, paneNumber, pasw, textFlowPane1);
		Scene scene = new Scene(pane, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Role Player");
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}