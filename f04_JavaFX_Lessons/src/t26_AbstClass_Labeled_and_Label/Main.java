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
			/* ����������� ����� Labeled - ������� ����� ��� ���� �������, ���������� ��������������� �������
	��������, ������� �� ������ ��������� � ���� LabeledText ������ ������, �.�. ������ ��������� ����� Labeled � ��� ��� ������
	������������ Object - Node - Parent - Region - Control - Labeled
		����������� ������������ ������ Labeled �������� ����� Label
	������������ Object - Node - Parent - Region - Control - Labeled - Label 
		��� ������ ������ � ���� ����� ����� ������������ ������ ������ Text. ������� ����� Text � Label � ���, ��� ����� Text ���������
	������, � ���� Label ��������� 	
		������������ 			*/
		Label lbl1 = new Label();
		Label lbl2 = new Label("String TEXT");
			// ����������� ���� ������ ������ ����� ���������� ����������� ����� �� ������ (�� ���������)
		ImageView imf = new ImageView("/img/icons.png");
		Label lbl3 = new Label("String TEXT", imf);
		
			// ��������� ����� ��������
		lbl1.setLineSpacing(2);
		
			// ������������ ������ � ������
		lbl1.setTextAlignment(TextAlignment.LEFT);			// �� ������ ����
		lbl1.setTextAlignment(TextAlignment.JUSTIFY);		// �� ������
		
			// ��������� �� ���������� ������ ������� �� ������ �/��� �����������
		lbl1.setStyle("-fx-label-padding: 20.0px;");
		
			// ������ ����������� ����� ������� � ��� ������������ ������������ �������
		lbl1.setGraphic(new ImageView("/img/icons.png"));
		lbl1.setContentDisplay(ContentDisplay.TOP);				// ������������� ����������� ������������ ������
		lbl1.setGraphicTextGap(2);								// ������ ��������� ����� ������������ � �������
		lbl1.setAlignment(Pos.CENTER);							// ������ ������������ ������ � ����������� ������ �������
		
			// ��������� ���� � ����� ������
		lbl2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		lbl2.setTextFill(Color.WHITE);
		
			// ��������� � ��������� ������
		lbl1.setText("LABEL1");																
		lbl1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// ����� 
		lbl1.setUnderline(true);														// �������������
		
			/* ������ ������� �� ������ ������
		���� true, �� ������ ����� ������������ �� ������
		���� false (�� ���������), �� ������ ����� ����������		 */
		Label lbl4 = new Label("LABELLLLLLLLLLLLLLLLLLLLLLLLLLLL");
		lbl4.setFont(new Font(17));
		lbl4.setWrapText(false);
		
			// ������ ������, ������� ����� ������������ ��� ������� ������ (���� �� �� ���������� �� ����� ������ ��� ������ �������)
		lbl4.setEllipsisString("/..../");
		
			/* ������ ����� ������� (���� ����� �� ���������� �� ����� ������ ��� ������ �������)
		 - ELLIPSIS 				- ����� ���������� � ����� � ����������� �������� �������� ellipsisString
		 - WORD_ELLIPSIS 			- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CENTER_ELLIPSIS 			- ����� ���������� ���������� � ����������� �������� �������� ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - LEADING_ELLIPSIS 		- ����� ���������� ������� � ����������� �������� �������� ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CLIP 					- ����� ������ ���������� � �����					 */
		lbl4.setTextOverrun(OverrunStyle.ELLIPSIS);
		
			
			
			
		HBox hbox = new HBox();		hbox.setPadding(new Insets(10));	hbox.setSpacing(20);	
		hbox.getChildren().addAll(lbl1, lbl2, lbl3, lbl4);
		Scene scene = new Scene(hbox, 500, 500);	// ���������� the layout pane to a scene
		primaryStage.setScene(scene);				// ���������� � Stage ������� scene
		primaryStage.show();						// ����� Stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}
