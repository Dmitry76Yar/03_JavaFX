package t49_TableView;
	
import java.util.Comparator;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.skin.TextFieldSkin;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

public class Main extends Application  {
	
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
	
		@Override 
	public void start(Stage primaryStage) {	
			/* ����� TableView<T> ������������ ��� ����������� � ��������� �����
			   ����� TreeView<T> � TreeTableView<S> ������������ ��� ����������� ������ � ����� �������� 
		������������: Object - Node - Parent - Region - Control - TableView<S> 	    */
			
		ObservableList<User> list = FXCollections.<User>observableArrayList();
		for (int i=1; i<20; i++) list.add(new User(100+i, "user" + i, "email" + i));
			
				/* �����������
		- TableView()	 
		- TableView(ObservableList<S> items)  */
		TableView<User> tableview1 = new TableView<User>(); 	
		TableView<User> tableview2 = new TableView<User>(list);
		
			// ���������� � TableView
		tableview1.setItems(list);
		
			/* �������� ��������
		������ �������� ������ � ������� ������������, ����� ������� ������� ������� � ��������� ������� ����������� 
		�������� � ������� �������. �������� �������� � ������� ������ TableColumn<S,T>
		������������: Object - TableColumnBase<S,T> - TableColumn<S,T>	*/
			/* �����������
		- TableColumn()	 
		- TableColumn(String text)   - text ������ �������� �������, ������ ����� � ��������� 
			���� �������� ������� � ���������� ��� � ����� name ������ User */
		TableColumn<User, String> columnName2 = new TableColumn<User, String>();
		TableColumn<User, String> columnName1 = new TableColumn<User, String>("User name");
		TableColumn<User, String> columnEmail1 = new TableColumn<User, String>("User email");
			// �������� �������� �������
		columnName1.setText("User name");
			// �������� �������� ����� ��������� ������� � �������
		columnName1.setGraphic(new ImageView(new Image("/img/icons.png")));
		
			/* ������ ������� ����������� �������� � ������� ������� ��������� ��������
		cellValueFactory �� ������  TableColumn<S,T> */
			/* ������ ������ �������� ������� ��� ������� ������� ����������� ����������� � ������������� ������
		 PropertyValueFactory<S,T>. �������� property ������ �������� JavaFX-�������� � ���� ������. ������ ������
		 ������ ���� ����� � ��������� <property>Property(), ������� ���������� ������ �� JavaFX-�������� - ��������,
		 nameProperty() ��� �������� name 		 */
		columnName1.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		
			/* ������ ������ ����������� � ���������� ���������� CallBack<P,R>, ������ ������ call �������� ��� ������� �������
		 ������ �� JavaFX-��������, �������� �������� ������ ������������ � ������. 
		 ��� ��� ����� call() ���������� ������ ObservableValue<T>, �� ����� ������������� �������� ���������� ������� ���������
		 �������� ��������. ������� ����� ��������� �������� �������� ������ ������ �������� � ��������� �������� ������ 
		 ������� �������		 */
		columnEmail1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<User, String> cellData) {
				return cellData.getValue().emailProperty();
			}
		});
			// ���� ����� � ������-��������� 
//		columnEmail1.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		
			/* ������ ������� ����������� ��� ������� �������� ����� (IntegerProperty, DoubleProperty)
		��� �������� ��������� ��������� ObservableValue<Number>, �� �� ObservableValue<Integer>
		������� ������ ����������� ����� ������ ���������� ����� ��� ��� �������� ������� ��������� Number ������ Integer */
		TableColumn<User, Number> columnId1 = new TableColumn<User, Number>("User ID");
		columnId1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User,Number>, ObservableValue<Number>>() {
			@Override
			public ObservableValue<Number> call(CellDataFeatures<User, Number> cellData) {
				return cellData.getValue().idProperty();
			}
		});
			
			// ���������� �������� � �������
		tableview1.getColumns().add(columnId1);
		tableview1.getColumns().add(columnName1);
		tableview1.getColumns().add(columnEmail1);
		
			// ����������� �������� � ������
		TableColumn<User, Integer> columnGroup = new TableColumn<>("������ ��������");
//		columnGroup.getColumns().add(columnName1);
//		columnGroup.getColumns().add(columnEmail1);
//		tableview2.getColumns().add(columnId1);
//		tableview2.getColumns().add(columnGroup);
		
			// ���������� ������� ��������
		columnId1.setMinWidth(100);		columnName1.setMinWidth(150);  columnEmail1.setMinWidth(150);
		columnId1.setPrefWidth(120);
		columnId1.setMaxWidth(150);
		columnId1.setResizable(true); // ��� true ���� ����� ������ ������ �������, �������� ����� �� ������� ������� � ������ ��������� 
		columnName1.setResizable(true);
		tableview1.resizeColumn(columnId1, 5); 		// ��������� ������ ��������� ������ �� 5 ���
		
			// ���������� ������� ��������
		tableview1.setFixedCellSize(20);   // ���� ��������� 0 ��� ������������� �����, �� ������������� ������ �� ������������
			
			// ���������� ��������� �������
		tableview1.setMinWidth(400);
		tableview2.setMinWidth(400);
		
			/* ���������� ��������� ��������� �������� �������� �������������� ����� ����� TableView<S> � ��� 
		����� void setColumnResizePolicy(CallBack<TableView.ResizeFeatures, Boolean>. ����� ����� �������������� ����������� ���������
		CallBack ��� ��������������� ������������ ����������� 
		 - CONSTRAINED_RESIZE_POLICY - ��� ��������� ������ �������, ������ ������� �����������, ����� ������ �������.�����
		 - UNCONSTRAINED_RESIZE_POLICY - ��� ��������� ������ ������� ������ ������� ��������� ����� ��� ������ �� ��� ���������
			 */
		tableview1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
			// ��������� ��������� �������
		columnId1.setVisible(true);		// ��� false ������� �� ����� ������������
			/* ����� ���� ����������� ����� �������� �������, ����� ��������� �������� true ��� �������� 
		tableMenuButtonVisible. � ���� ������ � ��������� �������� ������, ��� ������� ������� ����� ������� ������ ��������,
		��� ������� ����� ������ �������� ������� ������� 	 */
		tableview1.setTableMenuButtonVisible(true);
		System.out.println("������ ������� �������� " + tableview1.getVisibleLeafColumns());
		System.out.println("C������ �� ������� � ������� � ������� 3" + tableview1.getVisibleLeafColumn(5));
		System.out.println("������ ���������� ������� " + tableview1.getVisibleLeafIndex(columnEmail1));
		
			
			/* ���������� ������� ����� � �����
		������� ������������ ����� ��� ����� ������ (SelectionMode.SINGLE), ��� � ���������� ����� (SelectionMode.MULTIPLE)
		���������� ����� ����� ������ ��������� �����.
		��� ������ ���������� ����� ��� ����� ���������� ���������� Ctrl ��� Shift 	 */
		tableview1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			// ������ ��� ��������� ��������� �����
		Button btn11 = new Button("GET Rows");
		btn11.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<Integer> indexRaws = tableview1.getSelectionModel().getSelectedIndices();
				ObservableList<User> itemsRaws = tableview1.getSelectionModel().getSelectedItems();
				System.out.println(indexRaws);
				System.out.println(itemsRaws);
				Alert alert = new Alert(AlertType.INFORMATION, indexRaws + "\n" + itemsRaws);
				alert.showAndWait();
			}
		});
		
			// ���������� ������� ��������� ������
		tableview1.getSelectionModel().setCellSelectionEnabled(true);		// ��������� ��������� ��������� ������
//		tableview1.getSelectionModel().select(2);				// ����� 2-�� ������
		tableview1.getSelectionModel().select(2, columnId1);	// ����� ������ �� 2-�� ������ � � ������� columnId
		tableview1.getSelectionModel().selectAboveCell();		// ����� ������ ���� 
		tableview1.getSelectionModel().selectBelowCell();		// ����� ������ ����
		tableview1.getSelectionModel().selectLeftCell();		// ����� ������ �����
		tableview1.getSelectionModel().selectRightCell();		// ����� ������ ������ 
		tableview1.getSelectionModel().clearSelection();		// ���������� �����
		tableview1.getSelectionModel().selectRange(3, columnId1, 5, columnName1);		// ����� �������� �����
			
			// ������ ��� ��������� ��������� �����
		Button btn12 = new Button("GET Cells");
			btn12.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<TablePosition> cellsList = tableview1.getSelectionModel().getSelectedCells();
				StringBuilder sb = new StringBuilder();
				String msg = "";
				for (int i=0; i<cellsList.size(); i++) {
					TablePosition elem =  cellsList.get(i);
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
			
			/* ��������� ������� ����������� ����� �������
		��������� ������� �������� cellFactory �� ������ Table<S,T>
		������������: Object - Node - Parent - Region - control - Labelled - Cell<T> - IndexedCell<T> - TableCell<S,T> 
		����� ������� ������������, �������� ��� �����, �����, ���������� �����-���� ���� ����� � ������� (��� ������ ������),
		��������� ������� ������ �� ����� ������ (setWrapText(true)) � ������ ������, �������������� �� Labelled			*/
			// ����������� �������� ����� �� ������ �������
		Callback<TableColumn<User, Number>, TableCell<User, Number>> cellFactory = 
				new Callback<TableColumn<User,Number>, TableCell<User,Number>>() {
					@Override
					public TableCell<User, Number> call(TableColumn<User, Number> param) {
						return new TableCell<User, Number>(){
							{
							setAlignment(Pos.TOP_CENTER);
//							setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, getInsets())));
							setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 12));
							}
							@Override
							protected void updateItem(Number value, boolean empty) {
								super.updateItem(value, empty);
								if (value == null || empty) setText("");
								else setText(value.toString());
							}
					};
				}
		};
		columnId1.setCellFactory(cellFactory);
		
			/* ��������� ������� ����������� ����� ������
		��������� ������� �������� rowFactory �� ������ Table<S,T>
		������������: Object - Node - Parent - Region - control - Labelled - Cell<T> - IndexedCell<T> - TableRow<S,T> 
		����� ������� ������������, �������� ��� �����, �����, ���������� �����-���� ���� ����� � ������� (��� ������ ������),
		��������� ������� ������ �� ����� ������ (setWrapText(true)) � ������ ������, �������������� �� Labelled			*/
			// ����������� �������� �� ������ � �������
		Callback<TableView<User>, TableRow<User>> rowFactory = 
			new Callback<TableView<User>, TableRow<User>>() {
				@Override
				public TableRow<User> call(TableView<User> param) {
					return new TableRow<User>(){
						@Override
						protected void updateItem(User user, boolean empty) {
						super.updateItem(user, empty);
						if (user == null || empty) setStyle("");
						else {
							if (user.getId() == 108) setStyle("-fx-background-color: green;");
						}
					}
				};
			}
		};
		tableview1.setRowFactory(rowFactory);
		
			/* ���������� ���������
		������� �� ��������� ������������ ���������� ��������� ������ �������. ��� ����� ���������� �������� ����� ��������
		���� �� ��������� ������� - ��������� ������ �����������, ������������ ����������� ����������. ����� ��������
		����������� ����������, ����� �������� ����� ������� ���� �� ��������� ��� ���.
		����� ��������� ���������� ����� �� ���������� ��������, ��������� Shift ��� ������ ����� */
			// ��������� ������������ ��� ����������
//		columnEmail1.setSortNode();
			// ������ ����������
		tableview2.setSortPolicy(table -> false);
			// ���������� ����������� �� ����������
		tableview1.setOnSort(new EventHandler<SortEvent<TableView<User>>>() {
			@Override
			public void handle(SortEvent<TableView<User>> event) {
				System.out.println("��������� ����������");
			}
		});
			// ��������� ����������� ����������
		tableview1.setSortPolicy(new Callback<TableView<User>, Boolean>() {
			@Override
			public Boolean call(TableView<User> param) {
				if (param.getComparator() != null) {
					FXCollections.sort(param.getItems(), param.getComparator());
				}
				return true;
			}
		});
			// ���������� ������ �� ���������� �� �����������
		Button btnSort = new Button("Sort email");
		btnSort.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				columnEmail1.setSortType(SortType.ASCENDING);			// �� �����������
				tableview1.getSortOrder().clear();
				tableview1.getSortOrder().add(columnEmail1);
				tableview1.sort();
			}
		});
			// ���������� ������ �� ���������� �� ����� ������ (����������� Comparator)
		Button btnSort2 = new Button("Sort name");
		btnSort2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				columnName1.setComparator(new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						if (o1.length() > o2.length()) return 1;
						else if (o1.length() == o2.length()) return 0;
						else return -1;
					}
				});			// �� �����������
				tableview1.getSortOrder().clear();
				tableview1.getSortOrder().add(columnId1);
					/* ��� ���������� ����� ������ �������, ���������� ���������� ����� �� ���������� ��������
				� ������ ���������� ���������� �� ������� �������, � � ������ ��������� �������� ������������ ���������� 
				�� ���������� ������� 					 */
				tableview1.getSortOrder().add(columnName1);
				tableview1.sort();
			}
		});
		
			/* �������������� ��������� � �������
		������� ����� ��������� �������������� � ������� ������ setEditable(true);
		����� ����� ������ �������� �������� cellFactory - ����� ����������� ���� ����������� ������ �������������� ���
		��������������� �������� �������� �� ������ scene.control.cell.  ��������, ������� TextFieldTable<S,T>, ������� � ������
		�������������� ���������� ������ ������ ��������� ���� 			 */
		tableview1.setEditable(true);
			// ������ ������ forTableColumn() ���� �������� ������ ��� String
		columnName1.setCellFactory(TextFieldTableCell.<User>forTableColumn());
		columnEmail1.setCellFactory(TextFieldTableCell.<User>forTableColumn());
			// ������ ������ forTableColumn() ���� ��������� ������� ������ �������������� �������� � ������ � ��������
		columnId1.setCellFactory(TextFieldTableCell.<User, Number>forTableColumn(
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
		columnId1.addEventHandler(TableColumn.<User, Number>editCommitEvent(), event -> {
			/* if (event.getNewValue() == null) tableview1.refresh();		�� ��������, �.�. �� �������������� ���������� �� ���������
			else event.getRowValue().setId((Integer)event.getNewValue());  */
			System.out.println(event.getNewValue());					// ���������� ����� ��������
			System.out.println(event.getOldValue());					// ���������� ������ ��������
			System.out.println(event.getRowValue());					// ���������� ������ �� ������ User, �������� �������� � ���� ������
			System.out.println(event.getTableView());					// ���������� ������ �� �������
			System.out.println(event.getTableColumn());					// ���������� ������ �� ������ �������
			System.out.println(event.getTablePosition());				// ���������� ������ �� ������� ������� 
			System.out.println(event.getTablePosition().getRow());
			System.out.println(event.getTablePosition().getColumn());
			System.out.println(event.getTableView().getEditingCell());
		});
			/* ����� setOnEditCommit � ������� �� addEventHandler() �������������� ���������� ������ �� ��������� setCellFactory()
		������� ����� ���� �� ����� ������������ ����� refresh(), ������� ��� �������� � ���� id ������ � �������� null �� 
		setCellFactory() ����� ����� refresh() ��������� ������� � �� ������� �������� 		*/
		columnId1.setOnEditCommit(event -> {
			if (event.getNewValue() == null) tableview1.refresh();
			else event.getRowValue().setId((Integer)event.getNewValue());
		});
		
				/* ��������� ������� ��������
		�� ��������� ���� ����� �������� ��������� �������, �������� ����� �� ��������� ������� � ��������� ��� � ������ �����.
		����� ��������� �������������� ����� �������� false �������� reorderable				 */
		columnId1.setReorderable(false);
		
			// ������������� ���� (��������, label), ������� ������������ ����� ������ ������
		tableview1.setPlaceholder(new Label("Empty list"));
				
			// ������ ������������� ������ (��� ������.����������) � ������ (��� �����.����������) ����� ������
		tableview1.setFixedCellSize(20);
				
			// ��������� �������� �� ������ �� ��������� (����� ����� ������ ����)
		tableview1.getSelectionModel().selectLast();
		
			// ������� ������ �� �������� �� ������ �� ��������� (����� ����� ������ ����)
		tableview1.getFocusModel().focus(3);
				
		HBox hbox = new HBox();
		hbox.setMinWidth(100);	hbox.setPadding(new Insets(10));		hbox.setSpacing(20);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(btn11, btn12, btnSort, btnSort2);
		
		hbox.getChildren().addAll(tableview1, vbox);
//		hbox.getChildren().addAll(tableview1, tableview2);
		Scene scene = new Scene(hbox, 1000, 600);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
