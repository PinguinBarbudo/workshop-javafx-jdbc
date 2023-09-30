package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable{

	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	@FXML
	private TableColumn<Department, String> tableColumnName;
	@FXML
	private Button btNew;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("Button New pressed");
	}//end of onBtNewAction
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}//end of initialize

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		/*
		 * Nessa parte, pega-se a referência do stage que está na classe principal
		 * feito isso, usasse um downcasting para Stage pois getWindow pertence a super classe
		 * em seguida é atribuido o altura do stage a altura do componente
		 */
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}//end of initializeNodes

}//end of class