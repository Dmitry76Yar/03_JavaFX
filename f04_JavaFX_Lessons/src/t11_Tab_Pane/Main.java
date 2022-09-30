package t11_Tab_Pane;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Main extends Application {
	
		@Override 
	public void start(Stage primaryStage) {	
		
			// TabPane - контейнер для создания панели с вкладками (как картотека в библиотеке)
		Button btn1 = new Button("Button One");		Button btn2 = new Button("Button Two");		Button btn3 = new Button("Button Three");
		
			/* СОЗДАНИЕ TabPane
		Конструкторы:
		- TabPane () - создает пустой pane
		- TabPane (Tab...tabs)  				*/
		TabPane pane = new TabPane();
		
			// УСТАНОВКА РАЗМЕРОВ ЯРЛЫКА ВКЛАДКИ
		pane.setTabMinWidth(100);
		pane.setTabMinHeight(30);
		pane.setMaxWidth(100);
		pane.setMaxHeight(30);
			
			// УСТАНОВКА СТОРОНЫ НА КОТОРОЙ БУДУТ ОТОБРАЖАТЬсЯ ВКЛАДКИ
		pane.setSide(Side.TOP);
//		pane.setSide(Side.LEFT);
		
			// Если true, то узел, отображаемый слева от надписи, будет поворачиваться вместе с текстом надписи
		pane.setRotateGraphic(true);
				
			/* УСТАНОВКА ДОСТУПА К ЗАКРЫТИЮ ВКЛАДОК
		UNAVAILABLE - пользователь не может закрыть вкл
		SELECTED TAB - можно закрыть активную вкладку, если условие closable для этой вкладки имеет true (значение по умолчанию)
		ALL_TABS -  можно закрыть любую вкладку, если условие closable для этой вкладки имеет true (значение по умолчанию) 	 */
		pane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
//		pane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		
			/*  НАСТРОЙКА ПЕРЕТАСКИВАНИЯ ЯРЛЫКОВ ВКЛАДОК
		FIXED - ярлыки перетаскивать нельзя (значение по умолчанию)
		REORDER - пользователь может изменить порядок ярлыков вкладок 	 */
		pane.setTabDragPolicy(TabPane.TabDragPolicy.REORDER);
		
			/* СОЗДАНИЕ ВКЛАДОК И УСТАНОВКА ЗАГОЛОВКА И СОДЕРЖИМОГО ВКЛАДКИ
		Конструкторы класса Tab: 
		 - Tab()
		 - Tab(String text);
		 - Tab(String text, Node content);			*/
		Tab tab1 = new Tab();			
		Tab tab2 = new Tab("TAB2", new Label("Содержимое вкладки 2"));	   
		Tab tab3 = new Tab("TAB3", btn2);
		Tab tab4 = new Tab("TAB4", new Label("Содержимое вкладки 4"));
		
			// ТЕКСТ НАДПИСИ НА ЯРЛЫКЕ ВКЛАДКИ
		tab1.setText("TAB1");
		
			// УСТАНОВКА УЗЛА, РАСПОЛОЖЕННОГО СЛЕВА ОТ ТЕКСТА НАДПИСИ НА ЯРЛЫКЕ ВКЛАДКИ
		tab2.setGraphic(btn1);
		
			// УСТАНОВКА УЗЛА, ОТОБРАЖАЕМОГО НА ВКЛАДКЕ
		tab1.setContent(new Label("Содержимое вкладки 1"));
		
			/* БЛОКИРОВКА ЗАКРЫТИЯ ВКЛАДКИ
		По умолчанию вкладки можно закрыть через нажатия крестика на них.  При установке false вкладку закрыть нельзя  */
		tab1.setClosable(false);
		
			/*  НАЗНАЧЕНИЕ СОБЫТИЯ ПРИ ЗАКРЫТИИ ВКЛАДКИ			 */
		tab2.setOnClosed(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				System.out.println("ВЫ закрыли вкладку TAB2");
			}
		});
		
			/*  НАЗНАЧЕНИЕ СОБЫТИЯ ПРИ ЗАКРЫТИИ ВКЛАДКИ	БЕЗ ЕЕ ЗАКРЫТИЯ	 
		Если прописать consume, то событие будет обработано, но вкладка не закроется*/
		tab3.setOnCloseRequest(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				System.out.println("ВЫ пытались закрыть вкладку TAB3");
				event.consume();
			}
		});
			
			// СДЕЛАТЬ ВКЛАДКУ НЕАКТИВНОЙ
		tab4.setDisable(true);
		System.out.println("Вкладка TAB4 активна ? -  " + tab4.isDisable());
		
		pane.getTabs().add(tab1);
		pane.getTabs().add(tab2);
		pane.getTabs().add(tab3);
		pane.getTabs().add(tab4);
		
				// РАСТОЯНИЕ ОТ ГРАНИЦ PANE ДО УЗЛОВ
		pane.setPadding(new Insets(20, 20, 20, 20));	// Установлено растояния от края
		
		Scene scene = new Scene(pane, 600.0, 600.0); 
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("BorderPane");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
