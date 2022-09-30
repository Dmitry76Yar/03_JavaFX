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
	- Text(String text)						 - ������� Text � ��������� �������
	- Text(double x, double y, String text)	 - ������� Text � ��������� ������� � � ���������� ������������*/
		
	Text text1 = new Text();
	Text text2 = new Text("�����");
	Text text3 = new Text(0.0, 0.0, "����� QWERTY");		
		// ����� ������������� ������� � ���������
	text1.setX(1.0);
	text1.setY(1.0);
		// �������� �������
	text1.setText("Text");
		// ����
	text2.setFill(Color.BLACK);
		// ������������ ������ � ������
	text2.setTextOrigin(VPos.BOTTOM);		text3.setTextOrigin(VPos.CENTER);
		// �����
	text2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
		
		// ��������� ������ ������ getText()
	Button btnGetText = new Button("getText()");
	Button btnGetParagraph = new Button("getParagraph()");
	btnGetText.setOnAction(event -> {
		String msg = text2.getText();
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("GET TEXT");
		a.showAndWait();
	});

		// ������������� � ������������
	text3.setStrikethrough(true);
	text2.setUnderline(true);
	Path path = new Path(text2.underlineShape(0, 20));			// ����� ������� ������������� �������
	path.setStroke(Color.RED);
	path.setStrokeWidth(1);
		// ��������� ����� ��������
	text3.setLineSpacing(5);
		// �����
	text1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
			
		// ��������� ������
	// ��������� � �������� ������� ���������
	text2.setSelectionStart(-1);		// ����� �������� ���������
	text2.setSelectionStart(2); 		// ��������, ������� � 2-�� � ���������� 4-� ���������
	text2.setSelectionEnd(4);
		// ���� ���������
	text2.setSelectionFill(Color.BLUE);
		// ����������, ����������� ��� ��������� �������� ������
	Path path2 = new Path(text2.getSelectionShape());
	path2.setFill(Color.RED);
	path2.setStroke(Color.BLACK);
		// ���������� ������ ��������� ��������� ������
	Path path3 = new Path(text3.rangeShape(0, 10));
	path3.setFill(Color.BLUE);
	path3.setStroke(Color.BLACK);
	text3.setSelectionFill(Color.BEIGE);
		
			// ���������� �������� � ������
	text3.setCaretPosition(2);		// ������� ������� � ����� (�������� -1 - ������� �� �����������)
	text3.setCaretBias(true);       // true (�� ���������) - ������ ����� ��������, false -������ ����� �������
	Path path4 = new Path(text3.getCaretShape());		// ����������, ����������� ������
	path4.setStroke(Color.RED);
			
			// ������������ ������
		// ����������� ������ ���������� ����
		// ���� ����� �� ���������� � ���������� ����, �� ���� ������� �� ��������� ������
	text2.setWrappingWidth(100);		// ��� ���� �������� ������� ������� 100 ���
	text3.setWrappingWidth(100);	
				// ������������ ������ ������ ������� ������������ ������
	text2.setTextAlignment(TextAlignment.CENTER);
	text3.setTextAlignment(TextAlignment.RIGHT);			// �� ������� ����
	text1.setTextAlignment(TextAlignment.JUSTIFY);			// �� ������ ���������� �������
	
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
	Text text5 = new Text("����� TEXTFLOW------����� TEXTFLOW");
	text5.setFill(Color.BLACK);
	text5.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 24));
	
	TextFlow textFlowPane1 = new TextFlow();
	textFlowPane1.setPrefWidth(400);
	textFlowPane1.setPadding(new Insets(10));
	textFlowPane1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
	textFlowPane1.setTextAlignment(TextAlignment.CENTER);
	textFlowPane1.setLineSpacing(1.0);
	textFlowPane1.getChildren().addAll(text5);
	
/*--------------------------------------�����-------------------------------------------------------------------------*/
		// �����������
	Font font1 = new Font(24);								// ��������� ������ ������ ������
	Font font2 = new Font("Calibri Bold Italic", 24);		// ��������� ������ � ��� ������ ����� String
		// �������� ������
	Font font3 = Font.font(24);									// (double size)
	Font font4 = Font.font("Calibri");							// (String family)
	Font font5 = Font.font("Calibri", 24);						// (String family, double size)
	Font font6 = Font.font("Calibri", FontWeight.BOLD, 24);		// (String family, FontWeight weight, double size)
	Font font7 = Font.font("Calibri", FontPosture.ITALIC, 24);	// (String family, FontPosture posture, double size)
	Font font8 = Font.font("Calibri", FontWeight.THIN, FontPosture.ITALIC, 24);	// (String family, FontWeight weight, FontPosture posture, double size)
		// ������ ����� �� ��������� �������
	System.out.println("����� �� ��������� " + Font.getDefault());
		// ����� �������� ������ ���� �������� ��������� �������
	List<String> list1 = Font.getFamilies();	
	System.out.println(list1);
		// ����� �������� ������ ���� �������� ��������� �������
	List<String> list2 = Font.getFontNames();	
	System.out.println(list2);
		// ����� �������� ������ ���� �������� ��� ���������� ��������� �������
	List<String> list3 = Font.getFontNames("Calibri");	
	System.out.println(list3);
		/* �������� ������� �� ������
	 - static Font loadFont (string urlStr, double size)
	 - static Font loadFont (Inputstream in, double size)
	 - static Font[] loadFonts (string urlStr, double size)
	 - static Font[] loadFonts (Inputstream in, double size)			 */
		// ������ GET
	System.out.println("�������� ��������� ������  " + font8.getFamily());
	System.out.println("�������� ������  " + font8.getName());
	System.out.println("�������� ������  " + font8.getSize());
	System.out.println("�������� ����� ������  " + font8.getStyle());
		// ��������� ������
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