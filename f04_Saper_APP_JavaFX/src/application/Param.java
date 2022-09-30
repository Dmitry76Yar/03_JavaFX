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

public class Param implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final Path PATH = Paths.get(System.getProperty("user.dir")  + File.separator + "src\\Saves\\Parameters.txt");
	
	public boolean openAllCellsInTheEnd;
	public boolean notOpenEmtyArea, openRandomEmtyArea, openMaxEmtyArea, openHint;
	
	public Param(boolean openAllCellsInTheEnd, boolean notOpenEmtyArea, boolean openRandomEmtyArea,
			boolean openMaxEmtyArea, boolean openHint) {
		this.openAllCellsInTheEnd = openAllCellsInTheEnd;
		this.notOpenEmtyArea = notOpenEmtyArea;
		this.openRandomEmtyArea = openRandomEmtyArea;
		this.openMaxEmtyArea = openMaxEmtyArea;
		this.openHint = openHint;
	}
	
	public Param(Param toCopy) {
		this.openAllCellsInTheEnd = toCopy.openAllCellsInTheEnd;
		this.notOpenEmtyArea = toCopy.notOpenEmtyArea;
		this.openRandomEmtyArea = toCopy.openRandomEmtyArea;
		this.openMaxEmtyArea = toCopy.openMaxEmtyArea;
		this.openHint = toCopy.openHint;
	}
	
	public static Param read() {
		if (!Files.exists(PATH, LinkOption.NOFOLLOW_LINKS)) {
			try {
				Files.createFile(PATH);
			} catch (IOException e) {
				e.printStackTrace();}
//			Param toRecord = new Param(false, true, false, false, false);
			Param toRecord = new Param(false, false, false, false, false);
			record(toRecord);
			return toRecord;
		}
		else {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			Param result = null;
		    try{
		    	fis = new FileInputStream(PATH.toString());
		    	ois = new ObjectInputStream(fis);
		    	result = (Param)ois.readObject();
		    }
		    catch (Exception ex) {
				System.out.println("Ошибка чтения объекта из файла Parameters.txt");
				ex.printStackTrace();
			}
		    return result;
		}
	}

	public static void record(Param toRecord) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream(PATH.toString());
			oos = new ObjectOutputStream(fout);
			oos.writeObject(toRecord);
		}
		catch (Exception ex) {
			System.out.println("Ошибка записи файла Parameters.txt");
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
}
