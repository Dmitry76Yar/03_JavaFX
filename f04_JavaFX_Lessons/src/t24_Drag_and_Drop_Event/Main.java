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
		
		/* ��� ������ ������� ����� ����������� ������ ����� ������. ������ ���������� �������� ������ � ����� ������,
		� ������ ���������� (��� �� ��) ����� ������� ������ �� ������.
		�������� ������ �� ���������� ������ ������ ������ ��������� ����������� ����� getSystemClipboard() ������ Clipboard.
		������ ����������� � ����� ������ ����������� ������ ClipboardContent 
		������������ ������ ClipboardContent : Object - AbstactMap<K,V> - HashMap<DataFormat, Object> - ClipboardContent
			����������� ClipboardContent - ClipboardContent()
			������ ClipboardContent:
		- putString() - ���������� ������ ���� DataFormat.PLAIN_TEXT (������� �����)
		-putHtml() - ���������� ������ ���� DataFormat.HTML
		- putRtf() - ���������� ������ ���� DataFormat.RTF
		- putUrl() - ���������� ������ ���� DataFormat.URL
		- putFiles() - ���������� ������ ������ DataFormat.FILES  ������ List<File> files
		- putFilesByPath() - ���������� ������ ������ DataFormat.FILES   ������ List<String> filePatches
		- putImage() - ���������� ������ ���� DataFormat.IMAGE (�����������)
		- put() - ���������� ������ � ������� ������ ������ Object
		��������� ������� ������ ������������� ������� ����� � ������� ������� has(), �������� ������ - ������ get()		  */
		
			// ���������� ������ �������������� ������� � ����� ������
		Clipboard cb = Clipboard.getSystemClipboard();
		ClipboardContent content = new ClipboardContent();
		content.putString("����� ����������� � ����� ������");
		cb.setContent(content);
 
			/* ��������� ������ �� ������ ������
		hasString() - true, ���� � ������ ���������� DataFormat.PLAIN_TEXT (������� �����)
		getString() - ���������� ������ DataFormat.PLAIN_TEXT 		
		hasHtml() - true, ���� � ������ ���������� DataFormat.HTML (HTML-�����)
		getHtml() - ���������� ������ DataFormat.HTML
		hasRtf() - true, ���� � ������ ���������� DataFormat.RTF (����� � ������� RTF)
		getRtf() - ���������� ������ DataFormat.RTF
		hasUrl() - true, ���� � ������ ���������� DataFormat.URL (URL-������)
		getUrl() - ���������� ������ DataFormat.URL
		hasFiles() - true, ���� � ������ ���������� DataFormat.FILES (������ ������)
		getFiles() - ���������� ������ ������ DataFormat.FILES
		hasImage() - true, ���� � ������ ���������� DataFormat.IMAGE (�����������)
		hasImage() - true, ���� � ������ ���������� DataFormat.IMAGE (�����������)
		hasContent() - true, ���� � ������ ���������� ������ ������� dataFormat
		getContent() - ���������� ������ � ������� ������ ������ Object
		getContentTypes() - ���������� ��������� �� ����� ���������� ������  */
		
		if (cb.hasString()) System.out.println("��������� ������ �� ������  -   " + cb.getString());
		if (cb.hasHtml()) System.out.println("��������� ������ �� ������  -   " + cb.getHtml());
		if (cb.hasFiles()) System.out.println("��������� ������ �� ������  -   " + cb.getFiles());
		Image im = new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg"));
		ClipboardContent content2 = new ClipboardContent();
		content2.putImage(im);
		cb.setContent(content2);
		if (cb.hasString()) System.out.println("��������� ������ �� ������  -   " + cb.getString());
		else System.out.println("����� ���������� � ����� ��������, ����� ��������");
		if (cb.hasImage()) System.out.println("� ������ ���� ������ IMAGE");
		
			/* ���������� ������ ����������������� �������
		��� ���������� ������ ����������������� ������ ����� ������� ���������������� ���� ���, ������ ��������� ������ DataFormat
		
		*/
			// ����������� ����������������� ���� type/my_type
		DataFormat df = new DataFormat("type/my_type");
			// ��������� ������ �� ��� ����� ����������� ��������� ����������� ����� lookupMimeType
		DataFormat df1 = DataFormat.lookupMimeType("type/my_type");
		ClipboardContent content3 = new ClipboardContent();
			// ���������� ������� ������ Points
		content3.put(df1, new Points(10, 10));
		cb.setContent(content3);
			// ���������  ������� ������ Points
		if (cb.hasContent(df)) {
			Points p = (Points)cb.getContent(df);
			System.out.println(p);
		}
		
			// ������� ������ ������
		cb.clear();		
		
/* ----------------------------------------------------------------------------------------------------------------------------------
 							���������� ������ ������� DRAG&DROP
 	    ��������� ������������ ������� ��� ������ ����������, ��� � ������ ����������, ����� �������������� � ����������� �������� � 
 	    ������� ����. ��������, ����������� ������ � ���������� Windows
 	    ������������ Object - EventObject - Event - InputEvent - DragEvent
 	    ������� �������������� ������� �� 3-� ������. ������ ��������� �������. ������ - ������������ ������ ����������� � ������
 	    �������. ������ - ��������� ��������� ��������.
 	    						
 */
				// ��������� ����������� �� �������� �������������� 
		primaryStage.addEventHandler(DragEvent.ANY, event -> {
//		  System.out.println("������� �� ����� �������� �������������� " + event.getEventType());	
		});
		
				/* ����������� ��� ����� ��� ��������������
		����� setDragView(Image image) - ������ �����������
		����� setDragView(Image image�, double offsetX, double offset�) - ������ ����������� � �������� ������ (����� �� ������������ �� �����)
		����� setDragViewOffsetX(double offsetX) - ������ �������� ������ (����� �� ������������ �� �����)
		����� setDragViewOffsetY(double offsetY) - ������ �������� ������ (����� �� ������������ �� �����)
		 */
		
				/* ������ ��������������
		������ ����������� MouseEvent.DRAG_DETECTED �������� ����� startDragAndDrop() � � �������� ��������� �������� ���������
		������ ������ (����������� ��� �����������).
		����� ���������� ������ ������ Dragboard, ������� ��������� ClipBoard (����� ������)
		����� ��������� ������ �� ������ Dragboard ��������� ��������������� ������ � ����� �����					 */
			// �� Node       �� Scene � Node  �� �� ����� ������� � ������� ������ setOnDragDone(EventHandler event)
		lbl.addEventHandler(MouseEvent.DRAG_DETECTED, event -> {
			Dragboard db = lbl.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			try {
				db.setDragView(new Image(getClass().getResourceAsStream("/img/icons.png")));
				db.setDragViewOffsetX(32);
				db.setDragViewOffsetY(32);
			}
			catch (Exception t) {
				System.out.println("�� ������� ��������� ����");
			}
			ClipboardContent content4 = new ClipboardContent();
			content4.putString(lbl.getText());
			db.setContent(content4);
			System.out.println("� ����� ������� " + db.getString() + "  ��� DRAG&DROP");
			event.consume();
		});
			
				// ��������� ��������� ���� �� ���� ��� �������������� (������� ������ ��� ����)
			// �� Node       �� Scene � Node  �� �� ����� ������� � ������� ������ setOnDragEntered(EventHandler event)
		lbl.addEventHandler(DragEvent.DRAG_ENTERED, event -> {
			lbl.setText("DRAG_ENTERED");
		});
				
				// ��������� ��������� ���� �� ������� ���� ��� �������������� (������� ������ ��� ����)
			// �� Node       �� Scene � Node  �� �� ����� ������� � ������� ������ setOnDragEntered(EventHandler event)
		lbl.addEventHandler(DragEvent.DRAG_EXITED, event -> {
			lbl.setText("DRAG_EXITED");
		});
		
				//  DRAG_ENTERED_TARGET � DRAG_EXITED_TARGET
		
				/* �������������� ������ ������� ����
		������ ����������� ����� ��������� ��� ��������������� ������ �, ���� ��� ����������, ������� ����� acceptTransferModes() 
		����� ������ ������� � ������� � �������� ��������� �������������� ������ ��������� ������  - �������������
		����������� ����������� ��� �����������
		���������� ���������� ��������� ��� ����������� ���� � ������� ������� 			 */
			// �� Node       �� Scene � Node  �� �� ����� ������� � ������� ������ setOnDragOver(EventHandler event)
		lbl2.addEventHandler(DragEvent.DRAG_OVER, event2 -> {
			Dragboard db = event2.getDragboard();
			if (db.hasString()) event2.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			if (i ==0) {
				System.out.println("������ ��������������");
				i = 2;
			}
			event2.consume();
		});
		
				/* ���������� ������ ���� ��� �������������� (������� ������)
		������� ����� ��������������, ����� ������������ �������� ������� ����.
		������ ����������� ����� ������� ����� ��������� ��������� ������ ������: ��������� ��� ������ � �������� ��� ������.
		����� ��������� ������ ���������� �������� ��������� �������� ������, ������ ����� setDropCompleted, ����� ������ �������
		��������� ������ ����� �������� ������ ����������� DragEvent.DRAG_DONE			 */
			// �� Node       �� Scene � Node  �� �� ����� ������� � ������� ������ setOnDragDropped(EventHandler event)
		lbl2.addEventHandler(DragEvent.DRAG_DROPPED, event -> {
			Dragboard db = event.getDragboard();
			boolean success = false;
			System.out.println("��������� ����� " + db.getString());
			if (db.hasString()) {
				lbl2.setText(db.getString());
				success = true;
			}
			event.setDropCompleted(success);
			event.consume();
		});
		
				/* ��������� ��������������
		������ ����������� ����� ������� ����� ��������� ��������� ������ ������: ��������� ��� ������ � �������� ��� ������.
		����� ��������� ������ ���������� �������� ��������� �������� ������, ������ ����� setDropCompleted, ����� ������ �������				 */
			// �� Node       �� Scene � Node  �� �� ����� ������� � ������� ������ setOnDragDone(EventHandler event)
		lbl2.addEventHandler(DragEvent.DRAG_DONE, event -> {
			if (event.isAccepted()) {
				System.out.println("����� �������� ������. ����� " + event.getTransferMode());
			}
			else System.out.println("����� �� ��������");
		});
		
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
