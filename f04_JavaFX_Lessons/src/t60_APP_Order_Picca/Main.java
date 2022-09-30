package t60_APP_Order_Picca;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;
	
public class Main extends Application {
	Stage stage;
	TextField txtName, txtPhone, txtAddress;
	RadioButton rdoSmall, rdoMedium, rdoLarge, rdoThin, rdoThick;
	CheckBox chkPepperoni, chkSausage, chkLinguica, chkOlives, chkMushrooms, chkTomatoes, chkAnchovies;
		@Override 
	public void start(Stage primaryStage) 		{
		stage = primaryStage;
			//	Создание главного заголовка
		Text textHeading = new Text("Order Your Pizza Now!");
		textHeading.setFont(new Font(20));
		HBox paneTop = new HBox(textHeading);
		paneTop.setPadding(new Insets(20, 10, 20, 10));
		
			// Создание поля с именем
		Label lblName = new Label("Name:");
		lblName.setPrefWidth(100);
		txtName = new TextField();
		txtName.setPrefColumnCount(20);
		txtName.setPromptText("Enter the customer's name here");
		txtName.setMaxWidth(Double.MAX_VALUE);
		HBox paneName = new HBox(lblName, txtName);
		
			// Создание поля для телефонного номера
		Label lblPhone = new Label("Phone Number:");
		lblPhone.setPrefWidth(100);
		txtPhone = new TextField();
		txtPhone.setPrefColumnCount(20);
		txtPhone.setPromptText("Enter the customer's phone number here");
		HBox panePhone = new HBox(lblPhone, txtPhone);
		
			// Cоздание поля для адреса
		Label lblAddress = new Label("Address:");
		lblAddress.setPrefWidth(100);
		txtAddress = new TextField();
		txtAddress.setPrefColumnCount(20);
		txtAddress.setPromptText("Enter the customer's address here");
		HBox paneAddress = new HBox(lblAddress, txtAddress);
		
			// Добавление HBox для имени, номера телефона и адреса в VBox
		VBox paneCustomer = new VBox(10, paneName, panePhone, paneAddress);

			// Создание RadioButton для выбора размера пиццы и добавление их в VBox
		Label lblSize = new Label("Size");
		rdoSmall = new RadioButton("Small");
		rdoMedium = new RadioButton("Medium");
		rdoLarge = new RadioButton("Large");
		rdoMedium.setSelected(true);
		ToggleGroup groupSize = new ToggleGroup();
		rdoSmall.setToggleGroup(groupSize);
		rdoMedium.setToggleGroup(groupSize);
		rdoLarge.setToggleGroup(groupSize);
		VBox paneSize = new VBox(lblSize, rdoSmall, rdoMedium, rdoLarge);
		paneSize.setSpacing(10);
		
			// Создание RadioButton для выбора толщины коржа пиццы и добавление их в VBox
		Label lblCrust = new Label("Crust");
		rdoThin = new RadioButton("Thin");
		rdoThick = new RadioButton("Thick");
		rdoThin.setSelected(true);
		ToggleGroup groupCrust = new ToggleGroup();
		rdoThin.setToggleGroup(groupCrust);
		rdoThick.setToggleGroup(groupCrust);
		VBox paneCrust = new VBox(lblCrust, rdoThin, rdoThick);
		paneCrust.setSpacing(10);
		
			// Создание CheckBox для выбора наполнения пиццы и добавление его в FlowPane и затем вместе с заголовком в VBox
		Label lblToppings = new Label("Toppings");
		chkPepperoni = new CheckBox("Pepperoni");
		chkSausage = new CheckBox("Sausage");
		chkLinguica = new CheckBox("Linguica");
		chkOlives = new CheckBox("Olives");
		chkMushrooms = new CheckBox("Mushrooms");
		chkTomatoes = new CheckBox("Tomatoes");
		chkAnchovies = new CheckBox("Anchovies");
		FlowPane paneToppings = new FlowPane(Orientation.VERTICAL, chkPepperoni, chkSausage, chkLinguica, chkOlives,
		chkMushrooms, chkTomatoes, chkAnchovies);
		paneToppings.setPadding(new Insets(10, 0, 10, 0));
		paneToppings.setHgap(20);
		paneToppings.setVgap(10);
		paneToppings.setPrefWrapLength(100);
		VBox paneTopping = new VBox(lblToppings, paneToppings);
		
			// Добавление всех полей выбора в  HBox
		HBox paneOrder = new HBox(50, paneSize, paneCrust, paneTopping);

			// Добавление HBox для информации о клиенте и HBox c выбором заказа в общий VBox
		VBox paneCenter = new VBox(20, paneCustomer, paneOrder);
		paneCenter.setPadding(new Insets(0,10, 0, 10));

		Button btnOK = new Button("OK");
		btnOK.setPrefWidth(80);
		btnOK.setOnAction(e -> btnOK_Click() );
		
		Button btnCancel = new Button("Cancel");
		btnCancel.setPrefWidth(80);
		btnCancel.setOnAction(e -> btnCancel_Click() );
		Region spacer = new Region();
		
		HBox paneBottom = new HBox(10, spacer, btnOK, btnCancel);
		paneBottom.setHgrow(spacer, Priority.ALWAYS);
		paneBottom.setPadding(new Insets(20, 10, 20, 10));
		
		BorderPane paneMain = new BorderPane();
		paneMain.setTop(paneTop);
		paneMain.setCenter(paneCenter);
		paneMain.setBottom(paneBottom);

		Scene scene = new Scene(paneMain);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pizza Order");
		primaryStage.show();
	}
	
	public void btnOK_Click() 	{
		String msg = "Customer:\n\n";
		msg += "\t" + txtName.getText() + "\n";
		msg += "\t" + txtAddress.getText() + "\n";
		msg += "\t" + txtPhone.getText() + "\n\n";
		msg += "You have ordered a ";
		if (rdoSmall.isSelected()) 	msg += "small ";
		if (rdoMedium.isSelected()) msg += "medium ";
		if (rdoLarge.isSelected()) 	msg += "large ";
		
		if (rdoThin.isSelected()) 	msg += "thin crust pizza with ";
		if (rdoThick.isSelected()) 	msg += "thick crust pizza with ";

		String toppings = "";
		toppings = buildToppings(chkPepperoni, toppings);
		toppings = buildToppings(chkSausage, toppings);
		toppings = buildToppings(chkLinguica, toppings);
		toppings = buildToppings(chkOlives, toppings);
		toppings = buildToppings(chkTomatoes, toppings);
		toppings = buildToppings(chkMushrooms, toppings);
		toppings = buildToppings(chkAnchovies, toppings);
		if (toppings.equals("")) msg += "no toppings.";
		else msg += "the following toppings:\n" + toppings;

		Alert a = new Alert(Alert.AlertType.INFORMATION,msg);
		a.setTitle("Order Details");
		a.showAndWait();
	}
	
	public String buildToppings(CheckBox chk, String msg) 	{
		if (chk.isSelected()) {
			if (!msg.equals("")) msg += ", ";
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