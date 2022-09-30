package t03_Stage_Several_Windows;
	
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/* Наследование: Object - Window - Stage
   Параметром метода start() яв-cя объект Stage - это oсновa для создания графического интерфейса 
			   По сути он является контейнером, в который помещаются все остальные компоненты интерфейса. 
			   На десктопах это будет отдельное графическое окно, а на мобильных устройствах интерфейс - весь экран устройства
			   В программе на JavaFX можно использовать множество объектов Stage, но один из них является основным.
			   При создании JavaFX, основной primary stage создается автоматически. Ссылка на этот объект передается в метод старт. 
							@Override 
							public void start(Stage primaryStage) 	{		}
			   Stage primaryStage определяет главное окно или экран программы. Однако внутри приложения мы также можем создавать
			   другие объекты Stage - другие графические окна
		   Stage позволяет управлять позиционированием, размерами и некоторыми другими настройками окна приложения. Рассмотрим 
		   некоторые основные методы класса Stage
 */

public class Main extends Application {
	Button btn;
		@Override 
	public void start(Stage primaryStage) {			
		btn = new Button();							
		btn.setText("Открыть другое окно!");
		btn.setOnAction(event -> {
			newWindow(primaryStage, Modality.APPLICATION_MODAL);
		});
		BorderPane pane = new BorderPane();			
		pane.setCenter(btn);						
		Scene scene = new Scene(pane, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TITLE OF STAGE");
		primaryStage.show();
	}
		
	public void newWindow (Stage parent, Modality modality) {
		Stage window = new  Stage(StageStyle.UTILITY);	// Создание окна
			/* МОДАЛЬНЫЕ ОКНА
		 Пока модальное окно не будет закрыто, сделать активным другое окно нельзя.
		 primaryStage.initModality(Modality modality) - устанавливает модальность окна    Должен вызываться до вызова метода show()
        Модальность может быть:  
         - Modality.NONE  				- окно не является модальным
         - Modality.APPLICATION_MODAL	- модальное окно блокирует все окна
         - Modality.WINDOW_MODAL  	 	- окно блокирует только родительские окна в пределах иерархии
         	  При его использовании необходимо указать ссылку на родительское окно с помощью метода initOwner(Window owner)
         primaryStage.getModality() 	- возвращает модальность окна 	 */
		window.setTitle("NEW WINDOW");
		window.initModality(modality);
		window.initOwner(parent);
		
		BorderPane pane = new BorderPane();
		Button btn = new Button("Закрыть окно");
		pane.setCenter(btn);
		btn.setOnAction(event -> {
			window.close();
		});
		window.setScene(new Scene(pane, 200,200));
		window.show();
				/* Конструктор Stage(StageStyle) - можно выбрать вариант стиля окна
		- DECORATED - по умолчанию. Окно белого цвета с рамкой, заголовком и кнопки Свернуть, Развернуть и Закрыть и значок в левом верхнем углу,
		при нажатии	на который отображается меню окна Свернуть, Развернуть и Закрыть. Размеры окна меняются 
		- UNDECORATED -  DECORATED, но без рамки и заголовка. Размеры окна не меняются
		- TRANSPARENT - прозрачное окно без рамки и заголовка. Размеры окна не меняются
		- UTILITY -  DECORATED, но с единственным выбором ЗАКРЫТЬ (нет кнопки Свернуть, Развернуть и значок в левом верхнем углу)
		- UNIFIED - DECORATED, но внутренняя граница рамки не выделяется	 */
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
