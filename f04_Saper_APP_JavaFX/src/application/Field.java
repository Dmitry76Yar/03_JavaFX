package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.scene.image.Image;

public class Field implements Serializable {
	private static final long serialVersionUID = 1L;
	public static Image mineCellImg, emptyCellImg, flagCellImg, oneCellImg, twoCellImg, threeCellImg, fourCellImg, cellImg,
	fiveCellImg, sixCellimg, sevenCellImg, eightCellImg, openImg, redMine, wrongFlag;
	public int randomEmtyCell[]; 
	public int field[][];
	public ArrayList<Integer[]> allEmtyCells = new ArrayList<Integer[]>();
	
	 public Image createImg(String url) {
	    	Image img = null;
	    	try { 
	       		img = new Image(getClass().getResourceAsStream(url));
	       		if (img.isError()) new RuntimeException();	
	       		}
	       	catch (Exception e) {
	       		System.out.println("Не удалось загрузить изображение  " + url);
	       	}
	    	return img;
	    }
	 
		// Рандомное внесение бомб
	public Field() {
		Random random = new Random();
		int field[][] = new int[Main.xNumberOfCells][Main.yNumberOfCells];
		boolean isThisPlaceWithMine = true;
		int x1, y1;
			// Ячейка с миной имеет номер 9
		for (int i =0; i<Main.numberMines; i++) {
			isThisPlaceWithMine = true;
			 while (isThisPlaceWithMine == true) {
			   	 x1 = random.nextInt(Main.xNumberOfCells);
			   	 y1 = random.nextInt(Main.yNumberOfCells);
			   	 if (field[x1][y1] == 9) isThisPlaceWithMine = true;
			   	 else {
			   		field[x1][y1] = 9;
			   		isThisPlaceWithMine = false;
			   	 }
			   }
		}
	
			// Добавление чисел в ячейки (числа бомб около выбранной ячейки)
		for (int i =0; i<Main.xNumberOfCells; i++) {
			for (int j =0; j<Main.yNumberOfCells; j++) {
				if (field[i][j] != 9) {
					int count = 0;
					if (((j-1)>=0)&&(field[i][j-1] == 9)) count++;
					if (((j-1)>=0)&&((i+1)<Main.xNumberOfCells)&&(field[i+1][j-1] == 9)) count++;
					if (((i+1)<Main.xNumberOfCells)&&(field[i+1][j] == 9)) count++;
					if (((i+1)<Main.xNumberOfCells)&&((j+1)<Main.yNumberOfCells)&&(field[i+1][j+1] == 9)) count++;
					if (((j+1)<Main.yNumberOfCells)&&(field[i][j+1] == 9)) count++;
					if (((i-1)>=0)&&((j+1)<Main.yNumberOfCells)&&(field[i-1][j+1] == 9)) count++;
					if (((i-1)>=0)&&(field[i-1][j] == 9)) count++;
					if (((i-1)>=0)&&((j-1)>=0)&&(field[i-1][j-1] == 9)) count++;
					field[i][j] = count;
					if (count == 0) allEmtyCells.add(new Integer[]{i,j});
				}
			}
		}
		this.field = field;
		for (int i=0; i <field.length; i++) System.out.println(Arrays.toString(field[i]));
//		for (int i=0; i <allEmtyCells.size(); i++) System.out.println(Arrays.toString(allEmtyCells.get(i)));
		
			// Загрузка изображений в статичекие переменные (чтобы постоянно не загружать)
		cellImg = createImg("/Resources/cell.png");
		mineCellImg = createImg("/Resources/bomb2.png");
		emptyCellImg = createImg("/Resources/emptyCell2.png");
		flagCellImg = createImg("/Resources/flag.png");
		oneCellImg = createImg("/Resources/one.png");
		twoCellImg = createImg("/Resources/two.png");
		threeCellImg = createImg("/Resources/three.png");
		fourCellImg = createImg("/Resources/four.jpg");
		fiveCellImg = createImg("/Resources/five.jpg");
		sixCellimg = createImg("/Resources/six.jpg");
		sevenCellImg = createImg("/Resources/seven.jpg");
		eightCellImg = createImg("/Resources/eight.jpg");
		openImg = createImg("/Resources/open.jpg");
		redMine = createImg("/Resources/redMine.jpg");
		wrongFlag = createImg("/Resources/wrongMine.jpg");
	}
	
}
