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
				// ������ GET
		System.out.println("���������� � = " + p.getX());
		System.out.println("���������� y = " + p.getY());
		System.out.println("���������� z = " + p.getZ());
				// ��������� ���� �����
		System.out.println(p.equals(p2));
				// �������� ��������
		System.out.println("�������� �������� " + p.add(p));
				// ��������� ��������
		System.out.println("��������� �������� " + p.subtract(p));
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
		System.out.println("���� " + p.angle(p2, p));		System.out.println();
		
/*--------------------------------------------����� BOX  ������������K------------------------------------------------------------------------
		����������� Box()
		����������� Box( width, height, depth) 	 */
		Box box = new Box();
		Box box1 = new Box(10.0, 5.0, 10.0);  
			// ��������� ��������
		box.setWidth(150);
		box.setHeight(100);
		box.setDepth(150);
			// ��������� ��������� �����������.  �� ��������� - Color.LIGHTGRAY
		PhongMaterial mat = new PhongMaterial(Color.BLUE);
		box.setMaterial(mat);
			/* ������ ����� ��������� ������
		 - FILL - ������ ��������� ������ � ����������� ������
		 - LINE - ������ ����� ����� ��������� ������			 */
		box.setDrawMode(DrawMode.FILL);
			/* ���������� �����, ������� �� ����� ������������.
		 - BACK - ������ ����� ������� �����
		 - FRONT - ������ ����� ��������� �����
		 - NONE  - �������������� ��� ����� 		*/
		box.setCullFace(CullFace.NONE);
		
/*--------------------------------------------����� CYLINDER------------------------------------------------------------------------
		����������� Cylinder()
		����������� Cylinder( radius, height) 	
		����������� Cylinder( radius, height, divisions)	
			divisions - ���������� ������ ���� ������� 3, �� ����� 3 �����*/
		Cylinder cyl = new Cylinder();
			// ��������� ��������
		cyl.setRadius(30);
		cyl.setHeight(100);
			// ��������� ��������� �����������.  �� ��������� - Color.LIGHTGRAY
		mat = new PhongMaterial(Color.AQUA);
		cyl.setMaterial(mat);
			/* ������ ����� ��������� ������
		 - FILL - ������ ��������� ������ � ����������� ������
		 - LINE - ������ ����� ����� ��������� ������			 */
		cyl.setDrawMode(DrawMode.LINE);
			/* ���������� �����, ������� �� ����� ������������.
		 - BACK - ������ ����� ������� �����
		 - FRONT - ������ ����� ��������� �����
		 - NONE  - �������������� ��� ����� 		*/
		cyl.setCullFace(CullFace.FRONT);
		
/*--------------------------------------------����� SPHERE------------------------------------------------------------------------
		����������� Sphere()
		����������� Sphere( radius) 	
		����������� Sphere( radius, divisions)	
			divisions - ���������� ������ ���� ������� 3, �� ����� 3 �����	*/
		Sphere sph = new Sphere();
			// ��������� ��������
		sph.setRadius(30);
			// ��������� ��������� �����������.  �� ��������� - Color.LIGHTGRAY
		mat = new PhongMaterial(Color.AQUA);
		sph.setMaterial(mat);
			/* ������ ����� ��������� ������
		 - FILL - ������ ��������� ������ � ����������� ������
		 - LINE - ������ ����� ����� ��������� ������			 */
		sph.setDrawMode(DrawMode.LINE);
			/* ���������� �����, ������� �� ����� ������������.
		 - BACK - ������ ����� ������� �����
		 - FRONT - ������ ����� ��������� �����
		 - NONE  - �������������� ��� ����� 		*/
		sph.setCullFace(CullFace.FRONT);

/*--------------------------------------------����� MESHVIEW  ������ ������������ �����---------------------------------------------
		����������� MeshView()
		����������� MeshView(Mesh mesh) 		
			mesh - ������, ����� �������� ����������� �� Mesh. 
		�� ������ ������ ���� ������ ���� ���������- ����� TriangleMesh, ������� ������� 3�-������, ���������� �� ��������� �������������  
		� ������� ���� ������������� ����� ������� ����� ������, ������ ������������� ����� �����.
		��������, ��� ����� ��������� 6 ������������� ������, ������ �� ������� ����� ������� 2-�� ��������������. �� ���� ��� 
		���� ����� ������� 12 ������������� 					*/ 	
		TriangleMesh  rectmesh = new TriangleMesh();		// �������� �������������� �� ���� �������������
		rectmesh.getPoints().addAll(
								   0.0f, 10.0f, 0.0f, 		// ���������� ��������� ������ � ������� float x,y,z
								   0.0f, 0.0f, 0.0f,
								   10.0f, 0.0f, 0.0f,
								   10.0f, 10.0f, 0.0f );
	/* ����� ����� ��������� ������ � ������������ ����� �� ��������. ���������� ����������� � ���������� ������������ (�.�
	 ������ �� ���� �,�). ������ ��� ������������� ���������� �� 0.0 �� 1.0. ���������� (0.0f, 0.0f) ������������� ������ ��������
	 ���� ����������� � ���������, � ���������� (1.0f, 1.0f) - ������� ������� ����. ��� ���������� ��������� ������������  �����  */
		rectmesh.getTexCoords().addAll(
				   0.0f, 0.0f, 								// ���������� ������������ ����� �� ��������
				   1.0f, 0.0f,
				   0.0f, 1.0f,
				   1.0f, 1.0f);
	/* ����� ��������� ��� ������������ ����� ����� getFaces(). ������ ����������� ����� ������� � �������� �������. ��������
	 ������� �� ��������������. ����� ������� ������� �������, ���������� ������ ���������� ��� ������ ������ ������� �������.
	 � ����� getFaces() ����� ������ ��� ������� ������������ 6 ����; p1, t1, p2, t2, p3, t3
	 p1,p2,p3 - ��� ������� ������ ������������ �� �������, ������������� �������  getPoints()
	 t1,t2,t3 - ��� ������� ����� �� �������� �� �������, ������������� ������� getTexCoords()  	   */
		rectmesh.getFaces().addAll(
				0,0,1,2,2,3,		// ABC
				0,0,2,3,3,1 );		// ACD
	/* ����� ������� �������� �����������. ��� ����� ��������� ����������� �������� � ������ Image, � ����� ��������
	 ��� � ����� setDiffuseMap() ������ PhongMaterial  */
		 Image im = null; ;
     	// ���������  �������� �������, ������� ������������� �� ��� ����
     try {
			im = new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg"));
		} catch (Exception e) {
			System.out.println("�� ������� ��������� �����������");
		}
		PhongMaterial material = new PhongMaterial();
		material.setDiffuseMap(im);
	/* ����� �������� ������� ������ ������ MeshView � �������� ��� ������� ������� TriangleMesh � PhongMaterial */
		MeshView meshView = new MeshView();
		meshView.setMesh(rectmesh);
		meshView.setMaterial(material);
		meshView.setDrawMode(DrawMode.FILL);
		meshView.setCullFace(CullFace.NONE);
		
/*--------------------------------------------����� SUBSCENE------------------------------------------------------------------------ 
   ��� ���������� ���������� ����������� ������������ ����� Scene �������� ��� ������������
   ����������� Scene(Parent root, double width, double height, boolean depthBuffer)
   ����������� Scene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) 

   ������ ������������� ������� ����� ��� ����������� 3D ������������ ����� ������������ ������ ������ SubScene.
   ��� �������� �������, ���� �� ����� �������� �� ����� ������������ ����- � ���������� �������.	
   ������������ Object - Node - SubScene
   	����������� SubScene(Parent root, double width, double height, boolean depthBuffer)
    ����������� SubScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing)
    	- root - ������ �� �������� ���������,
    	- width � height - ������� ��������,
    	- depthBuffer - ��� true ������ ����� ����� ����� ����� �������,
	   	- antiAliasing - ������ ������� �����������. 
	   		   - SceneAntialiasing.DISABLED - ����� 3D ������ ����� ������������ ��������
	   		   - SceneAntialiasing.BALANCED - �������� �����������	
	��� ������ ���� 												   		   	*/

/*----------------------------------------���������-------------------------------------------------------------------------------
		  ����� LightBase ��������� ���������  
		  ������������ Object - Node- LightBase
		  � LightBase 2 ����������: 
		   - AmbientLight - �������� ����������� �����. ������ ���������� �� ���� ������ ����������
		   - PointLight - �������� �������� ���������. ����� ������������ ������� � ������ �� ��� �� ���� ������������
		 */
		AmbientLight aml1 = new AmbientLight();
		AmbientLight aml2 = new AmbientLight(Color.YELLOW);
		aml1.setColor(Color.YELLOW);			// ������������� ���� �����
		aml1.setLightOn(false);					// �������� ����, ���� true 
		aml1.getScope().addAll(box);			// ��������� � scope ���������� �������� ��������� ������
		
		PointLight poil1 = new PointLight();
		PointLight poil2 = new PointLight(Color.YELLOW);
		poil1.setColor(Color.YELLOW);
		poil1.setLightOn(true);
		poil1.setTranslateX(10);
		poil1.setTranslateY(10);
		poil1.setTranslateZ(10);		
		poil1.getScope().addAll(box);
		
			// ���������� 3D �������� � root node
		Group group = new Group(); 
//		group.getChildren().addAll(box, cyl, sph);
		group.getChildren().addAll(box);
			// ���������� 3D �������� �� Scene 
		SubScene subscene = new SubScene(group, 800, 500, true, SceneAntialiasing.BALANCED);
		subscene.setWidth(600);
		subscene.setHeight(500);
		subscene.setRoot(group);
		subscene.setFill(Color.AQUAMARINE);			// ���� ����
			/* ��� ������������ �������� �� ����� ������������� ������. ���� ������� ������, �� ����� ����� � ������������.
			 �� ��������� ������ ������� � ����������� ������������� �������� ��� Z.				 
			 ������������ Object- Node - Camera 
			 Camera - ��� ����������� �����, ��� ���������: 
			     - ParallelCamera - ������ ����� ������������ ����, ������� ������� ��������� ����������� ���
			     - PerspectiveCamera - ������ ����������  		*/
		ParallelCamera paralCamera = new ParallelCamera();
		PerspectiveCamera persCamera1 = new PerspectiveCamera();			// ������ ������ ������
		PerspectiveCamera persCamera2 = new PerspectiveCamera(true);		/* ���� �������� ����� true, �� ��������� ���� �����������
				� ����� (0,0,0) ��������� ������� ���������. ��� �������� ����� ������������, ���� ����������� ���������� ������ ������
				�����. �� ��������� ����� �������� false.		*/
		double trX = 500.0, trY = 500.0, trZ = 500.0;
		double aX = -30.0, aY = 230.0, aZ = 50.0;
		Translate tr = new Translate(trX, trY, trZ);		// ������ �������� ������ �� ������ ���������
		Rotate rx = new Rotate(aX, Rotate.X_AXIS);
		Rotate ry = new Rotate(aY, Rotate.Y_AXIS);
		Rotate rz = new Rotate(aZ, Rotate.Z_AXIS);
		persCamera2.getTransforms().addAll(tr,rx,ry,rz);
		persCamera2.setNearClip(0);						// ������� ����� ��������� �������� �� ����� ������������. �� ��������� - 0,1
		persCamera2.setFarClip(1000);					// ������� ������ ��������� �������� �� ����� ������������. �� ��������� - 0,1
		persCamera2.setFieldOfView(50);					// ������ ���� ������ � �����. �� ��������� - 30 ��������
		subscene.setCamera(persCamera2);								// ��������� ��� ������


		
		
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
