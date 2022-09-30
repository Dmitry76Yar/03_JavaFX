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
			/* Диалоговые окна нужны для информирования пользователя, а также для получения данных от пользователя. 
		В большинстве случае диаологовые окна являются модальными (т.е. блокирующими все окна приложения или только родит. окно	 
		 Класс Dialog<R> позволяет создать пользовательское диалоговое окно*/
			
//---------------------------------------------DIALOG---------------------------------------------------------------------
			// Пример создания окна с сообщением при нажатии кнопки
		Button btn51 = new Button("Dialog window");
		btn51.setOnAction(event -> {
			Dialog<ButtonType> dialog = new Dialog<ButtonType>();
			dialog.setTitle("ЗАГОЛОВОК ОКНА");
			dialog.setHeaderText("Текст заголовка окна");		// при null -не будет текста
			dialog.setGraphic(new Rectangle(10,10,Color.ALICEBLUE));
			dialog.setContentText("Текст сообщения");
			
				// Местоположение и размеры
			dialog.setX(300);		dialog.setY(300);
			dialog.setWidth(200);	dialog.setHeight(150);
			dialog.setResizable(true);	
			
				//Добавление кнопок внутрь диалогового окна getButtonTypes() из класса DialogPane
			dialog.getDialogPane().getButtonTypes().add(ButtonType.NEXT);
			dialog.getDialogPane().getButtonTypes().add(ButtonType.PREVIOUS);
			dialog.getDialogPane().getButtonTypes().add(new ButtonType("Отмена ", ButtonData.CANCEL_CLOSE));
			dialog.getDialogPane().getButtonTypes().add(new ButtonType("BTN"));
			
				// Для изменения свойств кнопок
			Node btnOk =  dialog.getDialogPane().lookupButton(ButtonType.OK);
			if (btnOk != null) btnOk.setDisable(false);		// Делать кнопку неактивной 
			
				/* Получение результата отклика пользователя
			После сокрытия диаолгового окна частно нужно определить, какую кнопку нажал пользователь, и получить данные из 
			диалового окна. При вызове метода showAndWait() диалоговое окно отображается и после нажатия кнопки пользователем
			метод возвращает объект класса Optional<R> внутри которого содержится результат 		 */
			Optional<ButtonType> result1 = dialog.showAndWait();
			if (result1.isPresent()) {
				if (result1.orElseThrow().getButtonData() == ButtonData.OK_DONE) 
					System.out.println("Нажата кнопка OK");
				else if (result1.orElseThrow().getButtonData() == ButtonData.NEXT_FORWARD) 
					System.out.println("Нажата кнопка NEXT");
				else if (result1.orElseThrow().getButtonData() == ButtonData.BACK_PREVIOUS) 
					System.out.println("Нажата кнопка PREVIOUS");
				else if (result1.orElseThrow().getButtonData() == ButtonData.CANCEL_CLOSE) 
					System.out.println("Нажата кнопка CANCEL");
				
			}
			dialog.show();
			
	//			// Обработчик при закрытии
	//		dialog.setOnCloseRequest(e -> {
	//			Alert alert = new Alert(AlertType.CONFIRMATION, "Действительно хотите закрыть окно?");
	//			alert.setTitle("Закрытие окна");
	//			alert.setHeaderText(null);
	//			Optional<ButtonType> result = alert.showAndWait();
	//			if (result.isPresent() && result.get() == ButtonType.OK) 
	//				System.out.println("Окно будет закрыто");
	//			else {
	//				System.out.println("Окно не будет закрыто");
	//				e.consume();
	//			}
	//		});
	//		dialog.show();
		});
		
/*------------------------------DIALOG PANE--------------------------------------------------------------------------------
 		Содержимое диалогового окна располагается внутри контейнера, реализуемого с помощью класса DialogPane 
 		Наследование Object - Node - Parent - Region - Pane - DailogPane*/
		
		Button btn52 = new Button("DialogPane window");
		btn52.setOnAction(event1 -> {
			Dialog<ButtonType> dialog1 = new Dialog<ButtonType>();
			dialog1.setTitle("ЗАГОЛОВОК ОКНА");
			
			DialogPane dialogPane = dialog1.getDialogPane();
			dialogPane.setHeaderText("Текст заголовка окна");		// при null -не будет текста
			dialogPane.setGraphic(new Rectangle(10,10,Color.ALICEBLUE));
			dialogPane.setContentText("Текст сообщения");
			dialogPane.setExpandableContent(new Label("Скрытый узел"));		// задает узел в расширяемой области
			dialogPane.setExpanded(false);									// при true расширяемая область будет показана
			dialogPane.getButtonTypes().add(ButtonType.OK);
//			dialogPane.setContent(new Button("fvdvdf"));
			
//			dialog.setOnCloseRequest(e -> {
//				Alert alert = new Alert(AlertType.CONFIRMATION, "Действительно хотите закрыть окно?");
//				alert.setTitle("Закрытие окна");
//				alert.setHeaderText(null);
//				Optional<ButtonType> result = alert.showAndWait();
//				if (result.isPresent() && result.get() == ButtonType.OK) 
//					System.out.println("Окно будет закрыто");
//				else {
//					System.out.println("Окно не будет закрыто");
//					e.consume();
//				}
//			});
			dialog1.show();
		});
		
/*------------------------------TextInput Dialog--------------------------------------------------------------------------------
 	Класс TextInputDialog наследует класс Dialog и отображает модальное диалоговое окно с текстовым полем
 	Obect - Dialog<String> - TextInputDialog  */
	Button btn53 = new Button("TextInputDialog1");
	Button btn54 = new Button("TextInputDialog2");
	TextInputDialog tid1 = new TextInputDialog();
	TextInputDialog tid2 = new TextInputDialog("текст в поле по умолчанию");
	btn53.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			tid2.setTitle("HEADER");
			tid2.setHeaderText("Enter a value");
			TextField texftfield = tid2.getEditor();			// Получить ссылку на текст
			texftfield.setPrefWidth(200);
			Optional<String> result = tid1.showAndWait();
			if (result.isPresent()) System.out.println(result.get());
			else System.out.println("Entered Exit");
		}
	});
	
/*------------------------------ChoiceDialog--------------------------------------------------------------------------------
Класс ChoiceDialog наследует класс Dialog<R> и отображает модальное диалоговое окно с раскрыввающимся списком
Obect - Dialog<T> - ChoiceDialog<T>  */
	Button btn55 = new Button("ChoiceDialog");
		/* Конструкторы
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
