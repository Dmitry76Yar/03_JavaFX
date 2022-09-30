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

/* ����� TextInputControl �������� ������� ��� ��������� �����
������������ Object - Node - Parent - Region - Control - TextInputControl
Text_Field - ����, � ������� user ����� ������� �����. */
	
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
 	��������� ������������ ��������� ����, �������������� ��� ����� � �������������� ������ ���������� ������. 
 	���� �� ��������� ������������ ����������� ������� �������� �������, ������ � ������� ������ � ������.
 	������������ Object - Node - Parent - Region - Control - TextInputControl - TextField
 	
 		 	������������:
 	- TextField()						 - ������� ������ text field. 
 	- TextField(String text, int cols)	 - ������� text field � ��������� ������� 
			������:
	- String getText() 				  	- ���������� �����, ������� ��� ������ � ��� ����
	- void requestFocus() 			  	- ����������� ����������� ������ � ��� text field. 
	- void setEditable(boolean value) 	- ���� false, �� ������  field �� �������� read-only.
	- void setMaxWidth(double width)  	- ������������� ������������ ������ text field. 
	- void setMinWidth(double width)  	- ������������� ����������� ������ text field.
	- void setPrefColumnCount(int cols) - ������������� ���������������� ������ text field � ������� (�.�. ����� �������� � �������)
	- void setPrefWidth(double width) 	- ������������� ���������������� ������ field.
	- void setPromptText(String prompt) - ������������� "�������" �������-��������� ��� ����� � ���� ��� ����������
										������� �������� ����� ����� ������ ������ ��� ���� ���� ����� �����
	- void setText(String text) 		- ��������� ����� � ����								 */
		
			// ������������
		TextField txtCharacter = new TextField();		
		TextField txtActor = new TextField();	
		TextField txtNumber = new TextField();
			// ���������� "�������" ��������� � ����
		txtCharacter.setPromptText("Enter the name of the character here.");
		txtActor.setPromptText("Enter the name of the actor here.");
		txtNumber.setPromptText("Enter the number");
			// �������
		txtCharacter.setMinWidth(200);	txtCharacter.setMaxWidth(200);
		txtActor.setMinWidth(200);		txtActor.setMaxWidth(200);
		txtNumber.setMinWidth(200);		txtNumber.setMaxWidth(200);
			// ������
		txtCharacter.setPadding(new Insets(10));
			// �������� �������
		txtActor.setText("TEXT");
			// ������������ ����� ������ ��������� ������� ����
		txtActor.setAlignment(Pos.CENTER);
			// ����
		txtCharacter.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(1), new Insets(10))));
			// �����
		txtCharacter.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
			// ��� false ���� �� ����� ���������������
		txtCharacter.setEditable(true);
			// ���������� ������ � ����� ������������ ������� �� ���������
		txtActor.appendText("1");	
			// ���������� ������ � ����� � ��������� ������ �� ���������
		txtActor.insertText(2, "2");
			// ������ ����� ������
		txtActor.replaceText(0, 2, "New");
		txtActor.replaceSelection("New");  	// �������� ���������
		 	// �������� ����� ������
		txtActor.deleteText(0, 1);
			// ������� ����
		txtCharacter.clear();
			// ������� ������, ������������� ����� �� ���������� �������    ������ ������ �� txtActor.insertText(2, "2");
		txtActor.deletePreviousChar();
			// ������� ������, ������������� ������ �� ���������� �������   ������ ������ �� txtActor.insertText(2, "2");
		txtActor.deleteNextChar(); 
			// ��������� ������ �� TextField  ������ getText() � getCharacters()
		btnGetText.setOnAction(event -> {
			String msg = txtActor.getText() + "  " + txtCharacter.getCharacters() + "  " + txtActor.getText();
			Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
			a.setTitle("GET TEXT");
			a.showAndWait();
		});
		
			// ���������� �������� ������� � TextField
		System.out.println("������� ������� ������� � TextField - " + txtActor.getCaretPosition());		
		txtActor.home(); 				// ���������� ������ � ������ ����
		txtActor.positionCaret(2);		// ���������� ������ � ��������� �������
		txtActor.end(); 				// ���������� ������ � ����� ����
		txtActor.backward(); 			// �������� ������ �� ���� ������ ����� � ������ ����
		txtActor.forward(); 			// �������� ������ �� ���� ������ ����� � ����� ����
		txtActor.previousWord(); 		// �������� ������ � ������ ����������� �����
		txtActor.nextWord(); 			// �������� ������ � ������ ���������� ����� 
		txtActor.endOfNextWord(); 		// �������� ������ � ����� ���������� �����
			// ���������� ����� ��������� � ����
		System.out.println("����� � ���� " + txtActor.getText());
		System.out.println("����� � ���� ����� 1 � 2 ��������" + txtActor.getText(1,2));
		
			/* ��������� ������ � TextField
			 ��� ������ � ���������� ������ TextField ������������� ��������� �������� ������ TextInpurControl	
			 �� ��������� ����������� ����������� ��������� ������: Ctrl + A - �������� ���, Shift + ������� �� ��������� - 
			 ��������� ������� ������������, Shift + End - ��������� �� ����� 				  */
				// ��������� ������ �� ���������:
		txtCharacter.setText("TEXT_CHARACTER");
		txtCharacter.selectAll();       		// ��������� ����� ������ � ����
		txtCharacter.deselect();        		// ������� ��������� 
		txtCharacter.selectRange(0, 2);			// �������� ��������� �������� ��������
		txtCharacter.selectPositionCaret(10);	/* ������ ����� �������� ������� (caretPosition). ���� ��������� �� ����, �� ���
			���������� �� ���������� ������� ���������� ������� (caretPosition) �� ����� �������.  ���� ��������� ����, �� ������
			������� �������� �� anchor �� caretPostion.  */
		txtCharacter.extendSelection(10);		/* �������� ��������� ����� �������, ����� ��������� ������� ����� �������� ���������.
			���� ��������� �� ����, �� ��� ���������� �� ���������� ������� ���������� ������� �� ����� ������� */
		txtCharacter.selectBackward();          // ���������� ������� caretPosition �� ���� ������ �����, ������� ��� ���� ���������
		txtCharacter.selectForward();          // ���������� ������� caretPosition �� ���� ������ ������, ������� ��� ���� ���������
		txtCharacter.selectPreviousWord();     // ���������� ������� caretPosition � ������ ������. �����, ������� ��� ���� ���������
		txtCharacter.selectNextWord();    	   // ���������� ������� caretPosition � ������ ���������� �����, ������� ��� ���� ���������
		txtCharacter.selectEndOfNextWord();    // ���������� ������� caretPosition � ����� ���������� �����, ������� ��� ���� ���������
		txtCharacter.selectHome();  	       // ���������� ������� caretPosition � ������ ����, ������� ��� ���� ���������
		txtCharacter.selectEnd();  			   // ���������� ������� caretPosition � ����� ����, ������� ��� ���� ���������
		System.out.println("��������� ������� ��������� - " + txtCharacter.getAnchor()  );
		System.out.println("�������� ������� ��������� - ������� ������� " + txtCharacter.getCaretPosition());
		System.out.println("���������� ����� - " + txtCharacter.getSelectedText());
		
			/* ����������� � ������� ������
		�� ��������� ����������� ����������� ��������� ������: Ctrl + C - ����������, Ctrl + X - ��������, Ctrl + V - �������� 	 */
		txtCharacter.copy();		// �������� ���������� ����� � �����
		txtCharacter.cut();			// �������� ���������� ����� � �������� � �����
		txtCharacter.paste();		// ������� ������ �� ������ � ������� ������� �������
		
			/* ������ � ������ �����
		�� ��������� ����������� ����������� ��������� ������: Ctrl + Z - ��������, Ctrl + Y - ��������� */
		txtCharacter.isUndoable();		// ���� true, �� �������� �������� ������ ���������� �����
		txtCharacter.isRedoable();		// ���� true, �� �������� �������� ������� ����� ���������� ������
		txtCharacter.undo();			// �������� ��������� �������� �����
		txtCharacter.redo();			// ��������� ����� ���������� �������� �����
		
		txtCharacter.clear();
	
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
		TextFormatter<Integer> textForm = new TextFormatter<Integer>(new IntegerStringConverter(), 0); 
		txtNumber.setTextFormatter(textForm);   
		
			// ��� ����� ���� �������� ����������� �� ���� ������ ����������� ������� � ������ ��������
		UnaryOperator<TextFormatter.Change> filter = change -> {
			String str = change.getControlNewText();
			if (str.matches("^([a-z]+)?$")) {
				return change;
			}
			return null;
		};
		TextFormatter<String> textForm2 = new TextFormatter<String>(TextFormatter.IDENTITY_STRING_CONVERTER, "ABC", filter); 
		txtCharacter.setTextFormatter(textForm2);
		
			// ��������� �������� �����, ��� ������� �������� TextFormatter �� ����
		btnOK.setOnAction(event -> {
			String msg = "������ Character's Name - ";
			msg = msg + txtCharacter.getText() + " , Actor's Name - ";
			msg = msg + txtActor.getText() + " , Number - ";
			Integer value = (Integer)txtNumber.getTextFormatter().getValue();
			msg = msg + value.toString();
			Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
			a.setTitle("���� �����");
			a.showAndWait();
		});
		
		
/*---------------------------------------PASSWORD FIELD--------------------------------------------------------------------------
  �������� �������� �����. ��������� ����� TextField � ������� ��������� ��� ��� ������  
  ������������ Object - Node - Parent - Region - Control - TextInputControl - TextField - PasswordField
 		 	�����������:
 	- PasswordField()						 - ������� ������ text field. 	*/
		
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("������� ������");
		Label label = new Label("_Password");
		label.setMnemonicParsing(true);
		label.setLabelFor(passwordField);
		
		passwordField.setMaxSize(200,100);
		
/*--------------------------------------����� TEXTFLOW---������������ ������ -------------------------------------------------------------------------*/
		/* 	��������� ��������� ����� - ���� ����� �� ���������� � ���������� �������, �� �� ����� ���������� �� ����.������
		��� ���� �������� ������� ������������ �� ������ Text ����� ��������������
		������������ Object - Node - Parent - Region - Pane - TextFlow
		������� PANE
			������������:
		 - TextFlow()					- ������� ������ Pane							
		 - TextFlow(Node...children) 	- ������� Pane � ����������� � ���� ������ 
		 ����� setTextAlignment(TextAlignment value) - ������������ �� ����������� ������ ����������
			 - CENTER - �� ������
			 - RIGHT - �� ������� ����
			 - LEFT  - �� ������ ����
			 - JUSTIFY - �� ������
		 ����� setLineSpacing() - ��������� ����� ��������
		 ����� setBackground()	- ��������� �������
		 ����� getChildren().addAll() - ���������� ����� 	 	 */
		TextField txt2 = new TextField();
		txt2.setText("fvndfvfdfnb");
		TextFlow textFlowPane1 = new TextFlow();
		textFlowPane1.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
		textFlowPane1.setMaxWidth(300);
		textFlowPane1.setTextAlignment(TextAlignment.CENTER);
		textFlowPane1.setLineSpacing(1.0);
		textFlowPane1.getChildren().addAll(txt2);
		
		HBox paneCharacter = new HBox(20, lblCharacter, txtCharacter, btnGetText, btnOK);
		paneCharacter.setPadding(new Insets(10));		// ��������� �� ���� = 10 ���
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