package t00_Distributive_Creation;

import java.awt.Desktop;
import java.net.URI;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.FocusModel;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Slider;
import javafx.scene.control.SortEvent;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
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
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.scene.web.HTMLEditor;

/* VM arguments ����������� --add-modules=javafx.controls,javafx.fxml,javafx.web
 * Run configurations - (x)-Arguments - VM arguments */

/* 		������� jlink.exe - �������� �������������, � ������� ������ JRE �� ����� ��������, ������������ ��� �������
 * 
 	������ ����� ����� ���������� ����������� ���������� �� �������. ��� ����� ������������� ������� jdeps.exe, �������� � ������ 
 	JDK, ����������� � C:\Program Files\Java\jdk-14.0.2\bin. 
 	��������� ��������� ������, ��������� � ����������, ��� ����������� ���������� (C:\Users\dkuli\Documents\My_works\f04_JavaFX_Lessons\src\t00_Distributive_Creation)
 	� �������� jdeps --module-path C:\javafx-sdk-14.0.2.1\lib -s Main.jar
 	
 * 
 * 
 * 
 * 
 */
public class Main extends Application {
	Timer timer;
	
	class MyTimerTask extends TimerTask {
		private Label lbl; 
		public MyTimerTask (Label lbl) {
			this.lbl = lbl;
		}
		@Override
		public void run() {
			Platform.runLater(() -> {
				lbl.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
			});
		}
	}
	
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
	public void start(Stage primaryStage) {	
		
//------------------------------------------------------------------------------------------------------------
		MenuBar menuBar = new MenuBar();
		menuBar.setPrefWidth(400); menuBar.setMinWidth(400);
		menuBar.setPrefHeight(25); menuBar.setMinHeight(25);
		menuBar.setStyle("-fx-label-padding: 5.0px;");
		Menu openME = new Menu("MenuItem");
		openME.getItems().add(new MenuItem("Leve1_MenuItem1"));
		openME.getItems().add(new MenuItem("Leve1_MenuItem2"));
		Menu Zoom = new Menu("Leve1_Menu");
		Zoom.getItems().add(new MenuItem("Leve2_MenuItem1"));
		Zoom.getItems().add(new MenuItem("Leve2_MenuItem2"));
		openME.getItems().add(Zoom);
		menuBar.getMenus().add(openME);
				
		CheckMenuItem checkMenuItem = new CheckMenuItem("CheckMenuItem1");
		CheckMenuItem checkMenuItem2 = new CheckMenuItem("CheckMenuItem2");
		CheckMenuItem checkMenuItem3 = new CheckMenuItem("CheckMenuItem3");
		CheckMenuItem checkMenuItem4 = new CheckMenuItem("CheckMenuItem4");
		Menu checkMenu = new Menu("CheckMenu");
		Menu checkMenu2 = new Menu("CheckMenu2");
		checkMenu.getItems().addAll(checkMenuItem, checkMenuItem2, checkMenuItem3);
		checkMenu2.getItems().addAll(checkMenuItem4);
		checkMenu.getItems().add(checkMenu2);
		menuBar.getMenus().add(checkMenu);
				
		RadioMenuItem radioMenuItem1 = new RadioMenuItem("RadioMenuItem 1");
		RadioMenuItem radioMenuItem2 = new RadioMenuItem("RadioMenuItem2");
		RadioMenuItem radioMenuItem3 = new RadioMenuItem("RadioMenuItem3");
		RadioMenuItem radioMenuItem4 = new RadioMenuItem("RadioMenuItem4");
		RadioMenuItem radioMenuItem5 = new RadioMenuItem("RadioMenuItem5");
		Menu radioMenu3 = new Menu("RadioMenu");
		Menu radioMenu4 = new Menu("RadioMenu2");
		radioMenu3.getItems().addAll(radioMenuItem1, radioMenuItem2, radioMenuItem3);
		radioMenu4.getItems().addAll(radioMenuItem4, radioMenuItem5);
		radioMenu3.getItems().add(radioMenu4);
				
		ToggleGroup group99 = new ToggleGroup();
		group99.getToggles().addAll(radioMenuItem1, radioMenuItem2, radioMenuItem3);
		ToggleGroup group98 = new ToggleGroup();
		group98.getToggles().addAll(radioMenuItem4, radioMenuItem5);
		menuBar.getMenus().add(radioMenu3);
				
		Label label99 = new Label("Slider"); 
		Slider slider99 = new Slider(0, 100, 50);
		Button btn99 = new Button("BUTTON");
		VBox vbox99 = new VBox();
		vbox99.getChildren().addAll(label99, btn99, slider99);
		CustomMenuItem сustomMenuItem1 = new CustomMenuItem();
		сustomMenuItem1.setContent(vbox99);		
		сustomMenuItem1.setHideOnClick(false);
		Menu customMenu = new Menu("CustomMenu");
		customMenu.getItems().add(сustomMenuItem1);
		menuBar.getMenus().add(customMenu);
		
		HBox hbox99 = new HBox();
		hbox99.setMinWidth(200); hbox99.setPadding(new Insets(10));	hbox99.setSpacing(20);
		hbox99.getChildren().addAll(menuBar);
				
//----------------------------------------------------------------------------------------------------------------------		
		
		Label lbl2 = new Label("LABEL1");
		ImageView imf = new ImageView("/img/icons.png");
		Label lbl3 = new Label("LABEL2", imf);
		lbl2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 16.0));
		lbl3.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 10.0));
		lbl2.setTextAlignment(TextAlignment.JUSTIFY);			lbl3.setTextAlignment(TextAlignment.JUSTIFY);		
		lbl3.setContentDisplay(ContentDisplay.TOP);
		lbl2.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));

//------------------------------------------------------------------------------------------------------------------------
		Button btn2 = new Button("BUTTON1");
		Button btn3 = new Button("BUTTON2", imf);
		btn2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 16.0));
		btn3.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 10.0));
		btn2.setTextAlignment(TextAlignment.JUSTIFY);			btn3.setTextAlignment(TextAlignment.JUSTIFY);		
		btn3.setContentDisplay(ContentDisplay.TOP);
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("������ ������1");
				btn2.setText("������");
			}
		});
		btn3.setOnAction(event -> {
			System.out.println("������ ������2");
			btn3.setText("������");
		});
		
//----------------------------------------------------------------------------------------------------------------------
		MenuItem redMenuItem = new MenuItem("RED");
		redMenuItem.setOnAction(event -> {
			System.out.println("������ ������� ����");
		});
		MenuItem blueMenuItem = new MenuItem("BLUE");
		blueMenuItem.setOnAction(event -> {
			System.out.println("������ ����� ����");
		});
		MenuButton menuButton = new MenuButton("MenuButton");
		menuButton.getItems().addAll(redMenuItem, blueMenuItem);
		menuButton.addEventHandler(Menu.ON_SHOWN, event -> {
			System.out.println("ON_ShOWN");
		});
		
//-------------------------------------------------------------------------------------------------------------------------		
		MenuItem redMenuItem1 = new MenuItem("RED");
		redMenuItem1.setOnAction(event -> {
			System.out.println("������ ������� ����");
		});
		MenuItem blueMenuItem1 = new MenuItem("BLUE");
		blueMenuItem1.setOnAction(event -> {
			System.out.println("������ ����� ����");
		});
		SplitMenuButton splitMenuButton1 = new SplitMenuButton();
		splitMenuButton1.setText("SplitMenuButton");
		splitMenuButton1.getItems().addAll(redMenuItem1, blueMenuItem1);
		
		VBox vbox98 = new VBox();
		vbox98.getChildren().addAll(menuButton, splitMenuButton1);
		
//------------------------------------------------------------------------------------------------------------------------
		Hyperlink hyperlink2 = new Hyperlink("������1");			   
		Hyperlink hyperlink3 = new Hyperlink("������2", imf);
		hyperlink2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 16.0));
		hyperlink3.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 10.0));
		hyperlink2.setTextAlignment(TextAlignment.JUSTIFY);			hyperlink3.setTextAlignment(TextAlignment.JUSTIFY);		
		hyperlink3.setContentDisplay(ContentDisplay.TOP);
		
		hyperlink2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("������� �� ����������� ������");
					// ����� ��������� Web-�������, ������������ � ������� �� ���������, � �������� ��� ����� ������
				if (Desktop.isDesktopSupported()) {
					try {	Desktop.getDesktop().browse(URI.create("https://yandex.ru/"));}
					catch (Exception e) {System.out.println("�� ������� ��������� �������");}
				}
			}
		});
			// � ������� ������-���������
		hyperlink3.setOnAction(event -> {
			System.out.println("������� �� ����������� ������");
				// ����� ��������� Web-�������, ������������ � ������� �� ���������, � �������� ��� ����� ������
			if (Desktop.isDesktopSupported()) {
				try {	Desktop.getDesktop().browse(URI.create("https://yandex.ru/"));}
				catch (Exception e) {System.out.println("�� ������� ��������� �������");}
			}
		});
		
//------------------------------------------------------------------------------------------------------------------------
		ToggleButton toggleButton1 = new ToggleButton(); 	toggleButton1.setText("ToggleButton1");	toggleButton1.setMinWidth(120);
		ToggleButton toggleButton2 = new ToggleButton(); 	toggleButton2.setText("ToggleButton2");	toggleButton2.setMinWidth(120);
		toggleButton1.setTextAlignment(TextAlignment.JUSTIFY);			toggleButton2.setTextAlignment(TextAlignment.JUSTIFY);
		toggleButton1.setStyle("-fx-label-padding: 5.0px;");			toggleButton2.setStyle("-fx-label-padding: 5.0px;");
		toggleButton1.setGraphic(new ImageView("/img/icons.png"));
		toggleButton1.setContentDisplay(ContentDisplay.TOP);			
		toggleButton1.setAlignment(Pos.CENTER);		
		toggleButton1.setOnAction(event -> {
			if (toggleButton1.isSelected())		toggleButton1.setText("TGB1 ���");
			else toggleButton1.setText("TGB1 ����");
		});
		toggleButton2.setOnAction(event -> {
			if (toggleButton2.isSelected())		toggleButton2.setText("TGB2 ���");
			else toggleButton2.setText("TGB2 ����");
		});

//------------------------------------------------------------------------------------------------------------------------
		ToggleGroup toggleGroup = new ToggleGroup();
		toggleGroup.getToggles().addAll(toggleButton1, toggleButton2);
		RadioButton radioButton1 = new RadioButton("RadioBtn1");
		RadioButton radioButton2 = new RadioButton("RadioBtn2");
		RadioButton radioButton3 = new RadioButton("RadioBtn3");
		Button btnOK = new Button("OK");
		btnOK.setOnAction(event -> {
			String msg = "";
		if (radioButton1.isSelected()) msg = "������� radioButton1";
		if (radioButton2.isSelected()) msg = "������� radioButton2";
		if (radioButton3.isSelected()) msg = "������� radioButton3";
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
				a.showAndWait();
		});
		radioButton1.setSelected(true);
		VBox vb97 = new VBox();		vb97.setAlignment(Pos.CENTER);
		vb97.getChildren().setAll(radioButton1, radioButton2, radioButton3);
		
//------------------------------------------------------------------------------------------------------------------------		
		ToggleGroup toggleGroup1 = new ToggleGroup();
		toggleGroup1.getToggles().addAll(radioButton1, radioButton2, radioButton3);
		
		VBox vb = new VBox();		vb.setAlignment(Pos.CENTER);
		Label lbl01= new Label("");	lbl01.setStyle("-fx-font-size: 24 pt");
		timer = new Timer(true);
		timer.schedule(new MyTimerTask(lbl01), 0, 1000);
		vb.getChildren().addAll(lbl01);
		
//------------------------------------------------------------------------------------------------------------------------
		Tooltip tooltip = new Tooltip();
		tooltip.setAutoHide(true);
		tooltip.setHideOnEscape(true);
		tooltip.setWidth(150);
		tooltip.setHeight(150);
		tooltip.setAutoFix(true);		
		tooltip.setConsumeAutoHidingEvents(true);
		tooltip.setText("����� ���������");
		tooltip.setFont(Font.font("Calibri", 15));
		tooltip.setGraphic(new Rectangle(10,  10,  Color.AQUA));
		tooltip.setOpacity(0.7);
		tooltip.setWrapText(false);
		tooltip.setGraphicTextGap(10);
		tooltip.setTextOverrun(OverrunStyle.ELLIPSIS);
		tooltip.setContentDisplay(ContentDisplay.LEFT);
		tooltip.setTextAlignment(TextAlignment.CENTER);
		tooltip.setStyle("-fx-background-color: green;");
		tooltip.setShowDelay(Duration.millis(1000));
		tooltip.setShowDuration(Duration.millis(6000));
		tooltip.setHideDelay(Duration.millis(500));

		Button btn = new Button("���������");
		btn.setTooltip(tooltip);
		Tooltip.install(btn, tooltip);
		
//----------------------------------------------------------------------------------------------------------------------------
		MenuItem menuItem1 = new MenuItem("����� ���� 1");
		MenuItem menuItem2 = new MenuItem("����� ���� 2");
		MenuItem menuItem3 = new MenuItem("����� ���� 3");
		
		ContextMenu contextMenu = new ContextMenu(menuItem1, menuItem2, menuItem3);
		
		Button btn50 = new Button("���� ��� ������� ������ �������");
		btn50.setMaxWidth(70);
		btn50.setMinHeight(100);
		btn50.setWrapText(true);
		btn50.setTextAlignment(TextAlignment.CENTER);
		btn50.setContextMenu(contextMenu);
		
		HBox hbox = new HBox();		hbox.setPadding(new Insets(10));	hbox.setSpacing(20);
		hbox.getChildren().addAll(lbl2, btn3, vbox98, toggleButton1, toggleButton2, 
				vb97, btnOK, vb, btn, btn50);
		
//------------------------------------------------------------------------------------------------------------------------
		CheckBox CheckBox1 = new CheckBox("CheckBox1");
		CheckBox CheckBox2 = new CheckBox("CheckBox2");
		CheckBox CheckBox3 = new CheckBox("CheckBox3");
		CheckBox1.setSelected(true);							
		Button btnOK2 = new Button("OK");
		btnOK2.setMinWidth(75);
		btnOK2.setOnAction(event -> {
			String msg = "";
			if (CheckBox1.isSelected()) 	msg += "CheckBox1\n";
			if (CheckBox2.isSelected()) 	msg += "CheckBox2\n";
			if (CheckBox3.isSelected()) 	msg += "CheckBox3\n";
			if (msg.equals("")) 	msg = "You didn't order any toppings.";
			else msg = "You ordered these toppings:\n" + msg;
			Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
			a.setTitle("Your Order");
			a.showAndWait();
			CheckBox1.setSelected(false);
			CheckBox2.setSelected(false);
			CheckBox3.setSelected(false);
			});
		
		Label lbl = new Label("Text for ChoiseBox");
		ObservableList<String> obvList =  
				FXCollections.<String>observableArrayList("ChoiseBox", "Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		ChoiceBox choice = new ChoiceBox(obvList);
		choice.setValue("ChoiseBox");
		SingleSelectionModel<String> sel = choice.getSelectionModel();
		sel.selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue == null) return;
				System.out.println("��������� ������ choice � ������������� � SingleSelectionModel �� �������� � " + 
						oldValue + " �� " + newValue);
				lbl.setText(newValue);
				}
			});
//---------------------------------------------------------------------------------------------------------------------------------/
		Label lbl4 = new Label("Text ");
		ObservableList<String> obvList2 =  
				FXCollections.<String>observableArrayList("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		ComboBox<String> choice2 = new ComboBox<String>(obvList2);
		choice2.setVisibleRowCount(4);
		choice2.setPromptText("COMBOBOX ������/������");
		choice2.setEditable(true);
		Callback<ListView<Color>,ListCell<Color>> cellFactory = new Callback<ListView<Color>, ListCell<Color>>() {
			@Override
			public ListCell<Color> call(ListView<Color> listView) {
				return new ListCell<Color>() {
					private final Rectangle rect = new Rectangle(50.0, 10.0);
					@Override
					protected void updateItem (Color color, boolean empty) {
						super.updateItem(color, empty);
						if (color == null || empty) {
							setGraphic(null);
							setText("");
						}
						else {
							rect.setFill(color);
							setGraphic(rect);
							setText(color.toString());
						}
					}
				};
			}
		};
		ComboBox<Color> comboColor = new ComboBox<Color>();
		comboColor.setPromptText("Color ComboBox");
		comboColor.getItems().addAll(Color.RED, Color.GREEN, Color.BLUE);
		comboColor.setButtonCell(cellFactory.call(null));
		comboColor.setCellFactory(cellFactory);
		SingleSelectionModel<String> sel2 = choice2.getSelectionModel();
		sel2.selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue == null) return;
				System.out.println("��������� ������ choice � ������������� � SingleSelectionModel �� �������� � " + 
						oldValue + " �� " + newValue);
				lbl4.setText(newValue);
				}
			});
		choice2.setOnShowing(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				lbl4.setText("ComboBox ����� � ������");
				lbl4.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
			}
		});
		choice2.setOnShown(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				lbl4.setText("���� �����");
				lbl4.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
			}
		});
		choice2.setOnHidden(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				lbl4.setText("����� ������");
				lbl4.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
			}
		});
		
//------------------------------------------------------------------------------------------------------------------------		
		ObservableList<Color> obvList3 = FXCollections.<Color>observableArrayList(Color.RED, Color.BLUE, Color.YELLOW);
		ColorPicker colorPicker2 = new ColorPicker();
		colorPicker2.getCustomColors().addAll(Color.RED, Color.BLUE, Color.YELLOW);
		colorPicker2.getStyleClass().add(ColorPicker.STYLE_CLASS_BUTTON);
		colorPicker2.setValue(Color.BLUE);
//------------------------------------------------------------------------------------------------------------------------
		
		DatePicker datePicker2 = new DatePicker();
		datePicker2.setEditable(true);
		datePicker2.setPromptText("DATE PICKER");
		Callback<DatePicker, DateCell> cellFactory2 = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(DatePicker param) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item == null || empty) return;
							// ������ ���������� ���� ����������� ��� ������
						if (item.equals(LocalDate.now().plusDays(1))) setDisable(true);
							// �������� ��������� ���� ������� ������ � ��������� ����������� ���������
						else if (item.equals(LocalDate.now().minusDays(2))) {
							setTooltip(new Tooltip("�����"));
							setStyle("fx-background-color: #008000;");
						}
							// ���� ������ ��� �������� ������ �������
						if ((item.getDayOfWeek() == DayOfWeek.SATURDAY) || (item.getDayOfWeek() == DayOfWeek.SUNDAY))
							setTextFill(Color.RED);
					}
				};
			}
		};
		datePicker2.setDayCellFactory(cellFactory2);
		
		Separator separatorVert5 = new Separator(Orientation.VERTICAL); 	Separator separatorVert6 = new Separator(Orientation.VERTICAL);
		Separator separatorVert7 = new Separator(Orientation.VERTICAL); 	Separator separatorVert8 = new Separator(Orientation.VERTICAL);
		Separator separatorVert9 = new Separator(Orientation.VERTICAL); 	
		
		HBox hbox2 = new HBox();		hbox2.setPadding(new Insets(10));	hbox2.setSpacing(20);
		hbox2.getChildren().addAll(CheckBox2, CheckBox3, btnOK2, separatorVert5, 
				choice, lbl, separatorVert6, choice2, lbl4, comboColor, separatorVert7, colorPicker2, separatorVert8, datePicker2,
				separatorVert9);		
//------------------------------------------------------------------------------------------------------------------------
		ObservableList<String> obvList4 =  
				FXCollections.<String>observableArrayList("Bashful", "Doc", "Dopey","Grumpy", "Happy", "Sleepy","Sneezy");
		ListView<String> choice3 = new ListView<String>(obvList4);
		ListView<String> apollo13 = new ListView<String>(obvList4);
		choice3.setMaxHeight(80); choice3.setMaxWidth(100);
		apollo13.setMaxHeight(80); apollo13.setMaxWidth(100);
		choice3.setFixedCellSize(20);		apollo13.setFixedCellSize(20);
		apollo13.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		choice3.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		Button btn6 = new Button("GET");
		btn6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
					// ��������� ��������� ��������� ��� ListView � SelectionMode.SINGLE 
				int index = choice3.getSelectionModel().getSelectedIndex();
				String chOb = choice3.getSelectionModel().getSelectedItem();
					// ��������� ��������� ��������� ��� ListView � SelectionMode.MULTIPLE
				ObservableList<Integer> obsIndex = apollo13.getSelectionModel().getSelectedIndices();
				ObservableList<String> obsValue = apollo13.getSelectionModel().getSelectedItems();
				Alert alert = new Alert(AlertType.INFORMATION, "������� �������� apollo ����� � ��������� " + 
						obsIndex.toString() + " � �� ��������� " + obsValue.toString() + "\n ������ ������� choice ����� � �������� " + 
						index + " � �� ��������� "  + chOb);
						alert.showAndWait();
					}
		});
		Callback<ListView<Color>,ListCell<Color>> cellFactory3 = new Callback<ListView<Color>, ListCell<Color>>() {
			@Override
			public ListCell<Color> call(ListView<Color> listView) {
				return new ListCell<Color>() {
					private final Rectangle rect = new Rectangle(50.0, 10.0);
					@Override
					protected void updateItem (Color color, boolean empty) {
						super.updateItem(color, empty);
						if (color == null || empty) {
							setGraphic(null);
							setText("");
						}
						else {
							rect.setFill(color);
							setGraphic(rect);
							setText(color.toString());
						}
					}
				};
			}
		};
		ListView<Color> liView3 = new ListView<Color>();
		liView3.setMaxHeight(80); liView3.setMaxWidth(130);
		liView3.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		liView3.getItems().addAll(Color.RED, Color.GREEN, Color.BLUE);
		liView3.setCellFactory(cellFactory3);
		
		choice3.setEditable(true);		
		choice3.setCellFactory(TextFieldListCell.forListView());
		choice3.addEventHandler(ListView.<String>editStartEvent(), event -> {
			System.out.println("���� � �������������� ������ ������");
		});
		choice3.addEventHandler(ListView.<String>editCancelEvent(), event -> {
			System.out.println("������ �������������� ������ ������");
		});
		choice3.addEventHandler(ListView.<String>editCommitEvent(), event -> {
			System.out.println("�������� �������������� ������ ������");
			System.out.println("��� ������� ����� ������ � �������� " + event.getIndex());
			System.out.println("��� ������� ����� ������  " + event.getSource());
			System.out.println("����� �������� ��� ����������� ������  " + event.getNewValue());
				// ���������� �������� � ������
			choice3.getItems().set(event.getIndex(), event.getNewValue());
			System.out.println(choice3.getItems().toString());
		});
		
//-----------------------------------------------------------------------------------------------------------------------------
	TreeItem the_Andy_Griffith, all_in_the_Family, happy_Days, the_Jeffersons, maude;
	TreeItem root = new TreeItem("Spin Offs ");
	root.setExpanded(true);		
	the_Andy_Griffith = makeShow("The Andy Griffith Show", root);
	makeShow("Gomer Pyle, U.S.M.C.", the_Andy_Griffith);
	makeShow("Mayberry R.F.D.", the_Andy_Griffith);
	
	all_in_the_Family = makeShow("All in the Family", root);
	the_Jeffersons = makeShow("The Jeffersons", all_in_the_Family);
	makeShow("Checking In", the_Jeffersons);
	maude = makeShow("Maude", all_in_the_Family);
	makeShow("Good Times", maude);
	makeShow("Gloria", all_in_the_Family);
	makeShow("Archie Bunker's Place", all_in_the_Family);
	happy_Days = makeShow("Happy Days", root);
	makeShow("Mork and Mindy", happy_Days);
	makeShow("Laverne and Shirley", happy_Days);
	makeShow("Joanie Loves Chachi", happy_Days);
	TreeView tree = new TreeView(root);
	tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	tree.setMaxHeight(80); tree.setMaxWidth(130);
	
	Button btn10 = new Button("GET");
	btn10.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			ObservableList<Integer> obsIndex = tree.getSelectionModel().getSelectedIndices();
			ObservableList<Object> obsValue = tree.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.INFORMATION, "������� �������� ����� � ��������� " + 
					obsIndex.toString() + " � �� ��������� " + obsValue.toString());
					alert.showAndWait();
				}
	});
		
//------------------------------------------------------------------------------------------------------------------------		
		ProgressIndicator prIndic1 = new ProgressIndicator();
		ProgressIndicator prIndic2 = new ProgressIndicator(0.5);  // ��������� ������ � ���� ������������� ����� 
		prIndic2.setProgress(0.6);
		prIndic1.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
		prIndic1.setMinHeight(60);   prIndic1.setMaxWidth(60);
		prIndic2.setMinHeight(60);   prIndic2.setMaxWidth(60);
		prIndic1.setStyle("-fx-label-padding: 5.0px;");
		prIndic1.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
		ProgressBar prBar1 = new ProgressBar();	
		ProgressBar prBar2 = new ProgressBar(0.5); 
		prBar2.setProgress(0.6);
		prBar1.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
		prBar1.setMinHeight(60);   prBar1.setMaxWidth(60);
		prBar2.setMinHeight(60);   prBar2.setMaxWidth(60);
		prBar1.setStyle("-fx-label-padding: 5.0px;");
		prBar1.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));

//------------------------------------------------------------------------------------------------------------------------
		Text text2 = new Text("TEXT ");
		text2.setFill(Color.BLACK);
		text2.setTextOrigin(VPos.CENTER);
		text2.setUnderline(true);
		text2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
		text2.setWrappingWidth(100);			// ��� ���� �������� ������� ������� 100 ���
		text2.setTextAlignment(TextAlignment.CENTER);
		
		Text text5 = new Text("     TEXTFLOW �������������� ��������� ������� �� ��������� ������");
		text5.setFill(Color.BLACK);
		text5.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
			
		TextFlow textFlowPane1 = new TextFlow();
		textFlowPane1.setMaxWidth(200);
		textFlowPane1.setPadding(new Insets(10));
		textFlowPane1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		textFlowPane1.setTextAlignment(TextAlignment.CENTER);
		textFlowPane1.setLineSpacing(1.0);
		textFlowPane1.getChildren().addAll(text5);
				
		Separator separatorVert1 = new Separator(Orientation.VERTICAL); 	Separator separatorVert2 = new Separator(Orientation.VERTICAL);
		Separator separatorVert3 = new Separator(Orientation.VERTICAL); 	Separator separatorVert4 = new Separator(Orientation.VERTICAL);
		Separator separatorVert0 = new Separator(Orientation.VERTICAL);
		HBox hbox4 = new HBox(20, separatorVert1, choice3, apollo13, btn6, liView3, separatorVert2, tree, btn10, separatorVert0,
				prIndic2, prBar1, prBar2, separatorVert3, textFlowPane1, separatorVert4 );
		hbox4.setAlignment(Pos.CENTER);	hbox4.setPadding(new Insets(10));
				
		
//--------------------------------------------------------------------------------------------------------------------------		
		
		Slider slider1 = new Slider();	Slider slider2 = new Slider();
		slider1.setMinHeight(60);   slider1.setMinWidth(100);	slider2.setMinHeight(60);   slider2.setMinWidth(100);
		slider1.setStyle("-fx-label-padding: 5.0px;");
		slider1.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		slider2.setShowTickLabels(true);	slider2.setShowTickMarks(true);		slider2.setMajorTickUnit(10);		
		slider2.setMinorTickCount(5);		slider2.setBlockIncrement(5);
		slider1.valueProperty().bindBidirectional(slider2.valueProperty());	
		TextField txtField1 = new TextField();  
		txtField1.textProperty().bindBidirectional(slider1.valueProperty(), new NumberStringConverter());
		Slider slider3 = new Slider();			Slider slider4 = new Slider();
		slider3.setMinHeight(60);   slider3.setMinWidth(100);	slider4.setMinHeight(60);   slider4.setMinWidth(100);
		slider3.valueProperty().bind(slider4.valueProperty());		// ����������
		Slider slider5 = new Slider();			Slider slider6 = new Slider();
		slider5.setMinHeight(60);   slider5.setMinWidth(100);	slider6.setMinHeight(60);   slider6.setMinWidth(100);
		slider5.valueProperty().bind(slider6.valueProperty().subtract(30));		// ���������� � ��������� 30
		
		ScrollBar scrollbar1 = new ScrollBar();
		scrollbar1.setPrefWidth(90); scrollbar1.setMinWidth(90);
		scrollbar1.setMin(0);		scrollbar1.setMax(100);		scrollbar1.setValue(20);
		scrollbar1.setOrientation(Orientation.HORIZONTAL);
		scrollbar1.setBlockIncrement(5.0);		scrollbar1.increment();		scrollbar1.decrement();

//------------------------------------------------------------------------------------------------------------------------
		Spinner<Integer> spinner1 = new Spinner<Integer>();
		spinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 5));
		Spinner<Integer> spinner2 = new Spinner<Integer>(0, 100, 10);
		Spinner<Integer> spinner3 = new Spinner<Integer>(0, 100, 0, 5);
		ObservableList<String> list = FXCollections.<String>observableArrayList("red", "green", "blue");
		Spinner<String> spinner6 = new Spinner<String>(list);
		spinner1.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);
		spinner2.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL);
		spinner3.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL);
		spinner6.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
		spinner1.getValueFactory().setWrapAround(true);
		spinner3.setPromptText("spinner3");
		spinner3.setEditable(true);
		spinner3.getValueFactory().setConverter(new StringConverter<Integer>() {
			@Override
			public Integer fromString(String string) {
				if (string.matches("^[0-9]+$")) {
					try {return Integer.valueOf(string); }
					catch (NumberFormatException e) { return 0; }
				}
				return 0;
			}
			@Override
			public String toString(Integer obj) {
				return (obj == null) ? "0" : obj.toString();
			}
		});
			
		HBox hbox3 = new HBox(20, slider1, slider2, txtField1, slider3, slider4, slider5, slider6, scrollbar1, 
				spinner1, spinner2, spinner3, spinner6);
		hbox3.setAlignment(Pos.CENTER);			hbox3.setPadding(new Insets(10));

//------------------------------------------------------------------------------------------------------------------------		
		TextField textfield1 = new TextField();		
		TextField textfield2 = new TextField();	
		textfield1.setPromptText("TextField for string");
		textfield2.setPromptText("TextField for number.");
		textfield1.setMinWidth(120);	textfield1.setMaxWidth(120);
		textfield2.setMinWidth(120);	textfield2.setMaxWidth(120);
		textfield1.setMinHeight(100);	textfield2.setMinHeight(100);
		TextFormatter<Integer> textForm = new TextFormatter<Integer>(new IntegerStringConverter(), null); 
		textfield2.setTextFormatter(textForm); 
		Button btn4 = new Button("GET");
		btn4.setOnAction(event -> {
			String msg = "������ Text -  ";
			msg = msg + textfield1.getText() + " , Number - ";
			Integer value = (Integer)textfield2.getTextFormatter().getValue();
			msg = msg + value.toString();
			Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
			a.setTitle("���� �����");
			a.showAndWait();
		});
		PasswordField passwordField = new PasswordField();
		passwordField.setMinHeight(100);
		passwordField.setPromptText("������� ������");
		Label label = new Label("_Password");
		label.setMnemonicParsing(true);
		label.setLabelFor(passwordField);
		passwordField.setMinWidth(120);		passwordField.setMaxWidth(120);
		
//------------------------------------------------------------------------------------------------------------------------	
		TextArea textArea1 = new TextArea("   TEXT AREA\n ������ ");
		TextArea textArea2 = new TextArea("   TEXT AREA\n ������");
		textArea2.setWrapText(true);
		textArea1.setMaxHeight(100);		textArea2.setMaxHeight(100);
		textArea1.setMaxWidth(100);		textArea2.setMaxWidth(100);

//------------------------------------------------------------------------------------------------------------------------
		HTMLEditor editor  = new HTMLEditor();
		editor.setMaxHeight(100);	editor.setMaxWidth(300);
		editor.setHtmlText(
				"<html><head><title>��������</title></head><body><body contenteditable=\"true\">" + 
				"<h1 style=\"text-align: center;\"><span style=\"font-family: &quot;Agency FB&quot;; font-size: large;\">HTMLEditor</span></h1>" + 
				"<p>����� 1 <b>���������� �����</b></p>" +
				"<p>����� 2 <u>������������ �����</u></p>" +
				"</body></html>");
		
		Button btn5 = new Button("�������� HTML �����");
		btn5.setOnAction(event -> {
			Alert a = new Alert(Alert.AlertType.INFORMATION, editor.getHtmlText());
			a.showAndWait();
			System.out.println(editor.getHtmlText().toString());
		});

		HBox hbox5 = new HBox();		hbox5.setPadding(new Insets(10));	hbox5.setSpacing(20);
		hbox5.getChildren().addAll(textfield1, textfield2, btn4, label, passwordField, textArea1, textArea2, editor, btn5);
		
//------------------------------------------------------------------------------------------------------------------------
		
		ObservableList<User> list2 = FXCollections.<User>observableArrayList();
		for (int i=1; i<5; i++) list2.add(new User(100+i, "user" + i, "email" + i));
		TableView<User> tableview1 = new TableView<User>(); 	
		tableview1.setItems(list2);
		TableColumn<User, String> columnName2 = new TableColumn<User, String>();
		TableColumn<User, String> columnName1 = new TableColumn<User, String>("User name");
		TableColumn<User, String> columnEmail1 = new TableColumn<User, String>("User email");
		columnName1.setText("User name");
		columnName1.setGraphic(new ImageView(new Image("/img/icons.png")));
		columnName1.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		columnEmail1.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		TableColumn<User, Number> columnId1 = new TableColumn<User, Number>("User ID");
		columnId1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User,Number>, ObservableValue<Number>>() {
			@Override
			public ObservableValue<Number> call(CellDataFeatures<User, Number> cellData) {
				return cellData.getValue().idProperty();
			}
		});
		tableview1.getColumns().add(columnId1);
		tableview1.getColumns().add(columnName1);
		tableview1.getColumns().add(columnEmail1);
		TableColumn<User, Integer> columnGroup = new TableColumn<>("������ ��������");
		columnId1.setMinWidth(50);		columnName1.setMinWidth(50);  columnEmail1.setMinWidth(50);
		columnId1.setResizable(true);  
		columnName1.setResizable(true);
		tableview1.setFixedCellSize(20); 
		tableview1.setMinWidth(150);
		tableview1.setMaxHeight(200);
		tableview1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableview1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		Callback<TableColumn<User, Number>, TableCell<User, Number>> cellFactory4 = 
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
		tableview1.setEditable(true);
		columnName1.setCellFactory(TextFieldTableCell.<User>forTableColumn());
		columnEmail1.setCellFactory(TextFieldTableCell.<User>forTableColumn());
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
		columnId1.addEventHandler(TableColumn.<User, Number>editCommitEvent(), event -> {
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
		columnId1.setOnEditCommit(event -> {
			if (event.getNewValue() == null) tableview1.refresh();
			else event.getRowValue().setId((Integer)event.getNewValue());
		});
		
//-----------------------------------------------------------------------------------------------------------------------------
		TreeView<String> treeview1 = new TreeView<String>();	
		TreeItem<String> root2 = new TreeItem<String>("ROOT NODE ", new Rectangle(10,10,Color.RED));
		root2.setExpanded(true);	 
		treeview1.setRoot(root2);
		treeview1.setShowRoot(true);
		treeview1.setMaxHeight(200);
		treeview1.setMaxWidth(150);
		TreeItem<String> point1 = new TreeItem<String>("Point1");
		TreeItem<String> point2 = new TreeItem<String>("Point2");
		TreeItem<String> point3 = new TreeItem<String>("Point3");
		root2.getChildren().addAll(point1, point2, point3);
		TreeItem<String> point1_1 = new TreeItem<String>("Point1.1");
		TreeItem<String> point1_2 = new TreeItem<String>("Point1.2");
		TreeItem<String> point1_1_1 = new TreeItem<String>("Point1.1.1");
		point1.getChildren().addAll(point1_1, point1_2);
		point1_1.getChildren().add(point1_1_1);
		point1.setExpanded(true);	
		point1_1.setExpanded(true);
		root2.addEventHandler(
				TreeItem.<String>childrenModificationEvent(), event -> {
					System.out.println("������� ��������� � ���� " + event.getTreeItem());
					System.out.println("����� �������� " + event.getNewValue());
					
		});
		root2.addEventHandler(
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
		treeview1.setEditable(true);
		treeview1.setCellFactory(TextFieldTreeCell.forTreeView());
		treeview1.addEventHandler(TreeView.<String>editCommitEvent(), event -> {
			System.out.println(event.getNewValue());					// ���������� ����� ��������
			System.out.println(event.getOldValue());					// ���������� ������ ��������
			System.out.println(event.getTreeItem());					// ���������� ������ �� ������������� ������� ������
			System.out.println(event.getSource());						// ��������� ������ �� ������ ������
			System.out.println(event.getTarget());					
		});
		
//--------------------------------------------------------------------------------------------------------------------------
		
		TreeItem<UserGroup> rootItem2 = new TreeItem<UserGroup>(new UserGroup("ROOT GROUP"));
		rootItem2.setExpanded(true);
		rootItem2.getChildren().add(new TreeItem<UserGroup>(new UserGroup(10,  "Name1",  "name1@mail.ru")));
		
		TreeItem<UserGroup>  group1 = new TreeItem<UserGroup>(new UserGroup("GROUP 1"));
		group1.setExpanded(true);
		group1.getChildren().add(new TreeItem<UserGroup>(new UserGroup(10, "Name 10", "name10@mail.ru")));
		group1.getChildren().add(new TreeItem<UserGroup>(new UserGroup(11, "Name 11", "name11@mail.ru")));
		rootItem2.getChildren().addAll(group1);
		
		TreeItem<UserGroup>  group2 = new TreeItem<UserGroup>(new UserGroup("GROUP 2"));
		group2.setExpanded(true);
		group2.getChildren().add(new TreeItem<UserGroup>(new UserGroup(20, "Name 20", "name20@mail.ru")));
		rootItem2.getChildren().addAll(group2);
		
		TreeTableView<UserGroup> treeTableView2 = new TreeTableView<UserGroup>();
		treeTableView2.setMinWidth(300);
		treeTableView2.setRoot(rootItem2);
		treeTableView2.setShowRoot(true);
		treeTableView2.setTableMenuButtonVisible(true);
		TreeTableColumn<UserGroup, Number> columnId11 = new TreeTableColumn<UserGroup, Number>("User ID");
		TreeTableColumn<UserGroup, String> columnName11 = new TreeTableColumn<UserGroup, String>("User name");
		TreeTableColumn<UserGroup, String> columnEmail11 = new TreeTableColumn<UserGroup, String>("User email");
		TreeTableColumn<UserGroup, String> columnGroup1 = new TreeTableColumn<UserGroup, String>("GROUP"); 
		columnName11.setText("User name");
		columnName11.setCellValueFactory(new TreeItemPropertyValueFactory<UserGroup, String> ("name"));
		columnEmail11.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<UserGroup,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					javafx.scene.control.TreeTableColumn.CellDataFeatures<UserGroup, String> cellData) {
				return cellData.getValue().getValue().emailProperty();
			}
		});
		columnId11.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<UserGroup,Number>, ObservableValue<Number>>() {
			@Override
			public ObservableValue<Number> call(
					javafx.scene.control.TreeTableColumn.CellDataFeatures<UserGroup, Number> cellData) {
				return cellData.getValue().getValue().idProperty();
			}
		});
		
		columnGroup1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<UserGroup,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					javafx.scene.control.TreeTableColumn.CellDataFeatures<UserGroup, String> cellData) {
				return cellData.getValue().getValue().groupProperty();
			}
		});
		treeTableView2.getColumns().add(columnGroup1);
		TreeTableColumn<UserGroup, Integer> columnGroup2 = new TreeTableColumn<UserGroup, Integer>("������ ��������");
		columnGroup2.getColumns().add(columnName11);
		columnGroup2.getColumns().add(columnEmail11);
		treeTableView2.getColumns().add(columnId11);
		treeTableView2.getColumns().add(columnGroup2);
		columnId1.setMinWidth(60);		columnName1.setMinWidth(70);  columnEmail1.setMinWidth(60); 
		columnGroup.setMinWidth(80);
		columnId1.setPrefWidth(120);
		columnId1.setMaxWidth(150);
		columnId1.setResizable(true); // ��� true ���� ����� ������ ������ �������, �������� ����� �� ������� ������� � ������ ��������� 
		columnName1.setResizable(true);
		treeTableView2.setMinWidth(300);
		treeTableView2.setMaxHeight(200);
		treeTableView2.setTableMenuButtonVisible(true);
		treeTableView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		treeTableView2.getSelectionModel().setCellSelectionEnabled(true);		// ��������� ��������� ��������� ������
		
		Callback<TreeTableColumn<UserGroup, Number>, TreeTableCell<UserGroup, Number>> cellFactory1 = 
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
		columnId11.setCellFactory(cellFactory1);

		Callback<TreeTableView<UserGroup>, TreeTableRow<UserGroup>> rowFactory1 = 
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
		treeTableView2.setRowFactory(rowFactory1);
		
		treeTableView2.setSortPolicy(table -> false);

		treeTableView2.setEditable(true);
		columnName11.setCellFactory(TextFieldTreeTableCell.<UserGroup>forTreeTableColumn());
		columnEmail11.setCellFactory(TextFieldTreeTableCell.<UserGroup>forTreeTableColumn());
		columnId11.setCellFactory(TextFieldTreeTableCell.<UserGroup, Number>forTreeTableColumn(
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
		columnId11.setOnEditCommit(event -> {
			if (event.getNewValue() == null) treeTableView2.refresh();
			else event.getRowValue().getValue().setId((Integer)event.getNewValue());
		});

//--------------------------------------------------------------------------------------------------------------------------		
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
		treeView2.setMaxHeight(200);
		treeView2.setMaxWidth(150);
		treeView2.setRoot(rootItem);
		treeView2.setCellFactory(CheckBoxTreeCell.<String>forTreeView());
		treeView2.setShowRoot(true);
		rootItem.addEventHandler(
				CheckBoxTreeItem.<String>checkBoxSelectionChangedEvent(), event  -> {
					System.out.println("������� ��������� � ���� " + event.getTreeItem());
					if (event.getTreeItem() == null) {
						System.out.println("value " + event.getTreeItem().getValue());
						System.out.println("selected " + event.getTreeItem().isSelected());
						System.out.println("intermerminate " + event.getTreeItem().isIndeterminate());
					}
		});
			
		HBox hbox6 = new HBox();		hbox6.setPadding(new Insets(10));	hbox6.setSpacing(20);
		hbox6.getChildren().addAll(tableview1, treeview1, treeView2, treeTableView2);
		
//---------------------------------------------------------------------------------------------------------------------------
		
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(hbox99, hbox, hbox2, hbox4, hbox3, hbox5, hbox6);
		
		Scene scene = new Scene(vbox, 1300, 700);	
		primaryStage.setScene(scene);				
		primaryStage.setTitle("ALL POSIBILLITIES");	
		primaryStage.show();						
	}	
	
	public TreeItem<String> makeShow(String nodeName, TreeItem<String> parent) {
		// � ��������� ��������� ��� ���� � String � ��� �������� ������ TreeItem  
		// ������� node ������ TreeItem, � ����������� ��������� String nodeName
	TreeItem<String> node = new TreeItem<String>(nodeName);
		// ������� setExpanded() �������������� ��� ����� node true, ����� �� ������ ��� ����� ����� � ������
	node.setExpanded(true);
		/* ������� getChildren() �������� ������ ObservableList - ������ ����� ����� �� �������� � ���������
		   � ���� ������ ������ ����   */
	parent.getChildren().add(node);
	return node;
}
	
	@Override					// ���������� ���������, ���� Timer �� �������� �����-�������
	public void stop() {
		timer.cancel();
	}
		
	
	public static void main(String[] args) {
		launch(args);
}
}