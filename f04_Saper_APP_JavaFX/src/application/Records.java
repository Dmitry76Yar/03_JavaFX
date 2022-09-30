package application;

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
import java.time.LocalDate;
import java.util.Arrays;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

class RecordObject  implements Serializable {
	private static final long serialVersionUID = 1L;
	long time;
	String name;
	LocalDate localDate;
	public RecordObject(long time, String name, LocalDate localDate) {
		this.time = time;
		this.name = name;
		this.localDate = localDate;
	}
	
	public RecordObject(RecordObject toCopy) {
		this.time = toCopy.time;
		this.name = toCopy.name;
		this.localDate = toCopy.localDate;
	}
}

public class Records implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Path PATH = Paths.get(System.getProperty("user.dir")  + File.separator + "src\\Saves\\Records.txt");

	public RecordObject novich[];
	public RecordObject amateur[];
	public RecordObject prof[];
	public RecordObject superprof[];
	public RecordObject crazy[];
	public int gamesPlayed[];
	public int gamesWon[];
	
	public Records(RecordObject[] novich, RecordObject[] amateur, RecordObject[] prof,
			RecordObject[] superprof, RecordObject[] crazy, int gamesPlayed[], int gamesWon[]) {
		this.novich = novich;
		this.amateur = amateur;
		this.prof = prof;
		this.superprof = superprof;
		this.crazy = crazy;
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
	}
	
	public Records(Records rec, int gamesPlayed, int gamesWon) {
		this.novich = rec.novich;
		this.amateur = rec.amateur;
		this.prof = rec.prof;
		this.superprof = rec.superprof;
		this.crazy = rec.crazy;
		this.gamesPlayed = rec.gamesPlayed;
		this.gamesWon = rec.gamesWon;
	}

	public static void createAndRecordRecords() {
		if (!Files.exists(PATH, LinkOption.NOFOLLOW_LINKS)) {
			try {
				Files.createFile(PATH);
			} catch (IOException e) {
				e.printStackTrace();}
			RecordObject recordObjectArrayTemp[] = new RecordObject[10];
			RecordObject recordObectTemp = new RecordObject(Long.MAX_VALUE, "no name", null);
			Arrays.fill(recordObjectArrayTemp, recordObectTemp);
			Records toRecord = new Records(recordObjectArrayTemp, recordObjectArrayTemp, recordObjectArrayTemp, 
											recordObjectArrayTemp, recordObjectArrayTemp, new int[] {0,0,0,0,0}, new int[]{0,0,0,0,0});
			record(toRecord);
		} // if
	}
		// Записывает 1 объект класса Record, в полях которого хранятся массивы для разной сложности с объектами
		// класса Recordobject, в полях которого хранится имя, время, дата     
		// Итого:  Recordobject -> Records novich[] -> Records novich[i].time, Records novich[i].name, Records novich[i].localDateTime
	static void record(Records toRecord) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream(PATH.toString());
			oos = new ObjectOutputStream(fout);
			oos.writeObject(toRecord);
		}
		catch (Exception ex) {
			System.out.println("Ошибка записи файла Records.txt");
			ex.printStackTrace();} 
		finally {
			if (fout != null) {
				try {
					fout.close();}
				catch (IOException e1) {
					e1.printStackTrace();}
			}
		} // finally
	}
	
	public static Records read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Records result = null;
	    try{
	    	fis = new FileInputStream(PATH.toString());
	    	ois = new ObjectInputStream(fis);
	    	result = (Records)ois.readObject();
	    }
	    catch (Exception ex) {
			System.out.println("Ошибка чтения объекта из файла Records.txt");
			ex.printStackTrace();
		}
	    return result;
	}
	
	public static void clearRecords() {
		if (!Files.exists(PATH, LinkOption.NOFOLLOW_LINKS)) {
			try {
				Files.delete(PATH);
			} catch (IOException e) {
				e.printStackTrace();}
		} // 
	}
	
	public static VBox printRecord() {
	   HBox hbox1 = new HBox();
	   HBox hbox2 = new HBox();
	   VBox vbox = new VBox();
	   Label lbl1 = new Label("ТАБЛИЦА РЕКОРДОВ");
	   lbl1.setPadding(new Insets(20, 5, 5, 10));		
	   lbl1.setTextAlignment(TextAlignment.CENTER);
	   lbl1.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 16));
	   lbl1.setTextFill(Color.BLACK);
	   lbl1.setAlignment(Pos.CENTER);

	   GridPane gp = new GridPane();
	   gp.setGridLinesVisible(true); 
	   gp.setAlignment(Pos.CENTER);
	   gp.setEffect(new InnerShadow(10, Color.BLACK));
	   gp.getColumnConstraints().addAll(new ColumnConstraints(40, 40, 40, null, HPos.CENTER, false), 
										new ColumnConstraints(150, 150, 150, null, HPos.CENTER, false), 
										new ColumnConstraints(150, 150, 150, null, HPos.CENTER, false));
	   		// Считывание рекордов из файла
	   Records recordForAllLevels = Records.read();	
	   hbox1.getChildren().addAll(printRecordHelp(recordForAllLevels.novich, "НОВИЧОК"), returnSepatator("vertical"), 
			   					  printRecordHelp(recordForAllLevels.amateur, "ЛЮБИТЕЛЬ"), returnSepatator("vertical"),
			   					  printRecordHelp(recordForAllLevels.prof, "ПРОФЕССИОНАЛ"));
	   hbox2.getChildren().addAll(printRecordHelp(recordForAllLevels.superprof, "СУПЕРПРОФЕССИОНАЛ"), returnSepatator("vertical"),
				  				  printRecordHelp(recordForAllLevels.crazy, "CRAZY"));
	   hbox1.setAlignment(Pos.CENTER);
	   hbox2.setAlignment(Pos.CENTER);
	   vbox.setAlignment(Pos.CENTER);
	   vbox.getChildren().addAll(hbox1, returnSepatator("horizontal"), hbox2);
	   return vbox;
	}
	
	static VBox printRecordHelp(RecordObject recordObject[], String level) {
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		Label levelLabel = new Label(level);
		levelLabel.setMinHeight(30);
		levelLabel.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 14));
		levelLabel.setTextFill(Color.DARKBLUE);
		
		GridPane gp = new GridPane();
		gp.setGridLinesVisible(true); 
		gp.setAlignment(Pos.CENTER);
		gp.setEffect(new InnerShadow(10, Color.BLACK));
		gp.getColumnConstraints().addAll(new ColumnConstraints(130, 130, 130, null, HPos.CENTER, false), 
										 new ColumnConstraints(130, 130, 130, null, HPos.CENTER, false));
		for (int i=0;i<11;i++) {
				Label timeLbl = new Label();
			timeLbl.setFont(Font.font("Calibri", FontWeight.NORMAL, FontPosture.REGULAR, 14));
			if (i==0) {
				timeLbl.setText("Время");
				timeLbl.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 14));
			}
			else {
				if (recordObject[i-1].time == Long.MAX_VALUE) timeLbl.setText("-");
    			else {
					if (Main.numberMines <40) 
						timeLbl.setText((long)recordObject[i-1].time/1000 + "," + recordObject[i-1].time%1000 + " сек");
				   	else {
		        		long min = recordObject[i-1].time/60000;
		        		long restMillisec = recordObject[i-1].time - min*60000;
		        		timeLbl.setText("" + min + " мин " + (long)restMillisec/1000 + "," + restMillisec%1000+ " сек");
		        	}
    			}
			}
			GridPane.setConstraints(timeLbl, 0, i);
				Label nameLbl = new Label();
			nameLbl.setFont(Font.font("Calibri", FontWeight.NORMAL, FontPosture.REGULAR, 14));
			if (i==0) {
				nameLbl.setText("Имя");
				nameLbl.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 14));
			}
			else {
				if (recordObject[i-1].time == Long.MAX_VALUE) nameLbl.setText("-");
    			else nameLbl.setText(recordObject[i-1].name);
			}
			GridPane.setConstraints(nameLbl, 1, i);
			gp.getChildren().addAll(timeLbl, nameLbl);
		}
		vbox.getChildren().addAll(levelLabel, gp);
		return vbox;
	}
	
	static Separator returnSepatator(String orientation) {
		Separator separator = null;
		if (orientation.equals("vertical")) separator = new Separator(Orientation.VERTICAL);
		else separator = new Separator(Orientation.HORIZONTAL);
		separator.setMinWidth(20);
		separator.setMinHeight(20);
		separator.setVisible(false);
		return separator;
	};
	
}
