package dad.inventario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Controller implements Initializable{
//	private StringProperty seleccion=new SimpleStringProperty();
	private ListProperty<String> disponiblesProperty =new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<String> seleccionadoProperty =new SimpleListProperty<>(FXCollections.observableArrayList());
		@FXML
	    private GridPane root;

	    @FXML
	    private ListView<String> listDisponible;

	    @FXML
	    private ListView<String> listSeleccionado;

	    @FXML
	    private VBox buttonsBox;

	    @FXML
	    private Button allLeft;

	    @FXML
	    private Button moveLeft;

	    @FXML
	    private Button moveRight;

	    @FXML
	    private Button allRight;

		public Controller() throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
			loader.setController(this);
			loader.load();
			}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		listDisponible.itemsProperty().bind(disponiblesProperty);
		listSeleccionado.itemsProperty().bind(seleccionadoProperty);
//		seleccion.bind(listDisponible.getSelectionModel().selectedItemProperty());
//		seleccion.bind(listSeleccionado.getSelectionModel().selectedItemProperty());
		disponiblesProperty.addAll("Pistola", "Machete", "Medicina", "Balas");
		seleccionadoProperty.addAll("Chaqueta", "Botas", "Casco");
		
	}

		
		@FXML
	    void onAllLeftAction(ActionEvent event) {
			disponiblesProperty.addAll(seleccionadoProperty);
			seleccionadoProperty.removeAll(seleccionadoProperty);
	    }

	    @FXML
	    void onAllRightAction(ActionEvent event) {
	    	seleccionadoProperty.addAll(disponiblesProperty);
	    	disponiblesProperty.removeAll(seleccionadoProperty);
	    }

	    @FXML
	    void onMoveLeftAction(ActionEvent event) {
	    	disponiblesProperty.add(listSeleccionado.getSelectionModel().getSelectedItem().toString());
			seleccionadoProperty.remove(listSeleccionado.getSelectionModel().getSelectedItem().toString());
	    }

	    @FXML
	    void onMoveRightAction(ActionEvent event) {
	    	seleccionadoProperty.add(listDisponible.getSelectionModel().getSelectedItem().toString());
			disponiblesProperty.remove(listDisponible.getSelectionModel().getSelectedItem().toString());
	    }

		public GridPane getView() {
			
			return root;
		}

}
