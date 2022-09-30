package t17_EventHandler_Lambda_Expression;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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

	/* РЕАЛИЗАЦИЯ EventHandler через лямбда выражение
   Lambda expression lets you create an anonymous class that implements a specific type of interface — a functional interface — which has one and
only one abstract method.
   The EventHandler interface used to handle JavaFX events meets that definition: It has just one abstract method, handle. Thus, EventHandler is
a functional interface and can be used with lambda expressions. */
public class Main extends Application {
	Button btnAdd, btnSubtract, btnDivision;
	Label lbl;
	double iCounter = 0;
	
		@Override 
	public void start(Stage primaryStage) {		
		/* При использовании лямбда-выражения не требуется знать метода, который вызывается, т.к. функциональный интерфейс, применяемый с 
		 лямбда-выраженеим может иметь единственный метод. В нашем случае с EventHandler interface - это метод handle.
		 Также не требуется знать название имлементируемого интерфейса, т.к. он определяется из контекста. Метод setOnAction возвращает
		 единственный параметра типа EventHandler, поэтому при использованиии лямбда-выражения в setOnAction, Java понимает, что 
		 лямбда-выражение имплементирует EventHandler interface и, соответственно, его единственный метод - handle(). 
	 Напротив, при использовании анонимного класса без лямбда-выражения нужно прописывать название интерфейса EventHandler и метода handle().  */
		btnAdd = new Button();					 
		btnAdd.setText("Add");
		btnAdd.setOnAction( e -> {
				iCounter++;
				lbl.setText(Double.toString(iCounter));
				} );
		
		/* Если в приложении используется много программируемых кнопок, то использование лямбда-выражений, как выше, громоздкое
		   В этом случае лучше прописывать процесс при вызове в отдельный метод, как указано ниже  		 */
		btnSubtract = new Button();					 
		btnSubtract.setText("Substract");
		btnSubtract.setOnAction( e -> btnSubtract_Click());
		
		btnDivision = new Button();					 
		btnDivision.setText("Division");
		btnDivision.setOnAction ( e -> btnDivision_Click());
		
		lbl = new Label();
		lbl.setText(Double.toString(iCounter));
		
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btnAdd, btnSubtract, btnDivision, lbl);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
 	}
	private void btnSubtract_Click(){
		iCounter++;
		lbl.setText(Double.toString(iCounter));
	}
	private void btnDivision_Click(){
		iCounter = iCounter/2;
		lbl.setText(Double.toString(iCounter));
	}
		
public static void main(String[] args) {
	launch(args);
	}
}
