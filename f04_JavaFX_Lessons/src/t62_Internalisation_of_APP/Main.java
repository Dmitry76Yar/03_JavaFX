package t62_Internalisation_of_APP;
	
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.*;

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) {
//		Label label = new Label("TEXT");
//		
//			/* ИНТЕРНАЦИОНАЛИЗАЦИЯ ПРИЛОЖЕНИЙ
//		Чтобы язык текста надписей соответствовал настройкам локали, нужно создать файл с расширением properties, 
//		внутри которых прописать текст на разных языках.
//		Название файлов состоят из следующих частей
//			<Название приложения>.properties					- этот файл исп-ся по умолчанию, при отсутствии файла с нужным языком 
//			<Название приложения>_<Язык>.properties				- файл общий для указанного языка
//			<Название приложения>_<Язык>_<Страна>.properties	- файл учитывает и страну, и язык
//				в папке bundles находятся
//			MyApp.properties			- этот файл исп-ся по умолчанию, при отсутствии файла с нужным языком 
//			MyApp_en.properties			- файл общий для указанного языка
//			MyApp_ru_RU.properties		- файл учитывает и страну, и язык */
//		
//			// Создание файла MyApp_ru_RU.properties через код ниже 
//		FileOutputStream fout = null;
//		try {
//			fout = new FileOutputStream("C:\\Users\\dkuli\\Documents\\My_works\\f04_JavaFX_Lessons\\"
//					+ "src\\t62_Internalisation_of_APP\\bundles\\MyApp_ru_RU.properties");
//			Properties map = new Properties();
//			map.setProperty("btnExit", "Выход");
//			map.setProperty("btnClose", "Закрыть");
//			map.setProperty("menuFile", "_Файл");
//			map.setProperty("menuFileOpen", "_Открыть");
//			map.setProperty("windowTitle", "Интернационализация приложения");
//			map.store(fout, "");
//			fout.close();
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//			// Создание файла MyApp_ru_RU.properties через код ниже
//		try {
//			fout = new FileOutputStream("C:\\Users\\dkuli\\Documents\\My_works\\f04_JavaFX_Lessons\\"
//					+ "src\\t62_Internalisation_of_APP\\bundles\\MyApp_en.properties");
//			Properties map = new Properties();
//			map.setProperty("btnExit", "Exit_EN");
//			map.setProperty("btnClose", "Close_EN");
//			map.setProperty("menuFile", "_File_EN");
//			map.setProperty("menuFileOpen", "_Open_EN");
//			map.setProperty("windowTitle", "Internationalisation of app_EN");
//			map.store(fout, "");
//			fout.close();
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
//			// Создание файла MyApp_ru_RU.properties через код ниже
//		try {
//			fout = new FileOutputStream("C:\\Users\\dkuli\\Documents\\My_works\\f04_JavaFX_Lessons\\"
//					+ "src\\t62_Internalisation_of_APP\\bundles\\MyApp.properties");
//			Properties map = new Properties();
//			map.setProperty("btnExit", "Exit_DEFAULT");
//			map.setProperty("btnClose", "Close_DEFAULT");
//			map.setProperty("menuFile", "_File_DEFAULT");
//			map.setProperty("menuFileOpen", "_Open_DEFAULT");
//			map.setProperty("windowTitle", "Internationalisation of app_DEFAULT");
//			map.store(fout, "");
//			fout.close();
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//			/* Для использования созданных файлов внутри приложения исп-ся класс ResourceBundle
//		Создать объекта класса ResourceBundle можно с помощью статического метода getBundle() с фоорматом
//		ResourceBundle getBundle(String baseName)
//		ResourceBundle getBundle (String baseName, Locale locale)
//			- в первом параметре указывается название приложения (с добавлением каталога)
//			- во втором параметре задается локаль			 */
//		
//			// Чтобы задать локаль ru_RU
//		ResourceBundle bundle = ResourceBundle.getBundle("t62_Internalisation_of_APP.bundles.MyApp", new Locale("ru", "RU"));
//			// Чтобы задать локаль en
////		ResourceBundle bundle = ResourceBundle.getBundle("t62_Internalisation_of_APP.bundles.MyApp", new Locale("en", ""));
//			// Чтобы задать локаль по умолчанию
////		ResourceBundle bundle = ResourceBundle.getBundle("t62_Internalisation_of_APP.bundles.MyApp", new Locale("", ""));
//		
//			/* Теперь внутри программы мы можем получить значение по ключу.
//		Для этого используется метод getString(). Если ключ не найден в файлах, то генерируется исключение	 */
//		Button btnClose = null;;
//		try {
//			btnClose = new Button(bundle.getString("btnClose"));
//		} catch (MissingResourceException e) {
//			System.out.println(e.toString());
//		}
//		Button btnExit = new Button(bundle.getString("btnExit"));
//		
//		/* При использовании FXML файла нужно передать ссылку на объект ResourceBuilder с помощью конструктора
//		класса или метода setResources() из класса FXMLLoader. 
//			ResourceBundle bundle = ResourceBundle.getBundle("t62_Internalisation_of_APP.bundles.MyApp", new Locale("ru", "RU"));
//			FXMLLoader loader = new FXMLLoader();
//			loader.serResources(bundle);
//			loader.setLocation(getClass().getResources("Sample.fxml"));
//		После этого можно внутри файла FXML указывать значения в формате %<Ключ>
//		Эти значения будут автоматически преобразованы в строки с учетом настроек объекта  ResourceBundle
//			<Button fx:id="btnExit" mnemonicParsing="false" text="%btnExit"/>
//			
//			Если мы реализуем интерфейс Initializable, то объект ResourceBundle будет доступен во втором параметре
//		@override
//		public void initialize (URL location, ResourceBundle resources) {
//		btnClose.setText(resources.getString("btnClose"));
//		
//			ПЕРЕДАЧА В КОНТРОЛЛЕР
//		Если внутри класса контроллера нужно ссылка на объект ResourceBundle, то можно передать ее конструктору
//		класса контроллера и сохранить в поле
//			loader.setControllerFactory(new Callback<Class<?>, Object>() {
//				@override
//				public Object call (Class <?> param) {
//					return new SampleController(primaryStage, bundle);
//					}
//			});
//		Пример реализации конструктора
//			// private Stage window
//			// private ResourceBundle bundle;
//			public SampleController(Stage window, ResourceBundle bundle) {
//				this.bundle = bundle;
//				this.window = window;
//			}
//		 */
		
		BorderPane grid = new BorderPane();
//		MenuBar menuBar = new MenuBar();
//		Menu menu = new Menu("MENU");
//		MenuItem menuFile = new MenuItem(bundle.getString("menuFile"));
//		MenuItem menuFileOpen = new MenuItem(bundle.getString("menuFileOpen"));
//		menu.getItems().addAll(menuFile, menuFileOpen);
//		menuBar.getMenus().add(menu);
//		grid.setTop(menuBar);
//		
//		HBox hbox = new HBox(btnClose, btnExit);
//		hbox.setSpacing(20);
//		hbox.setAlignment(Pos.CENTER);
//		hbox.setPadding(new Insets(10));
//		grid.setCenter(hbox);

		Scene scene = new Scene(grid, 1000, 400);
		primaryStage.setScene(scene);
//		primaryStage.setTitle(bundle.getString("windowTitle"));
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}