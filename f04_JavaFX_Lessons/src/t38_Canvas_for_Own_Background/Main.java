package t38_Canvas_for_Own_Background;
	
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

public class Main extends Application  {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl, lbl2;
	int i = 0;
	Image img1, img2, img3, img4, img5, img6, img7, img8;
	
	@Override 
public void start(Stage primaryStage) {	
		
/*--------------------------------------------КЛАСС CANVAS---------------------------------------------------------------------------
  позволяет программно рисовать на поверхности, называемой холстом. Можно нарисовать любую фигуру с заливкой и обводкой, вывести текст
  различными шрифтами, добавить изображение, применть эффекты.
  Холст позволяет обрабатывать все события мыши и клавиатуру, поэтому можно создавать собственные объекты произвольной формы.
  Отрисовка выполняется видеокартой, поэтому размер холста ограничен размерами текстуры (8192 пкс).			
  Иерарахия Object - Node - Canvas									 */
		
			/* КОНСТРУКТОРЫ
		- Canvas() 							  - холст с настройками по умолчанию
		- Canvas(double width, double height) - холст с определенными размерами 		 */
	Canvas cv1 = new Canvas();
	Canvas cv2 = new Canvas(100, 100);
		
			// Метод установки и получения размеров
	cv1.setWidth(400);		cv1.getWidth();
	cv1.setHeight(400);		cv1.getHeight();
		
			// Заливка фона однотонным цветом
	GraphicsContext gc2 = cv2.getGraphicsContext2D();
	gc2.setFill(Color.GREEN);								//
	gc2.fillRect(0, 0, cv2.getWidth(), cv2.getHeight());	// Заливает прямоуголник, каким яв-ся холст, по указанным коордианатам
		
			// Установка рамки
	gc2.setStroke(Color.BLACK);		
	gc2.strokeRect(2, 2, cv2.getWidth()-4, cv2.getHeight()-4);
	
			// Изменение характеристик обводки (рамки)
	 GraphicsContext gc3 = cv1.getGraphicsContext2D();
	 gc3.setFill(Color.WHITE);								
	 gc3.fillRect(0, 0, cv1.getWidth(), cv1.getHeight());	
	 gc3.setStroke(Color.BLUE);				// Цвет обводки
	 gc3.setLineWidth(3.0);					// Толщина обводки
	 gc3.setLineDashOffset(1);				// Задает смещение начала пунктирной линии
	 gc3.setLineDashes(25, 15);				//  Четные индексы задают длину штриха,  нечетные - длину пропуска
	 gc3.setLineCap(StrokeLineCap.ROUND);	// Задает форму окончания линии
	 gc3.setLineJoin(StrokeLineJoin.MITER);	// Задает форму окончания в месте соединения двух линий обводки
	 gc2.fillRect(0, 0, cv1.getWidth(), cv1.getHeight());
	 gc3.strokeRect(2, 2, cv1.getWidth()-4, cv1.getHeight()-4);
	 
	 /* Обводка пунктиром
	 
	 rectan1.setStroke(Color.BLACK);		rectan1.setStrokeWidth(2);
	 rectan1.getStrokeDashArray().addAll(25.0,15.0);
	 	// Форма окончания линии или штриха
	 rectan1.setStrokeLineCap(StrokeLineCap.SQUARE);
	 	// Управление сглаживанием  Иногда котнтур может отображаться лесенкой, для его сглаживания
	 polygon.setFill(Color.BROWN);
	 polygon.setStroke(Color.BLACK);
	 polygon.setStrokeWidth(2);
	 polygon.setSmooth(true);

	
/*--------------------------------------------КЛАСС GraphicsContext---------------------------------------------------------------------------
  описывает средства, позволяющие рисовать на холсте.			 */
		// Получение ссылки на объект GraphicsContext, связанный с данным холстом
	GraphicsContext gc6 = cv1.getGraphicsContext2D();		
		// Получение ссылки на объект Canvas из объекта GraphicsContext
	Canvas cv3 = gc3.getCanvas();
	
		// Заливка фона однотонным цветом
	gc3.setFill(Color.BEIGE);
	Paint curColor = gc3.getFill();
	
		// Установка изображения на фон
	Canvas cv4 = new Canvas(100, 100);
	GraphicsContext gc4 = cv4.getGraphicsContext2D();
    ImagePattern im = null; ;
    	// Установка  фонового рисунка, который растягивается на все окно
    try {
		im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg")));
		gc4.setFill(im);
	} catch (Exception e) {
		System.out.println("Не удалось загрузить изображение");
	}
    gc4.fillRect(0, 0, cv4.getWidth(), cv4.getHeight());
    
 		// Установка линейного градиента на фон
    Canvas cv5 = new Canvas(100, 100);
	GraphicsContext gc5 = cv5.getGraphicsContext2D();
    Stop[] stops = new Stop[] {new Stop(0, Color.BLACK), new Stop(1, Color.WHITE)};
//    gc5.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops));
    gc5.fillRect(110, 10, 40, 40);
    
    	// Изменение цвета пикселей
    PixelWriter pw = gc3.getPixelWriter();
    for (int x = 10; x<cv1.getWidth(); x++) pw.setColor(x, 40, Color.RED);		// Цвет линии из 1 пикселя
    
    	// Рисование прямой линий
    gc3.setStroke(Color.BLACK);
    gc3.setLineWidth(2);
    gc3.setLineDashes(5, 5);			// Пунктир для линии
    gc3.strokeLine(20, 20, 129, 20);    // Линия между двумя точками с координатами (x1, y1, x2, y2)
    
    	// Рисование красной точки
    gc3.setStroke(Color.RED);
    gc3.setLineWidth(5);
    gc3.setLineCap(StrokeLineCap.ROUND);		 // Задает форму окончания линии
    gc3.strokeLine(101, 100, 100, 100);   		 // Линия между двумя точками с координатами (x1, y1, x2, y2)
    
    	// Рисование ломанной линий  strokePolyline(double[] {x1,x2..xn}, double[] {y1,y2..yn}, int points);
    gc3.setStroke(Color.BLACK);
    gc3.setLineWidth(2);
    gc3.setLineJoin(StrokeLineJoin.MITER);			// Задает форму окончания в месте соединения двух линий обводки
    gc3.strokePolyline(new double[] {100,20,100}, new double[] {80,120,120}, 3);
    gc3.strokeLine(20, 20, 129, 20);    // Линия между двумя точками с координатами (x1, y1, x2, y2)
    
    	// Рисование дуги или сектора
    gc3.setStroke(Color.DARKGREEN);
    gc3.setLineWidth(3);
    gc3.strokeArc(10, 150, 100, 100, 45, 270, ArcType.OPEN);
    
    	// Рисование траектории       В примере ниже рисование треугольника
    gc3.setFill(Color.YELLOW);
    gc3.setStroke(Color.DARKGOLDENROD);
    gc3.setLineWidth(3);
    gc3.beginPath();
    gc3.moveTo(120,50);			// Стартовая  точка
    gc3.lineTo(200, 50);		// Линия в точку (200, 50)
    gc3.lineTo(200, 110);		// Следующая линия в точку (200, 110)
    gc3.closePath();			// Закрывают траекторию с возвратом в 1ую точку
    gc3.stroke();				// Рамка фигуры
    gc3.fill();					// Заливка фигуры
//  gc3.arcTo(10, 150, 100, 100, 45);			- рисует траекторию в форме дуги
    
    	// Рисование фигур
//  Чтобы сделать заливку нужно прописать до создания фигуры gc3.fill();
//  gc3.fillRect(100, 100, 150, 150);	 			  	  // Прямоугольник c заливкой
//  gc3.fillRoundRect(100, 100, 150, 150, 20, 20);	 	  // Прямоугольник c кругленными краями  c заливкой
//  gc3.strokeRect(100, 100, 150, 150);	 			  	  // Прямоугольник c рамкой
//  gc3.strokeRoundRect(100, 100, 150, 150, 20, 20);	  // Прямоугольник c кругленными краями c рамкой
//  gc3.fillOval(20, 100, 100, 40); 					  // Овал с заливкой
//  gc3.strokeOval(20, 100, 100, 40); 					  // Овал с рамкой
//  gc3.fillPolygon(new double [] {100, 20, 100} , new double[] {180, 220, 220}, 3);	// Многоугольник с заливкой
//  gc3.strokePolygon(new double [] {100, 20, 100} , new double[] {180, 220, 220}, 3);	
    
    	// ТЕКСТ
    gc3.setFill(Color.BLACK);
    gc3.setFont(new Font(24));					// Установка шрифта
    gc3.setTextAlign(TextAlignment.CENTER);		// Задает гориз.выравнивание относительно точки  
    gc3.setTextBaseline(VPos.CENTER);			// Задает вертик.выравнивание относительно точки    
    gc3.fillText("TEXT", 220, 70, 20);			// Установка надписи, координаты точки ориентира для текста и ширина поля для текста
    	// Текст сжимается, чтобы полностью влез в поле установленной ширины
    	// Чтобы текст не сжимался, а просто обрезался, нужно наложить маску
    gc3.save();							// Метод сохраняет в стеке текущие значения различных характеристик
    gc3.beginPath();
    gc3.rect(210, 145, 225, 160);			// Определяет границы маски
    gc3.clip();
    gc3.fillText("TEXT", 220, 150);
    gc3.restore();						// Восстанливает значения хар-к, сохраненных методом save()
    
    	// Изображение
    WritableImage img = new WritableImage(100, 100);				
    gc3.drawImage(img, 20, 20);					// (img, x, y) Вывод изображение в позицию с координатами x,y
    gc3.drawImage(img, 20, 20, 50, 50);			// (img, x, y,w,h)  Вывод изображение в позицию с координатами x,y в окно с заданным
    											// w,h. Изображение уменьшается или увеличивается ,чтобы вписаться в эту область. 
    											// При этом изображение будет растянуто или сжато
    gc3.drawImage(img, 0, 0, 50, 50,			// (img,sx,sy,sw,sh,dx,dy,dw,dh) - берет из изображения прямоугольный фрагмент 
    				   20, 20, 50, 50);			// (sx,sy,sw,sh) и вписывает его в окно (dx,dy,dw,dh)
    
    	// Очистка прямоугольной области или всего холста
//    gc3.clearRect(50, 100, 50, 100); 						// (x,y,w,h) Стирает фрагмент
//    gc3.clearRect(0, 0, cv1.getWidth(), cv1.getHeight()); 	// (x,y,w,h) Стирает весь канвас
    
    	// Трансформация фигуры
    	// Задает степень непрозрачности от 0.0 до 1.0 (непрозрачный)
    gc3.save();
    	gc3.setFill(Color.BLUE);
	    gc3.setGlobalAlpha(0.5);					 
	//    gc3.fillRect(150, 150, 40, 40);
	    gc3.setGlobalBlendMode(BlendMode.ADD);			// save(), restore(), чтобы это имело эффект только на фигуру
    gc3.restore();
    	// Задает наложение цветовое при пересечении двух фигур
    gc3.setFill(Color.GREEN);
//    gc3.fillRect(150, 150, 40, 40);
    gc3.save();
	    gc3.setFill(Color.BLACK);
	    gc3.setGlobalAlpha(0.5);					 
	//    gc3.fillRect(150, 130, 40, 40);
	    gc3.setGlobalBlendMode(BlendMode.OVERLAY);			
    gc3.restore();		
    	// Изменяет масштабирование
    gc3.save();
	    gc3.scale(2.0, 2.0);
//	    gc3.fillRect(75, 65, 40, 40);
    gc3.restore();	
    	// Вращает 
    gc3.save();
   		gc3.rotate(45.0);
    	gc3.fillRect(75, -20, 40, 40);		// Вращение прямоугольника на 45 гр относительно левого верхнего угла
    gc3.restore();
    	// Сдвигает систему координат		Ниже пример вращения прямоугол. на 45 градусов относительно точки вставки
    gc3.save();
    gc3.setStroke(Color.GREEN);
    gc3.translate(200, 200);
    gc3.rotate(45);
    gc3.strokeRect(0, 0, 40, 40);
    gc3.restore();
    	// Матрица трансформации		Ниже пример вращения прямоугол. на 45 градусов относительно центра прямоуголника
    gc3.save();
    gc3.setFill(Color.BLUE);
    double x = 150, y=150, width = 50, height = 50;
    Rotate r = new Rotate(45, x+width/2, y+height/2);
    gc3.setTransform(r.getMxx(), r.getMyx(), 
    				 r.getMxy(), r.getMyy(), 
    				 r.getTx(), r.getTy());
    gc3.fillRect(x, y, width, height);
    gc3.restore();
    	// Задает эффект для последующих операций     для отключения нужно передать  null
    gc3.save();
    gc3.setEffect(new DropShadow());		// накладывает тень
    gc3.setFill(Color.BISQUE);
    gc3.fillRect(30,300, 50, 50);
    gc3.restore();
    	// Применяет эффект ко всему холсту
    gc3.applyEffect(new DropShadow());
    	// ФИГИУРЫ  Смещение по осям, увеличение масштаба, поворот  
    Rectangle rect = new Rectangle(50,50);
    rect.setFill(Color.DARKORANGE);
    rect.setScaleX(2);			// в 2 раза
    rect.setScaleY(2);
    rect.setScaleZ(0);
    rect.setTranslateX(250);
    rect.setTranslateY(50);
    rect.setTranslateZ(0);
    rect.setRotate(45);			// По умолчанию вращения вокруг оси Z
    	// ФИГУРЫ Вращение вокруг других осей
    Rectangle rect2 = new Rectangle(50,50);
    rect2.setFill(Color.DARKORANGE);
    rect2.setRotationAxis(Rotate.X_AXIS);
    rect2.setRotate(45);
    	// ФИГУРЫ  Одновременное вращение по нескольким осям
    Rectangle rect3 = new Rectangle(50,50);
    rect3.setFill(Color.DARKORANGE);
    Rotate rx = new Rotate(30, Rotate.X_AXIS);
    Rotate ry = new Rotate(50, Rotate.Y_AXIS);
    Rotate rz = new Rotate(30, Rotate.Z_AXIS);
    rect3.getTransforms().addAll(rx,ry,rz);
    	
    	/* Траснформация через класс Transform, Affine
     Матрица {	mxx, mxy, mxz, tx
     			myx, myy, myz, ty, 
     			mzx, mzy, mzz, tz}
     Вычисление координат проводится так: 
     		x = mxx*x + mxy*y + mxz*z +tx
     		y = myx*x + myy*y + myz*z +ty
     		x = mzx*x + mzy*y + mzz*z +tz		  	 */
    	// Ниже пример по смещению на 100 пкс по осям x,y
    Affine m2 = new Affine	(1, 0, 0, 100,
    						 0, 1, 0, 100,
    						 0, 0, 1, 0);
    Rectangle rect4 = new Rectangle(50,50);
    rect4.setFill(Color.DARKGRAY);
    rect4.getTransforms().add(m2);
    	// Ниже пример по увеличению масштаба в 2 раза   Метод affine() равноценен созданию матрицы через конструктор
    Affine m3 = Transform.affine   (2, 0, 0, 0,
    								0, 2, 0, 0,
    								0, 0, 2, 0);
    	// Изменение матрицы после ее создания
    m2.setMxx(0);
    m2.setMxy(0); 		   // и т.п.
    	// Получение значений матрицы
    m2.getMxx();
    m2.getMxy(); 		   // и т.п.
    System.out.println(m2.toString());
    
    	// СМЕЩЕНИЕ ЧЕРЕЗ КЛАСС Translate
    Translate tr2 = new Translate(100, 50, 0);		// Смещение по оси х на 100, и по оси у на 50
    Rectangle rect5 = new Rectangle(50,50);
    rect5.setFill(Color.DARKGRAY);
    rect4.getTransforms().add(tr2);
    	// Изменение матрицы после ее создания
    tr2.setX(0);
    tr2.setY(0); 		   // и т.п.
    	// Получение значений матрицы
    tr2.getX();
    tr2.getY();
    
    	// 	МАСШТАБИРОВАНИЕ ЧЕРЕЗ КЛАСС SCALE
  /* Конструктор Scale(x, y, z, pivotX, pivotY, pibotZ)
   При этом создается матрица {	x, 0, 0, ((1-x)*pivotX)
     							0, y, 0, ((1-y)*pivotY) 
     							0, 0, z, ((1-z)*pivotZ)}		  	
     где x,y,z - масштаба по осям
         pivotX.. - координата опорной точки относителько которой делается масштабирование	    		 */
    	// Ниже пример по маштабированию прямоуголтнкиа в 2 раза относительно цента прямоугольника
    Scale tr5 = new Scale(2, 2, 1, 25, 25, 0);
    Rectangle rect6 = new Rectangle(50, 50);
    rect6.setFill(Color.BLACK);
    rect6.getTransforms().add(tr5);
    	// Изменение матрицы после ее создания
    tr5.setX(0);
    tr5.setPivotY(0); 		   // и т.п.
    	// Получение значений матрицы
    tr5.getX();
    tr5.getPivotX();
    
    	/* ВРАЩЕНИЕ ЧЕРЕЗ ROTATE
    Конструктор Rotate(angle, pivotX, pivotY)
    Конструктор Rotate(angle, pivotX, pivotY, pivotZ)
    Конструктор Rotate(angle, Point3D axis)
    Конструктор Rotate(angle, pivotX, pivotY, pivotZ, Point3D axis)
    	где angle - угол вращения в углах
    	    axis - создает ось, вокргу которой происходит вращение. По умолчанию Rotate.Z_AXIS  
    	    pivotX.. - координаты опорной точки, относительно которой выполняется вращение	   */
    // Ниже пример вращения прямоугольника на 45 гр относительно центра его
    Rotate tr6 = new Rotate(45,25,25);
    Rectangle rect7 = new Rectangle(50, 50);
    rect7.setFill(Color.LAVENDER);
    rect.getTransforms().addAll(tr6);
    
    	/* СДВИГ ЧЕРЕЗ SHEAR
    Конструктор Shear(x,y)
    Конструктор Shear(x,y, pivotX, pivotY)
    	где x,y - сдвиг по оси x,y
    	     pivotX - координаты опорной точки   	 */
    	
    	/* ЭФФЕКТЫ  ВНЕШНЯЯ ТЕНЬ
    Конструктор Dropshadow()
    Конструктор Dropshadow(radius, color)
    Конструктор Dropshadow(radius, offsetX, offsetY, color)
    Конструктор Dropshadow(blurType, color, radius, spread, offsetX, offsetY)
     где blurType - задает алгоритм размытия тени 
      	 radius - радиус размытия тени. Можно указать от 0 до 127. По умолчанию - 10
      	 spread - если 0, то тень полностью определяется алгоритмом размытия blurType
      	  		  если 1, то размытие отсутсвуте
      	  		  если 0-1, то позволяет контролировать степень размытия
      	 offsetX - смещенеи тени по оси Х. По умолчанию - 0
      	 offsetУ - смещение тени по У. По умолчанию - 0    	 */
    // Пример создания тени со смещением
    DropShadow effect3 = new DropShadow(20, 10, 10, Color.BLACK);
    Rectangle rect8 = new Rectangle(50, 50);
    rect8.setFill(Color.LAVENDER);
    rect8.setEffect(effect3);
    
    	/* ЭФФЕКТЫ  ВНУТРЕННЯЯ ТЕНЬ
    Конструктор InnerShadow()
    Конструктор InnerShadow(radius, color)
    Конструктор InnerShadow(radius, offsetX, offsetY, color)
    Конструктор InnerShadow(blurType, color, radius, choke, offsetX, offsetY)
     где blurType - задает алгоритм размытия тени 
      	 radius - радиус размытия тени. Можно указать от 0 до 127. По умолчанию - 10
      	 choke - если 0, то тень полностью определяется алгоритмом размытия blurType
      	  		  если 1, то размытие отсутсвуте
      	  		  если 0-1, то позволяет контролировать степень размытия
      	 offsetX - смещенеи тени по оси Х. По умолчанию - 0
      	 offsetУ - смещение тени по У. По умолчанию - 0    	 */
    // Пример создания тени со смещением
    InnerShadow effect4 = new InnerShadow(20, 10, 10, Color.BLACK);
    Rectangle rect9 = new Rectangle(50, 50);
    rect9.setFill(Color.LAVENDER);
    rect9.setEffect(effect4);
    
    	/* ЭФФЕКТЫ  ТЕНЬ   (просто превращает узел в тень, а не добавляет тень к узлу)
    Конструктор Shadow()
    Конструктор Shadow(radius, color)
    Конструктор Shadow(blurType, color, radius)
     где blurType - задает алгоритм размытия тени 
      	 radius - радиус размытия тени. Можно указать от 0 до 127. По умолчанию - 10
      	 choke - если 0, то тень полностью определяется алгоритмом размытия blurType
      	  		  если 1, то размытие отсутсвуте
      	  		  если 0-1, то позволяет контролировать степень размытия
      	 offsetX - смещенеи тени по оси Х. По умолчанию - 0
      	 offsetУ - смещение тени по У. По умолчанию - 0    	 */
    // Пример создания тени со смещением
    Shadow effect5 = new Shadow(40, Color.BLACK);
    Rectangle rect10 = new Rectangle(50, 50);
    rect10.setFill(Color.LAVENDER);
    rect10.setEffect(effect5);
    
    	/* ЭФФЕКТЫ  ЗЕРКАЛЬНОЕ ОТРАЖЕНИЕ
    Конструктор Reflection()
    Конструктор Reflection(topOffSet, fraction, topOpacity, bottomOpacity)
     где topOffSet - смещение отражения от нижней границы узла
 		 fraction - часть узла, видимая в отражении. Значение от 0 до 1. По умолчанию - 0,75
 		 topOpacity -степень непрозрачности верхней части отражения. Значение от 0 до 1. По умолчанию - 0,0
 		 bottomOpacity - степень непрозрачности нижней части отражения. Значение от 0 до 1. По умолчанию - 0,0  */
    // Пример добавления зеркального отражения к тексту
    Reflection effect6 = new Reflection(-20.0, 0.7, 0.5, 0.0);
    Text text = new Text("JavaFX");
    text.setFont(new Font(40));
    text.setEffect(effect6);

    	/* ЭФФЕКТЫ  РАЗМЫТИЕ ПО ГАУССУ
    Конструктор GaussianBlur()
    Конструктор GaussianBlur(radius)
     где radius - радиус размытия. Значение от 0 до 63. По умолчанию - 10			*/
    	// Пример добавления к тексту
    Text text1 = new Text("JavaFX");
    text1.setFont(new Font(40));
    text1.setEffect(new GaussianBlur());
    
    	/* ЭФФЕКТЫ  РАЗМЫТИЕ В ДВИЖЕНИИ
    Конструктор MotionBlur()
    Конструктор MotionBlur(angle, radius)
     	где radius - радиус размытия. Значение от 0 до 63. По умолчанию - 10			
    	 	angle - угол размытия в градусах. По умолчанию - 0 */
    // Пример добавления к тексту
    Text text2 = new Text("JavaFX");
    text2.setFont(new Font(40));
    text2.setEffect(new MotionBlur());
    
    	/* ЭФФЕКТЫ  РАЗМЫТИЕ BOXBLUR
    Конструктор BoxBlur()
    Конструктор BoxBlur(width, height, iterations)
     	где width - горизонтальный размер размытия. Значение от 0 до 255. По умолчанию - 5			
    	 	height - вертикальный размер размытия. Значение от 0 до 255. По умолчанию - 5 
    	 	iterations - количество применений эффекта. Значение от 0 до 3. По умолчанию - 1    	 	*/
    Text text3 = new Text("JavaFX");
    text3.setFont(new Font(40));
    text3.setEffect(new BoxBlur(5,5,3));
    
    	/* ЭФФЕКТЫ  СВЕЧЕНИЕ
    Конструктор Bloom()
    Конструктор Bloom(threshold)
     	где threshold - порог свечения. Значение от 0 до 1. По умолчанию - 0,3	*/
    Text text4 = new Text("JavaFX");
    text4.setFont(new Font(40));
    text4.setEffect(new Bloom(0.5));
    
    	/* ЭФФЕКТЫ  СВЕЧЕНИЕ GLOW
    Конструктор Glow()
    Конструктор Glow(level)
     	где level - интенсивность свечения. Значение от 0 до 1. По умолчанию - 0,3	*/
    Text text5 = new Text("JavaFX");
    text5.setFont(new Font(40));
    text5.setEffect(new Glow(0.5));
    
    	// ЭФФЕКТЫ Трансформация перспективы PerspectiveTransform
    
    	/* ЭФФЕКТЫ  Изменение цветового тона, насыщенности, яркости, 
    Конструктор СolorAdjust()
    Конструктор СolorAdjust(hue, saturation, brightness, contrast)
     	где hue - регилировка цветового тона. Значение от -1 до 1. По умолчанию - 0,0
     		saturation - регилировка насыщенности. Значение от -1 до 1. По умолчанию - 0,0
     		brightness - регилировка яркости. Значение от -1 до 1. По умолчанию - 0,0
     		contrast - регилировка контраста. Значение от -1 до 1. По умолчанию - 0,0		     		*/
    Text text6 = new Text("JavaFX");
    text6.setFill(Color.BLUE);
    text6.setFont(new Font(40));
    text6.setEffect(new ColorAdjust(-0.5, 0, -0.5, 0));
    
   		/* ЭФФЕКТЫ  CОСТАРИВАНИЯ 
    Конструктор SepiaTone()
    Конструктор SepiaTone(level)
     	где level - интесивность состаривания. Значение от 0 до 1. По умолчанию - 1,0		     		*/

    	/* ЭФФЕКТЫ  ОСВЕЩЕНИЕ ИСТОЧНИКОМ СВЕТА
    	Конструктор Lighting()
    	Конструктор Lighting(Light light)
     	где light - задает источник света. По умолчанию исп-ся Light.Distant		     		*/
    Lighting effect7 = new Lighting();
    Light.Distant light = new Light.Distant();
    effect7.setLight(light);			// setLight() задает источник света. По умолчанию исп-ся Light.Distant		     		
    effect7.setDiffuseConstant(1);		// setDiffuseConstant() - задает рассеивание свет. Значение - от 0 до 2.По умолчанию - 1
    effect7.setSpecularConstant(1);		// setSpecularConstant() - задает отражение света в центре. Значение - от 0 до 2.По умолчанию - 0,3
    effect7.setSpecularExponent(1);		// setSpecularExponent() - отражение света по краям. Значение - от 0 до 40.По умолчанию - 20
    effect7.setSurfaceScale(1);			// setSurfaceScale() - коэффициент масштаба поверхности. Значение - от 0 до 10.По умолчанию - 1,5
    effect7.setBumpInput(new DropShadow());		// setBumpInput(Effect value) - задает входные данные для создания рельефа
    											// поверхности. По умолчанию - эффект Shadow c радиумос размытия 10
    effect7.setSpecularExponent(1);		// setSpecularExponent() - отражение света по краям. Значение - от 0 до 40.По умолчанию - 20
    Text text7 = new Text("JavaFX");
    text7.setFill(Color.WHITE);
    text4.setFont(new Font(40));
    text4.setEffect(effect7);
    
	   		/* КЛАСС LIGHT
	   	задается с помощью статических классов: Light.Distant, Light.Point, Light.Spot
	   	Light.Distant - описывает равномерно светящийся удаленный источник света (солнце)
	   	Light.Point - описывает точечный источник света (эффект фонарика, светящего сверху вниз под прямум углом 
	   	Light.Spot - расширяет Light.Point описывает фонарик, светящий под разными углами  */
	Lighting effect8 = new Lighting();
		/* Light.Distant 
	 Конструктор Distant()
	 Конструктор Distant(azimuth, elevation, color)		 */
	Light.Distant light1 = new Light.Distant();
	light1.setAzimuth(45);			// Задает азимут (угол направления в градусах к плоскости XY. По умолчанию - 45
	light1.setElevation(45);		// Задает высоту (угол направления в градусах к плоскости YZ. По умолчанию - 45
	light1.setColor(Color.WHITE);	// Задает цвет источника света. По умолчанию - белый
		/* Light.Point 
	 Конструктор Point()
	 Конструктор Point(x, y, z, color)		 */
	Light.Point light2 = new Light.Point();
	light2.setX(100);			// Положение источника света по оси Х. По умолчанию - 0
	light2.setY(50);			
	light2.setZ(100);			
	light2.setColor(Color.WHITE);	// Задает цвет источника света. По умолчанию - белый
		/* Light.Spot 
	 Конструктор Spot()
	 Конструктор Spot(x, y, z, specularExponent, color)		 */
	Light.Spot light3 = new Light.Spot();
	light3.setX(100);					// Положение источника света по оси Х. По умолчанию - 0
	light3.setY(50);			
	light3.setZ(100);
	light3.setPointsAtX(100);			// Координата вектора направления источника света по оси Х. По умолчанию 0
	light3.setPointsAtY(50);			// Координата вектора направления источника света по оси Y. По умолчанию 0
	light3.setPointsAtZ(0);				// Координата вектора направления источника света по оси Z. По умолчанию 0
	light3.setColor(Color.WHITE);		// Задает цвет источника света. По умолчанию - белый
	light3.setSpecularExponent(1);		// Управляет фокусом. Значение от 0 до 4. По умолчанию - 1
	
		/* ЭФФЕКТЫ  СМЕШИВАНИЕ
	верхнего ввода с нижним, используя режимы наложения в перечислении BlendMode 
    Конструктор Blend()
    Конструктор Blend(Blendmode mode)
    Конструктор Blend(Blendmode mode, Effect bottomInput, Effect topInput)
     	где hue - регилировка цветового тона. Значение от -1 до 1. По умолчанию - 0,0
     		saturation - регилировка насыщенности. Значение от -1 до 1. По умолчанию - 0,0
     		brightness - регилировка яркости. Значение от -1 до 1. По умолчанию - 0,0
     		contrast - регилировка контраста. Значение от -1 до 1. По умолчанию - 0,0		     		*/
	ColorInput colorInput = new ColorInput();
	colorInput.setPaint(Color.WHITE);
	colorInput.setX(50);
	colorInput.setY(50);
	colorInput.setWidth(70);
	colorInput.setHeight(70);
	Blend effect9 = new Blend();
	effect9.setMode(BlendMode.OVERLAY);		// задает режим смешивания верхнего ввода с нижним. По умолчанию Blend.SRC_OVER
	effect9.setTopInput(colorInput);		// Верхний ввод. Если null (по умолчанию), то в качестве входных данных используется
												// изображение узла, к которому применяется эффект
	//effect9.setBottomInput();				// Нижний ввод. Если null (по умолчанию), то в качестве входных данных используется
												// изображение узла, к которому применяется эффект
	effect9.setOpacity(0.9);				// задает степень непрозрачности верхнего ввода. От 0 до 1 (непрозрачный) - по умолчанию
	
	Rectangle rect11 = new Rectangle(100, 100);
	rect11.setFill(Color.GREEN);
	rect11.setEffect(effect9);
	
		/* КЛАСС COLORINPUT
		позволяет использовать прямоуголную область с заливкой в качестве исходных входных даннных для эффекта
		Конструктор ColorInput()
		Конструктор ColorInput(x, y, width, height, Paint paint)		 */
	ColorInput colorInput1 = new ColorInput();
	colorInput1.setPaint(Color.WHITE);	// Задает хар-ки заливки
	colorInput1.setX(50);				// Координата левого верхнего угла прям.обл-ти по оси х
	colorInput1.setY(50);				// Координата левого верхнего угла прям.обл-ти по оси у
	colorInput1.setWidth(70);			// Ширина прям.обл-ти
	colorInput1.setHeight(70);
	
		/* КЛАСС IMAGEINPUT
		позволяет использовать прямоуголную область с заливкой в качестве исходных входных даннных для эффекта
		Конструктор ImageInput()
		Конструктор ImageInput(Image source)		 
		Конструктор ImageInput(Image source, x,y)			*/
	WritableImage wim = new WritableImage(70,70);
	PixelWriter pw1 = wim.getPixelWriter();
	for (int x1=0, w=(int)wim.getWidth(); x1<w; x1++) 
		for (int y1=0, h=(int)wim.getWidth(); y1<h; y1++)
				pw1.setColor(x1, y1, Color.WHITE);
	ImageInput imageInput = new ImageInput();
	imageInput.setSource(wim);					// Задает изображение
	imageInput.setX(50);						// Координата левого верхнего угла прям.обл-ти по оси х
	imageInput.setY(50);						// Координата левого верхнего угла прям.обл-ти по оси у
	Blend effect10 = new Blend(BlendMode.DIFFERENCE, null, imageInput);
	Rectangle rect14 = new Rectangle(100,100);
	rect14.setFill(Color.BLUE);
	rect14.setEffect(effect10);
    
	BorderPane pane = new BorderPane(cv4, cv1, cv2, null, null);
	Scene scene = new Scene(pane, 600, 600);
	primaryStage.setScene(scene); 
	primaryStage.setTitle("Add/Sub");
	primaryStage.show();
}
	public static void main(String[] args) {
		launch(args);
	}
}
