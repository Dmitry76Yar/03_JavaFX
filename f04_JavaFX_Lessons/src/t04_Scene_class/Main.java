package t04_Scene_class;
	
import java.awt.MultipleGradientPaint.CycleMethod;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
	/* Все визуальные элементы, которые мы хотим отобразить в Stage, помещаются в объект Scene или на сцену. 
	Scene представляет контейнер для всех графических элементов внутри объекта Stage в виде графа, который называется 
	Scene Graph. Все узлы этого графа, то есть по сути все вложенные элементы должны представлять класс javafx.scene.Node.
	Но корневой узел этого графа должен представлять объект класса, который унаследован от javafx.scene.Parent. 
	По сути Parent - это контейнер, который может содержать другие элементы.   
			Для установки корневого узла в Scene применяется один из конструкторов объекта Scene. Основные из них:
		Scene(Parent root): создает Scene с корневым узлом root
		Scene(Parent root, double width, double height): создает Scene с корневым узлом root, с шириной width и высотой height
		Scene(Parent root, Paint fill): создает Scene с корневым узлом root и устанавливает фоновый цвет
		Scene(Parent root, double width, double height, Paint fill): создает Scene с корневым узлом root, с шириной width и высотой height и устанавливает фоновый цвет
		При этом все конструкторы принимают в качестве первого параметра корневой узел. То есть при создании объекта Scene 
		нам та или иначе придется установить и корневой узел.
		
			Все графические элементы, которые используются в объекте Scene и добавляются в Scene Graph, должны представлять
		класс javafx.scene.Node или иначе узел. Все встроенные классы визуальных графических элементов или узлы, например, 
		кнопки, текстовые поля и другие, наследуется от класса Node.
			При этом одни узлы Node могут содержать несколько других узлов Node. Например, класс Parent наследуется от Node,
		но при этом сам может содержать другие узлы Node.
			Базовую иерархию классов можно представить следующим образом:
			
			jafafx.scene.shape.Shape     \       /  jafafx.scene.media.MediaView
			jafafx.scene.shape.Shape3D    - Node -   jafafx.scene.image.ImageView
			jafafx.scene.canvas.Canvas   /   |     
			                                 jafafx.scene.Parent. - jafafx.scene.Group
			                                           |          \ jafafx.scene.web.WebView
	  jafafx.scene.chart.Chart -   jafafx.scene.layout.Region
	  javafx.scene.layout.Pane /                              \ jafafx.scene.control.Control
	  
	  Вкратце рассмотрим эту иерархию. Основные классы, которые наследуются от класса Node:
	javafx.scene.shape.Shape: является базовым классом для создания геометрических двухмерных примтивов (например, линия, 
	прямоугольник, эллипс)
	javafx.scene.shape.Shape3D: является базовым классом для создания трехмерных объектов
	javafx.scene.canvas.Canvas: представляет полотно для отрисовки различного содержимого
	javafx.scene.Camera: базовый класс камеры, котоый применяется для рендеринга сцены
	javafx.scene.LightBase: предоставляет базовый функционал для классов, которые будут представлять источники света
	javafx.scene.image.ImageView: элемент для отображения изображений
	javafx.scene.media.MediaView: элемент для работы с мультимедиа
	javafx.embed.swing.SwingNode: элемент для встраивания содержимого Swing в JavaFX
	javafx.scene.SubScene: элемент для части сцены в JavaFX, позвляет разбить сцену на подсцены
	javafx.scene.Parent: базовый класс для всех элементов, которые могут содержать другие элементы
	Класс Parent
	Представляет функциональность для управления вложенными узлами, их добавления и удаления и прочие операции с ними. 
	- javafx.scene.web.WebView: элемент, который позволяет отображать веб-содержимое.
	- javafx.scene.Group: представляет контейнер для группы объектов
	- javafx.scene.layout.Region: базовый класс для всех элементов управления, панелей компоновки и диаграмм. 
	Его отличительная особенность состоит в том, что он добавляет функциональность управления границами и размерами элементов.
	Класс Region
	Является базовым классом для большинства визуальных компонентов, которые далее будут рассматриваться.
	- javafx.scene.chart.Chart: базовый класс для всех диаграмм.
	- javafx.scene.layout.Pane: базовый класс для всех панелей компоновки, которые позволяют управлять расположением вложенных 
	элементов, определенным образом упорядочивать их.
	- javafx.scene.control.Control: базовый класс для всех элементов управления (кнопок, текстовых полей ввода, списков и т.д.).  */

public class Main extends Application {
	Button btn;
		@Override 
	public void start(Stage primaryStage) {			
        Label label = new Label("Hello");        
        label.setMinWidth(50);      label.setMinHeight(50);
        Button button = new Button("Button");    
        Button button2 = new Button("Узнать цвет сцены");
        button2.setId("Button2");
        button.setMinWidth(50);     button.setMinHeight(50);
        Group group = new Group(button, button2);                // вложенный узел Group. Kласс Group унаследован от класса Parent.
        HBox hbox = new HBox(label,button,group);
        hbox.setSpacing(20);	hbox.setPadding(new Insets(20));
        hbox.setMinWidth(200);
        hbox.setMinHeight(200);
        
        	/* КОНСТРУКТОРЫ
       	Scene(Parent root)												где root - контейнер (HBox или VBOX или...) самого верхнего уровня
       	Scene(Parent root, double width, double height)					для указания размеров
       	Scene(Parent root, double width, double height, Paint fill)
       	Scene(Parent root, Paint fill)											fill задает параметры фона сцены 
       	Scene(Parent root, double width, double height, boolean depthBuffer)
       		При depthBuffer = true объект сцены будет имеить глубину, это используется для трехмерного пространства
        Scene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing)
        	 Параметр antiAliasing задает уровень сглаживания*/
        Scene scene = new Scene(hbox, 300, 300, Color.AQUA);
        
        	// УСТАНОВКА ДРУГОГО КОНТЕЙНЕРА ВЕРХНЕГО УРОВНЯ
        System.out.println("Контейнер верхнего уровня сейчас - " + scene.getRoot().toString());
        scene.setRoot(hbox);
        System.out.println("Контейнер верхнего уровня сейчас - " + scene.getRoot().toString());
       
       		/* РЕГУЛИРОВКА РАЗМЕРА ОКНА
       	 С помощью конструкторов с размерами.  При отсутствии в конструкторе окно будет размера, чтобы все объекты поместились
       	 Методов изменения размера у Scene нет
		 scene.getWidth()			- возвращает ширину окна
		 scene.getHeight()  		- возвращает высоту окна
		 scene.widthProperty()  	- возвращает ссылку на свойство, котрое связано с шириной сцены
		 scene.heightProperty()  	- возвращает ссылку на свойство, котрое связано с высотой сцены  */
       
       		/* ПОЗИЦИОНИРОВАНИЕ СЦЕНЫ ОТНОСИТЕЛЬНО ЛЕВОГО ВЕРХНЕГО УГЛА ОКНА
		scene.getX()		- возвращает местоположение левого верхнего угла по оси Х сцены относительно левого верхнего угла окна STAGE
		scene.getY()		- возвращает местоположение левого верхнего угла по оси Y сцены относительно левого верхнего угла окна STAGE
		По сути эти занчения позволяюут узнать толщину границы окна Scene.
		scene.xProperty()  	- возвращает ссылку на свойство, котрое связано с координатой X
		scene.yProperty()  	- возвращает ссылку на свойство, котрое связано с координатой Y
		Коордианты будут доступны только после отображения   */
       
        	/* ИЗМЕНЕНИЕ ЦВЕТА SCENE И УСТАНОВКА ФОНОВОГО РИСУНКА
        C помощью конструктора - Scene(Parent root, Paint fill) и Scene(Parent root, double width, double height, Paint fill)
        C помощью метода setFill(Paint fill)
        Параметр сцены может быть
          - COLOR 			- сплошной цвет		
          - ImagePattern 	- фоновое изображение
          - LinearGradient 	- линейный градиент
          - RadialGradient 	- радиальный градиент
        ВАЖНО - чтобы было видно фон сцены, необходимо сделать контейнер верхнего уровня прозрачным */
        hbox.setBackground(Background.EMPTY);
        scene.setFill(Color.BISQUE);
        
        	// УСТАНОВКА ФОНОВОГО РИСУНКА
        ImagePattern im = null; ;
        	// Установка  фонового рисунка, который растягивается на все окно
        try {
			im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg")));
			scene.setFill(im);
		} catch (Exception e) {
			System.out.println("Не удалось загрузить изображение");
		}
        	// Установка фонового рисунка ограниченного размера 
        	// Если задать фон из повторяющихся изображений, то при растягивании окна изображения также будут растягиватся непропорционально 
        try {
			im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg")),
					100, 100, 0.3, 0.3, true);
			/* Здесь конструктор ImagePattern(Image img, double x, double y, double width, double height, boolean proportional)
			   где x, y- начальные координаты, с которых идет отображение изображения,
			       width, height - размер в который будет помещаться выбранное изображение,
			       proportional - при true размеру указываются в долях от 0 до 1 	 */
			scene.setFill(im);
		} catch (Exception e) {
			System.out.println("Не удалось загрузить изображение");
		}
        	// Установка  фонового рисунка ограниченного размера
        	// Если задать фон из повторяющихся изображений, то при растягивании окна изображения не будут менять размер, 
        	// а будут добавляться новые для заполнения всего окна
        try {
			im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg")),
						100, 100, 50, 50, false);
				/* Здесь тот жеконструктор ImagePattern(Image img, double x, double y, double width, double height, boolean proportional), 
				   но размеры указаны в пикселях, а не в долях */
			scene.setFill(im);
		} catch (Exception e) {
			System.out.println("Не удалось загрузить изображение");
		}
        
        	/* Установка лийненого градиента
        Stop stop1 = new Stop(0, Color.BLACK);
        Stop stop2 = new Stop(1, Color.WHITE);
        LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stop1, stop2);      НЕ РАБОТАЕТ */
        
    		// Установка радиального градиента
        RadialGradient rg = RadialGradient.valueOf("center 100px 100 px, radius 300px, red 0%, blue 50%, black 100%");
        scene.setFill(im);

        	// Обработчик для определения параметров фона сцены
        scene.addEventHandler(ActionEvent.ACTION, event -> {
        	if (event.getTarget() instanceof Button) {
        		Button a = (Button)event.getTarget();
        		if (a.getId().equals("Button2")) {
        			System.out.println("Button was pressed");
        			Scene s = a.getScene();
        			System.out.println("Height of scene - " + s.getHeight());
        		}
        	}
        });
        
        	/* Здесь в качестве корневого узла выступает класс FlowPane
			   FlowPane содержит объект Label (текстовая метка) и объект Group.
			   А объект Group, в свою очередь, содержит объект Button (кнопка).
			   					FlowPane
			   					/	\
			   			   Label    group
			   			             /\
			   			               button
        	 */
        primaryStage.setTitle("Hello JavaFX");
        
        primaryStage.setScene(scene);                    // установка Scene для Stage
        primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
