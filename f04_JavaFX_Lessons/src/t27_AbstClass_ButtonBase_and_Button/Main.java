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
			
			/* ����������� ����� ButtonBase ������� ������� ��� ������, ��������������, ������� � �����������
		������������: Object - Node- Parent - Region - Control - Labeled - ButtonBase		 */
			
			/* ����� Button
		������������: Object - Node- Parent - Region - Control - Labeled - ButtonBase - Button		 */
			
			// ������������ 		
		Button btn = new Button();
		Button btn2 = new Button("BUTTON2");
			// ����������� ���� ������ ������ ����� ���������� ����������� ����� �� ������ (�� ���������)
		ImageView imf = new ImageView("/img/icons.png");
		Button btn3 = new Button("BUTTON3", imf);
		
			// �������� ������� �� ������
		btn.setText("Click me please!");		
		
			// ������ �� ��������� - ���������� ��� ������� Enter
		btn2.setDefaultButton(true);
		
			// ������ ������ - ���������� ��� ������� ESC
		btn3.setCancelButton(true);		
		
			/* ����� ��� ������� ������ ���������� ���������� ������� � ����� ������������� ������, ����� ������������
		�� ����� �� �������, �����, ��� ��������� �����. ����� ��������������� ������ �� ����� �������� ���������			 */
		btn3.setOnAction(event -> {
			System.out.println("������ ������3");
			btn3.setDisable(true);												// ������ ������ �����������
			PauseTransition tr = new PauseTransition(Duration.seconds(5));		// ��� �������� ���������� ������� ��������
			tr.setOnFinished(event2 -> {
				System.out.println("�������� ���������");
				btn3.setDisable(false);											// ������ ������ ����� ���������
			});
			tr.play();
		});
		
			// ��������� ����� �������� ������ � ������
		btn3.setLineSpacing(2);
		
			// ������������ ������ � ������
		btn3.setTextAlignment(TextAlignment.LEFT);			// �� ������ ����
		btn3.setTextAlignment(TextAlignment.JUSTIFY);		// �� ������
		
			// ��������� �� ���������� ������ ������� �� ������ �/��� ����������� ������ ������
		btn3.setStyle("-fx-label-padding: 5.0px;");
		
			// ������ ����������� ����� ������� � ��� ������������ ������������ ������� ������ ������
		btn.setGraphic(new ImageView("/img/icons.png"));
		btn.setContentDisplay(ContentDisplay.TOP);				// ������������� ����������� ������������ ������
		btn.setGraphicTextGap(2);								// ������ ��������� ����� ������������ � �������
		btn.setAlignment(Pos.CENTER);							// ������ ������������ ������ � ����������� ������ �������
		Button btn4 = new Button("BUTTON4", imf);
		btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);		// ������ �����������
		
			// ��������� ���� � ����� ������ ������
		btn2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		btn2.setTextFill(Color.WHITE);
		
			// ��������� � ��������� ������
		btn2.setText("LABEL1");																
		btn2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// ����� 
		btn2.setUnderline(true);														// �������������
				
			/* ������ ������� �� ������ ������
		���� true, �� ������ ����� ������������ �� ������
		���� false (�� ���������), �� ������ ����� ����������		 */
		Button btn5 = new Button("TEXTTTTTTTTTT");
		btn5.setFont(new Font(17));
		btn5.setWrapText(false);
				
			// ������ ������, ������� ����� ������������ ��� ������� ������ (���� �� �� ���������� �� ����� ������ ��� ������ �������)
		btn5.setEllipsisString("/..../");
			
			/* ������ ����� ������� (���� ����� �� ���������� �� ����� ������ ��� ������ �������)
		 - ELLIPSIS 				- ����� ���������� � ����� � ����������� �������� �������� ellipsisString
		 - WORD_ELLIPSIS 			- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CENTER_ELLIPSIS 			- ����� ���������� ���������� � ����������� �������� �������� ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - LEADING_ELLIPSIS 		- ����� ���������� ������� � ����������� �������� �������� ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CLIP 					- ����� ������ ���������� � �����					 */
		btn5.setTextOverrun(OverrunStyle.ELLIPSIS);
		
					// ���������� 
			// � ������� ����������� ������
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("������ ������1");
			}
		});
			// � ������� ������-���������
		btn2.setOnAction(event -> {
			System.out.println("������ ������2");
		});
			// � ������� ������ addEventHandler()
		btn4.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
				@Override
			public void handle(ActionEvent event) {
				System.out.println("������ ������3");
			}
		});
		
				// �������� ������� �� ������ ����� �� ���� ���������
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
		Scene scene = new Scene(hbox, 500, 500);	// ���������� the layout pane to a scene
		primaryStage.setScene(scene);				// ���������� � Stage ������� scene
		primaryStage.show();						// ����� Stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}
