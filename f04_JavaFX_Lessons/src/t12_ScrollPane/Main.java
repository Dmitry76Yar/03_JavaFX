package t12_ScrollPane;
	
import java.util.Set;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.*;

/* ScrollPane - ��������� ������� � �������� ���������
   ���� ���������� �� ���������� � ������� �������, �� ������������� ������������ ������ ���������.
   ��������� ��������� ��������� � ������� ���� ������������� �������� � ��������� ����������� �������
   ������ ���� - ��������� ����
   ������������: Object - Node - Parent - Region - Pane - ScrollPane		*/

public class Main extends Application {
	int iClickCount = 0;
	
	final ScrollPane scrollPane = new ScrollPane();
	final Image[] images = new Image[5];
	final ImageView[] pics = new ImageView[5];
	final VBox vb = new VBox();
	final Label fileName = new Label();
	final String [] imageNames = new String [] {"/img/3691-fonovyiy_risunok_windows_vista.jpg", "/img/icons.png"};
		 
		// ���� ��������� ���� � ������������ �������� �����
	@Override
	public void start(Stage stage) {
	    VBox box = new VBox();
	    Scene scene = new Scene(box, 350, 300);
	    stage.setScene(scene);
	    stage.setTitle("Scroll Pane");
	    box.getChildren().addAll(scrollPane, fileName);
	    VBox.setVgrow(scrollPane, Priority.ALWAYS);
	
	    fileName.setLayoutX(30);
	    fileName.setLayoutY(160);
		 
	    for (int i = 0; i < 2; i++) {
	    	 try {
	    		 images[i] = new Image(getClass().getResourceAsStream(imageNames[i]));
	 		} catch (Exception e) {
	 			System.out.println("�� ������� ��������� �����������");
	 		}
	         pics[i] = new ImageView(images[i]);
	         pics[i].setFitWidth(300);
	         pics[i].setPreserveRatio(true);
	         vb.getChildren().add(pics[i]);
	    }
	    	// ������ ������������ ������������ ��������� ������
	   scrollPane.setVmax(440);
	   		// ������ ������
	   scrollPane.setPrefSize(300, 400);
	   		// ������ ����, ������� ����� ������������ ������ �������
	   scrollPane.setContent(vb);
	   		// ������ ��������� ������ ���������
	   scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	   
	   
	   scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() {
	         public void changed(ObservableValue<? extends Number> ov,
	            Number old_val, Number new_val) {
	                 fileName.setText(imageNames[(new_val.intValue() - 1)/300]);
	            }
	         });
	  
	  stage.show();
	  
	   	// ��� ��������� ����� ��������� (��������, �������)  - ��� ����. �����, ����� ��� ��� ����� stage.show(); 
	  Set<Node> set = scrollPane.lookupAll(".scroll-bar");
	  for (Node node : set) {
		  if (node instanceof ScrollBar) {
			  ScrollBar sb = (ScrollBar)node;
			  if (sb.getOrientation() == Orientation.VERTICAL) {
				  sb.setPrefWidth(20);
			  }
			  else sb.setPrefHeight(20);
		  }
	  }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
