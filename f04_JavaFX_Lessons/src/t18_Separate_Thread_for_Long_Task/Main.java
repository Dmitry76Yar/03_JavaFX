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
		/* Длительные операции нельзя проводить в потоке диспетчера задач JavaFX (JavaFX Application Thread)
	 Иначе окно перестанет реагировать на действия пользователя и он подумает, что приложении зависло. Поэтому ВАЖНО
	 длительные операции проводить в отдельном потоке.
	 	Также ВАЖНО, что из отдельных потоков нельзя изменять свойства компонентов напрямую. Если это нужно, то следует
	 сформировать задачу (интерфейс Runnable) и передать ее статическому методу runLater() из класса Platform.
	 	КЛАСС TASK
	 Абстрактный класс Task<V> позволяет описать одноразовую задачу для выполнения в отдельном потоке. Класс реализует интерйфейсы
	 Future<V>, RunnableFuture<V>, а также наследует класс FutureTask<V>, поэтому мы можем получить результат выполнения задачи.
	 */
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;
		
		ProgressIndicator progress = new ProgressIndicator();	// Индикатор выполнения
		progress.setProgress(0);								// Установка стартовой точки индикатора выполнения
		progress.setVisible(false);								// До запуска индикатор выполнения не отображается
		Label label = new Label("");
		Label label2 = new Label("LABEL2");
		Button btn = new Button("Запустить процесс");
		Button btnNOK = new Button("Завершить процесс");
		Button btn2 = new Button("Кнопка 2");
		
			/* Ниже пример выполнения длительной задачи в отдельном потоке с отображением результата	 */
		
		btn.setOnAction(event -> {
			btn.setDisable(true);		// Делает кнопку неактивной, чтобы пользователь не нажимал ее пока выполняется обработчик
				/* Создаем объект класса Task с параметром результаты вычисления Integer (если будет void, то возвращать нужно null) 
				Далее нужно реализовать метод call() - именно он будет выполняться в отдельном потоке
				В методе проихсодит вычисление result и искусственно сделанa задержка выполнения через Thread.sleep()	 */
			Task<Integer> task = new Task<Integer>() {
				@Override
				protected Integer call() throws Exception {
					int result = 50;					
					for (int i =0; i<101; i +=5) {
							// Установка флага прерывания потока при нажатии клавиши btnNOK
						btnNOK.setOnAction(event -> {
							cancel(true);
						});
							/* Если происходит прерывание процесса (например,  с помощью флага Cancel), то
							 вызывается метод cancelled(). Для проверки наличия флага - метод isCancelled() */
						if (isCancelled()) cancelled();	 
						
							/* В классе Task<V> существует messageProperty, которому можно присваивать значение текущего результата
							выполнения через метод updateMessage().
							Значение messageProperty нельзя напрямую отобразить, например, в label - будет ошибка выполнения.
							Чтобы значение messageProperty отобразить следует связать label.textProperty() и task.messageProperty(), 
							а также progress.visibleProperty() и task.runningProperty(), чтобы при запуске процесса идикатор стал видимым 
							а, после завершения процесса индикатор исчез									*/
						updateMessage("Текущий статус i = " + i);
//						label.setText(Double.toString(i));	// БУДЕТ ОШИБКА
						
							/* В классе Task<V> существует progressProperty, которое содержит значение для индикатора выполнения
							Для актуализации значения progressProperty вызывается метод updateProgress(double workDone, double max)
						выполнения через метод updateMessage().
						Значение progressProperty нельзя напрямую отобразить, например, через индикатор - будет ошибка выполнения.
						Чтобы значение progressProperty отобразить следует связать progress.progressProperty() индикатора и
						task.progressProperty() объекта Task перед запуском потока	 */
						updateProgress(i, 100);
//						progress.setProgress(i);	-	 БУДЕТ ОШИБКА
						
						Thread.sleep(500);			// Имитация выполнения длительного процесса
						result+=i;					// Расчет результата вычисления в потоке
					}
						/* Метод runlater() вызывается, чтобы разорвать связи и сделать кнопку снова активной
						С помощью  PauseTransition устанавливаем задержку на выполнение - не ясно зачем?
						Отвязывание важно, чтобы при повторном запуске задачи весь алгоритм сохранился 		 */
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
					updateMessage("Задача успешно завершена!");
				}
				@Override
				protected void cancelled() {
					super.cancelled();
					System.out.println("Установлен флаг прерывания ");
					btn.setDisable(false);
				}
				@Override
				protected void failed() {
					super.failed();
					System.out.println("При выполнении произошла ошибка! ");
				}
			};		// Конец определения объекта Task
			
			/* После определения объекта Task и реализации методов ниже делается связь свойств объекта Task и свойств Label и индикатора
			 для отображения статуса в реальном времени 	 */
		progress.progressProperty().bind(task.progressProperty());
		progress.visibleProperty().bind(task.runningProperty());
		label.textProperty().bind(task.messageProperty());
			
			// Обработка выполнения task при его выполнении
		task.setOnRunning(event1 -> {
			System.out.println("Процесс выполняется");
		});
		
			// Обработка выполнения task при отказе
		task.setOnFailed(event2 -> {
			System.out.println("ERROR");
		});
		
			// Обработка выполнения task при успешном завершении
		task.setOnSucceeded(event3 -> {
			System.out.println("Успешное выполнение задачи");
		});
		
			// Обработка выполнения task при умпешном завершении
		task.setOnCancelled(event4 -> {
			System.out.println("Задача отменена");
		});
		
			// Запуск потока
		Thread t = new Thread(task);
		t.setDaemon(true);
		t.start();
		});		// Конец btn.setOnAction()

			// При выполнении потока Task остальной функционал окна остается рабочим
		btn2.setOnAction(event -> {
			label2.setText("Кнопка нажата");
			System.out.println("Кнопка нажата");
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