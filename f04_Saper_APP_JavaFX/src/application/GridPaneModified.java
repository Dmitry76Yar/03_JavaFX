package application;

import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Timer;
import Controllers.MainSceneController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

class GridPaneModifiedInstance extends GridPane implements Serializable {
	GridPaneModifiedInstance(GridPane gp) {
		super();
	}
}

class LabelMod extends Label implements Serializable {
	LabelMod(Label label) {
		super();
	}
}


public class GridPaneModified implements Serializable {
	private static final long serialVersionUID = 1L;
	public GridPaneModifiedInstance gridPane;
	public int numberMines, sizeCell, xNumberOfCells, yNumberOfCells;
	public  int numberOfBombs;
	public  int numberOfCellsWithoutBombOpened;
	public  LocalTime startGame;
	public  Param currentParameters;
	public  LocalTime endGame;
	public  LabelMod timerLabel;
	public  LabelMod lb;
//	public  Timer timer;

	public GridPaneModified() {
		super();
		this.gridPane = new GridPaneModifiedInstance(Engine.gridPane);
		this.numberMines = Main.numberMines;
		this.sizeCell = Main.sizeCell;
		this.xNumberOfCells = Main.xNumberOfCells;
		this.yNumberOfCells = Main.yNumberOfCells;
		this.currentParameters = Main.currentParameters;
		this.numberOfBombs = Engine.numberOfBombs;
		this.numberOfCellsWithoutBombOpened = Engine.numberOfCellsWithoutBombOpened;
		this.startGame = MainSceneController.startGame;
		this.endGame = MainSceneController.endGame;
		this.timerLabel = new LabelMod(MainSceneController.timerLabel);
		this.lb = new LabelMod(MainSceneController.lb);
//		this.timer = MainSceneController.timer;
	}

	public static void saveFile(GridPaneModified gpmod) {
		Scene scene = Engine.gridPane.getScene();
		Stage stage = (Stage)scene.getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select directory for save");
        fileChooser.setInitialFileName("save");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt", "*.txt"));
        fileChooser.setInitialDirectory(null);
        File fileToSave = fileChooser.showSaveDialog(stage);
        System.out.println(fileToSave.getPath());
        FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream(fileToSave.getPath());
			oos = new ObjectOutputStream(fout);
			oos.writeObject(gpmod);
		}
		catch (Exception ex) {
			System.out.println("Ошибка записи файла сохранения");
			ex.printStackTrace();} 
	}
	
	public static GridPaneModified read() {
		Scene scene = Engine.gridPane.getScene();
		Stage stage = (Stage)scene.getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select directory for loading");
        fileChooser.setInitialFileName("Load");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt", "*.txt"));
        fileChooser.setInitialDirectory(null);
        File fileToLoad = fileChooser.showOpenDialog(stage);
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		GridPaneModified gridPaneRead = null;
	    try{
	    	fis = new FileInputStream(fileToLoad.getPath());
	    	ois = new ObjectInputStream(fis);
	    	gridPaneRead = (GridPaneModified)ois.readObject();
	    }
	    catch (Exception ex) {
			System.out.println("Ошибка чтения объекта из файла сохранения");
			ex.printStackTrace();
		}
	    return gridPaneRead;
	}


}
