package t28_HyperLink;
	
import java.awt.Desktop;
import java.net.URI;
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
import javafx.scene.control.Hyperlink;
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
			
			/* HyperLink ��������� ���������� ����������� � ���� 
			�� ���� HyperLink ��� � ��������� ������� (��������� Labeled) � ������ (��������� ButtonBase)
			������������: Object - Node- Parent - Region - Control - Labeled - ButtonBase - Hyperlink		 */
			
			// ������������ 		
		Hyperlink hyperlink1 = new Hyperlink();
		Hyperlink hyperlink2 = new Hyperlink("������2");			// � ������ ����������� �����   
			// ����������� ���� ������ ������ ����� ���������� ����������� ����� �� ������ (�� ���������)
		ImageView imf = new ImageView("/img/icons.png");
		Hyperlink hyperlink3 = new Hyperlink("-----������3-------", imf);
		
			// �������� ������ � ������
		hyperlink1.setText("������1");	
		
			// ��������� ����� ��������
		hyperlink1.setLineSpacing(2);
		
			// ������������ ������ 
		hyperlink1.setTextAlignment(TextAlignment.LEFT);		// �� ������ ����
		hyperlink1.setTextAlignment(TextAlignment.JUSTIFY);		// �� ������
		
			// ��������� �� ���������� ������ ������� �� ������ �/��� ����������� 
		hyperlink1.setStyle("-fx-label-padding: 5.0px;");
		
			// ������ ����������� ����� ������� � ��� ������������ ������������ ������� ������ ������
		hyperlink1.setGraphic(new ImageView("/img/icons.png"));
		hyperlink1.setContentDisplay(ContentDisplay.TOP);				// ������������� ����������� ������������ ������
		hyperlink1.setGraphicTextGap(2);								// ������ ��������� ����� ������������ � �������
		hyperlink1.setAlignment(Pos.CENTER);							// ������ ������������ ������ � ����������� ������ �������
		Hyperlink hyperlink4 = new Hyperlink("https://yandex.ru/", imf);
		hyperlink4.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);				// ������ �����������
		
			// ��������� ���� � ����� ������ ������
		hyperlink2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		hyperlink2.setTextFill(Color.WHITE);
		
			// ��������� � ��������� ������
		hyperlink2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// ����� 
		hyperlink2.setUnderline(true);														// �������������
				
			/* ������ ������� �� ������ ������
		���� true, �� ������ ����� ������������ �� ������
		���� false (�� ���������), �� ������ ����� ����������		 */
		Hyperlink hyperlink5 = new Hyperlink("https://yandex.ru/images/?from=tabbar");
		hyperlink5.setFont(new Font(17));
		hyperlink5.setWrapText(false);
				
			// ������ ������, ������� ����� ������������ ��� ������� ������ (���� �� �� ���������� �� ����� ������ ��� ������ �������)
		hyperlink5.setEllipsisString("/..../");
			
			/* ������ ����� ������� (���� ����� �� ���������� �� ����� ������ ��� ������ �������)
		 - ELLIPSIS 				- ����� ���������� � ����� � ����������� �������� �������� ellipsisString
		 - WORD_ELLIPSIS 			- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CENTER_ELLIPSIS 			- ����� ���������� ���������� � ����������� �������� �������� ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - LEADING_ELLIPSIS 		- ����� ���������� ������� � ����������� �������� �������� ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- ���������� ELLIPSIS, �� ����� ���������� ����� �������, � �� � ����� ����� �����
		 - CLIP 					- ����� ������ ���������� � �����					 */
		hyperlink5.setTextOverrun(OverrunStyle.ELLIPSIS);
		
					// ���������� 
			// � ������� ����������� ������
		hyperlink1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("������� �� ����������� ������");
					// ����� ��������� Web-�������, ������������ � ������� �� ���������, � �������� ��� ����� ������
				if (Desktop.isDesktopSupported()) {
					try {	Desktop.getDesktop().browse(URI.create("https://yandex.ru/"));}
					catch (Exception e) {System.out.println("�� ������� ��������� �������");}
				}
			}
		});
			// � ������� ������-���������
		hyperlink2.setOnAction(event -> {
			System.out.println("������� �� ����������� ������");
				// ����� ��������� Web-�������, ������������ � ������� �� ���������, � �������� ��� ����� ������
			if (Desktop.isDesktopSupported()) {
				try {	Desktop.getDesktop().browse(URI.create("https://yandex.ru/"));}
				catch (Exception e) {System.out.println("�� ������� ��������� �������");}
			}
		});
			// � ������� ������ addEventHandler()
		hyperlink3.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
				@Override
			public void handle(ActionEvent event) {
				System.out.println("������� �� ����������� ������");
					// ����� ��������� Web-�������, ������������ � ������� �� ���������, � �������� ��� ����� ������
				if (Desktop.isDesktopSupported()) {
					try {	Desktop.getDesktop().browse(URI.create("https://yandex.ru/"));}
					catch (Exception e) {System.out.println("�� ������� ��������� �������");}
				}
			}
		});
		
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
		hbox.getChildren().addAll(hyperlink1, hyperlink2, hyperlink3, hyperlink4, hyperlink5);
		Scene scene = new Scene(hbox, 700, 500);	// ���������� the layout pane to a scene
		primaryStage.setScene(scene);				// ���������� � Stage ������� scene
		primaryStage.show();						// ����� Stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}
