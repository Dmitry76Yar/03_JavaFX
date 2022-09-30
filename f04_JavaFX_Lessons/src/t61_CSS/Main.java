package t61_CSS;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.*;

public class Main extends Application {
		@Override 
	public void start(Stage primaryStage) {
		Label label = new Label("TEXT");
		
			// ����������� ����� setStyle()
//		label.setStyle("-fx-text-fill: #ff0000;");
//		label.setStyle("-fx-text-fill: #ff0000; fx-font-size: 16 pt;");
		
				// ������� ����� ����� ������� � ��������� ���� � ����������� css //
			// ����� ���������� ���� ����� ��� ����� ���������� ��������� ����������� ����� setUserAgentStylesheet()
		System.out.println(" �� ��������� ����� ���������� - " + Application.getUserAgentStylesheet());
//		Application.setUserAgentStylesheet("/t61_CSS/application.css");
		System.out.println(" ������� ����� ���������� - " + Application.getUserAgentStylesheet());
		
			/* ����� ������� ���� �� �������� ������ Alplication 
		- STYLESHEET_CASPIAN
		- STYLESHEET_MODENA		- ���� ����� �� ���������			 */
//		Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
		System.out.println(" ������� ����� ���������� - " + Application.getUserAgentStylesheet());
		
			/* ��������� �������� ����� � CSS ����� ��� ������ ���������
		- Label {fx-text-fill: #133233;}			- ��� ����� ������ Label
		- .my_label {fx-text-fill: #133233;}		- ��� ���� �����, ������� �������� �������� ����� my_label
		- Label.my_label {fx-text-fill: #133233;}	- ��� ���� ����� ������ Label, ������� �������� �������� ����� my_label
	    - #labelId {fx-text-fill: #133233;}			- ��� ������������ ���� � Id = labelId
	    - Label, Button {fx-text-fill: #133233;}	- ��� ����� ������ Label � Button (������������ ����� ������� ������ ���-�� �������)
	    - HBox .Label {fx-text-fill: #133233;}		- ��� ���� ������ Label ������ ���� ����������� ������ Hbox
	    - #hboxId > .Label {fx-text-fill: #133233;} - ��� ���� ������ ������ ����������� ���������� � Id = hboxId
			 */
		
			/* ����� ���������� ���� ����� � ����� ������������� ������
		- ��������� � CSS ����� ����� ��� ����� ������ ���� ����� Label {}
		- �������� ����� � ���� ��� ����� ����, ��� ����� ���������� ����� �������� ������ 	 */
		Label label2 = new Label("LABEL 2");
		label2.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		
			/* ����� ��������� ����� ������ ��� ������������� ���� ����� ��������� ��� ���������� ID � 
		- ��������� ������ CSS ����� ������ ��� ����� ID ����� #My_Label{}
		- �������� ����� � ���� ��� ����� ����, ��� ����� ���������� ����� �������� ������ 	 */
		label.setId("My_Label");
		label.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		
			/* ���������� ��������� ������
		����� ������� � ����� CSS �������� �����, ������� ����� ����� ��������� � ������ ����
		 - ��������� � ����� ����� �������� �����, ��������  .labelStyleClass {} � 
		 - �������� ���� �������� ����� � ������������ ����		 */
		Label label3 = new Label("LABEL 3");
		label3.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		label3.getStyleClass().add("labelStyleClass");
		
			/* ��������� ���������� ������
		����������� ��� ���� ����� �������� ����� � ���������� ������:
		 - ��������� ��������� �����, �������� setFont() ����������� ����� � �������� ����
		 - � ������� ������ setStyle() ����������� ����� � �������� ����
		 - � ����� style_pane.css
		 - � ����� style_scene.css � ��������� ����� scene.getStyleSheets().add(getClass().getRecource(
		 											 "//t61_CSS/application.css").toExternalFrom());
		 - � ����� style_scene.css � ��������� ����� scene.setUserAgentStylesheet(getClass().getRecource(
		 											"//t61_CSS/application.css").toExternalFrom());
		  
		 ��������� ����� ��������� �� ������� � ��������: 
		 - ����� ����� � ��������� ����� scene.setUserAgentStylesheet(getClass().getRecource("//t61_CSS/application.css").toExternalFrom());
		 - ��������� ��������� �����, �������� setFont() ����� � �������� ����
		 - ����� ����� � ��������� ����� scene.getStyleSheets().add(getClass().getRecource("//t61_CSS/application.css").toExternalFrom());
		 - ����� �������� ���������� �� style_pane.css
		 - ����� ��� ������� ����, ����������� ����� setStyle()  - ����� ������������ ������� */
		
			// ������ ���������� ��� �������
//		label2.setStyle("-fx-label-padding: 10 px;");
		
						/* ����
		- ����� ��� ����� .label(-fx-background-color: red;)
		- ����� #RGB, ��� R - ������������ ��������, G - ������������ �������� � B - ������������ ������ 
			�������� �������� ����� ���������� 16-�������� ������� �� 0 �� F 
			��������, .label(-fx-background-color: #F00;)
		- ����� #RRGGBB, ��� RR - ������������ ��������, GG - ������������ �������� � BB - ������������ ������ 
			�������� �������� ����� ������������ 16-��������� ������� �� 00 �� FF 
			��������, .label(-fx-background-color: #FF0000;)
		- ����� rgb(R, G, B), ��� R - ������������ ��������, G - ������������ �������� � B - ������������ ������ 
			�������� �������� ����� ���������� 10-�������� ������� �� 0 �� 255
			��������, .label(-fx-background-color: rgb(255, 0, 0);)
		- ����� rgb(R%, G%, B%), ��� R - ������������ ��������, G - ������������ �������� � B - ������������ ������ � ���������
			��������, .label(-fx-background-color: rgb(100%, 0%, 0%);)
		- ����� rgba(R, G, B, A), ��� R - ������������ ��������, G - ������������ �������� � B - ������������ ������ 
			�������� �������� ����� ���������� 10-�������� ������� �� 0 �� 255
			A - ������ ������� ������������ ����� (�����-������) �� 0 �� 1 (��������� �����������)
			��������, .label(-fx-background-color: rgba(255, 0, 0, 0.5);)
		- ����� rgb(R%, G%, B%, A), ��� R - ������������ ��������, G - ������������ �������� � B - ������������ ������ � ���������
			A - ������ ������� ������������ ����� (�����-������) �� 0 �� 1 (��������� �����������)
			��������, .label(-fx-background-color: rgba(100%, 0%, 0%, 0.5);)
		- ����� #hsb(H,S,B), ��� H - ������� (�� 0 �� 359), S - ������������ � ��������� �� 0 �� 100%, B - ������� � ��������� �� 0 �� 100
			��������, .label(-fx-background-color: hsb(0, 100%, 50%);)
		- 	����� #hsba(H,S,B,A), ��� H - ������� (�� 0 �� 359), S - ������������ � ��������� �� 0 �� 100%, B - ������� � ��������� �� 0 �� 100
			A - ������ ������� ������������ ����� (�����-������) �� 0 �� 1 (��������� �����������)
			��������, .label(-fx-background-color: hsb(0, 100%, 50%, 0.5);)
		- � ������� ������� derive(<����>, <�������>%), 
				, ��� ������� ��������� ������� ����� � ��������� �� -100 �� +100 (����� �������)
			��������, .label(-fx-background-color: derive(red, 50%);)	 */
		
			/* :hover - ����, ��� ������� ��������� ��������� ���� ���������
			 � CSS ����� �����������  #VisitedButton:hover{-fx-background-color: linear-gradient(#2A5058, #61a2b1);}	 */
		Button btn = new Button("HOVER");
		btn.setStyle("-fx-font-size: 12px;");
		btn.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		btn.setId("VisitedButton");
		
			/* :armed - ������ ������ ��� ������� �� ��� ����
			� CSS ����� �����������  #FocusedButton:armed{-fx-background-color: linear-gradient(#2A5058, #61a2b1);}   */
		Button btn1 = new Button("ARMED");
		btn1.setStyle("-fx-font-size: 12px;");
		btn1.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		btn1.setId("FocusedButton");
		
			/* :cancel - ������ ������ (����������� setCancelButton(true)) ������ ���� �����
			� CSS ����� �����������  Button:cancel {-fx-background-color: green;} */
		Button btn2 = new Button("CANCEL");
		btn2.setStyle("-fx-font-size: 12px;");
		btn2.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		btn2.setCancelButton(true);
		
			/* :disabled - ������� ������ ���� �� ����, �������� �� �������
	 		� CSS ����� ����������� 			 */
		Button btn3 = new Button("DISABLED");
		btn3.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		btn3.setId("btn3Id");
		
			/* :visited - ����� �������� �� �����������, ��� ����������, ��� ����������
				� CSS ����� �����������  #HYPERL1:visited {-fx-text-fill: RED;} */
		Hyperlink hyperlink5 = new Hyperlink("https://yandex.ru/images/?from=tabbar");
		hyperlink5.setFont(new Font(17));
		hyperlink5.setWrapText(false);
		hyperlink5.setText("VISITED");
		hyperlink5.setId("HYPERL1");
		hyperlink5.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		
			/* :pressed - ������� ������ ���� �� ����, �������� �� �������
			 	� CSS ����� �����������  #HYPERL2:pressed {-fx-text-fill: YELLOW;} */
		Hyperlink hyperlink6 = new Hyperlink("https://yandex.ru/images/?from=tabbar");
		hyperlink6.setFont(new Font(17));
		hyperlink6.setWrapText(false);
		hyperlink6.setText("PRESSED");
		hyperlink6.setId("HYPERL2");
		hyperlink6.getStylesheets().add(getClass().getResource("/t61_CSS/application.css").toExternalForm());
		
				/* �������������� ������  */
		Label label4 = new Label("LABEL4");
			// ��� ������
		label4.setStyle("-fx-font-family: 'Arial'");
			/* � ���� ������ ��������� ����� ����� ������������� �� ���������� ������������, ������� ����� �������
		���� �� ���� ������� �������� �������: serif, sans-serif, cursive, fantasy, monospace  */
		label4.setStyle("-fx-font-family: fantasy;");
			/* ������ �������, ������������� �� ��������� � ������� �������, ����� ��������� ������ � �������
			 		��������� :
			 @font-face {
			 	font-family: <���, ��� �������� ����� ����� �������� � ������� ������>; 
			 	src: url("<URL-����� ����� �� �������>")
			  }		
			  		������:
			  @font-face {
			 	font-family: MyFont; 
			 	src: url("file:/C:/Windows/Fonts/Tahoma.ttf>")
			  }	
			  label4.setStyle("-fx-font-style: 16pt MyFont;");		  */
		
			// ����� ������   ���������, ���������� � ��������� �����
		label4.setStyle("-fx-font-style: normal;");
		label4.setStyle("-fx-font-style: italic;");		// ���������
		label4.setStyle("-fx-font-style: oblique;");	// ���������

			// �������� ������   
		label4.setStyle("-fx-font-weight: normal;");	// ����������
		label4.setStyle("-fx-font-weight: bold;");		// ������
		label4.setStyle("-fx-font-weight: lighter;");	// ����� ������, ��� � ������������� ��������
		label4.setStyle("-fx-font-weight: bolder;");	// ����� ������, ��� � ������������� ��������
			// ����� ����� ������ � �������� �� 100, 200, 300.... �� 900 (900 - ����� ������)
		label4.setStyle("-fx-font-weight: 900;");
			
			// ������ ������
		label4.setStyle("-fx-font-size: 20px;");
		label4.setStyle("-fx-font-size: 20pt;");
			// ����� ����� ������� ������, ��� ���� �� �������� xx-small, x-small, small, medium, latge, x-large, xx-large
		label4.setStyle("-fx-font-size: xx-large;");
			// ����� ����� ������� � ���������
		label4.setStyle("-fx-font-size: 150%;");
			// ����� ����� ������� ������ ��� ������
		label4.setStyle("-fx-font-size: smaller;");
		label4.setStyle("-fx-font-size: larger;");
			
			// ���� ������
		label4.setStyle("-fx-text-fill: red;");
		
			// ������������� �������� ���������� ������		style - weight - size - family
		label4.setStyle("-fx-font: italic bold 16pt 'Arial'");
		
		
		
			
//		label4.setStyle("-fx-font-size: 20px;");
//		label4.setStyle("-fx-underline: true;");			// ������������� ������
//		label4.setStyle("-fx-strikethrough: true;");		// ������������ ������
			
			// ������� � ������� ������ �� ����� ������1
		Label label5 = new Label("LABEL5");
			// ������� ����������, ��� ����� ������������, ���� ����� �� ���������� �� ����� ������ ��� ������ �������
		label5.setStyle("-fx-ellipsis-string: '>>>';");			
			
			/* ������� ������ ����� ������� ������, ���� �� �� ���������� 
		 		����� ������� ��������: 
		 	- ELLIPSIS 		  - ����� ����������� � ����� � ����������� �������� �������� ellipsisString (�������� �� ���������)
		 	- WORD_ELLIPSIS   - ���������� ELLIPSIS, �� ������� ����������� ����� �������, � �� � ����� �����
		 	- CENTER_ELLIPSIS - ����� ���������� ���������� � ����������� �������� �������� ellipsisString (�������� �� ���������)
		 	- CENTER_WORD_ELLIPSIS - ���������� CENTER_ELLIPSIS, �� ������� ����������� ����� �������, � �� � ����� �����
		 	- LEADING_ELLIPSIS - ����� ���������� � ������ � � ����������� �������� �������� ellipsisString (�������� �� ���������)
		 	- LEADING_WORD_ELLIPSIS - ���������� LEADING_ELLIPSIS, �� ������� ����������� ����� �������, � �� � ����� �����		
		 	- CLIP - ����� ������ ���������� � ����� */
		label5.setStyle("-fx-text-overrun: center-ellipsis");
		
			// ������� ���� �� ���������� �� ����� ������, �� �����������
		label5.setStyle("-fx-wrap-text: true;");				 
		
			/* �������������� ������������ ������
		- center - ������������ �� ������
		- left - ������������ �� ������ ����
		- right -������������ �� ��a���� ����
		- justify - ������������ �� ������ (�� ���� ��������)	 */
		label5.setStyle("-fx-text-alignment: center;");
		
				// �������������� ����� ������������ � �������
		/* ������� -fx-graphic ������ ��������-����� (URL) �����������, ������� ����� ������������
		����� � ������� ������� ��� ������ ���� */
		label5.setStyle("-fx-graphic: url(/img/icons.png);");
		
		/* ������� -fx-content-display ������ ��������� ����������� ������������ ������
		����� �������: left, right, center, top, bottom, text-only, graphic-only
		����� � ������� ������� ��� ������ ���� */
		label5.setStyle("-fx-graphic: url(/img/icons.png); -fx-content-display:left;");
		
		// ������� -fx-graphic-text-gap ������ ���������� ����� ������������ � �������
		label5.setStyle("-fx-graphic-text-gap: 20px;");
		
			/* ������������ ����������� � ������ ������ �������
		������� -fx-aligment ������ ������������ ������ � ����������� ������ ��������� ������� ����������
		���� ����� ��������� ������� ���, �� � ������� �� ����� �����
		����� ������� �������� 
			baseline-center, baseline-left, baseline-right
			bottom-center, bottom-left, bottom-tight
			center, center-left, center-tight
			top-center, top-left, top-tight	 				*/
		label5.setStyle("-fx-alignment: center;");
		
			/* ������ �� ������� ���������� �� ������ � �����������
		-fx-label-padding: <���� �������� �� ���� ������>
		-fx-label-padding: <top> <right> <bottom> <left>	 */
		label5.setStyle("-fx-label-padding: 20.0px;");
		
			/* ������� � ���������� �������
		������ ������� ��������� ��������� ��������:
		- fx-pref-width � fx-pref-height		- ���������������� ������� 
		- fx-min-width � fx-min-height			- ����������� �������
		- fx-max-width � fx-max-height			- ������������ �������	*/
		label5.setStyle("-fx-pref-width:400px; -fx-pref-height: 100px;" +
						"-fx-min-width:200px; 	-fx-min-height: 50px;" +
						"-fx-max-width:400px; 	-fx-max-height: 150px;");
		
		/* ���������� ������� - ��� ���������� ����� ����� � �������� �������.
		 -fx-label-padding: <���� �������� �� ���� ������>
		-fx-label-padding: <top> <right> <bottom> <left>	 */
		label5.setStyle("-fx-label-padding: 20.0px;");
		
			// ���
		label5.setStyle("-fx-background-color: green;");
		label5.setId("Label5");
		
			/* �����
		���������� � ����������, ����������� ����� Region ����� ����� ���� ��� ��������� �����.	
			// ����� �����
		� ������� �������� -fx-border-style ����� ������ ����� ����� �����
		-fx-border-style: <�����> [<�����>] [<���������>] [<����� ����������>] [<����� ���������>]
			��� 
				�������� "�����" ����� ��������� ��������
					- none - ����� �� ������������
					- solid - �������� �����
					- dotted - ���������� �����
					- dashed - ��������� �����
					- segments[<����� 1>,<����� 2>...<����� N> - ������ ������� ������ ������ ����� ������, �������� - ����� ��������  */
					label5.setStyle("-fx-font-size: 20px; -fx-border-style: solid;");
		/*		�������� "�����" ������ �������� ������ ���������� ������� � ������� phase<�����> 
		 � ���������� ����� ������ �������� ����� � ������� ���������� ����� */
					label5.setStyle("-fx-font-size: 30px; -fx-border-style: segments(16.0, 8.0) phase 2.0;");
		/*		�������� "���������" ������ ��������� ����� ������������ �������
		  			- centered - �� ������ �������
		  			- inside - ������ �������
		  			- outside - ������� ������� */
					label5.setStyle("-fx-font-size: 30px; -fx-border-style: dashed inside;");
		/* �������� "����� ����������> ������ ����� ��������� � ����� ���������� ���� ����� �����
		 		������ line-join <�����>
		 		, ��� � ����� ����� ������� 
		 			- miter<limit> - ������� ����
		 			- bevel - ��������� ����
		 			- round - ������������ ����	 */
					label5.setStyle("-fx-font-size: 30px; -fx-border-style: dashed line-join round;");
		/* �������� "����� ���������> ������ ����� ��������� ����� ��� ������
		 		������ line-cap <�����>
		 		, ��� � ����� ����� ������� 
		 			- square - ���������� ����� (������������ � ����� ����� ��� ������) 
		 			- butt - ����� ����� �� �����������
		 			- round - ������������ ����	(������������ � ����� ����� ��� ������) */
					label5.setStyle("-fx-font-size: 30px; -fx-border-style: solid line-cap butt;");
					
			// ������� �����
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px;");
			// ���� ����� �����
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-color: red;");
			
			/* ����� � ������������ ������
		������� ������ ���������� ��� ����� ����� ����� � ������� �������� -fx-border-radius
		 -fx-border-radius: <������> [/<������>]
		 -fx-border-radius: <top-left> <top-right> <bottom-right> <bottom-left> [/ <top-left> <top-right> <bottom-right> <bottom-left>]
		  ����� �������� / �������� ������ ���������� ��� �������������� �������� �����, � ����� ���� - ��� ������������ ��������
		  ���� ����� / �� ������� ��������, �� ������ ���������� ����� ���������� � ��� �����, � ��� ������			 */
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-radius: 5px;");
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-radius: 1px 2px 3px 4px;");
		
			/* ��������� ����� ������ � ��������
		-fx-border-insets: <�������� ��� ���� ������>
		-fx-border-insets: <top> <right> <bottom> <left>			 */
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-insets: 5px;");
		label5.setStyle("-fx-border-style: solid; -fx-border-width: 3px; -fx-border-insets: 1px 2px 3px 4px;");
		
				// ���
			// ���� ����
		label5.setStyle("-fx-font-size: 30px; -fx-background-color: green;");
		label5.setStyle("-fx-font-size: 30px; -fx-background-color: transparent;");		// ���������� ���
			/* ��������� ����� ����� � ��������
		-fx-background-insets: <�������� ��� ���� ������>
		-fx-background-insets: <top> <right> <bottom> <left>			 */
		label5.setStyle("-fx-font-size: 30px;  -fx-background-color: green; -fx-background-insets: 10px;");
		label5.setStyle("-fx-font-size: 30px;  -fx-background-color: green; -fx-background-insets: 10px 20px 30px 40px;");
			/* ���������� ����� ����
		 -fx-background-radius: <������> [/<������>]
		 -fx-background-radius: <top-left> <top-right> <bottom-right> <bottom-left> [/ <top-left> <top-right> <bottom-right> <bottom-left>]
		  ����� �������� / �������� ������ ���������� ��� �������������� �������� �����, � ����� ���� - ��� ������������ ��������
		  ���� ����� / �� ������� ��������, �� ������ ���������� ����� ���������� � ��� �����, � ��� ������			 */
		label5.setStyle("-fx-font-size: 30px;  -fx-background-color: green; -fx-background-radius: 25px;");
		label5.setStyle("-fx-font-size: 30px;  -fx-background-color: green; -fx-background-radius: 5px 10px 15px 20px;");
		
			/* ������� �������
		� ������� -fx-background-image:  ����� ���������� ������� �������
		� ������� -fx-background-repeat: ����� ������ ����� ������� �������� �������
		 - repeat - ������� ����������� � �� ���������, � �� �����������
		 - repeat-� - ������� ����������� �� �����������
		 - repeat-y - ������� ����������� �� ���������
		 - no-repeat - ������� �� �����������
		 - space - ��������� ����������� ��� ������� � ��������������, ��� ���� ��������� ���������� ����� ������
		 		   ������������� ����� �������������
		 - round - ��������� ����������� ����� �������, ����� ����������� ����� ����� ����������� ��� ������� 
		 		   ������������ ����� ����, ��� ���� ����������� ������������� 			 */
		label5.setStyle("-fx-font-size: 30px; -fx-background-image: url(/img/icons.png);");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: repeat");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: repeat-x");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: repeat-y");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: space");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: round");
			/* ��������� �������� �������
		������� -fx-background-position ������ ��������� ��������� �������� �������, ���������� ����� ������
		����� ����� ������� ��������� ��������
		 - left - ������������ �� ������ ����
		 - right - �� ������� ����
		 - center - �� ������
		 - top - �� �����
		 - bottom - �� ����	 */
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat;"
				+ "-fx-background-position: 50% 50%;");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat;"
				+ "-fx-background-position: left center;");
			/* ������� �������� �������
		������� -fx-background-size ������ ������� �������� ������� � ���� ���� ��������, ����������� ��������: ������ ��������
		������ ������ �������, ������ - ������
		����� ����� ������� ��������� ��������
		 - auto - �� �������� ������� �������
		 - cover - ����� ������� �������, ����� �� ��������� ������ ���. ��� ���� ��������� ������� ����� ����� �� ������� ����
		 - contain - ����� ������� �������, ����� �� ��������� ��������� ������ ����, ������� ��� �������
		  		     ��� ���� �����-�� ����� ���� ����� ���� �� ������� ��������
		 - stretch - ����������� ������� ������� �� ������ � ������  */
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat;"
				+ "-fx-background-size: 100% 50%;");
		label5.setStyle("-fx-font-size: 40px; -fx-background-image: url(/img/icons.png); -fx-background-repeat: no-repeat;"
				+ "-fx-background-size: stretch;");
		
				// ������������� � �������
			// ��������� ������������
		Rectangle rect = new Rectangle(80,50,Color.RED); 
		rect.setStyle("-fx-opacity: 0.7;");
			/* �������� ���� 
		��������  ���� �� ��������� ��������� ��������� -fx-translate-x, -fx-translate-y, -fx-translate-z	 */
		rect.setStyle("-fx-translate-x: 100.0; -fx-translate-y: 10.0;");
			/* ��������������� ����
		�������� ������� ���� ����� � ������� -fx-scale-x, -fx-scale-y, -fx-scale-z	 
		������ ���������� ������ �������������� � 2 ���� ����*/
		rect.setStyle("-fx-scale-x: 2.0; -fx-scale-y: 1.0;");
			/* �������� ����
		��������� ���� �� ��������� ���� � �������� */
		rect.setStyle("-fx-rotate: 45.0;");
			/* ��������� ������ ���������
		������� -fx-blend-mode ��������� �������� ����� ���������			 */
		Rectangle rect2 = new Rectangle(50,50,Color.GREEN);
		Rectangle rect3 = new Rectangle(50,50,Color.BLACK);
		rect3.relocate(25, 25);
		rect3.setStyle("-fx-blend-mode: overlay;");
		Pane pane = new Pane();
		pane.getChildren().addAll(rect2, rect3);
			// ���������� ��������
		rect.setStyle("-fx-scale-x: 0.5; -fx-scale-y: 1.0;" +
					  "-fx-effect: innershadow(gaussian, black, 10.0, 0.0, -3.0, -3.0);");
		
			/* ��������� �������� ���� ����
		������� -fx-cursor ������ ����� ��������� ���� ��� ��������� �� ����
		����� ��������� ��������: default, hand, closed-hand, open-hand, wait, text.... ��� ��������-���� (URL) �������	 */
		rect.setStyle("-fx-scale-x: 0.5; -fx-scale-y: 1.0; -fx-cursor: hand;");
		
				// ��������� ������������� ������
			// ��� ������
		rect.setStyle("-fx-fill: red;");
		
			// ������� ������
			// - fx-stroke - ���� �������
		rect.setStyle("-fx-stroke: black;");
			//- fx-stroke-width - ������ (�������) �������
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px;");
			//- fx-stroke-type - ��������� ������� ������������ ������� ������
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px; fx-stroke-type: centered");	// �� ������ ������� 
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px; fx-stroke-type: inside");		// ������ ������
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px; fx-stroke-type: outside");		// ������� ������
			//- fx-stroke-dash-array - ������ �������� ��� ���������� �����. ������ ������� ������ ����� ������, �������� - ����� ��������
		rect.setStyle("-fx-stroke: black; -fx-stroke-width: 3px; -fx-stroke-dash-array: 10.0px, 5.0px;");
		
			/* ����������� ������
		��� ������ ��������� ����� (����, ����������� ��� �����) ������ ����� ������������ � ���� �������.
		��� ����������� ������������ ������� -fx-smooth	 */
		Circle circle = new Circle(30.0);
		circle.setStyle("-fx-stroke: red; -fx-stroke-width: 5px; -fx-smooth: true;");
		
			// ���������� ����� ��������������
		rect.setStyle("-fx-arc-width: 20px; -fx-arc-height: 20px;");
		
			/* ��������� ������������� ����� ���������
		��������� ��������� ��������:
		 - fx-orientation - ������ ���������� ���������� - horizontal ��� vertical
		 - fx-block-increment - ������ ��������, �� ������� ��������� �������� ��� ������ ���� �� ������
		 - fx-unit-increment - ������ ��������, �� ������� ��������� �������� ��� ������� ������ �� ���������, 
		 					   �������� �������� ����, ��� ������ ������� increment() � decrement()	
		����� ����� ������ ������������ ���������
		���� ��������� ��������� ���������� ��������� ������ ScrollBar
		.scroll-bar
			.increment-button			- ������ ���������� ��������
				.increment-arrow		- ������� �� ������ ���������� ��������
			.decrement-button
				.decrement-arrow
			.track					    - ������� ���� ��������
			.thumb	 					- �������� 
		������ ��������� ������� ������ ���������� �������� � ����� ������� �� ���
		.scroll-bar. decrement-button {
		 	-fx-pref-width: 20px; 
		 	-fx-pref-height: 20px;
		 }
		 .scroll-bar. decrement-button. decrement-arrow {
		 	-fx-background-color: red; 
		 }
		 ������ ��������� ����� ���� �������� �������������� ���������
		 .scroll-bar:horizontal .thumb {
		 	-fx-background-color: green;				*/
		ScrollBar scrollBar = new ScrollBar();
		scrollBar.setPrefSize(100, 100);
		scrollBar.setMin(0.0);
		scrollBar.setMax(100.0);
		scrollBar.setValue(0.0);
		scrollBar.setStyle("-fx-orientation: horizontal;" + 
						   "-fx-block-increment: 5.0;" + 
						   "-fx-unit-increment: 1.0;");
		
			/* ��������� ������������� ScrollPane
		-fx-hbar-policy - ������ ����� ����������� ��������. ���������: as needed, always, never
		-fx-vbar-policy - ������ ����� ����������� ��������. ���������: as needed, always, never
		-fx-pannable - ��� true ���������� ������� ����� ������������ � ������� ����
		-fx-fit-to-width - ��� true ���� ������ ������� ����� ������ ���� ������ ������������ � ���������� ������� �������,
		��� �������, ��� ���� ������������ ��������� �������
		-fx-fit-to-hieght - ��� true ���� ������ ������� ����� ������ ���� ������ ������������ � ���������� ������� �������,
		��� �������, ��� ���� ������������ ��������� ������� 
			���������
			.scroll-pane
				.scroll-bar:horizontal
				.scroll-bar:vertical
				.corner
			������ ��������� ������� ����� ���������
		.scroll-pane .scroll-bar:horizontal (-fx-pref-height: 20 px;}
		.scroll-pane .scroll-bar:vertical (-fx-pref-width: 20 px;}
			������ ��������� ����� ����
		.scroll-pane .viewpoint { -fx-background-color: black;}			 */
		
		HBox hbox = new HBox(label, label2, label3, btn, btn1, btn2, btn3, hyperlink5, hyperlink6);
		hbox.setSpacing(20);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));
		
		HBox hbox2 = new HBox(label4, label5, rect, pane, circle, scrollBar);
		hbox2.setSpacing(20);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setPadding(new Insets(10));
		
		VBox vbox = new VBox(hbox, hbox2);
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(vbox, 1000, 400);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("����� �����");
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}