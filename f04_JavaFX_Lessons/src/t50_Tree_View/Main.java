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

/* TreeView ��������� ���������� ������ � ���� �������������� ������
   ��������, ��� ��������� ����� �� ������� �����
   ������ ����� ��������� ��������� ����������� �������
    - ������ ������� ������ �������� ����� node. ������ ���� ��������� �� TreeItem class - generic �����, ������� �����
    	��������� ������ ��������� ������� ������ ����, ������� ������� ������������ ������.
    - Root node - ��������� node ��� ������. ������ ������ ������ ����� ���� � ������ ���� root node. ��� �������� ������
    	�� ��������� root node � TreeView constructor.
    - Child node - nodes, ������� ���������� ����� ����� ��������� ���� - ��� �hild nodes. 
    - Parent node: node, ������� ���������� ����� ���� ��������� node - ��� parent node.
    	������ node ����� root ������ ����� ���� � ������ ���� parent.
    - Sibling nodes - nodes, ������� �������� ������ ������ parent.
    - Leaf node - node, ������� �� ����� �������� children.
    - Path - path �������� ��� ������� ��� node (��� ��������, ��� �������� ��������� � �.�. �� ������ ���� � root node).
    - Expanded node - node, ��� ���� �re visible.
	- Collapsed node - node, ��� ���� are hidden
������������: Object - Node - Parent - Region - Contol - TreeView<T>
�������� ���� ����� (Node) ���������� � ������� ������ TreeItem.   �� ���� root node - ��� ��� ������					*/

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) 		{
			
			// �����������
		TreeView<String> treeview1 = new TreeView<String>();	
//		TreeView<String> treeview = new TreeView<String>(root);    ����������� � �������� ����� - ������� ����� ������� �������� ����
		
			/* �������� ��������� ���� � ������� ������ TreeItem
		�����������  TreeItem()							- ���� � ����������� �� ���������
		             TreeItem(T value)					- ���� � ��������� ��������� ��������
		             TreeItem(T value, Node graphic) 	- ���� � ��������� ��������� �������� � ���� ����� ��������� (���, ��������) 	 */
		TreeItem<String> root = new TreeItem<String>("ROOT NODE ", new Rectangle(10,10,Color.RED));
		root.setExpanded(true);			/* ������������� ��� ����� node true, ����� �� ������ ��� ����� ����� � ������
										 � ��������� ������ � ������ ��� ����������� ����� ����� �������������  ����� */

			// ������������� �������� ���� � ������ 
		treeview1.setRoot(root);
		
			// �������� ��� ������ �������� ����
		treeview1.setShowRoot(true);
		
			// �������� ����� ��������� ����
		TreeItem<String> point1 = new TreeItem<String>("Point1");
		TreeItem<String> point2 = new TreeItem<String>("Point2");
		TreeItem<String> point3 = new TreeItem<String>("Point3");
		TreeItem<String> point4 = new TreeItem<String>("Point4");
		
			// ��������� ����� � ��������� ���� 
		root.getChildren().addAll(point1, point2, point3, point4);
		
			// ������� ����� ����� ��������� ���� � ��������� � ��������
		TreeItem<String> point1_1 = new TreeItem<String>("Point1.1");
		TreeItem<String> point1_2 = new TreeItem<String>("Point1.2");
		point1.getChildren().addAll(point1_1, point1_2);
		point1.setExpanded(true);	
		point1_1.setExpanded(true);
		
			// ���������� LEAF ����� ������ ������ ����� ���������������� �����
		treeItemAdd(point1_1, "point 1.1.1", new Rectangle(10,10,Color.RED), true);
		treeItemAdd(point1_1, "point 1.1.2", new Rectangle(10,10,Color.BLUE), true);
		
			// ���������� �� ������� ����� � ���������
		System.out.println("Point1.1 �������� Leaf (�� ����� �����) " + point1_1.isLeaf());
		System.out.println("�������� ��� Point1.1 " + point1_1.getParent());
		ObservableList<TreeItem<String>> list = point1.getChildren();
		System.out.println("������ ����� ��� Point1 - " + list.toString());
		
			// ����������� �� ������
		System.out.println("��������� ������� �� ��� �� ������ " + point1.nextSibling());
		System.out.println("��������� ������� �� ��� �� ������ " + point4.nextSibling());
		System.out.println("���������� ������� �� ��� �� ������ " + point4.previousSibling());
		
			// �������e��� ������� ���� ������ ������
		System.out.println("����� ������ � ������ ��� ���� point 1.1 - " + treeview1.getRow(point1_1));
			// ���� ���� �����, �� getRow() ���������� -1
		System.out.println("������� ����������� ���� point 1.1 - " + treeview1.getTreeItemLevel(point1_1));
		
			// ���������� ������ �� �������, ����������� � ������ �� ��������� ������� ������
		System.out.println("������� �� 2-�� ������� (������) " + treeview1.getTreeItem(2));
		
			// ���������� ������� ��������� ������
		System.out.println("���������� ������� ��������� ������ - " + treeview1.getExpandedItemCount());
		
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
		root.addEventHandler(
				TreeItem.<String>childrenModificationEvent(), event -> {
					System.out.println("������� ��������� � ���� " + event.getTreeItem());
					System.out.println("����� �������� " + event.getNewValue());
					
		});

		root.addEventHandler(
				TreeItem.<String>expandedItemCountChangeEvent(), event -> {
					System.out.println("������� ��������� � ���� " + event.getTreeItem());
					System.out.println("����� �������� " + event.getNewValue());
					if (event.wasAdded()) {
						System.out.println("��������� ��������");
						System.out.println(event.getAddedSize());
						System.out.println(event.getAddedChildren());
					}
					if (event.wasRemoved()) {
						System.out.println("������� ��������");
						System.out.println(event.getRemovedSize());
						System.out.println(event.getRemovedChildren());
					}
					if (event.wasPermutated()) {
						System.out.println("��������� ������� ����������");
						System.out.println(event.getTreeItem().getChildren());
					}
					if (event.wasExpanded()) System.out.println("�������� �������� ���� ����������");
					if (event.wasCollapsed()) System.out.println("�������� �������� ���� ������");
		});
		
			/* ��������� ���������
			����� ������� � ��������� �������� �������� � ���� ��������� ��������� ����� scrollTo()  */
				// ��������� � ���������� �������� ��������
		treeview1.scrollTo(treeview1.getExpandedItemCount() - 1);
				// ��������� � ���������� �������� ��� �������, ��� �� ������������ 
		int index = treeview1.getRow(point1_2);
		if (index !=-1) treeview1.scrollTo(index);
			// ���������� ���������
		treeview1.setOnScrollTo(event -> {
			System.out.println("Scroll to " + event.getScrollTarget());
		});
		
			/* ���������� ������� ���������
		������������, ��� ����� ������, ��� � ���������� ��������� 	 */
		treeview1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		Button setSelected = new Button("Set selected el");
		setSelected.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<Integer> arr = treeview1.getSelectionModel().getSelectedIndices();
				System.out.println("������� ���������� ��������� " + arr);
				ObservableList<TreeItem<String>> arr2 = treeview1.getSelectionModel().getSelectedItems();
				System.out.println("���������� �������� " + arr2);
			}
		});
		
			/* ���������� ������� �����
		�������� focusModel �� ������ TreeView<T> �������� ������ �� ������, � ������� �������� ����� ���������
		������� �����.
	    ���� ������ ��������� ������� ������ ������, ������������ � ������ �����, � ����� ��������*/
		FocusModel<TreeItem<String>> focusModel = treeview1.getFocusModel();
		System.out.println("Index - " + focusModel.getFocusedIndex());
		System.out.println("Item" + focusModel.getFocusedItem());
			// ������������ ��������� ������� ������
		treeview1.getFocusModel().focusedIndexProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Index  " + newValue);
		});
		
			/* �������������� ���������
			������� ����� ��������� �������������� � ������� ������ setEditable(true);
		����� ����� ������ �������� �������� cellFactory - ����� ����������� ���� ����������� ������ �������������� ���
		��������������� �������� �������� �� ������ scene.control.cell.  ��������, ������� TextFieldTable<S,T>, ������� � ������
		�������������� ���������� ������ ������ ��������� ���� 			 */
		treeview1.setEditable(true);
			// ������ ������ forTableColumn() ���� �������� ������ ��� String
		treeview1.setCellFactory(TextFieldTreeCell.forTreeView());
			// ������ ������ forTableColumn() ���� ��������� ������� ������ �������������� �������� � ������ � ��������
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
		
			/* ���������� ��������� ������� � ������� ������ addEventHandler � ������� ������ TableColumn ����
		editAnyEvent() - ����� ������� ��������������
		editStartEvent() - ������� ������ ��������������
		editCommitEvent() - ������� ��������� �������������� (���� ����� Enter ����� �����)
		editCancelEvent() - ������� ������ �������������� 			
		   ����� addEventHandler �� �������������� ���������� ������ �� ��������� setCellFactory(TextFieldTableCell.<User>forTableColumn())		 */
		treeview1.addEventHandler(TreeView.<String>editCommitEvent(), event -> {
			/* if (event.getNewValue() == null) tableview1.refresh();		�� ��������, �.�. �� �������������� ���������� �� ���������
			else event.getRowValue().setId((Integer)event.getNewValue());  */
			System.out.println(event.getNewValue());					// ���������� ����� ��������
			System.out.println(event.getOldValue());					// ���������� ������ ��������
			System.out.println(event.getTreeItem());					// ���������� ������ �� ������������� ������� ������
			System.out.println(event.getSource());						// ��������� ������ �� ������ ������
			System.out.println(event.getTarget());					
		});
			/* ����� setOnEditCommit � ������� �� addEventHandler() �������������� ���������� ������ �� ��������� setCellFactory()
		������� ����� ���� �� ����� ������������ ����� refresh(), ������� ��� �������� � ���� id ������ � �������� null �� 
		setCellFactory() ����� ����� refresh() ��������� ������� � �� ������� �������� 		*/
		treeview1.setOnEditCommit(event -> {
			if (event.getNewValue() == null) treeview1.refresh();
		});
		
			// ������� ������������� ������ ��� ���� ����� ������
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
