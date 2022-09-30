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
/* ������������: Object - TreeItem<T> - CheckBoxTreeItem
�������� ���� ����� (Node) ���������� � ������� ������ TreeItem.   �� ���� root node - ��� ��� ������					*/

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) 		{
			
			// ������������
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
		
			/* ����� �������� ������ ����� ������� ����� setCellFactory � �������� ��� ������,
		������������ ����������� ������� setCellFactory �� ������ CheckBoxTreeCell */  
		treeView2.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

		// �������� ��� ������ �������� ����
		treeView2.setShowRoot(true);
		
			// ���������� �� ������� ����� � ���������
		System.out.println("Point1.1 �������� Leaf (�� ����� �����) " + item1.isLeaf());
		System.out.println("�������� ��� Point1.1 " + item1.getParent());
		ObservableList<TreeItem<String>> list = item1.getChildren();
		System.out.println("������ ����� ��� Point1 - " + list.toString());
		
			// ����������� �� ������
		System.out.println("��������� ������� �� ��� �� ������ " + item1.nextSibling());
		System.out.println("��������� ������� �� ��� �� ������ " + item1.nextSibling());
		System.out.println("���������� ������� �� ��� �� ������ " + item1.previousSibling());
		
			// �������e��� ������� ���� ������ ������
		System.out.println("����� ������ � ������ ��� ���� point 1.1 - " + treeView2.getRow(item1));
			// ���� ���� �����, �� getRow() ���������� -1
		System.out.println("������� ����������� ���� point 1.1 - " + treeView2.getTreeItemLevel(item1));
		
			// ���������� ������ �� �������, ����������� � ������ �� ��������� ������� ������
		System.out.println("������� �� 2-�� ������� (������) " + treeView2.getTreeItem(2));
		
			// ���������� ������� ��������� ������
		System.out.println("���������� ������� ��������� ������ - " + treeView2.getExpandedItemCount());
		
			/* ��������� ������� � ������� addEventHandler 
		����� TreeItem �� ��������� ���� Node, ������� �� ����� ������������ ������ ������� ����
		 - treeNotificationEvent()  		- ������������� ��� �������
			 - valueChangedEvent() 				- ��������� �������� ��������	
			 - graphicChangedEvent() 			- ��������� ���� ����� �� �������
			 - expandedItemCountChangeEvent() 	- ������������� ��� ������� ����
				 - branchExpandedEvent()			- ����������� �������� �����
				 - branchCollapsedEvent()			- �������� �������� �����
				 - childrenModificationEvent()		- ���������� ��� �������� �������� �����
				 
		 	������� �������� ��������� ��������� � ��������� ����, ������� ��� ������������� ��������� ����������� ��� �������
		�������� ������. ���������� ��������� ���������� ��� ��������� ����, � ������ �� �������, ��������� ����������
		�������, ����� �������� ������� getTreeItems() ����� ������ �������		  */
		rootItem.addEventHandler(
				TreeItem.<String>childrenModificationEvent(), event -> {
					System.out.println("������� ��������� � ���� " + event.getTreeItem());
					System.out.println("����� �������� " + event.getNewValue());
					
		});

		rootItem.addEventHandler(
				CheckBoxTreeItem.<String>checkBoxSelectionChangedEvent(), event  -> {
					System.out.println("������� ��������� � ���� " + event.getTreeItem());
					if (event.getTreeItem() == null) {
						System.out.println("value " + event.getTreeItem().getValue());
						System.out.println("selected " + event.getTreeItem().isSelected());
						System.out.println("intermerminate " + event.getTreeItem().isIndeterminate());
					}
		});
		
			/* ��������� ���������
			����� ������� � ��������� �������� �������� � ���� ��������� ��������� ����� scrollTo()  */
				// ��������� � ���������� �������� ��������
		treeView2.scrollTo(treeView2.getExpandedItemCount() - 1);
				// ��������� � ���������� �������� ��� �������, ��� �� ������������ 
		int index = treeView2.getRow(item1);
		if (index !=-1) treeView2.scrollTo(index);
			// ���������� ���������
		treeView2.setOnScrollTo(event -> {
			System.out.println("Scroll to " + event.getScrollTarget());
		});
		
			/* ���������� ������� ���������
		������������, ��� ����� ������, ��� � ���������� ��������� 	 */
		treeView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		Button setSelected = new Button("Set selected el");
		setSelected.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<Integer> arr = treeView2.getSelectionModel().getSelectedIndices();
				System.out.println("������� ���������� ��������� " + arr);
				ObservableList<TreeItem<String>> arr2 = treeView2.getSelectionModel().getSelectedItems();
				System.out.println("���������� �������� " + arr2);
			}
		});
		
			/* ���������� ������� �����
		�������� focusModel �� ������ TreeView<T> �������� ������ �� ������, � ������� �������� ����� ���������
		������� �����.
	    ���� ������ ��������� ������� ������ ������, ������������ � ������ �����, � ����� ��������*/
		FocusModel<TreeItem<String>> focusModel = treeView2.getFocusModel();
		System.out.println("Index - " + focusModel.getFocusedIndex());
		System.out.println("Item" + focusModel.getFocusedItem());
			// ������������ ��������� ������� ������
		treeView2.getFocusModel().focusedIndexProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Index  " + newValue);
		});
		
			// ������� ������������� ������ ��� ���� ����� ������
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
