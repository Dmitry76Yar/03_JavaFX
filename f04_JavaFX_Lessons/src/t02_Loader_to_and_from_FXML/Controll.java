package t02_Loader_to_and_from_FXML;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controll {
	
	private Stage primaryStage;
	private String toTransfer;
	
	public Controll () {
		super();
	}

	public Controll(Stage primaryStage, String toTransfer) {
		super();
		this.primaryStage = primaryStage;
		this.toTransfer = toTransfer;
		System.out.println(" В конструктор был передан параметр toTransfer = " + toTransfer);
	}

	@FXML
    private Button ButtonId;

    @FXML
    private Label LabelFxId;

    @FXML
    void btnClick(MouseEvent event) {
    	System.out.println("toTransfer = " + toTransfer);
    }

}
