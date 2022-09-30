package t58_Directory_File_Chooser;
	
import java.io.File;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) {	
			
/*------------------------------DIRECTORY CHOOSER---------------------------------------------------------------------
	реализует модильное окно для выбора папки.    Obect - DirectoryChooser 
	showDialog(Window window) - в window указывается ссылка на родительское окно */		

	Button btn1 = new Button("DirectoryChooser");
	btn1.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			DirectoryChooser directCh = new DirectoryChooser();
			directCh.setTitle("DirectoryChooser");
			directCh.setInitialDirectory(new File("C:\\Users\\dkuli\\Documents\\My_works"));
			File result = directCh.showDialog(primaryStage);
			if (result != null) System.out.println(result);
			else System.out.println("Entered Exit");
		}
	});

/*------------------------------FILE CHOOSER---------------------------------------------------------------------
	реализует модильное окно для выбора файла.    Obect - FileChooser 
	showDialog(Window window) - в window указывается ссылка на родительское окно */
			// Реализация выбора одного файла
	Button btn2 = new Button("Open FileChooser");
	btn2.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			FileChooser fileCh = new FileChooser();
			fileCh.setTitle("FileChooser");
			fileCh.setInitialDirectory(new File("C:\\Users\\dkuli\\Documents\\My_works"));
			fileCh.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("EXE файлы", "*.exe"),
												new FileChooser.ExtensionFilter("TXT файлы", "*.txt", "*.doc"),
												new FileChooser.ExtensionFilter("ВСЕ файлы", "*.*"));
			File result = fileCh.showOpenDialog(primaryStage);
			if (result != null) System.out.println(result);
			else System.out.println("Entered Exit");
		}
	});
			// Выбор нескольких файлов
	Button btn3 = new Button("Myltiply Open FileChooser");     
	btn3.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			FileChooser fileCh = new FileChooser();
			fileCh.setTitle("FileChooser");
			fileCh.setInitialDirectory(new File("C:\\Users\\dkuli\\Documents\\My_works"));
			fileCh.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("EXE файлы", "*.exe"),
					new FileChooser.ExtensionFilter("TXT файлы", "*.txt", "*.doc"),
					new FileChooser.ExtensionFilter("ВСЕ файлы", "*.*"));
			List<File> result = fileCh.showOpenMultipleDialog(primaryStage);
			if (result != null) System.out.println(result);
			else System.out.println("Entered Exit");
		}
	});
	
			// Выбор файла для сохранения
	Button btn4 = new Button("FileChooser for SAVE");     
	btn4.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			FileChooser fileCh = new FileChooser();
			fileCh.setTitle("FileChooser");
			fileCh.setInitialDirectory(new File("C:\\Users\\dkuli\\Documents\\My_works"));
			fileCh.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("EXE файлы", "*.exe"),
					new FileChooser.ExtensionFilter("TXT файлы", "*.txt", "*.doc"),
					new FileChooser.ExtensionFilter("ВСЕ файлы", "*.*"));
			fileCh.setInitialFileName("ToSave.txt");
			File result = fileCh.showOpenDialog(primaryStage);
			if (result != null) System.out.println(result);
			else System.out.println("Entered Exit");
		}
	});
	
		HBox hb51 = new HBox();
		hb51.getChildren().addAll(btn1, btn2, btn3, btn4);
		Scene scene = new Scene(hb51, 650, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Click Counter");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
