package t53_MenuBar_ScrollBar_ToolBar;
	
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;

/* MenuBar ��������� ��������������� ������ ����, ������� ����� ���������� � ������� ����� ���� � ������� BorderPane 
  ������������: Object - Node - Parent- Region - Control - MenuBar		*/

public class Main extends Application {
	Stage stage;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
		
		/* �������� �����������: �������������� ���� ���� (MenuBar) - ������ ��������������� ���� (Menu) - 
								 - ������ � ������ ������ �������������� ���� (MenuItem) */
		
			// ������������ MenuBar
		MenuBar menuBar = new MenuBar();
//		MenuBar menuBar2 = new MenuBar(Menu ....menus);
		
			// ��������� ��������
		menuBar.setPrefWidth(50); menuBar.setMinWidth(50);
		menuBar.setPrefHeight(25); menuBar.setMinHeight(25);
				
			// ��������� �� ���������� ������ ������� �� ������
		menuBar.setStyle("-fx-label-padding: 5.0px;");
		
			/* ����� Menu ��������� ������ ��������������� ���� MenuBar
				 ������������
			Menu()
			Menu(String text)
			Menu (String text, Node graphic)
			Menu (String text, Node graphic, MenuItems...items)  
		������ _ � �������� _File ��������, ��� ������������� ������� ������� Alt + F �������� ����  
		MenuItems...items - ���������� ������� � ���� 			*/
		Menu fileMenu = new Menu("_FileMenu");
		Menu runMenu = new Menu("_RunMenu", new Rectangle(10,10,Color.BLUE), new MenuItem("RunMenuItem"), 
				new MenuItem("DebugMenuItem"));
		
			// ���������� Menu � MenuBar
		menuBar.getMenus().addAll(fileMenu, runMenu);
		
			/* ����� MenuItem ��������� ������ � ������ ������ �������������� ���� Menu
		����� ����������� � ������� ������� MenuItem (������� �����), CheckMenuItem (����� � �������), RadioMenuButton (����� � 
		��������������), SeparatorMenuItem (�������������� �����) ��� CustomMenuItem(������������ �����)  	 */
		
			/* ����� MenuItem ��������� ������� ����� ����   
		������������ Object - MenuItem 
			������������
		MenuItem()
		MenuItem(String text)
		MenuItem(String text, Node graphic)  */
		MenuItem openMenuItem = new MenuItem("MenuItem");
		fileMenu.getItems().addAll(openMenuItem);
		
			/* �������� ��������� ���� 
		����� �enu �������� ����������� ������ MenuItem, ������� ��� ������ ����� �����������, ��� ����� ����.
		��� ��������� ������ ��������� ���� 			 */
		Menu openME = new Menu("OpenMeMenu");
		openME.getItems().add(new MenuItem("Leve1_MenuItem1"));
		openME.getItems().add(new MenuItem("Leve1_MenuItem2"));
		Menu Zoom = new Menu("Leve1_Menu");
		Zoom.getItems().add(new MenuItem("Leve2_MenuItem1"));
		Zoom.getItems().add(new MenuItem("Leve2_MenuItem2"));
		openME.getItems().add(Zoom);
		menuBar.getMenus().add(openME);
		
			/* ���������� ������� MenuItem
		��������� ON_SHOWING - ����������, ����������� ����� ������������ ����
		��������� ON_SHOWN - ����������, ����������� ��� ����������� ����
		��������� ON_HIDDING - ����������, ����������� ����� ��������� ����
		��������� ON_HIDDEN - ����������, ����������� ��� �������� ����				 */
		runMenu.addEventHandler(Menu.ON_SHOWN, event -> {
			System.out.println("ON_ShOWN");
		});
		
			/* ����� CheckMenuItem ��������� ����� ���� � �������
		��� ������ ������ ���� ������ ��������������� ��� ������������.
		����� CheckMenuItem ��������� ��� �������� � ������  MenuItem, �� ��������� �������� selected, ������� �������� �������
		��������� ������: true - ������ ����������
		������������ Object - MenuItem - CheckMenuItem 	
			������������
		CheckMenuItem()
		CheckMenuItem(String text)
		CheckMenuItem(String text, Node graphic)  */
		
		CheckMenuItem checkMenuItem = new CheckMenuItem("CheckMenuItem1");
		CheckMenuItem checkMenuItem2 = new CheckMenuItem("CheckMenuItem2");
		CheckMenuItem checkMenuItem3 = new CheckMenuItem("CheckMenuItem3");
		CheckMenuItem checkMenuItem4 = new CheckMenuItem("CheckMenuItem4");
		Menu checkMenu = new Menu("CheckMenu");
		Menu checkMenu2 = new Menu("CheckMenu2");
		checkMenu.getItems().addAll(checkMenuItem, checkMenuItem2, checkMenuItem3);
		checkMenu2.getItems().addAll(checkMenuItem4);
		checkMenu.getItems().add(checkMenu2);
		menuBar.getMenus().add(checkMenu);
		
			// ���������� ������� CheckMenuItem
		checkMenuItem.setOnAction(event -> {
				System.out.println("������ ����� ���� - " + checkMenuItem.isSelected());
		});
		
			/* ����� RadioMenuItem ��������� ����� � ��������������
		������ ������������� ������������ � ������, ������ ������� ����� ���� ������� ������ ���� �������������
		������������ Object - MenuItem - RadioMenuItem 	
			������������
		RadioMenuItem()
		RadioMenuItem(String text)
		RadioMenuItem(String text, Node graphic)  */
		
		RadioMenuItem radioMenuItem1 = new RadioMenuItem("RadioMenuItem 1");
		RadioMenuItem radioMenuItem2 = new RadioMenuItem("RadioMenuItem2");
		RadioMenuItem radioMenuItem3 = new RadioMenuItem("RadioMenuItem3");
		RadioMenuItem radioMenuItem4 = new RadioMenuItem("RadioMenuItem4");
		RadioMenuItem radioMenuItem5 = new RadioMenuItem("RadioMenuItem5");
		Menu radioMenu3 = new Menu("RadioMenu");
		Menu radioMenu4 = new Menu("RadioMenu2");
		radioMenu3.getItems().addAll(radioMenuItem1, radioMenuItem2, radioMenuItem3);
		radioMenu4.getItems().addAll(radioMenuItem4, radioMenuItem5);
		radioMenu3.getItems().add(radioMenu4);
		
		ToggleGroup group = new ToggleGroup();
		group.getToggles().addAll(radioMenuItem1, radioMenuItem2, radioMenuItem3);
		ToggleGroup group1 = new ToggleGroup();
		group1.getToggles().addAll(radioMenuItem4, radioMenuItem5);
		menuBar.getMenus().add(radioMenu3);
		
			// ���������� ������� RadioMenuItem
		radioMenuItem1.setOnAction(event -> {
				System.out.println("������ ����� ���� radioMenuItem1 - " + radioMenuItem1.isSelected());
		});
		
			/* ����� SeparatorMenuItem - ����������� ������� ����
		��������� �������������� �����, � ������� ������� ����� ��������� ������ ���� �� ������ 
		������������  Object - MenuItem - CustomMenuItem - SeparatorMenuItem */
		SeparatorMenuItem sep = new SeparatorMenuItem();
		checkMenu.getItems().add(sep);
		
			/* ����� CustomMenuItem - ��������� ������� ���� � ������������ ����� 
		������������  Object - MenuItem - CustomMenuItem 
			������������
		CustomMenuItem()
		CustomMenuItem(Node content)
		CustomMenuItem(Node content, boolean hideOnClick)
			��� Node content - ���� ��� ����������
			 	boolean hideOnClick - ��� false ����� ������ �� ����� ��������� � ��������������� �������� ������ ��� �������������� � �����		  */
		Label label = new Label("Slider"); 
		Slider slider = new Slider(0, 100, 50);
		Button btn = new Button("BUTTON");
		VBox vbox = new VBox();
		vbox.getChildren().addAll(label, btn, slider);
		CustomMenuItem �ustomMenuItem1 = new CustomMenuItem();
		�ustomMenuItem1.setContent(vbox);		
		�ustomMenuItem1.setHideOnClick(false);
		slider.valueProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("New value = " + newValue);
		});
		Menu customMenu = new Menu("CustomMenu");
		customMenu.getItems().add(�ustomMenuItem1);
		menuBar.getMenus().add(customMenu);
		
		
			/* ScrollBar - ������ ��������� �������������� ��� ������������ 
		  �������� ��������� ����� � ������� ������� ������ �� �����, ������ �� ������ ��� ��������� ����
		  ������ ��������� �������� ������������ ����� - ������� ������� ������������ pane � �������� ���������� - ScrollPane 
		  ������������: Object - Node - Parent- Region - Control - ScrollBar		*/

		ScrollBar scrollbar1 = new ScrollBar();
				
			// ��������� ��������
		scrollbar1.setPrefWidth(50); scrollbar1.setMinWidth(25);
		scrollbar1.setPrefHeight(400); scrollbar1.setMinHeight(400);
				
			// ��������� ������������ � ������������� ��������� 
		scrollbar1.setMin(0);
		scrollbar1.setMax(100);
		scrollbar1.setValue(20);
				
			// ������� ����������
		scrollbar1.setOrientation(Orientation.VERTICAL);
		
			// ������� ������� ����� ��������
		scrollbar1.setVisibleAmount(10);
					
			// ��������� �� ���������� ������ ������� �� ������ �/��� ����������� ������ ������
		scrollbar1.setStyle("-fx-label-padding: 5.0px;");
								
			// ��������� ���� � ����� ������ ������
		scrollbar1.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
								
			// ������� ��������� ��������� �������� �������� ��� ������ ����� �� ������
		scrollbar1.setBlockIncrement(5.0);
				
			// ������� ��������� ��������� �������� �������� ��� ������� ������ �� ���������, �������� ������ ����
		scrollbar1.setUnitIncrement(5.0);
						
			// ���������� � ���������� �� ��������, ��������� � setBlockIncrement()
		scrollbar1.increment();
		scrollbar1.decrement();
						
			// �������� �������� ��������
		System.out.println(scrollbar1.getValue());
						
			// ������������ �������� ��������
		scrollbar1.valueProperty().addListener((obj, oldValue, newValue) -> {
			/* setValueChanging(true) �������� true, ���� ������������ � ������ ������ ���������� ��������
				 � false, ���� ����������� �������� ���������				 */
			System.out.println("�������� �������� ���������� � " + oldValue + " �� " + newValue); 
		});
		
			/* ToolBar - ������ ������������
		������ ������������ ������������� ��� ��������������� � ������������� ������������ ������ � ����� ������������� ���������, �
		����� ����� ������ ����. ����� ����� ������ �� ������ ������������ ��������� ������ �������� ���� ����������.
		���� ������ �� ���������� �� ToolBar, �� ����������� ������, � ������� ������� ����� ������� ������� ����������
		������������: Object - Node - Parent- Region - Control - ToolBar		*/

		Button btn1 = new Button("Button1");	Button btn2 = new Button("Button2");	Button btn3 = new Button("Button3");
		Button btn4 = new Button("Button4");	Button btn5 = new Button("Button5");	Button btn6 = new Button("Button6");
		Button btn7 = new Button("Button7");	Button btn8 = new Button("Button8");	Button btn9 = new Button("Button9");
			/* ������������
		ToolBar()
		ToolBar(Node...items)  	 */
		ToolBar toolBar1 = new ToolBar();
		ToolBar toolBar2 = new ToolBar();
		
			// ��������� ��������
//		toolBar1.setPrefWidth(400); 	toolBar1.setMinWidth(400);
//		toolBar1.setPrefHeight(50); 	toolBar1.setMinHeight(50);
//		toolBar2.setPrefWidth(50); 		toolBar2.setMinWidth(50);
//		toolBar2.setPrefHeight(400); 	toolBar2.setMinHeight(400);
		
			// ��������� ����������
		toolBar1.setOrientation(Orientation.HORIZONTAL);
		toolBar1.setOrientation(Orientation.VERTICAL);
		
			// ���������� �����
		toolBar1.getItems().addAll(btn1, btn2, btn3, btn4);
		toolBar2.getItems().addAll(btn5, btn6, btn7, btn8, btn9);
		
			// ������������ toolBar � ����� ������ ������ ����� BorderPane
		BorderPane bpane = new BorderPane();
		bpane.setBottom(toolBar1);
		bpane.setLeft(toolBar2);
				
			// ��������� �� ���������� ������ ������� �� ������ �/��� ����������� ������ ������
		toolBar1.setStyle("-fx-label-padding: 5.0px;");
						
			// ��������� ���� � ����� ������ ������
		toolBar1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
						
		
			// ������������ � ����� BorderPane
		BorderPane bp = new BorderPane();
		bp.setTop(menuBar);
		bp.setLeft(scrollbar1);
		bp.setCenter(bpane);
				
		
		Scene scene = new Scene(bp, 800,500 );
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}