package t33_Check_Box;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

/* Check box - контролер, чтобы "проставить галочки в предоставленном выборе"
  Например, набор наполнителей для пиццы из 3-х вариантов (можно выбрать от 1 до 3)
  В отличии от Check box при работе с RadioButton там можно выбрать только один из предложенных вариантов
  
  			КОНСТРУКТОРЫ:
 	- CheckBox() 						 - создает новый check box, которые изначально без выбранных полей
 	- CheckBox(String text)				 - создает новый check box с текстом
			МЕТОДЫ:
	- String getText() 				  					- возвращает текст, который был введен в это поле
	- boolean isSelected()								- возвращает true, если этот check box выбран/проверен 
	- void setOnAction(EventHandler<Action Event> value)- устанавливает ActionEvent listener для обращения с action events
	- void setSelected(boolean value) 					- выделяет этот сheck box сразу при true
	- void setText(String text) 						- добавляет текст в поле
	
Наследование: Object - Node - Parent- Region - Control - Labelled - ButtonBase - CheckBox		*/

	
public class Main extends Application {
	CheckBox chkPepperoni, chkMushrooms, chkAnchovies;
	Stage stage;
		
		@Override 
	public void start(Stage primaryStage) {
		stage = primaryStage;	
			
		Label lbl = new Label("Выбери наполнение пиццы");
		HBox paneLbl = new HBox(20, lbl);
		paneLbl.setAlignment(Pos.CENTER);
		paneLbl.setPadding(new Insets(10));		// Растояние от края = 10 пкс
		
			// Конструкторы 		
		chkMushrooms = new CheckBox();
		chkAnchovies = new CheckBox("Anchovies");
		chkPepperoni = new CheckBox("Pepperoni");
		
			// Этот CheckBox появится сразу с галочкой
		chkAnchovies.setSelected(true);							
		
			// Внесение надписи на кнопке
		chkMushrooms.setText("Mushrooms");	
		
			// Растояние между строками текста в кнопке
		chkMushrooms.setLineSpacing(2);
				
			// Выравнивание текста в кнопке
		chkMushrooms.setTextAlignment(TextAlignment.LEFT);			// По левому краю
		chkMushrooms.setTextAlignment(TextAlignment.JUSTIFY);		// По ширине
				
			// Растояние от внутренних границ области до текста и/или изображения внутри кнопки
		chkMushrooms.setStyle("-fx-label-padding: 5.0px;");
				
			// Задает изображение около надписи и его расположение относительно надписи внутри кнопки
		chkPepperoni.setGraphic(new ImageView("/img/icons.png"));
		chkPepperoni.setContentDisplay(ContentDisplay.TOP);				// Позиционирует изображение относительно текста
		chkPepperoni.setGraphicTextGap(2);								// Задает растояние между изображением и текстом
		chkPepperoni.setAlignment(Pos.CENTER);							// Задает выравнивание текста и изображения внутри области
//		Button btn4 = new Button("BUTTON4", imf);
		chkPepperoni.setContentDisplay(ContentDisplay.TOP);				// Только изображение
		
			// Установка фона и цвета текста кнопуи
		chkAnchovies.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		chkAnchovies.setTextFill(Color.WHITE);
				
			// Установка и настройка текста
		chkAnchovies.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20.0));	// Шрифт 
		chkAnchovies.setUnderline(true);														// Подчеркивание
						
			/* Задает перенос на другую строку
		Если true, то строка будет переноситься на другую
		Если false (по умолчанию), то строка будет обрезаться		 */
		chkAnchovies.setWrapText(false);
						
			// Задает строку, которая будет показываться при обрезке текста (если он не помещается на одной строке или внутри области)
		chkAnchovies.setEllipsisString("/..../");
				
			/* Задает режим обрезки (если текст не помещается на одной строке или внутри области)
		 - ELLIPSIS 				- текст обрезается в конце и добавляется значение свойства ellipsisString
		 - WORD_ELLIPSIS 			- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CENTER_ELLIPSIS 			- текст обрезается посередине и добавляется значение свойства ellipsisString
		 - CENTER_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - LEADING_ELLIPSIS 		- текст обрезается вначале и добавляется значение свойства ellipsisString
		 - LEADING_WORD_ELLIPSIS 	- аналогично ELLIPSIS, но текст обрезается между словами, а не в любом месте слова
		 - CLIP 					- текст просто обрезается в конце					 */
		chkAnchovies.setTextOverrun(OverrunStyle.ELLIPSIS);
				
		
		chkPepperoni.setOnAction(e -> chkPepperoni_Click() );	// Метод - при выборе этого CheckBox вылетает сообщение, что невозможно	
		HBox panePicca = new HBox(20, chkMushrooms, chkAnchovies, chkPepperoni);
		panePicca.setAlignment(Pos.CENTER);
		panePicca.setPadding(new Insets(10));		
		
		Button btnOK = new Button("OK");
		btnOK.setMinWidth(75);
		Button btnCancel = new Button("Cancel");
		btnCancel.setMinWidth(75);
		btnOK.setOnAction(e -> btnOK_Click() );
		btnCancel.setOnAction(e -> btnCancel_Click() );
		HBox buttonBox = new HBox(20, btnOK, btnCancel);
		buttonBox.setAlignment(Pos.CENTER_RIGHT);
		buttonBox.setPadding(new Insets(10));		// Растояние от края = 10 пкс
		
		VBox pane = new VBox(10, paneLbl, panePicca, buttonBox);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ВЫБОР ПИЦЦЫ");
		primaryStage.show();
	}
		
	public void btnOK_Click() {
		String msg = "";
		if (chkPepperoni.isSelected()) 	msg += "Pepperoni\n";
		if (chkMushrooms.isSelected()) 	msg += "Mushrooms\n";
		if (chkAnchovies.isSelected()) 	msg += "Anchovies\n";
		if (msg.equals("")) 	msg = "You didn't order any toppings.";
		else msg = "You ordered these toppings:\n" + msg;
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("Your Order");
		a.showAndWait();
		chkPepperoni.setSelected(false);
		chkMushrooms.setSelected(false);
		chkAnchovies.setSelected(false);
		}
	
	public void chkPepperoni_Click() {
		Alert a = new Alert(Alert.AlertType.WARNING, "We don't do anchovies here.");
		a.setTitle("Yuck!");
		a.showAndWait();
		chkPepperoni.setSelected(false);
	}
	
	public void btnCancel_Click() {
		stage.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}