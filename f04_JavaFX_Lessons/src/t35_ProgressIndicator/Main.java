package t35_ProgressIndicator;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.converter.NumberStringConverter;

public class Main extends Application {
	Stage stage;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
		
/*------------------------------------- КЛАСС PROGRESS INDICATOR--------------------------------------------------------------------
		 Класс ProgressIndicator реализует индикатор хода процесса в форме круга, внутри которого текущий статус в виде сегментов
		 Object - Node - Parent- Region - Control - ProgressIndicator		*/
		
			// Конструкторы
		ProgressIndicator prIndic1 = new ProgressIndicator();	/* создает индикатор с неопределенным значением. Внутри индикатора
			будут постоянно по кругу перемещаться сегменты, показывая ход выполнения процесса  с неопредел. кол-вом шагов.	
			Используют, если невозможно разделить задачу на части и неизвестны сроки выполнения */

		ProgressIndicator prIndic2 = new ProgressIndicator(0.5);  // указывает статус в виде вещественного числа 
		
			// До запуска индикатор выполнения не отображается при false
		prIndic2.setVisible(true);	
		
			// Установка определенного статуса  индикатора
		prIndic2.setProgress(0.6);
			
			// Установка определенного статуса  индикатора
		prIndic1.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
		
			// Указание размеров
		prIndic1.setMinHeight(60);   prIndic1.setMinWidth(100);
		prIndic2.setMinHeight(60);   prIndic2.setMinWidth(100);
		
			// Растояние от внутренних границ области до текста и/или изображения внутри кнопки
		prIndic1.setStyle("-fx-label-padding: 5.0px;");
				
			// Установка фона и цвета текста кнопуи
		prIndic1.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
		
/*----------------------------------------- КЛАСС PROGRESS BAR-----------------------------------------------------------------------
		 Класс ProgressIndicator реализует индикатор хода процесса в форме круга, внутри которого текущий статус в виде сегментов
		 Object - Node - Parent- Region - Control - ProgressIndicator - ProgressBar		*/
		
			// Конструкторы
		ProgressBar prBar1 = new ProgressBar();	/* создает индикатор с неопределенным значением. Внутри индикатора
			будут постоянно по кругу перемещаться сегменты, показывая ход выполнения процесса  с неопредел. кол-вом шагов.	
			Используют, если невозможно разделить задачу на части и неизвестны сроки выполнения */

		ProgressBar prBar2 = new ProgressBar(0.5);  // указывает статус в виде вещественного числа 
		
			// Установка определенного статуса  индикатора
		prBar2.setProgress(0.6);
			
			// Установка определенного статуса  индикатора
		prBar1.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
		
			// Указание размеров
		prBar1.setMinHeight(60);   prBar1.setMinWidth(100);
		prBar2.setMinHeight(60);   prBar2.setMinWidth(100);
		
			// Растояние от внутренних границ области до текста и/или изображения внутри кнопки
		prBar1.setStyle("-fx-label-padding: 5.0px;");
				
			// Установка фона и цвета текста кнопуи
		prBar1.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
				
		
		HBox hbox = new HBox(20, prIndic1, prIndic2, prBar1, prBar2);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));		
		
		Scene scene = new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Progress Indicator");
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}