package t19_Close_of_App;
	
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

/* ���������� ���� ��� �������� ��������� ������ ��������:
   - ���������� ��������� ������, ������� ����, �� ��� �������� ���������
   - ����������� ��������� ���� ������������� � ��������, ��� ����� ������� ����� Alert.ConfirmationBox  
   - ���� ������������ ����� ���������� ������ � ��� ������, ���� ���� �� �������� ����������
   - ���� ���� ������������� �������, �� ������ ���� ��������� ��� ����������� ����� (��������� ����������, ���������� �������� ��� ������...)
   - ����� ����������� ������ ������ ���� ������ primary stage�s close �����
   			������� ������ (�� ������������ ������� �������� ����� � ������ ����) ����� �������� ��������� ������
   	private void btnClose_Click() { 
   		boolean reallyQuit = false;
   		reallyQuit = ConfirmationBox.show("Are you sure you want to quit?", "Confirmation", "Yes", "No");
   		if (reallyQuit) stage.close();  }
   			��� ����������� �������� ������ ����� � � ������ ������� ����:
   	��� ������� ����� � Java ������� �loseRequest event, ������� ���������� � stage. 
   	����� ������� event handler ��� ����� �loseRequest event � ������� ������ ������ setOnCloseRequest() � ���������� ��� ������� �������
   		primaryStage.setOnCloseRequest( e -> btnClose_Click () );
   			� ���������, �� ��������� ���������� �������� ��� ������ ������ � ��� �loseRequest event � ������� ���� ���� � ���������� ������� btnClose_Click()
   		btnClose.setText("Close");
		btnClose.setOnAction( e -> btnClose_Click () );
		primaryStage.setOnCloseRequest( e -> btnClose_Click () );
	��� ��� btnClose_Click event ���������� ���� ������������� and closes the stage only if the user confirms that she really wants
	to quit the program. That�s because when the event handler for the CloseRequest event ends, JavaFX automatically closes the stage 
	if the event handler doesn�t explicitly close the stage.
		To prevent that from happening, you call the consume method of the Close Request event object. Consuming the event causes it to be
	stopped in its tracks within the event handler, thus preventing JavaFX from automatically closing the stage when the event handler ends.
    In the Lambda expression passed to the setOnCloseRequest method, the Close Request event object is represented by the argument e. 
    Thus, you can consume the CloseRequest event by calling e.consume().
    	btnClose.setText("Close");
		btnClose.setOnAction( e -> btnClose_Click () );
		primaryStage.setOnCloseRequest(	e -> { 
			e.consume();
			btnClose_Click ();
		} );   */

public class Main extends Application {
	Stage stage;
	int iClickCount = 0;
	
		@Override 
	public void start(Stage primaryStage) {	
		stage = primaryStage;
		Button btnClickMe = new Button();
		btnClickMe.setText("Click me please!");
		btnClickMe.setOnAction(e -> btnClickMe_Click());
		Button btnClose = new Button();
		btnClose.setText("Close");
		btnClose.setOnAction(e -> btnClose_Click());
		VBox pane = new VBox(10);
		pane.getChildren().addAll(btnClickMe, btnClose);
		pane.setAlignment(Pos.CENTER);

		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Click Counter");
		primaryStage.setOnCloseRequest( e -> {
			e.consume();
			btnClose_Click();
			} );
		primaryStage.show();
	}
	public void btnClickMe_Click() {
		iClickCount++;
		if (iClickCount == 1) {
			Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked once." );
			a.showAndWait();
		}
		else {
			Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked " + iClickCount + " times.");
			a.showAndWait();
		}
	}
	
	public void btnClose_Click() {
		Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit?", ButtonType.YES, ButtonType.NO);
		Optional<ButtonType> confirm = a.showAndWait();
		if (confirm.isPresent() && confirm.get() ==
		ButtonType.YES) stage.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
