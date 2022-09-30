package t59_Chart;
	
import java.io.File;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.Axis;
import javafx.scene.chart.Axis.TickMark;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) {	
			
/*------------------------------КЛАСС CHART---------------------------------------------------------------------
	является базовым для всех классов, реализующих диаграммы (линейный график, разные види диаграмм, гистограммы) 
	Наследование Obect - Node - parent - Region - Chart
	Методы базового класса Chart
	 - setTitle/getTitle() - установка заголовка
	 - setTitleSide/getTitleSide() - задает местоположение заголвка TOP, BOTTOM, LEFT, RIGHT
	 - setLegendSide/getLegendSide() - задает сторону диаграммы, с которой будет выводиться блок с именами областей и соответствующими 
	  									им цветами. 	
	 - setLegendVisible - при false блок с именами не будет отображаться
	 - setAnimated - при trueизменение значений будет выполняться с анимацией, а  не сразу
*/		
			
/*------------------------------КЛАСС PIECHART--------------------------------------------------------------------- 
 * Object - Node - Parent - Region - chart - PieChart*/
		PieChart piech1 = new PieChart();
		piech1.setTitle("PIECHART");
		piech1.setTitleSide(Side.TOP);
		piech1.setLegendVisible(true);
		piech1.setAnimated(true);
		piech1.setStartAngle(10);			// Задает начальный угол для первой области
		piech1.setClockwise(true);  		// При true области будут следовать по часовой стрелке
		piech1.setLabelLineLength(10);		// Задает длину линии между областью и ее названиями
			/* 	piech1.setData(Obversablelist <PieChart.Data> value)
		задает список с отображаемыми данными. Любые изменения списка отразятся на диаграмме 
		PieChart.Data(String name, double value) - для описания области на диаграмме 
		Перый параметр - имя, второй - значение*/
		ObservableList<PieChart.Data> list = FXCollections.<PieChart.Data>observableArrayList();
		list.add(new PieChart.Data("Name 1", 60));
		list.add(new PieChart.Data("Name 2", 20));
		list.add(new PieChart.Data("Name 3", 20));
		piech1.setData(list);

/*------------------------------------KЛАСС AXIS<T> - ось диаграммы-------------------------------------------
 является абстрактным классом и базовым для классов, описывающих ось диаграммы. 
 
 						КЛАСС ValueAxis<T> и NumberAxis		
 для создания оси с числовыми значениями
 Object - Node - Parent - Region - Axis<T> - ValueAxis<Number> - NumberAxis 		
 		Конструкторы
 	NumberAxis()
 	NumberAxis(double lowerBound, double upperBound, double tickUnit)
 	NumberAxis(String axisLabel, double lowerBound, double upperBound, double tickUnit)	
 		где lowerBound - минимальное значение на оси,
 			upperBound - максимальное значение на оси,
 			tickUnit - шаг для основных рисок
 			axisLabel - текст, отображаемый рядом с осью */
		NumberAxis axis = new NumberAxis();
		axis.setLowerBound(30);         		 // минимальное значение на оси,
		axis.setUpperBound(80);         		 // максимальное значение на оси,
		axis.setTickUnit(10);            		 // шаг для основных рисок
		axis.setForceZeroInRange(false);		 // при true значение ноль всегда будет видно на оси
		axis.setMinorTickVisible(true);   		 // при fasle промежуточные риски отображаться не будет
		axis.setMinorTickCount(3);        		 // задает количество промежуточных рисок
		axis.setMinorTickLength(2);              // задает длину промежуточных рисок
		axis.setAnimated(true);					// при true изменение проводится с анимацией
		axis.setAutoRanging(true);				// при true диапазон определяется автоматически в соответствии с отображаемым данными
		axis.setLabel("Axis X");
		axis.setSide(Side.BOTTOM);      			//задает сторону данной оси на диаграмме
		axis.setTickLabelsVisible(true);			// при true надписи рядом с основными будут отображаться
		axis.setTickMarkVisible(true);      		// при false основные риски отображаться не будут
		axis.setTickLength(5); 						// задает длину основных рисок
		axis.setTickLabelFill(Color.BLUE);			// задает цвет
		axis.setTickLabelFill(Color.BLUEVIOLET);	// задает цвет надписей с основыми рисками
		axis.setTickLabelFont(Font.font(9));		// задает шрифт
		axis.setTickLabelGap(5);                    // задает растояние между надписями и основными рисками
		axis.setTickLabelRotation(50);              // задает угол поворота расположенные рядом с основными рисками
					/* Класс NumberAxis.DefaultFormatter
			для форматирования числовых значений можно воспользоваться классом  DefaultFormatter
				Конструкторы
			DefaultFormatter(NumberAxis axis)
			DefaultFormatter(NumberAxis axis, String prefix, String suffix)
				где axis - ось для которой делаются настройки
				    prefix - строка, которая будет добавлена перед значением
				    suffix - строка, которая будет добавлена после значения  */
		axis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(axis, "-", "-"));
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setAutoRanging(true);		
		yAxis.setLabel("Axis Y");
		yAxis.setSide(Side.LEFT);      	
		yAxis.setTickLabelsVisible(true);
		yAxis.setTickMarkVisible(true);  
		yAxis.setTickLength(2); 		
		yAxis.setTickLabelFill(Color.RED);
		
/*------------------------------КЛАСС XYChart<X,Y>  и КЛАСС AXIS<T>, ValueAxis<T> и NumberAxis-----------------------------------------
 	является АБСТРАКТНЫМ БАЗОВЫМ для всех классов диаграмм с двумя осями Х и У 
	 Object - Node - Parent - Region - Сhart - XYChart<X,Y>
	 
	 	 						КЛАСС LineChart<X,Y> - линейный график с соединением точек линией
	 Object - Node - Parent - Region - Сhart - XYChart<X,Y> -LineChart<X,Y>
	 	Конструктор 
	 LineChart(Asis<X> xAsis, Axis<Y> yAxis)
	 LineChart(Asis<X> xAsis, Axis<Y> yAxis, ObservableList<XYCHart.Series<X,Y> data)
	 	где 
	 xAxis - задает объект для оси Х
	 yAxis - задает объект для оси у,
	 data - список с отображаемыми данными	*/
		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(axis, yAxis);
		lineChart.setTitle("LINECHART with NumberAxis");	// установка заголовка
		lineChart.setTitleSide(Side.TOP);					// задает местоположение заголвка TOP, BOTTOM, LEFT, RIGHT
		lineChart.setLegendSide(Side.BOTTOM);				/* задает сторону диаграммы, с которой будет выводиться блок с
															   именами областей и соответствующими им цветами.  */
		lineChart.setLegendVisible(true);					// при false блок с именами не будет отображаться 
		lineChart.setAnimated(true);						// при true изменение значений будет выполняться с анимацией, а  не сразу
		Axis referenceToXAxis = lineChart.getXAxis();		// Получить ссылку на ось Х
		Axis referenceToYAxis = lineChart.getYAxis();		// Получить ссылку на ось Y
		lineChart.setHorizontalGridLinesVisible(true);      // задает видимость горизонтальных линий
		lineChart.setVerticalGridLinesVisible(true);        // задает видимость вертикальных линий
		lineChart.setHorizontalZeroLineVisible(true);		/* при true при наличии и положительных, и отрицательных значений
															 будет проведена доп.горизонтальная линия для нулевого значения */
		lineChart.setVerticalZeroLineVisible(true);			/* при true при наличии и положительных, и отрицательных значений
															 будет проведена доп.вертикальная линия для нулевого значения */
		lineChart.setAlternativeColumnFillVisible(true);	// при true альтернативные вертикальные столбцы будут иметь заливку
		lineChart.setAlternativeRowFillVisible(true);		// при true альтернативные горизонтальные строки будут иметь заливку
		lineChart.setCreateSymbols(true);                  // при false показываются только линии
		lineChart.setMinWidth(200);
		lineChart.setMinHeight(200);
		
/*----------------------------КЛАСС XYChart.Series<X,Y>----------------------------------------------
		описывает именнованную серию данных
			Конструкторы
		Series()
		Series(ObservableList<Data<X,Y>> data)
		Series(String name, ObservableList<Data<X,Y>> data)
		 где name - название серии данных,
		 	 data - список с данными		*/
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName("FIRST");                 // задает имя серии данных
		series.getData().add(new XYChart.Data<Number, Number>(10,10));
		series.getData().add(new XYChart.Data<Number, Number>(30,50));
		series.getData().add(new XYChart.Data<Number, Number>(40,80));
		series.getData().add(new XYChart.Data<Number, Number>(50,90));
		series.getData().add(new XYChart.Data<Number, Number>(60,20));
			XYChart.Series<Number, Number> series3 = new XYChart.Series<>();
		series3.setName("SECOND");    
		series3.getData().add(new XYChart.Data<Number, Number>(10,5));
		series3.getData().add(new XYChart.Data<Number, Number>(30,25));
		series3.getData().add(new XYChart.Data<Number, Number>(40,50));
		series3.getData().add(new XYChart.Data<Number, Number>(50,45));
		series3.getData().add(new XYChart.Data<Number, Number>(60,10));
			// Добавление серии данных в чарт
		lineChart.getData().add(series);
		lineChart.getData().add(series3);
			/* Метод setNode
		возвращет ссылку на узел (точку на графике), соответствующую выбранному элементу ObservableList<Data<X,Y>> серии данных
		Ниже пример добавления всплывающей подсказки для первой точки на графике
		Сначала получаем  ObservableList<Data<X,Y>> серии данных и его нулевой элемент, затем устанавливаем для него подсказку
		Важно делать это после добавления серии в чат (после строки lineChart.getData().add(series))	 */
		Tooltip.install(series.getData().get(0).getNode(), new Tooltip("Data 1"));
			// Задание собственного узла вместо используемого по умолчанию
//		Image img1;
//		try { 
//			img1 = new Image(getClass().getResourceAsStream("/img/icons.png"));
//			if (img1.isError()) new RuntimeException();		
//			}
//		catch (Exception e) {
//			System.out.println("Не удалось загрузить изображение");
//			return; }
//		ImageView imf = new ImageView(img1);
//		imf.maxHeight(10);
//		imf.maxWidth(10);
//		series.setNode(imf);
		
/*----------------------------КЛАСС XYChart.Data<X,Y>   для добавления в series ----------------------------------------------
		описывает данные
			Конструкторы
		XYChart.Data()
		XYChart.Data(X xValue, Y yValue)
		XYChart.Data(X xValue, Y yValue, Object extraValue)
		 где xValue - значение по оси Х,
		 	 yValue - значение по оси У,
		 	 extraValue - дополнительные данные - например, радиус пузырька при использовании класса BubbleChart */
		XYChart.Data<Number, Number> data = new XYChart.Data();
		data.setXValue(100);
		data.setYValue(100);
		series.getData().add(data);			// Добавление data в series
		
/*-------------------------Класс CategoryAxis    Ось диаграммы со строковыми значениями
 * Object - Node - Parent - Region - Axis<String> - CategoryAxis
 		Конструкторы
 	CategoryAxis()
 	CategoryAxis(Observablelist<String> categories)	
 			где categories - список строк для внесения в ось			 */
		ObservableList<String> categories = FXCollections.<String>observableArrayList();
		categories.addAll("Marz", "February", "January", "April");
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setCategories(categories);			// добавление данных на ось
		xAxis.setAnimated(true);					// при true изменение проводится с анимацией
		xAxis.setAutoRanging(true);					// при true диапазон определяется автоматически в соответствии с отображаемым данными
		xAxis.setLabel("Axis X");
		xAxis.setSide(Side.BOTTOM);      			//задает сторону данной оси на диаграмме
		xAxis.setTickLabelsVisible(true);			// при true надписи рядом с основными будут отображаться
		xAxis.setTickMarkVisible(true);      		// при false основные риски отображаться не будут
		xAxis.setTickLength(5); 					// задает длину основных рисок
		xAxis.setTickLabelFill(Color.BLUE);			// задает цвет
		xAxis.setTickLabelFill(Color.BLUEVIOLET);	// задает цвет надписей с основыми рисками
		xAxis.setTickLabelFont(Font.font(9));		// задает шрифт
		xAxis.setTickLabelGap(5);                    // задает растояние между надписями и основными рисками
		xAxis.setTickLabelRotation(50);              // задает угол поворота расположенные рядом с основными рисками
		xAxis.setStartMargin(3);                     // задает растояние между осью и первой категорией
		xAxis.setEndMargin(3);                       // задает растояие между осью и последней категорией
		xAxis.setGapStartAndEnd(true);               // при true точка данных будет на одной линии с риской категории оси
		
		NumberAxis yAxis2 = new NumberAxis();
		
		LineChart<String, Number> lineChart2 = new LineChart<String, Number>(xAxis, yAxis2);
		lineChart2.setTitle("LINECHART with NumberAxis and CategoryAxis");					// установка заголовка
		Series<String, Number> series2 = new Series<String, Number>();
		series2.setName("FIRST");                 // задает имя серии данных
		series2.getData().add(new XYChart.Data<String, Number>("January", 10));
		series2.getData().add(new XYChart.Data<String, Number>("February",50));
		series2.getData().add(new XYChart.Data<String, Number>("Marz",80));
		series2.getData().add(new XYChart.Data<String, Number>("April",90));
		lineChart2.getData().add(series2);
		
/*----------------------------КЛАСС BarChart<X,Y>    ГИСТРОГРАММА----------------------------------------------------
     значение определяют высоту столбца для вертикальной гистограммы
     или длину столбца для горизонтальной гистограммы
     Object - Node - Parent - Region - Chart - XYChart<X,Y> - BarChart<X,Y>
     	Конструкторы
     BarChart (Axis<X> xAxis, Axis<Y> yAxis) 
     BarChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
     BarChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data, double categoryGap)
     	где 
	 xAxis - задает объект класса CategoryAxis для оси Х
	 yAxis - задает объект класса NumberAxis для оси у     ИЛИ НАОБОРОТ для горизонтальной гистограммы
	 data - список с отображаемыми данными	
	 categoryGap - расстояние между категориями гистрограммы */
		ObservableList<String> categories2 = FXCollections.<String>observableArrayList();
		categories2.addAll("Marz", "February", "January", "April");
		CategoryAxis xAxis3 = new CategoryAxis();
		xAxis.setCategories(categories);		
		NumberAxis yAxis3 = new NumberAxis();
		
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis3, yAxis3);
		barChart.setTitle("BARCHATRT");						// установка заголовка
		barChart.setTitleSide(Side.TOP);					// задает местоположение заголвка TOP, BOTTOM, LEFT, RIGHT
		barChart.setLegendSide(Side.BOTTOM);				/* задает сторону диаграммы, с которой будет выводиться блок с
															   именами областей и соответствующими им цветами.  */
		barChart.setLegendVisible(true);					// при false блок с именами не будет отображаться 
		barChart.setAnimated(true);							// при true изменение значений будет выполняться с анимацией, а  не сразу
		barChart.setHorizontalGridLinesVisible(true);      // задает видимость горизонтальных линий
		barChart.setVerticalGridLinesVisible(true);        // задает видимость вертикальных линий
		barChart.setHorizontalZeroLineVisible(true);		/* при true при наличии и положительных, и отрицательных значений
															 будет проведена доп.горизонтальная линия для нулевого значения */
		barChart.setVerticalZeroLineVisible(true);			/* при true при наличии и положительных, и отрицательных значений
															 будет проведена доп.вертикальная линия для нулевого значения */
		barChart.setAlternativeColumnFillVisible(true);		// при true альтернативные вертикальные столбцы будут иметь заливку
		barChart.setAlternativeRowFillVisible(true);		// при true альтернативные горизонтальные строки будут иметь заливку
		barChart.setMinWidth(200);
		barChart.setMinHeight(200);
		barChart.setCategoryGap(15);						  // задает расстояние между категориями гистограммы
		barChart.setBarGap(3);							   // задает расстояние между столбцами внутри одной категории
		Series<String, Number> series4 = new Series<String, Number>();
		series4.setName("FIRST");                 // задает имя серии данных
		series4.getData().add(new XYChart.Data<String, Number>("January", 10));
		series4.getData().add(new XYChart.Data<String, Number>("February",50));
		series4.getData().add(new XYChart.Data<String, Number>("Marz",80));
		series4.getData().add(new XYChart.Data<String, Number>("April",90));
		barChart.getData().add(series4);
		
/* -------------------------КЛАСС StackedBarChart<X,Y>   гистрограмма, в которой кол-во данных в категории определяет высоту 
  стобца (для вертикальной гистограммы) или его длину (для горизонтальной). Данные разных категорий накладываются друг на друга	
  Object - Node - Parent - Region - Chart - XYChart<X,Y> - StackedBarChart<X,Y>
     	Конструкторы
     StackedBarChart (Axis<X> xAxis, Axis<Y> yAxis) 
     StackedBarChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
     StackedBarChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data, double categoryGap)
     	где 
	 xAxis - задает объект класса CategoryAxis для оси Х
	 yAxis - задает объект класса NumberAxis для оси у     ИЛИ НАОБОРОТ для горизонтальной гистограммы
	 data - список с отображаемыми данными	
	 categoryGap - расстояние между категориями гистрограммы */
		StackedBarChart<String, Number> stackedBarChart = new StackedBarChart<String, Number>(xAxis3, yAxis3);
		stackedBarChart.setTitle("StackedBarChart");						// установка заголовка
		stackedBarChart.setTitleSide(Side.TOP);						// задает местоположение заголвка TOP, BOTTOM, LEFT, RIGHT
		stackedBarChart.setLegendSide(Side.BOTTOM);					/* задает сторону диаграммы, с которой будет выводиться блок с
															   		именами областей и соответствующими им цветами.  */
		stackedBarChart.setLegendVisible(true);					    // при false блок с именами не будет отображаться 
		stackedBarChart.setAnimated(true);							// при true изменение значений будет выполняться с анимацией, а  не сразу
		stackedBarChart.setHorizontalGridLinesVisible(true);        // задает видимость горизонтальных линий
		stackedBarChart.setVerticalGridLinesVisible(true);      	// задает видимость вертикальных линий
		stackedBarChart.setHorizontalZeroLineVisible(true);			/* при true при наличии и положительных, и отрицательных значений
															 		будет проведена доп.горизонтальная линия для нулевого значения */
		stackedBarChart.setVerticalZeroLineVisible(true);			/* при true при наличии и положительных, и отрицательных значений
															 		будет проведена доп.вертикальная линия для нулевого значения */
		stackedBarChart.setAlternativeColumnFillVisible(true);		// при true альтернативные вертикальные столбцы будут иметь заливку
		stackedBarChart.setAlternativeRowFillVisible(true);			// при true альтернативные горизонтальные строки будут иметь заливку
		stackedBarChart.setMinWidth(200);
		stackedBarChart.setMinHeight(200);
		stackedBarChart.setCategoryGap(15);						    // задает расстояние между категориями гистограммы
		
		Series<String, Number> series5 = new Series<String, Number>();
		series5.setName("FIRST");                 // задает имя серии данных
		series5.getData().add(new XYChart.Data<String, Number>("January", 10));
		series5.getData().add(new XYChart.Data<String, Number>("February",50));
		series5.getData().add(new XYChart.Data<String, Number>("Marz",80));
		series5.getData().add(new XYChart.Data<String, Number>("April",90));
		stackedBarChart.getData().add(series4);
		stackedBarChart.getData().add(series5);
		
/* -------------------------КЛАСС BubbleChart<X,Y>   Пузырьковая диаграмма	
	  Object - Node - Parent - Region - Chart - XYChart<X,Y> - BubbleChart<X,Y>
	     	Конструкторы
	     BubbleChart (Axis<X> xAxis, Axis<Y> yAxis) 
	     BubbleChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
	     	где 
		 xAxis - задает объект класса CategoryAxis для оси Х
		 yAxis - задает объект класса NumberAxis для оси у     ИЛИ НАОБОРОТ для горизонтальной гистограммы
	 	data - список с отображаемыми данными	*/
		NumberAxis xAxis4 = new NumberAxis();
		NumberAxis yAxis4 = new NumberAxis();
		BubbleChart<Number, Number> bubbleChart = new BubbleChart<Number, Number>(xAxis4, yAxis4);
		bubbleChart.setTitle("BubbleChart");						// установка заголовка
		bubbleChart.setTitleSide(Side.TOP);						// задает местоположение заголвка TOP, BOTTOM, LEFT, RIGHT
		bubbleChart.setLegendSide(Side.BOTTOM);					/* задает сторону диаграммы, с которой будет выводиться блок с
															   		именами областей и соответствующими им цветами.  */
		bubbleChart.setLegendVisible(true);					    // при false блок с именами не будет отображаться 
		bubbleChart.setAnimated(true);							// при true изменение значений будет выполняться с анимацией, а  не сразу
		bubbleChart.setHorizontalGridLinesVisible(true);        // задает видимость горизонтальных линий
		bubbleChart.setVerticalGridLinesVisible(true);      	// задает видимость вертикальных линий
		bubbleChart.setHorizontalZeroLineVisible(true);			/* при true при наличии и положительных, и отрицательных значений
															 		будет проведена доп.горизонтальная линия для нулевого значения */
		bubbleChart.setVerticalZeroLineVisible(true);			/* при true при наличии и положительных, и отрицательных значений
															 		будет проведена доп.вертикальная линия для нулевого значения */
		bubbleChart.setAlternativeColumnFillVisible(true);		// при true альтернативные вертикальные столбцы будут иметь заливку
		bubbleChart.setAlternativeRowFillVisible(true);			// при true альтернативные горизонтальные строки будут иметь заливку
		bubbleChart.setMinWidth(200);
		bubbleChart.setMinHeight(200);
		
		XYChart.Series<Number, Number> series6 = new XYChart.Series<>();
		series6.setName("FIRST");             
		series6.getData().add(new XYChart.Data<Number, Number>(10,10));
		series6.getData().add(new XYChart.Data<Number, Number>(30,50));
		series6.getData().add(new XYChart.Data<Number, Number>(40,80));
		series6.getData().add(new XYChart.Data<Number, Number>(50,90));
		bubbleChart.getData().add(series6);

/* -------------------------КЛАСС AreaChart<X,Y>   Линейный график с заливкой области	
	  Object - Node - Parent - Region - Chart - XYChart<X,Y> - AreaChart<X,Y>
	     	Конструкторы
	     AreaChart (Axis<X> xAxis, Axis<Y> yAxis) 
	     AreaChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
	     	где 
		 xAxis - задает объект класса CategoryAxis для оси Х
		 yAxis - задает объект класса NumberAxis для оси у     ИЛИ НАОБОРОТ для горизонтальной гистограммы
         data - список с отображаемыми данными	*/
			NumberAxis xAxis5 = new NumberAxis();
			NumberAxis yAxis5 = new NumberAxis();
			AreaChart<Number, Number> areaChart = new AreaChart<Number, Number>(xAxis5, yAxis5);
			areaChart.setTitle("AreaChart");						// установка заголовка
			areaChart.setTitleSide(Side.TOP);						// задает местоположение заголвка TOP, BOTTOM, LEFT, RIGHT
			areaChart.setLegendSide(Side.BOTTOM);					/* задает сторону диаграммы, с которой будет выводиться блок с
																   		именами областей и соответствующими им цветами.  */
			areaChart.setLegendVisible(true);					    // при false блок с именами не будет отображаться 
			areaChart.setAnimated(true);							// при true изменение значений будет выполняться с анимацией, а  не сразу
			areaChart.setHorizontalGridLinesVisible(true);     	   // задает видимость горизонтальных линий
			areaChart.setVerticalGridLinesVisible(true);   		   	// задает видимость вертикальных линий
			areaChart.setHorizontalZeroLineVisible(true);			/* при true при наличии и положительных, и отрицательных значений
																 		будет проведена доп.горизонтальная линия для нулевого значения */
			areaChart.setVerticalZeroLineVisible(true);				/* при true при наличии и положительных, и отрицательных значений
																 		будет проведена доп.вертикальная линия для нулевого значения */
			areaChart.setAlternativeColumnFillVisible(true);		// при true альтернативные вертикальные столбцы будут иметь заливку
			areaChart.setAlternativeRowFillVisible(true);			// при true альтернативные горизонтальные строки будут иметь заливку
			areaChart.setMinWidth(200);
			areaChart.setMinHeight(200);
			
			XYChart.Series<Number, Number> series7 = new XYChart.Series<>();
			series7.setName("FIRST");             
			series7.getData().add(new XYChart.Data<Number, Number>(10,10));
			series7.getData().add(new XYChart.Data<Number, Number>(30,50));
			series7.getData().add(new XYChart.Data<Number, Number>(40,80));
			series7.getData().add(new XYChart.Data<Number, Number>(50,90));
			areaChart.getData().add(series7);
			
/* -------------------------КЛАСС StackedAreaChart<X,Y>   Линейный график с заливкой области	
  Области складываются таким образом, чтобы каждая серия данных примыкала, но не перекрывала предыдущую серию данных
	  Object - Node - Parent - Region - Chart - XYChart<X,Y> - StackedAreaChart<X,Y>
	     	Конструкторы
      StackedAreaChart (Axis<X> xAxis, Axis<Y> yAxis) 
      StackedAreaChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
     	где 
	 xAxis - задает объект класса CategoryAxis для оси Х
	 yAxis - задает объект класса NumberAxis для оси у     ИЛИ НАОБОРОТ для горизонтальной гистограммы
     data - список с отображаемыми данными	*/
			NumberAxis xAxis6 = new NumberAxis();
			NumberAxis yAxis6 = new NumberAxis();
			StackedAreaChart<Number, Number> stackedAreaChart = new StackedAreaChart<Number, Number>(xAxis6, yAxis6);
			stackedAreaChart.setTitle("StackedAreaChart");				// установка заголовка
			stackedAreaChart.setTitleSide(Side.TOP);					// задает местоположение заголвка TOP, BOTTOM, LEFT, RIGHT
			stackedAreaChart.setLegendSide(Side.BOTTOM);				/* задает сторону диаграммы, с которой будет выводиться блок с
																		   именами областей и соответствующими им цветами.  */
			stackedAreaChart.setLegendVisible(true);					// при false блок с именами не будет отображаться 
			stackedAreaChart.setAnimated(true);							// при true изменение значений будет выполняться с анимацией, а  не сразу
			stackedAreaChart.setHorizontalGridLinesVisible(true);     	// задает видимость горизонтальных линий
			stackedAreaChart.setVerticalGridLinesVisible(true);   	   	// задает видимость вертикальных линий
			stackedAreaChart.setHorizontalZeroLineVisible(true);		/* при true при наличии и положительных, и отрицательных значений
																 		будет проведена доп.горизонтальная линия для нулевого значения */
			stackedAreaChart.setVerticalZeroLineVisible(true);			/* при true при наличии и положительных, и отрицательных значений
																 		будет проведена доп.вертикальная линия для нулевого значения */
			stackedAreaChart.setAlternativeColumnFillVisible(true);		// при true альтернативные вертикальные столбцы будут иметь заливку
			stackedAreaChart.setAlternativeRowFillVisible(true);		// при true альтернативные горизонтальные строки будут иметь заливку
			stackedAreaChart.setMinWidth(200);
			stackedAreaChart.setMinHeight(200);
			
			XYChart.Series<Number, Number> series8 = new XYChart.Series<>();
			series8.setName("FIRST");             
			series8.getData().add(new XYChart.Data<Number, Number>(10,10));
			series8.getData().add(new XYChart.Data<Number, Number>(30,50));
			series8.getData().add(new XYChart.Data<Number, Number>(40,80));
			series8.getData().add(new XYChart.Data<Number, Number>(50,90));
			stackedAreaChart.getData().add(series8);
				XYChart.Series<Number, Number> series9 = new XYChart.Series<>();
			series9.setName("SECOND");             
			series9.getData().add(new XYChart.Data<Number, Number>(10,10));
			series9.getData().add(new XYChart.Data<Number, Number>(30,50));
			series9.getData().add(new XYChart.Data<Number, Number>(40,80));
			series9.getData().add(new XYChart.Data<Number, Number>(50,90));
			stackedAreaChart.getData().add(series9);

/* -------------------------КЛАСС ScatterChart<X,Y>   Диаграмма, в которой точки отображаются различными символами
	  	Object - Node - Parent - Region - Chart - XYChart<X,Y> - ScatterChart<X,Y>
		     	Конструкторы
		  ScatterChart (Axis<X> xAxis, Axis<Y> yAxis) 
		  ScatterChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
		    	где 
		  xAxis - задает объект класса CategoryAxis для оси Х
		  yAxis - задает объект класса NumberAxis для оси у     ИЛИ НАОБОРОТ для горизонтальной гистограммы
		  data - список с отображаемыми данными	*/
		NumberAxis xAxis7 = new NumberAxis();
		NumberAxis yAxis7 = new NumberAxis();
		ScatterChart<Number, Number> scatterChart = new ScatterChart<Number, Number>(xAxis7, yAxis7);
		scatterChart.setTitle("ScatterChart");					// установка заголовка
		scatterChart.setTitleSide(Side.TOP);					// задает местоположение заголвка TOP, BOTTOM, LEFT, RIGHT
		scatterChart.setLegendSide(Side.BOTTOM);				/* задает сторону диаграммы, с которой будет выводиться блок с
																   именами областей и соответствующими им цветами.  */
		scatterChart.setLegendVisible(true);					// при false блок с именами не будет отображаться 
		scatterChart.setAnimated(true);							// при true изменение значений будет выполняться с анимацией, а  не сразу
		scatterChart.setHorizontalGridLinesVisible(true);     	// задает видимость горизонтальных линий
		scatterChart.setVerticalGridLinesVisible(true);   	   	// задает видимость вертикальных линий
		scatterChart.setHorizontalZeroLineVisible(true);		/* при true при наличии и положительных, и отрицательных значений
															 		будет проведена доп.горизонтальная линия для нулевого значения */
		scatterChart.setVerticalZeroLineVisible(true);			/* при true при наличии и положительных, и отрицательных значений
															 		будет проведена доп.вертикальная линия для нулевого значения */
		scatterChart.setAlternativeColumnFillVisible(true);		// при true альтернативные вертикальные столбцы будут иметь заливку
		scatterChart.setAlternativeRowFillVisible(true);		// при true альтернативные горизонтальные строки будут иметь заливку
		scatterChart.setMinWidth(200);
		scatterChart.setMinHeight(200);
			
		XYChart.Series<Number, Number> series10 = new XYChart.Series<>();
		series10.setName("FIRST");             
		series10.getData().add(new XYChart.Data<Number, Number>(10,10));
		series10.getData().add(new XYChart.Data<Number, Number>(30,50));
		series10.getData().add(new XYChart.Data<Number, Number>(40,80));
		series10.getData().add(new XYChart.Data<Number, Number>(50,90));
		scatterChart.getData().add(series10);
			XYChart.Series<Number, Number> series11 = new XYChart.Series<>();
		series11.setName("SECOND");             
		series11.getData().add(new XYChart.Data<Number, Number>(10,5));
		series11.getData().add(new XYChart.Data<Number, Number>(30,25));
		series11.getData().add(new XYChart.Data<Number, Number>(40,40));
		series11.getData().add(new XYChart.Data<Number, Number>(50,45));
		scatterChart.getData().add(series11);
			
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		hbox.getChildren().addAll(piech1, lineChart, lineChart2);
		HBox hbox2 = new HBox();
		hbox2.getChildren().addAll(barChart, stackedBarChart, bubbleChart);
		HBox hbox3 = new HBox();
		hbox3.getChildren().addAll(areaChart, stackedAreaChart, scatterChart);
		vbox.getChildren().addAll(hbox, hbox2, hbox3);

		Scene scene = new Scene(vbox, 1200, 650);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CHART");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
