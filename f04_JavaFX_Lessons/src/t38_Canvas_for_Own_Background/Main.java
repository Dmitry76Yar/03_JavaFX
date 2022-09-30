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
		
/*--------------------------------------------����� CANVAS---------------------------------------------------------------------------
  ��������� ���������� �������� �� �����������, ���������� �������. ����� ���������� ����� ������ � �������� � ��������, ������� �����
  ���������� ��������, �������� �����������, �������� �������.
  ����� ��������� ������������ ��� ������� ���� � ����������, ������� ����� ��������� ����������� ������� ������������ �����.
  ��������� ����������� �����������, ������� ������ ������ ��������� ��������� �������� (8192 ���).			
  ��������� Object - Node - Canvas									 */
		
			/* ������������
		- Canvas() 							  - ����� � ����������� �� ���������
		- Canvas(double width, double height) - ����� � ������������� ��������� 		 */
	Canvas cv1 = new Canvas();
	Canvas cv2 = new Canvas(100, 100);
		
			// ����� ��������� � ��������� ��������
	cv1.setWidth(400);		cv1.getWidth();
	cv1.setHeight(400);		cv1.getHeight();
		
			// ������� ���� ���������� ������
	GraphicsContext gc2 = cv2.getGraphicsContext2D();
	gc2.setFill(Color.GREEN);								//
	gc2.fillRect(0, 0, cv2.getWidth(), cv2.getHeight());	// �������� ������������, ����� ��-�� �����, �� ��������� ������������
		
			// ��������� �����
	gc2.setStroke(Color.BLACK);		
	gc2.strokeRect(2, 2, cv2.getWidth()-4, cv2.getHeight()-4);
	
			// ��������� ������������� ������� (�����)
	 GraphicsContext gc3 = cv1.getGraphicsContext2D();
	 gc3.setFill(Color.WHITE);								
	 gc3.fillRect(0, 0, cv1.getWidth(), cv1.getHeight());	
	 gc3.setStroke(Color.BLUE);				// ���� �������
	 gc3.setLineWidth(3.0);					// ������� �������
	 gc3.setLineDashOffset(1);				// ������ �������� ������ ���������� �����
	 gc3.setLineDashes(25, 15);				//  ������ ������� ������ ����� ������,  �������� - ����� ��������
	 gc3.setLineCap(StrokeLineCap.ROUND);	// ������ ����� ��������� �����
	 gc3.setLineJoin(StrokeLineJoin.MITER);	// ������ ����� ��������� � ����� ���������� ���� ����� �������
	 gc2.fillRect(0, 0, cv1.getWidth(), cv1.getHeight());
	 gc3.strokeRect(2, 2, cv1.getWidth()-4, cv1.getHeight()-4);
	 
	 /* ������� ���������
	 
	 rectan1.setStroke(Color.BLACK);		rectan1.setStrokeWidth(2);
	 rectan1.getStrokeDashArray().addAll(25.0,15.0);
	 	// ����� ��������� ����� ��� ������
	 rectan1.setStrokeLineCap(StrokeLineCap.SQUARE);
	 	// ���������� ������������  ������ ������� ����� ������������ ��������, ��� ��� �����������
	 polygon.setFill(Color.BROWN);
	 polygon.setStroke(Color.BLACK);
	 polygon.setStrokeWidth(2);
	 polygon.setSmooth(true);

	
/*--------------------------------------------����� GraphicsContext---------------------------------------------------------------------------
  ��������� ��������, ����������� �������� �� ������.			 */
		// ��������� ������ �� ������ GraphicsContext, ��������� � ������ �������
	GraphicsContext gc6 = cv1.getGraphicsContext2D();		
		// ��������� ������ �� ������ Canvas �� ������� GraphicsContext
	Canvas cv3 = gc3.getCanvas();
	
		// ������� ���� ���������� ������
	gc3.setFill(Color.BEIGE);
	Paint curColor = gc3.getFill();
	
		// ��������� ����������� �� ���
	Canvas cv4 = new Canvas(100, 100);
	GraphicsContext gc4 = cv4.getGraphicsContext2D();
    ImagePattern im = null; ;
    	// ���������  �������� �������, ������� ������������� �� ��� ����
    try {
		im = new ImagePattern(new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg")));
		gc4.setFill(im);
	} catch (Exception e) {
		System.out.println("�� ������� ��������� �����������");
	}
    gc4.fillRect(0, 0, cv4.getWidth(), cv4.getHeight());
    
 		// ��������� ��������� ��������� �� ���
    Canvas cv5 = new Canvas(100, 100);
	GraphicsContext gc5 = cv5.getGraphicsContext2D();
    Stop[] stops = new Stop[] {new Stop(0, Color.BLACK), new Stop(1, Color.WHITE)};
//    gc5.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops));
    gc5.fillRect(110, 10, 40, 40);
    
    	// ��������� ����� ��������
    PixelWriter pw = gc3.getPixelWriter();
    for (int x = 10; x<cv1.getWidth(); x++) pw.setColor(x, 40, Color.RED);		// ���� ����� �� 1 �������
    
    	// ��������� ������ �����
    gc3.setStroke(Color.BLACK);
    gc3.setLineWidth(2);
    gc3.setLineDashes(5, 5);			// ������� ��� �����
    gc3.strokeLine(20, 20, 129, 20);    // ����� ����� ����� ������� � ������������ (x1, y1, x2, y2)
    
    	// ��������� ������� �����
    gc3.setStroke(Color.RED);
    gc3.setLineWidth(5);
    gc3.setLineCap(StrokeLineCap.ROUND);		 // ������ ����� ��������� �����
    gc3.strokeLine(101, 100, 100, 100);   		 // ����� ����� ����� ������� � ������������ (x1, y1, x2, y2)
    
    	// ��������� �������� �����  strokePolyline(double[] {x1,x2..xn}, double[] {y1,y2..yn}, int points);
    gc3.setStroke(Color.BLACK);
    gc3.setLineWidth(2);
    gc3.setLineJoin(StrokeLineJoin.MITER);			// ������ ����� ��������� � ����� ���������� ���� ����� �������
    gc3.strokePolyline(new double[] {100,20,100}, new double[] {80,120,120}, 3);
    gc3.strokeLine(20, 20, 129, 20);    // ����� ����� ����� ������� � ������������ (x1, y1, x2, y2)
    
    	// ��������� ���� ��� �������
    gc3.setStroke(Color.DARKGREEN);
    gc3.setLineWidth(3);
    gc3.strokeArc(10, 150, 100, 100, 45, 270, ArcType.OPEN);
    
    	// ��������� ����������       � ������� ���� ��������� ������������
    gc3.setFill(Color.YELLOW);
    gc3.setStroke(Color.DARKGOLDENROD);
    gc3.setLineWidth(3);
    gc3.beginPath();
    gc3.moveTo(120,50);			// ���������  �����
    gc3.lineTo(200, 50);		// ����� � ����� (200, 50)
    gc3.lineTo(200, 110);		// ��������� ����� � ����� (200, 110)
    gc3.closePath();			// ��������� ���������� � ��������� � 1�� �����
    gc3.stroke();				// ����� ������
    gc3.fill();					// ������� ������
//  gc3.arcTo(10, 150, 100, 100, 45);			- ������ ���������� � ����� ����
    
    	// ��������� �����
//  ����� ������� ������� ����� ��������� �� �������� ������ gc3.fill();
//  gc3.fillRect(100, 100, 150, 150);	 			  	  // ������������� c ��������
//  gc3.fillRoundRect(100, 100, 150, 150, 20, 20);	 	  // ������������� c ����������� ������  c ��������
//  gc3.strokeRect(100, 100, 150, 150);	 			  	  // ������������� c ������
//  gc3.strokeRoundRect(100, 100, 150, 150, 20, 20);	  // ������������� c ����������� ������ c ������
//  gc3.fillOval(20, 100, 100, 40); 					  // ���� � ��������
//  gc3.strokeOval(20, 100, 100, 40); 					  // ���� � ������
//  gc3.fillPolygon(new double [] {100, 20, 100} , new double[] {180, 220, 220}, 3);	// ������������� � ��������
//  gc3.strokePolygon(new double [] {100, 20, 100} , new double[] {180, 220, 220}, 3);	
    
    	// �����
    gc3.setFill(Color.BLACK);
    gc3.setFont(new Font(24));					// ��������� ������
    gc3.setTextAlign(TextAlignment.CENTER);		// ������ �����.������������ ������������ �����  
    gc3.setTextBaseline(VPos.CENTER);			// ������ ������.������������ ������������ �����    
    gc3.fillText("TEXT", 220, 70, 20);			// ��������� �������, ���������� ����� ��������� ��� ������ � ������ ���� ��� ������
    	// ����� ���������, ����� ��������� ���� � ���� ������������� ������
    	// ����� ����� �� ��������, � ������ ���������, ����� �������� �����
    gc3.save();							// ����� ��������� � ����� ������� �������� ��������� �������������
    gc3.beginPath();
    gc3.rect(210, 145, 225, 160);			// ���������� ������� �����
    gc3.clip();
    gc3.fillText("TEXT", 220, 150);
    gc3.restore();						// ������������� �������� ���-�, ����������� ������� save()
    
    	// �����������
    WritableImage img = new WritableImage(100, 100);				
    gc3.drawImage(img, 20, 20);					// (img, x, y) ����� ����������� � ������� � ������������ x,y
    gc3.drawImage(img, 20, 20, 50, 50);			// (img, x, y,w,h)  ����� ����������� � ������� � ������������ x,y � ���� � ��������
    											// w,h. ����������� ����������� ��� ������������� ,����� ��������� � ��� �������. 
    											// ��� ���� ����������� ����� ��������� ��� �����
    gc3.drawImage(img, 0, 0, 50, 50,			// (img,sx,sy,sw,sh,dx,dy,dw,dh) - ����� �� ����������� ������������� �������� 
    				   20, 20, 50, 50);			// (sx,sy,sw,sh) � ��������� ��� � ���� (dx,dy,dw,dh)
    
    	// ������� ������������� ������� ��� ����� ������
//    gc3.clearRect(50, 100, 50, 100); 						// (x,y,w,h) ������� ��������
//    gc3.clearRect(0, 0, cv1.getWidth(), cv1.getHeight()); 	// (x,y,w,h) ������� ���� ������
    
    	// ������������� ������
    	// ������ ������� �������������� �� 0.0 �� 1.0 (������������)
    gc3.save();
    	gc3.setFill(Color.BLUE);
	    gc3.setGlobalAlpha(0.5);					 
	//    gc3.fillRect(150, 150, 40, 40);
	    gc3.setGlobalBlendMode(BlendMode.ADD);			// save(), restore(), ����� ��� ����� ������ ������ �� ������
    gc3.restore();
    	// ������ ��������� �������� ��� ����������� ���� �����
    gc3.setFill(Color.GREEN);
//    gc3.fillRect(150, 150, 40, 40);
    gc3.save();
	    gc3.setFill(Color.BLACK);
	    gc3.setGlobalAlpha(0.5);					 
	//    gc3.fillRect(150, 130, 40, 40);
	    gc3.setGlobalBlendMode(BlendMode.OVERLAY);			
    gc3.restore();		
    	// �������� ���������������
    gc3.save();
	    gc3.scale(2.0, 2.0);
//	    gc3.fillRect(75, 65, 40, 40);
    gc3.restore();	
    	// ������� 
    gc3.save();
   		gc3.rotate(45.0);
    	gc3.fillRect(75, -20, 40, 40);		// �������� �������������� �� 45 �� ������������ ������ �������� ����
    gc3.restore();
    	// �������� ������� ���������		���� ������ �������� ���������. �� 45 �������� ������������ ����� �������
    gc3.save();
    gc3.setStroke(Color.GREEN);
    gc3.translate(200, 200);
    gc3.rotate(45);
    gc3.strokeRect(0, 0, 40, 40);
    gc3.restore();
    	// ������� �������������		���� ������ �������� ���������. �� 45 �������� ������������ ������ �������������
    gc3.save();
    gc3.setFill(Color.BLUE);
    double x = 150, y=150, width = 50, height = 50;
    Rotate r = new Rotate(45, x+width/2, y+height/2);
    gc3.setTransform(r.getMxx(), r.getMyx(), 
    				 r.getMxy(), r.getMyy(), 
    				 r.getTx(), r.getTy());
    gc3.fillRect(x, y, width, height);
    gc3.restore();
    	// ������ ������ ��� ����������� ��������     ��� ���������� ����� ��������  null
    gc3.save();
    gc3.setEffect(new DropShadow());		// ����������� ����
    gc3.setFill(Color.BISQUE);
    gc3.fillRect(30,300, 50, 50);
    gc3.restore();
    	// ��������� ������ �� ����� ������
    gc3.applyEffect(new DropShadow());
    	// �������  �������� �� ����, ���������� ��������, �������  
    Rectangle rect = new Rectangle(50,50);
    rect.setFill(Color.DARKORANGE);
    rect.setScaleX(2);			// � 2 ����
    rect.setScaleY(2);
    rect.setScaleZ(0);
    rect.setTranslateX(250);
    rect.setTranslateY(50);
    rect.setTranslateZ(0);
    rect.setRotate(45);			// �� ��������� �������� ������ ��� Z
    	// ������ �������� ������ ������ ����
    Rectangle rect2 = new Rectangle(50,50);
    rect2.setFill(Color.DARKORANGE);
    rect2.setRotationAxis(Rotate.X_AXIS);
    rect2.setRotate(45);
    	// ������  ������������� �������� �� ���������� ����
    Rectangle rect3 = new Rectangle(50,50);
    rect3.setFill(Color.DARKORANGE);
    Rotate rx = new Rotate(30, Rotate.X_AXIS);
    Rotate ry = new Rotate(50, Rotate.Y_AXIS);
    Rotate rz = new Rotate(30, Rotate.Z_AXIS);
    rect3.getTransforms().addAll(rx,ry,rz);
    	
    	/* ������������� ����� ����� Transform, Affine
     ������� {	mxx, mxy, mxz, tx
     			myx, myy, myz, ty, 
     			mzx, mzy, mzz, tz}
     ���������� ��������� ���������� ���: 
     		x = mxx*x + mxy*y + mxz*z +tx
     		y = myx*x + myy*y + myz*z +ty
     		x = mzx*x + mzy*y + mzz*z +tz		  	 */
    	// ���� ������ �� �������� �� 100 ��� �� ���� x,y
    Affine m2 = new Affine	(1, 0, 0, 100,
    						 0, 1, 0, 100,
    						 0, 0, 1, 0);
    Rectangle rect4 = new Rectangle(50,50);
    rect4.setFill(Color.DARKGRAY);
    rect4.getTransforms().add(m2);
    	// ���� ������ �� ���������� �������� � 2 ����   ����� affine() ���������� �������� ������� ����� �����������
    Affine m3 = Transform.affine   (2, 0, 0, 0,
    								0, 2, 0, 0,
    								0, 0, 2, 0);
    	// ��������� ������� ����� �� ��������
    m2.setMxx(0);
    m2.setMxy(0); 		   // � �.�.
    	// ��������� �������� �������
    m2.getMxx();
    m2.getMxy(); 		   // � �.�.
    System.out.println(m2.toString());
    
    	// �������� ����� ����� Translate
    Translate tr2 = new Translate(100, 50, 0);		// �������� �� ��� � �� 100, � �� ��� � �� 50
    Rectangle rect5 = new Rectangle(50,50);
    rect5.setFill(Color.DARKGRAY);
    rect4.getTransforms().add(tr2);
    	// ��������� ������� ����� �� ��������
    tr2.setX(0);
    tr2.setY(0); 		   // � �.�.
    	// ��������� �������� �������
    tr2.getX();
    tr2.getY();
    
    	// 	��������������� ����� ����� SCALE
  /* ����������� Scale(x, y, z, pivotX, pivotY, pibotZ)
   ��� ���� ��������� ������� {	x, 0, 0, ((1-x)*pivotX)
     							0, y, 0, ((1-y)*pivotY) 
     							0, 0, z, ((1-z)*pivotZ)}		  	
     ��� x,y,z - �������� �� ����
         pivotX.. - ���������� ������� ����� ������������ ������� �������� ���������������	    		 */
    	// ���� ������ �� �������������� �������������� � 2 ���� ������������ ����� ��������������
    Scale tr5 = new Scale(2, 2, 1, 25, 25, 0);
    Rectangle rect6 = new Rectangle(50, 50);
    rect6.setFill(Color.BLACK);
    rect6.getTransforms().add(tr5);
    	// ��������� ������� ����� �� ��������
    tr5.setX(0);
    tr5.setPivotY(0); 		   // � �.�.
    	// ��������� �������� �������
    tr5.getX();
    tr5.getPivotX();
    
    	/* �������� ����� ROTATE
    ����������� Rotate(angle, pivotX, pivotY)
    ����������� Rotate(angle, pivotX, pivotY, pivotZ)
    ����������� Rotate(angle, Point3D axis)
    ����������� Rotate(angle, pivotX, pivotY, pivotZ, Point3D axis)
    	��� angle - ���� �������� � �����
    	    axis - ������� ���, ������ ������� ���������� ��������. �� ��������� Rotate.Z_AXIS  
    	    pivotX.. - ���������� ������� �����, ������������ ������� ����������� ��������	   */
    // ���� ������ �������� �������������� �� 45 �� ������������ ������ ���
    Rotate tr6 = new Rotate(45,25,25);
    Rectangle rect7 = new Rectangle(50, 50);
    rect7.setFill(Color.LAVENDER);
    rect.getTransforms().addAll(tr6);
    
    	/* ����� ����� SHEAR
    ����������� Shear(x,y)
    ����������� Shear(x,y, pivotX, pivotY)
    	��� x,y - ����� �� ��� x,y
    	     pivotX - ���������� ������� �����   	 */
    	
    	/* �������  ������� ����
    ����������� Dropshadow()
    ����������� Dropshadow(radius, color)
    ����������� Dropshadow(radius, offsetX, offsetY, color)
    ����������� Dropshadow(blurType, color, radius, spread, offsetX, offsetY)
     ��� blurType - ������ �������� �������� ���� 
      	 radius - ������ �������� ����. ����� ������� �� 0 �� 127. �� ��������� - 10
      	 spread - ���� 0, �� ���� ��������� ������������ ���������� �������� blurType
      	  		  ���� 1, �� �������� ����������
      	  		  ���� 0-1, �� ��������� �������������� ������� ��������
      	 offsetX - �������� ���� �� ��� �. �� ��������� - 0
      	 offset� - �������� ���� �� �. �� ��������� - 0    	 */
    // ������ �������� ���� �� ���������
    DropShadow effect3 = new DropShadow(20, 10, 10, Color.BLACK);
    Rectangle rect8 = new Rectangle(50, 50);
    rect8.setFill(Color.LAVENDER);
    rect8.setEffect(effect3);
    
    	/* �������  ���������� ����
    ����������� InnerShadow()
    ����������� InnerShadow(radius, color)
    ����������� InnerShadow(radius, offsetX, offsetY, color)
    ����������� InnerShadow(blurType, color, radius, choke, offsetX, offsetY)
     ��� blurType - ������ �������� �������� ���� 
      	 radius - ������ �������� ����. ����� ������� �� 0 �� 127. �� ��������� - 10
      	 choke - ���� 0, �� ���� ��������� ������������ ���������� �������� blurType
      	  		  ���� 1, �� �������� ����������
      	  		  ���� 0-1, �� ��������� �������������� ������� ��������
      	 offsetX - �������� ���� �� ��� �. �� ��������� - 0
      	 offset� - �������� ���� �� �. �� ��������� - 0    	 */
    // ������ �������� ���� �� ���������
    InnerShadow effect4 = new InnerShadow(20, 10, 10, Color.BLACK);
    Rectangle rect9 = new Rectangle(50, 50);
    rect9.setFill(Color.LAVENDER);
    rect9.setEffect(effect4);
    
    	/* �������  ����   (������ ���������� ���� � ����, � �� ��������� ���� � ����)
    ����������� Shadow()
    ����������� Shadow(radius, color)
    ����������� Shadow(blurType, color, radius)
     ��� blurType - ������ �������� �������� ���� 
      	 radius - ������ �������� ����. ����� ������� �� 0 �� 127. �� ��������� - 10
      	 choke - ���� 0, �� ���� ��������� ������������ ���������� �������� blurType
      	  		  ���� 1, �� �������� ����������
      	  		  ���� 0-1, �� ��������� �������������� ������� ��������
      	 offsetX - �������� ���� �� ��� �. �� ��������� - 0
      	 offset� - �������� ���� �� �. �� ��������� - 0    	 */
    // ������ �������� ���� �� ���������
    Shadow effect5 = new Shadow(40, Color.BLACK);
    Rectangle rect10 = new Rectangle(50, 50);
    rect10.setFill(Color.LAVENDER);
    rect10.setEffect(effect5);
    
    	/* �������  ���������� ���������
    ����������� Reflection()
    ����������� Reflection(topOffSet, fraction, topOpacity, bottomOpacity)
     ��� topOffSet - �������� ��������� �� ������ ������� ����
 		 fraction - ����� ����, ������� � ���������. �������� �� 0 �� 1. �� ��������� - 0,75
 		 topOpacity -������� �������������� ������� ����� ���������. �������� �� 0 �� 1. �� ��������� - 0,0
 		 bottomOpacity - ������� �������������� ������ ����� ���������. �������� �� 0 �� 1. �� ��������� - 0,0  */
    // ������ ���������� ����������� ��������� � ������
    Reflection effect6 = new Reflection(-20.0, 0.7, 0.5, 0.0);
    Text text = new Text("JavaFX");
    text.setFont(new Font(40));
    text.setEffect(effect6);

    	/* �������  �������� �� ������
    ����������� GaussianBlur()
    ����������� GaussianBlur(radius)
     ��� radius - ������ ��������. �������� �� 0 �� 63. �� ��������� - 10			*/
    	// ������ ���������� � ������
    Text text1 = new Text("JavaFX");
    text1.setFont(new Font(40));
    text1.setEffect(new GaussianBlur());
    
    	/* �������  �������� � ��������
    ����������� MotionBlur()
    ����������� MotionBlur(angle, radius)
     	��� radius - ������ ��������. �������� �� 0 �� 63. �� ��������� - 10			
    	 	angle - ���� �������� � ��������. �� ��������� - 0 */
    // ������ ���������� � ������
    Text text2 = new Text("JavaFX");
    text2.setFont(new Font(40));
    text2.setEffect(new MotionBlur());
    
    	/* �������  �������� BOXBLUR
    ����������� BoxBlur()
    ����������� BoxBlur(width, height, iterations)
     	��� width - �������������� ������ ��������. �������� �� 0 �� 255. �� ��������� - 5			
    	 	height - ������������ ������ ��������. �������� �� 0 �� 255. �� ��������� - 5 
    	 	iterations - ���������� ���������� �������. �������� �� 0 �� 3. �� ��������� - 1    	 	*/
    Text text3 = new Text("JavaFX");
    text3.setFont(new Font(40));
    text3.setEffect(new BoxBlur(5,5,3));
    
    	/* �������  ��������
    ����������� Bloom()
    ����������� Bloom(threshold)
     	��� threshold - ����� ��������. �������� �� 0 �� 1. �� ��������� - 0,3	*/
    Text text4 = new Text("JavaFX");
    text4.setFont(new Font(40));
    text4.setEffect(new Bloom(0.5));
    
    	/* �������  �������� GLOW
    ����������� Glow()
    ����������� Glow(level)
     	��� level - ������������� ��������. �������� �� 0 �� 1. �� ��������� - 0,3	*/
    Text text5 = new Text("JavaFX");
    text5.setFont(new Font(40));
    text5.setEffect(new Glow(0.5));
    
    	// ������� ������������� ����������� PerspectiveTransform
    
    	/* �������  ��������� ��������� ����, ������������, �������, 
    ����������� �olorAdjust()
    ����������� �olorAdjust(hue, saturation, brightness, contrast)
     	��� hue - ����������� ��������� ����. �������� �� -1 �� 1. �� ��������� - 0,0
     		saturation - ����������� ������������. �������� �� -1 �� 1. �� ��������� - 0,0
     		brightness - ����������� �������. �������� �� -1 �� 1. �� ��������� - 0,0
     		contrast - ����������� ���������. �������� �� -1 �� 1. �� ��������� - 0,0		     		*/
    Text text6 = new Text("JavaFX");
    text6.setFill(Color.BLUE);
    text6.setFont(new Font(40));
    text6.setEffect(new ColorAdjust(-0.5, 0, -0.5, 0));
    
   		/* �������  C����������� 
    ����������� SepiaTone()
    ����������� SepiaTone(level)
     	��� level - ������������ ������������. �������� �� 0 �� 1. �� ��������� - 1,0		     		*/

    	/* �������  ��������� ���������� �����
    	����������� Lighting()
    	����������� Lighting(Light light)
     	��� light - ������ �������� �����. �� ��������� ���-�� Light.Distant		     		*/
    Lighting effect7 = new Lighting();
    Light.Distant light = new Light.Distant();
    effect7.setLight(light);			// setLight() ������ �������� �����. �� ��������� ���-�� Light.Distant		     		
    effect7.setDiffuseConstant(1);		// setDiffuseConstant() - ������ ����������� ����. �������� - �� 0 �� 2.�� ��������� - 1
    effect7.setSpecularConstant(1);		// setSpecularConstant() - ������ ��������� ����� � ������. �������� - �� 0 �� 2.�� ��������� - 0,3
    effect7.setSpecularExponent(1);		// setSpecularExponent() - ��������� ����� �� �����. �������� - �� 0 �� 40.�� ��������� - 20
    effect7.setSurfaceScale(1);			// setSurfaceScale() - ����������� �������� �����������. �������� - �� 0 �� 10.�� ��������� - 1,5
    effect7.setBumpInput(new DropShadow());		// setBumpInput(Effect value) - ������ ������� ������ ��� �������� �������
    											// �����������. �� ��������� - ������ Shadow c �������� �������� 10
    effect7.setSpecularExponent(1);		// setSpecularExponent() - ��������� ����� �� �����. �������� - �� 0 �� 40.�� ��������� - 20
    Text text7 = new Text("JavaFX");
    text7.setFill(Color.WHITE);
    text4.setFont(new Font(40));
    text4.setEffect(effect7);
    
	   		/* ����� LIGHT
	   	�������� � ������� ����������� �������: Light.Distant, Light.Point, Light.Spot
	   	Light.Distant - ��������� ���������� ���������� ��������� �������� ����� (������)
	   	Light.Point - ��������� �������� �������� ����� (������ ��������, ��������� ������ ���� ��� ������ ����� 
	   	Light.Spot - ��������� Light.Point ��������� �������, �������� ��� ������� ������  */
	Lighting effect8 = new Lighting();
		/* Light.Distant 
	 ����������� Distant()
	 ����������� Distant(azimuth, elevation, color)		 */
	Light.Distant light1 = new Light.Distant();
	light1.setAzimuth(45);			// ������ ������ (���� ����������� � �������� � ��������� XY. �� ��������� - 45
	light1.setElevation(45);		// ������ ������ (���� ����������� � �������� � ��������� YZ. �� ��������� - 45
	light1.setColor(Color.WHITE);	// ������ ���� ��������� �����. �� ��������� - �����
		/* Light.Point 
	 ����������� Point()
	 ����������� Point(x, y, z, color)		 */
	Light.Point light2 = new Light.Point();
	light2.setX(100);			// ��������� ��������� ����� �� ��� �. �� ��������� - 0
	light2.setY(50);			
	light2.setZ(100);			
	light2.setColor(Color.WHITE);	// ������ ���� ��������� �����. �� ��������� - �����
		/* Light.Spot 
	 ����������� Spot()
	 ����������� Spot(x, y, z, specularExponent, color)		 */
	Light.Spot light3 = new Light.Spot();
	light3.setX(100);					// ��������� ��������� ����� �� ��� �. �� ��������� - 0
	light3.setY(50);			
	light3.setZ(100);
	light3.setPointsAtX(100);			// ���������� ������� ����������� ��������� ����� �� ��� �. �� ��������� 0
	light3.setPointsAtY(50);			// ���������� ������� ����������� ��������� ����� �� ��� Y. �� ��������� 0
	light3.setPointsAtZ(0);				// ���������� ������� ����������� ��������� ����� �� ��� Z. �� ��������� 0
	light3.setColor(Color.WHITE);		// ������ ���� ��������� �����. �� ��������� - �����
	light3.setSpecularExponent(1);		// ��������� �������. �������� �� 0 �� 4. �� ��������� - 1
	
		/* �������  ����������
	�������� ����� � ������, ��������� ������ ��������� � ������������ BlendMode 
    ����������� Blend()
    ����������� Blend(Blendmode mode)
    ����������� Blend(Blendmode mode, Effect bottomInput, Effect topInput)
     	��� hue - ����������� ��������� ����. �������� �� -1 �� 1. �� ��������� - 0,0
     		saturation - ����������� ������������. �������� �� -1 �� 1. �� ��������� - 0,0
     		brightness - ����������� �������. �������� �� -1 �� 1. �� ��������� - 0,0
     		contrast - ����������� ���������. �������� �� -1 �� 1. �� ��������� - 0,0		     		*/
	ColorInput colorInput = new ColorInput();
	colorInput.setPaint(Color.WHITE);
	colorInput.setX(50);
	colorInput.setY(50);
	colorInput.setWidth(70);
	colorInput.setHeight(70);
	Blend effect9 = new Blend();
	effect9.setMode(BlendMode.OVERLAY);		// ������ ����� ���������� �������� ����� � ������. �� ��������� Blend.SRC_OVER
	effect9.setTopInput(colorInput);		// ������� ����. ���� null (�� ���������), �� � �������� ������� ������ ������������
												// ����������� ����, � �������� ����������� ������
	//effect9.setBottomInput();				// ������ ����. ���� null (�� ���������), �� � �������� ������� ������ ������������
												// ����������� ����, � �������� ����������� ������
	effect9.setOpacity(0.9);				// ������ ������� �������������� �������� �����. �� 0 �� 1 (������������) - �� ���������
	
	Rectangle rect11 = new Rectangle(100, 100);
	rect11.setFill(Color.GREEN);
	rect11.setEffect(effect9);
	
		/* ����� COLORINPUT
		��������� ������������ ������������ ������� � �������� � �������� �������� ������� ������� ��� �������
		����������� ColorInput()
		����������� ColorInput(x, y, width, height, Paint paint)		 */
	ColorInput colorInput1 = new ColorInput();
	colorInput1.setPaint(Color.WHITE);	// ������ ���-�� �������
	colorInput1.setX(50);				// ���������� ������ �������� ���� ����.���-�� �� ��� �
	colorInput1.setY(50);				// ���������� ������ �������� ���� ����.���-�� �� ��� �
	colorInput1.setWidth(70);			// ������ ����.���-��
	colorInput1.setHeight(70);
	
		/* ����� IMAGEINPUT
		��������� ������������ ������������ ������� � �������� � �������� �������� ������� ������� ��� �������
		����������� ImageInput()
		����������� ImageInput(Image source)		 
		����������� ImageInput(Image source, x,y)			*/
	WritableImage wim = new WritableImage(70,70);
	PixelWriter pw1 = wim.getPixelWriter();
	for (int x1=0, w=(int)wim.getWidth(); x1<w; x1++) 
		for (int y1=0, h=(int)wim.getWidth(); y1<h; y1++)
				pw1.setColor(x1, y1, Color.WHITE);
	ImageInput imageInput = new ImageInput();
	imageInput.setSource(wim);					// ������ �����������
	imageInput.setX(50);						// ���������� ������ �������� ���� ����.���-�� �� ��� �
	imageInput.setY(50);						// ���������� ������ �������� ���� ����.���-�� �� ��� �
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
