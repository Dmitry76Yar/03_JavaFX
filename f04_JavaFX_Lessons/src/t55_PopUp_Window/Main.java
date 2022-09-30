package t55_PopUp_Window;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Popup;
import javafx.stage.PopupWindow.AnchorLocation;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.PopupControl;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Main extends Application {
	Button btn;
	Label lbl;
	int iClickCount = 0;
	
		@Override 
	public void start(Stage primaryStage) {
			
			/* ����������� ����� PopupWindow - ����������� ����
		��������� ���� ��� ��������� � �����, ������� ������������ ��� ����������� ��������� ����������� ���� - ��������, ���
		������ ������������ ���� ��� ���� � ����������.
		����� ���� �� ������������ �� ������ ����� ���� � ������ ��������� � ������������� ����
		������������ Object - Window - PopupWindow   */ 
			
//------------------------------------------TOOLTIP------------------------------------------------------------------------
			
			/* ����� Tooltip ��������� ����������� ���� � ������� ��������� ������������.
	     ��� ��������� ���� ����� ��������� ����� ����������� ����������. ��� ��������� ���� �� ������� ����������
	     ��� ��� ������ ������ ����� ����������� ���� ����������. ������ ����� ����� ����� ������� Esc 
	     ������������ Object - Window - PopupWindow - Tooltip			 */
		
			// �������� ������������  ����
		Tooltip tooltip = new Tooltip();
		Tooltip tooltip2 = new Tooltip("���������");
				
		System.out.println("������ �� ������������ ���� - " + tooltip.getOwnerWindow());
		System.out.println("������ �� ������������ ���� - " + tooltip.getOwnerNode());
		System.out.println("������ �� ������ ����� - " + tooltip.getScene());
				
			// �������� ������������ ���� ��� ������ ������
		tooltip.setAutoHide(true);
			// �������� ������������ ���� ��� ������� Esc
		tooltip.setHideOnEscape(true);
			// ������� ������������ ����
		tooltip.setWidth(150);
		tooltip.setHeight(150);
			// ��������� ���� �������������� ������������� ��� true, ����� ��� �� �������� �� �����
		tooltip.setAutoFix(true);		
		
			/* ��������� ����� ���������� ��������������� ������� ��� true.
		��������, ���� �� ��������� ���������� ������� ������ ��� ���� �������� ������, �� ��� �������� ������������ ����
		� ������� Esc ���������� ������ �� ����� 		 */
		tooltip.setConsumeAutoHidingEvents(true);
		
			// �������������� ������������ ����
//		tooltip.setX(100);			tooltip.setY(100);					// - ��������� ������ �������� ���� ����
//		tooltip.setAnchorX(100);	tooltip.setAnchorY(100);			// - ��������� ������� ����� �� ������
//		popup.setAnchorLocation(AnchorLocation.WINDOW_BOTTOM_LEFT);	// - ��������� ������� ����� ������ ����
		
			// ���������� ������������� � ����������� ���� ���� � ����������� ����
		tooltip.setText("����� ���������");
		
			// ��������� ����� � ������� ������� ����������� � ������ Labelled
		tooltip.setFont(Font.font("Calibri", 15));
		tooltip.setGraphic(new Rectangle(10,  10,  Color.AQUA));
		tooltip.setOpacity(0.7);
		tooltip.setWrapText(false);
		tooltip.setGraphicTextGap(10);
		tooltip.setTextOverrun(OverrunStyle.ELLIPSIS);
		tooltip.setContentDisplay(ContentDisplay.LEFT);
		tooltip.setTextAlignment(TextAlignment.CENTER);
		tooltip.setStyle("-fx-background-color: green;");
		
			// ������ �������� ����� ������������ ��������� ��� ��������� ��������� ���� � ������� ����������
		tooltip.setShowDelay(Duration.millis(1000));
			
			/* ������ ������������ ���������. ������ ���� � ����������. �� ��������� - 5000 ��.
		���� ����� ������� ������� ���������� ������ ����� �������, �� �� ����� ��������� � �������� hidedelay.				 */
		tooltip.setShowDuration(Duration.millis(6000));
		tooltip.setHideDelay(Duration.millis(500));
		
			// ���������� ����� �� ���� � ������� ����������
		System.out.println(tooltip.isActivated());

			/* 3 ������� ������ show() ��� ����������� ���������
		tooltip.show(window) - ����������� ������ �� ������������ ����. ���� ��������� �� ������ ������ 
		tooltip.show(window, window.getX() + anchorX, window.getY() + anchorY) - ��������� ������� ����������
		�������������� ������������� ���� ������������ ������ �������� ����
		tooltip.show(node, window.getX() + anchorX, window.getY() + anchorY) - ��������� ������ �� ����, ������������ ���� ��������
		����� �������������� � �������� ��������, � ����� ��������� ������� ������������������������ ������������� ���� ������������
		������ �������� ����				 */
		Button btn = new Button("ToolTip Button");
		
			// ����� ������������ ���� ��� ��������� �� ������ � ������� setTooltip(Tooltip value)
		btn.setTooltip(tooltip);
		
			// ����� ������������ ���� ��� ��������� �� ������ � ������� install(Node node, Tooltip value)
		Tooltip.install(btn, tooltip);
		
			// �������� �������� ���������
//		Tooltip.uninstall(btn, tooltip);
		
			// ����� ������������ ���� ��� ������� �� ������
		btn.setOnAction(event -> {
			System.out.println("����������� ���� ������������ - " + tooltip.isShowing());
			tooltip.show(primaryStage);	
		});
				
//---------------------------------------------POPUP-----------------------------------------------------------------------		
			/* ����� Popup - �������� ����������� ����������� ������ PopupWindow
		������������ Object - Window - PopupWindow - Popup   
		��������� ��� ������ ������ PopupWindow � ������������� getContent(), � ������� �������� ����� �������� ���� � ���� */
		
			// �������� ������������  ����
		Popup  popup = new Popup();
		
		System.out.println("������ �� ������������ ���� - " + popup.getOwnerWindow());
		System.out.println("������ �� ������������ ���� - " + popup.getOwnerNode());
		System.out.println("������ �� ������ ����� - " + popup.getScene());
		
			// �������� ������������ ���� ��� ������ ������
		popup.setAutoHide(true);
			// �������� ������������ ���� ��� ������� Esc
		popup.setHideOnEscape(true);
			// ������� ������������ ����
		popup.setWidth(150);
		popup.setHeight(150);
			// ��������� ���� �������������� ������������� ��� true, ����� ��� �� �������� �� �����
		popup.setAutoFix(true);
			
			/* ��������� ����� ���������� ��������������� ������� ��� true.
		��������, ���� �� ��������� ���������� ������� ������ ��� ���� �������� ������, �� ��� �������� ������������ ����
		� ������� Esc ���������� ������ �� ����� 		 */
		popup.setConsumeAutoHidingEvents(true);
		
			// �������������� ������������ ����
//		popup.setX(100);			popup.setY(100);					// - ��������� ������ �������� ���� ����
//		popup.setAnchorX(100);		popup.setAnchorY(100);			// - ��������� ������� ����� �� ������
//		popup.setAnchorLocation(AnchorLocation.WINDOW_BOTTOM_LEFT);	// - ��������� ������� ����� ������ ����
		
		popup.setOpacity(0.7);
		
			// �������� ���� � ���� ���� � ����� ����� � �������� ������ ����� ��� ������������ ����
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);		vbox.setPrefSize(200, 100);		vbox.setStyle("-fx-background-color: blue;");
		Label txt = new Label("����� ������ ����");
		txt.setTextFill(Color.WHITE);		
		vbox.getChildren().add(txt);
		
			// ����� ������������� ���� ��� ������� �� ������
		Button btn2 = new Button("PopUp Button");
		btn2.setOnAction(event -> {
			System.out.println("����������� ���� ������������ - " + popup.isShowing());
			popup.show(primaryStage);	
		});
		
//---------------------------------------------POPUP CONTROL-----------------------------------------------------------------------		
		/* ����� PopupControl - ��������� ����� PopupWindow � ��������� ����������� ������������� ������
	������������ Object - Window - PopupWindow - Popup  */
			// �������� ������������  ����
		PopupControl  popupControl = new PopupControl();
				
		System.out.println("������ �� ������������ ���� - " + popupControl.getOwnerWindow());
		System.out.println("������ �� ������������ ���� - " + popupControl.getOwnerNode());
		System.out.println("������ �� ������ ����� - " + popupControl.getScene());
				
			// �������� ������������ ���� ��� ������ ������
		popupControl.setAutoHide(true);
			// �������� ������������ ���� ��� ������� Esc
		popupControl.setHideOnEscape(true);
			// ������� ������������ ����
		popupControl.setWidth(150);
		popupControl.setHeight(150);
			// ��������� ���� �������������� ������������� ��� true, ����� ��� �� �������� �� �����
		popupControl.setAutoFix(true);
					
			/* ��������� ����� ���������� ��������������� ������� ��� true.
		��������, ���� �� ��������� ���������� ������� ������ ��� ���� �������� ������, �� ��� �������� ������������ ����
		� ������� Esc ���������� ������ �� ����� 		 */
		popupControl.setConsumeAutoHidingEvents(true);
				
			// �������������� ������������ ����
//				popupControl.setX(100);			popupControl.setY(100);					// - ��������� ������ �������� ���� ����
//				popupControl.setAnchorX(100);	popupControl.setAnchorY(100);			// - ��������� ������� ����� �� ������
//				popupControl.setAnchorLocation(AnchorLocation.WINDOW_BOTTOM_LEFT);	// - ��������� ������� ����� ������ ����
				
			// �������� ���� � ���� ���� � ����� ����� � �������� ������ ����� ��� ������������ ����
		VBox vbox2 = new VBox();
		vbox2.setAlignment(Pos.CENTER);		vbox2.setPrefSize(200, 100);		vbox2.setStyle("-fx-background-color: blue;");
		Label txt2 = new Label("����� ������ ����");
		txt2.setTextFill(Color.WHITE);		
		vbox2.getChildren().add(txt2);
				
			// ���������� ������������� � ����������� ���� ���� � ����������� ����
		popupControl.getScene().setRoot(vbox2);
			// ����������� �����
		popupControl.setStyle("-fx-background-color: green;");
				
			// ����� ������������� ���� ��� ������� �� ������
		Button btn3 = new Button("PopUpControl");
		btn3.setOnAction(event -> {
			System.out.println("����������� ���� ������������ - " + popupControl.isShowing());
			popupControl.show(primaryStage);	
		});
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(btn, btn2, btn3);
		Scene scene = new Scene(hbox, 800, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
 