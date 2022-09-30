package t06_HBox_and_VBox_Pane;
	
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.*;

/* Panes - ��� ����������� ������, ����� ������� �������� ����������� Nodes �� �����. 
 * ������������: Object - Node - Parent - Region - Pane - HBox
 * ������ ��� Panes ����� ���� �������� ������������.    �������� ������:
    - HBox: ����������� Nodes ������������� ����� ���� � ������ - �� ���� � ������ 
    - VBox: ����������� Nodes ����������� ����� ���� � ������ - �� ���� � �������
    - FlowPane: ����������� Nodes ����� ���� � ������ �� ��� ��� ���� �� ���������� �����, ����� it wraps to continue layout nodes. 
                ����� ������������������ FlowPane ��� ��������������� � ������������� ������������ Nodes 
    - Border: ��������� pane �� 5 ��������: Top, Left, Center, Right, and Bottom.  ��� ���������� node ����� ������� �������
    - GridPane: ��������� pane �� �����, ������������ �������������� ������������ ��������� �� ������� � �������� 
    
    ����� ������������� panes ��� �������� ����� ������� pane. ��������, ����� ������� pane c �������������� ������� ����� � ������������ 
    �������� ������ ������, ����� ������� Border Pane  � ������� HBox � ������ ������� � VBox � ������ �������. 
    ��� ��������, �.�. ��� Pane ��������� javafx.scene.layout.Pane, ������� � ���� ������� ��������� ����� javafx.scene.Node. 
    �� ���� ��� Pane ����� �������� Nodes.   */

public class Main extends Application {
	int iClickCount = 0;
	
		@Override 
	public void start(Stage primaryStage) {	
							// ������� ���� ��� HBOX    ��� VBOX ��� ������ ����������
			/* �����������
			HBox() - ������� ������ HBox
			HBox(double spacing) - ������� ������ HBox � ��������� ���������� ����� ����������
			HBox(Node... children) - ������� HBox � ���������� � ���������� child nodes (� ����� ����������, ����� �������)
			HBox(double spacing, Node... children) - - ������� HBox � ���������� � ���������� child nodes � ��������� ���������� ����� ���������� 			 */
		Button btn1 = new Button("Button One");
		Button btn2 = new Button("Button Two");
		Button btn3 = new Button("Button Three");
		
			// ���������� nodes ����� �����������
		HBox hbox = new HBox(10.0, btn1, btn2, btn3);
			
			// ���������� ��������� ������
		Separator separator2 = new Separator(Orientation.VERTICAL);
		
			// ���������� nodes ����� ����� getChildren().addAll
		/* ����� ObservableList<Node> getChildren() - ���������� ��������� ���� Nodes, ������� ����� ���� ��������� � HBOX
		 ��������� ���������� ������ ������ ObservableList, ������� ��������� �������� ���� ��� ������ Nodes ��� � ���� ������ */
//		hbox.getChildren().addAll(btn1, btn2, btn3);
		
			/* ���������� ����� ������������ �� ���������
	    ��� ������������� SceneBuilder �������� �������� �� ������� Layout � ������� Specific (������ Fill Height) */
		hbox.setFillHeight(true);
		
			/* ����������� ������� ����
		 hbox.setPrefWidth(100)				- ������������� ���������������� ������ ����
		 hbox.setPrefHeight(100)			- ������������� ���������������� ������ ����
		 hbox.setPrefSize(100,100)			- ������������� ���������������� ������ � ������ ����
		 hbox.setMinWidth(100)				- ������������� ����������� ������ ����
		 hbox.setMinHeight(100)				- ������������� ����������� ������ ����
		 hbox.setMinSize(100,100)			- ������������� ����������� ������ � ������ ����
		 hbox.setMaxWidth(100)				- ������������� ������������ ������ ����
		 hbox.setMaxHeight(100)				- ������������� ������������ ������ ����
		 hbox.setMaxSize(100,100)			- ������������� ������������ ������ � ������ ����
		   ����������� ������ get..() ������������ ��� ��������� ��������������� ���������� */
		
			/* ������� ��������� ����� NODES B PANE              ����� void setSpacing (double value)
		 1-�� ������� ����� ���������� HBox(double spacing, Node... children) 
		 2-�� ������� ����� 
				 ����� void setSpacing (double value) - ������� ��������� ����� nodes ������ HBox  
		��� ������������� Scene Builder ��������� ����� ������ �������� �� ������� Layout � ������� Internal (�������� Spacing) 	 */
		hbox.setSpacing(20);
		
			/* ������� ��������� ����� NODES � ������ PANE
		��� ������ ���� ������� ������ ��������� ����� nodes, �� ��������� �� ������, ������� � �������� ����� ����� ����� ����
		��� ������� ��������� �� ����� pane ����� ������������ 
		 	����� void setPadding (Insets value) 
		���� ����� ��������� � �������� �������� ������ ������ Insets, ������� �������� ������ ��������� �� ����� � ��������.
		������ Insets ����� ������� ����� ������������ ����:
		   - Insets(double value) - ������� Insets ������, ������� ���������� ���������� ���� ��� top, right, bottom, and left 
		   - Insets(double top, double right, double bottom, double left) - ������� Insets object � ��������� ������ ��� top, right, bottom, and left
		��� ������������� Scene Builder ������� �������� �� ������� Layout � ������� Internal (�������� Padding)
		  */
		hbox.setPadding(new Insets(20, 10, 20, 10));
		
			/*������� ��������� ����� NODES B PANE ����� �������� ����� (Margins) ����� 
			 ����� static void setMargin(Node child, Insets value) - ������ ����/���� ��� ��������� node.
		 � �������� ���������� ����� ��������� node, ��� �������� ����� ������ ����, � ������ ������ Insets, ������� 
		 �������� ������ ���������  � ��������. 
		 ������ Insets ����� ������� ����� ������������ ����:
		   - Insets(double value) - ������� Insets ������, ������� ���������� ���������� ���� ��� top, right, bottom, and left 
		   - Insets(double top, double right, double bottom, double left) - ������� Insets object � ��������� ������ ��� top, right, bottom, and left
		 ������ �������� ����������, ������� ���������� �������� ��� ��� ������ HBox, �� �� ��� ������� hbox, ����  HBox.setMargin() = hbox.setMargin()
		 �����, ��� ������ margins, spacing � padding ����� �������� ������. �������, ���� ������� margin = 5��� ��� ���� ������ ��� ������,
		 � �������� � pane � spacing = 10 ��� � � padding = 10 ���, �� ������ ����� ��������� ���� �� ����� �� ��������� 20 ��� � �� ���� �� 15 ���
		 ��� ������������� Scene Builder ������� �������� �� ������� Layout � ������� HBOX constraints (�������� Margin)   */
		HBox.setMargin(btn1, new Insets(40));
		HBox.setMargin(btn2, new Insets(10, 15, 20, 10));
		
			/*������� ��������� ����� NODES B PANE ����� �������� ������ NODE, ���� ������� ������ ������ ���������
		����� ����� �������������� ��� spacer node, ����� ��� ������������� ��������� ��� ��������� ������������ pane.
		��������, ����� ������� HBox � 3-�� �������� � �����, ����� ������ 2 ������ ���� � ������ ���� � ������ ������ ����� ������� ����
		� ���� ������ ����� ������� spacer node ����� 2-�� � 3-�� �������� ��� ���������� ����� ����������� ������������. 
		�����, ��� ��� ������������ ���� ���������� ��������� ����� ����� �������������, �� ������������ ������ ��� ��� ��������� ��������.
		����� ������� ������ �������� spacer node - ���������� Region class - ��� ������� ����� � ��� ������ Control, �� ������� 
		����������� Button � Label, � ��� ������ Pane, �� �������� ����������� ��� Pane. */
			// Create the spacer
		Region spacer = new Region();
		
			/* ��������� ������������   ����� setHgrow(Node child, Priority priority)
	    ���� �����, ����� ��� ������������ ����, �����-���� ���� ������� ��� �������, �� ����� ��������� ��� ���� ��������� � �������
	������ setHgrow() � ������������� ������������� ��������� ��� ����� ���� ������� node.setMaxWidth(Double.MAX_VAlUE)	
 		������ Priority enumeration:
	 - Priority.NEVER - ����������, ��� ������ node ������� �� ������ ���������������� ��� ���������� ����� ���������� ������������
	pane. ��� ��������� �� ���������, ������� nodes �� ���������� ��� ��������� ������� pane, ���������� ��.
	 - Priority.ALWAYS  -  ������  ������ ��������. ���� 2 � ����� ���� ����� ����� ���������, �� ��� ����� ������� �������
	 - Priority.SOMETIMES  - ������ ���� ��������, ������ ���� ��� ������ ����� � ����������� ALWAYS.
	����� �������� ���������, ������� ���������� �������� ��� ��� ������ HBox, �� �� ��� ������� hbox, ����  HBox.setMargin() = hbox.setMargin() 
	��� ������������� Scene Builder �������� �������� �� ������� Layout � ������� HBOX Constraints (������ Hgrow)
	*/
		HBox hbox2 = new HBox(10.0, btn1, btn2, spacer, btn3);
		HBox.setHgrow(spacer, Priority.ALWAYS);
			 
			/*  �������������� �� ����� � ������� ���������
		���� �� �� ���������� ����������, ���������� �������� ���������� (��������, Pane) ����� ������� �������������� ���� �������, �����
		��� ��� ����� ����������� ���� �� ����� � ����� ������� ����
		button1.setLayoutX(111)			- ������ ���������� �� ��� � ������������ ������ �������� ���� ����������
		button1.setLayoutY(111)			- ������ ���������� �� ��� Y ������������ ������ �������� ���� ����������
		button1.relocate(111,111)		- ������ ���������� �� ��� � � �� ��� Y ������������ ������ �������� ���� ���������� 
		� SceneBulider ���������� �������� �� ������� Layout � ������� Position (���� Layout X, Layout Y)
		����������� ������ get() ���������� �������� ����������
		button1.layoutXProperty() 		- ������ �� ��������, ������������ ���������� �� ��� �
		button1.layoutYProperty() 		- ������ �� ��������, ������������ ���������� �� ��� Y
			������������ ����������� 
		button1.layoutXProperty().addListener((obj, oldValue, newValue) -> {
			System.out.println("��������� �" + newValue);
		});		*/
		
			/* �������� �� ����������� (������ ��� ��������)
		�����, ��� ��� �������� �������� ���������� ����������� � ��� �������� button1.setLayoutX(0) ���������� ����� � �������� ���������
		button1.setLayoutX(100) 		- ������� �� ��� � ������������ �������� ����� �� ��� �
		button1.setLayoutY(100) 		- ������� �� ��� Y ������������ �������� ����� �� ��� �
		button1.getLayoutX() 			- ���������� �������� �� ��� � ������������ �������� ����� �� ��� �
		button1.getLayoutY() 			- ���������� �������� �� ��� Y ������������ �������� ����� �� ��� �
		� SceneBulider �������� �������� �� ������� Layout � ������� Transform (���� Translate X, Translate Y) */
		
			/* �������������� �� ����� � ������� �����������
			 ����� static void setAlignment(Pos alignment) - ������������� ��� �������� ������ HBox.
		����� ��������� ���� ��������, ������� ��-�� ���������� � Pos enumeration (���������� � javafx.geometry package)
		��� ������������� Scene Builder �������� �������� �� ������� Properties � ������� Node (�������� Aligment)
			Pos enumeration:
		Pos.TOP_LEFT 		Vertical Alignment	Top 		Horizontal Alignment Left
		Pos.TOP_CENTER 		Vertical Alignment Top 			Horizontal Alignment Center
		Pos.TOP_RIGHT 		Vertical Alignment Top 			Horizontal Alignment Right
		Pos.CENTER_LEFT 	Vertical Alignment Center 		Horizontal Alignment Left
		Pos.CENTER 			Vertical Alignment Center 		Horizontal Alignment Center
		Pos.CENTER_RIGHT 	Vertical Alignment Center 		Horizontal Alignment Right
		Pos.BOTTOM_LEFT 	Vertical Alignment Bottom 		Horizontal Alignment Left
		Pos.BOTTOM_CENTER 	Vertical Alignment Bottom 		Horizontal Alignment Center
		Pos.BOTTOM_RIGHT 	Vertical Alignment Bottom 		Horizontal Alignment Right
		Pos.BASELINE_LEFT 	Vertical Alignment Baseline		Horizontal Alignment Left
		Pos.BASELINE_CENTER Vertical Alignment Baseline 	Horizontal Alignment Center
		Pos.BASELINE_RIGHT  Vertical Alignment Baseline 	Horizontal Alignment Right
				������ ���� ���������� �������� ������������� ������� � 3-�� ��������, ����������������� � pane:  */
		VBox vbox = new VBox(10, btn1, btn2, btn3);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER); 
		
			/* �������� NODES ���������� ������
		��� ����� ����� ������� ����� ������� ��� ������ ������ ������������� ������� ����� Double.MAX_VALUE.
		� ���� ������ ��� ������ ������ ������ ��� ������ pane  */
		Button btn4 = new Button("Number One");
		Button btn5 = new Button("Two");
		Button btn6 = new Button("The Third Button");
		btn4.setMaxWidth(Double.MAX_VALUE);
		btn5.setMaxWidth(Double.MAX_VALUE);
		btn6.setMaxWidth(Double.MAX_VALUE);
		
		VBox vbox2 = new VBox(10, btn4, btn5, btn6); vbox2.setMinWidth(200);    vbox2.setMinHeight(200); 	vbox2.setPadding(new Insets(10));	vbox2.setAlignment(Pos.CENTER);
		Label lbl = new Label("LABEL");	lbl.setMinWidth(80);    lbl.setMinHeight(80);
		VBox vbox3 = new VBox(10, lbl); vbox3.setMinWidth(200);    vbox3.setMinHeight(200); 	vbox3.setPadding(new Insets(10));	vbox3.setAlignment(Pos.CENTER);
		VBox vbox4 = new VBox(10, lbl); vbox4.setMinWidth(200);    vbox4.setMinHeight(200); 	vbox4.setPadding(new Insets(10));	vbox4.setAlignment(Pos.CENTER);
		VBox vbox5 = new VBox(10, lbl); vbox5.setMinWidth(200);    vbox5.setMinHeight(200); 	vbox5.setPadding(new Insets(10));	vbox5.setAlignment(Pos.CENTER);
		VBox vbox6 = new VBox(10, lbl); vbox6.setMinWidth(200);    vbox6.setMinHeight(200); 	vbox6.setPadding(new Insets(10));	vbox6.setAlignment(Pos.CENTER);
		HBox root = new HBox(10, vbox2, separator2, vbox4, vbox5, vbox6);	root.setMinWidth(900);    root.setMinHeight(400); root.setPadding(new Insets(10));
		
			/* ��������� ����� ���� ����������� � �����������
        ����� ����� ��� ������� � ������� ����� -fx-background-color � ������  setStyle() 	 */
		vbox2.setStyle("-fx-background-color: green");
		
			/* ��������� ����� ���� ����������� � �����������
		����� ����� � ������� setBackground() - ������ ��� ����� �������� ������ Background
		������������ ������ Background:
		 - Background(BackgroundFill...fills)		 - ������ ���� ������� (��� ��������). ����� ������� ��������� ������ ����� �������, ��� 
		 			���� ������������ ����� ����� ������������� �� ����������.		 			
		 - Background(BackgroundImage...images)
		 - Background(BackgroundFill[] fills, BackgroundImage...images)
		 - Background(List <BackgroundFill> fills, List<BackgroundImage> images)  */
		vbox3.setBackground(new Background(
			new BackgroundFill(Color.RED, null, null), 
			new BackgroundFill(Color.YELLOW, null, new Insets(20)),								// Insets(20) -���� 				
			new BackgroundFill(Color.ANTIQUEWHITE, new CornerRadii(10), new Insets(40))			// CornerRadii(10) - ���������� �����
		));
			/* ���������� ����� ����
		������ ���������� �������� � ������� ������ CornerRadii
		������������ ������ CornerRadii:
		 - CornerRadii(double radius)						- ������ ������ ���������� ���������� ��� ���� ���� 			
		 - CornerRadii(double radius, boolean asPercent)	- 
		 - CornerRadii(double topLeft, double topRight, double bottomRight, double bottomLeft, boolean asPercent) -��� ���� �� �����������
		 ..... */
				
			/* ��������� �������� �������
		� ������� ������������ Background(BackgroundImage...images) 
		������ ������������ BackgroundImage: 
		BackgroundImage(Image im, BackgroundRepeat repeatX, BackgroundRepeat repeatY, BackgroundPosition position, BackgroundSize size)
		 , ��� repeatX � repeatY ������������� �������� ����������� �� ����������� � ���������
		 
		BackgroundPosition position ������ ��������� �������� ������� � ������� ������ BackgroundPosition, �������� ����������
		����������� - BackgroundPosition (Side horizontalSide, double horizontalPosition, boolean horizontalAsPercentage, 
										  Side verticalSide, double verticalPosition, boolean verticallAsPercentage)
		        - horizontalSide - ����� ���� ��� LEFT, ��� RIGHT
		        - verticalSide - ����� ���� ��� TOP, ��� BOTTOM
		        - horizontalPosition � verticalPosition - ������� ������� �� ��������� ���� ������
		        - horizontalAsPercentage � verticallAsPercentage - ��� true, ������� �������� � ����������
		     ������ BackgroundPosition ss = new BackgroundPosition(Side.LEFT, 20, false, Side.BOTTOM, 10, false)
		     ��� ���������� � ������ ����� ������ ������ BackgroundPosition.CENTER, �� ��������� - BackgroundPosition.DEFAULT
		     
	    BackgroundSize size ���������, ��� ������ �������� ������� �������� ����������� ��� ������������ ����
	    ����������� - BackgroundSize (double width, double height, boolean widthAsPercentage, boolean heightAsPercentage,
	    							  boolean contain, boolean cover)
	          - width, height - ������ � ������ ��������������
	          - widthAsPercentage � heightAsPercentage - ��� true ������ � ������ �������� � ���������
	          - contain - ��� true ��� �������������� ����������� ���������� ����������� ������, ����� ������ ��� ������ ��� ������
	                      (��� ������) �������
	          - cover - ��� true ��� �������������� ����������� ���������� ����������� ������, ����� ������ ��� ������ � ������
	    ������ �������� ������� ������, ����� ������ ������  BackgroundSize.DEFAULT 	*/
		try {
			Image im = new Image(getClass().getResourceAsStream("/img/3691-fonovyiy_risunok_windows_vista.jpg"));
			vbox4.setBackground(new Background(new BackgroundImage(im, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, 
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		} catch (Exception e) {
			System.out.println("�� ������� ��������� �������");
		}
		
			/* ��������� �������� ������� + �������� �����������
		� ������� ������������ Background(BackgroundFill[] fills, BackgroundImage...images) 
		������� ��������� �������� �����, � ����� ������ ������ ������� �����������*/
		try {
			Image im1= new Image(getClass().getResourceAsStream("/img/icons.png"));
			List<BackgroundFill> listFill = new ArrayList<BackgroundFill>();
			listFill.add(new BackgroundFill(Color.RED, null, null));
			listFill.add(new BackgroundFill(Color.GREEN, new CornerRadii(10), new Insets(10)));
			List<BackgroundImage> listImage = new ArrayList<BackgroundImage>();
			listImage.add(new BackgroundImage(im1, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, 
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
			vbox5.setBackground(new Background(listFill,listImage));
		} catch (Exception e) {
			System.out.println("�� ������� ��������� �������");
		}
		
			/* ��������� �����
		���� ����� ����� ���� ��� ��������� �����.  ��� �� ���������� ������������ ������ ������ Region � ����� setBorder()
		������������ ������ Border:
		 - Border(BorderStroke...strokes)	- ������ �������� ���� (��� ��������) �����. ����� ������� ��������� �������� ����� �������,
		                        � ���� ������ ����� ����� ������������� ���� �� �����
		 - Border(BorderImage...images)      - ��������� ������������ ����������� ��� �����. ����� ������� ��������� �������� ����� �������,
		                        � ���� ������ ����� ����� ������������� ���� �� �����
		 - Border(BorderStroke[] strokes, BorderImage[] images) - � ��, � ��
		 - Border(List<BorderStroke> strokes, List<BorderImage> images)
		 
		 ������������ ������ BorderStroke:
		  - BorderStroke(Paint Stroke, BorderStrokeStyle style, CornerRadii radii, BorderWidths widths)
		  - BorderStroke(Paint Stroke, BorderStrokeStyle style, CornerRadii radii, BorderWidths widths, Insets insets)
		  - BorderStroke(Paint topStroke, Paint rightStroke, Paint bottomStroke, Paint leftStroke, BorderStrokeStyle topStyle,
		        BorderStrokeStyle rightStyle, BorderStrokeStyle bottomStyle, BorderStrokeStyle leftStyle, CornerRadii radii,
		        BorderWidths widths, Insets insets)
		  �������� style ������ �����, ����� ������� ������ ������ BorderStrokeStyle ��� ������� �� ���������: BorderStrokeStyle.NONE,
	    BorderStrokeStyle.SOLID, BorderStrokeStyle.DASHED, BorderStrokeStyle.DOTTED 
		  �������� widths ������ ������� ����� ������ ������ BorderWidths  */
		BorderStroke brs = new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3.0), new Insets(10));
		vbox6.setBorder(new Border(brs));
		
			/* ������������ 
	     � SceneBuilder ������� ������������ �������� �� ������� Properties � ������� Node (�������� Opacity) */
		vbox6.setOpacity(50);
		
			/* ��������� 
	     � SceneBuilder ������� ������������ �������� �� ������� Properties � ������� Node (�������� Opacity) 
	      - setVisible() - ������ ������ ��������� ��� false
	      - isVisible()  - true, ���� ���� �������
	     � SceneBuilder �������� ��������� ���� �������� �� ������� Properties � ������� Node (������ Visible) */
		vbox6.setVisible(true);
		
			/* ��������� ����������� ����
		 ������ ����� �������, ����� ��������� ��� ��� ���� ���� ������������. ��������, ��� ������� ������ ��������������� ������
		 �������� � ����� ���� �� ������� �������� �� ������ ����� ������� �� �����������.
		  - setDisable() - ��� true, ���� ������ �����������
		  - isDisable() - true, ���� ��� ���� ���������� ������ �������������. ���� ������� ����������� ���������, �� ��� ���� ������
		    ������������, ������ ������ ������������ ��� ����������� ���� ������� �� �����.  
		  - isDisabled() - true, ���� ���� ����������
		  � SceneBuilder �������� ����������� �������� �� ������� Properties � ������� Node (������ Disable)
		  			 */
		
//		Scene scene = new Scene(hbox, 500, 500);	 // ���������� ������ spacing � marging
//		Scene scene = new Scene(hbox2, 500, 500);    // ���������� ������ ������ space node ����� 2-�� � 3-�� ��������
//		Scene scene = new Scene(vbox, 200, 500);     // ���������� ������ setAlignment(Pos alignment)
		Scene scene = new Scene(root, 1200, 500, Color.BEIGE);     // ���������� �������� NODES ���������� ������
//		scene.getStylesheets.add("-fx-background-color: black");
//		
//		Override public void start(Stage stage) {
//	         Scene scene = new Scene(new Group());
//	         scene.getStylesheets().add("/com/example/javafx/app/mystyles.css");
//	         stage.setScene(scene);
//	         stage.show();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("HBOX");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
