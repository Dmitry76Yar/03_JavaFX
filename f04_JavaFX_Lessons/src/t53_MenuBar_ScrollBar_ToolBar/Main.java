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

/* MenuBar описывает горизонтальныую панель меню, которую можно прикрепить к верхней части окна с помощью BorderPane 
  Наследование: Object - Node - Parent- Region - Control - MenuBar		*/

public class Main extends Application {
	Stage stage;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
		
		/* Иерархия вложенности: Горизонтальное поле меню (MenuBar) - ячейки горизонтального меню (Menu) - 
								 - пункты в каждой ячейке горизотельного меню (MenuItem) */
		
			// Конструкторы MenuBar
		MenuBar menuBar = new MenuBar();
//		MenuBar menuBar2 = new MenuBar(Menu ....menus);
		
			// Изменение размеров
		menuBar.setPrefWidth(50); menuBar.setMinWidth(50);
		menuBar.setPrefHeight(25); menuBar.setMinHeight(25);
				
			// Растояние от внутренних границ области до текста
		menuBar.setStyle("-fx-label-padding: 5.0px;");
		
			/* КЛАСС Menu реализует ячейки горизонтального меню MenuBar
				 Конструкторы
			Menu()
			Menu(String text)
			Menu (String text, Node graphic)
			Menu (String text, Node graphic, MenuItems...items)  
		Символ _ в названии _File означает, при одновременном нажатии клавиши Alt + F вызывает меню  
		MenuItems...items - добавление пунктов в меню 			*/
		Menu fileMenu = new Menu("_FileMenu");
		Menu runMenu = new Menu("_RunMenu", new Rectangle(10,10,Color.BLUE), new MenuItem("RunMenuItem"), 
				new MenuItem("DebugMenuItem"));
		
			// Добавление Menu в MenuBar
		menuBar.getMenus().addAll(fileMenu, runMenu);
		
			/* КЛАСС MenuItem реализует пункты в каждой ячейке горизотельного меню Menu
		Класс реализуется с помощью классов MenuItem (обычный пункт), CheckMenuItem (пункт с флажком), RadioMenuButton (пункт с 
		переключателем), SeparatorMenuItem (горизонтальная линия) или CustomMenuItem(произвольный пункт)  	 */
		
			/* КЛАСС MenuItem реализует обычный пункт меню   
		Наследование Object - MenuItem 
			Конструкторы
		MenuItem()
		MenuItem(String text)
		MenuItem(String text, Node graphic)  */
		MenuItem openMenuItem = new MenuItem("MenuItem");
		fileMenu.getItems().addAll(openMenuItem);
		
			/* Создание вложенных меню 
		Класс Мenu является наследником класса MenuItem, поэтому его объект можно исползовать, как пункт меню.
		Это позволяет делать вложенные меню 			 */
		Menu openME = new Menu("OpenMeMenu");
		openME.getItems().add(new MenuItem("Leve1_MenuItem1"));
		openME.getItems().add(new MenuItem("Leve1_MenuItem2"));
		Menu Zoom = new Menu("Leve1_Menu");
		Zoom.getItems().add(new MenuItem("Leve2_MenuItem1"));
		Zoom.getItems().add(new MenuItem("Leve2_MenuItem2"));
		openME.getItems().add(Zoom);
		menuBar.getMenus().add(openME);
		
			/* Обработчик событий MenuItem
		Константа ON_SHOWING - обработчик, возникающий перед отображением меню
		Константа ON_SHOWN - обработчик, возникающий при отображении меню
		Константа ON_HIDDING - обработчик, возникающий перед сокрытием меню
		Константа ON_HIDDEN - обработчик, возникающий при сокрытии меню				 */
		runMenu.addEventHandler(Menu.ON_SHOWN, event -> {
			System.out.println("ON_ShOWN");
		});
		
			/* КЛАСС CheckMenuItem реализует пункт меню с флажком
		При выборе пункта меню флажок устанавливается или сбрасывается.
		Класс CheckMenuItem наследует все свойства и методы  MenuItem, но добавляет свойство selected, которое содержит текущее
		состояния флажка: true - флажок установлен
		Наследование Object - MenuItem - CheckMenuItem 	
			Конструкторы
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
		
			// Обработчик событий CheckMenuItem
		checkMenuItem.setOnAction(event -> {
				System.out.println("Выбран пункт меню - " + checkMenuItem.isSelected());
		});
		
			/* КЛАСС RadioMenuItem реализует пункт с переключателем
		Обычно переключатели организуются в группы, внутри которой может быть включен только один переключатель
		Наследование Object - MenuItem - RadioMenuItem 	
			Конструкторы
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
		
			// Обработчик событий RadioMenuItem
		radioMenuItem1.setOnAction(event -> {
				System.out.println("Выбран пункт меню radioMenuItem1 - " + radioMenuItem1.isSelected());
		});
		
			/* Класс SeparatorMenuItem - разделитель пунктов меню
		реализует горизонтальную линию, с помощью которой можно разделить пункты меню на группы 
		Наследование  Object - MenuItem - CustomMenuItem - SeparatorMenuItem */
		SeparatorMenuItem sep = new SeparatorMenuItem();
		checkMenu.getItems().add(sep);
		
			/* Класс CustomMenuItem - позволяет создать меню с произвольным узлом 
		Наследование  Object - MenuItem - CustomMenuItem 
			Конструкторы
		CustomMenuItem()
		CustomMenuItem(Node content)
		CustomMenuItem(Node content, boolean hideOnClick)
			где Node content - узел для добавления
			 	boolean hideOnClick - при false выбор пункта не будет приводить к автоматическому сокрытию панели для взаимодействия с узлом		  */
		Label label = new Label("Slider"); 
		Slider slider = new Slider(0, 100, 50);
		Button btn = new Button("BUTTON");
		VBox vbox = new VBox();
		vbox.getChildren().addAll(label, btn, slider);
		CustomMenuItem сustomMenuItem1 = new CustomMenuItem();
		сustomMenuItem1.setContent(vbox);		
		сustomMenuItem1.setHideOnClick(false);
		slider.valueProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("New value = " + newValue);
		});
		Menu customMenu = new Menu("CustomMenu");
		customMenu.getItems().add(сustomMenuItem1);
		menuBar.getMenus().add(customMenu);
		
		
			/* ScrollBar - полоса прокрутки горизонтальная или вертикальная 
		  Изменить положение можно с помощью нажатия кнопок по краям, щелчка по полосе или поворотом мыши
		  Полоса прокрутки отдельно используется редко - гораздо удобнее пользоваться pane с полосами прокруткой - ScrollPane 
		  Наследование: Object - Node - Parent- Region - Control - ScrollBar		*/

		ScrollBar scrollbar1 = new ScrollBar();
				
			// Изменение размеров
		scrollbar1.setPrefWidth(50); scrollbar1.setMinWidth(25);
		scrollbar1.setPrefHeight(400); scrollbar1.setMinHeight(400);
				
			// Установка минимального и максимального диапазона 
		scrollbar1.setMin(0);
		scrollbar1.setMax(100);
		scrollbar1.setValue(20);
				
			// Задание ориентации
		scrollbar1.setOrientation(Orientation.VERTICAL);
		
			// Задание видимой длины ползунка
		scrollbar1.setVisibleAmount(10);
					
			// Растояние от внутренних границ области до текста и/или изображения внутри кнопки
		scrollbar1.setStyle("-fx-label-padding: 5.0px;");
								
			// Установка фона и цвета текста кнопуи
		scrollbar1.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
								
			// Задание насколько изменится значение ползунка при щелчке мышью по полосе
		scrollbar1.setBlockIncrement(5.0);
				
			// Задание насколько изменится значение ползунка при нажатии кнопок со стрелками, повороте колеса мыши
		scrollbar1.setUnitIncrement(5.0);
						
			// Увеличение и уменьшение на величину, указанную в setBlockIncrement()
		scrollbar1.increment();
		scrollbar1.decrement();
						
			// Получить значение ползунка
		System.out.println(scrollbar1.getValue());
						
			// Отслеживание значения ползунка
		scrollbar1.valueProperty().addListener((obj, oldValue, newValue) -> {
			/* setValueChanging(true) содержит true, если пользователь в данный момент перемещает ползунок
				 и false, если перемещение ползунка закончено				 */
			System.out.println("Значение ползунка изменилось с " + oldValue + " на " + newValue); 
		});
		
			/* ToolBar - панель инструментов
		Панели инструментов предназначены для горизонтального и вертикального выравнивания кнопок с часто используемыми командами, а
		также любых других улов. Оченб часто кнопки на панели инструментов дублируют пункты главного меню приложения.
		Если кнопки не помещаются на ToolBar, то отобразится кнопка, с помощью которой можно выбрать скрытые компоненты
		Наследование: Object - Node - Parent- Region - Control - ToolBar		*/

		Button btn1 = new Button("Button1");	Button btn2 = new Button("Button2");	Button btn3 = new Button("Button3");
		Button btn4 = new Button("Button4");	Button btn5 = new Button("Button5");	Button btn6 = new Button("Button6");
		Button btn7 = new Button("Button7");	Button btn8 = new Button("Button8");	Button btn9 = new Button("Button9");
			/* Конструкторы
		ToolBar()
		ToolBar(Node...items)  	 */
		ToolBar toolBar1 = new ToolBar();
		ToolBar toolBar2 = new ToolBar();
		
			// Изменение размеров
//		toolBar1.setPrefWidth(400); 	toolBar1.setMinWidth(400);
//		toolBar1.setPrefHeight(50); 	toolBar1.setMinHeight(50);
//		toolBar2.setPrefWidth(50); 		toolBar2.setMinWidth(50);
//		toolBar2.setPrefHeight(400); 	toolBar2.setMinHeight(400);
		
			// Изменение ориентации
		toolBar1.setOrientation(Orientation.HORIZONTAL);
		toolBar1.setOrientation(Orientation.VERTICAL);
		
			// Добавление узлов
		toolBar1.getItems().addAll(btn1, btn2, btn3, btn4);
		toolBar2.getItems().addAll(btn5, btn6, btn7, btn8, btn9);
		
			// Прикрепление toolBar к сцене удобно делать через BorderPane
		BorderPane bpane = new BorderPane();
		bpane.setBottom(toolBar1);
		bpane.setLeft(toolBar2);
				
			// Растояние от внутренних границ области до текста и/или изображения внутри кнопки
		toolBar1.setStyle("-fx-label-padding: 5.0px;");
						
			// Установка фона и цвета текста кнопуи
		toolBar1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
						
		
			// Прикрепление к верху BorderPane
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