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
			
/*------------------------------�������� ��������---------------------------------------------------------------------
   ����� �������� � VM --add-modules=javafx.controls,javafx.fxml,javafx.web,javafx.media
   Run configurations - (x)-Arguments - VM arguments 
   
   
 
	��� ��������������� ����� � ����� �����
	 - ������� ������ Media � ��������
	 - ������� ������ MediaPleer � �������� ��� ���� ������
	 - ������� ������ MediaView  � �������� ��� ������ ������ (��� ����� ���� ��� ����� ����������)
	 - �������� ������ MediaView � ���� ����� (��� ����� ���� ��� ����� ����������)
	 - ��������� ��������� ��������������� � ������� ����� play() ������� ������
	��� �������� ��� ��������������� ����� ����� ����� ��������������� ������� AudioClip, �� ������� �������, ���
	�� ������ ��������� ������ ������� � ������, � �� ������ ��� �� ������ � �����*/		
			
/*------------------------------����� AudiClip  ��������������� �����-------------------------------------------------
	  �����  AudioClip ��������� ��������� ���������� �� ����������: HTTP, HTTPS, FILE, JAR � �������������� ��
	  Object - AudioClip
	  		�����������
	  AudioClip(String source)	
	  	��� source - ��������-����� (URL) � ���������� HTTP, HTTPS, FILE, JAR � ������ ����� � �����
	  ��� ������ �������� ��������� ���������� IllegalArgumentException ��� MediaException
	  ���� URI - ���� ������� ����� ���� ������ �� ��������		*/
			
			// 1-�� ������ �������� �����, �� ����������� ������ ����� Path.get()
	AudioClip audioClip1;
	try {
		Path path = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\f04_JavaFX_Lessons\\src\\img\\dvoynoy-schelchok-myishi.wav");
		URI uriPath = path.toUri();
		audioClip1 = new AudioClip(uriPath.toString());
	} catch (Exception e) {
		System.out.println("�� ������ ����");
		return;
	}
	Button btn1 = new Button("AudioClip1");
	btn1.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			audioClip1.play();
		}
	});
		
			// 2-�� ������ �������� �����, �� �������������� ���� ����� Path.get()
	AudioClip audioClip2;
	try {
		Path path = Paths.get("src\\img\\dvoynoy-schelchok-myishi.wav");
		Path absolutePath = Paths.get(System.getProperty("user.dir")  + File.separator + path.toString());
		URI uriPath = absolutePath.toUri();
		audioClip2 = new AudioClip(uriPath.toString());
	} catch (Exception e) {
		System.out.println("�� ������� ��������� ����� � �����");
		return;
	}
	Button btn2 = new Button("AudioClip2");
	btn2.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			audioClip2.play();
		}
	});		

			// 3-�� ������ �������� �����, ����� this.getClass().getResource("/img/dvoynoy-schelchok-myishi.wav").toExternalForm() 
	AudioClip audioClip3; 
//		= new AudioClip(this.getClass().getResource("/img/dvoynoy-schelchok-myishi.wav").toExternalForm());
		try {
			String path = this.getClass().getResource("/img/maksim-znaesh-li-ty.mp3").toExternalForm();
			audioClip3 = new AudioClip(path);
		} catch (Exception e) {
			System.out.println("�� ������� ��������� ����� � �����");
			return;
		}
		Button btn3 = new Button("AudioClip3");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!audioClip3.isPlaying()) audioClip3.play();
			}
		});
		
			// ������ AudioClip
		System.out.println(" �������� ����� - " + audioClip3.getSource());		// ���������� ����� ���������
		System.out.println(" ���������������? - " + audioClip3.isPlaying());	// true, ���� ����� ���������������
			// ����� STOP ������������� ���������������
		Button btn4 = new Button("Stop AudioClip3");					
		btn4.setOnAction(event -> {
				if (audioClip3.isPlaying()) audioClip3.stop();
		});
			/* ����� Play ����� 3 ��������
		void play() 																	- ��������� �� ���������
		void play(double volume)
		void play (double volume, double balance, double rate, double pan, int priority)
			��� volume - ��������� 
				balance - ������ ����� - ����, �� -1 �� +1, �� ��������� - 0
				pan - "�����" �����. � ������� �� �������� balance ����������� ���������� ���� ������� ��� ������ ������. O� -1 �� +1, �� ��������� - 0
				rate - �������� ��������������� �� 0,125 �� 8,0. �� ��������� 1,0
				priority - ��������� ����� ������������ ������ ������. �� ��������� - 0
			 */
		Button btn5 = new Button("AudioClip3 � 1/2 Volume");					
		btn5.setOnAction(event -> {
				if (!audioClip3.isPlaying()) audioClip3.play(0.5);
		});
			/* ��������� �������� (volume, balance, rate, pan, priority) �
		��������� �������� �� ����� ��������������� �� ��������� �� �����		 */
		audioClip3.setVolume(0.5);
		audioClip3.setBalance(0);
		audioClip3.setPan(0);
		audioClip3.setRate(1);
		audioClip1.setCycleCount(AudioClip.INDEFINITE);		// ���������� �������� ���������������. ��� ������������-AudioClip.INDEFINITE
		audioClip1.setPriority(0);
		
		HBox hbox = new HBox(btn1, btn2, btn3, btn4, btn5);
		hbox.getChildren().addAll();
		
/*------------------------------------------------����� MEDIA--------------------------------------------------
	  	��������� ������ � ����� � �����, ������� ����� ���� �������� �� ����������: HTTP, HTTPS, FILE � JAR
	  	������������ : Object - Media
	  	����������� Media(String source)
	  	 	��� source - ��������-����� (URL) � ���������� HTTP, HTTPS, FILE, JAR � ������ ����� � �����
		��� ������ �������� ��������� ���������� IllegalArgumentException ��� MediaException
		���� URI - ���� ������� ����� ���� ������ �� ��������				*/
		
			// 1-�� ������ �������� �����, �� ����������� ������ ����� Path.get()
		Media videoClip1;
		try {
			Path path = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\f04_JavaFX_Lessons\\src\\img\\videoplayback.mp4");
			URI uriPath = path.toUri();
			videoClip1 = new Media(uriPath.toString());
		} catch (Exception e) {
			System.out.println("�� ������� ��������� ����� � �����");
			return;
		}
				// 2-�� ������ �������� �����, �� �������������� ���� ����� Path.get()
		Media videoClip2;
		try {
			Path path = Paths.get("src\\img\\videoplayback.mp4");
			Path absolutePath = Paths.get(System.getProperty("user.dir")  + File.separator + path.toString());
			URI uriPath = absolutePath.toUri();
			videoClip2 = new Media(uriPath.toString());
		} catch (Exception e) {
			System.out.println("�� ������� ��������� ����� � �����");
			return;
		}
				// 3-�� ������ �������� �����, ����� this.getClass().getResource("/img/dvoynoy-schelchok-myishi.wav").toExternalForm() 
		Media videoClip3; 
//			= new Media(this.getClass().getResource("/img/dvoynoy-schelchok-myishi.wav").toExternalForm());
		try {
			String path = this.getClass().getResource("/img/maksim-znaesh-li-ty.mp3").toExternalForm();
			videoClip3 = new Media(path);
		} catch (Exception e) {
			System.out.println("�� ������� ��������� ����� � �����");
			return;
		}
				// ������ Media	
		System.out.println(" �������� ����� - " + videoClip2.getSource());				// ���������� ����� ���������
		System.out.println("������� � ����������� - " + videoClip2.getMetadata());	// ���������� ������� � �����������
		System.out.println(" ������� � ��������� - " + videoClip2.getMarkers());	// ���������� ������� � ���������
		System.out.println(" ������ � ��������� - " + videoClip2.getTracks());		// ���������� ������ � ���������
		System.out.println(" ������ � ��������  - " + videoClip2.getWidth());		// ���������� ������ � �������� ��� ����
		System.out.println(" ������ � ��������  - " + videoClip2.getHeight());		// ���������� ������ � �������� ��� ����
		System.out.println(" ������������  - " + videoClip2.getDuration());			// ���������� ������������
		
		/* �������� error ����� ���� �������� ����� ����� public final MediaException getError()
		   ����� onError() ��������� ��������� ��������� ��� ������� ��������� �������� error  */
		videoClip2.setOnError(() -> {
			System.out.println("OnError");
		});

/*---------------------------------------------����� MediaPlayer-------------------------------------------------------
 		������������  Object - Node - MediaView
 		����������� MediaPlayer (Media media)
 		���� media == null, �� ���������� ���������� NullPointException
 		���� �������� ����������� ��������, �� ��� ������������� ������ ������������ MediaException
 		���� �������� ����������� ����������, �� �������� error ����� �������� ������ ���������� � ����� ������ ����������
 		����������� � ������� onError	 */

		MediaPlayer mediaPlayer = new MediaPlayer(videoClip1);
			/* ��� �������� ������� ����� ��������� ������� �������� Ready - ����� ����� � ������. ��������� ��� � getStatus()
			    UNKNOWN - ��������� ������ ����� ��������
			 	READY - ����� ����� � ������
			 	PAUSED - ��������������� �������� ��������������
			 	PLAYING - ���� ���������������
			 	STOPPED - ��������������� �����������
			 	STALLED - � ������ ������������ ������ ��� ����������� ���������������
			 	HALTED - ��������� ����������� ������ � ����� ������ ������������ ������
			 	DISPOSED - ��� ������� �����������, ����� ������ ������������ ������
			 */
			// ��������� Listener �� �������� statusProperty
		mediaPlayer.statusProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println(" ������ ��������� � " + oldValue + " �� " + newValue );
		});
			// ����� ����� ��������� ����������� ��� ������� �������
		mediaPlayer.setOnReady(() -> {
//			System.out.println(" ������ READY");
		}); 
		
/*					���������� ����������������
 	 - play() 	- ����� ���������������. ��� ��������� � ����� ������, ��������.�������� � ���� �� �����, � ��������� ������ ��
 	 			�������� �������� startTime
 	 - stop() 				- ������������� ���������������
 	 - seek() 				- ���������� ��������� ������� ������� � ��������� �������
 	 - dispose() 			- ����������� ��� ������� � ������������� ��� ������ ������ Disposed
 	 - setAutoplay() 		- ��� true ��������������� ��������, ��� ������ ����� ����� READY 
 	 - setStartTime() 		- ������ ��������� ����� ��� ������ ���������������
 	 - setStopTime() 		- ������ �������� ����� 
 	 - getCurrentTime()		- ���������� ������� ����� 
 	 - getCurrentRate() 	- ���������� ������� ��������
 	 - getCurrentCount() 	- ���������� ���������� ����������� ������ ���������������
 	 - getCycleDuratione()	- ���������� ����������������� ����� startTime � stopTime
 	 - getTotalDuration() 	- ���������� ����������������� ���������������  */
		
			// ���������� ���������� stopTime - ����� setOnEndOfMedia()
		mediaPlayer.setOnEndOfMedia(() -> {
			System.out.println(" ��������� ����� �����");
		}); 
			// ���������� ���������� stopTime � ������ ������� ��������������� - ����� setOnRepeat()
		mediaPlayer.setOnRepeat(() -> {
			System.out.println(" ������ ��������� ���������������");
		}); 
			// ��������� ���������������
		mediaPlayer.setVolume(90);							// ���������
		mediaPlayer.setMute(false);							// mute
		mediaPlayer.setBalance(0);							// balance - ������ ����� - ����, �� -1 �� +1, �� ��������� - 0
		mediaPlayer.setRate(1);								// rate - �������� ��������������� �� 0,125 �� 8,0. �� ��������� 1,0
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);	// ���������� �������� ���������������
		
/*-----------------------------------����� MediaView----------------------------------------------------
  		������������ Object - Node - MediaView
  			������������
  		MediaView()
  		MediaView(MediaPlayer mediaPlayer)				*/
		MediaView mediaView = new MediaView(mediaPlayer);
//		mediaView.setScaleX(0.5);			
//		mediaView.setScaleY(0.5);
		mediaView.setX(10);					// ������ ���������� ������ �������� ���� �� ��� �
		mediaView.setY(10);					// ������ ���������� ������ �������� ���� �� ��� �
		mediaView.setFitWidth(400);			
		mediaView.setPreserveRatio(true);	// ���������� ��������� ��� ��������� ������� ������
		mediaView.setSmooth(true);			// ��� true ��� ��������� �������� ����� �����������
//		mediaView.setViewport(new Rectangle2D(0, 0, 0, 0))     // ������, ����� ������� ����� ����������. �� ��������� - null = ���� ����
			
			// ���������� ��� ������
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

/*----------------------------------------------����� TRACK ------------------------------------------------------------------------
 		�������� ������� ��� �������, ����������� �������: AudioTrack(�����������), VideoTrack, SubtitleTrack(������� � ����������)
 		������������	Object - Track - AudioTrack / VideoTrack / SubtitleTrack			 */
			// ���� ������ ����� ����� ��a�� ��������� �������, ������� ����� �������� ����� getTracks()
		
		mediaPlayer.setOnReady(() -> {
			ObservableList<Track> tracks = mediaPlayer.getMedia().getTracks();
			Track audioTrack = tracks.get(0);
			System.out.println(audioTrack);
			Track videoTrack = tracks.get(1);
			System.out.println(videoTrack);
			System.out.println(" �������� ������� " + videoTrack.getName());
			System.out.println(" ���������� ������������� ������� " + videoTrack.getTrackID());
			System.out.println(" ������ ������� " + videoTrack.getLocale());
			System.out.println(" ������� ���������� ������� " + videoTrack.getMetadata());
		});
		
		Slider slider = new Slider(0, 100, 0);
		slider.setMinHeight(20);   slider.setMinWidth(200);
		slider.setOrientation(Orientation.HORIZONTAL);
		slider.setShowTickLabels(true);			// ��� true, ������������ �������� �������� ����� �����
		slider.setShowTickMarks(true);			// ��� true, ������������ ����� �����
		slider.setMajorTickUnit(20);			// ������ �������� ����� �������� �������
		slider.setMinorTickCount(10);			// ������ �������� ����� ���������������� �������
		slider.setSnapToTicks(true);			// ������������ �������� �� ������
		slider.setBlockIncrement(5.0);			// // ������� ��������� ��������� �������� �������� ��� ������� �� ������� ����� � ������
		
				// ��������� �������� ��� ��������� ����� 
		mediaPlayer.setOnPlaying(() -> {
			System.out.println("ffffffffff");
			Duration totalClipDuration = mediaPlayer.getMedia().getDuration();
			double totalClipDurationDouble = totalClipDuration.toMillis();
			mediaPlayer.currentTimeProperty().addListener((obj, oldValue, newValue) -> {
					double newValueDouble = newValue.toMillis();
//					slider.setValue(newValueDouble/totalClipDurationDouble);
			});
			
					// ��������� ����� ��� ������� ��������  (��� �������)
			slider.valueProperty().addListener((obj, oldValue, newValue) -> {
				/* setValueChanging(true) �������� true, ���� ������������ � ������ ������ ���������� ��������
				   � false, ���� ����������� �������� ���������				 */
				if (slider.isValueChanging() == false) {
					System.out.println("�������� �������� ���������� � " + oldValue + " �� " + newValue); 
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
