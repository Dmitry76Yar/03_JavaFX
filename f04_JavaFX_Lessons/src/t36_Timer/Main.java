package t36_Timer;
	
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

class MyTimerTask extends TimerTask {
	private Label lbl; 
	public MyTimerTask (Label lbl) {
		this.lbl = lbl;
	}
	@Override
	public void run() {
		Platform.runLater(() -> {
			lbl.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		});
	}
}

public class Main extends Application {
	/* ������ ��������� ����� ������������ �������� ������� ��������� �����-���� ������. 
	 * �������� �������� �������� ����������� ������� � �������� �� �������	 */
	private Timer timer;
	
		@Override 
	public void start(Stage primaryStage) throws Exception {	
			// ���� ������ �������� ���� ����� ��� ����������� ������� �� �������
		VBox root = new VBox();		root.setAlignment(Pos.CENTER);
		Label lbl= new Label("");	lbl.setStyle("-fx-font-size: 40 pt");
	
				/* ������������
		 - Timer() 
		 - Timer(boolean isDaemon)
		 - Timer(String name)
		 - Timer(String name, boolean isDaemon)
		 	���� isDaemon = true, �� ����� � �������� ����� �����-�������. �����-����� ������������� ����������� (� ����� ������ �
		 ����������) ��� ���������� ������� �������, ����� ��� ������� ����� � �������� ���������� ��������� ����� ������� (�����
		 cancel()), ����� ����� �������� ���� ���� ���������� �� ��������� �����������. 	 */
			
				/* ����� SCHEDULE() ������ Timer
		 - void schedule (TimerTask task, Date time) 					- ����������� ���������� ������ � ������������ �����
		 - void schedule (TimerTask task, Date firstTime, long period)  - ������������ ���������� ������ �� ������� � firstTime 
		  																� �������� ����� ������������ = period
		 - void schedule (TimerTask task, long delay)					- ����������� ���������� ������ ����� ������������ ��������
		 - void schedule (TimerTask task, long delay, long period)		- ������������ ���������� ������ ����� ������������ �������� 
		  																� �������� ����� ������������ = period	
		  ����� ����������� ����� Timer � �������������� ����������� ����� run(), ��� ������ ���� ����� ����������� ��� 
		  � ������ �������, ��� ���������� �������������. ��� ���������� ����� ������� ����� cancel()  */
			
				/* ������ � ����� PANE �� �������
		 ��� ��� ������ ����������� � ����������� ������, �� �������� ������ �������� ����� �� ��������� - �������� ����� �����
		 ������ ������ �� ������ ���������� ��������� ������� (Java FX Application Thread). � ��������� ������ - ������� ������
		 IllegalStateException.
		 ����� �������� ������ � ����� �� �������, ����� ������� ������ (��������� Runnable) � �������� �� ������������ ������
		 runLater() �� ������ Platform. ����� ���������� ������   */
			
		timer = new Timer(true);
		timer.schedule(new MyTimerTask(lbl), 0, 1000);
		root.getChildren().addAll(lbl);
	
		Scene scene = new Scene(root, 400, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("���� � ��������� �� �������");
		primaryStage.show();		
	}
		@Override					// ���������� ���������, ���� Timer �� �������� �����-�������
	public void stop() {
		timer.cancel();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
