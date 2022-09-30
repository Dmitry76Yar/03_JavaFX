package t18_Separate_Thread_for_Long_Task;
	
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.stage.*;
import javafx.util.Duration;

public class Main extends Application {
	Stage stage;
		/* ���������� �������� ������ ��������� � ������ ���������� ����� JavaFX (JavaFX Application Thread)
	 ����� ���� ���������� ����������� �� �������� ������������ � �� ��������, ��� ���������� �������. ������� �����
	 ���������� �������� ��������� � ��������� ������.
	 	����� �����, ��� �� ��������� ������� ������ �������� �������� ����������� ��������. ���� ��� �����, �� �������
	 ������������ ������ (��������� Runnable) � �������� �� ������������ ������ runLater() �� ������ Platform.
	 	����� TASK
	 ����������� ����� Task<V> ��������� ������� ����������� ������ ��� ���������� � ��������� ������. ����� ��������� �����������
	 Future<V>, RunnableFuture<V>, � ����� ��������� ����� FutureTask<V>, ������� �� ����� �������� ��������� ���������� ������.
	 */
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;
		
		ProgressIndicator progress = new ProgressIndicator();	// ��������� ����������
		progress.setProgress(0);								// ��������� ��������� ����� ���������� ����������
		progress.setVisible(false);								// �� ������� ��������� ���������� �� ������������
		Label label = new Label("");
		Label label2 = new Label("LABEL2");
		Button btn = new Button("��������� �������");
		Button btnNOK = new Button("��������� �������");
		Button btn2 = new Button("������ 2");
		
			/* ���� ������ ���������� ���������� ������ � ��������� ������ � ������������ ����������	 */
		
		btn.setOnAction(event -> {
			btn.setDisable(true);		// ������ ������ ����������, ����� ������������ �� ������� �� ���� ����������� ����������
				/* ������� ������ ������ Task � ���������� ���������� ���������� Integer (���� ����� void, �� ���������� ����� null) 
				����� ����� ����������� ����� call() - ������ �� ����� ����������� � ��������� ������
				� ������ ���������� ���������� result � ������������ ������a �������� ���������� ����� Thread.sleep()	 */
			Task<Integer> task = new Task<Integer>() {
				@Override
				protected Integer call() throws Exception {
					int result = 50;					
					for (int i =0; i<101; i +=5) {
							// ��������� ����� ���������� ������ ��� ������� ������� btnNOK
						btnNOK.setOnAction(event -> {
							cancel(true);
						});
							/* ���� ���������� ���������� �������� (��������,  � ������� ����� Cancel), ��
							 ���������� ����� cancelled(). ��� �������� ������� ����� - ����� isCancelled() */
						if (isCancelled()) cancelled();	 
						
							/* � ������ Task<V> ���������� messageProperty, �������� ����� ����������� �������� �������� ����������
							���������� ����� ����� updateMessage().
							�������� messageProperty ������ �������� ����������, ��������, � label - ����� ������ ����������.
							����� �������� messageProperty ���������� ������� ������� label.textProperty() � task.messageProperty(), 
							� ����� progress.visibleProperty() � task.runningProperty(), ����� ��� ������� �������� �������� ���� ������� 
							�, ����� ���������� �������� ��������� �����									*/
						updateMessage("������� ������ i = " + i);
//						label.setText(Double.toString(i));	// ����� ������
						
							/* � ������ Task<V> ���������� progressProperty, ������� �������� �������� ��� ���������� ����������
							��� ������������ �������� progressProperty ���������� ����� updateProgress(double workDone, double max)
						���������� ����� ����� updateMessage().
						�������� progressProperty ������ �������� ����������, ��������, ����� ��������� - ����� ������ ����������.
						����� �������� progressProperty ���������� ������� ������� progress.progressProperty() ���������� �
						task.progressProperty() ������� Task ����� �������� ������	 */
						updateProgress(i, 100);
//						progress.setProgress(i);	-	 ����� ������
						
						Thread.sleep(500);			// �������� ���������� ����������� ��������
						result+=i;					// ������ ���������� ���������� � ������
					}
						/* ����� runlater() ����������, ����� ��������� ����� � ������� ������ ����� ��������
						� �������  PauseTransition ������������� �������� �� ���������� - �� ���� �����?
						����������� �����, ����� ��� ��������� ������� ������ ���� �������� ���������� 		 */
					Platform.runLater (() -> {
						PauseTransition pause = new PauseTransition(Duration.millis(200.0)); 
						pause.setOnFinished(event -> {
							progress.progressProperty().unbind();
							label.textProperty().unbind();
							progress.visibleProperty().unbind();
							btn.setDisable(false);
						});
						pause.play();
					});
					return result;
				}
				@Override
				protected void succeeded() {
					super.succeeded();
					System.out.println("result = " + getValue());
					updateMessage("������ ������� ���������!");
				}
				@Override
				protected void cancelled() {
					super.cancelled();
					System.out.println("���������� ���� ���������� ");
					btn.setDisable(false);
				}
				@Override
				protected void failed() {
					super.failed();
					System.out.println("��� ���������� ��������� ������! ");
				}
			};		// ����� ����������� ������� Task
			
			/* ����� ����������� ������� Task � ���������� ������� ���� �������� ����� ������� ������� Task � ������� Label � ����������
			 ��� ����������� ������� � �������� ������� 	 */
		progress.progressProperty().bind(task.progressProperty());
		progress.visibleProperty().bind(task.runningProperty());
		label.textProperty().bind(task.messageProperty());
			
			// ��������� ���������� task ��� ��� ����������
		task.setOnRunning(event1 -> {
			System.out.println("������� �����������");
		});
		
			// ��������� ���������� task ��� ������
		task.setOnFailed(event2 -> {
			System.out.println("ERROR");
		});
		
			// ��������� ���������� task ��� �������� ����������
		task.setOnSucceeded(event3 -> {
			System.out.println("�������� ���������� ������");
		});
		
			// ��������� ���������� task ��� �������� ����������
		task.setOnCancelled(event4 -> {
			System.out.println("������ ��������");
		});
		
			// ������ ������
		Thread t = new Thread(task);
		t.setDaemon(true);
		t.start();
		});		// ����� btn.setOnAction()

			// ��� ���������� ������ Task ��������� ���������� ���� �������� �������
		btn2.setOnAction(event -> {
			label2.setText("������ ������");
			System.out.println("������ ������");
		});
		
		HBox hbox = new HBox(20, btn, label, progress, btnNOK, btn2, label2);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));		
		
		Scene scene = new Scene(hbox, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Progress Indicator");
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}