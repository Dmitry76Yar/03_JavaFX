package t63_JavaFX_Swing_Interactions;
	
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.layout.*;

/* 		�������������� ����� SWING � JAVAFX
  	VM arguments ����������� --add-modules=javafx.controls,javafx.swing
 	Run configurations - (x)-Arguments - VM arguments */
  	
public class Main extends Application {
	private JButton swingButton;
	
	@Override
    public void start(Stage stage) throws Exception {
		
/* -------------------------------------����� SwingNode----------------------------------------------------
	 	��������� ������������ ���������� Swing ������ JavaFX ����������.
	 	������������ Object - Node- SwingNode
	 	����������� ������ ���� - SwingNode()
	 	��� ���������� ������������ ����� setContent(Jcomponent content) 	*/
			
		VBox root = new VBox(5.0);
		root.setAlignment(Pos.CENTER);
		
		SwingNode swingNode = new SwingNode();
		root.getChildren().add(swingNode);
		
		SwingUtilities.invokeLater(() -> {
			swingButton = new JButton("SwingButton");
			swingButton.addActionListener(event -> {
				System.out.println(" ������ ������");
			});
			swingNode.setContent(swingButton);
		});
		
				
		
		
		
/* -------------------------------------����� JFXPanel----------------------------------------------------
	 	��������� ������������ ���������� JavaFX ������ Swing����������.
	 	������������ Object - java.awt.Component- java.awt.Container - java.swing.JC - JFXPanel
	 	����������� ������ ���� - JFXPanel()
	 	��� ���������� ����������� ������������ ����� setScene (Scene newScene) 	*/
		
		
		
		Scene scene = new Scene(root, 400, 200);
		stage.setTitle("SWING");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
}

    
}