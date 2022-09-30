package t50_Tree_View;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.control.Button;
import javafx.scene.control.FocusModel;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.util.StringConverter;

/* TreeView позволяет показывать список в виде иерархического дерева
   Например, как структура папок на жестком диске
   Обычно такие структуры создаются рекурсивным методом
    - Каждый элемент дерева является узлом node. Каждый узел создается из TreeItem class - generic класс, поэтому можно
    	создавать дерево используя объекты любого типа, включая объккты собственного класса.
    - Root node - стартовый node для дерева. Каждое дерево должно иметь один и только один root node. При создании дерева
    	ты передаешь root node в TreeView constructor.
    - Child node - nodes, который появляются сразу после заданного узла - это сhild nodes. 
    - Parent node: node, который появляется сразу выше заданного node - это parent node.
    	Каждый node кроме root должен иметь один и только один parent.
    - Sibling nodes - nodes, которые является детьми одного parent.
    - Leaf node - node, который не имеет ниодного children.
    - Path - path содержит всю цепочку для node (его родители, его родители родителей и т.д. до самого пути в root node).
    - Expanded node - node, чьи дети аre visible.
	- Collapsed node - node, чьи дети are hidden
Наследование: Object - Node - Parent - Region - Contol - TreeView<T>
Создание всех узлов (Node) происходит с помощью класса TreeItem.   По сути root node - это уже дерево					*/

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) 		{
			
			// Конструктор
		TreeView<String> treeview1 = new TreeView<String>();	
//		TreeView<String> treeview = new TreeView<String>(root);    Конструктор с корневым узлом - сначала нужно сделать корневой узел
		
			/* Создание корневого узла с помощью класса TreeItem
		Конструктор  TreeItem()							- узел с настройками по умолчанию
		             TreeItem(T value)					- узел с указанным значением элемента
		             TreeItem(T value, Node graphic) 	- узле с указанным значением элемента и узел перед значением (нпр, картинка) 	 */
		TreeItem<String> root = new TreeItem<String>("ROOT NODE ", new Rectangle(10,10,Color.RED));
		root.setExpanded(true);			/* Устанавливаем для этого node true, чтобы он дальше мог иметь детей в дереве
										 В противном случае в дереве при отображении нужно будет разворачивать  детей */

			// Устанавливаем корневой узел в дерево 
		treeview1.setRoot(root);
		
			// Показать или скрыть корневой узел
		treeview1.setShowRoot(true);
		
			// Создание детей корневого узла
		TreeItem<String> point1 = new TreeItem<String>("Point1");
		TreeItem<String> point2 = new TreeItem<String>("Point2");
		TreeItem<String> point3 = new TreeItem<String>("Point3");
		TreeItem<String> point4 = new TreeItem<String>("Point4");
		
			// Добавляем детей к корневому узлу 
		root.getChildren().addAll(point1, point2, point3, point4);
		
			// Создаем детей детей корневого узла и добавляем к родителю
		TreeItem<String> point1_1 = new TreeItem<String>("Point1.1");
		TreeItem<String> point1_2 = new TreeItem<String>("Point1.2");
		point1.getChildren().addAll(point1_1, point1_2);
		point1.setExpanded(true);	
		point1_1.setExpanded(true);
		
			// ДОБАВЛЕНИЕ LEAF УЗЛОВ УДОБНО ДЕЛАТЬ ЧЕРЕЗ ПОЛЬЗОВАТЕЛЬСКИЙ МЕТОД
		treeItemAdd(point1_1, "point 1.1.1", new Rectangle(10,10,Color.RED), true);
		treeItemAdd(point1_1, "point 1.1.2", new Rectangle(10,10,Color.BLUE), true);
		
			// Информация по наличию детей и родителей
		System.out.println("Point1.1 является Leaf (не имеет детей) " + point1_1.isLeaf());
		System.out.println("Родители для Point1.1 " + point1_1.getParent());
		ObservableList<TreeItem<String>> list = point1.getChildren();
		System.out.println("Список детей для Point1 - " + list.toString());
		
			// Перемещение по дереву
		System.out.println("Следующий элемент на том же уровне " + point1.nextSibling());
		System.out.println("Следующий элемент на том же уровне " + point4.nextSibling());
		System.out.println("Предыдущий элемент на том же уровне " + point4.previousSibling());
		
			// Определeние позиции узла внутри дерева
		System.out.println("Номер строки в списке для узла point 1.1 - " + treeview1.getRow(point1_1));
			// Если узел скрыт, то getRow() возвращает -1
		System.out.println("Уровень вложенности узла point 1.1 - " + treeview1.getTreeItemLevel(point1_1));
		
			// Возвращает ссылку на элемент, находящийся в списке на указанной позиции списка
		System.out.println("Элемент на 2-ой позиции (строки) " + treeview1.getTreeItem(2));
		
			// Количество видимых элементов дерева
		System.out.println("Количество видимых элементов дерева - " + treeview1.getExpandedItemCount());
		
			/* Обработка событий с помощью addEventHandler 
		Класс TreeItem не наследует узел Node, поэтому он может обрабатывать только события ниже
		 - treeNotificationEvent()  		- перехватывает все события
			 - valueChangedEvent() 				- изменение значения элемента	
			 - graphicChangedEvent() 			- изменение узла слева от надписи
			 - expandedItemCountChangeEvent() 	- перехватывает все события ниже
				 - branchExpandedEvent()			- отображение дочерних узлов
				 - branchCollapsedEvent()			- сокрытие дочерних узлов
				 - childrenModificationEvent()		- добавление или удаление дочерних узлов
				 
		 	События дочерних элементов всплывают к корневому узлу, поэтому нет необходимости назначать обработчики для каждого
		элемента списка. Достаточно назначить обработчик для корневого узла, а ссылку на элемент, явяющийся источником
		события, можно получить методом getTreeItems() через объект события		  */
		root.addEventHandler(
				TreeItem.<String>childrenModificationEvent(), event -> {
					System.out.println("Событие произошло в узле " + event.getTreeItem());
					System.out.println("Новое значение " + event.getNewValue());
					
		});

		root.addEventHandler(
				TreeItem.<String>expandedItemCountChangeEvent(), event -> {
					System.out.println("Событие произошло в узле " + event.getTreeItem());
					System.out.println("Новое значение " + event.getNewValue());
					if (event.wasAdded()) {
						System.out.println("Добавлены элементы");
						System.out.println(event.getAddedSize());
						System.out.println(event.getAddedChildren());
					}
					if (event.wasRemoved()) {
						System.out.println("Удалены элементы");
						System.out.println(event.getRemovedSize());
						System.out.println(event.getRemovedChildren());
					}
					if (event.wasPermutated()) {
						System.out.println("Изменился порядок следования");
						System.out.println(event.getTreeItem().getChildren());
					}
					if (event.wasExpanded()) System.out.println("Дочерние элементы были отображены");
					if (event.wasCollapsed()) System.out.println("Дочерние элементы были скрыты");
		});
		
			/* Прокрутка элементов
			чтобы элемент с указанным индексом оказался в зоне видимости позволяет метод scrollTo()  */
				// Прокрутка к последнему видимому элементу
		treeview1.scrollTo(treeview1.getExpandedItemCount() - 1);
				// Прокрутка к указанному элементу при условии, что он отображается 
		int index = treeview1.getRow(point1_2);
		if (index !=-1) treeview1.scrollTo(index);
			// Обработчик прокрутки
		treeview1.setOnScrollTo(event -> {
			System.out.println("Scroll to " + event.getScrollTarget());
		});
		
			/* Управление выбором элементов
		поддерживают, как выбор одного, так и нескольких элементов 	 */
		treeview1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		Button setSelected = new Button("Set selected el");
		setSelected.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<Integer> arr = treeview1.getSelectionModel().getSelectedIndices();
				System.out.println("Индексы выделенных элементов " + arr);
				ObservableList<TreeItem<String>> arr2 = treeview1.getSelectionModel().getSelectedItems();
				System.out.println("Выделенные элементы " + arr2);
			}
		});
		
			/* Управление фокусом ввода
		Свойство focusModel из класса TreeView<T> содержит ссылку на объект, с помощью которого можно управлять
		фокусом ввода.
	    Ниже пример получения индекса строки списка, находящегося в фокусе ввода, а также значения*/
		FocusModel<TreeItem<String>> focusModel = treeview1.getFocusModel();
		System.out.println("Index - " + focusModel.getFocusedIndex());
		System.out.println("Item" + focusModel.getFocusedItem());
			// Отслеживание изменения индекса строки
		treeview1.getFocusModel().focusedIndexProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Index  " + newValue);
		});
		
			/* Редактирование элементов
			Сначала нужно разрешить редактирование с помощью метода setEditable(true);
		Затем нужно задать значение свойству cellFactory - можно реализовать свой собственный способ редактирования или
		воспользоваться готовыми классами из пакета scene.control.cell.  Например, классом TextFieldTable<S,T>, который в режиме
		редактирования отображает внутри ячейки текстовое поле 			 */
		treeview1.setEditable(true);
			// Формат метода forTableColumn() ниже подходит только для String
		treeview1.setCellFactory(TextFieldTreeCell.forTreeView());
			// Формат метода forTableColumn() ниже позволяет указать способ преобразования значения в строку и наоборот
		treeview1.setCellFactory(TextFieldTreeCell.forTreeView(
			new StringConverter<String>() {
				@Override
				public String toString(String object) {
					if (object == null) return null;
					else return object.toString();
				}
				@Override
				public String fromString(String string) {
					if (string == null) return null;
					else return string;
				}
			}));
		
			/* Обработчик изменения таблицы с помощью метода addEventHandler и методов класса TableColumn ниже
		editAnyEvent() - любое событие редактирования
		editStartEvent() - событие начала редактирования
		editCommitEvent() - событие успешного редактирования (юзер нажал Enter после ввода)
		editCancelEvent() - событие отмены редактирования 			
		   Метод addEventHandler не переопределяет обработчик ячейки по умолчанию setCellFactory(TextFieldTableCell.<User>forTableColumn())		 */
		treeview1.addEventHandler(TreeView.<String>editCommitEvent(), event -> {
			/* if (event.getNewValue() == null) tableview1.refresh();		НЕ работает, т.к. не переопределяет обработчик по умолчанию
			else event.getRowValue().setId((Integer)event.getNewValue());  */
			System.out.println(event.getNewValue());					// Возвращает новое значение
			System.out.println(event.getOldValue());					// Возвращает старое значение
			System.out.println(event.getTreeItem());					// Возвращает ссылку на редактируемый элемент списка
			System.out.println(event.getSource());						// возващает ссылку на объект списка
			System.out.println(event.getTarget());					
		});
			/* Метод setOnEditCommit в отличии от addEventHandler() переопределяет обработчик ячейки по умолчанию setCellFactory()
		Поэтому кодом ниже мы можем использовать метод refresh(), который при введении в поле id строки и возврате null от 
		setCellFactory() метод будет refresh() обновлять таблицу к ее прежним значения 		*/
		treeview1.setOnEditCommit(event -> {
			if (event.getNewValue() == null) treeview1.refresh();
		});
		
			// Задание фиксированной высоты для всех ячеек списка
		treeview1.setFixedCellSize(20);

		HBox hbox = new HBox(10, treeview1, setSelected);
		hbox.setPadding(new Insets(20, 10, 20, 10));
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox, 900, 700);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CHOISE BOX");  // LbvfRbv1984@#!
		primaryStage.show();
	}

	public TreeItem<String> treeItemAdd(TreeItem<String> parent, String text, Node graphic, boolean expanded) {
		TreeItem<String> item = new TreeItem<String>(text);
		if (graphic != null) item.setGraphic(graphic);
		item.setExpanded(expanded);
		if (parent != null) parent.getChildren().add(item);
		return item;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
