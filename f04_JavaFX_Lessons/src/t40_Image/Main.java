package t40_Image;
	
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Main extends Application  {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl, lbl2;
	int i = 0;
	Image img1, img2, img3, img4, img5, img6, img7, img8;
	
	@Override 
public void start(Stage primaryStage) {	
		Label lbl = new Label("LABEL");
		
/*--------------------------------------------КЛАСС IMAGE---------------------------------------------------------------------------*/
					// КОНСТРУКТОРЫ
		/* Конструктор Image(InputStream is)
		Загружает изображение из открытого потока InputStream. Загружают форматы BMP, GIF, JPEG, PNG  */
	try { 
		img1 = new Image(getClass().getResourceAsStream("/img/icons.png"));
		if (img1.isError()) new RuntimeException();		// Полезно делать такую проверку о правильности загрузки
		}
	catch (Exception e) {
		System.out.println("Не удалось загрузить изображение");
		return; }
	
		/* Конструктор Image(InputStream is, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
		Загружает изображение из открытого потока InputStream. Загружают форматы BMP, GIF, JPEG, PNG  
		, где requestedWidth, requestedHeight - изменяет размеры под указанную ширину и высоту,
			  preserveRatio - при true изменение размеров с сохранением соотношения сторон,
			  smooth - при true при изменении размеров будет использоваться сглаживание			*/
	try { 
		img2 = new Image(getClass().getResourceAsStream("/img/icons.png"), 600, 600, true, true);
		if (img1.isError()) new RuntimeException();				// Полезно делать такую проверку о правильности загрузки
		}
	catch (Exception e) {
		System.out.println("Не удалось загрузить изображение");
		return; }
	
		/* Конструктор Image(String url)
		   Конструктор Image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
	Загружает изображение из пути. Это может быть абсолютный или локальный путь к файлу на диске, или URL-адрес в Интернете */
	try {
		img2 = new Image(getClass().getResource("/img/icons.png").toExternalForm());	
		if (img1.isError()) new RuntimeException();				// Полезно делать такую проверку о правильности загрузки
		}
	catch (Exception e) {
		System.out.println("Не удалось загрузить изображение");
		return; }
	
		/* Конструктор Image(String url, boolean backgroundLoading) 
		   Конструктор Image(String url, boolean backgroundLoading, double requestedWidth, double requestedHeight, 
		 					boolean preserveRatio, boolean smooth)
		 			, где backgroundLoading: загрузка изображения из Интернета может проводиться долго. Чтобы загрузка 
		 				  проводилась в фоновом потоке, а не в текущем, нужно присвоить backgroundLoading - true
		 		*/
	
		/* Метод Cancel()
		 Если загрузка в фоновом потоке происходит долго, то ее можно прервать  */
	
		// МЕТОДЫ GET
	System.out.println("Width =  " + img2.getWidth());
	System.out.println("Height =  " + img2.getHeight());
	System.out.println("Процент загрузки изображения от 0 до 1 - " + img2.getProgress());
	System.out.println("Произошла ошибка загрузки " + img2.getException());
	
		// Пример загрузки и обработки изображения из Интернета
	try {
		img3 = new Image("https://zastavok.net/main/priroda/163639027184.jpg", true);
		img3.progressProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Загружено на " + newValue + " процентов");
			lbl.setText("Загружено на " + newValue + " процентов");
			if (img3.getProgress() == 1) {
				System.out.print("Изображение загружено");
				if (!img3.isError()) {
					System.out.println(" удачно");
					System.out.println("Произошла ошибка загрузки " + img3.getException());
				}
				else System.out.println(" неудачно");
			}
		});
	}
	catch (Exception e) {
		System.out.println("Не удалось загрузить изображение");
		return; }
	
/*---------------------------КЛАСС IMAGE VIEW - ИЗОБРАЖЕНИЕ В ОКНЕ----------------------------------------------------------------
 		Наследование Object - Node - ImageView		
 																						*/
				// КОНСТРУКТОРЫ
		// Конструктор ImageView()
	ImageView imf = new ImageView();
	
		// Конструктор ImageView(String URL)
	ImageView imf3 = new ImageView("/img/icons.png");		// (String URL)
	
		// Конструктор ImageView(Image img)
	Image img7 = null;
	try {
		img7 = new Image(getClass().getResource("/img/icons.png").toExternalForm());	
		if (img7.isError()) new RuntimeException();				// Полезно делать такую проверку о правильности загрузки
		}
	catch (Exception e) {
		System.out.println("Не удалось загрузить изображение");
		return; }
	ImageView imf1 = new ImageView(img7);	
	
		// Помещение фото в ImageView
	imf.setImage(img7);
	
		// Ограничение области отображения (изображение будет изменено, чтобы вписаться в эту область)
	ImageView imf2 = new ImageView(img7);
	imf2.setFitWidth(70);			// Предпочтительная ширина изображения (если меньше или нуль, то исходная ширина изображения)
	imf2.setFitHeight(120);			// Предпочтительная высота изображения (если меньше или нуль, то исходная высота изображения)
	imf2.setPreserveRatio(true);	//  preserveRatio - при true изменение размеров с сохранением соотношения сторон,
	imf2.setSmooth(true);			// smooth - при true при изменении размеров будет использоваться сглаживание			
	imf.setCache(true);
	
		// Поворот изображения
	imf2.setRotate(180);
	
		// Получить информацию об изображении в данном ImageView
	System.out.println("Width = " + imf2.getImage().getWidth());
	System.out.println("Height = " + imf2.getImage().getHeight());
	System.out.println("URL = " + imf2.getImage().getUrl());
	
		// Координаты левого верхнего угла окна ImageView
	imf2.getX();
	imf2.getY();
	
		// Выбор фрагмента изображения, который будет показываться   Метод void setViewport (Rectangle2D value)
	ImageView imf4 = new ImageView(img3);
	ImageView imf5 = new ImageView(img3);
	imf4.setFitWidth(200);					imf5.setFitWidth(200);
	imf4.setFitHeight(200);					imf5.setFitHeight(200);
	imf4.setPreserveRatio(true);			imf5.setPreserveRatio(true);
		// Отображение фргмента шириной 300 пкс и высотой 200 пкс
	imf4.setViewport(new Rectangle2D(200, 100, 300, 200));
	
/*------------------------------------PIXEL READER----ПОЛУЧЕНИЕ ИНФОРМАЦИИ ОБ ОТДЕЛЬНОМ ПИКСЕЛЕ---------------------------*/
		// Получение объекта PixelReader     Если изображение не было загружено, то будет null 
	PixelReader pxl = img2.getPixelReader();
	
		// Информация о формате изображения
	PixelFormat pxf = pxl.getPixelFormat();
	System.out.println("Тип изображения " + pxf.getType());
	
		// Информация о цвете пиксиля, расположенног по указанным координатам
	Color color = pxl.getColor(10, 10);
	System.out.println(color.getRed() +  " " + color.getBlue() + " " + color.getGreen());
	
/*------------------------------------WRITEABLE IMAGE----СОЗДАНИЕ ИЗОБРАЖЕНИЯ-----------------------------------------------*/
		// Наследование Object - Image - WriteableImage         Может помещаться в ImageView
		/* КОНСТРУКТОРЫ
	 - WritableImage(int width, int height) 	- создает изображение указанного размера в формате PixelFormat.BYTE_BGRA_PRE
	  											  и с цветом пикселов 0x0000000000- полностью прозрачное изображение
	 - WritableImage(PixelReader reader, int width, int height) 				-позволяет создать изображение на основе изображения 
	 - WritableImage(PixelReader reader, int x, int y, int width, int height) 	-позволяет создать изображение на основе изображения 
		 									при чем, копирование начинается с определенного пиксела с координатам x и y */
		//Создание пустого изображения
	WritableImage wim = new WritableImage(50, 50);
		// Заливка всего изображения определенным цветов
	PixelWriter  pw = wim.getPixelWriter();
	for (int x= 0, w = (int)wim.getWidth(); x<w; x++) {
		for (int y= 0, h = (int)wim.getHeight(); y<h; y++) {
			pw.setColor(x, y, color.CHOCOLATE);
		}
	}
		// Копирование существующего изображения полностью и на выходе заданный размер
	img8 = new Image(getClass().getResourceAsStream("/img/icons.png"), 60, 60, true, true);
	WritableImage wim2 = new WritableImage(img8.getPixelReader(), (int)img8.getWidth(), (int)img8.getHeight());
	
		// Копирование отдельной области существующего изображения и на выходе заданный размер
	WritableImage wim3 = new WritableImage(img8.getPixelReader(), 0, 0, 60, 60);
		
	// Заливка отдельного пикселя
	PixelWriter  pw1 = wim3.getPixelWriter();
	pw1.setColor(0, 0, Color.RED);				// Заливка первого и второго пикселей красным цветом
	pw1.setColor(0, 1, Color.RED);
	
	
/*-------------------------ЗАПИСЬ ИЗОБРАЖЕНИЯ В ФАЙЛ   КЛАСС SWINGFXUTILS------------------------------------------------------
   Класс Image не поддерживает сериализацию, поэтому записать объект этого класса в файл не получится.
   Для этого используются статические методы класса SwingFXUtils, позволяющие преобразовать Image в BufferedImage и обратно  */
		// Создание одноцветного изображения
	WritableImage wim4 = new WritableImage(50, 50);
		// Заливка всего изображения определенным цветов
	PixelWriter  pw2 = wim4.getPixelWriter();
	for (int x= 0, w = (int)wim4.getWidth(); x<w; x++) {
		for (int y= 0, h = (int)wim4.getHeight(); y<h; y++) {
			pw2.setColor(x, y, color.CHOCOLATE);
		}
	}
		// Преобразование в BufferedImage объекта WritableImage
//	BufferedImage bim = SwingFXUtils.fromFXImage(wim4, null);
		// Преобразование в BufferedImage объекта Image
	Image img9 = new Image(getClass().getResourceAsStream("/img/icons.png"));
//	BufferedImage bim = SwingFXUtils.fromFXImage(img9, null);		// НЕ РАБОТАЕТ
//	BufferedImage bim2 = SwingFXUtils.fromFXImage(img9, null);
//		// Обратное преобразование
//	WritableImage wim5 = SwingFXUtils.toFXImage(bim2, null);
//	
//	
//	ImageView imf6 = new ImageView(wim5);
//	
	BorderPane pane = new BorderPane(imf2, lbl, imf4, imf5, imf3);
	Scene scene = new Scene(pane, 400, 400);
	primaryStage.setScene(scene); 
	primaryStage.setTitle("Add/Sub");
	primaryStage.show();
}
	public static void main(String[] args) {
		launch(args);
	}
}
