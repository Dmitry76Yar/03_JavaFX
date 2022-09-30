package t40_Image;
	
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Main extends Application  {
	Button btnAdd, btnSubtract, btnDivision, btnMultiply;
	Label lbl, lbl2;
	int i = 0;
	Image img1, img2, img3, img4, img5, img6, img7, img8;
	
	@Override 
public void start(Stage primaryStage) {	
		Label lbl = new Label("LABEL");
		
/*--------------------------------------------����� IMAGE---------------------------------------------------------------------------*/
					// ������������
		/* ����������� Image(InputStream is)
		��������� ����������� �� ��������� ������ InputStream. ��������� ������� BMP, GIF, JPEG, PNG  */
	try { 
		img1 = new Image(getClass().getResourceAsStream("/img/icons.png"));
		if (img1.isError()) new RuntimeException();		// ������� ������ ����� �������� � ������������ ��������
		}
	catch (Exception e) {
		System.out.println("�� ������� ��������� �����������");
		return; }
	
		/* ����������� Image(InputStream is, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
		��������� ����������� �� ��������� ������ InputStream. ��������� ������� BMP, GIF, JPEG, PNG  
		, ��� requestedWidth, requestedHeight - �������� ������� ��� ��������� ������ � ������,
			  preserveRatio - ��� true ��������� �������� � ����������� ����������� ������,
			  smooth - ��� true ��� ��������� �������� ����� �������������� �����������			*/
	try { 
		img2 = new Image(getClass().getResourceAsStream("/img/icons.png"), 600, 600, true, true);
		if (img1.isError()) new RuntimeException();				// ������� ������ ����� �������� � ������������ ��������
		}
	catch (Exception e) {
		System.out.println("�� ������� ��������� �����������");
		return; }
	
		/* ����������� Image(String url)
		   ����������� Image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
	��������� ����������� �� ����. ��� ����� ���� ���������� ��� ��������� ���� � ����� �� �����, ��� URL-����� � ��������� */
	try {
		img2 = new Image(getClass().getResource("/img/icons.png").toExternalForm());	
		if (img1.isError()) new RuntimeException();				// ������� ������ ����� �������� � ������������ ��������
		}
	catch (Exception e) {
		System.out.println("�� ������� ��������� �����������");
		return; }
	
		/* ����������� Image(String url, boolean backgroundLoading) 
		   ����������� Image(String url, boolean backgroundLoading, double requestedWidth, double requestedHeight, 
		 					boolean preserveRatio, boolean smooth)
		 			, ��� backgroundLoading: �������� ����������� �� ��������� ����� ����������� �����. ����� �������� 
		 				  ����������� � ������� ������, � �� � �������, ����� ��������� backgroundLoading - true
		 		*/
	
		/* ����� Cancel()
		 ���� �������� � ������� ������ ���������� �����, �� �� ����� ��������  */
	
		// ������ GET
	System.out.println("Width =  " + img2.getWidth());
	System.out.println("Height =  " + img2.getHeight());
	System.out.println("������� �������� ����������� �� 0 �� 1 - " + img2.getProgress());
	System.out.println("��������� ������ �������� " + img2.getException());
	
		// ������ �������� � ��������� ����������� �� ���������
	try {
		img3 = new Image("https://zastavok.net/main/priroda/163639027184.jpg", true);
		img3.progressProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("��������� �� " + newValue + " ���������");
			lbl.setText("��������� �� " + newValue + " ���������");
			if (img3.getProgress() == 1) {
				System.out.print("����������� ���������");
				if (!img3.isError()) {
					System.out.println(" ������");
					System.out.println("��������� ������ �������� " + img3.getException());
				}
				else System.out.println(" ��������");
			}
		});
	}
	catch (Exception e) {
		System.out.println("�� ������� ��������� �����������");
		return; }
	
/*---------------------------����� IMAGE VIEW - ����������� � ����----------------------------------------------------------------
 		������������ Object - Node - ImageView		
 																						*/
				// ������������
		// ����������� ImageView()
	ImageView imf = new ImageView();
	
		// ����������� ImageView(String URL)
	ImageView imf3 = new ImageView("/img/icons.png");		// (String URL)
	
		// ����������� ImageView(Image img)
	Image img7 = null;
	try {
		img7 = new Image(getClass().getResource("/img/icons.png").toExternalForm());	
		if (img7.isError()) new RuntimeException();				// ������� ������ ����� �������� � ������������ ��������
		}
	catch (Exception e) {
		System.out.println("�� ������� ��������� �����������");
		return; }
	ImageView imf1 = new ImageView(img7);	
	
		// ��������� ���� � ImageView
	imf.setImage(img7);
	
		// ����������� ������� ����������� (����������� ����� ��������, ����� ��������� � ��� �������)
	ImageView imf2 = new ImageView(img7);
	imf2.setFitWidth(70);			// ���������������� ������ ����������� (���� ������ ��� ����, �� �������� ������ �����������)
	imf2.setFitHeight(120);			// ���������������� ������ ����������� (���� ������ ��� ����, �� �������� ������ �����������)
	imf2.setPreserveRatio(true);	//  preserveRatio - ��� true ��������� �������� � ����������� ����������� ������,
	imf2.setSmooth(true);			// smooth - ��� true ��� ��������� �������� ����� �������������� �����������			
	imf.setCache(true);
	
		// ������� �����������
	imf2.setRotate(180);
	
		// �������� ���������� �� ����������� � ������ ImageView
	System.out.println("Width = " + imf2.getImage().getWidth());
	System.out.println("Height = " + imf2.getImage().getHeight());
	System.out.println("URL = " + imf2.getImage().getUrl());
	
		// ���������� ������ �������� ���� ���� ImageView
	imf2.getX();
	imf2.getY();
	
		// ����� ��������� �����������, ������� ����� ������������   ����� void setViewport (Rectangle2D value)
	ImageView imf4 = new ImageView(img3);
	ImageView imf5 = new ImageView(img3);
	imf4.setFitWidth(200);					imf5.setFitWidth(200);
	imf4.setFitHeight(200);					imf5.setFitHeight(200);
	imf4.setPreserveRatio(true);			imf5.setPreserveRatio(true);
		// ����������� �������� ������� 300 ��� � ������� 200 ���
	imf4.setViewport(new Rectangle2D(200, 100, 300, 200));
	
/*------------------------------------PIXEL READER----��������� ���������� �� ��������� �������---------------------------*/
		// ��������� ������� PixelReader     ���� ����������� �� ���� ���������, �� ����� null 
	PixelReader pxl = img2.getPixelReader();
	
		// ���������� � ������� �����������
	PixelFormat pxf = pxl.getPixelFormat();
	System.out.println("��� ����������� " + pxf.getType());
	
		// ���������� � ����� �������, ������������� �� ��������� �����������
	Color color = pxl.getColor(10, 10);
	System.out.println(color.getRed() +  " " + color.getBlue() + " " + color.getGreen());
	
/*------------------------------------WRITEABLE IMAGE----�������� �����������-----------------------------------------------*/
		// ������������ Object - Image - WriteableImage         ����� ���������� � ImageView
		/* ������������
	 - WritableImage(int width, int height) 	- ������� ����������� ���������� ������� � ������� PixelFormat.BYTE_BGRA_PRE
	  											  � � ������ �������� 0x0000000000- ��������� ���������� �����������
	 - WritableImage(PixelReader reader, int width, int height) 				-��������� ������� ����������� �� ������ ����������� 
	 - WritableImage(PixelReader reader, int x, int y, int width, int height) 	-��������� ������� ����������� �� ������ ����������� 
		 									��� ���, ����������� ���������� � ������������� ������� � ����������� x � y */
		//�������� ������� �����������
	WritableImage wim = new WritableImage(50, 50);
		// ������� ����� ����������� ������������ ������
	PixelWriter  pw = wim.getPixelWriter();
	for (int x= 0, w = (int)wim.getWidth(); x<w; x++) {
		for (int y= 0, h = (int)wim.getHeight(); y<h; y++) {
			pw.setColor(x, y, color.CHOCOLATE);
		}
	}
		// ����������� ������������� ����������� ��������� � �� ������ �������� ������
	img8 = new Image(getClass().getResourceAsStream("/img/icons.png"), 60, 60, true, true);
	WritableImage wim2 = new WritableImage(img8.getPixelReader(), (int)img8.getWidth(), (int)img8.getHeight());
	
		// ����������� ��������� ������� ������������� ����������� � �� ������ �������� ������
	WritableImage wim3 = new WritableImage(img8.getPixelReader(), 0, 0, 60, 60);
		
	// ������� ���������� �������
	PixelWriter  pw1 = wim3.getPixelWriter();
	pw1.setColor(0, 0, Color.RED);				// ������� ������� � ������� �������� ������� ������
	pw1.setColor(0, 1, Color.RED);
	
	
/*-------------------------������ ����������� � ����   ����� SWINGFXUTILS------------------------------------------------------
   ����� Image �� ������������ ������������, ������� �������� ������ ����� ������ � ���� �� ���������.
   ��� ����� ������������ ����������� ������ ������ SwingFXUtils, ����������� ������������� Image � BufferedImage � �������  */
		// �������� ������������ �����������
	WritableImage wim4 = new WritableImage(50, 50);
		// ������� ����� ����������� ������������ ������
	PixelWriter  pw2 = wim4.getPixelWriter();
	for (int x= 0, w = (int)wim4.getWidth(); x<w; x++) {
		for (int y= 0, h = (int)wim4.getHeight(); y<h; y++) {
			pw2.setColor(x, y, color.CHOCOLATE);
		}
	}
		// �������������� � BufferedImage ������� WritableImage
//	BufferedImage bim = SwingFXUtils.fromFXImage(wim4, null);
		// �������������� � BufferedImage ������� Image
	Image img9 = new Image(getClass().getResourceAsStream("/img/icons.png"));
//	BufferedImage bim = SwingFXUtils.fromFXImage(img9, null);		// �� ��������
//	BufferedImage bim2 = SwingFXUtils.fromFXImage(img9, null);
//		// �������� ��������������
//	WritableImage wim5 = SwingFXUtils.toFXImage(bim2, null);
//	
//	
//	ImageView imf6 = new ImageView(wim5);
//	
	BorderPane pane = new BorderPane(imf2, lbl, imf4, imf5, imf3);
	Scene scene = new Scene(pane, 400, 400);
	primaryStage.setScene(scene); 
	primaryStage.setTitle("Add/Sub");
	primaryStage.show();
}
	public static void main(String[] args) {
		launch(args);
	}
}
