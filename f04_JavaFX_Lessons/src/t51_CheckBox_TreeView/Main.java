package t51_CheckBox_TreeView;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBoxTreeItem;
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
/* Наследование: Object - TreeItem<T> - CheckBoxTreeItem
Создание всех узлов (Node) происходит с помощью класса TreeItem.   По сути root node - это уже дерево					*/

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) 		{
			
			// Конструкторы
		CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem<String>();
		CheckBoxTreeItem<String> item1 = new CheckBoxTreeItem<String>("Item 1");
		CheckBoxTreeItem<String> item2 = new CheckBoxTreeItem<String>("Item 2", null);
		CheckBoxTreeItem<String> item3 = new CheckBoxTreeItem<String>("Item 3", null, true);
		CheckBoxTreeItem<String> item4 = new CheckBoxTreeItem<String>("Item 4", null, true, true);
		
		CheckBoxTreeItem<String> item3_1 = new CheckBoxTreeItem<String>("Item 3.1");
		CheckBoxTreeItem<String> item3_2 = new CheckBoxTreeItem<String>("Item 3.2");
		item3.setExpanded(true);
			
		rootItem.setExpanded(true);
		rootItem.setValue("ROOT");
		rootItem.getChildren().addAll(item1, item2, item3, item4);
		item3.getChildren().addAll(item3_1, item3_2);
		
		TreeView<String> treeView2 = new TreeView<String>();
		treeView2.setRoot(rootItem);
		
			/* После создания дерева нужно вызвать метод setCellFactory и передать ему объект,
		возвращаемый статическим методом setCellFactory из класса CheckBoxTreeCell */  
		treeView2.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

		// Показать или скрыть корневой узел
		treeView2.setShowRoot(true);
		
			// Информация по наличию детей и родителей
		System.out.println("Point1.1 является Leaf (не имеет детей) " + item1.isLeaf());
		System.out.println("Родители для Point1.1 " + item1.getParent());
		ObservableList<TreeItem<String>> list = item1.getChildren();
		System.out.println("Список детей для Point1 - " + list.toString());
		
			// Перемещение по дереву
		System.out.println("Следующий элемент на том же уровне " + item1.nextSibling());
		System.out.println("Следующий элемент на том же уровне " + item1.nextSibling());
		System.out.println("Предыдущий элемент на том же уровне " + item1.previousSibling());
		
			// Определeние позиции узла внутри дерева
		System.out.println("Номер строки в списке для узла point 1.1 - " + treeView2.getRow(item1));
			// Если узел скрыт, то getRow() возвращает -1
		System.out.println("Уровень вложенности узла point 1.1 - " + treeView2.getTreeItemLevel(item1));
		
			// Возвращает ссылку на элемент, находящийся в списке на указанной позиции списка
		System.out.println("Элемент на 2-ой позиции (строки) " + treeView2.getTreeItem(2));
		
			// Количество видимых элементов дерева
		System.out.println("Количество видимых элементов дерева - " + treeView2.getExpandedItemCount());
		
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
		rootItem.addEventHandler(
				TreeItem.<String>childrenModificationEvent(), event -> {
					System.out.println("Событие произошло в узле " + event.getTreeItem());
					System.out.println("Новое значение " + event.getNewValue());
					
		});

		rootItem.addEventHandler(
				CheckBoxTreeItem.<String>checkBoxSelectionChangedEvent(), event  -> {
					System.out.println("Событие произошло в узле " + event.getTreeItem());
					if (event.getTreeItem() == null) {
						System.out.println("value " + event.getTreeItem().getValue());
						System.out.println("selected " + event.getTreeItem().isSelected());
						System.out.println("intermerminate " + event.getTreeItem().isIndeterminate());
					}
		});
		
			/* Прокрутка элементов
			чтобы элемент с указанным индексом оказался в зоне видимости позволяет метод scrollTo()  */
				// Прокрутка к последнему видимому элементу
		treeView2.scrollTo(treeView2.getExpandedItemCount() - 1);
				// Прокрутка к указанному элементу при условии, что он отображается 
		int index = treeView2.getRow(item1);
		if (index !=-1) treeView2.scrollTo(index);
			// Обработчик прокрутки
		treeView2.setOnScrollTo(event -> {
			System.out.println("Scroll to " + event.getScrollTarget());
		});
		
			/* Управление выбором элементов
		поддерживают, как выбор одного, так и нескольких элементов 	 */
		treeView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		Button setSelected = new Button("Set selected el");
		setSelected.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<Integer> arr = treeView2.getSelectionModel().getSelectedIndices();
				System.out.println("Индексы выделенных элементов " + arr);
				ObservableList<TreeItem<String>> arr2 = treeView2.getSelectionModel().getSelectedItems();
				System.out.println("Выделенные элементы " + arr2);
			}
		});
		
			/* Управление фокусом ввода
		Свойство focusModel из класса TreeView<T> содержит ссылку на объект, с помощью которого можно управлять
		фокусом ввода.
	    Ниже пример получения индекса строки списка, находящегося в фокусе ввода, а также значения*/
		FocusModel<TreeItem<String>> focusModel = treeView2.getFocusModel();
		System.out.println("Index - " + focusModel.getFocusedIndex());
		System.out.println("Item" + focusModel.getFocusedItem());
			// Отслеживание изменения индекса строки
		treeView2.getFocusModel().focusedIndexProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Index  " + newValue);
		});
		
			// Задание фиксированной высоты для всех ячеек списка
		treeView2.setFixedCellSize(20);

		HBox hbox = new HBox(10, treeView2, setSelected);
		hbox.setPadding(new Insets(20, 10, 20, 10));
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox, 900, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
