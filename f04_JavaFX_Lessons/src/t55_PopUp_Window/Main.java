package t55_PopUp_Window;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Popup;
import javafx.stage.PopupWindow.AnchorLocation;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.PopupControl;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Main extends Application {
	Button btn;
	Label lbl;
	int iClickCount = 0;
	
		@Override 
	public void start(Stage primaryStage) {
			
			/* Абстраткный класс PopupWindow - всплывающее окно
		описывает окно без заголовка и рамки, которое используется для отображения различных всплывающих окно - например, для
		вывода контекстного меню или окна с подсказкой.
		Такое окно не отображается на панели задач окна и всегда привязано к родительскому окну
		Наследование Object - Window - PopupWindow   */ 
			
//------------------------------------------TOOLTIP------------------------------------------------------------------------
			
			/* Класс Tooltip реализует всплывающее окно с текстом подсказки пользователю.
	     При наведении мыши через некоторое время отобразится подсказака. При выведении мыши из области компонента
	     или при потере фокуса ввода всплывающее окно скрывается. Скрыть также можно через нажатие Esc 
	     Наследование Object - Window - PopupWindow - Tooltip			 */
		
			// Создание всплывающего  окна
		Tooltip tooltip = new Tooltip();
		Tooltip tooltip2 = new Tooltip("Подсказка");
				
		System.out.println("Ссылка на родительское окно - " + tooltip.getOwnerWindow());
		System.out.println("Ссылка на родительский узел - " + tooltip.getOwnerNode());
		System.out.println("Ссылка на объект сцены - " + tooltip.getScene());
				
			// Сокрытие всплывающего окна при потере фокуса
		tooltip.setAutoHide(true);
			// Сокрытие всплывающего окна при нажатии Esc
		tooltip.setHideOnEscape(true);
			// Размеры всплывающего окна
		tooltip.setWidth(150);
		tooltip.setHeight(150);
			// Положение окна корректируется автоматически при true, чтобы оно не выходило за экран
		tooltip.setAutoFix(true);		
		
			/* Установка флага прерывания распространения события при true.
		Например, если мы назначили обработчик нажатия кнопки для окна верхнего уровня, то при сокрытии всплывающего окна
		с помощью Esc обработчик вызван не будет 		 */
		tooltip.setConsumeAutoHidingEvents(true);
		
			// Местоположение всплывающего окна
//		tooltip.setX(100);			tooltip.setY(100);					// - положение левого верхнего угла окна
//		tooltip.setAnchorX(100);	tooltip.setAnchorY(100);			// - положение якорной точки на экране
//		popup.setAnchorLocation(AnchorLocation.WINDOW_BOTTOM_LEFT);	// - положение якорной точки внутри окна
		
			// Добавление отображаемого в всплывающем окне узла в всплывающее окно
		tooltip.setText("ТЕКСТ ПОДСКАЗКИ");
		
			// Настройка стиля с помощью методов аналогичных в классе Labelled
		tooltip.setFont(Font.font("Calibri", 15));
		tooltip.setGraphic(new Rectangle(10,  10,  Color.AQUA));
		tooltip.setOpacity(0.7);
		tooltip.setWrapText(false);
		tooltip.setGraphicTextGap(10);
		tooltip.setTextOverrun(OverrunStyle.ELLIPSIS);
		tooltip.setContentDisplay(ContentDisplay.LEFT);
		tooltip.setTextAlignment(TextAlignment.CENTER);
		tooltip.setStyle("-fx-background-color: green;");
		
			// Задает задержку перед отображением подсказки при вхождении указателя мыши в область компонента
		tooltip.setShowDelay(Duration.millis(1000));
			
			/* Задает максимальную продолжит. показа окна с подсказкой. По умолчанию - 5000 мс.
		Если мышка покинет область компонента раньше этого времени, то он может закрыться с задржкой hidedelay.				 */
		tooltip.setShowDuration(Duration.millis(6000));
		tooltip.setHideDelay(Duration.millis(500));
		
			// Определяет вошла ли мышь в область компонента
		System.out.println(tooltip.isActivated());

			/* 3 формата метода show() для отображения подсказки
		tooltip.show(window) - указывается ссылка на родительское окно. Окно выводится по центру экрана 
		tooltip.show(window, window.getX() + anchorX, window.getY() + anchorY) - позволяет указать координаты
		местоположения всплываюещего окна относительно левого верхнего угла
		tooltip.show(node, window.getX() + anchorX, window.getY() + anchorY) - принимает ссылку на узел, родительское окно которого
		будет использоваться в качестве родителя, а также позволяет указать координатыместоположения всплываюещего окна относительно
		левого верхнего угла				 */
		Button btn = new Button("ToolTip Button");
		
			// Вызов всплывающего окна при наведении на кнопку с помощью setTooltip(Tooltip value)
		btn.setTooltip(tooltip);
		
			// Вызов всплывающего окна при наведении на кнопку с помощью install(Node node, Tooltip value)
		Tooltip.install(btn, tooltip);
		
			// Удаление привязки подсказки
//		Tooltip.uninstall(btn, tooltip);
		
			// Вызов всплывающего окна при нажатии на кнопку
		btn.setOnAction(event -> {
			System.out.println("Всплывающее окно отображается - " + tooltip.isShowing());
			tooltip.show(primaryStage);	
		});
				
//---------------------------------------------POPUP-----------------------------------------------------------------------		
			/* Класс Popup - является реализацией абсрактного класса PopupWindow
		Наследование Object - Window - PopupWindow - Popup   
		Реализует все методы класса PopupWindow и дополнительно getContent(), с помощью которого можно добавить узел в окно */
		
			// Создание всплывающего  окна
		Popup  popup = new Popup();
		
		System.out.println("Ссылка на родительское окно - " + popup.getOwnerWindow());
		System.out.println("Ссылка на родительский узел - " + popup.getOwnerNode());
		System.out.println("Ссылка на объект сцены - " + popup.getScene());
		
			// Сокрытие всплывающего окна при потере фокуса
		popup.setAutoHide(true);
			// Сокрытие всплывающего окна при нажатии Esc
		popup.setHideOnEscape(true);
			// Размеры всплывающего окна
		popup.setWidth(150);
		popup.setHeight(150);
			// Положение окна корректируется автоматически при true, чтобы оно не выходило за экран
		popup.setAutoFix(true);
			
			/* Установка флага прерывания распространения события при true.
		Например, если мы назначили обработчик нажатия кнопки для окна верхнего уровня, то при сокрытии всплывающего окна
		с помощью Esc обработчик вызван не будет 		 */
		popup.setConsumeAutoHidingEvents(true);
		
			// Местоположение всплывающего окна
//		popup.setX(100);			popup.setY(100);					// - положение левого верхнего угла окна
//		popup.setAnchorX(100);		popup.setAnchorY(100);			// - положение якорной точки на экране
//		popup.setAnchorLocation(AnchorLocation.WINDOW_BOTTOM_LEFT);	// - положение якорной точки внутри окна
		
		popup.setOpacity(0.7);
		
			// Создание узла в виде окна с синим фоном и надписью белого цвета для всплывающего окна
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);		vbox.setPrefSize(200, 100);		vbox.setStyle("-fx-background-color: blue;");
		Label txt = new Label("Текст внутри окна");
		txt.setTextFill(Color.WHITE);		
		vbox.getChildren().add(txt);
		
			// Вызов всплываующего окна при нажатии на кнопку
		Button btn2 = new Button("PopUp Button");
		btn2.setOnAction(event -> {
			System.out.println("Всплывающее окно отображается - " + popup.isShowing());
			popup.show(primaryStage);	
		});
		
//---------------------------------------------POPUP CONTROL-----------------------------------------------------------------------		
		/* Класс PopupControl - расширяет класс PopupWindow и добавляет возможность использования стилей
	Наследование Object - Window - PopupWindow - Popup  */
			// Создание всплывающего  окна
		PopupControl  popupControl = new PopupControl();
				
		System.out.println("Ссылка на родительское окно - " + popupControl.getOwnerWindow());
		System.out.println("Ссылка на родительский узел - " + popupControl.getOwnerNode());
		System.out.println("Ссылка на объект сцены - " + popupControl.getScene());
				
			// Сокрытие всплывающего окна при потере фокуса
		popupControl.setAutoHide(true);
			// Сокрытие всплывающего окна при нажатии Esc
		popupControl.setHideOnEscape(true);
			// Размеры всплывающего окна
		popupControl.setWidth(150);
		popupControl.setHeight(150);
			// Положение окна корректируется автоматически при true, чтобы оно не выходило за экран
		popupControl.setAutoFix(true);
					
			/* Установка флага прерывания распространения события при true.
		Например, если мы назначили обработчик нажатия кнопки для окна верхнего уровня, то при сокрытии всплывающего окна
		с помощью Esc обработчик вызван не будет 		 */
		popupControl.setConsumeAutoHidingEvents(true);
				
			// Местоположение всплывающего окна
//				popupControl.setX(100);			popupControl.setY(100);					// - положение левого верхнего угла окна
//				popupControl.setAnchorX(100);	popupControl.setAnchorY(100);			// - положение якорной точки на экране
//				popupControl.setAnchorLocation(AnchorLocation.WINDOW_BOTTOM_LEFT);	// - положение якорной точки внутри окна
				
			// Создание узла в виде окна с синим фоном и надписью белого цвета для всплывающего окна
		VBox vbox2 = new VBox();
		vbox2.setAlignment(Pos.CENTER);		vbox2.setPrefSize(200, 100);		vbox2.setStyle("-fx-background-color: blue;");
		Label txt2 = new Label("Текст внутри окна");
		txt2.setTextFill(Color.WHITE);		
		vbox2.getChildren().add(txt2);
				
			// Добавление отображаемого в всплывающем окне узла в всплывающее окно
		popupControl.getScene().setRoot(vbox2);
			// Определение стиля
		popupControl.setStyle("-fx-background-color: green;");
				
			// Вызов всплываующего окна при нажатии на кнопку
		Button btn3 = new Button("PopUpControl");
		btn3.setOnAction(event -> {
			System.out.println("Всплывающее окно отображается - " + popupControl.isShowing());
			popupControl.show(primaryStage);	
		});
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(btn, btn2, btn3);
		Scene scene = new Scene(hbox, 800, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
 