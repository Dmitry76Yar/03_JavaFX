package Controllers;

import java.io.IOException;
import java.util.Map;

import application.Engine;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GameController {

	@FXML
    private Button backButFxId;

    @FXML
    private Button exitFxID;

    @FXML
    private MenuItem menuRulesFxId;

    @FXML
    private RadioMenuItem rbAmateurToog1FxId;

    @FXML
    private RadioMenuItem rbCrazyToog1FxId;

    @FXML
    private RadioMenuItem rbNovichToog1FxId;

    @FXML
    private RadioMenuItem rbProffesToog1FxId;

    @FXML
    private RadioMenuItem rbSuperProffesToog1FxId;

    @FXML
    private ToggleGroup toogleGr1;

    @FXML
    void btnClose_Click2(ActionEvent event) {

    }

    @FXML
    void menuNewGameSelect(ActionEvent event) {

    }

    @FXML
    void menuRulesAction(ActionEvent event) {

    }

    @FXML
    private Button newGameButFxId;
    
    @FXML
    void newGameButIdClick(ActionEvent event) {
    	MainSceneController mc = new MainSceneController();
    	mc.playButtonClick(event);
    }
    
    @FXML
    private HBox hboxMineCounterFXID;
    
    @FXML
    public Label labelCounterMinesFXID;
    
    @FXML
    private HBox hboxTimerAndCounterFXID;
    
    
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
    void exitClick(ActionEvent event) {
    	 if(MainSceneController.btnClose_Click())   Main.primaryStage.close();
    }
}