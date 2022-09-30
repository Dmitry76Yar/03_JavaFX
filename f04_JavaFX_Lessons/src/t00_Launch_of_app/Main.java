package t00_Launch_of_app;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/* 			УКАЗАНИЕ МОДУЛЕЙ В RUN CONFIGURATION
   В настройках запуска нужно прописать модули, которые необходимы для работы приложения
   При указании нескольких модулей нужно прописывать их через запятую  javafx.controls,javafx.fxml
   Также можно указать значения ALL-DEFAULT или ALL-SYSTEM или ALL-MODULE-PATH
   	В  Run configurations - (x)-Arguments - VM arguments прописываем --add-modules=javafx.controls,javafx.fxml,javafx.web  */

 /* 		ЗАПУСК ИЗ КОМАНДНОЙ СТРОКИ
  	Нюансы:
  При расположении JavaFX в Program Files из командной строки не компилируется
  При переносе JavaFX из Program Files на диск С - все работает из командной строки
  		Создание структуры каталогов
  	Создадим следующую структуру каталогов C:\book\srs\TestJavaFX\application\ и добавим файл Main с кодом
  	  		Компиляция файла с помощью командной строки
  1. Запускать командную строку можно из любой директории
  2. Сомпилируем приложение с помощью команды (все три строки в одну строчку)
  		javac --module-path C:\Java\JavaFX\14.0.2.1\lib --add-modules javafx.controls 
  		-d C:\book\bin\TestJavaFX
  		C:\book\srs\TestJavaFX\application\*.java
			, где команда --module-path указывает путь поиска модулей
				  команда --add-modules добавляет модули.
				  команда -d указывает каталог, в который будут записаны скомпилированные файлы
	В результате в C:\book\bin\TestJavaFX будет создана папка application и в ней файл Main.class
	
		Запуск скомпилированного файла
  3. Для запуска приложения из командной строки набираем команду (все три строки в одну строчку)
		java --module-path C:\Java\JavaFX\14.0.2.1\lib --add-modules javafx.controls 
		-cp C:\book\bin\TestJavaFX application.Main
				, где команда --ср задает путь поска классов
	В результате отобразится окно приложения. 			*/

/* 			СОЗДАНИЕ АРХИВА JAR
С https://gluonhq.com/products/javafx/ из раздела Windows x64 скачиваем архив jmods.
Распаковываем его и переименовываем полученную папку из javafx-jmods-18.0.2 в jmods (для упрощения ввода из к.строки)
и затем копируем эту папку в C:\javafx-sdk-14.0.2.1 	 
	Создадим исполняемый JAR архив 
  1. Запускать можно из любой директории в командной строке
  2.  В командной строке наберем команду 
	 jar cvfe C:\book\TestJavaFX.jar application.Main -C C:\book\bin\TestJavaFX\ .
	   	, где в первой строке указано директория для сохранения JAR архива (просто диск С запрещено) и название архива (любое)
	   		  во второй строке указан название класса и его местоположение
   В результате в каталоге C:\book будет создан TestJavaFX.jar
			ЗАПУСК АРХИВА JAR ИЗ КОМАНДНОЙ СТРОКИ
  3A. Запустить архив из командной строки
   	java --module-path C:\Java\JavaFX\14.0.2.1\lib --add-modules javafx.controls -jar C:\book\TestJavaFX.jar
  3Б. Запустить архив по двойному щелчку 
  	1)В каталоге с Java приложением C:\Java\jdk-18.0.2 нужно создать файл runJAR.bat.
  	Для этого создаем документ Блокнота без названия
  	Добавлям код 
  	@echo off
  	start C:\Java\jdk-18.0.2\bin\javaw.exe --module-path  C:\Java\JavaFX\14.0.2.1\lib --add-modules ALL-MODULE-PATH -jar %1
  	Сохранить файл с названием runJAR.bat при этом выбрав вместо .txt опцию Все файлы
  	2) Выбрать программу runJAR.bat для открытия файла TestJavaFX.jar */

/* 			СОЗДАНИЕ ДИСТРИБЬЮТИВА
 	Можно создать дистрибутив, в состав которого входят все модули, необходимые для запуска приложения.
 	1) Сначалу нужно определить от каких модулей зависит приложение
 	Для этого предназначена утилита jdeps.exe, входящая в состав JDК (расположена в в C:\Java\jdk-18.0.2\bin)
 	Для файла с архивом TestJavaFX.jar, расположенного в C:\book
 		- переходим через cd в директорию  C:\book (обязательно)
 		- из нее вызываем команду в командной строке jdeps --module-path  C:\Java\JavaFX\14.0.2.1\lib -s TestJavaFX.jar
 	Ответ командной строки
	 	TestJavaFX.jar -> java.base
		TestJavaFX.jar -> javafx.controls
		TestJavaFX.jar -> javafx.graphics
	2) Для создания дистрибьютива можно воспользоваться утилитой jlink.exe (расположена в C:\Java\jdk-18.0.2\bin)
	 Предварительно в каталоге C:\book создаем каталог jlink, в который будем сохранять файлы.
	 В командной строке вводим команду (из любой директории, в одну строку)
	 jlink --no-header-files --no-man-pages --compress=2 --strip-debug 
	 --module-path C:\Java\JavaFX\14.0.2.1\javafx-jmods-18.0.2 
	 --add-modules java.base,javafx.controls,javafx.graphics 
	 --output C:\book\jlink\jrefx1
	 	где --no-header-files - не добавлять заголовочные файлы
	 		--no-man-pages - не добавлять файлы со справочной информацией
	 		--compress=2 - степень сжатия
	 		--strip-debug - удалить отладочную информацию
	 		--module-path - путь поиска модулей. ОБРАТИТЕ внимание, что обращение идет к файлам jmods, а не к модулям JAVAFX
	 		--output - путь к каталогу в который будут сохранены все файлы и модули
	 Для просмотра списка всех модулей, загруженных в каталог C:\book\jlink\jrefx1 набираем в командной строке (из любой директории)
	 	C:\book\jlink\jrefx1\bin\java --list-modules
	 Для запуска приложения из дистрибьютива набираем в командной строке	
	 	C:\book\jlink\jrefx1\bin\java -jar TestJavaFX.jar
	 	
	3)  Создание exe файла, при щелчке на котором запустим виртуальную машину Java из дистрибутива и передадим ей путь к Jar-архиву
	При этом сделаем так, чтобы черное окно не отображалось.
	Предварительно внутри каталога с дистрибутивом создаем каталог jar и копируем в него файл TestJavaFX.jar  (в C:\book\jlink\jrefx1\jar)
	Для создания exe файла нам потребуется библиотека MinGW-W64.
	Для загрузки библиотеки переходим на страницу https://sourceforge.net/projects/mingw-w64/files/ и 
	скачиваем файл mingw-w64-install.exe для онлайн загрузки, устанавливаем в C:\Java\MinGWCompiler
	Для проверки работоспособности установленного приложения набираем set Path=C:\Java\MinGWCompiler\mingw32\bin;%Path%   - ничего не выдает
	Проверяем версию C:\book>gcc --version
	Выдаст
		gcc (i686-posix-dwarf-rev0, Built by MinGW-W64 project) 8.1.0
		Copyright (C) 2018 Free Software Foundation, Inc.
		This is free software; see the source for copying conditions.  There is NO
		warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
	Чтобы exe-ярлык содержал значок
		- в каталог С:\book добавляем файл со значком, например, my_ico.ico
		- создаем текстовый файл с названием resources.rc и вставляем в него 001 ICON "my_ico.ico"
		- компилируем файл ресурсов с помощью программы windres.exe через команду (из директории С:\book) 
			windres --use-temp-file -iresources.rc -oresources.o
			В результате будет создан файл resources.o
		- чтобы передать файл resources.o компилятору при сборке программы нужно создать файл runjar.c с текстом ниже
			#include <stdio.h>
			#include <process.h>
			
			int main (int argc, char *argv[], char **penv) {
				_execl("bin\\javaw.exe", "bin\\javaw.exe", "-jar", "jar\\TestJavaFX.jar", NULL);
			return 0;
			}
	   - теперь можно создать exe-файл, выполнив команду
	   		gcc -Wall -O3 -mwindows -o C:\book\jlink\jrefx1\MyApp.exe runjar.c resources.o
	   	После компиляции будет создан в каталоге C:\book\jlink\jrefx1 файл MyApp.exe. 
	   	При двойном щелчке мыши запустится приложение  TestJavaFX.jar
	   	В этом виде дистрибутив можно передать пользователю и ему не понадобится дополнительно устанавливать JDK и библиотеку JavaFX.
	   	Чтобы сжать можно зарархивировать файл
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
        System.out.println("Application stops   папыввсыв");
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


