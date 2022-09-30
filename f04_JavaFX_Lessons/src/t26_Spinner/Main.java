package t26_Spinner;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class Main extends Application {
	Button btn, btn2;
		@Override 
	public void start(Stage primaryStage) {		
		/* ����� Spinner<T> ��������� ��������� ����, � ������� ������������ �������� �������� �� ��������� ��� �� ������.
	���� �������� ��� ��������� ������ �� ���������, ������� ��������� ������������ �� ��������� ��� ������ � ������� ������� ����.
	������������ Object - Node - Parent - Region - Control - Spinner
	
		������������ 			
	Spinner()
	Spinner(int min, int max, int initialValue)
	Spinner(int min, int max, int initialValue, int amountToStepBy)
	Spinner(double min, double max, double initialValue)
	Spinner(double min, double max, double initialValue, double amountToStepBy)
	Spinner(ObversableList <T> items)
	Spinner(SpinnerValueFactory<T> valueFactory)	
	  ��� min � max - ����������� � ������������ �������� ���������
	      initialValue - �������� �� ��������� (���������)
	      amountToStepBy - ���, �� ������� ����� �������� �������� ��� ������� ������ �� ���������. �� ��������� - 1.0
	����������� Spinner(ObversableList <T> items) ��������� ������� ������ ��������� ��������
	����������� Spinner(SpinnerValueFactory<T> valueFactory) ��������� ������������ �������� ������������ ��������:
	new Spinner<Integer>(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,5,1) - ������������� ��� �� 0 �� 10, ����� -5, ��� 1
	new Spinner<Double>(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 10.0, 5.0, 0.5) - ������������� ��� �� 0 �� 10, ����� -5, ��� 0,5
	new Spinner<String>(new SpinnerValueFactory.ListSpinnerValueFactory<String>(FXCollections.<String>obversableArraylist(
		"red", "green", "blue")));		      		*/
	
	Spinner<Integer> spinner1 = new Spinner<Integer>();
	
		// ������� int min, int max, int initialValueint, amountToStepBy
	spinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 5));
	
	Spinner<Integer> spinner2 = new Spinner<Integer>(0, 100, 10);
	Spinner<Integer> spinner3 = new Spinner<Integer>(0, 100, 0, 5);
	
	Spinner<Double> spinner4 = new Spinner<Double>(0.0, 10.0, 0.0);
	Spinner<Double> spinner5 = new Spinner<Double>(0.0, 10.0, 10.0, 5.0);
	
	ObservableList<String> list = FXCollections.<String>observableArrayList("red", "green", "blue");
	Spinner<String> spinner6 = new Spinner<String>(list);
	
	Spinner<Integer> spinner7 = new Spinner<Integer>((new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 5)));
	
		/* �������� ����������
	STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL - ������ �� ��������� ����������� � ����� ����� ���� ������ ���� � ������ �� �����������
	STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL - ������ �� ��������� ����������� � ����� �����. ������ ���������� ������, ���������� �����
	STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL - ������ �� ��������� ����������� � ������ ����� ���� ������ ���� � ������ �� �����������
	STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL - ������ ���������� ����������� � ������ ����� ����, ���������� - � ����� ����� ����
	STYLE_CLASS_SPLIT_ARROWS_VERTICAL -  ������ ���������� ����������� ��� �����, ���������� - ��� �����
		 */
	spinner1.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);
	spinner2.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL);
	spinner3.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL);
	spinner4.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
	spinner6.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);

		// ��������� �������� �� ���������
	spinner1.getValueFactory().setValue(10);
	
		// ��������� ��������� �������� �� ���������   �������� �� �������� ���
	spinner1.increment();
	spinner1.decrement();
	
		// ��������� ��������� �� ����� 
	spinner1.getValueFactory().setWrapAround(true);
	
		// ����� ����� ���������
	spinner3.setPromptText("spinner3");
	
		// ������ �������� ����� ������ �������� ��� ����������� ������� ������ �� ��������. �� ��������� - 300 ��
	spinner2.setInitialDelay(Duration.millis(300));
	
		// ������ �������� ����� ������������ ������� �������� ��� ����������� ������� ������ �� ��������. �� ��������� - 60 ��
	spinner3.setRepeatDelay(Duration.millis(100));
	
		// ��������� ������ �� ��������� ����
	TextField txf = spinner1.getEditor();
		
		// ��������� �������� ����� ����� �������� � ����������. �������� �������� ����� ������� Enter ��� �������� � ������ �������
	 	// ����� setConverter() ������ ������, ����������� �������������� �����
	spinner3.setEditable(true);
	spinner3.getValueFactory().setConverter(new StringConverter<Integer>() {
		@Override
		public Integer fromString(String string) {
			if (string.matches("^[0-9]+$")) {
				try {
					return Integer.valueOf(string);
				}
				catch (NumberFormatException e) {
					return 0;
				}
			}
			return 0;
		}
		@Override
		public String toString(Integer obj) {
			return (obj == null) ? "0" : obj.toString();
		}
	});
		
		// ��������� �� ���������� ������ ������� �� ������ �/��� �����������
	spinner4.setStyle("-fx-label-padding: 20.0px;");	
		
			// ��������� ���� � ����� ������
	spinner4.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		
			
	HBox hbox = new HBox();		hbox.setPadding(new Insets(10));	hbox.setSpacing(20);	
	hbox.getChildren().addAll(spinner1, spinner2, spinner3, spinner4, spinner6);
	Scene scene = new Scene(hbox, 500, 500);	// ���������� the layout pane to a scene
	primaryStage.setScene(scene);				// ���������� � Stage ������� scene
	primaryStage.show();						// ����� Stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}
