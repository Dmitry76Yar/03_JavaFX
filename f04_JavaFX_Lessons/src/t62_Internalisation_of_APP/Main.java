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
//			/* ������������������� ����������
//		����� ���� ������ �������� �������������� ���������� ������, ����� ������� ���� � ����������� properties, 
//		������ ������� ��������� ����� �� ������ ������.
//		�������� ������ ������� �� ��������� ������
//			<�������� ����������>.properties					- ���� ���� ���-�� �� ���������, ��� ���������� ����� � ������ ������ 
//			<�������� ����������>_<����>.properties				- ���� ����� ��� ���������� �����
//			<�������� ����������>_<����>_<������>.properties	- ���� ��������� � ������, � ����
//				� ����� bundles ���������
//			MyApp.properties			- ���� ���� ���-�� �� ���������, ��� ���������� ����� � ������ ������ 
//			MyApp_en.properties			- ���� ����� ��� ���������� �����
//			MyApp_ru_RU.properties		- ���� ��������� � ������, � ���� */
//		
//			// �������� ����� MyApp_ru_RU.properties ����� ��� ���� 
//		FileOutputStream fout = null;
//		try {
//			fout = new FileOutputStream("C:\\Users\\dkuli\\Documents\\My_works\\f04_JavaFX_Lessons\\"
//					+ "src\\t62_Internalisation_of_APP\\bundles\\MyApp_ru_RU.properties");
//			Properties map = new Properties();
//			map.setProperty("btnExit", "�����");
//			map.setProperty("btnClose", "�������");
//			map.setProperty("menuFile", "_����");
//			map.setProperty("menuFileOpen", "_�������");
//			map.setProperty("windowTitle", "������������������� ����������");
//			map.store(fout, "");
//			fout.close();
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//			// �������� ����� MyApp_ru_RU.properties ����� ��� ����
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
//			// �������� ����� MyApp_ru_RU.properties ����� ��� ����
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
//			/* ��� ������������� ��������� ������ ������ ���������� ���-�� ����� ResourceBundle
//		������� ������� ������ ResourceBundle ����� � ������� ������������ ������ getBundle() � ���������
//		ResourceBundle getBundle(String baseName)
//		ResourceBundle getBundle (String baseName, Locale locale)
//			- � ������ ��������� ����������� �������� ���������� (� ����������� ��������)
//			- �� ������ ��������� �������� ������			 */
//		
//			// ����� ������ ������ ru_RU
//		ResourceBundle bundle = ResourceBundle.getBundle("t62_Internalisation_of_APP.bundles.MyApp", new Locale("ru", "RU"));
//			// ����� ������ ������ en
////		ResourceBundle bundle = ResourceBundle.getBundle("t62_Internalisation_of_APP.bundles.MyApp", new Locale("en", ""));
//			// ����� ������ ������ �� ���������
////		ResourceBundle bundle = ResourceBundle.getBundle("t62_Internalisation_of_APP.bundles.MyApp", new Locale("", ""));
//		
//			/* ������ ������ ��������� �� ����� �������� �������� �� �����.
//		��� ����� ������������ ����� getString(). ���� ���� �� ������ � ������, �� ������������ ����������	 */
//		Button btnClose = null;;
//		try {
//			btnClose = new Button(bundle.getString("btnClose"));
//		} catch (MissingResourceException e) {
//			System.out.println(e.toString());
//		}
//		Button btnExit = new Button(bundle.getString("btnExit"));
//		
//		/* ��� ������������� FXML ����� ����� �������� ������ �� ������ ResourceBuilder � ������� ������������
//		������ ��� ������ setResources() �� ������ FXMLLoader. 
//			ResourceBundle bundle = ResourceBundle.getBundle("t62_Internalisation_of_APP.bundles.MyApp", new Locale("ru", "RU"));
//			FXMLLoader loader = new FXMLLoader();
//			loader.serResources(bundle);
//			loader.setLocation(getClass().getResources("Sample.fxml"));
//		����� ����� ����� ������ ����� FXML ��������� �������� � ������� %<����>
//		��� �������� ����� ������������� ������������� � ������ � ������ �������� �������  ResourceBundle
//			<Button fx:id="btnExit" mnemonicParsing="false" text="%btnExit"/>
//			
//			���� �� ��������� ��������� Initializable, �� ������ ResourceBundle ����� �������� �� ������ ���������
//		@override
//		public void initialize (URL location, ResourceBundle resources) {
//		btnClose.setText(resources.getString("btnClose"));
//		
//			�������� � ����������
//		���� ������ ������ ����������� ����� ������ �� ������ ResourceBundle, �� ����� �������� �� ������������
//		������ ����������� � ��������� � ����
//			loader.setControllerFactory(new Callback<Class<?>, Object>() {
//				@override
//				public Object call (Class <?> param) {
//					return new SampleController(primaryStage, bundle);
//					}
//			});
//		������ ���������� ������������
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