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
			
/*------------------------------����� CHART---------------------------------------------------------------------
	�������� ������� ��� ���� �������, ����������� ��������� (�������� ������, ������ ���� ��������, �����������) 
	������������ Obect - Node - parent - Region - Chart
	������ �������� ������ Chart
	 - setTitle/getTitle() - ��������� ���������
	 - setTitleSide/getTitleSide() - ������ �������������� �������� TOP, BOTTOM, LEFT, RIGHT
	 - setLegendSide/getLegendSide() - ������ ������� ���������, � ������� ����� ���������� ���� � ������� �������� � ���������������� 
	  									�� �������. 	
	 - setLegendVisible - ��� false ���� � ������� �� ����� ������������
	 - setAnimated - ��� true��������� �������� ����� ����������� � ���������, �  �� �����
*/		
			
/*------------------------------����� PIECHART--------------------------------------------------------------------- 
 * Object - Node - Parent - Region - chart - PieChart*/
		PieChart piech1 = new PieChart();
		piech1.setTitle("PIECHART");
		piech1.setTitleSide(Side.TOP);
		piech1.setLegendVisible(true);
		piech1.setAnimated(true);
		piech1.setStartAngle(10);			// ������ ��������� ���� ��� ������ �������
		piech1.setClockwise(true);  		// ��� true ������� ����� ��������� �� ������� �������
		piech1.setLabelLineLength(10);		// ������ ����� ����� ����� �������� � �� ����������
			/* 	piech1.setData(Obversablelist <PieChart.Data> value)
		������ ������ � ������������� �������. ����� ��������� ������ ��������� �� ��������� 
		PieChart.Data(String name, double value) - ��� �������� ������� �� ��������� 
		����� �������� - ���, ������ - ��������*/
		ObservableList<PieChart.Data> list = FXCollections.<PieChart.Data>observableArrayList();
		list.add(new PieChart.Data("Name 1", 60));
		list.add(new PieChart.Data("Name 2", 20));
		list.add(new PieChart.Data("Name 3", 20));
		piech1.setData(list);

/*------------------------------------K���� AXIS<T> - ��� ���������-------------------------------------------
 �������� ����������� ������� � ������� ��� �������, ����������� ��� ���������. 
 
 						����� ValueAxis<T> � NumberAxis		
 ��� �������� ��� � ��������� ����������
 Object - Node - Parent - Region - Axis<T> - ValueAxis<Number> - NumberAxis 		
 		������������
 	NumberAxis()
 	NumberAxis(double lowerBound, double upperBound, double tickUnit)
 	NumberAxis(String axisLabel, double lowerBound, double upperBound, double tickUnit)	
 		��� lowerBound - ����������� �������� �� ���,
 			upperBound - ������������ �������� �� ���,
 			tickUnit - ��� ��� �������� �����
 			axisLabel - �����, ������������ ����� � ���� */
		NumberAxis axis = new NumberAxis();
		axis.setLowerBound(30);         		 // ����������� �������� �� ���,
		axis.setUpperBound(80);         		 // ������������ �������� �� ���,
		axis.setTickUnit(10);            		 // ��� ��� �������� �����
		axis.setForceZeroInRange(false);		 // ��� true �������� ���� ������ ����� ����� �� ���
		axis.setMinorTickVisible(true);   		 // ��� fasle ������������� ����� ������������ �� �����
		axis.setMinorTickCount(3);        		 // ������ ���������� ������������� �����
		axis.setMinorTickLength(2);              // ������ ����� ������������� �����
		axis.setAnimated(true);					// ��� true ��������� ���������� � ���������
		axis.setAutoRanging(true);				// ��� true �������� ������������ ������������� � ������������ � ������������ �������
		axis.setLabel("Axis X");
		axis.setSide(Side.BOTTOM);      			//������ ������� ������ ��� �� ���������
		axis.setTickLabelsVisible(true);			// ��� true ������� ����� � ��������� ����� ������������
		axis.setTickMarkVisible(true);      		// ��� false �������� ����� ������������ �� �����
		axis.setTickLength(5); 						// ������ ����� �������� �����
		axis.setTickLabelFill(Color.BLUE);			// ������ ����
		axis.setTickLabelFill(Color.BLUEVIOLET);	// ������ ���� �������� � �������� �������
		axis.setTickLabelFont(Font.font(9));		// ������ �����
		axis.setTickLabelGap(5);                    // ������ ��������� ����� ��������� � ��������� �������
		axis.setTickLabelRotation(50);              // ������ ���� �������� ������������� ����� � ��������� �������
					/* ����� NumberAxis.DefaultFormatter
			��� �������������� �������� �������� ����� ��������������� �������  DefaultFormatter
				������������
			DefaultFormatter(NumberAxis axis)
			DefaultFormatter(NumberAxis axis, String prefix, String suffix)
				��� axis - ��� ��� ������� �������� ���������
				    prefix - ������, ������� ����� ��������� ����� ���������
				    suffix - ������, ������� ����� ��������� ����� ��������  */
		axis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(axis, "-", "-"));
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setAutoRanging(true);		
		yAxis.setLabel("Axis Y");
		yAxis.setSide(Side.LEFT);      	
		yAxis.setTickLabelsVisible(true);
		yAxis.setTickMarkVisible(true);  
		yAxis.setTickLength(2); 		
		yAxis.setTickLabelFill(Color.RED);
		
/*------------------------------����� XYChart<X,Y>  � ����� AXIS<T>, ValueAxis<T> � NumberAxis-----------------------------------------
 	�������� ����������� ������� ��� ���� ������� �������� � ����� ����� � � � 
	 Object - Node - Parent - Region - �hart - XYChart<X,Y>
	 
	 	 						����� LineChart<X,Y> - �������� ������ � ����������� ����� ������
	 Object - Node - Parent - Region - �hart - XYChart<X,Y> -LineChart<X,Y>
	 	����������� 
	 LineChart(Asis<X> xAsis, Axis<Y> yAxis)
	 LineChart(Asis<X> xAsis, Axis<Y> yAxis, ObservableList<XYCHart.Series<X,Y> data)
	 	��� 
	 xAxis - ������ ������ ��� ��� �
	 yAxis - ������ ������ ��� ��� �,
	 data - ������ � ������������� �������	*/
		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(axis, yAxis);
		lineChart.setTitle("LINECHART with NumberAxis");	// ��������� ���������
		lineChart.setTitleSide(Side.TOP);					// ������ �������������� �������� TOP, BOTTOM, LEFT, RIGHT
		lineChart.setLegendSide(Side.BOTTOM);				/* ������ ������� ���������, � ������� ����� ���������� ���� �
															   ������� �������� � ���������������� �� �������.  */
		lineChart.setLegendVisible(true);					// ��� false ���� � ������� �� ����� ������������ 
		lineChart.setAnimated(true);						// ��� true ��������� �������� ����� ����������� � ���������, �  �� �����
		Axis referenceToXAxis = lineChart.getXAxis();		// �������� ������ �� ��� �
		Axis referenceToYAxis = lineChart.getYAxis();		// �������� ������ �� ��� Y
		lineChart.setHorizontalGridLinesVisible(true);      // ������ ��������� �������������� �����
		lineChart.setVerticalGridLinesVisible(true);        // ������ ��������� ������������ �����
		lineChart.setHorizontalZeroLineVisible(true);		/* ��� true ��� ������� � �������������, � ������������� ��������
															 ����� ��������� ���.�������������� ����� ��� �������� �������� */
		lineChart.setVerticalZeroLineVisible(true);			/* ��� true ��� ������� � �������������, � ������������� ��������
															 ����� ��������� ���.������������ ����� ��� �������� �������� */
		lineChart.setAlternativeColumnFillVisible(true);	// ��� true �������������� ������������ ������� ����� ����� �������
		lineChart.setAlternativeRowFillVisible(true);		// ��� true �������������� �������������� ������ ����� ����� �������
		lineChart.setCreateSymbols(true);                  // ��� false ������������ ������ �����
		lineChart.setMinWidth(200);
		lineChart.setMinHeight(200);
		
/*----------------------------����� XYChart.Series<X,Y>----------------------------------------------
		��������� ������������ ����� ������
			������������
		Series()
		Series(ObservableList<Data<X,Y>> data)
		Series(String name, ObservableList<Data<X,Y>> data)
		 ��� name - �������� ����� ������,
		 	 data - ������ � �������		*/
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName("FIRST");                 // ������ ��� ����� ������
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
			// ���������� ����� ������ � ����
		lineChart.getData().add(series);
		lineChart.getData().add(series3);
			/* ����� setNode
		��������� ������ �� ���� (����� �� �������), ��������������� ���������� �������� ObservableList<Data<X,Y>> ����� ������
		���� ������ ���������� ����������� ��������� ��� ������ ����� �� �������
		������� ��������  ObservableList<Data<X,Y>> ����� ������ � ��� ������� �������, ����� ������������� ��� ���� ���������
		����� ������ ��� ����� ���������� ����� � ��� (����� ������ lineChart.getData().add(series))	 */
		Tooltip.install(series.getData().get(0).getNode(), new Tooltip("Data 1"));
			// ������� ������������ ���� ������ ������������� �� ���������
//		Image img1;
//		try { 
//			img1 = new Image(getClass().getResourceAsStream("/img/icons.png"));
//			if (img1.isError()) new RuntimeException();		
//			}
//		catch (Exception e) {
//			System.out.println("�� ������� ��������� �����������");
//			return; }
//		ImageView imf = new ImageView(img1);
//		imf.maxHeight(10);
//		imf.maxWidth(10);
//		series.setNode(imf);
		
/*----------------------------����� XYChart.Data<X,Y>   ��� ���������� � series ----------------------------------------------
		��������� ������
			������������
		XYChart.Data()
		XYChart.Data(X xValue, Y yValue)
		XYChart.Data(X xValue, Y yValue, Object extraValue)
		 ��� xValue - �������� �� ��� �,
		 	 yValue - �������� �� ��� �,
		 	 extraValue - �������������� ������ - ��������, ������ �������� ��� ������������� ������ BubbleChart */
		XYChart.Data<Number, Number> data = new XYChart.Data();
		data.setXValue(100);
		data.setYValue(100);
		series.getData().add(data);			// ���������� data � series
		
/*-------------------------����� CategoryAxis    ��� ��������� �� ���������� ����������
 * Object - Node - Parent - Region - Axis<String> - CategoryAxis
 		������������
 	CategoryAxis()
 	CategoryAxis(Observablelist<String> categories)	
 			��� categories - ������ ����� ��� �������� � ���			 */
		ObservableList<String> categories = FXCollections.<String>observableArrayList();
		categories.addAll("Marz", "February", "January", "April");
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setCategories(categories);			// ���������� ������ �� ���
		xAxis.setAnimated(true);					// ��� true ��������� ���������� � ���������
		xAxis.setAutoRanging(true);					// ��� true �������� ������������ ������������� � ������������ � ������������ �������
		xAxis.setLabel("Axis X");
		xAxis.setSide(Side.BOTTOM);      			//������ ������� ������ ��� �� ���������
		xAxis.setTickLabelsVisible(true);			// ��� true ������� ����� � ��������� ����� ������������
		xAxis.setTickMarkVisible(true);      		// ��� false �������� ����� ������������ �� �����
		xAxis.setTickLength(5); 					// ������ ����� �������� �����
		xAxis.setTickLabelFill(Color.BLUE);			// ������ ����
		xAxis.setTickLabelFill(Color.BLUEVIOLET);	// ������ ���� �������� � �������� �������
		xAxis.setTickLabelFont(Font.font(9));		// ������ �����
		xAxis.setTickLabelGap(5);                    // ������ ��������� ����� ��������� � ��������� �������
		xAxis.setTickLabelRotation(50);              // ������ ���� �������� ������������� ����� � ��������� �������
		xAxis.setStartMargin(3);                     // ������ ��������� ����� ���� � ������ ����������
		xAxis.setEndMargin(3);                       // ������ �������� ����� ���� � ��������� ����������
		xAxis.setGapStartAndEnd(true);               // ��� true ����� ������ ����� �� ����� ����� � ������ ��������� ���
		
		NumberAxis yAxis2 = new NumberAxis();
		
		LineChart<String, Number> lineChart2 = new LineChart<String, Number>(xAxis, yAxis2);
		lineChart2.setTitle("LINECHART with NumberAxis and CategoryAxis");					// ��������� ���������
		Series<String, Number> series2 = new Series<String, Number>();
		series2.setName("FIRST");                 // ������ ��� ����� ������
		series2.getData().add(new XYChart.Data<String, Number>("January", 10));
		series2.getData().add(new XYChart.Data<String, Number>("February",50));
		series2.getData().add(new XYChart.Data<String, Number>("Marz",80));
		series2.getData().add(new XYChart.Data<String, Number>("April",90));
		lineChart2.getData().add(series2);
		
/*----------------------------����� BarChart<X,Y>    ������������----------------------------------------------------
     �������� ���������� ������ ������� ��� ������������ �����������
     ��� ����� ������� ��� �������������� �����������
     Object - Node - Parent - Region - Chart - XYChart<X,Y> - BarChart<X,Y>
     	������������
     BarChart (Axis<X> xAxis, Axis<Y> yAxis) 
     BarChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
     BarChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data, double categoryGap)
     	��� 
	 xAxis - ������ ������ ������ CategoryAxis ��� ��� �
	 yAxis - ������ ������ ������ NumberAxis ��� ��� �     ��� �������� ��� �������������� �����������
	 data - ������ � ������������� �������	
	 categoryGap - ���������� ����� ����������� ������������ */
		ObservableList<String> categories2 = FXCollections.<String>observableArrayList();
		categories2.addAll("Marz", "February", "January", "April");
		CategoryAxis xAxis3 = new CategoryAxis();
		xAxis.setCategories(categories);		
		NumberAxis yAxis3 = new NumberAxis();
		
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis3, yAxis3);
		barChart.setTitle("BARCHATRT");						// ��������� ���������
		barChart.setTitleSide(Side.TOP);					// ������ �������������� �������� TOP, BOTTOM, LEFT, RIGHT
		barChart.setLegendSide(Side.BOTTOM);				/* ������ ������� ���������, � ������� ����� ���������� ���� �
															   ������� �������� � ���������������� �� �������.  */
		barChart.setLegendVisible(true);					// ��� false ���� � ������� �� ����� ������������ 
		barChart.setAnimated(true);							// ��� true ��������� �������� ����� ����������� � ���������, �  �� �����
		barChart.setHorizontalGridLinesVisible(true);      // ������ ��������� �������������� �����
		barChart.setVerticalGridLinesVisible(true);        // ������ ��������� ������������ �����
		barChart.setHorizontalZeroLineVisible(true);		/* ��� true ��� ������� � �������������, � ������������� ��������
															 ����� ��������� ���.�������������� ����� ��� �������� �������� */
		barChart.setVerticalZeroLineVisible(true);			/* ��� true ��� ������� � �������������, � ������������� ��������
															 ����� ��������� ���.������������ ����� ��� �������� �������� */
		barChart.setAlternativeColumnFillVisible(true);		// ��� true �������������� ������������ ������� ����� ����� �������
		barChart.setAlternativeRowFillVisible(true);		// ��� true �������������� �������������� ������ ����� ����� �������
		barChart.setMinWidth(200);
		barChart.setMinHeight(200);
		barChart.setCategoryGap(15);						  // ������ ���������� ����� ����������� �����������
		barChart.setBarGap(3);							   // ������ ���������� ����� ��������� ������ ����� ���������
		Series<String, Number> series4 = new Series<String, Number>();
		series4.setName("FIRST");                 // ������ ��� ����� ������
		series4.getData().add(new XYChart.Data<String, Number>("January", 10));
		series4.getData().add(new XYChart.Data<String, Number>("February",50));
		series4.getData().add(new XYChart.Data<String, Number>("Marz",80));
		series4.getData().add(new XYChart.Data<String, Number>("April",90));
		barChart.getData().add(series4);
		
/* -------------------------����� StackedBarChart<X,Y>   ������������, � ������� ���-�� ������ � ��������� ���������� ������ 
  ������ (��� ������������ �����������) ��� ��� ����� (��� ��������������). ������ ������ ��������� ������������� ���� �� �����	
  Object - Node - Parent - Region - Chart - XYChart<X,Y> - StackedBarChart<X,Y>
     	������������
     StackedBarChart (Axis<X> xAxis, Axis<Y> yAxis) 
     StackedBarChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
     StackedBarChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data, double categoryGap)
     	��� 
	 xAxis - ������ ������ ������ CategoryAxis ��� ��� �
	 yAxis - ������ ������ ������ NumberAxis ��� ��� �     ��� �������� ��� �������������� �����������
	 data - ������ � ������������� �������	
	 categoryGap - ���������� ����� ����������� ������������ */
		StackedBarChart<String, Number> stackedBarChart = new StackedBarChart<String, Number>(xAxis3, yAxis3);
		stackedBarChart.setTitle("StackedBarChart");						// ��������� ���������
		stackedBarChart.setTitleSide(Side.TOP);						// ������ �������������� �������� TOP, BOTTOM, LEFT, RIGHT
		stackedBarChart.setLegendSide(Side.BOTTOM);					/* ������ ������� ���������, � ������� ����� ���������� ���� �
															   		������� �������� � ���������������� �� �������.  */
		stackedBarChart.setLegendVisible(true);					    // ��� false ���� � ������� �� ����� ������������ 
		stackedBarChart.setAnimated(true);							// ��� true ��������� �������� ����� ����������� � ���������, �  �� �����
		stackedBarChart.setHorizontalGridLinesVisible(true);        // ������ ��������� �������������� �����
		stackedBarChart.setVerticalGridLinesVisible(true);      	// ������ ��������� ������������ �����
		stackedBarChart.setHorizontalZeroLineVisible(true);			/* ��� true ��� ������� � �������������, � ������������� ��������
															 		����� ��������� ���.�������������� ����� ��� �������� �������� */
		stackedBarChart.setVerticalZeroLineVisible(true);			/* ��� true ��� ������� � �������������, � ������������� ��������
															 		����� ��������� ���.������������ ����� ��� �������� �������� */
		stackedBarChart.setAlternativeColumnFillVisible(true);		// ��� true �������������� ������������ ������� ����� ����� �������
		stackedBarChart.setAlternativeRowFillVisible(true);			// ��� true �������������� �������������� ������ ����� ����� �������
		stackedBarChart.setMinWidth(200);
		stackedBarChart.setMinHeight(200);
		stackedBarChart.setCategoryGap(15);						    // ������ ���������� ����� ����������� �����������
		
		Series<String, Number> series5 = new Series<String, Number>();
		series5.setName("FIRST");                 // ������ ��� ����� ������
		series5.getData().add(new XYChart.Data<String, Number>("January", 10));
		series5.getData().add(new XYChart.Data<String, Number>("February",50));
		series5.getData().add(new XYChart.Data<String, Number>("Marz",80));
		series5.getData().add(new XYChart.Data<String, Number>("April",90));
		stackedBarChart.getData().add(series4);
		stackedBarChart.getData().add(series5);
		
/* -------------------------����� BubbleChart<X,Y>   ����������� ���������	
	  Object - Node - Parent - Region - Chart - XYChart<X,Y> - BubbleChart<X,Y>
	     	������������
	     BubbleChart (Axis<X> xAxis, Axis<Y> yAxis) 
	     BubbleChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
	     	��� 
		 xAxis - ������ ������ ������ CategoryAxis ��� ��� �
		 yAxis - ������ ������ ������ NumberAxis ��� ��� �     ��� �������� ��� �������������� �����������
	 	data - ������ � ������������� �������	*/
		NumberAxis xAxis4 = new NumberAxis();
		NumberAxis yAxis4 = new NumberAxis();
		BubbleChart<Number, Number> bubbleChart = new BubbleChart<Number, Number>(xAxis4, yAxis4);
		bubbleChart.setTitle("BubbleChart");						// ��������� ���������
		bubbleChart.setTitleSide(Side.TOP);						// ������ �������������� �������� TOP, BOTTOM, LEFT, RIGHT
		bubbleChart.setLegendSide(Side.BOTTOM);					/* ������ ������� ���������, � ������� ����� ���������� ���� �
															   		������� �������� � ���������������� �� �������.  */
		bubbleChart.setLegendVisible(true);					    // ��� false ���� � ������� �� ����� ������������ 
		bubbleChart.setAnimated(true);							// ��� true ��������� �������� ����� ����������� � ���������, �  �� �����
		bubbleChart.setHorizontalGridLinesVisible(true);        // ������ ��������� �������������� �����
		bubbleChart.setVerticalGridLinesVisible(true);      	// ������ ��������� ������������ �����
		bubbleChart.setHorizontalZeroLineVisible(true);			/* ��� true ��� ������� � �������������, � ������������� ��������
															 		����� ��������� ���.�������������� ����� ��� �������� �������� */
		bubbleChart.setVerticalZeroLineVisible(true);			/* ��� true ��� ������� � �������������, � ������������� ��������
															 		����� ��������� ���.������������ ����� ��� �������� �������� */
		bubbleChart.setAlternativeColumnFillVisible(true);		// ��� true �������������� ������������ ������� ����� ����� �������
		bubbleChart.setAlternativeRowFillVisible(true);			// ��� true �������������� �������������� ������ ����� ����� �������
		bubbleChart.setMinWidth(200);
		bubbleChart.setMinHeight(200);
		
		XYChart.Series<Number, Number> series6 = new XYChart.Series<>();
		series6.setName("FIRST");             
		series6.getData().add(new XYChart.Data<Number, Number>(10,10));
		series6.getData().add(new XYChart.Data<Number, Number>(30,50));
		series6.getData().add(new XYChart.Data<Number, Number>(40,80));
		series6.getData().add(new XYChart.Data<Number, Number>(50,90));
		bubbleChart.getData().add(series6);

/* -------------------------����� AreaChart<X,Y>   �������� ������ � �������� �������	
	  Object - Node - Parent - Region - Chart - XYChart<X,Y> - AreaChart<X,Y>
	     	������������
	     AreaChart (Axis<X> xAxis, Axis<Y> yAxis) 
	     AreaChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
	     	��� 
		 xAxis - ������ ������ ������ CategoryAxis ��� ��� �
		 yAxis - ������ ������ ������ NumberAxis ��� ��� �     ��� �������� ��� �������������� �����������
         data - ������ � ������������� �������	*/
			NumberAxis xAxis5 = new NumberAxis();
			NumberAxis yAxis5 = new NumberAxis();
			AreaChart<Number, Number> areaChart = new AreaChart<Number, Number>(xAxis5, yAxis5);
			areaChart.setTitle("AreaChart");						// ��������� ���������
			areaChart.setTitleSide(Side.TOP);						// ������ �������������� �������� TOP, BOTTOM, LEFT, RIGHT
			areaChart.setLegendSide(Side.BOTTOM);					/* ������ ������� ���������, � ������� ����� ���������� ���� �
																   		������� �������� � ���������������� �� �������.  */
			areaChart.setLegendVisible(true);					    // ��� false ���� � ������� �� ����� ������������ 
			areaChart.setAnimated(true);							// ��� true ��������� �������� ����� ����������� � ���������, �  �� �����
			areaChart.setHorizontalGridLinesVisible(true);     	   // ������ ��������� �������������� �����
			areaChart.setVerticalGridLinesVisible(true);   		   	// ������ ��������� ������������ �����
			areaChart.setHorizontalZeroLineVisible(true);			/* ��� true ��� ������� � �������������, � ������������� ��������
																 		����� ��������� ���.�������������� ����� ��� �������� �������� */
			areaChart.setVerticalZeroLineVisible(true);				/* ��� true ��� ������� � �������������, � ������������� ��������
																 		����� ��������� ���.������������ ����� ��� �������� �������� */
			areaChart.setAlternativeColumnFillVisible(true);		// ��� true �������������� ������������ ������� ����� ����� �������
			areaChart.setAlternativeRowFillVisible(true);			// ��� true �������������� �������������� ������ ����� ����� �������
			areaChart.setMinWidth(200);
			areaChart.setMinHeight(200);
			
			XYChart.Series<Number, Number> series7 = new XYChart.Series<>();
			series7.setName("FIRST");             
			series7.getData().add(new XYChart.Data<Number, Number>(10,10));
			series7.getData().add(new XYChart.Data<Number, Number>(30,50));
			series7.getData().add(new XYChart.Data<Number, Number>(40,80));
			series7.getData().add(new XYChart.Data<Number, Number>(50,90));
			areaChart.getData().add(series7);
			
/* -------------------------����� StackedAreaChart<X,Y>   �������� ������ � �������� �������	
  ������� ������������ ����� �������, ����� ������ ����� ������ ���������, �� �� ����������� ���������� ����� ������
	  Object - Node - Parent - Region - Chart - XYChart<X,Y> - StackedAreaChart<X,Y>
	     	������������
      StackedAreaChart (Axis<X> xAxis, Axis<Y> yAxis) 
      StackedAreaChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
     	��� 
	 xAxis - ������ ������ ������ CategoryAxis ��� ��� �
	 yAxis - ������ ������ ������ NumberAxis ��� ��� �     ��� �������� ��� �������������� �����������
     data - ������ � ������������� �������	*/
			NumberAxis xAxis6 = new NumberAxis();
			NumberAxis yAxis6 = new NumberAxis();
			StackedAreaChart<Number, Number> stackedAreaChart = new StackedAreaChart<Number, Number>(xAxis6, yAxis6);
			stackedAreaChart.setTitle("StackedAreaChart");				// ��������� ���������
			stackedAreaChart.setTitleSide(Side.TOP);					// ������ �������������� �������� TOP, BOTTOM, LEFT, RIGHT
			stackedAreaChart.setLegendSide(Side.BOTTOM);				/* ������ ������� ���������, � ������� ����� ���������� ���� �
																		   ������� �������� � ���������������� �� �������.  */
			stackedAreaChart.setLegendVisible(true);					// ��� false ���� � ������� �� ����� ������������ 
			stackedAreaChart.setAnimated(true);							// ��� true ��������� �������� ����� ����������� � ���������, �  �� �����
			stackedAreaChart.setHorizontalGridLinesVisible(true);     	// ������ ��������� �������������� �����
			stackedAreaChart.setVerticalGridLinesVisible(true);   	   	// ������ ��������� ������������ �����
			stackedAreaChart.setHorizontalZeroLineVisible(true);		/* ��� true ��� ������� � �������������, � ������������� ��������
																 		����� ��������� ���.�������������� ����� ��� �������� �������� */
			stackedAreaChart.setVerticalZeroLineVisible(true);			/* ��� true ��� ������� � �������������, � ������������� ��������
																 		����� ��������� ���.������������ ����� ��� �������� �������� */
			stackedAreaChart.setAlternativeColumnFillVisible(true);		// ��� true �������������� ������������ ������� ����� ����� �������
			stackedAreaChart.setAlternativeRowFillVisible(true);		// ��� true �������������� �������������� ������ ����� ����� �������
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

/* -------------------------����� ScatterChart<X,Y>   ���������, � ������� ����� ������������ ���������� ���������
	  	Object - Node - Parent - Region - Chart - XYChart<X,Y> - ScatterChart<X,Y>
		     	������������
		  ScatterChart (Axis<X> xAxis, Axis<Y> yAxis) 
		  ScatterChart (Axis<X> xAxis, Axis<Y> yAxis, ObservableList<XYChart.Series<X,Y> data)
		    	��� 
		  xAxis - ������ ������ ������ CategoryAxis ��� ��� �
		  yAxis - ������ ������ ������ NumberAxis ��� ��� �     ��� �������� ��� �������������� �����������
		  data - ������ � ������������� �������	*/
		NumberAxis xAxis7 = new NumberAxis();
		NumberAxis yAxis7 = new NumberAxis();
		ScatterChart<Number, Number> scatterChart = new ScatterChart<Number, Number>(xAxis7, yAxis7);
		scatterChart.setTitle("ScatterChart");					// ��������� ���������
		scatterChart.setTitleSide(Side.TOP);					// ������ �������������� �������� TOP, BOTTOM, LEFT, RIGHT
		scatterChart.setLegendSide(Side.BOTTOM);				/* ������ ������� ���������, � ������� ����� ���������� ���� �
																   ������� �������� � ���������������� �� �������.  */
		scatterChart.setLegendVisible(true);					// ��� false ���� � ������� �� ����� ������������ 
		scatterChart.setAnimated(true);							// ��� true ��������� �������� ����� ����������� � ���������, �  �� �����
		scatterChart.setHorizontalGridLinesVisible(true);     	// ������ ��������� �������������� �����
		scatterChart.setVerticalGridLinesVisible(true);   	   	// ������ ��������� ������������ �����
		scatterChart.setHorizontalZeroLineVisible(true);		/* ��� true ��� ������� � �������������, � ������������� ��������
															 		����� ��������� ���.�������������� ����� ��� �������� �������� */
		scatterChart.setVerticalZeroLineVisible(true);			/* ��� true ��� ������� � �������������, � ������������� ��������
															 		����� ��������� ���.������������ ����� ��� �������� �������� */
		scatterChart.setAlternativeColumnFillVisible(true);		// ��� true �������������� ������������ ������� ����� ����� �������
		scatterChart.setAlternativeRowFillVisible(true);		// ��� true �������������� �������������� ������ ����� ����� �������
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
