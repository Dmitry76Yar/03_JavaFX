package t64_Start_window_during_appLoading1;
	
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/* 		��������, ������������ ����� ������� ���������� � �� ��� ������ �� ������   (https://docs.oracle.com/javafx/2/deployment/deploy_user_experience.htm#BABFIECI)
 	- ���� �1: ������������� JavaFX Runtime � ��������� �������� ���������� ����������, ������� ������ ���� ���������.
 	- ���� �2: ��������� ������� ����������� ��� �� ����, ��� �� �� ���� �����, ���������� ������� ���������
 	- ���� �3: ���������� �����������, �� ����� ������������� �������� �������������� �������� ��� ��������� ��������������,
 	����� ���������� ����� ��������� �������������� 
 	- ���� �4: ���������� ������������  
 	
  			�������� ���������� ���� �������� ����� ����� PreLoader
	�� ����� ���� �2 �������� ���������� ����������� preloader application - ��� preloader �� ���������, ��� ���������������� �������������
	Preloader ���������:
	- �������� ������� �� ���� ��������, ��������, ������ ��������, ����� ������������ ����� �������� � �� �����, ��� 
	���������� �������. 
	- �������� ��������� ������������ � ���, ��� �� ������ ������� ������, ��������, ����� ���������� �� ���� �����������.
	
 		����� ����������� ����� Preloader � ������ ������ start() ������� ���� � ���������
 	������������ Object - Application - Preloader
 	����� ��������� �������������� ������� ��������, ������������� ������ ���� ������ Preloader
 	- publi� void handleProgressNotification (ProgressNotification info)  - ��� ����������� ��������� ��������
 	- public void handleStateChangeNotification(StateChangeNotification info)
 	- public void handleErrorNotification(ErrorNotification info)
 	- public void handleApplicationNotification(PreloaderNotification info)	
 		����� � ������� ������ public final void notifyPreloader(PreloaderNotification info) �� ������ Application ����� ���������� 
 	������ ������ handleApplicationNotification	o������ Preloader, ������� � �������� ��������.
 	
 	 
 	
 */

public class Main extends Application {
	@Override
    public void start(Stage stage) throws Exception {
		
		VBox root = new VBox(5.0, new Button("����� ����"));
		root.setAlignment(Pos.CENTER);
		Thread.sleep(5000);						// �������� ���������� ��������
		
		System.out.println(" ����� start �� Main ������� ");
		Scene scene = new Scene(root, 400, 200);
		stage.setTitle("��������� ������� ����������");
		stage.setScene(scene);
		stage.show();
		
//		this.notifyPreloader(new Preloader.StateChangeNotification(null));
		
	}
	
	public static void main(String[] args) {
			/* ����� �������� ���������� �� ���� � ���������, ����� ������� �������� � ��������� javafx.preloader � ��������� ���
	������ ��� ������, ������������ ����� Preloader. ����� �������� ������������ ������ launch() �� ������ Application ������ ��
	����� � �������� ����������� � ���������, ���������� � ��������� ������
	������� ������ launch
	 	- public stati� void launch(Class<? extends Application> appClass, String ....args)		 - ������ ��� ������
	 	- public stati� void launch(String ....args)		 - ����������� ������			 	 */	
	
	System.setProperty("javafx.preloader", "t64_Start_window_during_appLoading1.MyPreloader");
	Application.launch(Main.class, args);
}

    
}