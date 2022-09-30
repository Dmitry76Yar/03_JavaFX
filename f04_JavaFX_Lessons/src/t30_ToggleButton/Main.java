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
			
			/* ����� ToggleButton � ��������� Toogle
		����� ToggleButton ��������� ������������� � ���� ������� ������, ������� ������������� ������� ���������
		������������: Object - Node- Parent - Region - Control - Labeled - ButtonBase - ToogleButton		 */
			
			// ������������ 		
		ToggleButton toggleButton1 = new ToggleButton();
		ToggleButton toggleButton2 = new ToggleButton("toggleButton2");		   
			// ����������� ���� ������ ������ ����� ���������� ����������� ����� �� ������ (�� ���������)
		ImageView imf = new ImageView("/img/icons.png");
		ToggleButton toggleButton3 = new ToggleButton("toggleButton3", imf);
				
			// �������� ������ �� ������
		toggleButton1.setText("toggleButton1");
		toggleButton1.setMinWidth(120);
		
			// ��������� � ���������� ������
		toggleButton1.selectedProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("button selected = " + newValue);
		});
		toggleButton1.setOnAction(event -> {
			if (toggleButton1.isSelected())  {					// isSelected() ��� true �������, false - ���������
				System.out.println("������������� �������");			
				toggleButton1.setText("��������");
			}
			else {
				System.out.println("������������� ��������");
				toggleButton1.setText("���������");
			}
		});
		
		toggleButton2.setOnAction(event -> {
			if (toggleButton2.isSelected())  {					// isSelected() ��� true �������, false - ���������
				System.out.println("������������� �������");			
				toggleButton2.setText("��������");
			}
			else {
				System.out.println("������������� ��������");
				toggleButton2.setText("���������");
			}
		});
		
			/* ����� ToggleGroup ��� ����������� ������ � ������
		������ ����� ������ ����� ���� ������� ������ ���� �������������. ��� ��������� ������� ������������� ������ �����������.
		��� ������������� ToggleButton ����� ��������� ��� ����������� ������ ������ � �������� null
		��� ������������� RadioButton ������ ������ ������ ���� ���� ���������� �������������				 */
		ToggleGroup toggleGroup = new ToggleGroup();
			// ���������� ������ � ������
		toggleGroup.getToggles().addAll(toggleButton1, toggleButton2);
		
			// ��������� ����� ��������
		toggleButton1.setLineSpacing(2);
		
			// ������������ ������ 
		toggleButton1.setTextAlignment(TextAlignment.LEFT);		// �� ������ ����
		toggleButton1.setTextAlignment(TextAlignment.JUSTIFY);		// �� ������
		
			// ��������� �� ���������� ������ ������� �� ������ �/��� ����������� 
		toggleButton1.setStyle("-fx-label-padding: 5.0px;");
		
			// ������ ����������� ����� ������� � ��� ������������ ������������ ������� ������ ������
		toggleButton1.setGraphic(new ImageView("/img/icons.png"));
		toggleButton1.setContentDisplay(ContentDisplay.TOP);				// ������������� ����������� ������������ ������
		toggleButton1.setGraphicTextGap(2);								// ������ ��������� ����� ������������ � �������
		toggleButton1.setAlignment(Pos.CENTER);							// ������ ������������ ������ � ����������� ������ �������
		ToggleButton toggleButton4 = new ToggleButton("toggleButton4", imf);
		toggleButton4.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);				// ������ �����������
		
			// ��������� ���� � ����� ������ ������
		toggleButton2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		toggleButton2.setTextFill(Color.WHITE);
		
			// ��������� � ��������� ������
		toggleButton2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// ����� 
		toggleButton2.setUnderline(true);														// �������������
				
			/* ������ ������� �� ������ ������
		���� true, �� ������ ����� ������������ �� ������
		���� false (�� ���������), �� ������ ����� ����������		 */
		ToggleButton toggleButton5 = new ToggleButton("����� �� ������5");
		toggleButton5.setFont(new Font(17));
		toggleButton5.setWrapText(false);
				
			// ������ ������, ������� ����� ������������ ��� ������� ������ (���� �� �� ���������� �� ����� ������ ��� ������ �������)
		toggleButton5.setEllipsisString("/..../");
			
			/* ������ ����� ������� (���� ����� �� ���������� �� ����� ������ ��� ������ �������)
		 - ELLIPSIS 				- ����� ���������� � ����� � ����������� �������� �������� ellipsisString
		 - WORD_ELLIPSIS 			- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CENTER_ELLIPSIS 			- ����� ���������� ���������� � ����������� �������� �������� ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - LEADING_ELLIPSIS 		- ����� ���������� ������� � ����������� �������� �������� ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CLIP 					- ����� ������ ���������� � �����					 */
		toggleButton5.setTextOverrun(OverrunStyle.ELLIPSIS);
		
//				// �������� ������� �� ������ ����� �� ���� ���������
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
		Scene scene = new Scene(hbox, 700, 500);	// ���������� the layout pane to a scene
		primaryStage.setScene(scene);				// ���������� � Stage ������� scene
		primaryStage.show();						// ����� Stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}
