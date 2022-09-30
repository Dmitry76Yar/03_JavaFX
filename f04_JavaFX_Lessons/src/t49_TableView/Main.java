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
	
		@Override 
	public void start(Stage primaryStage) {	
			/* Класс TableView<T> используется для отображения в табличной форме
			   Класс TreeView<T> и TreeTableView<S> используется для отображения данных в форме иерархии 
		Наследование: Object - Node - Parent - Region - Control - TableView<S> 	    */
			
		ObservableList<User> list = FXCollections.<User>observableArrayList();
		for (int i=1; i<20; i++) list.add(new User(100+i, "user" + i, "email" + i));
			
				/* Конструктор
		- TableView()	 
		- TableView(ObservableList<S> items)  */
		TableView<User> tableview1 = new TableView<User>(); 	
		TableView<User> tableview2 = new TableView<User>(list);
		
			// Добавление в TableView
		tableview1.setItems(list);
		
			/* СОЗДАНИЕ СТОЛБЦОВ
		Просто добавить список в таблицу недостаточно, нужно описать столбцы таблицы и назначить правила отображения 
		значений в ячейках столбца. Описание столбцов с помощью класса TableColumn<S,T>
		Наследование: Object - TableColumnBase<S,T> - TableColumn<S,T>	*/
			/* Конструктор
		- TableColumn()	 
		- TableColumn(String text)   - text задает название столбца, котоое будет в заголовке 
			Ниже создание столбца и связывание его с полем name класса User */
		TableColumn<User, String> columnName2 = new TableColumn<User, String>();
		TableColumn<User, String> columnName1 = new TableColumn<User, String>("User name");
		TableColumn<User, String> columnEmail1 = new TableColumn<User, String>("User email");
			// Внесение название столбца
		columnName1.setText("User name");
			// Внесение картинки перед названием столбца в таблице
		columnName1.setGraphic(new ImageView(new Image("/img/icons.png")));
		
			/* Задать правило отображения значенйи в ячейках столбца позволяет свойство
		cellValueFactory из класса  TableColumn<S,T> */
			/* Первый способ создания объекта для задания правила отображения заклбчается в использовании класса
		 PropertyValueFactory<S,T>. Параметр property задает название JavaFX-свойства в виде строки. Внутри класса
		 должен быть метод с названием <property>Property(), который возвращает ссылку на JavaFX-свойство - например,
		 nameProperty() для свойства name 		 */
		columnName1.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		
			/* Второй способ заключается в реализации интерфейса CallBack<P,R>, внутри метода call которого нам следует вернуть
		 ссылку на JavaFX-свойство, значение которого должно отображаться в ячейке. 
		 Так как метод call() возвращает объект ObservableValue<T>, то будет автоматически добавлен обработчик события изменения
		 значения свойства. Поэтому любое изменение значения свойства внутри класса привдеет к изменению значения внутри 
		 ячейчки таблицы		 */
		columnEmail1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<User, String> cellData) {
				return cellData.getValue().emailProperty();
			}
		});
			// Тоже самое в лямбда-выражении 
//		columnEmail1.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		
			/* Задать правило отображения для свойств числовых типов (IntegerProperty, DoubleProperty)
		Эти свойства реализуют интерфейс ObservableValue<Number>, но не ObservableValue<Integer>
		Поэтому внутри обработчика нужно делать привидение типов или при создании столбца указывать Number вместо Integer */
		TableColumn<User, Number> columnId1 = new TableColumn<User, Number>("User ID");
		columnId1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User,Number>, ObservableValue<Number>>() {
			@Override
			public ObservableValue<Number> call(CellDataFeatures<User, Number> cellData) {
				return cellData.getValue().idProperty();
			}
		});
			
			// Добавление столбцов в таблицу
		tableview1.getColumns().add(columnId1);
		tableview1.getColumns().add(columnName1);
		tableview1.getColumns().add(columnEmail1);
		
			// Объединение столбцов в группу
		TableColumn<User, Integer> columnGroup = new TableColumn<>("Группа столбцов");
//		columnGroup.getColumns().add(columnName1);
//		columnGroup.getColumns().add(columnEmail1);
//		tableview2.getColumns().add(columnId1);
//		tableview2.getColumns().add(columnGroup);
		
			// Управление шириной столбцов
		columnId1.setMinWidth(100);		columnName1.setMinWidth(150);  columnEmail1.setMinWidth(150);
		columnId1.setPrefWidth(120);
		columnId1.setMaxWidth(150);
		columnId1.setResizable(true); // при true юзер может менять ширину столбца, взявшись мышью за границу столбца в строке заголовка 
		columnName1.setResizable(true);
		tableview1.resizeColumn(columnId1, 5); 		// Уменьшает ширину указанной строки на 5 пкс
		
			// Управление высотой столбцов
		tableview1.setFixedCellSize(20);   // Если поставить 0 или отрицательное число, то фиксированная высота не используется
			
			// Управление размерами таблицы
		tableview1.setMinWidth(400);
		tableview2.setMinWidth(400);
		
			/* Управление политикой изменения размеров столбцов осуществляется через класс TableView<S> и его 
		метод void setColumnResizePolicy(CallBack<TableView.ResizeFeatures, Boolean>. Здесь можно самостоятельно реализовать интерфейс
		CallBack или воспользоваться статическими константами 
		 - CONSTRAINED_RESIZE_POLICY - при изменении ширины столбца, другие столбцы расширяются, чтобы занять освобод.место
		 - UNCONSTRAINED_RESIZE_POLICY - при изменении ширины столбца другие столбцы смещаются влево или вправо на это растояние
			 */
		tableview1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
			// Изменение видимости столбца
		columnId1.setVisible(true);		// При false столбце не будет отображаться
			/* Чтобы дать возможность юзеры скрывать столбцы, нужно присвоить значение true для свойства 
		tableMenuButtonVisible. В этом случае в заголовке появится кнопка, при нажатии которой будет выведен список столбцов,
		для которых сброс флажка означает скрытие столбца 	 */
		tableview1.setTableMenuButtonVisible(true);
		System.out.println("Список видимых столбцов " + tableview1.getVisibleLeafColumns());
		System.out.println("Cссылка на столбец в позиции с идексом 3" + tableview1.getVisibleLeafColumn(5));
		System.out.println("Индекс указанного столбца " + tableview1.getVisibleLeafIndex(columnEmail1));
		
			
			/* Управление выбором строк и ячеек
		Таблицы поддерживают выбор как одной строки (SelectionMode.SINGLE), так и нескольких строк (SelectionMode.MULTIPLE)
		Существует также режим выбора отдельных ячеек.
		Для выбора нескольких строк или ячеек необходимо удерживать Ctrl или Shift 	 */
		tableview1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			// Кнопка для отражения выбранных строк
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
		
			// Управление выбором отдельной ячейки
		tableview1.getSelectionModel().setCellSelectionEnabled(true);		// Разрешает выделение отдельной ячейки
//		tableview1.getSelectionModel().select(2);				// Выбор 2-ой строки
		tableview1.getSelectionModel().select(2, columnId1);	// Выбор ячейки во 2-ой строке и в столбцу columnId
		tableview1.getSelectionModel().selectAboveCell();		// Выбор ячейки выше 
		tableview1.getSelectionModel().selectBelowCell();		// Выбор ячейки ниже
		tableview1.getSelectionModel().selectLeftCell();		// Выбор ячейки слева
		tableview1.getSelectionModel().selectRightCell();		// Выбор ячейки справа 
		tableview1.getSelectionModel().clearSelection();		// Сбрасывает выбор
		tableview1.getSelectionModel().selectRange(3, columnId1, 5, columnName1);		// Выбор диапазон ячеек
			
			// Кнопка для отражения выбранных строк
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
			
			/* Изменение свойств содержимого ячеек столбца
		позволяет сделать свойство cellFactory из класса Table<S,T>
		Наследование: Object - Node - Parent - Region - control - Labelled - Cell<T> - IndexedCell<T> - TableCell<S,T> 
		Можно сделать выравнивание, изменить фон ячеек, шрифт, отобразить какой-либо узел рядом с текстом (или вместо текста),
		разрешить перенос текста на новую строку (setWrapText(true)) и другие методы, унаследованные от Labelled			*/
			// Выранивание значение ячеек по центру столбца
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
		
			/* Изменение свойств содержимого ячеек строки
		позволяет сделать свойство rowFactory из класса Table<S,T>
		Наследование: Object - Node - Parent - Region - control - Labelled - Cell<T> - IndexedCell<T> - TableRow<S,T> 
		Можно сделать выравнивание, изменить фон ячеек, шрифт, отобразить какой-либо узел рядом с текстом (или вместо текста),
		разрешить перенос текста на новую строку (setWrapText(true)) и другие методы, унаследованные от Labelled			*/
			// Выранивание значение по центру в столбце
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
		
			/* Сортировка элементов
		Таблицы по умолчанию поддерживают сортировку элементов внутри столбца. Для этого достаточно щелкнуть левой клавишей
		мыши на заголовке столбца - отразится черный треугольник, показывающий направление сортировки. Чтобы изменить
		направление сортировки, нужно щелкнуть левой кнопкой мыши на заголовке еще раз.
		Можно выполнить сортировку сразу по нескольким столбцам, удерживая Shift при щелчке мышью */
			// Изменение треугольника для сортировки
//		columnEmail1.setSortNode();
			// Запрет сортировки
		tableview2.setSortPolicy(table -> false);
			// Назначение обработчика на сортировку
		tableview1.setOnSort(new EventHandler<SortEvent<TableView<User>>>() {
			@Override
			public void handle(SortEvent<TableView<User>> event) {
				System.out.println("Произошла сортировка");
			}
		});
			// Написание собственной сортировки
		tableview1.setSortPolicy(new Callback<TableView<User>, Boolean>() {
			@Override
			public Boolean call(TableView<User> param) {
				if (param.getComparator() != null) {
					FXCollections.sort(param.getItems(), param.getComparator());
				}
				return true;
			}
		});
			// Добавление кнопки на сортировку по возрастанию
		Button btnSort = new Button("Sort email");
		btnSort.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				columnEmail1.setSortType(SortType.ASCENDING);			// По возрастанию
				tableview1.getSortOrder().clear();
				tableview1.getSortOrder().add(columnEmail1);
				tableview1.sort();
			}
		});
			// Добавление кнопки на сортировку по длине строки (собственный Comparator)
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
				});			// По возрастанию
				tableview1.getSortOrder().clear();
				tableview1.getSortOrder().add(columnId1);
					/* При добавлении более одного столбца, сортировка происходит сразу по нескольким столбцам
				В начале сортировка происходит по первому столбцу, а в случае равенства значений производится сортировка 
				по следующему столбцу 					 */
				tableview1.getSortOrder().add(columnName1);
				tableview1.sort();
			}
		});
		
			/* РЕДАКТИРОВАНИЕ ЭЛЕМЕНТОВ В ТАБЛИЦЕ
		Сначала нужно разрешить редактирование с помощью метода setEditable(true);
		Затем нужно задать значение свойству cellFactory - можно реализовать свой собственный способ редактирования или
		воспользоваться готовыми классами из пакета scene.control.cell.  Например, классом TextFieldTable<S,T>, который в режиме
		редактирования отображает внутри ячейки текстовое поле 			 */
		tableview1.setEditable(true);
			// Формат метода forTableColumn() ниже подходит только для String
		columnName1.setCellFactory(TextFieldTableCell.<User>forTableColumn());
		columnEmail1.setCellFactory(TextFieldTableCell.<User>forTableColumn());
			// Формат метода forTableColumn() ниже позволяет указать способ преобразования значения в строку и наоборот
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
			/* Обработчик изменения таблицы с помощью метода addEventHandler и методов класса TableColumn ниже
		editAnyEvent() - любое событие редактирования
		editStartEvent() - событие начала редактирования
		editCommitEvent() - событие успешного редактирования (юзер нажал Enter после ввода)
		editCancelEvent() - событие отмены редактирования 			
		   Метод addEventHandler не переопределяет обработчик ячейки по умолчанию setCellFactory(TextFieldTableCell.<User>forTableColumn())		 */
		columnId1.addEventHandler(TableColumn.<User, Number>editCommitEvent(), event -> {
			/* if (event.getNewValue() == null) tableview1.refresh();		НЕ работает, т.к. не переопределяет обработчик по умолчанию
			else event.getRowValue().setId((Integer)event.getNewValue());  */
			System.out.println(event.getNewValue());					// Возвращает новое значение
			System.out.println(event.getOldValue());					// Возвращает старое значение
			System.out.println(event.getRowValue());					// Возвращает ссылку на объект User, значение которого в этой ячейке
			System.out.println(event.getTableView());					// Возвращает ссылку на таблицу
			System.out.println(event.getTableColumn());					// Возвращает ссылку на объект столбца
			System.out.println(event.getTablePosition());				// Возвращает ссылку на объекты позиции 
			System.out.println(event.getTablePosition().getRow());
			System.out.println(event.getTablePosition().getColumn());
			System.out.println(event.getTableView().getEditingCell());
		});
			/* Метод setOnEditCommit в отличии от addEventHandler() переопределяет обработчик ячейки по умолчанию setCellFactory()
		Поэтому кодом ниже мы можем использовать метод refresh(), который при введении в поле id строки и возврате null от 
		setCellFactory() метод будет refresh() обновлять таблицу к ее прежним значения 		*/
		columnId1.setOnEditCommit(event -> {
			if (event.getNewValue() == null) tableview1.refresh();
			else event.getRowValue().setId((Integer)event.getNewValue());
		});
		
				/* Изменение порядка столбцов
		По умолчанию юзер может изменить положение столбца, взявшись мышью за заголовок столбца и перетащив его в другое место.
		Чтобы запретить перетаскивание нужно присвоит false свойству reorderable				 */
		columnId1.setReorderable(false);
		
			// Устанавливает узел (например, label), который показывается когда список пустой
		tableview1.setPlaceholder(new Label("Empty list"));
				
			// Задает фиксированную высоту (для вертик.ориентации) и ширину (для гориз.ориентации) ячеек списка
		tableview1.setFixedCellSize(20);
				
			// Выделение элемента из списка по умолчанию (сразу после показа окна)
		tableview1.getSelectionModel().selectLast();
		
			// Задание фокуса на элементе из списка по умолчанию (сразу после показа окна)
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
