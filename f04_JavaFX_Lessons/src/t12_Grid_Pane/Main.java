package t12_Grid_Pane;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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

		/* GridPane: разделяет pane на сетку, позволяющую контролировать расположение элементов по строкам и столбцам
		    GridPane автоматически настраивает ширину столбцов и высоту строк на основе размера добавляемых элементов
	При добавлении node нужно указать область
	Border pane - идеальный вариант для app, которые имеют традиционный вид окна, где меню и список инструментов находится
	сверху окна, status bar или ОК/Cancel кнопки - внизу окна, навигациаонная панель - слева, различное меню -справ,
	а основая информация - в центре
	 		Конструктор:
	- GridPane grid = new GridPane() - создает пустой pane
			МЕТОДЫ:
	- void add(Node node, int col, int row)		- добавляет node в указанную ячейку (column and row index).
	- void add(Node node, int col, int row,int colspan, int rowspan) - добавляет node в указанную ячейку (column and row index) и 
	     с указанным column and row spans - сколько столбцов и строк занимает этот node
	- void addColumn(int col, Node... nodes)	-  добавляет в указанный столбец nodes.
	- void addRow(int row, Node... nodes)		-  добавляет в указанная строку nodes.
	- <ObservableList> getColumnConstraints()	- возвращает column constraints.   СМ НИЖЕ
	- <ObservableList> getRowConstraints() 		- возвращает row constraints.      СМ НИЖЕ
	- void setColumnSpan(Node node, int colspan)- устанавливает сколько столбцов должен задать указанный node.
	- void setRowSpan(Node node, int colspan) 	- устанавливает сколько строк должен задать указанный node.
	- void setHalignment(Node node, HPos value) - устанавливает horizontal alignment для node.
	 			Возможные варианты: HPos.LEFT, HPos.CENTER, HPos.RIGHT.
	- void setValignment(Node node, VPos value) - устанавливает vertical alignment для node. 
				Возможные варианты: HPos.BOTTOM, HPos.CENTER, HPos.TOP.
	- void setHgap(double value) 				- устанавливает размер зазора между столбцами
	- void setVgap(double value) 				- устанавливает размер зазора между строками
	- static void setMargin(Node node,Insets value)  - устанавливает margin (поля вокруг элемента) для указаного node.
	- void setPadding(Insets value) 			- устанавливает зазор от краев
	- void setMinHeight(double value)			- устанавливает минимальную высоту grid pane.
	- void setMaxHeight(double value) 			- устанавливает максимальную высоту grid pane.
	- void setPrefHeight(double value)			- устанавливает лимит по высоте the grid pane.
	- void setMinWidth(double value)			- устанавливает минимальную ширину grid pane.
	- void setMaxWidth(double value) 			- устанавливает максимальную ширину grid pane.
	- void setPrefWidth(double value)			- устанавливает лимит по ширине grid pane.		*/
			
public class Main extends Application {
	Stage stage;
	TextField txtName, txtPhone, txtAddress;
	RadioButton rdoSmall, rdoMedium, rdoLarge, rdoThin, rdoThick;
	CheckBox chkPepperoni, chkMushrooms, chkAnchovies;
		
		@Override 
	public void start(Stage primaryStage) {
		/* 	 При использовании Scene Builder GridPane находится во вкладке Containers. После его добавления появится таблица из 3-х строк и 
		 2-х столбцов. По сторонам таблицы расположены ярлыки. Если щелкнуть левой клавишей мыши по ярлыку, то отобразится вкладка 
		 Layout для свойств строки или столбца. Если на ярлыке щелкнуть правой клавишей, то можно удалить, переместить или добавить строку/столбец
		 Чтобы добавить компонент в таблицу достаточно перетащить его с помощью мыши в нужную ячейку.
		 Для изменения свойств отдельной ячейки надо выделить компонент, расположенный внутри ячейки, и отредактировать значения свойств
		 на влкадке Layout в разделе Grid Pane Constraints.	Чтобы изменить свойства всей таблицы, нужно щелкнуть левой клавишей мыши на свободном
		 месте таблицы и изменить значение свойств на вкладках Properties и Layout			 */

		stage = primaryStage;
			// Заголовок и текстовые поля создаются для customer’s name.
		Label lblName = new Label("Name:");
		txtName = new TextField();	txtName.setMinWidth(100);	txtName.setPrefWidth(200);		txtName.setMaxWidth(300);
		txtName.setPromptText("Enter the name here");	// Теневая подпись с подсказкой в строке для заполнения
		
			// Разделение элементов линией
	    Separator separator2 = new Separator(Orientation.VERTICAL);
		
			// Заголовок и текстовые поля создаются для customer’s phone number
		Label lblPhone = new Label("Phone Number:");
		txtPhone = new TextField();	txtPhone.setMinWidth(60);	txtPhone.setPrefWidth(120);	txtPhone.setMaxWidth(180);	
		txtPhone.setPromptText("Enter the phone number here");
		
			// Заголовок и текстовые поля создаются для customer’s address
		Label lblAddress = new Label("Address:");
		txtAddress = new TextField();	txtAddress.setMinWidth(100);	txtAddress.setPrefWidth(200);	txtAddress.setMaxWidth(300);
		txtAddress.setPromptText("Enter the address here");
		
			// Заголовок и 3 radio buttons (позволяют выбирать) создаются и добавляются в VBox с названием paneSize.
		Label lblSize = new Label("Size");
		rdoSmall = new RadioButton("Small");
		rdoMedium = new RadioButton("Medium");
		rdoLarge = new RadioButton("Large");
		rdoMedium.setSelected(true);
		ToggleGroup groupSize = new ToggleGroup();		// Без ToggleGroup можно выбрать все 3 radio buttons, но не одну из трех
		rdoSmall.setToggleGroup(groupSize);
		rdoMedium.setToggleGroup(groupSize);
		rdoLarge.setToggleGroup(groupSize);
		VBox paneSize = new VBox(lblSize, rdoSmall, rdoMedium, rdoLarge);
		paneSize.setSpacing(10);

			// Заголовок и 2 radio buttons создаются для выбора толщины коржа и вносятся в VBox с названием paneStyle
		Label lblCrust = new Label("Crust");
		rdoThin = new RadioButton("Thin");	rdoThick = new RadioButton("Thick");	rdoThin.setSelected(true);
		ToggleGroup groupCrust = new ToggleGroup();		// Без ToggleGroup можно выбрать все 2 radio buttons, но не одну из двух
		rdoThin.setToggleGroup(groupCrust);		rdoThick.setToggleGroup(groupCrust);	
		VBox paneCrust = new VBox(lblCrust, rdoThin, rdoThick);
		paneCrust.setSpacing(10);

			// Заголовок и 3 check boxes создаются для выбора наполнения пиццы и вносятся в VBox с названием paneStyle paneToppings
		Label lblToppings = new Label("Toppings");
		chkPepperoni = new CheckBox("Pepperoni");	chkMushrooms = new CheckBox("Mushrooms");	chkAnchovies = new CheckBox("Anchovies");
		VBox paneToppings = new VBox(lblToppings, chkPepperoni,	chkMushrooms, chkAnchovies);
		paneToppings.setSpacing(10);
			
			// Кнопки OK и Cancel создаются и добавляются в  HBox с названием paneButton
		Button btnOK = new Button("OK");
		btnOK.setPrefWidth(80);						// Задание ширины кнопки
		btnOK.setOnAction(e -> btnOK_Click() );		// Задание EventHandler при нажатии
		Button btnCancel = new Button("Cancel");
		btnCancel.setPrefWidth(80);
		btnCancel.setOnAction(e -> btnCancel_Click() );
		HBox paneButtons = new HBox(10, btnOK, btnCancel);

			// Создание GridPane
		GridPane grid = new GridPane();
		
			// РАСТОЯНИЕ ОТ ГРАНИЦ PANE ДО УЗЛОВ
		grid.setPadding(new Insets(10));
		
			// РАСТОЯНИЕ МЕЖДУ СТРОКАМИ И СТОЛБЦАМИ
		grid.setHgap(10);						
		grid.setVgap(10);
		
			// РАЗМЕРЫ PANE
		grid.setMinWidth(500);
		grid.setPrefWidth(500);
		grid.setMaxWidth(800);
		
			/* ДОБАВЛЕНИЕ Nodes в pane.
		Добавление Nodes возможно непосредственно в pane или сначала в Constrains, а потом их в Pane 
		Ниже непосредственное добавление в Pane
		 - Метод addRow(int rowIndex, Node...Children)  - добавляет строку и сразу Nodes в нее
		 - Метод addColumn(int columnIndex, Node...Children)  - добавляет столбнц и сразу Nodes в него
		 - Метод add(Node node, int columnIndex, int rowIndex)  - добавляет Nodes в заданный столбец и строку 
		 - Метод getchildren.addAll(Node...Childre)					*/
			
//		grid.addRow(0, lblName, txtName);		// Заголовки и текстовые поля для имя, номер телефона и адрес вносятся в строки 0,1 и 2 
//												// Т.о. заголовки встают в 1-ый столбец, а поля для внесения инфы во 2-ой столбец
//		grid.addRow(1, lblPhone, txtPhone);	
//		grid.addRow(2, lblAddress, txtAddress);
//		grid.addRow(3, paneSize, paneCrust, paneToppings);	// Добавление VBox paneSize, paneCrust, paneToppings в строку = 3
//		grid.add(paneButtons,2,4);  						// Добавление HBox, содержащий кнопки ОК и CANCEL в столбец = 2 и строку = 4
		
				// ОТОБРАЖЕНИЕ СЕТКИ
		grid.setGridLinesVisible(true);
		
				// ПОЗИЦИОНИРОВАНИЕ УЗЛОВ ВНУТРИ ЯЧЕЙКИ
		GridPane.setHalignment(lblName, HPos.RIGHT);		// Позиционирование надписи по правому края столбца
		GridPane.setHalignment(lblPhone, HPos.RIGHT);
		GridPane.setHalignment(lblAddress, HPos.RIGHT);
		
				/* ОБЪЕДИНЕНИЕ ЯЧЕЕК
		setColumnSpan(Node child, int value)		- задает кол-во объединенных ячеек по горизонтали
		setRawSpan(Node child, int value)			- задает кол-во объединенных ячеек по вертикали  
		В качестве value можно указать GridPane.REMAINING - узел будет занимать всю отсавшуюся площадь	*/
		
		GridPane.setColumnSpan(txtName,2);					// Растягиваем поля для внесения инфы на 2 столбца- теперь они занимают 2 и 3 столбцы 
		GridPane.setColumnSpan(txtPhone,2);
		GridPane.setColumnSpan(txtAddress,2);
		
				/* НАСТРОЙКА РАЗМЕРА КАЖДОЙ СТРОКИ/СТОЛБЦА и Nodes внутри них (всех сразу)			КЛАСС CONSTRAINS
		С методами выше можно контролировать многие аспекты вида pane, но не размер отдельных строк и столбцов.
		НИЖЕ указано для ColumnConstraints, для RowConstraints аналогичные методы и конструкторы
		    Конструктор CONSTRAINS:
		- ColumnConstraints()										- создает пустой column constraints объект
		- ColumnConstraints(double width) 							- создает column constraint фиксированной ширины, при этом значение для
		 										максимальной и минимальной шириной будут иметь значение Region.Pref_size
		- ColumnConstraints(double min, double pref, double max)	- создает column constraint указанной миним., предпочтит. и макс ширины */
		
				// Создаем ColumnConstraints для равномерного распределения их по ширине pane
		ColumnConstraints col1 = new ColumnConstraints();	
		ColumnConstraints col2 = new ColumnConstraints();
		ColumnConstraints col3 = new ColumnConstraints();
				
				/* НАСТРОЙКА ШИРИНЫ (ВЫСОТЫ) СТРОК (СТОЛБЦОВ) С ПОМОЩЬЮ CONSTRAINS: 
		- void setMinWidth(double value)	- устанавливает минимальную ширину строки 
		- void setMaxWidth(double value)	- устанавливает максимальную ширину строки
		- void setPrefWidth(double value) 	- устанавливат предпочтительную ширину столбца
		- void setPercentWidth(double value)- устанавливает ширину столбца, как % от общей ширины pane. */
		col1.setPercentWidth(33);
		col2.setPercentWidth(33);
		col3.setPercentWidth(33);
		
				/* НАСТРОЙКИ РАСТЯГИВАНИЯ   метод setHgrow(Node child, Priority priority)
		Если нужно, чтобы при растягивания окна, какой-либо узел занимал всю площадь, то нужно назначить для него приоритет с помощью
		метода setHgrow() и дополнительно рекомендуется прописать для этого узла команду node.setMaxWidth(Double.MAX_VAlUE)	
			 	Список Priority enumeration:
		- Priority.NEVER - показывает, что ширина node никогда не должна корректироваться для заполнения всего доспупного пространства
		pane. Это настройка по умолчанию, поэтому nodes не изменяются при изменение размера pane, содежащего их.
		- Priority.ALWAYS  -  ширина  всегда меняется. Если 2 и более узла имеют такой приоритет, то они делят влощадь поровну
		- Priority.SOMETIMES  - ширина узла меняется, только если нет других узлов с приоритетом ALWAYS. */ 
		col1.setHgrow(Priority.NEVER);   col2.setHgrow(Priority.SOMETIMES);    col3.setHgrow(Priority.ALWAYS);
			
			// ПОЗИЦИОНИРОВАНИЕ ВСЕХ УЗЛОВ ВНУТРИ СТРОКИ
		col1.setHalignment(HPos.RIGHT);		
		
				// ДОБАВЛЕНИЕ CONSTRAINS в PANE
		grid.getColumnConstraints().addAll(col1, col2, col3);
		
				/* ДОБАВЛЕНИЕ NODES в PANE через CONSTRAINS 
		Добавление Nodes возможно непосредственно в pane или сначала в Constrains, а потом их в Pane 
		Ниже добавление через Constrains через методы
		 - add(Node child, int columnIndex, int rowIndex)
		 - add(Node child, int columnIndex, int rowIndex, int columnspan, int rowspan)
		      где intcolumn и rowspan - кол-во объединенных ячеек по вертикали и горизонтали соответственно		 		*/
		grid.add(lblName, 0, 0);		grid.add(txtName, 1, 0);
		grid.add(lblPhone, 0, 1);		grid.add(txtPhone, 1, 1);
		grid.add(lblAddress, 0, 2);		grid.add(txtAddress, 1, 2);
		grid.add(paneSize, 0, 3);       grid.add(paneCrust, 1, 3);      grid.add(paneToppings, 2, 3);
	    grid.add(paneButtons, 1, 4);
	    
	    /* ДОБАВЛЕНИЕ NODES в PANE через setCONSTRAINS      Это третий способ добавления 
	     - setConstrains(Node child, int columnIndex, int rowIndex)
	     - setConstrains(Node child, int columnIndex, int rowIndex, int colspan, int rowspan)
	     - setConstrains(Node child, int columnIndex, int rowIndex, int colspan, int rowspan, Hpos haligment, Vpos valigment)
	     - setConstrains(Node child, int columnIndex, int rowIndex, int colspan, int rowspan, Hpos haligment, Vpos valigment, 
	     				Priority hgrow, Priority vgrow)
	     - setConstrains(Node child, int columnIndex, int rowIndex, int colspan, int rowspan, Hpos haligment, Vpos valigment, 
	     				Priority hgrow, Priority vgrow, Inserts margin)
	     	где intcolumn и rowspan - кол-во объединенных ячеек по вертикали и горизонтали соответственно		 	
	     	    haligment и valigment - выравнивание узла по горизонтали и вертикали соответственно
	     	    hgrow и vgrow - определяет растягивание Node  при изменении размера окна
	     	    margin -позволяет указать внешний отступ */
	    Label first = new Label("First");
        Label second = new Label("Second");
        Label third = new Label("Third");
         
        GridPane root = new GridPane();
        root.getColumnConstraints().add(new ColumnConstraints(80));
        root.getColumnConstraints().add(new ColumnConstraints(150, 150, 150));
        root.getColumnConstraints().add(new ColumnConstraints(70, 70, 70, null, HPos.CENTER, false));
         
        root.setGridLinesVisible(true); // делаем видимой сетку строк и столбцов
        root.setConstraints(first, 0, 0);
        root.setConstraints(second, 1, 0);
        root.setConstraints(third, 2, 0, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5));
        root.getChildren().addAll(first, second, third);
		
				// МЕТОДЫ GET()
	    System.out.println("Кол-во строк = " + grid.getColumnCount());
	    System.out.println("Кол-во столбцов = " + grid.getRowCount());
	    
	    		// ВНЕШНИЕ ОТСТУПЫ
	    GridPane.setMargin(lblName, new Insets(10));
	    
	    		// ТОЛЩИНА ГРАНИЦ
	    grid.setHgap(2);	// толщина горизонтальных границ
	    grid.setVgap(3);	// толщина вертикальных границ
	    
	    
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pizza Order");
		primaryStage.setMinWidth(500);
		primaryStage.setMaxWidth(900);
		primaryStage.show();
	}
	
	public void btnOK_Click()	{
			// Create a message string with the customer information
		String msg = "Customer:\n";
		msg += "\t Name: \t\t" + txtName.getText() + "\n";
		msg += "\t Phone: \t\t" + txtPhone.getText() + "\n";
		msg += "\t Address: \t\t" + txtAddress.getText() + "\n";
		msg += "You have ordered a ";
			// Add the pizza size
		if (rdoSmall.isSelected())  msg += "small ";
		if (rdoMedium.isSelected()) msg += "medium ";
		if (rdoLarge.isSelected()) 	msg += "large ";
			// Add the crust style
		if (rdoThin.isSelected()) 	msg += "thin crust pizza with ";
		if (rdoThick.isSelected()) 	msg += "thick crust pizza with ";
			// Add the toppings
		String toppings = "";
		toppings = buildToppings(chkPepperoni, toppings);
		toppings = buildToppings(chkMushrooms, toppings);
		toppings = buildToppings(chkAnchovies, toppings);
		if (toppings.equals("")) msg += "no toppings.";
		else msg += "the following toppings:\n" + toppings;
			// Display the message
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("Order Details");
		a.showAndWait();
	}
	
	public String buildToppings(CheckBox chk, String msg)	{
			// Helper method for displaying the list of toppings
		if (chk.isSelected()) 	{
			if (!msg.equals("")) msg += ", ";		// Ставит запятую только, если уже были перечислены наполнители
			msg += chk.getText();
		}
		return msg;
	}
	
	public void btnCancel_Click() {
	stage.close();
	}
	public static void main(String[] args) {
		launch(args);
	}
}