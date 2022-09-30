package t64_Start_window_during_appLoading1;
	
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/* 		Операции, происходящие после запуска приложение и до его показа на экране   (https://docs.oracle.com/javafx/2/deployment/deploy_user_experience.htm#BABFIECI)
 	- фаза №1: Инициализация JavaFX Runtime и начальная проверка определяет компоненты, которые должны быть загружены.
 	- фаза №2: Требуемые ресурсы загружаются или из сети, или из из кэша диска, происходит процесс валидации
 	- фаза №3: Приложение запускается, но может потребоваться загрузка дополнительных ресурсов или выполнить преобразования,
 	чтобы приложение стало полностью функциональным 
 	- фаза №4: Приложение отображается  
 	
  			СОЗДАНИЕ СТАРТОВОГО ОКНА ЗАГРУЗКИ через класс PreLoader
	Во время фазы №2 загрузки приложения запускается preloader application - или preloader по умолчанию, или переопределенный программистом
	Preloader позволяет:
	- показать контент на окно загрузки, например, статус загрузки, чтобы пользователь видел прогресс и не думал, что 
	приложение зависло. 
	- показать сообщения пользователю о том, что он должен сделать дальше, например, какие разрешения от него потребуются.
	
 		Нужно наследовать класс Preloader и внутри метода start() создать окно с заставкой
 	Наследование Object - Application - Preloader
 	Можно полностью контролировать процесс загрузки, переопределив методы ниже класса Preloader
 	- publiс void handleProgressNotification (ProgressNotification info)  - для отображения прогресса загрузки
 	- public void handleStateChangeNotification(StateChangeNotification info)
 	- public void handleErrorNotification(ErrorNotification info)
 	- public void handleApplicationNotification(PreloaderNotification info)	
 		Также с помощью метода public final void notifyPreloader(PreloaderNotification info) из класса Application можно передавать 
 	данные методу handleApplicationNotification	oбъекта Preloader, сообщая о процессе загрузки.
 	
 	 
 	
 */

public class Main extends Application {
	@Override
    public void start(Stage stage) throws Exception {
		
		VBox root = new VBox(5.0, new Button("Нажми меня"));
		root.setAlignment(Pos.CENTER);
		Thread.sleep(5000);						// Имитация длительной загрузки
		
		System.out.println(" Метод start из Main запущен ");
		Scene scene = new Scene(root, 400, 200);
		stage.setTitle("Настройка запуска приложения");
		stage.setScene(scene);
		stage.show();
		
//		this.notifyPreloader(new Preloader.StateChangeNotification(null));
		
	}
	
	public static void main(String[] args) {
			/* Чтобы сообщить приложению об окне с заставкой, нужно создать свойство с названием javafx.preloader и присвоить ему
	полное имя класса, наследующего класс Preloader. Далее передать статическому методу launch() из класса Application ссылку на
	класс с основным приложением и параметры, переданные в командной строке
	Форматы метода launch
	 	- public statiс void launch(Class<? extends Application> appClass, String ....args)		 - нужный нам формат
	 	- public statiс void launch(String ....args)		 - стандартный формат			 	 */	
	
	System.setProperty("javafx.preloader", "t64_Start_window_during_appLoading1.MyPreloader");
	Application.launch(Main.class, args);
}

    
}