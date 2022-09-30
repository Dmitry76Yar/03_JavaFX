package t34_Slider;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.converter.NumberStringConverter;

/* Slider - ����� � ���������, ������� ����� ����� �������������� � ������������ ����������
������������: Object - Node - Parent- Region - Control - Slider		*/

public class Main extends Application {
	Slider slider1, slider2, slider3, slider4, slider5, slider6;
	Stage stage;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
			// ������������
		slider1 = new Slider();
		slider2 = new Slider(0, 100, 0);		//(min, max, current)
			
			// �������� ��������
		slider1.setMinHeight(60);   slider1.setMinWidth(100);
		slider2.setMinHeight(60);   slider2.setMinWidth(100);
		
			// ������� ����������
		slider1.setOrientation(Orientation.HORIZONTAL);
		
			// ��������� ������������ � ������������� ��������� ��������
		slider1.setMin(0.0);    slider1.setMax(100.0);
		
			// ��������� �� ���������� ������ ������� �� ������ �/��� ����������� ������ ������
		slider1.setStyle("-fx-label-padding: 5.0px;");
				
			// ��������� ���� � ����� ������ ������
		slider1.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
				
			// ���������  ����� ��� ���������
		slider2.setShowTickLabels(true);	// ��� true, ������������ �������� �������� ����� �����
		slider2.setShowTickMarks(true);		// ��� true, ������������ ����� �����
		slider2.setMajorTickUnit(10);		// ������ �������� ����� �������� �������
		slider2.setMinorTickCount(5);		// ������ �������� ����� ���������������� �������
//		slider2.setLabelFormatter(new StringConverter<Double>());	// ������ ������ ������������� ����� � ������ ��� �����
		
			// ������������ �������� �� ������
		slider2.setSnapToTicks(true);
		
			// ������� ��������� ��������� �������� �������� ��� ������� �� ������� ����� � ������
		slider2.setBlockIncrement(5.0);
		
			// ���������� � ���������� �� ��������, ��������� � setBlockIncrement()
		slider2.increment();
		slider2.decrement();
		
			// �������� �������� ��������
		System.out.println(slider1.getValue());
		
			// ������������ �������� ��������
		slider1.valueProperty().addListener((obj, oldValue, newValue) -> {
				/* setValueChanging(true) �������� true, ���� ������������ � ������ ������ ���������� ��������
				 � false, ���� ����������� �������� ���������				 */
			if (slider1.isValueChanging() == false) {
				System.out.println("�������� �������� ���������� � " + oldValue + " �� " + newValue); 
			}
		});
		
		/*------------------------------------���������������� ���������------------------------------------------------------------------
 		�� ����� ������� �������� ������ �������� �� ��������� ������� ��������. ���� ��������� �������� ������� ��������, ��
 		��������� � �������� ������� �������� */
			/* ����� bindBidirectional(Property other) ������������� ���������������� ����� ��������� ��������1 � ��������2
		���� ����� �������� � ���������� Property<T>, ������� ��������� ��� �������� � JAVAFX	*/
		slider1.valueProperty().bindBidirectional(slider2.valueProperty());	
			
			// ������ ���������������� �����
//		slider1.textProperty().unbindBidirectional(slider2.valueProperty());
		
			/* ��������������� �� ������ �������� Properties
		� ������� ���� ��������������� ������ �� TextField � ����� ���������� ����� parse(), �� � Properties ���� ���� ����������
		� ������� ���� ��� 3 ������ ����� ������������ ������ ������� ������ bindBidirectional()
			- void bindBidirectional(Property<T> other, StringConverter<T> converter)
			- void bindBidirectional(Property<?> other, Format format)  
		 	����������� �����  StringConverter ��������� ������ ����� ����� �����������: BooleanStringConverter, NumberStringConverter,
		 IntegerStringConverter, DoubleStringConverter, DateTimeStringConverter, LocalDateTimeStringConverter....
		 	���������� ����� Format ��������� ����� �������: NumberFormat, DateFormat, MessageFormat...		*/
		TextField txtField1 = new TextField();  
		txtField1.textProperty().bindBidirectional(slider1.valueProperty(), new NumberStringConverter());
			
/*------------------------------------���������������� ���������------------------------------------------------------------------
 		������ ���� ���������� ���������������� ���������� ���� ���������	 - ��� ��������� �������� slider3 
 		����� ���������� ��������� �������� slider2
 		��� ���� ��������� �������� slider2 ����� ������� ����� ������ � ���������� ������  */
		slider3 = new Slider();			slider4 = new Slider();
		slider3.setMinHeight(60);   slider3.setMinWidth(100);	slider4.setMinHeight(60);   slider4.setMinWidth(100);
		System.out.println("�������� slider3 ������ " + slider3.valueProperty().isBound());
		slider3.valueProperty().bind(slider4.valueProperty());		// ����������
		System.out.println("�������� slider4 ������ " + slider4.valueProperty().isBound());
		
//		button.disabledProperty().bind(txtField.textProperty());
			
			// ������ ��������������� �����
//		slider2.valueProperty().unbind();
		
/*------------------------------------��������� � ��������� ���������� �������------------------------------------------------------------------
   �������� ��� ���� ������, ����� �����, ����� �������� ������ �������� ���������� �� �������� ������� �� �����-���� �����.
   ��������, ����� �������� ������� �������� ���� ������ ������ �� 30, ��� �������� ������� ��������
   � ���� ������ ������� ���������: BooleanExpresion, IntegerExpression, LongExpression, DoubleExpression, StringExpression, ObjectExpression */
		slider5 = new Slider();			slider6 = new Slider();
		slider5.setMinHeight(60);   slider5.setMinWidth(100);	slider6.setMinHeight(60);   slider6.setMinWidth(100);
		slider5.valueProperty().bind(slider6.valueProperty().subtract(30));		// ���������� � ��������� 30
		slider5.valueProperty().bind(slider6.valueProperty().multiply(1.2));	// ���������� � ���������
		slider5.valueProperty().bind(slider6.valueProperty().divide(1.2));		// ���������� � �������
//		slider5.valueProperty().bind(slider6.valueProperty().negate());			// �������� ���� �� ���������������
		slider5.valueProperty().bind(slider6.valueProperty().add(30));			// ���������� � ���������� 30
				
		
		HBox hbox = new HBox(20, slider1, slider2, txtField1, slider3, slider4, slider5, slider6);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));		
		
		Scene scene = new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("����� �����");
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}