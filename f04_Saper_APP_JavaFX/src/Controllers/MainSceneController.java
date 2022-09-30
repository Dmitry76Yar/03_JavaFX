package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import application.Engine;
import application.Field;
import application.GridPaneModified;
import application.Main;
import application.Param;
import application.Records;

class MyTimerTask extends TimerTask {
	public Label lbl; 
	public MyTimerTask (Label lbl) {
		this.lbl = lbl;
	}
	@Override
	public void run() {
		Platform.runLater(() -> {
			if ((Engine.numberOfBombs == 0) && (Engine.numberOfCellsWithoutBombOpened == 0)) {
				Duration duration = Duration.between(MainSceneController.startGame, MainSceneController.endGame);
				if (Main.numberMines >=180) lbl.setText(LocalTime.MIDNIGHT.plus(duration).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
				else lbl.setText(LocalTime.MIDNIGHT.plus(duration).format(DateTimeFormatter.ofPattern("mm:ss")));
			}
			else {
				Duration duration = Duration.between(MainSceneController.startGame, LocalTime.now());
				if (Main.numberMines >=180) lbl.setText(LocalTime.MIDNIGHT.plus(duration).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
				else lbl.setText(LocalTime.MIDNIGHT.plus(duration).format(DateTimeFormatter.ofPattern("mm:ss")));
			}
		});
	}
}

public class MainSceneController {
	public static LocalTime startGame;
	public static LocalTime endGame;
	public static Label timerLabel;
	public static Label lb;
	public static Timer timer;
	private static Dialog<ButtonType> dialog;
	public static String helpText = 
			"\t\t О Сапёре\r\n"
			+ "Истоки Сапёра (Minesweeper) берут начало в 1960-х годов, когда его ранние версии устанавливались на компьютерах типа"
			+ " мейнфреймов. Игра Сапёр стал популярным благодаря включению его в качестве стандартного элемента в операционную "
			+ "систему Windows 3.1 как инструмент, помогающий пользователям узнать, как использовать мышь \r\n"
			+ "\t\t Правила игры\r\n"
			+ "В начале игры у игрока есть планшет, заполненный закрытыми квадратными полями. Некоторые из этих полей скрывают мины, "
			+ "а некоторые нет. Задача игрока – определить под каким  полем скрывается мина и помечать эти поля. Игрок должен также"
			+ " открыть те поля, где нет мин. Если игрок открывает поле с миной, он проигрывает. Если игрок открывает поле без мины,"
			+ " появляется номер, указывающий, сколько мин находится в восьми соседних полях. Базируясь на этих числах, игрок должен "
			+ "определить, где находятся мины. Цель игры - нахождение всех мин, посредством открытия полей, в которых нет мин.\r\n"
			+ "\t\t Уровни сложности \r\n" 
			+ " - новичок – поле размером 9×9, где спрятаны 10 мин\n"
			+ " - любитель – поле размером 16×16, где спрятаны 40 мин\n"
			+ " - профессионал – поле 16×30, где спрятаны 99 мин\n"
			+ " - суперпрофессионал – поле 30×30, где спрятаны 180 мин\n"
			+ " - crazy – поле 30×60, где спрятаны 400 мин\n"
			+ "\t\t Управление \r\n"
			+ " - левая кнопка мыши - открыть поле, \n"
			+ " - правая кнопка мыши - назначить или снять флаг, обозначающий мину в данном поле\n"
			+ "\tСохранение параметров игры происходит автоматически при выходе из приложения\n"
			+ "\tСохранение записи в таблице рекордов происходит при нажатии кнопки в поле введения имени или при закрытии окна "
			+ "при нажатии \"ОК\" или крестика \n"
			+ "\tСохранение параметров игры происходит автоматически при выходе из приложения\n"
			+ " - не открывать пустую область в начале игры - настройка по умолчанию"
			+ " - Открыть "
			+ " мина. В этом случае открытая мина мигает в течение трех секунд, давая игроку время отметить ее. Если он этого не сделает, он проиграет. Включение этой опции даже на мгновение во время игры способствует тому, что игра становится «игрой с поддержкой».</p>\r\n"
			+ "<p><b>Подсказка</b> – она указывает игроку, какие из до сих пор неоткрытых полей должны быть открыты или помечены. Алгоритм генерирования подсказок не имеет доступа к неоткрытым полям - он знает только то, что знает игрок, и предполагает, что игра до настоящего времени разыгрывалась правильно. Это означает, что если игрок ранее неправильно отметил какое-либо поле, подсказка, основанная на этой ошибке, также будет неправильной. Кроме того, подсказка не будет генерироваться, если на планшете нет детерминированного движения, и единственным решением является произвести случайный выбор. Следовательно, действие подсказки гарантируется только в том случае, если игрок находится в режиме «чистой логики». Любая попытка использовать подсказку рассматривается как «поддержка».</p>\r\n"
			+ "<p><b>Мошенничество</b> – игрок может просто обманывать и открыть / отметить каждое выбранное поле в зависимости от того, находится под ним мина или нет. Это также классифицируется как «поддержка».</p>\r\n"
			+ "<p><b>Игра с поддержкой</b> – игра классифицируется как игра с поддержкой, если игрок использует один из трех упомянутых выше методов помощи во время игры. Статистика игр с поддержкой ведется отдельно.</p>\r\n"
			+ "<p><b>Сохранение состояния игры</b> – чтобы сохранить игру, просто закройте окно интернет-браузера. Повторный вход на страницу Сапёра позже автоматически восстановит состояние игры.</p>\r\n"
			+ "<p><h2>Управление игрой</h2></p>";
	@FXML
	private RadioButton novichRadioButtonToogl2FxId;
	@FXML
	private RadioButton amateurRadioButToogl2FxId;
    @FXML
    private RadioButton profRadioButToog2FxId;
    @FXML
    private RadioButton superprofRadioButToog2FxId;
    @FXML
	private RadioButton crazyRadioButToog2FxId;
    @FXML
    public Label labelCounterMinesFXID;
    
   
 //--------------------------------------МЕНЮ ПАРАМЕТРЫ--------------------------------------------------------------------------//
    	// Загрузка сцены параметрами при нажатии Меню - Параметры
    @FXML
    void menuParamClick(MouseEvent event) {
    	dialog = new Dialog<ButtonType>();
    	DialogPane dialogPane = null;
    	try {
			dialogPane = (DialogPane)FXMLLoader.load(getClass().getResource("/UI_FXML_files/ParametersDialogPane.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
    	
    		// Внесение параметров настроек из последних сохранений настроек
    	ObservableList<Node> obl = dialogPane.getChildren();
    	VBox vb = (VBox)obl.get(5);
    	ObservableList<Node> vboxChild= vb.getChildren();
    	RadioButton a1 = (RadioButton)vboxChild.get(1);		a1.setSelected(Main.currentParameters.notOpenEmtyArea);
    	RadioButton a2 = (RadioButton)vboxChild.get(2);		a2.setSelected(Main.currentParameters.openRandomEmtyArea);
    	RadioButton a3 = (RadioButton)vboxChild.get(3);		a3.setSelected(Main.currentParameters.openMaxEmtyArea);
    	RadioButton a4 = (RadioButton)vboxChild.get(4);		a4.setSelected(Main.currentParameters.openHint);
    	CheckBox a5 = (CheckBox)vboxChild.get(6);			a5.setSelected(Main.currentParameters.openAllCellsInTheEnd);
    	a1.setSelected(Main.currentParameters.notOpenEmtyArea);
    	a2.setSelected(Main.currentParameters.openRandomEmtyArea);
    	a3.setSelected(Main.currentParameters.openMaxEmtyArea);
    	a4.setSelected(Main.currentParameters.openHint);
    	a5.setSelected(Main.currentParameters.openAllCellsInTheEnd);
    		// Обработка и сохранение текущего выбора настроек    Сохранение их в файл будет при выходе из игры
    	dialog.setOnCloseRequest(new EventHandler<DialogEvent>() {
			@Override
			public void handle(DialogEvent event) {
				Main.currentParameters.notOpenEmtyArea = false;
				Main.currentParameters.openRandomEmtyArea = false;
				Main.currentParameters.openMaxEmtyArea = false;
				Main.currentParameters.openHint = false;
				Main.currentParameters.openAllCellsInTheEnd = false;
				if (a1.isSelected()) Main.currentParameters.notOpenEmtyArea = true;
				if (a2.isSelected()) Main.currentParameters.openRandomEmtyArea = true;
				if (a3.isSelected()) Main.currentParameters.openMaxEmtyArea = true;
				if (a4.isSelected()) Main.currentParameters.openHint = true;
				if (a5.isSelected()) Main.currentParameters.openAllCellsInTheEnd = true;
//				System.out.println("Main.currentParameters.notOpenEmtyArea = " + Main.currentParameters.notOpenEmtyArea);
//		    	System.out.println("Main.currentParameters.openRandomEmtyArea = " +  Main.currentParameters.openRandomEmtyArea);
//		    	System.out.println("Main.currentParameters.openMaxEmtyArea = " + Main.currentParameters.openMaxEmtyArea);
//		    	System.out.println("Main.currentParameters.openHint = " + Main.currentParameters.openHint);
//		    	System.out.println("Main.currentParameters.openAllCellsInTheEnd = " + Main.currentParameters.openAllCellsInTheEnd);
			}
		});
    	dialog.setResizable(false);
    	dialog.setDialogPane(dialogPane);
		dialog.show();
    }
    
 //---------------МЕНЮ ПАРАМЕТРЫ--------Обработчик кнопки "Сделать настройки по умолчанию)--------------------------------
    @FXML
    void defaultRulesClick(ActionEvent event) {
    	dialog.close();
    	Main.currentParameters.notOpenEmtyArea = true;
		Main.currentParameters.openRandomEmtyArea = false;
		Main.currentParameters.openMaxEmtyArea = false;
		Main.currentParameters.openHint = false;
		Main.currentParameters.openAllCellsInTheEnd = false;
		menuParamClick(null);
    }
    
 //---------------------------------------МЕНЮ РЕКОРДЫ--------------------------------------------------------------------------    
    @FXML
    void statisticClick(MouseEvent event) {
 	   Dialog<ButtonType> dialogStat = new Dialog<ButtonType>();
   	   DialogPane dialogPane = new DialogPane();
   	   dialogPane.getButtonTypes().add(new ButtonType("OK", ButtonData.CANCEL_CLOSE));
   	   dialogPane.setMinWidth(850);
   	   dialogPane.setMinHeight(500);
   	   	Label lbl1 = new Label("ТАБЛИЦА РЕКОРДОВ");
   	   lbl1.setPadding(new Insets(20, 5, 5, 10));		
   	   lbl1.setTextAlignment(TextAlignment.CENTER);
   	   lbl1.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 18));
   	   lbl1.setTextFill(Color.DARKRED);
   	   lbl1.setAlignment(Pos.CENTER);
   	   dialogPane.setContent(Records.printRecord());
   	   dialogPane.setHeader(lbl1);
   	   dialogStat.setResizable(false);
    	   dialogStat.setDialogPane(dialogPane);
   	   dialogStat.show();
 	}
    
 //-------------------------------------- ОБРАБОТЧИК ВЫБОРА ПОЛЯ "СПРАВКА" ИЗ СТАРТОВОЙ СЦЕНЫ----------------------------------------
    @FXML
    void helpMenuBarClick(MouseEvent event) {
     	Scene currentScene = (Scene)application.Main.primaryStage.getScene();		// Достаем текущую сцену
     	BorderPane root = (BorderPane)currentScene.getRoot();						// Достаем корневой Pane сцены
     	Node center = root.getCenter();				// Сохраняем центральный и нижний элемент, чтобы можно было их снова загрузить 
     	Node bottom = root.getBottom();
     	
     	Label label = new Label("СПРАВКА");
     	TextArea textHelp = new TextArea(helpText.toString());
     	textHelp.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(1), new Insets(10))));
     	textHelp.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
     	textHelp.setWrapText(true);
     	textHelp.setEditable(false);
     	textHelp.setId("helpTextId");
     	    	
     	Image img1 = null;;
     	try { 
     		img1 = new Image(getClass().getResourceAsStream("/Resources/png-arrow-back.png"));
     		if (img1.isError()) new RuntimeException();		
     		}
     	catch (Exception e) {
     		System.out.println("Не удалось загрузить изображение");
     		return; }
     	ImageView imf1 = new ImageView(img1);
     	imf1.setBlendMode(BlendMode.DARKEN);
     	imf1.setFitHeight(40);
     	imf1.setPreserveRatio(true);
     	
     	Button btnBack2 = new Button();
     	btnBack2.setId("btnBackId2");
     	btnBack2.setGraphic(imf1);
     	btnBack2.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
 			public void handle(ActionEvent event) {
 				root.setCenter(center);
 				root.setBottom(bottom);
 			}
 		});
     	HBox hbox = new HBox();
     	hbox.getChildren().addAll(btnBack2);
     	hbox.setAlignment(Pos.BOTTOM_LEFT);
     	VBox vbox = new VBox();
     	vbox.setPadding(new Insets(10, 10, 10, 10));
     	vbox.setAlignment(Pos.CENTER);
     	vbox.setSpacing(10);
     	VBox.setVgrow(textHelp, Priority.ALWAYS);
     	vbox.getChildren().addAll(label, textHelp, hbox);
     	root.setCenter(vbox);
     	root.setBottom(null);
       }
    
 // -------------------------Определение кол-ва мин, размера ячейки в зависисимости от сложности------------------------------------------------//   
   public void levelChoise() {
	   if (novichRadioButtonToogl2FxId.isSelected()) {
		   Main.xNumberOfCells = 9;
		   Main.yNumberOfCells = 9;
		   Main.sizeCell = 35;
		   Main.numberMines = 10;
		   Main.primaryStage.setWidth(650);
		   Main.primaryStage.setHeight(530);
	   }
	   if (amateurRadioButToogl2FxId.isSelected()) {
		   Main.xNumberOfCells = 16;
		   Main.yNumberOfCells = 16;
		   Main.sizeCell = 30;
		   Main.numberMines = 40;
		   Main.primaryStage.setWidth(680);
		   Main.primaryStage.setHeight(680);
	   }
	   if  (profRadioButToog2FxId.isSelected()) {
		   Main.xNumberOfCells = 16;
		   Main.yNumberOfCells = 30;
		   Main.sizeCell = 30;
		   Main.numberMines = 99;
		   Main.primaryStage.setWidth(980);
		   Main.primaryStage.setHeight(680);
	   }
	   if (superprofRadioButToog2FxId.isSelected()) {
		   Main.xNumberOfCells = 30;
		   Main.yNumberOfCells = 30;
		   Main.sizeCell = 18;
		   Main.numberMines = 180;
		   Main.primaryStage.setWidth(650);
		   Main.primaryStage.setHeight(730);
	   }
	   if (crazyRadioButToog2FxId.isSelected()) {
		   Main.xNumberOfCells = 30;
		   Main.yNumberOfCells = 60;
		   Main.sizeCell = 18;
		   Main.numberMines = 400;
		   Main.primaryStage.setWidth(1150);
		   Main.primaryStage.setHeight(730);
	   }
   }
  
 //----------------------ОБРАБОТЧИК ЗАПУСКА ИГРЫ---------Вызов сцены GameScene-------------------------------------------------
   @FXML
   public void playButtonClick(ActionEvent event) {
	   startGame = LocalTime.now();
	   FXMLLoader loader = new FXMLLoader(Main.class.getResource("/UI_FXML_files/GameScene.fxml"));
	   BorderPane root = null;
	   try {
			root = loader.load(); }
	   catch (IOException e) {
			e.printStackTrace(); }
	   if (Main.numberMines == 0) levelChoise();
	   			// Доступ к FXML файлу   Для получения ссылки на Label с числом мин и Label с временем
	   Map<String, Object> fxmlNamespace = loader.getNamespace(); 
	   lb = (Label)fxmlNamespace.get("labelCounterMinesFXID");
	   lb.setText(Integer.toString(Main.numberMines));
	   timerLabel = (Label)fxmlNamespace.get("timerLabelFXID");
	   timer = new Timer(true);
	   timer.schedule(new MyTimerTask(timerLabel), 0, 1000);

	   Engine.newGridPaneAndField(root);
	   Scene scene = new Scene(root);
	   
	   Main.primaryStage.setY(10);
	   Main.primaryStage.setX(100);
	   Main.primaryStage.setScene(scene);
	   Main.primaryStage.show();	   
   }
   
//------------------------------------------------------СОХРАНЕНИЕ ИГРЫ---------------------------------------------------
   @FXML
   void saveGameClick(ActionEvent event) {
	   GridPaneModified gpmod = new GridPaneModified();
	   GridPaneModified.saveFile(gpmod);
	   System.out.println(MainSceneController.timerLabel.getText());
   }
   
   @FXML
   void loadGame(ActionEvent event) {
	   GridPaneModified gridPaneRead = GridPaneModified.read();
	   Engine.gridPane = gridPaneRead.gridPane;
	   Main.numberMines = gridPaneRead.numberMines;
	   Main.sizeCell = gridPaneRead.sizeCell;
	   Main.xNumberOfCells = gridPaneRead.xNumberOfCells;
	   Main.yNumberOfCells = gridPaneRead.yNumberOfCells;
	   Main.currentParameters = gridPaneRead.currentParameters;
	   Engine.numberOfBombs = gridPaneRead.numberOfBombs;
	   Engine.numberOfCellsWithoutBombOpened = gridPaneRead.numberOfCellsWithoutBombOpened;
	   MainSceneController.startGame = gridPaneRead.startGame;
	   MainSceneController.endGame = gridPaneRead.endGame;
	   MainSceneController.timerLabel = gridPaneRead.timerLabel;
	   MainSceneController.lb = gridPaneRead.lb;
//	   MainSceneController.timer = gridPaneRead.timer;
	   System.out.println("MainSceneController.timerLabel = " + MainSceneController.timerLabel);
	   System.out.println(MainSceneController.timerLabel.getText());
	   System.out.println(Main.sizeCell);
	   
	   startGame = LocalTime.now();
	   FXMLLoader loader = new FXMLLoader(Main.class.getResource("/UI_FXML_files/GameScene.fxml"));
	   BorderPane root = null;
	   try {
			root = loader.load(); }
	   catch (IOException e) {
			e.printStackTrace(); }
	   if (Main.numberMines == 0) levelChoise();
	   Map<String, Object> fxmlNamespace = loader.getNamespace(); 
	   lb = (Label)fxmlNamespace.get("labelCounterMinesFXID");
	   lb.setText(Integer.toString(Main.numberMines));
	   timerLabel = (Label)fxmlNamespace.get("timerLabelFXID");
	   timer = new Timer(true);
	   timer.schedule(new MyTimerTask(timerLabel), 0, 1000);
	   
	   Engine.numberOfBombs = Main.numberMines;
	   Engine.numberOfCellsWithoutBombOpened = Main.xNumberOfCells*Main.yNumberOfCells - Main.numberMines;
	   root.setCenter(Engine.gridPane);
	   Scene scene = new Scene(root);
	   
	   Main.primaryStage.setY(10);
	   Main.primaryStage.setX(100);
	   Main.primaryStage.setScene(scene);
	   Main.primaryStage.show();	
   }

// -----------------------Метод-помощник выхода из игры---------Сохранение настроек игры для следующих игр-------------------------
   @FXML
   public static boolean btnClose_Click() {
		ButtonType yes = new ButtonType("ДА", ButtonData.YES);
		ButtonType no = new ButtonType("НЕТ", ButtonData.NO);
		Alert a = new Alert(Alert.AlertType.NONE, "Вы уверены, что хотите выйти?", yes, no);
		Optional<ButtonType> confirm = a.showAndWait();
		a.setResizable(false);
        
		if (confirm.isPresent() && confirm.get().getButtonData().equals(ButtonData.YES)) {
			Param param = new Param(Main.currentParameters.openAllCellsInTheEnd, Main.currentParameters.notOpenEmtyArea,
					Main.currentParameters.openRandomEmtyArea, Main.currentParameters.openMaxEmtyArea,
					Main.currentParameters.openHint);
			Param.record(param);
			return true;
		}
		else return false;
	}
  
 //-----------------------Метод выхода из игры------------------------------------------------------------------------------
   @FXML
   void btnClose_Click2(ActionEvent event) {
	   if(btnClose_Click())   {
		   Main.primaryStage.close();
	   }
   }
   
//-----------------------------ИГРОВАЯ СЦЕНА----------------------------------------------------------------------------------  
//-------------------------Обработка кнопки "Новая игра" на игровой сцене-----------------------------------------------------   
   @FXML
   void newGameButIdClick(ActionEvent event) {
   	MainSceneController mc = new MainSceneController();
   	mc.playButtonClick(event);
   }
   
   @FXML
   void backButClick(ActionEvent event) {
   	BorderPane root = null;
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("/UI_FXML_files/MainScene.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.numberMines = 0;
		Scene scene = new Scene(root,700,600);
		Main.primaryStage.setScene(scene);
   }
   
   @FXML
   void helpClickFromGameScene(MouseEvent event) {
	    Dialog<ButtonType> dialogHelp = new Dialog<ButtonType>();
   		DialogPane dialogPane = new DialogPane();
   		dialogPane.getButtonTypes().add(new ButtonType("OK", ButtonData.CANCEL_CLOSE));
   		dialogPane.setMinWidth(600);
   		dialogPane.setMinHeight(500);
        Label label = new Label("СПРАВКА");
        label.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        label.setAlignment(Pos.CENTER);
        dialogPane.setHeader(label);
		TextArea textHelp = new TextArea(helpText.toString());
		textHelp.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(1), new Insets(10))));
		textHelp.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
		textHelp.setWrapText(true);
		textHelp.setEditable(false);
		dialogPane.setContent(textHelp);
		dialogHelp.setResizable(false);
		dialogHelp.setDialogPane(dialogPane);
		dialogHelp.show();
   }
   
}

