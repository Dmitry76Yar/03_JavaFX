package t54_ContextMenu;
	
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
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
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class Main extends Application {
	Stage stage;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
		
			/* ContextMenu реализует контекстное меню, отображаемое при щелчке правой кнопкой мыши в области компонента
		Наследование Object - Window - PopupWindow - PoupContol - ContextMenu	
			 Конструкторы
		ContextMenu()
		ContextMenu(MenuItems...items)  */
			
		MenuItem menuItem1 = new MenuItem("Пункт меню 1");
		MenuItem menuItem2 = new MenuItem("Пункт меню 2");
		MenuItem menuItem3 = new MenuItem("Пункт меню 3");
		
		ContextMenu contextMenu = new ContextMenu(menuItem1, menuItem2, menuItem3);
		
		Button btn50 = new Button("Меню при нажитии правой клавиши");
		btn50.setMaxWidth(70);
		btn50.setMinHeight(100);
		btn50.setWrapText(true);
		btn50.setTextAlignment(TextAlignment.CENTER);
		btn50.setContextMenu(contextMenu);
		
			/* Событие контекстного меню    Класс ContextMenuEvent
		Когда пользователь запрашивает контекстное меню через правую клавишу мыши, генерируется событие CONTEXT_MENU_REQUESTED из 
		класса ContextMenuEvent  		
		Наследование Object - EventObject - Event - InputEvent - ContextMenuEvent */
		
		btn50.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			System.out.println("ContextMenuEvent");
		});
		
		
		
		
		HBox hb = new HBox();
		hb.getChildren().addAll(btn50);
		
		Scene scene = new Scene(hb, 800,500 );
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}