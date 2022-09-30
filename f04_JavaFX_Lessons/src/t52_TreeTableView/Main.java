package t52_TreeTableView;
	
import java.util.Comparator;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.FocusModel;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeSortMode;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTablePosition;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.*;
import javafx.util.Callback;
import javafx.util.StringConverter;
/* ��������� ������������� ������ �� ���������, ��� � �������
   ������������: Object - Node - Parent- Region - Control - TreeTableView<S>		*/

public class Main extends Application {
	

	public class User {
			/* ��� ���� ����� �������� ����������. ��� �����, ����� ��������� �������� � ���� ������������� ��������� � ���������
		�������� � ������� */
		private IntegerProperty id;
		private StringProperty name;
		private StringProperty email;
		
		public User (Integer id, String name, String email) {
			this.id = new SimpleIntegerProperty(this, "id", id);
			this.name = new SimpleStringProperty(this, "name", name);
			this.email = new SimpleStringProperty(this, "email", email);
		}
		public void setId (Integer value) {
			id.set(value);
		}
		public Integer getId () {
			return id.get();
		}
		public IntegerProperty idProperty () {
			return id;
		}
		public void setName (String value) {
			name.set(value);
		}
		public String getName () {
			return name.get();
		}
		public StringProperty nameProperty () {
			return name;
		}
		public void setEmail (String value) {
			email.set(value);
		}
		public String getEmail () {
			return email.get();
		}
		public StringProperty emailProperty () {
			return email;
		}
		
		@Override
		public String toString() {
			return "User [id= " + id.get() + ", name = " + getName() + " , email = " + getEmail() + "]";
		}
	}
	
		/* ����� UserGroup ��������� ����� User � ��������� ���� �������� group, ����������� �������� ������.
	����� �������� ��� ������������, ������� ��������� ������� ���� ������, ���� ������������.
	������ ����������� ������� ������������ ������, �������� �������� ������ � �������� � StringProperty group. ��� ����
	������������� ������������ ����� -1, � ��������� �������� �� ������ User ������������� ������ ������. ��� �������� ������� 
	� ������ ������ ������ �������� ������, � ��������� ������ �������� �������.  
	������ ����������� ������� ������������, � �������� group ������������� ������ ������. ��� ��������� � ������� �������� ������
	�������� �����, � ��������� ������ �������� �������   */
	public class UserGroup extends User {
		private StringProperty group;
		public UserGroup(Integer id, String name, String email) {
			super(id, name, email);
			this.group = new SimpleStringProperty(this, "group", "");
		}
		public UserGroup(String group) {
			super(-1, "", "");
			this.group = new SimpleStringProperty(this, "group", group);
		}
		public String getGroup() {
			return group.get();
		}
		public void setGroup(String group) {
			this.group.set(group);
		}
		public StringProperty groupProperty() {
			return group;
		}
		@Override
		public String toString() {
			if (getGroup().isEmpty()) return super.toString();
			return "Group [" + getGroup()+ "]";
		}
	}
	
		@Override 
	public void start(Stage primaryStage) 		{
			// �������� ��������� �������� � �������
		TreeItem<UserGroup> rootItem2 = new TreeItem<UserGroup>(new UserGroup("ROOT GROUP"));
		rootItem2.setExpanded(true);
		rootItem2.getChildren().add(new TreeItem<UserGroup>(new UserGroup(10,  "Name1",  "name1@mail.ru")));
		
		TreeItem<UserGroup>  group1 = new TreeItem<UserGroup>(new UserGroup("GROUP 1"));
		group1.setExpanded(true);
		group1.getChildren().add(new TreeItem<UserGroup>(new UserGroup(10, "Name 10", "name10@mail.ru")));
		group1.getChildren().add(new TreeItem<UserGroup>(new UserGroup(11, "Name 11", "name11@mail.ru")));
		group1.getChildren().add(new TreeItem<UserGroup>(new UserGroup(12, "Name 12", "name12@mail.ru")));
		rootItem2.getChildren().addAll(group1);
		
		TreeItem<UserGroup>  group2 = new TreeItem<UserGroup>(new UserGroup("GROUP 2"));
		group2.setExpanded(true);
		group2.getChildren().add(new TreeItem<UserGroup>(new UserGroup(20, "Name 20", "name20@mail.ru")));
		group2.getChildren().add(new TreeItem<UserGroup>(new UserGroup(21, "Name 21", "name21@mail.ru")));
		group2.getChildren().add(new TreeItem<UserGroup>(new UserGroup(22, "Name 22", "name22@mail.ru")));
		rootItem2.getChildren().addAll(group2);
		
			// ������������
		TreeTableView<UserGroup> treeTableView2 = new TreeTableView<UserGroup>();
		treeTableView2.setMinWidth(300);
		treeTableView2.setRoot(rootItem2);
		treeTableView2.setShowRoot(true);
			/* TreeTableView.CONSTRAINED_RESIZE_POLICY ������ �������� ��������� ������ �������� - ��������� ������ ���� ��������
		����� ����� ������ ������� */
		treeTableView2.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
			/* ����� setTableMenuButtonVisible(true) ���������� � ������ ��������� ������, ��� ������� �� ������� 
		������������ ���� � ��������� ��������. � ������� ����� ���� ����� ������ ��� ���������� ������� 	 */
		treeTableView2.setTableMenuButtonVisible(true);
		
			// ����� ������� ������� � ��������� ������� ����������� �������� � �������
		TreeTableColumn<UserGroup, Number> columnId1 = new TreeTableColumn<UserGroup, Number>("User ID");
		TreeTableColumn<UserGroup, String> columnName1 = new TreeTableColumn<UserGroup, String>("User name");
		TreeTableColumn<UserGroup, String> columnEmail1 = new TreeTableColumn<UserGroup, String>("User email");
		TreeTableColumn<UserGroup, String> columnGroup = new TreeTableColumn<UserGroup, String>("GROUP"); 
				
			// �������� �������� �������
		columnName1.setText("User name");
			// �������� �������� ����� ��������� ������� � �������
		columnName1.setGraphic(new ImageView(new Image("/img/icons.png")));
			/* ������ ������� ����������� �������� � ������� ������� ��������� ��������
		cellValueFactory �� ������  TreeTableColumn<S,T> */
			/* ������ ������ �������� ������� ��� ������� ������� ����������� ����������� � ������������� ������
		TreeItemPropertyValueFactory<S,T>. �������� property ������ �������� JavaFX-�������� � ���� ������. ������ ������
		 ������ ���� ����� � ��������� <property>Property(), ������� ���������� ������ �� JavaFX-�������� - ��������,
		 nameProperty() ��� �������� name. ������� ���������, ��� ��� ������������� ������� ����� ������ ��������� ��������
		 ���� ������ ������ �� �������� � ��������������� ��������� � ������ ���������� � �������� ��� ���������
		 ����������� ��������������		 */
		columnName1.setCellValueFactory(new TreeItemPropertyValueFactory<UserGroup, String> ("name"));

		/* ������ ������ ����������� � ���������� ���������� CallBack<P,R>, ������ ������ call �������� ��� ������� �������
		 ������ �� JavaFX-��������, �������� �������� ������ ������������ � ������. 
		 ��� ��� ����� call() ���������� ������ ObservableValue<T>, �� ����� ������������� �������� ���������� ������� ���������
		 �������� ��������. ������� ����� ��������� �������� �������� ������ ������ �������� � ��������� �������� ������ 
		 ������� �������		 */
		columnEmail1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<UserGroup,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					javafx.scene.control.TreeTableColumn.CellDataFeatures<UserGroup, String> cellData) {
				return cellData.getValue().getValue().emailProperty();
			}
		});
		
			/* ������ ������� ����������� ��� ������� �������� ����� (IntegerProperty, DoubleProperty)
			��� �������� ��������� ��������� ObservableValue<Number>, �� �� ObservableValue<Integer>
			������� ������ ����������� ����� ������ ���������� ����� ��� ��� �������� ������� ��������� Number ������ Integer */
		columnId1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<UserGroup,Number>, ObservableValue<Number>>() {
			@Override
			public ObservableValue<Number> call(
					javafx.scene.control.TreeTableColumn.CellDataFeatures<UserGroup, Number> cellData) {
				return cellData.getValue().getValue().idProperty();
			}
		});
		
		columnGroup.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<UserGroup,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					javafx.scene.control.TreeTableColumn.CellDataFeatures<UserGroup, String> cellData) {
				return cellData.getValue().getValue().groupProperty();
			}
		});
			// ���������� �������� � �������
		treeTableView2.getColumns().add(columnGroup);
//		treeTableView2.getColumns().add(columnId1);
//		treeTableView2.getColumns().add(columnName1);
//		treeTableView2.getColumns().add(columnEmail1);
//		treeTableView2.setShowRoot(true);				// ������ root ���� 
		
			// ����������� �������� � ������
		TreeTableColumn<UserGroup, Integer> columnGroup2 = new TreeTableColumn<UserGroup, Integer>("������ ��������");
		columnGroup2.getColumns().add(columnName1);
		columnGroup2.getColumns().add(columnEmail1);
		treeTableView2.getColumns().add(columnId1);
		treeTableView2.getColumns().add(columnGroup2);
		
			// ���������� ������� ��������
		columnId1.setMinWidth(60);		columnName1.setMinWidth(70);  columnEmail1.setMinWidth(60); 
		columnGroup.setMinWidth(80);
		columnId1.setPrefWidth(120);
		columnId1.setMaxWidth(150);
		columnId1.setResizable(true); // ��� true ���� ����� ������ ������ �������, �������� ����� �� ������� ������� � ������ ��������� 
		columnName1.setResizable(true);
		treeTableView2.resizeColumn(columnId1, 5); 		// ��������� ������ ��������� ������ �� 5 ���
			
			// ���������� ������� ��������
		treeTableView2.setFixedCellSize(20);   // ���� ��������� 0 ��� ������������� �����, �� ������������� ������ �� ������������
			
			// ���������� ��������� �������
		treeTableView2.setMinWidth(400);
		
		/* ���������� ��������� ��������� �������� �������� �������������� ����� ����� TableView<S> � ��� 
		����� void setColumnResizePolicy(CallBack<TableView.ResizeFeatures, Boolean>. ����� ����� �������������� ����������� ���������
		CallBack ��� ��������������� ������������ ����������� 
		 - CONSTRAINED_RESIZE_POLICY - ��� ��������� ������ �������, ������ ������� �����������, ����� ������ �������.�����
		 - UNCONSTRAINED_RESIZE_POLICY - ��� ��������� ������ ������� ������ ������� ��������� ����� ��� ������ �� ��� ���������
			 */
		treeTableView2.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
		
			// ��������� ��������� �������
		columnId1.setVisible(true);		// ��� false ������� �� ����� ������������
			/* ����� ���� ����������� ����� �������� �������, ����� ��������� �������� true ��� �������� 
		tableMenuButtonVisible. � ���� ������ � ��������� �������� ������, ��� ������� ������� ����� ������� ������ ��������,
		��� ������� ����� ������ �������� ������� ������� 	 */
		treeTableView2.setTableMenuButtonVisible(true);
		System.out.println("������ ������� �������� " + treeTableView2.getVisibleLeafColumns());
		System.out.println("C������ �� ������� � ������� � ������� 3" + treeTableView2.getVisibleLeafColumn(5));
		System.out.println("������ ���������� ������� " + treeTableView2.getVisibleLeafIndex(columnEmail1));
		
			/* ��������� ��������� 
		����� ������� � ��������� �������� �������� � ���� ��������� ��������� ����� scrollTo()  */
				// ��������� � ���������� �������� ��������
		treeTableView2.scrollTo(treeTableView2.getExpandedItemCount() - 1);
				// ��������� � ���������� �������� ��� �������, ��� �� ������������ 
		int index = treeTableView2.getRow(rootItem2);
		if (index !=-1) treeTableView2.scrollTo(index);
			// ���������� ���������
		treeTableView2.setOnScrollTo(event -> {
			System.out.println("Scroll to " + event.getScrollTarget());
		});
		
			/* ���������� ������� ���������
		������������, ��� ����� ������, ��� � ���������� ��������� 	 */
		treeTableView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		Button setSelected = new Button("Set selected el");
		setSelected.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<Integer> arr = treeTableView2.getSelectionModel().getSelectedIndices();
				System.out.println("������� ���������� ��������� " + arr);
				ObservableList<TreeItem<UserGroup>> arr2 = treeTableView2.getSelectionModel().getSelectedItems();
				System.out.println("���������� �������� " + arr2);
				System.out.println(treeTableView2.getSelectionModel().getSelectedIndices());
				System.out.println(treeTableView2.getSelectionModel().getSelectedItems());
				Alert alert = new Alert(AlertType.INFORMATION, treeTableView2.getSelectionModel().getSelectedIndices() + "\n" +
				treeTableView2.getSelectionModel().getSelectedItems());
				alert.showAndWait();
			}
		});
		
			// ���������� ������� ��������� ������
		treeTableView2.getSelectionModel().setCellSelectionEnabled(true);		// ��������� ��������� ��������� ������
//		treeTableView2.getSelectionModel().select(2);				// ����� 2-�� ������
		treeTableView2.getSelectionModel().select(2, columnId1);	// ����� ������ �� 2-�� ������ � � ������� columnId
		treeTableView2.getSelectionModel().selectAboveCell();		// ����� ������ ���� 
		treeTableView2.getSelectionModel().selectBelowCell();		// ����� ������ ����
		treeTableView2.getSelectionModel().selectLeftCell();		// ����� ������ �����
		treeTableView2.getSelectionModel().selectRightCell();		// ����� ������ ������ 
		treeTableView2.getSelectionModel().clearSelection();		// ���������� �����
		treeTableView2.getSelectionModel().selectRange(3, columnId1, 5, columnName1);		// ����� �������� �����
			
			// ������ ��� ��������� ��������� �����
		Button btn12 = new Button("GET Cells");
		btn12.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<TreeTablePosition<UserGroup, ?>> cellsList = treeTableView2.getSelectionModel().getSelectedCells();
				StringBuilder sb = new StringBuilder();
				String msg = "";
				for (int i=0; i<cellsList.size(); i++) {
					TreeTablePosition<UserGroup, ?> elem =  cellsList.get(i);
					msg = "Row - " + elem.getRow() + " Column - " + elem.getColumn() 
						+ " ��������� ������� - " + elem.getTableColumn().getText() + "  �������� � ������ -  "
						+ elem.getTableColumn().getCellObservableValue(elem.getRow()).getValue() +  "  "
						+ elem.getTableColumn().getCellData(elem.getRow()) + "\n";
						sb = sb.append(msg);
				}
				Alert alert = new Alert(AlertType.INFORMATION, sb.toString());
				alert.setWidth(200.0);
				alert.showAndWait();
			}
		});
		
			/* ���������� ������� �����
		�������� focusModel �� ������ TreeView<T> �������� ������ �� ������, � ������� �������� ����� ���������
		������� �����.
	    ���� ������ ��������� ������� ������ ������, ������������ � ������ �����, � ����� ��������*/
		FocusModel<TreeItem<UserGroup>> focusModel = treeTableView2.getFocusModel();
		System.out.println("Index - " + focusModel.getFocusedIndex());
		System.out.println("Item" + focusModel.getFocusedItem());
			// ������������ ��������� ������� ������
		treeTableView2.getFocusModel().focusedIndexProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Index  " + newValue);
		});
		
			/* ��������� ������� ����������� ����� �������
		��������� ������� �������� cellFactory �� ������ TreeTableColumn<S,T>
		������������: Object - Node - Parent - Region - control - Labelled - Cell<T> - IndexedCell<T> - TableCell<S,T> 
		����� ������� ������������, �������� ��� �����, �����, ���������� �����-���� ���� ����� � ������� (��� ������ ������),
		��������� ������� ������ �� ����� ������ (setWrapText(true)) � ������ ������, �������������� �� Labelled			*/
			// ����������� �������� ����� �� ������ ������� � ������� -1 � ��������� 
		
		
		Callback<TreeTableColumn<UserGroup, Number>, TreeTableCell<UserGroup, Number>> cellFactory = 
				new Callback<TreeTableColumn<UserGroup,Number>, TreeTableCell<UserGroup,Number>>() {
					@Override
					public TreeTableCell<UserGroup, Number> call(TreeTableColumn<UserGroup, Number> param) {
						return new TreeTableCell<UserGroup, Number>(){
							{
							setAlignment(Pos.TOP_CENTER);
//							setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, getInsets())));
							setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 12));
							}
							@Override
							protected void updateItem(Number value, boolean empty) {
								super.updateItem(value, empty);
								if (value == null || empty) setText("");
								else {
									if (value.intValue()<0) setText("");
									else setText(value.toString());
								}
							}
					};
				}
		};
		columnId1.setCellFactory(cellFactory);
		
			/* ��������� ������� ����������� ����� ������
		��������� ������� �������� rowFactory �� ������ TreeTableView<S,T>
		������������: Object - Node - Parent - Region - control - Labelled - Cell<T> - IndexedCell<T> - TreeTableRow<S,T> 
		����� ������� ������������, �������� ��� �����, �����, ���������� �����-���� ���� ����� � ������� (��� ������ ������),
		��������� ������� ������ �� ����� ������ (setWrapText(true)) � ������ ������, �������������� �� Labelled			*/
			// ��������� ������ � ���������� ������ ����� ������
		Callback<TreeTableView<UserGroup>, TreeTableRow<UserGroup>> rowFactory = 
			new Callback<TreeTableView<UserGroup>, TreeTableRow<UserGroup>>() {
				@Override
				public TreeTableRow<UserGroup> call(TreeTableView<UserGroup> param) {
					return new TreeTableRow<UserGroup>(){
						@Override
						protected void updateItem(UserGroup user, boolean empty) {
						super.updateItem(user, empty);
						if (user == null || empty) setStyle("");
						else {
							if (user.getGroup().isEmpty()) setStyle("");
							else setStyle("-fx-background-color: gray;");
						}
					}
				};
			}
		};
		treeTableView2.setRowFactory(rowFactory);
		
			/* ���������� ���������
		������� �� ��������� ������������ ���������� ��������� ������ �������. ��� ����� ���������� �������� ����� ��������
		���� �� ��������� ������� - ��������� ������ �����������, ������������ ����������� ����������. ����� ��������
		����������� ����������, ����� �������� ����� ������� ���� �� ��������� ��� ���.
		����� ��������� ���������� ����� �� ���������� ��������, ��������� Shift ��� ������ ����� */
			// ��������� ������������ ��� ����������
//		columnEmail1.setSortNode();
			// ������ ����������
		treeTableView2.setSortPolicy(table -> false);
			/* SortMode ������ ����� ����������. � ��������� valu� ��������� ��������� 
		 - ALL_DESCENDANTS - ���������� ���� ��������� (�������� �� ���������)
		 - ONLY_FIRST_LEVEL - ���������� ������ ��������� ������� ������ �����������  	 */
		treeTableView2.setSortMode(TreeSortMode.ALL_DESCENDANTS);
		
			// ���������� ����������� �� ����������
		treeTableView2.setOnSort(new EventHandler<SortEvent<TreeTableView<UserGroup>>>() {
			@Override
			public void handle(SortEvent<TreeTableView<UserGroup>> event) {
				System.out.println("��������� ����������");
			}
		});
			// ���������� ������ �� ���������� �� �����������
		Button btnSort = new Button("Sort email");
		btnSort.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				columnEmail1.setSortType(TreeTableColumn.SortType.ASCENDING);			// �� �����������
				treeTableView2.getSortOrder().clear();
				treeTableView2.getSortOrder().add(columnEmail1);
					/* ��� ���������� ����� ������ �������, ���������� ���������� ����� �� ���������� ��������
				� ������ ���������� ���������� �� ������� �������, � � ������ ��������� �������� ������������ ���������� 
				�� ���������� ������� 					 */
				treeTableView2.getSortOrder().add(columnName1);
				treeTableView2.sort();
			}
		});
			// ������ ����������� comparator ������� ��� ����������
		columnName1.setComparator(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) return 1;
				else if (o1.length() == o2.length()) return 0;
				else return -1;
			}
		});
		
			/* �������������� ��������� � �������
		������� ����� ��������� �������������� � ������� ������ setEditable(true);
		����� ����� ������ �������� �������� cellFactory - ����� ����������� ���� ����������� ������ �������������� ���
		��������������� �������� �������� �� ������ scene.control.cell.  ��������, ������� TextFieldTable<S,T>, ������� � ������
		�������������� ���������� ������ ������ ��������� ���� 			 */
		treeTableView2.setEditable(true);
			// ������ ������ forTableColumn() ���� �������� ������ ��� String
		columnName1.setCellFactory(TextFieldTreeTableCell.<UserGroup>forTreeTableColumn());
		columnEmail1.setCellFactory(TextFieldTreeTableCell.<UserGroup>forTreeTableColumn());
		
			// ������ ������ forTableColumn() ���� ��������� ������� ������ �������������� �������� � ������ � ��������
		columnId1.setCellFactory(TextFieldTreeTableCell.<UserGroup, Number>forTreeTableColumn(
			new StringConverter<Number>() {
				@Override
				public Number fromString(String string) {
					try {
						return Integer.valueOf(string);
					} catch (Exception e) {
						return null;
					}
				}
				@Override
				public String toString(Number object) {
					if (object == null) return "";
					else return object.toString();
				}
			}));
			/* ���������� ��������� ������� � ������� ������ addEventHandler � ������� ������ TableColumn ����
		editAnyEvent() - ����� ������� ��������������
		editStartEvent() - ������� ������ ��������������
		editCommitEvent() - ������� ��������� �������������� (���� ����� Enter ����� �����)
		editCancelEvent() - ������� ������ �������������� 			
		   ����� addEventHandler �� �������������� ���������� ������ �� ��������� setCellFactory(TextFieldTableCell.<User>forTableColumn())		 */
		
		columnId1.addEventHandler(TreeTableColumn.<UserGroup, Number>editCommitEvent(), event -> {
			/* if (event.getNewValue() == null) tableview1.refresh();		�� ��������, �.�. �� �������������� ���������� �� ���������
			else event.getRowValue().setId((Integer)event.getNewValue());  */
			System.out.println(event.getNewValue());					// ���������� ����� ��������
			System.out.println(event.getOldValue());					// ���������� ������ ��������
			System.out.println(event.getRowValue());					// ���������� ������ �� ������ User, �������� �������� � ���� ������
			System.out.println(event.getTreeTableView());					// ���������� ������ �� �������
			System.out.println(event.getTableColumn());					// ���������� ������ �� ������ �������
			System.out.println(event.getTreeTablePosition());				// ���������� ������ �� ������� ������� 
			System.out.println(event.getTreeTablePosition().getRow());
			System.out.println(event.getTreeTablePosition().getColumn());
			System.out.println(event.getTreeTableView().getEditingCell());
		});
			/* ����� setOnEditCommit � ������� �� addEventHandler() �������������� ���������� ������ �� ��������� setCellFactory()
		������� ����� ���� �� ����� ������������ ����� refresh(), ������� ��� �������� � ���� id ������ � �������� null �� 
		setCellFactory() ����� ����� refresh() ��������� ������� � �� ������� �������� 		*/
		columnId1.setOnEditCommit(event -> {
			if (event.getNewValue() == null) treeTableView2.refresh();
			else event.getRowValue().getValue().setId((Integer)event.getNewValue());
		});
		
			/* ��������� ������� ��������
		�� ��������� ���� ����� �������� ��������� �������, �������� ����� �� ��������� ������� � ��������� ��� � ������ �����.
		����� ��������� �������������� ����� �������� false �������� reorderable				 */
		columnId1.setReorderable(false);
		
			// ���������� �� ������� ����� � ���������
		System.out.println("group1 �������� Leaf (�� ����� �����) " + group1.isLeaf());
		System.out.println("�������� ��� group1 " + group1.getParent());
		
			// ����������� �� ������
		System.out.println("��������� ������� �� ��� �� ������ " + group1.nextSibling());
		System.out.println("��������� ������� �� ��� �� ������ " + group1.nextSibling());
		System.out.println("���������� ������� �� ��� �� ������ " + group1.previousSibling());
		
			// �������e��� ������� ���� ������ ������
		System.out.println("����� ������ � ������ ��� ���� point 1.1 - " + treeTableView2.getRow(group1));
			// ���� ���� �����, �� getRow() ���������� -1
		System.out.println("������� ����������� ���� point 1.1 - " + treeTableView2.getTreeItemLevel(group1));
		
			// ���������� ������ �� �������, ����������� � ������ �� ��������� ������� ������
		System.out.println("������� �� 2-�� ������� (������) " + treeTableView2.getTreeItem(2));
		
			// ���������� ������� ��������� ������
		System.out.println("���������� ������� ��������� ������ - " + treeTableView2.getExpandedItemCount());
		
		HBox hbox = new HBox(10, treeTableView2, setSelected, btn12, btnSort);
		hbox.setMinWidth(500);
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
