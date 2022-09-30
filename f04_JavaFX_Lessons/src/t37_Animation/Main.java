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
		
/* 			Класс DURATION
 		Конструктор Duration(double millis) 		*/
	Duration d1 = new Duration(500.0);			// Задает продолжительность в миллисекундах
	Duration d2 = Duration.millis(500.0);		// Задает продолжительность в миллисекундах
	Duration d3 = Duration.seconds(5.0);		// Задает продолжительность в секундах
	Duration d4 = Duration.minutes(0.5);		// Задает продолжительность в минутах
	Duration d5 = Duration.hours(0.5);			// Задает продолжительность в hours
	Duration d6 = Duration.valueOf("500ms");	// Задает продолжительность в миллисекундах
	Duration d7 = Duration.ONE;					// Задает продолжительность в 1 секундy
		// Возвращает длительность
	System.out.println(d7.toMillis());
	System.out.println(d7.toSeconds());
	System.out.println(d7.toMinutes());
	System.out.println(d7.toHours());
		// Изменяет продолжительность
	System.out.println(d7.add(d1));
	System.out.println(d7.subtract(d1));
	System.out.println(d7.multiply(2));
	System.out.println(d7.divide(2));
		// Сравнение длительности
	System.out.println(d7.lessThan(d6));
	System.out.println(d7.lessThanOrEqualTo(d6));
	System.out.println(d7.greaterThanOrEqualTo(d6));
	System.out.println(d7.equals(d6));
	
/*---------------------------Класс FadeTransition   Изменение прозрачности затухания, мигания, исчезновения) -------------------
 Наследлвание Object - Animation - Transition - FadeTransition */
	Rectangle rect = new Rectangle(100,100);
	rect.setFill(Color.BLUE);
	rect.relocate(350,350);
		// Конструктор 
	FadeTransition ft = new FadeTransition();								// Пустой конструктор
	FadeTransition ft1 = new FadeTransition(Duration.seconds(10.0));		// Устанавливает задержку в 1 сек перед началом анимации
	FadeTransition ft2 = new FadeTransition(Duration.seconds(10.0), rect);	// Устанавливает узел и задержку в 1 сек перед началом анимации
	ft.setDelay(Duration.ONE);		// Задает задержку перед началом анимации 
	ft.setNode(rect);               // Установка узла
	ft.setAutoReverse(false);		// Если true, то повтор анимации будет выполняться в противоположном направлении
	ft.setFromValue(1);				// Исходная непрозрачность - 1
	ft.setToValue(0);				// Финальная непрозрачность -0 
	ft.setCycleCount(7);					// Задает количество повторений анимаций. По умолчанию - 1 секунду
	ft.setRate(0.5);				// Задает скорость и направление анимации. По умолчанию - 1. Отрицательное значение приведет
									// к изменению направления на противоположное. Значение = 2 увеличит скорость в 2 раза.
									// Если свойство имеет значение 0,0, то анимация будет остановлена.
	ft.setDuration(Duration.seconds(1));	// Вместо скорости задает время одного цикла анимации
	System.out.println("Скоpость текущая анимации " + ft.getCurrentRate());
	System.out.println("Продолжителность выполнения одного цикла " + ft.getCycleDuration());
	System.out.println("Продолжителность всей анимации " + ft.getTotalDuration());
	System.out.println("Текущее время выполнения анимации на линейке времени " + ft.getCurrentTime());
		// Создание метки на шкале времени для перехода в нее 
	ft.getCuePoints().put("p1", Duration.seconds(1));
	ft.jumpTo(Duration.ONE);		// Переход осуществляется сразу при запуске анимации при вызове play(). 
	ft.jumpTo("p1");
	
	System.out.println("Статус анимации " + ft.getStatus());
	ft.setOnFinished(event -> {							// Обработчик после завершения анимации
		System.out.println("Анимация завершена");
	});
	ft.play();				// Запускает анимацию с текущей позиции
	ft.playFrom("p1");	    // Запускает анимацию с указанной метки или времени
	ft.playFromStart();		// Запускает анимацию с начала
	
	// Устанавливает паузу на анимацию при кликании мышью на прямоугольник 
	rect.addEventHandler(MouseEvent.MOUSE_CLICKED,  event -> {
		if (ft.getStatus() == Animation.Status.RUNNING) ft.pause();
		else ft.play();
	});
//	ft.pause();				
//	ft.stop();              // Останавливает анимацию. Важно останавливать анимацию особенно бесконечную явным образом, при закрытии
							// окна, иначе она так и останестся работать поака не будут закрыты все окна приложения.
		
 /* --------------------КЛАСС TranslateTransition АНИМАЦИЯ ПЕРЕДВИЖЕНИЯ-----------------------------------------------------
      Наследование Object - Animation - Transition - TranslateTransition								*/
	Rectangle rect2 = new Rectangle(70,70);
	rect2.setFill(Color.DARKRED);
	rect2.relocate(50, 50);
		// Конструктор анимации передвижения прямоугольника по линии
	TranslateTransition tt= new TranslateTransition();							// Пустой конструктор
	TranslateTransition tt1 = new TranslateTransition(Duration.seconds(10.0));		// Устанавливает задержку в 1 сек перед началом анимации
	TranslateTransition tt2 = new TranslateTransition(Duration.seconds(10.0), rect);	// Устанавливает узел и задержку в 1 сек перед началом анимации
	tt.setDelay(Duration.ONE);			 // Задает задержку перед началом анимации 
	tt.setNode(rect2);              	 // Установка узла
	tt.setAutoReverse(false);			 // Если true, то повтор анимации будет выполняться в противоположном направлении
	tt.setFromX(0);						 // Исходная точка для начала движения
	tt.setToX(450);					 
	tt.setRate(0.5);					 // Задает скорость и направление анимации. По умолчанию - 1. Отрицательное значение приведет
										 // к изменению направления на противоположное. Значение = 2 увеличит скорость в 2 раза.
										 // Если свойство имеет значение 0,0, то анимация будет остановлена.
	tt.setDuration(Duration.seconds(1));	// Вместо скорости задает время одного цикла анимации
	tt.setCycleCount(Animation.INDEFINITE);			// Число циклов
	tt.setInterpolator(Interpolator.EASE_BOTH);		/* Задает способ прироста значения через объект класса Interpolator. Например,
				 движение сначала медленно и потом ускорение.
				 Discrete - значение остается начальным до окончания временного интервала и затем становится бесконечным
				 Linear - равномерный ход анимации
				 Ease_in - замедление в начале и ускорение к концу анимации
				 Ease_out - ускоренное движение в начале и замедление в конце
				 Ease_both - земедление в начале, затем равномерный ход и замедление в конце 	 */
	
	System.out.println("Скоpость текущая анимации " + ft.getCurrentRate());
	System.out.println("Продолжителность выполнения одного цикла " + ft.getCycleDuration());
	System.out.println("Продолжителность всей анимации " + ft.getTotalDuration());
	System.out.println("Текущее время выполнения анимации на линейке времени " + ft.getCurrentTime());
	tt.play();
	
/* --------------------КЛАСС PathTransition АНИМАЦИЯ ДВИЖЕНИЯ ВДОЛЬ ЗАДАННОЙ ЛИНИИ------------------------------------------------
    Наследование Object - Animation - Transition - PathTransition								*/
	Rectangle rect3 = new Rectangle(70,70);
	rect3.setFill(Color.GREEN);
	rect3.relocate(150, 50);
		// Конструктор 
	Shape path = null;
	Shape path1 = null;
	PathTransition pt= new PathTransition();										// Пустой конструктор
	PathTransition pt1 = new PathTransition(Duration.seconds(1.0), path);			// Устанавливает задержку и траекторию
	PathTransition pt2 = new PathTransition(Duration.seconds(1.0), path1, rect);	// Устанавливает узел, задержку и траекторию
	Path path3 = new Path (
							new MoveTo(0,0), 
							new QuadCurveTo(200, 200, 400, 0));
		/* Метод path() задает траекторию по которой движется узел.  В качестве параметра класс Shape
		   Метод setOrientation() задает ориентацию узла относительно траектории:
		    - NONE - ориентация не изменяется
		    -  ORTHOGONAL_TO_TANGENT - ориентация будет соответствовать траекТОРИИ*/
	pt.setDelay(Duration.ONE);			 // Задает задержку перед началом анимации 
	pt.setNode(rect3);              	 // Установка узла
	pt.setPath(path3);
	pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);		//
	pt.setAutoReverse(false);			 // Если true, то повтор анимации будет выполняться в противоположном направлении
	pt.setRate(0.5);					 // Задает скорость и направление анимации. По умолчанию - 1. Отрицательное значение приведет
										 // к изменению направления на противоположное. Значение = 2 увеличит скорость в 2 раза.
											 // Если свойство имеет значение 0,0, то анимация будет остановлена.
	pt.setDuration(Duration.seconds(5));	// Вместо скорости задает время одного цикла анимации
	pt.setCycleCount(Animation.INDEFINITE);			// Число циклов
	pt.setInterpolator(Interpolator.EASE_BOTH);		/* Задает способ прироста значения через объект класса Interpolator. Например,
				 движение сначала медленно и потом ускорение.
					 Discrete - значение остается начальным до окончания временного интервала и затем становится бесконечным
					 Linear - равномерный ход анимации
					 Ease_in - замедление в начале и ускорение к концу анимации
					 Ease_out - ускоренное движение в начале и замедление в конце
					 Ease_both - земедление в начале, затем равномерный ход и замедление в конце 	 */
		
	System.out.println("Скоpость текущая анимации " + ft.getCurrentRate());
	System.out.println("Продолжителность выполнения одного цикла " + ft.getCycleDuration());
	System.out.println("Продолжителность всей анимации " + ft.getTotalDuration());
	System.out.println("Текущее время выполнения анимации на линейке времени " + ft.getCurrentTime());
	pt.play();
	
/* --------------------КЛАСС ScaleTransition ИЗМЕНЕНИЕ МАСШТАБА-----------------------------------------------------------------
    Наследование Object - Animation - Transition - ScaleTransition								*/
	Rectangle rect4 = new Rectangle(70,70);
	rect4.setFill(Color.GREEN);
	rect4.relocate(150, 50);
		// Конструктор 
	ScaleTransition st= new ScaleTransition();									// Пустой конструктор
	ScaleTransition st1 = new ScaleTransition(Duration.seconds(1.0));			// Устанавливает задержку 
	ScaleTransition st2 = new ScaleTransition(Duration.seconds(1.0), rect4);	// Устанавливает узел, задержку
	st.setDelay(Duration.ONE);			 // Задает задержку перед началом анимации 
	st.setNode(rect4);              	 // Установка узла
	st.setFromX(1);
	st.setFromY(1);
	st.setToX(2);
	st.setToY(2);
	pt.setAutoReverse(false);			 // Если true, то повтор анимации будет выполняться в противоположном направлении
	st.setRate(0.5);					 // Задает скорость и направление анимации. По умолчанию - 1. Отрицательное значение приведет
										 // к изменению направления на противоположное. Значение = 2 увеличит скорость в 2 раза.
											 // Если свойство имеет значение 0,0, то анимация будет остановлена.
	st.setDuration(Duration.seconds(1));	// Вместо скорости задает время одного цикла анимации
	st.setCycleCount(Animation.INDEFINITE);			// Число циклов
	st.setInterpolator(Interpolator.LINEAR);		/* Задает способ прироста значения через объект класса Interpolator. Например,
				 движение сначала медленно и потом ускорение.
					 Discrete - значение остается начальным до окончания временного интервала и затем становится бесконечным
					 Linear - равномерный ход анимации
					 Ease_in - замедление в начале и ускорение к концу анимации
					 Ease_out - ускоренное движение в начале и замедление в конце
					 Ease_both - земедление в начале, затем равномерный ход и замедление в конце 	 */
	System.out.println("Скоpость текущая анимации " + ft.getCurrentRate());
	System.out.println("Продолжителность выполнения одного цикла " + ft.getCycleDuration());
	System.out.println("Продолжителность всей анимации " + ft.getTotalDuration());
	System.out.println("Текущее время выполнения анимации на линейке времени " + ft.getCurrentTime());
	st.play();
	
/* --------------------КЛАСС RotateTransition ВРАЩЕНИЕ-----------------------------------------------------------------
    Наследование Object - Animation - Transition - RotateTransition								*/
	Rectangle rect5 = new Rectangle(70,70);
	rect5.setFill(Color.YELLOW);
	rect5.relocate(150, 50);
		// Конструктор 
	RotateTransition rt= new RotateTransition();									// Пустой конструктор
	RotateTransition rt1 = new RotateTransition(Duration.seconds(1.0));			// Устанавливает задержку 
	RotateTransition rt2 = new RotateTransition(Duration.seconds(1.0), rect5);	// Устанавливает узел, задержку
	rt.setDelay(Duration.ONE);			 // Задает задержку перед началом анимации 
	rt.setNode(rect5);              	 // Установка узла
	rt.setAutoReverse(true);			 // Если true, то повтор анимации будет выполняться в противоположном направлении
	rt.setAxis(Rotate.Z_AXIS);
	rt.setFromAngle(0);
	rt.setToAngle(180);
	rt.setRate(0.5);					 // Задает скорость и направление анимации. По умолчанию - 1. Отрицательное значение приведет
										 // к изменению направления на противоположное. Значение = 2 увеличит скорость в 2 раза.
											 // Если свойство имеет значение 0,0, то анимация будет остановлена.
	rt.setDuration(Duration.seconds(1));	// Вместо скорости задает время одного цикла анимации
	rt.setCycleCount(Animation.INDEFINITE);			// Число циклов
	rt.setInterpolator(Interpolator.LINEAR);		/* Задает способ прироста значения через объект класса Interpolator. Например,
				 движение сначала медленно и потом ускорение.
					 Discrete - значение остается начальным до окончания временного интервала и затем становится бесконечным
					 Linear - равномерный ход анимации
					 Ease_in - замедление в начале и ускорение к концу анимации
					 Ease_out - ускоренное движение в начале и замедление в конце
					 Ease_both - земедление в начале, затем равномерный ход и замедление в конце 	 */
		
	System.out.println("Скоpость текущая анимации " + rt.getCurrentRate());
	System.out.println("Продолжителность выполнения одного цикла " + rt.getCycleDuration());
	System.out.println("Продолжителность всей анимации " + rt.getTotalDuration());
	System.out.println("Текущее время выполнения анимации на линейке времени " + rt.getCurrentTime());
	rt.play();
	
/* --------------------КЛАСС FillTransition ИЗМЕНЕНИЕ ЗАЛИВКИ-----------------------------------------------------------------
    Наследование Object - Animation - Transition - FillTransition								*/
	Rectangle rect6 = new Rectangle(70,70);
	rect6.setFill(Color.YELLOW);
	rect6.relocate(150, 50);
		// Конструктор 
	Shape shape1 = null;
	Shape shape2 = null;
	Color colorfrom = Color.BLUE;
	Color colorTo = Color.RED;
	FillTransition ftr= new FillTransition();												// Пустой конструктор
	FillTransition ftr1 = new FillTransition(Duration.seconds(1.0));						// Устанавливает задержку 
	FillTransition ftr2 = new FillTransition(Duration.seconds(1.0), shape1);				// Устанавливает узел, задержку
	FillTransition ftr3 = new FillTransition(Duration.seconds(1.0), colorfrom, colorTo);	// Устанавливает задержку, цвет
	FillTransition ftr4 = new FillTransition(Duration.seconds(1.0), shape1, colorfrom, colorTo);	// Устанавливает узел, задержку, цвет
	ftr.setDelay(Duration.ONE);			 // Задает задержку перед началом анимации 
	ftr.setShape(rect6);              	 // Установка узла
	ftr.setAutoReverse(true);			 // Если true, то повтор анимации будет выполняться в противоположном направлении
	ftr.setFromValue(colorfrom);
	ftr.setToValue(colorTo);
	ftr.setRate(0.5);					 // Задает скорость и направление анимации. По умолчанию - 1. Отрицательное значение приведет
										 // к изменению направления на противоположное. Значение = 2 увеличит скорость в 2 раза.
											 // Если свойство имеет значение 0,0, то анимация будет остановлена.
	ftr.setDuration(Duration.seconds(1));	// Вместо скорости задает время одного цикла анимации
	ftr.setCycleCount(Animation.INDEFINITE);			// Число циклов
	ftr.setInterpolator(Interpolator.LINEAR);		/* Задает способ прироста значения через объект класса Interpolator. Например,
				 движение сначала медленно и потом ускорение.
					 Discrete - значение остается начальным до окончания временного интервала и затем становится бесконечным
					 Linear - равномерный ход анимации
					 Ease_in - замедление в начале и ускорение к концу анимации
					 Ease_out - ускоренное движение в начале и замедление в конце
					 Ease_both - земедление в начале, затем равномерный ход и замедление в конце 	 */
		
	System.out.println("Скоpость текущая анимации " + ftr.getCurrentRate());
	System.out.println("Продолжителность выполнения одного цикла " + ftr.getCycleDuration());
	System.out.println("Продолжителность всей анимации " + ftr.getTotalDuration());
	System.out.println("Текущее время выполнения анимации на линейке времени " + ftr.getCurrentTime());
	ftr.play();

/* --------------------КЛАСС StrokeTransition ИЗМЕНЕНИЕ ЦВЕТА ОБВОДКИ-----------------------------------------------------------------
    Наследование Object - Animation - Transition - StrokeTransition								*/
	Rectangle rect7 = new Rectangle(70,70);
	rect7.setFill(Color.BEIGE);
	rect7.setStroke(Color.BLUE);
	rect7.setStrokeWidth(5);
	rect7.relocate(150, 50);
		// Конструктор 
	Shape shape3 = null;
	Shape shape4 = null;
	colorfrom = Color.BLUE;
	colorTo = Color.RED;
	StrokeTransition stt= new StrokeTransition();												// Пустой конструктор
	StrokeTransition stt1 = new StrokeTransition(Duration.seconds(1.0));						// Устанавливает задержку 
	StrokeTransition stt2 = new StrokeTransition(Duration.seconds(1.0), shape1);				// Устанавливает узел, задержку
	StrokeTransition stt3 = new StrokeTransition(Duration.seconds(1.0), colorfrom, colorTo);	// Устанавливает задержку, цвет
	StrokeTransition stt4 = new StrokeTransition(Duration.seconds(1.0), shape1, colorfrom, colorTo);	// Устанавливает узел, задержку, цвет
	stt.setDelay(Duration.ONE);			 // Задает задержку перед началом анимации 
	stt.setShape(rect7);              	 // Установка узла
	stt.setAutoReverse(true);			 // Если true, то повтор анимации будет выполняться в противоположном направлении
	stt.setFromValue(colorfrom);
	stt.setToValue(colorTo);
	stt.setRate(0.5);					 // Задает скорость и направление анимации. По умолчанию - 1. Отрицательное значение приведет
										 // к изменению направления на противоположное. Значение = 2 увеличит скорость в 2 раза.
											 // Если свойство имеет значение 0,0, то анимация будет остановлена.
	stt.setDuration(Duration.seconds(1));	// Вместо скорости задает время одного цикла анимации
	stt.setCycleCount(Animation.INDEFINITE);			// Число циклов
	stt.setInterpolator(Interpolator.LINEAR);		/* Задает способ прироста значения через объект класса Interpolator. Например,
				 движение сначала медленно и потом ускорение.
					 Discrete - значение остается начальным до окончания временного интервала и затем становится бесконечным
					 Linear - равномерный ход анимации
					 Ease_in - замедление в начале и ускорение к концу анимации
					 Ease_out - ускоренное движение в начале и замедление в конце
					 Ease_both - земедление в начале, затем равномерный ход и замедление в конце 	 */
		
	System.out.println("Скоpость текущая анимации " + stt.getCurrentRate());
	System.out.println("Продолжителность выполнения одного цикла " + stt.getCycleDuration());
	System.out.println("Продолжителность всей анимации " + stt.getTotalDuration());
	System.out.println("Текущее время выполнения анимации на линейке времени " + stt.getCurrentTime());
	stt.play();

/* --------------------КЛАСС ParallelTransition ПАРАЛЛЕЛЬНОЕ ВЫПОЛНЕНИЕ НЕСКОЛЬКИХ АНИМАЦИЙ-----------------------------------------------------------------
    Наследование Object - Animation - Transition - ParallelTransition								*/
	Rectangle rect8 = new Rectangle(70,70);
	rect8.setFill(Color.BEIGE);
	rect8.setStroke(Color.BLUE);
	rect8.setStrokeWidth(5);
	rect8.relocate(150, 50);
		// Конструктор
	ParallelTransition plt4 = new ParallelTransition();								// Пустой конструктор
	ParallelTransition plt1 = new ParallelTransition(ftr, stt);						// (Animation..children) 
	ParallelTransition plt2 = new ParallelTransition(rect7);						// Устанавливает узел
	ParallelTransition plt3 = new ParallelTransition(rect7, ftr, stt);				// Устанавливает узел + (Animation..children)
		RotateTransition rt3= new RotateTransition();
	rt3.setDelay(Duration.ONE);		rt3.setNode(rect8);         rt3.setAutoReverse(true);			
	rt3.setAxis(Rotate.Z_AXIS);		rt3.setFromAngle(0);		rt3.setToAngle(180);
	rt3.setDuration(Duration.seconds(1));	rt3.setCycleCount(Animation.INDEFINITE);	rt3.setInterpolator(Interpolator.LINEAR);
		FillTransition ftr5 = new FillTransition(); 
	ftr5.setDelay(Duration.ONE);				ftr5.setShape(rect8);		ftr5.setAutoReverse(true);	
	ftr5.setFromValue(colorfrom);				ftr5.setToValue(colorTo);	ftr5.setDuration(Duration.seconds(1));
	ftr5.setCycleCount(Animation.INDEFINITE);	ftr5.setInterpolator(Interpolator.LINEAR);
		ParallelTransition plt= new ParallelTransition();								// Пустой конструктор
	plt.setDelay(Duration.ONE);			 // Задает задержку перед началом анимации 
	plt.setNode(rect8);              	 // Установка узла
	plt.setAutoReverse(true);			 // Если true, то повтор анимации будет выполняться в противоположном направлении
	plt.getChildren().addAll(rt3, ftr5);		// Добавление анимаций
	plt.play();

/* --------------------КЛАСС SequentialTransition ПОСЛЕДОВАТЕЛЬНОЕ ВЫПОЛНЕНИЕ НЕСКОЛЬКИХ АНИМАЦИЙ-----------------------------------------------------------------
    Наследование Object - Animation - Transition - SequentialTransition								*/
	Rectangle rect9 = new Rectangle(70,70);
	rect9.setFill(Color.BEIGE);
	rect9.setStroke(Color.BLUE);
	rect9.setStrokeWidth(5);
	rect9.relocate(150, 50);
		// Конструктор
	SequentialTransition str = new SequentialTransition();								// Пустой конструктор
	SequentialTransition str1 = new SequentialTransition(ftr, stt);						// (Animation..children) 
	SequentialTransition str2 = new SequentialTransition(rect7);						// Устанавливает узел
	SequentialTransition str3 = new SequentialTransition(rect7, ftr, stt);				// Устанавливает узел + (Animation..children)
		RotateTransition rt4= new RotateTransition();
	rt4.setDelay(Duration.ONE);		rt4.setNode(rect9);         rt4.setAutoReverse(true);			
	rt4.setAxis(Rotate.Z_AXIS);		rt4.setFromAngle(0);		rt4.setToAngle(180);
	rt4.setDuration(Duration.seconds(1));	rt4.setCycleCount(5);	rt4.setInterpolator(Interpolator.LINEAR);
		FillTransition ftr6 = new FillTransition(); 
	ftr6.setDelay(Duration.ONE);				ftr6.setShape(rect9);		ftr6.setAutoReverse(true);	
	ftr6.setFromValue(colorfrom);				ftr6.setToValue(colorTo);	ftr6.setDuration(Duration.seconds(1));
	ftr6.setCycleCount(Animation.INDEFINITE);	ftr6.setInterpolator(Interpolator.LINEAR);
		SequentialTransition str4= new SequentialTransition();
	str4.setDelay(Duration.ONE);			 // Задает задержку перед началом анимации 
	str4.setNode(rect9);              	 // Установка узла
	str4.setAutoReverse(true);			 // Если true, то повтор анимации будет выполняться в противоположном направлении
	str4.getChildren().addAll(rt4, ftr6);		// Добавление анимаций
	str4.play();
	
/* --------------------КЛАСС PauseTransition ПАУЗА ВО ВРЕМЯ ВЫПОЛНЕНИЯ АНИМАЦИЙ-----------------------------------------------------------------
    Наследование Object - Animation - Transition - PauseTransition								*/
	Rectangle rect10 = new Rectangle(70,70);
	rect10.setFill(Color.BEIGE);
	rect10.setStroke(Color.BLUE);
	rect10.setStrokeWidth(5);
	rect10.relocate(150, 50);
		// Конструктор
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
	
/* --------------------КЛАСС AnimationTimer  ТАЙМЕР ДЛЯ КАЖДОГО КАДРА-----------------------------------------------------------------
    Наследование Object - Animation - AnimationTimer							
    Таймер будет срабатывать для каждого кадра. Макс.частота срабатывания - 60 кадров/сек
    Такой таймер может использоваться для создания анимации и игр в сочетании с Canvas.
    Нужно наследовать класс AnimationTimer и реализовать абстрактный метод handle, который будет вызываться для каждого кадра   	*/
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
