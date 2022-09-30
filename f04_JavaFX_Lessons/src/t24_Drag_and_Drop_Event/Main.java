package t24_Drag_and_Drop_Event;
	
import java.io.Serializable;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;

class Points implements Serializable{
	private static final long serialVersionUID = -730791726267447983L;
	public double x,y;
	public Points(double x, double y) {
		this.x = x;
		this.y = y;	
	}
	@Override
	public String toString () {
		return ("Point [x=" + x + " , y = " + y + "]" );
	}
}

public class Main extends Application  {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl, lbl2;
	int i = 0;
	
		@Override 
	public void start(Stage primaryStage) {			
		lbl = new Label();				lbl.setText("TEXT LABEL 1"); 
		lbl2 = new Label();				lbl2.setText("TEXT LABEL 2");
		TextField txf = new TextField("TextField");
		
		HBox pane = new HBox(10);
		pane.getChildren().addAll(lbl, lbl2, txf);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Add/Sub");
		
		/* Для обмена данными между программами служит буфер обмена. Первое приложение помещает данные в буфер обмена,
		а второе приложение (или то же) может извлечь данные из буфера.
		Получить ссылку на глобальный объект буфера обмена повзоялет статический метод getSystemClipboard() класса Clipboard.
		Данные добавляемые в буфер обмена принадлежат классу ClipboardContent 
		Наследование класса ClipboardContent : Object - AbstactMap<K,V> - HashMap<DataFormat, Object> - ClipboardContent
			Конструктор ClipboardContent - ClipboardContent()
			Методы ClipboardContent:
		- putString() - добавление данных типа DataFormat.PLAIN_TEXT (простой текст)
		-putHtml() - добавление данных типа DataFormat.HTML
		- putRtf() - добавление данных типа DataFormat.RTF
		- putUrl() - добавление данных типа DataFormat.URL
		- putFiles() - добавление списка файлов DataFormat.FILES  Список List<File> files
		- putFilesByPath() - добавление списка файлов DataFormat.FILES   Список List<String> filePatches
		- putImage() - добавление данных типа DataFormat.IMAGE (изображение)
		- put() - добавление данных в формате объект класса Object
		Проверить наличие данных определенного формата можно с помощью методов has(), получить данные - методы get()		  */
		
			// ДОБАВЛЕНИЕ ДАННЫХ ФИКСИРОВАННОГО ФОРМАТА В БУФЕР ОБМЕНА
		Clipboard cb = Clipboard.getSystemClipboard();
		ClipboardContent content = new ClipboardContent();
		content.putString("ТЕКСТ ДОБАВЛЯЕМЫЙ В БУФЕР ОБМЕНА");
		cb.setContent(content);
 
			/* ПОЛУЧЕНИЕ ДАННЫХ ИЗ БУФЕРА ОБМЕНА
		hasString() - true, если в буфере содержится DataFormat.PLAIN_TEXT (простой текст)
		getString() - возвращает данные DataFormat.PLAIN_TEXT 		
		hasHtml() - true, если в буфере содержится DataFormat.HTML (HTML-текст)
		getHtml() - возвращает данные DataFormat.HTML
		hasRtf() - true, если в буфере содержится DataFormat.RTF (текст в формате RTF)
		getRtf() - возвращает данные DataFormat.RTF
		hasUrl() - true, если в буфере содержится DataFormat.URL (URL-адресс)
		getUrl() - возвращает данные DataFormat.URL
		hasFiles() - true, если в буфере содержится DataFormat.FILES (список файлов)
		getFiles() - возвращает список файлов DataFormat.FILES
		hasImage() - true, если в буфере содержится DataFormat.IMAGE (изображение)
		hasImage() - true, если в буфере содержится DataFormat.IMAGE (изображение)
		hasContent() - true, если в буфере содержатся данные формата dataFormat
		getContent() - возвращает данные в формате объект класса Object
		getContentTypes() - возвращает множество со всеми доступными типами  */
		
		if (cb.hasString()) System.out.println("Текстовые данные из буфера  -   " + cb.getString());
		if (cb.hasHtml()) System.out.println("Текстовые данные из буфера  -   " + cb.getHtml());
		if (cb.hasFiles()) System.out.println("Текстовые данные из буфера  -   " + cb.getFiles());
		Image im = new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg"));
		ClipboardContent content2 = new ClipboardContent();
		content2.putImage(im);
		cb.setContent(content2);
		if (cb.hasString()) System.out.println("Текстовые данные из буфера  -   " + cb.getString());
		else System.out.println("После добавления в буфер картинки, текст удалился");
		if (cb.hasImage()) System.out.println("В буфере есть данные IMAGE");
		
			/* ДОБАВЛЕНИЕ ДАННЫХ ПОЛЬЗОВАТЕЛЬСКОГО ФОРМАТА
		Для добавления данных пользовательского метода нужно сначала зарегистрировать этот тип, создав экземпляр класса DataFormat
		
		*/
			// Регистрация пользовательского типа type/my_type
		DataFormat df = new DataFormat("type/my_type");
			// Получение ссылки на тип после регистрации позволяет статический метод lookupMimeType
		DataFormat df1 = DataFormat.lookupMimeType("type/my_type");
		ClipboardContent content3 = new ClipboardContent();
			// Добавление объекта класса Points
		content3.put(df1, new Points(10, 10));
		cb.setContent(content3);
			// Получение  объекта класса Points
		if (cb.hasContent(df)) {
			Points p = (Points)cb.getContent(df);
			System.out.println(p);
		}
		
			// ОЧИСТКА БУФЕРА ОБМЕНА
		cb.clear();		
		
/* ----------------------------------------------------------------------------------------------------------------------------------
 							ТЕХНОЛОГИЯ ОБМЕНА ДАННЫМИ DRAG&DROP
 	    позволяет обмениваться данными как одного приложения, так и разных приложений, путем перетаскивания и сбрасывания объектов с 
 	    помощью мыши. Например, перемещение файлов в проводнике Windows
 	    Наследование Object - EventObject - Event - InputEvent - DragEvent
 	    Процесс перетаскивания состоит из 3-х этапов. Первый запускает процесс. Второй - обрабатывает момент перемещения и сброса
 	    объекта. Третий - проверяет результат операции.
 	    						
 */
				// УСТАНОВКА ОБРАБОТЧИКА НА ДЕЙСТВИЕ ПЕРЕТАСКИВАНИЯ 
		primaryStage.addEventHandler(DragEvent.ANY, event -> {
//		  System.out.println("Реакция на любое дейтсвие перетаскивания " + event.getEventType());	
		});
		
				/* ИЗОБРАЖЕНИЕ НАД МЫШЬЮ ПРИ ПЕРЕТАСКИВАНИИ
		Метод setDragView(Image image) - задает изображение
		Метод setDragView(Image imageб, double offsetX, double offsetН) - задает изображение и смещение курсра (чтобы не накладывался на изобр)
		Метод setDragViewOffsetX(double offsetX) - задает смещение курсра (чтобы не накладывался на изобр)
		Метод setDragViewOffsetY(double offsetY) - задает смещение курсра (чтобы не накладывался на изобр)
		 */
		
				/* ЗАПУСК ПЕРЕТАСКИВАНИЯ
		Внутри обработчика MouseEvent.DRAG_DETECTED вызываем метод startDragAndDrop() и в качестве параметра передаем возможные
		режимы сброса (копирование или перемещение).
		Метод возвращает объект класса Dragboard, который наследует ClipBoard (буфер обмена)
		После получения ссылки на объект Dragboard добавляем перетаскиваемые данные в буфер через					 */
			// Из Node       Из Scene и Node  то же можно сделать с помощью метода setOnDragDone(EventHandler event)
		lbl.addEventHandler(MouseEvent.DRAG_DETECTED, event -> {
			Dragboard db = lbl.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			try {
				db.setDragView(new Image(getClass().getResourceAsStream("/img/icons.png")));
				db.setDragViewOffsetX(32);
				db.setDragViewOffsetY(32);
			}
			catch (Exception t) {
				System.out.println("Не удалось загрузить фото");
			}
			ClipboardContent content4 = new ClipboardContent();
			content4.putString(lbl.getText());
			db.setContent(content4);
			System.out.println("В буфер внесено " + db.getString() + "  при DRAG&DROP");
			event.consume();
		});
			
				// НАВЕДЕНИЕ УКАЗАТЕЛЯ МЫШИ НА УЗЕЛ ПРИ ПЕРЕТАСКИВАНИИ (событие только для узла)
			// Из Node       Из Scene и Node  то же можно сделать с помощью метода setOnDragEntered(EventHandler event)
		lbl.addEventHandler(DragEvent.DRAG_ENTERED, event -> {
			lbl.setText("DRAG_ENTERED");
		});
				
				// ВЫВЕДЕНИЕ УКАЗАТЕЛЯ МЫШИ ИЗ ОБЛАСТИ УЗЛА ПРИ ПЕРЕТАСКИВАНИИ (событие только для узла)
			// Из Node       Из Scene и Node  то же можно сделать с помощью метода setOnDragEntered(EventHandler event)
		lbl.addEventHandler(DragEvent.DRAG_EXITED, event -> {
			lbl.setText("DRAG_EXITED");
		});
		
				//  DRAG_ENTERED_TARGET И DRAG_EXITED_TARGET
		
				/* ПЕРЕТАСКИВАНИЕ ВНУТРИ ОБЛАСТИ УЗЛА
		Внутри обработчика нужно проверить тип перетаскиваемых данных и, если тип устраивает, вызвать метод acceptTransferModes() 
		через объект события и указать в качестве параметра поддерживаемые режимы обработки сброса  - подтверждение
		возможности копирования или перемещения
		Обработчик вызывается постоянно при перемещении мыши с зажатой кнопкой 			 */
			// Из Node       Из Scene и Node  то же можно сделать с помощью метода setOnDragOver(EventHandler event)
		lbl2.addEventHandler(DragEvent.DRAG_OVER, event2 -> {
			Dragboard db = event2.getDragboard();
			if (db.hasString()) event2.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			if (i ==0) {
				System.out.println("Начало перетаскивания");
				i = 2;
			}
			event2.consume();
		});
		
				/* ОТПУСКАНИЕ КНОПКИ МЫШИ ПРИ ПЕРЕТАСКИВАНИИ (событие сброса)
		Событие сброа осуществляется, когда пользователь опускает клавишу мыши.
		Внутри обработчика этого события нужно выполнить обработку сброса данных: проверить тип данных и получить эти данные.
		После получения данных необходимо сообщить результат операции сброса, вызвав метод setDropCompleted, через объект события
		Результат сброса будет доступен внутри обработчика DragEvent.DRAG_DONE			 */
			// Из Node       Из Scene и Node  то же можно сделать с помощью метода setOnDragDropped(EventHandler event)
		lbl2.addEventHandler(DragEvent.DRAG_DROPPED, event -> {
			Dragboard db = event.getDragboard();
			boolean success = false;
			System.out.println("Произошел сброс " + db.getString());
			if (db.hasString()) {
				lbl2.setText(db.getString());
				success = true;
			}
			event.setDropCompleted(success);
			event.consume();
		});
		
				/* ОКОНЧАНИЕ ПЕРЕТАСКИВАНИЯ
		Внутри обработчика этого события нужно выполнить обработку сброса данных: проверить тип данных и получить эти данные.
		После получения данных необходимо сообщить результат операции сброса, вызвав метод setDropCompleted, через объект события				 */
			// Из Node       Из Scene и Node  то же можно сделать с помощью метода setOnDragDone(EventHandler event)
		lbl2.addEventHandler(DragEvent.DRAG_DONE, event -> {
			if (event.isAccepted()) {
				System.out.println("Сброс выполнен удачно. Режим " + event.getTransferMode());
			}
			else System.out.println("Сброс не выполнен");
		});
		
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
