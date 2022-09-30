package t64_Start_window_during_appLoading1;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyPreloader extends Preloader{
	private Stage stage;
	private ProgressBar progressBar;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(" Метод start из MyPreloader запущен ");
		stage = primaryStage;
		Image image = null;
		try {
			image = new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg"));
			if (image.isError()) new RuntimeException();
		}
		catch(Exception e){
			System.err.println("Не удалось загрузить изображение");
			return;
		}
		ImageView imf = new ImageView(image);
		imf.setPreserveRatio(true);
		imf.setFitWidth(500);
		progressBar = new ProgressBar();
		VBox vbox = new VBox();
		vbox.getChildren().addAll(new Label("ОКНО ЗАГРУЗКИ"), imf, progressBar);
		Scene scene = new Scene(vbox);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("Окно с заставкой");
		stage.setScene(scene);
		stage.show();
	}
	@Override
	public void handleApplicationNotification(PreloaderNotification info) {
		if (info instanceof StateChangeNotification) {
			this.stage.close();
		}
	}
	@Override
	public void handleProgressNotification(ProgressNotification info) {
		progressBar.setProgress(info.getProgress());
	}
//	@Override
//	public void handleStateChangeNotification(StateChangeNotification info) {
//		if (info.getType() == StateChangeNotification.Type.BEFORE_START)
//			stage.hide();
//	}

}
