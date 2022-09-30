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
				// ������ GET
		System.out.println("���������� � = " + p.getX());
		System.out.println("���������� y = " + p.getY());
				// ��������� ���� �����
		System.out.println(p.equals(p2));
				// �������� ��������
		System.out.println("�������� �������� " + p.add(p3));
				// ��������� ��������
		System.out.println("��������� �������� " + p.subtract(p3));
				// ��������� ������� �� ������
		System.out.println("��������� ������� �� ������ " + p.multiply(5));
				// ��������� ����� �������
		System.out.println("��������� ����� ������� " + p.distance(p2));
				// ����� �������
		System.out.println("����� ������� " + p.magnitude());
				// C�������� ������������ ��������
		System.out.println("��������� ������������ �������� " + p.dotProduct(p2));
				// ��������� ������������ ��������
		System.out.println("��������� ������������ �������� " + p.crossProduct(p2));
				// ���������� ����� �� �������� ����� ���������
		System.out.println("���������� ����� �� �������� ����� ��������� " + p.midpoint(p2));
				// ���� ����� ��������� ��� ����� �������
		System.out.println("���� " + p.angle(p2, p3));		System.out.println();
	
/*----------------------------------------------�������������-----------------------------------------------------------------------*/
				// ����� Dimension2D ������ ������������� ������������ ��������
		Dimension2D rect = new Dimension2D(10.0,15.0);
		System.out.println(rect);
				// ������ GET
		System.out.println("������ = " + rect.getWidth());
		System.out.println("����� = " + rect.getHeight());
		
				// ����� Rectangle2D ������ ������������� ������������ �������� � � ��������� ���������
		Rectangle2D rect2 = new Rectangle2D(0.0, 0.0, 10.0, 15.0);  // (minX, minY, width, height)
		Rectangle2D rect3 = new Rectangle2D(5.0, 5.0, 10.0, 15.0);  // (minX, minY, width, height)
		System.out.println(rect2);
				// ������ GET
		System.out.println("������ = " + rect2.getWidth());
		System.out.println("����� = " + rect2.getHeight());
				// ���������� ������ �������� ����
		System.out.println("���������� ������ �������� ���� = " + rect2.getMinX() + "  " + rect2.getMinY());
				// ���������� ������� ������� ����
		System.out.println("���������� ������� ������� ���� = " + rect2.getMaxX() + "  " + rect2.getMaxY());
				// ���������
		System.out.println(rect2.equals(rect3));
				// ����������� �����������
		System.out.println("������������� ������������ - " + rect2.intersects(rect3));
				// ����������� ���������� ������ �������������� � ������
		System.out.println(" ����������� ���������� " + rect2.contains(rect3));  System.out.println();

/*----------------------------������� ������ ������� ��������� ����-----------------------------------------------------------------*/		
		BoundingBox b = new BoundingBox(0, 0, 10, 20);				// ������� ������� �� ������
		BoundingBox b2 = new BoundingBox(0, 0, 10, 20, 10, 20);		// ������� ������� �� ������ � 3D
				// ���������� ������ �������� ����
		System.out.println("���������� ������ �������� ���� = " + b.getMinX() + "  " + b.getMinY());
				// ���������� ������� ������� ����
		System.out.println("���������� ������� ������� ���� = " + b.getMaxX() + "  " + b.getMaxY());
				// ������ GET
		System.out.println("������ = " + b.getWidth());
		System.out.println("����� = " + b.getHeight());
				// ���������� ������ �������
		System.out.println("���������� ������ ������� = " + b2.getCenterX() + "  " + b2.getCenterY() + "  " + b2.getCenterZ());
				// ����������� �����������
		System.out.println("������������ - " + b.intersects(b2));
				// ����������� ���������� ������ �������������� � ������
		System.out.println(" ����������� ���������� " + b.contains(b2));  System.out.println();
		
/*----------------------------����� SHAPE - ������� ����� ��� ����� + ��-�� ����������� NODES----------------------------------------
   ��� ��� ��-�� ����������� Node, �� ��� ����� ��������� �� Scene */
			// ������������
		Shape rectan = new Rectangle(0.0, 0.0, 100.0, 150.0);  // (minX, minY, width, height)
		Shape rectan1 = new Rectangle(5.0, 5.0, 150.0, 200.0);  // (minX, minY, width, height)
			// �������������
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[] {
				0.0, 0.0,
				150.0, 50.0,
				0.0, 100.0
		});
		
		Shape line = new Line(0.0, 0.0, 10.0, 15.0);  
			// ����� union() - ���������� ������, ������� ��-�� ����������� ����������� 2-�
		Shape fig = Shape.union(rectan1, rectan);
			// ����� subtract() - ���������� ������, ������� ��-�� ����������� ��������� 2-�
		Shape fig2 = Shape.subtract(rectan1, rectan);
			// ����� intersect() - ���������� ������, ������� ��-�� ����������� ����������� 2-�
		Shape fig3 = Shape.intersect(rectan1, rectan);
			// ��������� ���� ������ �� �������� ����
		rectan.setFill(Color.BLUE);		 
			// ��������� ���� ������ �� �������
		 try {
				ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
				rectan1.setFill(im);
			} catch (Exception e) {
				System.out.println("�� ������� ��������� �����������");
			}
		 
		 
		 	// ��������� ������������� ������� (�����)
		 rectan.setStroke(Color.BLACK);				// ���� �������
		 rectan.setStrokeWidth(3.0);				// ������� �������
		 rectan.setStrokeType(StrokeType.CENTERED);	// ������������ �������� ������������ ������
		 	/* ������� ���������
		 ����� ������� ����� getStrokeDashArray() � �������� � ������ ��������. ������ ������� ������ ����� ������,
		 �������� - ����� �������� 	 	 */
		 rectan1.setStroke(Color.BLACK);		rectan1.setStrokeWidth(2);
		 rectan1.getStrokeDashArray().addAll(25.0,15.0);
		 	// ����� ��������� ����� ��� ������
		 rectan1.setStrokeLineCap(StrokeLineCap.SQUARE);
		 	// ���������� ������������  ������ ������� ����� ������������ ��������, ��� ��� �����������
		 polygon.setFill(Color.BROWN);
		 polygon.setStroke(Color.BLACK);
		 polygon.setStrokeWidth(2);
		 polygon.setSmooth(true);

/*---------------------------------------------------����� RECTANGLE  (SHAPE)-------------------------------------------------- */
		 	// �����������
		Rectangle rectan2 = new Rectangle();
		Rectangle rectan3 = new Rectangle(100,500);					// (width, height)
		Rectangle recta4 = new Rectangle(0,0,50,70);				// (x, y, width, height)
		Rectangle rectan5 = new Rectangle(100,500,Color.BLACK);		// (width, height, Color)
			// ������ ��������� ��������� ����� � ��������
		rectan3.setX(1.0);					// ���������� ������������ ������ �������� ����
		rectan3.setY(1.0);
		rectan3.setWidth(100.0);			// ���������� ��������� ��������������
		rectan3.setHeight(70.0);
			// ��������� �������
		rectan5.setFill(Color.BLUE);		 
			// ��������� ���� ������ �� �������
		try {
				ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
				rectan5.setFill(im);
		} catch (Exception e) {
				System.out.println("�� ������� ��������� �����������");
		}
		 	// ��������� ������������� ������� (�����)
		rectan5.setStroke(Color.BLACK);				// ���� �������
		rectan5.setStrokeWidth(3.0);				// ������� �������
		rectan5.setStrokeType(StrokeType.CENTERED);	// ������������ �������� ������������ ������
		 	/* ������� ���������
		 ����� ������� ����� getStrokeDashArray() � �������� � ������ ��������. ������ ������� ������ ����� ������,
		 �������� - ����� �������� 	 	 */
		rectan5.setStroke(Color.BLACK);		
		rectan5.setStrokeWidth(2);
		rectan5.getStrokeDashArray().addAll(25.0,15.0);
		 	// ����� ��������� ����� ��� ������
		rectan5.setStrokeLineCap(StrokeLineCap.SQUARE);
			// ����������� ����
		rectan5.setArcWidth(20);
		rectan5.setArcHeight(20);

/*---------------------------------------------------�������  (SHAPE)-------------------------------------------------- */
		 	// �����������
		Ellipse ellip1 = new Ellipse();
		Ellipse ellip2 = new Ellipse(110,120);					// (radiusX, radiusY)
		Ellipse ellip3 = new Ellipse(0.0, 0.0, 40, 60);		// (centerX, centerY, radiusX, radiusY)
			// ������ ��������� ��������� ����� � ��������
		ellip1.setCenterX(1.0);				
		ellip1.setCenterY(1.0);
		ellip1.setRadiusX(100.0);			
		ellip1.setRadiusY(70.0);
			// ��������� �������
		ellip1.setFill(Color.BLUE);		 
			// ��������� ���� ������ �� �������
		try {
				ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
				ellip1.setFill(im);
		} catch (Exception e) {
				System.out.println("�� ������� ��������� �����������");
		}
		 	// ��������� ������������� ������� (�����)
		ellip1.setStroke(Color.BLACK);				// ���� �������
		ellip1.setStrokeWidth(3.0);				// ������� �������
		ellip1.setStrokeType(StrokeType.CENTERED);	// ������������ �������� ������������ ������
		 	/* ������� ���������
		 ����� ������� ����� getStrokeDashArray() � �������� � ������ ��������. ������ ������� ������ ����� ������,
		 �������� - ����� �������� 	 	 */
		ellip3.setStroke(Color.BLACK);		
		ellip3.setStrokeWidth(2);
		ellip3.getStrokeDashArray().addAll(25.0,15.0);
		 	// ����� ��������� ����� ��� ������
		rectan5.setStrokeLineCap(StrokeLineCap.SQUARE);
			// ����������� ����
		rectan5.setArcWidth(20);
		rectan5.setArcHeight(20);
		
/*---------------------------------------------------����  (SHAPE)-------------------------------------------------- */
	 	// �����������
	Circle circle1 = new Circle();
	Circle circle2 = new Circle(50);					// (radius)
	Circle circle3 = new Circle(0,0, 50);				// (centerX, centerY, radius)
	Circle circle4 = new Circle(0,0, 50, Color.BLUE);	// (centerX, centerY, radius, Color)
	Circle circle5 = new Circle(50, Color.ALICEBLUE);	// (radius, Color)
		// ������ ��������� ��������� ����� � ��������
	circle1.setCenterX(1.0);				
	circle1.setCenterY(1.0);
	circle1.setRadius(100.0);			
		// ��������� �������
	circle1.setFill(Color.BLUE);		 
		// ��������� ���� ������ �� �������
	try {
			ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
			circle1.setFill(im);
	} catch (Exception e) {
			System.out.println("�� ������� ��������� �����������");
	}
	 	// ��������� ������������� ������� (�����)
	circle4.setStroke(Color.BLACK);				// ���� �������
	circle4.setStrokeWidth(3.0);				// ������� �������
	circle4.setStrokeType(StrokeType.CENTERED);	// ������������ �������� ������������ ������
	 	/* ������� ���������
	 ����� ������� ����� getStrokeDashArray() � �������� � ������ ��������. ������ ������� ������ ����� ������,
	 �������� - ����� �������� 	 	 */
	circle2.setStroke(Color.BLACK);		
	circle2.setStrokeWidth(2);
	circle2.getStrokeDashArray().addAll(25.0,15.0);
	 	// ����� ��������� ����� ��� ������
	circle2.setStrokeLineCap(StrokeLineCap.SQUARE);

	
/*---------------------------------------------------�������������  (SHAPE)-------------------------------------------------- */
		 	// �����������
		Polygon polygon1 = new Polygon();
		Polygon polygon2 = new Polygon(			// (double...points)
				0.0, 0.0,
				10, 60,
				60, 80,
				30, 30	);			
			// ���������� �����
		polygon2.getPoints().addAll(new Double[] {10.0, 10.0});
			// ��������� �������
		polygon2.setFill(Color.BLUE);		 
			// ��������� ���� ������ �� �������
		try {
				ImagePattern im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/icons.png")));
				polygon1.setFill(im);
		} catch (Exception e) {
				System.out.println("�� ������� ��������� �����������");
		}
		 	// ��������� ������������� ������� (�����)
		polygon2.setStroke(Color.BLACK);				// ���� �������
		polygon2.setStrokeWidth(3.0);					// ������� �������
		polygon2.setStrokeType(StrokeType.CENTERED);	// ������������ �������� ������������ ������
		 	/* ������� ���������
		 ����� ������� ����� getStrokeDashArray() � �������� � ������ ��������. ������ ������� ������ ����� ������,
		 �������� - ����� �������� 	 	 */
		polygon1.setStroke(Color.BLACK);		
		polygon1.setStrokeWidth(2);
		polygon1.getStrokeDashArray().addAll(25.0,15.0);
		 	// ����� ��������� ����� ��� ������
		polygon1.setStrokeLineCap(StrokeLineCap.SQUARE);

/*---------------------------------------------------����� LINE  (SHAPE)-------------------------------------------------- */
		 	// �����������
		Line line1 = new Line();
		Line line2 = new Line(0.0, 0.0, 5.0, 5.0);		// (startX, startY, endX, endY)
			// ������ ��������� ��������� �����
		line1.setEndX(1.0);			line1.setEndY(1.0);
		line1.setStartX(0.0);		line1.setStartY(0.0);
			// ���� � ������� �����
		line1.setStroke(Color.BLACK);
		line1.setStrokeWidth(2.0);
			// ����� �����
		line1.setStrokeLineCap(StrokeLineCap.ROUND);
			/* ���������� �����
		 ����� ������� ����� getStrokeDashArray() � �������� � ������ ��������. ������ ������� ������ ����� ������,
		 �������� - ����� ��������  */ 	 	
		line2.getStrokeDashArray().addAll(25.0, 10.0);

/*--------------------------------------------------���� ��� ������ (SHAPE)-------------------------------------------------- */		
			// �����������
		Arc arc1 = new Arc();
		Arc arc2 = new Arc(0.0, 0.0, 75.0, 50.0, 45, 250);		// (centerX, centerY, radiusX, radiusY, startAngle, length)
			// ������ ��������� ��������� 
		arc1.setCenterX(1.0);			arc1.setRadiusX(1.0);		arc1.setStartAngle(45);
		arc1.setCenterY(0.0);			arc1.setRadiusY(0.0);		arc1.setLength(2);
			// ���� �������
		arc2.setFill(Color.TRANSPARENT);			// ����� ���� ������ �� ����� �������
			// ���� � ������� �������
		arc2.setStroke(Color.BLACK);	
		arc2.setStrokeWidth(2.0);
			// ����� �����
		arc2.setStrokeLineCap(StrokeLineCap.ROUND);
			/* ���������� �����
		 ����� ������� ����� getStrokeDashArray() � �������� � ������ ��������. ������ ������� ������ ����� ������,
		 �������� - ����� ��������  */ 	 	
		arc2.getStrokeDashArray().addAll(25.0, 10.0);
			// �����
		arc2.setType(ArcType.ROUND);
		arc2.setType(ArcType.OPEN);

/*--------------------------------------------------�������� ����� (SHAPE)-------------------------------------------------- */
			// �����������
		Polyline polyline1 = new Polyline();
		Polyline polyline2 = new Polyline(			// ������ �������� ����� �� ������
				5.0, 200.0,
				100.0, 300.0, 
				150.0, 220.0,
				200.0, 300.0);
			// ����� ���������� �����
		polyline1.getPoints().addAll(			// ������ �������� ����� �� ������
				5.0, 200.0,
				100.0, 300.0);
			// ���� 
		polyline2.setFill(Color.BLUE);			// ����� ���� ������ �� ����� �������
			// ���� � ������� �������
		polyline2.setStroke(Color.BLACK);	
		polyline2.setStrokeWidth(2.0);
					// ����� �����
		polyline2.setStrokeLineCap(StrokeLineCap.ROUND);
			// ���������� �����
		polyline2.getStrokeDashArray().addAll(25.0, 10.0);

/*---------------------------------------------���������� ������ ����� (SHAPE)-------------------------------------------------- */
			// �����������
		CubicCurve cubiccur1 = new CubicCurve();
		CubicCurve cubiccur2 = new CubicCurve(		// (startX, startY,controlX1, controlY1, controlX2, controlY2, endX, endY) 
				5.0, 200.0,		// ��������� �����
				100.0, 300.0, 	// 1-�� ������� �����
				150.0, 220.0,	// 2-�� ������� �����
				200.0, 300.0);	// �������� �����
			// ������ ��������� ��������� 
		cubiccur1.setStartX(1.0);			cubiccur1.setEndX(1.0);		cubiccur1.setControlX1(10);
		cubiccur1.setStartY(0.0);			cubiccur1.setEndY(0.0);		cubiccur1.setControlY1(10);
			// ���� 
		cubiccur1.setFill(Color.BLUE);			
			// ���� � ������� �������
		cubiccur1.setStroke(Color.BLACK);	
		cubiccur1.setStrokeWidth(2.0);
					// ����� �����
		cubiccur1.setStrokeLineCap(StrokeLineCap.ROUND);
			// ���������� �����
		cubiccur1.getStrokeDashArray().addAll(25.0, 10.0);
		

/*---------------------------------------------������������ ������ (SHAPE)-------------------------------------------------- */
			// �����������
		QuadCurve quadCurve1 = new QuadCurve();
		QuadCurve quadCurve2 = new QuadCurve(		// (startX, startY,controlX, controlY, endX, endY) 
				5.0, 200.0,		// ��������� �����
				100.0, 300.0, 	// ������� �����
				200.0, 300.0);	// �������� �����
			// ������ ��������� ��������� 
		quadCurve1.setStartX(1.0);			quadCurve1.setEndX(1.0);		quadCurve1.setControlX(10);
		quadCurve1.setStartY(0.0);			quadCurve1.setEndY(0.0);		quadCurve1.setControlY(10);
			// ���� 
		quadCurve1.setFill(Color.BLUE);			
			// ���� � ������� �������
		quadCurve1.setStroke(Color.BLACK);	
		quadCurve1.setStrokeWidth(2.0);
					// ����� �����
		quadCurve1.setStrokeLineCap(StrokeLineCap.ROUND);
			// ���������� �����
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
