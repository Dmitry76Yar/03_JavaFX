package t63_JavaFX_Swing_Interactions;
	
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.layout.*;

/* 		ВЗАИМОДЕЙСТВИЕ МЕЖДУ SWING И JAVAFX
  	VM arguments прописываем --add-modules=javafx.controls,javafx.swing
 	Run configurations - (x)-Arguments - VM arguments */
  	
public class Main extends Application {
	private JButton swingButton;
	
	@Override
    public void start(Stage stage) throws Exception {
		
/* -------------------------------------Класс SwingNode----------------------------------------------------
	 	позволяет использовать компоненты Swing внутри JavaFX приложения.
	 	Наследование Object - Node- SwingNode
	 	Конструктор класса один - SwingNode()
	 	Для добавления используется метод setContent(Jcomponent content) 	*/
			
		VBox root = new VBox(5.0);
		root.setAlignment(Pos.CENTER);
		
		SwingNode swingNode = new SwingNode();
		root.getChildren().add(swingNode);
		
		SwingUtilities.invokeLater(() -> {
			swingButton = new JButton("SwingButton");
			swingButton.addActionListener(event -> {
				System.out.println(" Нажата кнопка");
			});
			swingNode.setContent(swingButton);
		});
		
				
		
		
		
/* -------------------------------------Класс JFXPanel----------------------------------------------------
	 	позволяет использовать компоненты JavaFX внутри Swingприложения.
	 	Наследование Object - java.awt.Component- java.awt.Container - java.swing.JC - JFXPanel
	 	Конструктор класса один - JFXPanel()
	 	Для добавления компонентов используется метод setScene (Scene newScene) 	*/
		
		
		
		Scene scene = new Scene(root, 400, 200);
		stage.setTitle("SWING");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
}

    
}