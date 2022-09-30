package t37_Animation;
	
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.util.Duration;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
	
	@Override 
public void start(Stage primaryStage) {	
		
/* 			����� DURATION
 		����������� Duration(double millis) 		*/
	Duration d1 = new Duration(500.0);			// ������ ����������������� � �������������
	Duration d2 = Duration.millis(500.0);		// ������ ����������������� � �������������
	Duration d3 = Duration.seconds(5.0);		// ������ ����������������� � ��������
	Duration d4 = Duration.minutes(0.5);		// ������ ����������������� � �������
	Duration d5 = Duration.hours(0.5);			// ������ ����������������� � hours
	Duration d6 = Duration.valueOf("500ms");	// ������ ����������������� � �������������
	Duration d7 = Duration.ONE;					// ������ ����������������� � 1 ������y
		// ���������� ������������
	System.out.println(d7.toMillis());
	System.out.println(d7.toSeconds());
	System.out.println(d7.toMinutes());
	System.out.println(d7.toHours());
		// �������� �����������������
	System.out.println(d7.add(d1));
	System.out.println(d7.subtract(d1));
	System.out.println(d7.multiply(2));
	System.out.println(d7.divide(2));
		// ��������� ������������
	System.out.println(d7.lessThan(d6));
	System.out.println(d7.lessThanOrEqualTo(d6));
	System.out.println(d7.greaterThanOrEqualTo(d6));
	System.out.println(d7.equals(d6));
	
/*---------------------------����� FadeTransition   ��������� ������������ ���������, �������, ������������) -------------------
 ������������ Object - Animation - Transition - FadeTransition */
	Rectangle rect = new Rectangle(100,100);
	rect.setFill(Color.BLUE);
	rect.relocate(350,350);
		// ����������� 
	FadeTransition ft = new FadeTransition();								// ������ �����������
	FadeTransition ft1 = new FadeTransition(Duration.seconds(10.0));		// ������������� �������� � 1 ��� ����� ������� ��������
	FadeTransition ft2 = new FadeTransition(Duration.seconds(10.0), rect);	// ������������� ���� � �������� � 1 ��� ����� ������� ��������
	ft.setDelay(Duration.ONE);		// ������ �������� ����� ������� �������� 
	ft.setNode(rect);               // ��������� ����
	ft.setAutoReverse(false);		// ���� true, �� ������ �������� ����� ����������� � ��������������� �����������
	ft.setFromValue(1);				// �������� �������������� - 1
	ft.setToValue(0);				// ��������� �������������� -0 
	ft.setCycleCount(7);					// ������ ���������� ���������� ��������. �� ��������� - 1 �������
	ft.setRate(0.5);				// ������ �������� � ����������� ��������. �� ��������� - 1. ������������� �������� ��������
									// � ��������� ����������� �� ���������������. �������� = 2 �������� �������� � 2 ����.
									// ���� �������� ����� �������� 0,0, �� �������� ����� �����������.
	ft.setDuration(Duration.seconds(1));	// ������ �������� ������ ����� ������ ����� ��������
	System.out.println("���p���� ������� �������� " + ft.getCurrentRate());
	System.out.println("���������������� ���������� ������ ����� " + ft.getCycleDuration());
	System.out.println("���������������� ���� �������� " + ft.getTotalDuration());
	System.out.println("������� ����� ���������� �������� �� ������� ������� " + ft.getCurrentTime());
		// �������� ����� �� ����� ������� ��� �������� � ��� 
	ft.getCuePoints().put("p1", Duration.seconds(1));
	ft.jumpTo(Duration.ONE);		// ������� �������������� ����� ��� ������� �������� ��� ������ play(). 
	ft.jumpTo("p1");
	
	System.out.println("������ �������� " + ft.getStatus());
	ft.setOnFinished(event -> {							// ���������� ����� ���������� ��������
		System.out.println("�������� ���������");
	});
	ft.play();				// ��������� �������� � ������� �������
	ft.playFrom("p1");	    // ��������� �������� � ��������� ����� ��� �������
	ft.playFromStart();		// ��������� �������� � ������
	
	// ������������� ����� �� �������� ��� �������� ����� �� ������������� 
	rect.addEventHandler(MouseEvent.MOUSE_CLICKED,  event -> {
		if (ft.getStatus() == Animation.Status.RUNNING) ft.pause();
		else ft.play();
	});
//	ft.pause();				
//	ft.stop();              // ������������� ��������. ����� ������������� �������� �������� ����������� ����� �������, ��� ��������
							// ����, ����� ��� ��� � ���������� �������� ����� �� ����� ������� ��� ���� ����������.
		
 /* --------------------����� TranslateTransition �������� ������������-----------------------------------------------------
      ������������ Object - Animation - Transition - TranslateTransition								*/
	Rectangle rect2 = new Rectangle(70,70);
	rect2.setFill(Color.DARKRED);
	rect2.relocate(50, 50);
		// ����������� �������� ������������ �������������� �� �����
	TranslateTransition tt= new TranslateTransition();							// ������ �����������
	TranslateTransition tt1 = new TranslateTransition(Duration.seconds(10.0));		// ������������� �������� � 1 ��� ����� ������� ��������
	TranslateTransition tt2 = new TranslateTransition(Duration.seconds(10.0), rect);	// ������������� ���� � �������� � 1 ��� ����� ������� ��������
	tt.setDelay(Duration.ONE);			 // ������ �������� ����� ������� �������� 
	tt.setNode(rect2);              	 // ��������� ����
	tt.setAutoReverse(false);			 // ���� true, �� ������ �������� ����� ����������� � ��������������� �����������
	tt.setFromX(0);						 // �������� ����� ��� ������ ��������
	tt.setToX(450);					 
	tt.setRate(0.5);					 // ������ �������� � ����������� ��������. �� ��������� - 1. ������������� �������� ��������
										 // � ��������� ����������� �� ���������������. �������� = 2 �������� �������� � 2 ����.
										 // ���� �������� ����� �������� 0,0, �� �������� ����� �����������.
	tt.setDuration(Duration.seconds(1));	// ������ �������� ������ ����� ������ ����� ��������
	tt.setCycleCount(Animation.INDEFINITE);			// ����� ������
	tt.setInterpolator(Interpolator.EASE_BOTH);		/* ������ ������ �������� �������� ����� ������ ������ Interpolator. ��������,
				 �������� ������� �������� � ����� ���������.
				 Discrete - �������� �������� ��������� �� ��������� ���������� ��������� � ����� ���������� �����������
				 Linear - ����������� ��� ��������
				 Ease_in - ���������� � ������ � ��������� � ����� ��������
				 Ease_out - ���������� �������� � ������ � ���������� � �����
				 Ease_both - ���������� � ������, ����� ����������� ��� � ���������� � ����� 	 */
	
	System.out.println("���p���� ������� �������� " + ft.getCurrentRate());
	System.out.println("���������������� ���������� ������ ����� " + ft.getCycleDuration());
	System.out.println("���������������� ���� �������� " + ft.getTotalDuration());
	System.out.println("������� ����� ���������� �������� �� ������� ������� " + ft.getCurrentTime());
	tt.play();
	
/* --------------------����� PathTransition �������� �������� ����� �������� �����------------------------------------------------
    ������������ Object - Animation - Transition - PathTransition								*/
	Rectangle rect3 = new Rectangle(70,70);
	rect3.setFill(Color.GREEN);
	rect3.relocate(150, 50);
		// ����������� 
	Shape path = null;
	Shape path1 = null;
	PathTransition pt= new PathTransition();										// ������ �����������
	PathTransition pt1 = new PathTransition(Duration.seconds(1.0), path);			// ������������� �������� � ����������
	PathTransition pt2 = new PathTransition(Duration.seconds(1.0), path1, rect);	// ������������� ����, �������� � ����������
	Path path3 = new Path (
							new MoveTo(0,0), 
							new QuadCurveTo(200, 200, 400, 0));
		/* ����� path() ������ ���������� �� ������� �������� ����.  � �������� ��������� ����� Shape
		   ����� setOrientation() ������ ���������� ���� ������������ ����������:
		    - NONE - ���������� �� ����������
		    -  ORTHOGONAL_TO_TANGENT - ���������� ����� ��������������� ����������*/
	pt.setDelay(Duration.ONE);			 // ������ �������� ����� ������� �������� 
	pt.setNode(rect3);              	 // ��������� ����
	pt.setPath(path3);
	pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);		//
	pt.setAutoReverse(false);			 // ���� true, �� ������ �������� ����� ����������� � ��������������� �����������
	pt.setRate(0.5);					 // ������ �������� � ����������� ��������. �� ��������� - 1. ������������� �������� ��������
										 // � ��������� ����������� �� ���������������. �������� = 2 �������� �������� � 2 ����.
											 // ���� �������� ����� �������� 0,0, �� �������� ����� �����������.
	pt.setDuration(Duration.seconds(5));	// ������ �������� ������ ����� ������ ����� ��������
	pt.setCycleCount(Animation.INDEFINITE);			// ����� ������
	pt.setInterpolator(Interpolator.EASE_BOTH);		/* ������ ������ �������� �������� ����� ������ ������ Interpolator. ��������,
				 �������� ������� �������� � ����� ���������.
					 Discrete - �������� �������� ��������� �� ��������� ���������� ��������� � ����� ���������� �����������
					 Linear - ����������� ��� ��������
					 Ease_in - ���������� � ������ � ��������� � ����� ��������
					 Ease_out - ���������� �������� � ������ � ���������� � �����
					 Ease_both - ���������� � ������, ����� ����������� ��� � ���������� � ����� 	 */
		
	System.out.println("���p���� ������� �������� " + ft.getCurrentRate());
	System.out.println("���������������� ���������� ������ ����� " + ft.getCycleDuration());
	System.out.println("���������������� ���� �������� " + ft.getTotalDuration());
	System.out.println("������� ����� ���������� �������� �� ������� ������� " + ft.getCurrentTime());
	pt.play();
	
/* --------------------����� ScaleTransition ��������� ��������-----------------------------------------------------------------
    ������������ Object - Animation - Transition - ScaleTransition								*/
	Rectangle rect4 = new Rectangle(70,70);
	rect4.setFill(Color.GREEN);
	rect4.relocate(150, 50);
		// ����������� 
	ScaleTransition st= new ScaleTransition();									// ������ �����������
	ScaleTransition st1 = new ScaleTransition(Duration.seconds(1.0));			// ������������� �������� 
	ScaleTransition st2 = new ScaleTransition(Duration.seconds(1.0), rect4);	// ������������� ����, ��������
	st.setDelay(Duration.ONE);			 // ������ �������� ����� ������� �������� 
	st.setNode(rect4);              	 // ��������� ����
	st.setFromX(1);
	st.setFromY(1);
	st.setToX(2);
	st.setToY(2);
	pt.setAutoReverse(false);			 // ���� true, �� ������ �������� ����� ����������� � ��������������� �����������
	st.setRate(0.5);					 // ������ �������� � ����������� ��������. �� ��������� - 1. ������������� �������� ��������
										 // � ��������� ����������� �� ���������������. �������� = 2 �������� �������� � 2 ����.
											 // ���� �������� ����� �������� 0,0, �� �������� ����� �����������.
	st.setDuration(Duration.seconds(1));	// ������ �������� ������ ����� ������ ����� ��������
	st.setCycleCount(Animation.INDEFINITE);			// ����� ������
	st.setInterpolator(Interpolator.LINEAR);		/* ������ ������ �������� �������� ����� ������ ������ Interpolator. ��������,
				 �������� ������� �������� � ����� ���������.
					 Discrete - �������� �������� ��������� �� ��������� ���������� ��������� � ����� ���������� �����������
					 Linear - ����������� ��� ��������
					 Ease_in - ���������� � ������ � ��������� � ����� ��������
					 Ease_out - ���������� �������� � ������ � ���������� � �����
					 Ease_both - ���������� � ������, ����� ����������� ��� � ���������� � ����� 	 */
	System.out.println("���p���� ������� �������� " + ft.getCurrentRate());
	System.out.println("���������������� ���������� ������ ����� " + ft.getCycleDuration());
	System.out.println("���������������� ���� �������� " + ft.getTotalDuration());
	System.out.println("������� ����� ���������� �������� �� ������� ������� " + ft.getCurrentTime());
	st.play();
	
/* --------------------����� RotateTransition ��������-----------------------------------------------------------------
    ������������ Object - Animation - Transition - RotateTransition								*/
	Rectangle rect5 = new Rectangle(70,70);
	rect5.setFill(Color.YELLOW);
	rect5.relocate(150, 50);
		// ����������� 
	RotateTransition rt= new RotateTransition();									// ������ �����������
	RotateTransition rt1 = new RotateTransition(Duration.seconds(1.0));			// ������������� �������� 
	RotateTransition rt2 = new RotateTransition(Duration.seconds(1.0), rect5);	// ������������� ����, ��������
	rt.setDelay(Duration.ONE);			 // ������ �������� ����� ������� �������� 
	rt.setNode(rect5);              	 // ��������� ����
	rt.setAutoReverse(true);			 // ���� true, �� ������ �������� ����� ����������� � ��������������� �����������
	rt.setAxis(Rotate.Z_AXIS);
	rt.setFromAngle(0);
	rt.setToAngle(180);
	rt.setRate(0.5);					 // ������ �������� � ����������� ��������. �� ��������� - 1. ������������� �������� ��������
										 // � ��������� ����������� �� ���������������. �������� = 2 �������� �������� � 2 ����.
											 // ���� �������� ����� �������� 0,0, �� �������� ����� �����������.
	rt.setDuration(Duration.seconds(1));	// ������ �������� ������ ����� ������ ����� ��������
	rt.setCycleCount(Animation.INDEFINITE);			// ����� ������
	rt.setInterpolator(Interpolator.LINEAR);		/* ������ ������ �������� �������� ����� ������ ������ Interpolator. ��������,
				 �������� ������� �������� � ����� ���������.
					 Discrete - �������� �������� ��������� �� ��������� ���������� ��������� � ����� ���������� �����������
					 Linear - ����������� ��� ��������
					 Ease_in - ���������� � ������ � ��������� � ����� ��������
					 Ease_out - ���������� �������� � ������ � ���������� � �����
					 Ease_both - ���������� � ������, ����� ����������� ��� � ���������� � ����� 	 */
		
	System.out.println("���p���� ������� �������� " + rt.getCurrentRate());
	System.out.println("���������������� ���������� ������ ����� " + rt.getCycleDuration());
	System.out.println("���������������� ���� �������� " + rt.getTotalDuration());
	System.out.println("������� ����� ���������� �������� �� ������� ������� " + rt.getCurrentTime());
	rt.play();
	
/* --------------------����� FillTransition ��������� �������-----------------------------------------------------------------
    ������������ Object - Animation - Transition - FillTransition								*/
	Rectangle rect6 = new Rectangle(70,70);
	rect6.setFill(Color.YELLOW);
	rect6.relocate(150, 50);
		// ����������� 
	Shape shape1 = null;
	Shape shape2 = null;
	Color colorfrom = Color.BLUE;
	Color colorTo = Color.RED;
	FillTransition ftr= new FillTransition();												// ������ �����������
	FillTransition ftr1 = new FillTransition(Duration.seconds(1.0));						// ������������� �������� 
	FillTransition ftr2 = new FillTransition(Duration.seconds(1.0), shape1);				// ������������� ����, ��������
	FillTransition ftr3 = new FillTransition(Duration.seconds(1.0), colorfrom, colorTo);	// ������������� ��������, ����
	FillTransition ftr4 = new FillTransition(Duration.seconds(1.0), shape1, colorfrom, colorTo);	// ������������� ����, ��������, ����
	ftr.setDelay(Duration.ONE);			 // ������ �������� ����� ������� �������� 
	ftr.setShape(rect6);              	 // ��������� ����
	ftr.setAutoReverse(true);			 // ���� true, �� ������ �������� ����� ����������� � ��������������� �����������
	ftr.setFromValue(colorfrom);
	ftr.setToValue(colorTo);
	ftr.setRate(0.5);					 // ������ �������� � ����������� ��������. �� ��������� - 1. ������������� �������� ��������
										 // � ��������� ����������� �� ���������������. �������� = 2 �������� �������� � 2 ����.
											 // ���� �������� ����� �������� 0,0, �� �������� ����� �����������.
	ftr.setDuration(Duration.seconds(1));	// ������ �������� ������ ����� ������ ����� ��������
	ftr.setCycleCount(Animation.INDEFINITE);			// ����� ������
	ftr.setInterpolator(Interpolator.LINEAR);		/* ������ ������ �������� �������� ����� ������ ������ Interpolator. ��������,
				 �������� ������� �������� � ����� ���������.
					 Discrete - �������� �������� ��������� �� ��������� ���������� ��������� � ����� ���������� �����������
					 Linear - ����������� ��� ��������
					 Ease_in - ���������� � ������ � ��������� � ����� ��������
					 Ease_out - ���������� �������� � ������ � ���������� � �����
					 Ease_both - ���������� � ������, ����� ����������� ��� � ���������� � ����� 	 */
		
	System.out.println("���p���� ������� �������� " + ftr.getCurrentRate());
	System.out.println("���������������� ���������� ������ ����� " + ftr.getCycleDuration());
	System.out.println("���������������� ���� �������� " + ftr.getTotalDuration());
	System.out.println("������� ����� ���������� �������� �� ������� ������� " + ftr.getCurrentTime());
	ftr.play();

/* --------------------����� StrokeTransition ��������� ����� �������-----------------------------------------------------------------
    ������������ Object - Animation - Transition - StrokeTransition								*/
	Rectangle rect7 = new Rectangle(70,70);
	rect7.setFill(Color.BEIGE);
	rect7.setStroke(Color.BLUE);
	rect7.setStrokeWidth(5);
	rect7.relocate(150, 50);
		// ����������� 
	Shape shape3 = null;
	Shape shape4 = null;
	colorfrom = Color.BLUE;
	colorTo = Color.RED;
	StrokeTransition stt= new StrokeTransition();												// ������ �����������
	StrokeTransition stt1 = new StrokeTransition(Duration.seconds(1.0));						// ������������� �������� 
	StrokeTransition stt2 = new StrokeTransition(Duration.seconds(1.0), shape1);				// ������������� ����, ��������
	StrokeTransition stt3 = new StrokeTransition(Duration.seconds(1.0), colorfrom, colorTo);	// ������������� ��������, ����
	StrokeTransition stt4 = new StrokeTransition(Duration.seconds(1.0), shape1, colorfrom, colorTo);	// ������������� ����, ��������, ����
	stt.setDelay(Duration.ONE);			 // ������ �������� ����� ������� �������� 
	stt.setShape(rect7);              	 // ��������� ����
	stt.setAutoReverse(true);			 // ���� true, �� ������ �������� ����� ����������� � ��������������� �����������
	stt.setFromValue(colorfrom);
	stt.setToValue(colorTo);
	stt.setRate(0.5);					 // ������ �������� � ����������� ��������. �� ��������� - 1. ������������� �������� ��������
										 // � ��������� ����������� �� ���������������. �������� = 2 �������� �������� � 2 ����.
											 // ���� �������� ����� �������� 0,0, �� �������� ����� �����������.
	stt.setDuration(Duration.seconds(1));	// ������ �������� ������ ����� ������ ����� ��������
	stt.setCycleCount(Animation.INDEFINITE);			// ����� ������
	stt.setInterpolator(Interpolator.LINEAR);		/* ������ ������ �������� �������� ����� ������ ������ Interpolator. ��������,
				 �������� ������� �������� � ����� ���������.
					 Discrete - �������� �������� ��������� �� ��������� ���������� ��������� � ����� ���������� �����������
					 Linear - ����������� ��� ��������
					 Ease_in - ���������� � ������ � ��������� � ����� ��������
					 Ease_out - ���������� �������� � ������ � ���������� � �����
					 Ease_both - ���������� � ������, ����� ����������� ��� � ���������� � ����� 	 */
		
	System.out.println("���p���� ������� �������� " + stt.getCurrentRate());
	System.out.println("���������������� ���������� ������ ����� " + stt.getCycleDuration());
	System.out.println("���������������� ���� �������� " + stt.getTotalDuration());
	System.out.println("������� ����� ���������� �������� �� ������� ������� " + stt.getCurrentTime());
	stt.play();

/* --------------------����� ParallelTransition ������������ ���������� ���������� ��������-----------------------------------------------------------------
    ������������ Object - Animation - Transition - ParallelTransition								*/
	Rectangle rect8 = new Rectangle(70,70);
	rect8.setFill(Color.BEIGE);
	rect8.setStroke(Color.BLUE);
	rect8.setStrokeWidth(5);
	rect8.relocate(150, 50);
		// �����������
	ParallelTransition plt4 = new ParallelTransition();								// ������ �����������
	ParallelTransition plt1 = new ParallelTransition(ftr, stt);						// (Animation..children) 
	ParallelTransition plt2 = new ParallelTransition(rect7);						// ������������� ����
	ParallelTransition plt3 = new ParallelTransition(rect7, ftr, stt);				// ������������� ���� + (Animation..children)
		RotateTransition rt3= new RotateTransition();
	rt3.setDelay(Duration.ONE);		rt3.setNode(rect8);         rt3.setAutoReverse(true);			
	rt3.setAxis(Rotate.Z_AXIS);		rt3.setFromAngle(0);		rt3.setToAngle(180);
	rt3.setDuration(Duration.seconds(1));	rt3.setCycleCount(Animation.INDEFINITE);	rt3.setInterpolator(Interpolator.LINEAR);
		FillTransition ftr5 = new FillTransition(); 
	ftr5.setDelay(Duration.ONE);				ftr5.setShape(rect8);		ftr5.setAutoReverse(true);	
	ftr5.setFromValue(colorfrom);				ftr5.setToValue(colorTo);	ftr5.setDuration(Duration.seconds(1));
	ftr5.setCycleCount(Animation.INDEFINITE);	ftr5.setInterpolator(Interpolator.LINEAR);
		ParallelTransition plt= new ParallelTransition();								// ������ �����������
	plt.setDelay(Duration.ONE);			 // ������ �������� ����� ������� �������� 
	plt.setNode(rect8);              	 // ��������� ����
	plt.setAutoReverse(true);			 // ���� true, �� ������ �������� ����� ����������� � ��������������� �����������
	plt.getChildren().addAll(rt3, ftr5);		// ���������� ��������
	plt.play();

/* --------------------����� SequentialTransition ���������������� ���������� ���������� ��������-----------------------------------------------------------------
    ������������ Object - Animation - Transition - SequentialTransition								*/
	Rectangle rect9 = new Rectangle(70,70);
	rect9.setFill(Color.BEIGE);
	rect9.setStroke(Color.BLUE);
	rect9.setStrokeWidth(5);
	rect9.relocate(150, 50);
		// �����������
	SequentialTransition str = new SequentialTransition();								// ������ �����������
	SequentialTransition str1 = new SequentialTransition(ftr, stt);						// (Animation..children) 
	SequentialTransition str2 = new SequentialTransition(rect7);						// ������������� ����
	SequentialTransition str3 = new SequentialTransition(rect7, ftr, stt);				// ������������� ���� + (Animation..children)
		RotateTransition rt4= new RotateTransition();
	rt4.setDelay(Duration.ONE);		rt4.setNode(rect9);         rt4.setAutoReverse(true);			
	rt4.setAxis(Rotate.Z_AXIS);		rt4.setFromAngle(0);		rt4.setToAngle(180);
	rt4.setDuration(Duration.seconds(1));	rt4.setCycleCount(5);	rt4.setInterpolator(Interpolator.LINEAR);
		FillTransition ftr6 = new FillTransition(); 
	ftr6.setDelay(Duration.ONE);				ftr6.setShape(rect9);		ftr6.setAutoReverse(true);	
	ftr6.setFromValue(colorfrom);				ftr6.setToValue(colorTo);	ftr6.setDuration(Duration.seconds(1));
	ftr6.setCycleCount(Animation.INDEFINITE);	ftr6.setInterpolator(Interpolator.LINEAR);
		SequentialTransition str4= new SequentialTransition();
	str4.setDelay(Duration.ONE);			 // ������ �������� ����� ������� �������� 
	str4.setNode(rect9);              	 // ��������� ����
	str4.setAutoReverse(true);			 // ���� true, �� ������ �������� ����� ����������� � ��������������� �����������
	str4.getChildren().addAll(rt4, ftr6);		// ���������� ��������
	str4.play();
	
/* --------------------����� PauseTransition ����� �� ����� ���������� ��������-----------------------------------------------------------------
    ������������ Object - Animation - Transition - PauseTransition								*/
	Rectangle rect10 = new Rectangle(70,70);
	rect10.setFill(Color.BEIGE);
	rect10.setStroke(Color.BLUE);
	rect10.setStrokeWidth(5);
	rect10.relocate(150, 50);
		// �����������
	PauseTransition pau1 = new PauseTransition();								
	PauseTransition pau2 = new PauseTransition(Duration.ONE);
		TranslateTransition tt5 = new TranslateTransition(Duration.seconds(5), rect10);
	tt5.setFromX(0);
	tt5.setToX(100);
		TranslateTransition tt6 = new TranslateTransition(Duration.seconds(5), rect10);
	tt6.setFromX(100);
	tt6.setToX(0);
		PauseTransition pau = new PauseTransition();
	pau.setDuration(Duration.seconds(3));
		SequentialTransition str5= new SequentialTransition();
	str5.setDelay(Duration.ONE);			 
	str5.setNode(rect10);              	 
	str5.setAutoReverse(false);			 
	str5.getChildren().addAll(tt5, pau, tt6);	
	str5.play();
	
/* --------------------����� AnimationTimer  ������ ��� ������� �����-----------------------------------------------------------------
    ������������ Object - Animation - AnimationTimer							
    ������ ����� ����������� ��� ������� �����. ����.������� ������������ - 60 ������/���
    ����� ������ ����� �������������� ��� �������� �������� � ��� � ��������� � Canvas.
    ����� ����������� ����� AnimationTimer � ����������� ����������� ����� handle, ������� ����� ���������� ��� ������� �����   	*/
	Rectangle rect11 = new Rectangle(70,70);
	rect11.setFill(Color.BLUEVIOLET);
	rect11.relocate(150, 50);
	AnimationTimer timer = new AnimationTimer() {
		@Override
		public void handle(long now) {
			if (rect11.getTranslateX() > 100) rect11.setTranslateX(0);
			else rect11.setTranslateX(rect11.getTranslateX() + 1);
		}
	};;
	timer.start();

//--------------------------------------------------------------------------------------------------------------------------------//
	VBox vbox = new VBox();
	vbox.setMinWidth(100);
	vbox.setPadding(new Insets(10));
	vbox.setSpacing(20);
	vbox.getChildren().addAll(rect5, rect6, rect7, rect8);
	
	VBox vbox1 = new VBox();
	vbox1.setMinWidth(100);
	vbox1.setPadding(new Insets(10));
	vbox1.setSpacing(20);
	vbox1.getChildren().addAll(rect4, rect9);
	
	HBox hbox = new HBox();
	hbox.setMinWidth(100);
	hbox.setPadding(new Insets(10));
	hbox.setSpacing(20);
	hbox.getChildren().addAll(rect, rect10);
	
	HBox hbox1 = new HBox();
	hbox1.setMinWidth(100);
	hbox1.setPadding(new Insets(10));
	hbox1.setSpacing(20);
	hbox1.getChildren().addAll(rect11);
	
	VBox vbox2 = new VBox();
	vbox2.setMinWidth(100);
	vbox2.setPadding(new Insets(10));
	vbox2.setSpacing(20);
	vbox2.getChildren().addAll(hbox, hbox1);
	
	BorderPane pane = new BorderPane(vbox2, rect2, vbox1, rect3, vbox);
	Scene scene = new Scene(pane, 600, 600);
	primaryStage.setScene(scene); 
	primaryStage.setTitle("Add/Sub");
	primaryStage.show();
}
	public static void main(String[] args) {
		launch(args);
	}
}
