package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//.equals() -> important when comparing the chars by str
		//.toCharArray() -> important to place the strings into char to compare to chars
		
		int counter = 0;
		String str = "hello";
		String chars = "hl";
		
		int totalChar = Integer.parseInt(str);
		str.toCharArray();
		chars.toCharArray();
				
		while(totalChar > 0) {
			if(str.equals(chars)) {
				System.out.println("Character " + str + " equals " + chars);
				counter++;
			}
			totalChar--;
		}
				
	System.out.println(counter + "Is how many characters appeared in " + str);
	}
}
