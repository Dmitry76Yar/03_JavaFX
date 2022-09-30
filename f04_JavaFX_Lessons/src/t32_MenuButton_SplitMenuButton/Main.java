package t32_MenuButton_SplitMenuButton;
	
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;

public class Main extends Application {
	Stage stage;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
		
			/* MenuButton - ������ ������ ����
		������ MenuButton ��������� ������, ��� ������� �� ������� ������������ ����������� ���� 
		������������: Object - Node - Parent- Region - Control - Labeled - ButtonBase - MenuButton
			 ������������
		MenuButton()
		MenuButton(String text)
		MenuButton(String text, Node graphic)
		MenuButton(String text, Node graphic, MenuItem...items)			 */
		
		MenuItem redMenuItem = new MenuItem("RED");
		redMenuItem.setOnAction(event -> {
			System.out.println("������ ������� ����");
		});
		MenuItem blueMenuItem = new MenuItem("BLUE");
		blueMenuItem.setOnAction(event -> {
			System.out.println("������ ����� ����");
		});
		MenuButton menuButton = new MenuButton("MenuButton");
		menuButton.getItems().addAll(redMenuItem, blueMenuItem);
		
			// ������ �������������� ������������ ���� ������������ ������.���� ����� ��� ����������� ����, �� �����
		menuButton.setPopupSide(Side.BOTTOM);
		
			/* ���������� ������� 
		��������� ON_SHOWING - ����������, ����������� ����� ������������ ����
		��������� ON_SHOWN - ����������, ����������� ��� ����������� ����
		��������� ON_HIDDING - ����������, ����������� ����� ��������� ����
		��������� ON_HIDDEN - ����������, ����������� ��� �������� ����				 */
		menuButton.addEventHandler(Menu.ON_SHOWN, event -> {
			System.out.println("ON_ShOWN");
		});
		
			/* SplitMenuButton - ������ � ����
		��������� ������� ���������� ������� ������ � ������ ������ ������������ ����
		������������: Object - Node - Parent- Region - Control - Labeled - ButtonBase - MenuButton - SplitMenuButton
			 ������������
		SplitMenuButton()
		SplitMenuButton(MenuItem...items)	 	 */
		
		MenuItem redMenuItem1 = new MenuItem("RED");
		redMenuItem1.setOnAction(event -> {
			System.out.println("������ ������� ����");
		});
		MenuItem blueMenuItem1 = new MenuItem("BLUE");
		blueMenuItem1.setOnAction(event -> {
			System.out.println("������ ����� ����");
		});
		SplitMenuButton splitMenuButton1 = new SplitMenuButton();
		splitMenuButton1.setText("SplitMenuButton");
		splitMenuButton1.getItems().addAll(redMenuItem1, blueMenuItem1);
		
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.getChildren().addAll(menuButton, splitMenuButton1);
		
		Scene scene = new Scene(hbox, 800,500 );
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}