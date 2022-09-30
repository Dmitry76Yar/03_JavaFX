package t21_JavaFX_Properties_Bound_events;
	
import java.text.NumberFormat;
import java.util.Locale;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.event.*;
import javafx.geometry.Insets;

public class Main extends Application  {
	Button button, button2;
	Label lbl;
	TextField txtField, txtField1, txtField2 ;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {			
		button = new Button();			button.setText("BUTTON");				
		button2 = new Button();			button2.setText("BUTTON2");
		lbl = new Label("LABEL");		
		txtField = new TextField();		txtField.setMinWidth(70);	txtField.setMaxWidth(70);	txtField.setPromptText("Enter ");		
		txtField1 = new TextField();	txtField1.setMinWidth(70);	txtField1.setMaxWidth(70);	txtField1.setPromptText("Enter2 ");
		txtField2 = new TextField();	txtField2.setMinWidth(70);	txtField2.setMaxWidth(70);	txtField2.setPromptText("Enter2 ");
		Slider slider = new Slider(0, 100, 0); 				Slider slider1 = new Slider(0, 100, 0);
		Slider slider2 = new Slider(0, 100, 0); 			Slider slider3 = new Slider(0, 100, 0);
		Slider slider4 = new Slider(0, 100, 0); 			Slider slider5 = new Slider(0, 100, 0);
		Rectangle rectan = new Rectangle(50,50,Color.BEIGE);		
		rectan.setStroke(Color.BLACK);				// ���� �������
		rectan.setStrokeWidth(3.0);				// ������� �������
		
/*-----------------------����������� �� ������ JAVAFX PROPERTIES-------------------------------------------------------
 		JavaFX-�������� ����� ��������� ����������, ������� ����� ���������� ��� ��������� �������� ��������.
 		����� ����������� ������ ����������� ���� ��������� InvalidationListener ��� ChangeListener<T>
 		
 					INVALIDATION LISTENER
 		��������� InvalidationListener ��������� ������� ��������������� �������� �������� � ����� ���� ����� invalidated() 
 		������ ��� ���������� � �������� ����������� ������� ��������������� ����������� � ���������� Obversable, ������� ��������
 		  - ����� addListener() ��� ���������� �����������
 		  - ����� removeListener() ��� �������� �����������. 
 			 	���������� ����� ������ ������ ��� ������ ��������� ��������, � ����� �� ���������� �� �����, ���� �� �� ������� �������� 
 		 ����������� �������� ��������. ��� ������� � "�������" �����������, ����� �������� �������� ��������������� �� ����� �����
 		 ���������, � ������ ��� ������� �������� �������� ��������		 		 
 		 	 ����� ��������� ���������� ����� ��� ���� � ��������� ������� InvalidationListener � ��������������� ������ invalidated() ��� 
 		 ����� ��� � ������-����������, �.�. ��������� InvalidationListener �������� ��������������.		 		 	 */
		InvalidationListener invListener = new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
//				System.out.println(" ������  Scene ���a �������a");
			}
		};
		primaryStage.widthProperty().addListener(invListener);
			// ��� �������� ����������� �����
//		primaryStage.widthProperty().removeListener(invListener);
		
			/* ����������� ��������� ����� ������-���������
		����� ����� �������, ���, �.�. ������ �� ���������� �� ����������� �� ��������� ������-���������, �� ������� ���������� �� ��������� 			 */
		primaryStage.widthProperty().addListener(observable -> {
//			System.out.println(" ������  Scene ���a �������a   ������-���������");
//			System.out.println(primaryStage.getWidth());
		});

/*							CHANGE LISTENER																
  		�������������� ��������� ChangeListener<T> ��������� ������� ��������� �������� ��������. 
  		�� �������� ����� void changed(ObversableValue<? extends T> obversable, T oldValue, T newValue)
  		������ ����������� ������� ����������� � ���������� ObversableValue, ������� ��������
 		  - ����� addListener() ��� ���������� �����������
 		  - ����� removeListener() ��� �������� �����������.
 		  - ����� getValue() ��� �������� ������ �������� 
  		����� �������� ObversableValue �������� ������, ��� �� ���������� ObversableValue, ��� � �� ���������� Obversable, �.�.
  		ObversableValue �������� ����������� Obversable.
  		�������� oldValue - �������� ������ �������� ��������, newValue - �����
  			�����, ��� ����� ���������� ��� ����� ��������� �������� �������� � �� ������� �� "�������" ����������		
  		����� ��������� ���������� ����� ��� ���� � ��������� ������� ChangeListener � ��������������� ������ chaged() ��� 
 		 ����� ��� � ������-����������, �.�. ��������� ChangeListener �������� ��������������.		 	*/
		ChangeListener<? super Number> changeList = new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("������ stage ���������� � " + oldValue + "  �� " + newValue);
			}
		};
		primaryStage.widthProperty().addListener(changeList);
			// ��� �������� ����������� �����
//		primaryStage.widthProperty().removeListener(changeList);
		
			/* ����������� ��������� ����� ������-���������
		����� ����� �������, ���, �.�. ������ �� ���������� �� ����������� �� ��������� ������-���������, �� ������� ���������� �� ��������� 			 */
		primaryStage.widthProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("����� ������-��������� ������ stage ���������� � " + oldValue + "  �� " + newValue);
		});

/*------------------------------------���������������� ���������------------------------------------------------------------------
 		�� ����� ������� �������� ������ �������� �� ��������� ������� ��������. ���� ��������� �������� ������� ��������, ��
 		��������� � �������� ������� �������� */
			// ��������� �������� �������� � ��������� ������ ��������������
		slider.valueProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("�������� �������� ���������� � " + oldValue + " �� " + newValue);
			rectan.setWidth((Double)newValue);
		});
			// ��������� �������� ������ �������������� ��� ����� �������� � TextField ������ ��������
		txtField.textProperty().addListener((listener, oldValue, newValue) -> {
			System.out.println("���������� ������� �� txtField c " + oldValue + "  �� " + newValue);
			rectan.setWidth(Double.parseDouble(newValue));
		});
			/* ����� bindBidirectional(Property other) ������������� ���������������� ����� ��������� �������� � ������ ��������������
		���� ����� �������� � ���������� Property<T>, ������� ��������� ��� �������� � JAVAFX	*/
		rectan.widthProperty().bindBidirectional(slider.valueProperty());	
		
			/* ��������������� �� ������ �������� Properties
		� ������� ���� ��������������� ������ �� TextField � ����� ���������� ����� parse(), �� � Properties ���� ���� ����������
		� ������� ���� ��� 3 ������ ����� ������������ ������ ������� ������ bindBidirectional()
			- void bindBidirectional(Property<T> other, StringConverter<T> converter)
			- void bindBidirectional(Property<?> other, Format format)  
		 	����������� �����  StringConverter ��������� ������ ����� ����� �����������: BooleanStringConverter, NumberStringConverter,
		 IntegerStringConverter, DoubleStringConverter, DateTimeStringConverter, LocalDateTimeStringConverter....
		 	���������� ����� Format ��������� ����� �������: NumberFormat, DateFormat, MessageFormat...		*/
		txtField1.textProperty().bindBidirectional(slider1.valueProperty(), new NumberStringConverter());
//		txtField1.textProperty().bindBidirectional(slider1.valueProperty(), NumberFormat.getInstance());

			// ������ ���������������� �����
//		txtField1.textProperty().unbindBidirectional(slider1.valueProperty());
		
/*------------------------------------���������������� ���������------------------------------------------------------------------
 		������ ���� ���������� ���������������� ���������� ���� ���������	 - ��� ��������� �������� slider3 
 		����� ���������� ��������� �������� slider2
 		��� ���� ��������� �������� slider2 ����� ������� ����� ������ � ���������� ������  */
		System.out.println("�������� slider2 ������ " + slider2.valueProperty().isBound());
		slider2.valueProperty().bind(slider3.valueProperty());		// ����������
		System.out.println("�������� slider2 ������ " + slider2.valueProperty().isBound());
		
//		button.disabledProperty().bind(txtField.textProperty());
			
			// ������ ��������������� �����
//		slider2.valueProperty().unbind();
		
/*------------------------------------��������� � ��������� ���������� �������------------------------------------------------------------------
   �������� ��� ���� ������, ����� �����, ����� �������� ������ �������� ���������� �� �������� ������� �� �����-���� �����.
   ��������, ����� �������� ������� �������� ���� ������ ������ �� 30, ��� �������� ������� ��������
   � ���� ������ ������� ���������: BooleanExpresion, IntegerExpression, LongExpression, DoubleExpression, StringExpression, ObjectExpression */
		slider4.valueProperty().bind(slider5.valueProperty().subtract(30));		// ���������� � ��������� 30
		slider4.valueProperty().bind(slider5.valueProperty().multiply(1.2));	// ���������� � ���������
		slider4.valueProperty().bind(slider5.valueProperty().divide(1.2));		// ���������� � �������
//		slider4.valueProperty().bind(slider5.valueProperty().negate());			// �������� ���� �� ���������������
		slider4.valueProperty().bind(slider5.valueProperty().add(30));			// ���������� � ���������� 30

/* -------------------------------------�������������� �������� � ���������------------------------------------------------------
 		int property.intValue()
 		long property.longVaue()
 		float property.floatValue()
 		double property.doubleValue()		 */
		
/* -------------------------------------�������� ��������� �������------------------------------------------------------
 	� ������ NumberExpression, ������������ �������� �������� IntegerExpression, LongExpression, DoubleExpression...., ����������
 	������ ���������: greatherThan(),  greatherThanOrEqual(), isEqualTo(), isNotEqualTo(), lessThan(), lessThanOrEqualTo()  */
		DoubleProperty property = new SimpleDoubleProperty(20);
		System.out.println("Property greather than 30 --" + property.greaterThan(30).get());
		System.out.println("Property less than 30 --" + property.lessThan(30).get());
		System.out.println("Property equal to 30 --" + property.isEqualTo(30).get());
		
		StringProperty strProperty = new SimpleStringProperty("STRING");
		System.out.println("Is this string null " + strProperty.isEmpty().get());
		System.out.println("Isn't this string null " + strProperty.isNotEmpty().get());
		System.out.println("Is strProperty null = " + strProperty.isNull());
		System.out.println("Isn't strProperty null = " + strProperty.isNotNull());
		System.out.println("strProperty greather than STRING! --" + strProperty.greaterThan("STRING!").get());
		System.out.println("strProperty equal to STRING! --" + strProperty.isEqualTo("STRING!").get());
		
			// ������ �� ����� ��������, ���� ��� ������ � txtField
		button2.disableProperty().bind(txtField2.textProperty().isEmpty());

/*--------------------------------------������ �������� ��������---------------------------------------------------------*/
		DoubleProperty property1 = new SimpleDoubleProperty(20.01233);
		System.out.println("Value of property = " + property1.doubleValue());			// 20.01233
		System.out.println("Value of property = " + property1.toString());				// 20.01233
		System.out.println("Value of property = " + property1.asString().get());		// 20.01233
		System.out.println("Value of property = " + property1.asString("%.2f").get());	// 20,01
		System.out.println("Value of property = " + property1.asString(new Locale("en","US"), "%.2f").get());	// 20.01
		
		StringProperty strProperty1 = new SimpleStringProperty("STRING");
		System.out.println("Value of strProperty = " + strProperty1.get());
		System.out.println("Value of strProperty = " + strProperty1.getValueSafe());		// � ������� �� get(), ���� ������ ������,��
				// �������� ������ ������ ������, �� �� null
		
		
/*--------------------------------------������ �������� ��������---------------------------------------------------------*/		
		System.out.println("Is this string null " + strProperty.isEmpty().get());
		System.out.println("Isn't this string null " + strProperty.isNotEmpty().get());
		
		
			// ��������� ��������� � ������� ����     xProperty  � yProperty   
		primaryStage.xProperty().addListener((listener, oldValue, newValue) -> {
//			System.out.println("���������� � ������ �������� ���� ���� ���������� � " + oldValue + "  �� " + newValue);
		});
		
		HBox hbox = new HBox(10);	hbox.setPadding(new Insets(10));
		HBox hbox1 = new HBox(10);	hbox1.setPadding(new Insets(10));
		HBox hbox2 = new HBox(10);	hbox2.setPadding(new Insets(10));
		HBox hbox3 = new HBox(10);	hbox3.setPadding(new Insets(10));
		HBox hbox4 = new HBox(10);	hbox4.setPadding(new Insets(10));
		HBox hbox5 = new HBox(10);	hbox5.setPadding(new Insets(10));
		Group group = new Group(); 		group.getChildren().addAll(txtField);
		hbox.getChildren().addAll(button, lbl, slider, group);
		hbox1.getChildren().addAll(rectan);
		hbox2.getChildren().addAll(slider1, txtField1);
		hbox3.getChildren().addAll(slider2, slider3);
		hbox4.getChildren().addAll(slider4, slider5);
		hbox5.getChildren().addAll(button2, txtField2);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(hbox, hbox1, hbox2, hbox3, hbox4, hbox5);
		
		Scene scene = new Scene(vbox, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
