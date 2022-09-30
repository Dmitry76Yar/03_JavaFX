package t16_EventHandler_Inner_Classes;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.event.*;

/* Handling an Action Event  - несколько cпособов, самый прямой - это через метод btn.setOnAction():
   метод вызыается при каждом нажатии на клавишу и исполняет те дейтсвия, которые указаны в его теле. 	
   Event  - объект, который создается, когда пользователь  взаимодействует с интерфейс-компонент.
   Затем Event объект передается в специальный объект Event Handler, в котором происходит определение по объекту какое
   действие было совершенно и формируется соответствующее действие
   Event Handler имплементирует интерфейс EventHandler, который определяет единственный метод handle()
   
   	    Широко используемые классы
   - ActionEvent - создается, когда юзер выполняет действие с кнопкой или другим компонентом. Обычно это кликанье мышкой по кнопке
   в интерфейсе, но также это может быть нажатие клавиши Enter и переключение на вкладку с кнопкой  Это НАИБОЛЕЕ широкоиспользуемый класс
   - InputEvent - создается, когда возникает event, связанный с кликаньем мыши или нажатием клавиши на клавиатуре
   - KeyEvent  - создается при нажатии клавиши на клавиатуре. Используется для просмотра определенных клавиш клавиатуры
                 (KeyEvent является подклассом InputEvent.)
   - MouseEvent - создается, когда юзер делает что-то интересное с мышью: кликанье по кнопке, перетаскивание мышью, или
   				  просто движение курсора мыши на объект.      
   				  (MouseEvent является подклассом InputEvent)
    - TouchEvent - создается, когда пользователь инициирует сенсорное событие на устройстве с сенсорным вводом
    - WindowEvent - создается при наличии изменении статуса окна (stage)    
    
    4 способо создания EventHandler объект
    - Добавить "implements EventHandler" к классу самой программы и написать имплементацию метода handle()
    - Создать внутренний класс, который "implements EventHandler" интерфейс
    - Создать анонимный класс, который "implements EventHandler" интерфейс
    - Использовать  лямбда выражение, чтобы написать имплементацию метода handle()    */

	// РЕАЛИЗАЦИЯ EventHandler через добвление "implements EventHandler" к классу самой программы
public class Main extends Application {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {		
			// Создание объекта ClickHandler
		ClickHandler ch = new ClickHandler();
		
		btnAdd = new Button();					 
		btnAdd.setText("Add");
		btnAdd.setOnAction(ch);
		
		btnSubtract = new Button();					 
		btnSubtract.setText("Substract");
		btnSubtract.setOnAction(ch);
		
		btnDivision = new Button();					 
		btnDivision.setText("Division");
		btnDivision.setOnAction(ch);
		
		btnMultiply = new Button();					 
		btnMultiply.setText("Multiply");
		btnMultiply.setOnAction(ch);
		
		lbl = new Label();
		lbl.setText(Double.toString(iCounter));
		
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btnAdd, btnSubtract, btnDivision, btnMultiply, lbl);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
 	}
	private class ClickHandler implements EventHandler <ActionEvent> {
			@Override public void handle(ActionEvent e) {
		if (e.getSource() == btnAdd) iCounter++;
		else if (e.getSource() == btnSubtract) iCounter--;
		else if (e.getSource() == btnDivision) iCounter = iCounter/2;
		else if (e.getSource() == btnMultiply) iCounter = iCounter*2;
		lbl.setText(Double.toString(iCounter));
		}
	}
public static void main(String[] args) {
	launch(args);
	}
}
