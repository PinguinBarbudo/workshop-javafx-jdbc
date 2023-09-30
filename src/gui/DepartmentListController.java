package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable{
	
	//é importante que essa acoplamento seja fraco
	//com o objetivo de injetar dependências de outra forma
	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	@FXML
	private TableColumn<Department, String> tableColumnName;
	@FXML
	private Button btNew;
	
	/*
	 * Com o DepartmentService devidamente acoplado
	 * será necessário carregar os dados obtidos no tableView
	 */
	private ObservableList<Department> obsList;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("Button New pressed");
	}//end of onBtNewAction
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}//end of initialize

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		/*
		 * Nessa parte, pega-se a referência do stage que está na classe principal
		 * feito isso, usasse um downcasting para Stage pois getWindow pertence a super classe
		 * em seguida é atribuido o altura do stage a altura do componente
		 */
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}//end of initializeNodes
	
	/*
	 * Esse novo método acessa o serviço
	 * no caso o DepartmentService
	 * carrega as informações na variável obsList
	 * e em seguida carrega a tabela com os dados obtidos
	 */
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}//end of if
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
		
	}//end of updateTableView
	
}//end of class