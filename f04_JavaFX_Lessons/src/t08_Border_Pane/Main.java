package t08_Border_Pane;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.*;

/* Panes - это специальные классы, целью которых является организация Nodes на сцене. 
 * Каждый тип Panes имеет свой контроль расположений.    Основные классы:
    - HBox: распологает Nodes горизонтально рядом друг с другом - по сути в строку 
    - VBox: распологает Nodes вертикально рядом друг с другом - по сути в столбец
    - FlowPane: распологает Nodes рядом друг с другом до тех пор пока не закончится место, затем it wraps to continue layout nodes. 
                Можно сконфигирурировать FlowPane для горизонтального и вертикального расположения Nodes 
    - Border: разделяет pane на 5 областей: Top, Left, Center, Right, and Bottom.  При добавлении node нужно указать область
    - GridPane: разделяет pane на сетку, позволяующую контролировать расположение элементов по строкам и столбцам 
    
    Можно комбинировать panes для создания более сложных pane. Например, чтобы создать pane c горизонтальной строкой внизу и вертикальным 
    столбцом кнопок справа, можно создать Border Pane  и добавит HBox в нижнюю область и VBox в правую область. 
    Это возможно, т.к. все Pane наследуют javafx.scene.layout.Pane, который в свою очередь наследует класс javafx.scene.Node. 
    То есть все Pane также являются Nodes.   */

public class Main extends Application {
	
		@Override 
	public void start(Stage primaryStage) {	
		
			/* Border Pane: разделяет pane на 5 областей: Top, Left, Center, Right, and Bottom. 
			 При добавлении node нужно указать область
			 Border pane - идеальный вариант для app, которые имеют традиционный вид окна, где меню и список инструментов находится
			 сверху окна, status bar или ОК/Cancel кнопки - внизу окна, навигациаонная панель - слева, различное меню -справ,
			 а основая информация - в центре
					Методы:
			- void setCenter(Node node) 		- устанавливает центральный node
			- void setTop(Node node) 			- устанавливает верхний node
			- void setRight(Node node) 			- устанавливает правый node
			- void setBottom(Node node) 		- устанавливает нижний node
			- void setLeft(Node node) 			- устанавливает левый node
			- void setAlignment(Pos alignment) 	- устанавливает alignment для nodes
			- static void setMargin(Node child,Insets value) - устанавает margin (пустые поля со всех краев) для заданного node.
		 */
		Button btn1 = new Button("Button One");
		Button btn2 = new Button("Button Two");
		Button btn3 = new Button("Button Three");
		Button btn4 = new Button("Button 4");
		Button btn5 = new Button("Button 5");
		Button btn6 = new Button("Button 6");
		Button btn7 = new Button("Button 7");
		Button btn8 = new Button("Button 8");
		Button btn9 = new Button("Button 9");
		Button btn10 = new Button("Central information");
			VBox vboxRight = new VBox(btn1, btn2, btn3);
			vboxRight.setPadding(new Insets(10));
			vboxRight.setAlignment(Pos.CENTER_RIGHT); 
		HBox hbox = new HBox(btn4, btn5, btn6);
		hbox.setPadding(new Insets(10));
		hbox.setAlignment(Pos.CENTER_LEFT);
			VBox vboxLeft = new VBox(btn7, btn8, btn9);
			vboxLeft.setPadding(new Insets(10));
			vboxLeft.setAlignment(Pos.CENTER_LEFT); 
		HBox hboxCenter = new HBox(btn10);
		hboxCenter.setPadding(new Insets(10));
		hboxCenter.setAlignment(Pos.CENTER);
		
			/* СОЗДАНИЕ BorderPane
		Конструкторы:
		- BorderPane () - создает пустой pane
		- BorderPane (Node center) - создает pane c указанным центральным node.
		- BorderPane (Node center, Node top, Node right, Node bottom, Node left) - создает pane c указанным центральным..... nodes	 */
		BorderPane pane = new BorderPane(hboxCenter, null, vboxRight, hbox, vboxLeft);
		
				/* ДОБАВЛЕНИЕ Nodes в pane.
		 - Метод setLeft(Node node)  					- добавляет узел слева
		 - Метод setTop(Node node)  					- добавляет узел сверху
		 - Метод setRight(Node node)  
		 - Метод setBottom(Node node)  
		 - Метод setCenter(Node node)   
		 - Метод getchildren.addAll(Node...Children)					*/
		
				// РАСТОЯНИЕ ОТ ГРАНИЦ PANE ДО УЗЛОВ
		pane.setPadding(new Insets(20, 20, 20, 20));	// Установлено растояния от края
		
				// ПОЗИЦИОНИРОВАНИЕ УЗЛОВ ВНУТРИ ЯЧЕЙКИ
		pane.setAlignment(hboxCenter, Pos.CENTER);					
		
		Scene scene = new Scene(pane, 400.0, 400.0); 
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("BorderPane");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
