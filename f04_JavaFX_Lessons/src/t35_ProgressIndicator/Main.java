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
		
/*------------------------------------- ����� PROGRESS INDICATOR--------------------------------------------------------------------
		 ����� ProgressIndicator ��������� ��������� ���� �������� � ����� �����, ������ �������� ������� ������ � ���� ���������
		 Object - Node - Parent- Region - Control - ProgressIndicator		*/
		
			// ������������
		ProgressIndicator prIndic1 = new ProgressIndicator();	/* ������� ��������� � �������������� ���������. ������ ����������
			����� ��������� �� ����� ������������ ��������, ��������� ��� ���������� ��������  � ���������. ���-��� �����.	
			����������, ���� ���������� ��������� ������ �� ����� � ���������� ����� ���������� */

		ProgressIndicator prIndic2 = new ProgressIndicator(0.5);  // ��������� ������ � ���� ������������� ����� 
		
			// �� ������� ��������� ���������� �� ������������ ��� false
		prIndic2.setVisible(true);	
		
			// ��������� ������������� �������  ����������
		prIndic2.setProgress(0.6);
			
			// ��������� ������������� �������  ����������
		prIndic1.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
		
			// �������� ��������
		prIndic1.setMinHeight(60);   prIndic1.setMinWidth(100);
		prIndic2.setMinHeight(60);   prIndic2.setMinWidth(100);
		
			// ��������� �� ���������� ������ ������� �� ������ �/��� ����������� ������ ������
		prIndic1.setStyle("-fx-label-padding: 5.0px;");
				
			// ��������� ���� � ����� ������ ������
		prIndic1.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
		
/*----------------------------------------- ����� PROGRESS BAR-----------------------------------------------------------------------
		 ����� ProgressIndicator ��������� ��������� ���� �������� � ����� �����, ������ �������� ������� ������ � ���� ���������
		 Object - Node - Parent- Region - Control - ProgressIndicator - ProgressBar		*/
		
			// ������������
		ProgressBar prBar1 = new ProgressBar();	/* ������� ��������� � �������������� ���������. ������ ����������
			����� ��������� �� ����� ������������ ��������, ��������� ��� ���������� ��������  � ���������. ���-��� �����.	
			����������, ���� ���������� ��������� ������ �� ����� � ���������� ����� ���������� */

		ProgressBar prBar2 = new ProgressBar(0.5);  // ��������� ������ � ���� ������������� ����� 
		
			// ��������� ������������� �������  ����������
		prBar2.setProgress(0.6);
			
			// ��������� ������������� �������  ����������
		prBar1.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
		
			// �������� ��������
		prBar1.setMinHeight(60);   prBar1.setMinWidth(100);
		prBar2.setMinHeight(60);   prBar2.setMinWidth(100);
		
			// ��������� �� ���������� ������ ������� �� ������ �/��� ����������� ������ ������
		prBar1.setStyle("-fx-label-padding: 5.0px;");
				
			// ��������� ���� � ����� ������ ������
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