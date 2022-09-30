package t41_2D_Figures;
	
import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

public class Main extends Application  {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl, lbl2;
	int i = 0;
	
		@Override 
	public void start(Stage primaryStage) {	
		HBox pane = new HBox(10);
/*----------------------------------------------POINT---------------------------------------------------------------------------*/
		Point2D p = new Point2D (10.0,10.0);
		Point2D p2 = Point2D.ZERO;
		Point2D p3 = new Point2D (5.0,5.0);
		System.out.println(p2);
				// Методы GET
		System.out.println("Координата х = " + p.getX());
		System.out.println("Координата y = " + p.getY());
				// СРАВНЕНИЕ ДВУХ ТОЧЕК
		System.out.println(p.equals(p2));
				// СЛОЖЕНИЕ ВЕКТОРОВ
		System.out.println("СЛОЖЕНИЕ ВЕКТОРОВ " + p.add(p3));
				// ВЫЧИТАНИЕ ВЕКТОРОВ
		System.out.println("ВЫЧИТАНИЕ ВЕКТОРОВ " + p.subtract(p3));
				// УМНОЖЕНИЕ ВЕКТОРА НА СКАЛЯР
		System.out.println("УМНОЖЕНИЕ ВЕКТОРА НА СКАЛЯР " + p.multiply(5));
				// РАСТОЯНИЕ МЕЖДУ ТОЧКАМИ
		System.out.println("РАСТОЯНИЕ МЕЖДУ ТОЧКАМИ " + p.distance(p2));
				// ДЛИНА ВЕКТОРА
		System.out.println("ДЛИНА ВЕКТОРА " + p.magnitude());
				// CКАЛЯРНОЕ ПРОИЗВЕДЕНИЕ ВЕКТОРОВ
		System.out.println("СКАЛЯРНОЕ ПРОИЗВЕДЕНИЕ ВЕКТОРОВ " + p.dotProduct(p2));
				// ВЕКТОРНОЕ ПРОИЗВЕДЕНИЕ ВЕКТОРОВ
		System.out.println("ВЕКТОРНОЕ ПРОИЗВЕДЕНИЕ ВЕКТОРОВ " + p.crossProduct(p2));
				// КООРДИНАТЫ ТОЧКИ ПО СЕРЕДИНЕ МЕЖДУ ЗАДАННЫМИ
		System.out.println("КООРДИНАТЫ ТОЧКИ ПО СЕРЕДИНЕ МЕЖДУ ЗАДАННЫМИ " + p.midpoint(p2));
				// УГОЛ МЕЖДУ ВЕКТОРАМИ ИЛИ ТРЕМЯ ТОЧКАМИ
		System.out.println("УГОЛ " + p.angle(p2, p3));		System.out.println();
	
/*----------------------------------------------ПРЯМОУГОЛЬНИК-----------------------------------------------------------------------*/
				// КЛАСС Dimension2D задает прямоугольник определенных размеров
		Dimension2D rect = new Dimension2D(10.0,15.0);
		System.out.println(rect);
				// Методы GET
		System.out.println("Ширина = " + rect.getWidth());
		System.out.println("Длина = " + rect.getHeight());
		
				// КЛАСС Rectangle2D задает прямоугольник определенных размеров и с указанием координат
		Rectangle2D rect2 = new Rectangle2D(0.0, 0.0, 10.0, 15.0);  // (minX, minY, width, height)
		Rectangle2D rect3 = new Rectangle2D(5.0, 5.0, 10.0, 15.0);  // (minX, minY, width, height)
		System.out.println(rect2);
				// Методы GET
		System.out.println("Ширина = " + rect2.getWidth());
		System.out.println("Длина = " + rect2.getHeight());
				// КООРДИНАТЫ ЛЕВОГО ВЕРХНЕГО УГЛА
		System.out.println("КООРДИНАТЫ ЛЕВОГО ВЕРХНЕГО УГЛА = " + rect2.getMinX() + "  " + rect2.getMinY());
				// КООРДИНАТЫ ПРАВОГО НИЖНЕГО УГЛА
		System.out.println("КООРДИНАТЫ ПРАВОГО НИЖНЕГО УГЛА = " + rect2.getMaxX() + "  " + rect2.getMaxY());
				// СРАВНЕНИЕ
		System.out.println(rect2.equals(rect3));
				// ОПРЕДЕЛЕНИЕ ПЕРЕСЕЧЕНИЯ
		System.out.println("Прямоуголники пересекаются - " + rect2.intersects(rect3));
				// ОПРЕДЕЛЕНИЕ СОДЕРЖАНИЯ ОДНОГО ПРЯМОУГОЛЬНИКА В ДРУГОМ
		System.out.println(" ОПРЕДЕЛЕНИЕ СОДЕРЖАНИЯ " + rect2.contains(rect3));  System.out.println();

/*----------------------------ОБЛАСТЬ ВНУТРИ КОТОРОЙ НАХОДИТСЯ УЗЕЛ-----------------------------------------------------------------*/		
		BoundingBox b = new BoundingBox(0, 0, 10, 20);				// Создает область по точкам
		BoundingBox b2 = new BoundingBox(0, 0, 10, 20, 10, 20);		// Создает область по точкам в 3D
				// КООРДИНАТЫ ЛЕВОГО ВЕРХНЕГО УГЛА
		System.out.println("КООРДИНАТЫ ЛЕВОГО ВЕРХНЕГО УГЛА = " + b.getMinX() + "  " + b.getMinY());
				// КООРДИНАТЫ ПРАВОГО НИЖНЕГО УГЛА
		System.out.println("КООРДИНАТЫ ПРАВОГО НИЖНЕГО УГЛА = " + b.getMaxX() + "  " + b.getMaxY());
				// Методы GET
		System.out.println("Ширина = " + b.getWidth());
		System.out.println("Длина = " + b.getHeight());
				// КООРДИНАТЫ ЦЕНТРА ОБЛАСТИ
		System.out.println("КООРДИНАТЫ ЦЕНТРА ОБЛАСТИ = " + b2.getCenterX() + "  " + b2.getCenterY() + "  " + b2.getCenterZ());
				// ОПРЕДЕЛЕНИЕ ПЕРЕСЕЧЕНИЯ
		System.out.println("Пересекаются - " + b.intersects(b2));
				// ОПРЕДЕЛЕНИЕ СОДЕРЖАНИЯ ОДНОГО ПРЯМОУГОЛЬНИКА В ДРУГОМ
		System.out.println(" ОПРЕДЕЛЕНИЕ СОДЕРЖАНИЯ " + b.contains(b2));  System.out.println();
		
/*----------------------------КЛАСС SHAPE - базовый класс для фигур + яв-ся наследником NODES----------------------------------------
   Так как яв-ся наследником Node, то его можно добавлять на Scene */
			// ПРЯМОУГОЛЬНИ
		Shape rectan = new Rectangle(0.0, 0.0, 100.0, 150.0);  // (minX, minY, width, height)
		Shape rectan1 = new Rectangle(5.0, 5.0, 150.0, 200.0);  // (minX, minY, width, height)
			// МНОГОУГОЛЬНИК
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[] {
				0.0, 0.0,
				150.0, 50.0,
				0.0, 100.0
		});
		
		Shape line = new Line(0.0, 0.0, 10.0, 15.0);  
			// Метод union() - возвращает фигуру, которая яв-ся результатам объединения 2-х
		Shape fig = Shape.union(rectan1, rectan);
			// Метод subtract() - возвращает фигуру, которая яв-ся результатам вычитания 2-х
		Shape fig2 = Shape.subtract(rectan1, rectan);
			// Метод intersect() - возвращает фигуру, которая яв-ся результатам пересечения 2-х
		Shape fig3 = Shape.intersect(rectan1, rectan);
			// Изменение фона фигуры на сплошной цвет
		rectan.setFill(Color.BLUE);		 
			// Изменение фона фигуры на рисунок
		 try {
				ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
				rectan1.setFill(im);
			} catch (Exception e) {
				System.out.println("Не удалось загрузить изображение");
			}
		 
		 
		 	// Изменение характеристик обводки (рамки)
		 rectan.setStroke(Color.BLACK);				// Цвет обводки
		 rectan.setStrokeWidth(3.0);				// Толщина обводки
		 rectan.setStrokeType(StrokeType.CENTERED);	// Расположение обводвки относительно фигуры
		 	/* Обводка пунктиром
		 Нужно вызвать метод getStrokeDashArray() и добавить в список значения. Четные индексы задают длину штриха,
		 нечетные - длину пропуска 	 	 */
		 rectan1.setStroke(Color.BLACK);		rectan1.setStrokeWidth(2);
		 rectan1.getStrokeDashArray().addAll(25.0,15.0);
		 	// Форма окончания линии или штриха
		 rectan1.setStrokeLineCap(StrokeLineCap.SQUARE);
		 	// Управление сглаживанием  Иногда котнтур может отображаться лесенкой, для его сглаживания
		 polygon.setFill(Color.BROWN);
		 polygon.setStroke(Color.BLACK);
		 polygon.setStrokeWidth(2);
		 polygon.setSmooth(true);

/*---------------------------------------------------КЛАСС RECTANGLE  (SHAPE)-------------------------------------------------- */
		 	// Конструктор
		Rectangle rectan2 = new Rectangle();
		Rectangle rectan3 = new Rectangle(100,500);					// (width, height)
		Rectangle recta4 = new Rectangle(0,0,50,70);				// (x, y, width, height)
		Rectangle rectan5 = new Rectangle(100,500,Color.BLACK);		// (width, height, Color)
			// Методы изменения координат точек и размеров
		rectan3.setX(1.0);					// Управление координатами левого верхнего угла
		rectan3.setY(1.0);
		rectan3.setWidth(100.0);			// Управление размерами прямоугольника
		rectan3.setHeight(70.0);
			// Изменение заливки
		rectan5.setFill(Color.BLUE);		 
			// Изменение фона фигуры на рисунок
		try {
				ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
				rectan5.setFill(im);
		} catch (Exception e) {
				System.out.println("Не удалось загрузить изображение");
		}
		 	// Изменение характеристик обводки (рамки)
		rectan5.setStroke(Color.BLACK);				// Цвет обводки
		rectan5.setStrokeWidth(3.0);				// Толщина обводки
		rectan5.setStrokeType(StrokeType.CENTERED);	// Расположение обводвки относительно фигуры
		 	/* Обводка пунктиром
		 Нужно вызвать метод getStrokeDashArray() и добавить в список значения. Четные индексы задают длину штриха,
		 нечетные - длину пропуска 	 	 */
		rectan5.setStroke(Color.BLACK);		
		rectan5.setStrokeWidth(2);
		rectan5.getStrokeDashArray().addAll(25.0,15.0);
		 	// Форма окончания линии или штриха
		rectan5.setStrokeLineCap(StrokeLineCap.SQUARE);
			// Скругленные углы
		rectan5.setArcWidth(20);
		rectan5.setArcHeight(20);

/*---------------------------------------------------ЭЛЛИПИС  (SHAPE)-------------------------------------------------- */
		 	// Конструктор
		Ellipse ellip1 = new Ellipse();
		Ellipse ellip2 = new Ellipse(110,120);					// (radiusX, radiusY)
		Ellipse ellip3 = new Ellipse(0.0, 0.0, 40, 60);		// (centerX, centerY, radiusX, radiusY)
			// Методы изменения координат точек и размеров
		ellip1.setCenterX(1.0);				
		ellip1.setCenterY(1.0);
		ellip1.setRadiusX(100.0);			
		ellip1.setRadiusY(70.0);
			// Изменение заливки
		ellip1.setFill(Color.BLUE);		 
			// Изменение фона фигуры на рисунок
		try {
				ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
				ellip1.setFill(im);
		} catch (Exception e) {
				System.out.println("Не удалось загрузить изображение");
		}
		 	// Изменение характеристик обводки (рамки)
		ellip1.setStroke(Color.BLACK);				// Цвет обводки
		ellip1.setStrokeWidth(3.0);				// Толщина обводки
		ellip1.setStrokeType(StrokeType.CENTERED);	// Расположение обводвки относительно фигуры
		 	/* Обводка пунктиром
		 Нужно вызвать метод getStrokeDashArray() и добавить в список значения. Четные индексы задают длину штриха,
		 нечетные - длину пропуска 	 	 */
		ellip3.setStroke(Color.BLACK);		
		ellip3.setStrokeWidth(2);
		ellip3.getStrokeDashArray().addAll(25.0,15.0);
		 	// Форма окончания линии или штриха
		rectan5.setStrokeLineCap(StrokeLineCap.SQUARE);
			// Скругленные углы
		rectan5.setArcWidth(20);
		rectan5.setArcHeight(20);
		
/*---------------------------------------------------КРУГ  (SHAPE)-------------------------------------------------- */
	 	// Конструктор
	Circle circle1 = new Circle();
	Circle circle2 = new Circle(50);					// (radius)
	Circle circle3 = new Circle(0,0, 50);				// (centerX, centerY, radius)
	Circle circle4 = new Circle(0,0, 50, Color.BLUE);	// (centerX, centerY, radius, Color)
	Circle circle5 = new Circle(50, Color.ALICEBLUE);	// (radius, Color)
		// Методы изменения координат точек и размеров
	circle1.setCenterX(1.0);				
	circle1.setCenterY(1.0);
	circle1.setRadius(100.0);			
		// Изменение заливки
	circle1.setFill(Color.BLUE);		 
		// Изменение фона фигуры на рисунок
	try {
			ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
			circle1.setFill(im);
	} catch (Exception e) {
			System.out.println("Не удалось загрузить изображение");
	}
	 	// Изменение характеристик обводки (рамки)
	circle4.setStroke(Color.BLACK);				// Цвет обводки
	circle4.setStrokeWidth(3.0);				// Толщина обводки
	circle4.setStrokeType(StrokeType.CENTERED);	// Расположение обводвки относительно фигуры
	 	/* Обводка пунктиром
	 Нужно вызвать метод getStrokeDashArray() и добавить в список значения. Четные индексы задают длину штриха,
	 нечетные - длину пропуска 	 	 */
	circle2.setStroke(Color.BLACK);		
	circle2.setStrokeWidth(2);
	circle2.getStrokeDashArray().addAll(25.0,15.0);
	 	// Форма окончания линии или штриха
	circle2.setStrokeLineCap(StrokeLineCap.SQUARE);

	
/*---------------------------------------------------МНОГОУГОЛЬНИК  (SHAPE)-------------------------------------------------- */
		 	// Конструктор
		Polygon polygon1 = new Polygon();
		Polygon polygon2 = new Polygon(			// (double...points)
				0.0, 0.0,
				10, 60,
				60, 80,
				30, 30	);			
			// Добавление точек
		polygon2.getPoints().addAll(new Double[] {10.0, 10.0});
			// Изменение заливки
		polygon2.setFill(Color.BLUE);		 
			// Изменение фона фигуры на рисунок
		try {
				ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
				polygon1.setFill(im);
		} catch (Exception e) {
				System.out.println("Не удалось загрузить изображение");
		}
		 	// Изменение характеристик обводки (рамки)
		polygon2.setStroke(Color.BLACK);				// Цвет обводки
		polygon2.setStrokeWidth(3.0);					// Толщина обводки
		polygon2.setStrokeType(StrokeType.CENTERED);	// Расположение обводвки относительно фигуры
		 	/* Обводка пунктиром
		 Нужно вызвать метод getStrokeDashArray() и добавить в список значения. Четные индексы задают длину штриха,
		 нечетные - длину пропуска 	 	 */
		polygon1.setStroke(Color.BLACK);		
		polygon1.setStrokeWidth(2);
		polygon1.getStrokeDashArray().addAll(25.0,15.0);
		 	// Форма окончания линии или штриха
		polygon1.setStrokeLineCap(StrokeLineCap.SQUARE);

/*---------------------------------------------------КЛАСС LINE  (SHAPE)-------------------------------------------------- */
		 	// Конструктор
		Line line1 = new Line();
		Line line2 = new Line(0.0, 0.0, 5.0, 5.0);		// (startX, startY, endX, endY)
			// Методы изменения координат точек
		line1.setEndX(1.0);			line1.setEndY(1.0);
		line1.setStartX(0.0);		line1.setStartY(0.0);
			// Цвет и толщина линии
		line1.setStroke(Color.BLACK);
		line1.setStrokeWidth(2.0);
			// Концы линии
		line1.setStrokeLineCap(StrokeLineCap.ROUND);
			/* Пунктирная линия
		 Нужно вызвать метод getStrokeDashArray() и добавить в список значения. Четные индексы задают длину штриха,
		 нечетные - длину пропуска  */ 	 	
		line2.getStrokeDashArray().addAll(25.0, 10.0);

/*--------------------------------------------------ДУГА ИЛИ СЕКТОР (SHAPE)-------------------------------------------------- */		
			// Конструктор
		Arc arc1 = new Arc();
		Arc arc2 = new Arc(0.0, 0.0, 75.0, 50.0, 45, 250);		// (centerX, centerY, radiusX, radiusY, startAngle, length)
			// Методы изменения координат 
		arc1.setCenterX(1.0);			arc1.setRadiusX(1.0);		arc1.setStartAngle(45);
		arc1.setCenterY(0.0);			arc1.setRadiusY(0.0);		arc1.setLength(2);
			// Цвет заливки
		arc2.setFill(Color.TRANSPARENT);			// Чтобы арка внутри не имела заливки
			// Цвет и толщина контура
		arc2.setStroke(Color.BLACK);	
		arc2.setStrokeWidth(2.0);
			// Концы линии
		arc2.setStrokeLineCap(StrokeLineCap.ROUND);
			/* Пунктирная линия
		 Нужно вызвать метод getStrokeDashArray() и добавить в список значения. Четные индексы задают длину штриха,
		 нечетные - длину пропуска  */ 	 	
		arc2.getStrokeDashArray().addAll(25.0, 10.0);
			// СТИЛЬ
		arc2.setType(ArcType.ROUND);
		arc2.setType(ArcType.OPEN);

/*--------------------------------------------------ЛОМАННАЯ ЛИНИЯ (SHAPE)-------------------------------------------------- */
			// Конструктор
		Polyline polyline1 = new Polyline();
		Polyline polyline2 = new Polyline(			// Задает ломанную линию по точкам
				5.0, 200.0,
				100.0, 300.0, 
				150.0, 220.0,
				200.0, 300.0);
			// Метод добавления точек
		polyline1.getPoints().addAll(			// Задает ломанную линию по точкам
				5.0, 200.0,
				100.0, 300.0);
			// Цвет 
		polyline2.setFill(Color.BLUE);			// Чтобы арка внутри не имела заливки
			// Цвет и толщина контура
		polyline2.setStroke(Color.BLACK);	
		polyline2.setStrokeWidth(2.0);
					// Концы линии
		polyline2.setStrokeLineCap(StrokeLineCap.ROUND);
			// Пунктирная линия
		polyline2.getStrokeDashArray().addAll(25.0, 10.0);

/*---------------------------------------------КУБИЧЕСКАЯ КРИВАЯ БЕЗЬЕ (SHAPE)-------------------------------------------------- */
			// Конструктор
		CubicCurve cubiccur1 = new CubicCurve();
		CubicCurve cubiccur2 = new CubicCurve(		// (startX, startY,controlX1, controlY1, controlX2, controlY2, endX, endY) 
				5.0, 200.0,		// Начальная точка
				100.0, 300.0, 	// 1-ая опорная точка
				150.0, 220.0,	// 2-ая опорная точка
				200.0, 300.0);	// Конечная точка
			// Методы изменения координат 
		cubiccur1.setStartX(1.0);			cubiccur1.setEndX(1.0);		cubiccur1.setControlX1(10);
		cubiccur1.setStartY(0.0);			cubiccur1.setEndY(0.0);		cubiccur1.setControlY1(10);
			// Цвет 
		cubiccur1.setFill(Color.BLUE);			
			// Цвет и толщина контура
		cubiccur1.setStroke(Color.BLACK);	
		cubiccur1.setStrokeWidth(2.0);
					// Концы линии
		cubiccur1.setStrokeLineCap(StrokeLineCap.ROUND);
			// Пунктирная линия
		cubiccur1.getStrokeDashArray().addAll(25.0, 10.0);
		

/*---------------------------------------------КВАДРАТИЧНАЯ КРИВАЯ (SHAPE)-------------------------------------------------- */
			// Конструктор
		QuadCurve quadCurve1 = new QuadCurve();
		QuadCurve quadCurve2 = new QuadCurve(		// (startX, startY,controlX, controlY, endX, endY) 
				5.0, 200.0,		// Начальная точка
				100.0, 300.0, 	// Опорная точка
				200.0, 300.0);	// Конечная точка
			// Методы изменения координат 
		quadCurve1.setStartX(1.0);			quadCurve1.setEndX(1.0);		quadCurve1.setControlX(10);
		quadCurve1.setStartY(0.0);			quadCurve1.setEndY(0.0);		quadCurve1.setControlY(10);
			// Цвет 
		quadCurve1.setFill(Color.BLUE);			
			// Цвет и толщина контура
		quadCurve1.setStroke(Color.BLACK);	
		quadCurve1.setStrokeWidth(2.0);
					// Концы линии
		quadCurve1.setStrokeLineCap(StrokeLineCap.ROUND);
			// Пунктирная линия
		quadCurve1.getStrokeDashArray().addAll(25.0, 10.0);

		
		
		pane.getChildren().addAll(rectan, rectan1, polygon, line1, arc2,arc1, ellip3,circle4,polygon2);
		
		Scene scene = new Scene(pane, 1200, 600);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
				
		
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
