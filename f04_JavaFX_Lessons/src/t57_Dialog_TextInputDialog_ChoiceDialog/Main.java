package t57_Dialog_TextInputDialog_ChoiceDialog;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
			/* ���������� ���� ����� ��� �������������� ������������, � ����� ��� ��������� ������ �� ������������. 
		� ����������� ������ ����������� ���� �������� ���������� (�.�. ������������ ��� ���� ���������� ��� ������ �����. ����	 
		 ����� Dialog<R> ��������� ������� ���������������� ���������� ����*/
			
//---------------------------------------------DIALOG---------------------------------------------------------------------
			// ������ �������� ���� � ���������� ��� ������� ������
		Button btn51 = new Button("Dialog window");
		btn51.setOnAction(event -> {
			Dialog<ButtonType> dialog = new Dialog<ButtonType>();
			dialog.setTitle("��������� ����");
			dialog.setHeaderText("����� ��������� ����");		// ��� null -�� ����� ������
			dialog.setGraphic(new Rectangle(10,10,Color.ALICEBLUE));
			dialog.setContentText("����� ���������");
			
				// �������������� � �������
			dialog.setX(300);		dialog.setY(300);
			dialog.setWidth(200);	dialog.setHeight(150);
			dialog.setResizable(true);	
			
				//���������� ������ ������ ����������� ���� getButtonTypes() �� ������ DialogPane
			dialog.getDialogPane().getButtonTypes().add(ButtonType.NEXT);
			dialog.getDialogPane().getButtonTypes().add(ButtonType.PREVIOUS);
			dialog.getDialogPane().getButtonTypes().add(new ButtonType("������ ", ButtonData.CANCEL_CLOSE));
			dialog.getDialogPane().getButtonTypes().add(new ButtonType("BTN"));
			
				// ��� ��������� ������� ������
			Node btnOk =  dialog.getDialogPane().lookupButton(ButtonType.OK);
			if (btnOk != null) btnOk.setDisable(false);		// ������ ������ ���������� 
			
				/* ��������� ���������� ������� ������������
			����� �������� ����������� ���� ������ ����� ����������, ����� ������ ����� ������������, � �������� ������ �� 
			��������� ����. ��� ������ ������ showAndWait() ���������� ���� ������������ � ����� ������� ������ �������������
			����� ���������� ������ ������ Optional<R> ������ �������� ���������� ��������� 		 */
			Optional<ButtonType> result1 = dialog.showAndWait();
			if (result1.isPresent()) {
				if (result1.orElseThrow().getButtonData() == ButtonData.OK_DONE) 
					System.out.println("������ ������ OK");
				else if (result1.orElseThrow().getButtonData() == ButtonData.NEXT_FORWARD) 
					System.out.println("������ ������ NEXT");
				else if (result1.orElseThrow().getButtonData() == ButtonData.BACK_PREVIOUS) 
					System.out.println("������ ������ PREVIOUS");
				else if (result1.orElseThrow().getButtonData() == ButtonData.CANCEL_CLOSE) 
					System.out.println("������ ������ CANCEL");
				
			}
			dialog.show();
			
	//			// ���������� ��� ��������
	//		dialog.setOnCloseRequest(e -> {
	//			Alert alert = new Alert(AlertType.CONFIRMATION, "������������� ������ ������� ����?");
	//			alert.setTitle("�������� ����");
	//			alert.setHeaderText(null);
	//			Optional<ButtonType> result = alert.showAndWait();
	//			if (result.isPresent() && result.get() == ButtonType.OK) 
	//				System.out.println("���� ����� �������");
	//			else {
	//				System.out.println("���� �� ����� �������");
	//				e.consume();
	//			}
	//		});
	//		dialog.show();
		});
		
/*------------------------------DIALOG PANE--------------------------------------------------------------------------------
 		���������� ����������� ���� ������������� ������ ����������, ������������ � ������� ������ DialogPane 
 		������������ Object - Node - Parent - Region - Pane - DailogPane*/
		
		Button btn52 = new Button("DialogPane window");
		btn52.setOnAction(event1 -> {
			Dialog<ButtonType> dialog1 = new Dialog<ButtonType>();
			dialog1.setTitle("��������� ����");
			
			DialogPane dialogPane = dialog1.getDialogPane();
			dialogPane.setHeaderText("����� ��������� ����");		// ��� null -�� ����� ������
			dialogPane.setGraphic(new Rectangle(10,10,Color.ALICEBLUE));
			dialogPane.setContentText("����� ���������");
			dialogPane.setExpandableContent(new Label("������� ����"));		// ������ ���� � ����������� �������
			dialogPane.setExpanded(false);									// ��� true ����������� ������� ����� ��������
			dialogPane.getButtonTypes().add(ButtonType.OK);
//			dialogPane.setContent(new Button("fvdvdf"));
			
//			dialog.setOnCloseRequest(e -> {
//				Alert alert = new Alert(AlertType.CONFIRMATION, "������������� ������ ������� ����?");
//				alert.setTitle("�������� ����");
//				alert.setHeaderText(null);
//				Optional<ButtonType> result = alert.showAndWait();
//				if (result.isPresent() && result.get() == ButtonType.OK) 
//					System.out.println("���� ����� �������");
//				else {
//					System.out.println("���� �� ����� �������");
//					e.consume();
//				}
//			});
			dialog1.show();
		});
		
/*------------------------------TextInput Dialog--------------------------------------------------------------------------------
 	����� TextInputDialog ��������� ����� Dialog � ���������� ��������� ���������� ���� � ��������� �����
 	Obect - Dialog<String> - TextInputDialog  */
	Button btn53 = new Button("TextInputDialog1");
	Button btn54 = new Button("TextInputDialog2");
	TextInputDialog tid1 = new TextInputDialog();
	TextInputDialog tid2 = new TextInputDialog("����� � ���� �� ���������");
	btn53.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			tid2.setTitle("HEADER");
			tid2.setHeaderText("Enter a value");
			TextField texftfield = tid2.getEditor();			// �������� ������ �� �����
			texftfield.setPrefWidth(200);
			Optional<String> result = tid1.showAndWait();
			if (result.isPresent()) System.out.println(result.get());
			else System.out.println("Entered Exit");
		}
	});
	
/*------------------------------ChoiceDialog--------------------------------------------------------------------------------
����� ChoiceDialog ��������� ����� Dialog<R> � ���������� ��������� ���������� ���� � ��������������� �������
Obect - Dialog<T> - ChoiceDialog<T>  */
	Button btn55 = new Button("ChoiceDialog");
		/* ������������
	ChoiceDialog choicedialog1 = new ChoiceDialog();
	ChoiceDialog choicedialog2 = new ChoiceDialog(T defaultChoice, T...choices");  
	ChoiceDialog choicedialog3 = new ChoiceDialog(T defaultChoice, Collection<T> choices");  */
	Label label1 = new Label("First choice");
	Label label2 = new Label("Secong choice");
	btn55.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			ChoiceDialog<Label> choicedialog1 = new ChoiceDialog<Label>();
			choicedialog1.getItems().addAll(label1, label2);
			System.out.println(choicedialog1.getDefaultChoice());
			choicedialog1.setTitle("HEADER");
			choicedialog1.setHeaderText("CHOISE THE VALUE");
			choicedialog1.setContentText("&&&&&");
			Optional<Label> result = choicedialog1.showAndWait();
			if (result.isPresent()) System.out.println(result.get());
			else System.out.println("Entered Exit");
		}
	});
		
		HBox hb51 = new HBox();
		hb51.getChildren().addAll(btn51, btn52, btn53, btn55);
		Scene scene = new Scene(hb51, 650, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Click Counter");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
