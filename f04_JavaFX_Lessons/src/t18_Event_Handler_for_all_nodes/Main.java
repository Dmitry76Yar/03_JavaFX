package t18_Event_Handler_for_all_nodes;
	
import java.util.Collections;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class Main extends Application {
	Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
	Label lb1, lb2;
		@Override 
	public void start(Stage primaryStage) {			
			/* Ниже пример быстрого поиска узла на примере назначения для всех кнопок единого обработчика события
			и реакция на него в зависимости от идентификатора кнопки
			Также ниже объяснено, как получить ссылку на объект scene, stage, pane имея ссылку на Node  */
			
		btn1 = new Button("First");		btn2 = new Button("Second");		btn3 = new Button("Third");
		btn4 = new Button("Fourth");	btn5 = new Button("Fiveth");		btn6 = new Button("Sixeth");
		btn7 = new Button("Seventh");	btn8 = new Button("Eigth");			btn9 = new Button("Neinth");		btn10 = new Button("10");
		
			// Назначение ID для быстрой идентификации Node
		btn1.setId("btn1");		btn2.setId("btn2");		btn3.setId("btn3");		btn4.setId("btn4");		btn5.setId("btn5");
		btn7.setId("btn7");		btn8.setId("btn8");		btn9.setId("btn9");		btn10.setId("btn10");
		System.out.println("Id для кнопки №1 - " + btn1.getId());
		
			// Назначение пользовательских данных для узлов
		btn1.setUserData("btn1 User");		btn2.setUserData("btn2 User");		btn3.setUserData("btn3 User");
		btn4.setUserData("btn4 User");		btn5.setUserData("btn5 User");		btn6.setUserData("btn6 User");
		btn7.setUserData("btn7 User");		btn8.setUserData("btn8 User");		btn9.setUserData("btn9 User");
		System.out.println("User date для кнопки №1 - " + btn1.getUserData());
		
		HBox hbox = new HBox();
		lb1 = new Label("LBL1");		lb2 = new Label("LB2");
		hbox.getChildren().addAll(lb1, lb2, btn10);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));			// РАСТОЯНИЕ ОТ ГРАНИЦ PANE ДО УЗЛОВ
		grid.setHgap(10);							// РАСТОЯНИЕ МЕЖДУ СТРОКАМИ И СТОЛБЦАМИ						
		grid.setVgap(10);
		grid.setMinWidth(300);
		grid.setPrefWidth(300);
		grid.setMaxWidth(300);	grid.setMaxHeight(300);	
		
		ColumnConstraints col1 = new ColumnConstraints();
		ColumnConstraints col2 = new ColumnConstraints();
		ColumnConstraints col3 = new ColumnConstraints();
		col1.setPercentWidth(33);
		col2.setPercentWidth(33);
		col3.setPercentWidth(33);
		col1.setHalignment(HPos.CENTER);	col2.setHalignment(HPos.CENTER);	col3.setHalignment(HPos.CENTER);
		grid.getColumnConstraints().addAll(col1, col2, col3);
		
		RowConstraints rw1 = new RowConstraints();
		RowConstraints rw2 = new RowConstraints();
		RowConstraints rw3 = new RowConstraints();
		RowConstraints rw4 = new RowConstraints();
		rw1.setPercentHeight(25);		rw2.setPercentHeight(25);
		rw3.setPercentHeight(25);		rw4.setPercentHeight(25);
		grid.getRowConstraints().addAll(rw1, rw2, rw3);
		
		grid.add(btn1, 0, 0); 		grid.add(btn2, 1, 0);		grid.add(btn3, 2, 0);
		grid.add(btn4, 0, 1); 		grid.add(btn5, 1, 1);		grid.add(btn6, 2, 1);
		grid.add(btn7, 0, 2); 		grid.add(btn8, 1, 2);		grid.add(btn9, 2, 2);
		grid.add(hbox, 0, 3);
		
		grid.setGridLinesVisible(true);   			// ОТОБРАЖЕНИЕ СЕТКИ
		
		Scene scene = new Scene(grid, 600, 600);
		
			/* Добавление обработчика на сцену - одинаковый для всех кнопок. 
			Так как мы знаем идентификатор кнопки, то мы можем легко получить ссылку на кнопку, которая была нажата 	*/
		scene.addEventHandler(ActionEvent.ACTION, event -> {
			if (event.getTarget() instanceof Button) {
				Button a = (Button)event.getTarget();
				System.out.println("БЫЛА НАЖАТА КНОПКА - " + a.getText() + "  , ID - " + a.getId() + "  , " + a.getUserData());
				if (a.getId().equals("btn3")) System.out.println("БЫЛА нажата кнопка №3");
				
							// ПОКАЗАНА НАВИГАЦИЯ ПО ГРАФУ СЦЕНЫ											
					// Имея ссылку на узел, можно получить ссылку на объект scene через метод getscene()
				Scene sсene = a.getScene();
				System.out.println("Ширина сцены равна " + scene.getWidth());
				
					// Имея ссылку на scene, мы можем получить ссылку на stage (window)
				Stage stage = (Stage)scene.getWindow();
				System.out.println("Название stage равна " + stage.getTitle());
				
					/* Также имея ссылку на scene, мы можем получить ссылки на все узлы
					Для этого сначала нужно получить ссылку на корневой узел   */
				Parent rootNode = scene.getRoot();					// Если мы не знаем тип корневого узла
				Pane rootPane = (Pane)scene.getRoot();					// Если мы уверены, что это Pane
				System.out.println("Корневой узел  - " + rootNode.toString());
				System.out.println("Корневой контейнер - " + rootPane.toString());
				
					// Затем получаем все узлы в корневом узле
					/* Для корневого узла класса Parent это можно сделать с помощью метода  getChildrenUnmodifiable(). Здесь список 
				возвращаемый список ObversableList<Node> доступен только для чтения и содержит исключительно дочерние узлы, а не 
				весь граф сцены	*/
				ObservableList<Node> list = rootNode.getChildrenUnmodifiable();
				System.out.println("Список полученный из getChildrenUnmodifiable()  " + list);
				
					/* Если мы знаем, что корневой узел - это Pane и получили ссылку на него, то это можно сделать с помощью метода
 				getChildren(). Здесь список возвращаемый список ObversableList<Node> доступен является редактируемым и 
 				и содержит исключительно дочерние узлы, а не весь граф сцены	*/
				ObservableList<Node> list1 = rootPane.getChildren();
				System.out.println("Список полученный из getChildren()  " + list1);
				
					/* Чтобы получить все узлы графа сцены, обычно используется рекурсивный вызов созданного метода  */
//				printTreeNodes(rootNode, 1);
				
					// Получить ссылку на родительский узел 		Если его нет, то вернется null 
				System.out.println("Родительский узел для Hbox - " + hbox.getParent());
			}
		});
		primaryStage.setTitle("STAGE");
		primaryStage.setScene(scene);				// Добавление в Stage объекта scene
		primaryStage.show();						// Показ Stage
	}
		
	public static void printTreeNodes (Parent parent, int level) {
		String s = String.join ("", Collections.nCopies((level - 1)*3, " "));
		System.out.println(s + " + " + parent.getClass().getName());
		for (Node node : parent.getChildrenUnmodifiable()) {
			if (node instanceof Parent) {
				printTreeNodes((Parent)node, level+1);
			}
			else System.out.println(s + " - " + node.getClass().getName());
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
