package t39_Color_Background;
	
import java.awt.MultipleGradientPaint.CycleMethod;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Main extends Application  {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl, lbl2;
	int i = 0;
	
		@Override 
	public void start(Stage primaryStage) {	
		lbl = new Label();				lbl.setText("TEXT LABEL 1"); 
		lbl2 = new Label();				lbl2.setText("TEXT LABEL 2");
		TextField txf = new TextField("TextField");		
		
		/* АБСТРАКТНЫЙ КЛАСС PAINT ЯВЛЯЕТСЯ БАЗОВЫМ ДЛЯ COLOR, LINEARGRADIENT, RADIALGRADIENT, IMAGEPATTERN
          - COLOR 			- сплошной цвет		
          - ImagePattern 	- фоновое изображение
          - LinearGradient 	- линейный градиент
          - RadialGradient 	- радиальный градиент
        ВАЖНО - чтобы было видно фон сцены, необходимо сделать контейнер верхнего уровня прозрачным         */
		
			// СОЗДАНИЕ ЭКЗЕМПЛЯРА НА ОСНОВЕ МЕТОДА VALUEOF()
		Paint p = Paint.valueOf("#ff0000");
//        scene.setFill(p);
		
/*---------------------------------------- COLOR------------------------------------------------------------------------*/
			//Конструктор Color (double red, double green, double blue, double opacity)
//		Color color1 = new Color(10.0, 10.0, 10.0, 0.9);
			//Конструктор на основе констант
		Color color2 = Color.AQUAMARINE;
			// Задание цвета через метод rgb
		Color color3 = null;
		color3.rgb(200, 200, 200, 0.9);		// rgb(double red, double green, double blue, double opacity)
			// Задание цвета через метод hsb
//		Color color4 = null;
		color3.hsb(0.2, 0.2, 0.2, 0.9);		// hsb(double hue, double saturation, double brightness, double opacity)
			// Задание цвета через метод valueOf()
		Color color5 = null;
		color5.valueOf("silver");	
		color5.valueOf("#ff0000");
			// Задание цвета через метод web()
		color5.web("silver");	
		color5.web("#ff0000");
			//  Изменение цвет
		color2.brighter();		// Делает цвет ярче
		color2.darker();
		color2.saturate();
		color2.desaturate();
		color2.invert();
		color2.grayscale();
		
/*---------------------------------------- BACKGROUND------------------------------------------------------------------------*/
		Text text5 = new Text("КЛАСС TEXTFLOW------КЛАСС TEXTFLOW");
		text5.setFill(Color.BLACK);
		text5.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 24));
		TextFlow textFlowPane1 = new TextFlow();
		textFlowPane1.setPrefWidth(400);
		textFlowPane1.setPadding(new Insets(10));
		textFlowPane1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		/* Конструкторы класса Background:
		- Background(BackgroundFill...fills)		 - задает цвет заливки (или градиент). Можно указать несколько цветов через запятую, при 
		 			этом пооследующие цвета будет накладываться на предыдущие.		 			
		- Background(BackgroundImage...images)
		- Background(BackgroundFill[] fills, BackgroundImage...images)
		- Background(List <BackgroundFill> fills, List<BackgroundImage> images)  
			vbox3.setBackground(new Background(
				new BackgroundFill(Color.RED, null, null), 
				new BackgroundFill(Color.YELLOW, null, new Insets(20)),								// Insets(20) -поля 				
				new BackgroundFill(Color.ANTIQUEWHITE, new CornerRadii(10), new Insets(40))			// CornerRadii(10) - скругление углов
			)); */

/*---------------------------------------- LinearGradient------------------------------------------------------------------------*/
			/* Конструкторы
		LinearGradient (startX, startY, endX, endY, boolean proportional, CycleMethod cycleMethod, List<stop> stops)
		LinearGradient (startX, startY, endX, endY, boolean proportional, CycleMethod cycleMethod, Stop...stops)
		 где startX, st3artY - начальные координаты, endX, endY - конечные координаты градиента
		     если proportional = true, то коордианаты задаются от 0 до 1, где 0 -начало области, 1- конец области			 */
   List<Stop> stops = new ArrayList<Stop>();
   stops.add( new Stop(0, Color.BLACK));		stops.add( new Stop(0, Color.WHITE));
//   LinearGradient lg = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
//   LinearGradient lg = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.BLACK), new Stop(0, Color.WHITE));
		
		
        	// Установка фонового рисунка  СМОТРИ В SCENE

   
	   	HBox pane = new HBox(10);
		pane.getChildren().addAll(lbl, lbl2, txf);
		pane.setBackground(Background.EMPTY);
		VBox root = new VBox();
		root.getChildren().addAll(pane, textFlowPane1);
		
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
