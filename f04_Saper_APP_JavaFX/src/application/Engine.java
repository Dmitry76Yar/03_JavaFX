package application;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import Controllers.MainSceneController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Engine{
	
	private static ArrayList<Integer[]> arl;
	private static Field fieldObject;
	public static GridPane gridPane;
	public static int numberOfBombs;
	public static int numberOfCellsWithoutBombOpened;
	public static int indexofThisGameInRecordTable;
	private static String strTextField;
	private static Records updatedRecordForAllLevels;
//	private static long timeBetweenClicksMouseBut;
//	private static long time1;
//	private static long time2;

// ----------------МЕТОД СОЗДАНИЯ ИГРОВОГО ПОЛЯ С ЯЧЕЙКАМИ-КНОПКАМИ---------------------------------------------------------//
	public static GridPane newGridPaneAndField(BorderPane root) {
		Engine.numberOfBombs = Main.numberMines;
		Engine.numberOfCellsWithoutBombOpened = Main.xNumberOfCells*Main.yNumberOfCells - Main.numberMines;
		fieldObject = new Field();
		gridPane = (GridPane)root.getCenter();
		gridPane.getChildren().clear();
		gridPane.setGridLinesVisible(true);
		gridPane.setMaxSize(Main.yNumberOfCells*Main.sizeCell, Main.xNumberOfCells*Main.sizeCell);
		   		// Создание кнопок-клеток и внесение их в gridpane
		for (int i= 0; i<Main.xNumberOfCells; i++) {
			for (int j=0; j<Main.yNumberOfCells; j++) {
			  Cell btnCell = new Cell(i, j); 
			  btnCell.setOnMouseClicked(new EventHandler<MouseEvent>() {
				 @Override
				 public void handle(MouseEvent event) {
				 	openCell(event, gridPane);	
				 }
			  }); 	
			  	// Обработка события нажатия, чтобы при нажатии ячейка менялась временно (при зажатии кнопки и переводе фокуса на 
			  	// другую ячейку исходная ячейка не открывалась)     Когда нажал, но понял, что ошибся, можно исправить ситуацию 
			  btnCell.setOnMousePressed(event -> {
				  if ((btnCell.isOpened == false) && (btnCell.isOpened == false))  changeImgInCell(0, btnCell);
				});
			  btnCell.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
				  if ((btnCell.isOpened == false) && (btnCell.isOpened == false))  changeImgInCell(-1, btnCell);
				});
			  
			  gridPane.add(btnCell, j, i);
			}
	     }
			// Открытие произвольной пустой области
		 if (Main.currentParameters.openRandomEmtyArea) {
			 ArrayList<Integer[]> emtyAreasList = toFindEmtyAreas();
			 Random random = new Random();
			 int a = random.nextInt(emtyAreasList.size()-1);
			 openEmptyCells(gridPane, emtyAreasList.get(a)[0], emtyAreasList.get(a)[1]);
		 }
		 	// Открыть максимальную пустую область в начале игры
		 if (Main.currentParameters.openMaxEmtyArea) {
			 ArrayList<Integer[]> emtyAreasList = toFindEmtyAreas();
			 int maxValue = 0;
			 int maxIndex = 0;
			 for (int i = 0; i<emtyAreasList.size(); i++) {
				 if (emtyAreasList.get(i)[2] >maxValue) {
					 maxValue = emtyAreasList.get(i)[2];
					 maxIndex = i;
				 }
			 }
			 openEmptyCells(gridPane, emtyAreasList.get(maxIndex)[0], emtyAreasList.get(maxIndex)[1]);
		 }
		 		// Подсказка для поиска пустой области
		 if (Main.currentParameters.openHint) {
			 Button btn = new Button(); 
			 Tooltip tooltip = new Tooltip("Открыть пустую область");
			 tooltip.setAutoHide(true);
			 tooltip.setAutoFix(true);
			 tooltip.setFont(Font.font("Calibri", 15));
			 tooltip.setWrapText(false);
             tooltip.setTextOverrun(OverrunStyle.ELLIPSIS);
			 tooltip.setContentDisplay(ContentDisplay.LEFT);
			 tooltip.setTextAlignment(TextAlignment.CENTER);
			 tooltip.setStyle("-fx-background-color: green;");
			 btn.setTooltip(tooltip);
			 ImageView imf = new ImageView(Field.openImg);
			 imf.setFitHeight(Main.sizeCell-2);
			 imf.setFitWidth(Main.sizeCell-2);
			 btn.setGraphic(imf);
			 btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);		
			 btn.setOnAction(event -> {
				 ArrayList<Integer[]> emtyAreasList = toFindEmtyAreas();
				 Random random = new Random();
				 int a = random.nextInt(emtyAreasList.size()-1);
				 openEmptyCells(gridPane, emtyAreasList.get(a)[0], emtyAreasList.get(a)[1]);
				 btn.setDisable(true);
				});
			 root.setRight(btn);
		 }
		 return gridPane;
	}
	
//---------------------МЕТОД ПОИСКА ПУСТЫХ ОБЛАСТЕЙ ДЛЯ ОТКРЫТИЯ В НАЧАЛЕ ИГРЫ------------------------------
		private static ArrayList<Integer[]> toFindEmtyAreas() {
			 ArrayList<Integer[]> result = new ArrayList<Integer[]>();
			 int[][] fieldcopy = new int[Main.xNumberOfCells][Main.yNumberOfCells];
			 	// Создание вспомогательного массива fieldcopy - копия игрового поля. Чтобы не вносить изменения в игровое поле
			 for (int i=0; i<Main.xNumberOfCells; i++) 
				 for (int j=0; j<Main.yNumberOfCells; j++) 
					 fieldcopy[i][j] = fieldObject.field[i][j];
			 
			 for (int i=0; i<Main.xNumberOfCells; i++) {
				 for (int j=0; j<Main.yNumberOfCells; j++) {
					 if (fieldcopy[i][j] ==0) {
						 int count = 1;										// Счетчик всех пустых ячеек в области с этой ячейкой
						 ArrayList<Integer[]> queue = new ArrayList<Integer[]>();	
						 queue.add(new Integer[] {i,j});
						 while (queue.size() !=0) 	{
			            	 int x = queue.get(0)[0];
			            	 int y = queue.get(0)[1];
			            	 queue.remove(0);
			            	 fieldcopy[x][y] = 15;
			            	 for (int a = x-1; a<=(x+1); a++) {
				 					for (int b = y-1; b<=(y+1); b++) {
				 						if ((a>=0) && (a<Main.xNumberOfCells) && (b>=0) && (b<Main.yNumberOfCells) && (fieldcopy[a][b] == 0)) {
				 							queue.add(new Integer[] {a,b});
						            		fieldcopy[a][b] = 15;
						            		count++;
				 						}
				 					}
			            	 }
			             } //End of while cycle
						 result.add(new Integer[] {i, j, count});
					 } // End of if для найденной нулевой ячейки
				 }
			}
				 return result;
		}

//---------------------МЕТОД СОЗДАНИЯ IMAGEVIEW - ИЗОБРАЖЕНИЕ В ЯЧЕЙКЕ-КНОПКЕ       Создается ImageView всегда одного размера
		private static ImageView createImageView (Image img) {
			ImageView imf = new ImageView(img);
		  	imf.setFitHeight(Main.sizeCell-2);
		  	imf.setFitWidth(Main.sizeCell-2);
		  	return imf;
		}

//----------------------МЕТОД ИЗМЕНЕНИЯ ФОТО В ЯЧЕЙКЕ-------------------------------------------------------------
		public static void changeImgInCell(int valueInCell, Cell cell) {
			 switch (valueInCell){
				 case 0 : cell.setGraphic(createImageView(Field.emptyCellImg)); break;
				 case 1 : cell.setGraphic(createImageView(Field.oneCellImg)); break;
				 case 2 : cell.setGraphic(createImageView(Field.twoCellImg)); break;
				 case 3 : cell.setGraphic(createImageView(Field.threeCellImg)); break;
				 case 4 : cell.setGraphic(createImageView(Field.fourCellImg)); break;
				 case 5 : cell.setGraphic(createImageView(Field.fiveCellImg)); break;
				 case 6 : cell.setGraphic(createImageView(Field.sixCellimg)); break;
				 case 7 : cell.setGraphic(createImageView(Field.sevenCellImg)); break;
				 case 8 : cell.setGraphic(createImageView(Field.eightCellImg)); break;
				 case 9 : cell.setGraphic(createImageView(Field.mineCellImg)); break;
				 case -1 : cell.setGraphic(createImageView(Field.cellImg)); break;
				 case 99 : cell.setGraphic(createImageView(Field.flagCellImg)); break;
			 }
		}
		
//----------------------МЕТОД-ПОМОЩНИК ОБРАБОТКИ НАЖАТИЯ ЯЧЕЙКИ-КНОПКИ--------------------------------------------------------
	private static void openCellHelper(GridPane gridpane, Cell cellPressed) {
		switch (fieldObject.field[cellPressed.x][cellPressed.y]){
			 		// Если попали на клетку с номерами 1-8, то только ее открываем
			 case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 : case 8 :
			//	 congratulate();
				 Cell cell1 = (Cell)gridpane.getChildren().get(cellPressed.x*Main.yNumberOfCells + cellPressed.y + 1);
				 changeImgInCell(fieldObject.field[cellPressed.x][cellPressed.y], cell1);
				 cell1.isOpened = true;
				 Engine.numberOfCellsWithoutBombOpened--;
				 if ((Engine.numberOfCellsWithoutBombOpened == 0) && (Engine.numberOfBombs ==0)) {
					 System.out.println("ПОЗДРАВЛЯЕМ");
					 gridpane.setDisable(true);
					 congratulate();
				 }
				 break;
				 		// Если попали на мину (номер 9), то открываем 
				 // - все поле, если openAllCellsInTheEnd = true и заканчиваем игру
				//  - все мины, если openAllCellsInTheEnd = false и заканчиваем игру
			 case 9 : 
				 MainSceneController.timerLabel.setTextFill(Color.RED);
				 MainSceneController.timer.cancel();
				 gridpane.setDisable(true);
				 for (int i = 0; i<Main.xNumberOfCells; i++) {
					for (int j = 0; j<Main.yNumberOfCells; j++) {
						Cell cell2 = (Cell)gridpane.getChildren().get(i*Main.yNumberOfCells + j + 1);
						if (Main.currentParameters.openAllCellsInTheEnd == false) {
							if (fieldObject.field[i][j] == 9) changeImgInCell(9, cell2);
							if ((fieldObject.field[i][j] != 9) && (cell2.isMarked)) 
								cell2.setGraphic(createImageView(Field.wrongFlag));
						}
						else {
							changeImgInCell(fieldObject.field[i][j], cell2);
							if ((fieldObject.field[i][j] != 9) && (cell2.isMarked)) 
								cell2.setGraphic(createImageView(Field.wrongFlag));
						}
					}
				 }
				 cellPressed.setGraphic(createImageView(Field.redMine));
				 fail();
				 break;
				 	// Если попали на нулевое поле, то открываем все нулевые поля кругом + все цифры по периметру пустой области
			 case 0 : 
				openEmptyCells(gridpane, cellPressed.x, cellPressed.y);
				break;
				} // switch
					
	}
	
	//----------------------МЕТОД ОБРАБОТКИ НАЖАТИЯ ЯЧЕЙКИ-КНОПКИ нажатием левой, правой клавишами, двойным кликом------------
	private static void openCell(MouseEvent event, GridPane gridpane){
		Cell cellPressed = (Cell)event.getSource();
		if ((event.getButton() == MouseButton.PRIMARY) && (!cellPressed.isOpened) && (!cellPressed.isMarked)) {
			boolean wasDoubleCkick = false;
//				// Сохранения времени нажатия клавиши  Если первое нажатие, то сохраняем в time1, если 2-ое - то в time2
//			if (time1 ==0) time1 = System.currentTimeMillis();
//			else {
//				if (time2 == 0) {
//					time2 = System.currentTimeMillis();
//					timeBetweenClicksMouseBut = time2 - time1;
//				}
//				if (timeBetweenClicksMouseBut <=215) {
//					wasDoubleCkick = true;
//					time1 = 0;
//					time2 = 0;
//				}
//				else {
//					wasDoubleCkick = false;
//					time1 = time2;
//					time2 = 0;
//				}
//			}
				// Обработка однократного нажатия клавиши
			if (wasDoubleCkick == false) 	openCellHelper(gridpane, cellPressed);
				// Обработка двухкратного нажатия клавиши 
			else {
//				int a = cellPressed.x;
//				int b = cellPressed.y;
//				for (int x= a-1; x<=(a+1); x++) {
//					for (int y= b-1; y<=(b+1); y++) {
//						if ((x>=0) && (x<Main.xNumberOfCells) && (y>=0) && (y<Main.yNumberOfCells)) {
//							Cell cell = (Cell)gridpane.getChildren().get(x*Main.yNumberOfCells + y + 1);
//							openCellHelper(gridpane, cell);
//						}
//					}
//				}
			} 
		}	// if for MouseButton.PRIMARY

		else if (event.getButton() == MouseButton.SECONDARY) {
				// Снятие флажка мины
			if (cellPressed.isMarked == true) {
				changeImgInCell(-1, cellPressed);
				cellPressed.isOpened = false;
				cellPressed.isMarked = false;
				MainSceneController.lb.setText(Integer.toString(++Engine.numberOfBombs));
				}
			else {
					// Назначение флажка мины 
				if (cellPressed.isOpened == false) {
					MainSceneController.lb.setText(Integer.toString(--Engine.numberOfBombs));
					if (Engine.numberOfBombs<0) MainSceneController.lb.setTextFill(Color.RED);
					changeImgInCell(99, cellPressed);
					cellPressed.isMarked = true;
					cellPressed.isOpened = true;
					if ((Engine.numberOfCellsWithoutBombOpened == 0) && (Engine.numberOfBombs ==0)) {
						 System.out.println("ПОЗДРАВЛЯЕМ");
						 gridpane.setDisable(true);
						 congratulate();
					 }
				}
			}
		} // elseif MouseButton.Secondary 
	}
	
//-----------------------МЕТОД-ПОМОЩНИК ОТКРЫТИЯ ВСЕХ ПУСТЫХ ЯЧЕЕК ПРИ НАЖАТИЕ НА ПУСТОЕ ПОЛЕ----------------------------------
	private static void openHelpMethod(int x, int y, GridPane gridpane) {
		if ((x>=0) && (x<Main.xNumberOfCells) && (y>=0) && (y<Main.yNumberOfCells)) {
			Cell cell = (Cell)gridpane.getChildren().get(x*Main.yNumberOfCells + y + 1);
			if ((fieldObject.field[x][y] == 0) && (cell.isOpened == false) && (cell.isMarked == false))  {
					arl.add(new Integer[] {x, y});											// если пустое поле, то вносим в очередь
			}
				// если число, то только открываем
			else if  ((fieldObject.field[x][y] >=1) &&  (fieldObject.field[x][y] <=8) && (cell.isOpened == false) && (cell.isMarked == false)) {	
				changeImgInCell(fieldObject.field[x][y], cell);
				cell.isOpened = true;
				Engine.numberOfCellsWithoutBombOpened--;
				if ((Engine.numberOfCellsWithoutBombOpened == 0) && (Engine.numberOfBombs ==0)) {
					 System.out.println("ПОЗДРАВЛЯЕМ");
					 gridpane.setDisable(true);
					 congratulate();
				}
			}	
		}
	}

//-----------------------МЕТОД-ПОМОЩНИК ОТКРЫТИЯ ВСЕХ ПУСТЫХ ЯЧЕЕК ПРИ НАЖАТИЕ НА ПУСТОЕ ПОЛЕ----------------------------------
	private static void openEmptyCells(GridPane gridpane, int a, int b) {
		arl = new ArrayList<Integer[]>();
		arl.add(new Integer[] {a, b});
		while (arl.size() !=0) 	{
			int x = arl.get(0)[0];
			int y = arl.get(0)[1];
			arl.remove(0);
				// Если это нулевое поле, то открываем его и все его окружающие
			Cell cellCurrent = (Cell)gridpane.getChildren().get(x*Main.yNumberOfCells + y + 1);
				// Открываем нулевое поле
			if ((cellCurrent.isMarked == false) && (cellCurrent.isOpened == false)) {
				changeImgInCell(0, cellCurrent);
				cellCurrent.isOpened = true;
				Engine.numberOfCellsWithoutBombOpened--;
				if ((Engine.numberOfCellsWithoutBombOpened == 0) && (Engine.numberOfBombs ==0)) {
					 System.out.println("ПОЗДРАВЛЯЕМ");
					 gridpane.setDisable(true);
					 congratulate();
				}
			}
				// Открываем все пустые поля и поля с цирфами по перифирии
			 for (int a1 = x-1; a1<=(x+1); a1++) 
					for (int b1 = y-1; b1<=(y+1); b1++) 
						if ((a1!=x) || (b1 != y)) openHelpMethod(a1, b1, gridpane);
		}
	}

//----------------МЕТОД ЗАПИСИ РЕКОРДОВ ПРИ ПОРАЖЕНИИ  (Изменяет только кол-во совершенных игр)--------------------------
	private static void fail() {
		Records currentRecordForAllLevels = Records.read();
		int newGamesPlayed[] = Arrays.copyOf(currentRecordForAllLevels.gamesPlayed, 5);
	    switch (Main.numberMines){
			case 10 : newGamesPlayed[0]++;	break;
			case 40 : newGamesPlayed[1]++;	break;
			case 99 : newGamesPlayed[2]++;	break;
			case 180 : newGamesPlayed[3]++;	break;
			case 400 : newGamesPlayed[4]++;	break;
	}
	    Records updatedRecordForAllLevels = new Records(currentRecordForAllLevels.novich, currentRecordForAllLevels.amateur, 
				currentRecordForAllLevels.prof, currentRecordForAllLevels.superprof, currentRecordForAllLevels.crazy, 
				newGamesPlayed, currentRecordForAllLevels.gamesWon); 
	    Records.record(updatedRecordForAllLevels);
	}
		
//---------------- МЕТОД СОЗДАНИЯ ДИАЛОГОВОГО ОКНА С ИНФОРМАЦИЕЙ ПРИ ПОБЕДЕ   + запись рекордов------------------------
	private static void congratulate() {
		MainSceneController.timerLabel.setTextFill(Color.BLUE);
		MainSceneController.timer.cancel();
		MainSceneController.endGame = LocalTime.now();
		Duration durationOfGame = Duration.between(MainSceneController.startGame, MainSceneController.endGame);
		Dialog<ButtonType> dialog = new Dialog<ButtonType>();
		DialogPane dialogPane = new DialogPane();
		
		Label lbl = new Label();
		lbl.setPadding(new Insets(10, 0, 0, 10));
		lbl.setTextAlignment(TextAlignment.CENTER);
		lbl.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 18));
		lbl.setTextFill(Color.BLUE);
		lbl.setAlignment(Pos.CENTER);
		dialogPane.setHeader(lbl);
		
    	Image img = null;
    	String root = System.getProperty("user.dir");
    	String FileName="src\\Resources\\Congratulation1.gif";
		String filePath = root + File.separator + FileName;
    	try { 
    		File file = new File(filePath);
    		String localUrl = file.toURI().toURL().toString();
    		System.out.println(localUrl);
    		img = new Image(localUrl);
       	}
       	catch (Exception e) {
       		System.out.println("Не удалось загрузить изображение Congratulation1.gif ");
       	}
    	ImageView imgf = new ImageView(img);
    	imgf.setFitHeight(150);
    	imgf.setEffect(new DropShadow(10, Color.BLACK));
    	imgf.setPreserveRatio(true);
    	
    	HBox hbox = new HBox();
    	hbox.setSpacing(20);
    	hbox.getChildren().add(imgf);
    	
    		// Вывод времени данной игры 
    	StringBuilder sb = new StringBuilder("\nВаше время:        ");
    	if (Main.numberMines <40)  {
    		long sec = durationOfGame.toSeconds();
    		long milliSec = durationOfGame.toMillisPart();
    		sb.append(sec + ",").append(milliSec + " сек\n");
    	}
    	else {
    		long min = durationOfGame.toMinutes();
    		Duration dur = durationOfGame.minusMinutes(min);
    		long sec = dur.toSeconds();
    		long millisec = dur.toMillisPart();
    		sb.append(min + " мин ").append(sec + ",").append(millisec +" сек");
    	}
    	sb.append("\n");
    	
    		// Считывание предыдущих рекордов из файла
    	int level = 0;
		Records currentRecordForAllLevels = Records.read();		// Считывает объект класса Record, хранящий данные для всех сложностей
		RecordObject recordsForThisLevel[] = null;		// СХранит объект класса Record, хранящий данные для текущей в игре сложности
		int newGamesPlayed[] = Arrays.copyOf(currentRecordForAllLevels.gamesPlayed, 5);
		int newGamesWon[] = Arrays.copyOf(currentRecordForAllLevels.gamesWon, 5);
    	switch (Main.numberMines){
    		case 10 : recordsForThisLevel = currentRecordForAllLevels.novich; 
	    		level = 0; 	break;
    		case 40 : recordsForThisLevel = currentRecordForAllLevels.amateur; 
	    		level = 1;  break;
    		case 99 : recordsForThisLevel = currentRecordForAllLevels.prof; 
	    		level = 2;  break;
    		case 180 : recordsForThisLevel = currentRecordForAllLevels.superprof; 
	    		level = 3;  break;
    		case 400 : recordsForThisLevel = currentRecordForAllLevels.crazy; 
	    		level = 4; 	break;
    	}
    	newGamesPlayed[level]++;
		newGamesWon[level]++;
		
    	// Вывод данных по дате, количеству игр
    	sb.append("Дата:                        " + LocalDate.now().format(DateTimeFormatter.ofPattern("d MMM uuuu ")) + "\n");
    	sb.append("Проведено игр:    " + newGamesPlayed[level] + "\n");
		sb.append("Выиграно игр:      " + newGamesWon[level] + "\n");
    	sb.append("Процент побед:   " + (int)((newGamesWon[level]*100/newGamesPlayed[level])) + "%\n");
    	Text text = new Text(sb.toString()); 
    	text.setFont(Font.font("Calibri", FontWeight.NORMAL, FontPosture.REGULAR, 16));
    	text.setFill(Color.DARKBLUE);
    	
    		// Сравнение времени данной игры с рекордами и сохранение новых рекордов для этого уровня
    	indexofThisGameInRecordTable = -1;
    	RecordObject newRecordForThisLevel[] = new RecordObject[10];
    	if (durationOfGame.toMillis() <recordsForThisLevel[0].time) {
    		lbl.setText("ВЫ ПОКАЗАЛИ ЛУЧШЕЕ ВРЕМЯ \nДЛЯ ЭТОГО УРОВНЯ СЛОЖНОСТИ!");
    		indexofThisGameInRecordTable = 0;
    		newRecordForThisLevel[0] = new RecordObject(durationOfGame.toMillis(), "", LocalDate.now());
    		for (int i=0; i<9; i++) newRecordForThisLevel[i+1] = new RecordObject(recordsForThisLevel[i]);
    	}
    	else if (durationOfGame.toMillis() <recordsForThisLevel[9].time) {
    		lbl.setText("ВЫ ПОБЕДИЛИ C РЕЗУЛЬТАТОМ \n В ДЕСЯТКЕ ЛУЧШИХ!");
    			// Поиск первого худшего времени в таблице рекордов в сравнении с данной игрой 
    		int indexFirstWorseRecord = 0;
    		for (int i=0; i<10; i++) {
    			if (durationOfGame.toMillis() <recordsForThisLevel[i].time) {
    				indexFirstWorseRecord = i;
    				break;
    			}
    		}
    		indexofThisGameInRecordTable = indexFirstWorseRecord;
    		for (int i=0; i<10; i++) {
    			if (i < indexFirstWorseRecord) 	newRecordForThisLevel[i] =  new RecordObject(recordsForThisLevel[i]);
    			else if (i == indexFirstWorseRecord) 
    					newRecordForThisLevel[indexFirstWorseRecord] = new RecordObject(durationOfGame.toMillis(), "", LocalDate.now());
    			else 	newRecordForThisLevel[i] = new RecordObject(recordsForThisLevel[i-1]);
    		}
    	}
    	else {
    		lbl.setText("ВЫ ПОБЕДИЛИ. \n ПОЗДРАВЛЯЕМ!");
    		for (int i=0; i<10; i++) 	newRecordForThisLevel[i] = new RecordObject(recordsForThisLevel[i]);
    	}
    	hbox.getChildren().add(text);
    	
    		// Вывод новой таблицы рекордов
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
    	gp.getColumnConstraints().addAll(	new ColumnConstraints(40, 40, 40, null, HPos.CENTER, false), 
    										new ColumnConstraints(150, 150, 150, null, HPos.CENTER, false), 
    										new ColumnConstraints(150, 150, 150, null, HPos.CENTER, false),
    										new ColumnConstraints(100, 100, 100, null, HPos.CENTER, false));
    	strTextField = "";
    	for (int i=0;i<10;i++) {
    		Label numberLbl = new Label(Integer.toString(i+1));
    		numberLbl.setPadding(new Insets(3));
    		numberLbl.setFont(Font.font("Calibri", FontWeight.NORMAL, FontPosture.REGULAR, 14));
    		GridPane.setConstraints(numberLbl, 0, i);
    			Label dataLbl = new Label();
    		String dataStr = null;
    		if (newRecordForThisLevel[i].localDate == null) dataStr = "-";
    		else dataStr = newRecordForThisLevel[i].localDate.format(DateTimeFormatter.ofPattern("d MMM uuuu")).toString();
    		dataLbl.setText(dataStr);
    		dataLbl.setPadding(new Insets(3));
    		dataLbl.setFont(Font.font("Calibri", FontWeight.NORMAL, FontPosture.REGULAR, 14));
    		GridPane.setConstraints(dataLbl, 3, i);
    			Label timeLbl = new Label();
    		timeLbl.setFont(Font.font("Calibri", FontWeight.NORMAL, FontPosture.REGULAR, 14));
    			HBox hboxforName = new HBox();
    		TextField nameTextField = new TextField();
    		Label nameLbl = new Label();
    		
    		if (i == indexofThisGameInRecordTable) {
    			Button btn = new Button("OK");
    			btn.setMinWidth(50);
    			nameTextField.setMaxWidth(100);
    			nameTextField.setPromptText("Введите имя");
    			nameTextField.setBlendMode(BlendMode.DARKEN);
    			nameTextField.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 14));
    			btn.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						strTextField = nameTextField.getText();
						nameTextField.setEditable(false);
						System.out.println("ВВЕДЕНО ИМЯ " + strTextField);
					}
				});
    			hboxforName.getChildren().addAll(nameTextField, btn);
    		}
    		else {
    			nameLbl.setFont(Font.font("Calibri", FontWeight.NORMAL, FontPosture.REGULAR, 14));
    			if (newRecordForThisLevel[i].time == Long.MAX_VALUE) nameLbl.setText("-");
    			else nameLbl.setText(newRecordForThisLevel[i].name);
    			hboxforName.getChildren().add(nameLbl);
    		}
    		GridPane.setConstraints(hboxforName, 2, i);
    		
    		nameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
    		    strTextField = newValue;
    		});
    		
    		if (newRecordForThisLevel[i].time == Long.MAX_VALUE) timeLbl.setText("-");
    		else {
    			if (Main.numberMines <40) 
    				timeLbl.setText((long)newRecordForThisLevel[i].time/1000 + "," + newRecordForThisLevel[i].time%1000 + " сек");
    		   	else {
	        		long min = newRecordForThisLevel[i].time/60000;
	        		long restMillisec = newRecordForThisLevel[i].time - min*60000;
	        		timeLbl.setText("" + min + " мин " + (long)restMillisec/1000 + "," + restMillisec%1000+ " сек");
	        	}
    		}	
    		GridPane.setConstraints(timeLbl, 1, i);
    			// Выделение жирным шрифтом данной игры
    		if ((indexofThisGameInRecordTable != -1) && (i == indexofThisGameInRecordTable)) {
    			numberLbl.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 14));
    			timeLbl.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 14));
    			dataLbl.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 14));
    		}
    		gp.getChildren().addAll(numberLbl, timeLbl, hboxforName, dataLbl);
    	}
    	VBox vb = new VBox();
    	vb.setAlignment(Pos.CENTER);
    	vb.getChildren().addAll(hbox, lbl1, gp);
    	dialogPane.setContent(vb);
    	
    		// ЗАПИСЬ НОВЫХ РЕКОРДОВ
    	dialog.setOnCloseRequest(new EventHandler<DialogEvent>() {
			@Override
			public void handle(DialogEvent event) {
					// Запись в новые рекорды для этого уровня имени игрока для этой игры (вводится пользователем в TextField)
				if (strTextField.equals("")) strTextField = "Неизвестный";
		    	RecordObject newRecordForThisLevelWithEnteredName[] = new RecordObject[10]; 
		    	for (int i =0; i<10; i++) {
		    		if (i == indexofThisGameInRecordTable) 
		    			newRecordForThisLevelWithEnteredName[i] = new RecordObject( newRecordForThisLevel[i].time, strTextField, 
		    																		newRecordForThisLevel[i].localDate);
		    		else newRecordForThisLevelWithEnteredName[i] = new RecordObject(newRecordForThisLevel[i]);
		    	}
		    	System.out.println("strTextField2 = " + strTextField);
				System.out.println("newRecordForThisLevelWithEnteredName2 = "  + 
						newRecordForThisLevelWithEnteredName[indexofThisGameInRecordTable].name);
				 switch (Main.numberMines){
					case 10 : 
						updatedRecordForAllLevels = new Records(newRecordForThisLevelWithEnteredName, currentRecordForAllLevels.amateur, 
						currentRecordForAllLevels.prof, currentRecordForAllLevels.superprof, currentRecordForAllLevels.crazy, 
						newGamesPlayed, newGamesWon); 
						break;
					case 40 : 
						updatedRecordForAllLevels = new Records(currentRecordForAllLevels.novich, newRecordForThisLevelWithEnteredName, 
						currentRecordForAllLevels.prof, currentRecordForAllLevels.superprof, currentRecordForAllLevels.crazy, 
						newGamesPlayed, newGamesWon); 
						break;	
					case 99 : 
						updatedRecordForAllLevels = new Records(currentRecordForAllLevels.novich, currentRecordForAllLevels.amateur, 
						newRecordForThisLevelWithEnteredName, currentRecordForAllLevels.superprof, currentRecordForAllLevels.crazy, 
						newGamesPlayed, newGamesWon); 
						break;
					case 180 : 
						updatedRecordForAllLevels = new Records(currentRecordForAllLevels.novich, currentRecordForAllLevels.amateur, 
						currentRecordForAllLevels.prof, newRecordForThisLevelWithEnteredName, currentRecordForAllLevels.crazy, 
						newGamesPlayed, newGamesWon); 
						break;
					case 400 : 
						updatedRecordForAllLevels = new Records(currentRecordForAllLevels.novich, currentRecordForAllLevels.amateur, 
						currentRecordForAllLevels.prof, currentRecordForAllLevels.superprof, newRecordForThisLevelWithEnteredName, 
						newGamesPlayed, newGamesWon); 
						break;
			    }
			    Records.record(updatedRecordForAllLevels);
			}
		});
    	
    	dialogPane.getButtonTypes().add(new ButtonType("OK ", ButtonData.CANCEL_CLOSE));
    	dialog.setDialogPane(dialogPane);
    	dialog.setResizable(false);
		dialog.show();
	}
	
}
