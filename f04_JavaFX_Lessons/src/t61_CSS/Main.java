package t61_CSS;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
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
		Label label = new Label("TEXT");
		
			// Встраивание стиля setStyle()
//		label.setStyle("-fx-text-fill: #ff0000;");
//		label.setStyle("-fx-text-fill: #ff0000; fx-font-size: 16 pt;");
		
				// Таблицу стиля можно вынести в отдельный файл с расширением css //
			// Чтобы подключить файл стиля для всего приложении позволяет статический метод setUserAgentStylesheet()
		System.out.println(" По умолчанию стиль приложения - " + Application.getUserAgentStylesheet());
//		Application.setUserAgentStylesheet("/t61_CSS/application.css");
		System.out.println(" Текущий стиль приложения - " + Application.getUserAgentStylesheet());
		
			/* Можно указать одну из констант класса Alplication 
		- STYLESHEET_CASPIAN
		- STYLESHEET_MODENA		- этот стиль по умолчанию			 */
//		Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
		System.out.println(" Текущий стиль приложения - " + Application.getUserAgentStylesheet());
		
			/* Прописать параметр стиля в CSS файле для разных элементов
		- Label {fx-text-fill: #133233;}			- для всего класса Label
		- .my_label {fx-text-fill: #133233;}		- для всех узлов, которым присвоен стилевой класс my_label
		- Label.my_label {fx-text-fill: #133233;}	- для всех узлов класса Label, которым присвоен стилевой класс my_label
	    - #labelId {fx-text-fill: #133233;}			- для конктретного узла с Id = labelId
	    - Label, Button {fx-text-fill: #133233;}	- для всего класса Label и Button (перечисление через запятую любого кол-ва классов)
	    - HBox .Label {fx-text-fill: #133233;}		- все узлы класса Label внутри всех контейнеров класса Hbox
	    - #hboxId > .Label {fx-text-fill: #133233;} - все узлы класса внутри конкретного контейнера с Id = hboxId
			 */
		
			/* Чтобы подключить файл стиля к узлам определенного класса
		- прописать в CSS файле стиль для всего класса узла через Label {}
		- добавить стиль к узлу или через него, или через контейнеры более высокого уровня 	 */
		Label label2 = new Label("LABEL 2");
		label2.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		
			/* Чтобы прописать стиль именно для определенного узла нужно присвоить ему уникальный ID и 
		- прописать вфайле CSS стиль именно для этого ID через #My_Label{}
		- добавить стиль к узлу или через него, или через контейнеры более высокого уровня 	 */
		label.setId("My_Label");
		label.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		
			/* НАЗНАЧЕНИЕ СТИЛЕВОГО КЛАССА
		Можно создать в файле CSS стилевой класс, который можно будет добавлять к любому узлу
		 - прописать в файле новый стилевой класс, например  .labelStyleClass {} и 
		 - добавить этот стилевой класс к необходимому узлу		 */
		Label label3 = new Label("LABEL 3");
		label3.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		label3.getStyleClass().add("labelStyleClass");
		
			/* ПРИОРИТЕТ ПРИМЕНЕНИЯ СТИЛЕЙ
		Предположим для узла стиль прописан сразу в нескольких местах:
		 - отдельные параметры стиля, например setFont() назначенные прямо в основном коде
		 - с помощью метода setStyle() назначенные прямо в основном коде
		 - в файле style_pane.css
		 - в файле style_scene.css с привязкой через scene.getStyleSheets().add(getClass().getRecource(
		 											 "//t61_CSS/application.css").toExternalFrom());
		 - в файле style_scene.css с привязкой через scene.setUserAgentStylesheet(getClass().getRecource(
		 											"//t61_CSS/application.css").toExternalFrom());
		  
		 Приоритет будет следующим от нижнего к верхнему: 
		 - стиль сцены с привязкой через scene.setUserAgentStylesheet(getClass().getRecource("//t61_CSS/application.css").toExternalFrom());
		 - отдельные параметры стиля, например setFont() прямо в основном коде
		 - стиль сцены с привязкой через scene.getStyleSheets().add(getClass().getRecource("//t61_CSS/application.css").toExternalFrom());
		 - стиль верхнего контейнера из style_pane.css
		 - стиль для данного узла, назначенный через setStyle()  - САМЫЙ ПРИОРИТЕТНЫЙ УРОВЕНЬ */
		
			// ОТСТУП внутренний для надписи
//		label2.setStyle("-fx-label-padding: 10 px;");
		
						/* ЦВЕТ
		- через имя цвета .label(-fx-background-color: red;)
		- через #RGB, где R - насыщенность красного, G - насыщенность зеленого и B - насыщенность синего 
			Значения задаются тремя одинарными 16-теричным числами от 0 до F 
			Например, .label(-fx-background-color: #F00;)
		- через #RRGGBB, где RR - насыщенность красного, GG - насыщенность зеленого и BB - насыщенность синего 
			Значения задаются тремя двухзначными 16-теричными числами от 00 до FF 
			Например, .label(-fx-background-color: #FF0000;)
		- через rgb(R, G, B), где R - насыщенность красного, G - насыщенность зеленого и B - насыщенность синего 
			Значения задаются тремя одинарными 10-теричным числами от 0 до 255
			Например, .label(-fx-background-color: rgb(255, 0, 0);)
		- через rgb(R%, G%, B%), где R - насыщенность красного, G - насыщенность зеленого и B - насыщенность синего в процентах
			Например, .label(-fx-background-color: rgb(100%, 0%, 0%);)
		- через rgba(R, G, B, A), где R - насыщенность красного, G - насыщенность зеленого и B - насыщенность синего 
			Значения задаются тремя одинарными 10-теричным числами от 0 до 255
			A - задает уровень прозрачности цвета (альфа-канала) от 0 до 1 (полностью непрозрачен)
			Например, .label(-fx-background-color: rgba(255, 0, 0, 0.5);)
		- через rgb(R%, G%, B%, A), где R - насыщенность красного, G - насыщенность зеленого и B - насыщенность синего в процентах
			A - задает уровень прозрачности цвета (альфа-канала) от 0 до 1 (полностью непрозрачен)
			Например, .label(-fx-background-color: rgba(100%, 0%, 0%, 0.5);)
		- через #hsb(H,S,B), где H - оттенок (от 0 до 359), S - насыщенность в процентах от 0 до 100%, B - яркость в процентах от 0 до 100
			Например, .label(-fx-background-color: hsb(0, 100%, 50%);)
		- 	через #hsba(H,S,B,A), где H - оттенок (от 0 до 359), S - насыщенность в процентах от 0 до 100%, B - яркость в процентах от 0 до 100
			A - задает уровень прозрачности цвета (альфа-канала) от 0 до 1 (полностью непрозрачен)
			Например, .label(-fx-background-color: hsb(0, 100%, 50%, 0.5);)
		- с помощью функции derive(<Цвет>, <Яркость>%), 
				, где Яркость указывает яркость цвета в процентах от -100 до +100 (более светлый)
			Например, .label(-fx-background-color: derive(red, 50%);)	 */
		
			/* :hover - узел, над которым находится указатель мыши изменится
			 В CSS файле прописываем  #VisitedButton:hover{-fx-background-color: linear-gradient(#2A5058, #61a2b1);}	 */
		Button btn = new Button("HOVER");
		btn.setStyle("-fx-font-size: 12px;");
		btn.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		btn.setId("VisitedButton");
		
			/* :armed - кнопка мигнет при нажатии на нее мыши
			В CSS файле прописываем  #FocusedButton:armed{-fx-background-color: linear-gradient(#2A5058, #61a2b1);}   */
		Button btn1 = new Button("ARMED");
		btn1.setStyle("-fx-font-size: 12px;");
		btn1.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		btn1.setId("FocusedButton");
		
			/* :cancel - кнопка отмены (назначенная setCancelButton(true)) меняет свой стиль
			В CSS файле прописываем  Button:cancel {-fx-background-color: green;} */
		Button btn2 = new Button("CANCEL");
		btn2.setStyle("-fx-font-size: 12px;");
		btn2.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		btn2.setCancelButton(true);
		
			/* :disabled - нажатие кнопки мыши на узел, вызывает ее мигание
	 		В CSS файле прописываем 			 */
		Button btn3 = new Button("DISABLED");
		btn3.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		btn3.setId("btn3Id");
		
			/* :visited - после перехода по гиперссылке, она отмечается, как посещенная
				В CSS файле прописываем  #HYPERL1:visited {-fx-text-fill: RED;} */
		Hyperlink hyperlink5 = new Hyperlink("https://yandex.ru/images/?from=tabbar");
		hyperlink5.setFont(new Font(17));
		hyperlink5.setWrapText(false);
		hyperlink5.setText("VISITED");
		hyperlink5.setId("HYPERL1");
		hyperlink5.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		
			/* :pressed - нажатие кнопки мыши на узел, вызывает ее мигание
			 	В CSS файле прописываем  #HYPERL2:pressed {-fx-text-fill: YELLOW;} */
		Hyperlink hyperlink6 = new Hyperlink("https://yandex.ru/images/?from=tabbar");
		hyperlink6.setFont(new Font(17));
		hyperlink6.setWrapText(false);
		hyperlink6.setText("PRESSED");
		hyperlink6.setId("HYPERL2");
		hyperlink6.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		
				/* ФОРМАТИРОВАНИЕ ШРИФТА  */
		Label label4 = new Label("LABEL4");
			// ИМЯ ШРИФТА
		label4.setStyle("-fx-font-family: 'Arial'");
			/* В ряде случае указанный шрифт может отсутствовать на компьютере пользователя, поэтому можно указать
		одно из пяти типовых семейств шрифтов: serif, sans-serif, cursive, fantasy, monospace  */
		label4.setStyle("-fx-font-family: fantasy;");
			/* Помимо шрифтов, установленных на компьютер и типовых шрифтов, можно загружать шрифты с помощью
			 		Структура :
			 @font-face {
			 	font-family: <Имя, под котороым шрифт будет доступен в таблице стилей>; 
			 	src: url("<URL-адрес файла со шрифтом>")
			  }		
			  		Пример:
			  @font-face {
			 	font-family: MyFont; 
			 	src: url("file:/C:/Windows/Fonts/Tahoma.ttf>")
			  }	
			  label4.setStyle("-fx-font-style: 16pt MyFont;");		  */
		
			// СТИЛЬ ШРИФТА   Курсивный, нормальный и наклонный шрифт
		label4.setStyle("-fx-font-style: normal;");
		label4.setStyle("-fx-font-style: italic;");		// Курсивный
		label4.setStyle("-fx-font-style: oblique;");	// Наклонный

			// ЖИРНОСТЬ ШРИФТА   
		label4.setStyle("-fx-font-weight: normal;");	// Нормальный
		label4.setStyle("-fx-font-weight: bold;");		// Жирный
		label4.setStyle("-fx-font-weight: lighter;");	// Менее жирный, чем у родительского элемента
		label4.setStyle("-fx-font-weight: bolder;");	// Более жирный, чем у родительского элемента
			// Также можно задать в единицах от 100, 200, 300.... до 900 (900 - самый жирный)
		label4.setStyle("-fx-font-weight: 900;");
			
			// РАЗМЕР ШРИФТА
		label4.setStyle("-fx-font-size: 20px;");
		label4.setStyle("-fx-font-size: 20pt;");
			// Также можно указать размер, как одну из констант xx-small, x-small, small, medium, latge, x-large, xx-large
		label4.setStyle("-fx-font-size: xx-large;");
			// Также можно указать в процентах
		label4.setStyle("-fx-font-size: 150%;");
			// Также можно указать меньше или больше
		label4.setStyle("-fx-font-size: smaller;");
		label4.setStyle("-fx-font-size: larger;");
			
			// ЦВЕТ ТЕКСТА
		label4.setStyle("-fx-text-fill: red;");
		
			// ОДНОВРЕМЕННОЕ УКАЗАНИЕ ПАРАМЕТРОВ ШРИФТА		style - weight - size - family
		label4.setStyle("-fx-font: italic bold 16pt 'Arial'");
		
		
		
			
//		label4.setStyle("-fx-font-size: 20px;");
//		label4.setStyle("-fx-underline: true;");			// Подчеркивание текста
//		label4.setStyle("-fx-strikethrough: true;");		// Зачеркивание текста
			
			// Обрезка и перенос тексат на новую строку1
		Label label5 = new Label("LABEL5");
			// ОБРЕЗКА Определяет, что будет отображаться, если текст не помещается на одной строке или внутри области
		label5.setStyle("-fx-ellipsis-string: '>>>';");			
			
			/* ОБРЕЗКА Задает режим обрезки текста, если он не помещается 
		 		Можно указать значение: 
		 	- ELLIPSIS 		  - текст обрезаетася в конце и добавляется значение свойства ellipsisString (значение по умолчанию)
		 	- WORD_ELLIPSIS   - аналогично ELLIPSIS, но обрезка выполняется между словами, а не в любом месте
		 	- CENTER_ELLIPSIS - текст обрезается посередине и добавляется значение свойства ellipsisString (значение по умолчанию)
		 	- CENTER_WORD_ELLIPSIS - аналогично CENTER_ELLIPSIS, но обрезка выполняется между словами, а не в любом месте
		 	- LEADING_ELLIPSIS - текст обрезается в начале и и добавляется значение свойства ellipsisString (значение по умолчанию)
		 	- LEADING_WORD_ELLIPSIS - аналогично LEADING_ELLIPSIS, но обрезка выполняется между словами, а не в любом месте		
		 	- CLIP - текст просто обрезается в конце */
		label5.setStyle("-fx-text-overrun: center-ellipsis");
		
			// ПЕРЕНОС Если не помещается на одной строке, то переносится
		label5.setStyle("-fx-wrap-text: true;");				 
		
			/* ГОРИЗОНТАЛЬНОЕ ВЫРАВНИВАНИЕ ТЕКСТА
		- center - выравнивание по центру
		- left - выравнивание по левому краю
		- right -выравнивание по прaвому краю
		- justify - выравнивание по ширине (по двум сторонам)	 */
		label5.setStyle("-fx-text-alignment: center;");
		
				// ВЗАИМОДЕЙСТВИЕ МЕЖДУ ИЗОБРАЖЕНИЕМ И ТЕКСТОМ
		/* Атрибут -fx-graphic задает интернет-адрес (URL) изображения, которое будет отображаться
		рядом с текстом надписи или вместо него */
		label5.setStyle("-fx-graphic: url(/img/icons.png);");
		
		/* Атрибут -fx-content-display задает положение изображения относительно текста
		Можно указать: left, right, center, top, bottom, text-only, graphic-only
		рядом с текстом надписи или вместо него */
		label5.setStyle("-fx-graphic: url(/img/icons.png); -fx-content-display:left;");
		
		// Атрибут -fx-graphic-text-gap задает расстояние между изображением и текстом
		label5.setStyle("-fx-graphic-text-gap: 20px;");
		
			/* ВЫРАВНИВАНИЕ ИЗОБРАЖЕНИЯ И ТЕКСТА ВНУТРИ ОБЛАСТИ
		Атрибут -fx-aligment задает выравнивание текста и изображения внутри свободной области компонента
		Если такой свободной области нет, то и эффекта не будет видно
		Можно указать значения 
			baseline-center, baseline-left, baseline-right
			bottom-center, bottom-left, bottom-tight
			center, center-left, center-tight
			top-center, top-left, top-tight	 				*/
		label5.setStyle("-fx-alignment: center;");
		
			/* ОТСТУП ОТ ГРАНИЦЫ КОМПОНЕНТА ДО ТЕКСТА И ИЗОБРАЖЕНИЯ
		-fx-label-padding: <Одно значение со всех сторон>
		-fx-label-padding: <top> <right> <bottom> <left>	 */
		label5.setStyle("-fx-label-padding: 20.0px;");
		
			/* РАЗМЕРЫ И ВНУТРЕННИЕ ОТСТУПЫ
		задать размеры позволяют следующие атрибуты:
		- fx-pref-width и fx-pref-height		- предпочтительные размеры 
		- fx-min-width и fx-min-height			- минимальные размеры
		- fx-max-width и fx-max-height			- максимальные размеры	*/
		label5.setStyle("-fx-pref-width:400px; -fx-pref-height: 100px;" +
						"-fx-min-width:200px; 	-fx-min-height: 50px;" +
						"-fx-max-width:400px; 	-fx-max-height: 150px;");
		
		/* Внутренние отступы - это расстояние между узлом и границей области.
		 -fx-label-padding: <Одно значение со всех сторон>
		-fx-label-padding: <top> <right> <bottom> <left>	 */
		label5.setStyle("-fx-label-padding: 20.0px;");
		
			// ФОН
		label5.setStyle("-fx-background-color: green;");
		label5.setId("Label5");
		
			/* РАМКИ
		Компоненты и контейнеры, наследующие класс Region могут иметь одну или несколько рамок.	
			// ЛИНИЯ РАМКИ
		С помощью атрибута -fx-border-style можно задать стиль линии рамки
		-fx-border-style: <Стиль> [<Сдвиг>] [<Положение>] [<Форма соединения>] [<Форма окончания>]
			где 
				Параметр "Стиль" может принимать значения
					- none - линия не отображается
					- solid - сплошная линия
					- dotted - пунктирная линия
					- dashed - штриховая линия
					- segments[<Число 1>,<Число 2>...<Число N> - четные индексы списка задают длину штриха, короткие - длину пропуска  */
					label5.setStyle("-fx-font-size: 20px; -fx-border-style: solid;");
		/*		Параметр "Сдвиг" задает смещение начала пунктирной обводки в формате phase<Число> 
		 и определяет длину первой сплошной линии в составе пунктирной линии */
					label5.setStyle("-fx-font-size: 30px; -fx-border-style: segments(16.0, 8.0) phase 2.0;");
		/*		Параметр "Положение" задает положение рамки относительно границы
		  			- centered - по центру границы
		  			- inside - внутри области
		  			- outside - снаружи области */
					label5.setStyle("-fx-font-size: 30px; -fx-border-style: dashed inside;");
		/* Параметр "Форма соединения> задает форму окончания в месте соединения двух линий рамки
		 		Формат line-join <Форма>
		 		, где в форме можно указать 
		 			- miter<limit> - обычные углы
		 			- bevel - скошенные углы
		 			- round - закругленные углы	 */
					label5.setStyle("-fx-font-size: 30px; -fx-border-style: dashed line-join round;");
		/* Параметр "Форма окончания> задает форму окончания линии или штриха
		 		Формат line-cap <Форма>
		 		, где в форме можно указать 
		 			- square - квадратные концы (прибавляются к длине линии или штриха) 
		 			- butt - концы никак не оформляются
		 			- round - закругленные углы	(прибавляются к длине линии или штриха) */
					label5.setStyle("-fx-font-size: 30px; -fx-border-style: solid line-cap butt;");
					
			// ТОЛЩИНА РАМКИ
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px;");
			// ЦВЕТ ЛИНИЯ РАМКИ
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-color: red;");
			
			/* РАМКИ С СКРУГЛЕННЫМИ УГЛАМИ
		указать радиус скругления для углов рамки можно с помощью атрибута -fx-border-radius
		 -fx-border-radius: <Радиус> [/<Радиус>]
		 -fx-border-radius: <top-left> <top-right> <bottom-right> <bottom-left> [/ <top-left> <top-right> <bottom-right> <bottom-left>]
		  перед символом / задается радиус скругления для горизонтальной четверти углов, а после него - для вертикальной четверти
		  Если после / не указать значения, то радиус скругления будет примененен и для гориз, и для вертик			 */
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-radius: 5px;");
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-radius: 1px 2px 3px 4px;");
		
			/* РАСТОЯНИЕ МЕЖДУ РАМКОЙ И ГРАНИЦЕЙ
		-fx-border-insets: <Значение для всех сторон>
		-fx-border-insets: <top> <right> <bottom> <left>			 */
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-insets: 5px;");
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-insets: 1px 2px 3px 4px;");
		
				// ФОН
			// ЦВЕТ ФОНА
		label5.setStyle("-fx-font-size: 30px; -fx-background-color: green;");
		label5.setStyle("-fx-font-size: 30px; -fx-background-color: transparent;");		// Прозрачный фон
			/* РАСТОЯНИЕ между фоном и границей
		-fx-background-insets: <Значение для всех сторон>
		-fx-background-insets: <top> <right> <bottom> <left>			 */
		label5.setStyle("-fx-font-size: 30px;  -fx-background-color: green; -fx-background-insets: 10px;");
		label5.setStyle("-fx-font-size: 30px;  -fx-background-color: green; -fx-background-insets: 10px 20px 30px 40px;");
			/* СКРУГЛЕНИЕ углов фона
		 -fx-background-radius: <Радиус> [/<Радиус>]
		 -fx-background-radius: <top-left> <top-right> <bottom-right> <bottom-left> [/ <top-left> <top-right> <bottom-right> <bottom-left>]
		  перед символом / задается радиус скругления для горизонтальной четверти углов, а после него - для вертикальной четверти
		  Если после / не указать значения, то радиус скругления будет примененен и для гориз, и для вертик			 */
		label5.setStyle("-fx-font-size: 30px;  -fx-background-color: green; -fx-background-radius: 25px;");
		label5.setStyle("-fx-font-size: 30px;  -fx-background-color: green; -fx-background-radius: 5px 10px 15px 20px;");
		
			/* ФОНОВЫЙ РИСУНОК
		С помощью -fx-background-image:  можно установить фоновый рисунок
		С помощью -fx-background-repeat: можно задать режим повтора фонового рисунка
		 - repeat - рисунок повторяется и по вертикали, и по горизонтали
		 - repeat-х - рисунок повторяется по горизонтали
		 - repeat-y - рисунок повторяется по вертикали
		 - no-repeat - рисунок не повторяется
		 - space - повторяет изображение без обрезки и маштабирования, при этом заполняет оставшееся место пустым
		 		   пространством между изображениями
		 - round - повторяет изображение таким образом, чтобы поместилось целое число изображений без пустого 
		 		   пространства между ними, при этом изображение маштабируется 			 */
		label5.setStyle("-fx-font-size: 30px; -fx-background-image: url(/img/icons.png);");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: repeat");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: repeat-x");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: repeat-y");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: space");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: round");
			/* ПОЛОЖЕНИЕ фонового рисунка
		атрибут -fx-background-position задает начальное положение фонового рисунка, координаты через пробел
		Также можно указать следующие значения
		 - left - выравнивание по левому углу
		 - right - по правому углу
		 - center - по центру
		 - top - по верху
		 - bottom - по низу	 */
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat;"
				+ "-fx-background-position: 50% 50%;");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat;"
				+ "-fx-background-position: left center;");
			/* РАЗМЕРЫ фонового рисунка
		атрибут -fx-background-size задает размеры фонового рисунка в виду двух значений, разделенных пробелом: первое значение
		задает ширину рисунка, второе - высоту
		Также можно указать следующие значения
		 - auto - не изменяет размеры рисунка
		 - cover - такие размеры рисунка, чтобы он полностью покрыл фон. При этом фрагменты рисунка могут выйти за границы фона
		 - contain - такие размеры рисунка, чтобы он полностью помещался внутри фона, занимая его целиком
		  		     При этом какие-то части фона могут быть не покрыты рисунком
		 - stretch - растягивает фоновый рисунок по ширине и высоте  */
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat;"
				+ "-fx-background-size: 100% 50%;");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat;"
				+ "-fx-background-size: stretch;");
		
				// ТРАНСФОРМАЦИИ И ЭФФЕКТЫ
			// ИЗМЕНЕНИЕ ПРОЗРАЧНОСТИ
		Rectangle rect = new Rectangle(80,50,Color.RED); 
		rect.setStyle("-fx-opacity: 0.7;");
			/* СМЕЩЕНИЕ УЗЛА 
		Сместить  узел на некоторое растояние позволяет -fx-translate-x, -fx-translate-y, -fx-translate-z	 */
		rect.setStyle("-fx-translate-x: 100.0; -fx-translate-y: 10.0;");
			/* МАСШТАБИРОВАНИЕ УЗЛА
		Изменить масштаб узла можно с помощью -fx-scale-x, -fx-scale-y, -fx-scale-z	 
		Пример увеличения ширины прямоугольгика в 2 раза ниже*/
		rect.setStyle("-fx-scale-x: 2.0; -fx-scale-y: 1.0;");
			/* ВРАЩЕНИЕ УЗЛА
		Повернуть узел на некоторый угол в градусах */
		rect.setStyle("-fx-rotate: 45.0;");
			/* ИЗМЕНЕНИЕ РЕЖИМА НАЛОЖЕНИЯ
		атрибут -fx-blend-mode позвоялет изменить режим наложения			 */
		Rectangle rect2 = new Rectangle(50,50,Color.GREEN);
		Rectangle rect3 = new Rectangle(50,50,Color.BLACK);
		rect3.relocate(25, 25);
		rect3.setStyle("-fx-blend-mode: overlay;");
		Pane pane = new Pane();
		pane.getChildren().addAll(rect2, rect3);
			// ПРИМЕНЕНИЕ ЭФФЕКТОВ
		rect.setStyle("-fx-scale-x: 0.5; -fx-scale-y: 1.0;" +
					  "-fx-effect: innershadow(gaussian, black, 10.0, 0.0, -3.0, -3.0);");
		
			/* ИЗМЕНЕНИЕ ВНЕШНЕГО ВИДА МЫШИ
		атрибут -fx-cursor задает форму указателя мыши при наведении на узел
		Может принимать значения: default, hand, closed-hand, open-hand, wait, text.... или Интернет-адес (URL) курсора	 */
		rect.setStyle("-fx-scale-x: 0.5; -fx-scale-y: 1.0; -fx-cursor: hand;");
		
				// ИЗМЕНЕНИЕ ХАРАКТЕРИСТИК ФИГУРЫ
			// ФОН фигуры
		rect.setStyle("-fx-fill: red;");
		
			// ОБВОДКА фигуры
			// - fx-stroke - цвет обводки
		rect.setStyle("-fx-stroke: black;");
			//- fx-stroke-width - ширина (толщина) обводки
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px;");
			//- fx-stroke-type - положение обводки относительно границы фигуры
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px; fx-stroke-type: centered");	// по центру границы 
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px; fx-stroke-type: inside");		// внутри фигуры
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px; fx-stroke-type: outside");		// снаружи фигуры
			//- fx-stroke-dash-array - задает значение для пунктирной линии. Четные индексы задают длину штриха, нечетные - длину пропуска
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px; -fx-stroke-dash-array: 10.0px, 5.0px;");
		
			/* СГЛАЖИВАНИЕ ФИГУРЫ
		при выводе некоторых фигур (круг, треугольник или текст) контур может отображаться в виде лесенки.
		Для сглаживания используется атрибут -fx-smooth	 */
		Circle circle = new Circle(30.0);
		circle.setStyle("-fx-stroke: red; -fx-stroke-width: 5px; -fx-smooth: true;");
		
			// СКРУГЛЕНИЕ УГЛОВ ПРЯМОУГОЛЬНИКА
		rect.setStyle("-fx-arc-width: 20px; -fx-arc-height: 20px;");
		
			/* ИЗМЕНЕНИЕ ХАРАКТЕРИСТИК ПОЛОС ПРОКРУТКИ
		позволяют следующие атрибуты:
		 - fx-orientation - задает ориентацию компонента - horizontal или vertical
		 - fx-block-increment - задает интервал, на который изменится значение при щелчке мыши по полосе
		 - fx-unit-increment - задает интервал, на который изменится значение при нажатии кнопок со стрелками, 
		 					   повороте колесика мыши, при вызове методов increment() и decrement()	
		Также можно менять составляющие прокрутки
		Ниже приведена структура компонента прокрутки класса ScrollBar
		.scroll-bar
			.increment-button			- кнопка увеличения значения
				.increment-arrow		- стрелка на кнопке увеличения значения
			.decrement-button
				.decrement-arrow
			.track					    - дорожка хода ползунка
			.thumb	 					- ползунок 
		Пример изменения размера кнопки увеличения значения и цвета стрелки на ней
		.scroll-bar. decrement-button {
		 	-fx-pref-width: 20px; 
		 	-fx-pref-height: 20px;
		 }
		 .scroll-bar. decrement-button. decrement-arrow {
		 	-fx-background-color: red; 
		 }
		 Пример изменения цвета фону ползунка горизонтальной прокрутки
		 .scroll-bar:horizontal .thumb {
		 	-fx-background-color: green;				*/
		ScrollBar scrollBar = new ScrollBar();
		scrollBar.setPrefSize(100, 100);
		scrollBar.setMin(0.0);
		scrollBar.setMax(100.0);
		scrollBar.setValue(0.0);
		scrollBar.setStyle("-fx-orientation: horizontal;" + 
						   "-fx-block-increment: 5.0;" + 
						   "-fx-unit-increment: 1.0;");
		
			/* ИЗМЕНЕНИЕ ХАРАКТЕРИСТИК ScrollPane
		-fx-hbar-policy - задает режим отображения горизонт. прокрутки: as needed, always, never
		-fx-vbar-policy - задает режим отображения горизонт. прокрутки: as needed, always, never
		-fx-pannable - при true содержимое области может перемещаться с помощью мыши
		-fx-fit-to-width - при true узел внутри области будет менять свою ширину одновременно с изменением размера области,
		при условии, что узел поддерживает изменение размера
		-fx-fit-to-hieght - при true узел внутри области будет менять свою высоту одновременно с изменением размера области,
		при условии, что узел поддерживает изменение размера 
			Структура
			.scroll-pane
				.scroll-bar:horizontal
				.scroll-bar:vertical
				.corner
			Пример изменения толщины полос прокрутки
		.scroll-pane .scroll-bar:horizontal (-fx-pref-height: 20 px;}
		.scroll-pane .scroll-bar:vertical (-fx-pref-width: 20 px;}
			Пример изменения цвета фона
		.scroll-pane .viewpoint { -fx-background-color: black;}			 */
		
		HBox hbox = new HBox(label, label2, label3, btn, btn1, btn2, btn3, hyperlink5, hyperlink6);
		hbox.setSpacing(20);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));
		
		HBox hbox2 = new HBox(label4, label5, rect, pane, circle, scrollBar);
		hbox2.setSpacing(20);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setPadding(new Insets(10));
		
		VBox vbox = new VBox(hbox, hbox2);
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(vbox, 1000, 400);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("ВЫБОР ПИЦЦЫ");
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}