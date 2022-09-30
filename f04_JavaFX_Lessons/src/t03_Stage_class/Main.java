package t03_Stage_class;
	
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.RadialGradient;

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
		btn.setText("Click me please!");			
		BorderPane pane = new BorderPane();			
		pane.setCenter(btn);						
		Scene scene = new Scene(pane, 300, 250);
		/* Для большинства (если не всех) приложений только 3 метода используются
		 - setScene()    - каждая stage должна иметь scene
		 - setTtitle     - название окна
		 - show() 
		 	Другие методы позволяют менять внешний вид и поведение окна, если настройки по умолчанию не устраивают		 
		 Например, ниже устанавливается ограничение размера окна при его растягивании */
		
		 primaryStage.setScene(scene);
		 primaryStage.setTitle("TITLE OF STAGE");
		 primaryStage.setHeight(300);
		 primaryStage.setWidth(300);
		 
		 	/* РЕГУЛИРОВКА РАЗМЕРА ОКНА
		 primaryStage.setWidth(100)			- устанавливает ширину окна
		 primaryStage.setHeight(100)  		- устанавливает высоту окна
		 primaryStage.setMinWidth(200);		- устанавливает минимальную ширину окна (до которой можно сузить при растягивании) Default - 0
		 primaryStage.setMinHeight(200);	- устанавливает минимальную высоту окна (до которой можно сузить при растягивании) Default - 0
		 primaryStage.setMaxWidth(600);		- устанавливает максимальную ширину окна (до которой можно растянуть) Default - Double.MAX_VALUE
		 primaryStage.setMaxHeight(600);	- устанавливает максимальную высоту окна (до которой можно растянуть) Default - Double.MAX_VALUE
		 primaryStage.sizeToScene() 		- устанавливает размеры окна в соответствии с размерами содержимого объекта Scene
         primaryStage.setFullScreen(false)   - при передаче значения true окно раскрывается на весь экран. Для выхода ESC
		 primaryStage.setMaximized(false);	 - аналогично setFullScreen(), но показываются декорации (границы, название...)
		 primaryStage.setIconified(true)	 - при передаче значения true окно сворачивается
		 primaryStage.setResizable(true);     - при false окно нельзя растянуть
		   Аналогичные методы get..() используются для получения соответствующей информации */
		 
		 	/* ПОЗИЦИОНИРОВАНИЕ ОКНА НА ЭКРАНЕ ПО ЛЕВОМУ ВЕРХНЕМУ УГЛУ
		primaryStage.setX(111)			- устанавливает местоположение левого верхнего угла по оси Х
		primaryStage.setY(111)			- устанавливает местоположение левого верхнего угла по оси Y
		primaryStage.getX()				- возвращает местоположение левого верхнего угла по оси Х
		primaryStage.getY()				- возвращает местоположение левого верхнего угла по оси Y
		 Начало координат находится в левом верхнем углу экрана.  Положительная ось Х направлена вправо, положительная ось У - вниз
		primaryStage.centerOnScreen();	- располагает окно в центре экрана   */
		 
		 	/* ПОЗИЦИОНИРОВАНИЕ ОКНА НА ЭКРАНЕ ПО ОСТАЛЬНЫМ УГЛАМ
		Сначала нужно узнать минимальные или максимальные координаты Х и Y экрана, чтобы определить необходимый угол экрана
		Для этого используется класс SCREEN и его статические методы      import javafx.stage.Screen;
		Screen.getPrimary() 					- возвращает ссылку на основной экран
		Screen.getScreens()						- возвращает ссылку на основной экран в формате списка ObvervableList<Screen>
		Screen.getPrimary().getDpi() 			- возвращает разрешение основного экрана
		Screen.getPrimary().getBounds() 		- возвращает объект Rectangle2D с характистиками всего экрана
		Screen.getPrimary().getVisualBounds()  - возвращает объект Rectangle2D с характистиками всего экрана без панели задач 	 */
		Rectangle2D bounds = Screen.getPrimary().getBounds();
		System.out.println("Минимальняа коордианат X -" + bounds.getMinX());
		
			// ОТСЛЕЖИВАНИЕ ПЕРЕМЕЩЕНИЯ И РАСТЯГИВАНИЯ ОКНА
		 primaryStage.xProperty().addListener((obj, oldValue, newValue) -> {
			 System.out.println("Координата Х изменилась с " + oldValue + " на " + newValue);
			 });
		 primaryStage.widthProperty().addListener((obj, oldValue, newValue) -> {
			 System.out.println("Ширина изменилась с " + oldValue + " на " + newValue);
			 });
		
			/* УПРАВЛЕНИЕ ФОКУСОМ ОКНА
		Иногда бывает удобно после соверщение какого-либо действия передать фокус другому окну, чтобы она оказалось сверху всех окон
		primaryStage.setAlwaysOnTop(true)	- при передаче значения true окно будет всегда располагаться поверх других окон
		primaryStage.toBack();				- перемещает окно на задний план
		primaryStage.toFront();				- перемещает окно на передний план */
		 
		 	/* ПРОЗРАЧНОСТЬ
		primaryStage.setOpacity(double value)	: устанавливает прозрачность
		primaryStage.getOpacity()				: возвращает значение прозрачности
		 	
		 	/* МОДАЛЬНЫЕ ОКНА
		 Пока модальное окно не будет закрыто, сделать активным другое окно нельзя.
		 primaryStage.initModality(Modality modality) - устанавливает модальность окна    Должен вызываться до вызова метода show()
         Модальность может быть:  
          - Modality.NONE  				- окно не является модальным
          - Modality.APPLICATION_MODAL	- модальное окно блокирует все окна
          - Modality.WINDOW_MODAL  	 	- окно блокирует только родительские окна в пределах иерархии
          	  При его использовании необходимо указать ссылку на родительское окно с помощью метода initOwner(Window owner)
          primaryStage.getModality() 	- возвращает модальность окна 
          Метод getOwner(): возвращает родительское окно в виде объекта Window, которое владеет текущим окном
	      Window wind = primaryStage.getOwner();
          */

			/* Метод initStyle(StageStyle.UTILITY) - изменяет стиль окна из вариантов ниже 
		- DECORATED - по умолчанию. Окно белого цвета с рамкой, заголовком и кнопки Свернуть, Развернуть и Закрыть и значок в левом верхнем углу,
		при нажатии	на который отображается меню окна Свернуть, Развернуть и Закрыть. Размеры окна меняются 
		- UNDECORATED -  DECORATED, но без рамки и заголовка. Размеры окна не меняются
		- TRANSPARENT - прозрачное окно без рамки и заголовка. Размеры окна не меняются
		- UTILITY -  DECORATED, но с единственным выбором ЗАКРЫТЬ (нет кнопки Свернуть, Развернуть и значок в левом верхнем углу)
		- UNIFIED - DECORATED, но внутренняя граница рамки не выделяется
		primaryStage.initStyle(): возвращает стиль окна	 */
		primaryStage.initStyle(StageStyle.DECORATED);
		
				/* СМЕНА ЗНАЧКА ОКНА
		  Необходимо создать значок размеро 16х16 или 32х32 пкс и поместить его в формате PNG, BMP, JPEG, GIF и поместить его
		  в папку например src/img.   Получить путь к значку с помощью getResource() и передать путь в конструктор класса IMAGE
		  Вызвать метод getIcons() для объекта окна и добавить объект Image в список с помощью add()	 */
		try {
			primaryStage.getIcons().add(new Image(getClass().getResource("/img/icons.png").toExternalForm()));
		} catch (Exception e) {
			System.out.println("Не удалось загрузить значок");
		}
		
			// Метод show(): отображает окно		
		primaryStage.show();
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
