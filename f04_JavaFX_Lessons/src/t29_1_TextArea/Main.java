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

/* ����� TextInputControl �������� ������� ��� ��������� �����
������������ Object - Node - Parent - Region - Control - TextInputControl
Text_Field - ����, � ������� user ����� ������� �����. */
	
public class Main extends Application {
		
		@Override 
	public void start(Stage primaryStage) {
		
/* -------------------------------------------------TEXT AREA----------------------------------------------------------
 	��������� ������������� ��������� ����. ������� �� ��������� ������ �������������� �������� Enter, � �� ��������� /n.
 	���� ����� �� ���������� � ����, �� ������������� ������������ ������ ���������.
 	������������ Object - Node - Parent - Region - Control - TextInputControl - TextArea
 		 	������������:
 	- TextArea()						 - ������� ������ text field. 
 	- TextArea(String text)				 - ������� text area � ��������� ������� */
	
	TextArea textArea0 = new TextArea();
	TextArea textArea1 = new TextArea();
	TextArea textArea2 = new TextArea("������1 \n������2 ");
	
		// ������ �������������� �������, ���� �� ������� � ������ 
	textArea2.setWrapText(true);
		// �������� �������
	textArea0.setText("TEXT");
		// ���������� "�������" ��������� � ����
	textArea1.setPromptText("Enter a text");
		// �������
	textArea0.setMinWidth(300);		textArea0.setMaxWidth(300);
	textArea1.setMinWidth(200);		textArea1.setMaxWidth(200);
	textArea2.setMinWidth(200);		textArea2.setMaxWidth(200);
		// ������
	textArea0.setPadding(new Insets(10));
		// ���������������� ������ ���� prefRowCount.  �� ��������� - TextArea.DEFAULT_PREF_ROW_COUNT 
	textArea0.setPrefHeight(300);	
		// ���������������� ����� ���� prefColumnCount.  �� ��������� - TextArea.DEFAULT_PREF_COLUMN_COUNT 
	textArea0.setPrefRowCount(300);	
		// ���� ���� 
	textArea0.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(1), new Insets(10))));
		// �����
	textArea0.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
		// ��� false ���� �� ����� ���������������
	textArea0.setEditable(true);
		// ���������� ������ � ����� ������������ ������� �� ���������
	textArea0.appendText("1");
		// ���������� ������ � ����� � ��������� ������ �� ���������
	textArea0.insertText(2, "2");
		// ������ ����� ������
	textArea0.replaceText(0, 2, "New");
	textArea0.replaceSelection("New");  	// �������� ���������
	 	// �������� ����� ������
	textArea0.deleteText(0, 1);
		// ������� ����
//	textArea0.clear();
		// ������� ������, ������������� ����� �� ���������� �������    ������ ������ �� textArea0.insertText(2, "2");
	textArea0.deletePreviousChar();
		// ������� ������, ������������� ������ �� ���������� �������   ������ ������ �� textArea0.insertText(2, "2");
	textArea0.deleteNextChar(); 
		// ��������� ������ �� TextField  ������ getText() � getCharacters()
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
	
		// ���������� �������� ������� 
	System.out.println("������� ������� ������� � TextField - " + textArea0.getCaretPosition());		
	textArea0.home(); 				// ���������� ������ � ������ ����
	textArea0.positionCaret(2);		// ���������� ������ � ��������� �������
	textArea0.end(); 				// ���������� ������ � ����� ����
	textArea0.backward(); 			// �������� ������ �� ���� ������ ����� � ������ ����
	textArea0.forward(); 			// �������� ������ �� ���� ������ ����� � ����� ����
	textArea0.previousWord(); 		// �������� ������ � ������ ����������� �����
	textArea0.nextWord(); 			// �������� ������ � ������ ���������� ����� 
	textArea0.endOfNextWord(); 		// �������� ������ � ����� ���������� �����

		/* ��������� ������
		 ��� ������ � ���������� ������ ���� ������������� ��������� �������� ������ TextInpurControl	
		 �� ��������� ����������� ����������� ��������� ������: Ctrl + A - �������� ���, Shift + ������� �� ��������� - 
		 ��������� ������� ������������, Shift + End - ��������� �� ����� 				  */
			// ��������� ������ �� ���������:
	textArea0.selectAll();       			// ��������� ����� ������ � ����
	textArea0.deselect();        			// ������� ��������� 
	textArea0.selectRange(0, 2);			// �������� ��������� �������� ��������
	textArea0.selectPositionCaret(10);	/* ������ ����� �������� ������� (caretPosition). ���� ��������� �� ����, �� ���
		���������� �� ���������� ������� ���������� ������� (caretPosition) �� ����� �������.  ���� ��������� ����, �� ������
		������� �������� �� anchor �� caretPostion.  */
	textArea0.extendSelection(10);		/* �������� ��������� ����� �������, ����� ��������� ������� ����� �������� ���������.
		���� ��������� �� ����, �� ��� ���������� �� ���������� ������� ���������� ������� �� ����� ������� */
	textArea0.selectBackward();          // ���������� ������� caretPosition �� ���� ������ �����, ������� ��� ���� ���������
	textArea0.selectForward();          // ���������� ������� caretPosition �� ���� ������ ������, ������� ��� ���� ���������
	textArea0.selectPreviousWord();     // ���������� ������� caretPosition � ������ ������. �����, ������� ��� ���� ���������
	textArea0.selectNextWord();    	   // ���������� ������� caretPosition � ������ ���������� �����, ������� ��� ���� ���������
	textArea0.selectEndOfNextWord();    // ���������� ������� caretPosition � ����� ���������� �����, ������� ��� ���� ���������
	textArea0.selectHome();  	       // ���������� ������� caretPosition � ������ ����, ������� ��� ���� ���������
	textArea0.selectEnd();  			   // ���������� ������� caretPosition � ����� ����, ������� ��� ���� ���������
	System.out.println("��������� ������� ��������� - " + textArea0.getAnchor()  );
	System.out.println("�������� ������� ��������� - ������� ������� " + textArea0.getCaretPosition());
	System.out.println("���������� ����� - " + textArea0.getSelectedText());
	
	/* ����������� � ������� ������
	�� ��������� ����������� ����������� ��������� ������: Ctrl + C - ����������, Ctrl + X - ��������, Ctrl + V - �������� 	 */
	textArea0.copy();		// �������� ���������� ����� � �����
	textArea0.cut();			// �������� ���������� ����� � �������� � �����
	textArea0.paste();		// ������� ������ �� ������ � ������� ������� �������
	
		/* ������ � ������ �����
	�� ��������� ����������� ����������� ��������� ������: Ctrl + Z - ��������, Ctrl + Y - ��������� */
	textArea0.isUndoable();		// ���� true, �� �������� �������� ������ ���������� �����
	textArea0.isRedoable();		// ���� true, �� �������� �������� ������� ����� ���������� ������
	textArea0.undo();			// �������� ��������� �������� �����
	textArea0.redo();			// ��������� ����� ���������� �������� �����
	
		/*  �������������� ����� � ������� �� ���� ������ 
		�����  TextFormatter<V> �������� ������������� ���� ������ � ������������� �������������� ����� 	 
		������������:
	TextFormatter (StringConverter<V> valueConverter)
	TextFormatter (StringConverter<V> valueConverter, V defaultValue)
	TextFormatter (StringConverter<V> valueConverter, V defaultValue, UnaryOperator<TextFormatter.Change> filter)
	TextFormatter (UnaryOperator<TextFormatter.Change> filter)
		��� - StringConverter<V> valueConverter - ������ ������, ������� ����� ��������� �������������� �����
			- defaultValue - ��������� ������� �������� �� ���������. ��������� �������� ���������� � ������� valueConverter ����� 
			������� Enter, � �� �� ����� ����� 
			- UnaryOperator<TextFormatter.Change> filter - ������ ������, ������� ��������� �������������� ��������� UnaryOperator
			�������� � ���� �������� ���������� ����� ������� ��������� ��� �����, � ����� �� ����� ��������� ���������. ������
			����� ������� �� ����� ��������� ������. ���� ������ ������������� ����� ���������, �� ���������� ������ ��� ���� ���
			������������ ��. ���� �� ������������, �� ��������� null. ���� ���������� null, �� ����� ������ ��������� �� �����.  
		 		� ��������� StringConverter<V> valueConverter  ����� ������� ��������� TextFormatter.IDENTITY_STRING_CONVERTER, 
		 	� ���� ������ �������� ������, ������������� ������ � �� �� ����� ������. ��� ����� �����������, ��� ������� � 
		 	������������ TextFormatter (StringConverter<V> valueConverter, V defaultValue) ������ defaultValue	*/
	
		/* ��� ����� ���� �������� ����������� �� ���� ������ �����
		 ���� ����� ������� �����, �� ����� ������� Enter � ���� ���� ����������� ���� (defaultValue - ������ � ��������� ������������) 			 */
//	TextFormatter<Integer> textForm = new TextFormatter<Integer>(new IntegerStringConverter(), 0); 
//	textArea0.setTextFormatter(textForm);   
	
//		// ��� ����� ���� �������� ����������� �� ���� ������ ����������� ������� � ������ ��������
//	UnaryOperator<TextFormatter.Change> filter = change -> {
//		String str = change.getControlNewText();
//		if (str.matches("^([a-z]+)?$")) {
//			return change;
//		}
//		return null;
//	};
//	TextFormatter<String> textForm2 = new TextFormatter<String>(TextFormatter.IDENTITY_STRING_CONVERTER, "ABC", filter); 
//	textArea0.setTextFormatter(textForm2);

	// ��������� �������� �����, ��� ������� �������� TextFormatter �� ����
//	btnOK.setOnAction(event -> {
//		String msg = "������ Character's Name - ";
//		msg = msg + txtCharacter.getText() + " , Actor's Name - ";
//		msg = msg + txtActor.getText() + " , Number - ";
//		Integer value = (Integer)txtNumber.getTextFormatter().getValue();
//		msg = msg + value.toString();
//		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
//		a.setTitle("���� �����");
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