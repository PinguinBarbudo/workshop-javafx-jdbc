package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;


public class Main extends Application {
	
	//criado um atributo para a cena é possível pegar a referência
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			//foi trocado de Parent para ScrollPane
			ScrollPane scrollPane = loader.load();
			
			//Serão acrescentados dois comandos para fazer o
			//ScrollPane ajustar à janela
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			mainScene = new Scene(scrollPane);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Sample JavaFX application");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//método para pegar a referência da cena
	public static Scene getMainScene() {
		return mainScene;
	}//Esse método apenas retorna cena
	
	public static void main(String[] args) {
		launch(args);
	}
}
