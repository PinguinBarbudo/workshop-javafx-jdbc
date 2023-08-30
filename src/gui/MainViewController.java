package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("Seller");
	}//fim de onMenuItemSellerAction
	
	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("Department");
	}//fim de onMenuItemDepartmentAction
	
	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("About");
	}//fim de onMenuItemAboutAction
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}//fim de initialize

}//fim da classe