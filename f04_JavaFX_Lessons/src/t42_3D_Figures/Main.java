package t42_3D_Figures;
	
import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.ParallelCamera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class Main extends Application  {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl, lbl2;
	int i = 0;
	
		@Override 
	public void start(Stage primaryStage) {	
		HBox pane = new HBox(10);
/*----------------------------------------------POINT3D---------------------------------------------------------------------------*/
		Point3D p = new Point3D (10.0,10.0,10.0);
		Point3D p2 = Point3D.ZERO;
		System.out.println(p2);
				// Методы GET
		System.out.println("Координата х = " + p.getX());
		System.out.println("Координата y = " + p.getY());
		System.out.println("Координата z = " + p.getZ());
				// СРАВНЕНИЕ ДВУХ ТОЧЕК
		System.out.println(p.equals(p2));
				// СЛОЖЕНИЕ ВЕКТОРОВ
		System.out.println("СЛОЖЕНИЕ ВЕКТОРОВ " + p.add(p));
				// ВЫЧИТАНИЕ ВЕКТОРОВ
		System.out.println("ВЫЧИТАНИЕ ВЕКТОРОВ " + p.subtract(p));
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
		System.out.println("УГОЛ " + p.angle(p2, p));		System.out.println();
		
/*--------------------------------------------КЛАСС BOX  ПРЯМОУГОЛЬНИK------------------------------------------------------------------------
		Конструктор Box()
		Конструктор Box( width, height, depth) 	 */
		Box box = new Box();
		Box box1 = new Box(10.0, 5.0, 10.0);  
			// Установка размеров
		box.setWidth(150);
		box.setHeight(100);
		box.setDepth(150);
			// Установка материала поверхности.  По умолчанию - Color.LIGHTGRAY
		PhongMaterial mat = new PhongMaterial(Color.BLUE);
		box.setMaterial(mat);
			/* Задает режим отрисовки фигуры
		 - FILL - полная отрисовка фигуры с заполнением фигуры
		 - LINE - только линии между вершинами фигуры			 */
		box.setDrawMode(DrawMode.FILL);
			/* Определяет грани, которые не нужно отрисовывать.
		 - BACK - только грани заднего плана
		 - FRONT - только грани переднего плана
		 - NONE  - отрисовываются все грани 		*/
		box.setCullFace(CullFace.NONE);
		
/*--------------------------------------------КЛАСС CYLINDER------------------------------------------------------------------------
		Конструктор Cylinder()
		Конструктор Cylinder( radius, height) 	
		Конструктор Cylinder( radius, height, divisions)	
			divisions - количество граней Если указать 3, то будет 3 грани*/
		Cylinder cyl = new Cylinder();
			// Установка размеров
		cyl.setRadius(30);
		cyl.setHeight(100);
			// Установка материала поверхности.  По умолчанию - Color.LIGHTGRAY
		mat = new PhongMaterial(Color.AQUA);
		cyl.setMaterial(mat);
			/* Задает режим отрисовки фигуры
		 - FILL - полная отрисовка фигуры с заполнением фигуры
		 - LINE - только линии между вершинами фигуры			 */
		cyl.setDrawMode(DrawMode.LINE);
			/* Определяет грани, которые не нужно отрисовывать.
		 - BACK - только грани заднего плана
		 - FRONT - только грани переднего плана
		 - NONE  - отрисовываются все грани 		*/
		cyl.setCullFace(CullFace.FRONT);
		
/*--------------------------------------------КЛАСС SPHERE------------------------------------------------------------------------
		Конструктор Sphere()
		Конструктор Sphere( radius) 	
		Конструктор Sphere( radius, divisions)	
			divisions - количество граней Если указать 3, то будет 3 грани	*/
		Sphere sph = new Sphere();
			// Установка размеров
		sph.setRadius(30);
			// Установка материала поверхности.  По умолчанию - Color.LIGHTGRAY
		mat = new PhongMaterial(Color.AQUA);
		sph.setMaterial(mat);
			/* Задает режим отрисовки фигуры
		 - FILL - полная отрисовка фигуры с заполнением фигуры
		 - LINE - только линии между вершинами фигуры			 */
		sph.setDrawMode(DrawMode.LINE);
			/* Определяет грани, которые не нужно отрисовывать.
		 - BACK - только грани заднего плана
		 - FRONT - только грани переднего плана
		 - NONE  - отрисовываются все грани 		*/
		sph.setCullFace(CullFace.FRONT);

/*--------------------------------------------КЛАСС MESHVIEW  ФИГУРЫ ПРОИЗВОЛЬНОЙ ФОРМЫ---------------------------------------------
		Конструктор MeshView()
		Конструктор MeshView(Mesh mesh) 		
			mesh - объект, класс которого наследуется от Mesh. 
		На данный момент есть только один наследник- класс TriangleMesh, который создает 3Д-фигуру, состояющую из множества треугольников  
		С помощью этих треугольников можно создать любые фигуры, просто треугольников будет много.
		Например, куб будет содержать 6 прямоугольных граней, каждая из которых будет описана 2-мя треугольниками. То есть для 
		куба нужно описать 12 треугольников 					*/ 	
		TriangleMesh  rectmesh = new TriangleMesh();		// Создание прямоугольника из двух треугольников
		rectmesh.getPoints().addAll(
								   0.0f, 10.0f, 0.0f, 		// Добавление координат вершин в формате float x,y,z
								   0.0f, 0.0f, 0.0f,
								   10.0f, 0.0f, 0.0f,
								   10.0f, 10.0f, 0.0f );
	/* Далее нужно заполнить массив с координатами точек на текстуре. Координаты указываются в двухмерном пространстве (т.е
	 только по осям х,у). Причем это относительные координаты от 0.0 до 1.0. Координата (0.0f, 0.0f) соответствуют левому верхнему
	 углу изображения с текстурой, а координата (1.0f, 1.0f) - правому нижнему углу. Для добавления координат используется  метод  */
		rectmesh.getTexCoords().addAll(
				   0.0f, 0.0f, 								// Добавление координатами точек на текстуре
				   1.0f, 0.0f,
				   0.0f, 1.0f,
				   1.0f, 1.0f);
	/* Далее описываем все треугольники через метод getFaces(). Каждый треугольник имеет лицевую и обратную стороны. Обратная
	 сторона не отрисовывается. Чтобы описать лицевую сторону, достаточно задать координаты его вершин против часовой стрелки.
	 В метод getFaces() нужно ввести для каждого треугольника 6 цифр; p1, t1, p2, t2, p3, t3
	 p1,p2,p3 - это индексы вершин треугольника из массива, возвращаемого методом  getPoints()
	 t1,t2,t3 - это индексы точек на текстуре из массива, возвращаемого методом getTexCoords()  	   */
		rectmesh.getFaces().addAll(
				0,0,1,2,2,3,		// ABC
				0,0,2,3,3,1 );		// ACD
	/* Далее создаем текстуру поверхности. Для этого загружаем изображение текстуры в объект Image, а затем передаем
	 его в метод setDiffuseMap() класса PhongMaterial  */
		 Image im = null; ;
     	// Установка  фонового рисунка, который растягивается на все окно
     try {
			im = new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg"));
		} catch (Exception e) {
			System.out.println("Не удалось загрузить изображение");
		}
		PhongMaterial material = new PhongMaterial();
		material.setDiffuseMap(im);
	/* Далее осталось создать объект класса MeshView и передать ему объекты классов TriangleMesh и PhongMaterial */
		MeshView meshView = new MeshView();
		meshView.setMesh(rectmesh);
		meshView.setMaterial(material);
		meshView.setDrawMode(DrawMode.FILL);
		meshView.setCullFace(CullFace.NONE);
		
/*--------------------------------------------СЦЕНА SUBSCENE------------------------------------------------------------------------ 
   Для управления свойствами трехмерного пространства класс Scene содержит два конструктора
   Конструктор Scene(Parent root, double width, double height, boolean depthBuffer)
   Конструктор Scene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) 

   Вместо использования объекта сцены для отображения 3D пространства можно использовать объект класса SubScene.
   Она особенно полезна, если мы хотим отразить на сцене одновременно двух- и трехмерные объекты.	
   Наследование Object - Node - SubScene
   	Конструктор SubScene(Parent root, double width, double height, boolean depthBuffer)
    Конструктор SubScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing)
    	- root - ссылка на корневой контейнер,
    	- width и height - размеры субсцены,
    	- depthBuffer - при true объект сцены будет иметь буфер глубины,
	   	- antiAliasing - задает уровень сглаживания. 
	   		   - SceneAntialiasing.DISABLED - грани 3D фигуры будут отображаться лесенкой
	   		   - SceneAntialiasing.BALANCED - включить сглаживание	
	КОД СМОТРИ НИЖЕ 												   		   	*/

/*----------------------------------------ОСВЕЩЕНИЕ-------------------------------------------------------------------------------
		  Класс LightBase описывает освещение  
		  Наследование Object - Node- LightBase
		  У LightBase 2 наследника: 
		   - AmbientLight - источник окружающего света. Объект освещается со всех сторон равномерно
		   - PointLight - точечный источник освещения. Имеет определенную позицию и светит из нее во всех направлениях
		 */
		AmbientLight aml1 = new AmbientLight();
		AmbientLight aml2 = new AmbientLight(Color.YELLOW);
		aml1.setColor(Color.YELLOW);			// Устанавливает цвет света
		aml1.setLightOn(false);					// Включает свет, если true 
		aml1.getScope().addAll(box);			// Добавляет в scope освещаемых объектов выбранный объект
		
		PointLight poil1 = new PointLight();
		PointLight poil2 = new PointLight(Color.YELLOW);
		poil1.setColor(Color.YELLOW);
		poil1.setLightOn(true);
		poil1.setTranslateX(10);
		poil1.setTranslateY(10);
		poil1.setTranslateZ(10);		
		poil1.getScope().addAll(box);
		
			// Добавление 3D объектов в root node
		Group group = new Group(); 
//		group.getChildren().addAll(box, cyl, sph);
		group.getChildren().addAll(box);
			// Добавление 3D объектов на Scene 
		SubScene subscene = new SubScene(group, 800, 500, true, SceneAntialiasing.BALANCED);
		subscene.setWidth(600);
		subscene.setHeight(500);
		subscene.setRoot(group);
		subscene.setFill(Color.AQUAMARINE);			// Цвет фона
			/* Для визуализации объектов на сцене исполльзуется камера. Куда смотрит камера, та часть сцены и отображается.
			 По умолчанию камера смотрит в направлении положительных значений оси Z.				 
			 Наследование Object- Node - Camera 
			 Camera - это абстрактный класс, его подклассы: 
			     - ParallelCamera - камера имеет параллельные лучи, поэтому никаких искажений перспективы нет
			     - PerspectiveCamera - камера песпективы  		*/
		ParallelCamera paralCamera = new ParallelCamera();
		PerspectiveCamera persCamera1 = new PerspectiveCamera();			// Пустой объект камеры
		PerspectiveCamera persCamera2 = new PerspectiveCamera(true);		/* Если параметр равен true, то положение глаз фиксируется
				в точке (0,0,0) локальной системы координат. Это значение стоит использовать, если планируется перемещать камеры внутри
				сцены. По умолчанию стоит значение false.		*/
		double trX = 500.0, trY = 500.0, trZ = 500.0;
		double aX = -30.0, aY = 230.0, aZ = 50.0;
		Translate tr = new Translate(trX, trY, trZ);		// Задает удаление камеры от начала координат
		Rotate rx = new Rotate(aX, Rotate.X_AXIS);
		Rotate ry = new Rotate(aY, Rotate.Y_AXIS);
		Rotate rz = new Rotate(aZ, Rotate.Z_AXIS);
		persCamera2.getTransforms().addAll(tr,rx,ry,rz);
		persCamera2.setNearClip(0);						// Объекты ближе указанной величины не будут показываться. По умолчанию - 0,1
		persCamera2.setFarClip(1000);					// Объекты дальше указанной величины не будут показываться. По умолчанию - 0,1
		persCamera2.setFieldOfView(50);					// Задает угол обзора в углах. По умолчанию - 30 градусов
		subscene.setCamera(persCamera2);								// Указывает тип камеры


		
		
		Group group1 = new Group();
		group1.getChildren().addAll(subscene);
		
		Scene scene = new Scene(group1, 900, 600, true, SceneAntialiasing.BALANCED);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
				
		
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
