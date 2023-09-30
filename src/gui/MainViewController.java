package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("Seller on menu");
	}//fim de onMenuItemSellerAction
	
	@FXML
	public void onMenuItemDepartmentAction() {
		//System.out.println("Department");
		loadView("/gui/DepartmentList.fxml");
	}//fim de onMenuItemDepartmentAction
	
	@FXML
	public void onMenuItemAboutAction() {
		//System.out.println("About");
		loadView("/gui/About.fxml");
	}//fim de onMenuItemAboutAction
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}//fim de initialize
	
	//função para abrir uma outra classe
	private synchronized void loadView(String absoluteName) {
		//para garantir que não ocorram comportamentos inesperados
		//use o synchronized antes do void
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVbox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVbox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVbox.getChildren());
			
		}catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
		
	}//fim de loadVies
}//fim da classe