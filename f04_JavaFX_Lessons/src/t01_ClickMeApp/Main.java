package t01_ClickMeApp;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
	/* Stage класс - определяет top-level контейнер для всех объектов интерфейса (самое основное окно, где отражаются все элементы)
	Scene класс - контейнер, в котором содержится все элементы, показываемые в программе
	Layout класс - это пакет, который определяет менеджер слоев; назначение его - позиционирование каждого объекта
	Сontrol класс - этот пакет содержит индивидуальные покеты, такие как buttons, text boxes, and labels.
	   Наследование:
	Button класс - один из многих классов, которые наследуется от класса javafx.scene.control.Control. 
	Control класс - один из нескольких классов, кторые наследуется от самого верхнего класса javafx.scene.Node. 
    Класс Node  - базовый класс для всех элементов интерфейса, которые могут быть показаны in a scene. 
	 
	JavaFX application - это Java класс, который extends javafx.application, поэтому важно прописывать extends Application 
		РАБОТА JavaFX application 
	- Запускает исполняемая среда JavaFX (если она не запущена)
	- Она вызывает конструктор класса, который расширяет класс Application, тем самым создавая экземпляр данного класса
	- Затем среда JavaFX вызывает метод init()
	- Вызывается метод start(javafx.stage.Stage), в который среда JavaFX передает созданный объект Stage. Таким образом, 
	приложение начинает работать
	 - Далее среда ожидает, пока либо в приложении не будет вызван программным способом метод Platform.exit(), 
	 либо пока не будет закрыто последнее окно программы
	 - После завершения работы приложения среда JavaFX вызывает метод stop()
	*/
public class Main extends Application {
	Button btn;
	Label lbl;
	int iClickCount = 0;
	 @Override
	    public void init() throws Exception {
	         
	        System.out.println("Application inits");
	        super.init();
	    }
	 	/* Метод start - абстрактный метод класса Application, который не имеет default исполнения. Нужно override его. 
		   Метод start отвечает за построение и отображение user interface.  */
	@Override 
	public void start(Stage primaryStage) {		
			/* Параметром метода start() яв-cя объект Stage - это oсновa для создания графического интерфейса 
			   По сути он является контейнером, в который помещаются все остальные компоненты интерфейса. 
			   На десктопах это будет отдельное графическое окно, а на мобильных устройствах интерфейс - весь экран устройства
			   В программе на JavaFX можно использовать множество объектов Stage, но один из них является основным.
			   При запуске приложения основной объект Stage создается средой JavaFX и передается в метод start(Stage primaryStage)
			   Этот объект Stage определяет главное окно или экран программы. Однако внутри приложения мы также можем создавать
			   другие объекты Stage - другие графические окна  		 */
													// интерфейс. Например, на десктопах Stage будет представлять графическое окно.
		btn = new Button();							// Создание кнопки
		btn.setText("Click me please!");			

		Text text = new Text("Hello!!!");			// Cоздание надписи
		text.setLayoutY(80); 
		text.setLayoutX(80);
		
		lbl = new Label();								// Создание объекта, отражающего кол-во нажатий на клавишу			
		lbl.setText("You have not clicked the button.");
		
		btn.setOnAction(e -> buttonClick());	/* Метод buttonClick() вызывается, когда пользователь нажмет кнопку  
									Handling an Action Event  - несколько cпособов, самый прямой - это через метод btn.setOnAction():
									метод вызыается при каждом нажатии на клавишу и исполняет
									те дейтсвия, которые указаны в его теле.  Лямбда выражение e -> buttonClick()	
									Event  - объект, который создается, когда пользователь  взаимодействует с интерфейс-компонент.
									Затем Event объект передается в специальный метод Event Handler, в котором происходит
									определение по объекту какое действие было совершенно и формируется соответ. действия	*/
		
		BorderPane pane = new BorderPane();			/* Добавление кнопки на layout панель (pane)
									Pane - панель, где располагаются все элементы и упорядачиваются друг относительно друга
									Border pane - панель, где объекты могут располагаться в 5 позициях: верх, слева, справа,
									низ и центр. Это идеальный вариант для menu and toolbar at the top, a status bar at the bottom,
									optional task panes or toolbars on the left or right, and a main working area in the center of the screen. 	*/
		pane.setCenter(btn);						// Позиционирование кнопки по центру
		pane.setTop(lbl);
		pane.setBottom(text);
		
		/* Все визуальные элементы, которые мы хотим отобразить в Stage, помещаются в объект Scene или на сцену. 
		   Scene представляет контейнер для всех графических элементов внутри объекта Stage в виде графа, который называется 
		   Scene Graph. Все узлы этого графа, то есть по сути все вложенные элементы должны представлять класс javafx.scene.Node.
		   Но корневой узел этого графа должен представлять объект класса, который унаследован от javafx.scene.Parent. 
		   По сути Parent - это контейнер, который может содержать другие элементы.
		 */
		
		Scene scene = new Scene(pane, 300, 250);	/* Добавление the layout pane to a scene
								    Scene - это контейнер, в котором хранится Pane. Конструктор - pane, ширина и высота в пикселях
								    Scene может содержать только 1 Pane								*/
		primaryStage.setScene(scene);				/* Добавление в Stage объекта scene
						            				Stage хранит окно, в котором показывается Scene */
		primaryStage.setTitle("The Click Me App");	
		primaryStage.show();						// Показ Stage
	}
		// stop(): вызывается после закрытия приложения, например, после того, как пользователь нажал на крестик в правом верхнем углу
	 @Override
	 public void stop() throws Exception {
        System.out.println("Application stops");
        super.stop();
	}
	 
	public void buttonClick(){
		iClickCount++;
		if (iClickCount == 1) {
			lbl.setText("You have clicked once");
			btn.setText("You have clicked once");}
		else {
			lbl.setText("You have clicked " + iClickCount + "times!");
			btn.setText("You have clicked " + iClickCount + "times!");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Launching JavaFX");
		launch(args);
		/* Метод launch() начианет JavaFX app. Этот метод является статичным. 
		   При вызове метода launch() создается объект класса Application и начинается цикл жизни JavaFX, который сначала
		   вызыает метод init, затем метод start и затем дожидается завершения программы, после чего вызываект метод stop().
		   Метод init() по сути ничего не делает, но его можно переопределить, чтобы запустить действия перед началом работы app.
		   Метод stop() также ничего не делает, но его можно переопределить, чтобы запустить дейтсвия после работы основного app    
		*/
		System.out.println("Finished");
	}
}

/*   ЗАПУСК ИЗ КОМАНДНОЙ СТРОКИ
 *  Вначале с помощью команды cd перейдем в командной строке/терминале к каталоге, где расположен файл с исходным кодом. 
C:\Users\dkuli\Documents\My_works\JavaFX_Lessons\src\t01_ClickMeApp
	Затем скомпилируем приложение с помощью команды
	javac --module-path C:\Program Files\JavaFX\javafx-sdk-14.0.2.1\lib --add-modules=javafx.controls Main.java - НЕ РАБОТАЕТ
	При расположении JavaFX в Program Files из командной строки не компилируется
	При переносе JavaFX из Program Files на диск С - все работает из командной строки
	javac --module-path C:\javafx-sdk-14.0.2.1\lib --add-modules=javafx.controls Main.java
Для компиляции используется стандартный компилятор Java - javac. Ему передается параметр --module-path, который указывает на
расположение модулей. В каждом конкретном случае в зависимости от того, где расположен SDK, этот путь может отличаться.
Кроме того, указывается параметр add-modules, который указывает на используемые модули. В данном случае применяется модуль
javafx.controls, который содержит ссылки на другие модули.
	Далее запустим скомпилированное приложение с помощью команды
	java --module-path C:\javafx-sdk-14.0.2.1\lib --add-modules=javafx.controls Main    НЕ РАБОТАЕТ ??*/
