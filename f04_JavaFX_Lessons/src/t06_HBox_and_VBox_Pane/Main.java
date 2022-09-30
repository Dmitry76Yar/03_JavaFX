package t06_HBox_and_VBox_Pane;
	
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.*;

/* Panes - это специальные классы, целью которых является организация Nodes на сцене. 
 * Наследование: Object - Node - Parent - Region - Pane - HBox
 * Каждый тип Panes имеет свой контроль расположений.    Основные классы:
    - HBox: распологает Nodes горизонтально рядом друг с другом - по сути в строку 
    - VBox: распологает Nodes вертикально рядом друг с другом - по сути в столбец
    - FlowPane: распологает Nodes рядом друг с другом до тех пор пока не закончится место, затем it wraps to continue layout nodes. 
                Можно сконфигирурировать FlowPane для горизонтального и вертикального расположения Nodes 
    - Border: разделяет pane на 5 областей: Top, Left, Center, Right, and Bottom.  При добавлении node нужно указать область
    - GridPane: разделяет pane на сетку, позволяующую контролировать расположение элементов по строкам и столбцам 
    
    Можно комбинировать panes для создания более сложных pane. Например, чтобы создать pane c горизонтальной строкой внизу и вертикальным 
    столбцом кнопок справа, можно создать Border Pane  и добавит HBox в нижнюю область и VBox в правую область. 
    Это возможно, т.к. все Pane наследуют javafx.scene.layout.Pane, который в свою очередь наследует класс javafx.scene.Node. 
    То есть все Pane также являются Nodes.   */

public class Main extends Application {
	int iClickCount = 0;
	
		@Override 
	public void start(Stage primaryStage) {	
							// ПРИМЕРЫ НИЖЕ ДЛЯ HBOX    ДЛЯ VBOX ВСЕ МЕТОДЫ АНАЛОГИЧНЫ
			/* Конструктор
			HBox() - создает пустой HBox
			HBox(double spacing) - создает пустой HBox с указанным растоянием между элементами
			HBox(Node... children) - создает HBox с указанными в параметрах child nodes (в любом количестве, через запятую)
			HBox(double spacing, Node... children) - - создает HBox с указанными в параметрах child nodes с указанным растоянием между элементами 			 */
		Button btn1 = new Button("Button One");
		Button btn2 = new Button("Button Two");
		Button btn3 = new Button("Button Three");
		
			// Добавление nodes через конструктор
		HBox hbox = new HBox(10.0, btn1, btn2, btn3);
			
			// Разделение элементов линией
		Separator separator2 = new Separator(Orientation.VERTICAL);
		
			// Добавление nodes через метод getChildren().addAll
		/* Метод ObservableList<Node> getChildren() - возвращает коллекцию всех Nodes, которые ранее были добавлены в HBOX
		 Коллекция возвращает объект класса ObservableList, который позволяет добавить один или больше Nodes еще в этот список */
//		hbox.getChildren().addAll(btn1, btn2, btn3);
		
			/* ЗАПОЛНЕНИЕ ВСЕГО ПРОСТРАНСТВА ПО ВЕРТИКАЛИ
	    При использовании SceneBuilder значение задается на вкладке Layout в разделе Specific (флажок Fill Height) */
		hbox.setFillHeight(true);
		
			/* РЕГУЛИРОВКА РАЗМЕРА ОКНА
		 hbox.setPrefWidth(100)				- устанавливает предпочтительную ширину окна
		 hbox.setPrefHeight(100)			- устанавливает предпочтительную высоту окна
		 hbox.setPrefSize(100,100)			- устанавливает предпочтительную высоту и ширину окна
		 hbox.setMinWidth(100)				- устанавливает минимальную ширину окна
		 hbox.setMinHeight(100)				- устанавливает минимальную высоту окна
		 hbox.setMinSize(100,100)			- устанавливает минимальную высоту и ширину окна
		 hbox.setMaxWidth(100)				- устанавливает максимальную ширину окна
		 hbox.setMaxHeight(100)				- устанавливает максимальную высоту окна
		 hbox.setMaxSize(100,100)			- устанавливает максимальную высоту и ширину окна
		   Аналогичные методы get..() используются для получения соответствующей информации */
		
			/* ЗАДАНИЯ РАСТОЯНИЯ МЕЖДУ NODES B PANE              Метод void setSpacing (double value)
		 1-ый вариант через констуктор HBox(double spacing, Node... children) 
		 2-ой вариант через 
				 Метод void setSpacing (double value) - создает растояние между nodes внутри HBox  
		При использовании Scene Builder растояния между узлами задаются во вкладке Layout в разделе Internal (параметр Spacing) 	 */
		hbox.setSpacing(20);
		
			/* ЗАДАНИЯ РАСТОЯНИЯ МЕЖДУ NODES И КРАЯМИ PANE
		Оба метода выше зададут только растояние между nodes, но растояние от левого, правого и верхнего краев будет равно ноль
		Для задания растояния от краев pane нужно использовать 
		 	МЕТОД void setPadding (Insets value) 
		Этот метод принимает в качестве параметр объект класса Insets, который отражает размер растояния от краев в пикселях.
		Объект Insets можно создать через конструкторы ниже:
		   - Insets(double value) - создает Insets объект, который использует одинаковые поля для top, right, bottom, and left 
		   - Insets(double top, double right, double bottom, double left) - создает Insets object с заданными полями для top, right, bottom, and left
		При использовании Scene Builder отступы задаются во вкладке Layout в разделе Internal (параметр Padding)
		  */
		hbox.setPadding(new Insets(20, 10, 20, 10));
		
			/*ЗАДАНИЯ РАСТОЯНИЯ МЕЖДУ NODES B PANE ЧЕРЕЗ СОЗДАНИЕ ПОЛЕЙ (Margins) через 
			 МЕТОД static void setMargin(Node child, Insets value) - задает поля/края для заданного node.
		 В качестве параметров метод принимает node, для которого нужно задать поля, и объект класса Insets, который 
		 отражает размер растояния  в пикселях. 
		 Объект Insets можно создать через конструкторы ниже:
		   - Insets(double value) - создает Insets объект, который использует одинаковые поля для top, right, bottom, and left 
		   - Insets(double top, double right, double bottom, double left) - создает Insets object с заданными полями для top, right, bottom, and left
		 Методя является статичными, поэтому правильнее вызывать его для класса HBox, но не для объекта hbox, хотя  HBox.setMargin() = hbox.setMargin()
		 Важно, что методы margins, spacing и padding могут работать вместе. Поэтому, если создать margin = 5пкс для всех сторон для кнопки,
		 и добавить в pane с spacing = 10 пкс и с padding = 10 пкс, то кнопки будут разделены друг от друга на растояние 20 пкс и от края на 15 пкс
		 При использовании Scene Builder отступы задаются во вкладке Layout в разделе HBOX constraints (параметр Margin)   */
		HBox.setMargin(btn1, new Insets(40));
		HBox.setMargin(btn2, new Insets(10, 15, 20, 10));
		
			/*ЗАДАНИЯ РАСТОЯНИЯ МЕЖДУ NODES B PANE ЧЕРЕЗ СОЗДАНИЕ ПУСТЫХ NODE, ЦЕЛЬ КОТОРЫХ ИМЕННО ЗАДАТЬ РАСТОЯНИЕ
		Затем можно отрегулировать эти spacer node, чтобы они автоматически заполняли все свободное пространство pane.
		Например, нужно создать HBox с 3-мя кнопками и нужно, чтобы первые 2 кнопки были с левого края и третья кнопка около правого края
		В этом случае нужно создать spacer node между 2-ой и 3-ей кнопками для заполнения всего оставшегося пространства. 
		ВАЖНО, что при растягивания окна приложения растояние будет также увеличиваться, но расположение кнопок при это останется желаемым.
		Самый простой способ создания spacer node - применение Region class - это базовый класс и для класса Control, из котрого 
		наследуются Button и Label, и для класса Pane, из которого наследуются все Pane. */
			// Create the spacer
		Region spacer = new Region();
		
			/* НАСТРОЙКИ РАСТЯГИВАНИЯ   метод setHgrow(Node child, Priority priority)
	    Если нужно, чтобы при растягивания окна, какой-либо узел занимал всю площадь, то нужно назначить для него приоритет с помощью
	метода setHgrow() и дополнительно рекомендуется прописать для этого узла команду node.setMaxWidth(Double.MAX_VAlUE)	
 		Список Priority enumeration:
	 - Priority.NEVER - показывает, что ширина node никогда не должна корректироваться для заполнения всего доспупного пространства
	pane. Это настройка по умолчанию, поэтому nodes не изменяются при изменение размера pane, содежащего их.
	 - Priority.ALWAYS  -  ширина  всегда меняется. Если 2 и более узла имеют такой приоритет, то они делят влощадь поровну
	 - Priority.SOMETIMES  - ширина узла меняется, только если нет других узлов с приоритетом ALWAYS.
	Метод является статичным, поэтому правильнее вызывать его для класса HBox, но не для объекта hbox, хотя  HBox.setMargin() = hbox.setMargin() 
	При использовании Scene Builder значение задается во вкладке Layout в разделе HBOX Constraints (список Hgrow)
	*/
		HBox hbox2 = new HBox(10.0, btn1, btn2, spacer, btn3);
		HBox.setHgrow(spacer, Priority.ALWAYS);
			 
			/*  МЕСТОПОЛОЖЕНИЕ НА СЦЕНЕ С ПОМОЩЬЮ КООРДИНАТ
		Если мы не используем контейнеры, содержащие менеджер компоновки (например, Pane) нужно указать местоположение узла вручную, иначе
		они все будут расположены друг на друге в левом верхнем угле
		button1.setLayoutX(111)			- задает координату по оси Х относительно левого верхнего угла контейнера
		button1.setLayoutY(111)			- задает координату по оси Y относительно левого верхнего угла контейнера
		button1.relocate(111,111)		- задает координату по оси Х и по оси Y относительно левого верхнего угла контейнера 
		В SceneBulider координаты задается на вкладке Layout в разделе Position (поля Layout X, Layout Y)
		Аналогичные методы get() позволяеют получать информацию
		button1.layoutXProperty() 		- ссылка на свойства, показывающую координату по оси Х
		button1.layoutYProperty() 		- ссылка на свойства, показывающую координату по оси Y
			ОТСЛЕЖИВАНИЕ ПЕРЕМЕЩЕНИЯ 
		button1.layoutXProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Изменение Х" + newValue);
		});		*/
		
			/* СМЕЩЕНИЕ ПО КООРДИНАТАМ (удобно для анимации)
		Важно, что при смещении исходные коордианты сохраняются и при введении button1.setLayoutX(0) возвращает снова в исходное положение
		button1.setLayoutX(100) 		- смещает по оси Х относительно исходной точки на оси Х
		button1.setLayoutY(100) 		- смещает по оси Y относительно исходной точки на оси Х
		button1.getLayoutX() 			- возвращает смещение по оси Х относительно исходной точки на оси Х
		button1.getLayoutY() 			- возвращает смещение по оси Y относительно исходной точки на оси Х
		В SceneBulider смещение задается на вкладке Layout в разделе Transform (поля Translate X, Translate Y) */
		
			/* МЕСТОПОЛОЖЕНИЕ НА СЦЕНЫ С ПОМОЩЬЮ КОНТЕЙНЕРОВ
			 МЕТОД static void setAlignment(Pos alignment) - упорядачивает все элементы внутри HBox.
		Метод принимает один аргумент, который яв-ся константой в Pos enumeration (определена в javafx.geometry package)
		При использовании Scene Builder значение задается во вкладке Properties в разделе Node (параметр Aligment)
			Pos enumeration:
		Pos.TOP_LEFT 		Vertical Alignment	Top 		Horizontal Alignment Left
		Pos.TOP_CENTER 		Vertical Alignment Top 			Horizontal Alignment Center
		Pos.TOP_RIGHT 		Vertical Alignment Top 			Horizontal Alignment Right
		Pos.CENTER_LEFT 	Vertical Alignment Center 		Horizontal Alignment Left
		Pos.CENTER 			Vertical Alignment Center 		Horizontal Alignment Center
		Pos.CENTER_RIGHT 	Vertical Alignment Center 		Horizontal Alignment Right
		Pos.BOTTOM_LEFT 	Vertical Alignment Bottom 		Horizontal Alignment Left
		Pos.BOTTOM_CENTER 	Vertical Alignment Bottom 		Horizontal Alignment Center
		Pos.BOTTOM_RIGHT 	Vertical Alignment Bottom 		Horizontal Alignment Right
		Pos.BASELINE_LEFT 	Vertical Alignment Baseline		Horizontal Alignment Left
		Pos.BASELINE_CENTER Vertical Alignment Baseline 	Horizontal Alignment Center
		Pos.BASELINE_RIGHT  Vertical Alignment Baseline 	Horizontal Alignment Right
				Пример ниже показывает создание вертикального столбца с 3-мя кнопками, отцентрированными в pane:  */
		VBox vbox = new VBox(10, btn1, btn2, btn3);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER); 
		
			/* СОЗДАНИЕ NODES ОДИНАКОВОЙ ШИРИНЫ
		Это можно легко сделать через задание для каждой кнопки максимального размера через Double.MAX_VALUE.
		В этом случае все кнопки всегда займут всю ширину pane  */
		Button btn4 = new Button("Number One");
		Button btn5 = new Button("Two");
		Button btn6 = new Button("The Third Button");
		btn4.setMaxWidth(Double.MAX_VALUE);
		btn5.setMaxWidth(Double.MAX_VALUE);
		btn6.setMaxWidth(Double.MAX_VALUE);
		
		VBox vbox2 = new VBox(10, btn4, btn5, btn6); vbox2.setMinWidth(200);    vbox2.setMinHeight(200); 	vbox2.setPadding(new Insets(10));	vbox2.setAlignment(Pos.CENTER);
		Label lbl = new Label("LABEL");	lbl.setMinWidth(80);    lbl.setMinHeight(80);
		VBox vbox3 = new VBox(10, lbl); vbox3.setMinWidth(200);    vbox3.setMinHeight(200); 	vbox3.setPadding(new Insets(10));	vbox3.setAlignment(Pos.CENTER);
		VBox vbox4 = new VBox(10, lbl); vbox4.setMinWidth(200);    vbox4.setMinHeight(200); 	vbox4.setPadding(new Insets(10));	vbox4.setAlignment(Pos.CENTER);
		VBox vbox5 = new VBox(10, lbl); vbox5.setMinWidth(200);    vbox5.setMinHeight(200); 	vbox5.setPadding(new Insets(10));	vbox5.setAlignment(Pos.CENTER);
		VBox vbox6 = new VBox(10, lbl); vbox6.setMinWidth(200);    vbox6.setMinHeight(200); 	vbox6.setPadding(new Insets(10));	vbox6.setAlignment(Pos.CENTER);
		HBox root = new HBox(10, vbox2, separator2, vbox4, vbox5, vbox6);	root.setMinWidth(900);    root.setMinHeight(400); root.setPadding(new Insets(10));
		
			/* УСТАНОВКА ЦВЕТА ФОНА КОНТЕЙНЕРОВ И КОМПОНЕНТОВ
        Проще всего это сделать с помощью стиля -fx-background-color и метода  setStyle() 	 */
		vbox2.setStyle("-fx-background-color: green");
		
			/* УСТАНОВКА ЦВЕТА ФОНА КОНТЕЙНЕРОВ И КОМПОНЕНТОВ
		Также можно с помощью setBackground() - задает фон через параметр класса Background
		Конструкторы класса Background:
		 - Background(BackgroundFill...fills)		 - задает цвет заливки (или градиент). Можно указать несколько цветов через запятую, при 
		 			этом пооследующие цвета будет накладываться на предыдущие.		 			
		 - Background(BackgroundImage...images)
		 - Background(BackgroundFill[] fills, BackgroundImage...images)
		 - Background(List <BackgroundFill> fills, List<BackgroundImage> images)  */
		vbox3.setBackground(new Background(
			new BackgroundFill(Color.RED, null, null), 
			new BackgroundFill(Color.YELLOW, null, new Insets(20)),								// Insets(20) -поля 				
			new BackgroundFill(Color.ANTIQUEWHITE, new CornerRadii(10), new Insets(40))			// CornerRadii(10) - скругление углов
		));
			/* СКРУГЛЕНИЕ УГЛОВ ОКНА
		Радиус скругления задается с помощью класса CornerRadii
		Конструкторы класса CornerRadii:
		 - CornerRadii(double radius)						- задает радиус скругления одинаковый для всех угло 			
		 - CornerRadii(double radius, boolean asPercent)	- 
		 - CornerRadii(double topLeft, double topRight, double bottomRight, double bottomLeft, boolean asPercent) -все углы по отдельности
		 ..... */
				
			/* УСТАНОВКА ФОНОВОГО РИСУНКА
		с помощью конструктора Background(BackgroundImage...images) 
		Формат конструктора BackgroundImage: 
		BackgroundImage(Image im, BackgroundRepeat repeatX, BackgroundRepeat repeatY, BackgroundPosition position, BackgroundSize size)
		 , где repeatX и repeatY повторяемость фонового изображения во горизонтали и вертикали
		 
		BackgroundPosition position задает положение фонового рисунка с помощью класса BackgroundPosition, имеющего контруктор
		Конструктор - BackgroundPosition (Side horizontalSide, double horizontalPosition, boolean horizontalAsPercentage, 
										  Side verticalSide, double verticalPosition, boolean verticallAsPercentage)
		        - horizontalSide - может быть или LEFT, или RIGHT
		        - verticalSide - может быть или TOP, или BOTTOM
		        - horizontalPosition и verticalPosition - размеры отступа от выбранных выше границ
		        - horizontalAsPercentage и verticallAsPercentage - при true, отступы задаются в параметрах
		     Пример BackgroundPosition ss = new BackgroundPosition(Side.LEFT, 20, false, Side.BOTTOM, 10, false)
		     Для размещения в центре можно просто задать BackgroundPosition.CENTER, по умолчанию - BackgroundPosition.DEFAULT
		     
	    BackgroundSize size указывает, как должны меняться размеры фонового изображения при растягивании окна
	    Конструктор - BackgroundSize (double width, double height, boolean widthAsPercentage, boolean heightAsPercentage,
	    							  boolean contain, boolean cover)
	          - width, height - ширина и высота соответственно
	          - widthAsPercentage и heightAsPercentage - при true ширина и высота задается в процентах
	          - contain - при true при маштабирования сохраняется процентное соотношение сторон, чтобы занять всю ширину или высоту
	                      (что больше) области
	          - cover - при true при маштабирования сохраняется процентное соотношение сторон, чтобы занять всю ширину и высоту
	    Вместо создания объекта класса, можно просто задать  BackgroundSize.DEFAULT 	*/
		try {
			Image im = new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg"));
			vbox4.setBackground(new Background(new BackgroundImage(im, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, 
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		} catch (Exception e) {
			System.out.println("Не удалось загрузить рисунок");
		}
		
			/* УСТАНОВКА ФОНОВОГО РИСУНКА + ФОНОВОГО ИЗОБРАЖЕНИЯ
		с помощью конструктора Background(BackgroundFill[] fills, BackgroundImage...images) 
		Вначале выводятся сплошные цвета, а затем поверх цветов фоновые изображения*/
		try {
			Image im1= new Image(getClass().getResourceAsStream("/img/icons.png"));
			List<BackgroundFill> listFill = new ArrayList<BackgroundFill>();
			listFill.add(new BackgroundFill(Color.RED, null, null));
			listFill.add(new BackgroundFill(Color.GREEN, new CornerRadii(10), new Insets(10)));
			List<BackgroundImage> listImage = new ArrayList<BackgroundImage>();
			listImage.add(new BackgroundImage(im1, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, 
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
			vbox5.setBackground(new Background(listFill,listImage));
		} catch (Exception e) {
			System.out.println("Не удалось загрузить рисунок");
		}
		
			/* УСТАНОВКА РАМКИ
		Узел может иметь одну или несколько рамок.  Для их управления используются методы класса Region и метод setBorder()
		Конструкторы класса Border:
		 - Border(BorderStroke...strokes)	- задает сплошной цвет (или градиент) рамки. Можно указать несколько объектов через запятую,
		                        в этом случае рамки будут накладываться друг на друга
		 - Border(BorderImage...images)      - позволяет использовать изображения для рамки. Можно указать несколько объектов через запятую,
		                        в этом случае рамки будут накладываться друг на друга
		 - Border(BorderStroke[] strokes, BorderImage[] images) - и то, и то
		 - Border(List<BorderStroke> strokes, List<BorderImage> images)
		 
		 Конструкторы класса BorderStroke:
		  - BorderStroke(Paint Stroke, BorderStrokeStyle style, CornerRadii radii, BorderWidths widths)
		  - BorderStroke(Paint Stroke, BorderStrokeStyle style, CornerRadii radii, BorderWidths widths, Insets insets)
		  - BorderStroke(Paint topStroke, Paint rightStroke, Paint bottomStroke, Paint leftStroke, BorderStrokeStyle topStyle,
		        BorderStrokeStyle rightStyle, BorderStrokeStyle bottomStyle, BorderStrokeStyle leftStyle, CornerRadii radii,
		        BorderWidths widths, Insets insets)
		  Параметр style задает стиль, можно создать объект класса BorderStrokeStyle или выбрать из вараинтов: BorderStrokeStyle.NONE,
	    BorderStrokeStyle.SOLID, BorderStrokeStyle.DASHED, BorderStrokeStyle.DOTTED 
		  Параметр widths задает толщину через объект класса BorderWidths  */
		BorderStroke brs = new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3.0), new Insets(10));
		vbox6.setBorder(new Border(brs));
		
			/* ПРОЗРАЧНОСТЬ 
	     В SceneBuilder степень прозрачности задается на вкладке Properties в разделе Node (параметр Opacity) */
		vbox6.setOpacity(50);
		
			/* ВИДИМОСТЬ 
	     В SceneBuilder степень прозрачности задается на вкладке Properties в разделе Node (параметр Opacity) 
	      - setVisible() - делаем объект невидимым при false
	      - isVisible()  - true, если узел видимый
	     В SceneBuilder значение видимости узла задается на вкладке Properties в разделе Node (флажок Visible) */
		vbox6.setVisible(true);
		
			/* ИЗМЕНЕНИЕ ДОСТУПНОСТИ УЗЛА
		 Иногда нужно сделать, чтобы некоторые или все узлы были недоступными. Например, при нажатии кнопки осуществлеяется долгая
		 операция и чтобы юзер не нажимал повторно на кнопку нужно сделать ее недоступной.
		  - setDisable() - при true, узел станет недоступным
		  - isDisable() - true, если для узла установлен статус недоступности. Если сделать недоступным контейнер, то все узлы станут
		    недоступными, однако статус недосутпости для конкретного узла изменен не будет.  
		  - isDisabled() - true, если узел недоступен
		  В SceneBuilder значение доступности задается на вкладке Properties в разделе Node (флажок Disable)
		  			 */
		
//		Scene scene = new Scene(hbox, 500, 500);	 // Показывает работу spacing и marging
//		Scene scene = new Scene(hbox2, 500, 500);    // Показывает работу пустой space node между 2-ой и 3-ей кнопками
//		Scene scene = new Scene(vbox, 200, 500);     // Показывает работу setAlignment(Pos alignment)
		Scene scene = new Scene(root, 1200, 500, Color.BEIGE);     // Показывает СОЗДАНИЕ NODES ОДИНАКОВОЙ ШИРИНЫ
//		scene.getStylesheets.add("-fx-background-color: black");
//		
//		Override public void start(Stage stage) {
//	         Scene scene = new Scene(new Group());
//	         scene.getStylesheets().add("/com/example/javafx/app/mystyles.css");
//	         stage.setScene(scene);
//	         stage.show();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("HBOX");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
