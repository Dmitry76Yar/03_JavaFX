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
/* Реализует иерархический список со столбцами, как в таблице
   Наследование: Object - Node - Parent- Region - Control - TreeTableView<S>		*/

public class Main extends Application {
	

	public class User {
			/* Все поля юзера является свойствами. Это нужно, чтобы изменения значения в поле автоматически приводило к изменению
		значения в таблице */
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
	
		/* Класс UserGroup наследует класс User и добавляет одно свойство group, описывающей название группы.
	Класс содержит два конструктора, которые позволяют создать либо группу, либо пользователя.
	Первый конструктор создает именнованную группу, сохраняя название группы в свойство в StringProperty group. При этом
	идентификатор пользователя будет -1, а остальным свойства из класса User присваивается пустая строка. Это позволит вывести 
	в строке списка только название группы, а остальные ячейки оставить пустыми.  
	Второй конструктор создает пользователя, а свойству group присваивается пустая строка. Это позваолит в столбце выводить только
	название групп, а остальные ячейки оставить пустыми   */
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
			// Создание корневого элемента с группой
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
		
			// Конструкторы
		TreeTableView<UserGroup> treeTableView2 = new TreeTableView<UserGroup>();
		treeTableView2.setMinWidth(300);
		treeTableView2.setRoot(rootItem2);
		treeTableView2.setShowRoot(true);
			/* TreeTableView.CONSTRAINED_RESIZE_POLICY задает политику изменения ширины столбцов - суммарная ширина всех столбцов
		будет равна ширине таблицы */
		treeTableView2.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
			/* Метод setTableMenuButtonVisible(true) отображает в строке заголовка кнопку, при нажатии на которую 
		показывается меню с названием столбцов. С помощью этого меню можно скрыть или отобразить столбец 	 */
		treeTableView2.setTableMenuButtonVisible(true);
		
			// Нужно описать столбцы и назначить правила отображения значений в ячейках
		TreeTableColumn<UserGroup, Number> columnId1 = new TreeTableColumn<UserGroup, Number>("User ID");
		TreeTableColumn<UserGroup, String> columnName1 = new TreeTableColumn<UserGroup, String>("User name");
		TreeTableColumn<UserGroup, String> columnEmail1 = new TreeTableColumn<UserGroup, String>("User email");
		TreeTableColumn<UserGroup, String> columnGroup = new TreeTableColumn<UserGroup, String>("GROUP"); 
				
			// Внесение название столбца
		columnName1.setText("User name");
			// Внесение картинки перед названием столбца в таблице
		columnName1.setGraphic(new ImageView(new Image("/img/icons.png")));
			/* Задать правило отображения значенйи в ячейках столбца позволяет свойство
		cellValueFactory из класса  TreeTableColumn<S,T> */
			/* Первый способ создания объекта для задания правила отображения заклбчается в использовании класса
		TreeItemPropertyValueFactory<S,T>. Параметр property задает название JavaFX-свойства в виде строки. Внутри класса
		 должен быть метод с названием <property>Property(), который возвращает ссылку на JavaFX-свойство - например,
		 nameProperty() для свойства name. Следует учитывать, что при использовании обычных типов данных изменение значения
		 поля внутри класса не приведет к автоматическому изменению в ячейке компонента и придется все изменения
		 отслеживать самостоятельно		 */
		columnName1.setCellValueFactory(new TreeItemPropertyValueFactory<UserGroup, String> ("name"));

		/* Второй способ заключается в реализации интерфейса CallBack<P,R>, внутри метода call которого нам следует вернуть
		 ссылку на JavaFX-свойство, значение которого должно отображаться в ячейке. 
		 Так как метод call() возвращает объект ObservableValue<T>, то будет автоматически добавлен обработчик события изменения
		 значения свойства. Поэтому любое изменение значения свойства внутри класса привдеет к изменению значения внутри 
		 ячейчки таблицы		 */
		columnEmail1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<UserGroup,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					javafx.scene.control.TreeTableColumn.CellDataFeatures<UserGroup, String> cellData) {
				return cellData.getValue().getValue().emailProperty();
			}
		});
		
			/* Задать правило отображения для свойств числовых типов (IntegerProperty, DoubleProperty)
			Эти свойства реализуют интерфейс ObservableValue<Number>, но не ObservableValue<Integer>
			Поэтому внутри обработчика нужно делать привидение типов или при создании столбца указывать Number вместо Integer */
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
			// Добавление столбцов в таблицу
		treeTableView2.getColumns().add(columnGroup);
//		treeTableView2.getColumns().add(columnId1);
//		treeTableView2.getColumns().add(columnName1);
//		treeTableView2.getColumns().add(columnEmail1);
//		treeTableView2.setShowRoot(true);				// Скроем root узел 
		
			// Объединение столбцов в группу
		TreeTableColumn<UserGroup, Integer> columnGroup2 = new TreeTableColumn<UserGroup, Integer>("Группа столбцов");
		columnGroup2.getColumns().add(columnName1);
		columnGroup2.getColumns().add(columnEmail1);
		treeTableView2.getColumns().add(columnId1);
		treeTableView2.getColumns().add(columnGroup2);
		
			// Управление шириной столбцов
		columnId1.setMinWidth(60);		columnName1.setMinWidth(70);  columnEmail1.setMinWidth(60); 
		columnGroup.setMinWidth(80);
		columnId1.setPrefWidth(120);
		columnId1.setMaxWidth(150);
		columnId1.setResizable(true); // при true юзер может менять ширину столбца, взявшись мышью за границу столбца в строке заголовка 
		columnName1.setResizable(true);
		treeTableView2.resizeColumn(columnId1, 5); 		// Уменьшает ширину указанной строки на 5 пкс
			
			// Управление высотой столбцов
		treeTableView2.setFixedCellSize(20);   // Если поставить 0 или отрицательное число, то фиксированная высота не используется
			
			// Управление размерами таблицы
		treeTableView2.setMinWidth(400);
		
		/* Управление политикой изменения размеров столбцов осуществляется через класс TableView<S> и его 
		метод void setColumnResizePolicy(CallBack<TableView.ResizeFeatures, Boolean>. Здесь можно самостоятельно реализовать интерфейс
		CallBack или воспользоваться статическими константами 
		 - CONSTRAINED_RESIZE_POLICY - при изменении ширины столбца, другие столбцы расширяются, чтобы занять освобод.место
		 - UNCONSTRAINED_RESIZE_POLICY - при изменении ширины столбца другие столбцы смещаются влево или вправо на это растояние
			 */
		treeTableView2.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
		
			// Изменение видимости столбца
		columnId1.setVisible(true);		// При false столбце не будет отображаться
			/* Чтобы дать возможность юзеры скрывать столбцы, нужно присвоить значение true для свойства 
		tableMenuButtonVisible. В этом случае в заголовке появится кнопка, при нажатии которой будет выведен список столбцов,
		для которых сброс флажка означает скрытие столбца 	 */
		treeTableView2.setTableMenuButtonVisible(true);
		System.out.println("Список видимых столбцов " + treeTableView2.getVisibleLeafColumns());
		System.out.println("Cссылка на столбец в позиции с идексом 3" + treeTableView2.getVisibleLeafColumn(5));
		System.out.println("Индекс указанного столбца " + treeTableView2.getVisibleLeafIndex(columnEmail1));
		
			/* Прокрутка элементов 
		чтобы элемент с указанным индексом оказался в зоне видимости позволяет метод scrollTo()  */
				// Прокрутка к последнему видимому элементу
		treeTableView2.scrollTo(treeTableView2.getExpandedItemCount() - 1);
				// Прокрутка к указанному элементу при условии, что он отображается 
		int index = treeTableView2.getRow(rootItem2);
		if (index !=-1) treeTableView2.scrollTo(index);
			// Обработчик прокрутки
		treeTableView2.setOnScrollTo(event -> {
			System.out.println("Scroll to " + event.getScrollTarget());
		});
		
			/* Управление выбором элементов
		поддерживают, как выбор одного, так и нескольких элементов 	 */
		treeTableView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		Button setSelected = new Button("Set selected el");
		setSelected.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<Integer> arr = treeTableView2.getSelectionModel().getSelectedIndices();
				System.out.println("Индексы выделенных элементов " + arr);
				ObservableList<TreeItem<UserGroup>> arr2 = treeTableView2.getSelectionModel().getSelectedItems();
				System.out.println("Выделенные элементы " + arr2);
				System.out.println(treeTableView2.getSelectionModel().getSelectedIndices());
				System.out.println(treeTableView2.getSelectionModel().getSelectedItems());
				Alert alert = new Alert(AlertType.INFORMATION, treeTableView2.getSelectionModel().getSelectedIndices() + "\n" +
				treeTableView2.getSelectionModel().getSelectedItems());
				alert.showAndWait();
			}
		});
		
			// Управление выбором отдельной ячейки
		treeTableView2.getSelectionModel().setCellSelectionEnabled(true);		// Разрешает выделение отдельной ячейки
//		treeTableView2.getSelectionModel().select(2);				// Выбор 2-ой строки
		treeTableView2.getSelectionModel().select(2, columnId1);	// Выбор ячейки во 2-ой строке и в столбцу columnId
		treeTableView2.getSelectionModel().selectAboveCell();		// Выбор ячейки выше 
		treeTableView2.getSelectionModel().selectBelowCell();		// Выбор ячейки ниже
		treeTableView2.getSelectionModel().selectLeftCell();		// Выбор ячейки слева
		treeTableView2.getSelectionModel().selectRightCell();		// Выбор ячейки справа 
		treeTableView2.getSelectionModel().clearSelection();		// Сбрасывает выбор
		treeTableView2.getSelectionModel().selectRange(3, columnId1, 5, columnName1);		// Выбор диапазон ячеек
			
			// Кнопка для отражения выбранных строк
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
						+ " Заголовок столбца - " + elem.getTableColumn().getText() + "  Значение в ячейке -  "
						+ elem.getTableColumn().getCellObservableValue(elem.getRow()).getValue() +  "  "
						+ elem.getTableColumn().getCellData(elem.getRow()) + "\n";
						sb = sb.append(msg);
				}
				Alert alert = new Alert(AlertType.INFORMATION, sb.toString());
				alert.setWidth(200.0);
				alert.showAndWait();
			}
		});
		
			/* Управление фокусом ввода
		Свойство focusModel из класса TreeView<T> содержит ссылку на объект, с помощью которого можно управлять
		фокусом ввода.
	    Ниже пример получения индекса строки списка, находящегося в фокусе ввода, а также значения*/
		FocusModel<TreeItem<UserGroup>> focusModel = treeTableView2.getFocusModel();
		System.out.println("Index - " + focusModel.getFocusedIndex());
		System.out.println("Item" + focusModel.getFocusedItem());
			// Отслеживание изменения индекса строки
		treeTableView2.getFocusModel().focusedIndexProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("Index  " + newValue);
		});
		
			/* Изменение свойств содержимого ячеек столбца
		позволяет сделать свойство cellFactory из класса TreeTableColumn<S,T>
		Наследование: Object - Node - Parent - Region - control - Labelled - Cell<T> - IndexedCell<T> - TableCell<S,T> 
		Можно сделать выравнивание, изменить фон ячеек, шрифт, отобразить какой-либо узел рядом с текстом (или вместо текста),
		разрешить перенос текста на новую строку (setWrapText(true)) и другие методы, унаследованные от Labelled			*/
			// Выранивание значение ячеек по центру столбца и скрытие -1 в заголовке 
		
		
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
		
			/* Изменение свойств содержимого ячеек строки
		позволяет сделать свойство rowFactory из класса TreeTableView<S,T>
		Наследование: Object - Node - Parent - Region - control - Labelled - Cell<T> - IndexedCell<T> - TreeTableRow<S,T> 
		Можно сделать выравнивание, изменить фон ячеек, шрифт, отобразить какой-либо узел рядом с текстом (или вместо текста),
		разрешить перенос текста на новую строку (setWrapText(true)) и другие методы, унаследованные от Labelled			*/
			// Выделение строки с названивем группы серым цветом
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
		
			/* Сортировка элементов
		Таблицы по умолчанию поддерживают сортировку элементов внутри столбца. Для этого достаточно щелкнуть левой клавишей
		мыши на заголовке столбца - отразится черный треугольник, показывающий направление сортировки. Чтобы изменить
		направление сортировки, нужно щелкнуть левой кнопкой мыши на заголовке еще раз.
		Можно выполнить сортировку сразу по нескольким столбцам, удерживая Shift при щелчке мышью */
			// Изменение треугольника для сортировки
//		columnEmail1.setSortNode();
			// Запрет сортировки
		treeTableView2.setSortPolicy(table -> false);
			/* SortMode задает режим сортировки. В параметре valuе указывают константы 
		 - ALL_DESCENDANTS - сортировка всех элементов (значение по умолчанию)
		 - ONLY_FIRST_LEVEL - сортировка только элементов первого уровня вложенности  	 */
		treeTableView2.setSortMode(TreeSortMode.ALL_DESCENDANTS);
		
			// Назначение обработчика на сортировку
		treeTableView2.setOnSort(new EventHandler<SortEvent<TreeTableView<UserGroup>>>() {
			@Override
			public void handle(SortEvent<TreeTableView<UserGroup>> event) {
				System.out.println("Произошла сортировка");
			}
		});
			// Добавление кнопки на сортировку по возрастанию
		Button btnSort = new Button("Sort email");
		btnSort.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				columnEmail1.setSortType(TreeTableColumn.SortType.ASCENDING);			// По возрастанию
				treeTableView2.getSortOrder().clear();
				treeTableView2.getSortOrder().add(columnEmail1);
					/* При добавлении более одного столбца, сортировка происходит сразу по нескольким столбцам
				В начале сортировка происходит по первому столбцу, а в случае равенства значений производится сортировка 
				по следующему столбцу 					 */
				treeTableView2.getSortOrder().add(columnName1);
				treeTableView2.sort();
			}
		});
			// Задает собственный comparator столбца при сортировке
		columnName1.setComparator(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) return 1;
				else if (o1.length() == o2.length()) return 0;
				else return -1;
			}
		});
		
			/* РЕДАКТИРОВАНИЕ ЭЛЕМЕНТОВ В ТАБЛИЦЕ
		Сначала нужно разрешить редактирование с помощью метода setEditable(true);
		Затем нужно задать значение свойству cellFactory - можно реализовать свой собственный способ редактирования или
		воспользоваться готовыми классами из пакета scene.control.cell.  Например, классом TextFieldTable<S,T>, который в режиме
		редактирования отображает внутри ячейки текстовое поле 			 */
		treeTableView2.setEditable(true);
			// Формат метода forTableColumn() ниже подходит только для String
		columnName1.setCellFactory(TextFieldTreeTableCell.<UserGroup>forTreeTableColumn());
		columnEmail1.setCellFactory(TextFieldTreeTableCell.<UserGroup>forTreeTableColumn());
		
			// Формат метода forTableColumn() ниже позволяет указать способ преобразования значения в строку и наоборот
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
			/* Обработчик изменения таблицы с помощью метода addEventHandler и методов класса TableColumn ниже
		editAnyEvent() - любое событие редактирования
		editStartEvent() - событие начала редактирования
		editCommitEvent() - событие успешного редактирования (юзер нажал Enter после ввода)
		editCancelEvent() - событие отмены редактирования 			
		   Метод addEventHandler не переопределяет обработчик ячейки по умолчанию setCellFactory(TextFieldTableCell.<User>forTableColumn())		 */
		
		columnId1.addEventHandler(TreeTableColumn.<UserGroup, Number>editCommitEvent(), event -> {
			/* if (event.getNewValue() == null) tableview1.refresh();		НЕ работает, т.к. не переопределяет обработчик по умолчанию
			else event.getRowValue().setId((Integer)event.getNewValue());  */
			System.out.println(event.getNewValue());					// Возвращает новое значение
			System.out.println(event.getOldValue());					// Возвращает старое значение
			System.out.println(event.getRowValue());					// Возвращает ссылку на объект User, значение которого в этой ячейке
			System.out.println(event.getTreeTableView());					// Возвращает ссылку на таблицу
			System.out.println(event.getTableColumn());					// Возвращает ссылку на объект столбца
			System.out.println(event.getTreeTablePosition());				// Возвращает ссылку на объекты позиции 
			System.out.println(event.getTreeTablePosition().getRow());
			System.out.println(event.getTreeTablePosition().getColumn());
			System.out.println(event.getTreeTableView().getEditingCell());
		});
			/* Метод setOnEditCommit в отличии от addEventHandler() переопределяет обработчик ячейки по умолчанию setCellFactory()
		Поэтому кодом ниже мы можем использовать метод refresh(), который при введении в поле id строки и возврате null от 
		setCellFactory() метод будет refresh() обновлять таблицу к ее прежним значения 		*/
		columnId1.setOnEditCommit(event -> {
			if (event.getNewValue() == null) treeTableView2.refresh();
			else event.getRowValue().getValue().setId((Integer)event.getNewValue());
		});
		
			/* Изменение порядка столбцов
		По умолчанию юзер может изменить положение столбца, взявшись мышью за заголовок столбца и перетащив его в другое место.
		Чтобы запретить перетаскивание нужно присвоит false свойству reorderable				 */
		columnId1.setReorderable(false);
		
			// Информация по наличию детей и родителей
		System.out.println("group1 является Leaf (не имеет детей) " + group1.isLeaf());
		System.out.println("Родители для group1 " + group1.getParent());
		
			// Перемещение по дереву
		System.out.println("Следующий элемент на том же уровне " + group1.nextSibling());
		System.out.println("Следующий элемент на том же уровне " + group1.nextSibling());
		System.out.println("Предыдущий элемент на том же уровне " + group1.previousSibling());
		
			// Определeние позиции узла внутри дерева
		System.out.println("Номер строки в списке для узла point 1.1 - " + treeTableView2.getRow(group1));
			// Если узел скрыт, то getRow() возвращает -1
		System.out.println("Уровень вложенности узла point 1.1 - " + treeTableView2.getTreeItemLevel(group1));
		
			// Возвращает ссылку на элемент, находящийся в списке на указанной позиции списка
		System.out.println("Элемент на 2-ой позиции (строки) " + treeTableView2.getTreeItem(2));
		
			// Количество видимых элементов дерева
		System.out.println("Количество видимых элементов дерева - " + treeTableView2.getExpandedItemCount());
		
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
