package t60_Audio_Video;
	
import java.io.File;
import java.net.URI;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaErrorEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Track;


public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) {	
			
/*------------------------------ОСНОВНЫЕ ПРИНЦИПЫ---------------------------------------------------------------------
   НУЖНО ДОБАВИТЬ В VM --add-modules=javafx.controls,javafx.fxml,javafx.web,javafx.media
   Run configurations - (x)-Arguments - VM arguments 
   
   
 
	Для воспроизведения аудио и видео нужно
	 - создать объект Media с ресурсом
	 - Создать объект MediaPleer и передать ему этот ресурс
	 - Создать объект MediaView  и передать ему объект плеера (для аудио этот шаг можно пропустить)
	 - Добавить объект MediaView в граф сцены (для аудио этот шаг можно пропустить)
	 - Настроить параметры воспроизведения и вызвать метод play() объекта плеера
	Для простоты для воспроизведения аудио можно также воспользоваться классом AudioClip, но следует помнить, что
	он всегда загружает ресурс целиком в память, а не читает его по частям в буфер*/		
			
/*------------------------------КЛАСС AudiClip  Воспроизведение аудио-------------------------------------------------
	  Класс  AudioClip позволяет загружать аудиофайлы по протоколам: HTTP, HTTPS, FILE, JAR и воспроизводить их
	  Object - AudioClip
	  		Конструктор
	  AudioClip(String source)	
	  	где source - интернет-адрес (URL) с протоколом HTTP, HTTPS, FILE, JAR и полным путем к файлу
	  При ошибке загрузки генерится исключение IllegalArgumentException или MediaException
	  Путь URI - путь который может быть открыт из браузера		*/
			
			// 1-ый способ загрузки аудио, по абсолютному адресу через Path.get()
	AudioClip audioClip1;
	try {
		Path path = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\f04_JavaFX_Lessons\\src\\img\\dvoynoy-schelchok-myishi.wav");
		URI uriPath = path.toUri();
		audioClip1 = new AudioClip(uriPath.toString());
	} catch (Exception e) {
		System.out.println("Не найден файл");
		return;
	}
	Button btn1 = new Button("AudioClip1");
	btn1.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			audioClip1.play();
		}
	});
		
			// 2-ой способ загрузки аудио, по относительному пути через Path.get()
	AudioClip audioClip2;
	try {
		Path path = Paths.get("src\\img\\dvoynoy-schelchok-myishi.wav");
		Path absolutePath = Paths.get(System.getProperty("user.dir")  + File.separator + path.toString());
		URI uriPath = absolutePath.toUri();
		audioClip2 = new AudioClip(uriPath.toString());
	} catch (Exception e) {
		System.out.println("Не удалось загрузить аудио с диска");
		return;
	}
	Button btn2 = new Button("AudioClip2");
	btn2.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			audioClip2.play();
		}
	});		

			// 3-ий способ загрузки аудио, через this.getClass().getResource("/img/dvoynoy-schelchok-myishi.wav").toExternalForm() 
	AudioClip audioClip3; 
//		= new AudioClip(this.getClass().getResource("/img/dvoynoy-schelchok-myishi.wav").toExternalForm());
		try {
			String path = this.getClass().getResource("/img/maksim-znaesh-li-ty.mp3").toExternalForm();
			audioClip3 = new AudioClip(path);
		} catch (Exception e) {
			System.out.println("Не удалось загрузить аудио с диска");
			return;
		}
		Button btn3 = new Button("AudioClip3");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!audioClip3.isPlaying()) audioClip3.play();
			}
		});
		
			// МЕТОДЫ AudioClip
		System.out.println(" Источник аудио - " + audioClip3.getSource());		// возвращает адрес источника
		System.out.println(" Воспроизводится? - " + audioClip3.isPlaying());	// true, если аудио воспроизводится
			// Метод STOP останавливает воспроизведение
		Button btn4 = new Button("Stop AudioClip3");					
		btn4.setOnAction(event -> {
				if (audioClip3.isPlaying()) audioClip3.stop();
		});
			/* Метод Play имеет 3 варианта
		void play() 																	- настройки по умолчанию
		void play(double volume)
		void play (double volume, double balance, double rate, double pan, int priority)
			где volume - громкость 
				balance - баланс право - лево, от -1 до +1, по умолчнаию - 0
				pan - "центр" клипа. В отличие от свойства balance выполняется смешивание двух каналов без потери данных. Oт -1 до +1, по умолчнаию - 0
				rate - скорость воспроизведения от 0,125 до 8,0. По умолчанию 1,0
				priority - приоритет клипа относительно других клипов. По умолчанию - 0
			 */
		Button btn5 = new Button("AudioClip3 с 1/2 Volume");					
		btn5.setOnAction(event -> {
				if (!audioClip3.isPlaying()) audioClip3.play(0.5);
		});
			/* Изменение настроек (volume, balance, rate, pan, priority) д
		Изменение настроек во время воспроизведения не отразится на клипе		 */
		audioClip3.setVolume(0.5);
		audioClip3.setBalance(0);
		audioClip3.setPan(0);
		audioClip3.setRate(1);
		audioClip1.setCycleCount(AudioClip.INDEFINITE);		// Количество повторов воспроизведения. При бескнонечном-AudioClip.INDEFINITE
		audioClip1.setPriority(0);
		
		HBox hbox = new HBox(btn1, btn2, btn3, btn4, btn5);
		hbox.getChildren().addAll();
		
/*------------------------------------------------КЛАСС MEDIA--------------------------------------------------
	  	описывает ресурс с аудио и видео, который может быть загружен по протоколам: HTTP, HTTPS, FILE и JAR
	  	Наследование : Object - Media
	  	Конструктор Media(String source)
	  	 	где source - интернет-адрес (URL) с протоколом HTTP, HTTPS, FILE, JAR и полным путем к файлу
		При ошибке загрузки генерится исключение IllegalArgumentException или MediaException
		Путь URI - путь который может быть открыт из браузера				*/
		
			// 1-ый способ загрузки видео, по абсолютному адресу через Path.get()
		Media videoClip1;
		try {
			Path path = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\f04_JavaFX_Lessons\\src\\img\\videoplayback.mp4");
			URI uriPath = path.toUri();
			videoClip1 = new Media(uriPath.toString());
		} catch (Exception e) {
			System.out.println("Не удалось загрузить видео с диска");
			return;
		}
				// 2-ой способ загрузки видео, по относительному пути через Path.get()
		Media videoClip2;
		try {
			Path path = Paths.get("src\\img\\videoplayback.mp4");
			Path absolutePath = Paths.get(System.getProperty("user.dir")  + File.separator + path.toString());
			URI uriPath = absolutePath.toUri();
			videoClip2 = new Media(uriPath.toString());
		} catch (Exception e) {
			System.out.println("Не удалось загрузить видео с диска");
			return;
		}
				// 3-ий способ загрузки аудио, через this.getClass().getResource("/img/dvoynoy-schelchok-myishi.wav").toExternalForm() 
		Media videoClip3; 
//			= new Media(this.getClass().getResource("/img/dvoynoy-schelchok-myishi.wav").toExternalForm());
		try {
			String path = this.getClass().getResource("/img/maksim-znaesh-li-ty.mp3").toExternalForm();
			videoClip3 = new Media(path);
		} catch (Exception e) {
			System.out.println("Не удалось загрузить видео с диска");
			return;
		}
				// МЕТОДЫ Media	
		System.out.println(" Источник видео - " + videoClip2.getSource());				// возвращает адрес источника
		System.out.println("Словарь с метаданными - " + videoClip2.getMetadata());	// возвращает словарь с метаданными
		System.out.println(" Словарь с маркерами - " + videoClip2.getMarkers());	// возвращает словарь с маркерами
		System.out.println(" Список с дорожками - " + videoClip2.getTracks());		// возвращает список с дорожками
		System.out.println(" Ширина в пикселях  - " + videoClip2.getWidth());		// возвращает ширину в пикселях или нуль
		System.out.println(" Высота в пикселях  - " + videoClip2.getHeight());		// возвращает высоту в пикселях или нуль
		System.out.println(" Длительность  - " + videoClip2.getDuration());			// возвращает длительность
		
		/* Свойство error может быть получено через метод public final MediaException getError()
		   Метод onError() позволяет назначить обраточик для события изменения свойства error  */
		videoClip2.setOnError(() -> {
			System.out.println("OnError");
		});

/*---------------------------------------------КЛАСС MediaPlayer-------------------------------------------------------
 		Наследование  Object - Node - MediaView
 		Конструктор MediaPlayer (Media media)
 		Если media == null, то сгенерится исключение NullPointException
 		Если загрузка выполняется сихронно, то при возникновении ошибки генерируется MediaException
 		Если загрузка выполняется несихронно, то свойству error будет присвоен объект исплючения и будет вызван обработчик
 		назначенный с помощью onError	 */

		MediaPlayer mediaPlayer = new MediaPlayer(videoClip1);
			/* При создании объекта нужно дождаться статуса загрузки Ready - плеер готов к работе. Отследить это с getStatus()
			    UNKNOWN - состояние плеера после создания
			 	READY - плеер готов к работе
			 	PAUSED - воспроизведение временно приостановлено
			 	PLAYING - идет воспроизведение
			 	STOPPED - воспроизведение остановлено
			 	STALLED - в буфере недостаточно данных для продолжения воспроизведения
			 	HALTED - произошла критическая ошибка и плеер больше использовать нельзя
			 	DISPOSED - все ресурсы освобождены, плеер больше использовать нельзя
			 */
			// Назначить Listener на свойство statusProperty
		mediaPlayer.statusProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println(" Статус изменился с " + oldValue + " на " + newValue );
		});
			// Также можно назначить обработчика для каждого статуса
		mediaPlayer.setOnReady(() -> {
//			System.out.println(" Статус READY");
		}); 
		
/*					Управление воспроизведением
 	 - play() 	- старт воспроизведения. При остановке и снова старте, воспроиз.начнется с того же места, в противном случае со
 	 			значения свойства startTime
 	 - stop() 				- останавливает воспроизведение
 	 - seek() 				- перемещает указатель текущей позиции в указанную позицию
 	 - dispose() 			- освобождает все ресурсы и устанавливает для плеера статус Disposed
 	 - setAutoplay() 		- при true воспроизведение начнется, как только плеер будет READY 
 	 - setStartTime() 		- задает начальное время для старта воспроизведения
 	 - setStopTime() 		- задает конечное время 
 	 - getCurrentTime()		- возвращает текущее время 
 	 - getCurrentRate() 	- возвращает текущую скорость
 	 - getCurrentCount() 	- возвращает количество завершенных циклов воспроизведения
 	 - getCycleDuratione()	- возвращает продолжительность между startTime и stopTime
 	 - getTotalDuration() 	- возвращает продолжительность воспроизведения  */
		
			// Обработчик достижения stopTime - метод setOnEndOfMedia()
		mediaPlayer.setOnEndOfMedia(() -> {
			System.out.println(" Достигнут конец клипа");
		}); 
			// Обработчик достижения stopTime и начала повтора воспроизведения - метод setOnRepeat()
		mediaPlayer.setOnRepeat(() -> {
			System.out.println(" Начато повторное воспроизведение");
		}); 
			// Настройки воспроизведения
		mediaPlayer.setVolume(90);							// громкость
		mediaPlayer.setMute(false);							// mute
		mediaPlayer.setBalance(0);							// balance - баланс право - лево, от -1 до +1, по умолчнаию - 0
		mediaPlayer.setRate(1);								// rate - скорость воспроизведения от 0,125 до 8,0. По умолчанию 1,0
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);	// количество повторов воспроизведения
		
/*-----------------------------------Класс MediaView----------------------------------------------------
  		Наследование Object - Node - MediaView
  			Конструкторы
  		MediaView()
  		MediaView(MediaPlayer mediaPlayer)				*/
		MediaView mediaView = new MediaView(mediaPlayer);
//		mediaView.setScaleX(0.5);			
//		mediaView.setScaleY(0.5);
		mediaView.setX(10);					// задает координату левого верхнего угла по оси Х
		mediaView.setY(10);					// задает координату левого верхнего угла по оси У
		mediaView.setFitWidth(400);			
		mediaView.setPreserveRatio(true);	// сохранение пропорций при изменении размера одного
		mediaView.setSmooth(true);			// при true при изменении размеров будет сглаживание
//		mediaView.setViewport(new Rectangle2D(0, 0, 0, 0))     // задает, какую область кадра показывать. По умолчанию - null = весь кадр
			
			// Обработчик при ошибке
		mediaView.setOnError(new EventHandler<MediaErrorEvent>() {
			@Override
			public void handle(MediaErrorEvent event) {
				System.out.println("ERROR");
			}
		});
		
		Button btn6 = new Button("Play Video");
		btn6.setOnAction(event -> {
			if (mediaPlayer.getStatus() == MediaPlayer.Status.READY) {
				System.out.println("dfm vdf");
				mediaPlayer.play();
			}
		});
		
		Button btn7 = new Button("Stop Video");
		btn7.setOnAction(event -> {
			if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
				mediaPlayer.stop();
			}
		});

/*----------------------------------------------КЛАСС TRACK ------------------------------------------------------------------------
 		является базовым для классов, описывающих дорожки: AudioTrack(аудидорожка), VideoTrack, SubtitleTrack(дорожка с субтитрами)
 		Наследование	Object - Track - AudioTrack / VideoTrack / SubtitleTrack			 */
			// Один ресурс может иметь срaзу несколько дорожке, которые можно получить через getTracks()
		
		mediaPlayer.setOnReady(() -> {
			ObservableList<Track> tracks = mediaPlayer.getMedia().getTracks();
			Track audioTrack = tracks.get(0);
			System.out.println(audioTrack);
			Track videoTrack = tracks.get(1);
			System.out.println(videoTrack);
			System.out.println(" Название дорожки " + videoTrack.getName());
			System.out.println(" Уникальный идентификатор дорожки " + videoTrack.getTrackID());
			System.out.println(" Локаль дорожки " + videoTrack.getLocale());
			System.out.println(" Словарь метаданных дорожки " + videoTrack.getMetadata());
		});
		
		Slider slider = new Slider(0, 100, 0);
		slider.setMinHeight(20);   slider.setMinWidth(200);
		slider.setOrientation(Orientation.HORIZONTAL);
		slider.setShowTickLabels(true);			// при true, отображаются числовые значения около рисок
		slider.setShowTickMarks(true);			// при true, отображаются риски шкалы
		slider.setMajorTickUnit(20);			// Задает интервал между главными рисками
		slider.setMinorTickCount(10);			// Задает интервал между вспомогательными рисками
		slider.setSnapToTicks(true);			// Выравнивание ползунка по рискам
		slider.setBlockIncrement(5.0);			// // Задание насколько изменится значение ползунка при нажатии на клавиши влево и вправо
		
				// Изменение ползунка при просмотре видео 
		mediaPlayer.setOnPlaying(() -> {
			System.out.println("ffffffffff");
			Duration totalClipDuration = mediaPlayer.getMedia().getDuration();
			double totalClipDurationDouble = totalClipDuration.toMillis();
			mediaPlayer.currentTimeProperty().addListener((obj, oldValue, newValue) -> {
					double newValueDouble = newValue.toMillis();
//					slider.setValue(newValueDouble/totalClipDurationDouble);
			});
			
					// Перемотка видео при нажатии слайдера  (САМ НАПИСАЛ)
			slider.valueProperty().addListener((obj, oldValue, newValue) -> {
				/* setValueChanging(true) содержит true, если пользователь в данный момент перемещает ползунок
				   и false, если перемещение ползунка закончено				 */
				if (slider.isValueChanging() == false) {
					System.out.println("Значение ползунка изменилось с " + oldValue + " на " + newValue); 
					double sliderValue = (double)newValue;
					System.out.println("totalClipDuration = " + totalClipDuration);
					Duration newPoint = totalClipDuration.multiply(sliderValue/100);
					System.out.println(newPoint);
					mediaPlayer.seek(newPoint);
				}
			});
		});
				
		HBox hbox2 = new HBox();
		hbox2.getChildren().addAll(btn6, btn7, mediaView, slider);
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setSpacing(30);
		vbox.getChildren().addAll(hbox, hbox2);

		Scene scene = new Scene(vbox, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MEDIA");
		primaryStage.show();
	}
	public static void main(String[] args) {
			launch(args);
	}
}
