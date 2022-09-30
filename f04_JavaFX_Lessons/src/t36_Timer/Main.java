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
	/* Таймер позволяет через определенный интервал времени выполнять какую-либо задачу. 
	 * Типчиным примером является отображение времени с точности до секунды	 */
	private Timer timer;
	
		@Override 
	public void start(Stage primaryStage) throws Exception {	
			// НИЖЕ ПРИМЕР СОЗДАНИЯ ОКНА ЧАСОВ ДЛЯ ОТОБРАЖЕНИЯ ВРЕМЕНИ ДО СЕКУНДЫ
		VBox root = new VBox();		root.setAlignment(Pos.CENTER);
		Label lbl= new Label("");	lbl.setStyle("-fx-font-size: 40 pt");
	
				/* КОНСТРУКТОРЫ
		 - Timer() 
		 - Timer(boolean isDaemon)
		 - Timer(String name)
		 - Timer(String name, boolean isDaemon)
		 	Если isDaemon = true, то поток с таймером будем демон-потоком. Поток-демон автоматически завершается (в любой стадии э
		 выполнения) при отсутствии обычных потоков, тогда как обычный поток с таймером необходимо завершать явным образом (метод
		 cancel()), иначе после закрытия всех окон приложения он продолжит выполняться. 	 */
			
				/* МЕТОД SCHEDULE() КЛАССА Timer
		 - void schedule (TimerTask task, Date time) 					- Однократное выполнение задачи в обозначенное время
		 - void schedule (TimerTask task, Date firstTime, long period)  - Многократное выполнение задачи со стартом в firstTime 
		  																и задежкой между повторениями = period
		 - void schedule (TimerTask task, long delay)					- Однократное выполнение задачи после обозначенной задержки
		 - void schedule (TimerTask task, long delay, long period)		- Многократное выполнение задачи после обозначенной задержки 
		  																и задежкой между повторениями = period	
		  Нужно наследовать класс Timer и переопределить абстрактный метод run(), код внутри него будет выполняться при 
		  в потоке таймера, как определено конструктором. Для прерывания нужно вызвать метод cancel()  */
			
				/* ДОСТУП К УЗЛАМ PANE ИЗ ТАЙМЕРА
		 Так как таймер выполняется в собственном потоке, то напрямую менять свойства узлов не получится - свойства узлов можно
		 менять только из потока диспетчера обработки событий (Java FX Application Thread). В противном случае - получим ошибку
		 IllegalStateException.
		 Чтобы получить доступ к узлам из таймера, нужно создать задачу (интерфейс Runnable) и передать ее статическому методу
		 runLater() из класса Platform. После выполнения задачи   */
			
		timer = new Timer(true);
		timer.schedule(new MyTimerTask(lbl), 0, 1000);
		root.getChildren().addAll(lbl);
	
		Scene scene = new Scene(root, 400, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Часы с точностью до секунды");
		primaryStage.show();		
	}
		@Override					// Необходимо добавлять, если Timer не является демон-потоком
	public void stop() {
		timer.cancel();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
