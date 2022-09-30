package t07_Flow__Pane;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
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
	int iClickCount = 0;
	
		@Override 
	public void start(Stage primaryStage) {	
		
					/* ПОРЯДОК ДОБАВЛЕНИЯ NODES В FLOW PANE
		В отличии от HBox и VBox, если узлы не помещаются в одной строке/столбце, то они перетекают в следующую
		 			Методы КЛАСС FLOWPANE
		 -  ObservableList<Node> getChildren()	 	- возвращает коллекцию child nodes в списке, который позволяет добавить другие через addAll
		 - void setAlignment(Pos alignment) 		- устанавливает расположение внутри строк и столбцов
		 - void setColumnAlignment (Pos alignment) 	- устанавливает расположение внутри столбцов
		 - void setHgap(double value) 				- устанавливает горизонтальный зазор. 
		 		Для horizontal flow layout - это растояние между nodes. Для vertical flow layout - это растояние между столбцами
		 - static void setMargin(Node child, Insets value) 	- устанавливает margins для заданных node.
		 - void setOrientation(Orientation orientation) 	- устанавливает ориентацию на Orientation.HORIZONTAL или Orientation.VERTICAL
		 - void setPadding(Insets value)					- устанавливает растояние от края
		 - void setPrefWrapLength(double value) 			- устанавливает предпочтительный лимит для pane.
		  	Для horizontal flow layout	- это лимит ширины pane.  Для vertical flow layout	- это лимит высоты pane.
		 - void setRowAlignment(Pos alignment) 				- устанавливает расположение внутри строк
		 - void setSpacing(double value) 					- устанавливает spacing между nodes, показываемую в этом flow layout. 
		 - void setVgap(double value) 						- устанавливает вертикальный зазор.
		 	Для vertical flow layout - это растояние между nodes. Для horizontal flow layout - это растояние между строками
		 */
			
			// Пример создания horizontal flow pane c 10пкс для гориз. и вертик. зазоров между nodes и
			// пятью кнопкками и предпочтительной длиной 300 пкс
			// ВАЖНО, что при растягивании окна, кнопки переформируются
		Button btn1 = new Button("Button One");		Button btn2 = new Button("Button Two");		Button btn3 = new Button("Button Three");
		Button btn4 = new Button("Button Four");	Button btn5 = new Button("Button Five");
		
			// Разделение элементов линией
		Separator separator2 = new Separator(Orientation.VERTICAL);
		
				/* СОЗДАНИЕ FlowPane
		Конструкторы:
		- FlowPane() - создает пустой горизонтальный FlowPane с горизонт. и вертикальными зазорами = 0
		- FlowPane(double hgap, double vgap) - создает пустой горизонтальный FlowPane с заданными горизонт. и вертикальными зазорами
		- FlowPane(double hgap, double vgap, Node... children) - создает горизонтальный FlowPane с заданными горизонт. и 
			 вертикальными зазорами и содержащими указанные child nodes.
		- FlowPane(Node... children) - создает горизонтальный FlowPane с горизонт. и вертикальными зазорами = 0
			 и содержащими указанные child nodes.
		- FlowPane(Orientation orientation) - создает пустой FlowPane с горизонт. и вертикальными зазорами = 0 и 
		 	заданной ориентацией (Orientation.HORIZONTAL или Orientation.VERTICAL) 
		- FlowPane(Orientation orientation, double hgap, double vgap) -  - создает пустой FlowPane с заданными 
			 горизонт. и вертикальными зазорами и заданной ориентацией (Orientation.HORIZONTAL или Orientation.VERTICAL)
		- FlowPane(Orientation orientation, double hgap, double vgap, Node... children) - создает FlowPane с заданными горизонт. и 
			 вертикальными зазорами, содержащими указанные child nodes и заданной ориентацией (Orientation.HORIZONTAL или Orientation.VERTICAL)
		- FlowPane(Orientation orientation, Node... children) - создает FlowPane с горизонт. и вертикальными зазорами = 0
			 и содержащими указанные child nodes и заданной ориентацией (Orientation.HORIZONTAL или Orientation.VERTICAL)  */
		FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 10, 10, btn1, separator2, btn2, btn3, btn4, btn5);
		
				/* ДОБАВЛЕНИЕ Nodes в pane.
		 - Метод getchildren.addAll(Node...Children)					*/
		
				// РАСТОЯНИЕ ОТ ГРАНИЦ PANE ДО УЗЛОВ
		pane.setPadding(new Insets(20, 20, 20, 20));	// Установлено растояния от края
		
				// РАСТОЯНИЕ МЕЖДУ СТРОКАМИ И СТОЛБЦАМИ
		pane.setHgap(10);						
		pane.setVgap(10);
				
				// РАЗМЕРЫ PANE
		pane.setPrefWrapLength(300);					// Установлен лимит для ширины окна = 300 пкс
		
				// ОРИЕНТАЦИЯ УЗЛОВ ВНУТРИ КОНЕЙНЕРА
		pane.setOrientation(Orientation.HORIZONTAL);
		
				// ПОЗИЦИОНИРОВАНИЕ УЗЛОВ ВНУТРИ ЯЧЕЙКИ
		pane.setAlignment(Pos.CENTER);					// Центрирует все клавиши и по вертикали, и по горизонтали
		pane.setColumnHalignment(HPos.CENTER);			// Центрирует по горизонтали 
		pane.setRowValignment(VPos.CENTER);				// Центрирует по вертикали
		
		Scene scene = new Scene(pane);     	
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("FlowPane");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
